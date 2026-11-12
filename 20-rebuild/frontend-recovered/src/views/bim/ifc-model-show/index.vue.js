import { computed, defineAsyncComponent, defineComponent, h, nextTick, onUnmounted, ref, shallowRef, watch } from 'vue';
import { ElButton, ElEmpty, ElIcon, ElInput, ElOption, ElPopover, ElSelect, ElSlider, ElTree, ElTreeV2, ElCheckbox } from 'element-plus';
import { ArrowDown, Close, House, Loading, Minus, Plus, Refresh, Search } from '@element-plus/icons-vue';
import { m as projectContext, q as MonomerSelect, X as getToken } from '../../../shared/runtime.js';
import { buildProgress, stages, selectionColor, statusAppearance } from './progress.js';
import { a as DrawingPreview } from '../../../modules/drawing-preview-fullscreen-dialog-60155503.js';
import { createIfcViewer } from './viewer.js';
import { modelBundleCache } from './model-cache.js';
import { componentTree, viewDirections, zoomFromSlider, zoomLimits, zoomToSlider } from './navigation.js';
import { createOrientationCube } from './orientation-cube.js';
import './viewer.css';

const WeldingPreview = defineAsyncComponent(() => import('../../../modules/bim-model-view-dbf77a11.js').then(module => module.w));

async function read(url, signal, type = 'result') {
  const response = await fetch(url, {
    signal,
    headers: { Authorization: getToken() || '' },
    cache: 'no-store',
  });
  if (!response.ok) throw new Error(response.status === 403 ? '当前账号无权查看此项目模型' : '请求失败，请刷新后重试');
  if (type === 'binary' && !response.headers.get('content-type')?.includes('application/json')) {
    return response.arrayBuffer();
  }
  const payload = await response.json();
  if (payload.code != null && Number(payload.code) !== 20000) {
    throw new Error(payload.message || '请求失败，请刷新后重试');
  }
  return type === 'index' ? payload : payload.data;
}

