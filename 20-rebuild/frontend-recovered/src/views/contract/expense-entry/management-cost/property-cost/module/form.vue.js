import { ref as p } from "vue";
import { computed as U } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as w } from "vue";
import { createBlock as A } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as b } from "vue";
import { ElFormItem as T } from "element-plus";
import { ElInputNumber as N } from "element-plus";
import { ElForm as R } from "element-plus";
import { t as S, ao as q } from "../../../../../../shared/runtime.js";
const z = { style: { float: "right" } }, B = { class: "form" }, K = { __name: "form", props: { query: { type: Object } }, setup(y) {
  const { decimalPrecision: g } = S(), h = y, d = p(), v = { id: void 0, month: void 0, employeeQuantity: void 0, totalWage: void 0 }, u = p([]);
  for (let a = 1; a <= 12; a++) u.value.push({ id: a, name: a });
  const C = U(() => t.status.edit > 0), { crud: t, form: l, CRUD: r } = q(v, d), O = { month: [{ required: true, message: "请选择月份", trigger: "blur" }], feeAmount: [{ required: true, message: "请输入费用总额", trigger: "blur" }] };
  return r.HOOK.beforeToEdit = (a, o) => {
    console.log(o, "form");
  }, r.HOOK.beforeToQuery = async () => {
  }, r.HOOK.beforeToEdit = () => {
    console.log(l);
  }, r.HOOK.beforeSubmit = async () => {
    l.year = h.query.year;
  }, (a, o) => {
    const c = m("common-button"), k = m("common-select-v2"), f = T, x = N, V = R, E = m("common-dialog");
    return w(), A(E, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(t).cancelCU, visible: e(t).status.cu > 0, title: e(t).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: n(() => [_("span", z, [s(c, { loading: e(t).status.cu === e(r).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(t).submitCU }, { default: n(() => o[2] || (o[2] = [b(" 提 交 ")])), _: 1, __: [2] }, 8, ["loading", "onClick"]), s(c, { size: "default", onClick: e(t).cancelCU }, { default: n(() => o[3] || (o[3] = [b("关 闭")])), _: 1, __: [3] }, 8, ["onClick"])])]), default: n(() => [_("div", B, [s(V, { ref_key: "formRef", ref: d, model: e(l), rules: O, size: "default", "label-width": "140px", class: "demo-form" }, { default: n(() => [s(f, { label: "月份：", prop: "month" }, { default: n(() => [s(k, { modelValue: e(l).month, "onUpdate:modelValue": o[0] || (o[0] = (i) => e(l).month = i), options: u.value, type: "other", placeholder: "请选择月份", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, disabled: C.value }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), s(f, { label: "费用总额（元）：", prop: "feeAmount" }, { default: n(() => [s(x, { modelValue: e(l).feeAmount, "onUpdate:modelValue": o[1] || (o[1] = (i) => e(l).feeAmount = i), style: { width: "270px" }, placeholder: "输入费用总额", "controls-position": "right", precision: e(g).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  K as default
};
