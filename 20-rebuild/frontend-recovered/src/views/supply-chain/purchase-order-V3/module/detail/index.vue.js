import { useStore as ae } from "vuex";
import { ref as U } from "vue";
import { computed as V } from "vue";
import { watch as se } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as o } from "vue";
import { createBlock as f } from "vue";
import { createSlots as le } from "vue";
import { unref as e } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as c } from "vue";
import { createElementVNode as l } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as O } from "vue";
import { toDisplayString as p } from "vue";
import { normalizeClass as oe } from "vue";
import { Fragment as R } from "vue";
import { renderList as ne } from "vue";
import { ElMessage as N } from "element-plus";
import { ElTag as re } from "element-plus";
import { ElPopconfirm as ie } from "element-plus";
import { ElFormItem as pe } from "element-plus";
import { ElInput as ue } from "element-plus";
import { ElDivider as de } from "element-plus";
import { ElPopover as me } from "element-plus";
import { ElForm as ce } from "element-plus";
import { _ as fe, gt as _e, o as ye, i as y, jO as C, iF as H, cO as ve, jl as be, ib as x, L as he, vi as ge, fE as Ee, jS as we, gD as $, jP as b, cP as Se, bD as q, jT as Te, b as ke, bR as Ve, jU as xe, jV as Ae, z as Re, R as Ne, S as Ce, oz as Pe, jW as je, vj as De } from "../../../../../shared/runtime.js";
const Ie = { key: 0 }, Fe = { key: 0, class: "footer" }, Be = { class: "main-content" }, Me = { key: 0 }, Le = { key: 1 }, Ue = { class: "flex-rss child-mr-10" }, ze = { key: 0 }, Oe = { key: 0 }, He = { key: 0 }, $e = { key: 0 }, qe = { key: 0 }, Ge = { style: { "word-break": "break-all" } }, Ke = { class: "pre-wrap" }, We = { class: "form-right" }, Je = { class: "right-head flex-rbs" }, Qe = { class: "right-head-content" }, Xe = { class: "label" }, Ye = { class: "table-remark" }, Ze = { class: "con" }, et = { class: "con" }, tt = { __name: "index", props: { ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(G, { emit: K }) {
  const W = K, { CRUD: J, crud: E, detail: t } = _e(), Q = ae(), P = G, { maxHeight: j } = ye({ mainBox: ".purchase-order-raw-mat-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, () => E.detailVisible), S = U({ dataId: void 0, opinion: void 0, decision: void 0 }), X = V(() => y(t) && t.serialNumber ? `订单：${t.serialNumber}` : "订单"), T = U(false), D = V(() => t.purchaseStatus === C.FINISHED.V), I = V(() => t.settlementStatus === H.SETTLED.V), F = V(() => {
    var v;
    return !!((v = t.applyPurchase) != null && v.length);
  });
  J.HOOK.beforeDetailLoaded = async (v, a) => {
    var g, w;
    T.value = false, await ve(a.details), await be(a.details, { toNum: true });
    const _ = {};
    if ((g = a.applyPurchase) != null && g.length) for (const r of a.applyPurchase) _[r.id] = r;
    (w = a.details) == null || w.forEach((r) => {
      var k;
      r.purchaseSN = (k = _ == null ? void 0 : _[r.applyPurchaseId]) == null ? void 0 : k.serialNumber;
    });
  }, se(() => S.value.opinion, (v) => {
    v && (T.value = false);
  });
  async function B(v) {
    const a = { dataId: t == null ? void 0 : t.id, opinion: S.value.opinion, decision: v, approveRecordId: t.approveRecordIdNow };
    if (v === x.REFUSE.V && !y(a.opinion)) {
      N.error("请输入审批意见"), T.value = true;
      return;
    }
    await De(a).then((_) => {
      v === x.PASS.V ? N.success("审批通过") : N.error("审批驳回"), W("auditSuccess"), E.cancelDetail();
    }), await Q.dispatch("config/fetchSupplyUsedProject");
  }
  return (v, a) => {
    const _ = re, g = z("common-button"), w = ie, r = pe, k = ue, Y = de, Z = me, ee = ce, te = z("common-drawer"), h = A("parse-enum"), M = A("empty-text"), L = A("parse-time");
    return o(), f(te, { ref: "drawerRef", "before-close": e(E).cancelDetail, "content-loading": e(E).detailLoading, "show-close": true, size: e(y)(e(t).details) ? "100%" : "820px", title: X.value, visible: e(E).detailVisible, "custom-class": "purchase-order-raw-mat-detail" }, le({ titleRight: s(() => [P.ApprovalFlag ? (o(), m("div", Fe, [n(w, { title: "确认通过", onConfirm: a[0] || (a[0] = (d) => B(e(x).PASS.V)) }, { reference: s(() => [n(g, { class: "filter-item", size: "default", type: "success" }, { default: s(() => a[5] || (a[5] = [u("通过")])), _: 1, __: [5] })]), _: 1 }), n(w, { title: "确认驳回", onConfirm: a[1] || (a[1] = (d) => B(e(x).REFUSE.V)) }, { reference: s(() => [n(g, { class: "filter-item", size: "default", type: "danger" }, { default: s(() => a[6] || (a[6] = [u(" 驳回 ")])), _: 1, __: [6] })]), _: 1 })])) : i("", true), n(he, { fn: e(ge), params: { id: e(t).id }, class: "filter-item" }, { default: s(() => a[7] || (a[7] = [u(" 下载采购详情 ")])), _: 1, __: [7] }, 8, ["fn", "params"])]), content: s(() => [l("div", Be, [e(y)(e(t)) ? (o(), f(ee, { key: 0, model: e(t), "label-position": "left", "label-width": "100px", size: "small" }, { default: s(() => [l("div", { style: O(`height: ${e(j) - 90}px`), class: "form-content" }, [l("div", { style: O(`width:${e(y)(e(t).details) ? "450px" : "100%"}`), class: "form-left" }, [n(r, { label: "合同编号", prop: "serialNumber" }, { default: s(() => [l("span", null, p(e(t).serialNumber), 1)]), _: 1 }), n(r, { label: "采购目的", prop: "level" }, { default: s(() => [e(t).level ? (o(), m("span", Me, p(e(Ee).V[e(t).level].SL), 1)) : i("", true)]), _: 1 }), n(r, { label: "合同类型", prop: "boolAnnual" }, { default: s(() => [l("span", null, p(e(we).VL[e(t).boolAnnual]), 1)]), _: 1 }), n(r, { label: "经营方式", prop: "projectAttribute" }, { default: s(() => {
      var d;
      return [e(y)(e(t).projectAttribute) ? (o(), f(_, { key: 0, type: (d = e($).V[e(t).projectAttribute]) == null ? void 0 : d.T }, { default: s(() => [u(p(e($).VL[e(t).projectAttribute]), 1)]), _: 1 }, 8, ["type"])) : (o(), m("span", Le, "-"))];
    }), _: 1 }), n(r, { label: "物料种类", prop: "basicClass" }, { default: s(() => [l("div", Ue, [e(t).materialType & e(b).MATERIAL.V ? i("", true) : c((o(), m("span", ze, null, 512)), [[h, { e: e(b), v: e(t).materialType, extra: "：" }]]), c(l("span", null, null, 512), [[h, { e: e(Se), v: e(t).basicClass, bit: true, split: " | " }]])])]), _: 1 }), e(t).materialType & (e(b).MATERIAL.V | e(b).OTHER.V | e(b).GAS.V) ? i("", true) : (o(), f(r, { key: 0, label: "合同量", prop: "mete" }, { default: s(() => [l("span", null, p(e(t).mete) + " " + p(e(t).meteUnit), 1)]), _: 1 })), n(r, { label: "合同额", prop: "amount" }, { default: s(() => [l("span", null, p(e(t).amount) + " 元", 1), a[8] || (a[8] = u(" 【")), c(l("span", null, null, 512), [[h, { e: e(q), v: e(t).invoiceType }]]), e(t).invoiceType !== e(q).RECEIPT.V ? (o(), m("span", Oe, "（" + p(e(t).taxRate) + "%）", 1)) : i("", true), a[9] || (a[9] = u("】 "))]), _: 1, __: [8, 9] }), e(t).materialType & e(b).STEEL.V ? (o(), f(r, { key: 1, label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: s(() => [c(l("span", null, null, 512), [[h, { e: e(Te), v: e(t).purchaseOrderPaymentMode }]])]), _: 1 })) : i("", true), e(ke)(e(t).details) ? (o(), f(r, { key: 2, label: "计量方式", prop: "weightMeasurementMode" }, { default: s(() => [c(l("span", null, null, 512), [[h, { e: e(Ve), v: e(t).weightMeasurementMode }]])]), _: 1 })) : i("", true), n(r, { label: "物流信息", prop: "logistics" }, { default: s(() => [e(t).materialType & e(b).STEEL.V ? c((o(), m("span", He, null, 512)), [[h, { e: e(xe), v: e(t).logisticsTransportType }]]) : i("", true), a[10] || (a[10] = u(" （费用")), c(l("span", null, null, 512), [[h, { e: e(Ae), v: e(t).logisticsPayerType }]]), a[11] || (a[11] = u("） "))]), _: 1, __: [10, 11] }), n(r, { label: "供应商", prop: "supplier" }, { default: s(() => [e(t).supplier ? (o(), m("span", $e, p(e(t).supplier.name), 1)) : i("", true)]), _: 1 }), n(r, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: s(() => [e(t).branchCompany ? (o(), m("span", qe, p(e(t).branchCompany.name), 1)) : i("", true)]), _: 1 }), n(r, { label: "创建人", prop: "applicantName" }, { default: s(() => [c((o(), m("span", null, [u(p(e(t).applicantName), 1)])), [[M]]), a[12] || (a[12] = u(" （创建时间：")), c(l("span", null, null, 512), [[L, e(t).createTime]]), a[13] || (a[13] = u("） "))]), _: 1, __: [12, 13] }), n(r, { label: "最后操作人", prop: "lastOperatorName" }, { default: s(() => [c((o(), m("span", null, [u(p(e(t).lastOperatorName), 1)])), [[M]]), a[14] || (a[14] = u(" （操作时间：")), c(l("span", null, null, 512), [[L, e(t).userUpdateTime]]), a[15] || (a[15] = u("） "))]), _: 1, __: [14, 15] }), n(r, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: s(() => [l("span", Ge, p(e(t).remark), 1)]), _: 1 }), n(r, { class: "el-form-item-4", label: "关联项目", prop: "projectIds", style: { width: "100%" } }, { default: s(() => [l("span", Ke, p(e(t).projects ? e(t).projects.map((d) => e(Re)(d, null, false)).join(`
`) : ""), 1)]), _: 1 }), P.ApprovalFlag ? (o(), f(r, { key: 3, class: oe(T.value ? "isApproval-not" : ""), label: "审批意见", prop: "opinion", style: { width: "100%" } }, { default: s(() => [n(k, { modelValue: S.value.opinion, "onUpdate:modelValue": a[2] || (a[2] = (d) => S.value.opinion = d), modelModifiers: { trim: true }, class: "input-underline", maxlength: "30", placeholder: "请输入审批意见", size: "small" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["class"])) : i("", true), n(Y, null, { default: s(() => a[16] || (a[16] = [l("span", { class: "title" }, "附件", -1)])), _: 1, __: [16] }), n(Ne, { files: e(t).attachments, "onUpdate:files": a[3] || (a[3] = (d) => e(t).attachments = d), "file-classify": e(Ce).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"]), e(t).wmsApproveRecordFlowDTOS ? (o(), f(Z, { key: 4, placement: e(y)(e(t).details) ? "right-end" : "left-end", width: 400, trigger: "hover" }, { reference: s(() => [n(g, { style: { width: "100%", "margin-top": "20px" } }, { default: s(() => a[17] || (a[17] = [u("查看审批记录")])), _: 1, __: [17] })]), default: s(() => [n(Pe, { data: e(t).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 }, 8, ["placement"])) : i("", true)], 4), e(y)(e(t).details) ? (o(), m(R, { key: 0 }, [a[20] || (a[20] = l("div", { class: "vertical-dashed-divider" }, null, -1)), l("div", We, [l("div", Je, [l("span", Qe, [l("span", Xe, p(F.value ? "关联申购单号" : "采购清单"), 1), (o(true), m(R, null, ne(e(t).applyPurchase, (d) => (o(), f(_, { key: d == null ? void 0 : d.id, class: "preparation-sn-tag", effect: "plain" }, { default: s(() => [u(p(d.serialNumber), 1)]), _: 2 }, 1024))), 128))])]), n(je, { "bool-use-requisitions": F.value, level: e(t).level, list: e(t).details, "material-type": e(t).materialType, "max-height": e(j) - 150 }, null, 8, ["bool-use-requisitions", "level", "list", "material-type", "max-height"]), l("div", Ye, [e(t).materialType & (e(b).MATERIAL.V | e(b).OTHER.V | e(b).GAS.V) ? i("", true) : (o(), m(R, { key: 0 }, [a[18] || (a[18] = l("span", { class: "title" }, "合同量", -1)), l("span", Ze, p(e(t).mete) + " " + p(e(t).meteUnit), 1)], 64)), a[19] || (a[19] = l("span", { class: "title" }, "合同额", -1)), l("span", et, p(e(t).amount) + " 元", 1)])])], 64)) : i("", true)], 4)]), _: 1 }, 8, ["model"])) : i("", true)])]), _: 2 }, [e(y)(e(t)) ? { name: "titleAfter", fn: s(() => [e(t).boolPartyA ? (o(), f(_, { key: 0, effect: "dark", size: "small", type: "danger" }, { default: s(() => a[4] || (a[4] = [u("甲供")])), _: 1, __: [4] })) : i("", true), e(y)(e(t).purchaseStatus) ? (o(), f(_, { key: 1, effect: D.value ? "dark" : "plain", type: D.value ? "success" : e(t).boolUsed ? "warning" : "info", size: "small" }, { default: s(() => [c(l("span", null, null, 512), [[h, { e: e(C), v: e(t).purchaseStatus }]]), e(t).boolUsed && e(t).purchaseStatus === e(C).UNFINISHED.V ? (o(), m("span", Ie, " (有入库)")) : i("", true)]), _: 1 }, 8, ["effect", "type"])) : i("", true), e(y)(e(t).settlementStatus) ? c((o(), f(_, { key: 2, effect: I.value ? "dark" : "plain", type: I.value ? "success" : "info", size: "small" }, null, 8, ["effect", "type"])), [[h, { e: e(H), v: e(t).settlementStatus }]]) : i("", true)]), key: "0" } : void 0]), 1032, ["before-close", "content-loading", "size", "title", "visible"]);
  };
} }, lt = fe(tt, [["__scopeId", "data-v-8ad7c697"]]);
export {
  lt as default
};
