import { computed as C } from "vue";
import { ref as p } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as R, _ as B } from "./module/header.vue.js";
import { t as D, jY as P, jX as j, bD as $, D as r, Bu as E, x as q, Bv as U, o as V, cO as H, jl as Y, jG as F, k5 as I, jH as L, k6 as M, vb as O, ux as K, P as G } from "../../../../../shared/runtime.js";
import "../../../../../modules/reset-query-5216307c.js";
const W = { class: "app-container" }, ee = { __name: "index", setup(X) {
  const { decimalPrecision: u } = D();
  P();
  const f = { batchAdd: false, add: false, edit: false, del: false, download: false }, h = C(() => [...j, ["invoiceType", ["parse-enum", $, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", r.YUAN]], ["amountExcludingVAT", ["to-thousand", r.YUAN]], ["inputVAT", ["to-thousand", r.YUAN]], ...E]), _ = p([]), m = p(), { CRUD: w, crud: t, columns: a } = q({ title: "甲供买入", sort: ["reviewTime.desc"], invisibleColumns: ["heatNoAndBatchNo", "project", "warehouse", "invoiceType", "taxRate", "transferSN", "applicantName"], permission: { ...U }, optShow: { ...f }, crudApi: { ...R } }, m), { maxHeight: b } = V({ paginate: true });
  return w.HOOK.handleRefresh = async (v, { data: n }) => {
    await H(n.content), n.content = await Y(n.content, { toSmallest: false, toNum: false });
  }, (v, n) => {
    const l = S, y = N("common-table"), x = A;
    return o(), T("div", W, [s(e(B)), k((o(), i(y, { key: `return_to_party_a_${e(t).query.basicClass}`, ref_key: "tableRef", ref: m, data: e(t).data, "data-format": h.value, "default-expand-all": false, "expand-row-keys": _.value, "max-height": e(b), "row-key": "id", onSortChange: e(t).handleSortChange }, { default: d(() => [s(F, { "basic-class": e(t).query.basicClass, columns: e(a), "show-party-a": false, "classify-name-alias": "名称", "show-classification": "" }, null, 8, ["basic-class", "columns"]), s(I, { "basic-class": e(t).query.basicClass, columns: e(a) }, null, 8, ["basic-class", "columns"]), s(L, { "basic-class": e(t).query.basicClass, columns: e(a) }, null, 8, ["basic-class", "columns"]), s(M, { columns: e(a), "show-project": "" }, null, 8, ["columns"]), s(O, { columns: e(a), "show-invoice-type": "", "show-tax-rate": "", "show-unit-price-e": "" }, null, 8, ["columns"]), e(a).visible("transferSN") ? (o(), i(l, { key: "transferSN", "show-overflow-tooltip": true, align: "center", label: "调拨单号", "min-width": "120", prop: "transferSN" }, { default: d(({ row: g }) => [s(e(K), { receipt: g.transfer, "receipt-types": ["TRANSFER"] }, null, 8, ["receipt"])]), _: 1 })) : c("", true), e(a).visible("applicantName") ? (o(), i(l, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "操作人", prop: "applicantName", width: "90" })) : c("", true), e(a).visible("reviewTime") ? (o(), i(l, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "买入日期", prop: "reviewTime", sortable: "custom", width: "140" })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[x, e(t).loading]]), s(e(G))]);
  };
} };
export {
  ee as default
};
