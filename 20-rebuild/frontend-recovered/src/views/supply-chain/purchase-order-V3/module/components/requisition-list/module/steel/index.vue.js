import { ref as E } from "vue";
import { reactive as f } from "vue";
import { provide as k } from "vue";
import { computed as C } from "vue";
import { watch as A } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as m } from "vue";
import { withCtx as V } from "vue";
import { toDisplayString as j } from "vue";
import { createCommentVNode as b } from "vue";
import { unref as T } from "vue";
import { createTextVNode as y } from "vue";
import { withModifiers as g } from "vue";
import { createBlock as z } from "vue";
import { mergeProps as I } from "vue";
import { resolveDynamicComponent as R } from "vue";
import { Fragment as $ } from "vue";
import { ElInput as B } from "element-plus";
import { sl as t, j_ as D } from "../../../../../../../../shared/runtime.js";
import F from "./module/steel-plate-table.vue.js";
import W from "./module/section-steel-table.vue.js";
import q from "./module/steel-coil-table.vue.js";
import H from "./module/other-steel-material-table.vue.js";
const G = { class: "head-container" }, J = { key: 0 }, Q = { key: 0 }, ae = { __name: "index", setup(X, { expose: x }) {
  const d = E(), n = E(t.STEEL_PLATE.V), r = { [t.STEEL_PLATE.K]: "steelPlateList", [t.SECTION_STEEL.K]: "sectionSteelList", [t.STEEL_COIL.K]: "steelCoilList", [t.OTHER_STEEL_MATERIALS.K]: "otherSteelMaterialList" }, i = f({ steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [] }), c = f({ steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [] }), l = E({});
  k("bcListObj", i);
  const O = C(() => {
    var e, a;
    const s = [];
    for (const u in t.ENUM) (e = i[r[u]]) != null && e.length || s.push(t[u].V);
    return s.length === ((a = Object.keys(t.ENUM)) == null ? void 0 : a.length) ? [] : s;
  }), w = C(() => {
    switch (n.value) {
      case t.STEEL_PLATE.V:
        return F;
      case t.SECTION_STEEL.V:
        return W;
      case t.STEEL_COIL.V:
        return q;
      default:
        return H;
    }
  });
  A(() => d, () => {
    d.value && L();
  }, { immediate: true, deep: true });
  function L() {
    i[r[t.VK[n.value]]].forEach((s) => {
      d.value.rowWatch(s);
    });
  }
  function K() {
    const e = c[r[t.VK[n.value]]].filter((a) => (l.value.purchaseSN ? a.purchaseSN.indexOf(l.value.purchaseSN) > -1 : true) && (l.value.classifyName ? a.classifyName.indexOf(l.value.classifyName) > -1 : true) && (l.value.serialNumber ? a.serialNumber.indexOf(l.value.serialNumber) > -1 : true) && (l.value.specification ? a.specification.indexOf(l.value.specification) > -1 : true));
    i[r[t.VK[n.value]]] = [...e], L();
  }
  function h() {
    l.value = {};
    for (const s in r) i[r[s]] = c[r[s]];
  }
  function P() {
    h();
  }
  function M(s) {
    if (l.value = {}, i.sectionSteelList = [], i.steelPlateList = [], i.steelCoilList = [], i.otherSteelMaterialList = [], c.sectionSteelList = [], c.steelPlateList = [], c.steelCoilList = [], c.otherSteelMaterialList = [], n.value = t.STEEL_PLATE.V, !(s != null && s.length)) return;
    let e = t.STEEL_PLATE.V;
    s.forEach((a, u) => {
      i[r[t.VK[a.basicClass]]].push(f(a)), c[r[t.VK[a.basicClass]]].push(f(a)), e = a.basicClass < e || u === 0 ? a.basicClass : e;
    }), n.value = e, L();
  }
  return x({ initList: M }), (s, e) => {
    const a = N("common-radio-button"), u = B, v = N("common-button");
    return p(), _($, null, [U("div", G, [m(a, { type: "enum", modelValue: n.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => n.value = o), options: T(t).ENUM, disabledVal: O.value, clearable: "", class: "filter-item", onChange: h }, { suffix: V(({ item: o }) => {
      var S;
      return [(S = i[r[o.K]]) != null && S.length ? (p(), _("span", J, "(" + j(i[r[o.K]].length) + ")", 1)) : b("", true)];
    }), _: 1 }, 8, ["modelValue", "options", "disabledVal"]), n.value && !(n.value & T(D).MANUFACTURED.V) ? (p(), _("div", Q, [m(u, { modelValue: l.value.purchaseSN, "onUpdate:modelValue": e[1] || (e[1] = (o) => l.value.purchaseSN = o), placeholder: "申购单号", class: "filter-item", style: { width: "180px" }, size: "small", clearable: "" }, null, 8, ["modelValue"]), m(u, { modelValue: l.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (o) => l.value.serialNumber = o), placeholder: "编号", class: "filter-item", style: { width: "180px" }, size: "small", clearable: "" }, null, 8, ["modelValue"]), m(u, { modelValue: l.value.classifyName, "onUpdate:modelValue": e[3] || (e[3] = (o) => l.value.classifyName = o), placeholder: "物料种类", class: "filter-item", style: { width: "180px" }, size: "small", clearable: "" }, null, 8, ["modelValue"]), m(u, { modelValue: l.value.specification, "onUpdate:modelValue": e[4] || (e[4] = (o) => l.value.specification = o), placeholder: "规格", class: "filter-item", style: { width: "180px" }, size: "small", clearable: "" }, null, 8, ["modelValue"]), m(v, { class: "filter-item", size: "small", type: "success", icon: "el-icon-search", onClick: g(K, ["stop"]) }, { default: V(() => e[5] || (e[5] = [y("搜索")])), _: 1, __: [5] }), m(v, { class: "filter-item", size: "small", type: "warning", icon: "el-icon-refresh", onClick: g(P, ["stop"]) }, { default: V(() => e[6] || (e[6] = [y("重置")])), _: 1, __: [6] })])) : b("", true)]), n.value ? (p(), z(R(w.value), I({ key: 0, ref_key: "compRef", ref: d }, s.$attrs), null, 16)) : b("", true)], 64);
  };
} };
export {
  ae as default
};
