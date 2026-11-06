import { inject as ae } from "vue";
import { ref as _ } from "vue";
import { computed as f } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as A } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementVNode as E } from "vue";
import { ElTag as te } from "element-plus";
import { ElDescriptionsItem as le } from "element-plus";
import { ElDescriptions as oe } from "element-plus";
import { ElDivider as se } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElInput as ne } from "element-plus";
import { _ as re, t as ue, jX as ce, bD as P, D as d, gt as me, ib as k, jY as de, o as pe, G as fe, jZ as ge, j_ as _e, jV as x, gO as be, cO as he, jR as ye, Ae as we, p as ve, xn as xe, i as b, bV as Ne, jN as R, aR as Ve, BU as Ae, k6 as Ee, k7 as ke, ba as Te } from "../../../../../../../shared/runtime.js";
const De = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(U, { emit: Le }) {
  const { decimalPrecision: w } = ue(), C = ae("permission");
  _(false);
  const Y = U, B = f(() => [...ce, ["invoiceType", ["parse-enum", P, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", w.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", w.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", w.value.wms]], ["unitPriceNoFreight", ["to-thousand", w.value.wms]], ["amount", ["to-thousand", d.YUAN]], ["amountExcludingVat", ["to-thousand", d.YUAN]], ["amountNoFreight", ["to-thousand", d.YUAN]], ["amountExcludingVatNoFreight", ["to-thousand", d.YUAN]], ["inputVat", ["to-thousand", d.YUAN]], ["inputVatNoFreight", ["to-thousand", d.YUAN]], ["remark", "empty-text"], ["monomerName", "empty-text"], ["areaName", "empty-text"]]), j = _(), N = _([]), { CRUD: M, crud: h, detail: a } = me(), T = _();
  _(k.PASS.V);
  const O = _(), { inboundFillWayCfg: D } = de(), { maxHeight: I } = pe({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => f(() => !h.detailLoading)), p = f(() => a.purchaseOrder || {}), H = f(() => false), $ = f(() => fe(C.showAmount)), W = f(() => {
    var g;
    return ((g = p.value) == null ? void 0 : g.supplyType) === ge.PARTY_A.V;
  }), K = f(() => a.basicClass & _e.MANUFACTURED.V), z = f(() => h.detailLoading ? "制成品入库单" : `制成品入库单：${a.serialNumber}（ ${p.value.supplier ? p.value.supplier.name : "无供应商"} ）`), G = f(() => p.value.logisticsPayerType === x.DEMAND.V && (D.value ? D.value.freightShowScene === be.INVENTORY_REVIEW.V : true));
  M.HOOK.beforeDetailLoaded = async (g, r) => {
    await he(r.list), await ye(r.list, { toSmallest: false, toNum: false }, { amount: ["unitPrice", "unitPriceExcludingVat"] });
  };
  function q(g) {
    return Te(g, { props: ["quantity", ["mete", R.weight.precision], ["amount", d.YUAN], ["amountExcludingVat", d.YUAN], ["inputVat", d.YUAN], ["amountExcludingVat", d.YUAN]], toThousandFields: ["amount", "amountExcludingVat", "inputVat", "amountNoFreight"] });
  }
  return (g, r) => {
    const L = te, u = le, X = oe, Z = se, v = ie, J = F("common-table"), Q = ne, ee = F("common-drawer");
    return i(), c(ee, { ref_key: "drawerRef", ref: j, visible: e(h).detailVisible, "content-loading": e(h).detailLoading, "before-close": e(h).cancelDetail, title: z.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-record-detail" }, { titleAfter: l(() => {
      var t;
      return [o(we, { detail: e(a), order: p.value }, null, 8, ["detail", "order"]), o(L, { type: (t = e(k).V[e(a).reviewStatus]) == null ? void 0 : t.TAG }, { default: l(() => [n(s(e(k).VL[e(a).reviewStatus]), 1)]), _: 1 }, 8, ["type"]), o(L, { effect: "plain" }, { default: l(() => [n("入库申请时间：" + s(e(ve)(e(a).createTime, "{y}-{m}-{d}")), 1)]), _: 1 })];
    }), titleRight: l(() => [o(xe, { "purchase-id": p.value.id, size: "default" }, null, 8, ["purchase-id"])]), content: l(() => [e(b)(e(a).purchaseOrder) ? (i(), c(X, { key: 0, column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: l(() => [o(u, { label: "采购合同号", "label-class-name": "contractLabel" }, { default: l(() => {
      var t;
      return [n(s((t = e(a).purchaseOrder) == null ? void 0 : t.serialNumber), 1)];
    }), _: 1 }), o(u, { label: "供应商", "label-class-name": "contractLabel" }, { default: l(() => {
      var t, y;
      return [n(s((y = (t = e(a).purchaseOrder) == null ? void 0 : t.supplier) == null ? void 0 : y.name), 1)];
    }), _: 1 }), o(u, { label: "合同额", "label-class-name": "contractLabel" }, { default: l(() => {
      var t;
      return [n(s(e(Ne)((t = e(a).purchaseOrder) == null ? void 0 : t.amount, e(d).YUAN)), 1)];
    }), _: 1 }), o(u, { label: "累计入库额(元)", "label-class-name": "contractLabel" }, { default: l(() => [n(s(e(a).sumAmount), 1)]), _: 1 }), o(u, { label: "采购创建人", "label-class-name": "contractLabel" }, { default: l(() => {
      var t;
      return [n(s((t = e(a).purchaseOrder) == null ? void 0 : t.applicantName), 1)];
    }), _: 1 }), o(u, { label: "办理人", "label-class-name": "contractLabel" }, { default: l(() => [n(s(e(a).applicantName), 1)]), _: 1 }), e(b)(e(a).logistics) ? (i(), V(A, { key: 0 }, [p.value.logisticsPayerType === e(x).DEMAND.V ? (i(), c(u, { key: 0, label: "运输费(元)", "label-class-name": "contractLabel" }, { default: l(() => {
      var t;
      return [n(s((t = e(a).logistics) == null ? void 0 : t.freightInitial), 1)];
    }), _: 1 })) : m("", true), p.value.logisticsPayerType === e(x).DEMAND.V ? (i(), c(u, { key: 1, label: "装车费(元)", "label-class-name": "contractLabel" }, { default: l(() => {
      var t;
      return [n(s((t = e(a).logistics) == null ? void 0 : t.loadingCharge), 1)];
    }), _: 1 })) : m("", true), p.value.logisticsPayerType === e(x).DEMAND.V ? (i(), c(u, { key: 2, label: "物流费发票及税率", "label-class-name": "contractLabel" }, { default: l(() => {
      var t, y, S;
      return [n(s((t = e(a).logistics) != null && t.invoiceType ? e(P).VL[(y = e(a).logistics) == null ? void 0 : y.invoiceType] + "【" + ((S = e(a).logistics) == null ? void 0 : S.taxRate) + "%】" : "-"), 1)];
    }), _: 1 })) : m("", true)], 64)) : m("", true), e(b)(e(a).logistics) && e(b)(e(a).logistics.freightWeight) ? (i(), c(u, { key: 1, label: "运输重量", "label-class-name": "contractLabel" }, { default: l(() => [n(s(e(a).logistics.freightWeight) + " " + s(e(R).weight.unit), 1)]), _: 1 })) : m("", true), e(b)(e(a).logistics) && e(b)(e(a).logistics.supplierName) ? (i(), c(u, { key: 2, label: "物流单位", "label-class-name": "contractLabel" }, { default: l(() => [n(s(e(a).logistics.supplierName), 1)]), _: 1 })) : m("", true)]), _: 1 })) : m("", true), o(Z, null, { default: l(() => r[2] || (r[2] = [E("span", { class: "title" }, "入库明细", -1)])), _: 1, __: [2] }), o(J, { data: e(a).list, "data-format": B.value, "max-height": e(I), "show-summary": "", "summary-method": q, "expand-row-keys": N.value, "row-key": "id" }, { default: l(() => [o(Ve, { data: e(a).list, "expand-row-keys": N.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (t) => N.value = t), "row-key": "id", fixed: "left" }, { default: l(({ row: t }) => [E("p", null, [r[3] || (r[3] = n(" 备注：")), E("span", null, s(t.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), o(v, { prop: "manufacturedSn", label: "编号", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), o(v, { prop: "manufacturedName", label: "名称", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), $.value ? (i(), V(A, { key: 0 }, [W.value ? m("", true) : (i(), c(Ae, { key: 0, showFreight: H.value }, null, 8, ["showFreight"]))], 64)) : m("", true), o(v, { prop: "project", label: "项目", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), K.value ? (i(), c(v, { key: 2, prop: "workshop.name", label: "仓库", align: "left", "min-width": "120px", "show-overflow-tooltip": "" })) : (i(), c(Ee, { key: 1 }))]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"]), Y.ApprovalFlag ? (i(), V(A, { key: 1 }, [G.value && e(a).editMoney ? (i(), c(ke, { key: 0, ref_key: "logisticsRef", ref: O, disabled: g.formDisabled, form: e(a).logistics, class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : m("", true), o(Q, { modelValue: T.value, "onUpdate:modelValue": r[1] || (r[1] = (t) => T.value = t), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px", width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])], 64)) : m("", true)]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, Pe = re(De, [["__scopeId", "data-v-4a4ae47d"]]);
export {
  Pe as default
};
