import { openBlock as i } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as l } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as m } from "vue";
import { createElementVNode as c } from "vue";
import { unref as e } from "vue";
import { withKeys as _ } from "vue";
import { vShow as f } from "vue";
import { ElDatePicker as y } from "element-plus";
import { ElInput as h } from "element-plus";
import { B as Y, C as V, E as g } from "../../../../../shared/runtime.js";
const w = { class: "head-container" }, B = { __name: "header", setup(v) {
  const s = { year: String((/* @__PURE__ */ new Date()).getFullYear()), supplierName: void 0 }, { crud: o, query: a } = Y(s);
  return (x, t) => {
    const n = y, u = h;
    return i(), d("div", w, [l(e(g), null, { optLeft: p(() => [m(c("div", null, [l(n, { modelValue: e(a).year, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(a).year = r), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px!important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), l(u, { modelValue: e(a).supplierName, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(a).supplierName = r), placeholder: "物流公司", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: _(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(V))], 512), [[f, e(o).searchToggle]])]), _: 1 })]);
  };
} };
export {
  B as default
};
