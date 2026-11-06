import { ref as V } from "vue";
import { computed as C } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as n } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as r } from "vue";
import { unref as i } from "vue";
import { Fragment as x } from "vue";
import { renderList as k } from "vue";
import { createBlock as v } from "vue";
import { createTextVNode as w } from "vue";
import { ElOption as H } from "element-plus";
import { ElSelect as M } from "element-plus";
import { ElButton as O } from "element-plus";
import { ElInputNumber as P } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElForm as W } from "element-plus";
import { ElCard as Y } from "element-plus";
import { _ as $, bY as A, B as J, i as d } from "../../../../../../shared/runtime.js";
const K = { class: "head-container" }, X = { class: "header-titel" }, Z = { class: "search" }, ee = { class: "search-item" }, te = { class: "search-item" }, ae = { class: "search-item", style: { "margin-left": "-34px" } }, le = { __name: "header", props: { secondaryData: { type: Object, default: () => {
} }, paintSelectList: { type: Array, default: () => [] }, paintBrandList: { type: Array, default: () => [] }, paintTypeList: { type: Array, default: () => [] } }, emits: ["close", "toAdd", "calculate"], setup(m, { expose: R, emit: S }) {
  const T = S, y = m, U = { paintingTypeEnum: A.PRIMER.V, paintBrandList: void 0, paintTypeList: void 0 }, { crud: p, query: a } = J(U), s = V({ surfaceArea: void 0, filmThickness: void 0, lossCoefficient: void 0 }), g = V(), D = C(() => {
    var e, f;
    let l = [];
    return d(a.paintingTypeEnum) ? (l = (e = y.paintSelectList) == null ? void 0 : e.find((u) => u.id === a.paintingTypeEnum), ((f = l == null ? void 0 : l.nameInfos) == null ? void 0 : f.map((u) => u.name)) || []) : y.paintBrandList;
  }), N = C(() => {
    let l = [];
    return l = y.paintTypeList.filter((e) => d(a.paintingTypeEnum) && d(a.paintBrandList) ? e.paintingTypeEnum === a.paintingTypeEnum && e.paintBrand === a.paintBrandList : d(a.paintingTypeEnum) ? e.paintingTypeEnum === a.paintingTypeEnum : d(a.paintBrandList) ? e.paintBrand === a.paintBrandList : e), l = l.map((e) => e.paintType), l = Array.from(new Set(l)), l;
  }), q = { surfaceArea: [{ required: true, message: "请输入表面积", trigger: "change" }], filmThickness: [{ required: true, message: "请输入漆膜厚度", trigger: "change" }], lossCoefficient: [{ required: true, message: "请输入损耗系数", trigger: "change" }] };
  async function E() {
    await g.value.validate() && (p.data = p.data.map((e) => (e.theoreticalCoatingRate = e.volumeSolidContent * 10 / e.specificGravity / s.value.filmThickness, e.practicalSpreadingRate = e.theoreticalCoatingRate / s.value.lossCoefficient, e.weight = s.value.surfaceArea / e.practicalSpreadingRate, e.quantity = e.weight / e.packageWeight, e.weight && e.price && (e.totalPrice = e.weight * e.price), e)), T("calculate"));
  }
  function z() {
    a.paintBrandList = void 0, a.paintTypeList = void 0, p.toQuery();
  }
  function F() {
    a.paintTypeList = void 0, p.toQuery();
  }
  return R({ formRef: g, calculateForm: s.value, calculate: E }), (l, e) => {
    const f = j("common-select"), u = H, B = M, L = O, _ = P, h = G, I = W, Q = Y;
    return c(), b("div", K, [n(Q, null, { default: o(() => [r("div", X, [r("div", Z, [r("div", ee, [e[7] || (e[7] = r("span", { class: "search-label" }, "选择油漆类型：", -1)), n(f, { type: "enum", modelValue: i(a).paintingTypeEnum, "onUpdate:modelValue": e[0] || (e[0] = (t) => i(a).paintingTypeEnum = t), options: i(A).ENUM, placeholder: "请选择油漆类型", disabled: i(d)(m.secondaryData), style: { width: "240px" }, class: "filter-item", onChange: z }, null, 8, ["modelValue", "options", "disabled"])]), r("div", te, [e[8] || (e[8] = r("span", { class: "search-label" }, "选择油漆品牌：", -1)), n(B, { modelValue: i(a).paintBrandList, "onUpdate:modelValue": e[1] || (e[1] = (t) => i(a).paintBrandList = t), clearable: "", filterable: "", disabled: i(d)(m.secondaryData), placeholder: "请选择品牌", class: "filter-item", style: { width: "270px" }, onChange: F }, { default: o(() => [(c(true), b(x, null, k(D.value, (t) => (c(), v(u, { key: t, label: t, value: t }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), r("div", ae, [e[9] || (e[9] = r("span", { class: "search-label" }, "选择材质：", -1)), n(B, { modelValue: i(a).paintTypeList, "onUpdate:modelValue": e[2] || (e[2] = (t) => i(a).paintTypeList = t), clearable: "", filterable: "", disabled: i(d)(m.secondaryData), placeholder: "请选择材质", class: "filter-item", style: { width: "270px" }, onChange: i(p).toQuery }, { default: o(() => [(c(true), b(x, null, k(N.value, (t) => (c(), v(u, { key: t, label: t, value: t }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "onChange"])])]), n(L, { onClick: e[3] || (e[3] = (t) => T("close")) }, { default: o(() => e[10] || (e[10] = [w("关闭")])), _: 1, __: [10] })]), n(I, { ref_key: "formRef", ref: g, class: "form-style", model: s.value, rules: q, size: "default", "label-width": "130px" }, { default: o(() => [n(h, { class: "form-item-style", label: "表面积(m²)：", prop: "surfaceArea" }, { default: o(() => [n(_, { modelValue: s.value.surfaceArea, "onUpdate:modelValue": e[4] || (e[4] = (t) => s.value.surfaceArea = t), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, placeholder: "请输入表面积", size: "default", style: { width: "180px" } }, null, 8, ["modelValue"])]), _: 1 }), n(h, { class: "form-item-style", label: "漆膜厚度(μm)：", prop: "filmThickness" }, { default: o(() => [n(_, { modelValue: s.value.filmThickness, "onUpdate:modelValue": e[5] || (e[5] = (t) => s.value.filmThickness = t), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, placeholder: "请输入漆膜厚度", size: "default", style: { width: "180px" } }, null, 8, ["modelValue"])]), _: 1 }), n(h, { class: "form-item-style", label: "损耗系数：", prop: "lossCoefficient", style: { "margin-left": "-34px" } }, { default: o(() => [n(_, { modelValue: s.value.lossCoefficient, "onUpdate:modelValue": e[6] || (e[6] = (t) => s.value.lossCoefficient = t), "controls-position": "right", max: 999999999, min: 1e-6, step: 1, placeholder: "请输入损耗系数", size: "default", style: { width: "180px" } }, null, 8, ["modelValue"])]), _: 1 }), n(L, { class: "calculate-btn", type: "success", onClick: E }, { default: o(() => e[11] || (e[11] = [w("计算")])), _: 1, __: [11] })]), _: 1 }, 8, ["model"])]), _: 1 })]);
  };
} }, ie = $(le, [["__scopeId", "data-v-a7841631"]]);
export {
  ie as default
};
