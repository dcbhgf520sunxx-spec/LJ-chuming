import { computed as p } from "vue";
import { ref as C } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as x } from "vue";
import { vShow as E } from "vue";
import { unref as e } from "vue";
import { createElementVNode as Q } from "vue";
import { createVNode as n } from "vue";
import { withKeys as f } from "vue";
import { withCtx as l } from "vue";
import { createBlock as _ } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as V } from "vue";
import { ElInput as U } from "element-plus";
import { _ as I, ib as r, ig as y, i as h, B as A, C as B, G as w, b as D, L as K, ih as j, E as O, ii as P } from "../../../../../shared/runtime.js";
const R = { class: "head-container" }, T = { __name: "header", setup(q) {
  const b = { serialNumber: void 0, projectName: void 0, reviewStatus: r.PASS.V, boolQuote: y.NOT_USED.V }, g = p(() => [r.PASS, r.AUDITING, r.CANCEL]), N = p(() => h(t.selections) ? t.selections[0] : {}), { crud: t, query: s } = A(b), i = C(false);
  return (z, o) => {
    const d = c("common-radio-button"), m = U, S = c("common-button");
    return u(), k("div", R, [x(Q("div", null, [n(d, { modelValue: e(s).reviewStatus, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(s).reviewStatus = a), options: g.value, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(d, { modelValue: e(s).boolQuote, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(s).boolQuote = a), options: e(y).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(m, { modelValue: e(s).preRegistrationNo, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(s).preRegistrationNo = a), class: "filter-item", clearable: "", placeholder: "预登记单号检索", size: "default", style: { width: "200px" }, onKeyup: f(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(m, { modelValue: e(s).projectName, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(s).projectName = a), class: "filter-item", clearable: "", placeholder: "项目名称检索", size: "default", style: { width: "200px" }, onKeyup: f(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(B))], 512), [[E, e(t).searchToggle]]), n(e(O), { "add-text": "合同预登记申请" }, { optRight: l(() => [e(w)(e(t).permission.reviewAdd) ? (u(), _(S, { key: 0, type: "warning", size: "default", disabled: e(D)(e(t).selections), onClick: o[4] || (o[4] = (a) => i.value = true) }, { default: l(() => o[6] || (o[6] = [v("发起评审登记申请")])), _: 1, __: [6] }, 8, ["disabled"])) : V("", true)]), viewLeft: l(() => [e(w)(e(t).permission.download) ? (u(), _(K, { key: 0, fn: e(j), params: e(t).query, class: "filter-item" }, { default: l(() => o[7] || (o[7] = [v(" 合同预登记信息下载 ")])), _: 1, __: [7] }, 8, ["fn", "params"])) : V("", true)]), _: 1 }), n(P, { modelValue: i.value, "onUpdate:modelValue": o[5] || (o[5] = (a) => i.value = a), detailInfo: N.value, onSuccess: e(t).toQuery }, null, 8, ["modelValue", "detailInfo", "onSuccess"])]);
  };
} }, F = I(T, [["__scopeId", "data-v-7d729ea7"]]);
export {
  F as default
};
