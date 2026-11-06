import { ref as u } from "vue";
import { useStore as F } from "vuex";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { unref as e } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as x } from "vue";
import { createTextVNode as v } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as A } from "element-plus";
import M from "./module/header.vue.js";
import { x as W, o as I, lF as Q, lQ as g, G as E, P as q } from "../../../../shared/runtime.js";
import { c as G, _ as O, g as z } from "./module/form.vue.js";
import { o as y } from "../../../../modules/crm-c6ba92ff.js";
import J from "./module/detail.vue.js";
const K = { class: "app-container" }, X = { key: 0 }, Y = { key: 1 }, re = { __name: "index", setup(Z) {
  const T = u([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]]]), V = F(), h = u(), d = u(false), _ = u([]), N = u([]), k = u({}), f = u(false), D = { add: false, edit: false, del: false, download: false }, { crud: w, columns: l } = W({ title: "专项方案管理", optShow: { ...D }, crudApi: { ...G }, permission: { ...y }, queryOnPresenterCreated: true }, h), { maxHeight: B } = I({ extraBox: [".head-container"], paginate: true });
  async function j(m) {
    try {
      const r = await z({ id: m });
      N.value = r || [];
    } catch (r) {
      console.log(r, "获取详情失败");
    }
  }
  async function L(m) {
    await j(m.id), _.value = m, d.value = true;
  }
  async function U() {
    await V.dispatch("approval_list/fetchApprovalNum"), w.toQuery();
  }
  function P(m) {
    k.value = m, f.value = true;
  }
  return (m, r) => {
    const i = H, R = A, S = C("common-button"), $ = C("common-table");
    return a(), b("div", K, [s(M), s($, { ref_key: "tableRef", ref: h, style: { width: "100%" }, data: e(w).data, maxHeight: e(B), "row-key": "id", "data-format": T.value }, { default: c(() => [s(i, { type: "index", align: "center", label: "序号", width: "60", fixed: "left" }), e(l).visible("informantDateTime") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "登记日期", prop: "informantDateTime", key: "informantDateTime", width: "120", fixed: "left" })) : n("", true), e(l).visible("serialNumber") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", key: "serialNumber", "min-width": "170", fixed: "left" })) : n("", true), e(l).visible("projectName") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", key: "projectName", fixed: "left", "min-width": "170" })) : n("", true), e(l).visible("crmEnterpriseWarehousingName") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "建设单位", prop: "crmEnterpriseWarehousingName", key: "crmEnterpriseWarehousingName", "min-width": "130" })) : n("", true), e(l).visible("regionNames") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "regionNames", key: "regionNames", "min-width": "130" })) : n("", true), e(l).visible("structureTypeConfigurationName") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", key: "structureTypeConfigurationName", "min-width": "120" })) : n("", true), e(l).visible("crmSettlementBusinessTypeEnum") ? (a(), o(i, { align: "center", label: "业务类型", prop: "crmSettlementBusinessTypeEnum", key: "crmSettlementBusinessTypeEnum", width: "120" }, { default: c(({ row: t }) => [t != null && t.crmSettlementBusinessTypeEnum ? (a(), b("span", X, x(e(Q).VL[t == null ? void 0 : t.crmSettlementBusinessTypeEnum]), 1)) : (a(), b("span", Y, "-"))]), _: 1 })) : n("", true), e(l).visible("estimatedCost") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "预估造价（万元）", prop: "estimatedCost", key: "estimatedCost", "min-width": "120" })) : n("", true), e(l).visible("projectLevelConfigName") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "项目等级", prop: "projectLevelConfigName", key: "projectLevelConfigName", "min-width": "120" })) : n("", true), e(l).visible("departmentName") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", key: "departmentName", "min-width": "120" })) : n("", true), e(l).visible("informantUserName") ? (a(), o(i, { align: "center", "show-overflow-tooltip": true, label: "登记人", prop: "informantUserName", key: "informantUserName", "min-width": "120" })) : n("", true), e(l).visible("crmSubmissionStatusEnum") ? (a(), o(i, { align: "center", label: "状态", prop: "crmSubmissionStatusEnum", key: "crmSubmissionStatusEnum", width: "120", fixed: "right" }, { default: c(({ row: t }) => {
      var p;
      return [s(R, { type: (p = e(g).V[t == null ? void 0 : t.crmSubmissionStatusEnum]) == null ? void 0 : p.T }, { default: c(() => [v(x(e(g).VL[t == null ? void 0 : t.crmSubmissionStatusEnum] || ""), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : n("", true), s(i, { align: "center", label: "操作", fixed: "right", width: "170" }, { default: c(({ row: t }) => [e(E)(e(y).detail) ? (a(), o(S, { key: 0, type: "info", disabled: t.crmSubmissionStatusEnum === e(g).UN_FILL.V, onClick: (p) => L(t) }, { default: c(() => r[2] || (r[2] = [v(" 查看 ")])), _: 2, __: [2] }, 1032, ["disabled", "onClick"])) : n("", true), e(E)(e(y).report) ? (a(), o(S, { key: 1, type: "primary", onClick: (p) => P(t) }, { default: c(() => r[3] || (r[3] = [v("提报")])), _: 2, __: [3] }, 1032, ["onClick"])) : n("", true)]), _: 1 })]), _: 1 }, 8, ["data", "maxHeight", "data-format"]), s(e(q)), s(O, { modelValue: f.value, "onUpdate:modelValue": r[0] || (r[0] = (t) => f.value = t), "detail-info": k.value, onSuccess: U }, null, 8, ["modelValue", "detail-info"]), s(J, { modelValue: d.value, "onUpdate:modelValue": r[1] || (r[1] = (t) => d.value = t), "current-row": _.value, "detail-data": N.value }, null, 8, ["modelValue", "current-row", "detail-data"])]);
  };
} };
export {
  re as default
};
