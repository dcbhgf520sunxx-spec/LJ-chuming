import { ref as m } from "vue";
import { watch as k } from "vue";
import { nextTick as S } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as c } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as e } from "vue";
import { toDisplayString as l } from "vue";
import { unref as _ } from "vue";
import { createBlock as w } from "vue";
import { ElCard as N } from "element-plus";
import { _ as J, y1 as V } from "../../../../../../../shared/runtime.js";
import y from "./preview-form.vue.js";
const C = { style: { display: "flex" } }, D = { style: { background: "#eee", padding: "5px" } }, B = { style: { display: "flex" } }, L = { class: "flex-div" }, M = { class: "span-content" }, P = { class: "flex-div" }, q = { class: "span-content" }, E = { style: { display: "flex" } }, Q = { class: "flex-div" }, T = { class: "span-content" }, H = { class: "flex-div" }, I = { class: "span-content" }, W = { style: { display: "flex" } }, z = { class: "flex-div" }, A = { class: "span-content" }, G = { class: "flex-div" }, K = { class: "span-content" }, R = { key: 0 }, U = { style: { background: "#eee", padding: "5px" } }, X = { style: { display: "flex" } }, Y = { class: "flex-div" }, Z = { class: "span-content" }, $ = { class: "flex-div" }, ee = { class: "span-content" }, se = { style: { display: "flex" } }, te = { class: "flex-div" }, ae = { class: "span-content" }, le = { class: "flex-div" }, oe = { class: "span-content" }, ne = { style: { display: "flex" } }, ie = { class: "flex-div" }, re = { class: "span-content" }, de = { class: "flex-div" }, pe = { class: "span-content" }, ue = { key: 1, style: { color: "red" } }, me = { key: 1, style: { width: "400px" } }, ce = { __name: "steel-coil-preview", props: { basicClass: { type: Number }, material: { type: Object }, maxHeight: { type: Number }, projectWarehouseType: { type: [Number, String], default: void 0 }, formData: { type: Object, default: () => {
} } }, setup(x, { expose: F }) {
  const { steelMinLengthConfig: g } = V(), i = x, o = m(), a = m(), f = { plateForm: { totalObj: {} }, surplusForm: { totalObj: {} } }, t = m(JSON.parse(JSON.stringify(f)));
  k(() => i.formData, (n) => {
    v(n);
  }, { deep: true, immediate: true });
  function v(n) {
    o.value && o.value.resetFields(), a.value && a.value.resetFields();
    let s;
    n && Object.keys(n).length > 0 ? s = n : s = JSON.parse(JSON.stringify(f)), t.value = JSON.parse(JSON.stringify(s)), S(() => {
      a.value && a.value && a.value.clearValidate(), o.value && o.value.clearValidate();
    });
  }
  async function h() {
    if (!await o.value.validateForm()) return false;
    let s = true;
    if (a.value && (s = await a.value.validateForm()), !s) return false;
    const d = JSON.parse(JSON.stringify(t.value));
    return Object.assign(i.formData, d), true;
  }
  function O() {
    o.value && o.value.assignForm(), a.value && a.value && a.value.assignForm();
    const n = JSON.parse(JSON.stringify(t.value));
    Object.assign(i.formData, n);
  }
  function j() {
    o.value && o.value.clearValidate(), a.value && a.value && a.value.clearValidate();
  }
  return F({ validateSubmit: h, reset: v, assignForm: O, clearValidate: j }), (n, s) => {
    const d = N;
    return r(), p("div", C, [c(d, { class: "box-card" }, { header: u(() => s[0] || (s[0] = [e("div", { class: "card-header" }, [e("span", { style: { "font-weight": "600" } }, "开平钢板")], -1)])), default: u(() => [e("div", D, [e("div", B, [e("div", L, [s[1] || (s[1] = e("span", { class: "el-form-item__label span-label" }, "规格", -1)), e("span", M, l(t.value.plateForm.totalObj.specification), 1)]), e("div", P, [s[2] || (s[2] = e("span", { class: "el-form-item__label span-label span-label-left" }, "开平段数", -1)), e("span", q, l(t.value.plateForm.totalObj.segmentQuantity) + " 段", 1)])]), e("div", E, [e("div", Q, [s[3] || (s[3] = e("span", { class: "el-form-item__label span-label" }, "厚度", -1)), e("span", T, l(t.value.plateForm.totalObj.thickness) + " mm", 1)]), e("div", H, [s[4] || (s[4] = e("span", { class: "el-form-item__label span-label span-label-left" }, "开平板数量", -1)), e("span", I, l(t.value.plateForm.totalObj.quantity) + " 张", 1)])]), e("div", W, [e("div", z, [s[5] || (s[5] = e("span", { class: "el-form-item__label span-label" }, "宽度", -1)), e("span", A, l(t.value.plateForm.totalObj.width) + " mm", 1)]), e("div", G, [s[6] || (s[6] = e("span", { class: "el-form-item__label span-label span-label-left" }, "开平总重", -1)), e("span", K, l(t.value.plateForm.totalObj.mete) + " kg", 1)])])]), c(_(y), { ref_key: "plateForm", ref: o, key: "plateForm", "form-data": t.value.plateForm, material: i.material }, null, 8, ["form-data", "material"])]), _: 1 }), c(d, { class: "box-card", style: { "margin-left": "10px" } }, { header: u(() => s[7] || (s[7] = [e("div", { class: "card-header" }, [e("span", { style: { "font-weight": "600" } }, "开平-余料钢板")], -1)])), default: u(() => {
      var b;
      return [t.value.surplusForm.totalObj.width > 0 ? (r(), p("div", R, [e("div", U, [e("div", X, [e("div", Y, [s[8] || (s[8] = e("span", { class: "el-form-item__label span-label" }, "规格", -1)), e("span", Z, l(t.value.surplusForm.totalObj.specification), 1)]), e("div", $, [s[9] || (s[9] = e("span", { class: "el-form-item__label span-label span-label-left" }, "开平段数", -1)), e("span", ee, l(t.value.surplusForm.totalObj.segmentQuantity) + "段", 1)])]), e("div", se, [e("div", te, [s[10] || (s[10] = e("span", { class: "el-form-item__label span-label" }, "厚度", -1)), e("span", ae, l(t.value.surplusForm.totalObj.thickness) + " mm", 1)]), e("div", le, [s[11] || (s[11] = e("span", { class: "el-form-item__label span-label span-label-left" }, "余料板数量", -1)), e("span", oe, l(t.value.surplusForm.totalObj.quantity) + " 张", 1)])]), e("div", ne, [e("div", ie, [s[12] || (s[12] = e("span", { class: "el-form-item__label span-label" }, "宽度", -1)), e("span", re, l(t.value.surplusForm.totalObj.width) + " mm", 1)]), e("div", de, [s[13] || (s[13] = e("span", { class: "el-form-item__label span-label span-label-left" }, "余料总重", -1)), e("span", pe, l(t.value.surplusForm.totalObj.mete) + " kg", 1)])])]), t.value.surplusForm.totalObj.width > ((b = _(g)) == null ? void 0 : b.steelPlateShortestSideMinLength) ? (r(), w(_(y), { ref_key: "surplusForm", ref: a, key: "surplusForm", "form-data": t.value.surplusForm, material: i.material }, null, 8, ["form-data", "material"])) : (r(), p("div", ue, "根据系统配置，剩余余料规格属于“废料”范围，将纳入废料列表"))])) : (r(), p("div", me, " 本次无余料 "))];
    }), _: 1 })]);
  };
} }, be = J(ce, [["__scopeId", "data-v-92e0ce0e"]]);
export {
  be as default
};
