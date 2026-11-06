import { ref as D } from "vue";
import { inject as L } from "vue";
import { computed as M } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as W } from "vue";
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
import { ElTag as $ } from "element-plus";
import { ElPopover as B } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElTooltip as I } from "element-plus";
import { _ as F, jX as q, qS as z, gt as G, o as K, cO as Y, jP as X, bR as O, jl as J, p as Q, gG as p, oz as Z, aR as ee, k4 as te, jG as ae, k5 as oe, jH as ne, bD as le, ba as ie, jN as v } from "../../../../../../shared/runtime.js";
import { _ as se } from "../../../../../../modules/index-4b5f34f4.js";
const re = { key: 0 }, ue = { style: { color: "brown" } }, pe = { style: { color: "#3a8ee6" } }, ce = { __name: "detail", setup(de) {
  const C = D(), S = D([]);
  L("permission");
  const V = D([...q, ["outboundAddress", ["parse-enum", z]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: N, crud: h, detail: n } = G(), { maxHeight: j } = K({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => M(() => !h.detailLoading)), A = M(() => n && n.serialNumber ? `出库单：${n.serialNumber}` : "出库单");
  N.HOOK.beforeDetailLoaded = async (k, i) => {
    await Y(i.list), i.list.forEach((a) => {
      var f, b, s, w, g, y, T;
      a.branchCompany = (f = a.outboundDetailSellDTO) == null ? void 0 : f.branchCompany, a.inputMete = (b = a.outboundDetailSellDTO) == null ? void 0 : b.inputMete, a.invoiceType = (s = a.outboundDetailSellDTO) == null ? void 0 : s.invoiceType, a.sellAmount = (w = a.outboundDetailSellDTO) == null ? void 0 : w.sellAmount, a.sellUnitPrice = (g = a.outboundDetailSellDTO) == null ? void 0 : g.sellUnitPrice, a.taxRate = (y = a.outboundDetailSellDTO) == null ? void 0 : y.taxRate, a.weightMeasurementMode = (T = a.outboundDetailSellDTO) == null ? void 0 : T.weightMeasurementMode, a.basicClass & X.STEEL.V && (a.theoryTotalWeight = a.weightMeasurementMode === O.THEORY.V ? a.inputMete : null, a.weighingWeight = a.weightMeasurementMode === O.OVERWEIGHT.V ? a.inputMete : null);
    }), i.list = await J(i.list, { toSmallest: false, toNum: true }, { unitNetCalcMete: "inputMete", mete: ["actualTheoryWeight", "mete", "inputMete", "theoryTotalWeight", "weighingWeight"], amount: ["unitPrice", "sellUnitPrice"] });
  };
  function x(k) {
    return ie(k, { props: ["quantity", ["mete", v.weight.precision], ["theoryTotalWeight", v.weight.precision], ["weighingWeight", v.weight.precision], "sellAmount"] });
  }
  return (k, i) => {
    const a = $, f = E("common-button"), b = B, s = H, w = I, g = E("common-table"), y = E("common-drawer"), T = W("parse-time");
    return c(), _(y, { ref_key: "drawerRef", ref: C, "before-close": e(h).cancelDetail, "content-loading": e(h).detailLoading, "show-close": true, title: A.value, visible: e(h).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: o(() => [e(n).applicant ? (c(), _(a, { key: 0, effect: "dark", type: "success" }, { default: o(() => [d(r(`申请人：${e(n).applicant.name} | ${e(n).applicant.deptName}`), 1)]), _: 1 })) : m("", true), l(a, { effect: "plain" }, { default: o(() => [d(r(`出库申请时间：${e(Q)(e(n).createTime)}`), 1)]), _: 1 }), l(a, { effect: "plain", type: "warning" }, { default: o(() => [d("出库类型：" + r(e(p).VL[e(n).outboundTypeSelection]), 1)]), _: 1 }), l(a, { effect: "plain" }, { default: o(() => [d("备注：" + r(e(n).remark || "-"), 1)]), _: 1 })]), titleRight: o(() => {
      var t;
      return [((t = e(n).wmsApproveRecordFlowDTOS) == null ? void 0 : t.length) !== 0 ? (c(), _(b, { key: 0, width: 400, placement: "bottom", trigger: "hover" }, { reference: o(() => [l(f, { size: "default" }, { default: o(() => i[1] || (i[1] = [d("查看审批记录")])), _: 1, __: [1] })]), default: o(() => [l(Z, { data: e(n).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : m("", true)];
    }), content: o(() => [l(g, { data: e(n).list, "data-format": V.value, "expand-row-keys": S.value, "max-height": e(j), "summary-method": x, "row-key": "id", "show-summary": "" }, { default: o(() => [l(ee, { "expand-row-keys": S.value, "onUpdate:expandRowKeys": i[0] || (i[0] = (t) => S.value = t), data: e(n).list, fixed: "left", "row-key": "id" }, { default: o(({ row: t }) => [l(te, { "basic-class": t.basicClass, row: t, "show-graphics": "", "show-remark": "" }, { default: o(() => [t.boolTransfer ? (c(), R("p", re, [i[2] || (i[2] = d(" 调拨： ")), i[3] || (i[3] = u("span", null, "（来源）", -1)), u("span", ue, r(t.sourceProject), 1), i[4] || (i[4] = u("span", null, " ▶ ", -1)), i[5] || (i[5] = u("span", null, "（目的）", -1)), u("span", pe, r(t.project), 1)])) : m("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), l(ae, { "basic-class": e(n).basicClass, "show-outbound-mode": "" }, { afterMaterialSn: o(() => [l(s, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), l(oe), l(ne), l(s, { "show-overflow-tooltip": true, align: "center", label: "理论重量", prop: "actualTheoryWeight", "min-width": "100px" }), l(se, { "show-area": false, "show-monomer": false, "show-project": e(n).outboundTypeSelection !== e(p).FOR_SALE.V, showOutboundWorkshop: e(n).outboundTypeSelection === e(p).PRODUCE.V || e(n).outboundTypeSelection === e(p).TEMPORARY_LOAN.V || e(n).outboundTypeSelection === e(p).CONSTRUCTION_SITE_USE.V, workshopLabel: e(n).outboundTypeSelection === e(p).PRODUCE.V || e(n).outboundTypeSelection === e(p).CONSTRUCTION_SITE_USE.V ? "领用车间" : "借用车间", "show-transfer": "", "show-workshop": "", showAreaBatchName: "" }, null, 8, ["show-project", "showOutboundWorkshop", "workshopLabel"]), e(n).outboundTypeSelection === e(p).FOR_SALE.V ? (c(), R(P, { key: 0 }, [l(s, { align: "center", label: "理论重量", prop: "theoryTotalWeight", width: "100px" }, { default: o(({ row: t }) => [u("span", null, r(t.theoryTotalWeight || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "过磅重量", prop: "weighingWeight", width: "100px" }, { default: o(({ row: t }) => [u("span", null, r(t.weighingWeight || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "计量方式", width: "100px" }, { default: o(({ row: t }) => [u("span", null, r(e(O).VL[t.weightMeasurementMode] || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "出售含税单价", width: "120px" }, { default: o(({ row: t }) => [u("span", null, r(t.sellUnitPrice || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "出售含税金额", prop: "sellAmount", width: "120px" }, { default: o(({ row: t }) => [u("span", null, r(t.sellAmount || "-"), 1)]), _: 1 }), l(s, { align: "center", label: "出售票型及税率", width: "150px" }, { default: o(({ row: t }) => [u("span", null, r(`${e(le).VL[t.invoiceType]}(${t.taxRate}%)` || "-"), 1)]), _: 1 })], 64)) : m("", true), e(n).outboundTypeSelection !== e(p).FOR_SALE.V ? (c(), _(s, { key: "recipient", align: "center", label: "领用人", width: "100px" }, { default: o(({ row: t }) => [t.recipient ? (c(), _(w, { key: 0, content: `${t.recipient.deptName}`, effect: "light", placement: "top" }, { default: o(() => [u("span", null, r(t.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : m("", true)]), _: 1 })) : m("", true), l(s, { key: "outboundTime", align: "center", label: "出库时间", width: "140px" }, { default: o(({ row: t }) => [U(u("span", null, null, 512), [[T, t.outboundTime]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, fe = F(ce, [["__scopeId", "data-v-494fa17d"]]);
export {
  fe as default
};
