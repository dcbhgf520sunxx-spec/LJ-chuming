import { ref as s } from "vue";
import { onMounted as X } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as Z } from "vue";
import { createVNode as t } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as T } from "vue";
import { unref as n } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as w } from "vue";
import { createTextVNode as ee } from "vue";
import { ElTableColumn as te } from "element-plus";
import { ElTag as ne } from "element-plus";
import { ElPagination as ae } from "element-plus";
import oe from "./module/header.vue.js";
import re from "./module/detail.vue.js";
import { g as ie } from "../../../../modules/project-config-3fa4f850.js";
import { V as le, o as ue, J as me, lJ as se, dE as ce, G as S, lK as pe, lq as h, lF as de, dH as ge, lt as _ } from "../../../../shared/runtime.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/use-form-config-data-098a0552.js";
import "../../../../modules/project-information-053c195b.js";
import "../information-description/index.vue.js";
const fe = { class: "app-container" }, he = { style: { float: "right", "margin-top": "10px" } }, Pe = { __name: "index", props: { moduleType: { type: Number, default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(u) {
  const y = u, R = s([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["projectBidManagerFinishDate", ["parse-time", "{y}-{m}-{d}"]]]), j = s({ crmTenderRequirementTypeEnum: y.moduleType }), o = s({}), x = s({}), N = s([]), v = s(false), D = s({}), V = s([]);
  X(() => {
    o.value = le(j.value), l(), E(), P();
  });
  const { maxHeight: k } = ue({ extraBox: [".head-container"], extraHeight: 50, paginate: true }), { handleSizeChange: L, handleCurrentChange: M, total: q, setTotalPage: H, queryPage: d } = me({ fetchHook: l });
  async function E() {
    try {
      const e = await se({ crmTenderRequirementTypeEnum: o.value.crmTenderRequirementTypeEnum });
      x.value = e;
    } catch (e) {
      console.log(e);
    }
  }
  async function P() {
    var e;
    try {
      const r = await ie({ crmProjectInformationConfigEnum: ce.STRUCTURE_TYPE_CONFIG.V });
      V.value = r && (r != null && r.length) ? (e = r[0]) == null ? void 0 : e.crmProjectInformationConfigDTOS : [];
    } catch (r) {
      console.log(r, "获取结构类型配置列表失败");
    }
  }
  async function l() {
    if (S(y.permission.get)) try {
      const { content: e = [], totalElements: r } = await pe({ ...o.value, ...d });
      console.log(e), H(r), N.value = e.map((m) => (m.homeProvince = m.countryName + m.provinceName + m.cityName + m.regionName, m));
    } catch (e) {
      console.log(e);
    }
  }
  function z(e) {
    o.value.departmentId = e, l();
  }
  function I(e) {
    o.value.structureTypeConfigurationId = e, l();
  }
  function O({ startDate: e, endDate: r }) {
    o.value.startDate = e, o.value.endDate = r, l();
  }
  function U(e) {
    o.value.regionIds = e, l();
  }
  function F(e) {
    o.value.crmTenderRequirementTypeEnum = e, E(), l();
  }
  function G(e) {
    o.value = e, o.value.crmTenderRequirementTypeEnum = y.moduleType, l();
  }
  function Y(e) {
    o.value = e, o.value.crmTenderRequirementTypeEnum = y.moduleType, d.pageNumber = 1, d.pageSize = 20, l();
  }
  function J(e) {
    v.value = true, D.value = e;
  }
  function W() {
    l(), E(), P();
  }
  return (e, r) => {
    const m = C("print-table"), a = te, $ = ne, A = C("common-button"), K = C("common-table"), Q = ae;
    return p(), Z("div", fe, [t(oe, { "summary-data": x.value, moduleType: u.moduleType, "structure-list": V.value, onDepartmentChange: z, onStructureChange: I, onDateChange: O, onRegionChange: U, onTenderChange: F, onSearchSuccess: G, onReset: Y }, { printBtn: c(() => [T("div", he, [n(S)(u.permission.print) ? (p(), g(m, { key: 0, "api-key": "myProjectList", params: { ...o.value }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : f("", true)])]), _: 1 }, 8, ["summary-data", "moduleType", "structure-list"]), t(K, { data: N.value, "data-format": R.value, maxHeight: n(k), style: { width: "100%" } }, { default: c(() => [t(a, { type: "index", align: "center", label: "序号", width: "70", fixed: "left" }), u.moduleType === n(h).SETTLEMENT_METHOD.V ? (p(), g(a, { key: 0, align: "center", "show-overflow-tooltip": true, label: "来源", prop: "crmSpecialBubmissionStatusEnum", width: "120", fixed: "left" }, { default: c(({ row: i }) => [T("span", null, w(n(de).VL[i.crmSettlementBusinessTypeEnum] || ""), 1)]), _: 1 })) : f("", true), u.moduleType === n(h).SETTLEMENT_METHOD.V ? (p(), g(a, { key: 1, align: "center", "show-overflow-tooltip": true, label: "类型", prop: "crmSpecialBubmissionStatusEnum", width: "120", fixed: "left" }, { default: c(({ row: i }) => [T("span", null, w(n(ge).VL[i.crmSpecialBubmissionStatusEnum] || ""), 1)]), _: 1 })) : f("", true), u.moduleType !== n(h).BIDDING_METHOD.V && u.moduleType !== n(h).SETTLEMENT_METHOD.V ? (p(), g(a, { key: 2, align: "center", "show-overflow-tooltip": true, label: "标书类型", prop: "crmTenderRequirementTypeEnum", width: "120", fixed: "left" }, { default: c(({ row: i }) => [T("span", null, w(n(h).VL[i.crmTenderRequirementTypeEnum] || ""), 1)]), _: 1 })) : f("", true), t(a, { align: "center", "show-overflow-tooltip": true, label: "项目登记日期", prop: "informantDateTime", width: "120", fixed: "left" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", "min-width": "160", fixed: "left" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", "min-width": "160", fixed: "left" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "建设单位", prop: "crmEnterpriseWarehousingName", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "homeProvince", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "预估造价(万元)", prop: "estimatedCost", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "登记人", prop: "informantUserName", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "负责人", prop: "projectBidManagerUserName", "min-width": "130" }), t(a, { align: "center", "show-overflow-tooltip": true, label: "完成日期", prop: "projectBidManagerFinishDate", "min-width": "130" }), t(a, { align: "center", label: "状态", prop: "crmProjectBidStatus", width: "140", fixed: "right" }, { default: c(({ row: i }) => {
      var b;
      return [t($, { type: (b = n(_).V[i.crmProjectBidStatus]) == null ? void 0 : b.TYPE }, { default: c(() => {
        var B;
        return [ee(w(((B = n(_).V[i.crmProjectBidStatus]) == null ? void 0 : B.L) || n(_).UNDER_WAY.L), 1)];
      }), _: 2 }, 1032, ["type"])];
    }), _: 1 }), n(S)(u.permission.detail) ? (p(), g(a, { key: 3, align: "center", label: "操作", width: "100", fixed: "right" }, { default: c(({ row: i }) => [t(A, { type: "primary", icon: "el-icon-view", onClick: (b) => J(i) }, null, 8, ["onClick"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), t(Q, { total: n(q), "current-page": n(d).pageNumber, "page-size": n(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(L), onCurrentChange: n(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), t(re, { modelValue: v.value, "onUpdate:modelValue": r[0] || (r[0] = (i) => v.value = i), "current-row": D.value, permission: u.permission, "tender-type": o.value.crmTenderRequirementTypeEnum, onSuccess: W }, null, 8, ["modelValue", "current-row", "permission", "tender-type"])]);
  };
} };
export {
  Pe as default
};
