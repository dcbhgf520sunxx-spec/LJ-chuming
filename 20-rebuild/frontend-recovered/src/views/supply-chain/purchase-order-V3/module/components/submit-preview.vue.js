import { ref as L } from "vue";
import { inject as O } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as p } from "vue";
import { createBlock as g } from "vue";
import { withCtx as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as u } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as i } from "vue";
import { withDirectives as c } from "vue";
import { createElementBlock as d } from "vue";
import { Fragment as H } from "vue";
import { renderList as U } from "vue";
import { isRef as F } from "vue";
import { ElFormItem as K } from "element-plus";
import { ElDivider as $ } from "element-plus";
import { ElTag as G } from "element-plus";
import { ElForm as J } from "element-plus";
import { _ as W, ll as Y, u as Q, o as X, G as Z, vf as ee, vg as R, i as te, jS as se, jP as M, cP as ae, jT as le, bR as oe, jU as ne, jV as ie, bD as j, fE as re, jJ as pe, z as ue, R as de, S as me, vh as _e } from "../../../../../shared/runtime.js";
import ce from "./detail-table/index.vue.js";
import "./detail-table/module/manufactured.vue.js";
import "./detail-table/module/raw-material.vue.js";
const fe = { class: "main-content" }, ye = { class: "form-content" }, be = { class: "form-left" }, ve = { class: "flex-rss child-mr-10" }, ge = { key: 0 }, he = { key: 0 }, we = { key: 0 }, Te = { key: 0 }, Ve = { key: 0 }, Ee = { style: { "word-break": "break-all" } }, ke = { key: 0, class: "pre-wrap" }, Ce = { class: "form-right" }, xe = { class: "right-head flex-rbs" }, Pe = { class: "right-head-content" }, Re = { __name: "submit-preview", props: { modelValue: { type: Boolean, default: false }, loading: { type: Boolean, default: false }, isPassedEdit: { type: Boolean, default: false }, edit: { type: Boolean, default: false } }, emits: ["update:modelValue", "submit"], setup(f, { emit: B }) {
  var E;
  const h = L(), w = B, T = f, { supplierKV: S } = Y(), t = (E = O("cu")) == null ? void 0 : E.form, { visible: y, handleClose: b } = Q({ emit: w, props: T }), { maxHeight: A } = X({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, h);
  function V(k) {
    w("submit", k), setTimeout(() => {
      b();
    });
  }
  return (k, s) => {
    const v = P("common-button"), n = K, I = $, N = G, z = J, D = P("common-drawer"), m = q("parse-enum");
    return p(), g(D, { ref_key: "drawerRef", ref: h, modelValue: e(y), "onUpdate:modelValue": s[3] || (s[3] = (r) => F(y) ? y.value = r : null), "before-close": e(b), direction: "rtl", size: "100%", title: "提交预览" }, { titleRight: a(() => [e(Z)(e(ee).scmTemporaryStoragePM.add) && f.isPassedEdit && !T.edit ? (p(), g(v, { key: 0, loading: f.loading, size: "default", type: "warning", onClick: s[0] || (s[0] = (r) => V(e(R).YES.V)) }, { default: a(() => s[4] || (s[4] = [_(" 暂存 ")])), _: 1, __: [4] }, 8, ["loading"])) : u("", true), o(v, { loading: f.loading, size: "default", type: "success", onClick: e(b) }, { default: a(() => s[5] || (s[5] = [_(" 上一步 ")])), _: 1, __: [5] }, 8, ["loading", "onClick"]), o(v, { loading: f.loading, size: "default", type: "primary", onClick: s[1] || (s[1] = (r) => V(e(R).NO.V)) }, { default: a(() => s[6] || (s[6] = [_(" 发起审批 ")])), _: 1, __: [6] }, 8, ["loading"])]), content: a(() => [l("div", fe, [e(te)(e(t)) ? (p(), g(z, { key: 0, model: e(t), "label-position": "left", "label-width": "100px", size: "small" }, { default: a(() => [l("div", ye, [l("div", be, [o(n, { label: "合同类型", prop: "boolAnnual" }, { default: a(() => [l("span", null, i(e(se).VL[e(t).boolAnnual]), 1)]), _: 1 }), o(n, { label: "材料类型", prop: "basicClass" }, { default: a(() => [l("div", ve, [e(t).materialType & e(M).MATERIAL.V ? u("", true) : c((p(), d("span", ge, null, 512)), [[m, { e: e(M), v: e(t).materialType, extra: "：" }]]), c(l("span", null, null, 512), [[m, { e: e(ae), v: e(t).basicClass, bit: true, split: " | " }]])])]), _: 1 }), o(n, { label: "合同量", prop: "mete" }, { default: a(() => [l("span", null, i(e(t).mete) + " " + i(e(t).meteUnit), 1)]), _: 1 }), o(n, { label: "合同额", prop: "amount" }, { default: a(() => [l("span", null, i(e(t).amount) + " 元", 1)]), _: 1 }), o(n, { label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: a(() => [c(l("span", null, null, 512), [[m, { e: e(le), v: e(t).purchaseOrderPaymentMode }]])]), _: 1 }), o(n, { label: "计量方式", prop: "weightMeasurementMode" }, { default: a(() => [c(l("span", null, null, 512), [[m, { e: e(oe), v: e(t).weightMeasurementMode }]])]), _: 1 }), o(n, { label: "物流信息", prop: "logistics" }, { default: a(() => [c(l("span", null, null, 512), [[m, { e: e(ne), v: e(t).logisticsTransportType }]]), s[7] || (s[7] = _(" （费用")), c(l("span", null, null, 512), [[m, { e: e(ie), v: e(t).logisticsPayerType }]]), s[8] || (s[8] = _("） "))]), _: 1, __: [7, 8] }), o(n, { label: "供应商", prop: "supplier" }, { default: a(() => [e(t).supplierId ? (p(), d("span", he, i(e(S)[e(t).supplierId].name), 1)) : u("", true)]), _: 1 }), o(n, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: a(() => [e(t).branchCompany ? (p(), d("span", we, i(e(t).branchCompany.name), 1)) : u("", true)]), _: 1 }), o(n, { label: "发票及税率", prop: "invoiceType" }, { default: a(() => [c(l("span", null, null, 512), [[m, { e: e(j), v: e(t).invoiceType }]]), e(t).invoiceType !== e(j).RECEIPT.V ? (p(), d("span", Te, "（" + i(e(t).taxRate) + "%）", 1)) : u("", true), s[9] || (s[9] = _("】 "))]), _: 1, __: [9] }), o(n, { label: "目的地", prop: "level", style: { width: "100%" } }, { default: a(() => [e(t).level ? (p(), d("span", Ve, i(e(re).VL[e(t).level]), 1)) : u("", true)]), _: 1 }), o(n, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: a(() => [l("span", Ee, i(e(t).remark), 1)]), _: 1 }), o(n, { class: "el-form-item-4", label: "关联项目", prop: "projectIds", style: { width: "100%" } }, { default: a(() => [e(pe).RAW_MATERIAL.V === e(t).purchaseType ? (p(), d("span", ke, i(e(t).projects ? e(t).projects.map((r) => e(ue)(r, null, false)).join(`
`) : ""), 1)) : u("", true)]), _: 1 }), o(I, null, { default: a(() => s[10] || (s[10] = [l("span", { class: "title" }, "附件", -1)])), _: 1, __: [10] }), o(de, { files: e(t).attachments, "onUpdate:files": s[2] || (s[2] = (r) => e(t).attachments = r), "file-classify": e(me).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])]), s[12] || (s[12] = l("div", { class: "vertical-dashed-divider" }, null, -1)), l("div", Ce, [l("div", xe, [l("span", Pe, [s[11] || (s[11] = l("span", { class: "label" }, "采购清单", -1)), (p(true), d(H, null, U(e(t).actualRequisitionIds, (r) => (p(), d("span", { key: r }, [o(N, { class: "preparation-sn-tag", effect: "plain", size: "large" }, { default: a(() => {
      var C, x;
      return [_(i((x = (C = e(t).requisitionsKV) == null ? void 0 : C[r]) == null ? void 0 : x.serialNumber) + " " + i(e(_e).VL[e(t).requisitionsKV[r].purchaseCreationState]), 1)];
    }), _: 2 }, 1024)]))), 128))])]), o(ce, { form: e(t), list: e(t).list, "material-type": e(t).materialType, "max-height": e(A) - 150 }, null, 8, ["form", "list", "material-type", "max-height"])])])]), _: 1 }, 8, ["model"])) : u("", true)])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ie = W(Re, [["__scopeId", "data-v-10ab7697"]]);
export {
  Ie as default
};
