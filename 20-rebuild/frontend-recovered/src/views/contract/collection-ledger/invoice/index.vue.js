import { ref as k } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as C, g as N } from "../../../../modules/invoice-2cd386aa.js";
import { _ as q, t as R, x as U, o as P, bN as V, z as j, bV as _, p as B, bD as E, P as L } from "../../../../shared/runtime.js";
import { c as H } from "../../../../modules/contract-9b18cc88.js";
import S from "./module/header.vue.js";
const I = { class: "app-container" }, M = { class: "head-container" }, O = { key: 0 }, $ = { key: 1 }, z = { key: 0 }, F = { __name: "index", setup(K) {
  const { decimalPrecision: d } = R(), w = H.invoice, y = { add: false, edit: false, del: false, download: false }, v = k(), { crud: n, columns: c, CRUD: b } = U({ title: "开票台账", sort: [], permission: { ...w }, optShow: { ...y }, crudApi: { ...C, get: N }, invisibleColumns: ["contractAmount"], hasPagination: true }, v), { maxHeight: f } = P({ wrapperBox: ".invoice-ledger", paginate: true, extraHeight: 100 });
  return b.HOOK.beforeRefresh = () => {
    n.query.createTime && n.query.createTime.length > 0 ? (n.query.startDate = n.query.createTime[0], n.query.endDate = n.query.createTime[1]) : (n.query.startDate = void 0, n.query.endDate = void 0);
  }, (G, J) => {
    const a = D, h = x("common-table"), g = A;
    return o(), p("div", I, [u("div", M, [m(t(S))]), T((o(), r(h, { ref_key: "tableRef", ref: v, data: t(n).data, "empty-text": t(n).emptyText, "max-height": t(f), style: { width: "100%" }, stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: l(() => [m(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(c).visible("businessType") ? (o(), r(a, { key: "businessType", prop: "businessType", "show-overflow-tooltip": true, label: "业务类型", align: "center" }, { default: l((e) => [u("span", null, i(e.row.businessType ? t(V).VL[e.row.businessType] : "废料出售"), 1)]), _: 1 })) : s("", true), t(c).visible("project") ? (o(), r(a, { key: "project.serialNumber", prop: "project", "show-overflow-tooltip": true, label: "所属项目/购买方", "min-width": "150" }, { default: l((e) => [e.row.type === 1 ? (o(), p("span", O, i(t(j)(e.row.project)), 1)) : (o(), p("span", $, i(e.row.collectionUnit), 1))]), _: 1 })) : s("", true), t(c).visible("invoiceUnit") ? (o(), r(a, { key: "invoiceUnit", prop: "invoiceUnit", "show-overflow-tooltip": true, label: "签约主体/出售方", align: "center" }, { default: l((e) => [u("div", null, i(e.row.invoiceUnit), 1)]), _: 1 })) : s("", true), t(c).visible("contractAmount") ? (o(), r(a, { key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, label: "合同金额(元)" }, { default: l((e) => [u("span", null, i(e.row.contractAmount ? t(_)(e.row.contractAmount, t(d).contract) : ""), 1)]), _: 1 })) : s("", true), t(c).visible("invoiceDate") ? (o(), r(a, { key: "invoiceDate", prop: "invoiceDate", label: "开票日期", align: "center", "min-width": "120" }, { default: l((e) => [u("div", null, i(e.row.invoiceDate ? t(B)(e.row.invoiceDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : s("", true), t(c).visible("invoiceAmount") ? (o(), r(a, { key: "invoiceAmount", prop: "invoiceAmount", label: "开票额(元)", align: "center", "min-width": "120" }, { default: l((e) => [u("span", null, i(e.row.invoiceAmount && e.row.invoiceAmount > 0 ? t(_)(e.row.invoiceAmount, t(d).contract) : e.row.invoiceAmount), 1)]), _: 1 })) : s("", true), t(c).visible("invoiceNo") ? (o(), r(a, { key: "invoiceNo", prop: "invoiceNo", "show-overflow-tooltip": true, label: "发票号码", align: "center", "min-width": "120" }, { default: l((e) => [u("div", null, i(e.row.invoiceNo), 1)]), _: 1 })) : s("", true), t(c).visible("invoiceType") ? (o(), r(a, { key: "invoiceType", prop: "invoiceType", label: "发票类型", align: "center", "min-width": "120" }, { default: l((e) => [u("span", null, i(e.row.invoiceType ? t(E).VL[e.row.invoiceType] : ""), 1), e.row.taxRate ? (o(), p("span", z, i(`【${e.row.taxRate}%】`), 1)) : s("", true)]), _: 1 })) : s("", true), t(c).visible("invoiceContent") ? (o(), r(a, { key: 8, prop: "invoiceContent", label: "开票内容", align: "center", "show-overflow-tooltip": true }, { default: l((e) => [u("span", null, i(e.row.invoiceContent || "-"), 1)]), _: 1 })) : s("", true), t(c).visible("remark") ? (o(), r(a, { key: "remark", prop: "remark", label: "备注", align: "center", "show-overflow-tooltip": true }, { default: l((e) => [u("span", null, i(e.row.remark || "-"), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[g, t(n).loading]]), m(t(L))]);
  };
} }, ee = q(F, [["__scopeId", "data-v-9b3b6506"]]);
export {
  ee as default
};
