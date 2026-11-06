import o from "moment";
import { resolveComponent as i } from "vue";
import { openBlock as f } from "vue";
import { createBlock as p } from "vue";
import { withCtx as m } from "vue";
import { withDirectives as _ } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { vShow as g } from "vue";
import { ElDatePicker as v } from "element-plus";
import { B as O, I as C, C as D, E as V } from "../../../../../shared/runtime.js";
const b = { __name: "header", setup(y) {
  const s = { date: [o().startOf("month").valueOf(), o().valueOf()], startDate: o().startOf("month").valueOf(), endDate: o().valueOf() }, { crud: r, query: e } = O(s);
  function d() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), r.toQuery();
  }
  return (k, a) => {
    const u = i("project-radio-button"), c = v;
    return f(), p(t(V), null, { optLeft: m(() => [_(h("div", null, [n(u, { size: "default", modelValue: t(e).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => t(e).projectId = l), class: "filter-item", onChange: t(r).toQuery }, null, 8, ["modelValue", "onChange"]), n(c, { modelValue: t(e).date, "onUpdate:modelValue": a[1] || (a[1] = (l) => t(e).date = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: t(C), "value-format": "x", onChange: d }, null, 8, ["modelValue", "shortcuts"]), n(t(D))], 512), [[g, t(r).searchToggle]])]), _: 1 });
  };
} };
export {
  b as default
};
