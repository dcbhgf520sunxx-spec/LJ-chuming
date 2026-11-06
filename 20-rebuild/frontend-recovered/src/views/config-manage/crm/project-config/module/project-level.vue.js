import { ref as u } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { createElementBlock as c } from "vue";
import { toDisplayString as p } from "vue";
import { unref as r } from "vue";
import { ElInput as v } from "element-plus";
import { ElTableColumn as y } from "element-plus";
import { _ as O } from "../../components/table-config-card.vue.js";
import { dE as d, dv as k } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const R = { key: 1 }, I = { key: 1 }, j = { __name: "project-level", props: { permission: { type: Object, default: () => {
} } }, setup(_) {
  const f = u({ name: [{ required: true, message: "请填写项目级别", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), t = u(false);
  function g(o) {
    t.value = o;
  }
  function E(o) {
    t.value = o;
  }
  function b(o) {
    t.value = o;
  }
  return (o, T) => {
    const V = v, m = y, h = C("common-input-number");
    return n(), l(O, { title: r(d).PROJECT_LEVEL_CONFIG.L, "config-enum": r(d).PROJECT_LEVEL_CONFIG.V, "page-type": r(k).PROJECT_INFORMATION.V, allowEmpty: true, tableRules: f.value, permission: _.permission, onEdit: g, onCancelEdit: E, onSubmitSuccess: b }, { tableColumn: s(() => [i(m, { align: "center", label: "项目级别", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(V, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "2", size: "small", class: "input-border-none", placeholder: "填写项目级别" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", R, p(e.name), 1))]), _: 1 }), i(m, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(h, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", I, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules", "permission"]);
  };
} };
export {
  j as default
};
