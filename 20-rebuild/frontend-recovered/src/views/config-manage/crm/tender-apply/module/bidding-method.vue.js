import { ref as r } from "vue";
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
import { dw as d, dv as D } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const k = { key: 1 }, I = { key: 1 }, U = { __name: "bidding-method", setup(N) {
  const _ = r({ name: [{ required: true, message: "请填写招标方式", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), n = r(false);
  function g(t) {
    n.value = t;
  }
  function f(t) {
    n.value = t;
  }
  function b(t) {
    n.value = t;
  }
  return (t, T) => {
    const h = v, u = y, E = V("common-input-number");
    return o(), l(C, { title: m(d).BIDDING_METHOD_CONFIG.L, "config-enum": m(d).BIDDING_METHOD_CONFIG.V, "page-type": m(D).TENDER_APPLY.V, tableRules: _.value, onEdit: g, onCancelEdit: f, onSubmitSuccess: b }, { tableColumn: s(() => [c(u, { align: "center", label: "招标方式", prop: "name", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [n.value ? (o(), l(h, { key: 0, modelValue: e.name, "onUpdate:modelValue": (a) => e.name = a, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写战招标方式" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), i("span", k, p(e.name), 1))]), _: 1 }), c(u, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [n.value ? (o(), l(E, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (a) => e.sort = a, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), i("span", I, p(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "tableRules"]);
  };
} };
export {
  U as default
};
