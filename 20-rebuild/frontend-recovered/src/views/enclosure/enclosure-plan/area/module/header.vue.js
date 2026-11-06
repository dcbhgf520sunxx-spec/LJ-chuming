import { openBlock as m } from "vue";
import { createElementBlock as i } from "vue";
import { withDirectives as p } from "vue";
import { vShow as c } from "vue";
import { unref as e } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as o } from "vue";
import { ElDatePicker as f } from "element-plus";
import { ElInput as _ } from "element-plus";
import { B as y, C as Y } from "../../../../../shared/runtime.js";
const N = { __name: "header", setup(V) {
  const d = { monomerId: void 0, productType: void 0, year: (/* @__PURE__ */ new Date()).getFullYear() + "" }, { crud: r, query: a } = y(d);
  return (h, t) => {
    const s = f, u = _;
    return m(), i("div", null, [p(n("div", null, [o(s, { modelValue: e(a).year, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).year = l), class: "date-item filter-item", format: "YYYY", placeholder: "选择年", size: "default", style: { width: "100px !important" }, type: "year", "value-format": "YYYY", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), n("div", null, [o(u, { modelValue: e(a).projectNoOrName, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).projectNoOrName = l), class: "filter-item", clearable: "", placeholder: "项目编号或项目名称", style: { width: "220px" } }, null, 8, ["modelValue"]), o(e(Y))])], 512), [[c, e(r).searchToggle]])]);
  };
} };
export {
  N as default
};
