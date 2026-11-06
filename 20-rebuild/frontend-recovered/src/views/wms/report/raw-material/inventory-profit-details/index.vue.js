import { ref as x } from "vue";
import { computed as m } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as N } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as I, _ as $ } from "./module/header.vue.js";
import { _ as O, t as q, jX as H, bD as M, D as r, jY as K, x as L, BS as y, o as G, G as X, cO as W, jl as z, aR as J, jG as Q, ux as Z, k5 as ee, jH as ae, vb as te, k6 as oe, P as se, ba as ne } from "../../../../../shared/runtime.js";
const ie = { class: "report-material-outbound-details app-container" }, le = { class: "mtb-10", style: { "margin-left": "30px" } }, re = { __name: "index", setup(ue) {
  const { decimalPrecision: d } = q(), A = { add: false, edit: false, del: false, download: false }, f = x([]), g = x(), R = m(() => [...H, ["invoiceType", ["parse-enum", M, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", d.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", d.value.wms]], ["unitPriceNoFreight", ["to-thousand", d.value.wms]], ["amount", ["to-thousand", r.YUAN]], ["amountExcludingVAT", ["to-thousand", r.YUAN]], ["amountNoFreight", ["to-thousand", r.YUAN]], ["inputVAT", ["to-thousand", r.YUAN]], ["createTime", "parse-time"]]), { reportCfg: v } = K(), { CRUD: k, crud: u, columns: t } = L({ title: "盘盈明细", sort: ["id.desc"], invisibleColumns: [], permission: { ...y }, optShow: { ...A }, crudApi: { get: I } }, g), { maxHeight: C } = G({ paginate: true }), T = m(() => !!v.value.amountShow), P = m(() => !!v.value.amountExcludingTAXShow), S = m(() => X(y.showAmount)), h = m(() => u.query ? u.query.basicClass : void 0);
  k.HOOK.handleRefresh = async (_, { data: n }) => {
    await W(n.content), n.content = await z(n.content, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), n.content.forEach((a) => {
      a.profitReceipt || (a.profitReceipt = {}), a.profitReceipt.id = a.surplusId, a.profitReceipt.serialNumber = a.surplusSerialNumber;
    });
  };
  function E(_) {
    return ne(_, { props: ["quantity", "mete", ["amount", r.YUAN], ["amountExcludingVAT", r.YUAN], ["amountNoFreight", r.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "amountNoFreight"] });
  }
  return (_, n) => {
    const a = U, V = D("common-table"), B = Y;
    return o(), j("div", ie, [s(e($)), F((o(), l(V, { ref_key: "tableRef", ref: g, data: e(u).data, "data-format": R.value, "default-expand-all": false, "expand-row-keys": f.value, "max-height": e(C), "summary-method": E, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSortChange: e(u).handleSortChange }, { default: p(() => [s(J, { "expand-row-keys": f.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (i) => f.value = i), data: e(u).data, "row-key": "id", fixed: "left" }, { default: p(({ row: i }) => [w("div", le, [w("span", null, "备注：" + N(i.remark || "-"), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(Q, { "basic-class": h.value, columns: e(t), "classify-name-alias": "名称", "show-classification": "", "show-is-whole": "", "spec-merge": "" }, { afterIndex: p(() => [e(t).visible("createTime") ? (o(), l(a, { key: "outboundReceipt.reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核通过时间", prop: "createTime", width: "125" })) : c("", true), e(t).visible("profitReceipt.serialNumber") ? (o(), l(a, { key: "profitReceipt.serialNumber", "show-overflow-tooltip": true, align: "left", label: "盘盈单号", "min-width": "155", prop: "profitReceipt.serialNumber" }, { default: p(({ row: i }) => [s(Z, { receipt: i.profitReceipt, "receipt-types": ["INVENTORY_PROFIT"] }, null, 8, ["receipt"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["basic-class", "columns"]), s(ee, { "basic-class": h.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), s(ae, { "basic-class": h.value, columns: e(t) }, null, 8, ["basic-class", "columns"]), S.value ? (o(), l(te, { key: 0, columns: e(t), "show-amount": T.value, "show-amount-excluding-v-a-t": P.value, "show-invoice-type": "", "show-unit-price-e": "" }, null, 8, ["columns", "show-amount", "show-amount-excluding-v-a-t"])) : c("", true), e(t).visible("project.serialNumber") ? (o(), l(a, { key: "project.serialNumber", "show-overflow-tooltip": false, align: "center", label: "项目编号", "min-width": "150px", prop: "project.serialNumber" }, { default: p(({ row: { sourceRow: i } }) => {
      var b;
      return [w("span", null, N(((b = i.project) == null ? void 0 : b.serialNumber) || "-"), 1)];
    }), _: 1 })) : c("", true), s(oe, { columns: e(t), "show-area": false, "show-monomer": false, "show-project": "", "show-workshop": "" }, null, 8, ["columns"]), e(t).visible("heatNoAndBatchNo") ? (o(), l(a, { key: "heatNoAndBatchNo", "show-overflow-tooltip": true, align: "center", label: "炉批号/卷号", "min-width": "100", prop: "heatNoAndBatchNo" })) : c("", true), e(t).visible("supplier.name") ? (o(), l(a, { key: "supplier.name", "show-overflow-tooltip": true, align: "center", label: "供应商", "min-width": "150", prop: "supplier.name" })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange"])), [[B, e(u).loading]]), s(e(se))]);
  };
} }, de = O(re, [["__scopeId", "data-v-86a308e6"]]);
export {
  de as default
};
