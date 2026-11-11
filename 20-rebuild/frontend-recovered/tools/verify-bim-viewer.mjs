import assert from 'node:assert/strict';
import fs from 'node:fs';
import * as Vue from 'vue';
import {applyIntegrationBrowserPolicy} from '../vite.config.js';

const original = fs.readFileSync(new URL('../index.html', import.meta.url), 'utf8');
const viewer = {
  sdk_loader_url: 'https://sdk.example.test/load.js',
  api_url: 'https://api.example.test/bim',
  static_url: 'https://sdk.example.test/static',
  resource_url: 'https://models.example.test/resources',
  sdk_version: '3.6.295'
};
const policy = {
  schema: 1,
  approved: true,
  integration_ids: ['I03'],
  directives: {
    'script-src': ['https://sdk.example.test'],
    'connect-src': ['https://api.example.test', 'https://sdk.example.test', 'https://models.example.test']
  },
  bim_viewer: viewer
};

const configId = 'ljaps-bim-viewer-config';
assert.equal(applyIntegrationBrowserPolicy(original, null), original);
assert.throws(() => applyIntegrationBrowserPolicy(original, {...policy, integration_ids: ['I17']}),
  'I17 approval must not enable a BIM viewer');
assert.throws(() => applyIntegrationBrowserPolicy(original, {...policy, directives: {}}),
  'BIM viewer must have an explicit origin policy');
for (const key of ['api_url', 'sdk_loader_url', 'static_url', 'resource_url']) {
  assert.throws(() => applyIntegrationBrowserPolicy(original, {
    ...policy,
    bim_viewer: {...viewer, [key]: 'https://user:password@sdk.example.test/path?token=hidden'}
  }));
}
const result = applyIntegrationBrowserPolicy(original, policy);
assert.deepEqual(JSON.parse(result.match(new RegExp('id="' + configId + '">([^<]+)'))[1]), viewer);

globalThis.window = {location: {href: 'https://local.example.test/bim/model-show?viewToken=ignored&mode=dev&APIHost=https://ignored.example.test'}};
let config = null;
const scriptRequests = [];
let scriptResult = 'error';
globalThis.document = {
  getElementById: id => id === configId && config,
  createElement() {
    const listeners = new Map();
    return {
      addEventListener(event, callback) { listeners.set(event, callback); },
      remove() {},
      dispatch(event) { listeners.get(event)?.(); }
    };
  },
  head: {appendChild(script) {
    scriptRequests.push(script.src);
    queueMicrotask(() => script.dispatch(scriptResult));
  }}
};
const {i: initBimfaceApp} = await import('../src/modules/bimfaceAPI-c2661893.js');
await assert.rejects(initBimfaceApp({viewToken: 'from-server'}), /未配置/);
assert.deepEqual(scriptRequests, []);

config = {textContent: JSON.stringify(viewer)};
await assert.rejects(initBimfaceApp({viewToken: 'from-server'}), /SDK/);
assert.deepEqual(scriptRequests, [viewer.sdk_loader_url]);

scriptResult = 'load';
globalThis.BimfaceSDKLoaderConfig = class {};
globalThis.BimfaceSDKLoader = {load(options, resolve) {
  assert.equal(options.viewToken, 'from-server');
  assert.equal(options.version, viewer.sdk_version);
  for (const [key, url] of Object.entries({APIHost: viewer.api_url, staticHost: viewer.static_url, resourceHost: viewer.resource_url})) {
    assert.equal(options[key], url);
    assert.equal(window.hostConfig[key], url);
  }
  resolve({viewToken: options.viewToken});
}};
assert.deepEqual(await initBimfaceApp({viewToken: 'from-server'}), {viewToken: 'from-server'});
assert.deepEqual(await initBimfaceApp({viewToken: 'from-server'}), {viewToken: 'from-server'});
assert.deepEqual(scriptRequests, [viewer.sdk_loader_url, viewer.sdk_loader_url], 'A successful script is reused after a failed attempt');

BimfaceSDKLoader.load = (options, resolve, reject) => reject(new Error('external error'));
await assert.rejects(initBimfaceApp({viewToken: 'from-server'}), /模型加载/);
BimfaceSDKLoader.load = () => Promise.reject(new Error('asynchronous SDK error'));
await assert.rejects(initBimfaceApp({viewToken: 'from-server'}), /模型加载/);

BimfaceSDKLoader.load = () => undefined;
const timers = globalThis.setTimeout;
try {
  globalThis.setTimeout = callback => timers(callback, 0);
  await assert.rejects(initBimfaceApp({viewToken: 'from-server'}), /加载超时/);
} finally {
  globalThis.setTimeout = timers;
}
const controller = new AbortController();
const canceled = initBimfaceApp({viewToken: 'from-server', signal: controller.signal});
controller.abort();
await assert.rejects(canceled, {name: 'AbortError'});

