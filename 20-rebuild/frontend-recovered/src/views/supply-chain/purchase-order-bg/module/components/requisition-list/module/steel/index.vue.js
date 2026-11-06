import { ref as V } from "vue";
import { reactive as f } from "vue";
import { provide as U } from "vue";
import { computed as N } from "vue";
import { watch as A } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as c } from "vue";
import { withCtx as _ } from "vue";
import { toDisplayString as z } from "vue";
import { createCommentVNode as b } from "vue";
import { unref as y } from "vue";
import { createTextVNode as T } from "vue";
import { withModifiers as g } from "vue";
import { createBlock as I } from "vue";
import { mergeProps as M } from "vue";
import { resolveDynamicComponent as B } from "vue";
import { Fragment as D } from "vue";
import { ElInput as R } from "element-plus";
import { vI as l, j_ as $ } from "../../../../../../../../shared/runtime.js";
import F from "./module/steel-plate-table.vue.js";
import W from "./module/section-steel-table.vue.js";
import q from "./module/steel-coil-table.vue.js";
const G = { class: "head-container" }, H = { key: 0 }, J = { key: 0 }, le = { __name: "index", setup(Q, { expose: x }) {
  const d = V(), o = V(l.STEEL_PLATE.V), n = { [l.STEEL_PLATE.K]: "steelPlateList", [l.SECTION_STEEL.K]: "sectionSteelList", [l.STEEL_COIL.K]: "steelCoilList" }, u = f({ steelPlateList: [], sectionSteelList: [], steelCoilList: [] }), m = f({ steelPlateList: [], sectionSteelList: [], steelCoilList: [] }), t = V({});
  U("bcListObj", u);
  const w = N(() => {
    var e, a;
    const s = [];
    for (const r in l.ENUM) (e = u[n[r]]) != null && e.length || s.push(l[r].V);
    return s.length === ((a = Object.keys(l.ENUM)) == null ? void 0 : a.length) ? [] : s;
  }), O = N(() => {
    switch (o.value) {
      case l.STEEL_PLATE.V:
        return F;
      case l.SECTION_STEEL.V:
        return W;
      case l.STEEL_COIL.V:
        return q;
      default:
        return null;
    }
  });
  A(() => d, () => {
    d.value && L();
  }, { immediate: true, deep: true });
  function L() {
    u[n[l.VK[o.value]]].forEach((s) => {
      d.value.rowWatch(s);
    });
  }
  function P() {
    const e = m[n[l.VK[o.value]]].filter((a) => (t.value.purchaseSN ? a.purchaseSN.indexOf(t.value.purchaseSN) > -1 : true) && (t.value.classifyName ? a.classifyName.indexOf(t.value.classifyName) > -1 : true) && (t.value.serialNumber ? a.serialNumber.indexOf(t.value.serialNumber) > -1 : true) && (t.value.specification ? a.specification.indexOf(t.value.specification) > -1 : true));
    u[n[l.VK[o.value]]] = [...e], L();
  }
  function v() {
    t.value = {};
    for (const s in n) u[n[s]] = m[n[s]];
  }
  function K() {
    v();
  }
  function k(s) {
    if (t.value = {}, u.sectionSteelList = [], u.steelPlateList = [], u.steelCoilList = [], m.sectionSteelList = [], m.steelPlateList = [], m.steelCoilList = [], o.value = l.STEEL_PLATE.V, !(s != null && s.length)) return;
    let e = l.STEEL_PLATE.V;
    s.forEach((a, r) => {
      u[n[l.VK[a.basicClass]]].push(f(a)), m[n[l.VK[a.basicClass]]].push(f(a)), e = a.basicClass < e || r === 0 ? a.basicClass : e;
    }), o.value = e, L();
  }
  return x({ initList: k }), (s, e) => {
    const a = S("common-radio-button"), r = R, h = S("common-button");
    return p(), E(D, null, [j("div", G, [c(a, { type: "enum", modelValue: o.value, "onUpdate:modelValue": e[0] || (e[0] = (i) => o.value = i), options: y(l).ENUM, disabledVal: w.value, clearable: "", class: "filter-item", onChange: v }, { suffix: _(({ item: i }) => {
      var C;
      return [(C = u[n[i.K]]) != null && C.length ? (p(), E("span", H, "(" + z(u[n[i.K]].length) + ")", 1)) : b("", true)];
    }), _: 1 }, 8, ["modelValue", "options", "disabledVal"]), o.value && !(o.value & y($).MANUFACTURED.V) ? (p(), E("div", J, [c(r, { modelValue: t.value.purchaseSN, "onUpdate:modelValue": e[1] || (e[1] = (i) => t.value.purchaseSN = i), placeholder: "申购单号", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), c(r, { modelValue: t.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (i) => t.value.serialNumber = i), placeholder: "编号", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), c(r, { modelValue: t.value.classifyName, "onUpdate:modelValue": e[3] || (e[3] = (i) => t.value.classifyName = i), placeholder: "物料种类", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), c(r, { modelValue: t.value.specification, "onUpdate:modelValue": e[4] || (e[4] = (i) => t.value.specification = i), placeholder: "规格", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), c(h, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: g(P, ["stop"]) }, { default: _(() => e[5] || (e[5] = [T("搜索")])), _: 1, __: [5] }), c(h, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh", onClick: g(K, ["stop"]) }, { default: _(() => e[6] || (e[6] = [T("重置")])), _: 1, __: [6] })])) : b("", true)]), o.value ? (p(), I(B(O.value), M({ key: 0, ref_key: "compRef", ref: d }, s.$attrs), null, 16)) : b("", true)], 64);
  };
} };
export {
  le as default
};
