import { resolveComponent as p } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as f } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as s } from "vue";
import { withKeys as d } from "vue";
import { withCtx as i } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as g } from "vue";
import { ElInput as w } from "element-plus";
import { a as N } from "../../../../../modules/direct-register-2e5c9d69.js";
import { _ as v, B as x, au as b, C, G as k, L as B, E } from "../../../../../shared/runtime.js";
const K = { class: "head-container" }, j = { __name: "header", setup(D) {
  const u = { registrationNo: void 0, projectName: void 0 }, { crud: o, query: t } = x(u);
  return (Q, a) => {
    const n = w, m = p("common-select");
    return r(), c("div", K, [_(y("div", null, [s(n, { modelValue: e(t).registrationNo, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).registrationNo = l), class: "filter-item", clearable: "", placeholder: "直接登记单号检索", size: "default", style: { width: "200px" }, onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(n, { modelValue: e(t).projectName, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).projectName = l), class: "filter-item", clearable: "", placeholder: "合同名称检索", size: "default", style: { width: "200px" }, onKeyup: d(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(m, { modelValue: e(t).boolSupplement, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).boolSupplement = l), options: e(b).ENUM, type: "enum", size: "default", clearable: "", style: { width: "200px" }, class: "filter-item", placeholder: "是否增补合同", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(e(C))], 512), [[f, e(o).searchToggle]]), s(e(E), { "add-text": "合同直接登记申请" }, { viewLeft: i(() => [e(k)(e(o).permission.download) ? (r(), h(B, { key: 0, fn: e(N), params: e(o).query, class: "filter-item" }, { default: i(() => a[3] || (a[3] = [V(" 合同直接登记信息下载 ")])), _: 1, __: [3] }, 8, ["fn", "params"])) : g("", true)]), _: 1 })]);
  };
} }, S = v(j, [["__scopeId", "data-v-28911a41"]]);
export {
  S as default
};
