import { resolveComponent as m } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as i } from "vue";
import { withDirectives as d } from "vue";
import { vShow as p } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as t } from "vue";
import { withKeys as f } from "vue";
import { ElInput as y } from "element-plus";
import { B as h, cJ as V, C as v, E as b } from "../../../../../shared/runtime.js";
const g = { class: "head-container" }, B = { __name: "header", setup(w) {
  const n = {}, { crud: l, query: a } = h(n);
  return (C, o) => {
    const r = y, u = m("common-select");
    return c(), i("div", g, [d(_("div", null, [t(r, { modelValue: e(a).serialNumber, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(a).serialNumber = s), class: "filter-item", clearable: "", placeholder: "配套件名称检索", size: "default", style: { width: "200px" }, onKeyup: f(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(u, { modelValue: e(a).materialType, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(a).materialType = s), options: e(V).ENUM, class: "filter-item", clearable: "", placeholder: "可关联物料类型检索", size: "default", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(e(v))], 512), [[p, e(l).searchToggle]]), t(e(b))]);
  };
} };
export {
  B as default
};
