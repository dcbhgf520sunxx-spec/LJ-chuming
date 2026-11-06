import { _ as p, B as i, iF as m, jJ as _, lo as c, E as f } from "../../../../shared/runtime.js";
import { resolveComponent as y } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as r } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createCommentVNode as V } from "vue";
const b = { class: "head-container" }, g = { key: 0 }, h = { __name: "header", setup(v) {
  const d = { status: void 0, supplierId: void 0 }, { crud: a, query: t } = i(d);
  return (C, o) => {
    const u = y("common-radio-button");
    return l(), r("div", b, [e(a).searchToggle ? (l(), r("div", g, [s(u, { modelValue: e(t).status, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(t).status = n), options: e(m).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(c, { modelValue: e(t).supplierId, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(t).supplierId = n), type: e(_).RAW_MATERIAL.V, mode: "contain", clearable: "", filterable: "", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "type", "onChange"])])) : V("", true), s(e(f), { addText: "创建年度合同" })]);
  };
} }, I = p(h, [["__scopeId", "data-v-7701b047"]]);
export {
  I as default
};
