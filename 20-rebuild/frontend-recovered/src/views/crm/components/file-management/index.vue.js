import { ref as u } from "vue";
import { onMounted as O } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as F } from "vue";
import { createVNode as a } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as g } from "vue";
import { unref as n } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as T } from "vue";
import { toDisplayString as v } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElPagination as j } from "element-plus";
import { o as P, V as G, lE as $, G as C, lq as m, lF as U, dH as A } from "../../../../shared/runtime.js";
import J from "./module/detail.vue.js";
import K from "./module/header.vue.js";
const Q = { class: "app-container" }, W = { style: { float: "right", "margin-top": "10px" } }, ae = { __name: "index", props: { moduleType: { type: Number, default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(l) {
  const y = l, _ = u([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["projectBidManagerFinishDate", ["parse-time", "{y}-{m}-{d}"]]]), D = u({ crmTenderRequirementTypeEnum: y.moduleType, pageNumber: 1, pageSize: 20 }), t = u({}), E = u([]), b = u(0), f = u(false), w = u({}), { maxHeight: S } = P({ extraBox: [".head-container"], paginate: true });
  O(() => {
    t.value = G(D.value), i();
  });
  async function i() {
    try {
      const { content: e = [], totalElements: s } = await $(t.value);
      console.log(e), b.value = s, E.value = e;
    } catch (e) {
      console.log(e);
    }
  }
  function V(e) {
    t.value = e, t.value.crmTenderRequirementTypeEnum = y.moduleType, i();
  }
  function N(e) {
    t.value = e, t.value.crmTenderRequirementTypeEnum = y.moduleType, i();
  }
  function B({ startDate: e, endDate: s }) {
    t.value.startDate = e, t.value.endDate = s, i();
  }
  function M(e) {
    t.value.crmTenderRequirementTypeEnum = e, i();
  }
  function x(e) {
    t.value.pageSize = e, i();
  }
  function k(e) {
    t.value.pageNumber = e, i();
  }
  function H(e) {
    f.value = true, w.value = e;
  }
  return (e, s) => {
    const R = h("print-table"), o = I, q = h("common-button"), L = h("common-table"), z = j;
    return c(), F("div", Q, [a(K, { moduleType: l.moduleType, onDateChange: B, onSearchSuccess: V, onTenderChange: M, onReset: N }, { printBtn: p(() => [g("div", W, [n(C)(l.permission.print) ? (c(), d(R, { key: 0, "api-key": "documentInfoList", params: { ...t.value }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : T("", true)])]), _: 1 }, 8, ["moduleType"]), a(L, { data: E.value, "data-format": _.value, maxHeight: l.moduleType === n(m).BIDDING_METHOD.V || l.moduleType === n(m).SETTLEMENT_METHOD.V ? n(S) : n(S) - 45 }, { default: p(() => [a(o, { type: "index", align: "center", label: "序号" }), l.moduleType === n(m).SETTLEMENT_METHOD.V ? (c(), d(o, { key: 0, align: "center", "show-overflow-tooltip": true, label: "来源", prop: "crmSpecialBubmissionStatusEnum", width: "120" }, { default: p(({ row: r }) => [g("span", null, v(n(U).VL[r.crmSettlementBusinessTypeEnum] || ""), 1)]), _: 1 })) : T("", true), l.moduleType === n(m).SETTLEMENT_METHOD.V ? (c(), d(o, { key: 1, align: "center", "show-overflow-tooltip": true, label: "类型", prop: "crmSpecialBubmissionStatusEnum", width: "120" }, { default: p(({ row: r }) => [g("span", null, v(n(A).VL[r.crmSpecialBubmissionStatusEnum] || ""), 1)]), _: 1 })) : T("", true), l.moduleType !== n(m).BIDDING_METHOD.V && l.moduleType !== n(m).SETTLEMENT_METHOD.V ? (c(), d(o, { key: 2, align: "center", "show-overflow-tooltip": true, label: "标书类型", prop: "crmTenderRequirementTypeEnum", width: "120" }, { default: p(({ row: r }) => [g("span", null, v(n(m).VL[r.crmTenderRequirementTypeEnum] || ""), 1)]), _: 1 })) : T("", true), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目创建日期", prop: "createTime", width: "150" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "投标部门", prop: "departmentName" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "投标人", prop: "applyForBidReporterName" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "负责人", prop: "headOfCommerceName" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "完成日期", prop: "projectBidManagerFinishDate" }), n(C)(l.permission.detail) ? (c(), d(o, { key: 3, align: "center", width: "100", label: "操作" }, { default: p(({ row: r }) => [a(q, { type: "primary", icon: "el-icon-view", onClick: (X) => H(r) }, null, 8, ["onClick"])]), _: 1 })) : T("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), a(z, { total: b.value, "current-page": t.value.pageNumber, "page-size": t.value.pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: x, onCurrentChange: k }, null, 8, ["total", "current-page", "page-size"]), a(J, { modelValue: f.value, "onUpdate:modelValue": s[0] || (s[0] = (r) => f.value = r), "current-row": w.value, permission: l.permission, "tender-type": t.value.crmTenderRequirementTypeEnum, onSuccess: i }, null, 8, ["modelValue", "current-row", "permission", "tender-type"])]);
  };
} };
export {
  ae as default
};
