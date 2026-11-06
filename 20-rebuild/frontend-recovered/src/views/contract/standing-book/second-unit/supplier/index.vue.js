import { _ as H, x as W, D as f, i as $, bF as h, bv as G, iW as Q, jb as z, iF as I, bV as J, P as K, j0 as X } from "../../../../../shared/runtime.js";
import { ref as m } from "vue";
import { provide as Z } from "vue";
import { computed as ee } from "vue";
import { resolveComponent as te } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as _ } from "vue";
import { withDirectives as ae } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as w } from "vue";
import { renderList as ne } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as r } from "vue";
import { createTextVNode as se } from "vue";
import { resolveDynamicComponent as oe } from "vue";
import { defineAsyncComponent as le } from "vue";
import { ElTableColumn as ie } from "element-plus";
import { ElTag as ue } from "element-plus";
import { vLoading as re } from "element-plus";
import { c as me, m as ce } from "./module/Header.vue.js";
import { u as pe } from "../../../../../modules/useTableHeight-90797a0b.js";
import { u as de } from "../../../../../modules/useTableTotal-3d22365a.js";
import { W as ve } from "../../../../../modules/contract-9b18cc88.js";
import _e from "../../common/components/storage-detail.vue.js";
import "../../../../../modules/useSelect-654af12a.js";
const be = { class: "app-container" }, ye = { key: 1 }, fe = { key: 0 }, he = { key: 0 }, ke = { key: 1 }, Ce = { key: 2 }, ge = { key: 1 }, Te = ["onClick"], Ae = ["onClick"], Ne = ["onClick"], xe = ["onClick"], Re = { __name: "index", setup(Ve, { expose: D }) {
  const x = m(null), R = m({}), E = m({});
  Z("tableItem", { headerRef: x, projectInfo: R, _commonFn: E });
  const P = { add: false, del: false, download: false, edit: false }, k = m(), { crud: c, columns: o } = W({ title: "供应商台账", optShow: P, permission: { ...ve.secondUnit.supplier }, invisibleColumns: ["basicClass"], hasPagination: true, crudApi: { ...me } }, k), { maxHeight: U } = pe({ tableRef: k }, 60), j = m([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["amount", ["to-thousand", f.YUAN]], ["cumulativePayment", ["to-thousand", f.YUAN]], ["cumulativeInvoice", ["to-thousand", f.YUAN]], ["inboundAmount", ["to-thousand", f.YUAN]]]), { getSummaries: B } = de(false, { defineData: ["settlementAmount", "cumulativePayment", "cumulativeInvoice"] }), V = m(""), C = m(false), g = m(false), b = m(null), T = m(""), F = { detail: le(() => X(() => import("./module/detail/index.vue.js"), ["static/js/index-a9b89d20.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/css/index-407e6295.css", "static/css/el-radio-group-3b9ac3ad.css"])), record: "" }, L = ee(() => F[T.value]), S = () => {
    b.value && (b.value.radioType = V.value, T.value === "costReport" ? g.value = true : b.value.visible = true);
  }, q = (y) => {
    y && S();
  }, A = (y, v, n) => {
    T.value = y, R.value = v, V.value = n, S();
  };
  return D({ refresh: c.toQuery }), (y, v) => {
    const n = ie, M = ue, O = te("common-table"), Y = re;
    return a(), p("div", be, [_(ce, { ref_key: "headerRef", ref: x }, null, 512), ae((a(), s(O, { ref_key: "tableRef", ref: k, data: e(c).data, "data-format": j.value, "empty-text": e(c).emptyText, "max-height": e(U), "summary-method": e(B), "show-summary": "" }, { default: u(() => [_(n, { align: "center", label: "序号", type: "index", width: "60" }), e(o).visible("createTime") ? (a(), s(n, { key: "createTime", align: "center", label: "创建日期", prop: "createTime", width: "120" })) : l("", true), e(o).visible("supplier.name") ? (a(), s(n, { key: "supplier.name", align: "center", label: "供应商", "min-width": "140", prop: "supplier.name", "show-overflow-tooltip": "" })) : l("", true), e(o).visible("serialNumber") ? (a(), s(n, { key: "serialNumber", align: "center", label: "合同编号", "min-width": "140", prop: "serialNumber", "show-overflow-tooltip": "" })) : l("", true), e(o).visible("projectNames") ? (a(), s(n, { key: "projectNames", align: "left", label: "项目", "min-width": "180", "show-overflow-tooltip": "" }, { default: u(({ row: t }) => {
      var i;
      return [(i = t.projects) != null && i.length ? (a(true), p(w, { key: 0 }, ne(t.projects, (N) => (a(), p(w, { key: N.id }, [d("span", null, "【" + r(N.serialNumber), 1), v[2] || (v[2] = d("span", null, "-", -1)), d("span", null, r(N.shortName) + "】", 1)], 64))), 128)) : (a(), p("span", ye, "-"))];
    }), _: 1 })) : l("", true), e(o).visible("basicClass") ? (a(), s(n, { key: "basicClass", align: "center", label: "类型", "min-width": "200", prop: "basicClass" }, { default: u(({ row: t }) => [t.basicClass !== "-" & e($)(t.basicClass) ? (a(), p("section", fe, [Number(e(c).query.purchaseType) === e(h).RAW_MATERIAL.V || Number(e(c).query.purchaseType) === e(h).MANUFACTURED.V ? (a(), p("span", he, r(e(G).getBits(e(Q).ENUM, t.basicClass, "L").join(" | ")), 1)) : Number(e(c).query.purchaseType) === e(h).SUBCONTRACTING.V ? (a(), p("span", ke, r(e(z).VL[t.basicClass]), 1)) : (a(), p("span", Ce, "-"))])) : (a(), p("span", ge, "-"))]), _: 1 })) : l("", true), e(o).visible("settlementStatus") ? (a(), s(n, { key: "settlementStatus", align: "center", label: "状态", prop: "settlementStatus" }, { default: u(({ row: t }) => {
      var i;
      return [_(M, { type: (i = e(I).V[t.settlementStatus]) == null ? void 0 : i.T }, { default: u(() => [se(r(e(I).VL[t.settlementStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : l("", true), e(o).visible("amount") ? (a(), s(n, { key: "amount", align: "center", label: "合同额（元）", "min-width": "140", prop: "amount" })) : l("", true), e(o).visible("settlementAmount") ? (a(), s(n, { key: "settlementAmount", align: "center", label: "结算额（元）", "min-width": "140", prop: "settlementAmount" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: (i) => A("detail", t, "settle") }, r(e(J)(t.settlementAmount)), 9, Te)]), _: 1 })) : l("", true), e(o).visible("inboundAmount") && e(c).query.purchaseType !== e(h).SUBCONTRACTING.V ? (a(), s(n, { key: "inboundAmount", align: "center", label: "实际入库额（元）", prop: "inboundAmount", width: "120" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: () => {
      e(c).rowDetail = t, C.value = true;
    } }, r(t.inboundAmount), 9, Ae)]), _: 1 })) : l("", true), e(o).visible("cumulativePayment") ? (a(), s(n, { key: "cumulativePayment", align: "center", label: "累计付款", "min-width": "140", prop: "cumulativePayment" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: (i) => A("detail", t, "cumulativePayment") }, r(t.cumulativePayment), 9, Ne)]), _: 1 })) : l("", true), e(o).visible("paymentRate") ? (a(), s(n, { key: "paymentRate", align: "center", label: "付款率", "min-width": "100", prop: "paymentRate" }, { default: u(({ row: t }) => {
      var i;
      return [d("span", null, r((i = t == null ? void 0 : t.paymentRate) == null ? void 0 : i.toFixed(2)) + "%", 1)];
    }), _: 1 })) : l("", true), e(o).visible("cumulativeInvoice") ? (a(), s(n, { key: "cumulativeInvoice", align: "center", label: "累计收票", "min-width": "140", prop: "cumulativeInvoice" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: (i) => A("detail", t, "cumulativeInvoice") }, r(t.cumulativeInvoice), 9, xe)]), _: 1 })) : l("", true), e(o).visible("invoiceRate") ? (a(), s(n, { key: "invoiceRate", align: "center", label: "收票率", "min-width": "100", prop: "invoiceRate" }, { default: u(({ row: t }) => [d("span", null, r(t.invoiceRate.toFixed(2)) + "%", 1)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "summary-method"])), [[Y, e(c).loading]]), _(K), (a(), s(oe(L.value), { ref_key: "currentComponentRef", ref: b, visible: g.value, "onUpdate:visible": v[0] || (v[0] = (t) => g.value = t), onComponentMounted: q }, null, 40, ["visible"])), _(_e, { modelValue: C.value, "onUpdate:modelValue": v[1] || (v[1] = (t) => C.value = t) }, null, 8, ["modelValue"])]);
  };
} }, Be = H(Re, [["__scopeId", "data-v-7c170e0b"]]);
export {
  Be as default
};
