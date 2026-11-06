import n from "moment";
import { ref as T } from "vue";
import { computed as v } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createElementVNode as V } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as g } from "vue";
import { withCtx as k } from "vue";
import { createTextVNode as x } from "vue";
import { ElDatePicker as E } from "element-plus";
import { s as L } from "../../../../../modules/personal-production-statistics-348e794f.js";
import { a3 as r, B as b, fv as w, C as A, L as B } from "../../../../../shared/runtime.js";
const I = { class: "flex-rbc" }, U = { __name: "header", setup(O) {
  const i = { dateTimeList: [n().subtract(1, "month").valueOf(), n().valueOf()], startDate: n().subtract(1, "month").valueOf(), endDate: n().valueOf(), projectId: void 0, taskTypeEnum: r.ARTIFACT.V }, m = T([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), u = v(() => [r.ARTIFACT, r.ASSEMBLE, r.MACHINE_PART]), { crud: s, query: e } = b(i);
  function p() {
    e.dateTimeList && e.dateTimeList.length > 1 ? (e.startDate = e.dateTimeList[0], e.endDate = e.dateTimeList[1]) : (e.startDate = void 0, e.endDate = void 0), s.toQuery();
  }
  return (j, a) => {
    const c = E, f = y("common-radio-button"), _ = h("permission");
    return d(), D("div", null, [l(c, { modelValue: t(e).dateTimeList, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).dateTimeList = o), "default-time": m.value, class: "filter-item date-item", "end-placeholder": "结束时间", "range-separator": ":", size: "default", "start-placeholder": "开始时间", style: { width: "240px" }, type: "daterange", "value-format": "x", onChange: p }, null, 8, ["modelValue", "default-time"]), l(t(w), { modelValue: t(e).projectId, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).projectId = o), class: "filter-item", style: { width: "300px" }, filterable: "", clearable: "", placeholder: "可选择项目搜索", onChange: t(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(t(A)), V("div", I, [l(f, { modelValue: t(e).taskTypeEnum, "onUpdate:modelValue": a[2] || (a[2] = (o) => t(e).taskTypeEnum = o), options: u.value, size: "default", type: "enum", onChange: t(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), C((d(), g(t(B), { fn: t(L), params: t(e), "response-header-result": "" }, { default: k(() => a[3] || (a[3] = [x(" 导出产量汇总表 ")])), _: 1, __: [3] }, 8, ["fn", "params"])), [[_, t(s).permission.export]])])]);
  };
} };
export {
  U as default
};
