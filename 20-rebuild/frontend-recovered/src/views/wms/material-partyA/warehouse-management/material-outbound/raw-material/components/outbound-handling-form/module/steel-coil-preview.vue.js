import { ref as c } from "vue";
import { watch as S } from "vue";
import { nextTick as k } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as _ } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as l } from "vue";
import { unref as d } from "vue";
import { createBlock as N } from "vue";
import { ElCard as J } from "element-plus";
import { _ as C, y1 as V, sQ as B } from "../../../../../../../../../shared/runtime.js";
import h from "./preview-form.vue.js";
const D = { style: { display: "flex" } }, M = { style: { background: "#eee", padding: "5px" } }, L = { style: { display: "flex" } }, P = { class: "flex-div" }, Q = { class: "span-content" }, q = { class: "flex-div" }, E = { class: "span-content" }, T = { style: { display: "flex" } }, U = { class: "flex-div" }, H = { class: "span-content" }, I = { class: "flex-div" }, W = { class: "span-content" }, z = { style: { display: "flex" } }, A = { class: "flex-div" }, G = { class: "span-content" }, K = { class: "flex-div" }, R = { class: "span-content" }, X = { key: 0 }, Y = { style: { background: "#eee", padding: "5px" } }, Z = { style: { display: "flex" } }, $ = { class: "flex-div" }, ss = { class: "span-content" }, es = { class: "flex-div" }, ts = { class: "span-content" }, as = { style: { display: "flex" } }, ls = { class: "flex-div" }, os = { class: "span-content" }, is = { class: "flex-div" }, ns = { class: "span-content" }, rs = { style: { display: "flex" } }, ds = { class: "flex-div" }, ps = { class: "span-content" }, us = { class: "flex-div" }, ms = { class: "span-content" }, cs = { key: 1, style: { color: "red" } }, _s = { key: 1, style: { width: "400px" } }, fs = { __name: "steel-coil-preview", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number }, projectWarehouseType: { type: [Number, String], default: void 0 }, formData: { type: Object, default: () => {
} } }, setup(x, { expose: F }) {
  const { steelMinLengthConfig: g } = V(), n = x, o = c(), a = c(), { baseUnit: f } = B(n.basicClass), v = { plateForm: { totalObj: {} }, surplusForm: { totalObj: {} } }, t = c(JSON.parse(JSON.stringify(v)));
  S(() => n.formData, (i) => {
    b(i);
  }, { deep: true, immediate: true });
  function b(i) {
    o.value && o.value.resetFields(), a.value && a.value.resetFields();
    let e;
    i && Object.keys(i).length > 0 ? e = i : e = JSON.parse(JSON.stringify(v)), t.value = JSON.parse(JSON.stringify(e)), k(() => {
      a.value && a.value && a.value.clearValidate(), o.value && o.value.clearValidate();
    });
  }
  async function O() {
    if (!await o.value.validateForm()) return false;
    let e = true;
    if (a.value && (e = await a.value.validateForm()), !e) return false;
    const p = JSON.parse(JSON.stringify(t.value));
    return Object.assign(n.formData, p), true;
  }
  function j() {
    o.value && o.value.assignForm(), a.value && a.value && a.value.assignForm();
    const i = JSON.parse(JSON.stringify(t.value));
    Object.assign(n.formData, i);
  }
  function w() {
    o.value && o.value.clearValidate(), a.value && a.value && a.value.clearValidate();
  }
  return F({ validateSubmit: O, reset: b, assignForm: j, clearValidate: w }), (i, e) => {
    const p = J;
    return r(), u("div", D, [_(p, { class: "box-card" }, { header: m(() => e[0] || (e[0] = [s("div", { class: "card-header" }, [s("span", { style: { "font-weight": "600" } }, "开平钢板")], -1)])), default: m(() => [s("div", M, [s("div", L, [s("div", P, [e[1] || (e[1] = s("span", { class: "el-form-item__label span-label" }, "规格", -1)), s("span", Q, l(t.value.plateForm.totalObj.specification), 1)]), s("div", q, [e[2] || (e[2] = s("span", { class: "el-form-item__label span-label span-label-left" }, "开平段数", -1)), s("span", E, l(t.value.plateForm.totalObj.segmentQuantity) + " 段", 1)])]), s("div", T, [s("div", U, [e[3] || (e[3] = s("span", { class: "el-form-item__label span-label" }, "厚度", -1)), s("span", H, l(t.value.plateForm.totalObj.thickness) + " mm", 1)]), s("div", I, [e[4] || (e[4] = s("span", { class: "el-form-item__label span-label span-label-left" }, "开平板数量", -1)), s("span", W, l(t.value.plateForm.totalObj.quantity) + " 张", 1)])]), s("div", z, [s("div", A, [e[5] || (e[5] = s("span", { class: "el-form-item__label span-label" }, "宽度", -1)), s("span", G, l(t.value.plateForm.totalObj.width) + " mm", 1)]), s("div", K, [e[6] || (e[6] = s("span", { class: "el-form-item__label span-label span-label-left" }, "开平总重", -1)), s("span", R, l(t.value.plateForm.totalObj.mete) + " " + l(d(f).weight.unit), 1)])])]), _(d(h), { ref_key: "plateForm", ref: o, key: "plateForm", "form-data": t.value.plateForm, material: n.material }, null, 8, ["form-data", "material"])]), _: 1 }), _(p, { class: "box-card", style: { "margin-left": "10px" } }, { header: m(() => e[7] || (e[7] = [s("div", { class: "card-header" }, [s("span", { style: { "font-weight": "600" } }, "开平-余料钢板")], -1)])), default: m(() => {
      var y;
      return [t.value.surplusForm.totalObj.width > 0 ? (r(), u("div", X, [s("div", Y, [s("div", Z, [s("div", $, [e[8] || (e[8] = s("span", { class: "el-form-item__label span-label" }, "规格", -1)), s("span", ss, l(t.value.surplusForm.totalObj.specification), 1)]), s("div", es, [e[9] || (e[9] = s("span", { class: "el-form-item__label span-label span-label-left" }, "开平段数", -1)), s("span", ts, l(t.value.surplusForm.totalObj.segmentQuantity) + "段", 1)])]), s("div", as, [s("div", ls, [e[10] || (e[10] = s("span", { class: "el-form-item__label span-label" }, "厚度", -1)), s("span", os, l(t.value.surplusForm.totalObj.thickness) + " mm", 1)]), s("div", is, [e[11] || (e[11] = s("span", { class: "el-form-item__label span-label span-label-left" }, "余料板数量", -1)), s("span", ns, l(t.value.surplusForm.totalObj.quantity) + " 张", 1)])]), s("div", rs, [s("div", ds, [e[12] || (e[12] = s("span", { class: "el-form-item__label span-label" }, "宽度", -1)), s("span", ps, l(t.value.surplusForm.totalObj.width) + " mm", 1)]), s("div", us, [e[13] || (e[13] = s("span", { class: "el-form-item__label span-label span-label-left" }, "余料总重", -1)), s("span", ms, l(t.value.surplusForm.totalObj.mete) + " " + l(d(f).weight.unit), 1)])])]), t.value.surplusForm.totalObj.width > ((y = d(g)) == null ? void 0 : y.steelPlateShortestSideMinLength) ? (r(), N(d(h), { ref_key: "surplusForm", ref: a, key: "surplusForm", "form-data": t.value.surplusForm, material: n.material }, null, 8, ["form-data", "material"])) : (r(), u("div", cs, "根据系统配置，剩余余料规格属于“废料”范围，将纳入废料列表"))])) : (r(), u("div", _s, " 本次无余料 "))];
    }), _: 1 })]);
  };
} }, hs = C(fs, [["__scopeId", "data-v-4bbf7608"]]);
export {
  hs as default
};
