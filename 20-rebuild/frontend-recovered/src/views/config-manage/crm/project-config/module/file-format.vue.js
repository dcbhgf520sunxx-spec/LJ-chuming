import { ref as i } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as c } from "vue";
import { toDisplayString as p } from "vue";
import { unref as m } from "vue";
import { ElInput as y } from "element-plus";
import { ElTableColumn as C } from "element-plus";
import { _ as k } from "../../components/table-config-card.vue.js";
import { dE as d, dv as R } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const I = { key: 1 }, O = { key: 1 }, L = { __name: "file-format", props: { permission: { type: Object, default: () => {
} } }, setup(_) {
  const f = i({ name: [{ required: true, message: "请填写格式类型", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), t = i(false);
  function g(o) {
    t.value = o;
  }
  function b(o) {
    t.value = o;
  }
  function E(o) {
    t.value = o;
  }
  return (o, T) => {
    const h = y, r = C, V = v("common-input-number");
    return n(), l(k, { title: m(d).FILE_FORMAT.L, "config-enum": m(d).FILE_FORMAT.V, "page-type": m(R).PROJECT_INFORMATION.V, tableRules: f.value, permission: _.permission, onEdit: g, onCancelEdit: b, onSubmitSuccess: E }, { tableColumn: s(() => [u(r, { align: "center", label: "格式类型", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(h, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写格式类型" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", I, p(e.name), 1))]), _: 1 }), u(r, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [t.value ? (n(), l(V, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), c("span", O, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules", "permission"]);
  };
} };
export {
  L as default
};
