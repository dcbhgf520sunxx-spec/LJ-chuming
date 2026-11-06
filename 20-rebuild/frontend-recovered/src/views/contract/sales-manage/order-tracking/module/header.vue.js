import { resolveComponent as i } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as u } from "vue";
import { vShow as h } from "vue";
import { unref as e } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as n } from "vue";
import { withCtx as E } from "vue";
import { ElInput as T } from "element-plus";
import { ElDatePicker as U } from "element-plus";
import { m as w, B as v, iw as Y, c1 as p, bi as r, C as b, E as k } from "../../../../../shared/runtime.js";
const z = { class: "head-container" }, Q = { __name: "header", setup(N) {
  const { flag: d } = w(["flag"]), m = { year: void 0, projectStatus: void 0, orderSourceType: void 0 }, { crud: l, query: o } = v(m);
  return (R, t) => {
    const s = i("common-radio-button"), c = T, f = U, y = i("print-table"), V = _("permission");
    return S(), g("div", z, [u(C("div", null, [n(s, { modelValue: e(o).orderSourceType, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).orderSourceType = a), options: e(Y).ENUM, showOptionAll: "", type: "enumSL", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).projectStatus, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).projectStatus = a), options: e(p).ENUM, unshowVal: [e(p).SUSPEND.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), n(c, { modelValue: e(o).name, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).name = a), placeholder: "项目名称", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"]), n(s, { modelValue: e(o).productType, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).productType = a), options: e(d) ? [e(r).STRUCTURE] : [e(r).STRUCTURE, e(r).ENCLOSURE], default: "", type: "enumSL", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(f, { modelValue: e(o).year, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).year = a), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px!important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(b))], 512), [[h, e(l).searchToggle]]), n(e(k), null, { viewLeft: E(() => [u(n(y, { "api-key": "saleOrderTracking", params: { ...e(o) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[V, e(l).permission.print]])]), _: 1 })]);
  };
} };
export {
  Q as default
};
