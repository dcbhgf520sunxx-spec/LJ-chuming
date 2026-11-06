import { ref as p } from "vue";
import { resolveComponent as i } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as O } from "vue";
import { withDirectives as y } from "vue";
import { vShow as A } from "vue";
import { unref as e } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as n } from "vue";
import { createBlock as x } from "vue";
import { createCommentVNode as K } from "vue";
import { withKeys as f } from "vue";
import { withCtx as _ } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as L } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElTag as B } from "element-plus";
import { c3 as Q, B as z, bN as r, hZ as M, C as R, E as H } from "../../../../../shared/runtime.js";
import { a as P } from "../../../../../modules/collection-9275714a.js";
const F = { __name: "header", setup(q) {
  const V = { createTime: [], startDate: void 0, endDate: void 0, projectId: void 0, name: void 0, type: void 0, auditStatus: { value: Q.PASS.V, resetAble: false } }, u = p();
  async function g() {
    const s = await P({ ...t, startDate: t.createTime ? t.createTime[0] : void 0, endDate: t.createTime ? t.createTime[1] : void 0 });
    u.value = s;
  }
  const { crud: l, query: t, CRUD: T } = z(V), b = p([r.MACHINING, r.INSTALLATION]);
  T.HOOK.handleRefresh = async (s, { data: a }) => {
    g();
  };
  const N = (s) => {
    s || (t.businessType = ""), l.toQuery();
  };
  return (s, a) => {
    const h = i("project-radio-button"), C = i("common-radio-button"), v = U, w = i("common-select"), m = j, S = i("print-table"), I = B, D = E("permission");
    return c(), O("div", null, [y(d("div", null, [n(h, { modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).projectId = o), disabled: e(t).type === 2, type: "all", class: "filter-item", size: "default", onChange: e(l).toQuery }, null, 8, ["modelValue", "disabled", "onChange"]), n(C, { modelValue: e(t).type, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).type = o), options: e(M).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: N }, null, 8, ["modelValue", "options"]), n(v, { modelValue: e(t).createTime, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).createTime = o), class: "date-item filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), e(t).type === 1 ? (c(), x(w, { key: 0, modelValue: e(t).businessType, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).businessType = o), options: b.value, unshowOptions: e(t).type === 1 ? [e(r).SCRAPSELLER.K] : e(t).type === 2 ? [e(r).INSTALLATION.K, e(r).MACHINING.K] : [], size: "default", class: "filter-item", clearable: "", placeholder: "订单类型", style: { width: "200px" }, type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"])) : K("", true), d("div", null, [n(m, { modelValue: e(t).name, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(t).name = o), modelModifiers: { trim: true }, onKeyup: f(e(l).toQuery, ["enter"]), placeholder: "项目名称", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue", "onKeyup"]), n(m, { modelValue: e(t).contractSignBodyName, "onUpdate:modelValue": a[5] || (a[5] = (o) => e(t).contractSignBodyName = o), modelModifiers: { trim: true }, onKeyup: f(e(l).toQuery, ["enter"]), placeholder: "合同签订主体", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue", "onKeyup"]), n(e(R))])], 512), [[A, e(l).searchToggle]]), n(e(H), null, { optLeft: _(() => [y(n(S, { params: { ...e(t) }, "api-key": "collectionLedger", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"]), [[D, e(l).permission.print]]), n(I, { class: "filter-item", size: "large" }, { default: _(() => [a[6] || (a[6] = d("span", null, "收款合计：", -1)), k(L(u.value), 1)]), _: 1, __: [6] })]), _: 1 })]);
  };
} };
export {
  F as default
};
