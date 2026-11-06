import { provide as G } from "vue";
import { ref as _ } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as p } from "vue";
import { withDirectives as M } from "vue";
import { unref as e } from "vue";
import { createBlock as n } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as D } from "vue";
import { Fragment as O } from "vue";
import { renderList as z } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as Q } from "element-plus";
import { vLoading as W } from "element-plus";
import { l as X, t as Y, fg as Z, x as ee, o as te, iF as oe, c1 as T, z as ae, bN as le, iw as ne, bV as d, P as re, L as se, G as R } from "../../../shared/runtime.js";
import { A as x } from "../../../modules/contract-9b18cc88.js";
import ie from "./module/header.vue.js";
import ue from "./cost-page-dialog/index.vue.js";
import "./cost-page-dialog/module/main-material-fee.vue.js";
import "../../../modules/detail-fee-ef8adaab.js";
import "./cost-page-dialog/module/labor-fee.vue.js";
import "./cost-page-dialog/module/auxiliary-material-fee.vue.js";
import "./cost-page-dialog/module/water-electric-fee.vue.js";
import "./cost-page-dialog/module/depreciation-fee.vue.js";
import "./cost-page-dialog/module/management-fee.vue.js";
import "./cost-page-dialog/module/shipping-fee.vue.js";
import "./cost-page-dialog/module/testing-fee.vue.js";
import "./cost-page-dialog/module/subcontracting-fee.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function ce(P) {
  return X({ module: "", url: "/api/contract/project-finance", method: "get", params: P });
}
const pe = { get: ce }, me = { class: "app-container" }, de = { class: "head-container" }, fe = ["onClick"], be = ["onClick"], je = { __name: "index", setup(P) {
  const j = { add: false, edit: false, del: false, download: false }, { decimalPrecision: m } = Y(), { projectTree: h } = Z();
  G("projectTree", h);
  const V = _(), b = _({}), E = _({}), y = _(false), A = _(false), { crud: g, CRUD: B, columns: i } = ee({ title: "业财报表", sort: [], optShow: { ...j }, permission: { ...x }, crudApi: { ...pe }, hasPagination: true }, V), { maxHeight: N } = te({ extraBox: [".head-container"], paginate: true });
  function F(v) {
    if (!R(x.settleDetail)) return false;
    y.value = true, b.value = v;
  }
  function L(v) {
    if (!R(x.cost.get)) return false;
    A.value = true, E.value = v.sourceRow;
  }
  return B.HOOK.handleRefresh = (v, f) => {
    var a;
    h.value = h.value.map((c) => (c.serialNumberName = c.serialNumber + " " + c.name, c)), f.data.content = (a = f.data.content) == null ? void 0 : a.map((c) => (c.settlementStatus === oe.SETTLED.V && (c.status = T.SETTLED.V), c));
  }, (v, f) => {
    const a = I, c = K, U = C("common-table"), S = J, $ = Q, H = C("common-dialog"), q = W;
    return l(), k("div", me, [u("div", de, [p(ie)]), M((l(), n(U, { ref_key: "tableRef", ref: V, data: e(g).data, "empty-text": e(g).emptyText, "max-height": e(N), "row-key": "id", style: { width: "100%" } }, { default: o(() => [p(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(i).visible("project") ? (l(), n(a, { align: "center", key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "140" }, { default: o((t) => [u("span", null, r(e(ae)(t.row)), 1)]), _: 1 })) : s("", true), e(i).visible("businessType") ? (l(), n(a, { align: "center", key: "businessType", prop: "businessType", "show-overflow-tooltip": true, label: "业务类型" }, { default: o((t) => [u("span", null, r(e(le).VL[t.row.businessType]), 1)]), _: 1 })) : s("", true), e(i).visible("orderType") ? (l(), n(a, { align: "center", key: "orderType", prop: "orderType", "show-overflow-tooltip": true, label: "订单属性" }, { default: o((t) => [u("span", null, r(e(ne).VL[t.row.orderSourceType]), 1)]), _: 1 })) : s("", true), e(i).visible("status") ? (l(), n(a, { align: "center", key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态" }, { default: o((t) => [p(c, { type: e(T).V[t.row.status].TAG }, { default: o(() => [D(r(e(T).VL[t.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), e(i).visible("contractAmount") ? (l(), n(a, { align: "center", key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, label: "合同额" }, { default: o((t) => [u("span", null, r(e(d)(t.row.contractAmount, e(m).contract)), 1)]), _: 1 })) : s("", true), e(i).visible("settlementAmount") ? (l(), n(a, { align: "center", key: "settlementAmount", prop: "settlementAmount", "show-overflow-tooltip": true, label: "结算额" }, { default: o((t) => [u("span", { style: { color: "#409EFF", cursor: "pointer" }, onClick: (w) => F(t.row) }, r(e(d)(t.row.settlementAmount, e(m).contract)), 9, fe)]), _: 1 })) : s("", true), e(i).visible("costAmount") ? (l(), n(a, { align: "center", key: "costAmount", prop: "costAmount", "show-overflow-tooltip": true, label: "综合成本" }, { default: o((t) => [u("span", { style: { color: "#F56C6C", cursor: "pointer" }, onClick: (w) => L(t.row) }, r(e(d)(t.row.costAmount, e(m).contract)), 9, be)]), _: 1 })) : s("", true), e(i).visible("grossProfit") ? (l(), n(a, { align: "center", key: "grossProfit", prop: "grossProfit", "show-overflow-tooltip": true, label: "毛利润" }, { default: o((t) => [u("span", null, r(e(d)(t.row.grossProfit, e(m).contract)), 1)]), _: 1 })) : s("", true), e(i).visible("grossProfitRate") ? (l(), n(a, { align: "center", key: "grossProfitRate", prop: "grossProfitRate", "show-overflow-tooltip": true, label: "利润率（%）" }, { default: o((t) => [u("span", null, r((t.row.grossProfitRate * 100).toFixed(2)), 1)]), _: 1 })) : s("", true), e(i).visible("collectionAmount1") ? (l(), n(a, { align: "center", key: "collectionAmount1", prop: "collectionAmount1", "show-overflow-tooltip": true, label: "收款" }, { default: o(() => [e(i).visible("collectionAmount") ? (l(), n(a, { align: "center", key: "collectionAmount", prop: "collectionAmount", "show-overflow-tooltip": true, label: "收入" }, { default: o((t) => [u("span", null, r(e(d)(t.row.collectionAmount, e(m).contract)), 1)]), _: 1 })) : s("", true), e(i).visible("receivableAmount") ? (l(), n(a, { align: "center", key: "receivableAmount", prop: "receivableAmount", "show-overflow-tooltip": true, label: "应收款" }, { default: o((t) => [u("span", null, r(e(d)(t.row.receivableAmount, e(m).contract)), 1)]), _: 1 })) : s("", true), e(i).visible("availableBalance") ? (l(), n(a, { align: "center", key: "availableBalance", prop: "availableBalance", "show-overflow-tooltip": true, label: "可用余额" }, { default: o((t) => [u("span", null, r(e(d)(t.row.availableBalance, e(m).contract)), 1)]), _: 1 })) : s("", true)]), _: 1 })) : s("", true), e(i).visible("happenedAmount") ? (l(), n(a, { align: "center", key: "happenedAmount", prop: "happenedAmount", "show-overflow-tooltip": true, label: "累计发生额" }, { default: o((t) => [u("span", null, r(e(d)(t.row.happenedAmount, e(m).contract)), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[q, e(g).loading]]), p(e(re)), p(H, { title: "结算详情", modelValue: y.value, "onUpdate:modelValue": f[0] || (f[0] = (t) => y.value = t), width: "460px", "show-close": "", "custom-class": "settlement-detail", top: "10vh" }, { default: o(() => [p($, { column: 1, data: b.value, border: "", style: { cursor: "pointer" } }, { default: o(() => [p(S, { label: "结算额", "label-align": "center", align: "center" }, { default: o(() => [u("span", null, r(e(d)(b.value.settlementAmount, e(m).contract)), 1)]), _: 1 }), p(S, { label: "附件", "label-align": "center", align: "center" }, { default: o(() => {
      var t;
      return [((t = b.value.settlementAttachments) == null ? void 0 : t.length) > 0 ? (l(true), k(O, { key: 0 }, z(b.value.settlementAttachments, (w) => (l(), k("div", { key: w.id, style: { "margin-bottom": "3px" } }, [D(r(w.name) + " ", 1), p(se, { params: { id: w.id } }, null, 8, ["params"])]))), 128)) : s("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue"]), p(e(ue), { "detail-row": E.value, visible: A.value, "onUpdate:visible": f[1] || (f[1] = (t) => A.value = t), settlementStatus: e(g).query.settlementStatus }, null, 8, ["detail-row", "visible", "settlementStatus"])]);
  };
} };
export {
  je as default
};
