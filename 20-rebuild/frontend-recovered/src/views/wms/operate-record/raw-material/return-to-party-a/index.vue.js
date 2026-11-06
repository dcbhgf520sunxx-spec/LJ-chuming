import { computed as C } from "vue";
import { ref as p } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as l } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as R, _ as B } from "./module/header.vue.js";
import { t as D, jX as P, bD as E, D as r, Bu as $, x as j, Bw as q, o as U, cO as V, jl as H, jG as F, k5 as L, jH as M, k6 as O, ux as Y, P as I } from "../../../../../shared/runtime.js";
import "../../../../../modules/reset-query-5216307c.js";
const K = { class: "app-container" }, W = { __name: "index", setup(G) {
  const { decimalPrecision: u } = D(), f = { batchAdd: false, add: false, edit: false, del: false, download: false }, _ = C(() => [...P, ["invoiceType", ["parse-enum", E, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", r.YUAN]], ["amountExcludingVAT", ["to-thousand", r.YUAN]], ["inputVAT", ["to-thousand", r.YUAN]], ...$]), h = p([]), m = p(), { CRUD: w, crud: e, columns: s } = j({ title: "归还甲方", sort: ["reviewTime.desc"], invisibleColumns: ["heatNoAndBatchNo", "warehouse", "transferSN", "applicantName"], permission: { ...q }, optShow: { ...f }, crudApi: { ...R } }, m), { maxHeight: b } = U({ paginate: true });
  return w.HOOK.handleRefresh = async (v, { data: n }) => {
    await V(n.content), n.content = await H(n.content, { toSmallest: false, toNum: false });
  }, (v, n) => {
    const i = S, y = N("common-table"), g = A;
    return o(), T("div", K, [t(a(B)), k((o(), l(y, { key: `return_to_party_a_${a(e).query.basicClass}`, ref_key: "tableRef", ref: m, data: a(e).data, "data-format": _.value, "default-expand-all": false, "expand-row-keys": h.value, "max-height": a(b), "row-key": "id", onSortChange: a(e).handleSortChange }, { default: d(() => [t(F, { "basic-class": a(e).query.basicClass, columns: a(s), "show-party-a": false, "classify-name-alias": "名称", "show-classification": "" }, null, 8, ["basic-class", "columns"]), t(L, { "basic-class": a(e).query.basicClass, columns: a(s) }, null, 8, ["basic-class", "columns"]), t(M, { "basic-class": a(e).query.basicClass, columns: a(s) }, null, 8, ["basic-class", "columns"]), t(O, { columns: a(s), "show-project": "" }, null, 8, ["columns"]), a(s).visible("transferSN") ? (o(), l(i, { key: "transferSN", "show-overflow-tooltip": true, align: "center", label: "调拨单号", "min-width": "120", prop: "transferSN" }, { default: d(({ row: x }) => [t(a(Y), { receipt: x.transfer, "receipt-types": ["TRANSFER"] }, null, 8, ["receipt"])]), _: 1 })) : c("", true), a(s).visible("applicantName") ? (o(), l(i, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "操作人", prop: "applicantName", width: "90" })) : c("", true), a(s).visible("reviewTime") ? (o(), l(i, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "归还日期", prop: "reviewTime", sortable: "custom", width: "140" })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[g, a(e).loading]]), t(a(I))]);
  };
} };
export {
  W as default
};