console.log('BIM browser policy, explicit loader targets and script retry checks passed');

const coloringSource = fs.readFileSync(new URL('../src/modules/bim-model-view-dbf77a11.js', import.meta.url), 'utf8');
const coloringFunction = coloringSource.slice(coloringSource.indexOf('function useArtifactColoring('), coloringSource.indexOf('function useArtifactSearch('));
const requests = [];
const useArtifactColoring = new Function('computed', 'arr2obj', 'modelMenuBarEnum', 'ElLoading', 'getArtifactStatus',
  coloringFunction + '\nreturn useArtifactColoring;')(
  getter => ({get value() { return getter(); }}),
  (list, key) => Object.fromEntries(list.map(value => [value[key], value])),
  {PROJECT_TREE: {V: 1}},
  {service: () => ({close() {}})},
  args => new Promise((resolve, reject) => requests.push({args, resolve, reject}))
);
const appliedColors = new Map();
const viewerApi = {
  getModel: () => ({overrideAllComponentsColor(color) { appliedColors.set('base', color); }}),
  restoreComponentsColorById(ids) { ids.forEach(id => appliedColors.delete(id)); },
  overrideComponentsColorById(ids, color) { ids.forEach(id => appliedColors.set(id, color)); },
  clearIsolation() {},
  clearAllBlinkComponents() {},
  showComponentsById() {},
  render() {}
};
const modelStatus = {value: {fileId: 1}};
const group = {value: {}};
const statusMessage = {value: ''};
const colorController = useArtifactColoring({
  props: {showMonomerModel: true},
  bimModel: {getColor: color => color},
  modelStatus,
  viewer: {value: viewerApi},
  objectIdGroup: group,
  colors: {value: [{value: 2, color: 'green'}]},
  statusMessage
});

const production = colorController.fetchArtifactStatus(3);
requests.at(-1).resolve({2: ['old-color']});
await production;
assert.equal(appliedColors.get('old-color'), 'green');

const shipment = colorController.fetchArtifactStatus(4);
assert.equal(appliedColors.has('old-color'), false, 'Switching tabs must immediately clear old progress colors');
const installation = colorController.fetchArtifactStatus(5);
requests.at(-1).resolve({2: ['current-color']});
await installation;
requests.at(-2).resolve({2: ['stale-color']});
await shipment;
assert.equal(appliedColors.get('current-color'), 'green');
assert.equal(appliedColors.has('stale-color'), false);

const failed = colorController.fetchArtifactStatus(5);
requests.at(-1).reject(new Error('API failure'));
await failed;
assert.deepEqual([...appliedColors], [['base', '#999999']]);
assert.match(statusMessage.value, /未能加载/);
assert.deepEqual(group.value, {});

const previousModel = colorController.fetchArtifactStatus(5);
modelStatus.value = {fileId: 2};
requests.at(-1).resolve({2: ['stale-model']});
await previousModel;
assert.equal(appliedColors.has('stale-model'), false);
console.log('BIM progress reset, stale-tab/model rejection and neutral failure checks passed');

