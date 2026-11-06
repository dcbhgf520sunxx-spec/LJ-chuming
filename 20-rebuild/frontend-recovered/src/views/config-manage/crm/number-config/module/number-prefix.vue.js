import { ref as l } from "vue";
import { openBlock as o } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { createVNode as r } from "vue";
import { createElementBlock as g } from "vue";
import { toDisplayString as b } from "vue";
import { unref as x } from "vue";
import { ElTableColumn as h } from "element-plus";
import { ElInput as E } from "element-plus";
import { _ as N } from "../../components/table-config-card.vue.js";
import { dv as v } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const C = { key: 1 }, O = { __name: "number-prefix", props: { permission: { type: Object, default: () => {
} } }, setup(p) {
  const u = l({ prefixNaming: [{ required: true, message: "请填写前缀命名且不多于四位大写英文字母", trigger: "change" }] }), t = l(false);
  function m(e) {
    t.value = e;
  }
  function c(e) {
    t.value = e;
  }
  function d(e) {
    t.value = e;
  }
  return (e, y) => {
    const n = h, f = E;
    return o(), i(N, { title: "编号前缀配置", "page-type": x(v).NUMBER_CONFIG.V, "bool-add": false, "bool-controls": true, isOperation: false, tableRules: u.value, permission: p.permission, addHeight: 80, onEdit: m, onCancelEdit: c, onSubmitSuccess: d }, { tableColumn: s(() => [r(n, { align: "center", label: "类型", prop: "numberPrefixConfigEnumName", "show-overflow-tooltip": true }), r(n, { align: "center", label: "前缀命名", width: "130", prop: "prefixNaming", "show-overflow-tooltip": true }, { default: s(({ row: a }) => [t.value ? (o(), i(f, { key: 0, modelValue: a.prefixNaming, "onUpdate:modelValue": (_) => a.prefixNaming = _, maxlength: "4", size: "default", class: "input-border-none", placeholder: "不大于四位英文字母" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (o(), g("span", C, b(a.prefixNaming), 1))]), _: 1 })]), _: 1 }, 8, ["page-type", "tableRules", "permission"]);
  };
} };
export {
  O as default
};
