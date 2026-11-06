import { ref as h } from "vue";
import { computed as T } from "vue";
import { ElMessage as Y } from "element-plus";
import { resolveComponent as c } from "vue";
import { openBlock as S } from "vue";
import { createBlock as D } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { createTextVNode as U } from "vue";
import { ElDatePicker as M } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElInputNumber as F } from "element-plus";
import { ElForm as I } from "element-plus";
import { t as N, ao as R } from "../../../../../../shared/runtime.js";
const B = { style: { float: "right" } }, H = { class: "form" }, $ = { __name: "form", props: { query: { type: Object }, accountingUnit: { type: String, default: "" }, gasType: { type: String, default: "" }, detailData: { type: Array, default: () => [] } }, setup(f) {
  const { decimalPrecision: V } = N(), p = f, m = h(), y = h([]);
  for (let l = 1; l <= 12; l++) y.value.push({ id: l, name: l });
  const C = { id: void 0, year: void 0, month: void 0, usedMete: void 0, totalAmount: void 0 }, { crud: a, form: e, CRUD: s } = R(C, m), _ = T(() => a.status.edit > 0), b = (l, t, u) => {
    t || u(new Error("填写数据必须大于0")), u();
  }, q = { month: [{ required: true, message: "请输入月份", trigger: "blur" }], usedMete: [{ required: true, validator: b, trigger: "blur" }], totalAmount: [{ required: true, validator: b, trigger: "blur" }] };
  s.HOOK.beforeToAdd = async (l, t) => {
    if (t.year = l.query.year, t.accountingUnit = l.query.unit, !t.accountingUnit) return Y.error("请到科目管理里面配置对应新增的气体的计量单位"), false;
  }, s.HOOK.beforeToQuery = async () => {
  }, s.HOOK.beforeToEdit = async () => {
    e.year = p.query.year;
  }, s.HOOK.beforeSubmit = async () => {
    if (!await m.value.validate()) return false;
    e.classifyId = a.query.classifyId, e.year = e.year ? e.year : p.query.year, e.accountingUnit = a.query.unit, a.query.year = e.year, a.refresh();
  };
  function w(l) {
    return l > /* @__PURE__ */ new Date();
  }
  function x() {
    a.query.year = e.year, a.refresh();
  }
  return (l, t) => {
    const u = c("common-button"), k = M, d = z, O = c("common-select-v2"), g = F, A = I, E = c("common-dialog");
    return S(), D(E, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(a).cancelCU, visible: o(a).status.cu > 0, title: `${_.value ? "编辑" : "新增"} ${f.gasType} 气体统计`, "show-close": false, width: "500px", top: "10vh" }, { titleRight: r(() => [v("span", B, [n(u, { loading: o(a).status.cu === o(s).STATUS.PROCESSING, size: "default", type: "primary", onClick: o(a).submitCU }, { default: r(() => t[4] || (t[4] = [U(" 提 交 ")])), _: 1, __: [4] }, 8, ["loading", "onClick"]), n(u, { size: "default", onClick: o(a).cancelCU }, { default: r(() => t[5] || (t[5] = [U("关 闭")])), _: 1, __: [5] }, 8, ["onClick"])])]), default: r(() => [v("div", H, [n(A, { ref_key: "formRef", ref: m, model: o(e), rules: q, size: "default", "label-width": "140px", class: "demo-form" }, { default: r(() => [n(d, { label: "年份：", prop: "year" }, { default: r(() => [n(k, { modelValue: o(e).year, "onUpdate:modelValue": t[0] || (t[0] = (i) => o(e).year = i), type: "year", size: "default", format: "YYYY", "value-format": "YYYY", placeholder: "选择日期", style: { width: "270px" }, "disabled-date": w, onChange: x }, null, 8, ["modelValue"])]), _: 1 }), n(d, { label: "月份：", prop: "month" }, { default: r(() => [n(O, { modelValue: o(e).month, "onUpdate:modelValue": t[1] || (t[1] = (i) => o(e).month = i), options: y.value, type: "other", placeholder: "请选择月份", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, disabled: _.value }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), n(d, { label: `用量（${o(e).accountingUnit ? o(e).accountingUnit : ""}）：`, prop: "usedMete" }, { default: r(() => [n(g, { modelValue: o(e).usedMete, "onUpdate:modelValue": t[2] || (t[2] = (i) => o(e).usedMete = i), style: { width: "270px" }, placeholder: "输入用量", "controls-position": "right", min: 0 }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), n(d, { label: "费用总额（元）：", prop: "totalAmount" }, { default: r(() => [n(g, { modelValue: o(e).totalAmount, "onUpdate:modelValue": t[3] || (t[3] = (i) => o(e).totalAmount = i), style: { width: "270px" }, placeholder: "输入费用总额", "controls-position": "right", precision: o(V).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  $ as default
};
