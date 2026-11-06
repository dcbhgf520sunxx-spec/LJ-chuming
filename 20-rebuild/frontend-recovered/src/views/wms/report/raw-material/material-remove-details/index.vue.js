import { ref as g } from "vue";
import { computed as w } from "vue";
import { watch as F } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as n } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementVNode as x } from "vue";
import { createTextVNode as T } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as $ } from "element-plus";
import { g as q, a as M, _ as O } from "./module/header.vue.js";
import { _ as H, t as L, jX as G, bD as K, D as l, zd as z, x as Q, C4 as A, o as X, G as J, sQ as W, cO as Z, jl as ee, i as b, j_ as te, x_ as ae, aR as ie, k4 as se, jG as re, k5 as oe, jH as ne, zE as ce, ux as le, P as ue, ba as pe } from "../../../../../shared/runtime.js";
import j from "../../../material-transfer/raw-material/review/module/source-text-info.vue.js";
import k from "../../../material-transfer/raw-material/review/module/direction-text-info.vue.js";
import "../../../../../modules/reset-query-5216307c.js";
const me = { class: "report-material-transfer-details app-container" }, de = { __name: "index", setup(fe) {
  const { decimalPrecision: d } = L(), C = { add: false, edit: false, del: false, download: false }, h = g([]), y = g(), E = w(() => [...G, ["invoiceType", ["parse-enum", K, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", d.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", d.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", d.value.wms]], ["unitPriceNoFreight", ["to-thousand", d.value.wms]], ["amount", ["to-thousand", l.YUAN]], ["amountExcludingVAT", ["to-thousand", l.YUAN]], ["amountNoFreight", ["to-thousand", l.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", l.YUAN]], ["inputVAT", ["to-thousand", l.YUAN]], ["inputVATNoFreight", ["to-thousand", l.YUAN]], ["receipt.transferType", ["parse-enum", z]], ["receipt.transferTime", "parse-time"], ["receipt.reviewTime", "parse-time"], ["receipt.createTime", "parse-time"], ["receipt.borrowProject", ["parse-project", { onlyShortName: true }]], ["receipt.[source].project", ["parse-project", { onlyShortName: true }]], ["receipt.direction.project", ["parse-project", { onlyShortName: true }]]]), { CRUD: P, crud: u, columns: s } = Q({ title: "移库明细", sort: ["id.desc"], invisibleColumns: ["receipt.applicantName", "receipt.reviewerName", "receipt.createTime", "receipt.reviewTime", "invoiceType", "taxRate", "unitPrice", "unitPriceExcludingVAT", "amount", "amountExcludingVAT", "inputVAT"], permission: { ...A }, optShow: { ...C }, crudApi: { get: q } }, y), { maxHeight: V } = X({ paginate: true }), D = w(() => J(A.showAmount)), p = w(() => u.query ? u.query.basicClass : void 0), { baseUnit: N } = W(p.value), v = g();
  P.HOOK.handleRefresh = async (_, { data: a }) => {
    await Z(a.content), a.content = await ee(a.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), a.content.forEach((e) => {
      e.receipt || (e.receipt = {}), e.projects = [], b(e.receipt) && (Array.isArray(e.receipt.source) ? e.receipt.source.forEach((f) => {
        f.project && e.projects.push(f.project);
      }) : typeof e.receipt.source == "object" && (e.receipt.source.project && e.projects.push(e.receipt.source.project), e.receipt.source = [e.receipt.source]), b(e.receipt.borrowProject) && e.projects.push(e.receipt.borrowProject), e.receipt.direction && b(e.receipt.direction.project) && e.projects.push(e.receipt.direction.project));
    }), console.log(a.content, "data.content1111");
  }, F(() => u.query, async () => {
    v.value = await M(u.query), p.value & te.STEEL.V && await ae(v.value, { unit: N.value[p.value].weight.unit, precision: N.value[p.value].weight.precision, fields: ["meteCount"], toSmallest: false, toNum: true });
  }, { deep: true, immutable: true });
  function S(_) {
    return pe(_, { props: ["quantity", "mete", ["amount", l.YUAN], ["amountExcludingVAT", l.YUAN], ["amountNoFreight", l.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (_, a) => {
    const e = Y, f = I("common-table"), U = $;
    return r(), R("div", me, [o(t(O), { DetailsCount: v.value }, null, 8, ["DetailsCount"]), B((r(), n(f, { ref_key: "tableRef", ref: y, data: t(u).data, "data-format": E.value, "default-expand-all": false, "expand-row-keys": h.value, "max-height": t(V), "summary-method": S, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: t(u).handleSortChange }, { default: m(() => [o(ie, { "expand-row-keys": h.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (i) => h.value = i), data: t(u).data, "row-key": "id" }, { default: m(({ row: i }) => [p.value ? c("", true) : (r(), n(se, { key: 0, "basic-class": i.basicClass, row: i }, null, 8, ["basic-class", "row"])), x("p", null, [a[1] || (a[1] = T("来源： ")), o(j, { "transfer-receipt": i.receipt, class: "wth-auto" }, null, 8, ["transfer-receipt"])]), x("p", null, [a[2] || (a[2] = T("目的： ")), o(k, { "transfer-receipt": i.receipt, class: "wth-auto" }, null, 8, ["transfer-receipt"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), o(re, { "basic-class": p.value, columns: t(s), "classify-name-alias": "名称", "show-classification": "", sortable: "", "spec-merge": "" }, { afterIndex: m(() => [t(s).visible("sourceInfo") ? (r(), n(e, { key: "sourceInfo", label: "来源", "min-width": "170", prop: "sourceInfo", "show-overflow-tooltip": "" }, { default: m(({ row: i }) => [o(j, { "transfer-receipt": i.receipt, class: "ellipsis-text" }, null, 8, ["transfer-receipt"])]), _: 1 })) : c("", true), t(s).visible("directionInfo") ? (r(), n(e, { key: "directionInfo", label: "目的", "min-width": "170", prop: "directionInfo", "show-overflow-tooltip": "" }, { default: m(({ row: i }) => [o(k, { "transfer-receipt": i.receipt, class: "ellipsis-text" }, null, 8, ["transfer-receipt"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["basic-class", "columns"]), o(oe, { "basic-class": p.value, columns: t(s) }, null, 8, ["basic-class", "columns"]), o(ne, { "basic-class": p.value, columns: t(s) }, null, 8, ["basic-class", "columns"]), D.value ? (r(), n(ce, { key: 0, columns: t(s), "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns"])) : c("", true), t(s).visible("receipt.serialNumber") ? (r(), n(e, { key: "receipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "移库单号", "min-width": "155", prop: "receipt.serialNumber" }, { default: m(({ row: i }) => [o(t(le), { receipt: i.receipt, "receipt-types": ["MOVING_INVENTORY"] }, null, 8, ["receipt"])]), _: 1 })) : c("", true), t(s).visible("receipt.applicantName") ? (r(), n(e, { key: "receipt.applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "receipt.applicantName" })) : c("", true), t(s).visible("receipt.reviewerName") ? (r(), n(e, { key: "receipt.reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "receipt.reviewerName" })) : c("", true), t(s).visible("receipt.createTime") ? (r(), n(e, { key: "receipt.createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "receipt.createTime", width: "125" })) : c("", true), t(s).visible("receipt.reviewTime") ? (r(), n(e, { key: "receipt.reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "receipt.reviewTime", width: "125" })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[U, t(u).loading]]), o(t(ue))]);
  };
} }, ye = H(de, [["__scopeId", "data-v-0afe78a3"]]);
export {
  ye as default
};
