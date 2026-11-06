import { ref as w } from "vue";
import { watch as ne } from "vue";
import { nextTick as ae } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as t } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as T } from "vue";
import { withDirectives as p } from "vue";
import { createElementBlock as o } from "vue";
import { Fragment as g } from "vue";
import { unref as a } from "vue";
import { createVNode as m } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as s } from "vue";
import { renderList as oe } from "vue";
import { isRef as ie } from "vue";
import { ElNotification as P } from "element-plus";
import { ElTag as ue } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElInputNumber as de } from "element-plus";
import { ElInput as me } from "element-plus";
import { InfoFilled as fe } from "@element-plus/icons-vue";
import { ElIcon as ce } from "element-plus";
import { ElTooltip as ye } from "element-plus";
import { ElForm as re } from "element-plus";
import { vLoading as ve } from "element-plus";
import { s as he, a as Ie } from "../../../../../modules/payment-application-502afb4b.js";
import { t as ke, u as pe, bC as be, c3 as O, bV as I, ia as F, S as we, iy as Te } from "../../../../../shared/runtime.js";
import { _ as Ae } from "../../../../../modules/UploadBtn-b4cfb47a.js";
const Ce = { key: 0 }, ge = { key: 1 }, Se = { key: 0 }, Ve = { key: 1 }, Re = { key: 0 }, Ee = { key: 1 }, xe = { key: 0, style: { color: "#82848a" } }, Ne = { key: 0 }, De = { key: 1, style: { color: "#82848a" } }, Oe = { key: 0 }, Fe = { key: 1 }, ze = { key: 2 }, Be = { key: 0 }, $e = { key: 1 }, je = { key: 2 }, Je = { key: 1 }, Ue = { key: 0 }, Pe = ["onDblclick"], He = { __name: "settle-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 } }, emits: ["success", "update:modelValue"], setup(e, { emit: q }) {
  const { decimalPrecision: c } = ke(), r = w(false), E = q, A = e, { visible: S, handleClose: x } = pe({ emit: E, props: A }), z = { amount: void 0, attachmentIds: void 0, attachments: [], orderId: void 0, propertyType: void 0, remark: "" }, i = w(JSON.parse(JSON.stringify(z))), k = w(), L = w(), V = w(false), B = w(), M = { amount: [{ required: true, validator: (d, n, h) => {
    n || h(new Error("请填写申请金额并大于0")), h();
  }, trigger: "blur" }] };
  ne(() => S.value, (d) => {
    d && (A.showType || G());
  }, { deep: true, immediate: true });
  function W(d) {
    B.value = d.id, V.value = true;
  }
  function G(d) {
    k.value && k.value.resetFields(), d && Object.keys(d).length > 0 ? i.value = d : i.value = JSON.parse(JSON.stringify(z)), k.value && ae(() => {
      k.value.clearValidate();
    }), be(k, i);
  }
  async function H() {
    r.value = true;
    try {
      if (!await k.value.validate()) return;
      i.value.orderId = A.detailInfo.id, i.value.propertyType = A.detailInfo.propertyType, i.value.attachmentIds = i.value.attachments ? i.value.attachments.map((n) => n.id) : void 0, await he(i.value), r.value = false, P({ title: "提交成功", type: "success" }), E("success"), x();
    } catch (d) {
      r.value = false, console.log("项目结算失败", d);
    }
  }
  async function $(d) {
    r.value = true;
    const n = d === O.PASS.V ? "通过" : "驳回";
    try {
      const h = { auditStatus: d, orderId: A.detailInfo.id };
      await Ie(h), r.value = false, P({ title: "审核" + n, type: "success" }), E("success"), x();
    } catch (h) {
      r.value = false, console.log("项目结算审核失败", h);
    }
  }
  return (d, n) => {
    const h = ue, N = U("common-button"), f = se, K = de, Q = me, X = fe, Y = ce, Z = ye, _ = re, ee = U("common-drawer"), D = ve, R = le("thousand");
    return t(), y(ee, { "append-to-body": "", "close-on-click-modal": false, "before-close": a(x), modelValue: a(S), "onUpdate:modelValue": n[6] || (n[6] = (u) => ie(S) ? S.value = u : null), title: "订单结算", "wrapper-closable": false, size: "40%" }, { titleAfter: l(() => [e.showType === "detail" ? (t(), y(h, { key: 0 }, { default: l(() => n[7] || (n[7] = [C(" 已结算 ")])), _: 1, __: [7] })) : T("", true)]), titleRight: l(() => [e.showType === "add" ? p((t(), y(N, { key: 0, type: "primary", size: "default", onClick: H }, { default: l(() => n[8] || (n[8] = [C("提交审核")])), _: 1, __: [8] })), [[D, r.value]]) : (t(), o(g, { key: 1 }, [e.showType === "audit" ? p((t(), y(N, { key: 0, size: "default", type: "info", onClick: n[0] || (n[0] = (u) => $(a(O).REJECT.V)) }, { default: l(() => n[9] || (n[9] = [C("驳回")])), _: 1, __: [9] })), [[D, r.value]]) : T("", true), e.showType === "audit" ? p((t(), y(N, { key: 1, size: "default", type: "success", onClick: n[1] || (n[1] = (u) => $(a(O).PASS.V)) }, { default: l(() => n[10] || (n[10] = [C("通过")])), _: 1, __: [10] })), [[D, r.value]]) : T("", true)], 64))]), content: l(() => [m(_, { ref_key: "formRef", ref: k, model: i.value, rules: M, size: "default", "label-width": "130px" }, { default: l(() => [m(f, { label: "采购合同编号" }, { default: l(() => [b("span", null, s(e.detailInfo.serialNumber), 1)]), _: 1 }), m(f, { label: "供应商" }, { default: l(() => [b("span", null, s(e.detailInfo.supplierName), 1)]), _: 1 }), m(f, { label: "合同额" }, { default: l(() => [p(b("span", null, null, 512), [[R, e.detailInfo.amount]])]), _: 1 }), m(f, { label: "入库额" }, { default: l(() => [p(b("span", null, null, 512), [[R, e.detailInfo.inboundAmount]])]), _: 1 }), m(f, { label: "已付款" }, { default: l(() => [p(b("span", null, null, 512), [[R, e.detailInfo.paymentAmount]]), e.showType === "add" ? (t(), o("span", Ce, "（" + s(e.detailInfo.paymentRate) + "%）", 1)) : (t(), o("span", ge, "（" + s(e.detailInfo.inboundAmount ? (e.detailInfo.paymentAmount / e.detailInfo.inboundAmount * 100).toFixed(2) + "%" : "0.00%") + "）", 1))]), _: 1 }), m(f, { label: "已收票" }, { default: l(() => [p(b("span", null, null, 512), [[R, e.detailInfo.invoiceAmount]]), e.showType === "add" ? (t(), o("span", Se, "（" + s(e.detailInfo.invoiceRate) + "%）", 1)) : (t(), o("span", Ve, "（" + s(e.detailInfo.inboundAmount ? (e.detailInfo.invoiceAmount / e.detailInfo.inboundAmount * 100).toFixed(2) + "%" : "0.00%") + "）", 1))]), _: 1 }), m(f, { label: "最终结算额", prop: "amount" }, { default: l(() => {
      var u, v, j, J;
      return [e.showType === "add" ? (t(), y(K, { key: 0, modelValue: i.value.amount, "onUpdate:modelValue": n[2] || (n[2] = (te) => i.value.amount = te), step: 1, min: (v = (u = e.detailInfo) == null ? void 0 : u.sourceRow) != null && v.paymentAmount ? (J = (j = e.detailInfo) == null ? void 0 : j.sourceRow) == null ? void 0 : J.paymentAmount : 0, max: 999999999999, precision: a(c).supplyChain, placeholder: "最终结算额", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "min", "precision"])) : (t(), o(g, { key: 1 }, [e.showType === "audit" ? (t(), o("span", Re, s(e.detailInfo.unCheckSettlementAmount ? a(I)(e.detailInfo.unCheckSettlementAmount, a(c).supplyChain) : "-"), 1)) : (t(), o("span", Ee, s(e.detailInfo.settlementAmount ? a(I)(e.detailInfo.settlementAmount, a(c).supplyChain) : "-"), 1))], 64))];
    }), _: 1 }), m(f, { label: "大写" }, { default: l(() => [e.showType === "add" ? (t(), o("span", xe, s(i.value.amount ? a(F)(i.value.amount) : ""), 1)) : (t(), o(g, { key: 1 }, [e.showType === "audit" ? (t(), o("span", Ne, s(e.detailInfo.unCheckSettlementAmount ? a(F)(e.detailInfo.unCheckSettlementAmount, a(c).supplyChain) : "-"), 1)) : (t(), o("span", De, s(e.detailInfo.settlementAmount ? a(F)(e.detailInfo.settlementAmount, a(c).supplyChain) : ""), 1))], 64))]), _: 1 }), m(f, { label: "应付金额" }, { default: l(() => {
      var u, v;
      return [e.showType === "audit" ? (t(), o("span", Oe, s(a(I)(e.detailInfo.unCheckSettlementAmount - e.detailInfo.paymentAmount, a(c).supplyChain)), 1)) : e.showType === "add" ? (t(), o("span", Fe, s(i.value.amount ? a(I)(i.value.amount - ((v = (u = e.detailInfo) == null ? void 0 : u.sourceRow) == null ? void 0 : v.paymentAmount), a(c).supplyChain) : ""), 1)) : (t(), o("span", ze, s(a(I)(e.detailInfo.settlementAmount - e.detailInfo.paymentAmount, a(c).supplyChain)), 1))];
    }), _: 1 }), m(f, { label: "应补发票" }, { default: l(() => {
      var u, v;
      return [e.showType === "audit" ? (t(), o("span", Be, s(a(I)(e.detailInfo.unCheckSettlementAmount - e.detailInfo.invoiceAmount, a(c).supplyChain)), 1)) : e.showType === "add" ? (t(), o("span", $e, s(i.value.amount ? a(I)(i.value.amount - ((v = (u = e.detailInfo) == null ? void 0 : u.sourceRow) == null ? void 0 : v.invoiceAmount), a(c).supplyChain) : ""), 1)) : (t(), o("span", je, s(a(I)(e.detailInfo.settlementAmount - e.detailInfo.invoiceAmount, a(c).supplyChain)), 1))];
    }), _: 1 }), m(f, { label: "备注", prop: "remark" }, { default: l(() => [e.showType === "add" ? (t(), y(Q, { key: 0, modelValue: i.value.remark, "onUpdate:modelValue": n[3] || (n[3] = (u) => i.value.remark = u), type: "textarea", style: { width: "100%" }, maxlength: "200", "show-word-limit": "", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请输入备注" }, null, 8, ["modelValue"])) : (t(), o("span", Je, s(e.detailInfo.settlementRemark), 1))]), _: 1 }), m(f, { label: "附件" }, { label: l(() => [n[11] || (n[11] = C(" 附件 ")), e.detailInfo.attachmentDTOS && e.detailInfo.attachmentDTOS.length > 0 ? (t(), y(Z, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: l(() => [m(Y, null, { default: l(() => [m(X)]), _: 1 })]), _: 1 })) : T("", true)]), default: l(() => [e.showType === "add" ? (t(), y(a(Ae), { key: 0, ref_key: "uploadRef", ref: L, files: i.value.attachments, "onUpdate:files": n[4] || (n[4] = (u) => i.value.attachments = u), "file-classify": a(we).CONTRACT_ATT.V, limit: 1, accept: ".jpg,.png,.pdf,.jpeg" }, null, 8, ["files", "file-classify"])) : (t(), o(g, { key: 1 }, [e.detailInfo.attachmentDTOS && e.detailInfo.attachmentDTOS.length > 0 ? (t(), o("div", Ue, [(t(true), o(g, null, oe(e.detailInfo.attachmentDTOS, (u) => (t(), o("div", { key: u.id }, [b("div", { style: { cursor: "pointer" }, onDblclick: (v) => W(u) }, s(u.name), 41, Pe)]))), 128))])) : T("", true)], 64))]), _: 1 })]), _: 1 }, 8, ["model"]), V.value ? (t(), y(Te, { key: 0, isVisible: V.value, showType: "attachment", id: B.value, onClose: n[5] || (n[5] = (u) => V.value = false) }, null, 8, ["isVisible", "id"])) : T("", true)]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} };
export {
  He as default
};
