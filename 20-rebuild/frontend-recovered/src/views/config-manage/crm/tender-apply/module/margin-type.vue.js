import { ref as u } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as o } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as c } from "vue";
import { createElementBlock as i } from "vue";
import { toDisplayString as p } from "vue";
import { unref as m } from "vue";
import { ElInput as v } from "element-plus";
import { ElTableColumn as y } from "element-plus";
import { _ as C } from "../../components/table-config-card.vue.js";
import { dw as _, dv as R } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const k = { key: 1 }, P = { key: 1 }, F = { __name: "margin-type", setup(N) {
  const d = u({ name: [{ required: true, message: "请填写履约保证金类型", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), n = u(false);
  function g(t) {
    n.value = t;
  }
  function f(t) {
    n.value = t;
  }
  function E(t) {
    n.value = t;
  }
  return (t, O) => {
    const b = v, r = y, h = V("common-input-number");
    return o(), l(C, { title: m(_).TYPE_OF_PERFORMANCE_BOND.L, "config-enum": m(_).TYPE_OF_PERFORMANCE_BOND.V, "page-type": m(R).TENDER_APPLY.V, tableRules: d.value, onEdit: g, onCancelEdit: f, onSubmitSuccess: E }, { tableColumn: s(() => [c(r, { align: "center", label: "履约保证金类型", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [n.value ? (o(), l(b, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写履约保证金类型" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), i("span", k, p(e.name), 1))]), _: 1 }), c(r, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [n.value ? (o(), l(h, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), i("span", P, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules"]);
  };
} };
export {
  F as default
};
