import { computed as S } from "vue";
import { ref as x } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as ee } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as n } from "vue";
import { createBlock as y } from "vue";
import { createSlots as ae } from "vue";
import { unref as a } from "vue";
import { withCtx as t } from "vue";
import { withDirectives as p } from "vue";
import { createElementVNode as s } from "vue";
import { createElementBlock as m } from "vue";
import { createCommentVNode as i } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as v } from "vue";
import { normalizeStyle as le } from "vue";
import { toDisplayString as r } from "vue";
import { normalizeClass as te } from "vue";
import { Fragment as j } from "vue";
import { renderList as se } from "vue";
import { isRef as ne } from "vue";
import { ElTag as oe } from "element-plus";
import { ElDescriptionsItem as ue } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElDescriptions as re } from "element-plus";
import { ElDivider as ce } from "element-plus";
import { ElForm as de } from "element-plus";
import { vLoading as pe } from "element-plus";
import { e as me, f as ve } from "../../../../../../../modules/payable-list-dd7ea2e5.js";
import { _ as fe, i as _, u as _e, jO as C, iF as M, o as be, cO as ye, jP as b, jQ as he, jR as Ee, jl as Te, cP as F, L as ge, fE as Ve, jS as ke, bD as H, jT as Le, bR as Se, jU as we, jV as xe, z as Re, R as O, S as z, jW as Ce } from "../../../../../../../shared/runtime.js";
const Ne = { key: 0 }, Pe = { class: "main-content" }, Ae = { class: "form-left" }, De = { key: 0 }, Ue = { class: "flex-rss child-mr-10" }, Be = { key: 0 }, Ie = { key: 0 }, je = { key: 0 }, Me = { key: 0 }, Fe = { key: 0 }, He = { class: "pre-wrap" }, Oe = { style: { "word-break": "break-all" } }, ze = { key: 0, class: "form-right" }, qe = { class: "right-head flex-rbs" }, $e = { class: "right-head-content" }, Ge = { class: "table-remark" }, Qe = { class: "con" }, We = { class: "con" }, Je = { __name: "purchase-detail", props: { modelValue: { type: Boolean, require: true }, id: { type: [Number, String], default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(q, { emit: $ }) {
  const G = $, V = q, Q = S(() => _(e.value) && e.value.serialNumber ? `订单：${e.value.serialNumber}` : "订单"), N = x(), { visible: k, handleClose: W } = _e({ emit: G, props: V }), e = x(), w = x(), P = S(() => e.purchaseStatus === C.FINISHED.V), A = S(() => e.settlementStatus === M.SETTLED.V), J = S(() => {
    var f;
    return !!((f = e.applyPurchase) != null && f.length);
  });
  Z(k, (f) => {
    f && K();
  }, { immediate: true, deep: true });
  const { maxHeight: D } = be({ mainBox: ".purchase-detail-dialog", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, N);
  async function K() {
    var f, l, E, o;
    if (e.value = {}, !!V.id) {
      w.value = true;
      try {
        const g = await me(V.id);
        e.value = g, await ye(e.value.details), e.value.materialType & b.MANUFACTURED.V ? ((f = e.value.details) == null || f.forEach((c) => {
          c.manufacturedUnit = he.V[c.wageQuotaType].C_UNIT;
        }), await Ee(e.value.details, { toNum: true }, { mete: ["mete"], quantity: ["quantity"] })) : (await Te(e.value.details, { toNum: true }), (l = e.value.details) == null || l.forEach((c) => {
          c.basicClass === F.STEEL_COIL.V && (c.quantity = c.length);
        }));
        const T = {};
        if ((E = e.value.applyPurchase) != null && E.length) for (const c of e.value.applyPurchase) T[c.id] = c;
        (o = e.value.details) == null || o.forEach((c) => {
          var L;
          c.purchaseSN = (L = T == null ? void 0 : T[c.applyPurchaseId]) == null ? void 0 : L.serialNumber;
        });
      } catch (g) {
        console.log("获取采购订单详情失败", g);
      } finally {
        w.value = false;
      }
    }
  }
  return (f, l) => {
    var I;
    const E = oe, o = ue, g = ie, T = re, c = ce, L = de, X = ee("common-drawer"), h = R("parse-enum"), U = R("empty-text"), B = R("parse-time"), Y = pe;
    return n(), y(X, { ref_key: "dialogRef", ref: N, title: Q.value, "close-on-click-modal": false, modelValue: a(k), "onUpdate:modelValue": l[3] || (l[3] = (d) => ne(k) ? k.value = d : null), direction: "rtl", "before-close": a(W), "custom-class": "purchase-detail-dialog", size: a(_)((I = e.value) == null ? void 0 : I.details) ? "95%" : "1080px" }, ae({ content: t(() => [p((n(), m("div", Pe, [a(_)(e.value) ? (n(), y(L, { key: 0, model: e.value, "label-position": "left", "label-width": "100px", size: "default" }, { default: t(() => [s("div", { style: le(`height: ${a(D) - 320}px`), class: "form-content" }, [s("div", Ae, [u(T, { column: a(_)(e.value.details) ? 4 : 2, border: "", style: { "margin-bottom": "10px" } }, { default: t(() => [u(o, { label: "合同编号", "label-class-name": "contractLabel" }, { default: t(() => [s("span", null, r(e.value.serialNumber), 1)]), _: 1 }), u(o, { label: "采购目的", "label-class-name": "contractLabel" }, { default: t(() => [e.value.orderPlace ? (n(), m("span", De, r(a(Ve).VL[e.value.orderPlace]), 1)) : i("", true)]), _: 1 }), u(o, { label: "合同类型", "label-class-name": "contractLabel" }, { default: t(() => [s("span", null, r(a(ke).VL[e.value.boolAnnual]), 1)]), _: 1 }), u(o, { label: "物料种类", "label-class-name": "contractLabel" }, { default: t(() => [s("div", Ue, [e.value.materialType && !(e.value.materialType & a(b).MATERIAL.V) ? p((n(), m("span", Be, null, 512)), [[h, { e: a(b), v: e.value.materialType, extra: "：" }]]) : i("", true), p(s("span", null, null, 512), [[h, { e: a(F), v: e.value.basicClass, bit: true, split: " | " }]])])]), _: 1 }), e.value.materialType & (a(b).MATERIAL.V | a(b).OTHER.V | a(b).GAS.V) ? i("", true) : (n(), y(o, { key: 0, label: "合同量", "label-class-name": "contractLabel" }, { default: t(() => [s("span", null, r(e.value.mete) + " " + r(e.value.meteUnit), 1)]), _: 1 })), u(o, { label: "合同额", "label-class-name": "contractLabel" }, { default: t(() => [s("span", null, r(e.value.amount) + " 元", 1), l[5] || (l[5] = v(" 【")), p(s("span", null, null, 512), [[h, { e: a(H), v: e.value.invoiceType }]]), e.value.invoiceType !== a(H).RECEIPT.V ? (n(), m("span", Ie, "（" + r(e.value.taxRate) + "%）", 1)) : i("", true), l[6] || (l[6] = v("】 "))]), _: 1, __: [5, 6] }), e.value.materialType & a(b).STEEL.V ? (n(), y(o, { key: 1, label: "订单类型", "label-class-name": "contractLabel" }, { default: t(() => [p(s("span", null, null, 512), [[h, { e: a(Le), v: e.value.purchaseOrderPaymentMode }]])]), _: 1 })) : i("", true), u(o, { label: "计量方式", "label-class-name": "contractLabel" }, { default: t(() => [p(s("span", null, null, 512), [[h, { e: a(Se), v: e.value.weightMeasurementMode }]])]), _: 1 }), u(o, { label: "物流信息", "label-class-name": "contractLabel" }, { default: t(() => [e.value.materialType & a(b).STEEL.V ? p((n(), m("span", je, null, 512)), [[h, { e: a(we), v: e.value.logisticsTransportType }]]) : i("", true), l[7] || (l[7] = v(" （费用")), p(s("span", null, null, 512), [[h, { e: a(xe), v: e.value.logisticsPayerType }]]), l[8] || (l[8] = v("） "))]), _: 1, __: [7, 8] }), u(o, { label: "供应商", "label-class-name": "contractLabel" }, { default: t(() => [e.value.supplier ? (n(), m("span", Me, r(e.value.supplier.name), 1)) : i("", true)]), _: 1 }), u(o, { label: "采购单位", "label-class-name": "contractLabel" }, { default: t(() => [e.value.branchCompany ? (n(), m("span", Fe, r(e.value.branchCompany.name), 1)) : i("", true)]), _: 1 }), u(o, { label: "创建人", "label-class-name": "contractLabel" }, { default: t(() => [p((n(), m("span", null, [v(r(e.value.applicantName), 1)])), [[U]]), l[9] || (l[9] = v(" （创建时间：")), p(s("span", null, null, 512), [[B, e.value.createTime]]), l[10] || (l[10] = v("） "))]), _: 1, __: [9, 10] }), u(o, { label: "最后操作人", "label-class-name": "contractLabel" }, { default: t(() => [p((n(), m("span", null, [v(r(e.value.lastOperatorName), 1)])), [[U]]), l[11] || (l[11] = v(" （操作时间：")), p(s("span", null, null, 512), [[B, e.value.userUpdateTime]]), l[12] || (l[12] = v("） "))]), _: 1, __: [11, 12] }), u(o, { label: "关联项目", "label-class-name": "contractLabel" }, { default: t(() => [s("span", He, r(e.value.projects ? e.value.projects.map((d) => a(Re)(d, null, false)).join(`
`) : ""), 1)]), _: 1 }), u(o, { label: "备注", "label-class-name": "contractLabel" }, { default: t(() => [s("span", Oe, r(e.value.remark), 1)]), _: 1 }), V.ApprovalFlag ? (n(), y(o, { key: 2, class: te(f.notDecision ? "isApproval-not" : ""), label: "审批意见", "label-class-name": "contractLabel" }, { default: t(() => [u(g, { modelValue: f.AppForm.opinion, "onUpdate:modelValue": l[0] || (l[0] = (d) => f.AppForm.opinion = d), modelModifiers: { trim: true }, class: "input-underline", maxlength: "30", placeholder: "请输入审批意见", size: "default" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["class"])) : i("", true), a(_)(e.value.details) ? (n(), y(o, { key: 3, label: "附件", "label-class-name": "contractLabel" }, { default: t(() => [u(O, { files: e.value.attachments, "onUpdate:files": l[1] || (l[1] = (d) => e.value.attachments = d), "file-classify": a(z).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["column"]), a(_)(e.value.details) ? i("", true) : (n(), y(O, { key: 0, files: e.value.attachments, "onUpdate:files": l[2] || (l[2] = (d) => e.value.attachments = d), "file-classify": a(z).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"]))]), a(_)(e.value.details) ? (n(), m("div", ze, [u(c, null, { default: t(() => l[13] || (l[13] = [s("span", { class: "title" }, "采购清单", -1)])), _: 1, __: [13] }), s("div", qe, [s("span", $e, [(n(true), m(j, null, se(e.value.applyPurchase, (d) => (n(), y(E, { key: d == null ? void 0 : d.id, class: "preparation-sn-tag", effect: "plain" }, { default: t(() => [v(r(d.serialNumber), 1)]), _: 2 }, 1024))), 128))])]), u(Ce, { "bool-use-requisitions": J.value, list: e.value.details, "material-type": e.value.materialType, "max-height": a(D) - 400, level: e.value.level, orderPlace: e.value.orderPlace }, null, 8, ["bool-use-requisitions", "list", "material-type", "max-height", "level", "orderPlace"]), s("div", Ge, [e.value.materialType & (a(b).MATERIAL.V | a(b).OTHER.V | a(b).GAS.V) ? i("", true) : (n(), m(j, { key: 0 }, [l[14] || (l[14] = s("span", { class: "title" }, "合同量", -1)), s("span", Qe, r(e.value.mete) + " " + r(e.value.meteUnit), 1)], 64)), l[15] || (l[15] = s("span", { class: "title" }, "合同额", -1)), s("span", We, r(e.value.amount) + " 元", 1)])])) : i("", true)], 4)]), _: 1 }, 8, ["model"])) : i("", true)])), [[Y, w.value]])]), _: 2 }, [a(_)(e.value) ? { name: "titleAfter", fn: t(() => [a(_)(e.value.purchaseStatus) ? (n(), y(E, { key: 0, effect: P.value ? "dark" : "plain", type: P.value ? "success" : e.value.boolUsed ? "warning" : "info", size: "default" }, { default: t(() => [p(s("span", null, null, 512), [[h, { e: a(C), v: e.value.purchaseStatus }]]), e.value.boolUsed && e.value.purchaseStatus === a(C).UNFINISHED.V ? (n(), m("span", Ne, " (有入库)")) : i("", true)]), _: 1 }, 8, ["effect", "type"])) : i("", true), a(_)(e.value.settlementStatus) ? p((n(), y(E, { key: 1, effect: A.value ? "dark" : "plain", type: A.value ? "success" : "info", size: "default" }, null, 8, ["effect", "type"])), [[h, { e: a(M), v: e.value.settlementStatus }]]) : i("", true)]), key: "0" } : void 0, a(_)(e.value) ? { name: "titleRight", fn: t(() => [u(ge, { fn: a(ve), params: { id: e.value.id }, class: "filter-item" }, { default: t(() => l[4] || (l[4] = [v(" 下载采购详情 ")])), _: 1, __: [4] }, 8, ["fn", "params"])]), key: "1" } : void 0]), 1032, ["title", "modelValue", "before-close", "size"]);
  };
} }, Ze = fe(Je, [["__scopeId", "data-v-26185799"]]);
export {
  Ze as default
};
