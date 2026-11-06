import { ref as _ } from "vue";
import { computed as v } from "vue";
import { watch as j } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as Y } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as $ } from "vue";
import { unref as e } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as n } from "vue";
import { createElementVNode as T } from "vue";
import { toDisplayString as x } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { g as q, a as I, _ as O } from "./module/header.vue.js";
import { _ as H, t as K, jX as G, bD as z, D as l, x as Q, C5 as k, o as X, G as J, sQ as W, cO as Z, jl as ee, j_ as te, x_ as ae, aR as ie, k4 as re, jG as ne, yB as oe, bl as C, k5 as se, jH as le, zE as ue, k6 as ce, ux as E, P as me, ba as pe, jN as de } from "../../../../../shared/runtime.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/reset-query-5216307c.js";
import "../../../../../modules/closing-time-date-query-82715fa2.js";
const we = { class: "report-material-outbound-details app-container" }, he = { __name: "index", setup(fe) {
  const { decimalPrecision: w } = K(), A = { add: false, edit: false, del: false, download: false }, h = _([]), g = _(), S = v(() => [...G, ["invoiceType", ["parse-enum", z, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", w.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", w.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", w.value.wms]], ["unitPriceNoFreight", ["to-thousand", w.value.wms]], ["amount", ["to-thousand", l.YUAN]], ["amountExcludingVAT", ["to-thousand", l.YUAN]], ["amountNoFreight", ["to-thousand", l.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", l.YUAN]], ["inputVAT", ["to-thousand", l.YUAN]], ["inputVATNoFreight", ["to-thousand", l.YUAN]], ["realTime", "parse-time"], ["returnReceipt.returnTime", "parse-time"], ["returnReceipt.reviewTime", "parse-time"], ["returnReceipt.createTime", "parse-time"]]), { CRUD: U, crud: u, columns: t } = Q({ title: "退库明细", sort: ["id.desc"], invisibleColumns: ["returnReceipt.applicantName", "returnReceipt.reviewerName", "returnReceipt.createTime", "returnReceipt.reviewTime", "invoiceType", "taxRate", "inputVAT", "recipient", "departmentName", "returnReceipt.returnTime"], permission: { ...k }, optShow: { ...A }, crudApi: { get: q } }, g), { maxHeight: D } = X({ paginate: true }), P = v(() => J(k.showAmount)), c = v(() => u.query ? u.query.basicClass : void 0), { baseUnit: N } = W(c.value), f = _();
  U.HOOK.handleRefresh = async (b, { data: m }) => {
    await Z(m.content), m.content = await ee(m.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), m.content.forEach((d) => {
      d.outboundReceipt || (d.outboundReceipt = {}), d.returnReceipt || (d.returnReceipt = {});
    }), console.log(m, "data");
  }, j(() => u.query, async () => {
    f.value = await I(u.query), c.value & te.STEEL.V && await ae(f.value, { unit: N.value[c.value].weight.unit, precision: N.value[c.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function V(b) {
    return pe(b, { props: ["quantity", ["mete", de.weight.precision], ["amount", l.YUAN], ["amountExcludingVAT", l.YUAN], ["amountNoFreight", l.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (b, m) => {
    const d = y("table-cell-tag"), o = L, F = y("common-table"), B = M;
    return a(), Y("div", we, [s(O, { DetailsCount: f.value }, null, 8, ["DetailsCount"]), $((a(), r(F, { ref_key: "tableRef", ref: g, data: e(u).data, "data-format": S.value, "default-expand-all": false, "expand-row-keys": h.value, "max-height": e(D), "summary-method": V, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: e(u).handleSortChange }, { default: p(() => [s(ie, { "expand-row-keys": h.value, "onUpdate:expandRowKeys": m[0] || (m[0] = (i) => h.value = i), data: e(u).data, "row-key": "id" }, { default: p(({ row: i }) => [c.value ? n("", true) : (a(), r(re, { key: 0, "basic-class": i.basicClass, row: i, showRemark: "" }, null, 8, ["basic-class", "row"]))]), _: 1 }, 8, ["expand-row-keys", "data"]), s(ne, { "basic-class": c.value, columns: e(t), "classify-name-alias": "名称", "show-classification": "", sortable: "", "spec-merge": "" }, { afterIndex: p(() => [s(oe, { columns: e(t), label: "实际退库时间" }, null, 8, ["columns"]), e(t).visible("returnReceipt.returnTime") ? (a(), r(o, { key: "returnReceipt.returnTime", "show-overflow-tooltip": true, prop: "returnReceipt.returnTime", label: "系统退库时间", align: "center", sortable: "custom", width: "125" }, { default: p(({ row: i }) => [i.basicClass === e(C).STEEL_PLATE.V || i.basicClass === e(C).SECTION_STEEL.V ? (a(), r(d, { key: 0, color: "#f23c3c", offset: 15, show: i.boolReturns, name: "退余料" }, null, 8, ["show"])) : n("", true), T("span", null, x(i.returnReceipt.returnTime), 1)]), _: 1 })) : n("", true)]), afterMaterialSn: p(() => [e(t).visible("materialSnNew") ? (a(), r(o, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })) : n("", true)]), _: 1 }, 8, ["basic-class", "columns"]), s(se, { "basic-class": c.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), s(le, { "basic-class": c.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), P.value ? (a(), r(ue, { key: 0, columns: e(t), "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns"])) : n("", true), e(t).visible("project.serialNumber") ? (a(), r(o, { key: "project.serialNumber", "show-overflow-tooltip": false, align: "center", label: "项目编号", "min-width": "150px", prop: "project.serialNumber" }, { default: p(({ row: { sourceRow: i } }) => {
      var R;
      return [T("span", null, x(((R = i.project) == null ? void 0 : R.serialNumber) || "-"), 1)];
    }), _: 1 })) : n("", true), s(ce, { columns: e(t), "show-project": "" }, null, 8, ["columns"]), e(t).visible("returnReceipt.serialNumber") ? (a(), r(o, { key: "returnReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "退库单号", "min-width": "155", prop: "returnReceipt.serialNumber" }, { default: p(({ row: i }) => [s(e(E), { receipt: i.returnReceipt, "receipt-types": ["RETURN"] }, null, 8, ["receipt"])]), _: 1 })) : n("", true), e(t).visible("outboundReceipt.serialNumber") ? (a(), r(o, { key: "outboundReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "出库单号", "min-width": "155", prop: "outboundReceipt.serialNumber" }, { default: p(({ row: i }) => [s(e(E), { receipt: i.outboundReceipt, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : n("", true), e(t).visible("returnReceipt.applicantName") ? (a(), r(o, { key: "returnReceipt.applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "returnReceipt.applicantName" })) : n("", true), e(t).visible("returnReceipt.reviewerName") ? (a(), r(o, { key: "returnReceipt.reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "returnReceipt.reviewerName" })) : n("", true), e(t).visible("returnReceipt.createTime") ? (a(), r(o, { key: "returnReceipt.createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "returnReceipt.createTime", width: "125" })) : n("", true), e(t).visible("returnReceipt.reviewTime") ? (a(), r(o, { key: "returnReceipt.reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "returnReceipt.reviewTime", width: "125" })) : n("", true), e(t).visible("departmentName") ? (a(), r(o, { key: "departmentName", "show-overflow-tooltip": true, align: "center", label: "退库部门", "min-width": "100", prop: "departmentName" })) : n("", true), e(t).visible("recipient") ? (a(), r(o, { key: "recipient", "show-overflow-tooltip": true, align: "center", label: "退库人", "min-width": "100", prop: "recipient" })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[B, e(u).loading]]), s(e(me))]);
  };
} }, ye = H(he, [["__scopeId", "data-v-0d36c237"]]);
export {
  ye as default
};
