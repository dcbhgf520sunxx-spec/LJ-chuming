import { ref as c } from "vue";
import { resolveComponent as i } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as A } from "vue";
import { withDirectives as f } from "vue";
import { vShow as x } from "vue";
import { unref as e } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as l } from "vue";
import { createBlock as K } from "vue";
import { createCommentVNode as k } from "vue";
import { withKeys as _ } from "vue";
import { withCtx as g } from "vue";
import { createTextVNode as L } from "vue";
import { toDisplayString as Q } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElTag as B } from "element-plus";
import { c3 as z, bN as r, B as M, hZ as R, C as H, E as P } from "../../../../../shared/runtime.js";
import { a as q } from "../../../../../modules/invoice-2cd386aa.js";
const J = { __name: "header", setup(G) {
  const V = { createTime: [], startDate: void 0, endDate: void 0, projectId: void 0, type: void 0, name: void 0, auditStatus: { value: z.PASS.V, resetAble: false } }, u = c(), T = c([r.MACHINING, r.INSTALLATION]);
  async function m() {
    const s = await q({ ...t, startDate: t.createTime ? t.createTime[0] : void 0, endDate: t.createTime ? t.createTime[1] : void 0 });
    u.value = s;
  }
  const { crud: n, query: t, CRUD: b } = M(V);
  b.HOOK.handleRefresh = async (s, { data: a }) => {
    m();
  };
  const h = () => {
    n.toQuery(), m();
  }, C = (s) => {
    s || (t.businessType = ""), n.toQuery();
  };
  return (s, a) => {
    const N = i("project-radio-button"), v = i("common-radio-button"), w = U, S = i("common-select"), p = j, I = i("print-table"), D = B, E = O("permission");
    return y(), A("div", null, [f(d("div", null, [l(N, { modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).projectId = o), disabled: e(t).type === 2, type: "all", class: "filter-item", size: "default", onChange: e(n).toQuery }, null, 8, ["modelValue", "disabled", "onChange"]), l(v, { modelValue: e(t).type, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).type = o), options: e(R).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: C }, null, 8, ["modelValue", "options"]), l(w, { modelValue: e(t).createTime, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).createTime = o), class: "date-item filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "value-format": "x", onChange: e(n).toQuery, onClear: h }, null, 8, ["modelValue", "onChange"]), e(t).type === 1 ? (y(), K(S, { key: 0, modelValue: e(t).businessType, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).businessType = o), options: T.value, unshowOptions: e(t).type === 1 ? [e(r).SCRAPSELLER.K] : e(t).type === 2 ? [e(r).INSTALLATION.K, e(r).MACHINING.K] : [], size: "default", class: "filter-item", clearable: "", placeholder: "订单类型", style: { width: "200px" }, type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"])) : k("", true), d("div", null, [l(p, { modelValue: e(t).name, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(t).name = o), modelModifiers: { trim: true }, onKeyup: _(e(n).toQuery, ["enter"]), placeholder: "项目名称", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue", "onKeyup"]), l(p, { modelValue: e(t).contractSignBodyName, "onUpdate:modelValue": a[5] || (a[5] = (o) => e(t).contractSignBodyName = o), modelModifiers: { trim: true }, onKeyup: _(e(n).toQuery, ["enter"]), placeholder: "合同签订主体", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue", "onKeyup"]), l(e(H))])], 512), [[x, e(n).searchToggle]]), l(e(P), null, { optLeft: g(() => [f(l(I, { params: { ...e(t) }, "api-key": "invoiceLedger", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[E, e(n).permission.print]]), l(D, { class: "filter-item", size: "large" }, { default: g(() => [a[6] || (a[6] = d("span", null, "开票合计：", -1)), L(Q(u.value), 1)]), _: 1, __: [6] })]), _: 1 })]);
  };
} };
export {
  J as default
};
