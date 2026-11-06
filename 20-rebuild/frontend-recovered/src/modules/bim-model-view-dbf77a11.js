var qe = Object.defineProperty;
var $e = (z2, f2, $2) => f2 in z2 ? qe(z2, f2, { enumerable: true, configurable: true, writable: true, value: $2 }) : z2[f2] = $2;
var Mt = (z2, f2, $2) => ($e(z2, typeof f2 != "symbol" ? f2 + "" : f2, $2), $2), ae = (z2, f2, $2) => {
  if (!f2.has(z2)) throw TypeError("Cannot " + $2);
};
var R = (z2, f2, $2) => (ae(z2, f2, "read from private field"), $2 ? $2.call(z2) : f2.get(z2)), ct = (z2, f2, $2) => {
  if (f2.has(z2)) throw TypeError("Cannot add the same private member more than once");
  f2 instanceof WeakSet ? f2.add(z2) : f2.set(z2, $2);
}, mt = (z2, f2, $2, c2) => (ae(z2, f2, "write to private field"), c2 ? c2.call(z2, $2) : f2.set(z2, $2), $2);
var re = (z2, f2, $2, c2) => ({ set _(S2) {
  mt(z2, f2, S2, $2);
}, get _() {
  return R(z2, f2, c2);
} }), ft = (z2, f2, $2) => (ae(z2, f2, "access private method"), $2);
import { watch } from "vue";
import { ref } from "vue";
import { openBlock } from "vue";
import { createBlock } from "vue";
import { unref } from "vue";
import { createApp } from "vue";
import { computed } from "vue";
import { ElLoading } from "element-plus";
import { commonjsRequire } from "../runtime/build-helpers.mjs";
import { browserExternal as require$$4 } from "../runtime/build-helpers.mjs";
import { useStore } from "vuex";
import { withCtx } from "vue";
import { createElementVNode as createBaseVNode } from "vue";
import { createVNode } from "vue";
import { createTextVNode } from "vue";
import { toDisplayString } from "vue";
import { withDirectives } from "vue";
import { createElementBlock } from "vue";
import { normalizeStyle } from "vue";
import { createCommentVNode } from "vue";
import { Fragment } from "vue";
import { renderList } from "vue";
import { normalizeClass } from "vue";
import { ElTag } from "element-plus";
import { ElButton } from "element-plus";
import { ElScrollbar } from "element-plus";
import { ElTableColumn } from "element-plus";
import { ElCard } from "element-plus";
import { ElImage } from "element-plus";
import { ElDialog } from "element-plus";
import { vLoading } from "element-plus";
import { nextTick } from "vue";
import { reactive } from "vue";
import { m as bimModel, i as initBimfaceApp, g as getConfig, a as getApp, b as getViewer3DEvent, n as getPanelPositions } from "./bimfaceAPI-c2661893.js";
import { a as getStatusDetail, b as getIntegrateStatusDetail, c as getIntegrateMonomer, d as getProjectTree, e as getArtifactStatus, f as getIntegrationArtifactStatus, h as getArtifactSearch, i as getIntegrateArtifactSearch, j as getArtifactInfo, k as getIntegrateArtifactInfo, l as getArtifactProduction, m as getIntegrateArtifactProduction, n as getLogistics, o as getIntegrateLogistics, p as getTranslate, q as getIMTranslate } from "./model-0ac957f7.js";
import { a8 as modelMenuBarEnum, i as isNotBlank, a9 as arr2obj, p as parseTime, l as service, _ as _export_sfc, o as useMaxHeight, aa as deepenTypeEnum, ab as _sfc_main$5, ac as _sfc_main$6, ad as getDrawingNumber, a7 as previewPDF, j as store, m as mapGetters, n as constantize, ae as modelIntegrationStatusEnum, K as projectTypeEnum, a4 as modelTranslateStatusEnum, b as isBlank } from "../shared/runtime.js";
import { C as ColorCard } from "./index-d6a37d29.js";
import { a as _sfc_main$4 } from "./drawing-preview-fullscreen-dialog-60155503.js";
import { u as useChart } from "./use-chart-59e4b63c.js";
function useMyToolbar({ menuBar: z2, bimModel: f2, viewerPanel: $2, colors: c2, publicPath: S2, isMobile: q2, createLogisticsBtn: B2, hideLogisticsBtn: Q2, clearProTreePanel: I2, fetchProTree: y2, clearArtifactInfoPanel: w, fetchArtifactInfo: k2, clearStatusInfoPanel: T2, fetchStatusInfo: C2, clearSelectedComponents: l }) {
  const t = [{ ...modelMenuBarEnum.PROJECT_TREE, hidden: q2, clickEvent: function(a) {
    z2.value = a, y2();
  }, unActiveEvent: function() {
    I2();
  } }, { ...modelMenuBarEnum.COMPONENT_TREE, hidden: q2, clickEvent: function(a) {
    z2.value = a;
  }, unActiveEvent: function() {
    w();
  } }, { ...modelMenuBarEnum.PRODUCTION_STATE, hidden: false, clickEvent: function(a) {
    z2.value = a, C2();
  }, unActiveEvent: function() {
    T2();
  } }, { ...modelMenuBarEnum.SHIPMENT_STATUS, hidden: false, clickEvent: function(a) {
    z2.value = a, q2 || B2(), C2();
  }, unActiveEvent: function() {
    q2 || Q2(), T2();
  } }, { ...modelMenuBarEnum.INSTALL_STATE, hidden: q2, clickEvent: function(a) {
    z2.value = a, C2();
  }, unActiveEvent: function() {
    T2();
  } }];
  watch(() => z2.value, (a, h) => {
    isNotBlank(a) && (l(), document.querySelectorAll(`${q2 ? ".bf-toolbar-my-mobile" : ".bf-toolbar-my"}>.bf-button`).forEach((r) => {
      r.innerText === modelMenuBarEnum.VL[a] ? r.className = "bf-button bf-button-active" : r.className = "bf-button";
    }), c2.value = t[a - 1].COLORS), isNotBlank(h) && h !== a && t[h - 1].unActiveEvent();
  }, { immediate: true });
  function s() {
    const a = f2.getToolbarConfig();
    a.id = "MyToolbar", a.className = `bf-toolbar ${q2 ? "bf-toolbar-my-mobile" : "bf-toolbar-my"}`, a.element = document.getElementsByClassName("bf-container")[0];
    const h = f2.createToolbar(a);
    for (let b = 0; b < t.length; b++) {
      const r = t[b];
      if (r.hidden) continue;
      const n = f2.getButtonConfig();
      n.title = r.L;
      const e = f2.createButton(n);
      e.setHtml(`<div style="display:flex;flex-direction: column;justify-content: center;align-items: center;width: 70px;">
        <img src="${S2}/bimface/${r.ICON}" height="25" width="25"/>
        <span style="font-size:10px;">${r.L}</span>
      </div>`), e.addEventListener("Click", () => r.clickEvent(r.V)), h.insertControl(b, e);
    }
  }
  return { createMyToolbar: s, menuBar: z2 };
}
const _sfc_main$3 = { __name: "bf-color-card", props: { statusChange: { type: Function }, selectAble: { type: Boolean, default: true }, colors: { type: Array, default: () => [] } }, setup(z2) {
  const f2 = ref();
  return ($2, c2) => (openBlock(), createBlock(unref(ColorCard), { colors: z2.colors, value: f2.value, "onUpdate:value": c2[0] || (c2[0] = (S2) => f2.value = S2), "color-border": "", "select-able": z2.selectAble, onChange: z2.statusChange }, null, 8, ["colors", "value", "select-able", "onChange"]));
} };
function useColorCard({ props: z2, isMobile: f2, menuBar: $2, colors: c2, objectIdGroup: S2, bimModel: q2, viewerPanel: B2, modelStatus: Q2, searchBySN: I2, fetchArtifactStatus: y2, isolateComponentsById: w, clearIsolation: k2, hideComponentsById: T2, showComponentsById: C2, overrideComponentsColorById: l, isBridgeProject: t }) {
  const s = ref([]), a = ref();
  async function h(d) {
    if (!d) s.value = [], k2(), C2(S2.value[0]), m();
    else {
      const E = d.value;
      let U = S2.value[E] || [];
      console.log(U, S2.value, E, "elementIds"), U.length ? (C2(S2.value[0]), [2, 3, 4, 5, 6, 7, 10, 11, 12].indexOf(d.value) !== -1 && (await e(d), U = s.value), w(U)) : (T2(S2.value[0]), m());
    }
  }
  watch(() => $2.value, (d) => {
    d && r();
  });
  function b() {
    a.value = createApp(_sfc_main$3, { statusChange: h, colors: [] });
    const d = f2 ? "bfColorCardMobile" : "bfColorCard";
    if (!document.getElementById(d)) {
      const U = document.getElementsByClassName("bf-container")[0], tt = document.createElement("div");
      tt.id = d, U.appendChild(tt);
    }
    a.value.mount(`#${d}`), n();
  }
  function r() {
    a.value._container._vnode.component.props.selectAble = true, a.value._container._vnode.component.props.colors = c2.value, y2($2.value);
  }
  function n() {
    const d = q2.getPanelConfig();
    d.className = "bf-panel bf-panel-color-card", d.css.width = "300px", d.css.height = "300px", d.element = document.getElementsByClassName("bf-container")[0];
    const E = q2.createPanel(d);
    E.isShow = false, B2.colorCard = { config: d, panel: E };
  }
  async function e(d) {
    const E = B2.colorCard.panel;
    E.setTitleContent(d.title + "详情"), B2.panelPositions[E._opt.className] = { left: 1200, top: 80 }, E.initPosition(), E && E.show();
    try {
      let U;
      z2.showMonomerModel ? U = await getStatusDetail({ fileId: Q2.value.fileId, status: d.value, menuBar: $2.value }) : U = await getIntegrateStatusDetail({ projectId: z2.projectId, status: d.value, menuBar: $2.value });
      const { proportion: tt, quantity: H, totalGrossWeight: Z, basicsVOS: j, elementIds: V } = U;
      s.value = V;
      const X = document.getElementsByClassName("bf-panel-color-card")[0].getElementsByClassName("bf-panel-container")[0];
      X.innerHTML = "", X.innerHTML = `
        <div class="el-progress el-progress--line el-progress--text-inside"">
          <div class="el-progress-bar">
            <div class="el-progress-bar__outer" style="height: 26px;border-radius: 0;">
              <div class="el-progress-bar__inner" style="width: ${tt}%; animation-duration: 3s;border-radius: 0;">
                <div class="el-progress-bar__innerText">
                <span>${d.title}率：${tt}%</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="bf-panel-color-card-container">
          <div>
            <span>${d.title}总数（件）</span>
            <span>${H}</span>
          </div>
          <div>
            <span>${d.title}总量（kg）</span>
            <span>${Z}</span>
          </div>
          <div class="el-input el-input--default el-input-group el-input-group--append">
            <input class="el-input__inner search-input" type="text" autocomplete="off" placeholder="输入构件号查询">
            <div class="el-input-group__append" style="width: 70px;">
              <button class="el-button search-btn" type="button">
                查询
              </button>
            </div>
          </div>
          <div>
            <span>名称</span>
            <span>编号</span>
            <span>数量</span>
            <span>重量(kg)</span>
          </div>
          <div class="search-content" style="flex-direction: column;">
            ${v(j)}
          </div>
        </div>
      `, o();
      const at = document.querySelector(".bf-panel-color-card-container .search-input"), dt = document.querySelector(".bf-panel-color-card-container .search-btn"), bt = document.querySelector(".bf-panel-color-card-container .search-content");
      dt.onclick = () => {
        bt.innerHTML = "", bt.innerHTML = v(j, at.value), o();
      }, console.log(at, dt);
    } catch (U) {
      console.log(U, "获取状态下的信息");
    }
  }
  function o() {
    const d = document.getElementsByClassName("bf-panel-color-li");
    for (let E = 0; E < d.length; E++) d[E].onclick = () => {
      const U = d[E].dataset.serialNumber;
      I2(U);
    };
  }
  function v(d, E) {
    if (d && d.length) {
      let U = "";
      for (let tt = 0; tt < d.length; tt++) {
        const H = d[tt];
        if (E && H.serialNumber.indexOf(E) === -1) break;
        U += `
          <div class="bf-panel-color-li" style="cursor:pointer;" data-serial-number="${H.serialNumber}">
            <span>${H.name}</span>
            <span>${H.serialNumber}</span>
            <span>${H.quantity}</span>
            <span>${H.totalGrossWeight}</span>
          </div>
        `;
      }
      return U;
    } else return "";
  }
  function m() {
    const d = B2.colorCard.panel;
    d.isShow && d.hide();
  }
  return { createColorCardHtml: b };
}
function useProjectTreePanel({ props: z2, bimModel: f2, modelStatus: $2, viewerPanel: c2, viewProAreaTree: S2, fetchWeldingProcess: q2, setSelectedComponentsByObjectData: B2, clearSelectedComponents: Q2, addBlinkByIds: I2, removeBlink: y2, getModelViewSize: w, isBridgeProject: k2 }) {
  const T2 = ref([]), C2 = ref({});
  watch(() => z2.monomerId, () => {
    T2.value = [];
  }, { immediate: true });
  function l() {
    const e = f2.getPanelConfig();
    e.className = "bf-panel bf-panel-pro-tree", e.title = z2.showMonomerModel ? "区域单元" : "单体单元", e.css.width = "230px", e.element = document.getElementsByClassName("bf-container")[0];
    const o = f2.createPanel(e);
    o.isShow = false, console.log(o, "_panel"), document.querySelector(".bf-panel-pro-tree .bf-close").addEventListener("click", () => {
      const m = c2.artifactListByArea.panel;
      if (m != null && m.isShow) {
        m.hide(), y2();
        const { tree: d, treeApi: E } = S2.value;
        E.clear(d);
      }
    }), t(), c2.proTree = { config: e, panel: o };
  }
  function t() {
    const e = f2.getPanelConfig();
    e.className = "bf-panel bf-panel-artifact-list-by-area", e.title = z2.showMonomerModel ? "区域构件明细" : "单体构件明细", e.element = document.getElementsByClassName("bf-container")[0], e.css.width = "300px", e.css.height = "300px";
    const o = f2.createPanel(e);
    o.isShow = false, c2.artifactListByArea = { config: e, panel: o };
  }
  async function s() {
    const e = c2.proTree.panel;
    c2.panelPositions[e._opt.className] = { left: 10, top: 90 }, e.initPosition(), e && e.show(), z2.showMonomerModel ? await h() : await a();
  }
  async function a() {
    const e = f2.getTreeConfig();
    e.className = "bf-tree bf-tree-monomer", e.hasCheckbox = false, e.selection = false, e.title = "单体列表";
    const o = document.getElementsByClassName("bf-panel-pro-tree")[0].getElementsByClassName("bf-panel-container")[0];
    e.element = o, o.innerHTML = "";
    const v = f2.createTree(e);
    v.setData(-1, `${z2.projectName}`);
    try {
      const { content: m } = await getIntegrateMonomer(z2.projectId);
      for (let E = 0; E < m.length; E++) {
        const U = m[E], tt = f2.getTreeConfig();
        tt.hasCheckbox = false, tt.hasExpand = false, tt.id = U.monomerId, console.log(tt, "_treeNodeConfig");
        const H = f2.createTree(tt);
        H.setData({ ...U, type: "monomer" }, `${U.monomerName}`), v.addChildNode(H), C2.value[U.monomerId] = {}, C2.value[U.monomerId].treeNode = H, C2.value[U.monomerId].areaList = [];
      }
      v.expand();
      const d = f2.getTreeApi(v);
      console.log(d, "_treeApi"), d.addEventListener("SelectionChanged", (E, U) => {
        const { type: tt } = E.id;
        if (tt === "monomer") if (U) {
          b(E);
          const { fileId: H } = E.id;
          B2([{ fileId: String(H) }]);
        } else Q2();
        if (tt === "area") if (Q2(), U) {
          b(E);
          const { elementIds: H } = E.id;
          I2(H);
        } else {
          const H = c2.artifactListByArea.panel;
          H.isShow && H.hide(), y2();
        }
      }), S2.value = { config: e, tree: v, treeApi: d };
    } catch (m) {
      console.log("集成模型获取单体信息失败", m);
    }
  }
  async function h() {
    const e = f2.getTreeConfig();
    e.className = "bf-tree bf-tree-area", e.hasCheckbox = false, e.selection = false, e.title = "区域列表";
    const o = document.getElementsByClassName("bf-panel-pro-tree")[0].getElementsByClassName("bf-panel-container")[0];
    e.element = o, o.innerHTML = "";
    const v = f2.createTree(e);
    v.setData(-1, `${z2.projectName}>${z2.monomerName}`);
    let m;
    try {
      const { content: d } = await getProjectTree($2.value.fileId);
      T2.value = d;
      for (let E = 0; E < d.length; E++) {
        const U = d[E], tt = f2.getTreeConfig();
        tt.hasCheckbox = false;
        const H = f2.createTree(tt);
        H.setData(U, U.area.name), v.addChildNode(H);
      }
      v.expand(), m = f2.getTreeApi(v), m.addEventListener("SelectionChanged", (E, U) => {
        if (U) {
          b(E);
          const { elementIds: tt, fileId: H } = E.id;
          $2.value.modelType === "file" ? I2(tt) : B2([{ fileId: String(H) }]);
        } else {
          const tt = c2.artifactListByArea.panel;
          tt.isShow && tt.hide(), $2.value.modelType === "file" ? y2() : Q2();
        }
      }), S2.value = { config: e, tree: v, treeApi: m };
    } catch (d) {
      console.log(d, "获取区域");
    }
  }
  function b(e) {
    const o = c2.artifactListByArea.panel, { css: v } = o._opt, m = w();
    console.log(m.width, m, v, o, "modelViewSize"), c2.panelPositions[o._opt.className] = { left: m.width - Number(v.width.slice(0, -2)), top: 0 }, o.initPosition(), o.setHeight(m.height), o && o.show();
    const { basicsVOS: d, totalGrossWeight: E, quantity: U } = e.id, tt = e.name, H = document.querySelector(".bf-panel-artifact-list-by-area .bf-panel-container");
    H.innerHTML = "";
    const Z = `
      <div class="bf-area-artifact-container">
        <div>
          <span>单元</span>
          <span>${tt}</span>
        </div>
        <div>
          <span>构件数量（件）</span>
          <span>${U}</span>
        </div>
        <div>
          <span>构件重量（kg）</span>
          <span>${E}</span>
        </div>
        <div>
          <span>编号</span>
          <span>数量</span>
          <span>重量</span>
          <span>焊缝</span>
        </div>
        ${r(d)}
      </div>
    `;
    H.innerHTML = Z, H.addEventListener("click", (j) => {
      const V = j.target.closest(".bfWPBtn");
      V && q2({ productId: V.dataset.productId, monomerId: z2.monomerId, areaId: z2.areaId });
    });
  }
  function r(e) {
    let o = "";
    for (let v = 0; v < e.length; v++) {
      const m = e[v];
      o += `
        <div>
          <span>${m.serialNumber}</span>
          <span>${m.quantity}</span>
          <span>${m.totalGrossWeight}</span>
          <span data-productId='${m.id}' class="pointer bfWPBtn">${m.productWeldCount || 0}</span>
        </div>
      `;
    }
    return o;
  }
  function n() {
    y2(), Q2();
    const { tree: e, treeApi: o } = S2.value;
    o.clear(e);
    const v = c2.proTree.panel;
    v.isShow && v.hide();
    const m = c2.artifactListByArea.panel;
    m.isShow && m.hide();
  }
  return { createProTreePanel: l, fetchProTree: s, viewProAreaTree: S2, clearProTreePanel: n };
}
function useArtifactColoring({ props: z2, bimModel: f2, modelStatus: $2, viewer: c2, colors: S2, objectIdGroup: q2, isBridgeProject: B2 }) {
  const Q2 = computed(() => arr2obj(S2.value, "value"));
  function I2() {
    const n = ElLoading.service({ target: "#modelView", lock: true, text: "请稍后，正在染色", fullscreen: false });
    try {
      const e = f2.getColor("#999999", 1);
      c2.value.getModel().overrideAllComponentsColor(e), c2.value.render();
    } catch (e) {
      console.log("error", e);
    } finally {
      n.close();
    }
  }
  async function y2(n) {
    if (n === modelMenuBarEnum.PROJECT_TREE.V) {
      I2();
      return;
    }
    const e = ElLoading.service({ target: "#modelView", lock: true, text: "请稍后，正在染色", fullscreen: false });
    try {
      let o = {};
      z2.showMonomerModel ? o = await getArtifactStatus({ fileId: $2.value.fileId, menuBar: n }) : o = await getIntegrationArtifactStatus({ projectId: z2.projectId, menuBar: n });
      for (const v in o) if (o[v] && o[v].length > 0 && Q2.value[v]) {
        const m = f2.getColor(Q2.value[v].color, Q2.value[v].opacity);
        c2.value.overrideComponentsColorById(o[v], m);
      }
      q2.value = o, c2.value.render();
    } catch (o) {
      console.log("error", o);
    } finally {
      e.close();
    }
  }
  function w(n, { color: e, opacity: o = 0.8 }) {
    const v = f2.getColor(e, o);
    c2.value.overrideComponentsColorById(n, v), c2.value.render();
  }
  function k2(n) {
    c2.value.restoreComponentsColorById(n), c2.value.render();
  }
  function T2(n) {
    c2.value.clearAllBlinkComponents(), c2.value.addBlinkComponentsById(n), c2.value.setBlinkColor(f2.getColor("#ff1818", 1)), c2.value.enableBlinkComponents(true), c2.value.setBlinkIntervalTime(500), c2.value.render();
  }
  function C2() {
    c2.value.clearAllBlinkComponents(), c2.value.render();
  }
  function l(n) {
    const e = f2.getIsolateOption().HideOthers;
    console.log(e, "isolateOption"), c2.value.isolateComponentsById(n, e), c2.value.render();
  }
  function t() {
    c2.value.clearIsolation(), c2.value.render();
  }
  function s(n) {
    console.log(n, "hideComponentsById"), c2.value.hideComponentsById(n), c2.value.render();
  }
  function a(n) {
    c2.value.showComponentsById(n), c2.value.render();
  }
  function h(n) {
    c2.value.setSelectedComponentsByObjectData(n), c2.value.render();
  }
  function b() {
    c2.value.clearSelectedComponents();
  }
  function r(n) {
    c2.value.clearSelectedComponents(), c2.value.setSelectedComponentsById(n), c2.value.zoomToSelectedComponents(), c2.value.clearSelectedComponents();
  }
  return { initModelColor: I2, fetchArtifactStatus: y2, overrideComponentsColorById: w, resetComponentsColorById: k2, addBlinkByIds: T2, removeBlink: C2, isolateComponentsById: l, clearIsolation: t, hideComponentsById: s, showComponentsById: a, clearSelectedComponents: b, setSelectedComponentsByObjectData: h, zoomToComponentsById: r };
}
function useArtifactSearch({ props: z2, modelStatus: f2, addBlinkByIds: $2, removeBlink: c2, isBridgeProject: S2 }) {
  const q2 = ref(), B2 = ref([]);
  function Q2() {
    const y2 = document.getElementsByClassName("bf-container")[0], w = document.createElement("div");
    w.innerHTML = `
      <div class="bf-artifact-search">
        <div class="el-input el-input--default" style="margin-right: 10px;">
          <input class="el-input__inner bf-artifact-search-input" type="text" autocomplete="off" placeholder="构件编号搜索"></input> 
        </div>
        <button class="el-button el-button--primary el-button--default bf-artifact-search-btn-s" type="button">
          <span>搜索</span>
        </button>
        <button class="el-button el-button--warning el-button--default bf-artifact-search-btn-r" type="button">
          <span>重置</span>
        </button>
      </div>
    `, y2.appendChild(w), q2.value = document.getElementsByClassName("bf-artifact-search-input")[0], document.getElementsByClassName("bf-artifact-search-btn-s")[0].addEventListener("click", () => {
      I2(q2.value.value);
    }), document.getElementsByClassName("bf-artifact-search-btn-r")[0].addEventListener("click", () => {
      c2(), q2.value.value = "";
    });
  }
  async function I2(y2) {
    if (y2) try {
      let w;
      z2.showMonomerModel ? w = await getArtifactSearch({ serialNumber: y2, fileId: f2.value.fileId, productType: z2.productType }) : w = await getIntegrateArtifactSearch({ serialNumber: y2, projectId: z2.projectId }), $2(w), B2.value = w;
    } catch (w) {
      console.log("构件编号搜索报错", w);
    }
  }
  return { createSearchHtml: Q2, searchBySN: I2 };
}
function useArtifactInfo({ props: z2, menuBar: f2, bimModel: $2, viewerPanel: c2, modelStatus: S2, viewer: q2, fetchDrawing: B2, fetchWeldingProcess: Q2, addBlinkByIds: I2, isBridgeProject: y2 }) {
  const w = ref({});
  function k2() {
    const e = $2.getPanelConfig();
    e.className = "bf-panel bf-panel-artifact-info", e.title = "构件详情", e.css.width = "265px", e.css.height = "355px", e.element = document.getElementsByClassName("bf-container")[0];
    const o = $2.createPanel(e);
    o.isShow = false, T2(), c2.artifactInfo = { config: e, panel: o };
  }
  function T2() {
    const e = $2.getPanelConfig();
    e.className = "bf-panel bf-panel-machine-part-list", e.title = "零件列表", e.css.width = "400px", e.element = document.getElementsByClassName("bf-container")[0];
    const o = $2.createPanel(e);
    o.isShow = false, c2.machinePartList = { config: e, panel: o };
  }
  async function C2(e) {
    let o = e;
    if (e || (o = q2.value.getSelectedComponents()[0]), !o) return;
    const v = c2.artifactInfo.panel, m = c2.statusInfo.panel;
    let d = 0;
    if (m.isShow) {
      const { css: E, className: U } = m._opt;
      d = c2.panelPositions[U].top + Number(E.height.slice(0, -2)) + 10;
    }
    c2.panelPositions[v._opt.className] = { left: 10, top: d || 90 }, v.initPosition(), v && v.show(), await h(o);
  }
  function l() {
    const e = c2.machinePartList.panel, o = c2.artifactInfo.panel, { css: v, className: m } = o._opt;
    c2.panelPositions[e._opt.className] = { left: c2.panelPositions[m].left + Number(v.width.slice(0, -2)) + 10, top: c2.panelPositions[m].top }, e.initPosition(), e && e.show(), t();
  }
  function t() {
    const e = document.getElementsByClassName("bf-panel-machine-part-list")[0].getElementsByClassName("bf-panel-container")[0];
    e.innerHTML = "";
    const o = `
        <div class="bf-machine-part-list-container">
          <div>
            <span>零件编号</span>
            <span>规格</span>
            <span>材质</span>
            <span>数量</span>
            <span>单重</span>
          </div>
          ${s(w.value.techMachinePartDTOS)}
        </div>
      `;
    e.innerHTML = o, a();
  }
  function s(e) {
    let o = "";
    for (let v = 0; v < e.length; v++) {
      const m = e[v];
      o += `
        <div>
          <span class="bf-panel-machine-sn" style="cursor:pointer;" 
          data-bool-bim="${Number(m.boolBim || 0)}"
          data-serial-number="${m.serialNumber}"
          data-product-id="${m.id}"
          data-product-type="${m.productType}"
          >${m.serialNumber}</span>
          <span>${m.specification}</span>
          <span>${m.material}</span>
          <span>${m.quantity}</span>
          <span>${m.grossWeight}</span>
        </div>
      `;
    }
    return o;
  }
  function a() {
    const e = document.getElementsByClassName("bf-panel-machine-sn");
    for (let o = 0; o < e.length; o++) e[o].onclick = () => {
      const { boolBim: v, serialNumber: m, productId: d, productType: E, numbers: U, monomerId: tt } = e[o].dataset;
      B2({ boolBim: Number(v), serialNumber: m, productId: d, productType: E, drawingSN: U, monomerId: tt });
    };
  }
  async function h(e) {
    var v;
    if (c2.artifactInfo.panel.isShow && e) try {
      let m;
      z2.showMonomerModel ? m = await getArtifactInfo({ fileId: S2.value.fileId, elementId: e, menuBar: f2.value }) : m = await getIntegrateArtifactInfo({ projectId: z2.projectId, elementId: e, menuBar: f2.value }), w.value = m;
      const d = document.getElementsByClassName("bf-panel-artifact-info")[0].getElementsByClassName("bf-panel-container")[0];
      d.innerHTML = "";
      const E = `
        <div class="bf-artifact-info-container">
          <div>
            <span>名称</span>
            <span>${m.name}</span>
          </div>
          <div>
            <span>编号</span>
            <span>${m.serialNumber}</span>
          </div>
          <div>
            <span>规格</span>
            <span>${m.specification}</span>
          </div>
          <div>
            <span>材质</span>
            <span>${m.material}</span>
          </div>
          <div>
            <span>重量</span>
            <span>${m.grossWeight}kg</span>
          </div>
          <div>
            <span>长度</span>
            <span>${m.length}mm</span>
          </div>
          <div>
            <span>数量</span>
            <span>${m.quantity}</span>
          </div>
          <div>
            <span>单元</span>
            <span>${m.areaName}</span>
          </div>
          ${b(m)}
        </div>
      `;
      d.innerHTML = E, (v = c2.machinePartList.panel) != null && v.isShow && t();
      const U = document.getElementById("bfMPBtn");
      console.log(U, "bfMPBtnDom"), U && U.addEventListener("click", () => {
        l();
      });
      const tt = document.getElementById("bfDrawBtn");
      console.log(tt, "bfDrawBtn"), tt && tt.addEventListener("click", () => {
        B2({ boolBim: w.value.boolBim, serialNumber: w.value.serialNumber, productId: w.value.id, productType: w.value.productType, drawingSN: w.value.numbers, monomerId: w.value.monomerId });
      });
      const H = document.getElementById("bfWPBtn");
      H && H.addEventListener("click", () => {
        Q2({ productId: w.value.id, productType: w.value.productType, serialNumber: w.value.serialNumber, monomerId: w.value.monomerId, areaId: w.value.areaId });
      });
    } catch (m) {
      console.log("获取构件信息", m);
    }
  }
  function b(e) {
    switch (f2.value) {
      case modelMenuBarEnum.COMPONENT_TREE.V:
        return `
          <div>
            <span>表面积</span>
            <span>${e.surfaceArea}</span>
          </div>
          <div>
            <span>图纸</span>
            <span id="bfDrawBtn">查看</span>
          </div>
          <div>
            <span>构件树</span>
            <span id="bfMPBtn">查看</span>
          </div>
          <div>
            <span>焊缝</span>
            <span id="bfWPBtn">${e.productWeldCount || 0}（点击查看详情）</span>
          </div>
      `;
      case modelMenuBarEnum.PRODUCTION_STATE.V:
        return `
          <div style="justify-content: center;">
            生产状态（已上报/已质检）
          </div>
          ${r(e.quantity, e.processSummaryDetailsList)}
        `;
      case modelMenuBarEnum.SHIPMENT_STATUS.V:
        return `
          <div>
            <span>表面积</span>
            <span>${e.surfaceArea}</span>
          </div>
          <div>
            <span>焊缝</span>
            <span id="bfWPBtn">${e.productWeldCount || 0}（点击查看详情）</span>
          </div>
        `;
      case modelMenuBarEnum.INSTALL_STATE.V:
        return `
          <div>
            <span>表面积</span>
            <span>${e.surfaceArea}</span>
          </div>
          <div>
            <span>焊缝</span>
            <span id="bfWPBtn">${e.productWeldCount || 0}（点击查看详情）</span>
          </div>
        `;
      default:
        return "";
    }
  }
  function r(e, o) {
    if (!(o != null && o.length)) return '<div style="justify-content: center;">暂无生产信息</div>';
    let v = "";
    for (let m = 0; m < o.length; m++) {
      const d = o[m], U = e === d.completeQuantity && e === d.inspectionQuantity ? "√" : `${d.completeQuantity} / ${d.inspectionQuantity}`;
      v += `
        <div>
          <span>${d.name}</span>
          <span>${U} ${d.userNames ? `(${d.userNames})` : ""}</span>
        </div>
      `;
    }
    return v;
  }
  function n() {
    const e = c2.artifactInfo.panel;
    e.isShow && e.hide();
    const o = c2.machinePartList.panel;
    o.isShow && o.hide();
  }
  return { createArtifactInfoPanel: k2, fetchArtifactInfo: C2, clearArtifactInfoPanel: n, refreshArtifactInfoPanel: h };
}
function useStatusInfo({ props: z2, menuBar: f2, bimModel: $2, viewerPanel: c2, modelStatus: S2, isBridgeProject: q2 }) {
  function B2() {
    const k2 = $2.getPanelConfig();
    k2.className = "bf-panel bf-panel-status-info", k2.css.width = "480px", k2.element = document.getElementsByClassName("bf-container")[0];
    const T2 = $2.createPanel(k2);
    T2.isShow = false, c2.statusInfo = { config: k2, panel: T2 };
  }
  async function Q2() {
    const k2 = c2.statusInfo.panel;
    k2.setTitleContent(modelMenuBarEnum.VL[f2.value]), c2.panelPositions[k2._opt.className] = { left: 10, top: 90 }, k2.initPosition(), console.log(k2, "fetchStatusInfo"), k2 && k2.show();
    try {
      let T2;
      z2.showMonomerModel ? T2 = await getArtifactProduction({ fileId: S2.value.fileId, menuBar: f2.value }) : T2 = await getIntegrateArtifactProduction({ projectId: z2.projectId, menuBar: f2.value });
      const { content: C2 } = T2, l = document.getElementsByClassName("bf-panel-status-info")[0].getElementsByClassName("bf-panel-container")[0];
      l.innerHTML = "", l.innerHTML = `
        <table class="bf-table">
          ${I2(C2)}
        </table>
      `;
    } catch (T2) {
      console.log(T2, "获取生产状态信息");
    }
  }
  function I2(k2) {
    let T2 = "";
    const C2 = modelMenuBarEnum.V[f2.value].COLORS;
    for (let l = 0; l < k2.length; l++) {
      const t = k2[l];
      T2 += `
      <tbody class="bf-group">
        <tr class="bf-group-title">
          <td colspan="2">
            <i class="bf-icon"></i>
            ${z2.showMonomerModel ? t.areaName : t.monomerName}
          </td>
          ${y2(C2, "title")}
        </tr>
        <tr class="bf-group-content">
          <td>构件数量（件）</td>
          <td>${t.quantity}</td>
          ${y2(C2, "qField", t)}
        </tr>
        <tr class="bf-group-content">
          <td>构件重量（kg）</td>
          <td>${t.totalGrossWeight}</td>
          ${y2(C2, "wField", t)}
        </tr>
      </tbody>
    `;
    }
    return T2;
  }
  function y2(k2, T2, C2) {
    let l = "";
    for (let t = 0; t < k2.length; t++) {
      const s = k2[t];
      l += `
          <td>${C2 ? C2[s[T2]] : s[T2]}</td>
    `;
    }
    return l;
  }
  function w() {
    const k2 = c2.artifactInfo.panel;
    if (k2.isShow && k2.hide(), [modelMenuBarEnum.PRODUCTION_STATE.V, modelMenuBarEnum.INSTALL_STATE.V, modelMenuBarEnum.SHIPMENT_STATUS.V].indexOf(f2.value) !== -1) return;
    const T2 = c2.statusInfo.panel;
    T2.isShow && T2.hide();
  }
  return { createStatusInfoPanel: B2, fetchStatusInfo: Q2, clearStatusInfoPanel: w };
}
function useLogisticsInfo({ props: z2, bimModel: f2, modelStatus: $2, viewerPanel: c2, monomerId: S2, addBlinkByIds: q2, removeBlink: B2, isBridgeProject: Q2 }) {
  const I2 = ref([]);
  function y2() {
    let h = document.getElementById("bfLogisticsBtn");
    if (h) h.style = "display:block;";
    else {
      const b = document.getElementsByClassName("bf-container")[0];
      h = document.createElement("div"), h.id = "bfLogisticsBtn", h.innerHTML = `
        <button class="el-button el-button--info el-button--default bf-artifact-search-btn-r" type="button">
        <span>物流信息</span>
        </button>
      `, b.append(h), w(), h && h.addEventListener("click", () => {
        T2();
      });
    }
  }
  function w() {
    const h = f2.getPanelConfig();
    h.className = "bf-panel bf-panel-logistics-info", h.title = "物流详情", h.css.width = "350px", h.css.height = "300px", h.element = document.getElementsByClassName("bf-container")[0];
    const b = f2.createPanel(h);
    b.isShow = false, c2.logistics = { config: h, panel: b }, k2();
  }
  function k2() {
    const h = f2.getPanelConfig();
    h.className = "bf-panel bf-panel-shipment", h.title = "发运清单", h.css.width = "300px", h.css.height = "280px", h.element = document.getElementsByClassName("bf-container")[0];
    const b = f2.createPanel(h);
    b.isShow = false, c2.shipment = { config: h, panel: b };
  }
  async function T2() {
    const h = c2.logistics.panel;
    c2.panelPositions[h._opt.className] = { left: 900, top: 20 }, h.initPosition(), h && h.show();
    try {
      let b;
      z2.showMonomerModel ? b = await getLogistics({ fileId: $2.value.fileId }) : b = await getIntegrateLogistics({ projectId: z2.projectId });
      const { content: r } = b;
      I2.value = r;
      const n = document.querySelector(".bf-panel-logistics-info .bf-panel-container");
      n.innerHTML = "", n.innerHTML = `
        <div class="bf-panel-logistics-info-container">
          <div>
            <span>序号</span>
            <span>车牌/船牌号</span>
            <span>车次/船次</span>
            <span>发运日期</span>
          </div>
          ${C2(r)}
        </div>
      `, l();
    } catch (b) {
      console.log(b);
    }
  }
  function C2(h) {
    let b = "";
    for (let r = 0; r < h.length; r++) {
      const n = h[r];
      b += `
        <div class="bf-panel-logistics-li" style="cursor:pointer;" data-index="${r}">
          <span>${r + 1}</span>
          <span>${n.licensePlate}</span>
          <span>${n.serialNumber}</span>
          <span>${parseTime(n.auditTime, "{y}-{m}-{d}")}</span>
        </div>
      `;
    }
    return b;
  }
  function l() {
    const h = document.getElementsByClassName("bf-panel-logistics-li");
    for (let b = 0; b < h.length; b++) h[b].onclick = () => {
      const r = h[b].dataset.index;
      q2(I2.value[r].elementIds), t(I2.value[r].bimLogisticsLinkVOList);
    };
  }
  function t(h) {
    const b = c2.shipment.panel, r = c2.logistics.panel, { css: n, className: e } = r._opt;
    c2.panelPositions[b._opt.className] = { left: c2.panelPositions[e].left + Number(n.width.slice(0, -2)) + 10, top: c2.panelPositions[e].top }, b.initPosition(), b && b.show();
    const o = document.querySelector(".bf-panel-shipment .bf-panel-container");
    o.innerHTML = "", o.innerHTML = `
      <div class="bf-panel-shipment-container">
        <div>
          <span>序号</span>
          <span>名称</span>
          <span>编号</span>
          <span>数量</span>
        </div>
        ${s(h)}
      </div>
    `;
  }
  function s(h) {
    let b = "";
    for (let r = 0; r < h.length; r++) {
      const n = h[r];
      b += `
        <div>
          <span>${r + 1}</span>
          <span>${n.name}</span>
          <span>${n.serialNumber}</span>
          <span>${n.quantity}</span>
        </div>
      `;
    }
    return b;
  }
  function a() {
    const h = document.getElementById("bfLogisticsBtn");
    h.style = "display:none;", B2();
    const b = c2.logistics.panel;
    b.isShow && b.hide();
    const r = c2.shipment.panel;
    r.isShow && r.hide();
  }
  return { createLogisticsBtn: y2, hideLogisticsBtn: a };
}
const _sfc_main$2 = { __name: "bf-draw", props: { handleClose: { type: Function }, showDraw: { type: Boolean, default: false }, boolBim: { type: Boolean, default: false }, serialNumber: { type: String, default: void 0 }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, drawingSN: { type: Number, default: void 0 }, monomerId: { type: [Number, String], default: void 0 } }, setup(z2) {
  const f2 = ref(false), $2 = z2;
  return watch(() => $2.showDraw, (c2) => {
    c2 && (f2.value = true);
  }), watch(() => f2.value, (c2) => {
    c2 || typeof $2.handleClose == "function" && $2.handleClose();
  }), (c2, S2) => (openBlock(), createBlock(unref(_sfc_main$4), { modelValue: f2.value, "onUpdate:modelValue": S2[0] || (S2[0] = (q2) => f2.value = q2), "bool-bim": z2.boolBim, "serial-number": z2.serialNumber, productId: z2.productId, productType: z2.productType, drawingSN: z2.drawingSN, monomerId: z2.monomerId }, null, 8, ["modelValue", "bool-bim", "serial-number", "productId", "productType", "drawingSN", "monomerId"]));
} };
function useDrawing() {
  const z2 = ref();
  function f2() {
    z2.value = createApp(_sfc_main$2);
    const S2 = document.querySelector(".bf-container"), q2 = document.createElement("div");
    q2.id = "bfDrawingView", S2.appendChild(q2), z2.value.mount("#bfDrawingView", { serialNumber: void 0, productId: void 0, productType: void 0, monomerId: void 0 }), console.log(z2, "drawingApp");
  }
  function $2() {
    z2.value._container._vnode.component.props.showDraw = false;
  }
  function c2({ boolBim: S2, serialNumber: q2, productId: B2, productType: Q2, drawingSN: I2, monomerId: y2 }) {
    z2.value._container._vnode.component.props.handleClose = $2, z2.value._container._vnode.component.props.showDraw = true, z2.value._container._vnode.component.props.boolBim = S2, z2.value._container._vnode.component.props.serialNumber = q2, z2.value._container._vnode.component.props.productId = B2, z2.value._container._vnode.component.props.productType = Q2, z2.value._container._vnode.component.props.drawingSN = I2, z2.value._container._vnode.component.props.monomerId = y2;
  }
  return { createDrawing: f2, fetchDrawing: c2 };
}
function getProductList(z2) {
  return service({ module: "plan", url: "CappCraftProductPassTaskRecord/product/list", method: "get", params: z2 });
}
function getCodeList(z2) {
  return service({ module: "plan", url: "CappCraftProductPassTaskRecord/product/code/number/list", method: "get", params: z2 });
}
function getWeldingList(z2) {
  return service({ module: "plan", url: "CappCraftProductPassTaskRecord/welding/list", method: "get", params: z2 });
}
function getVoltageList(z2) {
  return service({ module: "plan", url: "CappCraftProductPassTaskRecord/product/current/voltage", method: "get", params: z2 });
}
var pdf = { exports: {} };
(function(module, exports) {
  (function(f2, $2) {
    module.exports = $2();
  })(globalThis, () => (() => {
    var __webpack_modules__ = [, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.VerbosityLevel = f2.Util = f2.UnknownErrorException = f2.UnexpectedResponseException = f2.UNSUPPORTED_FEATURES = f2.TextRenderingMode = f2.StreamType = f2.RenderingIntentFlag = f2.PermissionFlag = f2.PasswordResponses = f2.PasswordException = f2.PageActionEventType = f2.OPS = f2.MissingPDFException = f2.LINE_FACTOR = f2.LINE_DESCENT_FACTOR = f2.InvalidPDFException = f2.ImageKind = f2.IDENTITY_MATRIX = f2.FormatError = f2.FontType = f2.FeatureTest = f2.FONT_IDENTITY_MATRIX = f2.DocumentActionEventType = f2.CMapCompressionType = f2.BaseException = f2.AnnotationType = f2.AnnotationStateModelType = f2.AnnotationReviewState = f2.AnnotationReplyType = f2.AnnotationMode = f2.AnnotationMarkedState = f2.AnnotationFlag = f2.AnnotationFieldFlag = f2.AnnotationEditorType = f2.AnnotationEditorPrefix = f2.AnnotationEditorParamsType = f2.AnnotationBorderStyleType = f2.AnnotationActionEventType = f2.AbortException = void 0, f2.arrayByteLength = st, f2.arraysToBytes = it, f2.assert = p, f2.bytesToString = x, f2.createPromiseCapability = pt, f2.createValidAbsoluteUrl = P, f2.escapeString = wt, f2.getModificationDate = lt, f2.getVerbosityLevel = at, f2.info = dt, f2.isArrayBuffer = Ft, f2.isArrayEqual = Zt, f2.isAscii = It, f2.objectFromMap = et, f2.objectSize = rt, f2.setVerbosityLevel = X, f2.shadow = F, f2.string32 = J, f2.stringToBytes = L, f2.stringToPDFString = Ct, f2.stringToUTF16BEString = Rt, f2.stringToUTF8String = $t, f2.unreachable = N, f2.utf8StringToString = Et, f2.warn = bt, $2(2);
      const c2 = [1, 0, 0, 1, 0, 0];
      f2.IDENTITY_MATRIX = c2;
      const S2 = [1e-3, 0, 0, 1e-3, 0, 0];
      f2.FONT_IDENTITY_MATRIX = S2;
      const q2 = 1.35;
      f2.LINE_FACTOR = q2;
      const B2 = 0.35;
      f2.LINE_DESCENT_FACTOR = B2;
      const Q2 = { ANY: 1, DISPLAY: 2, PRINT: 4, ANNOTATIONS_FORMS: 16, ANNOTATIONS_STORAGE: 32, ANNOTATIONS_DISABLE: 64, OPLIST: 256 };
      f2.RenderingIntentFlag = Q2;
      const I2 = { DISABLE: 0, ENABLE: 1, ENABLE_FORMS: 2, ENABLE_STORAGE: 3 };
      f2.AnnotationMode = I2;
      const y2 = "pdfjs_internal_editor_";
      f2.AnnotationEditorPrefix = y2;
      const w = { DISABLE: -1, NONE: 0, FREETEXT: 3, INK: 15 };
      f2.AnnotationEditorType = w;
      const k2 = { FREETEXT_SIZE: 1, FREETEXT_COLOR: 2, FREETEXT_OPACITY: 3, INK_COLOR: 11, INK_THICKNESS: 12, INK_OPACITY: 13 };
      f2.AnnotationEditorParamsType = k2;
      const T2 = { PRINT: 4, MODIFY_CONTENTS: 8, COPY: 16, MODIFY_ANNOTATIONS: 32, FILL_INTERACTIVE_FORMS: 256, COPY_FOR_ACCESSIBILITY: 512, ASSEMBLE: 1024, PRINT_HIGH_QUALITY: 2048 };
      f2.PermissionFlag = T2;
      const C2 = { FILL: 0, STROKE: 1, FILL_STROKE: 2, INVISIBLE: 3, FILL_ADD_TO_PATH: 4, STROKE_ADD_TO_PATH: 5, FILL_STROKE_ADD_TO_PATH: 6, ADD_TO_PATH: 7, FILL_STROKE_MASK: 3, ADD_TO_PATH_FLAG: 4 };
      f2.TextRenderingMode = C2;
      const l = { GRAYSCALE_1BPP: 1, RGB_24BPP: 2, RGBA_32BPP: 3 };
      f2.ImageKind = l;
      const t = { TEXT: 1, LINK: 2, FREETEXT: 3, LINE: 4, SQUARE: 5, CIRCLE: 6, POLYGON: 7, POLYLINE: 8, HIGHLIGHT: 9, UNDERLINE: 10, SQUIGGLY: 11, STRIKEOUT: 12, STAMP: 13, CARET: 14, INK: 15, POPUP: 16, FILEATTACHMENT: 17, SOUND: 18, MOVIE: 19, WIDGET: 20, SCREEN: 21, PRINTERMARK: 22, TRAPNET: 23, WATERMARK: 24, THREED: 25, REDACT: 26 };
      f2.AnnotationType = t;
      const s = { MARKED: "Marked", REVIEW: "Review" };
      f2.AnnotationStateModelType = s;
      const a = { MARKED: "Marked", UNMARKED: "Unmarked" };
      f2.AnnotationMarkedState = a;
      const h = { ACCEPTED: "Accepted", REJECTED: "Rejected", CANCELLED: "Cancelled", COMPLETED: "Completed", NONE: "None" };
      f2.AnnotationReviewState = h;
      const b = { GROUP: "Group", REPLY: "R" };
      f2.AnnotationReplyType = b;
      const r = { INVISIBLE: 1, HIDDEN: 2, PRINT: 4, NOZOOM: 8, NOROTATE: 16, NOVIEW: 32, READONLY: 64, LOCKED: 128, TOGGLENOVIEW: 256, LOCKEDCONTENTS: 512 };
      f2.AnnotationFlag = r;
      const n = { READONLY: 1, REQUIRED: 2, NOEXPORT: 4, MULTILINE: 4096, PASSWORD: 8192, NOTOGGLETOOFF: 16384, RADIO: 32768, PUSHBUTTON: 65536, COMBO: 131072, EDIT: 262144, SORT: 524288, FILESELECT: 1048576, MULTISELECT: 2097152, DONOTSPELLCHECK: 4194304, DONOTSCROLL: 8388608, COMB: 16777216, RICHTEXT: 33554432, RADIOSINUNISON: 33554432, COMMITONSELCHANGE: 67108864 };
      f2.AnnotationFieldFlag = n;
      const e = { SOLID: 1, DASHED: 2, BEVELED: 3, INSET: 4, UNDERLINE: 5 };
      f2.AnnotationBorderStyleType = e;
      const o = { E: "Mouse Enter", X: "Mouse Exit", D: "Mouse Down", U: "Mouse Up", Fo: "Focus", Bl: "Blur", PO: "PageOpen", PC: "PageClose", PV: "PageVisible", PI: "PageInvisible", K: "Keystroke", F: "Format", V: "Validate", C: "Calculate" };
      f2.AnnotationActionEventType = o;
      const v = { WC: "WillClose", WS: "WillSave", DS: "DidSave", WP: "WillPrint", DP: "DidPrint" };
      f2.DocumentActionEventType = v;
      const m = { O: "PageOpen", C: "PageClose" };
      f2.PageActionEventType = m;
      const d = { UNKNOWN: "UNKNOWN", FLATE: "FLATE", LZW: "LZW", DCT: "DCT", JPX: "JPX", JBIG: "JBIG", A85: "A85", AHX: "AHX", CCF: "CCF", RLX: "RLX" };
      f2.StreamType = d;
      const E = { UNKNOWN: "UNKNOWN", TYPE1: "TYPE1", TYPE1STANDARD: "TYPE1STANDARD", TYPE1C: "TYPE1C", CIDFONTTYPE0: "CIDFONTTYPE0", CIDFONTTYPE0C: "CIDFONTTYPE0C", TRUETYPE: "TRUETYPE", CIDFONTTYPE2: "CIDFONTTYPE2", TYPE3: "TYPE3", OPENTYPE: "OPENTYPE", TYPE0: "TYPE0", MMTYPE1: "MMTYPE1" };
      f2.FontType = E;
      const U = { ERRORS: 0, WARNINGS: 1, INFOS: 5 };
      f2.VerbosityLevel = U;
      const tt = { NONE: 0, BINARY: 1, STREAM: 2 };
      f2.CMapCompressionType = tt;
      const H = { dependency: 1, setLineWidth: 2, setLineCap: 3, setLineJoin: 4, setMiterLimit: 5, setDash: 6, setRenderingIntent: 7, setFlatness: 8, setGState: 9, save: 10, restore: 11, transform: 12, moveTo: 13, lineTo: 14, curveTo: 15, curveTo2: 16, curveTo3: 17, closePath: 18, rectangle: 19, stroke: 20, closeStroke: 21, fill: 22, eoFill: 23, fillStroke: 24, eoFillStroke: 25, closeFillStroke: 26, closeEOFillStroke: 27, endPath: 28, clip: 29, eoClip: 30, beginText: 31, endText: 32, setCharSpacing: 33, setWordSpacing: 34, setHScale: 35, setLeading: 36, setFont: 37, setTextRenderingMode: 38, setTextRise: 39, moveText: 40, setLeadingMoveText: 41, setTextMatrix: 42, nextLine: 43, showText: 44, showSpacedText: 45, nextLineShowText: 46, nextLineSetSpacingShowText: 47, setCharWidth: 48, setCharWidthAndBounds: 49, setStrokeColorSpace: 50, setFillColorSpace: 51, setStrokeColor: 52, setStrokeColorN: 53, setFillColor: 54, setFillColorN: 55, setStrokeGray: 56, setFillGray: 57, setStrokeRGBColor: 58, setFillRGBColor: 59, setStrokeCMYKColor: 60, setFillCMYKColor: 61, shadingFill: 62, beginInlineImage: 63, beginImageData: 64, endInlineImage: 65, paintXObject: 66, markPoint: 67, markPointProps: 68, beginMarkedContent: 69, beginMarkedContentProps: 70, endMarkedContent: 71, beginCompat: 72, endCompat: 73, paintFormXObjectBegin: 74, paintFormXObjectEnd: 75, beginGroup: 76, endGroup: 77, beginAnnotations: 78, endAnnotations: 79, beginAnnotation: 80, endAnnotation: 81, paintJpegXObject: 82, paintImageMaskXObject: 83, paintImageMaskXObjectGroup: 84, paintImageXObject: 85, paintInlineImageXObject: 86, paintInlineImageXObjectGroup: 87, paintImageXObjectRepeat: 88, paintImageMaskXObjectRepeat: 89, paintSolidColorImageMask: 90, constructPath: 91 };
      f2.OPS = H;
      const Z = { unknown: "unknown", forms: "forms", javaScript: "javaScript", signatures: "signatures", smask: "smask", shadingPattern: "shadingPattern", font: "font", errorTilingPattern: "errorTilingPattern", errorExtGState: "errorExtGState", errorXObject: "errorXObject", errorFontLoadType3: "errorFontLoadType3", errorFontState: "errorFontState", errorFontMissing: "errorFontMissing", errorFontTranslate: "errorFontTranslate", errorColorSpace: "errorColorSpace", errorOperatorList: "errorOperatorList", errorFontToUnicode: "errorFontToUnicode", errorFontLoadNative: "errorFontLoadNative", errorFontBuildPath: "errorFontBuildPath", errorFontGetPath: "errorFontGetPath", errorMarkedContent: "errorMarkedContent", errorContentSubStream: "errorContentSubStream" };
      f2.UNSUPPORTED_FEATURES = Z;
      const j = { NEED_PASSWORD: 1, INCORRECT_PASSWORD: 2 };
      f2.PasswordResponses = j;
      let V = U.WARNINGS;
      function X(nt) {
        Number.isInteger(nt) && (V = nt);
      }
      function at() {
        return V;
      }
      function dt(nt) {
        V >= U.INFOS && console.log(`Info: ${nt}`);
      }
      function bt(nt) {
        V >= U.WARNINGS && console.log(`Warning: ${nt}`);
      }
      function N(nt) {
        throw new Error(nt);
      }
      function p(nt, W) {
        nt || N(W);
      }
      function u(nt) {
        if (!nt) return false;
        switch (nt.protocol) {
          case "http:":
          case "https:":
          case "ftp:":
          case "mailto:":
          case "tel:":
            return true;
          default:
            return false;
        }
      }
      function P(nt, W = null, G = null) {
        if (!nt) return null;
        try {
          if (G && typeof nt == "string") {
            if (G.addDefaultProtocol && nt.startsWith("www.")) {
              const _t = nt.match(/\./g);
              _t && _t.length >= 2 && (nt = `http://${nt}`);
            }
            if (G.tryConvertEncoding) try {
              nt = $t(nt);
            } catch {
            }
          }
          const gt = W ? new URL(nt, W) : new URL(nt);
          if (u(gt)) return gt;
        } catch {
        }
        return null;
      }
      function F(nt, W, G) {
        return Object.defineProperty(nt, W, { value: G, enumerable: true, configurable: true, writable: false }), G;
      }
      const D = (function() {
        function W(G, gt) {
          this.constructor === W && N("Cannot initialize BaseException."), this.message = G, this.name = gt;
        }
        return W.prototype = new Error(), W.constructor = W, W;
      })();
      f2.BaseException = D;
      class O extends D {
        constructor(W, G) {
          super(W, "PasswordException"), this.code = G;
        }
      }
      f2.PasswordException = O;
      class Y extends D {
        constructor(W, G) {
          super(W, "UnknownErrorException"), this.details = G;
        }
      }
      f2.UnknownErrorException = Y;
      class K extends D {
        constructor(W) {
          super(W, "InvalidPDFException");
        }
      }
      f2.InvalidPDFException = K;
      class i extends D {
        constructor(W) {
          super(W, "MissingPDFException");
        }
      }
      f2.MissingPDFException = i;
      class _ extends D {
        constructor(W, G) {
          super(W, "UnexpectedResponseException"), this.status = G;
        }
      }
      f2.UnexpectedResponseException = _;
      class g extends D {
        constructor(W) {
          super(W, "FormatError");
        }
      }
      f2.FormatError = g;
      class A extends D {
        constructor(W) {
          super(W, "AbortException");
        }
      }
      f2.AbortException = A;
      function x(nt) {
        (typeof nt != "object" || nt === null || nt.length === void 0) && N("Invalid argument for bytesToString");
        const W = nt.length, G = 8192;
        if (W < G) return String.fromCharCode.apply(null, nt);
        const gt = [];
        for (let _t = 0; _t < W; _t += G) {
          const At = Math.min(_t + G, W), St = nt.subarray(_t, At);
          gt.push(String.fromCharCode.apply(null, St));
        }
        return gt.join("");
      }
      function L(nt) {
        typeof nt != "string" && N("Invalid argument for stringToBytes");
        const W = nt.length, G = new Uint8Array(W);
        for (let gt = 0; gt < W; ++gt) G[gt] = nt.charCodeAt(gt) & 255;
        return G;
      }
      function st(nt) {
        if (nt.length !== void 0) return nt.length;
        if (nt.byteLength !== void 0) return nt.byteLength;
        N("Invalid argument for arrayByteLength");
      }
      function it(nt) {
        const W = nt.length;
        if (W === 1 && nt[0] instanceof Uint8Array) return nt[0];
        let G = 0;
        for (let At = 0; At < W; At++) G += st(nt[At]);
        let gt = 0;
        const _t = new Uint8Array(G);
        for (let At = 0; At < W; At++) {
          let St = nt[At];
          St instanceof Uint8Array || (typeof St == "string" ? St = L(St) : St = new Uint8Array(St));
          const xt = St.byteLength;
          _t.set(St, gt), gt += xt;
        }
        return _t;
      }
      function J(nt) {
        return String.fromCharCode(nt >> 24 & 255, nt >> 16 & 255, nt >> 8 & 255, nt & 255);
      }
      function rt(nt) {
        return Object.keys(nt).length;
      }
      function et(nt) {
        const W = /* @__PURE__ */ Object.create(null);
        for (const [G, gt] of nt) W[G] = gt;
        return W;
      }
      function ot() {
        const nt = new Uint8Array(4);
        return nt[0] = 1, new Uint32Array(nt.buffer, 0, 1)[0] === 1;
      }
      function ut() {
        try {
          return new Function(""), true;
        } catch {
          return false;
        }
      }
      class M {
        static get isLittleEndian() {
          return F(this, "isLittleEndian", ot());
        }
        static get isEvalSupported() {
          return F(this, "isEvalSupported", ut());
        }
        static get isOffscreenCanvasSupported() {
          return F(this, "isOffscreenCanvasSupported", typeof OffscreenCanvas < "u");
        }
      }
      f2.FeatureTest = M;
      const ht = [...Array(256).keys()].map((nt) => nt.toString(16).padStart(2, "0"));
      class yt {
        static makeHexColor(W, G, gt) {
          return `#${ht[W]}${ht[G]}${ht[gt]}`;
        }
        static scaleMinMax(W, G) {
          let gt;
          W[0] ? (W[0] < 0 && (gt = G[0], G[0] = G[1], G[1] = gt), G[0] *= W[0], G[1] *= W[0], W[3] < 0 && (gt = G[2], G[2] = G[3], G[3] = gt), G[2] *= W[3], G[3] *= W[3]) : (gt = G[0], G[0] = G[2], G[2] = gt, gt = G[1], G[1] = G[3], G[3] = gt, W[1] < 0 && (gt = G[2], G[2] = G[3], G[3] = gt), G[2] *= W[1], G[3] *= W[1], W[2] < 0 && (gt = G[0], G[0] = G[1], G[1] = gt), G[0] *= W[2], G[1] *= W[2]), G[0] += W[4], G[1] += W[4], G[2] += W[5], G[3] += W[5];
        }
        static transform(W, G) {
          return [W[0] * G[0] + W[2] * G[1], W[1] * G[0] + W[3] * G[1], W[0] * G[2] + W[2] * G[3], W[1] * G[2] + W[3] * G[3], W[0] * G[4] + W[2] * G[5] + W[4], W[1] * G[4] + W[3] * G[5] + W[5]];
        }
        static applyTransform(W, G) {
          const gt = W[0] * G[0] + W[1] * G[2] + G[4], _t = W[0] * G[1] + W[1] * G[3] + G[5];
          return [gt, _t];
        }
        static applyInverseTransform(W, G) {
          const gt = G[0] * G[3] - G[1] * G[2], _t = (W[0] * G[3] - W[1] * G[2] + G[2] * G[5] - G[4] * G[3]) / gt, At = (-W[0] * G[1] + W[1] * G[0] + G[4] * G[1] - G[5] * G[0]) / gt;
          return [_t, At];
        }
        static getAxialAlignedBoundingBox(W, G) {
          const gt = yt.applyTransform(W, G), _t = yt.applyTransform(W.slice(2, 4), G), At = yt.applyTransform([W[0], W[3]], G), St = yt.applyTransform([W[2], W[1]], G);
          return [Math.min(gt[0], _t[0], At[0], St[0]), Math.min(gt[1], _t[1], At[1], St[1]), Math.max(gt[0], _t[0], At[0], St[0]), Math.max(gt[1], _t[1], At[1], St[1])];
        }
        static inverseTransform(W) {
          const G = W[0] * W[3] - W[1] * W[2];
          return [W[3] / G, -W[1] / G, -W[2] / G, W[0] / G, (W[2] * W[5] - W[4] * W[3]) / G, (W[4] * W[1] - W[5] * W[0]) / G];
        }
        static apply3dTransform(W, G) {
          return [W[0] * G[0] + W[1] * G[1] + W[2] * G[2], W[3] * G[0] + W[4] * G[1] + W[5] * G[2], W[6] * G[0] + W[7] * G[1] + W[8] * G[2]];
        }
        static singularValueDecompose2dScale(W) {
          const G = [W[0], W[2], W[1], W[3]], gt = W[0] * G[0] + W[1] * G[2], _t = W[0] * G[1] + W[1] * G[3], At = W[2] * G[0] + W[3] * G[2], St = W[2] * G[1] + W[3] * G[3], xt = (gt + St) / 2, Dt = Math.sqrt((gt + St) ** 2 - 4 * (gt * St - At * _t)) / 2, kt = xt + Dt || 1, Tt = xt - Dt || 1;
          return [Math.sqrt(kt), Math.sqrt(Tt)];
        }
        static normalizeRect(W) {
          const G = W.slice(0);
          return W[0] > W[2] && (G[0] = W[2], G[2] = W[0]), W[1] > W[3] && (G[1] = W[3], G[3] = W[1]), G;
        }
        static intersect(W, G) {
          const gt = Math.max(Math.min(W[0], W[2]), Math.min(G[0], G[2])), _t = Math.min(Math.max(W[0], W[2]), Math.max(G[0], G[2]));
          if (gt > _t) return null;
          const At = Math.max(Math.min(W[1], W[3]), Math.min(G[1], G[3])), St = Math.min(Math.max(W[1], W[3]), Math.max(G[1], G[3]));
          return At > St ? null : [gt, At, _t, St];
        }
        static bezierBoundingBox(W, G, gt, _t, At, St, xt, Dt) {
          const kt = [], Tt = [[], []];
          let Ot, Lt, jt, Pt, Nt, Wt, Gt, zt;
          for (let Xt = 0; Xt < 2; ++Xt) {
            if (Xt === 0 ? (Lt = 6 * W - 12 * gt + 6 * At, Ot = -3 * W + 9 * gt - 9 * At + 3 * xt, jt = 3 * gt - 3 * W) : (Lt = 6 * G - 12 * _t + 6 * St, Ot = -3 * G + 9 * _t - 9 * St + 3 * Dt, jt = 3 * _t - 3 * G), Math.abs(Ot) < 1e-12) {
              if (Math.abs(Lt) < 1e-12) continue;
              Pt = -jt / Lt, 0 < Pt && Pt < 1 && kt.push(Pt);
              continue;
            }
            Gt = Lt * Lt - 4 * jt * Ot, zt = Math.sqrt(Gt), !(Gt < 0) && (Nt = (-Lt + zt) / (2 * Ot), 0 < Nt && Nt < 1 && kt.push(Nt), Wt = (-Lt - zt) / (2 * Ot), 0 < Wt && Wt < 1 && kt.push(Wt));
          }
          let Ht = kt.length, Bt;
          const Vt = Ht;
          for (; Ht--; ) Pt = kt[Ht], Bt = 1 - Pt, Tt[0][Ht] = Bt * Bt * Bt * W + 3 * Bt * Bt * Pt * gt + 3 * Bt * Pt * Pt * At + Pt * Pt * Pt * xt, Tt[1][Ht] = Bt * Bt * Bt * G + 3 * Bt * Bt * Pt * _t + 3 * Bt * Pt * Pt * St + Pt * Pt * Pt * Dt;
          return Tt[0][Vt] = W, Tt[1][Vt] = G, Tt[0][Vt + 1] = xt, Tt[1][Vt + 1] = Dt, Tt[0].length = Tt[1].length = Vt + 2, [Math.min(...Tt[0]), Math.min(...Tt[1]), Math.max(...Tt[0]), Math.max(...Tt[1])];
        }
      }
      f2.Util = yt;
      const vt = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 728, 711, 710, 729, 733, 731, 730, 732, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8226, 8224, 8225, 8230, 8212, 8211, 402, 8260, 8249, 8250, 8722, 8240, 8222, 8220, 8221, 8216, 8217, 8218, 8482, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 0, 8364];
      function Ct(nt) {
        if (nt[0] >= "ï") {
          let G;
          if (nt[0] === "þ" && nt[1] === "ÿ" ? G = "utf-16be" : nt[0] === "ÿ" && nt[1] === "þ" ? G = "utf-16le" : nt[0] === "ï" && nt[1] === "»" && nt[2] === "¿" && (G = "utf-8"), G) try {
            const gt = new TextDecoder(G, { fatal: true }), _t = L(nt);
            return gt.decode(_t);
          } catch (gt) {
            bt(`stringToPDFString: "${gt}".`);
          }
        }
        const W = [];
        for (let G = 0, gt = nt.length; G < gt; G++) {
          const _t = vt[nt.charCodeAt(G)];
          W.push(_t ? String.fromCharCode(_t) : nt.charAt(G));
        }
        return W.join("");
      }
      function wt(nt) {
        return nt.replace(/([()\\\n\r])/g, (W) => W === `
` ? "\\n" : W === "\r" ? "\\r" : `\\${W}`);
      }
      function It(nt) {
        return /^[\x00-\x7F]*$/.test(nt);
      }
      function Rt(nt) {
        const W = ["þÿ"];
        for (let G = 0, gt = nt.length; G < gt; G++) {
          const _t = nt.charCodeAt(G);
          W.push(String.fromCharCode(_t >> 8 & 255), String.fromCharCode(_t & 255));
        }
        return W.join("");
      }
      function $t(nt) {
        return decodeURIComponent(escape(nt));
      }
      function Et(nt) {
        return unescape(encodeURIComponent(nt));
      }
      function Ft(nt) {
        return typeof nt == "object" && nt !== null && nt.byteLength !== void 0;
      }
      function Zt(nt, W) {
        if (nt.length !== W.length) return false;
        for (let G = 0, gt = nt.length; G < gt; G++) if (nt[G] !== W[G]) return false;
        return true;
      }
      function lt(nt = /* @__PURE__ */ new Date()) {
        return [nt.getUTCFullYear().toString(), (nt.getUTCMonth() + 1).toString().padStart(2, "0"), nt.getUTCDate().toString().padStart(2, "0"), nt.getUTCHours().toString().padStart(2, "0"), nt.getUTCMinutes().toString().padStart(2, "0"), nt.getUTCSeconds().toString().padStart(2, "0")].join("");
      }
      function pt() {
        const nt = /* @__PURE__ */ Object.create(null);
        let W = false;
        return Object.defineProperty(nt, "settled", { get() {
          return W;
        } }), nt.promise = new Promise(function(G, gt) {
          nt.resolve = function(_t) {
            W = true, G(_t);
          }, nt.reject = function(_t) {
            W = true, gt(_t);
          };
        }), nt;
      }
    }, (z2, f2, $2) => {
      $2(3);
    }, (z2, f2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.isNodeJS = void 0;
      const $2 = typeof process == "object" && process + "" == "[object process]" && !process.versions.nw && !(process.versions.electron && process.type && process.type !== "browser");
      f2.isNodeJS = $2;
    }, (__unused_webpack_module, exports, __w_pdfjs_require__) => {
      var z, $, c, S, q, B, Q, I, y, oe, k, T;
      Object.defineProperty(exports, "__esModule", { value: true }), exports.build = exports.RenderTask = exports.PDFWorkerUtil = exports.PDFWorker = exports.PDFPageProxy = exports.PDFDocumentProxy = exports.PDFDocumentLoadingTask = exports.PDFDataRangeTransport = exports.LoopbackPort = exports.DefaultStandardFontDataFactory = exports.DefaultCanvasFactory = exports.DefaultCMapReaderFactory = void 0, exports.getDocument = getDocument, exports.setPDFNetworkStreamFactory = setPDFNetworkStreamFactory, exports.version = void 0;
      var _util = __w_pdfjs_require__(1), _annotation_storage = __w_pdfjs_require__(5), _display_utils = __w_pdfjs_require__(8), _font_loader = __w_pdfjs_require__(11), _canvas = __w_pdfjs_require__(12), _worker_options = __w_pdfjs_require__(15), _is_node = __w_pdfjs_require__(3), _message_handler = __w_pdfjs_require__(16), _metadata = __w_pdfjs_require__(17), _optional_content_config = __w_pdfjs_require__(18), _transport_stream = __w_pdfjs_require__(19), _xfa_text = __w_pdfjs_require__(20);
      const DEFAULT_RANGE_CHUNK_SIZE = 65536, RENDERING_CANCELLED_TIMEOUT = 100;
      let DefaultCanvasFactory = _display_utils.DOMCanvasFactory;
      exports.DefaultCanvasFactory = DefaultCanvasFactory;
      let DefaultCMapReaderFactory = _display_utils.DOMCMapReaderFactory;
      exports.DefaultCMapReaderFactory = DefaultCMapReaderFactory;
      let DefaultStandardFontDataFactory = _display_utils.DOMStandardFontDataFactory;
      if (exports.DefaultStandardFontDataFactory = DefaultStandardFontDataFactory, _is_node.isNodeJS) {
        const { NodeCanvasFactory: l, NodeCMapReaderFactory: t, NodeStandardFontDataFactory: s } = __w_pdfjs_require__(21);
        exports.DefaultCanvasFactory = DefaultCanvasFactory = l, exports.DefaultCMapReaderFactory = DefaultCMapReaderFactory = t, exports.DefaultStandardFontDataFactory = DefaultStandardFontDataFactory = s;
      }
      let createPDFNetworkStream;
      function setPDFNetworkStreamFactory(l) {
        createPDFNetworkStream = l;
      }
      function getDocument(l) {
        const t = new PDFDocumentLoadingTask();
        let s;
        if (typeof l == "string" || l instanceof URL) s = { url: l };
        else if ((0, _util.isArrayBuffer)(l)) s = { data: l };
        else if (l instanceof PDFDataRangeTransport) s = { range: l };
        else {
          if (typeof l != "object") throw new Error("Invalid parameter in getDocument, need either string, URL, TypedArray, or parameter object.");
          if (!l.url && !l.data && !l.range) throw new Error("Invalid parameter object: need either .data, .range or .url");
          s = l;
        }
        const a = /* @__PURE__ */ Object.create(null);
        let h = null, b = null;
        for (const n in s) {
          const e = s[n];
          switch (n) {
            case "url":
              if (typeof window < "u") try {
                a[n] = new URL(e, window.location).href;
                continue;
              } catch (o) {
                (0, _util.warn)(`Cannot create valid URL: "${o}".`);
              }
              else if (typeof e == "string" || e instanceof URL) {
                a[n] = e.toString();
                continue;
              }
              throw new Error("Invalid PDF url data: either string or URL-object is expected in the url property.");
            case "range":
              h = e;
              continue;
            case "worker":
              b = e;
              continue;
            case "data":
              if (_is_node.isNodeJS && typeof Buffer < "u" && e instanceof Buffer) a[n] = new Uint8Array(e);
              else {
                if (e instanceof Uint8Array) break;
                if (typeof e == "string") a[n] = (0, _util.stringToBytes)(e);
                else if (typeof e == "object" && e !== null && !isNaN(e.length)) a[n] = new Uint8Array(e);
                else if ((0, _util.isArrayBuffer)(e)) a[n] = new Uint8Array(e);
                else throw new Error("Invalid PDF binary data: either TypedArray, string, or array-like object is expected in the data property.");
              }
              continue;
          }
          a[n] = e;
        }
        if (a.CMapReaderFactory = a.CMapReaderFactory || DefaultCMapReaderFactory, a.StandardFontDataFactory = a.StandardFontDataFactory || DefaultStandardFontDataFactory, a.ignoreErrors = a.stopAtErrors !== true, a.fontExtraProperties = a.fontExtraProperties === true, a.pdfBug = a.pdfBug === true, a.enableXfa = a.enableXfa === true, (!Number.isInteger(a.rangeChunkSize) || a.rangeChunkSize < 1) && (a.rangeChunkSize = DEFAULT_RANGE_CHUNK_SIZE), (typeof a.docBaseUrl != "string" || (0, _display_utils.isDataScheme)(a.docBaseUrl)) && (a.docBaseUrl = null), (!Number.isInteger(a.maxImageSize) || a.maxImageSize < -1) && (a.maxImageSize = -1), typeof a.cMapUrl != "string" && (a.cMapUrl = null), typeof a.standardFontDataUrl != "string" && (a.standardFontDataUrl = null), typeof a.useWorkerFetch != "boolean" && (a.useWorkerFetch = a.CMapReaderFactory === _display_utils.DOMCMapReaderFactory && a.StandardFontDataFactory === _display_utils.DOMStandardFontDataFactory), typeof a.isEvalSupported != "boolean" && (a.isEvalSupported = true), typeof a.disableFontFace != "boolean" && (a.disableFontFace = _is_node.isNodeJS), typeof a.useSystemFonts != "boolean" && (a.useSystemFonts = !_is_node.isNodeJS && !a.disableFontFace), (typeof a.ownerDocument != "object" || a.ownerDocument === null) && (a.ownerDocument = globalThis.document), typeof a.disableRange != "boolean" && (a.disableRange = false), typeof a.disableStream != "boolean" && (a.disableStream = false), typeof a.disableAutoFetch != "boolean" && (a.disableAutoFetch = false), (0, _util.setVerbosityLevel)(a.verbosity), !b) {
          const n = { verbosity: a.verbosity, port: _worker_options.GlobalWorkerOptions.workerPort };
          b = n.port ? PDFWorker.fromPort(n) : new PDFWorker(n), t._worker = b;
        }
        const r = t.docId;
        return b.promise.then(function() {
          if (t.destroyed) throw new Error("Loading aborted");
          const n = _fetchDocument(b, a, h, r), e = new Promise(function(o) {
            let v;
            h ? v = new _transport_stream.PDFDataTransportStream({ length: a.length, initialData: a.initialData, progressiveDone: a.progressiveDone, contentDispositionFilename: a.contentDispositionFilename, disableRange: a.disableRange, disableStream: a.disableStream }, h) : a.data || (v = createPDFNetworkStream({ url: a.url, length: a.length, httpHeaders: a.httpHeaders, withCredentials: a.withCredentials, rangeChunkSize: a.rangeChunkSize, disableRange: a.disableRange, disableStream: a.disableStream })), o(v);
          });
          return Promise.all([n, e]).then(function([o, v]) {
            if (t.destroyed) throw new Error("Loading aborted");
            const m = new _message_handler.MessageHandler(r, o, b.port), d = new WorkerTransport(m, t, v, a);
            t._transport = d, m.send("Ready", null);
          });
        }).catch(t._capability.reject), t;
      }
      async function _fetchDocument(l, t, s, a) {
        if (l.destroyed) throw new Error("Worker was destroyed");
        s && (t.length = s.length, t.initialData = s.initialData, t.progressiveDone = s.progressiveDone, t.contentDispositionFilename = s.contentDispositionFilename);
        const h = await l.messageHandler.sendWithPromise("GetDocRequest", { docId: a, apiVersion: "2.16.105", source: { data: t.data, url: t.url, password: t.password, disableAutoFetch: t.disableAutoFetch, rangeChunkSize: t.rangeChunkSize, length: t.length }, maxImageSize: t.maxImageSize, disableFontFace: t.disableFontFace, docBaseUrl: t.docBaseUrl, ignoreErrors: t.ignoreErrors, isEvalSupported: t.isEvalSupported, fontExtraProperties: t.fontExtraProperties, enableXfa: t.enableXfa, useSystemFonts: t.useSystemFonts, cMapUrl: t.useWorkerFetch ? t.cMapUrl : null, standardFontDataUrl: t.useWorkerFetch ? t.standardFontDataUrl : null });
        if (t.data && (t.data = null), l.destroyed) throw new Error("Worker was destroyed");
        return h;
      }
      const f = class f2 {
        constructor() {
          this._capability = (0, _util.createPromiseCapability)(), this._transport = null, this._worker = null, this.docId = `d${re(f2, z)._++}`, this.destroyed = false, this.onPassword = null, this.onProgress = null, this.onUnsupportedFeature = null;
        }
        get promise() {
          return this._capability.promise;
        }
        async destroy() {
          var t;
          this.destroyed = true, await ((t = this._transport) == null ? void 0 : t.destroy()), this._transport = null, this._worker && (this._worker.destroy(), this._worker = null);
        }
      };
      z = /* @__PURE__ */ new WeakMap(), ct(f, z, 0);
      let PDFDocumentLoadingTask = f;
      exports.PDFDocumentLoadingTask = PDFDocumentLoadingTask;
      class PDFDataRangeTransport {
        constructor(t, s, a = false, h = null) {
          this.length = t, this.initialData = s, this.progressiveDone = a, this.contentDispositionFilename = h, this._rangeListeners = [], this._progressListeners = [], this._progressiveReadListeners = [], this._progressiveDoneListeners = [], this._readyCapability = (0, _util.createPromiseCapability)();
        }
        addRangeListener(t) {
          this._rangeListeners.push(t);
        }
        addProgressListener(t) {
          this._progressListeners.push(t);
        }
        addProgressiveReadListener(t) {
          this._progressiveReadListeners.push(t);
        }
        addProgressiveDoneListener(t) {
          this._progressiveDoneListeners.push(t);
        }
        onDataRange(t, s) {
          for (const a of this._rangeListeners) a(t, s);
        }
        onDataProgress(t, s) {
          this._readyCapability.promise.then(() => {
            for (const a of this._progressListeners) a(t, s);
          });
        }
        onDataProgressiveRead(t) {
          this._readyCapability.promise.then(() => {
            for (const s of this._progressiveReadListeners) s(t);
          });
        }
        onDataProgressiveDone() {
          this._readyCapability.promise.then(() => {
            for (const t of this._progressiveDoneListeners) t();
          });
        }
        transportReady() {
          this._readyCapability.resolve();
        }
        requestDataRange(t, s) {
          (0, _util.unreachable)("Abstract method PDFDataRangeTransport.requestDataRange");
        }
        abort() {
        }
      }
      exports.PDFDataRangeTransport = PDFDataRangeTransport;
      class PDFDocumentProxy {
        constructor(t, s) {
          this._pdfInfo = t, this._transport = s, Object.defineProperty(this, "fingerprint", { get() {
            return (0, _display_utils.deprecated)("`PDFDocumentProxy.fingerprint`, please use `PDFDocumentProxy.fingerprints` instead."), this.fingerprints[0];
          } }), Object.defineProperty(this, "getStats", { value: async () => ((0, _display_utils.deprecated)("`PDFDocumentProxy.getStats`, please use the `PDFDocumentProxy.stats`-getter instead."), this.stats || { streamTypes: {}, fontTypes: {} }) });
        }
        get annotationStorage() {
          return this._transport.annotationStorage;
        }
        get numPages() {
          return this._pdfInfo.numPages;
        }
        get fingerprints() {
          return this._pdfInfo.fingerprints;
        }
        get stats() {
          return this._transport.stats;
        }
        get isPureXfa() {
          return !!this._transport._htmlForXfa;
        }
        get allXfaHtml() {
          return this._transport._htmlForXfa;
        }
        getPage(t) {
          return this._transport.getPage(t);
        }
        getPageIndex(t) {
          return this._transport.getPageIndex(t);
        }
        getDestinations() {
          return this._transport.getDestinations();
        }
        getDestination(t) {
          return this._transport.getDestination(t);
        }
        getPageLabels() {
          return this._transport.getPageLabels();
        }
        getPageLayout() {
          return this._transport.getPageLayout();
        }
        getPageMode() {
          return this._transport.getPageMode();
        }
        getViewerPreferences() {
          return this._transport.getViewerPreferences();
        }
        getOpenAction() {
          return this._transport.getOpenAction();
        }
        getAttachments() {
          return this._transport.getAttachments();
        }
        getJavaScript() {
          return this._transport.getJavaScript();
        }
        getJSActions() {
          return this._transport.getDocJSActions();
        }
        getOutline() {
          return this._transport.getOutline();
        }
        getOptionalContentConfig() {
          return this._transport.getOptionalContentConfig();
        }
        getPermissions() {
          return this._transport.getPermissions();
        }
        getMetadata() {
          return this._transport.getMetadata();
        }
        getMarkInfo() {
          return this._transport.getMarkInfo();
        }
        getData() {
          return this._transport.getData();
        }
        getDownloadInfo() {
          return this._transport.downloadInfoCapability.promise;
        }
        cleanup(t = false) {
          return this._transport.startCleanup(t || this.isPureXfa);
        }
        destroy() {
          return this.loadingTask.destroy();
        }
        get loadingParams() {
          return this._transport.loadingParams;
        }
        get loadingTask() {
          return this._transport.loadingTask;
        }
        saveDocument() {
          return this._transport.annotationStorage.size <= 0 && (0, _display_utils.deprecated)("saveDocument called while `annotationStorage` is empty, please use the getData-method instead."), this._transport.saveDocument();
        }
        getFieldObjects() {
          return this._transport.getFieldObjects();
        }
        hasJSActions() {
          return this._transport.hasJSActions();
        }
        getCalculationOrderIds() {
          return this._transport.getCalculationOrderIds();
        }
      }
      exports.PDFDocumentProxy = PDFDocumentProxy;
      class PDFPageProxy {
        constructor(t, s, a, h, b = false) {
          this._pageIndex = t, this._pageInfo = s, this._ownerDocument = h, this._transport = a, this._stats = b ? new _display_utils.StatTimer() : null, this._pdfBug = b, this.commonObjs = a.commonObjs, this.objs = new PDFObjects(), this._bitmaps = /* @__PURE__ */ new Set(), this.cleanupAfterRender = false, this.pendingCleanup = false, this._intentStates = /* @__PURE__ */ new Map(), this._annotationPromises = /* @__PURE__ */ new Map(), this.destroyed = false;
        }
        get pageNumber() {
          return this._pageIndex + 1;
        }
        get rotate() {
          return this._pageInfo.rotate;
        }
        get ref() {
          return this._pageInfo.ref;
        }
        get userUnit() {
          return this._pageInfo.userUnit;
        }
        get view() {
          return this._pageInfo.view;
        }
        getViewport({ scale: t, rotation: s = this.rotate, offsetX: a = 0, offsetY: h = 0, dontFlip: b = false } = {}) {
          return new _display_utils.PageViewport({ viewBox: this.view, scale: t, rotation: s, offsetX: a, offsetY: h, dontFlip: b });
        }
        getAnnotations({ intent: t = "display" } = {}) {
          const s = this._transport.getRenderingIntent(t);
          let a = this._annotationPromises.get(s.cacheKey);
          return a || (a = this._transport.getAnnotations(this._pageIndex, s.renderingIntent), this._annotationPromises.set(s.cacheKey, a), a = a.then((h) => {
            for (const b of h) b.titleObj !== void 0 && Object.defineProperty(b, "title", { get() {
              return (0, _display_utils.deprecated)("`title`-property on annotation, please use `titleObj` instead."), b.titleObj.str;
            } }), b.contentsObj !== void 0 && Object.defineProperty(b, "contents", { get() {
              return (0, _display_utils.deprecated)("`contents`-property on annotation, please use `contentsObj` instead."), b.contentsObj.str;
            } });
            return h;
          })), a;
        }
        getJSActions() {
          return this._jsActionsPromise || (this._jsActionsPromise = this._transport.getPageJSActions(this._pageIndex));
        }
        async getXfa() {
          var t;
          return ((t = this._transport._htmlForXfa) == null ? void 0 : t.children[this._pageIndex]) || null;
        }
        render({ canvasContext: t, viewport: s, intent: a = "display", annotationMode: h = _util.AnnotationMode.ENABLE, transform: b = null, imageLayer: r = null, canvasFactory: n = null, background: e = null, optionalContentConfigPromise: o = null, annotationCanvasMap: v = null, pageColors: m = null, printAnnotationStorage: d = null }) {
          var X, at;
          ((X = arguments[0]) == null ? void 0 : X.renderInteractiveForms) !== void 0 && ((0, _display_utils.deprecated)("render no longer accepts the `renderInteractiveForms`-option, please use the `annotationMode`-option instead."), arguments[0].renderInteractiveForms === true && h === _util.AnnotationMode.ENABLE && (h = _util.AnnotationMode.ENABLE_FORMS)), ((at = arguments[0]) == null ? void 0 : at.includeAnnotationStorage) !== void 0 && ((0, _display_utils.deprecated)("render no longer accepts the `includeAnnotationStorage`-option, please use the `annotationMode`-option instead."), arguments[0].includeAnnotationStorage === true && h === _util.AnnotationMode.ENABLE && (h = _util.AnnotationMode.ENABLE_STORAGE)), this._stats && this._stats.time("Overall");
          const E = this._transport.getRenderingIntent(a, h, d);
          this.pendingCleanup = false, o || (o = this._transport.getOptionalContentConfig());
          let U = this._intentStates.get(E.cacheKey);
          U || (U = /* @__PURE__ */ Object.create(null), this._intentStates.set(E.cacheKey, U)), U.streamReaderCancelTimeout && (clearTimeout(U.streamReaderCancelTimeout), U.streamReaderCancelTimeout = null);
          const tt = n || new DefaultCanvasFactory({ ownerDocument: this._ownerDocument }), H = !!(E.renderingIntent & _util.RenderingIntentFlag.PRINT);
          U.displayReadyCapability || (U.displayReadyCapability = (0, _util.createPromiseCapability)(), U.operatorList = { fnArray: [], argsArray: [], lastChunk: false, separateAnnots: null }, this._stats && this._stats.time("Page Request"), this._pumpOperatorList(E));
          const Z = (dt) => {
            U.renderTasks.delete(j), (this.cleanupAfterRender || H) && (this.pendingCleanup = true), this._tryCleanup(), dt ? (j.capability.reject(dt), this._abortOperatorList({ intentState: U, reason: dt instanceof Error ? dt : new Error(dt) })) : j.capability.resolve(), this._stats && (this._stats.timeEnd("Rendering"), this._stats.timeEnd("Overall"));
          }, j = new InternalRenderTask({ callback: Z, params: { canvasContext: t, viewport: s, transform: b, imageLayer: r, background: e }, objs: this.objs, commonObjs: this.commonObjs, annotationCanvasMap: v, operatorList: U.operatorList, pageIndex: this._pageIndex, canvasFactory: tt, useRequestAnimationFrame: !H, pdfBug: this._pdfBug, pageColors: m });
          (U.renderTasks || (U.renderTasks = /* @__PURE__ */ new Set())).add(j);
          const V = j.task;
          return Promise.all([U.displayReadyCapability.promise, o]).then(([dt, bt]) => {
            if (this.pendingCleanup) {
              Z();
              return;
            }
            this._stats && this._stats.time("Rendering"), j.initializeGraphics({ transparency: dt, optionalContentConfig: bt }), j.operatorListChanged();
          }).catch(Z), V;
        }
        getOperatorList({ intent: t = "display", annotationMode: s = _util.AnnotationMode.ENABLE, printAnnotationStorage: a = null } = {}) {
          function h() {
            r.operatorList.lastChunk && (r.opListReadCapability.resolve(r.operatorList), r.renderTasks.delete(n));
          }
          const b = this._transport.getRenderingIntent(t, s, a, true);
          let r = this._intentStates.get(b.cacheKey);
          r || (r = /* @__PURE__ */ Object.create(null), this._intentStates.set(b.cacheKey, r));
          let n;
          return r.opListReadCapability || (n = /* @__PURE__ */ Object.create(null), n.operatorListChanged = h, r.opListReadCapability = (0, _util.createPromiseCapability)(), (r.renderTasks || (r.renderTasks = /* @__PURE__ */ new Set())).add(n), r.operatorList = { fnArray: [], argsArray: [], lastChunk: false, separateAnnots: null }, this._stats && this._stats.time("Page Request"), this._pumpOperatorList(b)), r.opListReadCapability.promise;
        }
        streamTextContent({ disableCombineTextItems: t = false, includeMarkedContent: s = false } = {}) {
          return this._transport.messageHandler.sendWithStream("GetTextContent", { pageIndex: this._pageIndex, combineTextItems: t !== true, includeMarkedContent: s === true }, { highWaterMark: 100, size(h) {
            return h.items.length;
          } });
        }
        getTextContent(t = {}) {
          if (this._transport._htmlForXfa) return this.getXfa().then((a) => _xfa_text.XfaText.textContent(a));
          const s = this.streamTextContent(t);
          return new Promise(function(a, h) {
            function b() {
              r.read().then(function({ value: e, done: o }) {
                if (o) {
                  a(n);
                  return;
                }
                Object.assign(n.styles, e.styles), n.items.push(...e.items), b();
              }, h);
            }
            const r = s.getReader(), n = { items: [], styles: /* @__PURE__ */ Object.create(null) };
            b();
          });
        }
        getStructTree() {
          return this._structTreePromise || (this._structTreePromise = this._transport.getStructTree(this._pageIndex));
        }
        _destroy() {
          this.destroyed = true;
          const t = [];
          for (const s of this._intentStates.values()) if (this._abortOperatorList({ intentState: s, reason: new Error("Page was destroyed."), force: true }), !s.opListReadCapability) for (const a of s.renderTasks) t.push(a.completed), a.cancel();
          this.objs.clear();
          for (const s of this._bitmaps) s.close();
          return this._bitmaps.clear(), this._annotationPromises.clear(), this._jsActionsPromise = null, this._structTreePromise = null, this.pendingCleanup = false, Promise.all(t);
        }
        cleanup(t = false) {
          return this.pendingCleanup = true, this._tryCleanup(t);
        }
        _tryCleanup(t = false) {
          if (!this.pendingCleanup) return false;
          for (const { renderTasks: s, operatorList: a } of this._intentStates.values()) if (s.size > 0 || !a.lastChunk) return false;
          this._intentStates.clear(), this.objs.clear(), this._annotationPromises.clear(), this._jsActionsPromise = null, this._structTreePromise = null, t && this._stats && (this._stats = new _display_utils.StatTimer());
          for (const s of this._bitmaps) s.close();
          return this._bitmaps.clear(), this.pendingCleanup = false, true;
        }
        _startRenderPage(t, s) {
          const a = this._intentStates.get(s);
          a && (this._stats && this._stats.timeEnd("Page Request"), a.displayReadyCapability && a.displayReadyCapability.resolve(t));
        }
        _renderPageChunk(t, s) {
          for (let a = 0, h = t.length; a < h; a++) s.operatorList.fnArray.push(t.fnArray[a]), s.operatorList.argsArray.push(t.argsArray[a]);
          s.operatorList.lastChunk = t.lastChunk, s.operatorList.separateAnnots = t.separateAnnots;
          for (const a of s.renderTasks) a.operatorListChanged();
          t.lastChunk && this._tryCleanup();
        }
        _pumpOperatorList({ renderingIntent: t, cacheKey: s, annotationStorageMap: a }) {
          const b = this._transport.messageHandler.sendWithStream("GetOperatorList", { pageIndex: this._pageIndex, intent: t, cacheKey: s, annotationStorage: a }).getReader(), r = this._intentStates.get(s);
          r.streamReader = b;
          const n = () => {
            b.read().then(({ value: e, done: o }) => {
              if (o) {
                r.streamReader = null;
                return;
              }
              this._transport.destroyed || (this._renderPageChunk(e, r), n());
            }, (e) => {
              if (r.streamReader = null, !this._transport.destroyed) {
                if (r.operatorList) {
                  r.operatorList.lastChunk = true;
                  for (const o of r.renderTasks) o.operatorListChanged();
                  this._tryCleanup();
                }
                if (r.displayReadyCapability) r.displayReadyCapability.reject(e);
                else if (r.opListReadCapability) r.opListReadCapability.reject(e);
                else throw e;
              }
            });
          };
          n();
        }
        _abortOperatorList({ intentState: t, reason: s, force: a = false }) {
          if (t.streamReader) {
            if (!a) {
              if (t.renderTasks.size > 0) return;
              if (s instanceof _display_utils.RenderingCancelledException) {
                t.streamReaderCancelTimeout = setTimeout(() => {
                  this._abortOperatorList({ intentState: t, reason: s, force: true }), t.streamReaderCancelTimeout = null;
                }, RENDERING_CANCELLED_TIMEOUT);
                return;
              }
            }
            if (t.streamReader.cancel(new _util.AbortException(s.message)).catch(() => {
            }), t.streamReader = null, !this._transport.destroyed) {
              for (const [h, b] of this._intentStates) if (b === t) {
                this._intentStates.delete(h);
                break;
              }
              this.cleanup();
            }
          }
        }
        get stats() {
          return this._stats;
        }
      }
      exports.PDFPageProxy = PDFPageProxy;
      class LoopbackPort {
        constructor() {
          this._listeners = [], this._deferred = Promise.resolve();
        }
        postMessage(t, s) {
          const a = { data: structuredClone(t, s) };
          this._deferred.then(() => {
            for (const h of this._listeners) h.call(this, a);
          });
        }
        addEventListener(t, s) {
          this._listeners.push(s);
        }
        removeEventListener(t, s) {
          const a = this._listeners.indexOf(s);
          this._listeners.splice(a, 1);
        }
        terminate() {
          this._listeners.length = 0;
        }
      }
      exports.LoopbackPort = LoopbackPort;
      const PDFWorkerUtil = { isWorkerDisabled: false, fallbackWorkerSrc: null, fakeWorkerId: 0 };
      exports.PDFWorkerUtil = PDFWorkerUtil;
      {
        if (_is_node.isNodeJS && typeof commonjsRequire == "function") PDFWorkerUtil.isWorkerDisabled = true, PDFWorkerUtil.fallbackWorkerSrc = "./pdf.worker.js";
        else if (typeof document == "object") {
          const l = ($ = document == null ? void 0 : document.currentScript) == null ? void 0 : $.src;
          l && (PDFWorkerUtil.fallbackWorkerSrc = l.replace(/(\.(?:min\.)?js)(\?.*)?$/i, ".worker$1$2"));
        }
        PDFWorkerUtil.isSameOrigin = function(l, t) {
          let s;
          try {
            if (s = new URL(l), !s.origin || s.origin === "null") return false;
          } catch {
            return false;
          }
          const a = new URL(t, s);
          return s.origin === a.origin;
        }, PDFWorkerUtil.createCDNWrapper = function(l) {
          const t = `importScripts("${l}");`;
          return URL.createObjectURL(new Blob([t]));
        };
      }
      const _PDFWorker = class ____PDFWorker {
        constructor({ name: l = null, port: t = null, verbosity: s = (0, _util.getVerbosityLevel)() } = {}) {
          if (t && R(____PDFWorker, c).has(t)) throw new Error("Cannot use more than one PDFWorker per port.");
          if (this.name = l, this.destroyed = false, this.verbosity = s, this._readyCapability = (0, _util.createPromiseCapability)(), this._port = null, this._webWorker = null, this._messageHandler = null, t) {
            R(____PDFWorker, c).set(t, this), this._initializeFromPort(t);
            return;
          }
          this._initialize();
        }
        get promise() {
          return this._readyCapability.promise;
        }
        get port() {
          return this._port;
        }
        get messageHandler() {
          return this._messageHandler;
        }
        _initializeFromPort(l) {
          this._port = l, this._messageHandler = new _message_handler.MessageHandler("main", "worker", l), this._messageHandler.on("ready", function() {
          }), this._readyCapability.resolve();
        }
        _initialize() {
          if (!PDFWorkerUtil.isWorkerDisabled && !____PDFWorker._mainThreadWorkerMessageHandler) {
            let { workerSrc: l } = ____PDFWorker;
            try {
              PDFWorkerUtil.isSameOrigin(window.location.href, l) || (l = PDFWorkerUtil.createCDNWrapper(new URL(l, window.location).href));
              const t = new Worker(l), s = new _message_handler.MessageHandler("main", "worker", t), a = () => {
                t.removeEventListener("error", h), s.destroy(), t.terminate(), this.destroyed ? this._readyCapability.reject(new Error("Worker was destroyed")) : this._setupFakeWorker();
              }, h = () => {
                this._webWorker || a();
              };
              t.addEventListener("error", h), s.on("test", (r) => {
                if (t.removeEventListener("error", h), this.destroyed) {
                  a();
                  return;
                }
                r ? (this._messageHandler = s, this._port = t, this._webWorker = t, this._readyCapability.resolve(), s.send("configure", { verbosity: this.verbosity })) : (this._setupFakeWorker(), s.destroy(), t.terminate());
              }), s.on("ready", (r) => {
                if (t.removeEventListener("error", h), this.destroyed) {
                  a();
                  return;
                }
                try {
                  b();
                } catch {
                  this._setupFakeWorker();
                }
              });
              const b = () => {
                const r = new Uint8Array();
                s.send("test", r, [r.buffer]);
              };
              b();
              return;
            } catch {
              (0, _util.info)("The worker has been disabled.");
            }
          }
          this._setupFakeWorker();
        }
        _setupFakeWorker() {
          PDFWorkerUtil.isWorkerDisabled || ((0, _util.warn)("Setting up fake worker."), PDFWorkerUtil.isWorkerDisabled = true), ____PDFWorker._setupFakeWorkerGlobal.then((l) => {
            if (this.destroyed) {
              this._readyCapability.reject(new Error("Worker was destroyed"));
              return;
            }
            const t = new LoopbackPort();
            this._port = t;
            const s = `fake${PDFWorkerUtil.fakeWorkerId++}`, a = new _message_handler.MessageHandler(s + "_worker", s, t);
            l.setup(a, t);
            const h = new _message_handler.MessageHandler(s, s + "_worker", t);
            this._messageHandler = h, this._readyCapability.resolve(), h.send("configure", { verbosity: this.verbosity });
          }).catch((l) => {
            this._readyCapability.reject(new Error(`Setting up fake worker failed: "${l.message}".`));
          });
        }
        destroy() {
          this.destroyed = true, this._webWorker && (this._webWorker.terminate(), this._webWorker = null), R(____PDFWorker, c).delete(this._port), this._port = null, this._messageHandler && (this._messageHandler.destroy(), this._messageHandler = null);
        }
        static fromPort(l) {
          if (!(l != null && l.port)) throw new Error("PDFWorker.fromPort - invalid method signature.");
          return R(this, c).has(l.port) ? R(this, c).get(l.port) : new ____PDFWorker(l);
        }
        static get workerSrc() {
          if (_worker_options.GlobalWorkerOptions.workerSrc) return _worker_options.GlobalWorkerOptions.workerSrc;
          if (PDFWorkerUtil.fallbackWorkerSrc !== null) return _is_node.isNodeJS || (0, _display_utils.deprecated)('No "GlobalWorkerOptions.workerSrc" specified.'), PDFWorkerUtil.fallbackWorkerSrc;
          throw new Error('No "GlobalWorkerOptions.workerSrc" specified.');
        }
        static get _mainThreadWorkerMessageHandler() {
          var l;
          try {
            return ((l = globalThis.pdfjsWorker) == null ? void 0 : l.WorkerMessageHandler) || null;
          } catch {
            return null;
          }
        }
        static get _setupFakeWorkerGlobal() {
          const loader = async () => {
            const mainWorkerMessageHandler = this._mainThreadWorkerMessageHandler;
            if (mainWorkerMessageHandler) return mainWorkerMessageHandler;
            if (_is_node.isNodeJS && typeof commonjsRequire == "function") {
              const worker = eval("require")(this.workerSrc);
              return worker.WorkerMessageHandler;
            }
            return await (0, _display_utils.loadScript)(this.workerSrc), window.pdfjsWorker.WorkerMessageHandler;
          };
          return (0, _util.shadow)(this, "_setupFakeWorkerGlobal", loader());
        }
      };
      c = /* @__PURE__ */ new WeakMap(), ct(_PDFWorker, c, /* @__PURE__ */ new WeakMap());
      let PDFWorker = _PDFWorker;
      exports.PDFWorker = PDFWorker, PDFWorker.getWorkerSrc = function() {
        return (0, _display_utils.deprecated)("`PDFWorker.getWorkerSrc()`, please use `PDFWorker.workerSrc` instead."), this.workerSrc;
      };
      class WorkerTransport {
        constructor(t, s, a, h) {
          ct(this, S, null);
          ct(this, q, /* @__PURE__ */ new Map());
          ct(this, B, /* @__PURE__ */ new Map());
          ct(this, Q, null);
          this.messageHandler = t, this.loadingTask = s, this.commonObjs = new PDFObjects(), this.fontLoader = new _font_loader.FontLoader({ docId: s.docId, onUnsupportedFeature: this._onUnsupportedFeature.bind(this), ownerDocument: h.ownerDocument, styleElement: h.styleElement }), this._params = h, h.useWorkerFetch || (this.CMapReaderFactory = new h.CMapReaderFactory({ baseUrl: h.cMapUrl, isCompressed: h.cMapPacked }), this.StandardFontDataFactory = new h.StandardFontDataFactory({ baseUrl: h.standardFontDataUrl })), this.destroyed = false, this.destroyCapability = null, this._passwordCapability = null, this._networkStream = a, this._fullReader = null, this._lastProgress = null, this.downloadInfoCapability = (0, _util.createPromiseCapability)(), this.setupMessageHandler();
        }
        get annotationStorage() {
          return (0, _util.shadow)(this, "annotationStorage", new _annotation_storage.AnnotationStorage());
        }
        get stats() {
          return R(this, S);
        }
        getRenderingIntent(t, s = _util.AnnotationMode.ENABLE, a = null, h = false) {
          let b = _util.RenderingIntentFlag.DISPLAY, r = null;
          switch (t) {
            case "any":
              b = _util.RenderingIntentFlag.ANY;
              break;
            case "display":
              break;
            case "print":
              b = _util.RenderingIntentFlag.PRINT;
              break;
            default:
              (0, _util.warn)(`getRenderingIntent - invalid intent: ${t}`);
          }
          switch (s) {
            case _util.AnnotationMode.DISABLE:
              b += _util.RenderingIntentFlag.ANNOTATIONS_DISABLE;
              break;
            case _util.AnnotationMode.ENABLE:
              break;
            case _util.AnnotationMode.ENABLE_FORMS:
              b += _util.RenderingIntentFlag.ANNOTATIONS_FORMS;
              break;
            case _util.AnnotationMode.ENABLE_STORAGE:
              b += _util.RenderingIntentFlag.ANNOTATIONS_STORAGE, r = (b & _util.RenderingIntentFlag.PRINT && a instanceof _annotation_storage.PrintAnnotationStorage ? a : this.annotationStorage).serializable;
              break;
            default:
              (0, _util.warn)(`getRenderingIntent - invalid annotationMode: ${s}`);
          }
          return h && (b += _util.RenderingIntentFlag.OPLIST), { renderingIntent: b, cacheKey: `${b}_${_annotation_storage.AnnotationStorage.getHash(r)}`, annotationStorageMap: r };
        }
        destroy() {
          if (this.destroyCapability) return this.destroyCapability.promise;
          this.destroyed = true, this.destroyCapability = (0, _util.createPromiseCapability)(), this._passwordCapability && this._passwordCapability.reject(new Error("Worker was destroyed during onPassword callback"));
          const t = [];
          for (const a of R(this, q).values()) t.push(a._destroy());
          R(this, q).clear(), R(this, B).clear(), this.hasOwnProperty("annotationStorage") && this.annotationStorage.resetModified();
          const s = this.messageHandler.sendWithPromise("Terminate", null);
          return t.push(s), Promise.all(t).then(() => {
            this.commonObjs.clear(), this.fontLoader.clear(), mt(this, Q, null), this._getFieldObjectsPromise = null, this._hasJSActionsPromise = null, this._networkStream && this._networkStream.cancelAllRequests(new _util.AbortException("Worker was terminated.")), this.messageHandler && (this.messageHandler.destroy(), this.messageHandler = null), this.destroyCapability.resolve();
          }, this.destroyCapability.reject), this.destroyCapability.promise;
        }
        setupMessageHandler() {
          const { messageHandler: t, loadingTask: s } = this;
          t.on("GetReader", (a, h) => {
            (0, _util.assert)(this._networkStream, "GetReader - no `IPDFStream` instance available."), this._fullReader = this._networkStream.getFullReader(), this._fullReader.onProgress = (b) => {
              this._lastProgress = { loaded: b.loaded, total: b.total };
            }, h.onPull = () => {
              this._fullReader.read().then(function({ value: b, done: r }) {
                if (r) {
                  h.close();
                  return;
                }
                (0, _util.assert)((0, _util.isArrayBuffer)(b), "GetReader - expected an ArrayBuffer."), h.enqueue(new Uint8Array(b), 1, [b]);
              }).catch((b) => {
                h.error(b);
              });
            }, h.onCancel = (b) => {
              this._fullReader.cancel(b), h.ready.catch((r) => {
                if (!this.destroyed) throw r;
              });
            };
          }), t.on("ReaderHeadersReady", (a) => {
            const h = (0, _util.createPromiseCapability)(), b = this._fullReader;
            return b.headersReady.then(() => {
              var r;
              (!b.isStreamingSupported || !b.isRangeSupported) && (this._lastProgress && ((r = s.onProgress) == null || r.call(s, this._lastProgress)), b.onProgress = (n) => {
                var e;
                (e = s.onProgress) == null || e.call(s, { loaded: n.loaded, total: n.total });
              }), h.resolve({ isStreamingSupported: b.isStreamingSupported, isRangeSupported: b.isRangeSupported, contentLength: b.contentLength });
            }, h.reject), h.promise;
          }), t.on("GetRangeReader", (a, h) => {
            (0, _util.assert)(this._networkStream, "GetRangeReader - no `IPDFStream` instance available.");
            const b = this._networkStream.getRangeReader(a.begin, a.end);
            if (!b) {
              h.close();
              return;
            }
            h.onPull = () => {
              b.read().then(function({ value: r, done: n }) {
                if (n) {
                  h.close();
                  return;
                }
                (0, _util.assert)((0, _util.isArrayBuffer)(r), "GetRangeReader - expected an ArrayBuffer."), h.enqueue(new Uint8Array(r), 1, [r]);
              }).catch((r) => {
                h.error(r);
              });
            }, h.onCancel = (r) => {
              b.cancel(r), h.ready.catch((n) => {
                if (!this.destroyed) throw n;
              });
            };
          }), t.on("GetDoc", ({ pdfInfo: a }) => {
            this._numPages = a.numPages, this._htmlForXfa = a.htmlForXfa, delete a.htmlForXfa, s._capability.resolve(new PDFDocumentProxy(a, this));
          }), t.on("DocException", function(a) {
            let h;
            switch (a.name) {
              case "PasswordException":
                h = new _util.PasswordException(a.message, a.code);
                break;
              case "InvalidPDFException":
                h = new _util.InvalidPDFException(a.message);
                break;
              case "MissingPDFException":
                h = new _util.MissingPDFException(a.message);
                break;
              case "UnexpectedResponseException":
                h = new _util.UnexpectedResponseException(a.message, a.status);
                break;
              case "UnknownErrorException":
                h = new _util.UnknownErrorException(a.message, a.details);
                break;
              default:
                (0, _util.unreachable)("DocException - expected a valid Error.");
            }
            s._capability.reject(h);
          }), t.on("PasswordRequest", (a) => {
            if (this._passwordCapability = (0, _util.createPromiseCapability)(), s.onPassword) {
              const h = (b) => {
                b instanceof Error ? this._passwordCapability.reject(b) : this._passwordCapability.resolve({ password: b });
              };
              try {
                s.onPassword(h, a.code);
              } catch (b) {
                this._passwordCapability.reject(b);
              }
            } else this._passwordCapability.reject(new _util.PasswordException(a.message, a.code));
            return this._passwordCapability.promise;
          }), t.on("DataLoaded", (a) => {
            var h;
            (h = s.onProgress) == null || h.call(s, { loaded: a.length, total: a.length }), this.downloadInfoCapability.resolve(a);
          }), t.on("StartRenderPage", (a) => {
            if (this.destroyed) return;
            R(this, q).get(a.pageIndex)._startRenderPage(a.transparency, a.cacheKey);
          }), t.on("commonobj", ([a, h, b]) => {
            var r;
            if (!this.destroyed && !this.commonObjs.has(a)) switch (h) {
              case "Font":
                const n = this._params;
                if ("error" in b) {
                  const v = b.error;
                  (0, _util.warn)(`Error during font loading: ${v}`), this.commonObjs.resolve(a, v);
                  break;
                }
                let e = null;
                n.pdfBug && ((r = globalThis.FontInspector) != null && r.enabled) && (e = { registerFont(v, m) {
                  globalThis.FontInspector.fontAdded(v, m);
                } });
                const o = new _font_loader.FontFaceObject(b, { isEvalSupported: n.isEvalSupported, disableFontFace: n.disableFontFace, ignoreErrors: n.ignoreErrors, onUnsupportedFeature: this._onUnsupportedFeature.bind(this), fontRegistry: e });
                this.fontLoader.bind(o).catch((v) => t.sendWithPromise("FontFallback", { id: a })).finally(() => {
                  !n.fontExtraProperties && o.data && (o.data = null), this.commonObjs.resolve(a, o);
                });
                break;
              case "FontPath":
              case "Image":
                this.commonObjs.resolve(a, b);
                break;
              default:
                throw new Error(`Got unknown common object type ${h}`);
            }
          }), t.on("obj", ([a, h, b, r]) => {
            var e;
            if (this.destroyed) return;
            const n = R(this, q).get(h);
            if (!n.objs.has(a)) switch (b) {
              case "Image":
                n.objs.resolve(a, r);
                const o = 8e6;
                if (r) {
                  let v;
                  if (r.bitmap) {
                    const { bitmap: m, width: d, height: E } = r;
                    v = d * E * 4, n._bitmaps.add(m);
                  } else v = ((e = r.data) == null ? void 0 : e.length) || 0;
                  v > o && (n.cleanupAfterRender = true);
                }
                break;
              case "Pattern":
                n.objs.resolve(a, r);
                break;
              default:
                throw new Error(`Got unknown object type ${b}`);
            }
          }), t.on("DocProgress", (a) => {
            var h;
            this.destroyed || (h = s.onProgress) == null || h.call(s, { loaded: a.loaded, total: a.total });
          }), t.on("DocStats", (a) => {
            this.destroyed || mt(this, S, Object.freeze({ streamTypes: Object.freeze(a.streamTypes), fontTypes: Object.freeze(a.fontTypes) }));
          }), t.on("UnsupportedFeature", this._onUnsupportedFeature.bind(this)), t.on("FetchBuiltInCMap", (a) => this.destroyed ? Promise.reject(new Error("Worker was destroyed.")) : this.CMapReaderFactory ? this.CMapReaderFactory.fetch(a) : Promise.reject(new Error("CMapReaderFactory not initialized, see the `useWorkerFetch` parameter."))), t.on("FetchStandardFontData", (a) => this.destroyed ? Promise.reject(new Error("Worker was destroyed.")) : this.StandardFontDataFactory ? this.StandardFontDataFactory.fetch(a) : Promise.reject(new Error("StandardFontDataFactory not initialized, see the `useWorkerFetch` parameter.")));
        }
        _onUnsupportedFeature({ featureId: t }) {
          var s, a;
          this.destroyed || (a = (s = this.loadingTask).onUnsupportedFeature) == null || a.call(s, t);
        }
        getData() {
          return this.messageHandler.sendWithPromise("GetData", null);
        }
        getPage(t) {
          if (!Number.isInteger(t) || t <= 0 || t > this._numPages) return Promise.reject(new Error("Invalid page request."));
          const s = t - 1, a = R(this, B).get(s);
          if (a) return a;
          const h = this.messageHandler.sendWithPromise("GetPage", { pageIndex: s }).then((b) => {
            if (this.destroyed) throw new Error("Transport destroyed");
            const r = new PDFPageProxy(s, b, this, this._params.ownerDocument, this._params.pdfBug);
            return R(this, q).set(s, r), r;
          });
          return R(this, B).set(s, h), h;
        }
        getPageIndex(t) {
          return typeof t != "object" || t === null || !Number.isInteger(t.num) || t.num < 0 || !Number.isInteger(t.gen) || t.gen < 0 ? Promise.reject(new Error("Invalid pageIndex request.")) : this.messageHandler.sendWithPromise("GetPageIndex", { num: t.num, gen: t.gen });
        }
        getAnnotations(t, s) {
          return this.messageHandler.sendWithPromise("GetAnnotations", { pageIndex: t, intent: s });
        }
        saveDocument() {
          var t;
          return this.messageHandler.sendWithPromise("SaveDocument", { isPureXfa: !!this._htmlForXfa, numPages: this._numPages, annotationStorage: this.annotationStorage.serializable, filename: ((t = this._fullReader) == null ? void 0 : t.filename) ?? null }).finally(() => {
            this.annotationStorage.resetModified();
          });
        }
        getFieldObjects() {
          return this._getFieldObjectsPromise || (this._getFieldObjectsPromise = this.messageHandler.sendWithPromise("GetFieldObjects", null));
        }
        hasJSActions() {
          return this._hasJSActionsPromise || (this._hasJSActionsPromise = this.messageHandler.sendWithPromise("HasJSActions", null));
        }
        getCalculationOrderIds() {
          return this.messageHandler.sendWithPromise("GetCalculationOrderIds", null);
        }
        getDestinations() {
          return this.messageHandler.sendWithPromise("GetDestinations", null);
        }
        getDestination(t) {
          return typeof t != "string" ? Promise.reject(new Error("Invalid destination request.")) : this.messageHandler.sendWithPromise("GetDestination", { id: t });
        }
        getPageLabels() {
          return this.messageHandler.sendWithPromise("GetPageLabels", null);
        }
        getPageLayout() {
          return this.messageHandler.sendWithPromise("GetPageLayout", null);
        }
        getPageMode() {
          return this.messageHandler.sendWithPromise("GetPageMode", null);
        }
        getViewerPreferences() {
          return this.messageHandler.sendWithPromise("GetViewerPreferences", null);
        }
        getOpenAction() {
          return this.messageHandler.sendWithPromise("GetOpenAction", null);
        }
        getAttachments() {
          return this.messageHandler.sendWithPromise("GetAttachments", null);
        }
        getJavaScript() {
          return this.messageHandler.sendWithPromise("GetJavaScript", null);
        }
        getDocJSActions() {
          return this.messageHandler.sendWithPromise("GetDocJSActions", null);
        }
        getPageJSActions(t) {
          return this.messageHandler.sendWithPromise("GetPageJSActions", { pageIndex: t });
        }
        getStructTree(t) {
          return this.messageHandler.sendWithPromise("GetStructTree", { pageIndex: t });
        }
        getOutline() {
          return this.messageHandler.sendWithPromise("GetOutline", null);
        }
        getOptionalContentConfig() {
          return this.messageHandler.sendWithPromise("GetOptionalContentConfig", null).then((t) => new _optional_content_config.OptionalContentConfig(t));
        }
        getPermissions() {
          return this.messageHandler.sendWithPromise("GetPermissions", null);
        }
        getMetadata() {
          return R(this, Q) || mt(this, Q, this.messageHandler.sendWithPromise("GetMetadata", null).then((t) => {
            var s, a;
            return { info: t[0], metadata: t[1] ? new _metadata.Metadata(t[1]) : null, contentDispositionFilename: ((s = this._fullReader) == null ? void 0 : s.filename) ?? null, contentLength: ((a = this._fullReader) == null ? void 0 : a.contentLength) ?? null };
          }));
        }
        getMarkInfo() {
          return this.messageHandler.sendWithPromise("GetMarkInfo", null);
        }
        async startCleanup(t = false) {
          if (await this.messageHandler.sendWithPromise("Cleanup", null), !this.destroyed) {
            for (const s of R(this, q).values()) if (!s.cleanup()) throw new Error(`startCleanup: Page ${s.pageNumber} is currently rendering.`);
            this.commonObjs.clear(), t || this.fontLoader.clear(), mt(this, Q, null), this._getFieldObjectsPromise = null, this._hasJSActionsPromise = null;
          }
        }
        get loadingParams() {
          const t = this._params;
          return (0, _util.shadow)(this, "loadingParams", { disableAutoFetch: t.disableAutoFetch, enableXfa: t.enableXfa });
        }
      }
      S = /* @__PURE__ */ new WeakMap(), q = /* @__PURE__ */ new WeakMap(), B = /* @__PURE__ */ new WeakMap(), Q = /* @__PURE__ */ new WeakMap();
      class PDFObjects {
        constructor() {
          ct(this, y);
          ct(this, I, /* @__PURE__ */ Object.create(null));
        }
        get(t, s = null) {
          if (s) {
            const h = ft(this, y, oe).call(this, t);
            return h.capability.promise.then(() => s(h.data)), null;
          }
          const a = R(this, I)[t];
          if (!(a != null && a.capability.settled)) throw new Error(`Requesting object that isn't resolved yet ${t}.`);
          return a.data;
        }
        has(t) {
          const s = R(this, I)[t];
          return (s == null ? void 0 : s.capability.settled) || false;
        }
        resolve(t, s = null) {
          const a = ft(this, y, oe).call(this, t);
          a.data = s, a.capability.resolve();
        }
        clear() {
          mt(this, I, /* @__PURE__ */ Object.create(null));
        }
      }
      I = /* @__PURE__ */ new WeakMap(), y = /* @__PURE__ */ new WeakSet(), oe = function(t) {
        const s = R(this, I)[t];
        return s || (R(this, I)[t] = { capability: (0, _util.createPromiseCapability)(), data: null });
      };
      class RenderTask {
        constructor(t) {
          ct(this, k, null);
          mt(this, k, t), this.onContinue = null;
        }
        get promise() {
          return R(this, k).capability.promise;
        }
        cancel() {
          R(this, k).cancel();
        }
        get separateAnnots() {
          const { separateAnnots: t } = R(this, k).operatorList;
          if (!t) return false;
          const { annotationCanvasMap: s } = R(this, k);
          return t.form || t.canvas && (s == null ? void 0 : s.size) > 0;
        }
      }
      k = /* @__PURE__ */ new WeakMap(), exports.RenderTask = RenderTask;
      const C = class C2 {
        constructor({ callback: t, params: s, objs: a, commonObjs: h, annotationCanvasMap: b, operatorList: r, pageIndex: n, canvasFactory: e, useRequestAnimationFrame: o = false, pdfBug: v = false, pageColors: m = null }) {
          this.callback = t, this.params = s, this.objs = a, this.commonObjs = h, this.annotationCanvasMap = b, this.operatorListIdx = null, this.operatorList = r, this._pageIndex = n, this.canvasFactory = e, this._pdfBug = v, this.pageColors = m, this.running = false, this.graphicsReadyCallback = null, this.graphicsReady = false, this._useRequestAnimationFrame = o === true && typeof window < "u", this.cancelled = false, this.capability = (0, _util.createPromiseCapability)(), this.task = new RenderTask(this), this._cancelBound = this.cancel.bind(this), this._continueBound = this._continue.bind(this), this._scheduleNextBound = this._scheduleNext.bind(this), this._nextBound = this._next.bind(this), this._canvas = s.canvasContext.canvas;
        }
        get completed() {
          return this.capability.promise.catch(function() {
          });
        }
        initializeGraphics({ transparency: t = false, optionalContentConfig: s }) {
          var e;
          if (this.cancelled) return;
          if (this._canvas) {
            if (R(C2, T).has(this._canvas)) throw new Error("Cannot use the same canvas during multiple render() operations. Use different canvas or ensure previous operations were cancelled or completed.");
            R(C2, T).add(this._canvas);
          }
          this._pdfBug && ((e = globalThis.StepperManager) != null && e.enabled) && (this.stepper = globalThis.StepperManager.create(this._pageIndex), this.stepper.init(this.operatorList), this.stepper.nextBreakPoint = this.stepper.getNextBreakPoint());
          const { canvasContext: a, viewport: h, transform: b, imageLayer: r, background: n } = this.params;
          this.gfx = new _canvas.CanvasGraphics(a, this.commonObjs, this.objs, this.canvasFactory, r, s, this.annotationCanvasMap, this.pageColors), this.gfx.beginDrawing({ transform: b, viewport: h, transparency: t, background: n }), this.operatorListIdx = 0, this.graphicsReady = true, this.graphicsReadyCallback && this.graphicsReadyCallback();
        }
        cancel(t = null) {
          this.running = false, this.cancelled = true, this.gfx && this.gfx.endDrawing(), this._canvas && R(C2, T).delete(this._canvas), this.callback(t || new _display_utils.RenderingCancelledException(`Rendering cancelled, page ${this._pageIndex + 1}`, "canvas"));
        }
        operatorListChanged() {
          if (!this.graphicsReady) {
            this.graphicsReadyCallback || (this.graphicsReadyCallback = this._continueBound);
            return;
          }
          this.stepper && this.stepper.updateOperatorList(this.operatorList), !this.running && this._continue();
        }
        _continue() {
          this.running = true, !this.cancelled && (this.task.onContinue ? this.task.onContinue(this._scheduleNextBound) : this._scheduleNext());
        }
        _scheduleNext() {
          this._useRequestAnimationFrame ? window.requestAnimationFrame(() => {
            this._nextBound().catch(this._cancelBound);
          }) : Promise.resolve().then(this._nextBound).catch(this._cancelBound);
        }
        async _next() {
          this.cancelled || (this.operatorListIdx = this.gfx.executeOperatorList(this.operatorList, this.operatorListIdx, this._continueBound, this.stepper), this.operatorListIdx === this.operatorList.argsArray.length && (this.running = false, this.operatorList.lastChunk && (this.gfx.endDrawing(), this._canvas && R(C2, T).delete(this._canvas), this.callback())));
        }
      };
      T = /* @__PURE__ */ new WeakMap(), ct(C, T, /* @__PURE__ */ new WeakSet());
      let InternalRenderTask = C;
      const version = "2.16.105";
      exports.version = version;
      const build = "172ccdbe5";
      exports.build = build;
    }, (z2, f2, $2) => {
      var I2, Ee, w;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.PrintAnnotationStorage = f2.AnnotationStorage = void 0;
      var c2 = $2(1), S2 = $2(6), q2 = $2(10);
      class B2 {
        constructor() {
          ct(this, I2);
          this._storage = /* @__PURE__ */ new Map(), this._modified = false, this.onSetModified = null, this.onResetModified = null, this.onAnnotationEditor = null;
        }
        getValue(T2, C2) {
          const l = this._storage.get(T2);
          return l === void 0 ? C2 : Object.assign(C2, l);
        }
        getRawValue(T2) {
          return this._storage.get(T2);
        }
        remove(T2) {
          if (this._storage.delete(T2), this._storage.size === 0 && this.resetModified(), typeof this.onAnnotationEditor == "function") {
            for (const C2 of this._storage.values()) if (C2 instanceof S2.AnnotationEditor) return;
            this.onAnnotationEditor(null);
          }
        }
        setValue(T2, C2) {
          const l = this._storage.get(T2);
          let t = false;
          if (l !== void 0) for (const [s, a] of Object.entries(C2)) l[s] !== a && (t = true, l[s] = a);
          else t = true, this._storage.set(T2, C2);
          t && ft(this, I2, Ee).call(this), C2 instanceof S2.AnnotationEditor && typeof this.onAnnotationEditor == "function" && this.onAnnotationEditor(C2.constructor._type);
        }
        has(T2) {
          return this._storage.has(T2);
        }
        getAll() {
          return this._storage.size > 0 ? (0, c2.objectFromMap)(this._storage) : null;
        }
        get size() {
          return this._storage.size;
        }
        resetModified() {
          this._modified && (this._modified = false, typeof this.onResetModified == "function" && this.onResetModified());
        }
        get print() {
          return new Q2(this);
        }
        get serializable() {
          if (this._storage.size === 0) return null;
          const T2 = /* @__PURE__ */ new Map();
          for (const [C2, l] of this._storage) {
            const t = l instanceof S2.AnnotationEditor ? l.serialize() : l;
            t && T2.set(C2, t);
          }
          return T2;
        }
        static getHash(T2) {
          if (!T2) return "";
          const C2 = new q2.MurmurHash3_64();
          for (const [l, t] of T2) C2.update(`${l}:${JSON.stringify(t)}`);
          return C2.hexdigest();
        }
      }
      I2 = /* @__PURE__ */ new WeakSet(), Ee = function() {
        this._modified || (this._modified = true, typeof this.onSetModified == "function" && this.onSetModified());
      }, f2.AnnotationStorage = B2;
      class Q2 extends B2 {
        constructor(C2) {
          super();
          ct(this, w, null);
          mt(this, w, structuredClone(C2.serializable));
        }
        get print() {
          (0, c2.unreachable)("Should not call PrintAnnotationStorage.print");
        }
        get serializable() {
          return R(this, w);
        }
      }
      w = /* @__PURE__ */ new WeakMap(), f2.PrintAnnotationStorage = Q2;
    }, (z2, f2, $2) => {
      var B2, Q2, I2, y2, w, k2;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.AnnotationEditor = void 0;
      var c2 = $2(7), S2 = $2(1);
      const T2 = class T3 {
        constructor(l) {
          ct(this, B2, this.focusin.bind(this));
          ct(this, Q2, this.focusout.bind(this));
          ct(this, I2, false);
          ct(this, y2, false);
          ct(this, w, false);
          ct(this, k2, T3._zIndex++);
          this.constructor === T3 && (0, S2.unreachable)("Cannot initialize AnnotationEditor."), this.parent = l.parent, this.id = l.id, this.width = this.height = null, this.pageIndex = l.parent.pageIndex, this.name = l.name, this.div = null;
          const [t, s] = this.parent.viewportBaseDimensions;
          this.x = l.x / t, this.y = l.y / s, this.rotation = this.parent.viewport.rotation, this.isAttachedToDOM = false;
        }
        static get _defaultLineColor() {
          return (0, S2.shadow)(this, "_defaultLineColor", this._colorManager.getHexCode("CanvasText"));
        }
        setInBackground() {
          this.div.style.zIndex = 0;
        }
        setInForeground() {
          this.div.style.zIndex = R(this, k2);
        }
        focusin(l) {
          R(this, I2) ? mt(this, I2, false) : this.parent.setSelected(this);
        }
        focusout(l) {
          if (!this.isAttachedToDOM) return;
          const t = l.relatedTarget;
          t != null && t.closest(`#${this.id}`) || (l.preventDefault(), this.parent.isMultipleSelection || this.commitOrRemove());
        }
        commitOrRemove() {
          this.isEmpty() ? this.remove() : this.commit();
        }
        commit() {
          this.parent.addToAnnotationStorage(this);
        }
        dragstart(l) {
          const t = this.parent.div.getBoundingClientRect();
          this.startX = l.clientX - t.x, this.startY = l.clientY - t.y, l.dataTransfer.setData("text/plain", this.id), l.dataTransfer.effectAllowed = "move";
        }
        setAt(l, t, s, a) {
          const [h, b] = this.parent.viewportBaseDimensions;
          [s, a] = this.screenToPageTranslation(s, a), this.x = (l + s) / h, this.y = (t + a) / b, this.div.style.left = `${100 * this.x}%`, this.div.style.top = `${100 * this.y}%`;
        }
        translate(l, t) {
          const [s, a] = this.parent.viewportBaseDimensions;
          [l, t] = this.screenToPageTranslation(l, t), this.x += l / s, this.y += t / a, this.div.style.left = `${100 * this.x}%`, this.div.style.top = `${100 * this.y}%`;
        }
        screenToPageTranslation(l, t) {
          const { rotation: s } = this.parent.viewport;
          switch (s) {
            case 90:
              return [t, -l];
            case 180:
              return [-l, -t];
            case 270:
              return [-t, l];
            default:
              return [l, t];
          }
        }
        setDims(l, t) {
          const [s, a] = this.parent.viewportBaseDimensions;
          this.div.style.width = `${100 * l / s}%`, this.div.style.height = `${100 * t / a}%`;
        }
        getInitialTranslation() {
          return [0, 0];
        }
        render() {
          this.div = document.createElement("div"), this.div.setAttribute("data-editor-rotation", (360 - this.rotation) % 360), this.div.className = this.name, this.div.setAttribute("id", this.id), this.div.setAttribute("tabIndex", 0), this.setInForeground(), this.div.addEventListener("focusin", R(this, B2)), this.div.addEventListener("focusout", R(this, Q2));
          const [l, t] = this.getInitialTranslation();
          return this.translate(l, t), (0, c2.bindEvents)(this, this.div, ["dragstart", "pointerdown"]), this.div;
        }
        pointerdown(l) {
          const t = c2.KeyboardManager.platform.isMac;
          if (l.button !== 0 || l.ctrlKey && t) {
            l.preventDefault();
            return;
          }
          l.ctrlKey && !t || l.shiftKey || l.metaKey && t ? this.parent.toggleSelected(this) : this.parent.setSelected(this), mt(this, I2, true);
        }
        getRect(l, t) {
          const [s, a] = this.parent.viewportBaseDimensions, [h, b] = this.parent.pageDimensions, r = h * l / s, n = b * t / a, e = this.x * h, o = this.y * b, v = this.width * h, m = this.height * b;
          switch (this.rotation) {
            case 0:
              return [e + r, b - o - n - m, e + r + v, b - o - n];
            case 90:
              return [e + n, b - o + r, e + n + m, b - o + r + v];
            case 180:
              return [e - r - v, b - o + n, e - r, b - o + n + m];
            case 270:
              return [e - n - m, b - o - r - v, e - n, b - o - r];
            default:
              throw new Error("Invalid rotation");
          }
        }
        getRectInCurrentCoords(l, t) {
          const [s, a, h, b] = l, r = h - s, n = b - a;
          switch (this.rotation) {
            case 0:
              return [s, t - b, r, n];
            case 90:
              return [s, t - a, n, r];
            case 180:
              return [h, t - a, r, n];
            case 270:
              return [h, t - b, n, r];
            default:
              throw new Error("Invalid rotation");
          }
        }
        onceAdded() {
        }
        isEmpty() {
          return false;
        }
        enableEditMode() {
          mt(this, w, true);
        }
        disableEditMode() {
          mt(this, w, false);
        }
        isInEditMode() {
          return R(this, w);
        }
        shouldGetKeyboardEvents() {
          return false;
        }
        needsToBeRebuilt() {
          return this.div && !this.isAttachedToDOM;
        }
        rebuild() {
          var l;
          (l = this.div) == null || l.addEventListener("focusin", R(this, B2));
        }
        serialize() {
          (0, S2.unreachable)("An editor must be serializable");
        }
        static deserialize(l, t) {
          const s = new this.prototype.constructor({ parent: t, id: t.getNextId() });
          s.rotation = l.rotation;
          const [a, h] = t.pageDimensions, [b, r, n, e] = s.getRectInCurrentCoords(l.rect, h);
          return s.x = b / a, s.y = r / h, s.width = n / a, s.height = e / h, s;
        }
        remove() {
          this.div.removeEventListener("focusin", R(this, B2)), this.div.removeEventListener("focusout", R(this, Q2)), this.isEmpty() || this.commit(), this.parent.remove(this);
        }
        select() {
          var l;
          (l = this.div) == null || l.classList.add("selectedEditor");
        }
        unselect() {
          var l;
          (l = this.div) == null || l.classList.remove("selectedEditor");
        }
        updateParams(l, t) {
        }
        disableEditing() {
        }
        enableEditing() {
        }
        get propertiesToUpdate() {
          return {};
        }
        get contentDiv() {
          return this.div;
        }
        get isEditing() {
          return R(this, y2);
        }
        set isEditing(l) {
          mt(this, y2, l), l ? (this.parent.setSelected(this), this.parent.setActiveEditor(this)) : this.parent.setActiveEditor(null);
        }
      };
      B2 = /* @__PURE__ */ new WeakMap(), Q2 = /* @__PURE__ */ new WeakMap(), I2 = /* @__PURE__ */ new WeakMap(), y2 = /* @__PURE__ */ new WeakMap(), w = /* @__PURE__ */ new WeakMap(), k2 = /* @__PURE__ */ new WeakMap(), Mt(T2, "_colorManager", new c2.ColorManager()), Mt(T2, "_zIndex", 1);
      let q2 = T2;
      f2.AnnotationEditor = q2;
    }, (z2, f2, $2) => {
      var C2, l, t, s, a, h, Te, n, o, v, m, d, E, U, tt, H, Z, j, V, X, at, dt, bt, N, p, u, we, F, le, O, Ut, K, Jt, _, xe, A, Pe, L, ce, it, Qt, rt, te;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.KeyboardManager = f2.CommandManager = f2.ColorManager = f2.AnnotationEditorUIManager = void 0, f2.bindEvents = q2, f2.opacityToHex = B2;
      var c2 = $2(1), S2 = $2(8);
      function q2(ut, M, ht) {
        for (const yt of ht) M.addEventListener(yt, ut[yt].bind(ut));
      }
      function B2(ut) {
        return Math.round(Math.min(255, Math.max(1, 255 * ut))).toString(16).padStart(2, "0");
      }
      class Q2 {
        constructor() {
          ct(this, C2, 0);
        }
        getId() {
          return `${c2.AnnotationEditorPrefix}${re(this, C2)._++}`;
        }
      }
      C2 = /* @__PURE__ */ new WeakMap();
      class I2 {
        constructor(M = 128) {
          ct(this, l, []);
          ct(this, t, false);
          ct(this, s, void 0);
          ct(this, a, -1);
          mt(this, s, M);
        }
        add({ cmd: M, undo: ht, mustExec: yt, type: vt = NaN, overwriteIfSameType: Ct = false, keepUndo: wt = false }) {
          if (yt && M(), R(this, t)) return;
          const It = { cmd: M, undo: ht, type: vt };
          if (R(this, a) === -1) {
            R(this, l).length > 0 && (R(this, l).length = 0), mt(this, a, 0), R(this, l).push(It);
            return;
          }
          if (Ct && R(this, l)[R(this, a)].type === vt) {
            wt && (It.undo = R(this, l)[R(this, a)].undo), R(this, l)[R(this, a)] = It;
            return;
          }
          const Rt = R(this, a) + 1;
          Rt === R(this, s) ? R(this, l).splice(0, 1) : (mt(this, a, Rt), Rt < R(this, l).length && R(this, l).splice(Rt)), R(this, l).push(It);
        }
        undo() {
          R(this, a) !== -1 && (mt(this, t, true), R(this, l)[R(this, a)].undo(), mt(this, t, false), mt(this, a, R(this, a) - 1));
        }
        redo() {
          R(this, a) < R(this, l).length - 1 && (mt(this, a, R(this, a) + 1), mt(this, t, true), R(this, l)[R(this, a)].cmd(), mt(this, t, false));
        }
        hasSomethingToUndo() {
          return R(this, a) !== -1;
        }
        hasSomethingToRedo() {
          return R(this, a) < R(this, l).length - 1;
        }
        destroy() {
          mt(this, l, null);
        }
      }
      l = /* @__PURE__ */ new WeakMap(), t = /* @__PURE__ */ new WeakMap(), s = /* @__PURE__ */ new WeakMap(), a = /* @__PURE__ */ new WeakMap(), f2.CommandManager = I2;
      const r = class r2 {
        constructor(M) {
          ct(this, h);
          this.buffer = [], this.callbacks = /* @__PURE__ */ new Map(), this.allKeys = /* @__PURE__ */ new Set();
          const ht = r2.platform.isMac;
          for (const [yt, vt] of M) for (const Ct of yt) {
            const wt = Ct.startsWith("mac+");
            ht && wt ? (this.callbacks.set(Ct.slice(4), vt), this.allKeys.add(Ct.split("+").at(-1))) : !ht && !wt && (this.callbacks.set(Ct, vt), this.allKeys.add(Ct.split("+").at(-1)));
          }
        }
        static get platform() {
          const M = typeof navigator < "u" ? navigator.platform : "";
          return (0, c2.shadow)(this, "platform", { isWin: M.includes("Win"), isMac: M.includes("Mac") });
        }
        exec(M, ht) {
          if (!this.allKeys.has(ht.key)) return;
          const yt = this.callbacks.get(ft(this, h, Te).call(this, ht));
          yt && (yt.bind(M)(), ht.stopPropagation(), ht.preventDefault());
        }
      };
      h = /* @__PURE__ */ new WeakSet(), Te = function(M) {
        M.altKey && this.buffer.push("alt"), M.ctrlKey && this.buffer.push("ctrl"), M.metaKey && this.buffer.push("meta"), M.shiftKey && this.buffer.push("shift"), this.buffer.push(M.key);
        const ht = this.buffer.join("+");
        return this.buffer.length = 0, ht;
      };
      let y2 = r;
      f2.KeyboardManager = y2;
      class w {
        constructor() {
          ct(this, n, null);
        }
        copy(M) {
          M && (Array.isArray(M) ? mt(this, n, M.map((ht) => ht.serialize())) : mt(this, n, [M.serialize()]), mt(this, n, R(this, n).filter((ht) => !!ht)), R(this, n).length === 0 && mt(this, n, null));
        }
        paste() {
          return R(this, n);
        }
        isEmpty() {
          return R(this, n) === null;
        }
        destroy() {
          mt(this, n, null);
        }
      }
      n = /* @__PURE__ */ new WeakMap();
      const e = class e2 {
        get _colors() {
          const M = /* @__PURE__ */ new Map([["CanvasText", null], ["Canvas", null]]);
          return (0, S2.getColorValues)(M), (0, c2.shadow)(this, "_colors", M);
        }
        convert(M) {
          const ht = (0, S2.getRGB)(M);
          if (!window.matchMedia("(forced-colors: active)").matches) return ht;
          for (const [yt, vt] of this._colors) if (vt.every((Ct, wt) => Ct === ht[wt])) return e2._colorsMapping.get(yt);
          return ht;
        }
        getHexCode(M) {
          const ht = this._colors.get(M);
          return ht ? c2.Util.makeHexColor(...ht) : M;
        }
      };
      Mt(e, "_colorsMapping", /* @__PURE__ */ new Map([["CanvasText", [0, 0, 0]], ["Canvas", [255, 255, 255]]]));
      let k2 = e;
      f2.ColorManager = k2;
      const ot = class ot2 {
        constructor(M, ht) {
          ct(this, u);
          ct(this, F);
          ct(this, O);
          ct(this, K);
          ct(this, _);
          ct(this, A);
          ct(this, L);
          ct(this, it);
          ct(this, rt);
          ct(this, o, null);
          ct(this, v, /* @__PURE__ */ new Map());
          ct(this, m, /* @__PURE__ */ new Map());
          ct(this, d, new w());
          ct(this, E, new I2());
          ct(this, U, 0);
          ct(this, tt, null);
          ct(this, H, null);
          ct(this, Z, new Q2());
          ct(this, j, false);
          ct(this, V, c2.AnnotationEditorType.NONE);
          ct(this, X, /* @__PURE__ */ new Set());
          ct(this, at, this.keydown.bind(this));
          ct(this, dt, this.onEditingAction.bind(this));
          ct(this, bt, this.onPageChanging.bind(this));
          ct(this, N, { isEditing: false, isEmpty: true, hasEmptyClipboard: true, hasSomethingToUndo: false, hasSomethingToRedo: false, hasSelectedEditor: false });
          ct(this, p, null);
          mt(this, p, M), mt(this, H, ht), R(this, H)._on("editingaction", R(this, dt)), R(this, H)._on("pagechanging", R(this, bt));
        }
        destroy() {
          ft(this, F, le).call(this), R(this, H)._off("editingaction", R(this, dt)), R(this, H)._off("pagechanging", R(this, bt));
          for (const M of R(this, m).values()) M.destroy();
          R(this, m).clear(), R(this, v).clear(), mt(this, o, null), R(this, X).clear(), R(this, d).destroy(), R(this, E).destroy();
        }
        onPageChanging({ pageNumber: M }) {
          mt(this, U, M - 1);
        }
        focusMainContainer() {
          R(this, p).focus();
        }
        keydown(M) {
          var ht;
          (ht = this.getActive()) != null && ht.shouldGetKeyboardEvents() || ot2._keyboardManager.exec(this, M);
        }
        onEditingAction(M) {
          ["undo", "redo", "cut", "copy", "paste", "delete", "selectAll"].includes(M.name) && this[M.name]();
        }
        setEditingState(M) {
          M ? (ft(this, u, we).call(this), ft(this, O, Ut).call(this, { isEditing: R(this, V) !== c2.AnnotationEditorType.NONE, isEmpty: ft(this, it, Qt).call(this), hasSomethingToUndo: R(this, E).hasSomethingToUndo(), hasSomethingToRedo: R(this, E).hasSomethingToRedo(), hasSelectedEditor: false, hasEmptyClipboard: R(this, d).isEmpty() })) : (ft(this, F, le).call(this), ft(this, O, Ut).call(this, { isEditing: false }));
        }
        registerEditorTypes(M) {
          mt(this, tt, M);
          for (const ht of R(this, tt)) ft(this, K, Jt).call(this, ht.defaultPropertiesToUpdate);
        }
        getId() {
          return R(this, Z).getId();
        }
        addLayer(M) {
          R(this, m).set(M.pageIndex, M), R(this, j) ? M.enable() : M.disable();
        }
        removeLayer(M) {
          R(this, m).delete(M.pageIndex);
        }
        updateMode(M) {
          if (mt(this, V, M), M === c2.AnnotationEditorType.NONE) this.setEditingState(false), ft(this, A, Pe).call(this);
          else {
            this.setEditingState(true), ft(this, _, xe).call(this);
            for (const ht of R(this, m).values()) ht.updateMode(M);
          }
        }
        updateToolbar(M) {
          M !== R(this, V) && R(this, H).dispatch("switchannotationeditormode", { source: this, mode: M });
        }
        updateParams(M, ht) {
          for (const yt of R(this, X)) yt.updateParams(M, ht);
          for (const yt of R(this, tt)) yt.updateDefaultParams(M, ht);
        }
        getEditors(M) {
          const ht = [];
          for (const yt of R(this, v).values()) yt.pageIndex === M && ht.push(yt);
          return ht;
        }
        getEditor(M) {
          return R(this, v).get(M);
        }
        addEditor(M) {
          R(this, v).set(M.id, M);
        }
        removeEditor(M) {
          R(this, v).delete(M.id), this.unselect(M);
        }
        setActiveEditor(M) {
          R(this, o) !== M && (mt(this, o, M), M && ft(this, K, Jt).call(this, M.propertiesToUpdate));
        }
        toggleSelected(M) {
          if (R(this, X).has(M)) {
            R(this, X).delete(M), M.unselect(), ft(this, O, Ut).call(this, { hasSelectedEditor: this.hasSelection });
            return;
          }
          R(this, X).add(M), M.select(), ft(this, K, Jt).call(this, M.propertiesToUpdate), ft(this, O, Ut).call(this, { hasSelectedEditor: true });
        }
        setSelected(M) {
          for (const ht of R(this, X)) ht !== M && ht.unselect();
          R(this, X).clear(), R(this, X).add(M), M.select(), ft(this, K, Jt).call(this, M.propertiesToUpdate), ft(this, O, Ut).call(this, { hasSelectedEditor: true });
        }
        isSelected(M) {
          return R(this, X).has(M);
        }
        unselect(M) {
          M.unselect(), R(this, X).delete(M), ft(this, O, Ut).call(this, { hasSelectedEditor: this.hasSelection });
        }
        get hasSelection() {
          return R(this, X).size !== 0;
        }
        undo() {
          R(this, E).undo(), ft(this, O, Ut).call(this, { hasSomethingToUndo: R(this, E).hasSomethingToUndo(), hasSomethingToRedo: true, isEmpty: ft(this, it, Qt).call(this) });
        }
        redo() {
          R(this, E).redo(), ft(this, O, Ut).call(this, { hasSomethingToUndo: true, hasSomethingToRedo: R(this, E).hasSomethingToRedo(), isEmpty: ft(this, it, Qt).call(this) });
        }
        addCommands(M) {
          R(this, E).add(M), ft(this, O, Ut).call(this, { hasSomethingToUndo: true, hasSomethingToRedo: false, isEmpty: ft(this, it, Qt).call(this) });
        }
        delete() {
          if (R(this, o) && R(this, o).commitOrRemove(), !this.hasSelection) return;
          const M = [...R(this, X)], ht = () => {
            for (const vt of M) vt.remove();
          }, yt = () => {
            for (const vt of M) ft(this, L, ce).call(this, vt);
          };
          this.addCommands({ cmd: ht, undo: yt, mustExec: true });
        }
        copy() {
          if (R(this, o) && R(this, o).commitOrRemove(), this.hasSelection) {
            const M = [];
            for (const ht of R(this, X)) ht.isEmpty() || M.push(ht);
            if (M.length === 0) return;
            R(this, d).copy(M), ft(this, O, Ut).call(this, { hasEmptyClipboard: false });
          }
        }
        cut() {
          this.copy(), this.delete();
        }
        paste() {
          if (R(this, d).isEmpty()) return;
          this.unselectAll();
          const M = R(this, m).get(R(this, U)), ht = R(this, d).paste().map((Ct) => M.deserialize(Ct)), yt = () => {
            for (const Ct of ht) ft(this, L, ce).call(this, Ct);
            ft(this, rt, te).call(this, ht);
          }, vt = () => {
            for (const Ct of ht) Ct.remove();
          };
          this.addCommands({ cmd: yt, undo: vt, mustExec: true });
        }
        selectAll() {
          for (const M of R(this, X)) M.commit();
          ft(this, rt, te).call(this, R(this, v).values());
        }
        unselectAll() {
          if (R(this, o)) {
            R(this, o).commitOrRemove();
            return;
          }
          if (ft(this, rt, te).size !== 0) {
            for (const M of R(this, X)) M.unselect();
            R(this, X).clear(), ft(this, O, Ut).call(this, { hasSelectedEditor: false });
          }
        }
        isActive(M) {
          return R(this, o) === M;
        }
        getActive() {
          return R(this, o);
        }
        getMode() {
          return R(this, V);
        }
      };
      o = /* @__PURE__ */ new WeakMap(), v = /* @__PURE__ */ new WeakMap(), m = /* @__PURE__ */ new WeakMap(), d = /* @__PURE__ */ new WeakMap(), E = /* @__PURE__ */ new WeakMap(), U = /* @__PURE__ */ new WeakMap(), tt = /* @__PURE__ */ new WeakMap(), H = /* @__PURE__ */ new WeakMap(), Z = /* @__PURE__ */ new WeakMap(), j = /* @__PURE__ */ new WeakMap(), V = /* @__PURE__ */ new WeakMap(), X = /* @__PURE__ */ new WeakMap(), at = /* @__PURE__ */ new WeakMap(), dt = /* @__PURE__ */ new WeakMap(), bt = /* @__PURE__ */ new WeakMap(), N = /* @__PURE__ */ new WeakMap(), p = /* @__PURE__ */ new WeakMap(), u = /* @__PURE__ */ new WeakSet(), we = function() {
        R(this, p).addEventListener("keydown", R(this, at));
      }, F = /* @__PURE__ */ new WeakSet(), le = function() {
        R(this, p).removeEventListener("keydown", R(this, at));
      }, O = /* @__PURE__ */ new WeakSet(), Ut = function(M) {
        Object.entries(M).some(([yt, vt]) => R(this, N)[yt] !== vt) && R(this, H).dispatch("annotationeditorstateschanged", { source: this, details: Object.assign(R(this, N), M) });
      }, K = /* @__PURE__ */ new WeakSet(), Jt = function(M) {
        R(this, H).dispatch("annotationeditorparamschanged", { source: this, details: M });
      }, _ = /* @__PURE__ */ new WeakSet(), xe = function() {
        if (!R(this, j)) {
          mt(this, j, true);
          for (const M of R(this, m).values()) M.enable();
        }
      }, A = /* @__PURE__ */ new WeakSet(), Pe = function() {
        if (this.unselectAll(), R(this, j)) {
          mt(this, j, false);
          for (const M of R(this, m).values()) M.disable();
        }
      }, L = /* @__PURE__ */ new WeakSet(), ce = function(M) {
        const ht = R(this, m).get(M.pageIndex);
        ht ? ht.addOrRebuild(M) : this.addEditor(M);
      }, it = /* @__PURE__ */ new WeakSet(), Qt = function() {
        if (R(this, v).size === 0) return true;
        if (R(this, v).size === 1) for (const M of R(this, v).values()) return M.isEmpty();
        return false;
      }, rt = /* @__PURE__ */ new WeakSet(), te = function(M) {
        R(this, X).clear();
        for (const ht of M) ht.isEmpty() || (R(this, X).add(ht), ht.select());
        ft(this, O, Ut).call(this, { hasSelectedEditor: true });
      }, Mt(ot, "_keyboardManager", new y2([[["ctrl+a", "mac+meta+a"], ot.prototype.selectAll], [["ctrl+c", "mac+meta+c"], ot.prototype.copy], [["ctrl+v", "mac+meta+v"], ot.prototype.paste], [["ctrl+x", "mac+meta+x"], ot.prototype.cut], [["ctrl+z", "mac+meta+z"], ot.prototype.undo], [["ctrl+y", "ctrl+shift+Z", "mac+meta+shift+Z"], ot.prototype.redo], [["Backspace", "alt+Backspace", "ctrl+Backspace", "shift+Backspace", "mac+Backspace", "mac+alt+Backspace", "mac+ctrl+Backspace", "Delete", "ctrl+Delete", "shift+Delete"], ot.prototype.delete], [["Escape", "mac+Escape"], ot.prototype.unselectAll]]));
      let T2 = ot;
      f2.AnnotationEditorUIManager = T2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.StatTimer = f2.RenderingCancelledException = f2.PixelsPerInch = f2.PageViewport = f2.PDFDateString = f2.DOMStandardFontDataFactory = f2.DOMSVGFactory = f2.DOMCanvasFactory = f2.DOMCMapReaderFactory = f2.AnnotationPrefix = void 0, f2.deprecated = e, f2.getColorValues = E, f2.getCurrentTransform = U, f2.getCurrentTransformInverse = tt, f2.getFilenameFromUrl = a, f2.getPdfFilenameFromUrl = h, f2.getRGB = d, f2.getXfaPageViewport = m, f2.isDataScheme = t, f2.isPdfFile = s, f2.isValidFetchUrl = r, f2.loadScript = n;
      var c2 = $2(9), S2 = $2(1);
      const q2 = "http://www.w3.org/2000/svg", B2 = "pdfjs_internal_id_";
      f2.AnnotationPrefix = B2;
      const H = class H {
      };
      Mt(H, "CSS", 96), Mt(H, "PDF", 72), Mt(H, "PDF_TO_CSS_UNITS", H.CSS / H.PDF);
      let Q2 = H;
      f2.PixelsPerInch = Q2;
      class I2 extends c2.BaseCanvasFactory {
        constructor({ ownerDocument: j = globalThis.document } = {}) {
          super(), this._document = j;
        }
        _createCanvas(j, V) {
          const X = this._document.createElement("canvas");
          return X.width = j, X.height = V, X;
        }
      }
      f2.DOMCanvasFactory = I2;
      async function y2(Z, j = false) {
        if (r(Z, document.baseURI)) {
          const V = await fetch(Z);
          if (!V.ok) throw new Error(V.statusText);
          return j ? new Uint8Array(await V.arrayBuffer()) : (0, S2.stringToBytes)(await V.text());
        }
        return new Promise((V, X) => {
          const at = new XMLHttpRequest();
          at.open("GET", Z, true), j && (at.responseType = "arraybuffer"), at.onreadystatechange = () => {
            if (at.readyState === XMLHttpRequest.DONE) {
              if (at.status === 200 || at.status === 0) {
                let dt;
                if (j && at.response ? dt = new Uint8Array(at.response) : !j && at.responseText && (dt = (0, S2.stringToBytes)(at.responseText)), dt) {
                  V(dt);
                  return;
                }
              }
              X(new Error(at.statusText));
            }
          }, at.send(null);
        });
      }
      class w extends c2.BaseCMapReaderFactory {
        _fetchData(j, V) {
          return y2(j, this.isCompressed).then((X) => ({ cMapData: X, compressionType: V }));
        }
      }
      f2.DOMCMapReaderFactory = w;
      class k2 extends c2.BaseStandardFontDataFactory {
        _fetchData(j) {
          return y2(j, true);
        }
      }
      f2.DOMStandardFontDataFactory = k2;
      class T2 extends c2.BaseSVGFactory {
        _createSVG(j) {
          return document.createElementNS(q2, j);
        }
      }
      f2.DOMSVGFactory = T2;
      class C2 {
        constructor({ viewBox: j, scale: V, rotation: X, offsetX: at = 0, offsetY: dt = 0, dontFlip: bt = false }) {
          this.viewBox = j, this.scale = V, this.rotation = X, this.offsetX = at, this.offsetY = dt;
          const N = (j[2] + j[0]) / 2, p = (j[3] + j[1]) / 2;
          let u, P, F, D;
          switch (X %= 360, X < 0 && (X += 360), X) {
            case 180:
              u = -1, P = 0, F = 0, D = 1;
              break;
            case 90:
              u = 0, P = 1, F = 1, D = 0;
              break;
            case 270:
              u = 0, P = -1, F = -1, D = 0;
              break;
            case 0:
              u = 1, P = 0, F = 0, D = -1;
              break;
            default:
              throw new Error("PageViewport: Invalid rotation, must be a multiple of 90 degrees.");
          }
          bt && (F = -F, D = -D);
          let O, Y, K, i;
          u === 0 ? (O = Math.abs(p - j[1]) * V + at, Y = Math.abs(N - j[0]) * V + dt, K = Math.abs(j[3] - j[1]) * V, i = Math.abs(j[2] - j[0]) * V) : (O = Math.abs(N - j[0]) * V + at, Y = Math.abs(p - j[1]) * V + dt, K = Math.abs(j[2] - j[0]) * V, i = Math.abs(j[3] - j[1]) * V), this.transform = [u * V, P * V, F * V, D * V, O - u * V * N - F * V * p, Y - P * V * N - D * V * p], this.width = K, this.height = i;
        }
        clone({ scale: j = this.scale, rotation: V = this.rotation, offsetX: X = this.offsetX, offsetY: at = this.offsetY, dontFlip: dt = false } = {}) {
          return new C2({ viewBox: this.viewBox.slice(), scale: j, rotation: V, offsetX: X, offsetY: at, dontFlip: dt });
        }
        convertToViewportPoint(j, V) {
          return S2.Util.applyTransform([j, V], this.transform);
        }
        convertToViewportRectangle(j) {
          const V = S2.Util.applyTransform([j[0], j[1]], this.transform), X = S2.Util.applyTransform([j[2], j[3]], this.transform);
          return [V[0], V[1], X[0], X[1]];
        }
        convertToPdfPoint(j, V) {
          return S2.Util.applyInverseTransform([j, V], this.transform);
        }
      }
      f2.PageViewport = C2;
      class l extends S2.BaseException {
        constructor(j, V) {
          super(j, "RenderingCancelledException"), this.type = V;
        }
      }
      f2.RenderingCancelledException = l;
      function t(Z) {
        const j = Z.length;
        let V = 0;
        for (; V < j && Z[V].trim() === ""; ) V++;
        return Z.substring(V, V + 5).toLowerCase() === "data:";
      }
      function s(Z) {
        return typeof Z == "string" && /\.pdf$/i.test(Z);
      }
      function a(Z) {
        const j = Z.indexOf("#"), V = Z.indexOf("?"), X = Math.min(j > 0 ? j : Z.length, V > 0 ? V : Z.length);
        return Z.substring(Z.lastIndexOf("/", X) + 1, X);
      }
      function h(Z, j = "document.pdf") {
        if (typeof Z != "string") return j;
        if (t(Z)) return (0, S2.warn)('getPdfFilenameFromUrl: ignore "data:"-URL for performance reasons.'), j;
        const V = /^(?:(?:[^:]+:)?\/\/[^/]+)?([^?#]*)(\?[^#]*)?(#.*)?$/, X = /[^/?#=]+\.pdf\b(?!.*\.pdf\b)/i, at = V.exec(Z);
        let dt = X.exec(at[1]) || X.exec(at[2]) || X.exec(at[3]);
        if (dt && (dt = dt[0], dt.includes("%"))) try {
          dt = X.exec(decodeURIComponent(dt))[0];
        } catch {
        }
        return dt || j;
      }
      class b {
        constructor() {
          this.started = /* @__PURE__ */ Object.create(null), this.times = [];
        }
        time(j) {
          j in this.started && (0, S2.warn)(`Timer is already running for ${j}`), this.started[j] = Date.now();
        }
        timeEnd(j) {
          j in this.started || (0, S2.warn)(`Timer has not been started for ${j}`), this.times.push({ name: j, start: this.started[j], end: Date.now() }), delete this.started[j];
        }
        toString() {
          const j = [];
          let V = 0;
          for (const X of this.times) {
            const at = X.name;
            at.length > V && (V = at.length);
          }
          for (const X of this.times) {
            const at = X.end - X.start;
            j.push(`${X.name.padEnd(V)} ${at}ms
`);
          }
          return j.join("");
        }
      }
      f2.StatTimer = b;
      function r(Z, j) {
        try {
          const { protocol: V } = j ? new URL(Z, j) : new URL(Z);
          return V === "http:" || V === "https:";
        } catch {
          return false;
        }
      }
      function n(Z, j = false) {
        return new Promise((V, X) => {
          const at = document.createElement("script");
          at.src = Z, at.onload = function(dt) {
            j && at.remove(), V(dt);
          }, at.onerror = function() {
            X(new Error(`Cannot load script at: ${at.src}`));
          }, (document.head || document.documentElement).append(at);
        });
      }
      function e(Z) {
        console.log("Deprecated API usage: " + Z);
      }
      let o;
      class v {
        static toDateObject(j) {
          if (!j || typeof j != "string") return null;
          o || (o = new RegExp("^D:(\\d{4})(\\d{2})?(\\d{2})?(\\d{2})?(\\d{2})?(\\d{2})?([Z|+|-])?(\\d{2})?'?(\\d{2})?'?"));
          const V = o.exec(j);
          if (!V) return null;
          const X = parseInt(V[1], 10);
          let at = parseInt(V[2], 10);
          at = at >= 1 && at <= 12 ? at - 1 : 0;
          let dt = parseInt(V[3], 10);
          dt = dt >= 1 && dt <= 31 ? dt : 1;
          let bt = parseInt(V[4], 10);
          bt = bt >= 0 && bt <= 23 ? bt : 0;
          let N = parseInt(V[5], 10);
          N = N >= 0 && N <= 59 ? N : 0;
          let p = parseInt(V[6], 10);
          p = p >= 0 && p <= 59 ? p : 0;
          const u = V[7] || "Z";
          let P = parseInt(V[8], 10);
          P = P >= 0 && P <= 23 ? P : 0;
          let F = parseInt(V[9], 10) || 0;
          return F = F >= 0 && F <= 59 ? F : 0, u === "-" ? (bt += P, N += F) : u === "+" && (bt -= P, N -= F), new Date(Date.UTC(X, at, dt, bt, N, p));
        }
      }
      f2.PDFDateString = v;
      function m(Z, { scale: j = 1, rotation: V = 0 }) {
        const { width: X, height: at } = Z.attributes.style, dt = [0, 0, parseInt(X), parseInt(at)];
        return new C2({ viewBox: dt, scale: j, rotation: V });
      }
      function d(Z) {
        if (Z.startsWith("#")) {
          const j = parseInt(Z.slice(1), 16);
          return [(j & 16711680) >> 16, (j & 65280) >> 8, j & 255];
        }
        return Z.startsWith("rgb(") ? Z.slice(4, -1).split(",").map((j) => parseInt(j)) : Z.startsWith("rgba(") ? Z.slice(5, -1).split(",").map((j) => parseInt(j)).slice(0, 3) : ((0, S2.warn)(`Not a valid color format: "${Z}"`), [0, 0, 0]);
      }
      function E(Z) {
        const j = document.createElement("span");
        j.style.visibility = "hidden", document.body.append(j);
        for (const V of Z.keys()) {
          j.style.color = V;
          const X = window.getComputedStyle(j).color;
          Z.set(V, d(X));
        }
        j.remove();
      }
      function U(Z) {
        const { a: j, b: V, c: X, d: at, e: dt, f: bt } = Z.getTransform();
        return [j, V, X, at, dt, bt];
      }
      function tt(Z) {
        const { a: j, b: V, c: X, d: at, e: dt, f: bt } = Z.getTransform().invertSelf();
        return [j, V, X, at, dt, bt];
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.BaseStandardFontDataFactory = f2.BaseSVGFactory = f2.BaseCanvasFactory = f2.BaseCMapReaderFactory = void 0;
      var c2 = $2(1);
      class S2 {
        constructor() {
          this.constructor === S2 && (0, c2.unreachable)("Cannot initialize BaseCanvasFactory.");
        }
        create(y2, w) {
          if (y2 <= 0 || w <= 0) throw new Error("Invalid canvas size");
          const k2 = this._createCanvas(y2, w);
          return { canvas: k2, context: k2.getContext("2d") };
        }
        reset(y2, w, k2) {
          if (!y2.canvas) throw new Error("Canvas is not specified");
          if (w <= 0 || k2 <= 0) throw new Error("Invalid canvas size");
          y2.canvas.width = w, y2.canvas.height = k2;
        }
        destroy(y2) {
          if (!y2.canvas) throw new Error("Canvas is not specified");
          y2.canvas.width = 0, y2.canvas.height = 0, y2.canvas = null, y2.context = null;
        }
        _createCanvas(y2, w) {
          (0, c2.unreachable)("Abstract method `_createCanvas` called.");
        }
      }
      f2.BaseCanvasFactory = S2;
      class q2 {
        constructor({ baseUrl: y2 = null, isCompressed: w = false }) {
          this.constructor === q2 && (0, c2.unreachable)("Cannot initialize BaseCMapReaderFactory."), this.baseUrl = y2, this.isCompressed = w;
        }
        async fetch({ name: y2 }) {
          if (!this.baseUrl) throw new Error('The CMap "baseUrl" parameter must be specified, ensure that the "cMapUrl" and "cMapPacked" API parameters are provided.');
          if (!y2) throw new Error("CMap name must be specified.");
          const w = this.baseUrl + y2 + (this.isCompressed ? ".bcmap" : ""), k2 = this.isCompressed ? c2.CMapCompressionType.BINARY : c2.CMapCompressionType.NONE;
          return this._fetchData(w, k2).catch((T2) => {
            throw new Error(`Unable to load ${this.isCompressed ? "binary " : ""}CMap at: ${w}`);
          });
        }
        _fetchData(y2, w) {
          (0, c2.unreachable)("Abstract method `_fetchData` called.");
        }
      }
      f2.BaseCMapReaderFactory = q2;
      class B2 {
        constructor({ baseUrl: y2 = null }) {
          this.constructor === B2 && (0, c2.unreachable)("Cannot initialize BaseStandardFontDataFactory."), this.baseUrl = y2;
        }
        async fetch({ filename: y2 }) {
          if (!this.baseUrl) throw new Error('The standard font "baseUrl" parameter must be specified, ensure that the "standardFontDataUrl" API parameter is provided.');
          if (!y2) throw new Error("Font filename must be specified.");
          const w = `${this.baseUrl}${y2}`;
          return this._fetchData(w).catch((k2) => {
            throw new Error(`Unable to load font data at: ${w}`);
          });
        }
        _fetchData(y2) {
          (0, c2.unreachable)("Abstract method `_fetchData` called.");
        }
      }
      f2.BaseStandardFontDataFactory = B2;
      class Q2 {
        constructor() {
          this.constructor === Q2 && (0, c2.unreachable)("Cannot initialize BaseSVGFactory.");
        }
        create(y2, w, k2 = false) {
          if (y2 <= 0 || w <= 0) throw new Error("Invalid SVG dimensions");
          const T2 = this._createSVG("svg:svg");
          return T2.setAttribute("version", "1.1"), k2 || (T2.setAttribute("width", `${y2}px`), T2.setAttribute("height", `${w}px`)), T2.setAttribute("preserveAspectRatio", "none"), T2.setAttribute("viewBox", `0 0 ${y2} ${w}`), T2;
        }
        createElement(y2) {
          if (typeof y2 != "string") throw new Error("Invalid SVG element type");
          return this._createSVG(y2);
        }
        _createSVG(y2) {
          (0, c2.unreachable)("Abstract method `_createSVG` called.");
        }
      }
      f2.BaseSVGFactory = Q2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.MurmurHash3_64 = void 0;
      var c2 = $2(1);
      const S2 = 3285377520, q2 = 4294901760, B2 = 65535;
      class Q2 {
        constructor(y2) {
          this.h1 = y2 ? y2 & 4294967295 : S2, this.h2 = y2 ? y2 & 4294967295 : S2;
        }
        update(y2) {
          let w, k2;
          if (typeof y2 == "string") {
            w = new Uint8Array(y2.length * 2), k2 = 0;
            for (let o = 0, v = y2.length; o < v; o++) {
              const m = y2.charCodeAt(o);
              m <= 255 ? w[k2++] = m : (w[k2++] = m >>> 8, w[k2++] = m & 255);
            }
          } else if ((0, c2.isArrayBuffer)(y2)) w = y2.slice(), k2 = w.byteLength;
          else throw new Error("Wrong data format in MurmurHash3_64_update. Input must be a string or array.");
          const T2 = k2 >> 2, C2 = k2 - T2 * 4, l = new Uint32Array(w.buffer, 0, T2);
          let t = 0, s = 0, a = this.h1, h = this.h2;
          const b = 3432918353, r = 461845907, n = b & B2, e = r & B2;
          for (let o = 0; o < T2; o++) o & 1 ? (t = l[o], t = t * b & q2 | t * n & B2, t = t << 15 | t >>> 17, t = t * r & q2 | t * e & B2, a ^= t, a = a << 13 | a >>> 19, a = a * 5 + 3864292196) : (s = l[o], s = s * b & q2 | s * n & B2, s = s << 15 | s >>> 17, s = s * r & q2 | s * e & B2, h ^= s, h = h << 13 | h >>> 19, h = h * 5 + 3864292196);
          switch (t = 0, C2) {
            case 3:
              t ^= w[T2 * 4 + 2] << 16;
            case 2:
              t ^= w[T2 * 4 + 1] << 8;
            case 1:
              t ^= w[T2 * 4], t = t * b & q2 | t * n & B2, t = t << 15 | t >>> 17, t = t * r & q2 | t * e & B2, T2 & 1 ? a ^= t : h ^= t;
          }
          this.h1 = a, this.h2 = h;
        }
        hexdigest() {
          let y2 = this.h1, w = this.h2;
          y2 ^= w >>> 1, y2 = y2 * 3981806797 & q2 | y2 * 36045 & B2, w = w * 4283543511 & q2 | ((w << 16 | y2 >>> 16) * 2950163797 & q2) >>> 16, y2 ^= w >>> 1, y2 = y2 * 444984403 & q2 | y2 * 60499 & B2, w = w * 3301882366 & q2 | ((w << 16 | y2 >>> 16) * 3120437893 & q2) >>> 16, y2 ^= w >>> 1;
          const k2 = (y2 >>> 0).toString(16), T2 = (w >>> 0).toString(16);
          return k2.padStart(8, "0") + T2.padStart(8, "0");
        }
      }
      f2.MurmurHash3_64 = Q2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.FontLoader = f2.FontFaceObject = void 0;
      var c2 = $2(1);
      class S2 {
        constructor({ docId: I2, onUnsupportedFeature: y2, ownerDocument: w = globalThis.document, styleElement: k2 = null }) {
          this.constructor === S2 && (0, c2.unreachable)("Cannot initialize BaseFontLoader."), this.docId = I2, this._onUnsupportedFeature = y2, this._document = w, this.nativeFontFaces = [], this.styleElement = null;
        }
        addNativeFontFace(I2) {
          this.nativeFontFaces.push(I2), this._document.fonts.add(I2);
        }
        insertRule(I2) {
          let y2 = this.styleElement;
          y2 || (y2 = this.styleElement = this._document.createElement("style"), y2.id = `PDFJS_FONT_STYLE_TAG_${this.docId}`, this._document.documentElement.getElementsByTagName("head")[0].append(y2));
          const w = y2.sheet;
          w.insertRule(I2, w.cssRules.length);
        }
        clear() {
          for (const I2 of this.nativeFontFaces) this._document.fonts.delete(I2);
          this.nativeFontFaces.length = 0, this.styleElement && (this.styleElement.remove(), this.styleElement = null);
        }
        async bind(I2) {
          if (I2.attached || I2.missingFile) return;
          if (I2.attached = true, this.isFontLoadingAPISupported) {
            const w = I2.createNativeFontFace();
            if (w) {
              this.addNativeFontFace(w);
              try {
                await w.loaded;
              } catch (k2) {
                throw this._onUnsupportedFeature({ featureId: c2.UNSUPPORTED_FEATURES.errorFontLoadNative }), (0, c2.warn)(`Failed to load font '${w.family}': '${k2}'.`), I2.disableFontFace = true, k2;
              }
            }
            return;
          }
          const y2 = I2.createFontFaceRule();
          if (y2) {
            if (this.insertRule(y2), this.isSyncFontLoadingSupported) return;
            await new Promise((w) => {
              const k2 = this._queueLoadingCallback(w);
              this._prepareFontLoadEvent([y2], [I2], k2);
            });
          }
        }
        _queueLoadingCallback(I2) {
          (0, c2.unreachable)("Abstract method `_queueLoadingCallback`.");
        }
        get isFontLoadingAPISupported() {
          var y2;
          const I2 = !!((y2 = this._document) != null && y2.fonts);
          return (0, c2.shadow)(this, "isFontLoadingAPISupported", I2);
        }
        get isSyncFontLoadingSupported() {
          (0, c2.unreachable)("Abstract method `isSyncFontLoadingSupported`.");
        }
        get _loadTestFont() {
          (0, c2.unreachable)("Abstract method `_loadTestFont`.");
        }
        _prepareFontLoadEvent(I2, y2, w) {
          (0, c2.unreachable)("Abstract method `_prepareFontLoadEvent`.");
        }
      }
      let q2;
      f2.FontLoader = q2, f2.FontLoader = q2 = class extends S2 {
        constructor(I2) {
          super(I2), this.loadingContext = { requests: [], nextRequestId: 0 }, this.loadTestFontId = 0;
        }
        get isSyncFontLoadingSupported() {
          let I2 = false;
          if (typeof navigator > "u") I2 = true;
          else {
            const y2 = /Mozilla\/5.0.*?rv:(\d+).*? Gecko/.exec(navigator.userAgent);
            (y2 == null ? void 0 : y2[1]) >= 14 && (I2 = true);
          }
          return (0, c2.shadow)(this, "isSyncFontLoadingSupported", I2);
        }
        _queueLoadingCallback(I2) {
          function y2() {
            for ((0, c2.assert)(!k2.done, "completeRequest() cannot be called twice."), k2.done = true; w.requests.length > 0 && w.requests[0].done; ) {
              const T2 = w.requests.shift();
              setTimeout(T2.callback, 0);
            }
          }
          const w = this.loadingContext, k2 = { id: `pdfjs-font-loading-${w.nextRequestId++}`, done: false, complete: y2, callback: I2 };
          return w.requests.push(k2), k2;
        }
        get _loadTestFont() {
          const I2 = function() {
            return atob("T1RUTwALAIAAAwAwQ0ZGIDHtZg4AAAOYAAAAgUZGVE1lkzZwAAAEHAAAABxHREVGABQAFQAABDgAAAAeT1MvMlYNYwkAAAEgAAAAYGNtYXABDQLUAAACNAAAAUJoZWFk/xVFDQAAALwAAAA2aGhlYQdkA+oAAAD0AAAAJGhtdHgD6AAAAAAEWAAAAAZtYXhwAAJQAAAAARgAAAAGbmFtZVjmdH4AAAGAAAAAsXBvc3T/hgAzAAADeAAAACAAAQAAAAEAALZRFsRfDzz1AAsD6AAAAADOBOTLAAAAAM4KHDwAAAAAA+gDIQAAAAgAAgAAAAAAAAABAAADIQAAAFoD6AAAAAAD6AABAAAAAAAAAAAAAAAAAAAAAQAAUAAAAgAAAAQD6AH0AAUAAAKKArwAAACMAooCvAAAAeAAMQECAAACAAYJAAAAAAAAAAAAAQAAAAAAAAAAAAAAAFBmRWQAwAAuAC4DIP84AFoDIQAAAAAAAQAAAAAAAAAAACAAIAABAAAADgCuAAEAAAAAAAAAAQAAAAEAAAAAAAEAAQAAAAEAAAAAAAIAAQAAAAEAAAAAAAMAAQAAAAEAAAAAAAQAAQAAAAEAAAAAAAUAAQAAAAEAAAAAAAYAAQAAAAMAAQQJAAAAAgABAAMAAQQJAAEAAgABAAMAAQQJAAIAAgABAAMAAQQJAAMAAgABAAMAAQQJAAQAAgABAAMAAQQJAAUAAgABAAMAAQQJAAYAAgABWABYAAAAAAAAAwAAAAMAAAAcAAEAAAAAADwAAwABAAAAHAAEACAAAAAEAAQAAQAAAC7//wAAAC7////TAAEAAAAAAAABBgAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAD/gwAyAAAAAQAAAAAAAAAAAAAAAAAAAAABAAQEAAEBAQJYAAEBASH4DwD4GwHEAvgcA/gXBIwMAYuL+nz5tQXkD5j3CBLnEQACAQEBIVhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYAAABAQAADwACAQEEE/t3Dov6fAH6fAT+fPp8+nwHDosMCvm1Cvm1DAz6fBQAAAAAAAABAAAAAMmJbzEAAAAAzgTjFQAAAADOBOQpAAEAAAAAAAAADAAUAAQAAAABAAAAAgABAAAAAAAAAAAD6AAAAAAAAA==");
          };
          return (0, c2.shadow)(this, "_loadTestFont", I2());
        }
        _prepareFontLoadEvent(I2, y2, w) {
          function k2(tt, H) {
            return tt.charCodeAt(H) << 24 | tt.charCodeAt(H + 1) << 16 | tt.charCodeAt(H + 2) << 8 | tt.charCodeAt(H + 3) & 255;
          }
          function T2(tt, H, Z, j) {
            const V = tt.substring(0, H), X = tt.substring(H + Z);
            return V + j + X;
          }
          let C2, l;
          const t = this._document.createElement("canvas");
          t.width = 1, t.height = 1;
          const s = t.getContext("2d");
          let a = 0;
          function h(tt, H) {
            if (a++, a > 30) {
              (0, c2.warn)("Load test font never loaded."), H();
              return;
            }
            if (s.font = "30px " + tt, s.fillText(".", 0, 20), s.getImageData(0, 0, 1, 1).data[3] > 0) {
              H();
              return;
            }
            setTimeout(h.bind(null, tt, H));
          }
          const b = `lt${Date.now()}${this.loadTestFontId++}`;
          let r = this._loadTestFont;
          r = T2(r, 976, b.length, b);
          const e = 16, o = 1482184792;
          let v = k2(r, e);
          for (C2 = 0, l = b.length - 3; C2 < l; C2 += 4) v = v - o + k2(b, C2) | 0;
          C2 < b.length && (v = v - o + k2(b + "XXX", C2) | 0), r = T2(r, e, 4, (0, c2.string32)(v));
          const m = `url(data:font/opentype;base64,${btoa(r)});`, d = `@font-face {font-family:"${b}";src:${m}}`;
          this.insertRule(d);
          const E = [];
          for (const tt of y2) E.push(tt.loadedName);
          E.push(b);
          const U = this._document.createElement("div");
          U.style.visibility = "hidden", U.style.width = U.style.height = "10px", U.style.position = "absolute", U.style.top = U.style.left = "0px";
          for (const tt of E) {
            const H = this._document.createElement("span");
            H.textContent = "Hi", H.style.fontFamily = tt, U.append(H);
          }
          this._document.body.append(U), h(b, () => {
            U.remove(), w.complete();
          });
        }
      };
      class B2 {
        constructor(I2, { isEvalSupported: y2 = true, disableFontFace: w = false, ignoreErrors: k2 = false, onUnsupportedFeature: T2, fontRegistry: C2 = null }) {
          this.compiledGlyphs = /* @__PURE__ */ Object.create(null);
          for (const l in I2) this[l] = I2[l];
          this.isEvalSupported = y2 !== false, this.disableFontFace = w === true, this.ignoreErrors = k2 === true, this._onUnsupportedFeature = T2, this.fontRegistry = C2;
        }
        createNativeFontFace() {
          if (!this.data || this.disableFontFace) return null;
          let I2;
          if (!this.cssFontInfo) I2 = new FontFace(this.loadedName, this.data, {});
          else {
            const y2 = { weight: this.cssFontInfo.fontWeight };
            this.cssFontInfo.italicAngle && (y2.style = `oblique ${this.cssFontInfo.italicAngle}deg`), I2 = new FontFace(this.cssFontInfo.fontFamily, this.data, y2);
          }
          return this.fontRegistry && this.fontRegistry.registerFont(this), I2;
        }
        createFontFaceRule() {
          if (!this.data || this.disableFontFace) return null;
          const I2 = (0, c2.bytesToString)(this.data), y2 = `url(data:${this.mimetype};base64,${btoa(I2)});`;
          let w;
          if (!this.cssFontInfo) w = `@font-face {font-family:"${this.loadedName}";src:${y2}}`;
          else {
            let k2 = `font-weight: ${this.cssFontInfo.fontWeight};`;
            this.cssFontInfo.italicAngle && (k2 += `font-style: oblique ${this.cssFontInfo.italicAngle}deg;`), w = `@font-face {font-family:"${this.cssFontInfo.fontFamily}";${k2}src:${y2}}`;
          }
          return this.fontRegistry && this.fontRegistry.registerFont(this, y2), w;
        }
        getPathGenerator(I2, y2) {
          if (this.compiledGlyphs[y2] !== void 0) return this.compiledGlyphs[y2];
          let w;
          try {
            w = I2.get(this.loadedName + "_path_" + y2);
          } catch (k2) {
            if (!this.ignoreErrors) throw k2;
            return this._onUnsupportedFeature({ featureId: c2.UNSUPPORTED_FEATURES.errorFontGetPath }), (0, c2.warn)(`getPathGenerator - ignoring character: "${k2}".`), this.compiledGlyphs[y2] = function(T2, C2) {
            };
          }
          if (this.isEvalSupported && c2.FeatureTest.isEvalSupported) {
            const k2 = [];
            for (const T2 of w) {
              const C2 = T2.args !== void 0 ? T2.args.join(",") : "";
              k2.push("c.", T2.cmd, "(", C2, `);
`);
            }
            return this.compiledGlyphs[y2] = new Function("c", "size", k2.join(""));
          }
          return this.compiledGlyphs[y2] = function(k2, T2) {
            for (const C2 of w) C2.cmd === "scale" && (C2.args = [T2, -T2]), k2[C2.cmd].apply(k2, C2.args);
          };
        }
      }
      f2.FontFaceObject = B2;
    }, (z2, f2, $2) => {
      var at, de;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.CanvasGraphics = void 0;
      var c2 = $2(8), S2 = $2(1), q2 = $2(13), B2 = $2(14), Q2 = $2(3);
      const I2 = 16, y2 = 100, w = 4096, k2 = 15, T2 = 10, C2 = Q2.isNodeJS && typeof Path2D > "u" ? -1 : 1e3, l = 16;
      function t(N, p) {
        if (N._removeMirroring) throw new Error("Context is already forwarding operations.");
        N.__originalSave = N.save, N.__originalRestore = N.restore, N.__originalRotate = N.rotate, N.__originalScale = N.scale, N.__originalTranslate = N.translate, N.__originalTransform = N.transform, N.__originalSetTransform = N.setTransform, N.__originalResetTransform = N.resetTransform, N.__originalClip = N.clip, N.__originalMoveTo = N.moveTo, N.__originalLineTo = N.lineTo, N.__originalBezierCurveTo = N.bezierCurveTo, N.__originalRect = N.rect, N.__originalClosePath = N.closePath, N.__originalBeginPath = N.beginPath, N._removeMirroring = () => {
          N.save = N.__originalSave, N.restore = N.__originalRestore, N.rotate = N.__originalRotate, N.scale = N.__originalScale, N.translate = N.__originalTranslate, N.transform = N.__originalTransform, N.setTransform = N.__originalSetTransform, N.resetTransform = N.__originalResetTransform, N.clip = N.__originalClip, N.moveTo = N.__originalMoveTo, N.lineTo = N.__originalLineTo, N.bezierCurveTo = N.__originalBezierCurveTo, N.rect = N.__originalRect, N.closePath = N.__originalClosePath, N.beginPath = N.__originalBeginPath, delete N._removeMirroring;
        }, N.save = function() {
          p.save(), this.__originalSave();
        }, N.restore = function() {
          p.restore(), this.__originalRestore();
        }, N.translate = function(P, F) {
          p.translate(P, F), this.__originalTranslate(P, F);
        }, N.scale = function(P, F) {
          p.scale(P, F), this.__originalScale(P, F);
        }, N.transform = function(P, F, D, O, Y, K) {
          p.transform(P, F, D, O, Y, K), this.__originalTransform(P, F, D, O, Y, K);
        }, N.setTransform = function(P, F, D, O, Y, K) {
          p.setTransform(P, F, D, O, Y, K), this.__originalSetTransform(P, F, D, O, Y, K);
        }, N.resetTransform = function() {
          p.resetTransform(), this.__originalResetTransform();
        }, N.rotate = function(P) {
          p.rotate(P), this.__originalRotate(P);
        }, N.clip = function(P) {
          p.clip(P), this.__originalClip(P);
        }, N.moveTo = function(u, P) {
          p.moveTo(u, P), this.__originalMoveTo(u, P);
        }, N.lineTo = function(u, P) {
          p.lineTo(u, P), this.__originalLineTo(u, P);
        }, N.bezierCurveTo = function(u, P, F, D, O, Y) {
          p.bezierCurveTo(u, P, F, D, O, Y), this.__originalBezierCurveTo(u, P, F, D, O, Y);
        }, N.rect = function(u, P, F, D) {
          p.rect(u, P, F, D), this.__originalRect(u, P, F, D);
        }, N.closePath = function() {
          p.closePath(), this.__originalClosePath();
        }, N.beginPath = function() {
          p.beginPath(), this.__originalBeginPath();
        };
      }
      class s {
        constructor(p) {
          this.canvasFactory = p, this.cache = /* @__PURE__ */ Object.create(null);
        }
        getCanvas(p, u, P) {
          let F;
          return this.cache[p] !== void 0 ? (F = this.cache[p], this.canvasFactory.reset(F, u, P)) : (F = this.canvasFactory.create(u, P), this.cache[p] = F), F;
        }
        delete(p) {
          delete this.cache[p];
        }
        clear() {
          for (const p in this.cache) {
            const u = this.cache[p];
            this.canvasFactory.destroy(u), delete this.cache[p];
          }
        }
      }
      function a(N, p, u, P, F, D, O, Y, K, i) {
        const [_, g, A, x, L, st] = (0, c2.getCurrentTransform)(N);
        if (g === 0 && A === 0) {
          const rt = O * _ + L, et = Math.round(rt), ot = Y * x + st, ut = Math.round(ot), M = (O + K) * _ + L, ht = Math.abs(Math.round(M) - et) || 1, yt = (Y + i) * x + st, vt = Math.abs(Math.round(yt) - ut) || 1;
          return N.setTransform(Math.sign(_), 0, 0, Math.sign(x), et, ut), N.drawImage(p, u, P, F, D, 0, 0, ht, vt), N.setTransform(_, g, A, x, L, st), [ht, vt];
        }
        if (_ === 0 && x === 0) {
          const rt = Y * A + L, et = Math.round(rt), ot = O * g + st, ut = Math.round(ot), M = (Y + i) * A + L, ht = Math.abs(Math.round(M) - et) || 1, yt = (O + K) * g + st, vt = Math.abs(Math.round(yt) - ut) || 1;
          return N.setTransform(0, Math.sign(g), Math.sign(A), 0, et, ut), N.drawImage(p, u, P, F, D, 0, 0, vt, ht), N.setTransform(_, g, A, x, L, st), [vt, ht];
        }
        N.drawImage(p, u, P, F, D, O, Y, K, i);
        const it = Math.hypot(_, g), J = Math.hypot(A, x);
        return [it * K, J * i];
      }
      function h(N) {
        const { width: p, height: u } = N;
        if (p > C2 || u > C2) return null;
        const P = 1e3, F = new Uint8Array([0, 2, 4, 0, 1, 0, 5, 4, 8, 10, 0, 8, 0, 2, 1, 0]), D = p + 1;
        let O = new Uint8Array(D * (u + 1)), Y, K, i;
        const _ = p + 7 & -8;
        let g = new Uint8Array(_ * u), A = 0;
        for (const J of N.data) {
          let rt = 128;
          for (; rt > 0; ) g[A++] = J & rt ? 0 : 255, rt >>= 1;
        }
        let x = 0;
        for (A = 0, g[A] !== 0 && (O[0] = 1, ++x), K = 1; K < p; K++) g[A] !== g[A + 1] && (O[K] = g[A] ? 2 : 1, ++x), A++;
        for (g[A] !== 0 && (O[K] = 2, ++x), Y = 1; Y < u; Y++) {
          A = Y * _, i = Y * D, g[A - _] !== g[A] && (O[i] = g[A] ? 1 : 8, ++x);
          let J = (g[A] ? 4 : 0) + (g[A - _] ? 8 : 0);
          for (K = 1; K < p; K++) J = (J >> 2) + (g[A + 1] ? 4 : 0) + (g[A - _ + 1] ? 8 : 0), F[J] && (O[i + K] = F[J], ++x), A++;
          if (g[A - _] !== g[A] && (O[i + K] = g[A] ? 2 : 4, ++x), x > P) return null;
        }
        for (A = _ * (u - 1), i = Y * D, g[A] !== 0 && (O[i] = 8, ++x), K = 1; K < p; K++) g[A] !== g[A + 1] && (O[i + K] = g[A] ? 4 : 8, ++x), A++;
        if (g[A] !== 0 && (O[i + K] = 4, ++x), x > P) return null;
        const L = new Int32Array([0, D, -1, 0, -D, 0, 0, 0, 1]), st = new Path2D();
        for (Y = 0; x && Y <= u; Y++) {
          let J = Y * D;
          const rt = J + p;
          for (; J < rt && !O[J]; ) J++;
          if (J === rt) continue;
          st.moveTo(J % D, Y);
          const et = J;
          let ot = O[J];
          do {
            const ut = L[ot];
            do
              J += ut;
            while (!O[J]);
            const M = O[J];
            M !== 5 && M !== 10 ? (ot = M, O[J] = 0) : (ot = M & 51 * ot >> 4, O[J] &= ot >> 2 | ot << 2), st.lineTo(J % D, J / D | 0), O[J] || --x;
          } while (et !== J);
          --Y;
        }
        return g = null, O = null, function(J) {
          J.save(), J.scale(1 / p, -1 / u), J.translate(0, -u), J.fill(st), J.beginPath(), J.restore();
        };
      }
      class b {
        constructor(p, u) {
          this.alphaIsShape = false, this.fontSize = 0, this.fontSizeScale = 1, this.textMatrix = S2.IDENTITY_MATRIX, this.textMatrixScale = 1, this.fontMatrix = S2.FONT_IDENTITY_MATRIX, this.leading = 0, this.x = 0, this.y = 0, this.lineX = 0, this.lineY = 0, this.charSpacing = 0, this.wordSpacing = 0, this.textHScale = 1, this.textRenderingMode = S2.TextRenderingMode.FILL, this.textRise = 0, this.fillColor = "#000000", this.strokeColor = "#000000", this.patternFill = false, this.fillAlpha = 1, this.strokeAlpha = 1, this.lineWidth = 1, this.activeSMask = null, this.transferMaps = null, this.startNewPathAndClipBox([0, 0, p, u]);
        }
        clone() {
          const p = Object.create(this);
          return p.clipBox = this.clipBox.slice(), p;
        }
        setCurrentPoint(p, u) {
          this.x = p, this.y = u;
        }
        updatePathMinMax(p, u, P) {
          [u, P] = S2.Util.applyTransform([u, P], p), this.minX = Math.min(this.minX, u), this.minY = Math.min(this.minY, P), this.maxX = Math.max(this.maxX, u), this.maxY = Math.max(this.maxY, P);
        }
        updateRectMinMax(p, u) {
          const P = S2.Util.applyTransform(u, p), F = S2.Util.applyTransform(u.slice(2), p);
          this.minX = Math.min(this.minX, P[0], F[0]), this.minY = Math.min(this.minY, P[1], F[1]), this.maxX = Math.max(this.maxX, P[0], F[0]), this.maxY = Math.max(this.maxY, P[1], F[1]);
        }
        updateScalingPathMinMax(p, u) {
          S2.Util.scaleMinMax(p, u), this.minX = Math.min(this.minX, u[0]), this.maxX = Math.max(this.maxX, u[1]), this.minY = Math.min(this.minY, u[2]), this.maxY = Math.max(this.maxY, u[3]);
        }
        updateCurvePathMinMax(p, u, P, F, D, O, Y, K, i, _) {
          const g = S2.Util.bezierBoundingBox(u, P, F, D, O, Y, K, i);
          if (_) {
            _[0] = Math.min(_[0], g[0], g[2]), _[1] = Math.max(_[1], g[0], g[2]), _[2] = Math.min(_[2], g[1], g[3]), _[3] = Math.max(_[3], g[1], g[3]);
            return;
          }
          this.updateRectMinMax(p, g);
        }
        getPathBoundingBox(p = q2.PathType.FILL, u = null) {
          const P = [this.minX, this.minY, this.maxX, this.maxY];
          if (p === q2.PathType.STROKE) {
            u || (0, S2.unreachable)("Stroke bounding box must include transform.");
            const F = S2.Util.singularValueDecompose2dScale(u), D = F[0] * this.lineWidth / 2, O = F[1] * this.lineWidth / 2;
            P[0] -= D, P[1] -= O, P[2] += D, P[3] += O;
          }
          return P;
        }
        updateClipFromPath() {
          const p = S2.Util.intersect(this.clipBox, this.getPathBoundingBox());
          this.startNewPathAndClipBox(p || [0, 0, 0, 0]);
        }
        isEmptyClip() {
          return this.minX === 1 / 0;
        }
        startNewPathAndClipBox(p) {
          this.clipBox = p, this.minX = 1 / 0, this.minY = 1 / 0, this.maxX = 0, this.maxY = 0;
        }
        getClippedPathBoundingBox(p = q2.PathType.FILL, u = null) {
          return S2.Util.intersect(this.clipBox, this.getPathBoundingBox(p, u));
        }
      }
      function r(N, p, u = null) {
        if (typeof ImageData < "u" && p instanceof ImageData) {
          N.putImageData(p, 0, 0);
          return;
        }
        const P = p.height, F = p.width, D = P % l, O = (P - D) / l, Y = D === 0 ? O : O + 1, K = N.createImageData(F, l);
        let i = 0, _;
        const g = p.data, A = K.data;
        let x, L, st, it, J, rt, et, ot;
        if (u) switch (u.length) {
          case 1:
            J = u[0], rt = u[0], et = u[0], ot = u[0];
            break;
          case 4:
            J = u[0], rt = u[1], et = u[2], ot = u[3];
            break;
        }
        if (p.kind === S2.ImageKind.GRAYSCALE_1BPP) {
          const ut = g.byteLength, M = new Uint32Array(A.buffer, 0, A.byteLength >> 2), ht = M.length, yt = F + 7 >> 3;
          let vt = 4294967295, Ct = S2.FeatureTest.isLittleEndian ? 4278190080 : 255;
          for (ot && ot[0] === 255 && ot[255] === 0 && ([vt, Ct] = [Ct, vt]), x = 0; x < Y; x++) {
            for (st = x < O ? l : D, _ = 0, L = 0; L < st; L++) {
              const wt = ut - i;
              let It = 0;
              const Rt = wt > yt ? F : wt * 8 - 7, $t = Rt & -8;
              let Et = 0, Ft = 0;
              for (; It < $t; It += 8) Ft = g[i++], M[_++] = Ft & 128 ? vt : Ct, M[_++] = Ft & 64 ? vt : Ct, M[_++] = Ft & 32 ? vt : Ct, M[_++] = Ft & 16 ? vt : Ct, M[_++] = Ft & 8 ? vt : Ct, M[_++] = Ft & 4 ? vt : Ct, M[_++] = Ft & 2 ? vt : Ct, M[_++] = Ft & 1 ? vt : Ct;
              for (; It < Rt; It++) Et === 0 && (Ft = g[i++], Et = 128), M[_++] = Ft & Et ? vt : Ct, Et >>= 1;
            }
            for (; _ < ht; ) M[_++] = 0;
            N.putImageData(K, 0, x * l);
          }
        } else if (p.kind === S2.ImageKind.RGBA_32BPP) {
          const ut = !!(J || rt || et);
          for (L = 0, it = F * l * 4, x = 0; x < O; x++) {
            if (A.set(g.subarray(i, i + it)), i += it, ut) for (let M = 0; M < it; M += 4) J && (A[M + 0] = J[A[M + 0]]), rt && (A[M + 1] = rt[A[M + 1]]), et && (A[M + 2] = et[A[M + 2]]);
            N.putImageData(K, 0, L), L += l;
          }
          if (x < Y) {
            if (it = F * D * 4, A.set(g.subarray(i, i + it)), ut) for (let M = 0; M < it; M += 4) J && (A[M + 0] = J[A[M + 0]]), rt && (A[M + 1] = rt[A[M + 1]]), et && (A[M + 2] = et[A[M + 2]]);
            N.putImageData(K, 0, L);
          }
        } else if (p.kind === S2.ImageKind.RGB_24BPP) {
          const ut = !!(J || rt || et);
          for (st = l, it = F * st, x = 0; x < Y; x++) {
            for (x >= O && (st = D, it = F * st), _ = 0, L = it; L--; ) A[_++] = g[i++], A[_++] = g[i++], A[_++] = g[i++], A[_++] = 255;
            if (ut) for (let M = 0; M < _; M += 4) J && (A[M + 0] = J[A[M + 0]]), rt && (A[M + 1] = rt[A[M + 1]]), et && (A[M + 2] = et[A[M + 2]]);
            N.putImageData(K, 0, x * l);
          }
        } else throw new Error(`bad image kind: ${p.kind}`);
      }
      function n(N, p) {
        if (p.bitmap) {
          N.drawImage(p.bitmap, 0, 0);
          return;
        }
        const u = p.height, P = p.width, F = u % l, D = (u - F) / l, O = F === 0 ? D : D + 1, Y = N.createImageData(P, l);
        let K = 0;
        const i = p.data, _ = Y.data;
        for (let g = 0; g < O; g++) {
          const A = g < D ? l : F;
          ({ srcPos: K } = (0, B2.applyMaskImageData)({ src: i, srcPos: K, dest: _, width: P, height: A })), N.putImageData(Y, 0, g * l);
        }
      }
      function e(N, p) {
        const u = ["strokeStyle", "fillStyle", "fillRule", "globalAlpha", "lineWidth", "lineCap", "lineJoin", "miterLimit", "globalCompositeOperation", "font"];
        for (let P = 0, F = u.length; P < F; P++) {
          const D = u[P];
          N[D] !== void 0 && (p[D] = N[D]);
        }
        N.setLineDash !== void 0 && (p.setLineDash(N.getLineDash()), p.lineDashOffset = N.lineDashOffset);
      }
      function o(N, p) {
        N.strokeStyle = N.fillStyle = p || "#000000", N.fillRule = "nonzero", N.globalAlpha = 1, N.lineWidth = 1, N.lineCap = "butt", N.lineJoin = "miter", N.miterLimit = 10, N.globalCompositeOperation = "source-over", N.font = "10px sans-serif", N.setLineDash !== void 0 && (N.setLineDash([]), N.lineDashOffset = 0);
      }
      function v(N, p, u, P) {
        const F = N.length;
        for (let D = 3; D < F; D += 4) {
          const O = N[D];
          if (O === 0) N[D - 3] = p, N[D - 2] = u, N[D - 1] = P;
          else if (O < 255) {
            const Y = 255 - O;
            N[D - 3] = N[D - 3] * O + p * Y >> 8, N[D - 2] = N[D - 2] * O + u * Y >> 8, N[D - 1] = N[D - 1] * O + P * Y >> 8;
          }
        }
      }
      function m(N, p, u) {
        const P = N.length, F = 1 / 255;
        for (let D = 3; D < P; D += 4) {
          const O = u ? u[N[D]] : N[D];
          p[D] = p[D] * O * F | 0;
        }
      }
      function d(N, p, u) {
        const P = N.length;
        for (let F = 3; F < P; F += 4) {
          const D = N[F - 3] * 77 + N[F - 2] * 152 + N[F - 1] * 28;
          p[F] = u ? p[F] * u[D >> 8] >> 8 : p[F] * D >> 16;
        }
      }
      function E(N, p, u, P, F, D, O, Y, K, i, _) {
        const g = !!D, A = g ? D[0] : 0, x = g ? D[1] : 0, L = g ? D[2] : 0;
        let st;
        F === "Luminosity" ? st = d : st = m;
        const J = Math.min(P, Math.ceil(1048576 / u));
        for (let rt = 0; rt < P; rt += J) {
          const et = Math.min(J, P - rt), ot = N.getImageData(Y - i, rt + (K - _), u, et), ut = p.getImageData(Y, rt + K, u, et);
          g && v(ot.data, A, x, L), st(ot.data, ut.data, O), p.putImageData(ut, Y, rt + K);
        }
      }
      function U(N, p, u, P) {
        const F = P[0], D = P[1], O = P[2] - F, Y = P[3] - D;
        O === 0 || Y === 0 || (E(p.context, u, O, Y, p.subtype, p.backdrop, p.transferMap, F, D, p.offsetX, p.offsetY), N.save(), N.globalAlpha = 1, N.globalCompositeOperation = "source-over", N.setTransform(1, 0, 0, 1, 0, 0), N.drawImage(u.canvas, 0, 0), N.restore());
      }
      function tt(N, p) {
        const u = S2.Util.singularValueDecompose2dScale(N);
        u[0] = Math.fround(u[0]), u[1] = Math.fround(u[1]);
        const P = Math.fround((globalThis.devicePixelRatio || 1) * c2.PixelsPerInch.PDF_TO_CSS_UNITS);
        return p !== void 0 ? p : u[0] <= P || u[1] <= P;
      }
      const H = ["butt", "round", "square"], Z = ["miter", "round", "bevel"], j = {}, V = {}, bt = class bt2 {
        constructor(p, u, P, F, D, O, Y, K) {
          ct(this, at);
          this.ctx = p, this.current = new b(this.ctx.canvas.width, this.ctx.canvas.height), this.stateStack = [], this.pendingClip = null, this.pendingEOFill = false, this.res = null, this.xobjs = null, this.commonObjs = u, this.objs = P, this.canvasFactory = F, this.imageLayer = D, this.groupStack = [], this.processingType3 = null, this.baseTransform = null, this.baseTransformStack = [], this.groupLevel = 0, this.smaskStack = [], this.smaskCounter = 0, this.tempSMask = null, this.suspendedCtx = null, this.contentVisible = true, this.markedContentStack = [], this.optionalContentConfig = O, this.cachedCanvases = new s(this.canvasFactory), this.cachedPatterns = /* @__PURE__ */ new Map(), this.annotationCanvasMap = Y, this.viewportScale = 1, this.outputScaleX = 1, this.outputScaleY = 1, this.backgroundColor = (K == null ? void 0 : K.background) || null, this.foregroundColor = (K == null ? void 0 : K.foreground) || null, this._cachedScaleForStroking = null, this._cachedGetSinglePixelWidth = null, this._cachedBitmapsMap = /* @__PURE__ */ new Map();
        }
        getObject(p, u = null) {
          return typeof p == "string" ? p.startsWith("g_") ? this.commonObjs.get(p) : this.objs.get(p) : u;
        }
        beginDrawing({ transform: p, viewport: u, transparency: P = false, background: F = null }) {
          const D = this.ctx.canvas.width, O = this.ctx.canvas.height, Y = F || "#ffffff";
          if (this.ctx.save(), this.foregroundColor && this.backgroundColor) {
            this.ctx.fillStyle = this.foregroundColor;
            const K = this.foregroundColor = this.ctx.fillStyle;
            this.ctx.fillStyle = this.backgroundColor;
            const i = this.backgroundColor = this.ctx.fillStyle;
            let _ = true, g = Y;
            if (this.ctx.fillStyle = Y, g = this.ctx.fillStyle, _ = typeof g == "string" && /^#[0-9A-Fa-f]{6}$/.test(g), K === "#000000" && i === "#ffffff" || K === i || !_) this.foregroundColor = this.backgroundColor = null;
            else {
              const [A, x, L] = (0, c2.getRGB)(g), st = (J) => (J /= 255, J <= 0.03928 ? J / 12.92 : ((J + 0.055) / 1.055) ** 2.4), it = Math.round(0.2126 * st(A) + 0.7152 * st(x) + 0.0722 * st(L));
              this.selectColor = (J, rt, et) => {
                const ot = 0.2126 * st(J) + 0.7152 * st(rt) + 0.0722 * st(et);
                return Math.round(ot) === it ? i : K;
              };
            }
          }
          if (this.ctx.fillStyle = this.backgroundColor || Y, this.ctx.fillRect(0, 0, D, O), this.ctx.restore(), P) {
            const K = this.cachedCanvases.getCanvas("transparent", D, O);
            this.compositeCtx = this.ctx, this.transparentCanvas = K.canvas, this.ctx = K.context, this.ctx.save(), this.ctx.transform(...(0, c2.getCurrentTransform)(this.compositeCtx));
          }
          this.ctx.save(), o(this.ctx, this.foregroundColor), p && (this.ctx.transform(...p), this.outputScaleX = p[0], this.outputScaleY = p[0]), this.ctx.transform(...u.transform), this.viewportScale = u.scale, this.baseTransform = (0, c2.getCurrentTransform)(this.ctx), this.imageLayer && ((0, c2.deprecated)("The `imageLayer` functionality will be removed in the future."), this.imageLayer.beginLayout());
        }
        executeOperatorList(p, u, P, F) {
          const D = p.argsArray, O = p.fnArray;
          let Y = u || 0;
          const K = D.length;
          if (K === Y) return Y;
          const i = K - Y > T2 && typeof P == "function", _ = i ? Date.now() + k2 : 0;
          let g = 0;
          const A = this.commonObjs, x = this.objs;
          let L;
          for (; ; ) {
            if (F !== void 0 && Y === F.nextBreakPoint) return F.breakIt(Y, P), Y;
            if (L = O[Y], L !== S2.OPS.dependency) this[L].apply(this, D[Y]);
            else for (const st of D[Y]) {
              const it = st.startsWith("g_") ? A : x;
              if (!it.has(st)) return it.get(st, P), Y;
            }
            if (Y++, Y === K) return Y;
            if (i && ++g > T2) {
              if (Date.now() > _) return P(), Y;
              g = 0;
            }
          }
        }
        endDrawing() {
          ft(this, at, de).call(this), this.cachedCanvases.clear(), this.cachedPatterns.clear();
          for (const p of this._cachedBitmapsMap.values()) {
            for (const u of p.values()) typeof HTMLCanvasElement < "u" && u instanceof HTMLCanvasElement && (u.width = u.height = 0);
            p.clear();
          }
          this._cachedBitmapsMap.clear(), this.imageLayer && this.imageLayer.endLayout();
        }
        _scaleImage(p, u) {
          const P = p.width, F = p.height;
          let D = Math.max(Math.hypot(u[0], u[1]), 1), O = Math.max(Math.hypot(u[2], u[3]), 1), Y = P, K = F, i = "prescale1", _, g;
          for (; D > 2 && Y > 1 || O > 2 && K > 1; ) {
            let A = Y, x = K;
            D > 2 && Y > 1 && (A = Math.ceil(Y / 2), D /= Y / A), O > 2 && K > 1 && (x = Math.ceil(K / 2), O /= K / x), _ = this.cachedCanvases.getCanvas(i, A, x), g = _.context, g.clearRect(0, 0, A, x), g.drawImage(p, 0, 0, Y, K, 0, 0, A, x), p = _.canvas, Y = A, K = x, i = i === "prescale1" ? "prescale2" : "prescale1";
          }
          return { img: p, paintWidth: Y, paintHeight: K };
        }
        _createMaskCanvas(p) {
          const u = this.ctx, { width: P, height: F } = p, D = this.current.fillColor, O = this.current.patternFill, Y = (0, c2.getCurrentTransform)(u);
          let K, i, _, g;
          if ((p.bitmap || p.data) && p.count > 1) {
            const ht = p.bitmap || p.data.buffer, yt = Y.slice(0, 4);
            i = JSON.stringify(O ? yt : [yt, D]), K = this._cachedBitmapsMap.get(ht), K || (K = /* @__PURE__ */ new Map(), this._cachedBitmapsMap.set(ht, K));
            const vt = K.get(i);
            if (vt && !O) {
              const Ct = Math.round(Math.min(Y[0], Y[2]) + Y[4]), wt = Math.round(Math.min(Y[1], Y[3]) + Y[5]);
              return { canvas: vt, offsetX: Ct, offsetY: wt };
            }
            _ = vt;
          }
          _ || (g = this.cachedCanvases.getCanvas("maskCanvas", P, F), n(g.context, p));
          let A = S2.Util.transform(Y, [1 / P, 0, 0, -1 / F, 0, 0]);
          A = S2.Util.transform(A, [1, 0, 0, 1, 0, -F]);
          const x = S2.Util.applyTransform([0, 0], A), L = S2.Util.applyTransform([P, F], A), st = S2.Util.normalizeRect([x[0], x[1], L[0], L[1]]), it = Math.round(st[2] - st[0]) || 1, J = Math.round(st[3] - st[1]) || 1, rt = this.cachedCanvases.getCanvas("fillCanvas", it, J), et = rt.context, ot = Math.min(x[0], L[0]), ut = Math.min(x[1], L[1]);
          et.translate(-ot, -ut), et.transform(...A), _ || (_ = this._scaleImage(g.canvas, (0, c2.getCurrentTransformInverse)(et)), _ = _.img, K && O && K.set(i, _)), et.imageSmoothingEnabled = tt((0, c2.getCurrentTransform)(et), p.interpolate), a(et, _, 0, 0, _.width, _.height, 0, 0, P, F), et.globalCompositeOperation = "source-in";
          const M = S2.Util.transform((0, c2.getCurrentTransformInverse)(et), [1, 0, 0, 1, -ot, -ut]);
          return et.fillStyle = O ? D.getPattern(u, this, M, q2.PathType.FILL) : D, et.fillRect(0, 0, P, F), K && !O && (this.cachedCanvases.delete("fillCanvas"), K.set(i, rt.canvas)), { canvas: rt.canvas, offsetX: Math.round(ot), offsetY: Math.round(ut) };
        }
        setLineWidth(p) {
          p !== this.current.lineWidth && (this._cachedScaleForStroking = null), this.current.lineWidth = p, this.ctx.lineWidth = p;
        }
        setLineCap(p) {
          this.ctx.lineCap = H[p];
        }
        setLineJoin(p) {
          this.ctx.lineJoin = Z[p];
        }
        setMiterLimit(p) {
          this.ctx.miterLimit = p;
        }
        setDash(p, u) {
          const P = this.ctx;
          P.setLineDash !== void 0 && (P.setLineDash(p), P.lineDashOffset = u);
        }
        setRenderingIntent(p) {
        }
        setFlatness(p) {
        }
        setGState(p) {
          for (let u = 0, P = p.length; u < P; u++) {
            const F = p[u], D = F[0], O = F[1];
            switch (D) {
              case "LW":
                this.setLineWidth(O);
                break;
              case "LC":
                this.setLineCap(O);
                break;
              case "LJ":
                this.setLineJoin(O);
                break;
              case "ML":
                this.setMiterLimit(O);
                break;
              case "D":
                this.setDash(O[0], O[1]);
                break;
              case "RI":
                this.setRenderingIntent(O);
                break;
              case "FL":
                this.setFlatness(O);
                break;
              case "Font":
                this.setFont(O[0], O[1]);
                break;
              case "CA":
                this.current.strokeAlpha = F[1];
                break;
              case "ca":
                this.current.fillAlpha = F[1], this.ctx.globalAlpha = F[1];
                break;
              case "BM":
                this.ctx.globalCompositeOperation = O;
                break;
              case "SMask":
                this.current.activeSMask = O ? this.tempSMask : null, this.tempSMask = null, this.checkSMaskState();
                break;
              case "TR":
                this.current.transferMaps = O;
            }
          }
        }
        get inSMaskMode() {
          return !!this.suspendedCtx;
        }
        checkSMaskState() {
          const p = this.inSMaskMode;
          this.current.activeSMask && !p ? this.beginSMaskMode() : !this.current.activeSMask && p && this.endSMaskMode();
        }
        beginSMaskMode() {
          if (this.inSMaskMode) throw new Error("beginSMaskMode called while already in smask mode");
          const p = this.ctx.canvas.width, u = this.ctx.canvas.height, P = "smaskGroupAt" + this.groupLevel, F = this.cachedCanvases.getCanvas(P, p, u);
          this.suspendedCtx = this.ctx, this.ctx = F.context;
          const D = this.ctx;
          D.setTransform(...(0, c2.getCurrentTransform)(this.suspendedCtx)), e(this.suspendedCtx, D), t(D, this.suspendedCtx), this.setGState([["BM", "source-over"], ["ca", 1], ["CA", 1]]);
        }
        endSMaskMode() {
          if (!this.inSMaskMode) throw new Error("endSMaskMode called while not in smask mode");
          this.ctx._removeMirroring(), e(this.ctx, this.suspendedCtx), this.ctx = this.suspendedCtx, this.suspendedCtx = null;
        }
        compose(p) {
          if (!this.current.activeSMask) return;
          p ? (p[0] = Math.floor(p[0]), p[1] = Math.floor(p[1]), p[2] = Math.ceil(p[2]), p[3] = Math.ceil(p[3])) : p = [0, 0, this.ctx.canvas.width, this.ctx.canvas.height];
          const u = this.current.activeSMask, P = this.suspendedCtx;
          U(P, u, this.ctx, p), this.ctx.save(), this.ctx.setTransform(1, 0, 0, 1, 0, 0), this.ctx.clearRect(0, 0, this.ctx.canvas.width, this.ctx.canvas.height), this.ctx.restore();
        }
        save() {
          this.inSMaskMode ? (e(this.ctx, this.suspendedCtx), this.suspendedCtx.save()) : this.ctx.save();
          const p = this.current;
          this.stateStack.push(p), this.current = p.clone();
        }
        restore() {
          this.stateStack.length === 0 && this.inSMaskMode && this.endSMaskMode(), this.stateStack.length !== 0 && (this.current = this.stateStack.pop(), this.inSMaskMode ? (this.suspendedCtx.restore(), e(this.suspendedCtx, this.ctx)) : this.ctx.restore(), this.checkSMaskState(), this.pendingClip = null, this._cachedScaleForStroking = null, this._cachedGetSinglePixelWidth = null);
        }
        transform(p, u, P, F, D, O) {
          this.ctx.transform(p, u, P, F, D, O), this._cachedScaleForStroking = null, this._cachedGetSinglePixelWidth = null;
        }
        constructPath(p, u, P) {
          const F = this.ctx, D = this.current;
          let O = D.x, Y = D.y, K, i;
          const _ = (0, c2.getCurrentTransform)(F), g = _[0] === 0 && _[3] === 0 || _[1] === 0 && _[2] === 0, A = g ? P.slice(0) : null;
          for (let x = 0, L = 0, st = p.length; x < st; x++) switch (p[x] | 0) {
            case S2.OPS.rectangle:
              O = u[L++], Y = u[L++];
              const it = u[L++], J = u[L++], rt = O + it, et = Y + J;
              F.moveTo(O, Y), it === 0 || J === 0 ? F.lineTo(rt, et) : (F.lineTo(rt, Y), F.lineTo(rt, et), F.lineTo(O, et)), g || D.updateRectMinMax(_, [O, Y, rt, et]), F.closePath();
              break;
            case S2.OPS.moveTo:
              O = u[L++], Y = u[L++], F.moveTo(O, Y), g || D.updatePathMinMax(_, O, Y);
              break;
            case S2.OPS.lineTo:
              O = u[L++], Y = u[L++], F.lineTo(O, Y), g || D.updatePathMinMax(_, O, Y);
              break;
            case S2.OPS.curveTo:
              K = O, i = Y, O = u[L + 4], Y = u[L + 5], F.bezierCurveTo(u[L], u[L + 1], u[L + 2], u[L + 3], O, Y), D.updateCurvePathMinMax(_, K, i, u[L], u[L + 1], u[L + 2], u[L + 3], O, Y, A), L += 6;
              break;
            case S2.OPS.curveTo2:
              K = O, i = Y, F.bezierCurveTo(O, Y, u[L], u[L + 1], u[L + 2], u[L + 3]), D.updateCurvePathMinMax(_, K, i, O, Y, u[L], u[L + 1], u[L + 2], u[L + 3], A), O = u[L + 2], Y = u[L + 3], L += 4;
              break;
            case S2.OPS.curveTo3:
              K = O, i = Y, O = u[L + 2], Y = u[L + 3], F.bezierCurveTo(u[L], u[L + 1], O, Y, O, Y), D.updateCurvePathMinMax(_, K, i, u[L], u[L + 1], O, Y, O, Y, A), L += 4;
              break;
            case S2.OPS.closePath:
              F.closePath();
              break;
          }
          g && D.updateScalingPathMinMax(_, A), D.setCurrentPoint(O, Y);
        }
        closePath() {
          this.ctx.closePath();
        }
        stroke(p) {
          p = typeof p < "u" ? p : true;
          const u = this.ctx, P = this.current.strokeColor;
          u.globalAlpha = this.current.strokeAlpha, this.contentVisible && (typeof P == "object" && (P != null && P.getPattern) ? (u.save(), u.strokeStyle = P.getPattern(u, this, (0, c2.getCurrentTransformInverse)(u), q2.PathType.STROKE), this.rescaleAndStroke(false), u.restore()) : this.rescaleAndStroke(true)), p && this.consumePath(this.current.getClippedPathBoundingBox()), u.globalAlpha = this.current.fillAlpha;
        }
        closeStroke() {
          this.closePath(), this.stroke();
        }
        fill(p) {
          p = typeof p < "u" ? p : true;
          const u = this.ctx, P = this.current.fillColor, F = this.current.patternFill;
          let D = false;
          F && (u.save(), u.fillStyle = P.getPattern(u, this, (0, c2.getCurrentTransformInverse)(u), q2.PathType.FILL), D = true);
          const O = this.current.getClippedPathBoundingBox();
          this.contentVisible && O !== null && (this.pendingEOFill ? (u.fill("evenodd"), this.pendingEOFill = false) : u.fill()), D && u.restore(), p && this.consumePath(O);
        }
        eoFill() {
          this.pendingEOFill = true, this.fill();
        }
        fillStroke() {
          this.fill(false), this.stroke(false), this.consumePath();
        }
        eoFillStroke() {
          this.pendingEOFill = true, this.fillStroke();
        }
        closeFillStroke() {
          this.closePath(), this.fillStroke();
        }
        closeEOFillStroke() {
          this.pendingEOFill = true, this.closePath(), this.fillStroke();
        }
        endPath() {
          this.consumePath();
        }
        clip() {
          this.pendingClip = j;
        }
        eoClip() {
          this.pendingClip = V;
        }
        beginText() {
          this.current.textMatrix = S2.IDENTITY_MATRIX, this.current.textMatrixScale = 1, this.current.x = this.current.lineX = 0, this.current.y = this.current.lineY = 0;
        }
        endText() {
          const p = this.pendingTextPaths, u = this.ctx;
          if (p === void 0) {
            u.beginPath();
            return;
          }
          u.save(), u.beginPath();
          for (const P of p) u.setTransform(...P.transform), u.translate(P.x, P.y), P.addToPath(u, P.fontSize);
          u.restore(), u.clip(), u.beginPath(), delete this.pendingTextPaths;
        }
        setCharSpacing(p) {
          this.current.charSpacing = p;
        }
        setWordSpacing(p) {
          this.current.wordSpacing = p;
        }
        setHScale(p) {
          this.current.textHScale = p / 100;
        }
        setLeading(p) {
          this.current.leading = -p;
        }
        setFont(p, u) {
          const P = this.commonObjs.get(p), F = this.current;
          if (!P) throw new Error(`Can't find font for ${p}`);
          if (F.fontMatrix = P.fontMatrix || S2.FONT_IDENTITY_MATRIX, (F.fontMatrix[0] === 0 || F.fontMatrix[3] === 0) && (0, S2.warn)("Invalid font matrix for font " + p), u < 0 ? (u = -u, F.fontDirection = -1) : F.fontDirection = 1, this.current.font = P, this.current.fontSize = u, P.isType3Font) return;
          const D = P.loadedName || "sans-serif";
          let O = "normal";
          P.black ? O = "900" : P.bold && (O = "bold");
          const Y = P.italic ? "italic" : "normal", K = `"${D}", ${P.fallbackName}`;
          let i = u;
          u < I2 ? i = I2 : u > y2 && (i = y2), this.current.fontSizeScale = u / i, this.ctx.font = `${Y} ${O} ${i}px ${K}`;
        }
        setTextRenderingMode(p) {
          this.current.textRenderingMode = p;
        }
        setTextRise(p) {
          this.current.textRise = p;
        }
        moveText(p, u) {
          this.current.x = this.current.lineX += p, this.current.y = this.current.lineY += u;
        }
        setLeadingMoveText(p, u) {
          this.setLeading(-u), this.moveText(p, u);
        }
        setTextMatrix(p, u, P, F, D, O) {
          this.current.textMatrix = [p, u, P, F, D, O], this.current.textMatrixScale = Math.hypot(p, u), this.current.x = this.current.lineX = 0, this.current.y = this.current.lineY = 0;
        }
        nextLine() {
          this.moveText(0, this.current.leading);
        }
        paintChar(p, u, P, F) {
          const D = this.ctx, O = this.current, Y = O.font, K = O.textRenderingMode, i = O.fontSize / O.fontSizeScale, _ = K & S2.TextRenderingMode.FILL_STROKE_MASK, g = !!(K & S2.TextRenderingMode.ADD_TO_PATH_FLAG), A = O.patternFill && !Y.missingFile;
          let x;
          (Y.disableFontFace || g || A) && (x = Y.getPathGenerator(this.commonObjs, p)), Y.disableFontFace || A ? (D.save(), D.translate(u, P), D.beginPath(), x(D, i), F && D.setTransform(...F), (_ === S2.TextRenderingMode.FILL || _ === S2.TextRenderingMode.FILL_STROKE) && D.fill(), (_ === S2.TextRenderingMode.STROKE || _ === S2.TextRenderingMode.FILL_STROKE) && D.stroke(), D.restore()) : ((_ === S2.TextRenderingMode.FILL || _ === S2.TextRenderingMode.FILL_STROKE) && D.fillText(p, u, P), (_ === S2.TextRenderingMode.STROKE || _ === S2.TextRenderingMode.FILL_STROKE) && D.strokeText(p, u, P)), g && (this.pendingTextPaths || (this.pendingTextPaths = [])).push({ transform: (0, c2.getCurrentTransform)(D), x: u, y: P, fontSize: i, addToPath: x });
        }
        get isFontSubpixelAAEnabled() {
          const { context: p } = this.cachedCanvases.getCanvas("isFontSubpixelAAEnabled", 10, 10);
          p.scale(1.5, 1), p.fillText("I", 0, 10);
          const u = p.getImageData(0, 0, 10, 10).data;
          let P = false;
          for (let F = 3; F < u.length; F += 4) if (u[F] > 0 && u[F] < 255) {
            P = true;
            break;
          }
          return (0, S2.shadow)(this, "isFontSubpixelAAEnabled", P);
        }
        showText(p) {
          const u = this.current, P = u.font;
          if (P.isType3Font) return this.showType3Text(p);
          const F = u.fontSize;
          if (F === 0) return;
          const D = this.ctx, O = u.fontSizeScale, Y = u.charSpacing, K = u.wordSpacing, i = u.fontDirection, _ = u.textHScale * i, g = p.length, A = P.vertical, x = A ? 1 : -1, L = P.defaultVMetrics, st = F * u.fontMatrix[0], it = u.textRenderingMode === S2.TextRenderingMode.FILL && !P.disableFontFace && !u.patternFill;
          D.save(), D.transform(...u.textMatrix), D.translate(u.x, u.y + u.textRise), i > 0 ? D.scale(_, -1) : D.scale(_, 1);
          let J;
          if (u.patternFill) {
            D.save();
            const M = u.fillColor.getPattern(D, this, (0, c2.getCurrentTransformInverse)(D), q2.PathType.FILL);
            J = (0, c2.getCurrentTransform)(D), D.restore(), D.fillStyle = M;
          }
          let rt = u.lineWidth;
          const et = u.textMatrixScale;
          if (et === 0 || rt === 0) {
            const M = u.textRenderingMode & S2.TextRenderingMode.FILL_STROKE_MASK;
            (M === S2.TextRenderingMode.STROKE || M === S2.TextRenderingMode.FILL_STROKE) && (rt = this.getSinglePixelWidth());
          } else rt /= et;
          O !== 1 && (D.scale(O, O), rt /= O), D.lineWidth = rt;
          let ot = 0, ut;
          for (ut = 0; ut < g; ++ut) {
            const M = p[ut];
            if (typeof M == "number") {
              ot += x * M * F / 1e3;
              continue;
            }
            let ht = false;
            const yt = (M.isSpace ? K : 0) + Y, vt = M.fontChar, Ct = M.accent;
            let wt, It, Rt = M.width;
            if (A) {
              const Et = M.vmetric || L, Ft = -(M.vmetric ? Et[1] : Rt * 0.5) * st, Zt = Et[2] * st;
              Rt = Et ? -Et[0] : Rt, wt = Ft / O, It = (ot + Zt) / O;
            } else wt = ot / O, It = 0;
            if (P.remeasure && Rt > 0) {
              const Et = D.measureText(vt).width * 1e3 / F * O;
              if (Rt < Et && this.isFontSubpixelAAEnabled) {
                const Ft = Rt / Et;
                ht = true, D.save(), D.scale(Ft, 1), wt /= Ft;
              } else Rt !== Et && (wt += (Rt - Et) / 2e3 * F / O);
            }
            if (this.contentVisible && (M.isInFont || P.missingFile)) {
              if (it && !Ct) D.fillText(vt, wt, It);
              else if (this.paintChar(vt, wt, It, J), Ct) {
                const Et = wt + F * Ct.offset.x / O, Ft = It - F * Ct.offset.y / O;
                this.paintChar(Ct.fontChar, Et, Ft, J);
              }
            }
            let $t;
            A ? $t = Rt * st - yt * i : $t = Rt * st + yt * i, ot += $t, ht && D.restore();
          }
          A ? u.y -= ot : u.x += ot * _, D.restore(), this.compose();
        }
        showType3Text(p) {
          const u = this.ctx, P = this.current, F = P.font, D = P.fontSize, O = P.fontDirection, Y = F.vertical ? 1 : -1, K = P.charSpacing, i = P.wordSpacing, _ = P.textHScale * O, g = P.fontMatrix || S2.FONT_IDENTITY_MATRIX, A = p.length, x = P.textRenderingMode === S2.TextRenderingMode.INVISIBLE;
          let L, st, it, J;
          if (!(x || D === 0)) {
            for (this._cachedScaleForStroking = null, this._cachedGetSinglePixelWidth = null, u.save(), u.transform(...P.textMatrix), u.translate(P.x, P.y), u.scale(_, O), L = 0; L < A; ++L) {
              if (st = p[L], typeof st == "number") {
                J = Y * st * D / 1e3, this.ctx.translate(J, 0), P.x += J * _;
                continue;
              }
              const rt = (st.isSpace ? i : 0) + K, et = F.charProcOperatorList[st.operatorListId];
              if (!et) {
                (0, S2.warn)(`Type3 character "${st.operatorListId}" is not available.`);
                continue;
              }
              this.contentVisible && (this.processingType3 = st, this.save(), u.scale(D, D), u.transform(...g), this.executeOperatorList(et), this.restore()), it = S2.Util.applyTransform([st.width, 0], g)[0] * D + rt, u.translate(it, 0), P.x += it * _;
            }
            u.restore(), this.processingType3 = null;
          }
        }
        setCharWidth(p, u) {
        }
        setCharWidthAndBounds(p, u, P, F, D, O) {
          this.ctx.rect(P, F, D - P, O - F), this.ctx.clip(), this.endPath();
        }
        getColorN_Pattern(p) {
          let u;
          if (p[0] === "TilingPattern") {
            const P = p[1], F = this.baseTransform || (0, c2.getCurrentTransform)(this.ctx), D = { createCanvasGraphics: (O) => new bt2(O, this.commonObjs, this.objs, this.canvasFactory) };
            u = new q2.TilingPattern(p, P, this.ctx, D, F);
          } else u = this._getPattern(p[1], p[2]);
          return u;
        }
        setStrokeColorN() {
          this.current.strokeColor = this.getColorN_Pattern(arguments);
        }
        setFillColorN() {
          this.current.fillColor = this.getColorN_Pattern(arguments), this.current.patternFill = true;
        }
        setStrokeRGBColor(p, u, P) {
          var D;
          const F = ((D = this.selectColor) == null ? void 0 : D.call(this, p, u, P)) || S2.Util.makeHexColor(p, u, P);
          this.ctx.strokeStyle = F, this.current.strokeColor = F;
        }
        setFillRGBColor(p, u, P) {
          var D;
          const F = ((D = this.selectColor) == null ? void 0 : D.call(this, p, u, P)) || S2.Util.makeHexColor(p, u, P);
          this.ctx.fillStyle = F, this.current.fillColor = F, this.current.patternFill = false;
        }
        _getPattern(p, u = null) {
          let P;
          return this.cachedPatterns.has(p) ? P = this.cachedPatterns.get(p) : (P = (0, q2.getShadingPattern)(this.objs.get(p)), this.cachedPatterns.set(p, P)), u && (P.matrix = u), P;
        }
        shadingFill(p) {
          if (!this.contentVisible) return;
          const u = this.ctx;
          this.save();
          const P = this._getPattern(p);
          u.fillStyle = P.getPattern(u, this, (0, c2.getCurrentTransformInverse)(u), q2.PathType.SHADING);
          const F = (0, c2.getCurrentTransformInverse)(u);
          if (F) {
            const D = u.canvas, O = D.width, Y = D.height, K = S2.Util.applyTransform([0, 0], F), i = S2.Util.applyTransform([0, Y], F), _ = S2.Util.applyTransform([O, 0], F), g = S2.Util.applyTransform([O, Y], F), A = Math.min(K[0], i[0], _[0], g[0]), x = Math.min(K[1], i[1], _[1], g[1]), L = Math.max(K[0], i[0], _[0], g[0]), st = Math.max(K[1], i[1], _[1], g[1]);
            this.ctx.fillRect(A, x, L - A, st - x);
          } else this.ctx.fillRect(-1e10, -1e10, 2e10, 2e10);
          this.compose(this.current.getClippedPathBoundingBox()), this.restore();
        }
        beginInlineImage() {
          (0, S2.unreachable)("Should not call beginInlineImage");
        }
        beginImageData() {
          (0, S2.unreachable)("Should not call beginImageData");
        }
        paintFormXObjectBegin(p, u) {
          if (this.contentVisible && (this.save(), this.baseTransformStack.push(this.baseTransform), Array.isArray(p) && p.length === 6 && this.transform(...p), this.baseTransform = (0, c2.getCurrentTransform)(this.ctx), u)) {
            const P = u[2] - u[0], F = u[3] - u[1];
            this.ctx.rect(u[0], u[1], P, F), this.current.updateRectMinMax((0, c2.getCurrentTransform)(this.ctx), u), this.clip(), this.endPath();
          }
        }
        paintFormXObjectEnd() {
          this.contentVisible && (this.restore(), this.baseTransform = this.baseTransformStack.pop());
        }
        beginGroup(p) {
          if (!this.contentVisible) return;
          this.save(), this.inSMaskMode && (this.endSMaskMode(), this.current.activeSMask = null);
          const u = this.ctx;
          p.isolated || (0, S2.info)("TODO: Support non-isolated groups."), p.knockout && (0, S2.warn)("Knockout groups not supported.");
          const P = (0, c2.getCurrentTransform)(u);
          if (p.matrix && u.transform(...p.matrix), !p.bbox) throw new Error("Bounding box is required.");
          let F = S2.Util.getAxialAlignedBoundingBox(p.bbox, (0, c2.getCurrentTransform)(u));
          const D = [0, 0, u.canvas.width, u.canvas.height];
          F = S2.Util.intersect(F, D) || [0, 0, 0, 0];
          const O = Math.floor(F[0]), Y = Math.floor(F[1]);
          let K = Math.max(Math.ceil(F[2]) - O, 1), i = Math.max(Math.ceil(F[3]) - Y, 1), _ = 1, g = 1;
          K > w && (_ = K / w, K = w), i > w && (g = i / w, i = w), this.current.startNewPathAndClipBox([0, 0, K, i]);
          let A = "groupAt" + this.groupLevel;
          p.smask && (A += "_smask_" + this.smaskCounter++ % 2);
          const x = this.cachedCanvases.getCanvas(A, K, i), L = x.context;
          L.scale(1 / _, 1 / g), L.translate(-O, -Y), L.transform(...P), p.smask ? this.smaskStack.push({ canvas: x.canvas, context: L, offsetX: O, offsetY: Y, scaleX: _, scaleY: g, subtype: p.smask.subtype, backdrop: p.smask.backdrop, transferMap: p.smask.transferMap || null, startTransformInverse: null }) : (u.setTransform(1, 0, 0, 1, 0, 0), u.translate(O, Y), u.scale(_, g), u.save()), e(u, L), this.ctx = L, this.setGState([["BM", "source-over"], ["ca", 1], ["CA", 1]]), this.groupStack.push(u), this.groupLevel++;
        }
        endGroup(p) {
          if (!this.contentVisible) return;
          this.groupLevel--;
          const u = this.ctx, P = this.groupStack.pop();
          if (this.ctx = P, this.ctx.imageSmoothingEnabled = false, p.smask) this.tempSMask = this.smaskStack.pop(), this.restore();
          else {
            this.ctx.restore();
            const F = (0, c2.getCurrentTransform)(this.ctx);
            this.restore(), this.ctx.save(), this.ctx.setTransform(...F);
            const D = S2.Util.getAxialAlignedBoundingBox([0, 0, u.canvas.width, u.canvas.height], F);
            this.ctx.drawImage(u.canvas, 0, 0), this.ctx.restore(), this.compose(D);
          }
        }
        beginAnnotation(p, u, P, F, D) {
          if (ft(this, at, de).call(this), o(this.ctx, this.foregroundColor), this.ctx.save(), this.save(), this.baseTransform && this.ctx.setTransform(...this.baseTransform), Array.isArray(u) && u.length === 4) {
            const O = u[2] - u[0], Y = u[3] - u[1];
            if (D && this.annotationCanvasMap) {
              P = P.slice(), P[4] -= u[0], P[5] -= u[1], u = u.slice(), u[0] = u[1] = 0, u[2] = O, u[3] = Y;
              const [K, i] = S2.Util.singularValueDecompose2dScale((0, c2.getCurrentTransform)(this.ctx)), { viewportScale: _ } = this, g = Math.ceil(O * this.outputScaleX * _), A = Math.ceil(Y * this.outputScaleY * _);
              this.annotationCanvas = this.canvasFactory.create(g, A);
              const { canvas: x, context: L } = this.annotationCanvas;
              this.annotationCanvasMap.set(p, x), this.annotationCanvas.savedCtx = this.ctx, this.ctx = L, this.ctx.setTransform(K, 0, 0, -i, 0, Y * i), o(this.ctx, this.foregroundColor);
            } else o(this.ctx, this.foregroundColor), this.ctx.rect(u[0], u[1], O, Y), this.ctx.clip(), this.endPath();
          }
          this.current = new b(this.ctx.canvas.width, this.ctx.canvas.height), this.transform(...P), this.transform(...F);
        }
        endAnnotation() {
          this.annotationCanvas && (this.ctx = this.annotationCanvas.savedCtx, delete this.annotationCanvas.savedCtx, delete this.annotationCanvas);
        }
        paintImageMaskXObject(p) {
          if (!this.contentVisible) return;
          const u = p.count;
          p = this.getObject(p.data, p), p.count = u;
          const P = this.ctx, F = this.processingType3;
          if (F && (F.compiled === void 0 && (F.compiled = h(p)), F.compiled)) {
            F.compiled(P);
            return;
          }
          const D = this._createMaskCanvas(p), O = D.canvas;
          P.save(), P.setTransform(1, 0, 0, 1, 0, 0), P.drawImage(O, D.offsetX, D.offsetY), P.restore(), this.compose();
        }
        paintImageMaskXObjectRepeat(p, u, P = 0, F = 0, D, O) {
          if (!this.contentVisible) return;
          p = this.getObject(p.data, p);
          const Y = this.ctx;
          Y.save();
          const K = (0, c2.getCurrentTransform)(Y);
          Y.transform(u, P, F, D, 0, 0);
          const i = this._createMaskCanvas(p);
          Y.setTransform(1, 0, 0, 1, 0, 0);
          for (let _ = 0, g = O.length; _ < g; _ += 2) {
            const A = S2.Util.transform(K, [u, P, F, D, O[_], O[_ + 1]]), [x, L] = S2.Util.applyTransform([0, 0], A);
            Y.drawImage(i.canvas, x, L);
          }
          Y.restore(), this.compose();
        }
        paintImageMaskXObjectGroup(p) {
          if (!this.contentVisible) return;
          const u = this.ctx, P = this.current.fillColor, F = this.current.patternFill;
          for (const D of p) {
            const { data: O, width: Y, height: K, transform: i } = D, _ = this.cachedCanvases.getCanvas("maskCanvas", Y, K), g = _.context;
            g.save();
            const A = this.getObject(O, D);
            n(g, A), g.globalCompositeOperation = "source-in", g.fillStyle = F ? P.getPattern(g, this, (0, c2.getCurrentTransformInverse)(u), q2.PathType.FILL) : P, g.fillRect(0, 0, Y, K), g.restore(), u.save(), u.transform(...i), u.scale(1, -1), a(u, _.canvas, 0, 0, Y, K, 0, -1, 1, 1), u.restore();
          }
          this.compose();
        }
        paintImageXObject(p) {
          if (!this.contentVisible) return;
          const u = this.getObject(p);
          if (!u) {
            (0, S2.warn)("Dependent image isn't ready yet");
            return;
          }
          this.paintInlineImageXObject(u);
        }
        paintImageXObjectRepeat(p, u, P, F) {
          if (!this.contentVisible) return;
          const D = this.getObject(p);
          if (!D) {
            (0, S2.warn)("Dependent image isn't ready yet");
            return;
          }
          const O = D.width, Y = D.height, K = [];
          for (let i = 0, _ = F.length; i < _; i += 2) K.push({ transform: [u, 0, 0, P, F[i], F[i + 1]], x: 0, y: 0, w: O, h: Y });
          this.paintInlineImageXObjectGroup(D, K);
        }
        paintInlineImageXObject(p) {
          if (!this.contentVisible) return;
          const u = p.width, P = p.height, F = this.ctx;
          this.save(), F.scale(1 / u, -1 / P);
          let D;
          if (typeof HTMLElement == "function" && p instanceof HTMLElement || !p.data) D = p;
          else {
            const i = this.cachedCanvases.getCanvas("inlineImage", u, P), _ = i.context;
            r(_, p, this.current.transferMaps), D = i.canvas;
          }
          const O = this._scaleImage(D, (0, c2.getCurrentTransformInverse)(F));
          F.imageSmoothingEnabled = tt((0, c2.getCurrentTransform)(F), p.interpolate);
          const [Y, K] = a(F, O.img, 0, 0, O.paintWidth, O.paintHeight, 0, -P, u, P);
          if (this.imageLayer) {
            const [i, _] = S2.Util.applyTransform([0, -P], (0, c2.getCurrentTransform)(this.ctx));
            this.imageLayer.appendImage({ imgData: p, left: i, top: _, width: Y, height: K });
          }
          this.compose(), this.restore();
        }
        paintInlineImageXObjectGroup(p, u) {
          if (!this.contentVisible) return;
          const P = this.ctx, F = p.width, D = p.height, O = this.cachedCanvases.getCanvas("inlineImage", F, D), Y = O.context;
          r(Y, p, this.current.transferMaps);
          for (const K of u) {
            if (P.save(), P.transform(...K.transform), P.scale(1, -1), a(P, O.canvas, K.x, K.y, K.w, K.h, 0, -1, 1, 1), this.imageLayer) {
              const [i, _] = S2.Util.applyTransform([K.x, K.y], (0, c2.getCurrentTransform)(this.ctx));
              this.imageLayer.appendImage({ imgData: p, left: i, top: _, width: F, height: D });
            }
            P.restore();
          }
          this.compose();
        }
        paintSolidColorImageMask() {
          this.contentVisible && (this.ctx.fillRect(0, 0, 1, 1), this.compose());
        }
        markPoint(p) {
        }
        markPointProps(p, u) {
        }
        beginMarkedContent(p) {
          this.markedContentStack.push({ visible: true });
        }
        beginMarkedContentProps(p, u) {
          p === "OC" ? this.markedContentStack.push({ visible: this.optionalContentConfig.isVisible(u) }) : this.markedContentStack.push({ visible: true }), this.contentVisible = this.isContentVisible();
        }
        endMarkedContent() {
          this.markedContentStack.pop(), this.contentVisible = this.isContentVisible();
        }
        beginCompat() {
        }
        endCompat() {
        }
        consumePath(p) {
          const u = this.current.isEmptyClip();
          this.pendingClip && this.current.updateClipFromPath(), this.pendingClip || this.compose(p);
          const P = this.ctx;
          this.pendingClip && (u || (this.pendingClip === V ? P.clip("evenodd") : P.clip()), this.pendingClip = null), this.current.startNewPathAndClipBox(this.current.clipBox), P.beginPath();
        }
        getSinglePixelWidth() {
          if (!this._cachedGetSinglePixelWidth) {
            const p = (0, c2.getCurrentTransform)(this.ctx);
            if (p[1] === 0 && p[2] === 0) this._cachedGetSinglePixelWidth = 1 / Math.min(Math.abs(p[0]), Math.abs(p[3]));
            else {
              const u = Math.abs(p[0] * p[3] - p[2] * p[1]), P = Math.hypot(p[0], p[2]), F = Math.hypot(p[1], p[3]);
              this._cachedGetSinglePixelWidth = Math.max(P, F) / u;
            }
          }
          return this._cachedGetSinglePixelWidth;
        }
        getScaleForStroking() {
          if (!this._cachedScaleForStroking) {
            const { lineWidth: p } = this.current, u = (0, c2.getCurrentTransform)(this.ctx);
            let P, F;
            if (u[1] === 0 && u[2] === 0) {
              const D = Math.abs(u[0]), O = Math.abs(u[3]);
              if (p === 0) P = 1 / D, F = 1 / O;
              else {
                const Y = D * p, K = O * p;
                P = Y < 1 ? 1 / Y : 1, F = K < 1 ? 1 / K : 1;
              }
            } else {
              const D = Math.abs(u[0] * u[3] - u[2] * u[1]), O = Math.hypot(u[0], u[1]), Y = Math.hypot(u[2], u[3]);
              if (p === 0) P = Y / D, F = O / D;
              else {
                const K = p * D;
                P = Y > K ? Y / K : 1, F = O > K ? O / K : 1;
              }
            }
            this._cachedScaleForStroking = [P, F];
          }
          return this._cachedScaleForStroking;
        }
        rescaleAndStroke(p) {
          const { ctx: u } = this, { lineWidth: P } = this.current, [F, D] = this.getScaleForStroking();
          if (u.lineWidth = P || 1, F === 1 && D === 1) {
            u.stroke();
            return;
          }
          let O, Y, K;
          p && (O = (0, c2.getCurrentTransform)(u), Y = u.getLineDash().slice(), K = u.lineDashOffset), u.scale(F, D);
          const i = Math.max(F, D);
          u.setLineDash(u.getLineDash().map((_) => _ / i)), u.lineDashOffset /= i, u.stroke(), p && (u.setTransform(...O), u.setLineDash(Y), u.lineDashOffset = K);
        }
        isContentVisible() {
          for (let p = this.markedContentStack.length - 1; p >= 0; p--) if (!this.markedContentStack[p].visible) return false;
          return true;
        }
      };
      at = /* @__PURE__ */ new WeakSet(), de = function() {
        for (; this.stateStack.length || this.inSMaskMode; ) this.restore();
        this.ctx.restore(), this.transparentCanvas && (this.ctx = this.compositeCtx, this.ctx.save(), this.ctx.setTransform(1, 0, 0, 1, 0, 0), this.ctx.drawImage(this.transparentCanvas, 0, 0), this.ctx.restore(), this.transparentCanvas = null);
      };
      let X = bt;
      f2.CanvasGraphics = X;
      for (const N in S2.OPS) X.prototype[N] !== void 0 && (X.prototype[S2.OPS[N]] = X.prototype[N]);
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.TilingPattern = f2.PathType = void 0, f2.getShadingPattern = l;
      var c2 = $2(1), S2 = $2(8), q2 = $2(3);
      const B2 = { FILL: "Fill", STROKE: "Stroke", SHADING: "Shading" };
      f2.PathType = B2;
      function Q2(a, h) {
        if (!h || q2.isNodeJS) return;
        const b = h[2] - h[0], r = h[3] - h[1], n = new Path2D();
        n.rect(h[0], h[1], b, r), a.clip(n);
      }
      class I2 {
        constructor() {
          this.constructor === I2 && (0, c2.unreachable)("Cannot initialize BaseShadingPattern.");
        }
        getPattern() {
          (0, c2.unreachable)("Abstract method `getPattern` called.");
        }
      }
      class y2 extends I2 {
        constructor(h) {
          super(), this._type = h[1], this._bbox = h[2], this._colorStops = h[3], this._p0 = h[4], this._p1 = h[5], this._r0 = h[6], this._r1 = h[7], this.matrix = null;
        }
        _createGradient(h) {
          let b;
          this._type === "axial" ? b = h.createLinearGradient(this._p0[0], this._p0[1], this._p1[0], this._p1[1]) : this._type === "radial" && (b = h.createRadialGradient(this._p0[0], this._p0[1], this._r0, this._p1[0], this._p1[1], this._r1));
          for (const r of this._colorStops) b.addColorStop(r[0], r[1]);
          return b;
        }
        getPattern(h, b, r, n) {
          let e;
          if (n === B2.STROKE || n === B2.FILL) {
            const o = b.current.getClippedPathBoundingBox(n, (0, S2.getCurrentTransform)(h)) || [0, 0, 0, 0], v = Math.ceil(o[2] - o[0]) || 1, m = Math.ceil(o[3] - o[1]) || 1, d = b.cachedCanvases.getCanvas("pattern", v, m, true), E = d.context;
            E.clearRect(0, 0, E.canvas.width, E.canvas.height), E.beginPath(), E.rect(0, 0, E.canvas.width, E.canvas.height), E.translate(-o[0], -o[1]), r = c2.Util.transform(r, [1, 0, 0, 1, o[0], o[1]]), E.transform(...b.baseTransform), this.matrix && E.transform(...this.matrix), Q2(E, this._bbox), E.fillStyle = this._createGradient(E), E.fill(), e = h.createPattern(d.canvas, "no-repeat");
            const U = new DOMMatrix(r);
            try {
              e.setTransform(U);
            } catch (tt) {
              (0, c2.warn)(`RadialAxialShadingPattern.getPattern: "${tt == null ? void 0 : tt.message}".`);
            }
          } else Q2(h, this._bbox), e = this._createGradient(h);
          return e;
        }
      }
      function w(a, h, b, r, n, e, o, v) {
        const m = h.coords, d = h.colors, E = a.data, U = a.width * 4;
        let tt;
        m[b + 1] > m[r + 1] && (tt = b, b = r, r = tt, tt = e, e = o, o = tt), m[r + 1] > m[n + 1] && (tt = r, r = n, n = tt, tt = o, o = v, v = tt), m[b + 1] > m[r + 1] && (tt = b, b = r, r = tt, tt = e, e = o, o = tt);
        const H = (m[b] + h.offsetX) * h.scaleX, Z = (m[b + 1] + h.offsetY) * h.scaleY, j = (m[r] + h.offsetX) * h.scaleX, V = (m[r + 1] + h.offsetY) * h.scaleY, X = (m[n] + h.offsetX) * h.scaleX, at = (m[n + 1] + h.offsetY) * h.scaleY;
        if (Z >= at) return;
        const dt = d[e], bt = d[e + 1], N = d[e + 2], p = d[o], u = d[o + 1], P = d[o + 2], F = d[v], D = d[v + 1], O = d[v + 2], Y = Math.round(Z), K = Math.round(at);
        let i, _, g, A, x, L, st, it;
        for (let J = Y; J <= K; J++) {
          if (J < V) {
            let M;
            J < Z ? M = 0 : M = (Z - J) / (Z - V), i = H - (H - j) * M, _ = dt - (dt - p) * M, g = bt - (bt - u) * M, A = N - (N - P) * M;
          } else {
            let M;
            J > at ? M = 1 : V === at ? M = 0 : M = (V - J) / (V - at), i = j - (j - X) * M, _ = p - (p - F) * M, g = u - (u - D) * M, A = P - (P - O) * M;
          }
          let rt;
          J < Z ? rt = 0 : J > at ? rt = 1 : rt = (Z - J) / (Z - at), x = H - (H - X) * rt, L = dt - (dt - F) * rt, st = bt - (bt - D) * rt, it = N - (N - O) * rt;
          const et = Math.round(Math.min(i, x)), ot = Math.round(Math.max(i, x));
          let ut = U * J + et * 4;
          for (let M = et; M <= ot; M++) rt = (i - M) / (i - x), rt < 0 ? rt = 0 : rt > 1 && (rt = 1), E[ut++] = _ - (_ - L) * rt | 0, E[ut++] = g - (g - st) * rt | 0, E[ut++] = A - (A - it) * rt | 0, E[ut++] = 255;
        }
      }
      function k2(a, h, b) {
        const r = h.coords, n = h.colors;
        let e, o;
        switch (h.type) {
          case "lattice":
            const v = h.verticesPerRow, m = Math.floor(r.length / v) - 1, d = v - 1;
            for (e = 0; e < m; e++) {
              let E = e * v;
              for (let U = 0; U < d; U++, E++) w(a, b, r[E], r[E + 1], r[E + v], n[E], n[E + 1], n[E + v]), w(a, b, r[E + v + 1], r[E + 1], r[E + v], n[E + v + 1], n[E + 1], n[E + v]);
            }
            break;
          case "triangles":
            for (e = 0, o = r.length; e < o; e += 3) w(a, b, r[e], r[e + 1], r[e + 2], n[e], n[e + 1], n[e + 2]);
            break;
          default:
            throw new Error("illegal figure");
        }
      }
      class T2 extends I2 {
        constructor(h) {
          super(), this._coords = h[2], this._colors = h[3], this._figures = h[4], this._bounds = h[5], this._bbox = h[7], this._background = h[8], this.matrix = null;
        }
        _createMeshCanvas(h, b, r) {
          const v = Math.floor(this._bounds[0]), m = Math.floor(this._bounds[1]), d = Math.ceil(this._bounds[2]) - v, E = Math.ceil(this._bounds[3]) - m, U = Math.min(Math.ceil(Math.abs(d * h[0] * 1.1)), 3e3), tt = Math.min(Math.ceil(Math.abs(E * h[1] * 1.1)), 3e3), H = d / U, Z = E / tt, j = { coords: this._coords, colors: this._colors, offsetX: -v, offsetY: -m, scaleX: 1 / H, scaleY: 1 / Z }, V = U + 2 * 2, X = tt + 2 * 2, at = r.getCanvas("mesh", V, X, false), dt = at.context, bt = dt.createImageData(U, tt);
          if (b) {
            const p = bt.data;
            for (let u = 0, P = p.length; u < P; u += 4) p[u] = b[0], p[u + 1] = b[1], p[u + 2] = b[2], p[u + 3] = 255;
          }
          for (const p of this._figures) k2(bt, p, j);
          return dt.putImageData(bt, 2, 2), { canvas: at.canvas, offsetX: v - 2 * H, offsetY: m - 2 * Z, scaleX: H, scaleY: Z };
        }
        getPattern(h, b, r, n) {
          Q2(h, this._bbox);
          let e;
          if (n === B2.SHADING) e = c2.Util.singularValueDecompose2dScale((0, S2.getCurrentTransform)(h));
          else if (e = c2.Util.singularValueDecompose2dScale(b.baseTransform), this.matrix) {
            const v = c2.Util.singularValueDecompose2dScale(this.matrix);
            e = [e[0] * v[0], e[1] * v[1]];
          }
          const o = this._createMeshCanvas(e, n === B2.SHADING ? null : this._background, b.cachedCanvases);
          return n !== B2.SHADING && (h.setTransform(...b.baseTransform), this.matrix && h.transform(...this.matrix)), h.translate(o.offsetX, o.offsetY), h.scale(o.scaleX, o.scaleY), h.createPattern(o.canvas, "no-repeat");
        }
      }
      class C2 extends I2 {
        getPattern() {
          return "hotpink";
        }
      }
      function l(a) {
        switch (a[0]) {
          case "RadialAxial":
            return new y2(a);
          case "Mesh":
            return new T2(a);
          case "Dummy":
            return new C2();
        }
        throw new Error(`Unknown IR type: ${a[0]}`);
      }
      const t = { COLORED: 1, UNCOLORED: 2 };
      class s {
        static get MAX_PATTERN_SIZE() {
          return (0, c2.shadow)(this, "MAX_PATTERN_SIZE", 3e3);
        }
        constructor(h, b, r, n, e) {
          this.operatorList = h[2], this.matrix = h[3] || [1, 0, 0, 1, 0, 0], this.bbox = h[4], this.xstep = h[5], this.ystep = h[6], this.paintType = h[7], this.tilingType = h[8], this.color = b, this.ctx = r, this.canvasGraphicsFactory = n, this.baseTransform = e;
        }
        createPatternCanvas(h) {
          const b = this.operatorList, r = this.bbox, n = this.xstep, e = this.ystep, o = this.paintType, v = this.tilingType, m = this.color, d = this.canvasGraphicsFactory;
          (0, c2.info)("TilingType: " + v);
          const E = r[0], U = r[1], tt = r[2], H = r[3], Z = c2.Util.singularValueDecompose2dScale(this.matrix), j = c2.Util.singularValueDecompose2dScale(this.baseTransform), V = [Z[0] * j[0], Z[1] * j[1]], X = this.getSizeAndScale(n, this.ctx.canvas.width, V[0]), at = this.getSizeAndScale(e, this.ctx.canvas.height, V[1]), dt = h.cachedCanvases.getCanvas("pattern", X.size, at.size, true), bt = dt.context, N = d.createCanvasGraphics(bt);
          N.groupLevel = h.groupLevel, this.setFillAndStrokeStyleToContext(N, o, m);
          let p = E, u = U, P = tt, F = H;
          return E < 0 && (p = 0, P += Math.abs(E)), U < 0 && (u = 0, F += Math.abs(U)), bt.translate(-(X.scale * p), -(at.scale * u)), N.transform(X.scale, 0, 0, at.scale, 0, 0), bt.save(), this.clipBbox(N, p, u, P, F), N.baseTransform = (0, S2.getCurrentTransform)(N.ctx), N.executeOperatorList(b), N.endDrawing(), { canvas: dt.canvas, scaleX: X.scale, scaleY: at.scale, offsetX: p, offsetY: u };
        }
        getSizeAndScale(h, b, r) {
          h = Math.abs(h);
          const n = Math.max(s.MAX_PATTERN_SIZE, b);
          let e = Math.ceil(h * r);
          return e >= n ? e = n : r = e / h, { scale: r, size: e };
        }
        clipBbox(h, b, r, n, e) {
          const o = n - b, v = e - r;
          h.ctx.rect(b, r, o, v), h.current.updateRectMinMax((0, S2.getCurrentTransform)(h.ctx), [b, r, n, e]), h.clip(), h.endPath();
        }
        setFillAndStrokeStyleToContext(h, b, r) {
          const n = h.ctx, e = h.current;
          switch (b) {
            case t.COLORED:
              const o = this.ctx;
              n.fillStyle = o.fillStyle, n.strokeStyle = o.strokeStyle, e.fillColor = o.fillStyle, e.strokeColor = o.strokeStyle;
              break;
            case t.UNCOLORED:
              const v = c2.Util.makeHexColor(r[0], r[1], r[2]);
              n.fillStyle = v, n.strokeStyle = v, e.fillColor = v, e.strokeColor = v;
              break;
            default:
              throw new c2.FormatError(`Unsupported paint type: ${b}`);
          }
        }
        getPattern(h, b, r, n) {
          let e = r;
          n !== B2.SHADING && (e = c2.Util.transform(e, b.baseTransform), this.matrix && (e = c2.Util.transform(e, this.matrix)));
          const o = this.createPatternCanvas(b);
          let v = new DOMMatrix(e);
          v = v.translate(o.offsetX, o.offsetY), v = v.scale(1 / o.scaleX, 1 / o.scaleY);
          const m = h.createPattern(o.canvas, "repeat");
          try {
            m.setTransform(v);
          } catch (d) {
            (0, c2.warn)(`TilingPattern.getPattern: "${d == null ? void 0 : d.message}".`);
          }
          return m;
        }
      }
      f2.TilingPattern = s;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.applyMaskImageData = S2;
      var c2 = $2(1);
      function S2({ src: q2, srcPos: B2 = 0, dest: Q2, destPos: I2 = 0, width: y2, height: w, inverseDecode: k2 = false }) {
        const T2 = c2.FeatureTest.isLittleEndian ? 4278190080 : 255, [C2, l] = k2 ? [0, T2] : [T2, 0], t = y2 >> 3, s = y2 & 7, a = q2.length;
        Q2 = new Uint32Array(Q2.buffer);
        for (let h = 0; h < w; h++) {
          for (const r = B2 + t; B2 < r; B2++) {
            const n = B2 < a ? q2[B2] : 255;
            Q2[I2++] = n & 128 ? l : C2, Q2[I2++] = n & 64 ? l : C2, Q2[I2++] = n & 32 ? l : C2, Q2[I2++] = n & 16 ? l : C2, Q2[I2++] = n & 8 ? l : C2, Q2[I2++] = n & 4 ? l : C2, Q2[I2++] = n & 2 ? l : C2, Q2[I2++] = n & 1 ? l : C2;
          }
          if (s === 0) continue;
          const b = B2 < a ? q2[B2++] : 255;
          for (let r = 0; r < s; r++) Q2[I2++] = b & 1 << 7 - r ? l : C2;
        }
        return { srcPos: B2, destPos: I2 };
      }
    }, (z2, f2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.GlobalWorkerOptions = void 0;
      const $2 = /* @__PURE__ */ Object.create(null);
      f2.GlobalWorkerOptions = $2, $2.workerPort = $2.workerPort === void 0 ? null : $2.workerPort, $2.workerSrc = $2.workerSrc === void 0 ? "" : $2.workerSrc;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.MessageHandler = void 0;
      var c2 = $2(1);
      const S2 = { UNKNOWN: 0, DATA: 1, ERROR: 2 }, q2 = { UNKNOWN: 0, CANCEL: 1, CANCEL_COMPLETE: 2, CLOSE: 3, ENQUEUE: 4, ERROR: 5, PULL: 6, PULL_COMPLETE: 7, START_COMPLETE: 8 };
      function B2(I2) {
        switch (I2 instanceof Error || typeof I2 == "object" && I2 !== null || (0, c2.unreachable)('wrapReason: Expected "reason" to be a (possibly cloned) Error.'), I2.name) {
          case "AbortException":
            return new c2.AbortException(I2.message);
          case "MissingPDFException":
            return new c2.MissingPDFException(I2.message);
          case "PasswordException":
            return new c2.PasswordException(I2.message, I2.code);
          case "UnexpectedResponseException":
            return new c2.UnexpectedResponseException(I2.message, I2.status);
          case "UnknownErrorException":
            return new c2.UnknownErrorException(I2.message, I2.details);
          default:
            return new c2.UnknownErrorException(I2.message, I2.toString());
        }
      }
      class Q2 {
        constructor(y2, w, k2) {
          this.sourceName = y2, this.targetName = w, this.comObj = k2, this.callbackId = 1, this.streamId = 1, this.streamSinks = /* @__PURE__ */ Object.create(null), this.streamControllers = /* @__PURE__ */ Object.create(null), this.callbackCapabilities = /* @__PURE__ */ Object.create(null), this.actionHandler = /* @__PURE__ */ Object.create(null), this._onComObjOnMessage = (T2) => {
            const C2 = T2.data;
            if (C2.targetName !== this.sourceName) return;
            if (C2.stream) {
              this._processStreamMessage(C2);
              return;
            }
            if (C2.callback) {
              const t = C2.callbackId, s = this.callbackCapabilities[t];
              if (!s) throw new Error(`Cannot resolve callback ${t}`);
              if (delete this.callbackCapabilities[t], C2.callback === S2.DATA) s.resolve(C2.data);
              else if (C2.callback === S2.ERROR) s.reject(B2(C2.reason));
              else throw new Error("Unexpected callback case");
              return;
            }
            const l = this.actionHandler[C2.action];
            if (!l) throw new Error(`Unknown action from worker: ${C2.action}`);
            if (C2.callbackId) {
              const t = this.sourceName, s = C2.sourceName;
              new Promise(function(a) {
                a(l(C2.data));
              }).then(function(a) {
                k2.postMessage({ sourceName: t, targetName: s, callback: S2.DATA, callbackId: C2.callbackId, data: a });
              }, function(a) {
                k2.postMessage({ sourceName: t, targetName: s, callback: S2.ERROR, callbackId: C2.callbackId, reason: B2(a) });
              });
              return;
            }
            if (C2.streamId) {
              this._createStreamSink(C2);
              return;
            }
            l(C2.data);
          }, k2.addEventListener("message", this._onComObjOnMessage);
        }
        on(y2, w) {
          const k2 = this.actionHandler;
          if (k2[y2]) throw new Error(`There is already an actionName called "${y2}"`);
          k2[y2] = w;
        }
        send(y2, w, k2) {
          this.comObj.postMessage({ sourceName: this.sourceName, targetName: this.targetName, action: y2, data: w }, k2);
        }
        sendWithPromise(y2, w, k2) {
          const T2 = this.callbackId++, C2 = (0, c2.createPromiseCapability)();
          this.callbackCapabilities[T2] = C2;
          try {
            this.comObj.postMessage({ sourceName: this.sourceName, targetName: this.targetName, action: y2, callbackId: T2, data: w }, k2);
          } catch (l) {
            C2.reject(l);
          }
          return C2.promise;
        }
        sendWithStream(y2, w, k2, T2) {
          const C2 = this.streamId++, l = this.sourceName, t = this.targetName, s = this.comObj;
          return new ReadableStream({ start: (a) => {
            const h = (0, c2.createPromiseCapability)();
            return this.streamControllers[C2] = { controller: a, startCall: h, pullCall: null, cancelCall: null, isClosed: false }, s.postMessage({ sourceName: l, targetName: t, action: y2, streamId: C2, data: w, desiredSize: a.desiredSize }, T2), h.promise;
          }, pull: (a) => {
            const h = (0, c2.createPromiseCapability)();
            return this.streamControllers[C2].pullCall = h, s.postMessage({ sourceName: l, targetName: t, stream: q2.PULL, streamId: C2, desiredSize: a.desiredSize }), h.promise;
          }, cancel: (a) => {
            (0, c2.assert)(a instanceof Error, "cancel must have a valid reason");
            const h = (0, c2.createPromiseCapability)();
            return this.streamControllers[C2].cancelCall = h, this.streamControllers[C2].isClosed = true, s.postMessage({ sourceName: l, targetName: t, stream: q2.CANCEL, streamId: C2, reason: B2(a) }), h.promise;
          } }, k2);
        }
        _createStreamSink(y2) {
          const w = y2.streamId, k2 = this.sourceName, T2 = y2.sourceName, C2 = this.comObj, l = this, t = this.actionHandler[y2.action], s = { enqueue(a, h = 1, b) {
            if (this.isCancelled) return;
            const r = this.desiredSize;
            this.desiredSize -= h, r > 0 && this.desiredSize <= 0 && (this.sinkCapability = (0, c2.createPromiseCapability)(), this.ready = this.sinkCapability.promise), C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.ENQUEUE, streamId: w, chunk: a }, b);
          }, close() {
            this.isCancelled || (this.isCancelled = true, C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.CLOSE, streamId: w }), delete l.streamSinks[w]);
          }, error(a) {
            (0, c2.assert)(a instanceof Error, "error must have a valid reason"), !this.isCancelled && (this.isCancelled = true, C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.ERROR, streamId: w, reason: B2(a) }));
          }, sinkCapability: (0, c2.createPromiseCapability)(), onPull: null, onCancel: null, isCancelled: false, desiredSize: y2.desiredSize, ready: null };
          s.sinkCapability.resolve(), s.ready = s.sinkCapability.promise, this.streamSinks[w] = s, new Promise(function(a) {
            a(t(y2.data, s));
          }).then(function() {
            C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.START_COMPLETE, streamId: w, success: true });
          }, function(a) {
            C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.START_COMPLETE, streamId: w, reason: B2(a) });
          });
        }
        _processStreamMessage(y2) {
          const w = y2.streamId, k2 = this.sourceName, T2 = y2.sourceName, C2 = this.comObj, l = this.streamControllers[w], t = this.streamSinks[w];
          switch (y2.stream) {
            case q2.START_COMPLETE:
              y2.success ? l.startCall.resolve() : l.startCall.reject(B2(y2.reason));
              break;
            case q2.PULL_COMPLETE:
              y2.success ? l.pullCall.resolve() : l.pullCall.reject(B2(y2.reason));
              break;
            case q2.PULL:
              if (!t) {
                C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.PULL_COMPLETE, streamId: w, success: true });
                break;
              }
              t.desiredSize <= 0 && y2.desiredSize > 0 && t.sinkCapability.resolve(), t.desiredSize = y2.desiredSize, new Promise(function(s) {
                s(t.onPull && t.onPull());
              }).then(function() {
                C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.PULL_COMPLETE, streamId: w, success: true });
              }, function(s) {
                C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.PULL_COMPLETE, streamId: w, reason: B2(s) });
              });
              break;
            case q2.ENQUEUE:
              if ((0, c2.assert)(l, "enqueue should have stream controller"), l.isClosed) break;
              l.controller.enqueue(y2.chunk);
              break;
            case q2.CLOSE:
              if ((0, c2.assert)(l, "close should have stream controller"), l.isClosed) break;
              l.isClosed = true, l.controller.close(), this._deleteStreamController(l, w);
              break;
            case q2.ERROR:
              (0, c2.assert)(l, "error should have stream controller"), l.controller.error(B2(y2.reason)), this._deleteStreamController(l, w);
              break;
            case q2.CANCEL_COMPLETE:
              y2.success ? l.cancelCall.resolve() : l.cancelCall.reject(B2(y2.reason)), this._deleteStreamController(l, w);
              break;
            case q2.CANCEL:
              if (!t) break;
              new Promise(function(s) {
                s(t.onCancel && t.onCancel(B2(y2.reason)));
              }).then(function() {
                C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.CANCEL_COMPLETE, streamId: w, success: true });
              }, function(s) {
                C2.postMessage({ sourceName: k2, targetName: T2, stream: q2.CANCEL_COMPLETE, streamId: w, reason: B2(s) });
              }), t.sinkCapability.reject(B2(y2.reason)), t.isCancelled = true, delete this.streamSinks[w];
              break;
            default:
              throw new Error("Unexpected stream case");
          }
        }
        async _deleteStreamController(y2, w) {
          await Promise.allSettled([y2.startCall && y2.startCall.promise, y2.pullCall && y2.pullCall.promise, y2.cancelCall && y2.cancelCall.promise]), delete this.streamControllers[w];
        }
        destroy() {
          this.comObj.removeEventListener("message", this._onComObjOnMessage);
        }
      }
      f2.MessageHandler = Q2;
    }, (z2, f2, $2) => {
      var q2, B2;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.Metadata = void 0;
      var c2 = $2(1);
      class S2 {
        constructor({ parsedData: I2, rawData: y2 }) {
          ct(this, q2, void 0);
          ct(this, B2, void 0);
          mt(this, q2, I2), mt(this, B2, y2);
        }
        getRaw() {
          return R(this, B2);
        }
        get(I2) {
          return R(this, q2).get(I2) ?? null;
        }
        getAll() {
          return (0, c2.objectFromMap)(R(this, q2));
        }
        has(I2) {
          return R(this, q2).has(I2);
        }
      }
      q2 = /* @__PURE__ */ new WeakMap(), B2 = /* @__PURE__ */ new WeakMap(), f2.Metadata = S2;
    }, (z2, f2, $2) => {
      var Q2, I2, y2, w, k2, T2, he;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.OptionalContentConfig = void 0;
      var c2 = $2(1);
      const S2 = /* @__PURE__ */ Symbol("INTERNAL");
      class q2 {
        constructor(t, s) {
          ct(this, Q2, true);
          this.name = t, this.intent = s;
        }
        get visible() {
          return R(this, Q2);
        }
        _setVisible(t, s) {
          t !== S2 && (0, c2.unreachable)("Internal method `_setVisible` called."), mt(this, Q2, s);
        }
      }
      Q2 = /* @__PURE__ */ new WeakMap();
      class B2 {
        constructor(t) {
          ct(this, T2);
          ct(this, I2, true);
          ct(this, y2, /* @__PURE__ */ new Map());
          ct(this, w, null);
          ct(this, k2, null);
          if (this.name = null, this.creator = null, t !== null) {
            this.name = t.name, this.creator = t.creator, mt(this, k2, t.order);
            for (const s of t.groups) R(this, y2).set(s.id, new q2(s.name, s.intent));
            if (t.baseState === "OFF") for (const s of R(this, y2).values()) s._setVisible(S2, false);
            for (const s of t.on) R(this, y2).get(s)._setVisible(S2, true);
            for (const s of t.off) R(this, y2).get(s)._setVisible(S2, false);
            mt(this, w, /* @__PURE__ */ new Map());
            for (const [s, a] of R(this, y2)) R(this, w).set(s, a.visible);
          }
        }
        isVisible(t) {
          if (R(this, y2).size === 0) return true;
          if (!t) return (0, c2.warn)("Optional content group not defined."), true;
          if (t.type === "OCG") return R(this, y2).has(t.id) ? R(this, y2).get(t.id).visible : ((0, c2.warn)(`Optional content group not found: ${t.id}`), true);
          if (t.type === "OCMD") {
            if (t.expression) return ft(this, T2, he).call(this, t.expression);
            if (!t.policy || t.policy === "AnyOn") {
              for (const s of t.ids) {
                if (!R(this, y2).has(s)) return (0, c2.warn)(`Optional content group not found: ${s}`), true;
                if (R(this, y2).get(s).visible) return true;
              }
              return false;
            } else if (t.policy === "AllOn") {
              for (const s of t.ids) {
                if (!R(this, y2).has(s)) return (0, c2.warn)(`Optional content group not found: ${s}`), true;
                if (!R(this, y2).get(s).visible) return false;
              }
              return true;
            } else if (t.policy === "AnyOff") {
              for (const s of t.ids) {
                if (!R(this, y2).has(s)) return (0, c2.warn)(`Optional content group not found: ${s}`), true;
                if (!R(this, y2).get(s).visible) return true;
              }
              return false;
            } else if (t.policy === "AllOff") {
              for (const s of t.ids) {
                if (!R(this, y2).has(s)) return (0, c2.warn)(`Optional content group not found: ${s}`), true;
                if (R(this, y2).get(s).visible) return false;
              }
              return true;
            }
            return (0, c2.warn)(`Unknown optional content policy ${t.policy}.`), true;
          }
          return (0, c2.warn)(`Unknown group type ${t.type}.`), true;
        }
        setVisibility(t, s = true) {
          if (!R(this, y2).has(t)) {
            (0, c2.warn)(`Optional content group not found: ${t}`);
            return;
          }
          R(this, y2).get(t)._setVisible(S2, !!s), mt(this, I2, null);
        }
        get hasInitialVisibility() {
          if (R(this, I2) !== null) return R(this, I2);
          for (const [t, s] of R(this, y2)) {
            const a = R(this, w).get(t);
            if (s.visible !== a) return mt(this, I2, false);
          }
          return mt(this, I2, true);
        }
        getOrder() {
          return R(this, y2).size ? R(this, k2) ? R(this, k2).slice() : [...R(this, y2).keys()] : null;
        }
        getGroups() {
          return R(this, y2).size > 0 ? (0, c2.objectFromMap)(R(this, y2)) : null;
        }
        getGroup(t) {
          return R(this, y2).get(t) || null;
        }
      }
      I2 = /* @__PURE__ */ new WeakMap(), y2 = /* @__PURE__ */ new WeakMap(), w = /* @__PURE__ */ new WeakMap(), k2 = /* @__PURE__ */ new WeakMap(), T2 = /* @__PURE__ */ new WeakSet(), he = function(t) {
        const s = t.length;
        if (s < 2) return true;
        const a = t[0];
        for (let h = 1; h < s; h++) {
          const b = t[h];
          let r;
          if (Array.isArray(b)) r = ft(this, T2, he).call(this, b);
          else if (R(this, y2).has(b)) r = R(this, y2).get(b).visible;
          else return (0, c2.warn)(`Optional content group not found: ${b}`), true;
          switch (a) {
            case "And":
              if (!r) return false;
              break;
            case "Or":
              if (r) return true;
              break;
            case "Not":
              return !r;
            default:
              return true;
          }
        }
        return a === "And";
      }, f2.OptionalContentConfig = B2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.PDFDataTransportStream = void 0;
      var c2 = $2(1), S2 = $2(8);
      class q2 {
        constructor(y2, w) {
          (0, c2.assert)(w, 'PDFDataTransportStream - missing required "pdfDataRangeTransport" argument.'), this._queuedChunks = [], this._progressiveDone = y2.progressiveDone || false, this._contentDispositionFilename = y2.contentDispositionFilename || null;
          const k2 = y2.initialData;
          if ((k2 == null ? void 0 : k2.length) > 0) {
            const T2 = new Uint8Array(k2).buffer;
            this._queuedChunks.push(T2);
          }
          this._pdfDataRangeTransport = w, this._isStreamingSupported = !y2.disableStream, this._isRangeSupported = !y2.disableRange, this._contentLength = y2.length, this._fullRequestReader = null, this._rangeReaders = [], this._pdfDataRangeTransport.addRangeListener((T2, C2) => {
            this._onReceiveData({ begin: T2, chunk: C2 });
          }), this._pdfDataRangeTransport.addProgressListener((T2, C2) => {
            this._onProgress({ loaded: T2, total: C2 });
          }), this._pdfDataRangeTransport.addProgressiveReadListener((T2) => {
            this._onReceiveData({ chunk: T2 });
          }), this._pdfDataRangeTransport.addProgressiveDoneListener(() => {
            this._onProgressiveDone();
          }), this._pdfDataRangeTransport.transportReady();
        }
        _onReceiveData(y2) {
          const w = new Uint8Array(y2.chunk).buffer;
          if (y2.begin === void 0) this._fullRequestReader ? this._fullRequestReader._enqueue(w) : this._queuedChunks.push(w);
          else {
            const k2 = this._rangeReaders.some(function(T2) {
              return T2._begin !== y2.begin ? false : (T2._enqueue(w), true);
            });
            (0, c2.assert)(k2, "_onReceiveData - no `PDFDataTransportStreamRangeReader` instance found.");
          }
        }
        get _progressiveDataLength() {
          var y2;
          return ((y2 = this._fullRequestReader) == null ? void 0 : y2._loaded) ?? 0;
        }
        _onProgress(y2) {
          if (y2.total === void 0) {
            const w = this._rangeReaders[0];
            w != null && w.onProgress && w.onProgress({ loaded: y2.loaded });
          } else {
            const w = this._fullRequestReader;
            w != null && w.onProgress && w.onProgress({ loaded: y2.loaded, total: y2.total });
          }
        }
        _onProgressiveDone() {
          this._fullRequestReader && this._fullRequestReader.progressiveDone(), this._progressiveDone = true;
        }
        _removeRangeReader(y2) {
          const w = this._rangeReaders.indexOf(y2);
          w >= 0 && this._rangeReaders.splice(w, 1);
        }
        getFullReader() {
          (0, c2.assert)(!this._fullRequestReader, "PDFDataTransportStream.getFullReader can only be called once.");
          const y2 = this._queuedChunks;
          return this._queuedChunks = null, new B2(this, y2, this._progressiveDone, this._contentDispositionFilename);
        }
        getRangeReader(y2, w) {
          if (w <= this._progressiveDataLength) return null;
          const k2 = new Q2(this, y2, w);
          return this._pdfDataRangeTransport.requestDataRange(y2, w), this._rangeReaders.push(k2), k2;
        }
        cancelAllRequests(y2) {
          this._fullRequestReader && this._fullRequestReader.cancel(y2);
          for (const w of this._rangeReaders.slice(0)) w.cancel(y2);
          this._pdfDataRangeTransport.abort();
        }
      }
      f2.PDFDataTransportStream = q2;
      class B2 {
        constructor(y2, w, k2 = false, T2 = null) {
          this._stream = y2, this._done = k2 || false, this._filename = (0, S2.isPdfFile)(T2) ? T2 : null, this._queuedChunks = w || [], this._loaded = 0;
          for (const C2 of this._queuedChunks) this._loaded += C2.byteLength;
          this._requests = [], this._headersReady = Promise.resolve(), y2._fullRequestReader = this, this.onProgress = null;
        }
        _enqueue(y2) {
          this._done || (this._requests.length > 0 ? this._requests.shift().resolve({ value: y2, done: false }) : this._queuedChunks.push(y2), this._loaded += y2.byteLength);
        }
        get headersReady() {
          return this._headersReady;
        }
        get filename() {
          return this._filename;
        }
        get isRangeSupported() {
          return this._stream._isRangeSupported;
        }
        get isStreamingSupported() {
          return this._stream._isStreamingSupported;
        }
        get contentLength() {
          return this._stream._contentLength;
        }
        async read() {
          if (this._queuedChunks.length > 0) return { value: this._queuedChunks.shift(), done: false };
          if (this._done) return { value: void 0, done: true };
          const y2 = (0, c2.createPromiseCapability)();
          return this._requests.push(y2), y2.promise;
        }
        cancel(y2) {
          this._done = true;
          for (const w of this._requests) w.resolve({ value: void 0, done: true });
          this._requests.length = 0;
        }
        progressiveDone() {
          this._done || (this._done = true);
        }
      }
      class Q2 {
        constructor(y2, w, k2) {
          this._stream = y2, this._begin = w, this._end = k2, this._queuedChunk = null, this._requests = [], this._done = false, this.onProgress = null;
        }
        _enqueue(y2) {
          if (!this._done) {
            if (this._requests.length === 0) this._queuedChunk = y2;
            else {
              this._requests.shift().resolve({ value: y2, done: false });
              for (const k2 of this._requests) k2.resolve({ value: void 0, done: true });
              this._requests.length = 0;
            }
            this._done = true, this._stream._removeRangeReader(this);
          }
        }
        get isStreamingSupported() {
          return false;
        }
        async read() {
          if (this._queuedChunk) {
            const w = this._queuedChunk;
            return this._queuedChunk = null, { value: w, done: false };
          }
          if (this._done) return { value: void 0, done: true };
          const y2 = (0, c2.createPromiseCapability)();
          return this._requests.push(y2), y2.promise;
        }
        cancel(y2) {
          this._done = true;
          for (const w of this._requests) w.resolve({ value: void 0, done: true });
          this._requests.length = 0, this._stream._removeRangeReader(this);
        }
      }
    }, (z2, f2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.XfaText = void 0;
      class $2 {
        static textContent(S2) {
          const q2 = [], B2 = { items: q2, styles: /* @__PURE__ */ Object.create(null) };
          function Q2(I2) {
            var k2;
            if (!I2) return;
            let y2 = null;
            const w = I2.name;
            if (w === "#text") y2 = I2.value;
            else if ($2.shouldBuildText(w)) (k2 = I2 == null ? void 0 : I2.attributes) != null && k2.textContent ? y2 = I2.attributes.textContent : I2.value && (y2 = I2.value);
            else return;
            if (y2 !== null && q2.push({ str: y2 }), !!I2.children) for (const T2 of I2.children) Q2(T2);
          }
          return Q2(S2), B2;
        }
        static shouldBuildText(S2) {
          return !(S2 === "textarea" || S2 === "input" || S2 === "option" || S2 === "select");
        }
      }
      f2.XfaText = $2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.NodeStandardFontDataFactory = f2.NodeCanvasFactory = f2.NodeCMapReaderFactory = void 0;
      var c2 = $2(9);
      const S2 = function(I2) {
        return new Promise((y2, w) => {
          require$$4.readFile(I2, (T2, C2) => {
            if (T2 || !C2) {
              w(new Error(T2));
              return;
            }
            y2(new Uint8Array(C2));
          });
        });
      };
      class q2 extends c2.BaseCanvasFactory {
        _createCanvas(y2, w) {
          return require$$4.createCanvas(y2, w);
        }
      }
      f2.NodeCanvasFactory = q2;
      class B2 extends c2.BaseCMapReaderFactory {
        _fetchData(y2, w) {
          return S2(y2).then((k2) => ({ cMapData: k2, compressionType: w }));
        }
      }
      f2.NodeCMapReaderFactory = B2;
      class Q2 extends c2.BaseStandardFontDataFactory {
        _fetchData(y2) {
          return S2(y2);
        }
      }
      f2.NodeStandardFontDataFactory = Q2;
    }, (z2, f2, $2) => {
      var I2, y2, w, k2, T2, C2, l, t, s, ue, h, ke, r, fe, e, Re;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.AnnotationEditorLayer = void 0;
      var c2 = $2(7), S2 = $2(1), q2 = $2(23), B2 = $2(24);
      const v = class v2 {
        constructor(d) {
          ct(this, s);
          ct(this, h);
          ct(this, r);
          ct(this, e);
          ct(this, I2, void 0);
          ct(this, y2, false);
          ct(this, w, this.pointerup.bind(this));
          ct(this, k2, this.pointerdown.bind(this));
          ct(this, T2, /* @__PURE__ */ new Map());
          ct(this, C2, false);
          ct(this, l, false);
          ct(this, t, void 0);
          v2._initialized || (v2._initialized = true, q2.FreeTextEditor.initialize(d.l10n), B2.InkEditor.initialize(d.l10n), d.uiManager.registerEditorTypes([q2.FreeTextEditor, B2.InkEditor])), mt(this, t, d.uiManager), this.annotationStorage = d.annotationStorage, this.pageIndex = d.pageIndex, this.div = d.div, mt(this, I2, d.accessibilityManager), R(this, t).addLayer(this);
        }
        updateToolbar(d) {
          R(this, t).updateToolbar(d);
        }
        updateMode(d = R(this, t).getMode()) {
          ft(this, e, Re).call(this), d === S2.AnnotationEditorType.INK ? (this.addInkEditorIfNeeded(false), this.disableClick()) : this.enableClick(), R(this, t).unselectAll();
        }
        addInkEditorIfNeeded(d) {
          if (!d && R(this, t).getMode() !== S2.AnnotationEditorType.INK) return;
          if (!d) {
            for (const U of R(this, T2).values()) if (U.isEmpty()) {
              U.setInBackground();
              return;
            }
          }
          ft(this, r, fe).call(this, { offsetX: 0, offsetY: 0 }).setInBackground();
        }
        setEditingState(d) {
          R(this, t).setEditingState(d);
        }
        addCommands(d) {
          R(this, t).addCommands(d);
        }
        enable() {
          this.div.style.pointerEvents = "auto";
          for (const d of R(this, T2).values()) d.enableEditing();
        }
        disable() {
          this.div.style.pointerEvents = "none";
          for (const d of R(this, T2).values()) d.disableEditing();
        }
        setActiveEditor(d) {
          R(this, t).getActive() !== d && R(this, t).setActiveEditor(d);
        }
        enableClick() {
          this.div.addEventListener("pointerdown", R(this, k2)), this.div.addEventListener("pointerup", R(this, w));
        }
        disableClick() {
          this.div.removeEventListener("pointerdown", R(this, k2)), this.div.removeEventListener("pointerup", R(this, w));
        }
        attach(d) {
          R(this, T2).set(d.id, d);
        }
        detach(d) {
          var E;
          R(this, T2).delete(d.id), (E = R(this, I2)) == null || E.removePointerInTextLayer(d.contentDiv);
        }
        remove(d) {
          R(this, t).removeEditor(d), this.detach(d), this.annotationStorage.remove(d.id), d.div.style.display = "none", setTimeout(() => {
            d.div.style.display = "", d.div.remove(), d.isAttachedToDOM = false, document.activeElement === document.body && R(this, t).focusMainContainer();
          }, 0), R(this, l) || this.addInkEditorIfNeeded(false);
        }
        add(d) {
          if (ft(this, s, ue).call(this, d), R(this, t).addEditor(d), this.attach(d), !d.isAttachedToDOM) {
            const E = d.render();
            this.div.append(E), d.isAttachedToDOM = true;
          }
          this.moveEditorInDOM(d), d.onceAdded(), this.addToAnnotationStorage(d);
        }
        moveEditorInDOM(d) {
          var E;
          (E = R(this, I2)) == null || E.moveElementInDOM(this.div, d.div, d.contentDiv, true);
        }
        addToAnnotationStorage(d) {
          !d.isEmpty() && !this.annotationStorage.has(d.id) && this.annotationStorage.setValue(d.id, d);
        }
        addOrRebuild(d) {
          d.needsToBeRebuilt() ? d.rebuild() : this.add(d);
        }
        addANewEditor(d) {
          const E = () => {
            this.addOrRebuild(d);
          }, U = () => {
            d.remove();
          };
          this.addCommands({ cmd: E, undo: U, mustExec: true });
        }
        addUndoableEditor(d) {
          const E = () => {
            this.addOrRebuild(d);
          }, U = () => {
            d.remove();
          };
          this.addCommands({ cmd: E, undo: U, mustExec: false });
        }
        getNextId() {
          return R(this, t).getId();
        }
        deserialize(d) {
          switch (d.annotationType) {
            case S2.AnnotationEditorType.FREETEXT:
              return q2.FreeTextEditor.deserialize(d, this);
            case S2.AnnotationEditorType.INK:
              return B2.InkEditor.deserialize(d, this);
          }
          return null;
        }
        setSelected(d) {
          R(this, t).setSelected(d);
        }
        toggleSelected(d) {
          R(this, t).toggleSelected(d);
        }
        isSelected(d) {
          return R(this, t).isSelected(d);
        }
        unselect(d) {
          R(this, t).unselect(d);
        }
        pointerup(d) {
          const E = c2.KeyboardManager.platform.isMac;
          if (!(d.button !== 0 || d.ctrlKey && E) && d.target === this.div && R(this, C2)) {
            if (mt(this, C2, false), !R(this, y2)) {
              mt(this, y2, true);
              return;
            }
            ft(this, r, fe).call(this, d);
          }
        }
        pointerdown(d) {
          const E = c2.KeyboardManager.platform.isMac;
          if (d.button !== 0 || d.ctrlKey && E || d.target !== this.div) return;
          mt(this, C2, true);
          const U = R(this, t).getActive();
          mt(this, y2, !U || U.isEmpty());
        }
        drop(d) {
          const E = d.dataTransfer.getData("text/plain"), U = R(this, t).getEditor(E);
          if (!U) return;
          d.preventDefault(), d.dataTransfer.dropEffect = "move", ft(this, s, ue).call(this, U);
          const tt = this.div.getBoundingClientRect(), H = d.clientX - tt.x, Z = d.clientY - tt.y;
          U.translate(H - U.startX, Z - U.startY), this.moveEditorInDOM(U), U.div.focus();
        }
        dragover(d) {
          d.preventDefault();
        }
        destroy() {
          var d, E;
          ((d = R(this, t).getActive()) == null ? void 0 : d.parent) === this && R(this, t).setActiveEditor(null);
          for (const U of R(this, T2).values()) (E = R(this, I2)) == null || E.removePointerInTextLayer(U.contentDiv), U.isAttachedToDOM = false, U.div.remove(), U.parent = null;
          this.div = null, R(this, T2).clear(), R(this, t).removeLayer(this);
        }
        render(d) {
          this.viewport = d.viewport, (0, c2.bindEvents)(this, this.div, ["dragover", "drop"]), this.setDimensions();
          for (const E of R(this, t).getEditors(this.pageIndex)) this.add(E);
          this.updateMode();
        }
        update(d) {
          this.viewport = d.viewport, this.setDimensions(), this.updateMode();
        }
        get scaleFactor() {
          return this.viewport.scale;
        }
        get pageDimensions() {
          const [d, E, U, tt] = this.viewport.viewBox, H = U - d, Z = tt - E;
          return [H, Z];
        }
        get viewportBaseDimensions() {
          const { width: d, height: E, rotation: U } = this.viewport;
          return U % 180 === 0 ? [d, E] : [E, d];
        }
        setDimensions() {
          const { width: d, height: E, rotation: U } = this.viewport, tt = U % 180 !== 0, H = Math.floor(d) + "px", Z = Math.floor(E) + "px";
          this.div.style.width = tt ? Z : H, this.div.style.height = tt ? H : Z, this.div.setAttribute("data-main-rotation", U);
        }
      };
      I2 = /* @__PURE__ */ new WeakMap(), y2 = /* @__PURE__ */ new WeakMap(), w = /* @__PURE__ */ new WeakMap(), k2 = /* @__PURE__ */ new WeakMap(), T2 = /* @__PURE__ */ new WeakMap(), C2 = /* @__PURE__ */ new WeakMap(), l = /* @__PURE__ */ new WeakMap(), t = /* @__PURE__ */ new WeakMap(), s = /* @__PURE__ */ new WeakSet(), ue = function(d) {
        var E;
        d.parent !== this && (this.attach(d), d.pageIndex = this.pageIndex, (E = d.parent) == null || E.detach(d), d.parent = this, d.div && d.isAttachedToDOM && (d.div.remove(), this.div.append(d.div)));
      }, h = /* @__PURE__ */ new WeakSet(), ke = function(d) {
        switch (R(this, t).getMode()) {
          case S2.AnnotationEditorType.FREETEXT:
            return new q2.FreeTextEditor(d);
          case S2.AnnotationEditorType.INK:
            return new B2.InkEditor(d);
        }
        return null;
      }, r = /* @__PURE__ */ new WeakSet(), fe = function(d) {
        const E = this.getNextId(), U = ft(this, h, ke).call(this, { parent: this, id: E, x: d.offsetX, y: d.offsetY });
        return U && this.add(U), U;
      }, e = /* @__PURE__ */ new WeakSet(), Re = function() {
        mt(this, l, true);
        for (const d of R(this, T2).values()) d.isEmpty() && d.remove();
        mt(this, l, false);
      }, Mt(v, "_initialized", false);
      let Q2 = v;
      f2.AnnotationEditorLayer = Q2;
    }, (z2, f2, $2) => {
      var Q2, I2, y2, w, k2, T2, C2, l, Ie, s, Me, h, Fe, r, pe;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.FreeTextEditor = void 0;
      var c2 = $2(1), S2 = $2(7), q2 = $2(6);
      const e = class e2 extends q2.AnnotationEditor {
        constructor(m) {
          super({ ...m, name: "freeTextEditor" });
          ct(this, l);
          ct(this, s);
          ct(this, h);
          ct(this, r);
          ct(this, Q2, this.editorDivBlur.bind(this));
          ct(this, I2, this.editorDivFocus.bind(this));
          ct(this, y2, this.editorDivKeydown.bind(this));
          ct(this, w, void 0);
          ct(this, k2, "");
          ct(this, T2, false);
          ct(this, C2, void 0);
          mt(this, w, m.color || e2._defaultColor || q2.AnnotationEditor._defaultLineColor), mt(this, C2, m.fontSize || e2._defaultFontSize);
        }
        static initialize(m) {
          this._l10nPromise = new Map(["free_text_default_content", "editor_free_text_aria_label"].map((E) => [E, m.get(E)]));
          const d = getComputedStyle(document.documentElement);
          this._internalPadding = parseFloat(d.getPropertyValue("--freetext-padding"));
        }
        static updateDefaultParams(m, d) {
          switch (m) {
            case c2.AnnotationEditorParamsType.FREETEXT_SIZE:
              e2._defaultFontSize = d;
              break;
            case c2.AnnotationEditorParamsType.FREETEXT_COLOR:
              e2._defaultColor = d;
              break;
          }
        }
        updateParams(m, d) {
          switch (m) {
            case c2.AnnotationEditorParamsType.FREETEXT_SIZE:
              ft(this, l, Ie).call(this, d);
              break;
            case c2.AnnotationEditorParamsType.FREETEXT_COLOR:
              ft(this, s, Me).call(this, d);
              break;
          }
        }
        static get defaultPropertiesToUpdate() {
          return [[c2.AnnotationEditorParamsType.FREETEXT_SIZE, e2._defaultFontSize], [c2.AnnotationEditorParamsType.FREETEXT_COLOR, e2._defaultColor || q2.AnnotationEditor._defaultLineColor]];
        }
        get propertiesToUpdate() {
          return [[c2.AnnotationEditorParamsType.FREETEXT_SIZE, R(this, C2)], [c2.AnnotationEditorParamsType.FREETEXT_COLOR, R(this, w)]];
        }
        getInitialTranslation() {
          return [-e2._internalPadding * this.parent.scaleFactor, -(e2._internalPadding + R(this, C2)) * this.parent.scaleFactor];
        }
        rebuild() {
          super.rebuild(), this.div !== null && (this.isAttachedToDOM || this.parent.add(this));
        }
        enableEditMode() {
          this.isInEditMode() || (this.parent.setEditingState(false), this.parent.updateToolbar(c2.AnnotationEditorType.FREETEXT), super.enableEditMode(), this.enableEditing(), this.overlayDiv.classList.remove("enabled"), this.editorDiv.contentEditable = true, this.div.draggable = false, this.editorDiv.addEventListener("keydown", R(this, y2)), this.editorDiv.addEventListener("focus", R(this, I2)), this.editorDiv.addEventListener("blur", R(this, Q2)));
        }
        disableEditMode() {
          this.isInEditMode() && (this.parent.setEditingState(true), super.disableEditMode(), this.disableEditing(), this.overlayDiv.classList.add("enabled"), this.editorDiv.contentEditable = false, this.div.draggable = true, this.editorDiv.removeEventListener("keydown", R(this, y2)), this.editorDiv.removeEventListener("focus", R(this, I2)), this.editorDiv.removeEventListener("blur", R(this, Q2)), this.div.focus(), this.isEditing = false);
        }
        focusin(m) {
          super.focusin(m), m.target !== this.editorDiv && this.editorDiv.focus();
        }
        onceAdded() {
          this.width || (this.enableEditMode(), this.editorDiv.focus());
        }
        isEmpty() {
          return !this.editorDiv || this.editorDiv.innerText.trim() === "";
        }
        remove() {
          this.isEditing = false, this.parent.setEditingState(true), super.remove();
        }
        commit() {
          super.commit(), R(this, T2) || (mt(this, T2, true), this.parent.addUndoableEditor(this)), this.disableEditMode(), mt(this, k2, ft(this, h, Fe).call(this).trimEnd()), ft(this, r, pe).call(this);
        }
        shouldGetKeyboardEvents() {
          return this.isInEditMode();
        }
        dblclick(m) {
          this.enableEditMode(), this.editorDiv.focus();
        }
        keydown(m) {
          m.target === this.div && m.key === "Enter" && (this.enableEditMode(), this.editorDiv.focus());
        }
        editorDivKeydown(m) {
          e2._keyboardManager.exec(this, m);
        }
        editorDivFocus(m) {
          this.isEditing = true;
        }
        editorDivBlur(m) {
          this.isEditing = false;
        }
        disableEditing() {
          this.editorDiv.setAttribute("role", "comment"), this.editorDiv.removeAttribute("aria-multiline");
        }
        enableEditing() {
          this.editorDiv.setAttribute("role", "textbox"), this.editorDiv.setAttribute("aria-multiline", true);
        }
        render() {
          if (this.div) return this.div;
          let m, d;
          this.width && (m = this.x, d = this.y), super.render(), this.editorDiv = document.createElement("div"), this.editorDiv.className = "internal", this.editorDiv.setAttribute("id", `${this.id}-editor`), this.enableEditing(), e2._l10nPromise.get("editor_free_text_aria_label").then((U) => {
            var tt;
            return (tt = this.editorDiv) == null ? void 0 : tt.setAttribute("aria-label", U);
          }), e2._l10nPromise.get("free_text_default_content").then((U) => {
            var tt;
            return (tt = this.editorDiv) == null ? void 0 : tt.setAttribute("default-content", U);
          }), this.editorDiv.contentEditable = true;
          const { style: E } = this.editorDiv;
          if (E.fontSize = `calc(${R(this, C2)}px * var(--scale-factor))`, E.color = R(this, w), this.div.append(this.editorDiv), this.overlayDiv = document.createElement("div"), this.overlayDiv.classList.add("overlay", "enabled"), this.div.append(this.overlayDiv), (0, S2.bindEvents)(this, this.div, ["dblclick", "keydown"]), this.width) {
            const [U, tt] = this.parent.viewportBaseDimensions;
            this.setAt(m * U, d * tt, this.width * U, this.height * tt);
            for (const H of R(this, k2).split(`
`)) {
              const Z = document.createElement("div");
              Z.append(H ? document.createTextNode(H) : document.createElement("br")), this.editorDiv.append(Z);
            }
            this.div.draggable = true, this.editorDiv.contentEditable = false;
          } else this.div.draggable = false, this.editorDiv.contentEditable = true;
          return this.div;
        }
        get contentDiv() {
          return this.editorDiv;
        }
        static deserialize(m, d) {
          const E = super.deserialize(m, d);
          return mt(E, C2, m.fontSize), mt(E, w, c2.Util.makeHexColor(...m.color)), mt(E, k2, m.value), E;
        }
        serialize() {
          if (this.isEmpty()) return null;
          const m = e2._internalPadding * this.parent.scaleFactor, d = this.getRect(m, m), E = q2.AnnotationEditor._colorManager.convert(getComputedStyle(this.editorDiv).color);
          return { annotationType: c2.AnnotationEditorType.FREETEXT, color: E, fontSize: R(this, C2), value: R(this, k2), pageIndex: this.parent.pageIndex, rect: d, rotation: this.rotation };
        }
      };
      Q2 = /* @__PURE__ */ new WeakMap(), I2 = /* @__PURE__ */ new WeakMap(), y2 = /* @__PURE__ */ new WeakMap(), w = /* @__PURE__ */ new WeakMap(), k2 = /* @__PURE__ */ new WeakMap(), T2 = /* @__PURE__ */ new WeakMap(), C2 = /* @__PURE__ */ new WeakMap(), l = /* @__PURE__ */ new WeakSet(), Ie = function(m) {
        const d = (U) => {
          this.editorDiv.style.fontSize = `calc(${U}px * var(--scale-factor))`, this.translate(0, -(U - R(this, C2)) * this.parent.scaleFactor), mt(this, C2, U), ft(this, r, pe).call(this);
        }, E = R(this, C2);
        this.parent.addCommands({ cmd: () => {
          d(m);
        }, undo: () => {
          d(E);
        }, mustExec: true, type: c2.AnnotationEditorParamsType.FREETEXT_SIZE, overwriteIfSameType: true, keepUndo: true });
      }, s = /* @__PURE__ */ new WeakSet(), Me = function(m) {
        const d = R(this, w);
        this.parent.addCommands({ cmd: () => {
          mt(this, w, m), this.editorDiv.style.color = m;
        }, undo: () => {
          mt(this, w, d), this.editorDiv.style.color = d;
        }, mustExec: true, type: c2.AnnotationEditorParamsType.FREETEXT_COLOR, overwriteIfSameType: true, keepUndo: true });
      }, h = /* @__PURE__ */ new WeakSet(), Fe = function() {
        const m = this.editorDiv.getElementsByTagName("div");
        if (m.length === 0) return this.editorDiv.innerText;
        const d = [];
        for (let E = 0, U = m.length; E < U; E++) {
          const H = m[E].firstChild;
          (H == null ? void 0 : H.nodeName) === "#text" ? d.push(H.data) : d.push("");
        }
        return d.join(`
`);
      }, r = /* @__PURE__ */ new WeakSet(), pe = function() {
        const [m, d] = this.parent.viewportBaseDimensions, E = this.div.getBoundingClientRect();
        this.width = E.width / m, this.height = E.height / d;
      }, Mt(e, "_freeTextDefaultContent", ""), Mt(e, "_l10nPromise"), Mt(e, "_internalPadding", 0), Mt(e, "_defaultColor", null), Mt(e, "_defaultFontSize", 10), Mt(e, "_keyboardManager", new S2.KeyboardManager([[["ctrl+Enter", "mac+meta+Enter", "Escape", "mac+Escape"], e.prototype.commitOrRemove]])), Mt(e, "_type", "freetext");
      let B2 = e;
      f2.FreeTextEditor = B2;
    }, (z2, f2, $2) => {
      var y2, w, k2, T2, C2, l, t, s, a, h, b, r, n, e, o, De, m, Le, E, Oe, tt, Ne, Z, ge, V, Be, at, je, bt, Ue, p, qt, P, me, D, ee, Y, ne, i, Yt, g, be, x, se, st, _e, J, We, et, Ve, ut, He, ht, ye, vt, ie, wt, Kt, Rt, Ae;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.InkEditor = void 0, Object.defineProperty(f2, "fitCurve", { enumerable: true, get: function() {
        return q2.fitCurve;
      } });
      var c2 = $2(1), S2 = $2(6), q2 = $2(25), B2 = $2(7);
      const Q2 = 16, Et = class Et2 extends S2.AnnotationEditor {
        constructor(lt) {
          super({ ...lt, name: "inkEditor" });
          ct(this, o);
          ct(this, m);
          ct(this, E);
          ct(this, tt);
          ct(this, Z);
          ct(this, V);
          ct(this, at);
          ct(this, bt);
          ct(this, p);
          ct(this, P);
          ct(this, D);
          ct(this, Y);
          ct(this, i);
          ct(this, g);
          ct(this, x);
          ct(this, J);
          ct(this, et);
          ct(this, ut);
          ct(this, ht);
          ct(this, vt);
          ct(this, wt);
          ct(this, Rt);
          ct(this, y2, 0);
          ct(this, w, 0);
          ct(this, k2, 0);
          ct(this, T2, this.canvasPointermove.bind(this));
          ct(this, C2, this.canvasPointerleave.bind(this));
          ct(this, l, this.canvasPointerup.bind(this));
          ct(this, t, this.canvasPointerdown.bind(this));
          ct(this, s, false);
          ct(this, a, false);
          ct(this, h, null);
          ct(this, b, null);
          ct(this, r, 0);
          ct(this, n, 0);
          ct(this, e, null);
          this.color = lt.color || null, this.thickness = lt.thickness || null, this.opacity = lt.opacity || null, this.paths = [], this.bezierPath2D = [], this.currentPath = [], this.scaleFactor = 1, this.translationX = this.translationY = 0, this.x = 0, this.y = 0;
        }
        static initialize(lt) {
          this._l10nPromise = new Map(["editor_ink_canvas_aria_label", "editor_ink_aria_label"].map((pt) => [pt, lt.get(pt)]));
        }
        static updateDefaultParams(lt, pt) {
          switch (lt) {
            case c2.AnnotationEditorParamsType.INK_THICKNESS:
              Et2._defaultThickness = pt;
              break;
            case c2.AnnotationEditorParamsType.INK_COLOR:
              Et2._defaultColor = pt;
              break;
            case c2.AnnotationEditorParamsType.INK_OPACITY:
              Et2._defaultOpacity = pt / 100;
              break;
          }
        }
        updateParams(lt, pt) {
          switch (lt) {
            case c2.AnnotationEditorParamsType.INK_THICKNESS:
              ft(this, o, De).call(this, pt);
              break;
            case c2.AnnotationEditorParamsType.INK_COLOR:
              ft(this, m, Le).call(this, pt);
              break;
            case c2.AnnotationEditorParamsType.INK_OPACITY:
              ft(this, E, Oe).call(this, pt);
              break;
          }
        }
        static get defaultPropertiesToUpdate() {
          return [[c2.AnnotationEditorParamsType.INK_THICKNESS, Et2._defaultThickness], [c2.AnnotationEditorParamsType.INK_COLOR, Et2._defaultColor || S2.AnnotationEditor._defaultLineColor], [c2.AnnotationEditorParamsType.INK_OPACITY, Math.round(Et2._defaultOpacity * 100)]];
        }
        get propertiesToUpdate() {
          return [[c2.AnnotationEditorParamsType.INK_THICKNESS, this.thickness || Et2._defaultThickness], [c2.AnnotationEditorParamsType.INK_COLOR, this.color || Et2._defaultColor || S2.AnnotationEditor._defaultLineColor], [c2.AnnotationEditorParamsType.INK_OPACITY, Math.round(100 * (this.opacity ?? Et2._defaultOpacity))]];
        }
        rebuild() {
          super.rebuild(), this.div !== null && (this.canvas || (ft(this, D, ee).call(this), ft(this, Y, ne).call(this)), this.isAttachedToDOM || (this.parent.add(this), ft(this, i, Yt).call(this)), ft(this, wt, Kt).call(this));
        }
        remove() {
          this.canvas !== null && (this.isEmpty() || this.commit(), this.canvas.width = this.canvas.height = 0, this.canvas.remove(), this.canvas = null, R(this, b).disconnect(), mt(this, b, null), super.remove());
        }
        enableEditMode() {
          R(this, s) || this.canvas === null || (super.enableEditMode(), this.div.draggable = false, this.canvas.addEventListener("pointerdown", R(this, t)), this.canvas.addEventListener("pointerup", R(this, l)));
        }
        disableEditMode() {
          !this.isInEditMode() || this.canvas === null || (super.disableEditMode(), this.div.draggable = !this.isEmpty(), this.div.classList.remove("editing"), this.canvas.removeEventListener("pointerdown", R(this, t)), this.canvas.removeEventListener("pointerup", R(this, l)));
        }
        onceAdded() {
          this.div.draggable = !this.isEmpty();
        }
        isEmpty() {
          return this.paths.length === 0 || this.paths.length === 1 && this.paths[0].length === 0;
        }
        commit() {
          R(this, s) || (super.commit(), this.isEditing = false, this.disableEditMode(), this.setInForeground(), mt(this, s, true), this.div.classList.add("disabled"), ft(this, wt, Kt).call(this, true), this.parent.addInkEditorIfNeeded(true), this.parent.moveEditorInDOM(this), this.div.focus());
        }
        focusin(lt) {
          super.focusin(lt), this.enableEditMode();
        }
        canvasPointerdown(lt) {
          lt.button !== 0 || !this.isInEditMode() || R(this, s) || (this.setInForeground(), lt.type !== "mouse" && this.div.focus(), lt.stopPropagation(), this.canvas.addEventListener("pointerleave", R(this, C2)), this.canvas.addEventListener("pointermove", R(this, T2)), ft(this, V, Be).call(this, lt.offsetX, lt.offsetY));
        }
        canvasPointermove(lt) {
          lt.stopPropagation(), ft(this, at, je).call(this, lt.offsetX, lt.offsetY);
        }
        canvasPointerup(lt) {
          lt.button === 0 && this.isInEditMode() && this.currentPath.length !== 0 && (lt.stopPropagation(), ft(this, P, me).call(this, lt), this.setInBackground());
        }
        canvasPointerleave(lt) {
          ft(this, P, me).call(this, lt), this.setInBackground();
        }
        render() {
          if (this.div) return this.div;
          let lt, pt;
          this.width && (lt = this.x, pt = this.y), super.render(), Et2._l10nPromise.get("editor_ink_aria_label").then((_t) => {
            var At;
            return (At = this.div) == null ? void 0 : At.setAttribute("aria-label", _t);
          });
          const [nt, W, G, gt] = ft(this, tt, Ne).call(this);
          if (this.setAt(nt, W, 0, 0), this.setDims(G, gt), ft(this, D, ee).call(this), this.width) {
            const [_t, At] = this.parent.viewportBaseDimensions;
            this.setAt(lt * _t, pt * At, this.width * _t, this.height * At), mt(this, a, true), ft(this, i, Yt).call(this), this.setDims(this.width * _t, this.height * At), ft(this, p, qt).call(this), ft(this, Rt, Ae).call(this), this.div.classList.add("disabled");
          } else this.div.classList.add("editing"), this.enableEditMode();
          return ft(this, Y, ne).call(this), this.div;
        }
        setDimensions(lt, pt) {
          const nt = Math.round(lt), W = Math.round(pt);
          if (R(this, r) === nt && R(this, n) === W) return;
          mt(this, r, nt), mt(this, n, W), this.canvas.style.visibility = "hidden", R(this, y2) && Math.abs(R(this, y2) - lt / pt) > 0.01 && (pt = Math.ceil(lt / R(this, y2)), this.setDims(lt, pt));
          const [G, gt] = this.parent.viewportBaseDimensions;
          this.width = lt / G, this.height = pt / gt, R(this, s) && ft(this, g, be).call(this, lt, pt), ft(this, i, Yt).call(this), ft(this, p, qt).call(this), this.canvas.style.visibility = "visible";
        }
        static deserialize(lt, pt) {
          var Dt, kt;
          const nt = super.deserialize(lt, pt);
          nt.thickness = lt.thickness, nt.color = c2.Util.makeHexColor(...lt.color), nt.opacity = lt.opacity;
          const [W, G] = pt.pageDimensions, gt = nt.width * W, _t = nt.height * G, At = pt.scaleFactor, St = lt.thickness / 2;
          mt(nt, y2, gt / _t), mt(nt, s, true), mt(nt, r, Math.round(gt)), mt(nt, n, Math.round(_t));
          for (const { bezier: Tt } of lt.paths) {
            const Ot = [];
            nt.paths.push(Ot);
            let Lt = At * (Tt[0] - St), jt = At * (_t - Tt[1] - St);
            for (let Nt = 2, Wt = Tt.length; Nt < Wt; Nt += 6) {
              const Gt = At * (Tt[Nt] - St), zt = At * (_t - Tt[Nt + 1] - St), Ht = At * (Tt[Nt + 2] - St), Bt = At * (_t - Tt[Nt + 3] - St), Vt = At * (Tt[Nt + 4] - St), Xt = At * (_t - Tt[Nt + 5] - St);
              Ot.push([[Lt, jt], [Gt, zt], [Ht, Bt], [Vt, Xt]]), Lt = Vt, jt = Xt;
            }
            const Pt = ft(this, st, _e).call(this, Ot);
            nt.bezierPath2D.push(Pt);
          }
          const xt = ft(Dt = nt, ht, ye).call(Dt);
          return mt(nt, k2, Math.max(Q2, xt[2] - xt[0])), mt(nt, w, Math.max(Q2, xt[3] - xt[1])), ft(kt = nt, g, be).call(kt, gt, _t), nt;
        }
        serialize() {
          if (this.isEmpty()) return null;
          const lt = this.getRect(0, 0), pt = this.rotation % 180 === 0 ? lt[3] - lt[1] : lt[2] - lt[0], nt = S2.AnnotationEditor._colorManager.convert(this.ctx.strokeStyle);
          return { annotationType: c2.AnnotationEditorType.INK, color: nt, thickness: this.thickness, opacity: this.opacity, paths: ft(this, J, We).call(this, this.scaleFactor / this.parent.scaleFactor, this.translationX, this.translationY, pt), pageIndex: this.parent.pageIndex, rect: lt, rotation: this.rotation };
        }
      };
      y2 = /* @__PURE__ */ new WeakMap(), w = /* @__PURE__ */ new WeakMap(), k2 = /* @__PURE__ */ new WeakMap(), T2 = /* @__PURE__ */ new WeakMap(), C2 = /* @__PURE__ */ new WeakMap(), l = /* @__PURE__ */ new WeakMap(), t = /* @__PURE__ */ new WeakMap(), s = /* @__PURE__ */ new WeakMap(), a = /* @__PURE__ */ new WeakMap(), h = /* @__PURE__ */ new WeakMap(), b = /* @__PURE__ */ new WeakMap(), r = /* @__PURE__ */ new WeakMap(), n = /* @__PURE__ */ new WeakMap(), e = /* @__PURE__ */ new WeakMap(), o = /* @__PURE__ */ new WeakSet(), De = function(lt) {
        const pt = this.thickness;
        this.parent.addCommands({ cmd: () => {
          this.thickness = lt, ft(this, wt, Kt).call(this);
        }, undo: () => {
          this.thickness = pt, ft(this, wt, Kt).call(this);
        }, mustExec: true, type: c2.AnnotationEditorParamsType.INK_THICKNESS, overwriteIfSameType: true, keepUndo: true });
      }, m = /* @__PURE__ */ new WeakSet(), Le = function(lt) {
        const pt = this.color;
        this.parent.addCommands({ cmd: () => {
          this.color = lt, ft(this, p, qt).call(this);
        }, undo: () => {
          this.color = pt, ft(this, p, qt).call(this);
        }, mustExec: true, type: c2.AnnotationEditorParamsType.INK_COLOR, overwriteIfSameType: true, keepUndo: true });
      }, E = /* @__PURE__ */ new WeakSet(), Oe = function(lt) {
        lt /= 100;
        const pt = this.opacity;
        this.parent.addCommands({ cmd: () => {
          this.opacity = lt, ft(this, p, qt).call(this);
        }, undo: () => {
          this.opacity = pt, ft(this, p, qt).call(this);
        }, mustExec: true, type: c2.AnnotationEditorParamsType.INK_OPACITY, overwriteIfSameType: true, keepUndo: true });
      }, tt = /* @__PURE__ */ new WeakSet(), Ne = function() {
        const { width: lt, height: pt, rotation: nt } = this.parent.viewport;
        switch (nt) {
          case 90:
            return [0, lt, lt, pt];
          case 180:
            return [lt, pt, lt, pt];
          case 270:
            return [pt, 0, lt, pt];
          default:
            return [0, 0, lt, pt];
        }
      }, Z = /* @__PURE__ */ new WeakSet(), ge = function() {
        this.ctx.lineWidth = this.thickness * this.parent.scaleFactor / this.scaleFactor, this.ctx.lineCap = "round", this.ctx.lineJoin = "round", this.ctx.miterLimit = 10, this.ctx.strokeStyle = `${this.color}${(0, B2.opacityToHex)(this.opacity)}`;
      }, V = /* @__PURE__ */ new WeakSet(), Be = function(lt, pt) {
        this.isEditing = true, R(this, a) || (mt(this, a, true), ft(this, i, Yt).call(this), this.thickness || (this.thickness = Et._defaultThickness), this.color || (this.color = Et._defaultColor || S2.AnnotationEditor._defaultLineColor), this.opacity ?? (this.opacity = Et._defaultOpacity)), this.currentPath.push([lt, pt]), mt(this, h, null), ft(this, Z, ge).call(this), this.ctx.beginPath(), this.ctx.moveTo(lt, pt), mt(this, e, () => {
          R(this, e) && (R(this, h) && (this.isEmpty() ? (this.ctx.setTransform(1, 0, 0, 1, 0, 0), this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height)) : ft(this, p, qt).call(this), this.ctx.lineTo(...R(this, h)), mt(this, h, null), this.ctx.stroke()), window.requestAnimationFrame(R(this, e)));
        }), window.requestAnimationFrame(R(this, e));
      }, at = /* @__PURE__ */ new WeakSet(), je = function(lt, pt) {
        const [nt, W] = this.currentPath.at(-1);
        lt === nt && pt === W || (this.currentPath.push([lt, pt]), mt(this, h, [lt, pt]));
      }, bt = /* @__PURE__ */ new WeakSet(), Ue = function(lt, pt) {
        var St;
        this.ctx.closePath(), mt(this, e, null), lt = Math.min(Math.max(lt, 0), this.canvas.width), pt = Math.min(Math.max(pt, 0), this.canvas.height);
        const [nt, W] = this.currentPath.at(-1);
        (lt !== nt || pt !== W) && this.currentPath.push([lt, pt]);
        let G;
        if (this.currentPath.length !== 1) G = (0, q2.fitCurve)(this.currentPath, 30, null);
        else {
          const xt = [lt, pt];
          G = [[xt, xt.slice(), xt.slice(), xt]];
        }
        const gt = ft(St = Et, st, _e).call(St, G);
        this.currentPath.length = 0;
        const _t = () => {
          this.paths.push(G), this.bezierPath2D.push(gt), this.rebuild();
        }, At = () => {
          this.paths.pop(), this.bezierPath2D.pop(), this.paths.length === 0 ? this.remove() : (this.canvas || (ft(this, D, ee).call(this), ft(this, Y, ne).call(this)), ft(this, wt, Kt).call(this));
        };
        this.parent.addCommands({ cmd: _t, undo: At, mustExec: true });
      }, p = /* @__PURE__ */ new WeakSet(), qt = function() {
        if (this.isEmpty()) {
          ft(this, x, se).call(this);
          return;
        }
        ft(this, Z, ge).call(this);
        const { canvas: lt, ctx: pt } = this;
        pt.setTransform(1, 0, 0, 1, 0, 0), pt.clearRect(0, 0, lt.width, lt.height), ft(this, x, se).call(this);
        for (const nt of this.bezierPath2D) pt.stroke(nt);
      }, P = /* @__PURE__ */ new WeakSet(), me = function(lt) {
        ft(this, bt, Ue).call(this, lt.offsetX, lt.offsetY), this.canvas.removeEventListener("pointerleave", R(this, C2)), this.canvas.removeEventListener("pointermove", R(this, T2)), this.parent.addToAnnotationStorage(this);
      }, D = /* @__PURE__ */ new WeakSet(), ee = function() {
        this.canvas = document.createElement("canvas"), this.canvas.width = this.canvas.height = 0, this.canvas.className = "inkEditorCanvas", Et._l10nPromise.get("editor_ink_canvas_aria_label").then((lt) => {
          var pt;
          return (pt = this.canvas) == null ? void 0 : pt.setAttribute("aria-label", lt);
        }), this.div.append(this.canvas), this.ctx = this.canvas.getContext("2d");
      }, Y = /* @__PURE__ */ new WeakSet(), ne = function() {
        mt(this, b, new ResizeObserver((lt) => {
          const pt = lt[0].contentRect;
          pt.width && pt.height && this.setDimensions(pt.width, pt.height);
        })), R(this, b).observe(this.div);
      }, i = /* @__PURE__ */ new WeakSet(), Yt = function() {
        if (!R(this, a)) return;
        const [lt, pt] = this.parent.viewportBaseDimensions;
        this.canvas.width = Math.ceil(this.width * lt), this.canvas.height = Math.ceil(this.height * pt), ft(this, x, se).call(this);
      }, g = /* @__PURE__ */ new WeakSet(), be = function(lt, pt) {
        const nt = ft(this, vt, ie).call(this), W = (lt - nt) / R(this, k2), G = (pt - nt) / R(this, w);
        this.scaleFactor = Math.min(W, G);
      }, x = /* @__PURE__ */ new WeakSet(), se = function() {
        const lt = ft(this, vt, ie).call(this) / 2;
        this.ctx.setTransform(this.scaleFactor, 0, 0, this.scaleFactor, this.translationX * this.scaleFactor + lt, this.translationY * this.scaleFactor + lt);
      }, st = /* @__PURE__ */ new WeakSet(), _e = function(lt) {
        const pt = new Path2D();
        for (let nt = 0, W = lt.length; nt < W; nt++) {
          const [G, gt, _t, At] = lt[nt];
          nt === 0 && pt.moveTo(...G), pt.bezierCurveTo(gt[0], gt[1], _t[0], _t[1], At[0], At[1]);
        }
        return pt;
      }, J = /* @__PURE__ */ new WeakSet(), We = function(lt, pt, nt, W) {
        const gt = [], _t = this.thickness / 2;
        let At, St;
        for (const xt of this.paths) {
          At = [], St = [];
          for (let Dt = 0, kt = xt.length; Dt < kt; Dt++) {
            const [Tt, Ot, Lt, jt] = xt[Dt], Pt = lt * (Tt[0] + pt) + _t, Nt = W - lt * (Tt[1] + nt) - _t, Wt = lt * (Ot[0] + pt) + _t, Gt = W - lt * (Ot[1] + nt) - _t, zt = lt * (Lt[0] + pt) + _t, Ht = W - lt * (Lt[1] + nt) - _t, Bt = lt * (jt[0] + pt) + _t, Vt = W - lt * (jt[1] + nt) - _t;
            Dt === 0 && (At.push(Pt, Nt), St.push(Pt, Nt)), At.push(Wt, Gt, zt, Ht, Bt, Vt), ft(this, et, Ve).call(this, Pt, Nt, Wt, Gt, zt, Ht, Bt, Vt, 4, St);
          }
          gt.push({ bezier: At, points: St });
        }
        return gt;
      }, et = /* @__PURE__ */ new WeakSet(), Ve = function(lt, pt, nt, W, G, gt, _t, At, St, xt) {
        if (ft(this, ut, He).call(this, lt, pt, nt, W, G, gt, _t, At)) {
          xt.push(_t, At);
          return;
        }
        for (let Dt = 1; Dt < St - 1; Dt++) {
          const kt = Dt / St, Tt = 1 - kt;
          let Ot = kt * lt + Tt * nt, Lt = kt * pt + Tt * W, jt = kt * nt + Tt * G, Pt = kt * W + Tt * gt;
          const Nt = kt * G + Tt * _t, Wt = kt * gt + Tt * At;
          Ot = kt * Ot + Tt * jt, Lt = kt * Lt + Tt * Pt, jt = kt * jt + Tt * Nt, Pt = kt * Pt + Tt * Wt, Ot = kt * Ot + Tt * jt, Lt = kt * Lt + Tt * Pt, xt.push(Ot, Lt);
        }
        xt.push(_t, At);
      }, ut = /* @__PURE__ */ new WeakSet(), He = function(lt, pt, nt, W, G, gt, _t, At) {
        const xt = (3 * nt - 2 * lt - _t) ** 2, Dt = (3 * W - 2 * pt - At) ** 2, kt = (3 * G - lt - 2 * _t) ** 2, Tt = (3 * gt - pt - 2 * At) ** 2;
        return Math.max(xt, kt) + Math.max(Dt, Tt) <= 10;
      }, ht = /* @__PURE__ */ new WeakSet(), ye = function() {
        let lt = 1 / 0, pt = -1 / 0, nt = 1 / 0, W = -1 / 0;
        for (const G of this.paths) for (const [gt, _t, At, St] of G) {
          const xt = c2.Util.bezierBoundingBox(...gt, ..._t, ...At, ...St);
          lt = Math.min(lt, xt[0]), nt = Math.min(nt, xt[1]), pt = Math.max(pt, xt[2]), W = Math.max(W, xt[3]);
        }
        return [lt, nt, pt, W];
      }, vt = /* @__PURE__ */ new WeakSet(), ie = function() {
        return R(this, s) ? Math.ceil(this.thickness * this.parent.scaleFactor) : 0;
      }, wt = /* @__PURE__ */ new WeakSet(), Kt = function(lt = false) {
        if (this.isEmpty()) return;
        if (!R(this, s)) {
          ft(this, p, qt).call(this);
          return;
        }
        const pt = ft(this, ht, ye).call(this), nt = ft(this, vt, ie).call(this);
        mt(this, k2, Math.max(Q2, pt[2] - pt[0])), mt(this, w, Math.max(Q2, pt[3] - pt[1]));
        const W = Math.ceil(nt + R(this, k2) * this.scaleFactor), G = Math.ceil(nt + R(this, w) * this.scaleFactor), [gt, _t] = this.parent.viewportBaseDimensions;
        this.width = W / gt, this.height = G / _t, mt(this, y2, W / G), ft(this, Rt, Ae).call(this);
        const At = this.translationX, St = this.translationY;
        this.translationX = -pt[0], this.translationY = -pt[1], ft(this, i, Yt).call(this), ft(this, p, qt).call(this), mt(this, r, W), mt(this, n, G), this.setDims(W, G);
        const xt = lt ? nt / this.scaleFactor / 2 : 0;
        this.translate(At - this.translationX - xt, St - this.translationY - xt);
      }, Rt = /* @__PURE__ */ new WeakSet(), Ae = function() {
        const { style: lt } = this.div;
        R(this, y2) >= 1 ? (lt.minHeight = `${Q2}px`, lt.minWidth = `${Math.round(R(this, y2) * Q2)}px`) : (lt.minWidth = `${Q2}px`, lt.minHeight = `${Math.round(Q2 / R(this, y2))}px`);
      }, ct(Et, st), Mt(Et, "_defaultColor", null), Mt(Et, "_defaultOpacity", 1), Mt(Et, "_defaultThickness", 1), Mt(Et, "_l10nPromise"), Mt(Et, "_type", "ink");
      let I2 = Et;
      f2.InkEditor = I2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.fitCurve = void 0;
      const c2 = $2(26);
      f2.fitCurve = c2;
    }, (z2) => {
      function f2(l, t, s) {
        if (!Array.isArray(l)) throw new TypeError("First argument should be an array");
        if (l.forEach((r) => {
          if (!Array.isArray(r) || r.some((n) => typeof n != "number") || r.length !== l[0].length) throw Error("Each point should be an array of numbers. Each point should have the same amount of numbers.");
        }), l = l.filter((r, n) => n === 0 || !r.every((e, o) => e === l[n - 1][o])), l.length < 2) return [];
        const a = l.length, h = k2(l[1], l[0]), b = k2(l[a - 2], l[a - 1]);
        return $2(l, h, b, t, s);
      }
      function $2(l, t, s, a, h) {
        var r, n, e, o, v, m, d, E, U, tt, H, Z, j;
        if (l.length === 2) return Z = T2.vectorLen(T2.subtract(l[0], l[1])) / 3, r = [l[0], T2.addArrays(l[0], T2.mulItems(t, Z)), T2.addArrays(l[1], T2.mulItems(s, Z)), l[1]], [r];
        if (n = Q2(l), [r, o, m] = c2(l, n, n, t, s, h), o === 0 || o < a) return [r];
        if (o < a * a) for (e = n, v = o, d = m, j = 0; j < 20; j++) {
          if (e = q2(r, l, e), [r, o, m] = c2(l, n, e, t, s, h), o < a) return [r];
          if (m === d) {
            let V = o / v;
            if (V > 0.9999 && V < 1.0001) break;
          }
          v = o, d = m;
        }
        return H = [], E = T2.subtract(l[m - 1], l[m + 1]), E.every((V) => V === 0) && (E = T2.subtract(l[m - 1], l[m]), [E[0], E[1]] = [-E[1], E[0]]), U = T2.normalize(E), tt = T2.mulItems(U, -1), H = H.concat($2(l.slice(0, m + 1), t, U, a, h)), H = H.concat($2(l.slice(m), tt, s, a, h)), H;
      }
      function c2(l, t, s, a, h, b) {
        var r, n, e;
        return r = S2(l, s, a, h), [n, e] = I2(l, r, t), b && b({ bez: r, points: l, params: t, maxErr: n, maxPoint: e }), [r, n, e];
      }
      function S2(l, t, s, a) {
        var h, b, r, n, e, o, v, m, d, E, U, tt, H, Z, j, V, X, at = l[0], dt = l[l.length - 1];
        for (h = [at, null, null, dt], b = T2.zeros_Xx2x2(t.length), H = 0, Z = t.length; H < Z; H++) V = t[H], X = 1 - V, r = b[H], r[0] = T2.mulItems(s, 3 * V * (X * X)), r[1] = T2.mulItems(a, 3 * X * (V * V));
        for (n = [[0, 0], [0, 0]], e = [0, 0], H = 0, Z = l.length; H < Z; H++) V = t[H], r = b[H], n[0][0] += T2.dot(r[0], r[0]), n[0][1] += T2.dot(r[0], r[1]), n[1][0] += T2.dot(r[0], r[1]), n[1][1] += T2.dot(r[1], r[1]), j = T2.subtract(l[H], C2.q([at, at, dt, dt], V)), e[0] += T2.dot(r[0], j), e[1] += T2.dot(r[1], j);
        return o = n[0][0] * n[1][1] - n[1][0] * n[0][1], v = n[0][0] * e[1] - n[1][0] * e[0], m = e[0] * n[1][1] - e[1] * n[0][1], d = o === 0 ? 0 : m / o, E = o === 0 ? 0 : v / o, tt = T2.vectorLen(T2.subtract(at, dt)), U = 1e-6 * tt, d < U || E < U ? (h[1] = T2.addArrays(at, T2.mulItems(s, tt / 3)), h[2] = T2.addArrays(dt, T2.mulItems(a, tt / 3))) : (h[1] = T2.addArrays(at, T2.mulItems(s, d)), h[2] = T2.addArrays(dt, T2.mulItems(a, E))), h;
      }
      function q2(l, t, s) {
        return s.map((a, h) => B2(l, t[h], a));
      }
      function B2(l, t, s) {
        var a = T2.subtract(C2.q(l, s), t), h = C2.qprime(l, s), b = T2.mulMatrix(a, h), r = T2.sum(T2.squareItems(h)) + 2 * T2.mulMatrix(a, C2.qprimeprime(l, s));
        return r === 0 ? s : s - b / r;
      }
      function Q2(l) {
        var t = [], s, a, h;
        return l.forEach((b, r) => {
          s = r ? a + T2.vectorLen(T2.subtract(b, h)) : 0, t.push(s), a = s, h = b;
        }), t = t.map((b) => b / a), t;
      }
      function I2(l, t, s) {
        var a, h, b, r, n, e, o, v;
        h = 0, b = Math.floor(l.length / 2);
        const m = y2(t, 10);
        for (n = 0, e = l.length; n < e; n++) o = l[n], v = w(t, s[n], m, 10), r = T2.subtract(C2.q(t, v), o), a = r[0] * r[0] + r[1] * r[1], a > h && (h = a, b = n);
        return [h, b];
      }
      var y2 = function(l, t) {
        for (var s, a = [0], h = l[0], b = 0, r = 1; r <= t; r++) s = C2.q(l, r / t), b += T2.vectorLen(T2.subtract(s, h)), a.push(b), h = s;
        return a = a.map((n) => n / b), a;
      };
      function w(l, t, s, a) {
        if (t < 0) return 0;
        if (t > 1) return 1;
        for (var h, b, r, n, e, o = 1; o <= a; o++) if (t <= s[o]) {
          n = (o - 1) / a, r = o / a, b = s[o - 1], h = s[o], e = (t - b) / (h - b) * (r - n) + n;
          break;
        }
        return e;
      }
      function k2(l, t) {
        return T2.normalize(T2.subtract(l, t));
      }
      class T2 {
        static zeros_Xx2x2(t) {
          for (var s = []; t--; ) s.push([0, 0]);
          return s;
        }
        static mulItems(t, s) {
          return t.map((a) => a * s);
        }
        static mulMatrix(t, s) {
          return t.reduce((a, h, b) => a + h * s[b], 0);
        }
        static subtract(t, s) {
          return t.map((a, h) => a - s[h]);
        }
        static addArrays(t, s) {
          return t.map((a, h) => a + s[h]);
        }
        static addItems(t, s) {
          return t.map((a) => a + s);
        }
        static sum(t) {
          return t.reduce((s, a) => s + a);
        }
        static dot(t, s) {
          return T2.mulMatrix(t, s);
        }
        static vectorLen(t) {
          return Math.hypot(...t);
        }
        static divItems(t, s) {
          return t.map((a) => a / s);
        }
        static squareItems(t) {
          return t.map((s) => s * s);
        }
        static normalize(t) {
          return this.divItems(t, this.vectorLen(t));
        }
      }
      class C2 {
        static q(t, s) {
          var a = 1 - s, h = T2.mulItems(t[0], a * a * a), b = T2.mulItems(t[1], 3 * a * a * s), r = T2.mulItems(t[2], 3 * a * s * s), n = T2.mulItems(t[3], s * s * s);
          return T2.addArrays(T2.addArrays(h, b), T2.addArrays(r, n));
        }
        static qprime(t, s) {
          var a = 1 - s, h = T2.mulItems(T2.subtract(t[1], t[0]), 3 * a * a), b = T2.mulItems(T2.subtract(t[2], t[1]), 6 * a * s), r = T2.mulItems(T2.subtract(t[3], t[2]), 3 * s * s);
          return T2.addArrays(T2.addArrays(h, b), r);
        }
        static qprimeprime(t, s) {
          return T2.addArrays(T2.mulItems(T2.addArrays(T2.subtract(t[2], T2.mulItems(t[1], 2)), t[0]), 6 * (1 - s)), T2.mulItems(T2.addArrays(T2.subtract(t[3], T2.mulItems(t[2], 2)), t[1]), 6 * s));
        }
      }
      z2.exports = f2, z2.exports.fitCubic = $2, z2.exports.createTangent = k2;
    }, (z2, f2, $2) => {
      var p, ve, P, Se, D, Ce;
      Object.defineProperty(f2, "__esModule", { value: true }), f2.AnnotationLayer = void 0;
      var c2 = $2(1), S2 = $2(8), q2 = $2(5), B2 = $2(28), Q2 = $2(29);
      const I2 = 1e3, y2 = 9, w = /* @__PURE__ */ new WeakSet();
      function k2(K) {
        return { width: K[2] - K[0], height: K[3] - K[1] };
      }
      class T2 {
        static create(i) {
          switch (i.data.annotationType) {
            case c2.AnnotationType.LINK:
              return new l(i);
            case c2.AnnotationType.TEXT:
              return new t(i);
            case c2.AnnotationType.WIDGET:
              switch (i.data.fieldType) {
                case "Tx":
                  return new a(i);
                case "Btn":
                  return i.data.radioButton ? new b(i) : i.data.checkBox ? new h(i) : new r(i);
                case "Ch":
                  return new n(i);
              }
              return new s(i);
            case c2.AnnotationType.POPUP:
              return new e(i);
            case c2.AnnotationType.FREETEXT:
              return new v(i);
            case c2.AnnotationType.LINE:
              return new m(i);
            case c2.AnnotationType.SQUARE:
              return new d(i);
            case c2.AnnotationType.CIRCLE:
              return new E(i);
            case c2.AnnotationType.POLYLINE:
              return new U(i);
            case c2.AnnotationType.CARET:
              return new H(i);
            case c2.AnnotationType.INK:
              return new Z(i);
            case c2.AnnotationType.POLYGON:
              return new tt(i);
            case c2.AnnotationType.HIGHLIGHT:
              return new j(i);
            case c2.AnnotationType.UNDERLINE:
              return new V(i);
            case c2.AnnotationType.SQUIGGLY:
              return new X(i);
            case c2.AnnotationType.STRIKEOUT:
              return new at(i);
            case c2.AnnotationType.STAMP:
              return new dt(i);
            case c2.AnnotationType.FILEATTACHMENT:
              return new bt(i);
            default:
              return new C2(i);
          }
        }
      }
      class C2 {
        constructor(i, { isRenderable: _ = false, ignoreBorder: g = false, createQuadrilaterals: A = false } = {}) {
          this.isRenderable = _, this.data = i.data, this.layer = i.layer, this.page = i.page, this.viewport = i.viewport, this.linkService = i.linkService, this.downloadManager = i.downloadManager, this.imageResourcesPath = i.imageResourcesPath, this.renderForms = i.renderForms, this.svgFactory = i.svgFactory, this.annotationStorage = i.annotationStorage, this.enableScripting = i.enableScripting, this.hasJSActions = i.hasJSActions, this._fieldObjects = i.fieldObjects, this._mouseState = i.mouseState, _ && (this.container = this._createContainer(g)), A && (this.quadrilaterals = this._createQuadrilaterals(g));
        }
        _createContainer(i = false) {
          const _ = this.data, g = this.page, A = this.viewport, x = document.createElement("section"), { width: L, height: st } = k2(_.rect), [it, J, rt, et] = A.viewBox, ot = rt - it, ut = et - J;
          x.setAttribute("data-annotation-id", _.id);
          const M = c2.Util.normalizeRect([_.rect[0], g.view[3] - _.rect[1] + g.view[1], _.rect[2], g.view[3] - _.rect[3] + g.view[1]]);
          if (!i && _.borderStyle.width > 0) {
            x.style.borderWidth = `${_.borderStyle.width}px`;
            const yt = _.borderStyle.horizontalCornerRadius, vt = _.borderStyle.verticalCornerRadius;
            if (yt > 0 || vt > 0) {
              const wt = `calc(${yt}px * var(--scale-factor)) / calc(${vt}px * var(--scale-factor))`;
              x.style.borderRadius = wt;
            } else if (this instanceof b) {
              const wt = `calc(${L}px * var(--scale-factor)) / calc(${st}px * var(--scale-factor))`;
              x.style.borderRadius = wt;
            }
            switch (_.borderStyle.style) {
              case c2.AnnotationBorderStyleType.SOLID:
                x.style.borderStyle = "solid";
                break;
              case c2.AnnotationBorderStyleType.DASHED:
                x.style.borderStyle = "dashed";
                break;
              case c2.AnnotationBorderStyleType.BEVELED:
                (0, c2.warn)("Unimplemented border style: beveled");
                break;
              case c2.AnnotationBorderStyleType.INSET:
                (0, c2.warn)("Unimplemented border style: inset");
                break;
              case c2.AnnotationBorderStyleType.UNDERLINE:
                x.style.borderBottomStyle = "solid";
                break;
            }
            const Ct = _.borderColor || null;
            Ct ? x.style.borderColor = c2.Util.makeHexColor(Ct[0] | 0, Ct[1] | 0, Ct[2] | 0) : x.style.borderWidth = 0;
          }
          x.style.left = `${100 * (M[0] - it) / ot}%`, x.style.top = `${100 * (M[1] - J) / ut}%`;
          const { rotation: ht } = _;
          return _.hasOwnCanvas || ht === 0 ? (x.style.width = `${100 * L / ot}%`, x.style.height = `${100 * st / ut}%`) : this.setRotation(ht, x), x;
        }
        setRotation(i, _ = this.container) {
          const [g, A, x, L] = this.viewport.viewBox, st = x - g, it = L - A, { width: J, height: rt } = k2(this.data.rect);
          let et, ot;
          i % 180 === 0 ? (et = 100 * J / st, ot = 100 * rt / it) : (et = 100 * rt / st, ot = 100 * J / it), _.style.width = `${et}%`, _.style.height = `${ot}%`, _.setAttribute("data-main-rotation", (360 - i) % 360);
        }
        get _commonActions() {
          const i = (_, g, A) => {
            const x = A.detail[_];
            A.target.style[g] = B2.ColorConverters[`${x[0]}_HTML`](x.slice(1));
          };
          return (0, c2.shadow)(this, "_commonActions", { display: (_) => {
            const g = _.detail.display % 2 === 1;
            this.container.style.visibility = g ? "hidden" : "visible", this.annotationStorage.setValue(this.data.id, { hidden: g, print: _.detail.display === 0 || _.detail.display === 3 });
          }, print: (_) => {
            this.annotationStorage.setValue(this.data.id, { print: _.detail.print });
          }, hidden: (_) => {
            this.container.style.visibility = _.detail.hidden ? "hidden" : "visible", this.annotationStorage.setValue(this.data.id, { hidden: _.detail.hidden });
          }, focus: (_) => {
            setTimeout(() => _.target.focus({ preventScroll: false }), 0);
          }, userName: (_) => {
            _.target.title = _.detail.userName;
          }, readonly: (_) => {
            _.detail.readonly ? _.target.setAttribute("readonly", "") : _.target.removeAttribute("readonly");
          }, required: (_) => {
            this._setRequired(_.target, _.detail.required);
          }, bgColor: (_) => {
            i("bgColor", "backgroundColor", _);
          }, fillColor: (_) => {
            i("fillColor", "backgroundColor", _);
          }, fgColor: (_) => {
            i("fgColor", "color", _);
          }, textColor: (_) => {
            i("textColor", "color", _);
          }, borderColor: (_) => {
            i("borderColor", "borderColor", _);
          }, strokeColor: (_) => {
            i("strokeColor", "borderColor", _);
          }, rotation: (_) => {
            const g = _.detail.rotation;
            this.setRotation(g), this.annotationStorage.setValue(this.data.id, { rotation: g });
          } });
        }
        _dispatchEventFromSandbox(i, _) {
          const g = this._commonActions;
          for (const A of Object.keys(_.detail)) {
            const x = i[A] || g[A];
            x && x(_);
          }
        }
        _setDefaultPropertiesFromJS(i) {
          if (!this.enableScripting) return;
          const _ = this.annotationStorage.getRawValue(this.data.id);
          if (!_) return;
          const g = this._commonActions;
          for (const [A, x] of Object.entries(_)) {
            const L = g[A];
            if (L) {
              const st = { detail: { [A]: x }, target: i };
              L(st), delete _[A];
            }
          }
        }
        _createQuadrilaterals(i = false) {
          if (!this.data.quadPoints) return null;
          const _ = [], g = this.data.rect;
          for (const A of this.data.quadPoints) this.data.rect = [A[2].x, A[2].y, A[1].x, A[1].y], _.push(this._createContainer(i));
          return this.data.rect = g, _;
        }
        _createPopup(i, _) {
          let g = this.container;
          this.quadrilaterals && (i = i || this.quadrilaterals, g = this.quadrilaterals[0]), i || (i = document.createElement("div"), i.className = "popupTriggerArea", g.append(i));
          const x = new o({ container: g, trigger: i, color: _.color, titleObj: _.titleObj, modificationDate: _.modificationDate, contentsObj: _.contentsObj, richText: _.richText, hideWrapper: true }).render();
          x.style.left = "100%", g.append(x);
        }
        _renderQuadrilaterals(i) {
          for (const _ of this.quadrilaterals) _.className = i;
          return this.quadrilaterals;
        }
        render() {
          (0, c2.unreachable)("Abstract method `AnnotationElement.render` called");
        }
        _getElementsByName(i, _ = null) {
          const g = [];
          if (this._fieldObjects) {
            const A = this._fieldObjects[i];
            if (A) for (const { page: x, id: L, exportValues: st } of A) {
              if (x === -1 || L === _) continue;
              const it = typeof st == "string" ? st : null, J = document.querySelector(`[data-element-id="${L}"]`);
              if (J && !w.has(J)) {
                (0, c2.warn)(`_getElementsByName - element not allowed: ${L}`);
                continue;
              }
              g.push({ id: L, exportValue: it, domElement: J });
            }
            return g;
          }
          for (const A of document.getElementsByName(i)) {
            const { id: x, exportValue: L } = A;
            x !== _ && w.has(A) && g.push({ id: x, exportValue: L, domElement: A });
          }
          return g;
        }
        static get platform() {
          const i = typeof navigator < "u" ? navigator.platform : "";
          return (0, c2.shadow)(this, "platform", { isWin: i.includes("Win"), isMac: i.includes("Mac") });
        }
      }
      class l extends C2 {
        constructor(i, _ = null) {
          super(i, { isRenderable: true, ignoreBorder: !!(_ != null && _.ignoreBorder), createQuadrilaterals: true }), this.isTooltipOnly = i.data.isTooltipOnly;
        }
        render() {
          const { data: i, linkService: _ } = this, g = document.createElement("a");
          g.setAttribute("data-element-id", i.id);
          let A = false;
          return i.url ? (_.addLinkAttributes(g, i.url, i.newWindow), A = true) : i.action ? (this._bindNamedAction(g, i.action), A = true) : i.dest ? (this._bindLink(g, i.dest), A = true) : (i.actions && (i.actions.Action || i.actions["Mouse Up"] || i.actions["Mouse Down"]) && this.enableScripting && this.hasJSActions && (this._bindJSAction(g, i), A = true), i.resetForm ? (this._bindResetFormAction(g, i.resetForm), A = true) : this.isTooltipOnly && !A && (this._bindLink(g, ""), A = true)), this.quadrilaterals ? this._renderQuadrilaterals("linkAnnotation").map((x, L) => {
            const st = L === 0 ? g : g.cloneNode();
            return x.append(st), x;
          }) : (this.container.className = "linkAnnotation", A && this.container.append(g), this.container);
        }
        _bindLink(i, _) {
          i.href = this.linkService.getDestinationHash(_), i.onclick = () => (_ && this.linkService.goToDestination(_), false), (_ || _ === "") && (i.className = "internalLink");
        }
        _bindNamedAction(i, _) {
          i.href = this.linkService.getAnchorUrl(""), i.onclick = () => (this.linkService.executeNamedAction(_), false), i.className = "internalLink";
        }
        _bindJSAction(i, _) {
          i.href = this.linkService.getAnchorUrl("");
          const g = /* @__PURE__ */ new Map([["Action", "onclick"], ["Mouse Up", "onmouseup"], ["Mouse Down", "onmousedown"]]);
          for (const A of Object.keys(_.actions)) {
            const x = g.get(A);
            x && (i[x] = () => {
              var L;
              return (L = this.linkService.eventBus) == null || L.dispatch("dispatcheventinsandbox", { source: this, detail: { id: _.id, name: A } }), false;
            });
          }
          i.onclick || (i.onclick = () => false), i.className = "internalLink";
        }
        _bindResetFormAction(i, _) {
          const g = i.onclick;
          if (g || (i.href = this.linkService.getAnchorUrl("")), i.className = "internalLink", !this._fieldObjects) {
            (0, c2.warn)('_bindResetFormAction - "resetForm" action not supported, ensure that the `fieldObjects` parameter is provided.'), g || (i.onclick = () => false);
            return;
          }
          i.onclick = () => {
            var rt;
            g && g();
            const { fields: A, refs: x, include: L } = _, st = [];
            if (A.length !== 0 || x.length !== 0) {
              const et = new Set(x);
              for (const ot of A) {
                const ut = this._fieldObjects[ot] || [];
                for (const { id: M } of ut) et.add(M);
              }
              for (const ot of Object.values(this._fieldObjects)) for (const ut of ot) et.has(ut.id) === L && st.push(ut);
            } else for (const et of Object.values(this._fieldObjects)) st.push(...et);
            const it = this.annotationStorage, J = [];
            for (const et of st) {
              const { id: ot } = et;
              switch (J.push(ot), et.type) {
                case "text": {
                  const M = et.defaultValue || "";
                  it.setValue(ot, { value: M });
                  break;
                }
                case "checkbox":
                case "radiobutton": {
                  const M = et.defaultValue === et.exportValues;
                  it.setValue(ot, { value: M });
                  break;
                }
                case "combobox":
                case "listbox": {
                  const M = et.defaultValue || "";
                  it.setValue(ot, { value: M });
                  break;
                }
                default:
                  continue;
              }
              const ut = document.querySelector(`[data-element-id="${ot}"]`);
              if (ut) {
                if (!w.has(ut)) {
                  (0, c2.warn)(`_bindResetFormAction - element not allowed: ${ot}`);
                  continue;
                }
              } else continue;
              ut.dispatchEvent(new Event("resetform"));
            }
            return this.enableScripting && ((rt = this.linkService.eventBus) == null || rt.dispatch("dispatcheventinsandbox", { source: this, detail: { id: "app", ids: J, name: "ResetForm" } })), false;
          };
        }
      }
      class t extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _ });
        }
        render() {
          this.container.className = "textAnnotation";
          const i = document.createElement("img");
          return i.src = this.imageResourcesPath + "annotation-" + this.data.name.toLowerCase() + ".svg", i.alt = "[{{type}} Annotation]", i.dataset.l10nId = "text_annotation_type", i.dataset.l10nArgs = JSON.stringify({ type: this.data.name }), this.data.hasPopup || this._createPopup(i, this.data), this.container.append(i), this.container;
        }
      }
      class s extends C2 {
        render() {
          return this.data.alternativeText && (this.container.title = this.data.alternativeText), this.container;
        }
        _getKeyModifier(i) {
          const { isWin: _, isMac: g } = C2.platform;
          return _ && i.ctrlKey || g && i.metaKey;
        }
        _setEventListener(i, _, g, A) {
          _.includes("mouse") ? i.addEventListener(_, (x) => {
            var L;
            (L = this.linkService.eventBus) == null || L.dispatch("dispatcheventinsandbox", { source: this, detail: { id: this.data.id, name: g, value: A(x), shift: x.shiftKey, modifier: this._getKeyModifier(x) } });
          }) : i.addEventListener(_, (x) => {
            var L;
            (L = this.linkService.eventBus) == null || L.dispatch("dispatcheventinsandbox", { source: this, detail: { id: this.data.id, name: g, value: A(x) } });
          });
        }
        _setEventListeners(i, _, g) {
          var A;
          for (const [x, L] of _) (L === "Action" || (A = this.data.actions) != null && A[L]) && this._setEventListener(i, x, L, g);
        }
        _setBackgroundColor(i) {
          const _ = this.data.backgroundColor || null;
          i.style.backgroundColor = _ === null ? "transparent" : c2.Util.makeHexColor(_[0], _[1], _[2]);
        }
        _setTextStyle(i) {
          const _ = ["left", "center", "right"], { fontColor: g } = this.data.defaultAppearanceData, A = this.data.defaultAppearanceData.fontSize || y2, x = i.style;
          let L;
          if (this.data.multiLine) {
            const st = Math.abs(this.data.rect[3] - this.data.rect[1]), it = Math.round(st / (c2.LINE_FACTOR * A)) || 1, J = st / it;
            L = Math.min(A, Math.round(J / c2.LINE_FACTOR));
          } else {
            const st = Math.abs(this.data.rect[3] - this.data.rect[1]);
            L = Math.min(A, Math.round(st / c2.LINE_FACTOR));
          }
          x.fontSize = `calc(${L}px * var(--scale-factor))`, x.color = c2.Util.makeHexColor(g[0], g[1], g[2]), this.data.textAlignment !== null && (x.textAlign = _[this.data.textAlignment]);
        }
        _setRequired(i, _) {
          _ ? i.setAttribute("required", true) : i.removeAttribute("required"), i.setAttribute("aria-required", _);
        }
      }
      class a extends s {
        constructor(i) {
          const _ = i.renderForms || !i.data.hasAppearance && !!i.data.fieldValue;
          super(i, { isRenderable: _ });
        }
        setPropertyOnSiblings(i, _, g, A) {
          const x = this.annotationStorage;
          for (const L of this._getElementsByName(i.name, i.id)) L.domElement && (L.domElement[_] = g), x.setValue(L.id, { [A]: g });
        }
        render() {
          var A;
          const i = this.annotationStorage, _ = this.data.id;
          this.container.className = "textWidgetAnnotation";
          let g = null;
          if (this.renderForms) {
            const x = i.getValue(_, { value: this.data.fieldValue });
            let L = x.formattedValue || x.value || "";
            const st = i.getValue(_, { charLimit: this.data.maxLen }).charLimit;
            st && L.length > st && (L = L.slice(0, st));
            const it = { userValue: L, formattedValue: null, valueOnFocus: "" };
            this.data.multiLine ? (g = document.createElement("textarea"), g.textContent = L, this.data.doNotScroll && (g.style.overflowY = "hidden")) : (g = document.createElement("input"), g.type = "text", g.setAttribute("value", L), this.data.doNotScroll && (g.style.overflowX = "hidden")), w.add(g), g.setAttribute("data-element-id", _), g.disabled = this.data.readOnly, g.name = this.data.fieldName, g.tabIndex = I2, this._setRequired(g, this.data.required), st && (g.maxLength = st), g.addEventListener("input", (rt) => {
              i.setValue(_, { value: rt.target.value }), this.setPropertyOnSiblings(g, "value", rt.target.value, "value");
            }), g.addEventListener("resetform", (rt) => {
              const et = this.data.defaultFieldValue ?? "";
              g.value = it.userValue = et, it.formattedValue = null;
            });
            let J = (rt) => {
              const { formattedValue: et } = it;
              et != null && (rt.target.value = et), rt.target.scrollLeft = 0;
            };
            if (this.enableScripting && this.hasJSActions) {
              g.addEventListener("focus", (et) => {
                it.userValue && (et.target.value = it.userValue), it.valueOnFocus = et.target.value;
              }), g.addEventListener("updatefromsandbox", (et) => {
                const ot = { value(ut) {
                  it.userValue = ut.detail.value ?? "", i.setValue(_, { value: it.userValue.toString() }), ut.target.value = it.userValue;
                }, formattedValue(ut) {
                  const { formattedValue: M } = ut.detail;
                  it.formattedValue = M, M != null && ut.target !== document.activeElement && (ut.target.value = M), i.setValue(_, { formattedValue: M });
                }, selRange(ut) {
                  ut.target.setSelectionRange(...ut.detail.selRange);
                }, charLimit: (ut) => {
                  var vt;
                  const { charLimit: M } = ut.detail, { target: ht } = ut;
                  if (M === 0) {
                    ht.removeAttribute("maxLength");
                    return;
                  }
                  ht.setAttribute("maxLength", M);
                  let yt = it.userValue;
                  !yt || yt.length <= M || (yt = yt.slice(0, M), ht.value = it.userValue = yt, i.setValue(_, { value: yt }), (vt = this.linkService.eventBus) == null || vt.dispatch("dispatcheventinsandbox", { source: this, detail: { id: _, name: "Keystroke", value: yt, willCommit: true, commitKey: 1, selStart: ht.selectionStart, selEnd: ht.selectionEnd } }));
                } };
                this._dispatchEventFromSandbox(ot, et);
              }), g.addEventListener("keydown", (et) => {
                var M;
                let ot = -1;
                if (et.key === "Escape" ? ot = 0 : et.key === "Enter" ? ot = 2 : et.key === "Tab" && (ot = 3), ot === -1) return;
                const { value: ut } = et.target;
                it.valueOnFocus !== ut && (it.userValue = ut, (M = this.linkService.eventBus) == null || M.dispatch("dispatcheventinsandbox", { source: this, detail: { id: _, name: "Keystroke", value: ut, willCommit: true, commitKey: ot, selStart: et.target.selectionStart, selEnd: et.target.selectionEnd } }));
              });
              const rt = J;
              J = null, g.addEventListener("blur", (et) => {
                var ut;
                const { value: ot } = et.target;
                it.userValue = ot, this._mouseState.isDown && it.valueOnFocus !== ot && ((ut = this.linkService.eventBus) == null || ut.dispatch("dispatcheventinsandbox", { source: this, detail: { id: _, name: "Keystroke", value: ot, willCommit: true, commitKey: 1, selStart: et.target.selectionStart, selEnd: et.target.selectionEnd } })), rt(et);
              }), (A = this.data.actions) != null && A.Keystroke && g.addEventListener("beforeinput", (et) => {
                var wt;
                const { data: ot, target: ut } = et, { value: M, selectionStart: ht, selectionEnd: yt } = ut;
                let vt = ht, Ct = yt;
                switch (et.inputType) {
                  case "deleteWordBackward": {
                    const It = M.substring(0, ht).match(/\w*[^\w]*$/);
                    It && (vt -= It[0].length);
                    break;
                  }
                  case "deleteWordForward": {
                    const It = M.substring(ht).match(/^[^\w]*\w*/);
                    It && (Ct += It[0].length);
                    break;
                  }
                  case "deleteContentBackward":
                    ht === yt && (vt -= 1);
                    break;
                  case "deleteContentForward":
                    ht === yt && (Ct += 1);
                    break;
                }
                et.preventDefault(), (wt = this.linkService.eventBus) == null || wt.dispatch("dispatcheventinsandbox", { source: this, detail: { id: _, name: "Keystroke", value: M, change: ot || "", willCommit: false, selStart: vt, selEnd: Ct } });
              }), this._setEventListeners(g, [["focus", "Focus"], ["blur", "Blur"], ["mousedown", "Mouse Down"], ["mouseenter", "Mouse Enter"], ["mouseleave", "Mouse Exit"], ["mouseup", "Mouse Up"]], (et) => et.target.value);
            }
            if (J && g.addEventListener("blur", J), this.data.comb) {
              const et = (this.data.rect[2] - this.data.rect[0]) / st;
              g.classList.add("comb"), g.style.letterSpacing = `calc(${et}px * var(--scale-factor) - 1ch)`;
            }
          } else g = document.createElement("div"), g.textContent = this.data.fieldValue, g.style.verticalAlign = "middle", g.style.display = "table-cell";
          return this._setTextStyle(g), this._setBackgroundColor(g), this._setDefaultPropertiesFromJS(g), this.container.append(g), this.container;
        }
      }
      class h extends s {
        constructor(i) {
          super(i, { isRenderable: i.renderForms });
        }
        render() {
          const i = this.annotationStorage, _ = this.data, g = _.id;
          let A = i.getValue(g, { value: _.exportValue === _.fieldValue }).value;
          typeof A == "string" && (A = A !== "Off", i.setValue(g, { value: A })), this.container.className = "buttonWidgetAnnotation checkBox";
          const x = document.createElement("input");
          return w.add(x), x.setAttribute("data-element-id", g), x.disabled = _.readOnly, this._setRequired(x, this.data.required), x.type = "checkbox", x.name = _.fieldName, A && x.setAttribute("checked", true), x.setAttribute("exportValue", _.exportValue), x.tabIndex = I2, x.addEventListener("change", (L) => {
            const { name: st, checked: it } = L.target;
            for (const J of this._getElementsByName(st, g)) {
              const rt = it && J.exportValue === _.exportValue;
              J.domElement && (J.domElement.checked = rt), i.setValue(J.id, { value: rt });
            }
            i.setValue(g, { value: it });
          }), x.addEventListener("resetform", (L) => {
            const st = _.defaultFieldValue || "Off";
            L.target.checked = st === _.exportValue;
          }), this.enableScripting && this.hasJSActions && (x.addEventListener("updatefromsandbox", (L) => {
            const st = { value(it) {
              it.target.checked = it.detail.value !== "Off", i.setValue(g, { value: it.target.checked });
            } };
            this._dispatchEventFromSandbox(st, L);
          }), this._setEventListeners(x, [["change", "Validate"], ["change", "Action"], ["focus", "Focus"], ["blur", "Blur"], ["mousedown", "Mouse Down"], ["mouseenter", "Mouse Enter"], ["mouseleave", "Mouse Exit"], ["mouseup", "Mouse Up"]], (L) => L.target.checked)), this._setBackgroundColor(x), this._setDefaultPropertiesFromJS(x), this.container.append(x), this.container;
        }
      }
      class b extends s {
        constructor(i) {
          super(i, { isRenderable: i.renderForms });
        }
        render() {
          this.container.className = "buttonWidgetAnnotation radioButton";
          const i = this.annotationStorage, _ = this.data, g = _.id;
          let A = i.getValue(g, { value: _.fieldValue === _.buttonValue }).value;
          typeof A == "string" && (A = A !== _.buttonValue, i.setValue(g, { value: A }));
          const x = document.createElement("input");
          if (w.add(x), x.setAttribute("data-element-id", g), x.disabled = _.readOnly, this._setRequired(x, this.data.required), x.type = "radio", x.name = _.fieldName, A && x.setAttribute("checked", true), x.tabIndex = I2, x.addEventListener("change", (L) => {
            const { name: st, checked: it } = L.target;
            for (const J of this._getElementsByName(st, g)) i.setValue(J.id, { value: false });
            i.setValue(g, { value: it });
          }), x.addEventListener("resetform", (L) => {
            const st = _.defaultFieldValue;
            L.target.checked = st != null && st === _.buttonValue;
          }), this.enableScripting && this.hasJSActions) {
            const L = _.buttonValue;
            x.addEventListener("updatefromsandbox", (st) => {
              const it = { value: (J) => {
                const rt = L === J.detail.value;
                for (const et of this._getElementsByName(J.target.name)) {
                  const ot = rt && et.id === g;
                  et.domElement && (et.domElement.checked = ot), i.setValue(et.id, { value: ot });
                }
              } };
              this._dispatchEventFromSandbox(it, st);
            }), this._setEventListeners(x, [["change", "Validate"], ["change", "Action"], ["focus", "Focus"], ["blur", "Blur"], ["mousedown", "Mouse Down"], ["mouseenter", "Mouse Enter"], ["mouseleave", "Mouse Exit"], ["mouseup", "Mouse Up"]], (st) => st.target.checked);
          }
          return this._setBackgroundColor(x), this._setDefaultPropertiesFromJS(x), this.container.append(x), this.container;
        }
      }
      class r extends l {
        constructor(i) {
          super(i, { ignoreBorder: i.data.hasAppearance });
        }
        render() {
          const i = super.render();
          i.className = "buttonWidgetAnnotation pushButton", this.data.alternativeText && (i.title = this.data.alternativeText);
          const _ = i.lastChild;
          return this.enableScripting && this.hasJSActions && _ && (this._setDefaultPropertiesFromJS(_), _.addEventListener("updatefromsandbox", (g) => {
            this._dispatchEventFromSandbox({}, g);
          })), i;
        }
      }
      class n extends s {
        constructor(i) {
          super(i, { isRenderable: i.renderForms });
        }
        render() {
          this.container.className = "choiceWidgetAnnotation";
          const i = this.annotationStorage, _ = this.data.id, g = i.getValue(_, { value: this.data.fieldValue }), A = document.createElement("select");
          w.add(A), A.setAttribute("data-element-id", _), A.disabled = this.data.readOnly, this._setRequired(A, this.data.required), A.name = this.data.fieldName, A.tabIndex = I2;
          let x = this.data.combo && this.data.options.length > 0;
          this.data.combo || (A.size = this.data.options.length, this.data.multiSelect && (A.multiple = true)), A.addEventListener("resetform", (J) => {
            const rt = this.data.defaultFieldValue;
            for (const et of A.options) et.selected = et.value === rt;
          });
          for (const J of this.data.options) {
            const rt = document.createElement("option");
            rt.textContent = J.displayValue, rt.value = J.exportValue, g.value.includes(J.exportValue) && (rt.setAttribute("selected", true), x = false), A.append(rt);
          }
          let L = null;
          if (x) {
            const J = document.createElement("option");
            J.value = " ", J.setAttribute("hidden", true), J.setAttribute("selected", true), A.prepend(J), L = () => {
              J.remove(), A.removeEventListener("input", L), L = null;
            }, A.addEventListener("input", L);
          }
          const st = (J, rt) => {
            const et = rt ? "value" : "textContent", ot = J.target.options;
            return J.target.multiple ? Array.prototype.filter.call(ot, (ut) => ut.selected).map((ut) => ut[et]) : ot.selectedIndex === -1 ? null : ot[ot.selectedIndex][et];
          }, it = (J) => {
            const rt = J.target.options;
            return Array.prototype.map.call(rt, (et) => ({ displayValue: et.textContent, exportValue: et.value }));
          };
          return this.enableScripting && this.hasJSActions ? (A.addEventListener("updatefromsandbox", (J) => {
            const rt = { value(et) {
              L == null || L();
              const ot = et.detail.value, ut = new Set(Array.isArray(ot) ? ot : [ot]);
              for (const M of A.options) M.selected = ut.has(M.value);
              i.setValue(_, { value: st(et, true) });
            }, multipleSelection(et) {
              A.multiple = true;
            }, remove(et) {
              const ot = A.options, ut = et.detail.remove;
              ot[ut].selected = false, A.remove(ut), ot.length > 0 && Array.prototype.findIndex.call(ot, (ht) => ht.selected) === -1 && (ot[0].selected = true), i.setValue(_, { value: st(et, true), items: it(et) });
            }, clear(et) {
              for (; A.length !== 0; ) A.remove(0);
              i.setValue(_, { value: null, items: [] });
            }, insert(et) {
              const { index: ot, displayValue: ut, exportValue: M } = et.detail.insert, ht = A.children[ot], yt = document.createElement("option");
              yt.textContent = ut, yt.value = M, ht ? ht.before(yt) : A.append(yt), i.setValue(_, { value: st(et, true), items: it(et) });
            }, items(et) {
              const { items: ot } = et.detail;
              for (; A.length !== 0; ) A.remove(0);
              for (const ut of ot) {
                const { displayValue: M, exportValue: ht } = ut, yt = document.createElement("option");
                yt.textContent = M, yt.value = ht, A.append(yt);
              }
              A.options.length > 0 && (A.options[0].selected = true), i.setValue(_, { value: st(et, true), items: it(et) });
            }, indices(et) {
              const ot = new Set(et.detail.indices);
              for (const ut of et.target.options) ut.selected = ot.has(ut.index);
              i.setValue(_, { value: st(et, true) });
            }, editable(et) {
              et.target.disabled = !et.detail.editable;
            } };
            this._dispatchEventFromSandbox(rt, J);
          }), A.addEventListener("input", (J) => {
            var ot;
            const rt = st(J, true), et = st(J, false);
            i.setValue(_, { value: rt }), (ot = this.linkService.eventBus) == null || ot.dispatch("dispatcheventinsandbox", { source: this, detail: { id: _, name: "Keystroke", value: et, changeEx: rt, willCommit: true, commitKey: 1, keyDown: false } });
          }), this._setEventListeners(A, [["focus", "Focus"], ["blur", "Blur"], ["mousedown", "Mouse Down"], ["mouseenter", "Mouse Enter"], ["mouseleave", "Mouse Exit"], ["mouseup", "Mouse Up"], ["input", "Action"]], (J) => J.target.checked)) : A.addEventListener("input", function(J) {
            i.setValue(_, { value: st(J, true) });
          }), this.data.combo && this._setTextStyle(A), this._setBackgroundColor(A), this._setDefaultPropertiesFromJS(A), this.container.append(A), this.container;
        }
      }
      class e extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!((g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _ });
        }
        render() {
          const i = ["Line", "Square", "Circle", "PolyLine", "Polygon", "Ink"];
          if (this.container.className = "popupAnnotation", i.includes(this.data.parentType)) return this.container;
          const _ = `[data-annotation-id="${this.data.parentId}"]`, g = this.layer.querySelectorAll(_);
          if (g.length === 0) return this.container;
          const A = new o({ container: this.container, trigger: Array.from(g), color: this.data.color, titleObj: this.data.titleObj, modificationDate: this.data.modificationDate, contentsObj: this.data.contentsObj, richText: this.data.richText }), x = this.page, L = c2.Util.normalizeRect([this.data.parentRect[0], x.view[3] - this.data.parentRect[1] + x.view[1], this.data.parentRect[2], x.view[3] - this.data.parentRect[3] + x.view[1]]), st = L[0] + this.data.parentRect[2] - this.data.parentRect[0], it = L[1], [J, rt, et, ot] = this.viewport.viewBox, ut = et - J, M = ot - rt;
          return this.container.style.left = `${100 * (st - J) / ut}%`, this.container.style.top = `${100 * (it - rt) / M}%`, this.container.append(A.render()), this.container;
        }
      }
      class o {
        constructor(i) {
          this.container = i.container, this.trigger = i.trigger, this.color = i.color, this.titleObj = i.titleObj, this.modificationDate = i.modificationDate, this.contentsObj = i.contentsObj, this.richText = i.richText, this.hideWrapper = i.hideWrapper || false, this.pinned = false;
        }
        render() {
          var st, it;
          const _ = document.createElement("div");
          _.className = "popupWrapper", this.hideElement = this.hideWrapper ? _ : this.container, this.hideElement.hidden = true;
          const g = document.createElement("div");
          g.className = "popup";
          const A = this.color;
          if (A) {
            const J = 0.7 * (255 - A[0]) + A[0], rt = 0.7 * (255 - A[1]) + A[1], et = 0.7 * (255 - A[2]) + A[2];
            g.style.backgroundColor = c2.Util.makeHexColor(J | 0, rt | 0, et | 0);
          }
          const x = document.createElement("h1");
          x.dir = this.titleObj.dir, x.textContent = this.titleObj.str, g.append(x);
          const L = S2.PDFDateString.toDateObject(this.modificationDate);
          if (L) {
            const J = document.createElement("span");
            J.className = "popupDate", J.textContent = "{{date}}, {{time}}", J.dataset.l10nId = "annotation_date_string", J.dataset.l10nArgs = JSON.stringify({ date: L.toLocaleDateString(), time: L.toLocaleTimeString() }), g.append(J);
          }
          if ((st = this.richText) != null && st.str && (!((it = this.contentsObj) != null && it.str) || this.contentsObj.str === this.richText.str)) Q2.XfaLayer.render({ xfaHtml: this.richText.html, intent: "richText", div: g }), g.lastChild.className = "richText popupContent";
          else {
            const J = this._formatContents(this.contentsObj);
            g.append(J);
          }
          Array.isArray(this.trigger) || (this.trigger = [this.trigger]);
          for (const J of this.trigger) J.addEventListener("click", this._toggle.bind(this)), J.addEventListener("mouseover", this._show.bind(this, false)), J.addEventListener("mouseout", this._hide.bind(this, false));
          return g.addEventListener("click", this._hide.bind(this, true)), _.append(g), _;
        }
        _formatContents({ str: i, dir: _ }) {
          const g = document.createElement("p");
          g.className = "popupContent", g.dir = _;
          const A = i.split(/(?:\r\n?|\n)/);
          for (let x = 0, L = A.length; x < L; ++x) {
            const st = A[x];
            g.append(document.createTextNode(st)), x < L - 1 && g.append(document.createElement("br"));
          }
          return g;
        }
        _toggle() {
          this.pinned ? this._hide(true) : this._show(true);
        }
        _show(i = false) {
          i && (this.pinned = true), this.hideElement.hidden && (this.hideElement.hidden = false, this.container.style.zIndex = parseInt(this.container.style.zIndex) + 1e3);
        }
        _hide(i = true) {
          i && (this.pinned = false), !this.hideElement.hidden && !this.pinned && (this.hideElement.hidden = true, this.container.style.zIndex = parseInt(this.container.style.zIndex) - 1e3);
        }
      }
      class v extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true }), this.textContent = i.data.textContent;
        }
        render() {
          if (this.container.className = "freeTextAnnotation", this.textContent) {
            const i = document.createElement("div");
            i.className = "annotationTextContent", i.setAttribute("role", "comment");
            for (const _ of this.textContent) {
              const g = document.createElement("span");
              g.textContent = _, i.append(g);
            }
            this.container.append(i);
          }
          return this.data.hasPopup || this._createPopup(null, this.data), this.container;
        }
      }
      class m extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true });
        }
        render() {
          this.container.className = "lineAnnotation";
          const i = this.data, { width: _, height: g } = k2(i.rect), A = this.svgFactory.create(_, g, true), x = this.svgFactory.createElement("svg:line");
          return x.setAttribute("x1", i.rect[2] - i.lineCoordinates[0]), x.setAttribute("y1", i.rect[3] - i.lineCoordinates[1]), x.setAttribute("x2", i.rect[2] - i.lineCoordinates[2]), x.setAttribute("y2", i.rect[3] - i.lineCoordinates[3]), x.setAttribute("stroke-width", i.borderStyle.width || 1), x.setAttribute("stroke", "transparent"), x.setAttribute("fill", "transparent"), A.append(x), this.container.append(A), this._createPopup(x, i), this.container;
        }
      }
      class d extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true });
        }
        render() {
          this.container.className = "squareAnnotation";
          const i = this.data, { width: _, height: g } = k2(i.rect), A = this.svgFactory.create(_, g, true), x = i.borderStyle.width, L = this.svgFactory.createElement("svg:rect");
          return L.setAttribute("x", x / 2), L.setAttribute("y", x / 2), L.setAttribute("width", _ - x), L.setAttribute("height", g - x), L.setAttribute("stroke-width", x || 1), L.setAttribute("stroke", "transparent"), L.setAttribute("fill", "transparent"), A.append(L), this.container.append(A), this._createPopup(L, i), this.container;
        }
      }
      class E extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true });
        }
        render() {
          this.container.className = "circleAnnotation";
          const i = this.data, { width: _, height: g } = k2(i.rect), A = this.svgFactory.create(_, g, true), x = i.borderStyle.width, L = this.svgFactory.createElement("svg:ellipse");
          return L.setAttribute("cx", _ / 2), L.setAttribute("cy", g / 2), L.setAttribute("rx", _ / 2 - x / 2), L.setAttribute("ry", g / 2 - x / 2), L.setAttribute("stroke-width", x || 1), L.setAttribute("stroke", "transparent"), L.setAttribute("fill", "transparent"), A.append(L), this.container.append(A), this._createPopup(L, i), this.container;
        }
      }
      class U extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true }), this.containerClassName = "polylineAnnotation", this.svgElementName = "svg:polyline";
        }
        render() {
          this.container.className = this.containerClassName;
          const i = this.data, { width: _, height: g } = k2(i.rect), A = this.svgFactory.create(_, g, true);
          let x = [];
          for (const st of i.vertices) {
            const it = st.x - i.rect[0], J = i.rect[3] - st.y;
            x.push(it + "," + J);
          }
          x = x.join(" ");
          const L = this.svgFactory.createElement(this.svgElementName);
          return L.setAttribute("points", x), L.setAttribute("stroke-width", i.borderStyle.width || 1), L.setAttribute("stroke", "transparent"), L.setAttribute("fill", "transparent"), A.append(L), this.container.append(A), this._createPopup(L, i), this.container;
        }
      }
      class tt extends U {
        constructor(i) {
          super(i), this.containerClassName = "polygonAnnotation", this.svgElementName = "svg:polygon";
        }
      }
      class H extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true });
        }
        render() {
          return this.container.className = "caretAnnotation", this.data.hasPopup || this._createPopup(null, this.data), this.container;
        }
      }
      class Z extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true }), this.containerClassName = "inkAnnotation", this.svgElementName = "svg:polyline";
        }
        render() {
          this.container.className = this.containerClassName;
          const i = this.data, { width: _, height: g } = k2(i.rect), A = this.svgFactory.create(_, g, true);
          for (const x of i.inkLists) {
            let L = [];
            for (const it of x) {
              const J = it.x - i.rect[0], rt = i.rect[3] - it.y;
              L.push(`${J},${rt}`);
            }
            L = L.join(" ");
            const st = this.svgFactory.createElement(this.svgElementName);
            st.setAttribute("points", L), st.setAttribute("stroke-width", i.borderStyle.width || 1), st.setAttribute("stroke", "transparent"), st.setAttribute("fill", "transparent"), this._createPopup(st, i), A.append(st);
          }
          return this.container.append(A), this.container;
        }
      }
      class j extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true, createQuadrilaterals: true });
        }
        render() {
          return this.data.hasPopup || this._createPopup(null, this.data), this.quadrilaterals ? this._renderQuadrilaterals("highlightAnnotation") : (this.container.className = "highlightAnnotation", this.container);
        }
      }
      class V extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true, createQuadrilaterals: true });
        }
        render() {
          return this.data.hasPopup || this._createPopup(null, this.data), this.quadrilaterals ? this._renderQuadrilaterals("underlineAnnotation") : (this.container.className = "underlineAnnotation", this.container);
        }
      }
      class X extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true, createQuadrilaterals: true });
        }
        render() {
          return this.data.hasPopup || this._createPopup(null, this.data), this.quadrilaterals ? this._renderQuadrilaterals("squigglyAnnotation") : (this.container.className = "squigglyAnnotation", this.container);
        }
      }
      class at extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true, createQuadrilaterals: true });
        }
        render() {
          return this.data.hasPopup || this._createPopup(null, this.data), this.quadrilaterals ? this._renderQuadrilaterals("strikeoutAnnotation") : (this.container.className = "strikeoutAnnotation", this.container);
        }
      }
      class dt extends C2 {
        constructor(i) {
          var g, A, x;
          const _ = !!(i.data.hasPopup || (g = i.data.titleObj) != null && g.str || (A = i.data.contentsObj) != null && A.str || (x = i.data.richText) != null && x.str);
          super(i, { isRenderable: _, ignoreBorder: true });
        }
        render() {
          return this.container.className = "stampAnnotation", this.data.hasPopup || this._createPopup(null, this.data), this.container;
        }
      }
      class bt extends C2 {
        constructor(i) {
          var A;
          super(i, { isRenderable: true });
          const { filename: _, content: g } = this.data.file;
          this.filename = (0, S2.getFilenameFromUrl)(_), this.content = g, (A = this.linkService.eventBus) == null || A.dispatch("fileattachmentannotation", { source: this, filename: _, content: g });
        }
        render() {
          var _, g;
          this.container.className = "fileAttachmentAnnotation";
          const i = document.createElement("div");
          return i.className = "popupTriggerArea", i.addEventListener("dblclick", this._download.bind(this)), !this.data.hasPopup && ((_ = this.data.titleObj) != null && _.str || (g = this.data.contentsObj) != null && g.str || this.data.richText) && this._createPopup(i, this.data), this.container.append(i), this.container;
        }
        _download() {
          var i;
          (i = this.downloadManager) == null || i.openOrDownloadData(this.container, this.content, this.filename);
        }
      }
      const Y = class Y2 {
        static render(i) {
          var st, it;
          const { annotations: _, div: g, viewport: A, accessibilityManager: x } = i;
          ft(this, P, Se).call(this, g, A);
          let L = 0;
          for (const J of _) {
            if (J.annotationType !== c2.AnnotationType.POPUP) {
              const { width: et, height: ot } = k2(J.rect);
              if (et <= 0 || ot <= 0) continue;
            }
            const rt = T2.create({ data: J, layer: g, page: i.page, viewport: A, linkService: i.linkService, downloadManager: i.downloadManager, imageResourcesPath: i.imageResourcesPath || "", renderForms: i.renderForms !== false, svgFactory: new S2.DOMSVGFactory(), annotationStorage: i.annotationStorage || new q2.AnnotationStorage(), enableScripting: i.enableScripting, hasJSActions: i.hasJSActions, fieldObjects: i.fieldObjects, mouseState: i.mouseState || { isDown: false } });
            if (rt.isRenderable) {
              const et = rt.render();
              if (J.hidden && (et.style.visibility = "hidden"), Array.isArray(et)) for (const ot of et) ot.style.zIndex = L++, ft(st = Y2, p, ve).call(st, ot, J.id, g, x);
              else et.style.zIndex = L++, rt instanceof e ? g.prepend(et) : ft(it = Y2, p, ve).call(it, et, J.id, g, x);
            }
          }
          ft(this, D, Ce).call(this, g, i.annotationCanvasMap);
        }
        static update(i) {
          const { annotationCanvasMap: _, div: g, viewport: A } = i;
          ft(this, P, Se).call(this, g, A), ft(this, D, Ce).call(this, g, _), g.hidden = false;
        }
      };
      p = /* @__PURE__ */ new WeakSet(), ve = function(i, _, g, A) {
        const x = i.firstChild || i;
        x.id = `${S2.AnnotationPrefix}${_}`, g.append(i), A == null || A.moveElementInDOM(g, i, x, false);
      }, P = /* @__PURE__ */ new WeakSet(), Se = function(i, { width: _, height: g, rotation: A }) {
        const { style: x } = i, L = A % 180 !== 0, st = Math.floor(_) + "px", it = Math.floor(g) + "px";
        x.width = L ? it : st, x.height = L ? st : it, i.setAttribute("data-main-rotation", A);
      }, D = /* @__PURE__ */ new WeakSet(), Ce = function(i, _) {
        if (_) {
          for (const [g, A] of _) {
            const x = i.querySelector(`[data-annotation-id="${g}"]`);
            if (!x) continue;
            const { firstChild: L } = x;
            L ? L.nodeName === "CANVAS" ? L.replaceWith(A) : L.before(A) : x.append(A);
          }
          _.clear();
        }
      }, ct(Y, p), ct(Y, P), ct(Y, D);
      let N = Y;
      f2.AnnotationLayer = N;
    }, (z2, f2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.ColorConverters = void 0;
      function $2(S2) {
        return Math.floor(Math.max(0, Math.min(1, S2)) * 255).toString(16).padStart(2, "0");
      }
      class c2 {
        static CMYK_G([q2, B2, Q2, I2]) {
          return ["G", 1 - Math.min(1, 0.3 * q2 + 0.59 * Q2 + 0.11 * B2 + I2)];
        }
        static G_CMYK([q2]) {
          return ["CMYK", 0, 0, 0, 1 - q2];
        }
        static G_RGB([q2]) {
          return ["RGB", q2, q2, q2];
        }
        static G_HTML([q2]) {
          const B2 = $2(q2);
          return `#${B2}${B2}${B2}`;
        }
        static RGB_G([q2, B2, Q2]) {
          return ["G", 0.3 * q2 + 0.59 * B2 + 0.11 * Q2];
        }
        static RGB_HTML([q2, B2, Q2]) {
          const I2 = $2(q2), y2 = $2(B2), w = $2(Q2);
          return `#${I2}${y2}${w}`;
        }
        static T_HTML() {
          return "#00000000";
        }
        static CMYK_RGB([q2, B2, Q2, I2]) {
          return ["RGB", 1 - Math.min(1, q2 + I2), 1 - Math.min(1, Q2 + I2), 1 - Math.min(1, B2 + I2)];
        }
        static CMYK_HTML(q2) {
          const B2 = this.CMYK_RGB(q2).slice(1);
          return this.RGB_HTML(B2);
        }
        static RGB_CMYK([q2, B2, Q2]) {
          const I2 = 1 - q2, y2 = 1 - B2, w = 1 - Q2, k2 = Math.min(I2, y2, w);
          return ["CMYK", I2, y2, w, k2];
        }
      }
      f2.ColorConverters = c2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.XfaLayer = void 0;
      var c2 = $2(20);
      class S2 {
        static setupStorage(B2, Q2, I2, y2, w) {
          const k2 = y2.getValue(Q2, { value: null });
          switch (I2.name) {
            case "textarea":
              if (k2.value !== null && (B2.textContent = k2.value), w === "print") break;
              B2.addEventListener("input", (T2) => {
                y2.setValue(Q2, { value: T2.target.value });
              });
              break;
            case "input":
              if (I2.attributes.type === "radio" || I2.attributes.type === "checkbox") {
                if (k2.value === I2.attributes.xfaOn ? B2.setAttribute("checked", true) : k2.value === I2.attributes.xfaOff && B2.removeAttribute("checked"), w === "print") break;
                B2.addEventListener("change", (T2) => {
                  y2.setValue(Q2, { value: T2.target.checked ? T2.target.getAttribute("xfaOn") : T2.target.getAttribute("xfaOff") });
                });
              } else {
                if (k2.value !== null && B2.setAttribute("value", k2.value), w === "print") break;
                B2.addEventListener("input", (T2) => {
                  y2.setValue(Q2, { value: T2.target.value });
                });
              }
              break;
            case "select":
              if (k2.value !== null) for (const T2 of I2.children) T2.attributes.value === k2.value && (T2.attributes.selected = true);
              B2.addEventListener("input", (T2) => {
                const C2 = T2.target.options, l = C2.selectedIndex === -1 ? "" : C2[C2.selectedIndex].value;
                y2.setValue(Q2, { value: l });
              });
              break;
          }
        }
        static setAttributes({ html: B2, element: Q2, storage: I2 = null, intent: y2, linkService: w }) {
          const { attributes: k2 } = Q2, T2 = B2 instanceof HTMLAnchorElement;
          k2.type === "radio" && (k2.name = `${k2.name}-${y2}`);
          for (const [C2, l] of Object.entries(k2)) if (l != null) switch (C2) {
            case "class":
              l.length && B2.setAttribute(C2, l.join(" "));
              break;
            case "dataId":
              break;
            case "id":
              B2.setAttribute("data-element-id", l);
              break;
            case "style":
              Object.assign(B2.style, l);
              break;
            case "textContent":
              B2.textContent = l;
              break;
            default:
              (!T2 || C2 !== "href" && C2 !== "newWindow") && B2.setAttribute(C2, l);
          }
          T2 && w.addLinkAttributes(B2, k2.href, k2.newWindow), I2 && k2.dataId && this.setupStorage(B2, k2.dataId, Q2, I2);
        }
        static render(B2) {
          var t;
          const Q2 = B2.annotationStorage, I2 = B2.linkService, y2 = B2.xfaHtml, w = B2.intent || "display", k2 = document.createElement(y2.name);
          y2.attributes && this.setAttributes({ html: k2, element: y2, intent: w, linkService: I2 });
          const T2 = [[y2, -1, k2]], C2 = B2.div;
          if (C2.append(k2), B2.viewport) {
            const s = `matrix(${B2.viewport.transform.join(",")})`;
            C2.style.transform = s;
          }
          w !== "richText" && C2.setAttribute("class", "xfaLayer xfaFont");
          const l = [];
          for (; T2.length > 0; ) {
            const [s, a, h] = T2.at(-1);
            if (a + 1 === s.children.length) {
              T2.pop();
              continue;
            }
            const b = s.children[++T2.at(-1)[1]];
            if (b === null) continue;
            const { name: r } = b;
            if (r === "#text") {
              const e = document.createTextNode(b.value);
              l.push(e), h.append(e);
              continue;
            }
            let n;
            if ((t = b == null ? void 0 : b.attributes) != null && t.xmlns ? n = document.createElementNS(b.attributes.xmlns, r) : n = document.createElement(r), h.append(n), b.attributes && this.setAttributes({ html: n, element: b, storage: Q2, intent: w, linkService: I2 }), b.children && b.children.length > 0) T2.push([b, -1, n]);
            else if (b.value) {
              const e = document.createTextNode(b.value);
              c2.XfaText.shouldBuildText(r) && l.push(e), n.append(e);
            }
          }
          for (const s of C2.querySelectorAll(".xfaNonInteractive input, .xfaNonInteractive textarea")) s.setAttribute("readOnly", true);
          return { textDivs: l };
        }
        static update(B2) {
          const Q2 = `matrix(${B2.viewport.transform.join(",")})`;
          B2.div.style.transform = Q2, B2.div.hidden = false;
        }
      }
      f2.XfaLayer = S2;
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.TextLayerRenderTask = void 0, f2.renderTextLayer = h;
      var c2 = $2(1), S2 = $2(8);
      const q2 = 1e5, B2 = 30, Q2 = 0.8, I2 = /* @__PURE__ */ new Map(), y2 = /^\s+$/g;
      function w(b, r) {
        const n = I2.get(b);
        if (n) return n;
        r.save(), r.font = `${B2}px ${b}`;
        const e = r.measureText("");
        let o = e.fontBoundingBoxAscent, v = Math.abs(e.fontBoundingBoxDescent);
        if (o) {
          r.restore();
          const d = o / (o + v);
          return I2.set(b, d), d;
        }
        r.strokeStyle = "red", r.clearRect(0, 0, B2, B2), r.strokeText("g", 0, 0);
        let m = r.getImageData(0, 0, B2, B2).data;
        v = 0;
        for (let d = m.length - 1 - 3; d >= 0; d -= 4) if (m[d] > 0) {
          v = Math.ceil(d / 4 / B2);
          break;
        }
        r.clearRect(0, 0, B2, B2), r.strokeText("A", 0, B2), m = r.getImageData(0, 0, B2, B2).data, o = 0;
        for (let d = 0, E = m.length; d < E; d += 4) if (m[d] > 0) {
          o = B2 - Math.floor(d / 4 / B2);
          break;
        }
        if (r.restore(), o) {
          const d = o / (o + v);
          return I2.set(b, d), d;
        }
        return I2.set(b, Q2), Q2;
      }
      function k2(b, r, n, e) {
        const o = document.createElement("span"), v = b._enhanceTextSelection ? { angle: 0, canvasWidth: 0, hasText: r.str !== "", hasEOL: r.hasEOL, originalTransform: null, paddingBottom: 0, paddingLeft: 0, paddingRight: 0, paddingTop: 0, scale: 1, fontSize: 0 } : { angle: 0, canvasWidth: 0, hasText: r.str !== "", hasEOL: r.hasEOL, fontSize: 0 };
        b._textDivs.push(o);
        const m = c2.Util.transform(b._viewport.transform, r.transform);
        let d = Math.atan2(m[1], m[0]);
        const E = n[r.fontName];
        E.vertical && (d += Math.PI / 2);
        const U = Math.hypot(m[2], m[3]), tt = U * w(E.fontFamily, e);
        let H, Z;
        d === 0 ? (H = m[4], Z = m[5] - tt) : (H = m[4] + tt * Math.sin(d), Z = m[5] - tt * Math.cos(d)), o.style.left = `${H}px`, o.style.top = `${Z}px`, o.style.fontSize = `${U}px`, o.style.fontFamily = E.fontFamily, v.fontSize = U, o.setAttribute("role", "presentation"), o.textContent = r.str, o.dir = r.dir, b._fontInspectorEnabled && (o.dataset.fontName = r.fontName), d !== 0 && (v.angle = d * (180 / Math.PI));
        let j = false;
        if (r.str.length > 1 || b._enhanceTextSelection && y2.test(r.str)) j = true;
        else if (r.str !== " " && r.transform[0] !== r.transform[3]) {
          const V = Math.abs(r.transform[0]), X = Math.abs(r.transform[3]);
          V !== X && Math.max(V, X) / Math.min(V, X) > 1.5 && (j = true);
        }
        if (j && (E.vertical ? v.canvasWidth = r.height * b._viewport.scale : v.canvasWidth = r.width * b._viewport.scale), b._textDivProperties.set(o, v), b._textContentStream && b._layoutText(o), b._enhanceTextSelection && v.hasText) {
          let V = 1, X = 0;
          d !== 0 && (V = Math.cos(d), X = Math.sin(d));
          const at = (E.vertical ? r.height : r.width) * b._viewport.scale, dt = U;
          let bt, N;
          d !== 0 ? (bt = [V, X, -X, V, H, Z], N = c2.Util.getAxialAlignedBoundingBox([0, 0, at, dt], bt)) : N = [H, Z, H + at, Z + dt], b._bounds.push({ left: N[0], top: N[1], right: N[2], bottom: N[3], div: o, size: [at, dt], m: bt });
        }
      }
      function T2(b) {
        if (b._canceled) return;
        const r = b._textDivs, n = b._capability, e = r.length;
        if (e > q2) {
          b._renderingDone = true, n.resolve();
          return;
        }
        if (!b._textContentStream) for (let o = 0; o < e; o++) b._layoutText(r[o]);
        b._renderingDone = true, n.resolve();
      }
      function C2(b, r, n) {
        let e = 0;
        for (let o = 0; o < n; o++) {
          const v = b[r++];
          v > 0 && (e = e ? Math.min(v, e) : v);
        }
        return e;
      }
      function l(b) {
        const r = b._bounds, n = b._viewport, e = t(n.width, n.height, r);
        for (let o = 0; o < e.length; o++) {
          const v = r[o].div, m = b._textDivProperties.get(v);
          if (m.angle === 0) {
            m.paddingLeft = r[o].left - e[o].left, m.paddingTop = r[o].top - e[o].top, m.paddingRight = e[o].right - r[o].right, m.paddingBottom = e[o].bottom - r[o].bottom, b._textDivProperties.set(v, m);
            continue;
          }
          const d = e[o], E = r[o], U = E.m, tt = U[0], H = U[1], Z = [[0, 0], [0, E.size[1]], [E.size[0], 0], E.size], j = new Float64Array(64);
          for (let X = 0, at = Z.length; X < at; X++) {
            const dt = c2.Util.applyTransform(Z[X], U);
            j[X + 0] = tt && (d.left - dt[0]) / tt, j[X + 4] = H && (d.top - dt[1]) / H, j[X + 8] = tt && (d.right - dt[0]) / tt, j[X + 12] = H && (d.bottom - dt[1]) / H, j[X + 16] = H && (d.left - dt[0]) / -H, j[X + 20] = tt && (d.top - dt[1]) / tt, j[X + 24] = H && (d.right - dt[0]) / -H, j[X + 28] = tt && (d.bottom - dt[1]) / tt, j[X + 32] = tt && (d.left - dt[0]) / -tt, j[X + 36] = H && (d.top - dt[1]) / -H, j[X + 40] = tt && (d.right - dt[0]) / -tt, j[X + 44] = H && (d.bottom - dt[1]) / -H, j[X + 48] = H && (d.left - dt[0]) / H, j[X + 52] = tt && (d.top - dt[1]) / -tt, j[X + 56] = H && (d.right - dt[0]) / H, j[X + 60] = tt && (d.bottom - dt[1]) / -tt;
          }
          const V = 1 + Math.min(Math.abs(tt), Math.abs(H));
          m.paddingLeft = C2(j, 32, 16) / V, m.paddingTop = C2(j, 48, 16) / V, m.paddingRight = C2(j, 0, 16) / V, m.paddingBottom = C2(j, 16, 16) / V, b._textDivProperties.set(v, m);
        }
      }
      function t(b, r, n) {
        const e = n.map(function(v, m) {
          return { x1: v.left, y1: v.top, x2: v.right, y2: v.bottom, index: m, x1New: void 0, x2New: void 0 };
        });
        s(b, e);
        const o = new Array(n.length);
        for (const v of e) {
          const m = v.index;
          o[m] = { left: v.x1New, top: 0, right: v.x2New, bottom: 0 };
        }
        n.map(function(v, m) {
          const d = o[m], E = e[m];
          E.x1 = v.top, E.y1 = b - d.right, E.x2 = v.bottom, E.y2 = b - d.left, E.index = m, E.x1New = void 0, E.x2New = void 0;
        }), s(r, e);
        for (const v of e) {
          const m = v.index;
          o[m].top = v.x1New, o[m].bottom = v.x2New;
        }
        return o;
      }
      function s(b, r) {
        r.sort(function(o, v) {
          return o.x1 - v.x1 || o.index - v.index;
        });
        const e = [{ start: -1 / 0, end: 1 / 0, boundary: { x1: -1 / 0, y1: -1 / 0, x2: 0, y2: 1 / 0, index: -1, x1New: 0, x2New: 0 } }];
        for (const o of r) {
          let v = 0;
          for (; v < e.length && e[v].end <= o.y1; ) v++;
          let m = e.length - 1;
          for (; m >= 0 && e[m].start >= o.y2; ) m--;
          let d, E, U, tt, H = -1 / 0;
          for (U = v; U <= m; U++) {
            d = e[U], E = d.boundary;
            let V;
            E.x2 > o.x1 ? V = E.index > o.index ? E.x1New : o.x1 : E.x2New === void 0 ? V = (E.x2 + o.x1) / 2 : V = E.x2New, V > H && (H = V);
          }
          for (o.x1New = H, U = v; U <= m; U++) d = e[U], E = d.boundary, E.x2New === void 0 ? E.x2 > o.x1 ? E.index > o.index && (E.x2New = E.x2) : E.x2New = H : E.x2New > H && (E.x2New = Math.max(H, E.x2));
          const Z = [];
          let j = null;
          for (U = v; U <= m; U++) {
            d = e[U], E = d.boundary;
            const V = E.x2 > o.x2 ? E : o;
            j === V ? Z.at(-1).end = d.end : (Z.push({ start: d.start, end: d.end, boundary: V }), j = V);
          }
          for (e[v].start < o.y1 && (Z[0].start = o.y1, Z.unshift({ start: e[v].start, end: o.y1, boundary: e[v].boundary })), o.y2 < e[m].end && (Z.at(-1).end = o.y2, Z.push({ start: o.y2, end: e[m].end, boundary: e[m].boundary })), U = v; U <= m; U++) {
            if (d = e[U], E = d.boundary, E.x2New !== void 0) continue;
            let V = false;
            for (tt = v - 1; !V && tt >= 0 && e[tt].start >= E.y1; tt--) V = e[tt].boundary === E;
            for (tt = m + 1; !V && tt < e.length && e[tt].end <= E.y2; tt++) V = e[tt].boundary === E;
            for (tt = 0; !V && tt < Z.length; tt++) V = Z[tt].boundary === E;
            V || (E.x2New = H);
          }
          Array.prototype.splice.apply(e, [v, m - v + 1, ...Z]);
        }
        for (const o of e) {
          const v = o.boundary;
          v.x2New === void 0 && (v.x2New = Math.max(b, v.x2));
        }
      }
      class a {
        constructor({ textContent: r, textContentStream: n, container: e, viewport: o, textDivs: v, textContentItemsStr: m, enhanceTextSelection: d }) {
          var E;
          d && (0, S2.deprecated)("The `enhanceTextSelection` functionality will be removed in the future."), this._textContent = r, this._textContentStream = n, this._container = e, this._document = e.ownerDocument, this._viewport = o, this._textDivs = v || [], this._textContentItemsStr = m || [], this._enhanceTextSelection = !!d, this._fontInspectorEnabled = !!((E = globalThis.FontInspector) != null && E.enabled), this._reader = null, this._layoutTextLastFontSize = null, this._layoutTextLastFontFamily = null, this._layoutTextCtx = null, this._textDivProperties = /* @__PURE__ */ new WeakMap(), this._renderingDone = false, this._canceled = false, this._capability = (0, c2.createPromiseCapability)(), this._renderTimer = null, this._bounds = [], this._devicePixelRatio = globalThis.devicePixelRatio || 1, this._capability.promise.finally(() => {
            this._enhanceTextSelection || (this._textDivProperties = null), this._layoutTextCtx && (this._layoutTextCtx.canvas.width = 0, this._layoutTextCtx.canvas.height = 0, this._layoutTextCtx = null);
          }).catch(() => {
          });
        }
        get promise() {
          return this._capability.promise;
        }
        cancel() {
          this._canceled = true, this._reader && (this._reader.cancel(new c2.AbortException("TextLayer task cancelled.")).catch(() => {
          }), this._reader = null), this._renderTimer !== null && (clearTimeout(this._renderTimer), this._renderTimer = null), this._capability.reject(new Error("TextLayer task cancelled."));
        }
        _processItems(r, n) {
          for (let e = 0, o = r.length; e < o; e++) {
            if (r[e].str === void 0) {
              if (r[e].type === "beginMarkedContentProps" || r[e].type === "beginMarkedContent") {
                const v = this._container;
                this._container = document.createElement("span"), this._container.classList.add("markedContent"), r[e].id !== null && this._container.setAttribute("id", `${r[e].id}`), v.append(this._container);
              } else r[e].type === "endMarkedContent" && (this._container = this._container.parentNode);
              continue;
            }
            this._textContentItemsStr.push(r[e].str), k2(this, r[e], n, this._layoutTextCtx);
          }
        }
        _layoutText(r) {
          const n = this._textDivProperties.get(r);
          let e = "";
          if (n.canvasWidth !== 0 && n.hasText) {
            const { fontFamily: o } = r.style, { fontSize: v } = n;
            (v !== this._layoutTextLastFontSize || o !== this._layoutTextLastFontFamily) && (this._layoutTextCtx.font = `${v * this._devicePixelRatio}px ${o}`, this._layoutTextLastFontSize = v, this._layoutTextLastFontFamily = o);
            const { width: m } = this._layoutTextCtx.measureText(r.textContent);
            if (m > 0) {
              const d = this._devicePixelRatio * n.canvasWidth / m;
              this._enhanceTextSelection && (n.scale = d), e = `scaleX(${d})`;
            }
          }
          if (n.angle !== 0 && (e = `rotate(${n.angle}deg) ${e}`), e.length > 0 && (this._enhanceTextSelection && (n.originalTransform = e), r.style.transform = e), n.hasText && this._container.append(r), n.hasEOL) {
            const o = document.createElement("br");
            o.setAttribute("role", "presentation"), this._container.append(o);
          }
        }
        _render(r = 0) {
          const n = (0, c2.createPromiseCapability)();
          let e = /* @__PURE__ */ Object.create(null);
          const o = this._document.createElement("canvas");
          if (o.height = o.width = B2, this._layoutTextCtx = o.getContext("2d", { alpha: false }), this._textContent) {
            const v = this._textContent.items, m = this._textContent.styles;
            this._processItems(v, m), n.resolve();
          } else if (this._textContentStream) {
            const v = () => {
              this._reader.read().then(({ value: m, done: d }) => {
                if (d) {
                  n.resolve();
                  return;
                }
                Object.assign(e, m.styles), this._processItems(m.items, e), v();
              }, n.reject);
            };
            this._reader = this._textContentStream.getReader(), v();
          } else throw new Error('Neither "textContent" nor "textContentStream" parameters specified.');
          n.promise.then(() => {
            e = null, r ? this._renderTimer = setTimeout(() => {
              T2(this), this._renderTimer = null;
            }, r) : T2(this);
          }, this._capability.reject);
        }
        expandTextDivs(r = false) {
          if (!this._enhanceTextSelection || !this._renderingDone) return;
          this._bounds !== null && (l(this), this._bounds = null);
          const n = [], e = [];
          for (let o = 0, v = this._textDivs.length; o < v; o++) {
            const m = this._textDivs[o], d = this._textDivProperties.get(m);
            d.hasText && (r ? (n.length = 0, e.length = 0, d.originalTransform && n.push(d.originalTransform), d.paddingTop > 0 ? (e.push(`${d.paddingTop}px`), n.push(`translateY(${-d.paddingTop}px)`)) : e.push(0), d.paddingRight > 0 ? e.push(`${d.paddingRight / d.scale}px`) : e.push(0), d.paddingBottom > 0 ? e.push(`${d.paddingBottom}px`) : e.push(0), d.paddingLeft > 0 ? (e.push(`${d.paddingLeft / d.scale}px`), n.push(`translateX(${-d.paddingLeft / d.scale}px)`)) : e.push(0), m.style.padding = e.join(" "), n.length && (m.style.transform = n.join(" "))) : (m.style.padding = null, m.style.transform = d.originalTransform));
          }
        }
      }
      f2.TextLayerRenderTask = a;
      function h(b) {
        const r = new a({ textContent: b.textContent, textContentStream: b.textContentStream, container: b.container, viewport: b.viewport, textDivs: b.textDivs, textContentItemsStr: b.textContentItemsStr, enhanceTextSelection: b.enhanceTextSelection });
        return r._render(b.timeout), r;
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.SVGGraphics = void 0;
      var c2 = $2(8), S2 = $2(1), q2 = $2(3);
      let B2 = class {
        constructor() {
          (0, S2.unreachable)("Not implemented: SVGGraphics");
        }
      };
      f2.SVGGraphics = B2;
      {
        let t = function(n) {
          let e = [];
          const o = [];
          for (const v of n) {
            if (v.fn === "save") {
              e.push({ fnId: 92, fn: "group", items: [] }), o.push(e), e = e.at(-1).items;
              continue;
            }
            v.fn === "restore" ? e = o.pop() : e.push(v);
          }
          return e;
        }, s = function(n) {
          if (Number.isInteger(n)) return n.toString();
          const e = n.toFixed(10);
          let o = e.length - 1;
          if (e[o] !== "0") return e;
          do
            o--;
          while (e[o] === "0");
          return e.substring(0, e[o] === "." ? o : o + 1);
        }, a = function(n) {
          if (n[4] === 0 && n[5] === 0) {
            if (n[1] === 0 && n[2] === 0) return n[0] === 1 && n[3] === 1 ? "" : `scale(${s(n[0])} ${s(n[3])})`;
            if (n[0] === n[3] && n[1] === -n[2]) {
              const e = Math.acos(n[0]) * 180 / Math.PI;
              return `rotate(${s(e)})`;
            }
          } else if (n[0] === 1 && n[1] === 0 && n[2] === 0 && n[3] === 1) return `translate(${s(n[4])} ${s(n[5])})`;
          return `matrix(${s(n[0])} ${s(n[1])} ${s(n[2])} ${s(n[3])} ${s(n[4])} ${s(n[5])})`;
        };
        const Q2 = { fontStyle: "normal", fontWeight: "normal", fillColor: "#000000" }, I2 = "http://www.w3.org/XML/1998/namespace", y2 = "http://www.w3.org/1999/xlink", w = ["butt", "round", "square"], k2 = ["miter", "round", "bevel"], T2 = function(n, e = "", o = false) {
          if (URL.createObjectURL && typeof Blob < "u" && !o) return URL.createObjectURL(new Blob([n], { type: e }));
          const v = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
          let m = `data:${e};base64,`;
          for (let d = 0, E = n.length; d < E; d += 3) {
            const U = n[d] & 255, tt = n[d + 1] & 255, H = n[d + 2] & 255, Z = U >> 2, j = (U & 3) << 4 | tt >> 4, V = d + 1 < E ? (tt & 15) << 2 | H >> 6 : 64, X = d + 2 < E ? H & 63 : 64;
            m += v[Z] + v[j] + v[V] + v[X];
          }
          return m;
        }, C2 = (function() {
          const n = new Uint8Array([137, 80, 78, 71, 13, 10, 26, 10]), e = 12, o = new Int32Array(256);
          for (let H = 0; H < 256; H++) {
            let Z = H;
            for (let j = 0; j < 8; j++) Z & 1 ? Z = 3988292384 ^ Z >> 1 & 2147483647 : Z = Z >> 1 & 2147483647;
            o[H] = Z;
          }
          function v(H, Z, j) {
            let V = -1;
            for (let X = Z; X < j; X++) {
              const at = (V ^ H[X]) & 255, dt = o[at];
              V = V >>> 8 ^ dt;
            }
            return V ^ -1;
          }
          function m(H, Z, j, V) {
            let X = V;
            const at = Z.length;
            j[X] = at >> 24 & 255, j[X + 1] = at >> 16 & 255, j[X + 2] = at >> 8 & 255, j[X + 3] = at & 255, X += 4, j[X] = H.charCodeAt(0) & 255, j[X + 1] = H.charCodeAt(1) & 255, j[X + 2] = H.charCodeAt(2) & 255, j[X + 3] = H.charCodeAt(3) & 255, X += 4, j.set(Z, X), X += Z.length;
            const dt = v(j, V + 4, X);
            j[X] = dt >> 24 & 255, j[X + 1] = dt >> 16 & 255, j[X + 2] = dt >> 8 & 255, j[X + 3] = dt & 255;
          }
          function d(H, Z, j) {
            let V = 1, X = 0;
            for (let at = Z; at < j; ++at) V = (V + (H[at] & 255)) % 65521, X = (X + V) % 65521;
            return X << 16 | V;
          }
          function E(H) {
            if (!q2.isNodeJS) return U(H);
            try {
              let Z;
              parseInt(process.versions.node) >= 8 ? Z = H : Z = Buffer.from(H);
              const j = require$$4.deflateSync(Z, { level: 9 });
              return j instanceof Uint8Array ? j : new Uint8Array(j);
            } catch (Z) {
              (0, S2.warn)("Not compressing PNG because zlib.deflateSync is unavailable: " + Z);
            }
            return U(H);
          }
          function U(H) {
            let Z = H.length;
            const j = 65535, V = Math.ceil(Z / j), X = new Uint8Array(2 + Z + V * 5 + 4);
            let at = 0;
            X[at++] = 120, X[at++] = 156;
            let dt = 0;
            for (; Z > j; ) X[at++] = 0, X[at++] = 255, X[at++] = 255, X[at++] = 0, X[at++] = 0, X.set(H.subarray(dt, dt + j), at), at += j, dt += j, Z -= j;
            X[at++] = 1, X[at++] = Z & 255, X[at++] = Z >> 8 & 255, X[at++] = ~Z & 65535 & 255, X[at++] = (~Z & 65535) >> 8 & 255, X.set(H.subarray(dt), at), at += H.length - dt;
            const bt = d(H, 0, H.length);
            return X[at++] = bt >> 24 & 255, X[at++] = bt >> 16 & 255, X[at++] = bt >> 8 & 255, X[at++] = bt & 255, X;
          }
          function tt(H, Z, j, V) {
            const X = H.width, at = H.height;
            let dt, bt, N;
            const p = H.data;
            switch (Z) {
              case S2.ImageKind.GRAYSCALE_1BPP:
                bt = 0, dt = 1, N = X + 7 >> 3;
                break;
              case S2.ImageKind.RGB_24BPP:
                bt = 2, dt = 8, N = X * 3;
                break;
              case S2.ImageKind.RGBA_32BPP:
                bt = 6, dt = 8, N = X * 4;
                break;
              default:
                throw new Error("invalid format");
            }
            const u = new Uint8Array((1 + N) * at);
            let P = 0, F = 0;
            for (let _ = 0; _ < at; ++_) u[P++] = 0, u.set(p.subarray(F, F + N), P), F += N, P += N;
            if (Z === S2.ImageKind.GRAYSCALE_1BPP && V) {
              P = 0;
              for (let _ = 0; _ < at; _++) {
                P++;
                for (let g = 0; g < N; g++) u[P++] ^= 255;
              }
            }
            const D = new Uint8Array([X >> 24 & 255, X >> 16 & 255, X >> 8 & 255, X & 255, at >> 24 & 255, at >> 16 & 255, at >> 8 & 255, at & 255, dt, bt, 0, 0, 0]), O = E(u), Y = n.length + e * 3 + D.length + O.length, K = new Uint8Array(Y);
            let i = 0;
            return K.set(n, i), i += n.length, m("IHDR", D, K, i), i += e + D.length, m("IDATA", O, K, i), i += e + O.length, m("IEND", new Uint8Array(0), K, i), T2(K, "image/png", j);
          }
          return function(Z, j, V) {
            const X = Z.kind === void 0 ? S2.ImageKind.GRAYSCALE_1BPP : Z.kind;
            return tt(Z, X, j, V);
          };
        })();
        class l {
          constructor() {
            this.fontSizeScale = 1, this.fontWeight = Q2.fontWeight, this.fontSize = 0, this.textMatrix = S2.IDENTITY_MATRIX, this.fontMatrix = S2.FONT_IDENTITY_MATRIX, this.leading = 0, this.textRenderingMode = S2.TextRenderingMode.FILL, this.textMatrixScale = 1, this.x = 0, this.y = 0, this.lineX = 0, this.lineY = 0, this.charSpacing = 0, this.wordSpacing = 0, this.textHScale = 1, this.textRise = 0, this.fillColor = Q2.fillColor, this.strokeColor = "#000000", this.fillAlpha = 1, this.strokeAlpha = 1, this.lineWidth = 1, this.lineJoin = "", this.lineCap = "", this.miterLimit = 0, this.dashArray = [], this.dashPhase = 0, this.dependencies = [], this.activeClipUrl = null, this.clipGroup = null, this.maskId = "";
          }
          clone() {
            return Object.create(this);
          }
          setCurrentPoint(e, o) {
            this.x = e, this.y = o;
          }
        }
        let h = 0, b = 0, r = 0;
        f2.SVGGraphics = B2 = class {
          constructor(n, e, o = false) {
            (0, c2.deprecated)("The SVG back-end is no longer maintained and *may* be removed in the future."), this.svgFactory = new c2.DOMSVGFactory(), this.current = new l(), this.transformMatrix = S2.IDENTITY_MATRIX, this.transformStack = [], this.extraStack = [], this.commonObjs = n, this.objs = e, this.pendingClip = null, this.pendingEOFill = false, this.embedFonts = false, this.embeddedFonts = /* @__PURE__ */ Object.create(null), this.cssStyle = null, this.forceDataSchema = !!o, this._operatorIdMapping = [];
            for (const v in S2.OPS) this._operatorIdMapping[S2.OPS[v]] = v;
          }
          save() {
            this.transformStack.push(this.transformMatrix);
            const n = this.current;
            this.extraStack.push(n), this.current = n.clone();
          }
          restore() {
            this.transformMatrix = this.transformStack.pop(), this.current = this.extraStack.pop(), this.pendingClip = null, this.tgrp = null;
          }
          group(n) {
            this.save(), this.executeOpTree(n), this.restore();
          }
          loadDependencies(n) {
            const e = n.fnArray, o = n.argsArray;
            for (let v = 0, m = e.length; v < m; v++) if (e[v] === S2.OPS.dependency) for (const d of o[v]) {
              const E = d.startsWith("g_") ? this.commonObjs : this.objs, U = new Promise((tt) => {
                E.get(d, tt);
              });
              this.current.dependencies.push(U);
            }
            return Promise.all(this.current.dependencies);
          }
          transform(n, e, o, v, m, d) {
            const E = [n, e, o, v, m, d];
            this.transformMatrix = S2.Util.transform(this.transformMatrix, E), this.tgrp = null;
          }
          getSVG(n, e) {
            this.viewport = e;
            const o = this._initialize(e);
            return this.loadDependencies(n).then(() => (this.transformMatrix = S2.IDENTITY_MATRIX, this.executeOpTree(this.convertOpList(n)), o));
          }
          convertOpList(n) {
            const e = this._operatorIdMapping, o = n.argsArray, v = n.fnArray, m = [];
            for (let d = 0, E = v.length; d < E; d++) {
              const U = v[d];
              m.push({ fnId: U, fn: e[U], args: o[d] });
            }
            return t(m);
          }
          executeOpTree(n) {
            for (const e of n) {
              const o = e.fn, v = e.fnId, m = e.args;
              switch (v | 0) {
                case S2.OPS.beginText:
                  this.beginText();
                  break;
                case S2.OPS.dependency:
                  break;
                case S2.OPS.setLeading:
                  this.setLeading(m);
                  break;
                case S2.OPS.setLeadingMoveText:
                  this.setLeadingMoveText(m[0], m[1]);
                  break;
                case S2.OPS.setFont:
                  this.setFont(m);
                  break;
                case S2.OPS.showText:
                  this.showText(m[0]);
                  break;
                case S2.OPS.showSpacedText:
                  this.showText(m[0]);
                  break;
                case S2.OPS.endText:
                  this.endText();
                  break;
                case S2.OPS.moveText:
                  this.moveText(m[0], m[1]);
                  break;
                case S2.OPS.setCharSpacing:
                  this.setCharSpacing(m[0]);
                  break;
                case S2.OPS.setWordSpacing:
                  this.setWordSpacing(m[0]);
                  break;
                case S2.OPS.setHScale:
                  this.setHScale(m[0]);
                  break;
                case S2.OPS.setTextMatrix:
                  this.setTextMatrix(m[0], m[1], m[2], m[3], m[4], m[5]);
                  break;
                case S2.OPS.setTextRise:
                  this.setTextRise(m[0]);
                  break;
                case S2.OPS.setTextRenderingMode:
                  this.setTextRenderingMode(m[0]);
                  break;
                case S2.OPS.setLineWidth:
                  this.setLineWidth(m[0]);
                  break;
                case S2.OPS.setLineJoin:
                  this.setLineJoin(m[0]);
                  break;
                case S2.OPS.setLineCap:
                  this.setLineCap(m[0]);
                  break;
                case S2.OPS.setMiterLimit:
                  this.setMiterLimit(m[0]);
                  break;
                case S2.OPS.setFillRGBColor:
                  this.setFillRGBColor(m[0], m[1], m[2]);
                  break;
                case S2.OPS.setStrokeRGBColor:
                  this.setStrokeRGBColor(m[0], m[1], m[2]);
                  break;
                case S2.OPS.setStrokeColorN:
                  this.setStrokeColorN(m);
                  break;
                case S2.OPS.setFillColorN:
                  this.setFillColorN(m);
                  break;
                case S2.OPS.shadingFill:
                  this.shadingFill(m[0]);
                  break;
                case S2.OPS.setDash:
                  this.setDash(m[0], m[1]);
                  break;
                case S2.OPS.setRenderingIntent:
                  this.setRenderingIntent(m[0]);
                  break;
                case S2.OPS.setFlatness:
                  this.setFlatness(m[0]);
                  break;
                case S2.OPS.setGState:
                  this.setGState(m[0]);
                  break;
                case S2.OPS.fill:
                  this.fill();
                  break;
                case S2.OPS.eoFill:
                  this.eoFill();
                  break;
                case S2.OPS.stroke:
                  this.stroke();
                  break;
                case S2.OPS.fillStroke:
                  this.fillStroke();
                  break;
                case S2.OPS.eoFillStroke:
                  this.eoFillStroke();
                  break;
                case S2.OPS.clip:
                  this.clip("nonzero");
                  break;
                case S2.OPS.eoClip:
                  this.clip("evenodd");
                  break;
                case S2.OPS.paintSolidColorImageMask:
                  this.paintSolidColorImageMask();
                  break;
                case S2.OPS.paintImageXObject:
                  this.paintImageXObject(m[0]);
                  break;
                case S2.OPS.paintInlineImageXObject:
                  this.paintInlineImageXObject(m[0]);
                  break;
                case S2.OPS.paintImageMaskXObject:
                  this.paintImageMaskXObject(m[0]);
                  break;
                case S2.OPS.paintFormXObjectBegin:
                  this.paintFormXObjectBegin(m[0], m[1]);
                  break;
                case S2.OPS.paintFormXObjectEnd:
                  this.paintFormXObjectEnd();
                  break;
                case S2.OPS.closePath:
                  this.closePath();
                  break;
                case S2.OPS.closeStroke:
                  this.closeStroke();
                  break;
                case S2.OPS.closeFillStroke:
                  this.closeFillStroke();
                  break;
                case S2.OPS.closeEOFillStroke:
                  this.closeEOFillStroke();
                  break;
                case S2.OPS.nextLine:
                  this.nextLine();
                  break;
                case S2.OPS.transform:
                  this.transform(m[0], m[1], m[2], m[3], m[4], m[5]);
                  break;
                case S2.OPS.constructPath:
                  this.constructPath(m[0], m[1]);
                  break;
                case S2.OPS.endPath:
                  this.endPath();
                  break;
                case 92:
                  this.group(e.items);
                  break;
                default:
                  (0, S2.warn)(`Unimplemented operator ${o}`);
                  break;
              }
            }
          }
          setWordSpacing(n) {
            this.current.wordSpacing = n;
          }
          setCharSpacing(n) {
            this.current.charSpacing = n;
          }
          nextLine() {
            this.moveText(0, this.current.leading);
          }
          setTextMatrix(n, e, o, v, m, d) {
            const E = this.current;
            E.textMatrix = E.lineMatrix = [n, e, o, v, m, d], E.textMatrixScale = Math.hypot(n, e), E.x = E.lineX = 0, E.y = E.lineY = 0, E.xcoords = [], E.ycoords = [], E.tspan = this.svgFactory.createElement("svg:tspan"), E.tspan.setAttributeNS(null, "font-family", E.fontFamily), E.tspan.setAttributeNS(null, "font-size", `${s(E.fontSize)}px`), E.tspan.setAttributeNS(null, "y", s(-E.y)), E.txtElement = this.svgFactory.createElement("svg:text"), E.txtElement.append(E.tspan);
          }
          beginText() {
            const n = this.current;
            n.x = n.lineX = 0, n.y = n.lineY = 0, n.textMatrix = S2.IDENTITY_MATRIX, n.lineMatrix = S2.IDENTITY_MATRIX, n.textMatrixScale = 1, n.tspan = this.svgFactory.createElement("svg:tspan"), n.txtElement = this.svgFactory.createElement("svg:text"), n.txtgrp = this.svgFactory.createElement("svg:g"), n.xcoords = [], n.ycoords = [];
          }
          moveText(n, e) {
            const o = this.current;
            o.x = o.lineX += n, o.y = o.lineY += e, o.xcoords = [], o.ycoords = [], o.tspan = this.svgFactory.createElement("svg:tspan"), o.tspan.setAttributeNS(null, "font-family", o.fontFamily), o.tspan.setAttributeNS(null, "font-size", `${s(o.fontSize)}px`), o.tspan.setAttributeNS(null, "y", s(-o.y));
          }
          showText(n) {
            const e = this.current, o = e.font, v = e.fontSize;
            if (v === 0) return;
            const m = e.fontSizeScale, d = e.charSpacing, E = e.wordSpacing, U = e.fontDirection, tt = e.textHScale * U, H = o.vertical, Z = H ? 1 : -1, j = o.defaultVMetrics, V = v * e.fontMatrix[0];
            let X = 0;
            for (const bt of n) {
              if (bt === null) {
                X += U * E;
                continue;
              } else if (typeof bt == "number") {
                X += Z * bt * v / 1e3;
                continue;
              }
              const N = (bt.isSpace ? E : 0) + d, p = bt.fontChar;
              let u, P, F = bt.width;
              if (H) {
                let O;
                const Y = bt.vmetric || j;
                O = bt.vmetric ? Y[1] : F * 0.5, O = -O * V;
                const K = Y[2] * V;
                F = Y ? -Y[0] : F, u = O / m, P = (X + K) / m;
              } else u = X / m, P = 0;
              (bt.isInFont || o.missingFile) && (e.xcoords.push(e.x + u), H && e.ycoords.push(-e.y + P), e.tspan.textContent += p);
              let D;
              H ? D = F * V - N * U : D = F * V + N * U, X += D;
            }
            e.tspan.setAttributeNS(null, "x", e.xcoords.map(s).join(" ")), H ? e.tspan.setAttributeNS(null, "y", e.ycoords.map(s).join(" ")) : e.tspan.setAttributeNS(null, "y", s(-e.y)), H ? e.y -= X : e.x += X * tt, e.tspan.setAttributeNS(null, "font-family", e.fontFamily), e.tspan.setAttributeNS(null, "font-size", `${s(e.fontSize)}px`), e.fontStyle !== Q2.fontStyle && e.tspan.setAttributeNS(null, "font-style", e.fontStyle), e.fontWeight !== Q2.fontWeight && e.tspan.setAttributeNS(null, "font-weight", e.fontWeight);
            const at = e.textRenderingMode & S2.TextRenderingMode.FILL_STROKE_MASK;
            if (at === S2.TextRenderingMode.FILL || at === S2.TextRenderingMode.FILL_STROKE ? (e.fillColor !== Q2.fillColor && e.tspan.setAttributeNS(null, "fill", e.fillColor), e.fillAlpha < 1 && e.tspan.setAttributeNS(null, "fill-opacity", e.fillAlpha)) : e.textRenderingMode === S2.TextRenderingMode.ADD_TO_PATH ? e.tspan.setAttributeNS(null, "fill", "transparent") : e.tspan.setAttributeNS(null, "fill", "none"), at === S2.TextRenderingMode.STROKE || at === S2.TextRenderingMode.FILL_STROKE) {
              const bt = 1 / (e.textMatrixScale || 1);
              this._setStrokeAttributes(e.tspan, bt);
            }
            let dt = e.textMatrix;
            e.textRise !== 0 && (dt = dt.slice(), dt[5] += e.textRise), e.txtElement.setAttributeNS(null, "transform", `${a(dt)} scale(${s(tt)}, -1)`), e.txtElement.setAttributeNS(I2, "xml:space", "preserve"), e.txtElement.append(e.tspan), e.txtgrp.append(e.txtElement), this._ensureTransformGroup().append(e.txtElement);
          }
          setLeadingMoveText(n, e) {
            this.setLeading(-e), this.moveText(n, e);
          }
          addFontStyle(n) {
            if (!n.data) throw new Error('addFontStyle: No font data available, ensure that the "fontExtraProperties" API parameter is set.');
            this.cssStyle || (this.cssStyle = this.svgFactory.createElement("svg:style"), this.cssStyle.setAttributeNS(null, "type", "text/css"), this.defs.append(this.cssStyle));
            const e = T2(n.data, n.mimetype, this.forceDataSchema);
            this.cssStyle.textContent += `@font-face { font-family: "${n.loadedName}"; src: url(${e}); }
`;
          }
          setFont(n) {
            const e = this.current, o = this.commonObjs.get(n[0]);
            let v = n[1];
            e.font = o, this.embedFonts && !o.missingFile && !this.embeddedFonts[o.loadedName] && (this.addFontStyle(o), this.embeddedFonts[o.loadedName] = o), e.fontMatrix = o.fontMatrix || S2.FONT_IDENTITY_MATRIX;
            let m = "normal";
            o.black ? m = "900" : o.bold && (m = "bold");
            const d = o.italic ? "italic" : "normal";
            v < 0 ? (v = -v, e.fontDirection = -1) : e.fontDirection = 1, e.fontSize = v, e.fontFamily = o.loadedName, e.fontWeight = m, e.fontStyle = d, e.tspan = this.svgFactory.createElement("svg:tspan"), e.tspan.setAttributeNS(null, "y", s(-e.y)), e.xcoords = [], e.ycoords = [];
          }
          endText() {
            var e;
            const n = this.current;
            n.textRenderingMode & S2.TextRenderingMode.ADD_TO_PATH_FLAG && ((e = n.txtElement) != null && e.hasChildNodes()) && (n.element = n.txtElement, this.clip("nonzero"), this.endPath());
          }
          setLineWidth(n) {
            n > 0 && (this.current.lineWidth = n);
          }
          setLineCap(n) {
            this.current.lineCap = w[n];
          }
          setLineJoin(n) {
            this.current.lineJoin = k2[n];
          }
          setMiterLimit(n) {
            this.current.miterLimit = n;
          }
          setStrokeAlpha(n) {
            this.current.strokeAlpha = n;
          }
          setStrokeRGBColor(n, e, o) {
            this.current.strokeColor = S2.Util.makeHexColor(n, e, o);
          }
          setFillAlpha(n) {
            this.current.fillAlpha = n;
          }
          setFillRGBColor(n, e, o) {
            this.current.fillColor = S2.Util.makeHexColor(n, e, o), this.current.tspan = this.svgFactory.createElement("svg:tspan"), this.current.xcoords = [], this.current.ycoords = [];
          }
          setStrokeColorN(n) {
            this.current.strokeColor = this._makeColorN_Pattern(n);
          }
          setFillColorN(n) {
            this.current.fillColor = this._makeColorN_Pattern(n);
          }
          shadingFill(n) {
            const e = this.viewport.width, o = this.viewport.height, v = S2.Util.inverseTransform(this.transformMatrix), m = S2.Util.applyTransform([0, 0], v), d = S2.Util.applyTransform([0, o], v), E = S2.Util.applyTransform([e, 0], v), U = S2.Util.applyTransform([e, o], v), tt = Math.min(m[0], d[0], E[0], U[0]), H = Math.min(m[1], d[1], E[1], U[1]), Z = Math.max(m[0], d[0], E[0], U[0]), j = Math.max(m[1], d[1], E[1], U[1]), V = this.svgFactory.createElement("svg:rect");
            V.setAttributeNS(null, "x", tt), V.setAttributeNS(null, "y", H), V.setAttributeNS(null, "width", Z - tt), V.setAttributeNS(null, "height", j - H), V.setAttributeNS(null, "fill", this._makeShadingPattern(n)), this.current.fillAlpha < 1 && V.setAttributeNS(null, "fill-opacity", this.current.fillAlpha), this._ensureTransformGroup().append(V);
          }
          _makeColorN_Pattern(n) {
            return n[0] === "TilingPattern" ? this._makeTilingPattern(n) : this._makeShadingPattern(n);
          }
          _makeTilingPattern(n) {
            const e = n[1], o = n[2], v = n[3] || S2.IDENTITY_MATRIX, [m, d, E, U] = n[4], tt = n[5], H = n[6], Z = n[7], j = `shading${r++}`, [V, X, at, dt] = S2.Util.normalizeRect([...S2.Util.applyTransform([m, d], v), ...S2.Util.applyTransform([E, U], v)]), [bt, N] = S2.Util.singularValueDecompose2dScale(v), p = tt * bt, u = H * N, P = this.svgFactory.createElement("svg:pattern");
            P.setAttributeNS(null, "id", j), P.setAttributeNS(null, "patternUnits", "userSpaceOnUse"), P.setAttributeNS(null, "width", p), P.setAttributeNS(null, "height", u), P.setAttributeNS(null, "x", `${V}`), P.setAttributeNS(null, "y", `${X}`);
            const F = this.svg, D = this.transformMatrix, O = this.current.fillColor, Y = this.current.strokeColor, K = this.svgFactory.create(at - V, dt - X);
            if (this.svg = K, this.transformMatrix = v, Z === 2) {
              const i = S2.Util.makeHexColor(...e);
              this.current.fillColor = i, this.current.strokeColor = i;
            }
            return this.executeOpTree(this.convertOpList(o)), this.svg = F, this.transformMatrix = D, this.current.fillColor = O, this.current.strokeColor = Y, P.append(K.childNodes[0]), this.defs.append(P), `url(#${j})`;
          }
          _makeShadingPattern(n) {
            switch (typeof n == "string" && (n = this.objs.get(n)), n[0]) {
              case "RadialAxial":
                const e = `shading${r++}`, o = n[3];
                let v;
                switch (n[1]) {
                  case "axial":
                    const m = n[4], d = n[5];
                    v = this.svgFactory.createElement("svg:linearGradient"), v.setAttributeNS(null, "id", e), v.setAttributeNS(null, "gradientUnits", "userSpaceOnUse"), v.setAttributeNS(null, "x1", m[0]), v.setAttributeNS(null, "y1", m[1]), v.setAttributeNS(null, "x2", d[0]), v.setAttributeNS(null, "y2", d[1]);
                    break;
                  case "radial":
                    const E = n[4], U = n[5], tt = n[6], H = n[7];
                    v = this.svgFactory.createElement("svg:radialGradient"), v.setAttributeNS(null, "id", e), v.setAttributeNS(null, "gradientUnits", "userSpaceOnUse"), v.setAttributeNS(null, "cx", U[0]), v.setAttributeNS(null, "cy", U[1]), v.setAttributeNS(null, "r", H), v.setAttributeNS(null, "fx", E[0]), v.setAttributeNS(null, "fy", E[1]), v.setAttributeNS(null, "fr", tt);
                    break;
                  default:
                    throw new Error(`Unknown RadialAxial type: ${n[1]}`);
                }
                for (const m of o) {
                  const d = this.svgFactory.createElement("svg:stop");
                  d.setAttributeNS(null, "offset", m[0]), d.setAttributeNS(null, "stop-color", m[1]), v.append(d);
                }
                return this.defs.append(v), `url(#${e})`;
              case "Mesh":
                return (0, S2.warn)("Unimplemented pattern Mesh"), null;
              case "Dummy":
                return "hotpink";
              default:
                throw new Error(`Unknown IR type: ${n[0]}`);
            }
          }
          setDash(n, e) {
            this.current.dashArray = n, this.current.dashPhase = e;
          }
          constructPath(n, e) {
            const o = this.current;
            let v = o.x, m = o.y, d = [], E = 0;
            for (const U of n) switch (U | 0) {
              case S2.OPS.rectangle:
                v = e[E++], m = e[E++];
                const tt = e[E++], H = e[E++], Z = v + tt, j = m + H;
                d.push("M", s(v), s(m), "L", s(Z), s(m), "L", s(Z), s(j), "L", s(v), s(j), "Z");
                break;
              case S2.OPS.moveTo:
                v = e[E++], m = e[E++], d.push("M", s(v), s(m));
                break;
              case S2.OPS.lineTo:
                v = e[E++], m = e[E++], d.push("L", s(v), s(m));
                break;
              case S2.OPS.curveTo:
                v = e[E + 4], m = e[E + 5], d.push("C", s(e[E]), s(e[E + 1]), s(e[E + 2]), s(e[E + 3]), s(v), s(m)), E += 6;
                break;
              case S2.OPS.curveTo2:
                d.push("C", s(v), s(m), s(e[E]), s(e[E + 1]), s(e[E + 2]), s(e[E + 3])), v = e[E + 2], m = e[E + 3], E += 4;
                break;
              case S2.OPS.curveTo3:
                v = e[E + 2], m = e[E + 3], d.push("C", s(e[E]), s(e[E + 1]), s(v), s(m), s(v), s(m)), E += 4;
                break;
              case S2.OPS.closePath:
                d.push("Z");
                break;
            }
            d = d.join(" "), o.path && n.length > 0 && n[0] !== S2.OPS.rectangle && n[0] !== S2.OPS.moveTo ? d = o.path.getAttributeNS(null, "d") + d : (o.path = this.svgFactory.createElement("svg:path"), this._ensureTransformGroup().append(o.path)), o.path.setAttributeNS(null, "d", d), o.path.setAttributeNS(null, "fill", "none"), o.element = o.path, o.setCurrentPoint(v, m);
          }
          endPath() {
            const n = this.current;
            if (n.path = null, !this.pendingClip) return;
            if (!n.element) {
              this.pendingClip = null;
              return;
            }
            const e = `clippath${h++}`, o = this.svgFactory.createElement("svg:clipPath");
            o.setAttributeNS(null, "id", e), o.setAttributeNS(null, "transform", a(this.transformMatrix));
            const v = n.element.cloneNode(true);
            if (this.pendingClip === "evenodd" ? v.setAttributeNS(null, "clip-rule", "evenodd") : v.setAttributeNS(null, "clip-rule", "nonzero"), this.pendingClip = null, o.append(v), this.defs.append(o), n.activeClipUrl) {
              n.clipGroup = null;
              for (const m of this.extraStack) m.clipGroup = null;
              o.setAttributeNS(null, "clip-path", n.activeClipUrl);
            }
            n.activeClipUrl = `url(#${e})`, this.tgrp = null;
          }
          clip(n) {
            this.pendingClip = n;
          }
          closePath() {
            const n = this.current;
            if (n.path) {
              const e = `${n.path.getAttributeNS(null, "d")}Z`;
              n.path.setAttributeNS(null, "d", e);
            }
          }
          setLeading(n) {
            this.current.leading = -n;
          }
          setTextRise(n) {
            this.current.textRise = n;
          }
          setTextRenderingMode(n) {
            this.current.textRenderingMode = n;
          }
          setHScale(n) {
            this.current.textHScale = n / 100;
          }
          setRenderingIntent(n) {
          }
          setFlatness(n) {
          }
          setGState(n) {
            for (const [e, o] of n) switch (e) {
              case "LW":
                this.setLineWidth(o);
                break;
              case "LC":
                this.setLineCap(o);
                break;
              case "LJ":
                this.setLineJoin(o);
                break;
              case "ML":
                this.setMiterLimit(o);
                break;
              case "D":
                this.setDash(o[0], o[1]);
                break;
              case "RI":
                this.setRenderingIntent(o);
                break;
              case "FL":
                this.setFlatness(o);
                break;
              case "Font":
                this.setFont(o);
                break;
              case "CA":
                this.setStrokeAlpha(o);
                break;
              case "ca":
                this.setFillAlpha(o);
                break;
              default:
                (0, S2.warn)(`Unimplemented graphic state operator ${e}`);
                break;
            }
          }
          fill() {
            const n = this.current;
            n.element && (n.element.setAttributeNS(null, "fill", n.fillColor), n.element.setAttributeNS(null, "fill-opacity", n.fillAlpha), this.endPath());
          }
          stroke() {
            const n = this.current;
            n.element && (this._setStrokeAttributes(n.element), n.element.setAttributeNS(null, "fill", "none"), this.endPath());
          }
          _setStrokeAttributes(n, e = 1) {
            const o = this.current;
            let v = o.dashArray;
            e !== 1 && v.length > 0 && (v = v.map(function(m) {
              return e * m;
            })), n.setAttributeNS(null, "stroke", o.strokeColor), n.setAttributeNS(null, "stroke-opacity", o.strokeAlpha), n.setAttributeNS(null, "stroke-miterlimit", s(o.miterLimit)), n.setAttributeNS(null, "stroke-linecap", o.lineCap), n.setAttributeNS(null, "stroke-linejoin", o.lineJoin), n.setAttributeNS(null, "stroke-width", s(e * o.lineWidth) + "px"), n.setAttributeNS(null, "stroke-dasharray", v.map(s).join(" ")), n.setAttributeNS(null, "stroke-dashoffset", s(e * o.dashPhase) + "px");
          }
          eoFill() {
            this.current.element && this.current.element.setAttributeNS(null, "fill-rule", "evenodd"), this.fill();
          }
          fillStroke() {
            this.stroke(), this.fill();
          }
          eoFillStroke() {
            this.current.element && this.current.element.setAttributeNS(null, "fill-rule", "evenodd"), this.fillStroke();
          }
          closeStroke() {
            this.closePath(), this.stroke();
          }
          closeFillStroke() {
            this.closePath(), this.fillStroke();
          }
          closeEOFillStroke() {
            this.closePath(), this.eoFillStroke();
          }
          paintSolidColorImageMask() {
            const n = this.svgFactory.createElement("svg:rect");
            n.setAttributeNS(null, "x", "0"), n.setAttributeNS(null, "y", "0"), n.setAttributeNS(null, "width", "1px"), n.setAttributeNS(null, "height", "1px"), n.setAttributeNS(null, "fill", this.current.fillColor), this._ensureTransformGroup().append(n);
          }
          paintImageXObject(n) {
            const e = n.startsWith("g_") ? this.commonObjs.get(n) : this.objs.get(n);
            if (!e) {
              (0, S2.warn)(`Dependent image with object ID ${n} is not ready yet`);
              return;
            }
            this.paintInlineImageXObject(e);
          }
          paintInlineImageXObject(n, e) {
            const o = n.width, v = n.height, m = C2(n, this.forceDataSchema, !!e), d = this.svgFactory.createElement("svg:rect");
            d.setAttributeNS(null, "x", "0"), d.setAttributeNS(null, "y", "0"), d.setAttributeNS(null, "width", s(o)), d.setAttributeNS(null, "height", s(v)), this.current.element = d, this.clip("nonzero");
            const E = this.svgFactory.createElement("svg:image");
            E.setAttributeNS(y2, "xlink:href", m), E.setAttributeNS(null, "x", "0"), E.setAttributeNS(null, "y", s(-v)), E.setAttributeNS(null, "width", s(o) + "px"), E.setAttributeNS(null, "height", s(v) + "px"), E.setAttributeNS(null, "transform", `scale(${s(1 / o)} ${s(-1 / v)})`), e ? e.append(E) : this._ensureTransformGroup().append(E);
          }
          paintImageMaskXObject(n) {
            const e = this.current, o = n.width, v = n.height, m = e.fillColor;
            e.maskId = `mask${b++}`;
            const d = this.svgFactory.createElement("svg:mask");
            d.setAttributeNS(null, "id", e.maskId);
            const E = this.svgFactory.createElement("svg:rect");
            E.setAttributeNS(null, "x", "0"), E.setAttributeNS(null, "y", "0"), E.setAttributeNS(null, "width", s(o)), E.setAttributeNS(null, "height", s(v)), E.setAttributeNS(null, "fill", m), E.setAttributeNS(null, "mask", `url(#${e.maskId})`), this.defs.append(d), this._ensureTransformGroup().append(E), this.paintInlineImageXObject(n, d);
          }
          paintFormXObjectBegin(n, e) {
            if (Array.isArray(n) && n.length === 6 && this.transform(n[0], n[1], n[2], n[3], n[4], n[5]), e) {
              const o = e[2] - e[0], v = e[3] - e[1], m = this.svgFactory.createElement("svg:rect");
              m.setAttributeNS(null, "x", e[0]), m.setAttributeNS(null, "y", e[1]), m.setAttributeNS(null, "width", s(o)), m.setAttributeNS(null, "height", s(v)), this.current.element = m, this.clip("nonzero"), this.endPath();
            }
          }
          paintFormXObjectEnd() {
          }
          _initialize(n) {
            const e = this.svgFactory.create(n.width, n.height), o = this.svgFactory.createElement("svg:defs");
            e.append(o), this.defs = o;
            const v = this.svgFactory.createElement("svg:g");
            return v.setAttributeNS(null, "transform", a(n.transform)), e.append(v), this.svg = v, e;
          }
          _ensureClipGroup() {
            if (!this.current.clipGroup) {
              const n = this.svgFactory.createElement("svg:g");
              n.setAttributeNS(null, "clip-path", this.current.activeClipUrl), this.svg.append(n), this.current.clipGroup = n;
            }
            return this.current.clipGroup;
          }
          _ensureTransformGroup() {
            return this.tgrp || (this.tgrp = this.svgFactory.createElement("svg:g"), this.tgrp.setAttributeNS(null, "transform", a(this.transformMatrix)), this.current.activeClipUrl ? this._ensureClipGroup().append(this.tgrp) : this.svg.append(this.tgrp)), this.tgrp;
          }
        };
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.PDFNodeStream = void 0;
      var c2 = $2(1), S2 = $2(33);
      const q2 = require$$4, B2 = require$$4, Q2 = require$$4, I2 = require$$4, y2 = /^file:\/\/\/[a-zA-Z]:\//;
      function w(b) {
        const r = I2.parse(b);
        return r.protocol === "file:" || r.host ? r : /^[a-z]:[/\\]/i.test(b) ? I2.parse(`file:///${b}`) : (r.host || (r.protocol = "file:"), r);
      }
      class k2 {
        constructor(r) {
          this.source = r, this.url = w(r.url), this.isHttp = this.url.protocol === "http:" || this.url.protocol === "https:", this.isFsUrl = this.url.protocol === "file:", this.httpHeaders = this.isHttp && r.httpHeaders || {}, this._fullRequestReader = null, this._rangeRequestReaders = [];
        }
        get _progressiveDataLength() {
          var r;
          return ((r = this._fullRequestReader) == null ? void 0 : r._loaded) ?? 0;
        }
        getFullReader() {
          return (0, c2.assert)(!this._fullRequestReader, "PDFNodeStream.getFullReader can only be called once."), this._fullRequestReader = this.isFsUrl ? new a(this) : new t(this), this._fullRequestReader;
        }
        getRangeReader(r, n) {
          if (n <= this._progressiveDataLength) return null;
          const e = this.isFsUrl ? new h(this, r, n) : new s(this, r, n);
          return this._rangeRequestReaders.push(e), e;
        }
        cancelAllRequests(r) {
          this._fullRequestReader && this._fullRequestReader.cancel(r);
          for (const n of this._rangeRequestReaders.slice(0)) n.cancel(r);
        }
      }
      f2.PDFNodeStream = k2;
      class T2 {
        constructor(r) {
          this._url = r.url, this._done = false, this._storedError = null, this.onProgress = null;
          const n = r.source;
          this._contentLength = n.length, this._loaded = 0, this._filename = null, this._disableRange = n.disableRange || false, this._rangeChunkSize = n.rangeChunkSize, !this._rangeChunkSize && !this._disableRange && (this._disableRange = true), this._isStreamingSupported = !n.disableStream, this._isRangeSupported = !n.disableRange, this._readableStream = null, this._readCapability = (0, c2.createPromiseCapability)(), this._headersCapability = (0, c2.createPromiseCapability)();
        }
        get headersReady() {
          return this._headersCapability.promise;
        }
        get filename() {
          return this._filename;
        }
        get contentLength() {
          return this._contentLength;
        }
        get isRangeSupported() {
          return this._isRangeSupported;
        }
        get isStreamingSupported() {
          return this._isStreamingSupported;
        }
        async read() {
          if (await this._readCapability.promise, this._done) return { value: void 0, done: true };
          if (this._storedError) throw this._storedError;
          const r = this._readableStream.read();
          return r === null ? (this._readCapability = (0, c2.createPromiseCapability)(), this.read()) : (this._loaded += r.length, this.onProgress && this.onProgress({ loaded: this._loaded, total: this._contentLength }), { value: new Uint8Array(r).buffer, done: false });
        }
        cancel(r) {
          if (!this._readableStream) {
            this._error(r);
            return;
          }
          this._readableStream.destroy(r);
        }
        _error(r) {
          this._storedError = r, this._readCapability.resolve();
        }
        _setReadableStream(r) {
          this._readableStream = r, r.on("readable", () => {
            this._readCapability.resolve();
          }), r.on("end", () => {
            r.destroy(), this._done = true, this._readCapability.resolve();
          }), r.on("error", (n) => {
            this._error(n);
          }), !this._isStreamingSupported && this._isRangeSupported && this._error(new c2.AbortException("streaming is disabled")), this._storedError && this._readableStream.destroy(this._storedError);
        }
      }
      class C2 {
        constructor(r) {
          this._url = r.url, this._done = false, this._storedError = null, this.onProgress = null, this._loaded = 0, this._readableStream = null, this._readCapability = (0, c2.createPromiseCapability)();
          const n = r.source;
          this._isStreamingSupported = !n.disableStream;
        }
        get isStreamingSupported() {
          return this._isStreamingSupported;
        }
        async read() {
          if (await this._readCapability.promise, this._done) return { value: void 0, done: true };
          if (this._storedError) throw this._storedError;
          const r = this._readableStream.read();
          return r === null ? (this._readCapability = (0, c2.createPromiseCapability)(), this.read()) : (this._loaded += r.length, this.onProgress && this.onProgress({ loaded: this._loaded }), { value: new Uint8Array(r).buffer, done: false });
        }
        cancel(r) {
          if (!this._readableStream) {
            this._error(r);
            return;
          }
          this._readableStream.destroy(r);
        }
        _error(r) {
          this._storedError = r, this._readCapability.resolve();
        }
        _setReadableStream(r) {
          this._readableStream = r, r.on("readable", () => {
            this._readCapability.resolve();
          }), r.on("end", () => {
            r.destroy(), this._done = true, this._readCapability.resolve();
          }), r.on("error", (n) => {
            this._error(n);
          }), this._storedError && this._readableStream.destroy(this._storedError);
        }
      }
      function l(b, r) {
        return { protocol: b.protocol, auth: b.auth, host: b.hostname, port: b.port, path: b.path, method: "GET", headers: r };
      }
      class t extends T2 {
        constructor(r) {
          super(r);
          const n = (e) => {
            if (e.statusCode === 404) {
              const d = new c2.MissingPDFException(`Missing PDF "${this._url}".`);
              this._storedError = d, this._headersCapability.reject(d);
              return;
            }
            this._headersCapability.resolve(), this._setReadableStream(e);
            const o = (d) => this._readableStream.headers[d.toLowerCase()], { allowRangeRequests: v, suggestedLength: m } = (0, S2.validateRangeRequestCapabilities)({ getResponseHeader: o, isHttp: r.isHttp, rangeChunkSize: this._rangeChunkSize, disableRange: this._disableRange });
            this._isRangeSupported = v, this._contentLength = m || this._contentLength, this._filename = (0, S2.extractFilenameFromHeader)(o);
          };
          this._request = null, this._url.protocol === "http:" ? this._request = B2.request(l(this._url, r.httpHeaders), n) : this._request = Q2.request(l(this._url, r.httpHeaders), n), this._request.on("error", (e) => {
            this._storedError = e, this._headersCapability.reject(e);
          }), this._request.end();
        }
      }
      class s extends C2 {
        constructor(r, n, e) {
          super(r), this._httpHeaders = {};
          for (const v in r.httpHeaders) {
            const m = r.httpHeaders[v];
            typeof m > "u" || (this._httpHeaders[v] = m);
          }
          this._httpHeaders.Range = `bytes=${n}-${e - 1}`;
          const o = (v) => {
            if (v.statusCode === 404) {
              const m = new c2.MissingPDFException(`Missing PDF "${this._url}".`);
              this._storedError = m;
              return;
            }
            this._setReadableStream(v);
          };
          this._request = null, this._url.protocol === "http:" ? this._request = B2.request(l(this._url, this._httpHeaders), o) : this._request = Q2.request(l(this._url, this._httpHeaders), o), this._request.on("error", (v) => {
            this._storedError = v;
          }), this._request.end();
        }
      }
      class a extends T2 {
        constructor(r) {
          super(r);
          let n = decodeURIComponent(this._url.path);
          y2.test(this._url.href) && (n = n.replace(/^\//, "")), q2.lstat(n, (e, o) => {
            if (e) {
              e.code === "ENOENT" && (e = new c2.MissingPDFException(`Missing PDF "${n}".`)), this._storedError = e, this._headersCapability.reject(e);
              return;
            }
            this._contentLength = o.size, this._setReadableStream(q2.createReadStream(n)), this._headersCapability.resolve();
          });
        }
      }
      class h extends C2 {
        constructor(r, n, e) {
          super(r);
          let o = decodeURIComponent(this._url.path);
          y2.test(this._url.href) && (o = o.replace(/^\//, "")), this._setReadableStream(q2.createReadStream(o, { start: n, end: e - 1 }));
        }
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.createResponseStatusError = I2, f2.extractFilenameFromHeader = Q2, f2.validateRangeRequestCapabilities = B2, f2.validateResponseStatus = y2;
      var c2 = $2(1), S2 = $2(34), q2 = $2(8);
      function B2({ getResponseHeader: w, isHttp: k2, rangeChunkSize: T2, disableRange: C2 }) {
        const l = { allowRangeRequests: false, suggestedLength: void 0 }, t = parseInt(w("Content-Length"), 10);
        return !Number.isInteger(t) || (l.suggestedLength = t, t <= 2 * T2) || C2 || !k2 || w("Accept-Ranges") !== "bytes" || (w("Content-Encoding") || "identity") !== "identity" || (l.allowRangeRequests = true), l;
      }
      function Q2(w) {
        const k2 = w("Content-Disposition");
        if (k2) {
          let T2 = (0, S2.getFilenameFromContentDispositionHeader)(k2);
          if (T2.includes("%")) try {
            T2 = decodeURIComponent(T2);
          } catch {
          }
          if ((0, q2.isPdfFile)(T2)) return T2;
        }
        return null;
      }
      function I2(w, k2) {
        return w === 404 || w === 0 && k2.startsWith("file:") ? new c2.MissingPDFException('Missing PDF "' + k2 + '".') : new c2.UnexpectedResponseException(`Unexpected server response (${w}) while retrieving PDF "${k2}".`, w);
      }
      function y2(w) {
        return w === 200 || w === 206;
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.getFilenameFromContentDispositionHeader = S2;
      var c2 = $2(1);
      function S2(q2) {
        let B2 = true, Q2 = I2("filename\\*", "i").exec(q2);
        if (Q2) {
          Q2 = Q2[1];
          let t = T2(Q2);
          return t = unescape(t), t = C2(t), t = l(t), w(t);
        }
        if (Q2 = k2(q2), Q2) {
          const t = l(Q2);
          return w(t);
        }
        if (Q2 = I2("filename", "i").exec(q2), Q2) {
          Q2 = Q2[1];
          let t = T2(Q2);
          return t = l(t), w(t);
        }
        function I2(t, s) {
          return new RegExp("(?:^|;)\\s*" + t + '\\s*=\\s*([^";\\s][^;\\s]*|"(?:[^"\\\\]|\\\\"?)+"?)', s);
        }
        function y2(t, s) {
          if (t) {
            if (!/^[\x00-\xFF]+$/.test(s)) return s;
            try {
              const a = new TextDecoder(t, { fatal: true }), h = (0, c2.stringToBytes)(s);
              s = a.decode(h), B2 = false;
            } catch {
            }
          }
          return s;
        }
        function w(t) {
          return B2 && /[\x80-\xff]/.test(t) && (t = y2("utf-8", t), B2 && (t = y2("iso-8859-1", t))), t;
        }
        function k2(t) {
          const s = [];
          let a;
          const h = I2("filename\\*((?!0\\d)\\d+)(\\*?)", "ig");
          for (; (a = h.exec(t)) !== null; ) {
            let [, r, n, e] = a;
            if (r = parseInt(r, 10), r in s) {
              if (r === 0) break;
              continue;
            }
            s[r] = [n, e];
          }
          const b = [];
          for (let r = 0; r < s.length && r in s; ++r) {
            let [n, e] = s[r];
            e = T2(e), n && (e = unescape(e), r === 0 && (e = C2(e))), b.push(e);
          }
          return b.join("");
        }
        function T2(t) {
          if (t.startsWith('"')) {
            const s = t.slice(1).split('\\"');
            for (let a = 0; a < s.length; ++a) {
              const h = s[a].indexOf('"');
              h !== -1 && (s[a] = s[a].slice(0, h), s.length = a + 1), s[a] = s[a].replace(/\\(.)/g, "$1");
            }
            t = s.join('"');
          }
          return t;
        }
        function C2(t) {
          const s = t.indexOf("'");
          if (s === -1) return t;
          const a = t.slice(0, s), b = t.slice(s + 1).replace(/^[^']*'/, "");
          return y2(a, b);
        }
        function l(t) {
          return !t.startsWith("=?") || /[\x00-\x19\x80-\xff]/.test(t) ? t : t.replace(/=\?([\w-]*)\?([QqBb])\?((?:[^?]|\?(?!=))*)\?=/g, function(s, a, h, b) {
            if (h === "q" || h === "Q") return b = b.replace(/_/g, " "), b = b.replace(/=([0-9a-fA-F]{2})/g, function(r, n) {
              return String.fromCharCode(parseInt(n, 16));
            }), y2(a, b);
            try {
              b = atob(b);
            } catch {
            }
            return y2(a, b);
          });
        }
        return "";
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.PDFNetworkStream = void 0;
      var c2 = $2(1), S2 = $2(33);
      const q2 = 200, B2 = 206;
      function Q2(T2) {
        const C2 = T2.response;
        return typeof C2 != "string" ? C2 : (0, c2.stringToBytes)(C2).buffer;
      }
      class I2 {
        constructor(C2, l = {}) {
          this.url = C2, this.isHttp = /^https?:/i.test(C2), this.httpHeaders = this.isHttp && l.httpHeaders || /* @__PURE__ */ Object.create(null), this.withCredentials = l.withCredentials || false, this.getXhr = l.getXhr || function() {
            return new XMLHttpRequest();
          }, this.currXhrId = 0, this.pendingRequests = /* @__PURE__ */ Object.create(null);
        }
        requestRange(C2, l, t) {
          const s = { begin: C2, end: l };
          for (const a in t) s[a] = t[a];
          return this.request(s);
        }
        requestFull(C2) {
          return this.request(C2);
        }
        request(C2) {
          const l = this.getXhr(), t = this.currXhrId++, s = this.pendingRequests[t] = { xhr: l };
          l.open("GET", this.url), l.withCredentials = this.withCredentials;
          for (const a in this.httpHeaders) {
            const h = this.httpHeaders[a];
            typeof h > "u" || l.setRequestHeader(a, h);
          }
          return this.isHttp && "begin" in C2 && "end" in C2 ? (l.setRequestHeader("Range", `bytes=${C2.begin}-${C2.end - 1}`), s.expectedStatus = B2) : s.expectedStatus = q2, l.responseType = "arraybuffer", C2.onError && (l.onerror = function(a) {
            C2.onError(l.status);
          }), l.onreadystatechange = this.onStateChange.bind(this, t), l.onprogress = this.onProgress.bind(this, t), s.onHeadersReceived = C2.onHeadersReceived, s.onDone = C2.onDone, s.onError = C2.onError, s.onProgress = C2.onProgress, l.send(null), t;
        }
        onProgress(C2, l) {
          var s;
          const t = this.pendingRequests[C2];
          t && ((s = t.onProgress) == null || s.call(t, l));
        }
        onStateChange(C2, l) {
          var r, n, e;
          const t = this.pendingRequests[C2];
          if (!t) return;
          const s = t.xhr;
          if (s.readyState >= 2 && t.onHeadersReceived && (t.onHeadersReceived(), delete t.onHeadersReceived), s.readyState !== 4 || !(C2 in this.pendingRequests)) return;
          if (delete this.pendingRequests[C2], s.status === 0 && this.isHttp) {
            (r = t.onError) == null || r.call(t, s.status);
            return;
          }
          const a = s.status || q2;
          if (!(a === q2 && t.expectedStatus === B2) && a !== t.expectedStatus) {
            (n = t.onError) == null || n.call(t, s.status);
            return;
          }
          const b = Q2(s);
          if (a === B2) {
            const o = s.getResponseHeader("Content-Range"), v = /bytes (\d+)-(\d+)\/(\d+)/.exec(o);
            t.onDone({ begin: parseInt(v[1], 10), chunk: b });
          } else b ? t.onDone({ begin: 0, chunk: b }) : (e = t.onError) == null || e.call(t, s.status);
        }
        getRequestXhr(C2) {
          return this.pendingRequests[C2].xhr;
        }
        isPendingRequest(C2) {
          return C2 in this.pendingRequests;
        }
        abortRequest(C2) {
          const l = this.pendingRequests[C2].xhr;
          delete this.pendingRequests[C2], l.abort();
        }
      }
      class y2 {
        constructor(C2) {
          this._source = C2, this._manager = new I2(C2.url, { httpHeaders: C2.httpHeaders, withCredentials: C2.withCredentials }), this._rangeChunkSize = C2.rangeChunkSize, this._fullRequestReader = null, this._rangeRequestReaders = [];
        }
        _onRangeRequestReaderClosed(C2) {
          const l = this._rangeRequestReaders.indexOf(C2);
          l >= 0 && this._rangeRequestReaders.splice(l, 1);
        }
        getFullReader() {
          return (0, c2.assert)(!this._fullRequestReader, "PDFNetworkStream.getFullReader can only be called once."), this._fullRequestReader = new w(this._manager, this._source), this._fullRequestReader;
        }
        getRangeReader(C2, l) {
          const t = new k2(this._manager, C2, l);
          return t.onClosed = this._onRangeRequestReaderClosed.bind(this), this._rangeRequestReaders.push(t), t;
        }
        cancelAllRequests(C2) {
          var l;
          (l = this._fullRequestReader) == null || l.cancel(C2);
          for (const t of this._rangeRequestReaders.slice(0)) t.cancel(C2);
        }
      }
      f2.PDFNetworkStream = y2;
      class w {
        constructor(C2, l) {
          this._manager = C2;
          const t = { onHeadersReceived: this._onHeadersReceived.bind(this), onDone: this._onDone.bind(this), onError: this._onError.bind(this), onProgress: this._onProgress.bind(this) };
          this._url = l.url, this._fullRequestId = C2.requestFull(t), this._headersReceivedCapability = (0, c2.createPromiseCapability)(), this._disableRange = l.disableRange || false, this._contentLength = l.length, this._rangeChunkSize = l.rangeChunkSize, !this._rangeChunkSize && !this._disableRange && (this._disableRange = true), this._isStreamingSupported = false, this._isRangeSupported = false, this._cachedChunks = [], this._requests = [], this._done = false, this._storedError = void 0, this._filename = null, this.onProgress = null;
        }
        _onHeadersReceived() {
          const C2 = this._fullRequestId, l = this._manager.getRequestXhr(C2), t = (h) => l.getResponseHeader(h), { allowRangeRequests: s, suggestedLength: a } = (0, S2.validateRangeRequestCapabilities)({ getResponseHeader: t, isHttp: this._manager.isHttp, rangeChunkSize: this._rangeChunkSize, disableRange: this._disableRange });
          s && (this._isRangeSupported = true), this._contentLength = a || this._contentLength, this._filename = (0, S2.extractFilenameFromHeader)(t), this._isRangeSupported && this._manager.abortRequest(C2), this._headersReceivedCapability.resolve();
        }
        _onDone(C2) {
          if (C2 && (this._requests.length > 0 ? this._requests.shift().resolve({ value: C2.chunk, done: false }) : this._cachedChunks.push(C2.chunk)), this._done = true, !(this._cachedChunks.length > 0)) {
            for (const l of this._requests) l.resolve({ value: void 0, done: true });
            this._requests.length = 0;
          }
        }
        _onError(C2) {
          this._storedError = (0, S2.createResponseStatusError)(C2, this._url), this._headersReceivedCapability.reject(this._storedError);
          for (const l of this._requests) l.reject(this._storedError);
          this._requests.length = 0, this._cachedChunks.length = 0;
        }
        _onProgress(C2) {
          var l;
          (l = this.onProgress) == null || l.call(this, { loaded: C2.loaded, total: C2.lengthComputable ? C2.total : this._contentLength });
        }
        get filename() {
          return this._filename;
        }
        get isRangeSupported() {
          return this._isRangeSupported;
        }
        get isStreamingSupported() {
          return this._isStreamingSupported;
        }
        get contentLength() {
          return this._contentLength;
        }
        get headersReady() {
          return this._headersReceivedCapability.promise;
        }
        async read() {
          if (this._storedError) throw this._storedError;
          if (this._cachedChunks.length > 0) return { value: this._cachedChunks.shift(), done: false };
          if (this._done) return { value: void 0, done: true };
          const C2 = (0, c2.createPromiseCapability)();
          return this._requests.push(C2), C2.promise;
        }
        cancel(C2) {
          this._done = true, this._headersReceivedCapability.reject(C2);
          for (const l of this._requests) l.resolve({ value: void 0, done: true });
          this._requests.length = 0, this._manager.isPendingRequest(this._fullRequestId) && this._manager.abortRequest(this._fullRequestId), this._fullRequestReader = null;
        }
      }
      class k2 {
        constructor(C2, l, t) {
          this._manager = C2;
          const s = { onDone: this._onDone.bind(this), onError: this._onError.bind(this), onProgress: this._onProgress.bind(this) };
          this._url = C2.url, this._requestId = C2.requestRange(l, t, s), this._requests = [], this._queuedChunk = null, this._done = false, this._storedError = void 0, this.onProgress = null, this.onClosed = null;
        }
        _close() {
          var C2;
          (C2 = this.onClosed) == null || C2.call(this, this);
        }
        _onDone(C2) {
          const l = C2.chunk;
          this._requests.length > 0 ? this._requests.shift().resolve({ value: l, done: false }) : this._queuedChunk = l, this._done = true;
          for (const t of this._requests) t.resolve({ value: void 0, done: true });
          this._requests.length = 0, this._close();
        }
        _onError(C2) {
          this._storedError = (0, S2.createResponseStatusError)(C2, this._url);
          for (const l of this._requests) l.reject(this._storedError);
          this._requests.length = 0, this._queuedChunk = null;
        }
        _onProgress(C2) {
          var l;
          this.isStreamingSupported || (l = this.onProgress) == null || l.call(this, { loaded: C2.loaded });
        }
        get isStreamingSupported() {
          return false;
        }
        async read() {
          if (this._storedError) throw this._storedError;
          if (this._queuedChunk !== null) {
            const l = this._queuedChunk;
            return this._queuedChunk = null, { value: l, done: false };
          }
          if (this._done) return { value: void 0, done: true };
          const C2 = (0, c2.createPromiseCapability)();
          return this._requests.push(C2), C2.promise;
        }
        cancel(C2) {
          this._done = true;
          for (const l of this._requests) l.resolve({ value: void 0, done: true });
          this._requests.length = 0, this._manager.isPendingRequest(this._requestId) && this._manager.abortRequest(this._requestId), this._close();
        }
      }
    }, (z2, f2, $2) => {
      Object.defineProperty(f2, "__esModule", { value: true }), f2.PDFFetchStream = void 0;
      var c2 = $2(1), S2 = $2(33);
      function q2(w, k2, T2) {
        return { method: "GET", headers: w, signal: T2.signal, mode: "cors", credentials: k2 ? "include" : "same-origin", redirect: "follow" };
      }
      function B2(w) {
        const k2 = new Headers();
        for (const T2 in w) {
          const C2 = w[T2];
          typeof C2 > "u" || k2.append(T2, C2);
        }
        return k2;
      }
      class Q2 {
        constructor(k2) {
          this.source = k2, this.isHttp = /^https?:/i.test(k2.url), this.httpHeaders = this.isHttp && k2.httpHeaders || {}, this._fullRequestReader = null, this._rangeRequestReaders = [];
        }
        get _progressiveDataLength() {
          var k2;
          return ((k2 = this._fullRequestReader) == null ? void 0 : k2._loaded) ?? 0;
        }
        getFullReader() {
          return (0, c2.assert)(!this._fullRequestReader, "PDFFetchStream.getFullReader can only be called once."), this._fullRequestReader = new I2(this), this._fullRequestReader;
        }
        getRangeReader(k2, T2) {
          if (T2 <= this._progressiveDataLength) return null;
          const C2 = new y2(this, k2, T2);
          return this._rangeRequestReaders.push(C2), C2;
        }
        cancelAllRequests(k2) {
          this._fullRequestReader && this._fullRequestReader.cancel(k2);
          for (const T2 of this._rangeRequestReaders.slice(0)) T2.cancel(k2);
        }
      }
      f2.PDFFetchStream = Q2;
      class I2 {
        constructor(k2) {
          this._stream = k2, this._reader = null, this._loaded = 0, this._filename = null;
          const T2 = k2.source;
          this._withCredentials = T2.withCredentials || false, this._contentLength = T2.length, this._headersCapability = (0, c2.createPromiseCapability)(), this._disableRange = T2.disableRange || false, this._rangeChunkSize = T2.rangeChunkSize, !this._rangeChunkSize && !this._disableRange && (this._disableRange = true), this._abortController = new AbortController(), this._isStreamingSupported = !T2.disableStream, this._isRangeSupported = !T2.disableRange, this._headers = B2(this._stream.httpHeaders);
          const C2 = T2.url;
          fetch(C2, q2(this._headers, this._withCredentials, this._abortController)).then((l) => {
            if (!(0, S2.validateResponseStatus)(l.status)) throw (0, S2.createResponseStatusError)(l.status, C2);
            this._reader = l.body.getReader(), this._headersCapability.resolve();
            const t = (h) => l.headers.get(h), { allowRangeRequests: s, suggestedLength: a } = (0, S2.validateRangeRequestCapabilities)({ getResponseHeader: t, isHttp: this._stream.isHttp, rangeChunkSize: this._rangeChunkSize, disableRange: this._disableRange });
            this._isRangeSupported = s, this._contentLength = a || this._contentLength, this._filename = (0, S2.extractFilenameFromHeader)(t), !this._isStreamingSupported && this._isRangeSupported && this.cancel(new c2.AbortException("Streaming is disabled."));
          }).catch(this._headersCapability.reject), this.onProgress = null;
        }
        get headersReady() {
          return this._headersCapability.promise;
        }
        get filename() {
          return this._filename;
        }
        get contentLength() {
          return this._contentLength;
        }
        get isRangeSupported() {
          return this._isRangeSupported;
        }
        get isStreamingSupported() {
          return this._isStreamingSupported;
        }
        async read() {
          await this._headersCapability.promise;
          const { value: k2, done: T2 } = await this._reader.read();
          return T2 ? { value: k2, done: T2 } : (this._loaded += k2.byteLength, this.onProgress && this.onProgress({ loaded: this._loaded, total: this._contentLength }), { value: new Uint8Array(k2).buffer, done: false });
        }
        cancel(k2) {
          this._reader && this._reader.cancel(k2), this._abortController.abort();
        }
      }
      class y2 {
        constructor(k2, T2, C2) {
          this._stream = k2, this._reader = null, this._loaded = 0;
          const l = k2.source;
          this._withCredentials = l.withCredentials || false, this._readCapability = (0, c2.createPromiseCapability)(), this._isStreamingSupported = !l.disableStream, this._abortController = new AbortController(), this._headers = B2(this._stream.httpHeaders), this._headers.append("Range", `bytes=${T2}-${C2 - 1}`);
          const t = l.url;
          fetch(t, q2(this._headers, this._withCredentials, this._abortController)).then((s) => {
            if (!(0, S2.validateResponseStatus)(s.status)) throw (0, S2.createResponseStatusError)(s.status, t);
            this._readCapability.resolve(), this._reader = s.body.getReader();
          }).catch(this._readCapability.reject), this.onProgress = null;
        }
        get isStreamingSupported() {
          return this._isStreamingSupported;
        }
        async read() {
          await this._readCapability.promise;
          const { value: k2, done: T2 } = await this._reader.read();
          return T2 ? { value: k2, done: T2 } : (this._loaded += k2.byteLength, this.onProgress && this.onProgress({ loaded: this._loaded }), { value: new Uint8Array(k2).buffer, done: false });
        }
        cancel(k2) {
          this._reader && this._reader.cancel(k2), this._abortController.abort();
        }
      }
    }], __webpack_module_cache__ = {};
    function __w_pdfjs_require__(z2) {
      var f2 = __webpack_module_cache__[z2];
      if (f2 !== void 0) return f2.exports;
      var $2 = __webpack_module_cache__[z2] = { exports: {} };
      return __webpack_modules__[z2]($2, $2.exports, __w_pdfjs_require__), $2.exports;
    }
    var __webpack_exports__ = {};
    return (() => {
      var z2 = __webpack_exports__;
      Object.defineProperty(z2, "__esModule", { value: true }), Object.defineProperty(z2, "AnnotationEditorLayer", { enumerable: true, get: function() {
        return S2.AnnotationEditorLayer;
      } }), Object.defineProperty(z2, "AnnotationEditorParamsType", { enumerable: true, get: function() {
        return f2.AnnotationEditorParamsType;
      } }), Object.defineProperty(z2, "AnnotationEditorType", { enumerable: true, get: function() {
        return f2.AnnotationEditorType;
      } }), Object.defineProperty(z2, "AnnotationEditorUIManager", { enumerable: true, get: function() {
        return q2.AnnotationEditorUIManager;
      } }), Object.defineProperty(z2, "AnnotationLayer", { enumerable: true, get: function() {
        return B2.AnnotationLayer;
      } }), Object.defineProperty(z2, "AnnotationMode", { enumerable: true, get: function() {
        return f2.AnnotationMode;
      } }), Object.defineProperty(z2, "CMapCompressionType", { enumerable: true, get: function() {
        return f2.CMapCompressionType;
      } }), Object.defineProperty(z2, "GlobalWorkerOptions", { enumerable: true, get: function() {
        return Q2.GlobalWorkerOptions;
      } }), Object.defineProperty(z2, "InvalidPDFException", { enumerable: true, get: function() {
        return f2.InvalidPDFException;
      } }), Object.defineProperty(z2, "LoopbackPort", { enumerable: true, get: function() {
        return $2.LoopbackPort;
      } }), Object.defineProperty(z2, "MissingPDFException", { enumerable: true, get: function() {
        return f2.MissingPDFException;
      } }), Object.defineProperty(z2, "OPS", { enumerable: true, get: function() {
        return f2.OPS;
      } }), Object.defineProperty(z2, "PDFDataRangeTransport", { enumerable: true, get: function() {
        return $2.PDFDataRangeTransport;
      } }), Object.defineProperty(z2, "PDFDateString", { enumerable: true, get: function() {
        return c2.PDFDateString;
      } }), Object.defineProperty(z2, "PDFWorker", { enumerable: true, get: function() {
        return $2.PDFWorker;
      } }), Object.defineProperty(z2, "PasswordResponses", { enumerable: true, get: function() {
        return f2.PasswordResponses;
      } }), Object.defineProperty(z2, "PermissionFlag", { enumerable: true, get: function() {
        return f2.PermissionFlag;
      } }), Object.defineProperty(z2, "PixelsPerInch", { enumerable: true, get: function() {
        return c2.PixelsPerInch;
      } }), Object.defineProperty(z2, "RenderingCancelledException", { enumerable: true, get: function() {
        return c2.RenderingCancelledException;
      } }), Object.defineProperty(z2, "SVGGraphics", { enumerable: true, get: function() {
        return w.SVGGraphics;
      } }), Object.defineProperty(z2, "UNSUPPORTED_FEATURES", { enumerable: true, get: function() {
        return f2.UNSUPPORTED_FEATURES;
      } }), Object.defineProperty(z2, "UnexpectedResponseException", { enumerable: true, get: function() {
        return f2.UnexpectedResponseException;
      } }), Object.defineProperty(z2, "Util", { enumerable: true, get: function() {
        return f2.Util;
      } }), Object.defineProperty(z2, "VerbosityLevel", { enumerable: true, get: function() {
        return f2.VerbosityLevel;
      } }), Object.defineProperty(z2, "XfaLayer", { enumerable: true, get: function() {
        return k2.XfaLayer;
      } }), Object.defineProperty(z2, "build", { enumerable: true, get: function() {
        return $2.build;
      } }), Object.defineProperty(z2, "createPromiseCapability", { enumerable: true, get: function() {
        return f2.createPromiseCapability;
      } }), Object.defineProperty(z2, "createValidAbsoluteUrl", { enumerable: true, get: function() {
        return f2.createValidAbsoluteUrl;
      } }), Object.defineProperty(z2, "getDocument", { enumerable: true, get: function() {
        return $2.getDocument;
      } }), Object.defineProperty(z2, "getFilenameFromUrl", { enumerable: true, get: function() {
        return c2.getFilenameFromUrl;
      } }), Object.defineProperty(z2, "getPdfFilenameFromUrl", { enumerable: true, get: function() {
        return c2.getPdfFilenameFromUrl;
      } }), Object.defineProperty(z2, "getXfaPageViewport", { enumerable: true, get: function() {
        return c2.getXfaPageViewport;
      } }), Object.defineProperty(z2, "isPdfFile", { enumerable: true, get: function() {
        return c2.isPdfFile;
      } }), Object.defineProperty(z2, "loadScript", { enumerable: true, get: function() {
        return c2.loadScript;
      } }), Object.defineProperty(z2, "renderTextLayer", { enumerable: true, get: function() {
        return y2.renderTextLayer;
      } }), Object.defineProperty(z2, "shadow", { enumerable: true, get: function() {
        return f2.shadow;
      } }), Object.defineProperty(z2, "version", { enumerable: true, get: function() {
        return $2.version;
      } });
      var f2 = __w_pdfjs_require__(1), $2 = __w_pdfjs_require__(4), c2 = __w_pdfjs_require__(8), S2 = __w_pdfjs_require__(22), q2 = __w_pdfjs_require__(7), B2 = __w_pdfjs_require__(27), Q2 = __w_pdfjs_require__(15), I2 = __w_pdfjs_require__(3), y2 = __w_pdfjs_require__(30), w = __w_pdfjs_require__(31), k2 = __w_pdfjs_require__(29);
      if (I2.isNodeJS) {
        const { PDFNodeStream: T2 } = __w_pdfjs_require__(32);
        (0, $2.setPDFNetworkStreamFactory)((C2) => new T2(C2));
      } else {
        const { PDFNetworkStream: T2 } = __w_pdfjs_require__(35), { PDFFetchStream: C2 } = __w_pdfjs_require__(36);
        (0, $2.setPDFNetworkStreamFactory)((l) => (0, c2.isValidFetchUrl)(l.url) ? new C2(l) : new T2(l));
      }
    })(), __webpack_exports__;
  })());
})(pdf);
var pdfExports = pdf.exports;
const workerURL = new URL("./pdf.worker.min-99732130.js", import.meta.url).href;
setTimeout(() => {
  pdfExports.GlobalWorkerOptions.workerSrc = workerURL;
});
const transitionImgs = async (z2) => {
  const $2 = await pdfExports.getDocument(z2).promise, c2 = [];
  for (let S2 = 1; S2 <= $2.numPages; S2++) {
    const q2 = await $2.getPage(S2), B2 = q2.getViewport({ scale: 1 }), Q2 = document.createElement("canvas"), I2 = Q2.getContext("2d");
    Q2.height = B2.height, Q2.width = B2.width;
    const y2 = { canvasContext: I2, viewport: B2 };
    await q2.render(y2).promise, c2.push({ imgName: S2 + ".png", storePrivateFullPath: Q2.toDataURL("image/png") });
  }
  return c2;
}, bfWeldingProcessDialog_vue_vue_type_style_index_0_lang = "", bfWeldingProcessDialog_vue_vue_type_style_index_1_scoped_9ecb8c13_lang = "", _hoisted_1$1 = { class: "flex-rbc" }, _hoisted_2 = { class: "dialog-title" }, _hoisted_3 = { class: "wrap" }, _hoisted_4 = { class: "wrap-left" }, _hoisted_5 = { key: 0, class: "product-item" }, _hoisted_6 = ["title", "onClick"], _hoisted_7 = { class: "code-list" }, _hoisted_8 = { class: "card-title" }, _hoisted_9 = { key: 1 }, _sfc_main$1 = { __name: "bf-welding-process-dialog", props: { handleClose: { type: Function }, showDialog: { type: Boolean, default: false }, monomerId: { type: [Number, String], default: void 0 }, areaId: { type: [Number, String], default: void 0 }, productId: { type: [Number, String], default: void 0 } }, setup(z2) {
  const f2 = useStore(), $2 = z2, c2 = ref(false), S2 = ref(false), q2 = ref(false), B2 = ref(false), Q2 = ref(false), I2 = ref([]), y2 = ref(false), w = ref(false), k2 = ref([]), T2 = ref(), C2 = ref(), l = ref(), t = ref([]), s = ref([]), a = ref([]), h = ref({}), b = ref([["startTime", "parse-time"], ["endTime", "parse-time"]]), r = ref(), { getMyChart: n } = useChart({ elementId: "electricityChart", fetchHook: u, initOption: { grid: { top: 40, left: 10, right: 10 }, legend: { show: true }, xAxis: { data: [] }, custom: { title: [{ text: "电流实时曲线图", left: 0, textStyle: { fontSize: 13 } }] }, series: [{ name: "电流(A)", data: [], type: "line", label: { show: false, distance: 0, position: "left" }, itemStyle: { color: "#148a09" } }] } }), { getMyChart: e } = useChart({ elementId: "voltageChart", fetchHook: P, initOption: { grid: { top: 40, left: 10, right: 10 }, legend: { show: true }, xAxis: { data: [] }, custom: { title: [{ text: "电压实时曲线图", left: 0, textStyle: { fontSize: 13 } }] }, series: [{ name: "电压(V)", data: [], type: "line", label: { show: false, distance: 0, position: "right" }, itemStyle: { color: "#22e4ff" } }] } }), { maxHeight: o, fixMaxHeight: v } = useMaxHeight({ mainBox: ".bf-welding-process-dialog", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 600 }, l), m = computed(() => Math.floor((o.value - 40) / 2)), d = computed(() => Math.floor((m.value - 44) / 2)), E = computed(() => f2.getters.globalProject), U = computed(() => {
    var st, it, J, rt;
    const { projectMap: g, monomerMap: A, areaMap: x } = f2.state.project, L = [(it = g == null ? void 0 : g[(st = E.value) == null ? void 0 : st.id]) == null ? void 0 : it.name, (J = A == null ? void 0 : A[$2.monomerId]) == null ? void 0 : J.name];
    return $2.areaId && L.push((rt = x == null ? void 0 : x[$2.areaId]) == null ? void 0 : rt.name), L.join(" > ");
  }), tt = computed(() => t.value.find((g) => g.productId === h.value.productId)), H = computed(() => s.value.find((g) => g.id === h.value.id)), Z = computed(() => {
    var A, x, L;
    let g = `${(A = deepenTypeEnum.VL) == null ? void 0 : A[h.value.productType]}编号：`;
    return t.value.length && (g += `${(x = tt.value) == null ? void 0 : x.productSerialNumber}（${(L = H.value) == null ? void 0 : L.productCodeNumber}）`), g;
  });
  watch(() => $2.showDialog, (g) => {
    c2.value = g, g && (j(), v(), dt());
  });
  function j() {
    var g;
    h.value = { id: void 0, passId: void 0, productId: $2.productId, projectId: (g = E.value) == null ? void 0 : g.id, monomerId: $2.monomerId, areaId: $2.areaId, productType: deepenTypeEnum.ARTIFACT.V }, t.value = [], s.value = [], a.value = [];
  }
  function V(g = {}) {
    h.value.productId !== g.productId && (h.value.productId = g.productId, bt(), O());
  }
  function X(g = {}) {
    h.value.id !== g.id && (h.value.id = g.id, N());
  }
  function at(g = {}) {
    h.value.passId !== g.passId && (h.value.passId = g.passId, p());
  }
  async function dt() {
    var g;
    t.value = [], s.value = [], a.value = [];
    try {
      if (S2.value = true, t.value = await getProductList(h.value), t.value.findIndex((x) => x.productId === h.value.productId) === -1) V((g = t.value) == null ? void 0 : g[0]);
      else {
        const x = t.value.find((L) => L.productId === h.value.productId);
        x && (h.value.productId = void 0, V(x));
      }
    } catch (A) {
      console.error("获取焊接工艺产品列表失败", A);
    } finally {
      S2.value = false;
    }
  }
  async function bt() {
    var g;
    s.value = [], a.value = [], h.value.id = void 0;
    try {
      q2.value = true, s.value = await getCodeList(h.value), X((g = s.value) == null ? void 0 : g[0]);
    } catch (A) {
      console.error("获取焊接工艺产品码号列表失败", A);
    } finally {
      q2.value = false;
    }
  }
  async function N() {
    var g, A, x;
    a.value = [];
    try {
      B2.value = true, (await getWeldingList({ ...h.value, productSerialNumber: (g = tt.value) == null ? void 0 : g.productSerialNumber })).forEach((it) => {
        it.cappCraftCardPassVOS = it.cappCraftCardPassVOS || [{}], it.cappCraftCardPassVOS.forEach((J, rt) => {
          J.rowspan = 0, rt === 0 && (J.rowspan = it.cappCraftCardPassVOS.length), a.value.push({ ...it, ...J });
        });
      });
      const st = ((A = a.value) == null ? void 0 : A[0]) || {};
      at(st), (x = C2.value) == null || x.setCurrentRow(st);
    } catch (L) {
      console.error("获取焊接工艺焊缝列表失败", L);
    } finally {
      B2.value = false;
    }
  }
  async function p(g) {
    w.value = true, k2.value = [];
    try {
      h.value.passId && (k2.value = await getVoltageList({ passId: h.value.passId }) || []);
    } catch (A) {
      console.log(A, "获取差异分析柱状图失败");
    } finally {
      w.value = false, u(), P();
    }
  }
  async function u(g) {
    var L, st;
    const A = g || n(), x = A.getOption();
    x.xAxis[0].data = (L = k2.value) == null ? void 0 : L.map((it) => parseTime(it.createTime)), x.series[0].data = (st = k2.value) == null ? void 0 : st.map((it) => it.electricity), A.setOption(x);
  }
  async function P(g) {
    var L, st;
    const A = g || e(), x = A.getOption();
    x.xAxis[0].data = (L = k2.value) == null ? void 0 : L.map((it) => parseTime(it.createTime)), x.series[0].data = (st = k2.value) == null ? void 0 : st.map((it) => it.voltage), A.setOption(x);
  }
  let F = new AbortController(), D = 0;
  async function O() {
    var g, A, x, L;
    try {
      F.abort(), F = new AbortController();
      const st = ++D;
      Q2.value = true, I2.value = [];
      const it = { ...h.value, projectType: (g = E.value) == null ? void 0 : g.projectType, serialNumber: (A = tt.value) == null ? void 0 : A.productSerialNumber };
      if (((x = h.value) == null ? void 0 : x.productType) === deepenTypeEnum.ARTIFACT.V) {
        const { boolExist: ot, numbers: ut } = await getDrawingNumber(it);
        ot && (I2.value = ut);
      }
      it.number = I2.value;
      const J = await previewPDF(it, { signal: F.signal });
      if (J.headers["content-disposition"]) {
        const ot = J.headers["content-disposition"].split("=")[1].split(".");
        if (ot[ot.length - 1] !== "pdf") throw new Error("非.pdf格式");
      } else throw new Error("获取文件格式失败");
      const rt = await Y(J);
      if (st !== D) return;
      const et = await transitionImgs(rt);
      if (st !== D) return;
      r.value = (L = et[0]) == null ? void 0 : L.storePrivateFullPath;
    } catch (st) {
      if (st.name === "AbortError" || st.message === "abort") return;
      console.log("获取图纸", st), r.value = null;
    } finally {
      Q2.value = false;
    }
  }
  function Y(g) {
    return new Promise((A, x) => {
      if (g && g.data && g.data.size) {
        const L = g.data, st = new window.FileReader();
        st.readAsArrayBuffer(L), st.onload = function(it) {
          const J = it.target.result, rt = L.type, et = new Blob([J], { type: rt }), ot = window.URL.createObjectURL(et);
          A(ot);
        };
      } else x();
    });
  }
  function K() {
    y2.value = true;
  }
  function i({ row: g, column: A, rowIndex: x, columnIndex: L }) {
    if (["weldingSerialNumber", "techCappCraftCardStorehouseSerialNumber", "weldingBaseWeldingPosition"].includes(A.property)) return { rowspan: g.rowspan || 0, colspan: 1 };
  }
  function _(g) {
    const A = g.deltaY || g.detail || g.wheelDelta;
    T2.value.wrapRef.scrollLeft += A > 0 ? 30 : -30;
  }
  return (g, A) => {
    const x = ElTag, L = ElButton, st = ElScrollbar, it = ElTableColumn, J = ElCard, rt = ElImage, et = ElDialog, ot = vLoading;
    return openBlock(), createBlock(et, { ref_key: "dialogRef", ref: l, modelValue: c2.value, "onUpdate:modelValue": A[2] || (A[2] = (ut) => c2.value = ut), fullscreen: true, "show-close": false, "before-close": $2.handleClose, class: "bf-welding-process-dialog" }, { header: withCtx(() => [createBaseVNode("div", _hoisted_1$1, [createBaseVNode("div", _hoisted_2, [A[3] || (A[3] = createBaseVNode("span", { class: "title" }, " WPS焊接工艺 ", -1)), createVNode(x, { effect: "plain" }, { default: withCtx(() => [createTextVNode(toDisplayString(U.value), 1)]), _: 1 })]), createVNode(L, { size: "default", onClick: $2.handleClose }, { default: withCtx(() => A[4] || (A[4] = [createTextVNode(" 关闭 ")])), _: 1, __: [4] }, 8, ["onClick"])])]), default: withCtx(() => {
      var ut, M;
      return [createBaseVNode("div", _hoisted_3, [createBaseVNode("div", _hoisted_4, [createVNode(unref(_sfc_main$5), { modelValue: h.value.productType, "onUpdate:modelValue": A[0] || (A[0] = (ht) => h.value.productType = ht), options: unref(deepenTypeEnum).ENUM, unshowVal: [unref(deepenTypeEnum).MACHINE_PART.V], type: "enum", onChange: dt }, null, 8, ["modelValue", "options", "unshowVal"]), withDirectives((openBlock(), createElementBlock("div", { class: "product-list", style: normalizeStyle({ maxHeight: unref(o) - 40 + "px" }) }, [t.value.length ? createCommentVNode("", true) : (openBlock(), createElementBlock("div", _hoisted_5, "暂无数据")), (openBlock(true), createElementBlock(Fragment, null, renderList(t.value, (ht) => (openBlock(), createElementBlock("div", { key: ht.productId, class: normalizeClass(["product-item pointer ellipsis-text", { active: ht.productId === h.value.productId }]), title: ht.productSerialNumber, onClick: (yt) => V(ht) }, toDisplayString(ht.productSerialNumber), 11, _hoisted_6))), 128))], 4)), [[ot, S2.value]])]), createBaseVNode("div", { class: "wrap-right", style: normalizeStyle({ height: unref(o) + "px" }) }, [createVNode(st, { ref_key: "scrollbarRef", ref: T2, class: "tag-scroll-container", onWheel: _ }, { default: withCtx(() => [withDirectives((openBlock(), createElementBlock("div", _hoisted_7, [s.value.length ? createCommentVNode("", true) : (openBlock(), createBlock(x, { key: 0, effect: "plain", size: "large", "disable-transitions": "", class: "code-item" }, { default: withCtx(() => A[5] || (A[5] = [createTextVNode("暂无数据")])), _: 1, __: [5] })), (openBlock(true), createElementBlock(Fragment, null, renderList(s.value, (ht) => (openBlock(), createBlock(x, { effect: `${ht.id === h.value.id ? "dark" : "plain"}`, "disable-transitions": "", key: ht.id, size: "large", class: "code-item pointer", onClick: (yt) => X(ht) }, { default: withCtx(() => [createTextVNode(toDisplayString(ht.productCodeNumber), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))])), [[ot, q2.value]])]), _: 1 }, 512), createBaseVNode("div", { class: "card-wrap", style: normalizeStyle({ height: m.value + "px" }) }, [createVNode(J, { class: "welding-list", "body-style": { padding: "10px" } }, { default: withCtx(() => [createBaseVNode("div", _hoisted_8, toDisplayString(Z.value), 1), withDirectives((openBlock(), createBlock(unref(_sfc_main$6), { ref_key: "tableRef", ref: C2, data: a.value, "max-height": m.value - 54, "data-format": b.value, "empty-text": "暂无数据", rowKey: "passId", "highlight-current-row": "", "span-method": i, onRowClick: at }, { default: withCtx(() => [createVNode(it, { label: "序号", type: "index", align: "center", width: "55" }), createVNode(it, { label: "焊缝编号", prop: "weldingSerialNumber", key: "weldingSerialNumber", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), createVNode(it, { label: "工艺编号	", prop: "techCappCraftCardStorehouseSerialNumber", key: "techCappCraftCardStorehouseSerialNumber", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), createVNode(it, { label: "焊接位置", prop: "weldingBaseWeldingPosition", key: "weldingBaseWeldingPosition", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), createVNode(it, { label: "道次", prop: "passName", key: "passName", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), createVNode(it, { key: "equimentName", prop: "equimentName", align: "center", label: "设备名称", "min-width": "100px", "show-overflow-tooltip": "" }), createVNode(it, { label: "设备编号", prop: "equimentCode", key: "equimentCode", align: "center", width: "160", "show-overflow-tooltip": "" }), createVNode(it, { label: "实际操作人", prop: "weldUserName", key: "weldUserName", align: "center", width: "100", "show-overflow-tooltip": "" }), createVNode(it, { label: "开始时间", prop: "startTime", key: "startTime", align: "center", width: "130", "show-overflow-tooltip": "" }), createVNode(it, { label: "结束时间", prop: "endTime", key: "endTime", align: "center", width: "130", "show-overflow-tooltip": "" }), createVNode(it, { label: "时长(h:m)", prop: "actualTime", key: "actualTime", align: "center", width: "90", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[ot, B2.value]])]), _: 1 }), withDirectives((openBlock(), createBlock(J, { class: "drawing", "body-style": { padding: "10px" } }, { default: withCtx(() => [createBaseVNode("div", { style: normalizeStyle({ height: m.value - 20 + "px" }) }, [r.value ? (openBlock(), createBlock(rt, { key: 0, src: r.value, alt: "图纸", class: "pointer", onDblclick: K }, null, 8, ["src"])) : (openBlock(), createElementBlock("span", _hoisted_9, "暂无图纸"))], 4)]), _: 1 })), [[ot, Q2.value]])], 4), withDirectives((openBlock(), createBlock(J, { "body-style": { padding: "10px", height: d.value + "px" } }, { default: withCtx(() => A[6] || (A[6] = [createBaseVNode("div", { id: "electricityChart", style: { width: "100%", height: "100%" } }, null, -1)])), _: 1, __: [6] }, 8, ["body-style"])), [[ot, w.value]]), withDirectives((openBlock(), createBlock(J, { "body-style": { padding: "10px", height: d.value + "px" } }, { default: withCtx(() => A[7] || (A[7] = [createBaseVNode("div", { id: "voltageChart", style: { width: "100%", height: "100%" } }, null, -1)])), _: 1, __: [7] }, 8, ["body-style"])), [[ot, w.value]])], 4)]), createVNode(unref(_sfc_main$4), { modelValue: y2.value, "onUpdate:modelValue": A[1] || (A[1] = (ht) => y2.value = ht), drawingSN: I2.value, monomerId: $2.monomerId, productId: h.value.productId, productType: h.value.productType, projectType: (ut = E.value) == null ? void 0 : ut.projectType, serialNumber: (M = tt.value) == null ? void 0 : M.productSerialNumber }, null, 8, ["modelValue", "drawingSN", "monomerId", "productId", "productType", "projectType", "serialNumber"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, weldingProcess = _export_sfc(_sfc_main$1, [["__scopeId", "data-v-9ecb8c13"]]);
function useWeldingProcess() {
  const z2 = ref();
  async function f2() {
    const S2 = createApp(weldingProcess);
    S2.use(store);
    const q2 = document.querySelector(".bf-container"), B2 = document.createElement("div");
    B2.id = "bfWeldingProcessView", q2.appendChild(B2), S2.mount(B2), z2.value = S2, await nextTick();
  }
  function $2() {
    z2.value._container._vnode.component.props.showDialog = false;
  }
  async function c2({ productId: S2, monomerId: q2, areaId: B2 }) {
    z2.value || await f2();
    const Q2 = z2.value._container._vnode.component.props;
    Q2.showDialog = true, Q2.handleClose = $2, Q2.productId = S2, Q2.monomerId = q2, Q2.areaId = B2;
  }
  return { createWeldingProcess: f2, fetchWeldingProcess: c2 };
}
function usePreview({ props: z2, modelStatus: f2, initModelColor: $2, overrideComponentsColorById: c2, isolateComponentsById: S2, isBridgeProject: q2 }) {
  const B2 = ref();
  watch(() => z2.serialNumber, (I2) => {
    z2.isPreview && I2 && !z2.previewShowAll && Q2();
  }, { immediate: true });
  async function Q2() {
    const I2 = ElLoading.service({ target: "#modelView", lock: true, text: "请稍后，正在染色", fullscreen: false });
    if (z2.serialNumber) try {
      const y2 = await getArtifactSearch({ serialNumber: z2.serialNumber, fileId: f2.value.fileId, productType: z2.productType });
      $2(), c2(y2, { color: "#1682e6", opacity: 1 }), S2(y2), B2.value = y2;
    } catch (y2) {
      console.log("构件编号预览染色错误", y2);
    } finally {
      I2.close();
    }
  }
  return { serialNumberElementIds: B2 };
}
const bimModelView_vue_vue_type_style_index_0_scoped_e583eb98_lang = "", bimModelView_vue_vue_type_style_index_1_lang = "", _hoisted_1 = { key: 1, id: "modelView" }, _sfc_main = { __name: "bim-model-view", props: { monomerId: { type: Number }, areaId: { type: [Number, String] }, projectId: { type: Number }, showMonomerModel: { type: Boolean, default: true }, maxHeight: { type: Number }, tracePage: { type: Boolean, default: false }, isPreview: { type: Boolean, default: false }, visible: { type: Boolean, default: false }, isMobile: { type: Boolean, default: false }, isBridge: { type: Boolean, default: false }, previewShowAll: { type: Boolean, default: false }, serialNumber: { type: String }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, monomerName: { type: String }, modelElementIds: { type: Array, default: void 0 }, projectName: { type: String } }, setup(z2, { expose: f2 }) {
  const { globalProject: $2 } = mapGetters(["globalProject"]), c2 = z2, S2 = "/assets", q2 = { PROCESSING_NO: { L: "3D模型未集成", K: "PROCESSING_NO", V: "processing_no", T: "warning" }, PROCESSING: { L: "3D模型正在转换，请稍后刷新重试", K: "PROCESSING", V: "processing", T: "warning" }, SUCCESS: { L: "成功", K: "SUCCESS", V: "success", T: "success" }, FAILED: { L: "3D模型转换失败，请联系管理员或重新上传", K: "FAILED", V: "failed", T: "danger" }, QUERY: { L: "查询中...", K: "QUERY", V: "query", T: "primary" }, UNEXIST: { L: "未上传3D模型", K: "UNEXIST", V: "unexist", T: "info" }, UPLOAD_PROCESSING: { L: "模型正在上传", K: "UPLOAD_PROCESSING", V: "uploadProcessing", T: "warning" }, UPLOAD_SUCCESS: { L: "模型未转换", K: "UPLOAD_SUCCESS", V: "uploadSuccess", T: "info" }, UPLOAD_FAILED: { L: "模型上传失败", K: "UPLOAD_FAILED", V: "uploadFailed", T: "danger" } };
  constantize(q2);
  const B2 = ref(false), Q2 = ref(q2.QUERY.V), I2 = ref({ reason: "", status: "success", viewToken: "" }), y2 = ref(), w = ref(), k2 = ref(), T2 = computed(() => I2.value.modelType === "integration" ? modelIntegrationStatusEnum : q2), C2 = computed(() => {
    var it;
    return ((it = $2.value) == null ? void 0 : it.projectType) === projectTypeEnum.BRIDGE.V || c2.isBridge;
  }), l = reactive({ panelPositions: {}, proTree: { config: null, panel: null }, artifactListByArea: { config: null, panel: null }, artifactInfo: { config: null, panel: null }, drawing: { config: null, panel: null }, machinePartList: { config: null, panel: null }, statusInfo: { config: null, panel: null }, logistics: { config: null, panel: null }, shipment: { config: null, panel: null }, colorCard: { config: null, panel: null } }), t = ref({}), s = ref([]), a = ref(), h = ref({});
  function b() {
    const it = document.getElementById("modelView");
    return console.log(it.clientHeight, it.clientWidth, "getModelViewSize"), { width: it.clientWidth, height: it.clientHeight };
  }
  const { initModelColor: r, fetchArtifactStatus: n, addBlinkByIds: e, removeBlink: o, isolateComponentsById: v, clearIsolation: m, hideComponentsById: d, showComponentsById: E, overrideComponentsColorById: U, setSelectedComponentsByObjectData: tt, clearSelectedComponents: H, zoomToComponentsById: Z } = useArtifactColoring({ props: c2, bimModel, modelStatus: I2, viewer: w, colors: s, objectIdGroup: h, isBridgeProject: C2 }), { createDrawing: j, fetchDrawing: V } = useDrawing(), { fetchWeldingProcess: X } = useWeldingProcess(), { createArtifactInfoPanel: at, fetchArtifactInfo: dt, clearArtifactInfoPanel: bt } = useArtifactInfo({ props: c2, menuBar: a, bimModel, viewer: w, viewerPanel: l, modelStatus: I2, fetchDrawing: V, fetchWeldingProcess: X, addBlinkByIds: e, isBridgeProject: C2 }), { createStatusInfoPanel: N, fetchStatusInfo: p, clearStatusInfoPanel: u } = useStatusInfo({ props: c2, menuBar: a, bimModel, viewerPanel: l, modelStatus: I2, isBridgeProject: C2 }), { createProTreePanel: P, clearProTreePanel: F, fetchProTree: D } = useProjectTreePanel({ props: c2, bimModel, modelStatus: I2, viewerPanel: l, viewProAreaTree: t, fetchWeldingProcess: X, setSelectedComponentsByObjectData: tt, clearSelectedComponents: H, addBlinkByIds: e, removeBlink: o, getModelViewSize: b, isBridgeProject: C2 }), { createLogisticsBtn: O, hideLogisticsBtn: Y } = useLogisticsInfo({ props: c2, modelStatus: I2, bimModel, viewerPanel: l, monomerId: computed(() => c2.monomerId), addBlinkByIds: e, removeBlink: o, isBridgeProject: C2 }), { createMyToolbar: K } = useMyToolbar({ menuBar: a, publicPath: S2, bimModel, viewerPanel: l, viewProAreaTree: t, colors: s, isMobile: c2.isMobile, createLogisticsBtn: O, hideLogisticsBtn: Y, clearProTreePanel: F, fetchProTree: D, clearArtifactInfoPanel: bt, fetchArtifactInfo: dt, clearStatusInfoPanel: u, fetchStatusInfo: p, clearSelectedComponents: H }), { createSearchHtml: i, searchBySN: _ } = useArtifactSearch({ props: c2, modelStatus: I2, addBlinkByIds: e, removeBlink: o, isBridgeProject: C2 }), { createColorCardHtml: g } = useColorCard({ props: c2, isMobile: c2.isMobile, menuBar: a, colors: s, objectIdGroup: h, bimModel, viewerPanel: l, modelStatus: I2, searchBySN: _, fetchArtifactStatus: n, isolateComponentsById: v, clearIsolation: m, hideComponentsById: d, showComponentsById: E, overrideComponentsColorById: U, isBridgeProject: C2 }), A = ref([]);
  watch(() => [c2.monomerId, c2.showMonomerModel, c2.projectId, c2.areaId], () => {
    L(c2.monomerId);
  }, { immediate: true }), watch(() => c2.visible, (it) => {
    it && L(c2.monomerId);
  }, { immediate: true });
  function x() {
    I2.value = { reason: "", status: "success", viewToken: "" }, a.value = null, s.value = [];
  }
  async function L(it) {
    if (!(c2.showMonomerModel && !it) && !(!c2.showMonomerModel && !c2.projectId) && !(c2.isPreview && !c2.visible)) {
      B2.value = false, Q2.value = q2.QUERY.V, x();
      try {
        if (c2.showMonomerModel) {
          const { viewToken: J, reason: rt, status: et, fileId: ot, modelType: ut, integrationStatus: M } = await getTranslate(it, c2.areaId);
          I2.value = { fileId: ot, viewToken: J, reason: rt, status: et, modelType: ut, integrationStatus: M }, Q2.value = ut === "file" ? et : M;
        } else {
          const { viewToken: J, reason: rt, status: et, fileId: ot } = await getIMTranslate(c2.projectId);
          I2.value = { fileId: ot, viewToken: J, reason: rt, status: et }, Q2.value = et;
        }
        Q2.value === modelTranslateStatusEnum.SUCCESS.V && st(I2.value.viewToken);
      } catch (J) {
        console.log("获取模型viewToken", J);
      }
    }
  }
  async function st(it) {
    try {
      const J = await initBimfaceApp({ viewToken: it });
      k2.value = getConfig(), k2.value.Toolbars = ["MainToolbar"], c2.tracePage && (k2.value.enableViewHouse = false), (c2.isPreview || c2.tracePage) && (k2.value.Buttons = ["Home", "FullScreen"]);
      const rt = document.getElementById("modelView");
      rt.innerHTML = "", k2.value.domElement = rt;
      const et = getApp(k2.value);
      J.viewToken ? et.addView(J.viewToken) : et.addModel(J), console.log(et, "app"), w.value = et.getViewer(), console.log(w, "_viewer"), y2.value = getViewer3DEvent(), w.value.addEventListener(y2.value.ViewAdded, async () => {
        if (!c2.isPreview) l.panelPositions = getPanelPositions(), K(), at(), P(), N(), i(), g();
        else if (c2.tracePage) c2.modelElementIds && c2.modelElementIds.length > 0 && (v(c2.modelElementIds), Z(c2.modelElementIds));
        else {
          c2.isMobile && (l.panelPositions = getPanelPositions(), at(), K(), N(), g());
          const { serialNumberElementIds: ot } = usePreview({ props: c2, modelStatus: I2, initModelColor: r, overrideComponentsColorById: U, isolateComponentsById: v, isBridgeProject: C2 });
          A.value = ot;
        }
        j(), window.onresize = function() {
          w.value.resize(document.documentElement.clientWidth, document.documentElement.clientHeight - 40), w.value.clearSelectedComponents();
        }, r(), B2.value = true;
      }, { passive: false }), console.log(y2, "_viewer3DEvent"), w.value.addEventListener(y2.value.ComponentsSelectionChanged, (ot) => {
        if (console.log(ot, "ComponentsSelectionChanged"), a.value && a.value !== modelMenuBarEnum.PROJECT_TREE.V) {
          const ut = w.value.getSelectedComponents();
          isBlank(ut) ? bt() : dt(ut[0]);
        }
      }, { passive: false });
    } catch (J) {
      console.log(J);
    }
  }
  return f2({ modelLoaded: B2, clearIsolation: m, isolateComponentsById: v, previewSNElementIds: A }), (it, J) => {
    var et;
    const rt = ElTag;
    return openBlock(), createElementBlock("div", { class: "model-container", style: normalizeStyle({ height: `${z2.maxHeight}px` }) }, [Q2.value !== T2.value.SUCCESS.V ? (openBlock(), createBlock(rt, { key: 0, type: (et = T2.value.V[Q2.value]) == null ? void 0 : et.T, style: normalizeStyle(z2.isPreview || !z2.showMonomerModel ? "margin-left: 10px;margin-top: 10px;" : "") }, { default: withCtx(() => [createTextVNode(toDisplayString(T2.value.VL[Q2.value]) + " " + toDisplayString(I2.value.reason), 1)]), _: 1 }, 8, ["type", "style"])) : createCommentVNode("", true), Q2.value === T2.value.SUCCESS.V ? (openBlock(), createElementBlock("div", _hoisted_1)) : createCommentVNode("", true)], 4);
  };
} }, bimModelView = _export_sfc(_sfc_main, [["__scopeId", "data-v-e583eb98"]]);
export {
  bimModelView as b
};
