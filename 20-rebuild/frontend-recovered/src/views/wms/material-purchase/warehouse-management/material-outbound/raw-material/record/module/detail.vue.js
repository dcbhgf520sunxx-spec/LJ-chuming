import { ref as k } from "vue";
import { computed as M } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as m } from "vue";
import { createVNode as l } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as u } from "vue";
import { Fragment as P } from "vue";
import { withDirectives as U } from "vue";
import { ElTag as W } from "element-plus";
import { ElPopover as $ } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { _ as I, jX as F, qS as q, gt as z, o as G, cO as K, jP as Y, bR as O, jl as X, p as J, gG as p, oz as Q, aR as Z, k4 as ee, jG as te, k5 as ae, jH as oe, bD as ne, ba as le, jN as v } from "../../../../../../../../shared/runtime.js";
import { _ as ie } from "../../../../../../../../modules/index-4b5f34f4.js";
const se = { key: 0 }, re = { style: { color: "brown" } }, ue = { style: { color: "#3a8ee6" } }, pe = { __name: "detail", setup(ce) {
  const C = k(), S = k([]), V = k([...F, ["outboundAddress", ["parse-enum", q]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: N, crud: h, detail: n } = z(), { maxHeight: j } = G({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => M(() => !h.detailLoading)), A = M(() => n && n.serialNumber ? `出库单：${n.serialNumber}` : "出库单");
  N.HOOK.beforeDetailLoaded = async (D, i) => {
    await K(i.list), i.list.forEach((a) => {
      var f, b, s, w, g, y, T, t;
      a.branchCompany = (f = a.outboundDetailSellDTO) == null ? void 0 : f.branchCompany, a.inputMete = (b = a.outboundDetailSellDTO) == null ? void 0 : b.inputMete, a.invoiceType = (s = a.outboundDetailSellDTO) == null ? void 0 : s.invoiceType, a.sellAmount = (w = a.outboundDetailSellDTO) == null ? void 0 : w.sellAmount, a.sellUnitPrice = (g = a.outboundDetailSellDTO) == null ? void 0 : g.sellUnitPrice, a.taxRate = (y = a.outboundDetailSellDTO) == null ? void 0 : y.taxRate, a.weightMeasurementMode = (T = a.outboundDetailSellDTO) == null ? void 0 : T.weightMeasurementMode, a.purchaser = (t = a.outboundDetailSellDTO) == null ? void 0 : t.purchaser, a.basicClass & Y.STEEL.V && (a.theoryTotalWeight = a.weightMeasurementMode === O.THEORY.V ? a.inputMete : null, a.weighingWeight = a.weightMeasurementMode === O.OVERWEIGHT.V ? a.inputMete : null);
    }), i.list = await X(i.list, { toSmallest: false, toNum: true }, { unitNetCalcMete: "inputMete", mete: ["mete", "inputMete", "theoryTotalWeight", "weighingWeight"], amount: ["unitPrice", "sellUnitPrice"] });
  };
  function L(D) {
    return le(D, { props: ["quantity", ["mete", v.weight.precision], ["theoryTotalWeight", v.weight.precision], ["weighingWeight", v.weight.precision], "sellAmount"] });
  }
  return (D, i) => {
    const a = W, f = E("common-button"), b = $, s = B, w = H, g = E("common-table"), y = E("common-drawer"), T = x("parse-time");
    return c(), _(y, { ref_key: "drawerRef", ref: C, "before-close": e(h).cancelDetail, "content-loading": e(h).detailLoading, "show-close": true, title: A.value, visible: e(h).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: o(() => [e(n).applicant ? (c(), _(a, { key: 0, effect: "dark", type: "success" }, { default: o(() => [d(r(`申请人：${e(n).applicant.name} | ${e(n).applicant.deptName}`), 1)]), _: 1 })) : m("", true), l(a, { effect: "plain" }, { default: o(() => [d(r(`出库申请时间：${e(J)(e(n).createTime)}`), 1)]), _: 1 }), l(a, { effect: "plain", type: "warning" }, { default: o(() => [d("出库类型：" + r(e(p).VL[e(n).outboundTypeSelection]), 1)]), _: 1 }), l(a, { effect: "plain" }, { default: o(() => [d("备注：" + r(e(n).remark || "-"), 1)]), _: 1 })]), titleRight: o(() => {
      var t;
      return [((t = e(n).wmsApproveRecordFlowDTOS) == null ? void 0 : t.length) !== 0 ? (c(), _(b, { key: 0, width: 400, placement: "bottom", trigger: "hover" }, { reference: o(() => [l(f, { size: "default" }, { default: o(() => i[1] || (i[1] = [d("查看审批记录")])), _: 1, __: [1] })]), default: o(() => [l(Q, { data: e(n).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : m("", true)];
    }), content: o(() => [l(g, { data: e(n).list, "data-format": V.value, "expand-row-keys": S.value, "max-height": e(j), "summary-method": L, "row-key": "id", "show-summary": "" }, { default: o(() => [l(Z, { "expand-row-keys": S.value, "onUpdate:expandRowKeys": i[0] || (i[0] = (t) => S.value = t), data: e(n).list, fixed: "left", "row-key": "id" }, { default: o(({ row: t }) => [l(ee, { "basic-class": t.basicClass, row: t, "show-graphics": "", "show-remark": "" }, { default: o(() => [t.boolTransfer ? (c(), R("p", se, [i[2] || (i[2] = d(" 调拨： ")), i[3] || (i[3] = u("span", null, "（来源）", -1)), u("span", re, r(t.sourceProject), 1), i[4] || (i[4] = u("span", null, " ▶ ", -1)), i[5] || (i[5] = u("span", null, "（目的）", -1)), u("span", ue, r(t.project), 1)])) : m("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(te, { "basic-class": e(n).basicClass, fixed: "left", "show-outbound-mode": "" }, { afterMaterialSn: o(() => [l(s, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), l(ae), l(oe), l(ie, { "show-area": false, "show-monomer": false, "show-project": e(n).outboundTypeSelection !== e(p).FOR_SALE.V, showOutboundWorkshop: e(n).outboundTypeSelection === e(p).PRODUCE.V || e(n).outboundTypeSelection === e(p).TEMPORARY_LOAN.V || e(n).outboundTypeSelection === e(p).CONSTRUCTION_SITE_USE.V, workshopLabel: e(n).outboundTypeSelection === e(p).PRODUCE.V || e(n).outboundTypeSelection === e(p).CONSTRUCTION_SITE_USE.V ? "领用车间" : "借用车间", "show-transfer": "", "show-workshop": "" }, null, 8, ["show-project", "showOutboundWorkshop", "workshopLabel"]), e(n).outboundTypeSelection === e(p).FOR_SALE.V ? (c(), R(P, { key: 0 }, [l(s, { align: "center", label: "理论重量", prop: "theoryTotalWeight", width: "100px" }, { default: o(({ row: t }) => [u("span", null, r(t.theoryTotalWeight || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "过磅重量", prop: "weighingWeight", width: "100px" }, { default: o(({ row: t }) => [u("span", null, r(t.weighingWeight || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "计量方式", width: "100px" }, { default: o(({ row: t }) => [u("span", null, r(e(O).VL[t.weightMeasurementMode] || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "出售含税单价", width: "120px" }, { default: o(({ row: t }) => [u("span", null, r(t.sellUnitPrice || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "出售含税金额", prop: "sellAmount", width: "120px" }, { default: o(({ row: t }) => [u("span", null, r(t.sellAmount || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "出售票型及税率", width: "150px" }, { default: o(({ row: t }) => [u("span", null, r(`${e(ne).VL[t.invoiceType]}(${t.taxRate}%)` || "-"), 1)]), _: 1 }), l(s, { key: "purchaser", "show-overflow-tooltip": true, label: "购买方", "min-width": "120", prop: "purchaser" })], 64)) : m("", true), e(n).outboundTypeSelection !== e(p).FOR_SALE.V ? (c(), _(s, { key: "recipient", align: "center", label: "领用人", width: "100px" }, { default: o(({ row: t }) => [t.recipient ? (c(), _(w, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: o(() => [u("span", null, r(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : m("", true)]), _: 1 })) : m("", true), l(s, { key: "outboundTime", align: "center", label: "出库时间", width: "140px" }, { default: o(({ row: t }) => [U(u("span", null, null, 512), [[T, t.outboundTime]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, he = I(pe, [["__scopeId", "data-v-3496f097"]]);
export {
  he as default
};
