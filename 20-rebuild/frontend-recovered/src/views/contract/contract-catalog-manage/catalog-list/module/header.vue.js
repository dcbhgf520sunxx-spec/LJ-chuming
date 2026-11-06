import { ref as N } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as g } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as l } from "vue";
import { withKeys as p } from "vue";
import { withCtx as s } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as f } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElInput as S } from "element-plus";
import { a as h } from "../../../../../modules/catalog-list-6b93ea83.js";
import { _ as x, B as U, i3 as E, i4 as k, i2 as Q, C as B, G as y, L as K, E as O } from "../../../../../shared/runtime.js";
import j from "./serialNumber-table.vue.js";
const L = { class: "head-container" }, q = { __name: "header", setup(z) {
  const b = { boolContractNumber: void 0, createSource: void 0, contractNumber: void 0, projectName: void 0 }, { crud: t, query: n } = U(b), r = N(false);
  return (A, o) => {
    const u = m("common-radio-button"), d = S, V = m("common-button");
    return i(), v("div", L, [g(C("div", null, [l(u, { modelValue: e(n).boolContractNumber, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(n).boolContractNumber = a), options: e(E).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(u, { modelValue: e(n).createSource, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(n).createSource = a), options: e(k).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(u, { modelValue: e(n).reviewStatus, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(n).reviewStatus = a), options: e(Q).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(d, { modelValue: e(n).contractNumber, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(n).contractNumber = a), class: "filter-item", clearable: "", placeholder: "合同编号检索", size: "default", style: { width: "200px" }, onKeyup: p(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(d, { modelValue: e(n).projectName, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(n).projectName = a), class: "filter-item", clearable: "", placeholder: "合同名称检索", size: "default", style: { width: "200px" }, onKeyup: p(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(B))], 512), [[w, e(t).searchToggle]]), l(e(O), { "add-text": "合同评审申请" }, { optLeft: s(() => [e(y)(e(t).permission.edit) ? (i(), c(V, { key: 0, size: "default", type: "primary", disabled: !e(t).selections.length, onClick: o[5] || (o[5] = (a) => r.value = true) }, { default: s(() => o[7] || (o[7] = [f("合同编号录入")])), _: 1, __: [7] }, 8, ["disabled"])) : _("", true)]), viewLeft: s(() => [e(y)(e(t).permission.download) ? (i(), c(K, { key: 0, fn: e(h), params: e(t).query, class: "filter-item" }, { default: s(() => o[8] || (o[8] = [f(" 合同直接登记信息下载 ")])), _: 1, __: [8] }, 8, ["fn", "params"])) : _("", true)]), _: 1 }), l(j, { modelValue: r.value, "onUpdate:modelValue": o[6] || (o[6] = (a) => r.value = a), selections: e(t).selections, onSuccess: e(t).toQuery }, null, 8, ["modelValue", "selections", "onSuccess"])]);
  };
} }, H = x(q, [["__scopeId", "data-v-586d2a17"]]);
export {
  H as default
};
