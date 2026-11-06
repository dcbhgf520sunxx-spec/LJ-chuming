import { _ as W, x as G, D as f, i as Q, bF as h, bv as z, iW as J, jb as K, iF as w, bV as X, P as Z, j0 as ee } from "../../../../shared/runtime.js";
import { ref as m } from "vue";
import { provide as te } from "vue";
import { computed as ae } from "vue";
import { resolveComponent as ne } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as se } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as I } from "vue";
import { renderList as oe } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as r } from "vue";
import { createTextVNode as le } from "vue";
import { resolveDynamicComponent as ie } from "vue";
import { defineAsyncComponent as ue } from "vue";
import { ElTableColumn as re } from "element-plus";
import { ElTag as me } from "element-plus";
import { vLoading as ce } from "element-plus";
import pe from "./module/Header.vue.js";
import { c as de } from "../../../../modules/supplier-e2667d36.js";
import { u as ve } from "../../../../modules/useTableHeight-90797a0b.js";
import { u as _e } from "../../../../modules/useTableTotal-3d22365a.js";
import { W as be } from "../../../../modules/contract-9b18cc88.js";
import ye from "./module/record/index.vue.js";
import fe from "../common/components/storage-detail.vue.js";
import "../../../../modules/useSelect-654af12a.js";
const he = { class: "app-container" }, ke = { key: 1 }, Ce = { key: 0 }, ge = { key: 0 }, Te = { key: 1 }, Ae = { key: 2 }, Ne = { key: 1 }, xe = ["onClick"], Re = ["onClick"], Ve = ["onClick"], Se = ["onClick"], we = { __name: "index", setup(Ie, { expose: D }) {
  const x = m(null), R = m({}), E = m({});
  te("tableItem", { headerRef: x, projectInfo: R, _commonFn: E });
  const P = { add: false, del: false, download: false, edit: false }, k = m(), { crud: c, columns: o } = G({ title: "供应商台账", optShow: P, permission: { ...be.self.supplier }, invisibleColumns: ["basicClass"], hasPagination: true, crudApi: { ...de } }, k), { maxHeight: U } = ve({ tableRef: k }, 60), j = m([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["amount", ["to-thousand", f.YUAN]], ["cumulativePayment", ["to-thousand", f.YUAN]], ["cumulativeInvoice", ["to-thousand", f.YUAN]], ["inboundAmount", ["to-thousand", f.YUAN]]]), { getSummaries: B } = _e(false, { defineData: ["settlementAmount", "cumulativePayment", "cumulativeInvoice"] }), V = m(""), C = m(false), g = m(false), y = m(null), T = m(""), F = { detail: ue(() => ee(() => import("./module/detail/index.vue.js"), ["static/js/index-e65b653e.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/css/index-855b3cd7.css", "static/css/el-radio-group-3b9ac3ad.css"])), record: "" }, L = ae(() => F[T.value]), S = () => {
    y.value && (y.value.radioType = V.value, T.value === "costReport" ? g.value = true : y.value.visible = true);
  }, q = (_) => {
    _ && S();
  }, A = (_, v, n) => {
    T.value = _, R.value = v, V.value = n, S();
  }, M = (_) => {
    console.log(_);
  };
  return D({ refresh: c.toQuery }), (_, v) => {
    const n = re, O = me, Y = ne("common-table"), $ = Z, H = ce;
    return a(), p("div", he, [b(pe, { ref_key: "headerRef", ref: x }, null, 512), se((a(), s(Y, { ref_key: "tableRef", ref: k, data: e(c).data, "data-format": j.value, "empty-text": e(c).emptyText, "max-height": e(U), "summary-method": e(B), "show-summary": "", onRowClick: M }, { default: u(() => [b(n, { align: "center", label: "序号", type: "index", width: "60" }), e(o).visible("createTime") ? (a(), s(n, { key: "createTime", align: "center", label: "创建日期", prop: "createTime", width: "120" })) : l("", true), e(o).visible("supplier.name") ? (a(), s(n, { key: "supplier.name", align: "center", label: "供应商", "min-width": "140", prop: "supplier.name", "show-overflow-tooltip": "" })) : l("", true), e(o).visible("serialNumber") ? (a(), s(n, { key: "serialNumber", align: "center", label: "合同编号", "min-width": "140", prop: "serialNumber", "show-overflow-tooltip": "" })) : l("", true), e(o).visible("projectNames") ? (a(), s(n, { key: "projectNames", align: "left", label: "项目", "min-width": "180", "show-overflow-tooltip": "" }, { default: u(({ row: t }) => {
      var i;
      return [(i = t.projects) != null && i.length ? (a(true), p(I, { key: 0 }, oe(t.projects, (N) => (a(), p(I, { key: N.id }, [d("span", null, "【" + r(N.serialNumber), 1), v[2] || (v[2] = d("span", null, "-", -1)), d("span", null, r(N.shortName) + "】", 1)], 64))), 128)) : (a(), p("span", ke, "-"))];
    }), _: 1 })) : l("", true), e(o).visible("basicClass") ? (a(), s(n, { key: "basicClass", align: "center", label: "类型", "min-width": "200", prop: "basicClass" }, { default: u(({ row: t }) => [t.basicClass !== "-" & e(Q)(t.basicClass) ? (a(), p("section", Ce, [Number(e(c).query.purchaseType) === e(h).RAW_MATERIAL.V || Number(e(c).query.purchaseType) === e(h).MANUFACTURED.V ? (a(), p("span", ge, r(e(z).getBits(e(J).ENUM, t.basicClass, "L").join(" | ")), 1)) : Number(e(c).query.purchaseType) === e(h).SUBCONTRACTING.V ? (a(), p("span", Te, r(e(K).VL[t.basicClass]), 1)) : (a(), p("span", Ae, "-"))])) : (a(), p("span", Ne, "-"))]), _: 1 })) : l("", true), e(o).visible("settlementStatus") ? (a(), s(n, { key: "settlementStatus", align: "center", label: "状态", prop: "settlementStatus" }, { default: u(({ row: t }) => {
      var i;
      return [b(O, { type: (i = e(w).V[t.settlementStatus]) == null ? void 0 : i.T }, { default: u(() => [le(r(e(w).VL[t.settlementStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : l("", true), e(o).visible("amount") ? (a(), s(n, { key: "amount", align: "center", label: "合同额（元）", "min-width": "140", prop: "amount" })) : l("", true), e(o).visible("settlementAmount") ? (a(), s(n, { key: "settlementAmount", align: "center", label: "结算额（元）", "min-width": "140", prop: "settlementAmount" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: (i) => A("detail", t, "settle") }, r(e(X)(t.settlementAmount)), 9, xe)]), _: 1 })) : l("", true), e(o).visible("inboundAmount") && e(c).query.purchaseType !== e(h).SUBCONTRACTING.V ? (a(), s(n, { key: "inboundAmount", align: "center", label: "实际入库额（元）", prop: "inboundAmount", width: "120" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: () => {
      e(c).rowDetail = t, C.value = true;
    } }, r(t.inboundAmount), 9, Re)]), _: 1 })) : l("", true), e(o).visible("cumulativePayment") ? (a(), s(n, { key: "cumulativePayment", align: "center", label: "累计付款", "min-width": "140", prop: "cumulativePayment" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: (i) => A("detail", t, "cumulativePayment") }, r(t.cumulativePayment), 9, Ve)]), _: 1 })) : l("", true), e(o).visible("paymentRate") ? (a(), s(n, { key: "paymentRate", align: "center", label: "付款率", "min-width": "100", prop: "paymentRate" }, { default: u(({ row: t }) => {
      var i;
      return [d("span", null, r((i = t == null ? void 0 : t.paymentRate) == null ? void 0 : i.toFixed(2)) + "%", 1)];
    }), _: 1 })) : l("", true), e(o).visible("cumulativeInvoice") ? (a(), s(n, { key: "cumulativeInvoice", align: "center", label: "累计收票", "min-width": "140", prop: "cumulativeInvoice" }, { default: u(({ row: t }) => [d("span", { class: "specialText", onClick: (i) => A("detail", t, "cumulativeInvoice") }, r(t.cumulativeInvoice), 9, Se)]), _: 1 })) : l("", true), e(o).visible("invoiceRate") ? (a(), s(n, { key: "invoiceRate", align: "center", label: "收票率", "min-width": "100", prop: "invoiceRate" }, { default: u(({ row: t }) => [d("span", null, r(t.invoiceRate.toFixed(2)) + "%", 1)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "summary-method"])), [[H, e(c).loading]]), b($), b(ye), (a(), s(ie(L.value), { ref_key: "currentComponentRef", ref: y, visible: g.value, "onUpdate:visible": v[0] || (v[0] = (t) => g.value = t), onComponentMounted: q }, null, 40, ["visible"])), b(fe, { modelValue: C.value, "onUpdate:modelValue": v[1] || (v[1] = (t) => C.value = t) }, null, 8, ["modelValue"])]);
  };
} }, Oe = W(we, [["__scopeId", "data-v-e51db1a2"]]);
export {
  Oe as default
};
