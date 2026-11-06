import { ref as y } from "vue";
import { watch as ye } from "vue";
import { resolveComponent as F } from "vue";
import { resolveDirective as Re } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as Ce } from "vue";
import { createElementVNode as T } from "vue";
import { unref as l } from "vue";
import { createBlock as E } from "vue";
import { createCommentVNode as g } from "vue";
import { createVNode as u } from "vue";
import { withKeys as z } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as S } from "vue";
import { withDirectives as $ } from "vue";
import { renderSlot as H } from "vue";
import { ElNotification as G } from "element-plus";
import { ElDatePicker as ve } from "element-plus";
import { ElInput as ge } from "element-plus";
import { ElCol as _e } from "element-plus";
import { ElRow as Ie } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { ElPopconfirm as be } from "element-plus";
import { ElPagination as Ee } from "element-plus";
import { vLoading as he } from "element-plus";
import { dA as d, lN as R, o as Oe, G as k, I as Te } from "../../../../shared/runtime.js";
import { g as ke, a as we, b as De, c as Fe, d as Se, e as Ge, f as Ve, h as Ae, i as Pe, j as Me, k as Ke, l as Ue } from "../../../../modules/use-form-data-13311836.js";
import xe from "../module/record-form.vue.js";
import { P as V } from "../../../../modules/index-5b9e6004.js";
import { _ as Le } from "../../../../modules/basics-config-select-53b77c54.js";
import "../../../../modules/project-information-053c195b.js";
import "../../../../modules/use-crm-basics-c35b230b.js";
import "../../../../modules/use-crm-user-tree-f2f683a5.js";
import "../../../../modules/use-crm-project-information-18afe991.js";
import "./firm-information-dialog.vue.js";
import "./form-box.vue.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
function ze() {
  const m = y([]), s = y({}), e = y(0);
  async function h({ props: n, params: i }) {
    let r = {};
    try {
      switch (console.log(n == null ? void 0 : n.tabType, "qoiwueioqwu"), n == null ? void 0 : n.tabType) {
        case d.FIRM_RECORD_CONFIG.K:
          r = await C();
          break;
        case d.GOVERNMENT_RECORD_CONFIG.K:
          r = await _(i);
          break;
        case d.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
          r = await A(i);
          break;
        case d.SUPPLIER_INTO_RECORD_CONFIG.K:
          r = await I(i);
          break;
      }
      s.value = r;
    } catch (f) {
      throw console.log(f, "获取汇总数据"), f;
    }
  }
  async function C() {
    try {
      return await ke();
    } catch (n) {
      console.log(n);
    }
  }
  async function _(n) {
    try {
      return await we({ checkRecord: n.checkRecord });
    } catch (i) {
      console.log(i);
    }
  }
  async function A(n) {
    try {
      return await De({ checkRecord: n.checkRecord });
    } catch (i) {
      console.log(i);
    }
  }
  async function I(n) {
    try {
      return await Fe({ checkRecord: n.checkRecord });
    } catch (i) {
      console.log(i);
    }
  }
  async function O({ props: n, params: i }) {
    let r = [];
    try {
      switch (n == null ? void 0 : n.tabType) {
        case d.FIRM_RECORD_CONFIG.K:
          r = await N(i);
          break;
        case d.GOVERNMENT_RECORD_CONFIG.K:
          r = await P(i);
          break;
        case d.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
          r = await M(i);
          break;
        case d.SUPPLIER_INTO_RECORD_CONFIG.K:
          r = await K(i);
          break;
      }
      m.value = r;
    } catch (f) {
      console.log(f);
    }
  }
  async function N(n) {
    try {
      const { content: i, totalElements: r } = await Se({ ...n });
      return e.value = r, i.map((c) => (c.provinceCity = c.provinceName + c.cityName, c));
    } catch (i) {
      console.log(i);
    }
  }
  async function P(n) {
    try {
      const { content: i, totalElements: r } = await Ge({ ...n });
      return e.value = r, i.map((c) => (c.provinceCity = c.provinceName + c.cityName, c));
    } catch (i) {
      console.log(i);
    }
  }
  async function M(n) {
    try {
      const { content: i, totalElements: r } = await Ve({ ...n });
      return e.value = r, i.map((c) => (c.provinceCity = c.provinceName + c.cityName, c));
    } catch (i) {
      console.log(i);
    }
  }
  async function K(n) {
    try {
      const { content: i, totalElements: r } = await Ae({ ...n });
      return e.value = r, i.map((c) => (c.provinceCity = c.provinceName + c.cityName, c));
    } catch (i) {
      console.log(i);
    }
  }
  return { tableData: m, dataCollect: s, total: e, fetchSummaryData: h, fetchTableData: O };
}
const $e = { class: "head-container" }, Be = { style: { "margin-top": "20px" } }, qe = { style: { float: "right" } }, ut = { __name: "main-content", props: { tabType: { type: String, default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(m) {
  const s = m, e = y({ pageNumber: 1, pageSize: 20, crmCheckStatusEnum: void 0, date: [], startDate: void 0, endDate: void 0, unitClassConfigurationId: void 0, unitPropertyAllocationConfigId: void 0, unitReputationAllocationConfigId: void 0, industryConfigurationId: void 0, businessName: void 0, creditCode: void 0, informantUserName: void 0, checkRecord: R.UN_RECORD.V }), h = y(false), C = y(false), _ = y(), A = y([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["deadlineForAcceptanceTime", ["parse-time", "{y}-{m}-{d}"]]]), I = y(true), O = y({}), { dataCollect: N, total: P, tableData: M, fetchSummaryData: K, fetchTableData: n } = ze();
  ye(() => s.tabType, () => {
    r();
  }, { immediate: true });
  const { maxHeight: i } = Oe({ extraBox: [".head-container"], extraHeight: 70, paginate: true });
  async function r() {
    if (k(s.permission.get)) {
      await K({ props: s, params: e.value });
      try {
        h.value = true, await n({ props: s, params: e.value });
      } catch (o) {
        console.log(o);
      } finally {
        h.value = false;
      }
    }
  }
  function f(o) {
    e.value.pageNumber = 1, e.value.pageSize = o, n({ props: s, params: e.value });
  }
  function c(o) {
    e.value.pageNumber = o, n({ props: s, params: e.value });
  }
  function j(o) {
    n({ props: s, params: e.value });
  }
  function J(o) {
    n({ props: s, params: e.value });
  }
  function Q(o) {
    n({ props: s, params: e.value });
  }
  function W(o) {
    n({ props: s, params: e.value });
  }
  function X(o) {
    (o == null ? void 0 : o.length) > 0 ? (e.value.startDate = o[0], e.value.endDate = o[1]) : (e.value.startDate = void 0, e.value.endDate = void 0), n({ props: s, params: e.value });
  }
  function Y() {
    C.value = true, _.value = "新增备案", I.value = true;
  }
  function Z(o) {
    O.value = o, C.value = true, I.value = false, _.value = "查看备案";
  }
  function ee(o) {
    C.value = true, _.value = "任务认领", I.value = true, O.value = o;
  }
  function te() {
    const o = e.value.checkRecord;
    e.value = { pageNumber: 1, pageSize: 20, crmCheckStatusEnum: void 0, date: [], startDate: void 0, endDate: void 0, unitClassConfigurationId: void 0, unitPropertyAllocationConfigId: void 0, unitReputationAllocationConfigId: void 0, industryConfigurationId: void 0, businessName: void 0, creditCode: void 0, informantUserName: void 0, checkRecord: o }, n({ props: s, params: e.value });
  }
  async function ae(o) {
    switch (s.tabType) {
      case d.FIRM_RECORD_CONFIG.K:
        await ne(o);
        break;
      case d.GOVERNMENT_RECORD_CONFIG.K:
        await oe(o);
        break;
      case d.PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K:
        await ie(o);
        break;
      case d.SUPPLIER_INTO_RECORD_CONFIG.K:
        await le(o);
        break;
    }
  }
  async function ne(o) {
    try {
      await Pe({ id: o.id }), G({ title: "删除成功", type: "success", duration: 2500 }), r();
    } catch (t) {
      console.log("删除企业备案失败", t);
    }
  }
  async function oe(o) {
    try {
      await Me({ id: o.id }), G({ title: "删除成功", type: "success", duration: 2500 }), r();
    } catch (t) {
      console.log("删除政府备案失败", t);
    }
  }
  async function ie(o) {
    try {
      await Ke({ id: o.id }), G({ title: "删除成功", type: "success", duration: 2500 }), r();
    } catch (t) {
      console.log("删除平台注册失败", t);
    }
  }
  async function le(o) {
    try {
      await Ue({ id: o.id }), G({ title: "删除成功", type: "success", duration: 2500 }), r();
    } catch (t) {
      console.log("删除供应商备案失败", t);
    }
  }
  return (o, t) => {
    var q;
    const re = F("common-radio-button"), ue = ve, U = ge, b = F("common-button"), w = _e, se = Ie, ce = F("print-table"), x = Ne, de = be, me = F("common-table"), pe = Ee, B = Re("permission"), fe = he;
    return v(), Ce("div", null, [T("div", $e, [T("div", null, [s.tabType !== l(d).FIRM_RECORD_CONFIG.K ? (v(), E(re, { key: 0, modelValue: e.value.checkRecord, "onUpdate:modelValue": t[0] || (t[0] = (a) => e.value.checkRecord = a), options: l(R).ENUM, type: "enum", class: "filter-item", onChange: t[1] || (t[1] = (a) => r()) }, null, 8, ["modelValue", "options"])) : g("", true), u(ue, { class: "filter-item", type: "daterange", "value-format": "x", shortcuts: l(Te), modelValue: e.value.date, "onUpdate:modelValue": t[2] || (t[2] = (a) => e.value.date = a), "start-placeholder": "开始日期", "end-placeholder": "结束日期", onChange: X }, null, 8, ["shortcuts", "modelValue"]), u(Le, { firmNatureId: e.value.unitClassConfigurationId, "onUpdate:firmNatureId": t[3] || (t[3] = (a) => e.value.unitClassConfigurationId = a), firmTypeId: e.value.unitPropertyAllocationConfigId, "onUpdate:firmTypeId": t[4] || (t[4] = (a) => e.value.unitPropertyAllocationConfigId = a), industryId: e.value.industryConfigurationId, "onUpdate:industryId": t[5] || (t[5] = (a) => e.value.industryConfigurationId = a), corporateRepurationId: e.value.unitReputationAllocationConfigId, "onUpdate:corporateRepurationId": t[6] || (t[6] = (a) => e.value.unitReputationAllocationConfigId = a), onFirmNatureChange: j, onFirmTypeChange: J, onIndustryChange: Q, onCorporateRepurationChange: W, firmNatureClearable: "", corporateRepurationClearable: "", firmTypeClearable: "", industryClearable: "" }, null, 8, ["firmNatureId", "firmTypeId", "industryId", "corporateRepurationId"])]), T("div", null, [u(U, { modelValue: e.value.businessName, "onUpdate:modelValue": t[7] || (t[7] = (a) => e.value.businessName = a), class: "filter-item", style: { width: "210px" }, placeholder: "企业名称搜索", clearable: "", onKeyup: z(r, ["enter"]) }, null, 8, ["modelValue"]), u(U, { modelValue: e.value.creditCode, "onUpdate:modelValue": t[8] || (t[8] = (a) => e.value.creditCode = a), class: "filter-item", style: { width: "210px" }, placeholder: "社会统一信用代码搜索", clearable: "", onKeyup: z(r, ["enter"]) }, null, 8, ["modelValue"]), u(U, { modelValue: e.value.informantUserName, "onUpdate:modelValue": t[9] || (t[9] = (a) => e.value.informantUserName = a), class: "filter-item", style: { width: "210px" }, placeholder: "登记人搜索", clearable: "", onKeyup: z(r, ["enter"]) }, null, 8, ["modelValue"]), u(b, { class: "filter-item", type: "success", icon: "el-icon-search", onClick: t[10] || (t[10] = (a) => r()) }, { default: p(() => t[13] || (t[13] = [S(" 搜索 ")])), _: 1, __: [13] }), u(b, { class: "filter-item", type: "warning", icon: "el-icon-refresh-left", onClick: te }, { default: p(() => t[14] || (t[14] = [S(" 重置 ")])), _: 1, __: [14] })]), u(se, { gutter: 20 }, { default: p(() => [u(w, { span: 6 }, { default: p(() => {
      var a;
      return [u(l(V), { name: "企业数量", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((a = l(N)) == null ? void 0 : a.enterprisesCount) || 0 }, null, 8, ["end-val"])];
    }), _: 1 }), u(w, { span: 6 }, { default: p(() => {
      var a;
      return [u(l(V), { name: "国内", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((a = l(N)) == null ? void 0 : a.domesticEnterprisesCount) || 0 }, null, 8, ["end-val"])];
    }), _: 1 }), u(w, { span: 6 }, { default: p(() => {
      var a;
      return [u(l(V), { name: "国外", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((a = l(N)) == null ? void 0 : a.foreignEnterprisesCount) || 0 }, null, 8, ["end-val"])];
    }), _: 1 }), u(w, { span: 6 }, { default: p(() => {
      var a;
      return [u(l(V), { name: "未审核", "text-color": "#626262", "num-color": "#1890ff", "end-val": ((a = l(N)) == null ? void 0 : a.unauditedCount) || 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 }), T("div", Be, [s.tabType === l(d).FIRM_RECORD_CONFIG.K && l(k)(m.permission.add) ? (v(), E(b, { key: 0, icon: "el-icon-plus", type: "success", class: "filter-item", onClick: Y }, { default: p(() => t[15] || (t[15] = [S(" 新增备案 ")])), _: 1, __: [15] })) : g("", true), T("div", qe, [e.value.checkRecord !== l(R).UN_RECORD.V && l(k)((q = m.permission) == null ? void 0 : q.print) ? (v(), E(ce, { key: 0, "api-key": m.tabType === l(d).FIRM_RECORD_CONFIG.K ? "businessBidReport" : m.tabType === l(d).GOVERNMENT_RECORD_CONFIG.K ? "governmentReport" : m.tabType === l(d).PLATFORM_REGISTRATION_RECORD_PAGE_MANAGEMENT.K ? "platFormReport" : m.tabType === l(d).SUPPLIER_INTO_RECORD_CONFIG.K ? "supplierReport" : "", params: { ...e.value }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["api-key", "params"])) : g("", true)])])]), $((v(), E(me, { style: { width: "100%" }, data: l(M), "show-empty-symbol": true, "max-height": e.value.checkRecord === l(R).RECORD.V ? l(i) - 40 : l(i), "data-format": A.value, "empty-text": l(k)(m.permission.get) ? "暂无数据" : "暂无权限" }, { default: p(() => [u(x, { type: "index", label: "序号", align: "center", width: "60" }), e.value.checkRecord === l(R).RECORD.V || s.tabType === l(d).FIRM_RECORD_CONFIG.K ? H(o.$slots, "tableColumn", { key: 0 }) : g("", true), e.value.checkRecord === l(R).UN_RECORD.V ? H(o.$slots, "taskColumn", { key: 1 }) : g("", true), e.value.checkRecord === l(R).UN_RECORD.V && s.tabType !== l(d).FIRM_RECORD_CONFIG.K && l(k)(m.permission.addTask) ? (v(), E(x, { key: 2, label: "操作", align: "center", width: "120" }, { default: p(({ row: a }) => [u(b, { link: "", type: "primary", size: "default", onClick: (L) => ee(a) }, { default: p(() => t[16] || (t[16] = [S("确认认领")])), _: 2, __: [16] }, 1032, ["onClick"])]), _: 1 })) : g("", true), e.value.checkRecord === l(R).RECORD.V || s.tabType === l(d).FIRM_RECORD_CONFIG.K ? (v(), E(x, { key: 3, label: "操作", align: "center", width: "120" }, { default: p(({ row: a }) => {
      var L;
      return [$(u(b, { icon: "el-icon-view", type: "primary", size: "default", onClick: (D) => Z(a) }, null, 8, ["onClick"]), [[B, (L = m.permission) == null ? void 0 : L.detail]]), u(de, { title: "确定删除此条数据么", onConfirm: (D) => ae(a) }, { reference: p(() => {
        var D;
        return [$(u(b, { icon: "el-icon-delete", type: "danger", size: "default" }, null, 512), [[B, (D = m.permission) == null ? void 0 : D.del]])];
      }), _: 2 }, 1032, ["onConfirm"])];
    }), _: 1 })) : g("", true)]), _: 3 }, 8, ["data", "max-height", "data-format", "empty-text"])), [[fe, h.value]]), u(pe, { total: l(P), "current-page": e.value.pageNumber, "page-size": e.value.pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: f, onCurrentChange: c }, null, 8, ["total", "current-page", "page-size"]), u(xe, { modelValue: C.value, "onUpdate:modelValue": t[11] || (t[11] = (a) => C.value = a), title: _.value, tabType: m.tabType, "is-add": I.value, currentRow: O.value, permission: m.permission, onSuccess: t[12] || (t[12] = (a) => r()) }, null, 8, ["modelValue", "title", "tabType", "is-add", "currentRow", "permission"])]);
  };
} };
export {
  ut as default
};
