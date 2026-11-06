import l from "moment";
import { watch as y } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as V } from "vue";
import { vShow as O } from "vue";
import { unref as t } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as o } from "vue";
import { withKeys as u } from "vue";
import { ElDatePicker as N } from "element-plus";
import { ElInput as g } from "element-plus";
import { B as w, I as D, C as I, E as K } from "../../../../../shared/runtime.js";
const U = { class: "head-container" }, P = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(p) {
  const m = { projectId: { value: void 0, resetAble: false }, date: [l().valueOf() - 2592e6, l().valueOf()], startDate: l().valueOf() - 2592e6, endDate: l().valueOf(), licensePlate: void 0, receiptName: void 0, auditUserName: void 0 }, { crud: r, query: e } = w(m), n = p;
  y(() => n.projectId, (i) => {
    i && (r.query.projectId = n.projectId, r.toQuery());
  }, { immediate: true, deep: true });
  function c() {
    e.date && e.date.length > 1 ? (e.startDate = l(e.date[0]).valueOf(), e.endDate = l(e.date[1]).valueOf()) : (e.startDate = l().valueOf() - 3600 * 1e3 * 24 * 30, e.endDate = l().valueOf()), r.toQuery();
  }
  return (i, a) => {
    const f = N, s = g;
    return h(), v("div", U, [V(_("div", null, [o(f, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (d) => t(e).date = d), type: "daterange", "range-separator": ":", size: "default", shortcuts: t(D), class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", clearable: false, style: { width: "240px" }, onChange: c }, null, 8, ["modelValue", "shortcuts"]), o(s, { modelValue: t(e).licensePlate, "onUpdate:modelValue": a[1] || (a[1] = (d) => t(e).licensePlate = d), modelModifiers: { trim: true }, placeholder: "车牌/船牌", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: t(e).auditUserName, "onUpdate:modelValue": a[2] || (a[2] = (d) => t(e).auditUserName = d), modelModifiers: { trim: true }, placeholder: "办理人", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(s, { modelValue: t(e).receiptName, "onUpdate:modelValue": a[3] || (a[3] = (d) => t(e).receiptName = d), modelModifiers: { trim: true }, placeholder: "收货人", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(t(I))], 512), [[O, t(r).searchToggle]]), o(t(K))]);
  };
} };
export {
  P as default
};
