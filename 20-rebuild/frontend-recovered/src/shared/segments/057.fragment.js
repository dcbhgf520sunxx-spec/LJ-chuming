const Yme = { __name: "title-after-info", props: { order: { type: Object, default: () => ({}) }, detail: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, n = Ee(() => (o.detail.basicClass & sl || o.order.basicClass & sl) && o.order.weightMeasurementMode !== Wt.THEORY.V && o.detail.loadingWeight);
  return (c, u) => {
    const r = wi, E = _t("parse-enum");
    return w(), Q(Qe, null, [e.detail.licensePlate ? (w(), U(r, { key: 0, effect: "plain" }, { default: p(() => [Te(K(`车牌：${e.detail.licensePlate}`), 1)]), _: 1 })) : H("", true), e.detail.shipmentNumber ? (w(), U(r, { key: 1, effect: "plain" }, { default: p(() => [Te(K(`物流单号：${e.detail.shipmentNumber}`), 1)]), _: 1 })) : H("", true), n.value ? (w(), U(r, { key: 2, effect: "plain" }, { default: p(() => [Te(K(`过磅重量：${e.detail.loadingWeight}${l(ei).weight.unit}`), 1)]), _: 1 })) : H("", true), e.order.supplyType ? qe((w(), U(r, { key: 3, effect: "plain", type: "info" }, null, 512)), [[E, { e: l(Ni), v: e.order.supplyType }]]) : H("", true), e.order.weightMeasurementMode ? qe((w(), U(r, { key: 4, effect: "plain", type: "info" }, null, 512)), [[E, { e: l(Wt), v: e.order.weightMeasurementMode }]]) : H("", true), e.order.purchaseOrderPaymentMode ? qe((w(), U(r, { key: 5, effect: "plain", type: "info" }, null, 512)), [[E, { e: l(Jl), v: e.order.purchaseOrderPaymentMode }]]) : H("", true)], 64);
  };
} }, w8 = ut(Yme, [["__scopeId", "data-v-ef118815"]]), Kme = Object.freeze(Object.defineProperty({ __proto__: null, default: w8 }, Symbol.toStringTag, { value: "Module" }));
const Wme = { key: 0, class: "footer" }, jme = { key: 0 }, Fme = { key: 1 }, zme = { key: 2 }, Bme = { key: 3 }, Hme = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const { decimalPrecision: n } = Ln(), c = o, u = ft("permission"), r = Z(false), E = e, y = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", n.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", n.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", n.value.wms]], ["unitPriceNoFreight", ["to-thousand", n.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVat", ["to-thousand", Ze.YUAN]], ["amountNoFreight", ["to-thousand", Ze.YUAN]], ["amountExcludingVatNoFreight", ["to-thousand", Ze.YUAN]], ["inputVat", ["to-thousand", Ze.YUAN]], ["inputVatNoFreight", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"], ["monomerName", "empty-text"], ["areaName", "empty-text"]]), b = Z(), V = Z([]), { CRUD: M, crud: g, detail: S } = qi(), h = Z(), T = Z(Lt.PASS.V), _ = Z(), { inboundFillWayCfg: f } = aa(), { maxHeight: m } = Kt({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !g.detailLoading)), R = Ee(() => S.purchaseOrder || {}), v = Ee(() => false), N = Ee(() => Ai(u.showAmount)), P = Ee(() => {
    var q;
    return ((q = R.value) == null ? void 0 : q.supplyType) === Ni.PARTY_A.V;
  }), L = Ee(() => S.basicClass & va.MANUFACTURED.V), O = Ee(() => g.detailLoading ? "制成品入库单" : `制成品入库单：${S.serialNumber}（ ${R.value.supplier ? R.value.supplier.name : "无供应商"} ）`), x = Ee(() => R.value.logisticsPayerType === Bi.DEMAND.V && (f.value ? f.value.freightShowScene === Aa.INVENTORY_REVIEW.V : true));
  M.HOOK.beforeDetailLoaded = async (q, ae) => {
    h.value = void 0, await Qt(ae.list), await fo(ae.list, { toSmallest: false, toNum: false }, { amount: ["unitPrice", "unitPriceExcludingVat"] });
  };
  function I(q) {
    return Hi(q, { props: ["quantity", "mete", ["amount", Ze.YUAN], ["amountExcludingVat", Ze.YUAN], ["inputVat", Ze.YUAN], ["amountExcludingVat", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVat", "inputVat", "amountNoFreight"] });
  }
  async function Y() {
    let q = true;
    return x.value && _.value && (q = await _.value.validate()), q;
  }
  async function ee(q) {
    return q.list = await fo(q.list, { toSmallest: true, toNum: true }), q;
  }
  async function B(q) {
    try {
      r.value = true, T.value = q;
      let ae = true;
      if (q === Lt.REFUSE.V ? (ae = true, Ae(h.value) && (ot.error("请输入审批意见"), ae = false)) : ae = await Y(S), !ae) return;
      const j = At(S);
      let le = await ee(j);
      le.logistics = el(le.originLogistics, le.logistics) ? null : A(le.logistics) ? le.logistics : null;
      const oe = { approveRecordId: S.approveRecordId, decision: q, opinion: h.value };
      le.approvalComments = h.value, q === Lt.REFUSE.V && (le = { id: S.id, opinion: h.value, approveRecordId: S.approveRecordId, decision: q }), await gO(oe, le), c("auditSuccess");
    } catch (ae) {
      console.log("入库审核提交", ae);
    } finally {
      r.value = false;
    }
  }
  return (q, ae) => {
    const j = wi, le = Ve("common-button"), oe = pa, ye = La, ce = qa, se = Ga, he = Ml, be = vt, me = Ve("common-table"), ge = Mt, Le = Ve("common-drawer");
    return w(), U(Le, { ref_key: "drawerRef", ref: b, "before-close": l(g).cancelDetail, "content-loading": l(g).detailLoading, "show-close": true, title: O.value, visible: l(g).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: p(() => {
      var Ie;
      return [s(w8, { detail: l(S), order: R.value }, null, 8, ["detail", "order"]), s(j, { type: (Ie = l(Lt).V[l(S).reviewStatus]) == null ? void 0 : Ie.TAG }, { default: p(() => [Te(K(l(Lt).VL[l(S).reviewStatus]), 1)]), _: 1 }, 8, ["type"]), s(j, { effect: "plain" }, { default: p(() => [Te("入库时间：" + K(l(Qi)(l(S).createTime, "{y}-{m}-{d}")), 1)]), _: 1 })];
    }), titleRight: p(() => {
      var Ie;
      return [E.ApprovalFlag ? (w(), Q("div", Wme, [s(oe, { title: "确认通过", onConfirm: ae[0] || (ae[0] = (Se) => B(l(Lt).PASS.V)) }, { reference: p(() => [s(le, { loading: r.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => ae[4] || (ae[4] = [Te("通过")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 }), s(oe, { title: "确认驳回", onConfirm: ae[1] || (ae[1] = (Se) => B(l(Lt).REFUSE.V)) }, { reference: p(() => [s(le, { loading: r.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => ae[5] || (ae[5] = [Te(" 驳回 ")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 })])) : H("", true), ((Ie = l(S).wmsApproveRecordFlowDTOS) == null ? void 0 : Ie.length) !== 0 ? (w(), U(ye, { key: 1, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s(le, { size: "default" }, { default: p(() => ae[6] || (ae[6] = [Te("查看审批记录")])), _: 1, __: [6] })]), default: p(() => [s(tl, { data: l(S).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : H("", true), s(br, { "purchase-id": R.value.id, size: "default" }, null, 8, ["purchase-id"])];
    }), content: p(() => [l(A)(l(S).purchaseOrder) ? (w(), U(se, { key: 0, column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(ce, { label: "采购合同号", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie;
      return [Te(K((Ie = l(S).purchaseOrder) == null ? void 0 : Ie.serialNumber), 1)];
    }), _: 1 }), s(ce, { label: "供应商", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie, Se;
      return [Te(K((Se = (Ie = l(S).purchaseOrder) == null ? void 0 : Ie.supplier) == null ? void 0 : Se.name), 1)];
    }), _: 1 }), s(ce, { label: "合同额", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie;
      return [Te(K(l(Mi)((Ie = l(S).purchaseOrder) == null ? void 0 : Ie.amount, l(Ze).YUAN)), 1)];
    }), _: 1 }), s(ce, { label: "累计入库额(元)", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(S).sumAmount), 1)]), _: 1 }), s(ce, { label: "采购创建人", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie;
      return [Te(K((Ie = l(S).purchaseOrder) == null ? void 0 : Ie.applicantName), 1)];
    }), _: 1 }), s(ce, { label: "办理人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(S).applicantName), 1)]), _: 1 }), l(A)(l(S).logistics) ? (w(), Q(Qe, { key: 0 }, [R.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(ce, { key: 0, label: "运输费(元)", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie;
      return [Te(K((Ie = l(S).logistics) == null ? void 0 : Ie.freightInitial), 1)];
    }), _: 1 })) : H("", true), R.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(ce, { key: 1, label: "装车费(元)", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie;
      return [Te(K((Ie = l(S).logistics) == null ? void 0 : Ie.loadingCharge), 1)];
    }), _: 1 })) : H("", true), R.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(ce, { key: 2, label: "物流费发票及税率", "label-class-name": "contractLabel" }, { default: p(() => {
      var Ie, Se, X;
      return [Te(K((Ie = l(S).logistics) != null && Ie.invoiceType ? l(fi).VL[(Se = l(S).logistics) == null ? void 0 : Se.invoiceType] + "【" + ((X = l(S).logistics) == null ? void 0 : X.taxRate) + "%】" : "-"), 1)];
    }), _: 1 })) : H("", true)], 64)) : H("", true), l(A)(l(S).logistics) && l(A)(l(S).logistics.freightWeight) ? (w(), U(ce, { key: 1, label: "运输重量", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(S).logistics.freightWeight) + " " + K(q.STEEL_BASE_UNIT.weight.unit), 1)]), _: 1 })) : H("", true), l(A)(l(S).logistics) && l(A)(l(S).logistics.supplierName) ? (w(), U(ce, { key: 2, label: "物流单位", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(S).logistics.supplierName), 1)]), _: 1 })) : H("", true)]), _: 1 })) : H("", true), s(he, null, { default: p(() => ae[7] || (ae[7] = [C("span", { class: "title" }, "入库明细", -1)])), _: 1, __: [7] }), s(me, { data: l(S).list, "data-format": y.value, "expand-row-keys": V.value, "max-height": l(m), "summary-method": I, "row-key": "id", "show-summary": "" }, { default: p(() => [s(Ha, { "expand-row-keys": V.value, "onUpdate:expandRowKeys": ae[2] || (ae[2] = (Ie) => V.value = Ie), data: l(S).list, fixed: "left", "row-key": "id" }, { default: p(({ row: Ie }) => [C("p", null, [ae[8] || (ae[8] = Te(" 备注：")), C("span", null, K(Ie.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(be, { align: "left", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(be, { align: "left", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(be, { key: "project.name", align: "center", label: "项目", "min-width": "150px", prop: "project.name", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: Ie } }) => {
      var Se, X, $;
      return [Te(K(l(A)((Se = Ie.project) == null ? void 0 : Se.name) ? `${(X = Ie.project) == null ? void 0 : X.serialNumber} ${($ = Ie.project) == null ? void 0 : $.name}` : "-"), 1)];
    }), _: 1 }), s(be, { prop: "monomer.name", label: "单体", align: "center", "min-width": "100px", "show-overflow-tooltip": "" }), s(be, { prop: "area.name", label: "区域", align: "center", "min-width": "100px", "show-overflow-tooltip": "" }), s(be, { prop: "totalWeight", label: "计价方式", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: Ie }) => [C("span", null, K(l(Gi).VL[Ie.wageQuotaType]), 1)]), _: 1 }), s(be, { prop: "quantity", label: "数量", align: "center", "min-width": "100px", "show-overflow-tooltip": "" }), s(be, { prop: "accountingUnit", label: "核算单位", width: "90px", align: "center", "show-overflow-tooltip": "" }), s(be, { prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: p(({ row: Ie }) => [Ie.wageQuotaType === l(Gi).WEIGHT.V ? (w(), Q("span", jme, K(l(St)(Ie.weight, "kg", "t", l(Ze).COM_WT__T)), 1)) : H("", true), Ie.wageQuotaType === l(Gi).LENGTH.V ? (w(), Q("span", Fme, K(l(St)(Ie.totalLength, "mm", "m", l(Ze).COM_T__MM)), 1)) : H("", true), Ie.wageQuotaType === l(Gi).AREA.V ? (w(), Q("span", zme, K(l(St)(Ie.totalArea, "mm²", "㎡", 6)), 1)) : H("", true), Ie.wageQuotaType === l(Gi).QUANTITY.V ? (w(), Q("span", Bme, K(Ie.quantity), 1)) : H("", true)]), _: 1 }), N.value ? (w(), Q(Qe, { key: 0 }, [P.value ? H("", true) : (w(), U(Ume, { key: 0, showFreight: v.value }, null, 8, ["showFreight"]))], 64)) : H("", true), L.value ? (w(), U(be, { key: 2, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (w(), U(xl, { key: 1 }))]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), E.ApprovalFlag ? (w(), Q(Qe, { key: 1 }, [x.value && l(S).editMoney ? (w(), U(cd, { key: 0, ref_key: "logisticsRef", ref: _, disabled: q.formDisabled, form: l(S).logistics, class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : H("", true), s(ge, { modelValue: h.value, "onUpdate:modelValue": ae[3] || (ae[3] = (Ie) => h.value = Ie), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px", width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])], 64)) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, S8 = ut(Hme, [["__scopeId", "data-v-99d1f62e"]]), qme = Object.freeze(Object.defineProperty({ __proto__: null, default: S8 }, Symbol.toStringTag, { value: "Module" }));
const Gme = { __name: "form", setup(e) {
  const { CRUD: o, crud: n, form: c } = An();
  ai();
  const u = Ee(() => {
    switch (c.basicClass) {
      case Ge.STRUC_MANUFACTURED.V:
      case Ge.ENCL_MANUFACTURED.V:
        return Ec;
      default:
        return c.basicClass & ho ? Ec : void 0;
    }
  });
  o.HOOK.beforeEditDetailLoaded = async (E, y) => {
    var b, V;
    await Qt(y.list), y.list = await fo(y.list, { toSmallest: false, toNum: true }), y.list.forEach((M) => {
      var g, S, h, T;
      M.warehouseName = ((g = M.workshop) == null ? void 0 : g.name) || M.warehouseName, M.workshopId = ((S = M.workshop) == null ? void 0 : S.id) || M.workshopId, M.warehouseId = ((h = M.warehouse) == null ? void 0 : h.id) || M.warehouseId, M.projectId = ((T = M.project) == null ? void 0 : T.id) || M.projectId;
    }), y.supplierId = (V = (b = y.purchaseOrder) == null ? void 0 : b.supplier) == null ? void 0 : V.id, A(y.purchaseOrder.details) && (y.originList = At(y.list), y.list = [], y.editObj = {}, y.originList.forEach((M) => {
      M.mergeId = M.purchaseOrderDetailId, M.applyPurchaseId = M.applyPurchaseId || M.mergeId, y.editObj[M.mergeId] ? (y.editObj[M.mergeId].applyPurchaseObj[M.applyPurchaseId] ? y.editObj[M.mergeId].applyPurchaseObj[M.applyPurchaseId].push({ ...M }) : y.editObj[M.mergeId].applyPurchaseObj[M.applyPurchaseId] = [{ ...M }], y.editObj[M.mergeId].quantity += M.quantity, y.editObj[M.mergeId].mete += M.mete) : y.editObj[M.mergeId] = { ...M, applyPurchaseObj: { [M.applyPurchaseId]: [{ ...M }] }, isSelected: true };
    }));
  };
  function r() {
    n.cancelCU(), n.refresh();
  }
  return (E, y) => {
    const b = Ve("common-drawer");
    return w(), U(b, { ref: "drawerRef", "before-close": l(n).cancelCU, "content-loading": l(n).editDetailLoading, "show-close": true, title: l(n).status.title, visible: l(n).status.cu > l(o).STATUS.NORMAL, "custom-class": "raw-mat-inbound-application-record-form", size: "90%" }, { content: p(() => [(w(), U(Ri(u.value), { detail: l(c), edit: "", onSuccess: r }, null, 40, ["detail"]))]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, v8 = ut(Gme, [["__scopeId", "data-v-3e0a8fc2"]]), Qme = Object.freeze(Object.defineProperty({ __proto__: null, default: v8 }, Symbol.toStringTag, { value: "Module" })), Zme = (e) => {
  const o = Ht(), n = Ee(() => o.state.wms.loaded.subjoinMsgBool);
  if (n.value || o.dispatch("wms/fetchSetSubjoinMsgBool"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { subjoinMsgBool: Ee(() => o.state.wms.subjoinMsgBool), loaded: Ee(() => o.state.wms.loaded.subjoinMsgBool) };
};
function R8(e, o, n = 2e3) {
  return ot({ type: e, message: o, showClose: true, duration: n });
}
function Jme(e) {
  return W({ url: "/api/contract/audit/listPage", method: "get", params: e });
}
function MEt(e) {
  return W({ url: "/api/contract/audit/insourcingDetail", method: "get", params: e });
}
function AEt(e) {
  return W({ url: "/api/contract/audit/selfemployedDetail", method: "get", params: e });
}
function NEt(e) {
  return W({ url: "/api/contract/audit/supplierSettlement", method: "get", params: e });
}
function LEt(e) {
  return W({ url: "/api/contract/audit/purchaseInvoice", method: "get", params: e });
}
function IEt(e) {
  return W({ url: "/api/contract/audit/insourcingAudit", method: "get", params: e });
}
function CEt() {
  return W({ url: "/api/scm/supplier/all/brief", method: "get" });
}
function Xme(e) {
  return W({ url: "/api/contract/audit/invoice", method: "put", data: e });
}
function $me(e) {
  return W({ url: "/api/contract/audit/outputInvoice", method: "put", data: e });
}
function epe(e) {
  return W({ url: "/api/contract/audit/projectLedger/projectSettlementAudit", method: "put", data: e });
}
function tpe(e) {
  return W({ url: "/api/contract/audit/procurement", method: "put", data: e });
}
function ipe(e) {
  return W({ url: "/api/contract/audit/procurementSelf", method: "put", data: e });
}
function ape(e) {
  return W({ url: "/api/contract/audit/settlementAudit", method: "put", data: e });
}
function lpe(e) {
  return W({ url: `/api/contract/audit/getAudit/${e}`, method: "get" });
}
function PEt(e) {
  return W({ url: `/api/contract/audit/settlementAudit/${e.auditId}`, method: "get" });
}
function OEt(e) {
  return W({ url: `/api/contract/audit/preSettlementAudit/${e.auditId}`, method: "get" });
}
const kEt = { get: Jme };
function ope(e) {
  return W({ url: "/api/contract/audit/subcontract/selfPaymentAudit", method: "put", data: e });
}
function DEt(e) {
  return W({ url: "/api/contract/audit/subcontractSettlementAuditDetail", method: "get", params: e });
}
function xEt(e) {
  return W({ url: "/api/contract/audit/subcontract/settlementAuditDetail", method: "get", params: e });
}
function npe(e) {
  return W({ url: "/api/contract/audit/subcontract/selfSettlementAudit", method: "put", data: e });
}
function spe(e) {
  return W({ url: "/api/contract/audit/subcontract/selfPreSettlementAudit", method: "put", data: e });
}
function rpe(e) {
  return W({ url: "/api/contract/audit/projectLedger/projectPreSettlementAudit", method: "put", data: e });
}
function UEt(e) {
  return W({ url: "/api/contract/audit/testingFee/auditDetail", method: "get", params: e });
}
function YEt(e) {
  return W({ url: "/api/contract/audit/waterElectricityFee/auditDetail", method: "get", params: e });
}
function KEt(e) {
  return W({ url: "/api/contract/audit/reimbursementFee/auditDetail", method: "get", params: e });
}
function WEt(e) {
  return W({ url: "/api/contract/audit/wageFee/auditDetail", method: "get", params: e });
}
function upe(e) {
  return W({ url: "/api/contract/audit/testingFee/audit", method: "post", data: e });
}
function cpe(e) {
  return W({ url: "/api/contract/audit/waterElectricityFee/audit", method: "post", data: e });
}
function dpe(e) {
  return W({ url: "/api/contract/audit/reimbursementFee/audit", method: "post", data: e });
}
function mpe(e) {
  return W({ url: "/api/contract/audit/wageFee/audit", method: "post", data: e });
}
function ppe(e) {
  return W({ url: "/api/contract/audit/subcontract/selfInvoiceAudit", method: "put", data: e });
}
const hpe = { __name: "index", props: { tableItemData: { type: Object }, visible: { type: Boolean } }, emits: ["close", "updateList", "update:visible"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(""), E = Z(null), y = Z(true), b = Z(false), V = Z(false), M = Z(false), g = Z([]), S = Z(false), h = Z("55%"), T = Z([]), _ = zV(), f = { 1: _l(() => d(() => import("./index-398c76ec.js"), ["static/js/index-398c76ec.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 2: _l(() => d(() => import("./index-ef1661f1.js"), ["static/js/index-ef1661f1.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 3: _l(() => d(() => import("./index-aa1fc56b.js"), ["static/js/index-aa1fc56b.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 4: _l(() => d(() => import("./index-aa1fc56b.js"), ["static/js/index-aa1fc56b.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 5: _l(() => d(() => import("./index-8bd4728e.js"), ["static/js/index-8bd4728e.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-b70a6a0f.js", "static/js/logistiics-7d598f3c.js", "static/js/second-table-01aa7ec6.js", "static/css/second-table-e93956a2.css", "static/js/approval-status-71386381.js", "static/css/index-cd434ff3.css"])), 7: _l(() => d(() => import("./index-60182b98.js"), ["static/js/index-60182b98.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 8: _l(() => d(() => import("./index-0c9d3289.js"), ["static/js/index-0c9d3289.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/self-healing-6f411a5c.js", "static/js/approval-status-71386381.js", "static/css/index-2d62c969.css"])), 9: _l(() => d(() => import("./index-9dfc6f54.js"), ["static/js/index-9dfc6f54.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 10: _l(() => d(() => import("./index-0b17c0b5.js"), ["static/js/index-0b17c0b5.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 11: _l(() => d(() => import("./index-9c6a6917.js"), ["static/js/index-9c6a6917.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css"])), 12: _l(() => d(() => import("./index-15f06559.js"), ["static/js/index-15f06559.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/self-healing-6f411a5c.js", "static/js/approval-status-71386381.js", "static/css/index-17173592.css"])), 14: _l(() => d(() => import("./index-5a1f967d.js"), ["static/js/index-5a1f967d.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/approval-status-71386381.js", "static/css/index-950badcc.css"])), 15: _l(() => d(() => import("./index-19f0242d.js"), ["static/js/index-19f0242d.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/approval-status-71386381.js", "static/css/index-6e63a25f.css"])), 16: _l(() => d(() => import("./index-130a7ceb.js"), ["static/js/index-130a7ceb.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/approval-status-71386381.js", "static/css/index-0823b445.css"])), 17: _l(() => d(() => import("./index-97792a0a.js"), ["static/js/index-97792a0a.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/approval-status-71386381.js", "static/css/index-eadda2f5.css"])) }, m = Ee(() => {
    var be;
    return f[(be = u.tableItemData) == null ? void 0 : be.paymentEnum];
  });
  function R() {
    R8("success", "操作成功"), c("update:visible", false), c("updateList");
  }
  async function v(be, me) {
    try {
      await tpe(me), R();
    } catch (ge) {
      console.error("采购付款内包与合营审批失败", ge);
    }
  }
  async function N(be, me) {
    try {
      me.supplierPayment = T.value.map((ge) => ({ supplierPaymentId: ge.orderId, moneyAmount: ge.actuallyPiad })), await ipe(me), R();
    } catch (ge) {
      console.error("采购付款自营审批失败", ge);
    }
  }
  async function P(be, me) {
    try {
      await $me(me), R();
    } catch (ge) {
      console.error("销项发票审批失败", ge);
    }
  }
  async function L(be, me) {
    try {
      await Xme(me), R();
    } catch (ge) {
      console.error("进项发票审批失败", ge);
    }
  }
  async function O(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null, settlementAmount: me.settlementAmount };
      await ape(ge), R();
    } catch (ge) {
      console.error("供应商结算失败", ge);
    }
  }
  async function x(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null };
      await epe(ge), R();
    } catch (ge) {
      console.error("操作失败", ge);
    }
  }
  async function I(be, me) {
    try {
      await ppe(me), R();
    } catch {
      console.log("分包进项审批失败");
    }
  }
  async function Y(be, me) {
    try {
      await ope(me), R();
    } catch (ge) {
      console.log("分包付款审批失败", ge);
    }
  }
  async function ee(be, me) {
    try {
      await npe(me), R();
    } catch (ge) {
      console.log("分包结算审批失败", ge);
    }
  }
  async function B(be, me) {
    try {
      await spe(me), R();
    } catch (ge) {
      console.log("分包结算审批失败", ge);
    }
  }
  async function q(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null };
      await rpe(ge), R();
    } catch (ge) {
      console.log("分包结算审批失败", ge);
    }
  }
  async function ae(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null };
      await upe(ge), R();
    } catch (ge) {
      console.log("检测费用审批失败", ge);
    }
  }
  async function j(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null };
      await cpe(ge), R();
    } catch (ge) {
      console.log("水电费用审批失败", ge);
    }
  }
  async function le(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null };
      await dpe(ge), R();
    } catch (ge) {
      console.log("报销费用审批失败", ge);
    }
  }
  async function oe(be, me) {
    try {
      const ge = { auditId: u.tableItemData.id, auditStatusEnum: be, remark: me.remark || null };
      await mpe(ge), R();
    } catch (ge) {
      console.log("工资审批失败", ge);
    }
  }
  async function ye(be, me) {
    const { tableItemData: { paymentEnum: ge }, tableItemData: Le } = u;
    switch (ge) {
      case 1:
        return [2, 3].includes(Le.projectAttribute) ? await v(be, me) : await N(be, me);
      case 2:
        return [2, 3].includes(Le.projectAttribute) ? void 0 : await Y(be, me);
      case 3:
        return (Le == null ? void 0 : Le.auditType) === 3 ? await I(be, me) : await L(be, me);
      case 4:
        return await P(be, me);
      case 7:
        return await O(be, me);
      case 8:
        return await x(be, me);
      case 9:
        return Le.projectAttribute === 3 || Le.projectAttribute === 2 ? void 0 : await ee(be, me);
      case 10:
        return await O(be, me);
      case 11:
        return await B(be, me);
      case 12:
        return await q(be, me);
      case 14:
        return await ae(be, me);
      case 15:
        return await j(be, me);
      case 16:
        return await le(be, me);
      case 17:
        return await oe(be, me);
      default:
        throw new Error("未知的审批类型");
    }
  }
  const ce = async (be) => {
    try {
      b.value = true;
      const me = E.value.purchaseForm || E.value.formData;
      if (be !== 4) V.value = true, await Promise.all(g.value.map((ge) => ge()));
      else if (M.value = true, !me.remark) return Di({ title: "请填写处理意见!", type: "warning" });
      me.auditStatusEnum = be, await ye(be, me);
    } catch (me) {
      console.error("操作失败", me);
    } finally {
      b.value = false, M.value = false, V.value = false;
    }
  };
  async function se() {
    c("close"), c("update:visible", false);
  }
  Ce(() => u.tableItemData.id, (be) => {
    be && (y.value = true);
  }, { immediate: true, deep: true });
  function he() {
    y.value = false;
  }
  return yi("size", h), yi("saveList", g), yi("purChaseSelfData", T), o({ headerTitle: r }), (be, me) => {
    const ge = xo, Le = pa, Ie = Ve("common-drawer"), Se = oi;
    return w(), U(Ie, { "append-to-body": true, "close-on-click-modal": false, "close-on-press-escape": false, destroyOnClose: true, "show-close": false, size: h.value, title: r.value, visible: u.visible, "custom-class": "approval-detail" }, { titleRight: p(() => [l(_).ApprovalFlag && S.value ? (w(), U(Le, { key: 0, title: "请认真核对实付金额，一旦保存将无法修改?", onConfirm: me[0] || (me[0] = (X) => ce(2)) }, { reference: p(() => [s(ge, { type: "success" }, { default: p(() => me[3] || (me[3] = [Te("通过")])), _: 1, __: [3] })]), _: 1 })) : H("", true), l(_).ApprovalFlag && S.value ? (w(), U(Le, { key: 1, title: "是否确认驳回?", onConfirm: me[1] || (me[1] = (X) => ce(4)) }, { reference: p(() => [s(ge, { loading: M.value, type: "danger" }, { default: p(() => me[4] || (me[4] = [Te("驳回")])), _: 1, __: [4] }, 8, ["loading"])]), _: 1 })) : H("", true), s(ge, { onClick: se }, { default: p(() => me[5] || (me[5] = [Te("关闭")])), _: 1, __: [5] })]), content: p(() => [qe((w(), U(Ri(m.value), { ref_key: "currentComponentRef", ref: E, onUpdateBtn: me[2] || (me[2] = (X) => S.value = X), onVnodeMounted: he }, null, 544)), [[Se, y.value]])]), _: 1 }, 8, ["size", "title", "visible"]);
  };
} }, M8 = ut(hpe, [["__scopeId", "data-v-ee6f8b17"]]), fpe = Object.freeze(Object.defineProperty({ __proto__: null, default: M8 }, Symbol.toStringTag, { value: "Module" }));
class gpe {
  constructor() {
    d(() => Promise.resolve().then(() => I9), void 0).then((o) => {
      this.request = o.default;
    });
  }
  async get(o, n = {}, c = {}) {
    try {
      const u = await this.request({ url: o, method: "get", params: n, ...c });
      return this.handleResponse(u);
    } catch (u) {
      return this.handleError(u, o);
    }
  }
  async post(o, n = {}, c = {}) {
    try {
      const u = await this.request({ url: o, method: "post", data: n, ...c });
      return this.handleResponse(u);
    } catch (u) {
      return this.handleError(u);
    }
  }
  async put(o, n = {}, c = {}) {
    try {
      const u = await this.request({ url: o, method: "put", data: n, ...c });
      return this.handleResponse(u);
    } catch (u) {
      return this.handleError(u);
    }
  }
  delete(o, n = {}, c = {}) {
    return this.request({ url: o, method: "delete", params: n, ...c });
  }
  handleResponse(o) {
    return o;
  }
  handleError(o, n) {
    throw console.error(`${n}: request failed:`, o), o;
  }
}
const Epe = new gpe();
let A8, N8, L8, I8, C8, $u, ec, tc, ic;
E0 && (A8 = Jc || void 0, N8 = nu || void 0);
ph && (L8 = Vc || void 0, I8 = Sc || void 0, C8 = vc || void 0);
Ay && ($u = qc || void 0, ec = Gc || void 0, tc = Hc || void 0, ic = Bc || void 0);
const ype = ["signingDate", "endDate", "startDate", "invoiceDate", "collectionDate", "settlementDate", "auditTime", "dateTime", "createTime", "closingDate", "updateTime", "paymentDate", "applyDate", "filingDate", "shipDate", "date", "submitDate", "interestTime", "expireTime", "approveTime", "arriveTime", "assetInjectionTime", "createDate", "applicantDate", "signDate"], Tpe = ["amount", "expense", "collectionAmount", "invoiceAmount", "contractAmount", "expense", "income", "remainingSum", "cashSurplus", "invoiceAmountSum", "contractAmountSum", "accumulatedPayments", "lineOfCredit", "usedCredit", "expenseMoney", "paymentAmount", "paymentContractAmount", "applyAmount", "collectionSummary", "contractAmount", "projectIncome", "lastFreight", "thisFreight", "freight", "paymentAmountSum", "settlementAmount", "totalPaid", "unpaid", "incomeAmount", "managementFee", "personalCredit", "contractCollectionSummary", "projectExpenditure", "projectIncome", "useAmount", "residueAmount", "projectAmount", "liabilities", "expenditure", "dailyAmount", "accumulatedCollection", "accumulatedInvoice", "actuallyPayAmount", "settlementInterest", "settledInterest", "contractSignBodyScale", "projectManagerScale", "totalAmount", "fixedPrice", "organizationInsidePrice", "organizationOutsidePrice", "actualAmountPaid", "capitalContributorAmount", "totalExpenditure", "materialCost", "laborCost", "leaseCost", "subcontractCost", "otherCost", "indirectCost", "profit", "contractSignBodyPayAmount", "contractSignBodyRemainAmount", "projectManagerPayAmount", "projectManagerRemainAmount", "contractExpenditure", "actualInvoiceAmount", "projectManagerAmount", "contractSignBodyAmount", "accumulatedCost", "advancesReceived", "remainingAdvances", "advancesReceived", "totalIncome", "reimburseAmount", "contractProjectAmount", "remainderInvoice", "remainderPayment", "availableBalance"], _pe = ["incomeType", "expenseType", "collectionMode"], bpe = ["paymentEnum"], Vpe = ["partyType"], P8 = ["projectType", "projectAttribute"], wpe = ["machinePartType"], Spe = ["measurementManner"], vpe = ["statisticsMode"], O8 = { formatTime: (e, o) => e ? Qi(e, o ? "{y}-{m}-{d} {h}:{i}:{s}" : "{y}-{m}-{d}") : void 0, formatIncomeType: (e, o) => (o === "expenseType" ? A8.VL : N8.VL)[e] || e, formatAmount: (e) => Mi(e), formatProjectType: (e) => {
  var o;
  return ((o = L8.V[e]) == null ? void 0 : o.L) || e;
}, formatApprovePayment: (e) => {
  var o;
  return ((o = I8.V[e]) == null ? void 0 : o.L) || e;
}, formatPartyTypeArray: (e) => {
  const o = Array.from(C8.V).find((n) => n.V === e);
  return (o == null ? void 0 : o.L) || e;
}, isPlainObject: (e) => Object.prototype.toString.call(e) === "[object Object]", formatSparePartsType: (e) => {
  var o;
  return ((o = ic == null ? void 0 : ic.V[e]) == null ? void 0 : o.L) || e;
}, formatMeterTypeArray: (e) => {
  var o;
  return ((o = ec == null ? void 0 : ec.V[e]) == null ? void 0 : o.L) || e;
}, formatStatisticsModeTypeArray: (e) => {
  var o, n;
  return ((o = tc == null ? void 0 : tc.V[e]) == null ? void 0 : o.L) || ((n = $u == null ? void 0 : $u.V[e]) == null ? void 0 : n.L) || e;
} };
function h2(e, o = [], n = false) {
  const { formatTime: c, formatIncomeType: u, formatAmount: r, formatProjectType: E, formatApprovePayment: y, formatPartyTypeArray: b, isPlainObject: V, formatSparePartsType: M, formatMeterTypeArray: g, formatStatisticsModeTypeArray: S } = O8, h = { time: (T, _) => {
    ype.includes(T) && _[T] && (_[T] = c(_[T], n));
  }, incomeType: (T, _) => {
    _pe.includes(T) && _[T] && (_[T] = u(_[T], T));
  }, amount: (T, _) => {
    Tpe.includes(T) && (_[T] = r(_[T]));
  }, projectType: (T, _) => {
    P8.includes(T) && _[T] && (_[T + "Name"] = E(_[T]));
  }, approvePayment: (T, _) => {
    bpe.includes(T) && (_[T + "Name"] = y(_[T]));
  }, partyType: (T, _) => {
    Vpe.includes(T) && (_[T] = b(_[T]));
  }, sparePartsType: (T, _) => {
    wpe.includes(T) && _[T] && (_[T + "Name"] = M(_[T]));
  }, meterType: (T, _) => {
    Spe.includes(T) && _[T] && (_[T + "Name"] = g(_[T]));
  }, statisticsModeType: (T, _) => {
    vpe.includes(T) && _[T] && (_[T + "Name"] = S(_[T]));
  } };
  return e = k8(e), e.map((T) => (Object.keys(T).forEach((_) => {
    if (o.includes(_)) return;
    const f = T[_];
    if (V(f)) h2([f]);
    else for (const [m, R] of Object.entries(h)) R(_, T);
  }), T));
}
const k8 = (e) => {
  if (Array.isArray(e)) return e.map((o) => k8(o));
  {
    const o = {};
    for (const n in e) A(e[n]) && (o[n] = e[n]);
    return o;
  }
};
function jEt(e) {
  if (typeof e == "string") return e.includes(",") ? parseFloat(e.replace(/,/g, "")) : e === "-" ? e : parseFloat(e);
  if (typeof e == "number") return e;
}
function FEt(e) {
  return e.forEach((o, n) => {
    typeof o == "number" && (e[n] = Mi(o));
  }), e;
}
function Pm(e, { sustainable: o = [] } = {}) {
  for (const n in e) o.length !== 0 && o.includes(n) || (typeof e[n] == "string" || typeof e[n] == "number" ? e[n] = null : Array.isArray(e[n]) ? e[n].some((u) => typeof u == "object" && u !== null) ? e[n] = e[n].map((u) => typeof u == "object" && u !== null ? Pm({ ...u }) : u) : e[n] = [] : typeof e[n] == "object" && e[n] !== null ? Pm(e[n]) : e[n] = null);
  return e;
}
function zEt(e) {
  return e.map((o) => (o.key && P8.includes(o.key) && o.value && (o.value = O8.formatProjectType(o.value)), o));
}
