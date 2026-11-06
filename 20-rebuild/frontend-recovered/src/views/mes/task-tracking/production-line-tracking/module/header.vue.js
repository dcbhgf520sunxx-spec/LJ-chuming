import u from "moment";
import { ref as i } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as n } from "vue";
import { withCtx as _ } from "vue";
import { unref as t } from "vue";
import { ElDatePicker as V } from "element-plus";
import { bo as d, B as C, a3 as s, I as S, aV as w, C as E, E as k } from "../../../../../shared/runtime.js";
const I = { class: "head-container" }, A = { __name: "header", setup(O) {
  const p = { workShopId: void 0, productType: void 0, weightStatus: d.NET.V, date: void 0, startTime: u().subtract(1, "month").valueOf(), endTime: u().valueOf() }, { crud: l, query: e } = C(p), m = i([s.ARTIFACT, s.ASSEMBLE, s.MACHINE_PART]), c = i([d.NET, d.GROSS]);
  function f() {
    e.date && e.date.length > 1 ? (e.startTime = e.date[0], e.endTime = e.date[1]) : (e.startTime = void 0, e.endTime = void 0), l.toQuery();
  }
  return (b, o) => {
    const r = y("common-radio-button"), h = V;
    return T(), g("div", I, [n(t(k), null, { optLeft: _(() => [n(r, { modelValue: t(e).productType, "onUpdate:modelValue": o[0] || (o[0] = (a) => t(e).productType = a), options: m.value, showOptionAll: "", class: "filter-item", type: "enum", onChange: t(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(r, { type: "enum", modelValue: t(e).weightStatus, "onUpdate:modelValue": o[1] || (o[1] = (a) => t(e).weightStatus = a), options: c.value, class: "filter-item", onChange: t(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(h, { modelValue: t(e).date, "onUpdate:modelValue": o[2] || (o[2] = (a) => t(e).date = a), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", clearable: false, shortcuts: t(S), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: f }, null, 8, ["modelValue", "shortcuts"]), n(w, { ref: "workshopInfRef", modelValue: t(e).workShopId, "onUpdate:modelValue": o[3] || (o[3] = (a) => t(e).workShopId = a), placeholder: "请选择车间", "factory-id": t(e).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "", onChange: t(l).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), n(t(E))]), _: 1 })]);
  };
} };
export {
  A as default
};
