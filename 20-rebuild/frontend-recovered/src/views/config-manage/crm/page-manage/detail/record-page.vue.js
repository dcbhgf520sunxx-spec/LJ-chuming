import { ref as f } from "vue";
import { watch as C } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as l } from "vue";
import { createBlock as i } from "vue";
import { withCtx as c } from "vue";
import { createVNode as m } from "vue";
import { createElementBlock as g } from "vue";
import { toDisplayString as y } from "vue";
import { unref as r } from "vue";
import { ElTableColumn as k } from "element-plus";
import { _ as N } from "../../components/table-config-card.vue.js";
import { dv as O, dA as b } from "../../../../../shared/runtime.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const T = { key: 1 }, G = { key: 1 }, D = { __name: "record-page", props: { configEnum: { type: Object, default: void 0 }, permission: { type: Object, default: () => {
} }, countryType: { type: Number } }, emits: ["success"], setup(o, { emit: E }) {
  const _ = E, n = o, d = f([{ label: "是", value: true }, { label: "否", value: false }]), a = f(false);
  function v(e) {
    a.value = e;
  }
  function h(e) {
    a.value = e;
  }
  function V(e) {
    a.value = e, _("success");
  }
  return C(() => n.configEnum, (e) => {
    a.value = false;
  }, { immeDiate: true }), (e, I) => {
    const s = k, p = S("common-select");
    return l(), i(N, { title: n.configEnum.L, "config-enum": n.configEnum.V, "page-type": r(O).PAGE_MANAGE.V, "bool-add": false, "bool-controls": false, isCanSort: true, "bool-serial-number": false, "add-height": o.configEnum.V === r(b).FIRM_RECORD_CONFIG.V || o.configEnum.V === r(b).PROJECT_SIGN_IN_CONFIG.V ? 350 : 400, permission: o.permission, countryType: o.countryType, onEdit: v, onCancelEdit: h, onSubmitSuccess: V, onEditStatus: e.handleEditStatus }, { tableColumn: c(() => [m(s, { align: "center", label: "字段名称", prop: "fieldName" }), m(s, { label: "是否展示", align: "center" }, { default: c(({ row: t }) => [a.value ? (l(), i(p, { key: 0, modelValue: t.isShow, "onUpdate:modelValue": (u) => t.isShow = u, options: d.value, type: "other", "data-structure": { key: "value", label: "label", value: "value" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (l(), g("span", T, y(t.isShow ? "是" : "否"), 1))]), _: 1 }), m(s, { label: "是否必填", align: "center" }, { default: c(({ row: t }) => [a.value ? (l(), i(p, { key: 0, modelValue: t.isWrite, "onUpdate:modelValue": (u) => t.isWrite = u, options: d.value, type: "other", "data-structure": { key: "value", label: "label", value: "value" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (l(), g("span", G, y(t.isWrite ? "是" : "否"), 1))]), _: 1 })]), _: 1 }, 8, ["title", "config-enum", "page-type", "add-height", "permission", "countryType", "onEditStatus"]);
  };
} };
export {
  D as default
};
