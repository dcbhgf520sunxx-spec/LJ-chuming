import { ref as i } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as c } from "vue";
import { toDisplayString as p } from "vue";
import { unref as r } from "vue";
import { ElInput as v } from "element-plus";
import { ElTableColumn as y } from "element-plus";
import { _ as I } from "../../components/table-config-card.vue.js";
import { dE as d, dv as F } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const O = { key: 1 }, T = { key: 1 }, B = { __name: "difficulty-factor", props: { permission: { type: Object, default: () => {
} } }, setup(_) {
  const f = i({ name: [{ required: true, message: "请填写系数值", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), t = i(false);
  function g(o) {
    t.value = o;
  }
  function b(o) {
    t.value = o;
  }
  function C(o) {
    t.value = o;
  }
  return (o, k) => {
    const h = v, m = y, E = V("common-input-number");
    return n(), l(I, { title: r(d).DIFFICULTY_FACTOR_CONFIG.L, "config-enum": r(d).DIFFICULTY_FACTOR_CONFIG.V, "page-type": r(F).PROJECT_INFORMATION.V, tableRules: f.value, permission: _.permission, onEdit: g, onCancelEdit: b, onSubmitSuccess: C }, { tableColumn: s(() => [u(m, { align: "center", label: "系数值", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(h, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写系数值" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", O, p(e.name), 1))]), _: 1 }), u(m, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(E, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", T, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules", "permission"]);
  };
} };
export {
  B as default
};