const setupSource = coloringSource.slice(coloringSource.indexOf('_sfc_main = { __name: "bim-model-view"'), coloringSource.indexOf(' }, bimModelView = _export_sfc') + 2);
const modelRequests = [];
const loaderRequests = [];
const builtModels = [];
let destroyed = 0;
let unmount;
const sourceWatchers = [];
const noOp = () => {};
const testRoot = {replaceChildren: noOp};
document.getElementById = () => testRoot;
window.addEventListener = noOp;
window.removeEventListener = noOp;
const testBindings = {
  ref: value => ({value: value === null ? testRoot : value}),
  shallowRef: value => ({value}),
  reactive: value => value,
  computed: getter => ({get value() { return getter(); }}),
  mapGetters: () => ({globalProject: {value: null}}),
  constantize: value => { value.V = Object.fromEntries(Object.values(value).map(entry => [entry.V, entry])); },
  nextTick: async () => {},
  watch(getter, callback, options) {
    sourceWatchers.push({getter, callback});
    if (options?.immediate) callback(getter());
  },
  onBeforeUnmount: callback => { unmount = callback; },
  getTranslate: (id, areaId) => new Promise(resolve => modelRequests.push({id, areaId, resolve})),
  initBimfaceApp: args => new Promise(resolve => loaderRequests.push({...args, resolve})),
  useArtifactColoring: () => ({initModelColor: noOp, resetArtifactColoring: noOp}),
  useDrawing: () => ({createDrawing: noOp, destroyDrawing: noOp}),
  useWeldingProcess: () => ({destroyWeldingProcess: noOp}),
  useArtifactInfo: () => ({}),
  useStatusInfo: () => ({}),
  useProjectTreePanel: () => ({}),
  useLogisticsInfo: () => ({}),
  useMyToolbar: () => ({}),
  useArtifactSearch: () => ({}),
  useColorCard: () => ({destroyColorCard: noOp}),
  usePreview: () => ({serialNumberElementIds: {value: []}}),
  bimModel: {},
  modelTranslateStatusEnum: {SUCCESS: {V: 'success'}},
  getConfig: () => ({}),
  getViewer3DEvent: () => ({ViewAdded: 'ViewAdded', ComponentsSelectionChanged: 'ComponentsSelectionChanged'}),
  getApp: () => {
    const handlers = new Map();
    return {
      addView(token) { builtModels.push(token); handlers.get('ViewAdded')?.(); },
      getViewer() {
        return {
          addEventListener: (event, handler) => handlers.set(event, handler),
          removeEventListener: (event, handler) => handlers.delete(event),
          destroy() { destroyed++; }
        };
      }
    };
  }
};
const component = new Function(...Object.keys(testBindings), 'const ' + setupSource + ';return _sfc_main;')(...Object.values(testBindings));
const props = {monomerId: 1, showMonomerModel: true, visible: true, isPreview: true, tracePage: true};
let viewerState;
component.setup(props, {expose: value => { viewerState = value; }});
assert.equal(modelRequests.length, 1, 'Opening a visible preview must request metadata only once');
const selection = sourceWatchers[0];
props.monomerId = 2;
selection.callback(selection.getter());
modelRequests.at(-1).resolve({fileId: 2, status: 'success', modelType: 'file', viewToken: 'second'});
await new Promise(resolve => setImmediate(resolve));
assert.equal(loaderRequests.length, 1);
modelRequests[0].resolve({fileId: 1, status: 'success', modelType: 'file', viewToken: 'first'});
await new Promise(resolve => setImmediate(resolve));
assert.equal(loaderRequests.length, 1, 'A slow response for the previous selection cannot start SDK loading');

loaderRequests[0].resolve({viewToken: 'second'});
await new Promise(resolve => setImmediate(resolve));
assert.deepEqual(builtModels, ['second']);
assert.equal(viewerState.modelLoaded.value, true, 'Synchronous ViewAdded must be observed');
unmount();
assert.equal(destroyed, 1);
assert.equal(viewerState.modelLoaded.value, false);
console.log('BIM model lifecycle checks passed');

const element = type => ({type, children: [], parent: null, replaceChildren() { this.children.length = 0; }});
function detach(node) {
  if (node.parent) node.parent.children.splice(node.parent.children.indexOf(node), 1);
  node.parent = null;
}
const renderer = Vue.createRenderer({
  createElement: element,
  createText: () => element('#text'),
  createComment: () => element('#comment'),
  parentNode: node => node.parent,
  nextSibling: node => node.parent?.children[node.parent.children.indexOf(node) + 1] ?? null,
  remove: detach,
  insert(node, parent, anchor = null) {
    detach(node);
    node.parent = parent;
    parent.children.splice(anchor ? parent.children.indexOf(anchor) : parent.children.length, 0, node);
  },
  patchProp: noOp,
  setText: noOp,
  setElementText: noOp
});
const bindings = {
  ...testBindings,
  ref: Vue.ref,
  shallowRef: Vue.shallowRef,
  computed: Vue.computed,
  watch: Vue.watch,
  nextTick: Vue.nextTick,
  onBeforeUnmount: Vue.onBeforeUnmount,
  openBlock: Vue.openBlock,
  createElementBlock: Vue.createElementBlock,
  createCommentVNode: Vue.createCommentVNode,
  createVNode: Vue.createVNode,
  normalizeStyle: Vue.normalizeStyle,
  createBaseVNode: Vue.createElementVNode,
  _hoisted_1: {key: 1, id: 'modelView'},
  ElTag: {render: () => Vue.createVNode('span')},
  ElButton: {render: () => Vue.createVNode('button')},
  constantize(value) {
    const entries = Object.values(value);
    value.V = Object.fromEntries(entries.map(entry => [entry.V, entry]));
    value.VL = Object.fromEntries(entries.map(entry => [entry.V, entry.L]));
  },
  getTranslate: async () => ({fileId: 3, status: 'success', modelType: 'file', viewToken: 'mounted'}),
  initBimfaceApp: async () => ({viewToken: 'mounted'}),
  getApp(config) {
    assert.equal(config.domElement?.parent?.type, 'div');
    return testBindings.getApp();
  }
};
const mountedComponent = new Function(...Object.keys(bindings), 'const ' + setupSource + ';return _sfc_main;')(...Object.values(bindings));
const app = renderer.createApp(mountedComponent, props);
app.mount(element('root'));
await new Promise(resolve => setImmediate(resolve));
assert.equal(builtModels.at(-1), 'mounted', 'The SDK must receive a mounted container after the asynchronous status change');
app.unmount();
console.log('BIM model container mounts before the viewer initializes');
