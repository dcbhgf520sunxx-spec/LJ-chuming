import { ref as f } from "vue";
import { computed as b } from "vue";
import { provide as Te } from "vue";
import { watch as Ve } from "vue";
import { resolveComponent as X } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as t } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as u } from "vue";
import { unref as o } from "vue";
import { createElementBlock as C } from "vue";
import { Fragment as I } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementVNode as y } from "vue";
import { isRef as Ne } from "vue";
import { ElTag as Ae } from "element-plus";
import { ElDescriptionsItem as ke } from "element-plus";
import { ElDescriptions as xe } from "element-plus";
import { ElDivider as Ce } from "element-plus";
import { ElTableColumn as Le } from "element-plus";
import { ElInput as Se } from "element-plus";
import { i as Pe } from "../../../../../../../modules/payable-list-dd7ea2e5.js";
import { _ as Fe, t as De, u as Ue, jX as Re, bD as Z, D as d, jY as Ie, o as Me, ib as M, jV as L, gS as Ye, b as Oe, i as g, jZ as je, j_ as Be, gO as We, j$ as qe, cO as $e, jl as He, k0 as S, bR as J, am as Y, V as Q, k1 as Ge, p as Ke, bV as ze, jN as ee, k2 as Xe, k3 as Ze, aR as ae, k4 as le, jG as te, jH as se, k5 as ie, jI as oe, k6 as ue, k7 as Je, ba as ne } from "../../../../../../../shared/runtime.js";
const Qe = { key: 3 }, ea = { class: "inventory" }, aa = { class: "right-box" }, la = { class: "head-container", style: { "margin-top": "15px" } }, ta = { __name: "inbound-detail", props: { modelValue: { type: Boolean, require: true }, id: { type: [Number, String], default: () => {
} } }, emits: ["update:modelValue"], setup(re, { emit: ce }) {
  const me = ce, P = re, { decimalPrecision: F } = De(), { visible: D, handleClose: de } = Ue({ emit: me, props: P }), h = f([]), _ = f([]), O = b(() => [...Re, ["invoiceType", ["parse-enum", Z, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", F.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", F.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", F.value.wms]], ["unitPriceNoFreight", ["to-thousand", F.value.wms]], ["amount", ["to-thousand", d.YUAN]], ["amountExcludingVAT", ["to-thousand", d.YUAN]], ["amountNoFreight", ["to-thousand", d.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", d.YUAN]], ["inputVAT", ["to-thousand", d.YUAN]], ["inputVATNoFreight", ["to-thousand", d.YUAN]], ["remark", "empty-text"]]), ve = f(), T = f([]), e = f({}), U = f(false), { inboundFillWayCfg: V } = Ie(), j = f(), pe = f();
  f(false);
  const B = b(() => {
    var a;
    let n = 0;
    return (a = e.value.list) == null || a.forEach((w) => {
      n += Number(w.mete) || 0;
    }), n;
  }), { maxHeight: W } = Me({ mainBox: ".inbound-detail-dialog", extraBox: [".el-drawer__header", ".inspection-return-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 40 }, ve), v = b(() => e.value.purchaseOrder || {}), q = b(() => e.value.reviewStatus === M.PASS.V && v.value.logisticsPayerType === L.DEMAND.V);
  b(() => V.value ? V.value.amountFillWay === Ye.REVIEWING.V : false);
  const N = b(() => Oe(v.value.detail) || g(v.value.detail) && V.value.passedInboundState);
  f(M.PASS.V);
  const A = b(() => {
    var n;
    return ((n = e.value) == null ? void 0 : n.supplyType) === je.PARTY_A.V;
  }), $ = b(() => e.value.basicClass & Be.MANUFACTURED.V), be = b(() => v.value.logisticsPayerType === L.DEMAND.V && (V.value ? V.value.freightShowScene === We.INVENTORY_REVIEW.V : true)), H = b(() => e.value.inboundWay === qe.OPENING_RECEIPT.V);
  Te("isBegin", H);
  const ge = b(() => H.value ? U.value ? "入库单" : `入库单：${e.value.serialNumber}` : U.value ? "入库单" : `入库单：${e.value.serialNumber}（ ${v.value.supplier ? v.value.supplier.name : "无供应商"} ）`), k = b(() => {
    const n = N.value && !A.value && v.value.projects && v.value.requisitionsSN, a = N.value && A.value && v.value.projects && v.value.requisitionsSN;
    return !(n || a);
  });
  Ve(D, (n) => {
    n && fe();
  }, { immediate: true, deep: true });
  async function fe() {
    if (e.value = {}, !!P.id) {
      U.value = true;
      try {
        const n = await Pe(P.id);
        if (e.value = n, e.value.list.map((a) => {
          a.originUnitPrice = a.unitPrice, a.originAmount = a.amount;
        }), await $e(e.value.list), e.value.list = await He(e.value.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), e.value.qualityTestingEnum & S.UNREVIEWED.V) {
          _.value = [], h.value = [], e.value.list.forEach((a) => {
            a.weightMeasurementMode === J.OVERWEIGHT.V && (a.basicClass & Y.STEEL_PLATE.V || a.basicClass & Y.SECTION_STEEL.V) ? _.value.push(a) : h.value.push(a);
          });
          return;
        }
        e.value.originList = Q(e.value.list), e.value.list = e.value.originList.filter((a) => a.qualityTestingEnum & (S.ALL_PASS.V | S.NO.V)), _.value = [], h.value = [], e.value.list.forEach((a) => {
          a.weightMeasurementMode === J.OVERWEIGHT.V && (a.basicClass & Y.STEEL_PLATE.V || a.basicClass & Y.SECTION_STEEL.V) ? _.value.push(a) : h.value.push(a);
        }), e.value.returnList = e.value.originList.filter((a) => a.qualityTestingEnum & S.ALL_REFUSE.V), e.value.logistics = g(e.value.logistics) ? e.value.logistics : {}, e.value.originLogistics = g(e.value.logistics) ? Q(e.value.logistics) : {};
      } catch (n) {
        console.log("获取入库详情失败", n);
      } finally {
        U.value = false;
      }
    }
  }
  function ye(n) {
    return ne({ ...n, data: h.value || [] }, { props: ["quantity", "mete", ["amount", d.YUAN], ["amountExcludingVAT", d.YUAN], ["inputVAT", d.YUAN], ["amountNoFreight", d.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  function he(n) {
    return ne({ ...n, data: _.value || [] }, { props: ["quantity", "mete", ["amount", d.YUAN], ["amountExcludingVAT", d.YUAN], ["inputVAT", d.YUAN], ["amountNoFreight", d.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (n, a) => {
    const w = Ae, p = ke, G = xe, _e = Ce, R = Le, K = X("common-table"), we = Se, Ee = X("common-drawer");
    return i(), c(Ee, { ref: "dialogRef", title: ge.value, "close-on-click-modal": false, modelValue: o(D), "onUpdate:modelValue": a[3] || (a[3] = (E) => Ne(D) ? D.value = E : null), direction: "rtl", "before-close": o(de), "custom-class": "inbound-detail-dialog", size: "95%" }, { titleAfter: t(() => {
      var E;
      return [s(w, null, { default: t(() => [r(u(e.value.supplyType === 1 ? "自购" : "甲供"), 1)]), _: 1 }), s(Ge, { detail: e.value, order: v.value }, null, 8, ["detail", "order"]), s(w, { type: (E = o(M).V[e.value.reviewStatus]) == null ? void 0 : E.TAG }, { default: t(() => [r(u(o(M).VL[e.value.reviewStatus]), 1)]), _: 1 }, 8, ["type"]), s(w, { effect: "plain" }, { default: t(() => [r("入库时间：" + u(o(Ke)(e.value.createTime, "{y}-{m}-{d}")), 1)]), _: 1 })];
    }), content: t(() => {
      var E;
      return [o(g)(e.value.purchaseOrder) ? (i(), c(G, { key: 0, column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: t(() => [s(p, { label: "采购合同号", "label-class-name": "contractLabel" }, { default: t(() => {
        var l;
        return [r(u((l = e.value.purchaseOrder) == null ? void 0 : l.serialNumber), 1)];
      }), _: 1 }), s(p, { label: "供应商", "label-class-name": "contractLabel" }, { default: t(() => {
        var l, x;
        return [r(u((x = (l = e.value.purchaseOrder) == null ? void 0 : l.supplier) == null ? void 0 : x.name), 1)];
      }), _: 1 }), s(p, { label: "合同额", "label-class-name": "contractLabel" }, { default: t(() => {
        var l;
        return [r(u(o(ze)((l = e.value.purchaseOrder) == null ? void 0 : l.amount, o(d).YUAN)), 1)];
      }), _: 1 }), s(p, { label: "累计入库额(元)", "label-class-name": "contractLabel" }, { default: t(() => [r(u(e.value.sumAmount), 1)]), _: 1 }), s(p, { label: "采购创建人", "label-class-name": "contractLabel" }, { default: t(() => {
        var l;
        return [r(u((l = e.value.purchaseOrder) == null ? void 0 : l.applicantName), 1)];
      }), _: 1 }), s(p, { label: "办理人", "label-class-name": "contractLabel" }, { default: t(() => [r(u(e.value.applicantName), 1)]), _: 1 }), s(p, { label: "质检人", "label-class-name": "contractLabel" }, { default: t(() => [r(u(e.value.qualityTestingEnum ? e.value.qualityTestingEnum === o(S).NO.V ? "无需质检" : e.value.qualityTestingUserName : "-"), 1)]), _: 1 }), o(g)(e.value.logistics) ? (i(), C(I, { key: 0 }, [v.value.logisticsPayerType === o(L).DEMAND.V ? (i(), c(p, { key: 0, label: "运输费(元)", "label-class-name": "contractLabel" }, { default: t(() => {
        var l;
        return [r(u((l = e.value.logistics) == null ? void 0 : l.freightInitial), 1)];
      }), _: 1 })) : m("", true), v.value.logisticsPayerType === o(L).DEMAND.V ? (i(), c(p, { key: 1, label: "装车费(元)", "label-class-name": "contractLabel" }, { default: t(() => {
        var l;
        return [r(u((l = e.value.logistics) == null ? void 0 : l.loadingCharge), 1)];
      }), _: 1 })) : m("", true), v.value.logisticsPayerType === o(L).DEMAND.V ? (i(), c(p, { key: 2, label: "物流费发票及税率", "label-class-name": "contractLabel" }, { default: t(() => {
        var l, x, z;
        return [r(u((l = e.value.logistics) != null && l.invoiceType ? o(Z).VL[(x = e.value.logistics) == null ? void 0 : x.invoiceType] + "【" + ((z = e.value.logistics) == null ? void 0 : z.taxRate) + "%】" : "-"), 1)];
      }), _: 1 })) : m("", true)], 64)) : m("", true), o(g)(e.value.logistics) && o(g)(e.value.logistics.freightWeight) ? (i(), c(p, { key: 1, label: "运输重量", "label-class-name": "contractLabel" }, { default: t(() => [r(u(e.value.logistics.freightWeight) + " " + u(o(ee).weight.unit), 1)]), _: 1 })) : m("", true), o(g)(e.value.logistics) && o(g)(e.value.logistics.supplierName) ? (i(), c(p, { key: 2, label: "物流单位", "label-class-name": "contractLabel" }, { default: t(() => [r(u(e.value.logistics.supplierName), 1)]), _: 1 })) : m("", true)]), _: 1 })) : (i(), c(G, { key: 1, column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: t(() => [s(p, { label: "录入办理人", "label-class-name": "contractLabel" }, { default: t(() => [r(u(e.value.applicantName), 1)]), _: 1 }), s(p, { label: "本次入库", "label-class-name": "contractLabel" }, { default: t(() => [r(u(B.value), 1)]), _: 1 })]), _: 1 })), (E = e.value.returnList) != null && E.length ? (i(), c(Xe, { key: 2, "basic-class": e.value.basicClass, boolPartyA: A.value, list: e.value.returnList, showAmount: N.value, showTableColumnSecondary: k.value, class: "inspection-return-info" }, null, 8, ["basic-class", "boolPartyA", "list", "showAmount", "showTableColumnSecondary"])) : m("", true), s(_e, null, { default: t(() => a[4] || (a[4] = [y("span", { class: "title" }, "入库明细", -1)])), _: 1, __: [4] }), e.value.basicClass & o(Ze) ? (i(), C("div", Qe, [y("div", ea, [a[5] || (a[5] = y("div", { class: "left-box" }, " 汇总 ", -1)), y("div", aa, u(B.value || 0) + u(o(ee).weight.unit), 1)])])) : m("", true), o(g)(h.value) ? (i(), C(I, { key: 4 }, [s(w, { type: "success", style: { "margin-bottom": "15px" } }, { default: t(() => a[6] || (a[6] = [r("理计汇总")])), _: 1, __: [6] }), s(K, { "cell-class-name": n.wrongCellMask, data: h.value, "data-format": O.value, "expand-row-keys": T.value, "max-height": o(W) - 180, "summary-method": ye, "row-key": "id", "show-summary": "" }, { default: t(() => [s(ae, { "expand-row-keys": T.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (l) => T.value = l), data: e.value.list, fixed: "left", "row-key": "id" }, { default: t(({ row: l }) => [k.value ? m("", true) : (i(), c(le, { key: 0, "basic-class": e.value.basicClass, row: l, "show-brand": "" }, null, 8, ["basic-class", "row"])), y("p", null, [a[7] || (a[7] = r(" 备注：")), y("span", null, u(l.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(te, { "basic-class": e.value.basicClass, fixed: "left" }, null, 8, ["basic-class"]), s(se, { "basic-class": e.value.basicClass }, null, 8, ["basic-class"]), k.value ? (i(), c(ie, { key: 0, "basic-class": e.value.basicClass }, null, 8, ["basic-class"])) : m("", true), N.value && !A.value ? (i(), c(oe, { key: 1, "inbound-way": e.value.inboundWay, showFreight: q.value }, null, 8, ["inbound-way", "showFreight"])) : m("", true), s(R, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), $.value ? (i(), c(R, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (i(), c(ue, { key: 2 }))]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])], 64)) : m("", true), o(g)(_.value) ? (i(), C(I, { key: 5 }, [y("div", la, [s(w, { class: "filter-item" }, { default: t(() => a[8] || (a[8] = [r("磅计汇总")])), _: 1, __: [8] })]), s(K, { "cell-class-name": n.wrongCellMask, data: _.value, "data-format": O.value, "expand-row-keys": T.value, "max-height": o(W), "summary-method": he, "row-key": "id", "show-summary": "" }, { default: t(() => [s(ae, { "expand-row-keys": T.value, "onUpdate:expandRowKeys": a[1] || (a[1] = (l) => T.value = l), data: e.value.list, fixed: "left", "row-key": "id" }, { default: t(({ row: l }) => [k.value ? m("", true) : (i(), c(le, { key: 0, "basic-class": e.value.basicClass, row: l, "show-brand": "" }, null, 8, ["basic-class", "row"])), y("p", null, [a[9] || (a[9] = r(" 备注：")), y("span", null, u(l.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(te, { "basic-class": e.value.basicClass, fixed: "left" }, null, 8, ["basic-class"]), s(se, { "basic-class": e.value.basicClass }, null, 8, ["basic-class"]), k.value ? (i(), c(ie, { key: 0, "basic-class": e.value.basicClass }, null, 8, ["basic-class"])) : m("", true), N.value && !A.value ? (i(), c(oe, { key: 1, showFreight: q.value }, null, 8, ["showFreight"])) : m("", true), s(R, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), $.value ? (i(), c(R, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (i(), c(ue, { key: 2 }))]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])], 64)) : m("", true), P.ApprovalFlag ? (i(), C(I, { key: 6 }, [be.value && e.value.editMoney ? (i(), c(Je, { key: 0, ref_key: "logisticsRef", ref: pe, disabled: n.formDisabled, form: e.value.logistics, class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : m("", true), s(we, { modelValue: j.value, "onUpdate:modelValue": a[2] || (a[2] = (l) => j.value = l), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px", width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])], 64)) : m("", true)];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ua = Fe(ta, [["__scopeId", "data-v-71e4f72c"]]);
export {
  ua as default
};
