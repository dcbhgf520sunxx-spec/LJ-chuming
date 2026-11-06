import { ref as d } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as n } from "vue";
import { withCtx as h } from "vue";
import { unref as e } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as P } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as S, _ as V } from "./module/detail.vue.js";
import { x as j, o as F, G as v, P as H } from "../../../../shared/runtime.js";
import { w as l } from "../../../../modules/crm-c6ba92ff.js";
import I from "./module/header.vue.js";
const $ = { class: "app-container" }, q = { class: "head-container" }, K = { __name: "index", setup(z) {
  const _ = { add: false, edit: false, del: false, download: false }, g = d(), m = d(false), b = d({}), { crud: s, CRUD: w, columns: r } = j({ title: "商务统计报表", sort: [], optShow: { ..._ }, permission: { permission: l }, crudApi: { ...S }, hasPagination: true }, g), { maxHeight: y } = F({ extraBox: [".head-container"], paginate: true });
  function N(p) {
    m.value = true, b.value = p;
  }
  return w.HOOK.handleRefresh = (p, { data: u }) => {
  }, (p, u) => {
    const k = f("print-table"), a = U, x = f("common-button"), W = f("common-table"), B = D;
    return t(), R("div", $, [C("div", q, [n(I, null, { printBtn: h(() => [e(v)(e(l).print) ? (t(), o(k, { key: 0, "api-key": "businessSummaryReport", params: { ...e(s).query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : i("", true)]), _: 1 })]), P((t(), o(W, { ref_key: "tableRef", ref: g, data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(y), "row-key": "id", style: { width: "100%" } }, { default: h(() => [n(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(r).visible("departmentName") ? (t(), o(a, { key: "departmentName", prop: "departmentName", "show-overflow-tooltip": true, label: "销售部", align: "center" })) : i("", true), e(r).visible("informantUserName") ? (t(), o(a, { align: "center", key: "informantUserName", prop: "informantUserName", "show-overflow-tooltip": true, label: "销售员" })) : i("", true), e(r).visible("projectInformationWarehousingNum") ? (t(), o(a, { key: "projectInformationWarehousingNum", prop: "projectInformationWarehousingNum", "show-overflow-tooltip": true, align: "center", label: "项目信息登记数量" })) : i("", true), e(r).visible("governmentWarehousingNum") ? (t(), o(a, { key: "governmentWarehousingNum", prop: "governmentWarehousingNum", align: "center", "show-overflow-tooltip": true, label: "政府备案数量" })) : i("", true), e(r).visible("biddingPlatformWarehousingNum") ? (t(), o(a, { key: "biddingPlatformWarehousingNum", prop: "biddingPlatformWarehousingNum", align: "center", "show-overflow-tooltip": true, label: "平台注册数量" })) : i("", true), e(r).visible("supplierWarehousingNum") ? (t(), o(a, { key: "supplierWarehousingNum", prop: "supplierWarehousingNum", align: "center", "show-overflow-tooltip": true, label: "业主供应商入库数量" })) : i("", true), e(r).visible("applyForBidRecordNum") ? (t(), o(a, { key: "applyForBidRecordNum", prop: "applyForBidRecordNum", align: "center", "show-overflow-tooltip": true, label: "项目投标报名数量" })) : i("", true), n(a, { align: "center", "show-overflow-tooltip": true, label: "操作", width: "100px" }, { default: h((c) => [e(v)(e(l).detail) ? (t(), o(x, { key: 0, type: "primary", size: "default", icon: "el-icon-view", onClick: (A) => N(c.row) }, null, 8, ["onClick"])) : i("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, e(s).loading]]), n(e(H)), n(V, { visible: m.value, "onUpdate:visible": u[0] || (u[0] = (c) => m.value = c), "detail-data": b.value, permission: e(l) }, null, 8, ["visible", "detail-data", "permission"])]);
  };
} };
export {
  K as default
};
