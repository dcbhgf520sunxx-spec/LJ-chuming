import { ref as p } from "vue";
import { watch as P } from "vue";
import { provide as I } from "vue";
import { computed as v } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as o } from "vue";
import { unref as i } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as j } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as u } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as D } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElButton as L } from "element-plus";
import { vLoading as R } from "element-plus";
import { _ as $, x as G, D as c, k_ as O, c1 as S, G as z, P as F } from "../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import { X } from "../../../../modules/contract-9b18cc88.js";
import { c as J } from "../../../../modules/index-1f7d934b.js";
import { u as K } from "../../../../modules/useTableHeight-90797a0b.js";
import { u as W } from "../../../../modules/useTableTotal-3d22365a.js";
import Z from "./module/collection-invoice/index.vue.js";
import ee from "./module/expend-detail.vue.js";
import te from "./module/overview/index.vue.js";
import "./module/project-info.vue.js";
import "./components/year-date.vue.js";
import "./module/collection-invoice/collection.vue.js";
import "./module/collection-invoice/invoice.vue.js";
import "./components/purchase-select.vue.js";
const oe = { class: "app-container1" }, ae = { class: "head-container" }, ne = { key: 0, style: { padding: "0 20px 20px 20px" } }, le = ["onClick"], ie = ["onClick"], se = { key: 1, style: { "margin-top": "10px", padding: "0 0 0 20px" } }, re = { __name: "index", setup(ce) {
  const b = p(), k = { add: false, del: false, edit: false, download: false }, { crud: r } = G({ title: "内部（合营）项目", optShow: { ...k }, permission: { ...X }, crudApi: { ...J }, hasPagination: true, queryOnPresenterCreated: false }, b), { maxHeight: N } = K({ tableRef: b }, 50), { getSummaries: C } = W(false, { defineData: ["settlementAmount", "injectionAmount", "collectionAmountSum", "invoiceAmountSum", "paymentAmountSum", "creditAmount", "projectSummary"] }), V = p([["project.signDate", ["parse-time", "{y}-{m}-{d}"]], ["contractAmount", ["to-thousand", c.YUAN]], ["settlementAmount", ["to-thousand", c.YUAN]], ["collectionAmountSum", ["to-thousand", c.YUAN]], ["invoiceAmountSum", ["to-thousand", c.YUAN]], ["creditAmount", ["to-thousand", c.YUAN]], ["projectSummary", ["to-thousand", c.YUAN]], ["paymentAmountSum", ["to-thousand", c.YUAN]], ["injectionAmount", ["to-thousand", c.YUAN]]]), n = p({}), g = p(false), A = p(false), f = p(false);
  function h(l, t) {
    switch (n.value = t, console.log(t), l) {
      case "overView":
        f.value = true;
        break;
      case "expend":
        A.value = true;
        break;
      default:
        g.value = true;
    }
  }
  return P(() => f.value, async (l) => {
    l || (await r.toQuery(), await r.crudApi.getAmount());
  }), I("common", { itemData: n, projectId: v(() => {
    var l, t;
    return (t = (l = n == null ? void 0 : n.value) == null ? void 0 : l.project) == null ? void 0 : t.id;
  }), projectManagerId: v(() => r.query.projectManagerId), projectName: v(() => {
    var l, t, a, m;
    return ((t = (l = n == null ? void 0 : n.value) == null ? void 0 : l.project) == null ? void 0 : t.serialNumber) + ((m = (a = n == null ? void 0 : n.value) == null ? void 0 : a.project) == null ? void 0 : m.shortName);
  }), projectAttribute: v(() => {
    var l, t;
    return (t = (l = n == null ? void 0 : n.value) == null ? void 0 : l.project) == null ? void 0 : t.projectAttribute;
  }) }), (l, t) => {
    const a = M, m = H, U = L, T = B("common-table"), Y = F, E = R;
    return d(), y("div", oe, [_("div", ae, [o(Q)]), i(r).query.projectManagerId ? (d(), y("div", ne, [q((d(), j(T, { ref_key: "tableRef", ref: b, data: i(r).data, "data-format": V.value, "empty-text": i(r).emptyText, "max-height": i(N), "summary-method": i(C), "show-summary": "" }, { default: s(() => [o(a, { align: "center", label: "序号", type: "index", width: "60px" }), o(a, { align: "center", label: "项目", "min-width": "140", prop: "project.name", "show-overflow-tooltip": "" }, { default: s(({ row: { project: e } }) => [_("span", null, u(e.serialNumber) + "-" + u(e.shortName), 1)]), _: 1 }), o(a, { align: "center", label: "类型", prop: "project.projectAttribute" }, { default: s(({ row: { project: e } }) => [_("span", null, u(i(O).VL[e.projectAttribute]), 1)]), _: 1 }), o(a, { align: "center", label: "签订日期", prop: "project.signDate" }), o(a, { align: "center", label: "合同额", prop: "contractAmount" }), o(a, { align: "center", label: "状态", prop: "status" }, { default: s(({ row: e }) => [o(m, { type: i(S).V[e.status].TAG }, { default: s(() => [w(u(i(S).VL[e.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), o(a, { align: "center", label: "结算额", prop: "settlementAmount" }), o(a, { align: "center", label: "注资", prop: "injectionAmount" }), o(a, { align: "center", label: "累计收款", prop: "collectionAmountSum" }, { default: s(({ row: e }) => [_("span", { class: "specialText", onClick: (x) => h("collection_invoice", e) }, u(e.collectionAmountSum), 9, le)]), _: 1 }), o(a, { align: "center", label: "累计支出", prop: "paymentAmountSum" }, { default: s(({ row: e }) => [_("span", { class: "specialText", onClick: (x) => h("expend", e) }, u(e.paymentAmountSum), 9, ie)]), _: 1 }), o(a, { align: "center", label: "可用额度/总授信额度", "min-width": "120", prop: "creditAmount" }), o(a, { align: "center", label: "项目结余", prop: "projectSummary" }), i(z)(i(r).permission.detail) ? (d(), j(a, { key: 0, align: "center", label: "操作", width: "80px" }, { default: s(({ row: e }) => [o(U, { icon: "el-icon-view", size: "default", type: "info", onClick: (x) => h("overView", e) }, null, 8, ["onClick"])]), _: 1 })) : D("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "summary-method"])), [[E, i(r).loading]]), o(Y)])) : (d(), y("div", se, [o(m, { closable: false, "show-icon": "", type: "danger" }, { default: s(() => t[3] || (t[3] = [w("您好，当前页面需要选择项目经理方可查看")])), _: 1, __: [3] })])), o(Z, { visible: g.value, "onUpdate:visible": t[0] || (t[0] = (e) => g.value = e) }, null, 8, ["visible"]), o(ee, { visible: A.value, "onUpdate:visible": t[1] || (t[1] = (e) => A.value = e) }, null, 8, ["visible"]), o(te, { visible: f.value, "onUpdate:visible": t[2] || (t[2] = (e) => f.value = e) }, null, 8, ["visible"])]);
  };
} }, ke = $(re, [["__scopeId", "data-v-ce03c9fa"]]);
export {
  ke as default
};
