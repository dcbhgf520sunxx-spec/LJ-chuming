import { ref as u } from "vue";
import { onMounted as re } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as n } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as E } from "vue";
import { unref as a } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as M } from "vue";
import { normalizeStyle as R } from "vue";
import { toDisplayString as x } from "vue";
import { Fragment as ie } from "vue";
import { renderList as le } from "vue";
import { ElMessageBox as se } from "element-plus";
import { ElNotification as ce } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElOption as ue } from "element-plus";
import { ElSelect as pe } from "element-plus";
import { ElPagination as de } from "element-plus";
import ge from "./module/header.vue.js";
import he from "./module/detail.vue.js";
import { g as fe } from "../../../../modules/project-config-3fa4f850.js";
import { lq as _, dH as C, V as Te, o as ye, J as Ee, lr as Se, lF as B, dE as _e, G as w, ls as Ce, lt as c, p as F, lM as Be } from "../../../../shared/runtime.js";
import { e as T } from "../../../../modules/crm-c6ba92ff.js";
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
const we = { class: "app-container" }, be = { style: { float: "right", "margin-top": "10px" } }, We = { __name: "index", setup(ve) {
  const I = u([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["commissionTime", ["parse-time", "{y}-{m}-{d}"]]]), A = u({ crmTenderRequirementTypeEnum: _.SETTLEMENT_METHOD.V, crmSpecialBubmissionStatusEnum: C.SPECIAL_PROGRAMS.V }), o = u({}), b = u({}), v = u([]), y = u(false), D = u({}), P = u([]);
  re(() => {
    o.value = Te(A.value), s(), h(), j();
  });
  const { maxHeight: L } = ye({ extraBox: [".head-container"], extraHeight: 50, paginate: true }), { handleSizeChange: O, handleCurrentChange: q, total: k, setTotalPage: U, queryPage: d } = Ee({ fetchHook: s });
  async function h() {
    try {
      const e = await Se({ crmTenderRequirementTypeEnum: o.value.crmTenderRequirementTypeEnum, crmSpecialBubmissionStatusEnum: o.value.crmSpecialBubmissionStatusEnum, crmSettlementBusinessTypeEnum: B.DIRECT.V });
      b.value = e;
    } catch (e) {
      console.log(e);
    }
  }
  async function j() {
    var e;
    try {
      const r = await fe({ crmProjectInformationConfigEnum: _e.STRUCTURE_TYPE_CONFIG.V });
      P.value = r && (r != null && r.length) ? (e = r[0]) == null ? void 0 : e.crmProjectInformationConfigDTOS : [];
    } catch (r) {
      console.log(r, "获取结构类型配置列表失败");
    }
  }
  async function s() {
    if (w(T.get)) try {
      const { content: e = [], totalElements: r } = await Ce({ ...o.value, ...d, crmSettlementBusinessTypeEnum: B.DIRECT.V });
      console.log(e), U(r), v.value = e.map((l) => (l.homeProvince = l.countryName + l.provinceName + l.cityName + l.regionName, l.originStatus = l.crmProjectBidStatus, l));
    } catch (e) {
      console.log(e);
    }
  }
  function z(e) {
    o.value.departmentId = e, s();
  }
  function H(e) {
    o.value.structureTypeConfigurationId = e, s();
  }
  function $({ startDate: e, endDate: r }) {
    o.value.startDate = e, o.value.endDate = r, s();
  }
  function G(e) {
    o.value.regionIds = e, s();
  }
  function W(e) {
    o.value.crmTenderRequirementTypeEnum = e, h(), s();
  }
  function Y(e) {
    o.value.crmSpecialBubmissionStatusEnum = e, h(), s();
  }
  function J(e) {
    o.value = e, o.value.crmTenderRequirementTypeEnum = _.SETTLEMENT_METHOD.V, s();
  }
  function Q(e) {
    o.value = e, o.value.crmTenderRequirementTypeEnum = _.SETTLEMENT_METHOD.V, o.value.crmSpecialBubmissionStatusEnum = C.SPECIAL_PROGRAMS.V, d.pageNumber = 1, d.pageSize = 20, s();
  }
  async function Z(e, r) {
    try {
      await se.confirm(`此操作将把 “${e.projectName}” 状态更改为 “${c.VL[r]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const l = { crmProjectInformationWarehousingId: e.id, crmApplyTechnologyBiddingRecordId: e.crmApplyTechnologyBiddingRecordId, crmSpecialBubmissionStatusEnum: e.crmSpecialBubmissionStatusEnum, crmTenderRequirementTypeEnum: e.crmTenderRequirementTypeEnum, crmProjectBidStatus: r };
      await Be(l), ce({ title: `“${e.projectName}” 变更为 “${c.VL[r]}” 成功`, type: "success" }), s();
    } catch (l) {
      console.log(l), e.crmProjectBidStatus = e.originStatus;
    }
  }
  function K(e) {
    y.value = true, D.value = e;
  }
  function X() {
    s(), h(), j();
  }
  return (e, r) => {
    const l = f("print-table"), i = me, V = f("table-cell-tag"), ee = ue, te = pe, ae = f("common-button"), ne = f("common-table"), oe = de;
    return g(), N("div", we, [n(ge, { "summary-data": b.value, "structure-list": P.value, onDepartmentChange: z, onStructureChange: H, onDateChange: $, onRegionChange: G, onTenderChange: W, onReportType: Y, onSearchSuccess: J, onReset: Q }, { printBtn: p(() => {
      var t;
      return [E("div", be, [a(w)((t = a(T)) == null ? void 0 : t.print) ? (g(), S(l, { key: 0, "api-key": "specificalBidInfoList", params: { ...o.value, crmSettlementBusinessTypeEnum: a(B).DIRECT.V }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : M("", true)])];
    }), _: 1 }, 8, ["summary-data", "structure-list"]), n(ne, { data: v.value, "data-format": I.value, maxHeight: a(L), "show-empty-symbol": false, style: { width: "100%" } }, { default: p(() => [n(i, { type: "index", align: "center", label: "序号", width: "80", fixed: "left" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "项目登记日期", prop: "informantDateTime", width: "120", fixed: "left" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", "min-width": "160", fixed: "left" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", "min-width": "300", fixed: "left" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "建设单位", "min-width": "170", prop: "crmEnterpriseWarehousingName" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince", "min-width": "170" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", "min-width": "130" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "预估造价(万元)", prop: "estimatedCost", "min-width": "130" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", "min-width": "130" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "登记人", prop: "informantUserName", width: "120" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "技术服务委托时间", prop: "commissionTime", width: "120" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "负责人", prop: "projectBidManagerUserName", width: "120", fixed: "right" }), n(i, { align: "center", "show-overflow-tooltip": true, label: "计划完成日期", prop: "projectBidManagerFinishDate", width: "120", fixed: "right" }, { default: p(({ row: t }) => [n(V, { show: t.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && t.crmProjectBidStatus === a(c).UNDER_WAY.V, name: "超期", color: t.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && t.crmProjectBidStatus === a(c).UNDER_WAY.V ? "#F56C6C" : "" }, null, 8, ["show", "color"]), E("span", { style: R(`color: ${t.projectBidManagerFinishDate < (/* @__PURE__ */ new Date()).getTime() && t.crmProjectBidStatus === a(c).UNDER_WAY.V ? "#F56C6C" : ""}`) }, x(t.projectBidManagerFinishDate ? a(F)(t.projectBidManagerFinishDate, "{y}-{m}-{d}") : "-"), 5)]), _: 1 }), n(i, { align: "center", "show-overflow-tooltip": true, label: "实际完成日期", prop: "projectBidManagerActualFinishDate", width: "120", fixed: "right" }, { default: p(({ row: t }) => [n(V, { show: t.projectBidManagerFinishDate < t.projectBidManagerActualFinishDate && t.crmProjectBidStatus === a(c).COMPLETED.V, name: "超期", color: t.projectBidManagerFinishDate < t.projectBidManagerActualFinishDate && t.crmProjectBidStatus === a(c).COMPLETED.V ? "#F56C6C" : "" }, null, 8, ["show", "color"]), E("span", { style: R(`color: ${t.projectBidManagerFinishDate < t.projectBidManagerActualFinishDate && t.crmProjectBidStatus === a(c).COMPLETED.V ? "#F56C6C" : ""}`) }, x(t.projectBidManagerActualFinishDate ? a(F)(t.projectBidManagerActualFinishDate, "{y}-{m}-{d}") : "-"), 5)]), _: 1 }), n(i, { key: "status", align: "center", fixed: "right", label: "状态", prop: "crmProjectBidStatus", width: "120" }, { default: p((t) => [n(te, { disabled: t.row.crmProjectBidStatus === a(c).NOT_APPOINTED.V, modelValue: t.row.crmProjectBidStatus, "onUpdate:modelValue": (m) => t.row.crmProjectBidStatus = m, size: "default", onChange: (m) => Z(t.row, t.row.crmProjectBidStatus) }, { default: p(() => [(g(true), N(ie, null, le(a(c).ENUM, (m) => (g(), S(ee, { key: m.V, disabled: m.V === a(c).NOT_APPOINTED.V, label: m.L, value: m.V }, null, 8, ["disabled", "label", "value"]))), 128))]), _: 2 }, 1032, ["disabled", "modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), a(w)(a(T).detail) ? (g(), S(i, { key: 0, align: "center", label: "操作", width: "100", fixed: "right" }, { default: p(({ row: t }) => [n(ae, { type: "primary", icon: "el-icon-view", onClick: (m) => K(t) }, null, 8, ["onClick"])]), _: 1 })) : M("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), n(oe, { total: a(k), "current-page": a(d).pageNumber, "page-size": a(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(O), onCurrentChange: a(q) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), n(he, { modelValue: y.value, "onUpdate:modelValue": r[0] || (r[0] = (t) => y.value = t), "current-row": D.value, crmSpecialBubmissionStatusEnum: D.value.crmSpecialBubmissionStatusEnum, permission: a(T), "tender-type": o.value.crmTenderRequirementTypeEnum, onSuccess: X }, null, 8, ["modelValue", "current-row", "crmSpecialBubmissionStatusEnum", "permission", "tender-type"])]);
  };
} };
export {
  We as default
};
