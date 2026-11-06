import { jE as u, B as V, C as w, E, a as h } from "../../../../../shared/runtime.js";
import { ref as k } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as a } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as b } from "vue";
import { createElementVNode as x } from "vue";
import { unref as n } from "vue";
import { createTextVNode as c } from "vue";
import { vShow as B } from "vue";
import { createBlock as U } from "vue";
import { resolveDynamicComponent as N } from "vue";
import { Fragment as z } from "vue";
import { ElDatePicker as P } from "element-plus";
import { ElInput as Q } from "element-plus";
const q = { __name: "header", setup(S) {
  const f = { type: u.PRODUCT.V, name: void 0, date: void 0, startDate: void 0, endDate: void 0 }, _ = k([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: l, query: e } = V(f);
  function y() {
    l.data = [], l.toQuery();
  }
  function g() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), l.toQuery();
  }
  return (s, t) => {
    const v = m("common-radio-button"), D = P, C = Q, d = h, i = m("common-button");
    return p(), T(z, null, [a(n(E), null, { optLeft: r(() => [b(x("div", null, [a(v, { modelValue: n(e).type, "onUpdate:modelValue": t[0] || (t[0] = (o) => n(e).type = o), options: n(u).ENUM, class: "filter-item", type: "enum", onChange: y }, null, 8, ["modelValue", "options"]), a(D, { modelValue: n(e).date, "onUpdate:modelValue": t[1] || (t[1] = (o) => n(e).date = o), "default-time": _.value, class: "date-item filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "value-format": "x", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", onChange: g }, null, 8, ["modelValue", "default-time"]), a(C, { modelValue: n(e).name, "onUpdate:modelValue": t[2] || (t[2] = (o) => n(e).name = o), placeholder: "项目名称/采购合同编号/物流公司搜索", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue"]), a(n(w)), a(i, { class: "filter-item", size: "mini", type: "success", onClick: t[3] || (t[3] = (o) => s.openDrawer("Payment")) }, { default: r(() => [a(d, { "icon-class": "contract-collection" }), t[5] || (t[5] = c(" 付款申请 "))]), _: 1, __: [5] }), a(i, { class: "filter-item", size: "mini", type: "warning", onClick: t[4] || (t[4] = (o) => s.openDrawer("InvoiceEntry")) }, { default: r(() => [a(d, { "icon-class": "contract-invoice" }), t[6] || (t[6] = c(" 发票入账 "))]), _: 1, __: [6] })], 512), [[B, n(l).searchToggle]])]), _: 1 }), (p(), U(N(s.currentComponent), { ref: "currentComponentRef" }, null, 512))], 64);
  };
} };
export {
  q as default
};
