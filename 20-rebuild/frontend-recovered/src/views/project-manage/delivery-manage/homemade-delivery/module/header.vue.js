import { watch as y } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as N } from "vue";
import { vShow as v } from "vue";
import { unref as t } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { withKeys as n } from "vue";
import s from "moment";
import { ElDatePicker as g } from "element-plus";
import { ElInput as D } from "element-plus";
import { B as K, C as U, E as b } from "../../../../../shared/runtime.js";
const x = { class: "head-container" }, I = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(m) {
  const p = { projectId: { value: void 0, resetAble: false }, date: void 0, startDate: void 0, endDate: void 0, licensePlate: void 0, driverName: void 0, receiptName: void 0, auditUserName: void 0 }, { crud: d, query: e } = K(p), i = m;
  y(() => i.projectId, (u) => {
    u && (d.query.projectId = i.projectId, d.toQuery());
  }, { immediate: true, deep: true });
  function f() {
    e.date && e.date.length > 1 ? (e.startDate = s(e.date[0]).valueOf(), e.endDate = s(e.date[1]).valueOf()) : (e.startDate = void 0, e.endDate = void 0), d.toQuery();
  }
  return (u, a) => {
    const c = g, o = D;
    return V(), h("div", x, [N(w("div", null, [r(c, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (l) => t(e).date = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: f }, null, 8, ["modelValue"]), r(o, { modelValue: t(e).licensePlate, "onUpdate:modelValue": a[1] || (a[1] = (l) => t(e).licensePlate = l), modelModifiers: { trim: true }, placeholder: "车牌/船牌", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: n(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(o, { modelValue: t(e).driverName, "onUpdate:modelValue": a[2] || (a[2] = (l) => t(e).driverName = l), modelModifiers: { trim: true }, placeholder: "司机", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: n(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(o, { modelValue: t(e).receiptName, "onUpdate:modelValue": a[3] || (a[3] = (l) => t(e).receiptName = l), modelModifiers: { trim: true }, placeholder: "收货人", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: n(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(o, { modelValue: t(e).auditUserName, "onUpdate:modelValue": a[4] || (a[4] = (l) => t(e).auditUserName = l), modelModifiers: { trim: true }, placeholder: "办理人", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: n(t(d).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(t(U))], 512), [[v, t(d).searchToggle]]), r(t(b))]);
  };
} };
export {
  I as default
};
