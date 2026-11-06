import { ref as r } from "vue";
import { provide as w } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as $ } from "vue";
import { unref as l } from "vue";
import { createBlock as p } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as i } from "vue";
import { createCommentVNode as v } from "vue";
import { createTextVNode as B } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { InfoFilled as H } from "@element-plus/icons-vue";
import { ElIcon as L } from "element-plus";
import { ElPopover as M } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as q } from "element-plus";
import K from "./module/header.vue.js";
import Q from "./module/form/index.vue.js";
import { _ as G, x as J, wF as T, D as g, o as W, z as X, jb as Z, wG as A, an as ee, P as te } from "../../../../shared/runtime.js";
import { c as ne } from "../../../../modules/index-dfff0f60.js";
import oe from "./module/detail/index.vue.js";
import ae from "./module/record/index.vue.js";
import "./components/supplier-select-sub/index.vue.js";
import "./components/supplier-select-sub/module/add-supplier.vue.js";
import "./components/invoice-type-select-private.vue.js";
const le = { class: "app-container" }, se = { class: "content-container" }, ie = ["onClick"], ce = { class: "content-container" }, re = ["onClick"], pe = { class: "content-container" }, me = ["onClick"], de = { class: "content-container" }, ue = ["onClick"], _e = { __name: "index", setup(fe, { expose: E }) {
  const x = r(), { crud: m, CRUD: N } = J({ title: "分包台账", crudApi: { ...ne }, permission: T.self, hasPagination: true }, x);
  N.HOOK.beforeRefresh = (d) => {
    d.query.projectAttribute = [1];
  };
  const D = r([["createDate", ["parse-time", "{y}-{m}-{d}"]], ["amount", ["to-thousand", g.YUAN]], ["settlementAmount", ["to-thousand", g.YUAN]], ["totalPayment", ["to-thousand", g.YUAN]], ["totalInvoice", ["to-thousand", g.YUAN]]]), { maxHeight: P } = W({ paginate: true }), S = r(), k = r([]), y = r(false);
  function u(d, _) {
    S.value = _, k.value = d, y.value = true;
  }
  const C = r(0);
  function V() {
    C.value = Math.random();
  }
  function z(d) {
    return false;
  }
  return w("permission", T.self), w("common", { table_item_data: k, current_key: S }), E({ refresh: m.toQuery }), (d, _) => {
    const o = Y, f = H, h = L, b = M, I = O, R = j("common-table"), U = q;
    return s(), F("div", le, [t(K), $((s(), p(R, { ref_key: "tableRef", ref: x, data: l(m).data, "data-format": D.value, "empty-text": l(m).emptyText, "max-height": l(P), "custom-class": "table-container" }, { default: n(() => [t(o, { align: "center", label: "序号", type: "index", width: "60" }), t(o, { align: "center", label: "创建日期", prop: "createDate" }), t(o, { align: "left", label: "所属项目", "min-width": "160", "show-overflow-tooltip": "" }, { default: n(({ row: { project: e } }) => [a("span", null, i(l(X)(e)), 1)]), _: 1 }), t(o, { align: "left", label: "分包合同号", "min-width": "140", prop: "serialNumber", "show-overflow-tooltip": "" }), t(o, { align: "center", label: "分供类型", "min-width": "100", prop: "subSupplyTypeEnum" }, { default: n(({ row: e }) => [a("span", null, i(l(Z).VL[e.subSupplyTypeEnum]), 1)]), _: 1 }), t(o, { align: "left", label: "分包商", "min-width": "140", prop: "supplier.supplierName", "show-overflow-tooltip": "" }), t(o, { align: "center", label: "合同额", "min-width": "100", prop: "amount" }), t(o, { align: "center", label: "结算额", "min-width": "100", prop: "settlementAmount" }, { default: n(({ row: e }) => [a("div", se, [e.settlementSize ? (s(), p(b, { key: 0, content: "存在未审核结束的单据：" + e.settlementSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: n(() => [t(h, { class: "icon" }, { default: n(() => [t(f)]), _: 1 })]), _: 2 }, 1032, ["content"])) : v("", true), a("span", { class: "specialText", onClick: (c) => u(e, "settle") }, i(e.settlementAmount), 9, ie)])]), _: 1 }), t(o, { align: "center", label: "预结算额", "min-width": "100", prop: "preSettlementAmount" }, { default: n(({ row: e }) => [a("div", ce, [e.preSettlementSize ? (s(), p(b, { key: 0, content: "存在未审核结束的单据：" + e.preSettlementSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: n(() => [t(h, { class: "icon" }, { default: n(() => [t(f)]), _: 1 })]), _: 2 }, 1032, ["content"])) : v("", true), a("span", { class: "specialText", onClick: (c) => u(e, "preSettle") }, i(e.preSettlementAmount), 9, re)])]), _: 1 }), t(o, { align: "center", label: "累计付款", "min-width": "100", prop: "totalPayment" }, { default: n(({ row: e }) => [a("div", pe, [e.paymentSize ? (s(), p(b, { key: 0, content: "存在未审核结束的单据: " + e.paymentSize, width: 240, effect: "dark", placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: n(() => [t(h, { class: "icon" }, { default: n(() => [t(f)]), _: 1 })]), _: 2 }, 1032, ["content"])) : v("", true), a("span", { class: "specialText", onClick: (c) => u(e, "payment") }, i(e.totalPayment), 9, me)])]), _: 1 }), t(o, { align: "center", label: "累计收票", "min-width": "100", prop: "totalInvoice" }, { default: n(({ row: e }) => [a("div", de, [e.invoiceSize ? (s(), p(b, { key: 0, content: "存在未审核结束的单据：" + e.invoiceSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: n(() => [t(h, { class: "icon" }, { default: n(() => [t(f)]), _: 1 })]), _: 2 }, 1032, ["content"])) : v("", true), a("span", { class: "specialText", onClick: (c) => u(e, "invoice") }, i(e.totalInvoice), 9, ue)])]), _: 1 }), t(o, { align: "center", label: "执行状态", prop: "boolSettlementStatus" }, { default: n(({ row: e }) => {
      var c;
      return [t(I, { type: (c = l(A).V[e.boolSettlementStatus]) == null ? void 0 : c.T }, { default: n(() => [B(i(l(A).VL[e.boolSettlementStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), t(o, { align: "center", label: "创建人", prop: "user.name" }), t(o, { align: "center", label: "操作", "min-width": "160" }, { default: n(({ row: { sourceRow: e } }) => [t(ee, { data: e, "disabled-edit": z(e), "show-detail": "" }, null, 8, ["data", "disabled-edit"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[U, l(m).loading]]), t(te), t(Q, { onClosed: l(m).toQuery }, null, 8, ["onClosed"]), t(oe), (s(), p(ae, { key: C.value, modelValue: y.value, "onUpdate:modelValue": _[0] || (_[0] = (e) => y.value = e), onClosed: V }, null, 8, ["modelValue"]))]);
  };
} }, Ae = G(_e, [["__scopeId", "data-v-a40a2621"]]);
export {
  Ae as default
};
