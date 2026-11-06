import { ref as r } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as c } from "vue";
import { createElementBlock as i } from "vue";
import { toDisplayString as p } from "vue";
import { unref as u } from "vue";
import { ElInput as v } from "element-plus";
import { ElTableColumn as y } from "element-plus";
import { _ as C } from "../../components/table-config-card.vue.js";
import { dw as d, dv as T } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const k = { key: 1 }, A = { key: 1 }, R = { __name: "evaluation-method", setup(N) {
  const _ = r({ name: [{ required: true, message: "请填写评价方式", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), o = r(false);
  function f(t) {
    o.value = t;
  }
  function g(t) {
    o.value = t;
  }
  function E(t) {
    o.value = t;
  }
  return (t, O) => {
    const b = v, m = y, h = V("common-input-number");
    return n(), l(C, { title: u(d).EVALUATION_METHOD_CONFIG.L, "config-enum": u(d).EVALUATION_METHOD_CONFIG.V, "page-type": u(T).TENDER_APPLY.V, allowEmpty: true, tableRules: _.value, onEdit: f, onCancelEdit: g, onSubmitSuccess: E }, { tableColumn: s(() => [c(m, { align: "center", label: "评价方式", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [o.value ? (n(), l(b, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写评价方式" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), i("span", k, p(e.name), 1))]), _: 1 }), c(m, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [o.value ? (n(), l(h, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), i("span", A, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules"]);
  };
} };
export {
  R as default
};