export default defineComponent({
  name: 'IfcModelShow',
  setup() {
    const { globalProjectId, globalProject, projectMap } = projectContext(['globalProjectId', 'globalProject', 'projectMap']);
    const monomer = ref();
    const areaId = ref();
    const areaOptions = ref([]);
    const modelIndex = shallowRef();
    const businessRows = shallowRef();
    const stage = ref('production');
    const areaLoading = ref(false);
    const loading = ref(false);
    const error = ref('');
    const progressError = ref('');
    const query = ref('');
    const focused = ref('');
    const selected = ref();
    const detailRows = shallowRef([]);
    const detailIndex = ref(0);
    const detailLoading = ref(false);
    const detailError = ref('');
    const detailRetry = ref(0);
    const detailTab = ref('info');
    const drawingVisible = ref(false);
    const weldingVisible = ref(false);
    const statusGuideVisible = ref(false);
    const stateFilter = ref(null);
    const searchMessage = ref('');
    const activeTab = ref('production');
    const panelVisible = ref(false);
    const treeQuery = ref('');
    const appliedTreeQuery = ref('');
    const treeViewport = ref();
    const treeHeight = ref(320);
    let treeObserver;
    watch(treeQuery, (value, previous, cleanup) => {
      const timer = setTimeout(() => { appliedTreeQuery.value = value.trim().toLowerCase(); }, value ? 120 : 0);
      cleanup(() => clearTimeout(timer));
    });
    watch(treeViewport, element => {
      treeObserver?.disconnect();
      if (!element) return;
      treeObserver = new ResizeObserver(entries => {
        const height = Math.floor(entries[0].contentRect.height);
        if (height > 0) treeHeight.value = height;
      });
      treeObserver.observe(element);
    }, {flush: 'post'});
    const hiddenParts = shallowRef(new Set());
    const projectMonomers = shallowRef([]);
    const projectTreeError = ref('');
    const viewMenu = ref(false);
    const zoom = ref(100);
    const monomerRef = ref();
    const cubeRef = ref();
    let pendingArea;
    const generation = ref(0);
    const canvasHost = ref();
    const base = computed(() => globalProjectId.value && monomer.value
      ? '/api/bim/ifc/' + globalProjectId.value + '/' + monomer.value : '');
    const area = computed(() => areaOptions.value.find(item => item.id === areaId.value));
    const detail = computed(() => detailRows.value[detailIndex.value]);
    const progress = computed(() => stages[stage.value] && modelIndex.value && businessRows.value
      ? buildProgress(modelIndex.value.assemblies, businessRows.value, stage.value) : null);
    const partsTree = computed(() => modelIndex.value ? componentTree(modelIndex.value) : []);
    const filteredTree = computed(() => {
      if (!appliedTreeQuery.value) return partsTree.value;
      const result = partsTree.value.filter(item => item.label.toLowerCase().includes(appliedTreeQuery.value));
      return result.length === partsTree.value.length ? partsTree.value : result;
    });
    const monomerName = computed(() => monomerRef.value?.getOption(monomer.value)?.name || '当前单体');
    const projectName = computed(() => {
      const project = projectMap.value?.[globalProjectId.value] || globalProject.value;
      return project ? [project.serialNumber, project.shortName || project.name].filter(Boolean).join(' ') : '当前项目';
    });
    const projectNodes = computed(() => [{
      key: 'project:' + globalProjectId.value, label: projectName.value, kind: 'project',
      children: projectMonomers.value.map(item => ({
        key: 'monomer:' + item.id, label: item.name, kind: 'monomer', monomerId: item.id,
        children: (String(item.id) === String(monomer.value) ? areaOptions.value : item.areaSimpleList || []).map(part => ({
          key: 'area:' + part.id, label: part.name, kind: 'area', monomerId: item.id, areaId: String(part.id),
        })),
      })),
    }]);
    const number = value => value == null ? '—' : Number(value).toLocaleString('zh-CN', { maximumFractionDigits: 4 });
    const tabs = [
      { id: 'project', label: '项目树', icon: 'project-tree' },
      { id: 'component', label: '构件树', icon: 'artifact-tree' },
      { id: 'production', label: '生产状态', icon: 'production' },
      { id: 'shipment', label: '发运状态', icon: 'shipment' },
      { id: 'installation', label: '安装状态', icon: 'installation' },
    ];
    let viewer;
    let orientationCube;
    let lastOrientation = [0, 0, 0, 1];
    watch(cubeRef, element => {
      orientationCube?.dispose();
      orientationCube = undefined;
      if (!element) return;
      try {
        orientationCube = createOrientationCube(element, direction => viewer?.setView(direction));
        orientationCube.update(lastOrientation);
      } catch {
        element.textContent = '请使用下方视角菜单';
      }
    }, { flush: 'post' });

    watch(globalProjectId, () => { monomer.value = undefined; pendingArea = undefined; }, { flush: 'sync' });
    watch([globalProjectId, generation], async ([id], previous, cleanup) => {
      const abort = new AbortController();
      cleanup(() => abort.abort());
      projectMonomers.value = [];
      projectTreeError.value = '';
      if (!id) return;
      try {
        const result = await read('/api/plan/monomer/listByProjectId/' + id, abort.signal);
        if (!abort.signal.aborted) projectMonomers.value = result.content || [];
      } catch {
        if (!abort.signal.aborted) projectTreeError.value = '项目树读取失败，可刷新重试';
      }
    }, { immediate: true });
    watch([base, generation], async ([path], previous, cleanup) => {
      const abort = new AbortController();
      cleanup(() => abort.abort());
      const previousArea = areaId.value;
      areaId.value = undefined;
      areaOptions.value = [];
      areaLoading.value = false;
      error.value = '';
      if (!path) return;
      areaLoading.value = true;
      try {
        const options = await read(path + '/areas', abort.signal);
        if (abort.signal.aborted) return;
        areaOptions.value = options;
        if (pendingArea && String(pendingArea.monomerId) === String(monomer.value)) {
          areaId.value = options.find(item => item.id === pendingArea.areaId)?.id;
          pendingArea = undefined;
        } else if (previous?.[0] === path && options.some(item => item.id === previousArea)) areaId.value = previousArea;
        else {
          const imported = options.filter(item => item.revision);
          if (imported.length === 1) areaId.value = imported[0].id;
        }
      } catch (failure) {
        if (!abort.signal.aborted) error.value = failure.message;
      } finally {
        if (!abort.signal.aborted) areaLoading.value = false;
      }
    });
    watch([base, area], async ([path, chosen], previous, cleanup) => {
      const abort = new AbortController();
      cleanup(() => abort.abort());
      viewer?.dispose();
      viewer = null;
      modelIndex.value = undefined;
      businessRows.value = undefined;
      progressError.value = '';
      loading.value = false;
      query.value = '';
      focused.value = '';
      selected.value = undefined;
      stateFilter.value = null;
      searchMessage.value = '';
      hiddenParts.value = new Set();
      treeQuery.value = '';
      if (activeTab.value !== 'project') panelVisible.value = false;
      error.value = '';
      if (!path || !chosen?.revision) return;
      loading.value = true;
      const url = path + '/' + chosen.id + '/' + chosen.revision;
      read(url + '/progress', abort.signal).then(rows => {
        if (!abort.signal.aborted) businessRows.value = rows;
      }).catch(() => {
        if (!abort.signal.aborted) progressError.value = '进度读取失败，可刷新重试';
      });
      try {
        const {index, geometry} = await modelBundleCache.load(url, getToken() || '', abort.signal);
        if (abort.signal.aborted) return;
        await nextTick();
        if (abort.signal.aborted || !canvasHost.value) return;
        const result = await createIfcViewer(canvasHost.value, geometry, index, abort.signal,
          value => { selected.value = activeTab.value === 'project' ? undefined : value; },
          (quaternion, direction, percent) => {
            lastOrientation = quaternion;
            zoom.value = Math.round(percent);
            orientationCube?.update(quaternion);
            if (!cubeRef.value) return;
            cubeRef.value.dataset.direction = direction.map(value => value.toFixed(4)).join(',');
          });
        if (abort.signal.aborted) {
          result?.dispose();
          return;
        }
        viewer = result;
        modelIndex.value = { ...index, looseElements: result.elementIds.filter(id => !index.parts[id]) };

      } catch (failure) {
        if (!abort.signal.aborted) error.value = failure.message || '模型无法打开，请检查模型文件';
      } finally {
        if (!abort.signal.aborted) loading.value = false;
      }
    });
    watch([stage, progress, focused, selected, stateFilter, modelIndex, hiddenParts], () => {
      viewer?.update(stage.value, progress.value, focused.value, selected.value, stateFilter.value, hiddenParts.value);
    });
    watch([() => selected.value?.mark, base, area, detailRetry, stage], async ([mark, path, chosen], previous, cleanup) => {
      const abort = new AbortController();
      cleanup(() => abort.abort());
      detailRows.value = [];
      detailIndex.value = 0;
      detailTab.value = 'info';
      detailError.value = '';
      detailLoading.value = false;
      drawingVisible.value = false;
      weldingVisible.value = false;
      statusGuideVisible.value = false;
      if (!mark || !chosen?.revision) return;
      detailLoading.value = true;
      try {
        const rows = await read(path + '/' + chosen.id + '/' + chosen.revision + '/components?mark='
          + encodeURIComponent(mark) + '&mode=' + (stages[stage.value] ? stage.value : 'component'), abort.signal);
        if (!abort.signal.aborted) detailRows.value = rows;
      } catch (failure) {
        if (!abort.signal.aborted) detailError.value = failure.message || '构件详情读取失败';
      } finally {
        if (!abort.signal.aborted) detailLoading.value = false;
      }
    });
    onUnmounted(() => { viewer?.dispose(); orientationCube?.dispose(); treeObserver?.disconnect(); });

    function locate(mark) {
      if (!mark || !viewer?.focus(mark)) {
        searchMessage.value = mark ? '未找到构件 ' + mark : '请输入构件编号';
        return;
      }
      hiddenParts.value = new Set();
      if (activeTab.value === 'project') activate('component');
      query.value = mark;
      focused.value = mark;
      const matches = modelIndex.value.assemblies.filter(item => item.mark === mark);
      if (matches.length === 1) viewer.focusAssembly(matches[0].id);
      else selected.value = { mark };
      stateFilter.value = null;
      searchMessage.value = '已定位 ' + mark;
    }
    function reset() {
      query.value = '';
      focused.value = '';
      selected.value = undefined;
      stateFilter.value = null;
      searchMessage.value = '';
      hiddenParts.value = new Set();
      viewer?.fit();
    }
    function activate(tab) {
      if (activeTab.value !== tab && stages[tab]) viewer?.fit();
      panelVisible.value = activeTab.value !== tab || !panelVisible.value;
      activeTab.value = tab;
      stage.value = stages[tab] ? tab : 'model';
      selected.value = undefined;
      stateFilter.value = null;
      focused.value = '';
      hiddenParts.value = new Set();
      searchMessage.value = '';
    }
    function selectState(value) {
      selected.value = undefined;
      focused.value = '';
      stateFilter.value = stateFilter.value === value ? null : value;
      panelVisible.value = true;
      activeTab.value = stage.value;
    }
    function selectProject(node) {
      if (node.kind === 'monomer') {
        if (String(monomer.value) !== String(node.monomerId)) monomer.value = node.monomerId;
        return;
      }
      if (node.kind === 'project') { reset(); return; }
      if (node.kind !== 'area') return;
      if (String(monomer.value) === String(node.monomerId)) {
        if (areaId.value === node.areaId) reset();
        else areaId.value = node.areaId;
      }
      else {
        pendingArea = node;
        monomer.value = node.monomerId;
      }
    }
    function toggleVisibility(node, visible) {
      const hidden = new Set(hiddenParts.value);
      for (const id of node.ids) {
        if (visible) hidden.delete(id);
        else hidden.add(id);
      }
      hiddenParts.value = hidden;
    }
    function selectPart(node) {
      stateFilter.value = null;
      focused.value = '';
      if (node.kind === 'mark') locate(node.mark);
      if (node.kind === 'assembly') viewer?.focusAssembly(node.assemblyId);
      if (node.kind === 'part') viewer?.focusElement(node.ids[0]);
    }
    function renderPart({ data }) {
      const hidden = data.ids.filter(id => hiddenParts.value.has(id)).length;
      return h('span', { class: 'ifc-part-node', title: data.label }, [
        h(ElCheckbox, {
          modelValue: hidden === 0, indeterminate: hidden > 0 && hidden < data.ids.length,
          'aria-label': '显示 ' + data.label, onClick: event => event.stopPropagation(),
          onChange: value => toggleVisibility(data, value),
        }),
        h('span', data.label),
      ]);
    }
    function statPanel(mode) {
      const current = progress.value;
      const filtered = current && stateFilter.value != null
        ? [...current.byMark].filter(([, item]) => stateFilter.value === 'mixed' ? item.state === 'mixed' : item.amounts[stateFilter.value] > 0)
        : [];
      return [
        current ? h('table', { class: 'ifc-statistics', 'aria-label': mode.title + '统计' }, [
          h('thead', [h('tr', [
            h('th', { colspan: 2 }, area.value?.name), ...mode.labels.map(label => h('th', label)),
          ])]),
          h('tbody', [
            h('tr', [
              h('th', '构件数量（件）'), h('td', number(current.totals.reduce((a, b) => a + b, 0))),
              ...current.totals.map((value, i) => h('td', [h('button', { onClick: () => selectState(i) }, number(value))])),
            ]),
            h('tr', [
              h('th', '构件重量（kg）'), h('td', number(current.weightTotals?.reduce((a, b) => a + b, 0))),
              ...mode.labels.map((_, i) => h('td', number(current.weightTotals?.[i]))),
            ]),
          ]),
        ]) : h('p', { role: progressError.value ? 'alert' : 'status' }, progressError.value || '正在读取进度…'),
        stateFilter.value != null ? h('table', { class: 'ifc-status-list', 'aria-label': '状态构件清单' }, [
          h('thead', [h('tr', [h('th', '构件编号'), h('th', '数量'), h('th', '重量（kg）')])]),
          h('tbody', filtered.map(([mark, item]) => h('tr', { key: mark }, [
            h('td', [h('button', { onClick: () => locate(mark) }, mark)]),
            h('td', number(stateFilter.value === 'mixed' ? item.quantity : item.amounts[stateFilter.value])),
            h('td', number(stateFilter.value === 'mixed' ? item.weights?.reduce((a, b) => a + b, 0) : item.weights?.[stateFilter.value])),
          ]))),
        ]) : null,
      ];
    }

    function detailPanel() {
      const part = selected.value;
      const record = detail.value?.artifact;
      const parts = record?.machinePartDTOList || [];
      const value = (data, unit = '') => data == null || data === '' ? '—' : (typeof data === 'number' ? number(data) : data) + unit;
      const row = (label, data) => h('tr', [h('th', label), h('td', data)]);
      const match = progress.value?.byMark.get(part.mark);
      const mode = stages[stage.value];
      const appearance = mode ? statusAppearance(stage.value, match)
        : {label: part.elementOnly ? '已选元件' : '已选构件', color: selectionColor};
      const componentMode = activeTab.value === 'component';
      return h('section', { key: 'component-detail', class: ['ifc-panel', 'ifc-component-detail', detailTab.value === 'parts' && 'ifc-component-parts'],
        'aria-label': detailTab.value === 'parts' ? '构件关联零件' : '构件详情' }, [
        h('div', { class: 'ifc-panel-heading' }, [
          h('span', detailTab.value === 'parts' ? '构件树 · ' + part.mark : '构件详情'),
          h('button', { type: 'button', 'aria-label': '关闭构件详情', onClick: () => { selected.value = undefined; } }, h(ElIcon, () => h(Close))),
        ]),
        h('div', { class: 'ifc-panel-content', 'aria-busy': detailLoading.value }, [
          h('div', { class: 'ifc-detail-topline' }, [
            h('p', { class: 'ifc-selection-note' }, [h('i', { style: { backgroundColor: '#' + selectionColor.toString(16) } }),
              (mode ? '玫红轮廓：选中' : '玫红色：选中') + (part.elementOnly ? '元件' : '构件')]),
            h(ElPopover, {
              trigger: 'click', role: 'dialog', placement: 'bottom-end', width: 320, popperClass: 'ifc-status-explanation',
              strategy: 'fixed', popperOptions: {modifiers: [
                {name: 'preventOverflow', options: {rootBoundary: 'viewport', padding: 12, altAxis: true, tether: false}},
                {name: 'flip', options: {rootBoundary: 'viewport', padding: 12}},
              ]},
              visible: statusGuideVisible.value, 'onUpdate:visible': value => { statusGuideVisible.value = value; },
            }, {
              reference: () => h('button', {
                type: 'button', class: 'ifc-detail-status',
                'aria-label': (mode?.title || '选中状态') + '：' + appearance.label + '，查看状态图例',
                'aria-expanded': statusGuideVisible.value,
                onKeydown: event => { if (event.key === 'Escape') statusGuideVisible.value = false; },
                style: {color: '#' + appearance.color.toString(16).padStart(6, '0')},
              }, [h('i', {'aria-hidden': true}), h('span', appearance.label)]),
              default: () => h('div', {
                onKeydown: event => { if (event.key === 'Escape') statusGuideVisible.value = false; },
              }, [
                h('div', {class: 'ifc-status-guide-heading'}, [
                  h('div', [h('strong', '状态图例'), h('p', '颜色与模型状态保持一致')]),
                  h('button', {type: 'button', 'aria-label': '关闭状态图例', onClick: () => { statusGuideVisible.value = false; }}, h(ElIcon, () => h(Close))),
                ]),
                ...Object.entries(stages).map(([key, item]) => h('section', {
                  class: ['ifc-status-group', key === stage.value && 'is-current-view'],
                }, [
                  h('h4', [item.title, key === stage.value ? h('small', '当前视图') : null]),
                  h('div', {class: 'ifc-status-values'}, item.labels.map((label, i) => h('span', {
                    class: ['ifc-status-value', key === stage.value && label === appearance.label && 'is-current'],
                    style: {'--status-color': '#' + item.colors[i].toString(16).padStart(6, '0')},
                  }, [h('i', {'aria-hidden': true}), label]))),
                ])),
                h('section', {class: 'ifc-status-special'}, [h('h4', '特殊情况'),
                  h('dl', [
                    ['部分完成', '同编号的多件构件处于不同状态。'],
                    ['数量待核对', '模型件数与清单件数不一致。'],
                    ['暂无进度', '尚未取得对应的业务进度。'],
                    ['已选构件 / 已选元件', '仅表示选中，不代表业务进度。'],
                  ].flatMap(([label, description]) => [h('dt', label), h('dd', description)])),
                ]),
              ]),
            }),
          ]),
          detailLoading.value ? h('p', { role: 'status' }, '正在读取构件详情…') : null,
          detailError.value ? h('p', { role: 'alert' }, [detailError.value,
            h('button', { class: 'ifc-detail-link', type: 'button', onClick: () => { detailRetry.value++; } }, '重试')]) : null,
          detailRows.value.length > 1 ? h(ElSelect, {
            modelValue: detailIndex.value, 'onUpdate:modelValue': index => {
              detailIndex.value = index; detailTab.value = 'info'; weldingVisible.value = false; drawingVisible.value = false;
            },
            'aria-label': '选择构件清单记录', size: 'small',
          }, () => detailRows.value.map((item, index) => h(ElOption, {
            value: index, label: (item.artifact.areaBatch?.name || '清单记录 ' + (index + 1)) + ' · ' + item.artifact.quantity + '件',
          }))) : null,
          !detailLoading.value && !detailError.value && !record ? h('p', { class: 'ifc-panel-note' },
            part.mark ? '当前区域清单未找到对应构件，暂无业务详情。' : '此元件未关联构件清单，暂无业务详情。') : null,
          detailTab.value === 'parts' ? [
            h('button', { class: 'ifc-detail-link', type: 'button', onClick: () => { detailTab.value = 'info'; } }, '返回构件详情'),
            parts.length ? h('table', { class: 'ifc-parts-table', 'aria-label': '关联零件清单' }, [
              h('thead', [h('tr', ['编号', '名称', '规格', '材质', '数量', '单重（kg）'].map(label => h('th', label)))]),
              h('tbody', parts.map(item => h('tr', { key: item.id }, [item.serialNumber, item.name, item.specification,
                item.material, item.quantity, item.grossWeight].map(data => h('td', value(data)))))),
            ]) : h('p', '暂无关联零件'),
          ] : [
            h('table', { class: 'ifc-detail-table', 'aria-label': '构件属性' }, [h('tbody', [
              row('名称', value(record?.name)),
              row('编号', value(record?.serialNumber || part.mark)),
              row('规格', value(record?.specification)),
              row('材质', value(record?.material)),
              row('重量（kg）', value(record?.grossWeight)),
              row('长度（mm）', value(record?.length)),
              row('清单数量（件）', value(record?.quantity)),
              row('单体', record?.monomer?.name || monomerName.value),
              row('单元', record?.area?.name || area.value?.name || '—'),
              row('批次', value(record?.areaBatch?.name)),
              activeTab.value !== 'production' ? row('表面积（㎡）', record?.surfaceArea == null ? '—' : number(record.surfaceArea / 1000000)) : null,
              componentMode ? row('图号', value(record?.drawingNumber)) : null,
              componentMode ? row('图纸', detailLoading.value ? '读取中…' : !record ? '—' : detail.value?.drawings?.length ? h('button', {
                class: 'ifc-detail-link', type: 'button', onClick: () => { drawingVisible.value = true; },
              }, '查看图纸') : '未上传') : null,
              componentMode ? row('构件树', record ? h('button', { class: 'ifc-detail-link', type: 'button',
                onClick: () => { detailTab.value = 'parts'; } }, '查看关联零件（' + parts.length + '）') : '—') : null,
              activeTab.value !== 'production' ? row('焊缝', record ? h('button', {
                class: 'ifc-detail-link', type: 'button', onClick: () => { weldingVisible.value = true; },
              }, number(detail.value.productWeldCount ?? 0) + '（查看详情）') : '—') : null,
              row('轴线位置', value(part.position)),
              part.elementOnly ? row('元件 GUID', value(part.id)) : null,
              record?.remark ? row('备注', record.remark) : null,
            ])]),
          ],
        ]),
      ]);
    }

    return () => {
      const mode = stages[stage.value];
      const noModel = !loading.value && !modelIndex.value && !error.value;
      return h('div', { class: 'app-container ifc-workspace' }, [
        h('div', { class: 'ifc-stage' }, [
          h('div', { class: 'ifc-canvas', ref: canvasHost }),
          h('div', { class: 'ifc-left-stack' }, [
            h('div', { class: 'ifc-commandbar', 'aria-label': '模型筛选与搜索' }, [
              h('div', { class: 'ifc-scope' }, [
                h('label', { class: 'ifc-scope-field' }, [h('span', '单体'),
                  h(MonomerSelect, {
                    key: globalProjectId.value, ref: monomerRef,
                    modelValue: monomer.value,
                    'onUpdate:modelValue': value => { monomer.value = value || undefined; },
                    'project-id': globalProjectId.value,
                    placeholder: '请选择单体', 'aria-label': '选择单体', class: 'ifc-scope-select',
                  }),
                ]),
                h('label', { class: 'ifc-scope-field' }, [h('span', '区域'),
                  h(ElSelect, {
                    modelValue: areaId.value, 'onUpdate:modelValue': value => { areaId.value = value; },
                    placeholder: '请选择区域', 'aria-label': '选择区域', disabled: !monomer.value,
                    loading: areaLoading.value, class: 'ifc-scope-select', popperClass: 'ifc-scope-dropdown',
                  }, () => areaOptions.value.map(item => h(ElOption, {
                    key: item.id, value: item.id, label: item.name + (item.revision ? '' : '（未导入 IFC）'),
                  }))),
                ]),
                h(ElButton, { class: 'ifc-refresh', disabled: !base.value || loading.value || areaLoading.value,
                  'aria-label': '刷新模型', title: '刷新模型', icon: Refresh, onClick: () => { generation.value += 1; } }),
              ]),
              h('form', { class: 'ifc-search', onSubmit: event => { event.preventDefault(); locate(query.value.trim()); } }, [
                h(ElInput, { modelValue: query.value, 'onUpdate:modelValue': value => { query.value = value; },
                  placeholder: '搜索构件编号', 'aria-label': '构件编号', prefixIcon: Search, clearable: true, disabled: !modelIndex.value }),
                h(ElButton, { nativeType: 'submit', type: 'primary', disabled: !modelIndex.value }, () => '搜索'),
                h(ElButton, { disabled: !modelIndex.value, onClick: reset }, () => '重置'),
              ]),
            ]),
            globalProjectId.value && panelVisible.value ? h('section', { key: 'context-panel',
              style: selected.value ? { display: 'none' } : undefined,
              class: ['ifc-panel', stages[activeTab.value] ? 'ifc-panel-stat' : 'ifc-panel-tree', activeTab.value === 'component' && 'ifc-panel-component'],
              'aria-label': tabs.find(item => item.id === activeTab.value)?.label }, [
              h('div', { class: 'ifc-panel-heading' }, [
                h('span', tabs.find(item => item.id === activeTab.value)?.label),
                h('button', { type: 'button', 'aria-label': '关闭面板', onClick: () => { panelVisible.value = false; } }, h(ElIcon, () => h(Close))),
              ]),
              h('div', { class: 'ifc-panel-content' }, [
                activeTab.value === 'project' ? [
                  projectTreeError.value ? h('p', { role: 'alert' }, projectTreeError.value) : null,
                  h(ElTree, {
                    data: projectNodes.value, nodeKey: 'key', highlightCurrent: true,
                    currentNodeKey: 'area:' + areaId.value, defaultExpandAll: false,
                    defaultExpandedKeys: ['project:' + globalProjectId.value, 'monomer:' + monomer.value],
                    onNodeClick: selectProject,
                  }),
                ] : null,
                activeTab.value === 'component' ? [
                  h(ElInput, { modelValue: treeQuery.value, 'onUpdate:modelValue': value => { treeQuery.value = value; },
                    placeholder: '筛选构件编号', 'aria-label': '筛选构件编号', size: 'small', clearable: true }),
                  h('div', {class: 'ifc-tree-viewport', ref: treeViewport}, [
                    h(ElTreeV2, {
                      key: area.value?.revision, data: filteredTree.value, height: treeHeight.value, itemSize: 32,
                      props: {value: 'key', label: 'label', children: 'children'},
                      expandOnClickNode: false, onNodeClick: selectPart, emptyText: '无匹配构件',
                    }, {default: renderPart}),
                  ]),
                ] : null,
                stages[activeTab.value] ? statPanel(stages[activeTab.value]) : null,
              ]),
            ]) : null,
            selected.value ? detailPanel() : null,
            searchMessage.value ? h('div', { class: 'ifc-details', role: 'status' }, searchMessage.value) : null,
          ]),
          loading.value ? h('div', { class: 'ifc-placeholder', role: 'status' }, [
            h(ElIcon, { class: 'is-loading' }, () => h(Loading)), h('strong', '正在加载模型'), h('span', '首次打开可能需要一点时间'),
          ]) : null,
          error.value ? h('div', { class: 'ifc-placeholder ifc-failure', role: 'alert' }, [
            h(ElEmpty, { imageSize: 64, description: error.value }),
            h(ElButton, { type: 'primary', onClick: () => { generation.value += 1; } }, () => '重新加载'),
          ]) : null,
          noModel ? h('div', { class: 'ifc-placeholder' }, [
            h(ElEmpty, { imageSize: 72, description: area.value ? '此区域暂未导入 IFC 模型' : globalProjectId.value ? '请选择单体和区域' : '请先选择项目' }),
          ]) : null,
          globalProjectId.value ? h('div', { class: 'ifc-overlay' }, [
            h('div', { class: 'ifc-topbar' }, [
              h('nav', { class: 'ifc-actions', 'aria-label': '模型功能' }, tabs.map(tab =>
                h('button', {
                  key: tab.id, type: 'button', class: activeTab.value === tab.id ? 'active' : '',
                  'aria-label': tab.label, 'aria-pressed': activeTab.value === tab.id,
                  disabled: !modelIndex.value && tab.id !== 'project',
                  onClick: () => activate(tab.id),
                }, [h('img', { src: '/assets/bimface/' + tab.icon + '.png', alt: '' }), h('span', tab.label)]))),
              h('div', { class: 'ifc-summary', 'aria-live': 'polite' }, [
                ...(mode && progress.value ? mode.labels.map((label, i) => h('button', {
                  class: ['ifc-legend', stateFilter.value === i && 'active'], type: 'button',
                  'aria-pressed': stateFilter.value === i, onClick: () => selectState(i),
                }, [h('i', { style: { backgroundColor: '#' + mode.colors[i].toString(16).padStart(6, '0') } }),
                  h('span', label), h('strong', number(progress.value.totals[i]))])) : []),
                progress.value && [...progress.value.byMark.values()].some(item => item.state === 'mixed')
                  ? h('button', { class: 'ifc-legend', type: 'button', onClick: () => selectState('mixed') },
                    [h('i', { style: { backgroundColor: '#a26de4' } }), '部分完成 / 数量待核对']) : null,
                !mode && modelIndex.value ? h('span', '模型构件 ' + modelIndex.value.assemblies.length + ' 件') : null,
                progressError.value ? h('span', { role: 'alert' }, progressError.value) : null,
              ]),
            ]),
          ]) : null,
          modelIndex.value ? h('nav', { class: 'ifc-navigation', 'aria-label': '模型视角',
            onKeydown: event => { if (event.key === 'Escape') viewMenu.value = false; } }, [
            h('div', { class: 'ifc-zoom', 'aria-label': '模型缩放' }, [
              h('button', { type: 'button', class: 'ifc-zoom-button', 'aria-label': '放大模型', title: '放大模型',
                disabled: zoom.value >= zoomLimits.max, onClick: () => viewer?.setZoom(zoom.value * 1.25) }, h(ElIcon, () => h(Plus))),
              h(ElSlider, { vertical: true, height: '86px', min: 0, max: 100, step: 1,
                modelValue: zoomToSlider(zoom.value), 'onUpdate:modelValue': value => viewer?.setZoom(zoomFromSlider(value)),
                'aria-label': '缩放比例', formatTooltip: value => Math.round(zoomFromSlider(value)) + '%',
                formatValueText: value => Math.round(zoomFromSlider(value)) + '%',
                tooltipClass: 'ifc-zoom-tooltip',
              }),
              h('button', { type: 'button', class: 'ifc-zoom-button', 'aria-label': '缩小模型', title: '缩小模型',
                disabled: zoom.value <= zoomLimits.min, onClick: () => viewer?.setZoom(zoom.value / 1.25) }, h(ElIcon, () => h(Minus))),
              h('button', { type: 'button', class: 'ifc-zoom-value', 'aria-label': '恢复100%缩放',
                title: '以整体模型为 100%，点击恢复该缩放比例', onClick: () => viewer?.setZoom(100) }, zoom.value + '%'),
            ]),
            h('div', { class: 'ifc-view-cube', ref: cubeRef }),
            h('div', { class: 'ifc-navigation-actions' }, [
              h('button', { class: 'ifc-home', type: 'button', title: '恢复全景', 'aria-label': '恢复全景', onClick: reset },
                [h(ElIcon, () => h(House)), h('span', '全景')]),
              h('button', { class: 'ifc-view-toggle', type: 'button', 'aria-label': '选择视角',
                'aria-expanded': viewMenu.value, onClick: () => { viewMenu.value = !viewMenu.value; } },
                [h('span', '视角'), h(ElIcon, () => h(ArrowDown))]),
            ]),
            viewMenu.value ? h('div', { class: 'ifc-view-menu' }, Object.entries(viewDirections).map(([key, value]) =>
              h('button', { key, type: 'button', onClick: () => {
                viewer?.setView(value.direction);
                viewMenu.value = false;
              } }, value.label))) : null,
          ]) : null,
        ]),
        h(DrawingPreview, {
          modelValue: drawingVisible.value, 'onUpdate:modelValue': value => { drawingVisible.value = value; },
          productId: detail.value?.artifact.id, productType: 2, monomerId: monomer.value,
          serialNumber: detail.value?.artifact.serialNumber,
          drawingSN: detail.value?.drawings.map(item => item.number).filter(value => value != null),
          boolBim: !!detail.value?.drawings.length && detail.value.drawings.every(item => /\.dwg$/i.test(item.fileName)),
        }),
        weldingVisible.value && detail.value ? h(WeldingPreview, {
          showDialog: weldingVisible.value, handleClose: () => { weldingVisible.value = false; },
          projectId: globalProjectId.value, monomerId: monomer.value, areaId: areaId.value,
          productId: detail.value.artifact.id,
        }) : null,
      ]);
    };
  },
});
