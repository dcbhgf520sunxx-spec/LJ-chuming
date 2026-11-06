import { ref as P } from "vue";
import { watchEffect as E } from "vue";
import { computed as y } from "vue";
import { inject as O } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as t } from "vue";
import { withCtx as u } from "vue";
import { unref as r } from "vue";
import { createElementVNode as D } from "vue";
import { createBlock as b } from "vue";
import { withDirectives as I } from "vue";
import { createCommentVNode as V } from "vue";
import { Fragment as F } from "vue";
import { ElFormItem as M } from "element-plus";
import { ElInput as A } from "element-plus";
import { _ as B, fg as N, jY as R, qS as T, fv as $, hV as z, cy as Q } from "../../../../../../../shared/runtime.js";
import { _ as W } from "../../../../../../../modules/workshop-select-210dd661.js";
const H = { key: 0 }, K = { key: 1 }, Y = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object } }, setup(w) {
  const s = w, { projectMap: k, monomerMap: x } = N(), e = P({ projectId: void 0, monomerId: void 0, areaId: void 0, workshopId: void 0, recipientId: void 0, quantity: void 0, remark: void 0 });
  E(() => {
    e.value = s.form;
  });
  const l = y(() => s.material), { outboundCfg: h } = R(), v = O("maxQuantity"), j = y(() => !s.material.project || h.value.boolCanOutToOtherProject === true && s.material.boolPartyA !== true);
  function g() {
    e.value.quantity = v.value;
  }
  return (G, a) => {
    const U = p("common-radio"), n = M, q = p("common-input-number"), f = p("common-select"), C = A, _ = S("to-fixed");
    return m(), c(F, null, [t(n, { label: "出库目的地", prop: "outboundAddress" }, { default: u(() => [t(U, { modelValue: e.value.outboundAddress, "onUpdate:modelValue": a[0] || (a[0] = (o) => e.value.outboundAddress = o), options: r(T).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(n, { label: `数量(${l.value.outboundUnit})`, prop: "quantity" }, { default: u(() => [t(q, { modelValue: e.value.quantity, "onUpdate:modelValue": a[1] || (a[1] = (o) => e.value.quantity = o), max: r(v), min: 0, precision: l.value.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"]), D("span", { class: "text-clickable set-max-text", onClick: g }, "全部出库")]), _: 1 }, 8, ["label"]), l.value.accountingUnit ? (m(), b(n, { key: 0, label: `核算量(${l.value.accountingUnit})` }, { default: u(() => [l.value.quantity ? I((m(), c("span", H, null, 512)), [[_, { val: e.value.quantity / l.value.quantity * l.value.mete || 0, dp: l.value.accountingPrecision }]]) : I((m(), c("span", K, null, 512)), [[_, { val: e.value.quantity || 0, dp: l.value.accountingPrecision }]])]), _: 1 }, 8, ["label"])) : V("", true), j.value ? (m(), b(n, { key: 1, label: "项目", prop: "projectId" }, { default: u(() => [t(r($), { modelValue: e.value.projectId, "onUpdate:modelValue": a[2] || (a[2] = (o) => e.value.projectId = o), clearable: "", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : V("", true), t(n, { label: "单体", prop: "monomerId" }, { default: u(() => {
      var o, d;
      return [t(f, { modelValue: e.value.monomerId, "onUpdate:modelValue": a[3] || (a[3] = (i) => e.value.monomerId = i), dataStructure: { key: "id", label: "name", value: "id" }, options: e.value.projectId && ((d = (o = r(k)) == null ? void 0 : o[e.value.projectId]) == null ? void 0 : d.children) || [], clearable: "", placeholder: "可选择单体", style: { width: "100%" }, type: "other" }, null, 8, ["modelValue", "options"])];
    }), _: 1 }), t(n, { label: "区域", prop: "areaId" }, { default: u(() => {
      var o, d;
      return [t(f, { modelValue: e.value.areaId, "onUpdate:modelValue": a[4] || (a[4] = (i) => e.value.areaId = i), options: e.value.monomerId && ((d = (o = r(x)) == null ? void 0 : o[e.value.monomerId]) == null ? void 0 : d.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", type: "other", placeholder: "可选择区域", style: { width: "100%" } }, null, 8, ["modelValue", "options"])];
    }), _: 1 }), t(n, { label: "车间", prop: "workshopId" }, { default: u(() => [t(W, { modelValue: e.value.workshopId, "onUpdate:modelValue": a[5] || (a[5] = (o) => e.value.workshopId = o), type: r(z).WORKSHOP.V, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "type"])]), _: 1 }), t(n, { label: "领用人", prop: "recipientId" }, { default: u(() => [t(Q, { modelValue: e.value.recipientId, "onUpdate:modelValue": a[6] || (a[6] = (o) => e.value.recipientId = o), "collapse-tags": false, clearable: "", filterable: "", "show-all-levels": "", placeholder: "领用人", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "备注", prop: "remark" }, { default: u(() => [t(C, { modelValue: e.value.remark, "onUpdate:modelValue": a[7] || (a[7] = (o) => e.value.remark = o), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", "show-word-limit": "", placeholder: "备注", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, Z = B(Y, [["__scopeId", "data-v-36d14603"]]);
export {
  Z as default
};
