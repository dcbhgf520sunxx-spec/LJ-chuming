import o from "moment";
import { resolveComponent as i } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as m } from "vue";
import { withDirectives as _ } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { vShow as g } from "vue";
import { ElDatePicker as O } from "element-plus";
import { F as v, B as C, I as D, C as V, E as y } from "../../../../../shared/runtime.js";
const B = { __name: "header", setup(T) {
  const l = { date: [o().startOf("month").valueOf(), o().valueOf()], startDate: o().startOf("month").valueOf(), endDate: o().valueOf(), productType: v.BOX.V }, { crud: r, query: e } = C(l);
  function d() {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), r.toQuery();
  }
  return (b, a) => {
    const u = i("project-radio-button"), c = O;
    return p(), f(t(y), null, { optLeft: m(() => [_(h("div", null, [s(u, { size: "default", modelValue: t(e).projectId, "onUpdate:modelValue": a[0] || (a[0] = (n) => t(e).projectId = n), class: "filter-item", onChange: t(r).toQuery }, null, 8, ["modelValue", "onChange"]), s(c, { modelValue: t(e).date, "onUpdate:modelValue": a[1] || (a[1] = (n) => t(e).date = n), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: false, shortcuts: t(D), "value-format": "x", onChange: d }, null, 8, ["modelValue", "shortcuts"]), s(t(V))], 512), [[g, t(r).searchToggle]])]), _: 1 });
  };
} };
export {
  B as default
};
