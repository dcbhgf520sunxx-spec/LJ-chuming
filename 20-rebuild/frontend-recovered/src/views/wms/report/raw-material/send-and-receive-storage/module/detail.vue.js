import { computed as s } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as z } from "vue";
import { createBlock as l } from "vue";
import { createCommentVNode as r } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as T } from "vue";
import { unref as o } from "vue";
import { Fragment as Q } from "vue";
import { mergeProps as fe } from "vue";
import { resolveDynamicComponent as ie } from "vue";
import { renderSlot as pe } from "vue";
import { createElementVNode as G } from "vue";
import { createVNode as A } from "vue";
import { ElTooltip as Ee } from "element-plus";
import { ref as F } from "vue";
import { inject as ae } from "vue";
import { resolveDirective as Ve } from "vue";
import { withModifiers as le } from "vue";
import { withDirectives as Pe } from "vue";
import { ElInput as Ue } from "element-plus";
import { sQ as we, rJ as ke, bl as m, cV as te, b as a, cS as se, bD as ye, j$ as ue, bV as v, D as x, hW as Se, zF as re, z as Be, xP as Fe, _ as Ie, t as Ce, jX as Le, vx as X, o as Me, u as Oe, i as oe, yY as ce, Cg as Re, pA as _e, jl as je, L as De, Cj as We, Ck as Ye, k5 as $e, ux as qe } from "../../../../../../shared/runtime.js";
import { f as Z } from "../../../../../../modules/enum-deb64dab.js";
const de = { __name: "raw-mat", props: { basicClass: { type: Number }, fixed: { type: String }, showHeatNoAndBatchNo: { type: Boolean, default: true }, showQuantity: { type: Boolean, default: true }, showMete: { type: Boolean, default: true }, showNumber: { type: Boolean, default: true }, showUnit: { type: Boolean, default: true }, showSteelUnit: { type: Boolean, default: false }, outboundTypeMode: { type: Boolean, default: false }, rejectTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, numberPropField: { type: String, default: "quantity" }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, showTip: { type: Boolean, default: false }, showMeasureUnit: { type: Boolean, default: true }, showAccountingUnit: { type: Boolean, default: true }, showTheory: { type: Boolean, default: false } }, setup(t) {
  const e = t, { loaded: b, baseUnit: P } = we(), h = s(() => e.basicClass ? b.value ? P.value[e.basicClass] || {} : ke[e.basicClass] || {} : {}), D = s(() => {
    let c = "";
    if (e.showUnit && e.showSteelUnit) c = "核算量";
    else switch (e.basicClass) {
      case m.STEEL_PLATE.V:
      case m.SECTION_STEEL.V:
      case m.STEEL_COIL.V:
      case te:
        c = `重量(${h.value.weight.unit})`;
        break;
      case m.MATERIAL.V:
      case m.GAS.V:
      default:
        c = "核算量";
        break;
    }
    return (e.labelPrefix || "") + c;
  }), W = s(() => {
    let c = "";
    if (e.showUnit && e.showSteelUnit) c = "数量";
    else switch (e.basicClass) {
      case m.STEEL_PLATE.V:
        c = `数量(${h.value.measure.unit})`;
        break;
      case m.SECTION_STEEL.V:
        c = `数量(${h.value.measure.unit})`;
        break;
      case m.STEEL_COIL.V:
        c = `长度(${h.value.measure.unit})`;
        break;
      case te:
        c = "数量";
        break;
      case m.MATERIAL.V:
      case m.GAS.V:
      default:
        c = "数量";
        break;
    }
    return (e.labelPrefix || "") + c;
  }), O = s(() => e.basicClass & te ? e.showSteelUnit && e.showUnit : e.showUnit), R = s(() => O.value && !a(e.columns) && e.columns.visible("measureUnit") || e.showMeasureUnit), N = s(() => O.value && !a(e.columns) && e.columns.visible("accountingUnit") || e.showAccountingUnit), I = s(() => e.showQuantity && (a(e.columns) || e.columns.visible(e.quantityField))), C = s(() => e.showMete && (a(e.columns) || e.columns.visible(e.meteField))), E = s(() => e.showTheory && (a(e.columns) || e.columns.visible("theoryTotalWeight"))), U = s(() => a(e.columns) || e.columns.visible("outboundUnit")), w = s(() => a(e.columns) || e.columns.visible("rejectUnit")), f = s(() => e.showNumber && (a(e.columns) || e.columns.visible(e.numberPropField)));
  return (c, n) => {
    var J;
    const k = L("vxe-column");
    return t.outboundTypeMode ? (i(), z(Q, { key: 0 }, [U.value ? (i(), l(k, { key: 0, align: "center", field: "outboundUnit", fixed: t.fixed, width: "70px", title: "单位" }, null, 8, ["fixed"])) : r("", true), f.value ? (i(), l(k, { key: 1, align: "right", field: t.numberPropField, fixed: t.fixed, width: "100px", title: "数量" }, { default: d(({ row: V }) => [g(T(V.outboundUnitType === o(se).MEASURE.V ? V[t.quantityField] : V[t.meteField]), 1)]), _: 1 }, 8, ["field", "fixed"])) : r("", true)], 64)) : t.rejectTypeMode ? (i(), z(Q, { key: 1 }, [w.value ? (i(), l(k, { key: 0, align: "center", field: "rejectUnit", fixed: t.fixed, width: "70px", title: "单位" }, null, 8, ["fixed"])) : r("", true), f.value ? (i(), l(k, { key: 1, align: "right", field: t.numberPropField, fixed: t.fixed, width: "100px", title: "数量" }, { default: d(({ row: V }) => [g(T(V.rejectUnitType === o(se).MEASURE.V ? V[t.quantityField] : V[t.meteField]), 1)]), _: 1 }, 8, ["field", "fixed"])) : r("", true)], 64)) : (i(), z(Q, { key: 2 }, [R.value ? (i(), l(k, { key: 0, align: "center", field: "measureUnit", fixed: t.fixed, width: "70px", title: "计量单位" }, null, 8, ["fixed"])) : r("", true), I.value ? (i(), l(k, { key: 1, align: "center", field: t.quantityField, fixed: t.fixed, width: "100px", title: W.value }, null, 8, ["field", "fixed", "title"])) : r("", true), t.showHeatNoAndBatchNo ? (i(), l(k, { key: 2, align: "center", field: "heatNoAndBatchNo", fixed: t.fixed, width: "130px", title: "炉批号/卷号" }, null, 8, ["fixed"])) : r("", true), N.value ? (i(), l(k, { key: 3, align: "center", field: "accountingUnit", fixed: t.fixed, width: "70px", title: "核算单位" }, null, 8, ["fixed"])) : r("", true), t.showTip && t.basicClass === o(m).STEEL_PLATE.V ? (i(), l(k, { key: 4, align: "right", field: "mete", fixed: t.fixed, width: "120px", title: `余料 | 总重(${(J = h.value) == null ? void 0 : J.weight.unit})` }, { default: d(({ row: V }) => [g(T(V.boolReturns ? V.detailMete + " | " + V.mete : V.mete), 1)]), _: 1 }, 8, ["fixed", "title"])) : (i(), z(Q, { key: 5 }, [E.value ? (i(), l(k, { key: 0, align: "right", field: "theoryTotalWeight", fixed: t.fixed, width: "100px", title: "理论重量" }, null, 8, ["fixed"])) : r("", true), C.value ? (i(), l(k, { key: 1, align: "right", field: t.meteField, fixed: t.fixed, width: "100px", title: D.value }, null, 8, ["field", "fixed", "title"])) : r("", true)], 64))], 64));
  };
} }, He = { __name: "index", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, showHeatNoAndBatchNo: { type: Boolean, default: false }, showMete: { type: Boolean, default: true }, outboundTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, showMeasureUnit: { type: Boolean, default: true }, showAccountingUnit: { type: Boolean, default: true }, showQuantity: { type: Boolean, default: true }, showTheory: { type: Boolean, default: false } }, setup(t) {
  const e = t, b = s(() => {
    switch (e.basicClass) {
      case m.STEEL_PLATE.V:
      case m.SECTION_STEEL.V:
      case m.STEEL_COIL.V:
      case m.MATERIAL.V:
      case m.GAS.V:
        return de;
      default:
        return de;
    }
  });
  return (P, h) => (i(), l(ie(b.value), fe({ "basic-class": e.basicClass, columns: e.columns, "label-prefix": e.labelPrefix, "mete-field": t.meteField, "outbound-type-mode": t.outboundTypeMode, "quantity-field": t.quantityField, showAccountingUnit: e.showAccountingUnit, showHeatNoAndBatchNo: e.showHeatNoAndBatchNo, showMeasureUnit: e.showMeasureUnit, showMete: e.showMete, showQuantity: e.showQuantity, showUnit: e.showUnit, showTheory: e.showTheory }, P.$attrs), null, 16, ["basic-class", "columns", "label-prefix", "mete-field", "outbound-type-mode", "quantity-field", "showAccountingUnit", "showHeatNoAndBatchNo", "showMeasureUnit", "showMete", "showQuantity", "showUnit", "showTheory"]));
} }, me = { __name: "raw-mat", props: { columns: { type: Object }, showUnitPriceE: { type: Boolean, default: false }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showInputVAT: { type: Boolean, default: true }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true }, showFreight: { type: Boolean, default: true }, inboundWay: { type: [Number, String] }, DPPrecision: { type: [Number, String] } }, setup(t) {
  const e = t, b = s(() => e.showInvoiceType && (a(e.columns) || e.columns.visible("invoiceType"))), P = s(() => e.showTaxRate && (a(e.columns) || e.columns.visible("taxRate"))), h = s(() => e.showAmount && (a(e.columns) || e.columns.visible("unitPrice"))), D = s(() => e.showAmountExcludingVAT && e.showUnitPriceE && (a(e.columns) || e.columns.visible("unitPriceExcludingVAT"))), W = s(() => e.showAmount && (a(e.columns) || e.columns.visible("amount"))), O = s(() => e.showAmountExcludingVAT && (a(e.columns) || e.columns.visible("amountExcludingVAT"))), R = s(() => e.showInputVAT && (a(e.columns) || e.columns.visible("inputVAT"))), N = s(() => e.showAmount && (a(e.columns) || e.columns.visible("unitPriceNoFreight"))), I = s(() => e.showAmountExcludingVAT && e.showUnitPriceE && (a(e.columns) || e.columns.visible("unitPriceExcludingVATNoFreight"))), C = s(() => e.showAmount && (a(e.columns) || e.columns.visible("amountNoFreight"))), E = s(() => e.showAmountExcludingVAT && (a(e.columns) || e.columns.visible("amountExcludingVATNoFreight"))), U = s(() => e.showInputVAT && (a(e.columns) || e.columns.visible("inputVATNoFreight")));
  return (w, f) => {
    const c = L("vxe-column");
    return i(), z(Q, null, [b.value ? (i(), l(c, { key: 0, align: "center", field: "invoiceType", "min-width": "70px", title: "票据类型" }, { default: d(({ row: n }) => [g(T(o(a)(n.invoiceType) ? "-" : o(ye).VL[n.invoiceType]), 1)]), _: 1 })) : r("", true), P.value ? (i(), l(c, { key: 1, align: "center", field: "taxRate", "min-width": "70px", title: "税率(%)" })) : r("", true), t.inboundWay !== o(ue).OPENING_RECEIPT.V && N.value ? (i(), l(c, { key: 2, align: "right", field: "unitPriceNoFreight", "min-width": "90px", title: "含税单价" }, { default: d(({ row: n }) => [g(T(o(a)(n.unitPriceNoFreight) ? "-" : o(v)(n.unitPriceNoFreight, t.DPPrecision)), 1)]), _: 1 })) : r("", true), C.value ? (i(), l(c, { key: 3, align: "right", field: "amountNoFreight", "min-width": "105px", title: "含税金额" }, { default: d(({ row: n }) => [g(T(o(a)(n.amountNoFreight) ? "-" : o(v)(n.amountNoFreight, o(x).YUAN)), 1)]), _: 1 })) : r("", true), I.value ? (i(), l(c, { key: 4, align: "right", field: "unitPriceExcludingVATNoFreight", "min-width": "90px", title: "不含税单价" }, { default: d(({ row: n }) => [g(T(o(a)(n.unitPriceExcludingVATNoFreight) ? "-" : o(v)(n.unitPriceExcludingVATNoFreight, t.DPPrecision)), 1)]), _: 1 })) : r("", true), E.value ? (i(), l(c, { key: 5, align: "right", field: "amountExcludingVATNoFreight", "min-width": "105px", title: "不含税金额" }, { default: d(({ row: n }) => [g(T(o(a)(n.amountExcludingVATNoFreight) ? "-" : o(v)(n.amountExcludingVATNoFreight, o(x).YUAN)), 1)]), _: 1 })) : r("", true), t.inboundWay !== o(ue).OPENING_RECEIPT.V && U.value ? (i(), l(c, { key: 6, align: "right", field: "inputVATNoFreight", "min-width": "90px", title: "进项税" }, { default: d(({ row: n }) => [g(T(o(a)(n.inputVATNoFreight) ? "-" : o(v)(n.inputVATNoFreight, o(x).YUAN)), 1)]), _: 1 })) : r("", true), h.value && t.showFreight ? (i(), l(c, { key: 7, align: "right", field: "unitPrice", "min-width": "90px", title: `含税单价
(含运费装车费)` }, { default: d(({ row: n }) => [g(T(o(a)(n.unitPrice) ? "-" : o(v)(n.unitPrice, t.DPPrecision)), 1)]), _: 1 })) : r("", true), W.value && t.showFreight ? (i(), l(c, { key: 8, align: "right", field: "amount", "min-width": "130px", title: `含税金额
(含运费装车费)` }, { default: d(({ row: n }) => [g(T(o(a)(n.amount) ? "-" : o(v)(n.amount, o(x).YUAN)), 1)]), _: 1 })) : r("", true), D.value && t.showFreight ? (i(), l(c, { key: 9, align: "right", field: "unitPriceExcludingVAT", "min-width": "130px", title: `不含税单价
(含运费装车费)` }, { default: d(({ row: n }) => [g(T(o(a)(n.unitPriceExcludingVAT) ? "-" : o(v)(n.unitPriceExcludingVAT, t.DPPrecision)), 1)]), _: 1 })) : r("", true), O.value && t.showFreight ? (i(), l(c, { key: 10, align: "right", field: "amountExcludingVAT", "min-width": "130px", title: `不含税金额
(含运费装车费)` }, { default: d(({ row: n }) => [g(T(o(a)(n.amountExcludingVAT) ? "-" : o(v)(n.amountExcludingVAT, o(x).YUAN)), 1)]), _: 1 })) : r("", true), R.value && t.showFreight ? (i(), l(c, { key: 11, align: "right", field: "inputVAT", "min-width": "120px", title: `进项税
(含运费装车费)` }, { default: d(({ row: n }) => [g(T(o(a)(n.inputVAT) ? "-" : o(v)(n.inputVAT, o(x).YUAN)), 1)]), _: 1 })) : r("", true)], 64);
  };
} }, ze = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true }, showFreight: { type: Boolean, default: true }, inboundWay: { type: [Number, String] }, DPPrecision: { type: [Number, String], default: x.YUAN } }, setup(t) {
  const e = t, b = s(() => {
    switch (e.basicClass) {
      case m.STEEL_PLATE.V:
      case m.SECTION_STEEL.V:
      case m.STEEL_COIL.V:
      case m.MATERIAL.V:
      case m.GAS.V:
        return me;
      default:
        return me;
    }
  });
  return (P, h) => (i(), l(ie(b.value), { columns: t.columns, "inbound-way": t.inboundWay, "show-amount": t.showAmount, "show-amount-excluding-v-a-t": t.showAmountExcludingVAT, "show-freight": t.showFreight, "show-invoice-type": t.showInvoiceType, "show-tax-rate": t.showTaxRate, DPPrecision: t.DPPrecision }, null, 8, ["columns", "inbound-way", "show-amount", "show-amount-excluding-v-a-t", "show-freight", "show-invoice-type", "show-tax-rate", "DPPrecision"]));
} }, Qe = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, he = { __name: "raw-mat", props: { showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showOutboundWorkshop: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: true }, showWarehouse: { type: Boolean, default: true }, columns: { type: Object }, fixed: { type: String }, workshopLabel: { type: String, default: "出库车间" } }, setup(t) {
  const e = t, { workshopNameKV: b } = Se();
  function P(N) {
    var U;
    const I = N.workshop ? N.workshop.id : N.workshopId, C = (U = b.value[I]) == null ? void 0 : U.name, E = N.warehouse ? N.warehouse.name : N.warehouseName;
    return C ? C + "【" + E + "】" : E;
  }
  const h = s(() => e.showWarehouse && (a(e.columns) || e.columns.visible("warehouse"))), D = s(() => e.showProject && (a(e.columns) || e.columns.visible("project"))), W = s(() => e.showMonomer && (a(e.columns) || e.columns.visible("monomerName"))), O = s(() => e.showArea && (a(e.columns) || e.columns.visible("areaName"))), R = s(() => e.showOutboundWorkshop && (a(e.columns) || e.columns.visible("workshop")));
  return (N, I) => {
    const C = L("table-cell-tag"), E = L("vxe-column"), U = Ee;
    return i(), z(Q, null, [D.value ? (i(), l(E, { key: 0, align: "left", field: "project", "min-width": "150px", title: "项目" }, { default: d(({ row: w }) => {
      var f;
      return [t.showTransfer && w.outboundRelationType && w.outboundRelationType !== o(re).ROUTINE.V ? (i(), l(C, { key: 0, name: (f = o(re).VL) == null ? void 0 : f[w.outboundRelationType], offset: 15, type: "transfer" }, null, 8, ["name"])) : r("", true), g(" " + T(o(a)(w.project) ? "-" : o(Be)(w.project)), 1)];
    }), _: 1 })) : r("", true), pe(N.$slots, "projectAfter"), W.value ? (i(), l(E, { key: 1, align: "left", field: "monomerName", "min-width": "100px", title: "单体" })) : r("", true), O.value ? (i(), l(E, { key: 2, align: "left", field: "areaName", "min-width": "100px", title: "区域" })) : r("", true), R.value ? (i(), l(E, { key: 3, align: "left", field: "mesWorkshop.name", "min-width": "120px", title: t.workshopLabel }, { default: d(({ row: w }) => {
      var f;
      return [g(T(((f = w.mesWorkshop) == null ? void 0 : f.name) || "-"), 1)];
    }), _: 1 }, 8, ["title"])) : r("", true), h.value ? (i(), l(E, { key: 4, align: "left", field: "warehouse", "min-width": "120px", title: "仓库" }, { default: d(({ row: w }) => [G("div", Qe, [e.showWorkshop ? (i(), l(Fe, { key: 0, id: w.workshop ? w.workshop.id : w.workshopId }, null, 8, ["id"])) : r("", true), A(U, { class: "item", effect: "dark", content: P(w), placement: "top-start" }, { default: d(() => [G("span", null, T(w.warehouse ? w.warehouse.name : w.warehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 })) : r("", true)], 64);
  };
} }, Ge = { __name: "index", props: { basicClass: { type: Number }, showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: true }, showFactory: { type: Boolean, default: true }, showWarehouse: { type: Boolean, default: true }, columns: { type: Object }, workshopLabel: { type: String, default: "出库车间" } }, setup(t) {
  const e = t, b = s(() => {
    switch (e.basicClass) {
      case m.STEEL_PLATE.V:
      case m.SECTION_STEEL.V:
      case m.STEEL_COIL.V:
      case m.MATERIAL.V:
      case m.GAS.V:
        return he;
      default:
        return he;
    }
  });
  return (P, h) => (i(), l(ie(b.value), fe({ columns: t.columns, "show-area": t.showArea, "show-monomer": t.showMonomer, "show-project": t.showProject, "show-transfer": t.showTransfer, "show-warehouse": t.showWarehouse, "show-workshop": t.showWorkshop }, P.$attrs), { projectAfter: d(() => [pe(P.$slots, "projectAfter")]), _: 3 }, 16, ["columns", "show-area", "show-monomer", "show-project", "show-transfer", "show-warehouse", "show-workshop"]));
} };
const Je = { class: "head-container query-header filter-container" }, Ke = { class: "filter-left-box" }, Xe = { class: "filter-right-box" }, Ze = { __name: "detail", props: { visible: { type: Boolean, default: false }, date: { type: [Number, String], required: true }, formType: { type: [Number, void 0] }, materialInfo: { type: Object }, showAmount: { type: Boolean }, dateTimeList: { type: Array, default: () => [] }, wmsClosingTimeId: { type: [Number, String], default: void 0 } }, emits: ["update:visible"], setup(t, { emit: e }) {
  const { decimalPrecision: b } = Ce(), P = e, h = t, D = F({ resizable: true }), W = F({ isCurrent: true, isHover: true }), O = F({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), R = F([{ showIndex: "合计", quantity: "-", mete: "-", amount: "-", amountExcludingVAT: "-", inputVAT: "-", amountNoFreight: "-" }]);
  s(() => [...Le, ["invoiceType", ["parse-enum", ye, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", b.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", b.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", b.value.wms]], ["unitPriceNoFreight", ["to-thousand", b.value.wms]], ["amount", ["to-thousand", x.YUAN]], ["amountExcludingVAT", ["to-thousand", x.YUAN]], ["amountNoFreight", ["to-thousand", x.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", x.YUAN]], ["inputVAT", ["to-thousand", x.YUAN]], ["inputVATNoFreight", ["to-thousand", x.YUAN]], ["receipt.receiptType", ["parse-enum", X]]]);
  const N = ae("permission"), I = F(false), C = F();
  F();
  const E = F([]), U = F({}), w = F([]), f = F({ formType: Z.BEGIN_PERIOD.V, specification: void 0 }), c = ae("closingTimeConfig"), { baseUnit: n } = we(), { maxHeight: k } = Me({ mainBox: ".raw-mat-send-and-receive-storage-detail", extraBox: [".el-drawer__header", ".material-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, I), { visible: J, handleClose: V } = Oe({ emit: P, props: h, field: "visible", showHook: Ae }), ge = s(() => U.value && U.value.serialNumber ? `收发存详情：${U.value.serialNumber}` : "收发存汇总详情"), Te = s(() => {
    let S = w.value;
    return f.value.specification && (S = w.value.filter((u) => oe(u.specMerge) && u.specMerge.indexOf(f.value.specification) > -1)), f.value.receiptSerialNumber && (S = w.value.filter((u) => oe(u.receipt) && u.receipt.serialNumber.indexOf(f.value.receiptSerialNumber) > -1)), S;
  }), ne = s(() => {
    var S, u, _, B;
    return { id: (S = h.materialInfo) == null ? void 0 : S.id, ids: (u = h.materialInfo) == null ? void 0 : u.ids, statId: (_ = h.materialInfo) == null ? void 0 : _.statId, statIds: (B = h.materialInfo) == null ? void 0 : B.statIds, date: h.date, formType: f.value.formType, dateTimeList: c.value === ce.SELF.V ? h.dateTimeList : [], wmsClosingTimeId: c.value === ce.SELF.V ? h.wmsClosingTimeId : void 0 };
  });
  function be() {
    U.value = {}, w.value = [], E.value.length = 0;
  }
  function xe() {
    f.value.specification = void 0;
  }
  function Ae() {
    h.formType && (f.value.formType = h.formType), ee();
  }
  async function ee() {
    be();
    const S = { ...ne.value };
    try {
      I.value = true;
      const { content: u } = await Re(S);
      u == null || u.forEach((_, B) => {
        _.showIndex = B + 1;
      }), w.value = await ve(u);
    } catch (u) {
      console.error(u);
    } finally {
      I.value = false;
    }
  }
  async function ve(S) {
    var K, y, j;
    const u = [];
    S.forEach((p) => {
      p.serialNumber = p.classifySerialNumber, p.specMerge = _e(p), p.measureUnit = p.measure.measureUnit, p.accountingUnit = p.measure.accountingUnit, p.accountingPrecision = p.measure.accountingPrecision, p.measurePrecision = p.measure.measurePrecision;
      const Ne = je(p, { basicClass: p.basicClass, measureUnit: p.measureUnit, accountingUnit: p.accountingUnit, accountingPrecision: p.accountingPrecision, measurePrecision: p.measurePrecision }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
      u.push(Ne);
    }), await Promise.all(u);
    const _ = (K = h.materialInfo) != null && K.basicClass && n.value && n.value[(y = h.materialInfo) == null ? void 0 : y.basicClass] ? n.value[(j = h.materialInfo) == null ? void 0 : j.basicClass].measure.precision : 0;
    let B = 0, Y = 0, $ = 0, M = 0, q = 0, H = 0;
    return S.forEach((p) => {
      B += Number(p.quantity) || 0, Y += Number(p.mete) || 0, $ += Number(p.amount) || 0, M += Number(p.amountExcludingVAT) || 0, q += Number(p.inputVAT) || 0, H += Number(p.amountNoFreight) || 0;
    }), B = v(B, _), Y = v(Y, 2), $ = v($, x.YUAN), M = v(M, x.YUAN), q = v(q, x.YUAN), H = v(H, x.YUAN), R.value = [{ showIndex: "合计", quantity: B, mete: Y, amount: $, amountExcludingVAT: M, inputVAT: q, amountNoFreight: H }], S;
  }
  return (S, u) => {
    const _ = L("common-radio-button"), B = Ue, Y = L("common-button"), $ = L("table-cell-tag"), M = L("vxe-column"), q = L("vxe-table"), H = L("common-dialog"), K = Ve("permission");
    return i(), l(H, { ref_key: "drawerRef", ref: C, "before-close": o(V), title: ge.value, visible: o(J), "custom-class": "raw-mat-send-and-receive-storage-detail", fullscreen: "", "show-close": "" }, { default: d(() => [G("div", Je, [G("div", Ke, [A(_, { modelValue: f.value.formType, "onUpdate:modelValue": u[0] || (u[0] = (y) => f.value.formType = y), options: o(Z), class: "filter-item", size: "default", type: "enum", onChange: ee }, null, 8, ["modelValue", "options"]), A(B, { modelValue: f.value.specification, "onUpdate:modelValue": u[1] || (u[1] = (y) => f.value.specification = y), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "250px" } }, null, 8, ["modelValue"]), A(B, { modelValue: f.value.receiptSerialNumber, "onUpdate:modelValue": u[2] || (u[2] = (y) => f.value.receiptSerialNumber = y), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "单据编号", size: "default", style: { width: "250px" } }, null, 8, ["modelValue"]), A(Y, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: le(ee, ["stop"]) }, { default: d(() => u[4] || (u[4] = [g(" 搜索 ")])), _: 1, __: [4] }), A(Y, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: u[3] || (u[3] = le((y) => xe(), ["stop"])) }, { default: d(() => u[5] || (u[5] = [g(" 重置 ")])), _: 1, __: [5] })]), G("div", Xe, [Pe((i(), l(De, { fn: o(We), params: ne.value, "response-header-result": "" }, { default: d(() => u[6] || (u[6] = [g(" 下载材料报表（根据查询条件） ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[K, o(N).get]])])]), A(q, { key: "`detail`", "column-config": D.value, data: Te.value, "empty-text": "暂无数据", "max-height": o(k) - 110, "row-config": W.value, "scroll-y": O.value, border: "", class: "myTable-style", "show-overflow": "tooltip", "tooltip-config": { appendTo: "body", theme: "dark", zIndex: 9999 }, stripe: "", "footer-data": R.value, "show-footer": "", "show-footer-overflow": "" }, { default: d(() => [A(M, { align: "center", field: "showIndex", fixed: "left", title: "序号", width: "70" }, { default: d(({ row: y }) => {
      var j;
      return [A($, { name: o(X).SUPPLEMENT.L, show: ((j = y == null ? void 0 : y.receipt) == null ? void 0 : j.receiptType) === o(X).SUPPLEMENT.V, type: "supplement" }, null, 8, ["name", "show"]), G("span", null, T(y.showIndex), 1)];
    }), _: 1 }), A(Ye, { "basic-class": t.materialInfo.basicClass, "show-index": false, "show-outbound-mode": f.value.formType === o(Z).INBOUND.V, fixed: "left", "show-oddment-by-half-out": "", "spec-merge": "" }, null, 8, ["basic-class", "show-outbound-mode"]), A($e, { "basic-class": t.materialInfo.basicClass, columns: {}, "is-vxe": true }, null, 8, ["basic-class"]), A(He, { "basic-class": t.materialInfo.basicClass & o(m).STEEL_COIL.V ? "" : t.materialInfo.basicClass }, null, 8, ["basic-class"]), t.showAmount ? (i(), l(ze, { key: 0, columns: {}, DPPrecision: o(b).wms }, null, 8, ["DPPrecision"])) : r("", true), A(Ge, { "show-project": "" }), f.value.formType === o(Z).OUTBOUND.V ? (i(), l(M, { key: 1, field: "mesWorkshop.name", align: "center", title: "领料车间", "show-overflow-tooltip": "", width: "90" })) : r("", true), A(M, { field: "receipt.receiptType", align: "center", title: "类型", "show-overflow-tooltip": "", width: "70" }, { default: d(({ row: y }) => {
      var j;
      return [g(T(o(oe)(y.receipt) && ((j = y.receipt) != null && j.receiptType) ? o(X).VL[y.receipt.receiptType] : "-"), 1)];
    }), _: 1 }), A(M, { align: "center", field: "receipt", title: "单据编号", "min-width": "120" }, { default: d(({ row: y }) => [A(o(qe), { receipt: y == null ? void 0 : y.receipt, "receipt-types": ["INBOUND", "OUTBOUND", "FOR_SALE", "OUTSOURCE", "SCRAPS", "TEMPORARY_LOAN", "TRANSFER", "RETURN", "REJECTED", "SUPPLEMENT", "CONVERT", "ADJUST", "INVENTORY_LOSS", "INVENTORY_PROFIT", "MOVING_INVENTORY", "MODAL_SHIFT"] }, null, 8, ["receipt"])]), _: 1 })]), _: 1 }, 8, ["column-config", "data", "max-height", "row-config", "scroll-y", "footer-data"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, it = Ie(Ze, [["__scopeId", "data-v-87ad828f"]]);
export {
  it as default
};
