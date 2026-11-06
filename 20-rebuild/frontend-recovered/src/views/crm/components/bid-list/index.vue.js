import { ref as p } from "vue";
import { onMounted as te } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as ae } from "vue";
import { createVNode as a } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as y } from "vue";
import { unref as n } from "vue";
import { createBlock as B } from "vue";
import { createCommentVNode as v } from "vue";
import { toDisplayString as S } from "vue";
import { normalizeStyle as V } from "vue";
import { createTextVNode as ne } from "vue";
import { ElTableColumn as ie } from "element-plus";
import { ElTag as oe } from "element-plus";
import { ElPagination as re } from "element-plus";
import le from "./module/header.vue.js";
import me from "./module/detail.vue.js";
import { g as se } from "../../../../modules/project-config-3fa4f850.js";
import { V as ue, o as ce, J as pe, lr as de, dE as ge, G as C, ls as he, lq as w, lt as s, p as F } from "../../../../shared/runtime.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/user-template-config-16e71de8.js";
import "../../../../modules/bid-list-077bf24b.js";
import "../../../../modules/use-crm-project-information-18afe991.js";
import "../../../../modules/use-form-config-data-098a0552.js";
import "../../../../modules/project-information-053c195b.js";
import "../information-description/index.vue.js";
import "../../../../modules/tender-apply-config-select-032e3e0f.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
const fe = { class: "app-container" }, ye = { style: { float: "right", "margin-top": "10px" } }, qe = { __name: "index", props: { moduleType: { type: Number, default: void 0 }, crmSpecialBubmissionStatusEnum: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(m) {
  const u = m, R = p([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]]]), q = p({ crmTenderRequirementTypeEnum: u.moduleType, crmSpecialBubmissionStatusEnum: u.crmSpecialBubmissionStatusEnum }), i = p({}), D = p({}), _ = p([]), T = p(false), j = p({}), P = p([]);
  te(() => {
    i.value = ue(q.value), l(), b(), x();
  });
  const { maxHeight: L } = ce({ extraBox: [".head-container"], extraHeight: 50, paginate: true }), { handleSizeChange: k, handleCurrentChange: z, total: A, setTotalPage: I, queryPage: g } = pe({ fetchHook: l });
  async function b() {
    try {
      const t = await de({ crmTenderRequirementTypeEnum: i.value.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: u.crmSpecialBubmissionStatusEnum });
      D.value = t;
    } catch (t) {
      console.log(t);
    }
  }
  async function x() {
    var t;
    try {
      const r = await se({ crmProjectInformationConfigEnum: ge.STRUCTURE_TYPE_CONFIG.V });
      P.value = r && (r != null && r.length) ? (t = r[0]) == null ? void 0 : t.crmProjectInformationConfigDTOS : [];
    } catch (r) {
      console.log(r, "获取结构类型配置列表失败");
    }
  }
  async function l() {
    if (C(u.permission.get)) try {
      const { content: t = [], totalElements: r } = await he({ ...i.value, ...g });
      console.log(t), I(r), _.value = t.map((c) => (c.homeProvince = c.countryName + c.provinceName + c.cityName + c.regionName, c));
    } catch (t) {
      console.log(t);
    }
  }
  function U(t) {
    i.value.departmentId = t, l();
  }
  function H(t) {
    i.value.structureTypeConfigurationId = t, l();
  }
  function O({ startDate: t, endDate: r }) {
    i.value.startDate = t, i.value.endDate = r, l();
  }
  function Y(t) {
    i.value.regionIds = t, l();
  }
  function W(t) {
    i.value.crmTenderRequirementTypeEnum = t, b(), l();
  }
  function $(t) {
    i.value = t, i.value.crmTenderRequirementTypeEnum = u.moduleType, i.value.crmSpecialBubmissionStatusEnum = u.crmSpecialBubmissionStatusEnum, l();
  }
  function G(t) {
    i.value = t, i.value.crmTenderRequirementTypeEnum = u.moduleType, i.value.crmSpecialBubmissionStatusEnum = u.crmSpecialBubmissionStatusEnum, g.pageNumber = 1, g.pageSize = 20, l();
  }
  function J(t) {
    T.value = true, j.value = t;
  }
  function K() {
    l(), b(), x();
  }
  return (t, r) => {
    const c = h("print-table"), o = ie, N = h("table-cell-tag"), Q = oe, X = h("common-button"), Z = h("common-table"), ee = re;
    return f(), ae("div", fe, [a(le, { "summary-data": D.value, moduleType: m.moduleType, crmSpecialBubmissionStatusEnum: m.crmSpecialBubmissionStatusEnum, "structure-list": P.value, onDepartmentChange: U, onStructureChange: H, onDateChange: O, onRegionChange: Y, onTenderChange: W, onSearchSuccess: $, onReset: G }, { printBtn: d(() => [y("div", ye, [n(C)(m.permission.print) ? (f(), B(c, { key: 0, "api-key": "bidInfoList", params: { ...i.value }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : v("", true)])]), _: 1 }, 8, ["summary-data", "moduleType", "crmSpecialBubmissionStatusEnum", "structure-list"]), a(Z, { data: _.value, "data-format": R.value, maxHeight: n(L), "show-empty-symbol": false, style: { width: "100%" } }, { default: d(() => [a(o, { type: "index", align: "center", label: "序号", width: "80", fixed: "left" }), m.moduleType !== n(w).BIDDING_METHOD.V && m.moduleType !== n(w).SETTLEMENT_METHOD.V ? (f(), B(o, { key: 0, align: "center", "show-overflow-tooltip": true, label: "标书类型", prop: "crmTenderRequirementTypeEnum", width: "120", fixed: "left" }, { default: d(({ row: e }) => [y("span", null, S(n(w).VL[e.crmTenderRequirementTypeEnum] || ""), 1)]), _: 1 })) : v("", true), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目登记日期", prop: "informantDateTime", width: "120", fixed: "left" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", "min-width": "160", fixed: "left" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", "min-width": "300", fixed: "left" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "建设单位", "min-width": "170", prop: "crmEnterpriseWarehousingName" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince", "min-width": "170" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", "min-width": "130" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "预估造价(万元)", prop: "estimatedCost", "min-width": "130" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", "min-width": "130" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "登记人", prop: "informantUserName", width: "120" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "负责人", prop: "projectBidManagerUserName", width: "120", fixed: "right" }), a(o, { align: "center", "show-overflow-tooltip": true, label: "计划完成日期", prop: "projectBidManagerFinishDate", width: "120", fixed: "right" }, { default: d(({ row: e }) => [a(N, { show: e.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && e.crmProjectBidStatus === n(s).UNDER_WAY.V, name: "超期", color: e.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && e.crmProjectBidStatus === n(s).UNDER_WAY.V ? "#F56C6C" : "" }, null, 8, ["show", "color"]), y("span", { style: V(`color: ${e.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && e.crmProjectBidStatus === n(s).UNDER_WAY.V ? "#F56C6C" : ""}`) }, S(e.projectBidManagerFinishDate ? n(F)(e.projectBidManagerFinishDate, "{y}-{m}-{d}") : "-"), 5)]), _: 1 }), a(o, { align: "center", "show-overflow-tooltip": true, label: "实际完成日期", prop: "projectBidManagerActualFinishDate", width: "120", fixed: "right" }, { default: d(({ row: e }) => [a(N, { show: e.projectBidManagerFinishDate < e.projectBidManagerActualFinishDate && e.crmProjectBidStatus === n(s).COMPLETED.V, name: "超期", color: e.projectBidManagerFinishDate < e.projectBidManagerActualFinishDate && e.crmProjectBidStatus === n(s).COMPLETED.V ? "#F56C6C" : "" }, null, 8, ["show", "color"]), y("span", { style: V(`color: ${e.projectBidManagerFinishDate < e.projectBidManagerActualFinishDate && e.crmProjectBidStatus === n(s).COMPLETED.V ? "#F56C6C" : ""}`) }, S(e.projectBidManagerActualFinishDate ? n(F)(e.projectBidManagerActualFinishDate, "{y}-{m}-{d}") : "-"), 5)]), _: 1 }), a(o, { align: "center", label: "状态", prop: "crmProjectBidStatus", width: "100", fixed: "right" }, { default: d(({ row: e }) => {
      var E;
      return [a(Q, { type: (E = n(s).V[e.crmProjectBidStatus]) == null ? void 0 : E.TYPE }, { default: d(() => {
        var M;
        return [ne(S(((M = n(s).V[e.crmProjectBidStatus]) == null ? void 0 : M.L) || n(s).UNDER_WAY.L), 1)];
      }), _: 2 }, 1032, ["type"])];
    }), _: 1 }), n(C)(m.permission.detail) ? (f(), B(o, { key: 1, align: "center", label: "操作", width: "100", fixed: "right" }, { default: d(({ row: e }) => [a(X, { type: "primary", icon: "el-icon-view", onClick: (E) => J(e) }, null, 8, ["onClick"])]), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), a(ee, { total: n(A), "current-page": n(g).pageNumber, "page-size": n(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(k), onCurrentChange: n(z) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(me, { modelValue: T.value, "onUpdate:modelValue": r[0] || (r[0] = (e) => T.value = e), "current-row": j.value, permission: m.permission, "tender-type": i.value.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: m.crmSpecialBubmissionStatusEnum, onSuccess: K }, null, 8, ["modelValue", "current-row", "permission", "tender-type", "crmSpecialBubmissionStatusEnum"])]);
  };
} };
export {
  qe as default
};
