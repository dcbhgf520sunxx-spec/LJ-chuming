import { ref as u } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { createElementBlock as c } from "vue";
import { toDisplayString as p } from "vue";
import { unref as r } from "vue";
import { ElInput as v } from "element-plus";
import { ElTableColumn as y } from "element-plus";
import { _ as T } from "../../components/table-config-card.vue.js";
import { dE as d, dv as R } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const U = { key: 1 }, k = { key: 1 }, B = { __name: "structure-type", props: { permission: { type: Object, default: () => {
} } }, setup(_) {
  const f = u({ name: [{ required: true, message: "请填写结构类型", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), o = u(false);
  function g(t) {
    o.value = t;
  }
  function b(t) {
    o.value = t;
  }
  function E(t) {
    o.value = t;
  }
  return (t, I) => {
    const h = v, m = y, C = V("common-input-number");
    return n(), l(T, { title: r(d).STRUCTURE_TYPE_CONFIG.L, "config-enum": r(d).STRUCTURE_TYPE_CONFIG.V, "page-type": r(R).PROJECT_INFORMATION.V, tableRules: f.value, permission: _.permission, onEdit: g, onCancelEdit: b, onSubmitSuccess: E }, { tableColumn: s(() => [i(m, { align: "center", label: "结构类型", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [o.value ? (n(), l(h, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写结构类型" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", U, p(e.name), 1))]), _: 1 }), i(m, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [o.value ? (n(), l(C, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", k, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules", "permission"]);
  };
} };
export {
  B as default
};
