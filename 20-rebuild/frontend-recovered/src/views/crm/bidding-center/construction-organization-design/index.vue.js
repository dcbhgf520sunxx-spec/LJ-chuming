import { ref as d } from "vue";
import { onMounted as le } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as a } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as se } from "vue";
import { unref as n } from "vue";
import { createBlock as C } from "vue";
import { createCommentVNode as I } from "vue";
import { toDisplayString as c } from "vue";
import { normalizeStyle as F } from "vue";
import { Fragment as ue } from "vue";
import { renderList as me } from "vue";
import { ElMessageBox as ce } from "element-plus";
import { ElNotification as pe } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElOption as ge } from "element-plus";
import { ElSelect as fe } from "element-plus";
import { ElPagination as he } from "element-plus";
import Te from "./module/header.vue.js";
import _e from "./module/detail.vue.js";
import ye from "./module/add-form.vue.js";
import { g as Se } from "../../../../modules/project-config-3fa4f850.js";
import { lq as B, dH as b, V as Ee, o as Ce, J as Be, lr as be, lF as w, dE as we, G as v, ls as ve, lt as p, p as O, lM as updateBidStatus } from "../../../../shared/runtime.js";
import { b as T } from "../../../../modules/crm-c6ba92ff.js";
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
import "../../components/information-description/index.vue.js";
import "../../../../modules/tender-apply-config-select-032e3e0f.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
const Ne = { class: "app-container" }, De = { style: { display: "flex", "justify-content": "space-between", "margin-top": "10px" } }, Ze = { __name: "index", setup(je) {
  const A = d([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["commissionTime", ["parse-time", "{y}-{m}-{d}"]]]), L = d({ crmTenderRequirementTypeEnum: B.SETTLEMENT_METHOD.V, crmSpecialBubmissionStatusEnum: b.SPECIAL_PROGRAMS.V }), i = d({}), N = d({}), D = d([]), S = d(false), E = d(false), j = d({}), P = d([]);
  le(() => {
    i.value = Ee(L.value), m(), _(), V();
  });
  const { maxHeight: U } = Ce({ extraBox: [".head-container"], extraHeight: 50, paginate: true }), { handleSizeChange: z, handleCurrentChange: k, total: q, setTotalPage: H, queryPage: f } = Be({ fetchHook: m });
  async function _() {
    try {
      const t = await be({ crmTenderRequirementTypeEnum: i.value.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: i.value.crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum: w.NON_DIRECT.V });
      N.value = t;
    } catch (t) {
      console.log(t);
    }
  }
  async function V() {
    var t;
    try {
      const o = await Se({ crmProjectInformationConfigEnum: we.STRUCTURE_TYPE_CONFIG.V });
      P.value = o && (o != null && o.length) ? (t = o[0]) == null ? void 0 : t.crmProjectInformationConfigDTOS : [];
    } catch (o) {
      console.log(o, "获取结构类型配置列表失败");
    }
  }
  async function m() {
    if (v(T.get)) try {
      const { content: t = [], totalElements: o } = await ve({ ...i.value, ...f, crmSettlementBusinessTypeEnum: w.NON_DIRECT.V });
      console.log(t), H(o), D.value = t.map((s) => (s.homeProvince = s.countryName + s.provinceName + s.cityName + s.regionName, s.originStatus = s.crmProjectBidStatus, s));
    } catch (t) {
      console.log(t);
    }
  }
  function $(t) {
    i.value.departmentId = t, m();
  }
  function G(t) {
    i.value.structureTypeConfigurationId = t, m();
  }
  function W({ startDate: t, endDate: o }) {
    i.value.startDate = t, i.value.endDate = o, m();
  }
  function Y(t) {
    i.value.regionIds = t, m();
  }
  function J(t) {
    i.value.crmTenderRequirementTypeEnum = t, _(), m();
  }
  function Q(t) {
    i.value.crmSpecialBubmissionStatusEnum = t, _(), m();
  }
  function Z(t) {
    i.value = t, i.value.crmTenderRequirementTypeEnum = B.SETTLEMENT_METHOD.V, m();
  }
  function K(t) {
    i.value = t, i.value.crmTenderRequirementTypeEnum = B.SETTLEMENT_METHOD.V, i.value.crmSpecialBubmissionStatusEnum = b.SPECIAL_PROGRAMS.V, f.pageNumber = 1, f.pageSize = 20, m();
  }
  async function X(t, o) {
    try {
      await ce.confirm(`此操作将把 “${t.projectName}” 状态更改为 “${p.VL[o]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const s = { crmProjectInformationWarehousingId: t.id, crmApplyTechnologyBiddingRecordId: t.crmApplyTechnologyBiddingRecordId, crmSpecialBubmissionStatusEnum: t.crmSpecialBubmissionStatusEnum, crmTenderRequirementTypeEnum: t.crmTenderRequirementTypeEnum, crmProjectBidStatus: o };
      await updateBidStatus(s), pe({ title: `“${t.projectName}” 变更为 “${p.VL[o]}” 成功`, type: "success" }), m();
    } catch (s) {
      console.log(s), t.crmProjectBidStatus = t.originStatus;
    }
  }
  function ee(t) {
    S.value = true, j.value = t;
  }
  function te() {
    E.value = true;
  }
  function M() {
    m(), _(), V();
  }
  return (t, o) => {
    const s = y("common-button"), ae = y("print-table"), l = de, R = y("table-cell-tag"), ne = ge, oe = fe, ie = y("common-table"), re = he;
    return h(), x("div", Ne, [a(Te, { "summary-data": N.value, "structure-list": P.value, onDepartmentChange: $, onStructureChange: G, onDateChange: W, onRegionChange: Y, onTenderChange: J, onReportType: Q, onSearchSuccess: Z, onReset: K }, { printBtn: r(() => [u("div", De, [a(s, { size: "default", icon: "el-icon-plus", type: "primary", onClick: te }, { default: r(() => o[2] || (o[2] = [se(" 新增任务 ")])), _: 1, __: [2] }), n(v)(n(T).print) ? (h(), C(ae, { key: 0, "api-key": "organizeBidInfoList", params: { ...i.value, crmSettlementBusinessTypeEnum: n(w).NON_DIRECT.V }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : I("", true)])]), _: 1 }, 8, ["summary-data", "structure-list"]), a(ie, { data: D.value, "data-format": A.value, maxHeight: n(U), "show-empty-symbol": false, style: { width: "100%" } }, { default: r(() => [a(l, { type: "index", align: "center", label: "序号", width: "80", fixed: "left" }), a(l, { align: "center", "show-overflow-tooltip": true, label: "项目登记日期", prop: "informantDateTime", width: "120", fixed: "left" }, { default: r(({ row: e }) => [u("span", null, c(e.informantDateTime || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", "min-width": "160", fixed: "left" }, { default: r(({ row: e }) => [u("span", null, c(e.serialNumber || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", "min-width": "300", fixed: "left" }, { default: r(({ row: e }) => [u("span", null, c(e.projectName || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "建设单位", "min-width": "170", prop: "crmEnterpriseWarehousingName" }, { default: r(({ row: e }) => [u("span", null, c(e.crmEnterpriseWarehousingName || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince", "min-width": "170" }, { default: r(({ row: e }) => [u("span", null, c(e.homeProvince || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", "min-width": "130" }, { default: r(({ row: e }) => [u("span", null, c(e.structureTypeConfigurationName || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "预估造价(万元)", prop: "estimatedCost", "min-width": "130" }, { default: r(({ row: e }) => [u("span", null, c(e.estimatedCost || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", "min-width": "130" }, { default: r(({ row: e }) => [u("span", null, c(e.departmentName || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "登记人", prop: "informantUserName", width: "120" }, { default: r(({ row: e }) => [u("span", null, c(e.informantUserName || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "技术服务委托时间", prop: "commissionTime", width: "120" }), a(l, { align: "center", "show-overflow-tooltip": true, label: "负责人", prop: "projectBidManagerUserName", width: "120", fixed: "right" }, { default: r(({ row: e }) => [u("span", null, c(e.projectBidManagerUserName || "-"), 1)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "计划完成日期", prop: "projectBidManagerFinishDate", width: "120", fixed: "right" }, { default: r(({ row: e }) => [a(R, { show: e.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && e.crmProjectBidStatus === n(p).UNDER_WAY.V, name: "超期", color: e.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && e.crmProjectBidStatus === n(p).UNDER_WAY.V ? "#F56C6C" : "" }, null, 8, ["show", "color"]), u("span", { style: F(`color: ${e.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && e.crmProjectBidStatus === n(p).UNDER_WAY.V ? "#F56C6C" : ""}`) }, c(e.projectBidManagerFinishDate ? n(O)(e.projectBidManagerFinishDate, "{y}-{m}-{d}") : "-"), 5)]), _: 1 }), a(l, { align: "center", "show-overflow-tooltip": true, label: "实际完成日期", prop: "projectBidManagerActualFinishDate", width: "120", fixed: "right" }, { default: r(({ row: e }) => [a(R, { show: e.projectBidManagerFinishDate < e.projectBidManagerActualFinishDate && e.crmProjectBidStatus === n(p).COMPLETED.V, name: "超期", color: e.projectBidManagerFinishDate < e.projectBidManagerActualFinishDate && e.crmProjectBidStatus === n(p).COMPLETED.V ? "#F56C6C" : "" }, null, 8, ["show", "color"]), u("span", { style: F(`color: ${e.projectBidManagerFinishDate < e.projectBidManagerActualFinishDate && e.crmProjectBidStatus === n(p).COMPLETED.V ? "#F56C6C" : ""}`) }, c(e.projectBidManagerActualFinishDate ? n(O)(e.projectBidManagerActualFinishDate, "{y}-{m}-{d}") : "-"), 5)]), _: 1 }), a(l, { key: "status", align: "center", fixed: "right", label: "状态", prop: "crmProjectBidStatus", width: "120" }, { default: r((e) => [a(oe, { disabled: e.row.crmProjectBidStatus === n(p).NOT_APPOINTED.V, modelValue: e.row.crmProjectBidStatus, "onUpdate:modelValue": (g) => e.row.crmProjectBidStatus = g, size: "default", onChange: (g) => X(e.row, e.row.crmProjectBidStatus) }, { default: r(() => [(h(true), x(ue, null, me(n(p).ENUM, (g) => (h(), C(ne, { key: g.V, disabled: g.V === n(p).NOT_APPOINTED.V, label: g.L, value: g.V }, null, 8, ["disabled", "label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), n(v)(n(T).detail) ? (h(), C(l, { key: 0, align: "center", label: "操作", width: "100", fixed: "right" }, { default: r(({ row: e }) => [a(s, { type: "primary", icon: "el-icon-view", onClick: (g) => ee(e) }, null, 8, ["onClick"])]), _: 1 })) : I("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), a(re, { total: n(q), "current-page": n(f).pageNumber, "page-size": n(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(z), onCurrentChange: n(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), a(_e, { modelValue: S.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => S.value = e), "current-row": j.value, crmSpecialBubmissionStatusEnum: j.value.crmSpecialBubmissionStatusEnum, permission: n(T), "tender-type": i.value.crmTenderRequirementTypeEnum, onSuccess: M }, null, 8, ["modelValue", "current-row", "crmSpecialBubmissionStatusEnum", "permission", "tender-type"]), a(ye, { modelValue: E.value, "onUpdate:modelValue": o[1] || (o[1] = (e) => E.value = e), permission: n(T), crmSpecialBubmissionStatusEnum: i.value.crmSpecialBubmissionStatusEnum, onSuccess: M }, null, 8, ["modelValue", "permission", "crmSpecialBubmissionStatusEnum"])]);
  };
} };
export {
  Ze as default
};
