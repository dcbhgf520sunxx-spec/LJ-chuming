import _ from "moment";
import { openBlock as u } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as m } from "vue";
import { ElDatePicker as f } from "element-plus";
import { ElTag as x } from "element-plus";
import { _ as y, B as g } from "../../../../../shared/runtime.js";
import { _ as h } from "../../../../../modules/project-visa-select-e1b3658e.js";
const V = { class: "head-container flex" }, v = { __name: "header", setup(k) {
  const r = { selectedDate: _().valueOf(), projectId: void 0 }, { crud: s, query: t } = g(r);
  return (D, a) => {
    const n = f, c = x;
    return u(), p("div", V, [d("div", null, [o(n, { style: { width: "140px" }, modelValue: e(t).selectedDate, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).selectedDate = l), type: "date", size: "default", class: "filter-item", format: "YYYY-MM-DD", "value-format": "x", clearable: false, placeholder: "请选择日期", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(h), { modelValue: e(t).projectId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).projectId = l), class: "filter-item", style: { width: "300px" }, placeholder: "可选择项目搜索", clearable: "", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"])]), d("div", null, [o(c, { type: "success", size: "large" }, { default: i(() => a[2] || (a[2] = [m(" 计件模式：入库反推模式 ")])), _: 1, __: [2] })])]);
  };
} }, j = y(v, [["__scopeId", "data-v-dd65bcc6"]]);
export {
  j as default
};
