import { ref as m } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as n } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { createVNode as i } from "vue";
import { unref as s } from "vue";
import { createElementBlock as _ } from "vue";
import { toDisplayString as f } from "vue";
import { ElInput as R } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { _ as P } from "../../components/table-config-card.vue.js";
import { dH as g, dw as E, dv as S } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const U = { key: 1 }, x = { key: 1 }, Y = { __name: "work-content-type", setup(B) {
  const a = m(g.SPECIAL_PROGRAMS.V), b = m({ name: [{ required: true, message: "请填写工作内容类型", trigger: "change" }], sort: [{ required: true, message: "请填写排序", trigger: "change" }] }), o = m(false);
  function h(t) {
    o.value = t;
  }
  function v(t) {
    a.value = t, o.value = false;
  }
  function V(t) {
    o.value = t;
  }
  function y(t) {
    o.value = t;
  }
  return (t, c) => {
    const C = d("common-radio-button"), T = R, p = N, k = d("common-input-number");
    return n(), r(P, { title: s(E).WORK_CONTENT_TYPE.L, "config-enum": s(E).WORK_CONTENT_TYPE.V, otherEnum: a.value, "page-type": s(S).TENDER_APPLY.V, tableRules: b.value, onEdit: h, onCancelEdit: V, onSubmitSuccess: y }, { filterBtn: l(() => [i(C, { class: "filter-item", modelValue: a.value, "onUpdate:modelValue": c[0] || (c[0] = (e) => a.value = e), size: "default", default: "", type: "enum", style: { "margin-bottom": "20px" }, options: s(g).ENUM, onChange: v }, null, 8, ["modelValue", "options"])]), tableColumn: l(() => [i(p, { align: "center", label: "工作内容类型", prop: "name", "show-overflow-tooltip": true }, { default: l(({ row: e }) => [o.value ? (n(), r(T, { key: 0, modelValue: e.name, "onUpdate:modelValue": (u) => e.name = u, maxlength: "50", size: "small", class: "input-border-none", placeholder: "填写工作内容类型" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), _("span", U, f(e.name), 1))]), _: 1 }), i(p, { align: "center", label: "排序", width: "130", prop: "sort", "show-overflow-tooltip": true }, { default: l(({ row: e }) => [o.value ? (n(), r(k, { key: 0, modelValue: e.sort, "onUpdate:modelValue": (u) => e.sort = u, min: 1, size: "small", class: "input-border-none", placeholder: "填写排序" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (n(), _("span", x, f(e.sort), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "otherEnum", "page-type", "tableRules"]);
  };
} };
export {
  Y as default
};
