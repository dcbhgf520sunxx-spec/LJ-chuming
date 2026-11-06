import { ref as n } from "vue";
import { reactive as X } from "vue";
import { provide as Y } from "vue";
import { inject as g } from "vue";
import { computed as Z } from "vue";
import { watch as y } from "vue";
import { nextTick as b } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as x } from "vue";
import { unref as o } from "vue";
import { createVNode as m } from "vue";
import { withCtx as f } from "vue";
import { Fragment as B } from "vue";
import { renderList as ee } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as R } from "vue";
import { createCommentVNode as w } from "vue";
import { createBlock as A } from "vue";
import { resolveDynamicComponent as te } from "vue";
import { normalizeStyle as ae } from "vue";
import { ElMessage as le } from "element-plus";
import { ElRadioButton as se } from "element-plus";
import { ElRadioGroup as ie } from "element-plus";
import { ElForm as oe } from "element-plus";
import { am as S, cP as p, o as C, cQ as re } from "../../../../../../../shared/runtime.js";
import ne from "./module/steel-plate.vue.js";
import ue from "./module/section-steel.vue.js";
import ce from "./module/other.vue.js";
import me from "./module/edit-table.vue.js";
import fe from "./module/steel-coil.vue.js";
import de from "./module/other-steel-material.vue.js";
import Le from "./module/auxiliary-material.vue.js";
import _e from "./module/gas.vue.js";
const pe = { class: "steel-requisitions-application-container" }, he = { class: "filter-container" }, ve = { key: 0, class: "filter-left-box" }, xe = { class: "filter-right-box" }, Ce = { __name: "index", setup(Se, { expose: H }) {
  var V;
  const i = { steelPlateList: { K: "steelPlateList", L: "钢板", V: S.STEEL_PLATE.V, TABLE: ne }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: S.STEEL_COIL.V, TABLE: fe }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: S.SECTION_STEEL.V, TABLE: ue }, otherSteelMaterialList: { K: "otherSteelMaterialList", L: "其它钢材", V: p.OTHER_STEEL_MATERIALS.V, TABLE: de }, auxiliaryMaterialList: { K: "auxiliaryMaterialList", L: "辅材", V: p.MATERIAL.V, TABLE: Le }, gasList: { K: "gasList", L: "气体", V: p.GAS.V, TABLE: _e }, otherList: { K: "otherList", L: "办公用品", V: p.OTHER.V, TABLE: ce } }, h = n(), K = n(), E = n(), u = n(), r = n(), d = n([]), L = n(), s = X({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null, auxiliaryMaterialList: null, gasList: null, otherList: null });
  Y("matSpecRef", u);
  const e = (V = g("crud")) == null ? void 0 : V.form, _ = g("crud"), { maxHeight: P, maxHeightStyle: $ } = C({ mainBox: ".steel-requisitions-application-container", extraBox: [".el-drawer__header", ".filter-container"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 130 }), { maxHeight: k } = C({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => E.value.loaded), I = Z(() => {
    var t;
    return _.status.edit ? me : ((t = i == null ? void 0 : i[r.value]) == null ? void 0 : t.TABLE) || i.steelPlateList.TABLE;
  });
  y(r, (t) => {
    var a;
    d.value = e[t], e.currentBasicClass = (a = i[t]) == null ? void 0 : a.V, t && b(() => {
      s[t] || (s[t] = h.value);
    });
  }, { immediate: true }), y(d, (t) => {
    e[r.value] = t;
  }, { deep: true });
  function N() {
    b(() => {
      s.steelPlateList = null, s.sectionSteelList = null, s.steelCoilList = null, s.otherSteelMaterialList = null, s.auxiliaryMaterialList = null, s.gasList = null, s.otherList = null, r.value = i.steelPlateList.K, u.value && u.value.clear();
    });
  }
  function O() {
    e.list = [], e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [], e.otherSteelMaterials = [], e.auxiliaryMaterialList = [], e.gasList = [], e.otherList = [], u.value && u.value.clear();
  }
  function U(t) {
    return h.value.rowInit(t);
  }
  async function j() {
    L.value = true;
  }
  function q() {
    return Object.keys(s).every((t) => {
      var a;
      return s[t] ? (a = s[t]) == null ? void 0 : a.validate() : true;
    });
  }
  function z() {
    const t = q();
    if (!_.status.edit && t && (e.list = [...e.steelPlateList, ...e.sectionSteelList, ...e.steelCoilList, ...e.otherSteelMaterialList, ...e.auxiliaryMaterialList, ...e.gasList, ...e.otherList], !e.list.length)) {
      le.error("请添加数据");
      return;
    }
    return true;
  }
  return N(), H({ form: e, validate: z, clearList: O }), (t, a) => {
    const D = se, F = ie, G = T("common-button"), Q = oe, J = T("common-drawer");
    return c(), v(B, null, [x("div", pe, [x("div", he, [o(_).status.edit ? w("", true) : (c(), v("div", ve, [m(F, { modelValue: r.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => r.value = l), class: "filter-item", size: "default" }, { default: f(() => [(c(), v(B, null, ee(i, (l) => m(D, { key: l.K, label: l.K }, { default: f(() => [M(R(l.L) + R(o(e)[l.K] && o(e)[l.K].length ? `(${o(e)[l.K].length})` : ""), 1)]), _: 2 }, 1032, ["label"])), 64))]), _: 1 }, 8, ["modelValue"])])), x("div", xe, [o(_).status.edit ? w("", true) : (c(), A(G, { key: 0, class: "filter-item", type: "success", onClick: j }, { default: f(() => a[3] || (a[3] = [M(" 添加物料 ")])), _: 1, __: [3] }))])]), m(Q, { ref_key: "formRef", ref: K, model: o(e) }, { default: f(() => [(c(), A(te(I.value), { ref_key: "tableRef", ref: h, "max-height": o(P), style: ae(o($)) }, null, 8, ["max-height", "style"]))]), _: 1 }, 8, ["model"])]), m(J, { ref_key: "drawerRef", ref: E, modelValue: L.value, "onUpdate:modelValue": a[2] || (a[2] = (l) => L.value = l), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: f(() => {
      var l;
      return [m(re, { ref_key: "matSpecRef", ref: u, modelValue: d.value, "onUpdate:modelValue": a[1] || (a[1] = (W) => d.value = W), "basic-class": (l = i == null ? void 0 : i[r.value]) == null ? void 0 : l.V, "max-height": o(k), "row-init-fn": U, "table-width": 350, visible: L.value, "auto-selected": "", "expand-query": "", "is-push": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])];
    }), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Ce as default
};
