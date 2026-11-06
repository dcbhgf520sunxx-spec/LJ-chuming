import l from "moment";
import { ref as p } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as w } from "vue";
import { vShow as O } from "vue";
import { unref as t } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as r } from "vue";
import { renderSlot as _ } from "vue";
import { ElDatePicker as C } from "element-plus";
import { c1 as u, bo as i, B as E, aV as D } from "../../../../../shared/runtime.js";
const k = { class: "head-container" }, b = { style: { display: "flex", "justify-content": "space-between" } }, P = { __name: "header", setup(T) {
  const c = { date: [l().startOf("month").valueOf(), l().valueOf()], startDate: l().startOf("month").valueOf(), endDate: l().valueOf(), status: u.PROCESS.V, weightStatus: i.NET.V, workshopId: void 0 }, { crud: n, query: e } = E(c), f = p([u.PROCESS, u.COMPLETE, u.SUSPEND]), h = p([i.NET, i.GROSS]);
  function g(s) {
    s && s.length > 1 ? (e.startDate = s[0], e.endDate = s[1]) : (e.startDate = l().startOf("month").valueOf(), e.endDate = l().valueOf()), n.toQuery();
  }
  return (s, a) => {
    const S = C, m = V("common-radio-button");
    return y(), v("div", k, [w(d("div", b, [d("div", null, [r(S, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).date = o), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", "value-format": "x", style: { width: "240px" }, onChange: g, clearable: false }, null, 8, ["modelValue"]), r(m, { type: "enum", modelValue: t(e).status, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).status = o), options: f.value, "show-option-all": "", class: "filter-item", onChange: t(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(m, { type: "enum", modelValue: t(e).weightStatus, "onUpdate:modelValue": a[2] || (a[2] = (o) => t(e).weightStatus = o), options: h.value, class: "filter-item", onChange: t(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(D, { modelValue: t(e).workshopId, "onUpdate:modelValue": a[3] || (a[3] = (o) => t(e).workshopId = o), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: t(n).toQuery }, null, 8, ["modelValue", "onChange"])]), d("div", null, [_(s.$slots, "viewLeft")])], 512), [[O, t(n).searchToggle]])]);
  };
} };
export {
  P as default
};
