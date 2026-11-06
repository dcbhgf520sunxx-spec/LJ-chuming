import moment from "moment";
import { ref as u } from "vue";
import { onMounted as F } from "vue";
import { watch as G } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { withKeys as I } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as d } from "vue";
import { withModifiers as z } from "vue";
import { withDirectives as J } from "vue";
import { createBlock as k } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as Q } from "vue";
import { renderList as $ } from "vue";
import { ElInput as W } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElTag as Y } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { h as te } from "../../../modules/purchase-data-analysis-1b2dc5a0.js";
import { sx as f, J as ae, G as le, jP as g, p as ne, aN as oe, bv as se, i as ie } from "../../../shared/runtime.js";
import re from "./purchase-order-record-detail.vue.js";
const ue = { style: { display: "flex", "justify-content": "space-between", "align-items": "center", margin: "8px 0" } }, pe = { style: { display: "flex", "align-items": "center" } }, me = { key: 1 }, ye = { __name: "purchase-order-status", props: { maxHeight: [Number, String], default: void 0, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(y) {
  const b = y, L = u(), P = u(false), h = u(false), V = u({}), o = u({ settlementStatus: f.UNSETTLEMENT.V, basicClass: void 0, supplierName: void 0 }), { handleSizeChange: U, handleCurrentChange: M, total: q, setTotalPage: B, queryPage: v } = ae({ fetchHook: s }), S = u([]);
  F(() => {
    s();
  }), G(() => b.query, (r) => {
    s();
  }, { deep: true });
  async function s() {
    var r;
    if (!le((r = b.permission) == null ? void 0 : r.get)) return false;
    try {
      const { yearDate, ...filters } = b.query;
      const year = moment(Number(yearDate));
      const createTime = yearDate == null ? undefined : [year.clone().startOf("year").valueOf(), year.endOf("year").valueOf()];
      const { content: e = [], totalElements: _ } = await te({ ...filters, createTime, ...o.value, ...v });
      B(_), S.value = e || [];
    } catch (e) {
      console.log(e, "获取选择筛选列列表");
    }
  }
  function j(r) {
    V.value = r, h.value = true;
  }
  function O() {
    o.value = { settlementStatus: f.UNSETTLEMENT.V, basicClass: void 0, supplierName: void 0 }, s();
  }
  return (r, e) => {
    var T;
    const _ = m("common-radio-button"), R = m("common-select"), A = W, N = m("common-button"), n = X, E = Y, D = m("common-table"), H = Z, K = ee;
    return p(), C("div", null, [e[6] || (e[6] = c("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "采购订单执行状态", -1)), c("div", ue, [c("div", pe, [a(_, { modelValue: o.value.settlementStatus, "onUpdate:modelValue": e[0] || (e[0] = (t) => o.value.settlementStatus = t), options: l(f).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: s }, null, 8, ["modelValue", "options"]), a(R, { modelValue: o.value.basicClass, "onUpdate:modelValue": e[1] || (e[1] = (t) => o.value.basicClass = t), options: l(g).ENUM, class: "filter-item", clearable: "", placeholder: "材料类型搜索", style: { width: "200px", margin: "0 6px" }, type: "enum", onChange: s }, null, 8, ["modelValue", "options"]), a(A, { modelValue: o.value.supplierName, "onUpdate:modelValue": e[2] || (e[2] = (t) => o.value.supplierName = t), modelModifiers: { trim: true }, size: "default", placeholder: "供应商搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: I(s, ["enter"]) }, null, 8, ["modelValue"]), a(N, { class: "filter-item", size: "default", type: "success", style: { "margin-left": "6px" }, icon: "el-icon-search", onClick: z(s, ["stop"]) }, { default: i(() => e[4] || (e[4] = [d(" 搜索 ")])), _: 1, __: [4] }), a(N, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: z(O, ["stop"]) }, { default: i(() => e[5] || (e[5] = [d(" 重置 ")])), _: 1, __: [5] })])]), J((p(), k(D, { ref_key: "tableRef", ref: L, data: S.value, "max-height": y.maxHeight, "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: j }, { default: i(() => [a(n, { align: "center", label: "序号", type: "index", width: "55" }), a(n, { key: "createTime", align: "center", "show-overflow-tooltip": "", label: "创建日期", prop: "createTime" }, { default: i(({ row: t }) => [c("span", null, x(t.createTime ? l(ne)(t.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(n, { key: "serialNumber", align: "center", "show-overflow-tooltip": "", label: "采购合同", prop: "serialNumber", "min-width": "120" }), a(n, { key: "supplier.name", prop: "supplier.name", align: "center", "show-overflow-tooltip": "", label: "供应商" }), a(n, { key: "branchCompany.name", align: "center", "show-overflow-tooltip": "", label: "签订主体", prop: "branchCompany.name", "min-width": "120" }), a(n, { key: "basicClass", prop: "basicClass", align: "center", "show-overflow-tooltip": "", label: "类别" }, { default: i((t) => [(p(true), C(Q, null, $(l(oe)(l(se).getBits(l(g), t.row.basicClass, "V")), (w) => (p(), k(E, { style: { "margin-right": "5px" }, key: w, type: l(g).V[w].T, effect: "light", "disable-transitions": "" }, { default: i(() => [d(x(l(g).VL[w]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), a(n, { key: "amount", prop: "amount", align: "center", "show-overflow-tooltip": "", label: "合同额（元）" }), a(n, { key: "inboundAmount", prop: "inboundAmount", align: "center", "show-overflow-tooltip": "", label: "入库额（元）" }), a(n, { key: "settlementStatus", prop: "settlementStatus", align: "center", "show-overflow-tooltip": "", label: "当前状态" }, { default: i(({ row: t }) => [l(ie)(t.settlementStatus) ? (p(), k(E, { key: 0, type: t.settlementStatus === 0 ? "success" : "danger" }, { default: i(() => [d(x(l(f).VL[t.settlementStatus]), 1)]), _: 2 }, 1032, ["type"])) : (p(), C("span", me, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[K, P.value]]), a(H, { total: l(q), "current-page": l(v).pageNumber, "page-size": l(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(U), onCurrentChange: l(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(re, { visible: h.value, "onUpdate:visible": e[3] || (e[3] = (t) => h.value = t), "detail-data": V.value, permission: (T = y.permission) == null ? void 0 : T.order }, null, 8, ["visible", "detail-data", "permission"])]);
  };
} };
export {
  ye as default
};
