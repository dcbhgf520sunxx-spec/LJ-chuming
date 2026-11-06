import { ref as r } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as o } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { createVNode as c } from "vue";
import { createElementBlock as i } from "vue";
import { toDisplayString as p } from "vue";
import { unref as m } from "vue";
import { ElInput as V } from "element-plus";
import { ElTableColumn as v } from "element-plus";
import { _ as y } from "../../components/table-config-card.vue.js";
import { dw as d, dv as k } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const C = { key: 1 }, S = { key: 1 }, w = { __name: "settlement-method", setup(x) {
  const _ = r({ name: [{ required: true, message: "请填写结算方式", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), n = r(false);
  function f(t) {
    n.value = t;
  }
  function g(t) {
    n.value = t;
  }
  function E(t) {
    n.value = t;
  }
  return (t, D) => {
    const b = V, u = v, h = T("common-input-number");
    return o(), l(y, { title: m(d).SETTLEMENT_METHOD.L, "config-enum": m(d).SETTLEMENT_METHOD.V, "page-type": m(k).TENDER_APPLY.V, tableRules: _.value, onEdit: f, onCancelEdit: g, onSubmitSuccess: E }, { tableColumn: s(() => [c(u, { align: "center", label: "结算方式", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [n.value ? (o(), l(b, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写结算方式" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), i("span", C, p(e.name), 1))]), _: 1 }), c(u, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [n.value ? (o(), l(h, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), i("span", S, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules"]);
  };
} };
export {
  w as default
};
