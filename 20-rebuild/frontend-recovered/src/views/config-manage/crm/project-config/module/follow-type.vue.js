import { ref as u } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { createElementBlock as c } from "vue";
import { toDisplayString as p } from "vue";
import { unref as m } from "vue";
import { ElInput as y } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { _ as C } from "../../components/table-config-card.vue.js";
import { dE as d, dv as k } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const T = { key: 1 }, U = { key: 1 }, w = { __name: "follow-type", props: { permission: { type: Object, default: () => {
} } }, setup(_) {
  const f = u({ name: [{ required: true, message: "请填写跟进方式", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), t = u(false);
  function g(o) {
    t.value = o;
  }
  function b(o) {
    t.value = o;
  }
  function E(o) {
    t.value = o;
  }
  return (o, L) => {
    const h = y, r = O, V = v("common-input-number");
    return n(), l(C, { title: m(d).FOLLOW_UP_METHODS.L, "config-enum": m(d).FOLLOW_UP_METHODS.V, "page-type": m(k).PROJECT_INFORMATION.V, tableRules: f.value, permission: _.permission, onEdit: g, onCancelEdit: b, onSubmitSuccess: E }, { tableColumn: s(() => [i(r, { align: "center", label: "跟进方式", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(h, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写跟进方式" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", T, p(e.name), 1))]), _: 1 }), i(r, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(V, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", U, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules", "permission"]);
  };
} };
export {
  w as default
};
