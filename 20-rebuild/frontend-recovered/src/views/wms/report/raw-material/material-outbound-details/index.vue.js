import { ref as _ } from "vue";
import { computed as w } from "vue";
import { watch as M } from "vue";
import { resolveComponent as Y } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as q } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as n } from "vue";
import { createElementVNode as k } from "vue";
import { toDisplayString as O } from "vue";
import { ElTableColumn as I } from "element-plus";
import { vLoading as W } from "element-plus";
import { g as H, a as z } from "../../../../../modules/outbound-13fff63c.js";
import { _ as K, t as G, jX as X, bD as Q, D as d, jY as J, x as Z, C0 as C, o as ee, G as te, sQ as oe, cO as A, jl as E, j_ as ae, x_ as ie, aR as ne, k4 as se, jG as ue, k5 as re, jH as le, zE as ce, k6 as me, ux as pe, P as de, ba as be, jN as we } from "../../../../../shared/runtime.js";
import he from "./module/header.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/reset-query-5216307c.js";
const fe = { class: "report-material-outbound-details app-container" }, ve = { __name: "index", setup(ge) {
  const { decimalPrecision: h } = G(), S = { add: false, edit: false, del: false, download: false }, f = _([]), y = _(), P = w(() => [...X, ["invoiceType", ["parse-enum", Q, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", h.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", h.value.wms]], ["unitPriceNoFreight", ["to-thousand", h.value.wms]], ["amount", ["to-thousand", d.YUAN]], ["amountExcludingVAT", ["to-thousand", d.YUAN]], ["amountNoFreight", ["to-thousand", d.YUAN]], ["inputVAT", ["to-thousand", d.YUAN]], ["wod.outboundTime", "parse-time"], ["outboundTime", "parse-time"], ["outboundReceipt.outboundTime", "parse-time"], ["outboundReceipt.reviewTime", "parse-time"], ["outboundReceipt.createTime", "parse-time"]]), { reportCfg: N } = J(), { CRUD: D, crud: r, columns: t } = Z({ title: "出库明细", sort: ["id.desc"], invisibleColumns: ["outboundReceipt.applicantName", "outboundReceipt.reviewerName", "outboundReceipt.createTime", "outboundReceipt.reviewTime1", "recipientName", "invoiceType", "taxRate"], permission: { ...C }, optShow: { ...S }, crudApi: { get: H } }, y), { maxHeight: U } = ee({ paginate: true }), j = w(() => !!N.value.amountShow), V = w(() => !!N.value.amountExcludingTAXShow), B = w(() => te(C.showAmount)), l = w(() => r.query ? r.query.basicClass : void 0), { baseUnit: T } = oe(l.value), v = _();
  D.HOOK.handleRefresh = async (g, { data: c }) => {
    await A(c.content), c.content = await E(c.content, { toSmallest: false, toNum: false }, { mete: ["actualTheoryWeight", "mete", "frozenMete"], amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), c.content.forEach((u) => {
      var b;
      u.outboundReceipt || (u.outboundReceipt = {}), u.outboundTime = (b = u.outboundReceipt) == null ? void 0 : b.outboundTime;
    });
    const o = [];
    c.content.forEach((u) => {
      Array.isArray(u.rejectList) && u.rejectList.forEach((b) => {
        o.push(b.material);
      });
    }), await A(o), await E(o, { toSmallest: false, toNum: false }, { mete: ["actualTheoryWeight", "mete", "frozenMete"], amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  }, M(() => r.query, async () => {
    v.value = await z(r.query), l.value & ae.STEEL.V && await ie(v.value, { unit: T.value[l.value].weight.unit, precision: T.value[l.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function F(g) {
    return be(g, { props: ["quantity", ["mete", we.weight.precision], ["amount", d.YUAN], ["amountExcludingVAT", d.YUAN], ["amountNoFreight", d.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (g, c) => {
    const o = I, u = Y("common-table"), b = $("parse-time"), L = W;
    return a(), q("div", fe, [m(e(he), { DetailsCount: v.value }, null, 8, ["DetailsCount"]), x((a(), i(u, { ref_key: "tableRef", ref: y, data: e(r).data, "data-format": P.value, "default-expand-all": false, "expand-row-keys": f.value, "max-height": e(U), "summary-method": F, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: e(r).handleSortChange }, { default: p(() => [m(ne, { "expand-row-keys": f.value, "onUpdate:expandRowKeys": c[0] || (c[0] = (s) => f.value = s), data: e(r).data, "row-key": "id" }, { default: p(({ row: s }) => [l.value ? n("", true) : (a(), i(se, { key: 0, "basic-class": s.basicClass, row: s }, null, 8, ["basic-class", "row"]))]), _: 1 }, 8, ["expand-row-keys", "data"]), m(ue, { "basic-class": l.value, columns: e(t), "classify-name-alias": "名称", "show-classification": "", "show-outbound-mode": "", "spec-merge": "" }, { afterIndex: p(() => [e(t).visible("outboundTime") ? (a(), i(o, { key: "outboundTime", "show-overflow-tooltip": true, prop: "outboundReceipt.outboundTime", label: "实际出库时间", align: "center", sortable: "custom", width: "125" }, { default: p(({ row: s }) => [x(k("span", null, null, 512), [[b, s.outboundReceipt.outboundTime]])]), _: 1 })) : n("", true), e(t).visible("outboundReceipt.reviewTime1") ? (a(), i(o, { key: "outboundReceipt.reviewTime1", "show-overflow-tooltip": true, prop: "outboundReceipt.reviewTime", label: "系统出库时间", align: "center", width: "125" })) : n("", true), e(t).visible("outboundReceipt.reviewTime") ? (a(), i(o, { key: "outboundReceipt.reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "outboundReceipt.reviewTime", width: "125" })) : n("", true)]), afterMaterialSn: p(() => [e(t).visible("materialSnNew") ? (a(), i(o, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })) : n("", true)]), _: 1 }, 8, ["basic-class", "columns"]), m(re, { "basic-class": l.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), m(le, { "basic-class": l.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), e(t).visible("actualTheoryWeight") ? (a(), i(o, { key: 0, "show-overflow-tooltip": true, align: "center", label: "理论重量", prop: "actualTheoryWeight", "min-width": "100px" })) : n("", true), B.value ? (a(), i(ce, { key: 1, columns: e(t), "show-amount": j.value, "show-amount-excluding-v-a-t": V.value, "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns", "show-amount", "show-amount-excluding-v-a-t"])) : n("", true), e(t).visible("project.serialNumber") ? (a(), i(o, { key: "project.serialNumber", "show-overflow-tooltip": false, align: "center", label: "项目编号", "min-width": "150px", prop: "project.serialNumber" }, { default: p(({ row: { sourceRow: s } }) => {
      var R;
      return [k("span", null, O(((R = s.project) == null ? void 0 : R.serialNumber) || "-"), 1)];
    }), _: 1 })) : n("", true), m(me, { columns: e(t), "show-area": false, "show-monomer": false, "show-project": "", "show-workshop": "", showAreaBatchName: "" }, null, 8, ["columns"]), e(t).visible("outboundReceipt.serialNumber") ? (a(), i(o, { key: "outboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "出库单号", "min-width": "155", prop: "outboundReceipt.serialNumber" }, { default: p(({ row: s }) => [m(e(pe), { receipt: s.outboundReceipt, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : n("", true), e(t).visible("outboundReceipt.applicantName") ? (a(), i(o, { key: "outboundReceipt.applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "outboundReceipt.applicantName" })) : n("", true), e(t).visible("recipientName") ? (a(), i(o, { key: "recipientName", "show-overflow-tooltip": true, align: "center", label: "领料人", "min-width": "100", prop: "recipientName" })) : n("", true), e(t).visible("outboundReceipt.reviewerName") ? (a(), i(o, { key: "outboundReceipt.reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "outboundReceipt.reviewerName" })) : n("", true), e(t).visible("outboundReceipt.createTime") ? (a(), i(o, { key: "outboundReceipt.createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "outboundReceipt.createTime", width: "125" })) : n("", true), e(t).visible("remark") ? (a(), i(o, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "150px", prop: "remark" })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[L, e(r).loading]]), m(e(de))]);
  };
} }, ke = K(ve, [["__scopeId", "data-v-157d3555"]]);
export {
  ke as default
};
