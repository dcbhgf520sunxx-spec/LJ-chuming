import { ref as T } from "vue";
import { computed as g } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as s } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as A } from "vue";
import { toDisplayString as P } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as V } from "element-plus";
import { vLoading as E } from "element-plus";
import { t as R, jX as U, bD as B, D as u, x as S, Cm as j, Cn as M, o as q, cO as H, jl as I, jG as L, xP as O, k5 as Y, P as $ } from "../../../../../shared/runtime.js";
import { c as F } from "../../../../../modules/reject-03b2f373.js";
import G from "./module/header.vue.js";
import "../../../../../modules/reset-query-5216307c.js";
const K = { class: "report-material-transfer-details app-container" }, ee = { __name: "index", setup(X) {
  const { decimalPrecision: m } = R(), w = { add: false, edit: false, del: false, download: false }, p = T(), b = g(() => [...U, ["invoiceType", ["parse-enum", B, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", m.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", m.value.wms]], ["amount", ["to-thousand", u.YUAN]], ["amountExcludingVAT", ["to-thousand", u.YUAN]], ["inputVAT", ["to-thousand", u.YUAN]], ["createTime", "parse-time"]]), { CRUD: _, crud: r, columns: a } = S({ title: "调整记录", sort: [], permission: { ...j }, invisibleColumns: [], optShow: { ...w }, crudApi: { get: M, detail: F } }, p), { maxHeight: v } = q({ paginate: true }), d = g(() => r.query ? r.query.basicClass : void 0);
  return _.HOOK.handleRefresh = async (x, { data: i }) => {
    i.content = i.content.map((t) => (t.supplementNo = t.serialNumber, t)), await H(i.content), i.content = await I(i.content);
  }, (x, i) => {
    const t = V, y = k("common-table"), C = E;
    return o(), D("div", K, [l(e(G)), N((o(), s(y, { ref_key: "tableRef", ref: p, data: e(r).data, "data-format": b.value, "max-height": e(v) }, { default: c(() => [l(L, { "basic-class": d.value, columns: e(a), "classify-name-alias": "名称", "show-classification": "", "show-project": "", sortable: "", "spec-merge": "" }, { afterIndex: c(() => [e(a).visible("createTime") ? (o(), s(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建时间", prop: "createTime", width: "140" }, { default: c(({ row: f }) => {
      var h;
      return [l(O, { id: (h = f.workshop) == null ? void 0 : h.id }, null, 8, ["id"]), A("span", null, P(f.createTime), 1)];
    }), _: 1 })) : n("", true), e(a).visible("supplementNo") ? (o(), s(t, { key: "supplementNo", "show-overflow-tooltip": true, align: "center", label: "调整单号", "min-width": "120", prop: "supplementNo" })) : n("", true)]), _: 1 }, 8, ["basic-class", "columns"]), l(Y, { "basic-class": d.value, columns: e(a) }, null, 8, ["basic-class", "columns"]), e(a).visible("accountingUnit") ? (o(), s(t, { key: "accountingUnit", "show-overflow-tooltip": true, align: "center", label: "核算单位", prop: "accountingUnit", width: "80" })) : n("", true), e(a).visible("mete") ? (o(), s(t, { key: "mete", "show-overflow-tooltip": true, align: "center", label: "核算量", "min-width": "120", prop: "mete" })) : n("", true), e(a).visible("amount") ? (o(), s(t, { key: "amount", label: "调整金额(含税)", "show-overflow-tooltip": true, align: "right", prop: "amount", width: "110" })) : n("", true), e(a).visible("amountExcludingVAT") ? (o(), s(t, { key: "amountExcludingVAT", label: "调整金额(不含税)", "show-overflow-tooltip": true, align: "right", prop: "amountExcludingVAT", width: "120" })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[C, e(r).loading]]), l(e($))]);
  };
} };
export {
  ee as default
};
