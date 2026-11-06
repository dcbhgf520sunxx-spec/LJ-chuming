import { ref as c } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as f } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as n } from "vue";
import { vShow as _ } from "vue";
import { unref as e } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as m } from "vue";
import { createBlock as V } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as g } from "vue";
import { B as q, q as j } from "../../../../../shared/runtime.js";
import B from "./subcontract-account.vue.js";
import "../../../../../modules/subcontract-plan-b05fc818.js";
const C = { style: { display: "float" } }, h = { __name: "header", setup(I) {
  const d = { monomerId: void 0 }, { crud: t, query: r } = q(d), l = c(false);
  return (k, o) => {
    const i = p("common-button"), u = f("permission");
    return s(), v("div", null, [n(y("div", C, [m(e(j), { ref: "monomerSelectRef", modelValue: e(r).monomerId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(r).monomerId = a), "project-id": e(r).projectId, default: false, clearable: "", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "project-id", "onChange"]), n((s(), V(i, { size: "default", type: "primary", onClick: o[1] || (o[1] = (a) => l.value = true), style: { float: "right" }, disabled: !e(r).projectId }, { default: b(() => o[3] || (o[3] = [g("分包登陆账号")])), _: 1, __: [3] }, 8, ["disabled"])), [[u, e(t).permission.account]])], 512), [[_, e(t).searchToggle]]), m(e(B), { modelValue: l.value, "onUpdate:modelValue": o[2] || (o[2] = (a) => l.value = a), query: e(t).query }, null, 8, ["modelValue", "query"])]);
  };
} };
export {
  h as default
};
