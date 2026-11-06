import i from "moment";
import { computed as y } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as c } from "vue";
import { vShow as D } from "vue";
import { unref as t } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as r } from "vue";
import { withCtx as b } from "vue";
import { Fragment as I } from "vue";
import { ElMessage as k } from "element-plus";
import { ElDatePicker as B } from "element-plus";
import { B as x, i as P, I as S, C as T, E as w, b as E } from "../../../../../shared/runtime.js";
import { _ as j } from "../../../../../modules/factory-select-b8d0a4ac.js";
const q = { __name: "header", setup(N) {
  const p = { date: [i().startOf("month").valueOf(), i().valueOf()], startDate: i().startOf("month").valueOf(), endDate: i().valueOf() }, { crud: n, query: e } = x(p), d = y(() => {
    if (P(n.selections)) return n.selections.map((s) => {
      var a, l;
      return { ...n.query, factoryId: (a = s.factory) == null ? void 0 : a.id, productType: s.productType, productionLineId: (l = s.productionLine) == null ? void 0 : l.id };
    });
  });
  function m() {
    if (E(d.value)) return k.warning("至少选择一条需要打印的生产线信息"), false;
  }
  function f() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), n.toQuery();
  }
  return (s, a) => {
    const l = u("project-radio-button"), _ = B, h = u("print-table"), g = v("permission");
    return C(), V(I, null, [c(O("div", null, [r(l, { size: "default", modelValue: t(e).projectId, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).projectId = o), class: "filter-item", onChange: t(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(_, { modelValue: t(e).date, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).date = o), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: t(S), "value-format": "x", onChange: f }, null, 8, ["modelValue", "shortcuts"]), r(t(j), { modelValue: t(e).factoryId, "onUpdate:modelValue": a[2] || (a[2] = (o) => t(e).factoryId = o), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: t(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(t(T))], 512), [[D, t(n).searchToggle]]), r(t(w), null, { optRight: b(() => [c(r(h, { "api-key": "mesStructureProductionLine", params: d.value, "before-print": m, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[g, t(n).permission.print]])]), _: 1 })], 64);
  };
} };
export {
  q as default
};
