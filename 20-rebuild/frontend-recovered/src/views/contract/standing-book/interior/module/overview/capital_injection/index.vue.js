import { ref as u } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as a } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as s } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as d } from "vue";
import { ElRadioButton as p } from "element-plus";
import { ElRadioGroup as c } from "element-plus";
import f from "./detail.vue.js";
import x from "./use-detail.vue.js";
import { _ as v } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/index-1f7d934b.js";
import "../../../../../../../modules/capital-de0d42db.js";
import "../../../components/purchase-select.vue.js";
const V = { class: "header box-container" }, k = { __name: "index", setup(y) {
  const t = u("detail");
  return (b, e) => {
    const r = p, i = c;
    return o(), m("div", V, [a(i, { modelValue: t.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => t.value = n), class: "box-container", size: "default" }, { default: l(() => [a(r, { value: "detail" }, { default: l(() => e[1] || (e[1] = [s("注资明细")])), _: 1, __: [1] }), a(r, { value: "use_detail" }, { default: l(() => e[2] || (e[2] = [s("支出明细")])), _: 1, __: [2] })]), _: 1 }, 8, ["modelValue"]), t.value === "detail" ? (o(), _(f, { key: 0 })) : d("", true), t.value === "use_detail" ? (o(), _(x, { key: 1 })) : d("", true)]);
  };
} }, R = v(k, [["__scopeId", "data-v-89ff44c8"]]);
export {
  R as default
};
