import l from "moment";
import { openBlock as i } from "vue";
import { createBlock as f } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as m } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as s } from "vue";
import { unref as a } from "vue";
import { vShow as h } from "vue";
import { ElDatePicker as _ } from "element-plus";
import { B as g, I as O, C as v, E as y } from "../../../../../shared/runtime.js";
import { _ as D } from "../../../../../modules/factory-select-b8d0a4ac.js";
const I = { __name: "header", setup(C) {
  const n = { date: [l().startOf("month").valueOf(), l().valueOf()], startDate: l().startOf("month").valueOf(), endDate: l().valueOf() }, { crud: o, query: e } = g(n);
  function d() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), o.toQuery();
  }
  return (V, t) => {
    const u = _;
    return i(), f(a(y), null, { optLeft: c(() => [m(p("div", null, [s(u, { modelValue: a(e).date, "onUpdate:modelValue": t[0] || (t[0] = (r) => a(e).date = r), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: a(O), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: d }, null, 8, ["modelValue", "shortcuts"]), s(D, { modelValue: a(e).factoryId, "onUpdate:modelValue": t[1] || (t[1] = (r) => a(e).factoryId = r), class: "filter-item", placeholder: "可选择工厂", clearable: "", style: { width: "200px" }, onChange: a(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(a(v))], 512), [[h, a(o).searchToggle]])]), _: 1 });
  };
} };
export {
  I as default
};
