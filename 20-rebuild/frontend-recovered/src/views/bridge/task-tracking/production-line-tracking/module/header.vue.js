import r from "moment";
import { ref as c } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { ElDatePicker as y } from "element-plus";
import { F as d, B as T, I as g, aV as C, C as V } from "../../../../../shared/runtime.js";
const k = { class: "head-container" }, v = { __name: "header", setup(I) {
  const s = { workShopId: void 0, productType: void 0, date: void 0, startTime: r().subtract(1, "month").valueOf(), endTime: r().valueOf() }, u = c([d.BOX, d.CELL, d.MACHINE_PART]), { crud: l, query: e } = T(s);
  function i() {
    e.date && e.date.length > 1 ? (e.startTime = e.date[0], e.endTime = e.date[1]) : (e.startTime = void 0, e.endTime = void 0), l.toQuery();
  }
  return (O, a) => {
    const m = f("common-radio-button"), p = y;
    return h(), _("div", k, [n(m, { modelValue: t(e).productType, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).productType = o), options: u.value, showOptionAll: "", class: "filter-item", type: "enum", onChange: t(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(p, { modelValue: t(e).date, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).date = o), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", clearable: false, shortcuts: t(g), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: i }, null, 8, ["modelValue", "shortcuts"]), n(t(C), { ref: "workshopInfRef", modelValue: t(e).workShopId, "onUpdate:modelValue": a[2] || (a[2] = (o) => t(e).workShopId = o), placeholder: "请选择车间", "factory-id": t(e).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", defaultValue: "", onChange: t(l).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), n(t(V))]);
  };
} };
export {
  v as default
};
