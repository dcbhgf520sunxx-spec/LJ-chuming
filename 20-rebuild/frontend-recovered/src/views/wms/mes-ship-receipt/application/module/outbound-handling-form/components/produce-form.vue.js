import { inject as m } from "vue";
import { ref as y } from "vue";
import { watchEffect as E } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as o } from "vue";
import { withCtx as u } from "vue";
import { unref as i } from "vue";
import { createElementVNode as k } from "vue";
import { createBlock as D } from "vue";
import { withDirectives as V } from "vue";
import { createCommentVNode as N } from "vue";
import { toDisplayString as P } from "vue";
import { ElFormItem as R } from "element-plus";
import { ElInput as W } from "element-plus";
import { _ as A, i as B, cS as _, qS as F, z as S, aV as q, cy as z } from "../../../../../../../shared/runtime.js";
const T = { key: 0 }, $ = { key: 1 }, O = { __name: "produce-form", props: { material: { type: Object }, form: { type: Object } }, setup(a) {
  const r = a, p = m("maxQuantity"), I = m("globalProjectId"), h = m("globalProject"), e = y({ projectId: void 0, mesWorkshopId: void 0, recipientId: void 0, quantity: void 0, remark: void 0, mesWorkshop: {}, userInfo: {} });
  E(() => {
    e.value = r.form, e.value.projectId = I.value;
  });
  const b = y();
  function x() {
    e.value.outboundQuantity = p.value, f();
  }
  function f() {
    r.material.outboundUnitType === _.MEASURE.V ? e.value.outboundMete = e.value.outboundQuantity && e.value.outboundQuantity / r.material.operableQuantity * r.material.operableMete || 0 : e.value.outboundMete = e.value.outboundQuantity;
  }
  function U(d) {
    e.value.mesWorkshop = d;
  }
  function Q() {
    var t;
    const d = ((t = b.value) == null ? void 0 : t.getNodeInfo()) || {};
    e.value.userInfo = d;
  }
  return (d, t) => {
    const C = g("common-input-number"), n = R, j = g("common-radio"), w = W, v = M("to-fixed");
    return s(), c("div", null, [o(n, { label: `出库数量(${a.material.outboundUnit})`, prop: "outboundQuantity" }, { default: u(() => [o(C, { modelValue: e.value.outboundQuantity, "onUpdate:modelValue": t[0] || (t[0] = (l) => e.value.outboundQuantity = l), max: i(p), min: 0, precision: a.material.outboundUnitPrecision, "controls-position": "right", onChange: f }, null, 8, ["modelValue", "max", "precision"]), k("span", { class: "text-clickable set-max-text", onClick: x }, "全部出库")]), _: 1 }, 8, ["label"]), a.material.accountingUnit ? (s(), D(n, { key: 0, label: `核算量(${a.material.accountingUnit})` }, { default: u(() => [i(B)(a.material.measureUnit) && a.material.outboundUnitType === i(_).MEASURE.V ? V((s(), c("span", T, null, 512)), [[v, { val: e.value.outboundQuantity / a.material.operableQuantity * a.material.operableMete || 0, dp: a.material.accountingPrecision }]]) : V((s(), c("span", $, null, 512)), [[v, { val: e.value.outboundQuantity || 0, dp: a.material.accountingPrecision }]])]), _: 1 }, 8, ["label"])) : N("", true), o(n, { label: "出库目的地", prop: "outboundAddress" }, { default: u(() => [o(j, { modelValue: e.value.outboundAddress, "onUpdate:modelValue": t[1] || (t[1] = (l) => e.value.outboundAddress = l), disabled: "", options: i(F).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(n, { label: "领用项目", prop: "projectId" }, { default: u(() => [k("span", null, P(i(S)(i(h))), 1)]), _: 1 }), o(n, { label: "领用车间", prop: "mesWorkshopId" }, { default: u(() => [o(i(q), { modelValue: e.value.mesWorkshopId, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.mesWorkshopId = l), "factory-id": e.value.factoryId, clearable: "", placeholder: "领用车间", style: { width: "100%" }, onNameChange: U }, null, 8, ["modelValue", "factory-id"])]), _: 1 }), o(n, { label: "领用人", prop: "recipientId" }, { default: u(() => [o(z, { ref_key: "userDeptRef", ref: b, modelValue: e.value.recipientId, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.recipientId = l), "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" }, onChange: Q }, null, 8, ["modelValue"])]), _: 1 }), o(n, { label: "备注", prop: "remark" }, { default: u(() => [o(w, { modelValue: e.value.remark, "onUpdate:modelValue": t[4] || (t[4] = (l) => e.value.remark = l), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]);
  };
} }, J = A(O, [["__scopeId", "data-v-4b661a24"]]);
export {
  J as default
};
