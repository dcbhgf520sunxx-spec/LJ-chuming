import P from "lodash";
import { computed as _ } from "vue";
import { inject as g } from "vue";
import { watchEffect as w } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
import { createBlock as S } from "vue";
import { createSlots as C } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as R } from "vue";
import { toDisplayString as A } from "vue";
import { unref as l } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as U } from "vue";
import { Fragment as F } from "vue";
import { renderList as L } from "vue";
import { withDirectives as j } from "vue";
import { ElInput as Q } from "element-plus";
import { ElOption as G } from "element-plus";
import { ElSelect as H } from "element-plus";
import { ElDatePicker as J } from "element-plus";
import { ElButton as X } from "element-plus";
import { p as Y } from "../../../../modules/pc-pasychia-data-6ecf5a97.js";
import { _ as ee, dZ as ae, ia as z, e7 as K, iv as O, e5 as M, iK as le } from "../../../../shared/runtime.js";
import { d as W } from "../../../../modules/upload-file-download-812f558c.js";
const te = { class: "main-descriptions-container" }, oe = { key: 0, class: "downLoad" }, ne = { class: "notSlotValue" }, se = { key: 1, class: "notSlotValue" }, de = { key: 0, class: "notSlotValue" }, ue = { key: 1, class: "notSlotValue" }, ie = { key: 0, class: "downLoad" }, pe = { class: "notSlotValue" }, me = { key: 1, class: "notSlotValue" }, re = { key: 0, class: "notSlotValue" }, ce = { key: 1, class: "notSlotValue" }, ye = { __name: "payment-table", props: { isWrite: { type: Boolean, default: true }, hiddenUpload: { type: Boolean, default: false }, hideItemKey: { type: Array, default: () => [] }, column: { type: [Number, String], default: 2 }, readonlyColumn: { type: [Number, String], default: 2 }, isAmount: { type: Boolean, default: false }, isNegative: { type: Boolean, default: false } }, setup(Z) {
  const u = Z, V = P.cloneDeep(Y), b = _(() => u.hideItemKey.length > 0 ? V.filter((t) => !u.hideItemKey.includes(t.key)) : V), E = _(() => ae(b.value)), n = g("purchaseForm"), { attachmentIds: k, purchaseInfo: v } = g("purchaseInfo", { attachmentIds: [] }), h = g("tableItemData", {}), x = _(() => h.auditStatusEnum === 2), D = _(() => {
    if (x.value) return z(K(h.actuallyPayAmount));
    const t = n.actuallyPayAmount;
    return z(K(t));
  });
  function T(t) {
    const o = {};
    function c(i) {
      if (Object(i) !== i) return i;
      if (Array.isArray(i)) for (let r = 0; r < i.length; r++) c(i[r]);
      else for (const r in i) {
        const y = i[r];
        typeof y == "object" && y !== null ? Object.assign(o, T(y)) : o[r] = y;
      }
    }
    return c(t), o;
  }
  const f = _(() => {
    const t = P.cloneDeep(v);
    return T(t);
  });
  w(() => {
    if (k != null && k.value) {
      const t = b.value.find((o) => o.key === "attachmentIds");
      t && (t.value = k.value);
    }
  }), w(() => {
    var t;
    (t = v.supplierAuditSelfEmployedDto) != null && t.paymentType && (n.paymentType = v.supplierAuditSelfEmployedDto.paymentType), n.paymentDate = f.value.paymentDate;
  });
  const I = _(() => f.value.boolFinalApprover && u.isWrite && h.approvalFlag);
  w(() => {
    if (I.value) {
      const t = V.findIndex((o) => o.key === "paymentType");
      t !== -1 && (V[t].verify = true);
    }
  });
  const $ = (t) => {
    const o = n.actuallyPayAmount;
    n.actuallyPayAmount = le(o, { decimalPlaces: 2, allowNegative: u.isNegative });
  };
  return (t, o) => {
    const c = Q, i = G, r = H, y = J, B = X, N = q("ellipsis");
    return d(), p("div", te, [x.value ? (d(), S(M, { key: 0, column: u.readonlyColumn, formData: l(h), formRules: E.value, hiddenItem: u.hiddenUpload ? ["attachmentIds", "paymentType"] : [], "table-list": b.value, size: "default" }, C({ actuallyPayAmount: s(({ item: e }) => [m(c, { "model-value": l(h)[e], disabled: "", placeholder: "请录入金额" }, null, 8, ["model-value"])]), capital: s(() => [m(c, { modelValue: D.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => D.value = e), placeholder: "输入实付金额", readonly: "" }, null, 8, ["modelValue"])]), paymentType: s(({ item: e }) => [m(r, { modelValue: l(n)[e], "onUpdate:modelValue": (a) => l(n)[e] = a, class: "ele-module-width", clearable: "", disabled: "" }, { default: s(() => [(d(true), p(F, null, L(l(O).V, (a) => (d(), S(i, { key: a.V, label: a.L, value: a.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), paymentDate: s(({ item: e }) => [m(y, { modelValue: l(n)[e], "onUpdate:modelValue": (a) => l(n)[e] = a, class: "ele-module-width", clearable: "", disabled: "", placeholder: "请选择日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), remark: s(() => [f.value.remark ? j((d(), p("span", de, [U(A(f.value.remark), 1)])), [[N]]) : (d(), p("span", ue, "无"))]), _: 2 }, [u.hiddenUpload ? void 0 : { name: "attachmentIds", fn: s(({ val: e }) => [e ? (d(), p("div", oe, [R("span", ne, A(l(v).supplierAuditSelfEmployedDto.attachmentDto.name), 1), m(B, { icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (a) => l(W)(e) }, { default: s(() => o[2] || (o[2] = [U("下载 ")])), _: 2, __: [2] }, 1032, ["onClick"])])) : (d(), p("span", se, "无"))]), key: "0" }]), 1032, ["column", "formData", "formRules", "hiddenItem", "table-list"])) : (d(), S(M, { key: 1, column: u.column, formData: l(n), formRules: E.value, hiddenItem: u.hiddenUpload ? ["attachmentIds"] : [], "table-list": b.value, size: "default" }, C({ actuallyPayAmount: s(({ item: e }) => [m(c, { modelValue: l(n)[e], "onUpdate:modelValue": (a) => l(n)[e] = a, disabled: !I.value, readonly: !u.isAmount, placeholder: "请录入金额", onInput: $ }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "readonly"])]), capital: s(() => [m(c, { modelValue: D.value, "onUpdate:modelValue": o[1] || (o[1] = (e) => D.value = e), placeholder: "输入实付金额", readonly: "" }, null, 8, ["modelValue"])]), paymentType: s(({ item: e }) => [m(r, { modelValue: l(n)[e], "onUpdate:modelValue": (a) => l(n)[e] = a, disabled: !I.value, class: "ele-module-width", clearable: "" }, { default: s(() => [(d(true), p(F, null, L(l(O).V, (a) => (d(), S(i, { key: a.V, label: a.L, value: a.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), paymentDate: s(({ item: e }) => [m(y, { modelValue: l(n)[e], "onUpdate:modelValue": (a) => l(n)[e] = a, disabled: !I.value, class: "ele-module-width", clearable: "", placeholder: "请选择日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), remark: s(() => [f.value.remark ? j((d(), p("span", re, [U(A(f.value.remark), 1)])), [[N]]) : (d(), p("span", ce, "无"))]), _: 2 }, [u.hiddenUpload ? void 0 : { name: "attachmentIds", fn: s(({ val: e }) => [e ? (d(), p("div", ie, [R("span", pe, A(l(v).supplierAuditSelfEmployedDto.attachmentDto.name), 1), m(B, { icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (a) => l(W)(e) }, { default: s(() => o[3] || (o[3] = [U("下载 ")])), _: 2, __: [3] }, 1032, ["onClick"])])) : (d(), p("span", me, "无"))]), key: "0" }]), 1032, ["column", "formData", "formRules", "hiddenItem", "table-list"]))]);
  };
} }, Ve = ee(ye, [["__scopeId", "data-v-077b7099"]]);
export {
  Ve as default
};
