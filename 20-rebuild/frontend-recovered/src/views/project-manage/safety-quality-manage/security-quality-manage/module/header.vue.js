import o from "moment";
import { watch as f } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as V } from "vue";
import { vShow as v } from "vue";
import { unref as e } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as s } from "vue";
import { ElDatePicker as b } from "element-plus";
import { B as D, u9 as E, u8 as O, ua as _, C as I, E as U } from "../../../../../shared/runtime.js";
const N = { class: "head-container" }, k = { __name: "header", props: { projectId: { type: Number } }, setup(p) {
  const r = p, i = { projectId: { value: void 0, resetAble: false }, date: [o().valueOf() - 31 * 60 * 60 * 24 * 1e3, o().valueOf()], startDate: o().valueOf() - 31 * 60 * 60 * 24 * 1e3, endDate: o().valueOf(), boolChangeStatusV2: void 0, isInternal: void 0, type: void 0 }, { crud: l, query: a } = D(i);
  function m() {
    a.date && a.date.length > 1 ? (a.startDate = o(a.date[0]).valueOf(), a.endDate = o(a.date[1]).valueOf()) : (a.startDate = o().valueOf() - 31 * 60 * 60 * 24 * 1e3, a.endDate = o().valueOf()), l.toQuery();
  }
  return f(() => r.projectId, (u) => {
    u && (l.query.projectId = r.projectId, l.toQuery());
  }, { immediate: true, deep: true }), (u, t) => {
    const c = b, d = y("common-select");
    return h(), g("div", N, [V(C("div", null, [s(c, { modelValue: e(a).date, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(a).date = n), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" }, onChange: m }, null, 8, ["modelValue"]), s(d, { modelValue: e(a).isInternal, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(a).isInternal = n), options: e(E).ENUM, class: "filter-item", placeholder: "责任分类", size: "default", type: "enum", clearable: "", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(d, { modelValue: e(a).type, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(a).type = n), options: e(O).ENUM, class: "filter-item", placeholder: "问题分类", size: "default", type: "enum", clearable: "", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(d, { modelValue: e(a).boolChangeStatusV2, "onUpdate:modelValue": t[3] || (t[3] = (n) => e(a).boolChangeStatusV2 = n), options: e(_).ENUM, class: "filter-item", placeholder: "状态", size: "default", type: "enum", clearable: "", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(e(I))], 512), [[v, e(l).searchToggle]]), s(e(U))]);
  };
} };
export {
  k as default
};
