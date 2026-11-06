import { ref as r } from "vue";
import { provide as P } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as z } from "vue";
import { unref as n } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as y } from "vue";
import { createTextVNode as I } from "vue";
import { ElTableColumn as R } from "element-plus";
import { InfoFilled as U } from "@element-plus/icons-vue";
import { ElIcon as F } from "element-plus";
import { ElPopover as B } from "element-plus";
import { ElTag as Y } from "element-plus";
import { vLoading as $ } from "element-plus";
import H from "./module/header.vue.js";
import L from "./module/form/index.vue.js";
import M from "./module/detail/index.vue.js";
import { _ as O, x as q, wF as G, D as _, o as K, z as J, jb as Q, wG as k, an as W, P as X } from "../../../../shared/runtime.js";
import { c as Z } from "../../../../modules/index-69cea220.js";
import ee from "./module/record/index.vue.js";
import "./components/supplier-select-sub/index.vue.js";
import "./components/supplier-select-sub/module/add-supplier.vue.js";
import "./components/branch-company-select-sub.vue.js";
import "./components/invoice-type-select-private.vue.js";
const te = { class: "app-container" }, ae = { class: "content-container" }, oe = ["onClick"], ne = { class: "content-container" }, le = ["onClick"], ie = { class: "content-container" }, se = ["onClick"], re = { __name: "index", setup(ce) {
  const x = r(), { crud: u, CRUD: C } = q({ title: "内包（合营）分包台账", crudApi: { ...Z }, permission: G.interior, hasPagination: true }, x);
  C.HOOK.beforeRefresh = (p) => {
    p.query.projectAttribute = [2, 3];
  };
  const N = r([["createDate", ["parse-time", "{y}-{m}-{d}"]], ["amount", ["to-thousand", _.YUAN]], ["settlementAmount", ["to-thousand", _.YUAN]], ["totalPayment", ["to-thousand", _.YUAN]], ["totalInvoice", ["to-thousand", _.YUAN]]]), { maxHeight: T } = K({ paginate: true }), w = r(), S = r([]), f = r(false);
  function b(p, m) {
    w.value = m, S.value = p, f.value = true;
  }
  return P("common", { table_item_data: S, current_key: w }), (p, m) => {
    const o = R, h = U, v = F, g = B, E = Y, A = V("common-table"), D = $;
    return c(), j("div", te, [e(H), z((c(), d(A, { ref_key: "tableRef", ref: x, data: n(u).data, "data-format": N.value, "empty-text": n(u).emptyText, "max-height": n(T) }, { default: a(() => [e(o, { align: "center", label: "序号", type: "index", width: "60" }), e(o, { align: "center", label: "创建日期", prop: "createDate" }), e(o, { align: "center", label: "项目经理", prop: "project.projectManagerName" }), e(o, { align: "center", label: "所属项目", "min-width": "160", "show-overflow-tooltip": "" }, { default: a(({ row: { project: t } }) => [l("span", null, i(n(J)(t)), 1)]), _: 1 }), e(o, { align: "center", label: "采购合同号", "min-width": "140", prop: "serialNumber", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "分供类型", "min-width": "100", prop: "subSupplyTypeEnum" }, { default: a(({ row: t }) => [l("span", null, i(n(Q).VL[t.subSupplyTypeEnum]), 1)]), _: 1 }), e(o, { align: "center", label: "供应商", "min-width": "140", prop: "supplier.supplierName", "show-overflow-tooltip": "" }), e(o, { align: "center", label: "合同额", "min-width": "100", prop: "amount" }), e(o, { align: "center", label: "结算额", "min-width": "100", prop: "settlementAmount" }, { default: a(({ row: t }) => [l("div", ae, [t.settlementSize ? (c(), d(g, { key: 0, content: "存在未审核结束的单据：" + t.settlementSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: a(() => [e(v, { class: "icon" }, { default: a(() => [e(h)]), _: 1 })]), _: 2 }, 1032, ["content"])) : y("", true), l("span", { class: "specialText", onClick: (s) => b(t, "settle") }, i(t.settlementAmount), 9, oe)])]), _: 1 }), e(o, { align: "center", label: "累计付款", "min-width": "100", prop: "totalPayment" }, { default: a(({ row: t }) => [l("div", ne, [t.paymentSize ? (c(), d(g, { key: 0, content: "存在未审核结束的单据: " + t.paymentSize, width: 240, effect: "dark", placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: a(() => [e(v, { class: "icon" }, { default: a(() => [e(h)]), _: 1 })]), _: 2 }, 1032, ["content"])) : y("", true), l("span", { class: "specialText", onClick: (s) => b(t, "payment") }, i(t.totalPayment), 9, le)])]), _: 1 }), e(o, { align: "center", label: "累计开票", "min-width": "100", prop: "totalInvoice" }, { default: a(({ row: t }) => [l("div", ie, [t.invoiceSize ? (c(), d(g, { key: 0, content: "存在未审核结束的单据：" + t.invoiceSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: a(() => [e(v, { class: "icon" }, { default: a(() => [e(h)]), _: 1 })]), _: 2 }, 1032, ["content"])) : y("", true), l("span", { class: "specialText", onClick: (s) => b(t, "invoice") }, i(t.totalInvoice), 9, se)])]), _: 1 }), e(o, { align: "center", label: "执行状态", prop: "boolSettlementStatus" }, { default: a(({ row: t }) => {
      var s;
      return [e(E, { type: (s = n(k).V[t.boolSettlementStatus]) == null ? void 0 : s.T }, { default: a(() => [I(i(n(k).VL[t.boolSettlementStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(o, { align: "center", label: "创建人", prop: "user.name" }), e(o, { align: "center", label: "操作", "min-width": "120" }, { default: a(({ row: { sourceRow: t } }) => [e(W, { data: t, showEdit: false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[D, n(u).loading]]), e(X), e(L), e(M), e(ee, { modelValue: f.value, "onUpdate:modelValue": m[0] || (m[0] = (t) => f.value = t) }, null, 8, ["modelValue"])]);
  };
} }, we = O(re, [["__scopeId", "data-v-ad8b5dfb"]]);
export {
  we as default
};
