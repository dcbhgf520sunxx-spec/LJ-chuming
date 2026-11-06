import { ref as p } from "vue";
import { watch as z } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as a } from "vue";
import { createBlock as y } from "vue";
import { withCtx as t } from "vue";
import { unref as i } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as h } from "vue";
import { createElementBlock as o } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as r } from "vue";
import { isRef as F } from "vue";
import { ElFormItem as S } from "element-plus";
import { ElDivider as q } from "element-plus";
import { ElForm as U } from "element-plus";
import { _ as A, u as L, i as P, z as G, bV as H, bD as k, R as J } from "../../../../../../../shared/runtime.js";
import { h as K } from "../../../../../../../modules/payable-list-dd7ea2e5.js";
const M = { class: "form-content" }, O = { class: "form-left" }, Q = { key: 0 }, W = { key: 0 }, X = { key: 0 }, Y = { key: 0 }, Z = { key: 0 }, $ = { key: 0 }, ee = { key: 0 }, ae = { key: 0 }, te = { key: 0 }, le = { key: 0 }, oe = { key: 1 }, se = { key: 0, style: { "word-break": "break-all" } }, ne = { __name: "subcontract-detail", props: { modelValue: { type: Boolean, require: true }, id: { type: [Number, String], default: () => {
} } }, emits: ["update:modelValue"], setup(N, { emit: w }) {
  const g = w, _ = N, D = p(), { visible: d, handleClose: C } = L({ emit: g, props: _ });
  p(false), p();
  const e = p({}), v = p(false);
  z(d, (u) => {
    u && V();
  }, { immediate: true, deep: true });
  async function V() {
    if (e.value = {}, !!_.id) {
      v.value = true;
      try {
        const u = await K(_.id);
        e.value = u;
      } catch (u) {
        console.log("获取分包订单详情失败", u);
      } finally {
        v.value = false;
      }
    }
  }
  return (u, c) => {
    const s = S, x = q, T = J, B = U, E = I("common-drawer"), R = b("parse-time"), j = b("parse-enum");
    return a(), y(E, { ref_key: "dialogRef", ref: D, title: "分供合同详情", "close-on-click-modal": false, modelValue: i(d), "onUpdate:modelValue": c[1] || (c[1] = (m) => F(d) ? d.value = m : null), direction: "rtl", "before-close": i(C), "custom-class": "inbound-detail-dialog", size: "600px" }, { content: t(() => [i(P)(e.value) ? (a(), y(B, { key: 0, model: e.value, "label-position": "left", "label-width": "110px", size: "default" }, { default: t(() => [f("div", M, [f("div", O, [l(s, { label: "日期", prop: "signDate" }, { default: t(() => [e.value.signDate ? h((a(), o("span", Q, null, 512)), [[R, { val: e.value.signDate, fmt: "{y}-{m}-{d}" }]]) : n("", true)]), _: 1 }), l(s, { label: "创建人", prop: "userName" }, { default: t(() => [e.value.userName ? (a(), o("span", W, r(e.value.userName), 1)) : n("", true)]), _: 1 }), l(s, { label: "项目", prop: "project" }, { default: t(() => [e.value.project ? (a(), o("span", X, r(i(G)(e.value.project)), 1)) : n("", true)]), _: 1 }), l(s, { label: "分供类型", prop: "subcontractClassName" }, { default: t(() => [e.value.subcontractClassName ? (a(), o("span", Y, r(e.value.subcontractClassName), 1)) : n("", true)]), _: 1 }), l(s, { label: "供应商", prop: "supplierName" }, { default: t(() => [e.value.supplierName ? (a(), o("span", Z, r(e.value.supplierName), 1)) : n("", true)]), _: 1 }), l(s, { label: "签约主体", prop: "branchCompany" }, { default: t(() => [e.value.branchCompany.name ? (a(), o("span", $, r(e.value.branchCompany.name), 1)) : n("", true)]), _: 1 }), l(s, { label: "合同编号", prop: "serialNumber" }, { default: t(() => [e.value.serialNumber ? (a(), o("span", ee, r(e.value.serialNumber), 1)) : n("", true)]), _: 1 }), l(s, { label: "合同额", prop: "amount" }, { default: t(() => [e.value.amount ? (a(), o("span", ae, r(i(H)(e.value.amount)), 1)) : n("", true)]), _: 1 }), l(s, { label: "发票类型", prop: "invoiceType", style: { width: "100%" } }, { default: t(() => [e.value.invoiceType ? h((a(), o("span", te, null, 512)), [[j, { e: i(k), v: e.value.invoiceType }]]) : n("", true)]), _: 1 }), l(s, { label: "发票税率", prop: "invoiceType", style: { width: "100%" } }, { default: t(() => [e.value.invoiceType !== i(k).RECEIPT.V ? (a(), o("span", le, "（" + r(e.value.taxRate) + "%）", 1)) : (a(), o("span", oe, "-"))]), _: 1 }), l(s, { label: "备注信息", prop: "remark", style: { width: "100%" } }, { default: t(() => [e.value.remark ? (a(), o("span", se, r(e.value.remark), 1)) : n("", true)]), _: 1 }), l(x, null, { default: t(() => c[2] || (c[2] = [f("span", { class: "title" }, "附件", -1)])), _: 1, __: [2] }), l(T, { files: e.value.attachments, "onUpdate:files": c[0] || (c[0] = (m) => e.value.attachments = m), uploadable: false, "empty-text": "暂未上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])])]), _: 1 }, 8, ["model"])) : n("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = A(ne, [["__scopeId", "data-v-7c84f4f4"]]);
export {
  ce as default
};
