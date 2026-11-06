import { ref as r } from "vue";
import { computed as te } from "vue";
import { watch as G } from "vue";
import { nextTick as he } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as c } from "vue";
import { createBlock as b } from "vue";
import { unref as a } from "vue";
import { useStore as be } from "vuex";
import { onMounted as Ce } from "vue";
import { createElementBlock as z } from "vue";
import { createElementVNode as $ } from "vue";
import { createVNode as n } from "vue";
import { withKeys as ee } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as A } from "vue";
import { withDirectives as Ve } from "vue";
import { toDisplayString as Y } from "vue";
import { ElDatePicker as we } from "element-plus";
import { ElInput as _e } from "element-plus";
import { ElTableColumn as Ee } from "element-plus";
import { ElTag as je } from "element-plus";
import { ElPagination as Te } from "element-plus";
import { vLoading as Se } from "element-plus";
import { i as ke, b as M, dE as H, ai as Ne, _ as Pe, o as Ie, J as xe, G as E, lO as L, lI as Ue, a9 as ze, lv as O } from "../../../../shared/runtime.js";
import { c as Le } from "../../../../modules/project-information-053c195b.js";
import { u as Oe } from "../../../../modules/use-crm-project-information-18afe991.js";
import Re from "../module/assignment-drawer.vue.js";
import Be from "../module/record-form.vue.js";
import { g as De } from "../../../../modules/project-config-3fa4f850.js";
import Fe from "../module/project-follow-up.vue.js";
import "../components/UploadList.vue.js";
import "../../../../modules/use-form-data-13311836.js";
import "../../../../modules/use-crm-basics-c35b230b.js";
import "../../../../modules/use-crm-user-tree-f2f683a5.js";
import "../components/firm-information-dialog.vue.js";
import "../components/form-box.vue.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/project-information-ad6c6e75.js";
import "../components/tabular-information.vue.js";
import "../../components/information-description/index.vue.js";
const $e = { __name: "information-config-select", props: { modelValue: { type: [Number, String, Array] }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, crmProjectInformationConfigEnum: { type: [Number, String] } }, emits: ["change", "info-change", "update:modelValue"], setup(g, { emit: P }) {
  const I = P, i = g, v = r(), o = r([]), R = r({}), C = r(false), V = te(() => o.value);
  G(() => i.modelValue, (u) => {
    v.value = u;
  }, { immediate: true }), G(() => i.crmProjectInformationConfigEnum, (u) => {
    j();
  }, { immediate: true }), j();
  async function j() {
    var u;
    o.value = [];
    try {
      C.value = false;
      const l = await De({ crmProjectInformationConfigEnum: i.crmProjectInformationConfigEnum });
      o.value = ((u = l[0]) == null ? void 0 : u.crmProjectInformationConfigDTOS) || [], x();
    } catch (l) {
      console.log(l);
    } finally {
      C.value = true;
    }
  }
  function w(u) {
    let l = u;
    M(l) && (l = void 0);
    const y = !Ne(l, i.modelValue), _ = M(l) && M(i.modelValue);
    y && !_ && (I("update:modelValue", l), I("change", l), T(l, i.modelValue));
  }
  function T(u, l) {
    const y = u ? R.value[u] : null, _ = l ? R.value[l] : null;
    I("info-change", y, _);
  }
  function x() {
    ke(v.value) ? T(v.value) : B();
  }
  function B() {
    he(() => {
      if (!(M(V.value) || v.value) && i.default) {
        v.value = V.value[0].id, w(v.value);
        return;
      }
    });
  }
  return (u, l) => {
    const y = N("common-select");
    return c(), b(y, { modelValue: v.value, "onUpdate:modelValue": l[0] || (l[0] = (_) => v.value = _), size: i.size, disabled: i.disabled, multiple: i.multiple, "collapse-tags": i.collapseTags, loading: !C.value, clearable: i.clearable, filterable: i.filterable, crmProjectInformationConfigEnum: i.crmProjectInformationConfigEnum, placeholder: `${a(H).VL[i.crmProjectInformationConfigEnum]}`, options: V.value, onChange: w }, null, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "filterable", "crmProjectInformationConfigEnum", "placeholder", "options"]);
  };
} };
const Ae = { class: "head-container" }, Me = { style: { float: "right" } }, Ye = { key: 0 }, Ge = { key: 1 }, He = { key: 1 }, Ke = { key: 1 }, qe = { __name: "project-information", props: { tabType: { type: String, default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(g) {
  const P = g, I = be();
  G(() => I.state.approval_list.approvalNum, () => {
    m();
  }), Ce(() => {
    m();
  });
  const { projectInformationMap: i } = Oe(), v = te(() => {
    var d;
    return ((d = i.value[H.PROJECT_LEVEL_CONFIG.V]) == null ? void 0 : d.crmProjectInformationConfigDTOS) || [];
  }), o = r({ crmCheckStatusEnum: void 0, crmProjectScheduleTypeEnumName: void 0, keyProjectName: void 0, informantDateTime: void 0, structureTypeConfigurationId: void 0, projecprojectNameOrRecordNumbertName: void 0, informantUserName: void 0 }), R = r(false), C = r([]), V = r({}), j = r(true), w = r(false), T = r(false), x = r(false), B = r({}), u = r([]), l = r([]), y = r([]), _ = r([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]]]);
  function oe() {
    j.value = true, w.value = true;
  }
  const { maxHeight: ne } = Ie({ extraBox: [".head-container"], extraHeight: 70, paginate: true }), { handleSizeChange: ae, handleCurrentChange: le, total: ie, setTotalPage: re, queryPage: U } = xe({ fetchHook: m });
  async function m() {
    var F;
    if (!E((F = P.permission) == null ? void 0 : F.get)) return;
    const { content: d = [], totalElements: e } = await Le({ ...o.value, ...U });
    re(e), C.value = d == null ? void 0 : d.map((p) => (p.crmCheckStatusEnumName = L.V[p.crmCheckStatusEnum].AL, p)), u.value = C.value.map((p) => ({ id: p.id, label: p.projectName }));
    const D = await Ue();
    l.value = D.map((p) => ({ id: p.id, name: p.businessName })), y.value = ze(D);
  }
  function ue() {
    T.value = true;
  }
  function me(d) {
    var e;
    E((e = P.permission) == null ? void 0 : e.detail) && (x.value = true, B.value = d);
  }
  async function se(d) {
    j.value = false, V.value = d, console.log(d, V.value, " currentRow.value"), w.value = true;
  }
  function ce() {
    o.value.crmCheckStatusEnum = void 0, o.value.crmProjectScheduleTypeEnumName = void 0, o.value.informantDateTime = void 0, o.value.keyProjectName = void 0, o.value.projectLevelConfigId = void 0, o.value.crmProjectScheduleTypeEnum = void 0, o.value.structureTypeConfigurationId = void 0, o.value.informantUserName = void 0, o.value.projectNameOrRecordNumber = void 0, U.pageNumber = 1, U.pageSize = 20, m();
  }
  function K() {
    m();
  }
  function de() {
    m();
  }
  return (d, e) => {
    var W, Q, X, Z;
    const D = N("common-radio-button"), F = we, p = N("common-select"), q = _e, S = N("common-button"), pe = N("print-table"), s = Ee, J = je, fe = N("common-table"), ve = Te, ge = Se;
    return c(), z("div", null, [$("div", Ae, [$("div", null, [n(D, { modelValue: o.value.crmCheckStatusEnum, "onUpdate:modelValue": e[0] || (e[0] = (t) => o.value.crmCheckStatusEnum = t), options: a(L).ENUM, "unshow-val": [a(L).TEMPORARY_STORAGE.V], showOptionAll: "", type: "enum", class: "filter-item", onChange: e[1] || (e[1] = (t) => m()) }, null, 8, ["modelValue", "options", "unshow-val"]), n(F, { modelValue: o.value.informantDateTime, "onUpdate:modelValue": e[2] || (e[2] = (t) => o.value.informantDateTime = t), class: "filter-item", type: "year", "value-format": "x", format: "YYYY", placeholder: "选择日期", onChange: e[3] || (e[3] = (t) => m()), style: { width: "120px" } }, null, 8, ["modelValue"]), n(p, { modelValue: o.value.projectLevelConfigId, "onUpdate:modelValue": e[4] || (e[4] = (t) => o.value.projectLevelConfigId = t), class: "filter-item", placeholder: "项目等级", options: v.value, type: "other", onChange: e[5] || (e[5] = (t) => m()), clearable: "" }, null, 8, ["modelValue", "options"]), n(p, { modelValue: o.value.crmProjectScheduleTypeEnum, "onUpdate:modelValue": e[6] || (e[6] = (t) => o.value.crmProjectScheduleTypeEnum = t), options: a(O).ENUM, type: "enum", class: "filter-item", placeholder: "状态", onChange: e[7] || (e[7] = (t) => m()), clearable: "" }, null, 8, ["modelValue", "options"]), n($e, { modelValue: o.value.structureTypeConfigurationId, "onUpdate:modelValue": e[8] || (e[8] = (t) => o.value.structureTypeConfigurationId = t), class: "filter-item", size: "default", crmProjectInformationConfigEnum: a(H).STRUCTURE_TYPE_CONFIG.V, onChange: m, clearable: "" }, null, 8, ["modelValue", "crmProjectInformationConfigEnum"]), n(q, { modelValue: o.value.projectNameOrRecordNumber, "onUpdate:modelValue": e[9] || (e[9] = (t) => o.value.projectNameOrRecordNumber = t), modelModifiers: { trim: true }, size: "default", placeholder: "项目名称/备案号", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: ee(m, ["enter"]) }, null, 8, ["modelValue"]), n(q, { modelValue: o.value.informantUserName, "onUpdate:modelValue": e[10] || (e[10] = (t) => o.value.informantUserName = t), modelModifiers: { trim: true }, size: "default", placeholder: "填报人", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: ee(m, ["enter"]) }, null, 8, ["modelValue"]), n(S, { class: "filter-item", size: "default", type: "success", onClick: e[11] || (e[11] = (t) => m()) }, { default: f(() => e[15] || (e[15] = [k(" 搜索 ")])), _: 1, __: [15] }), n(S, { class: "filter-item", size: "default", type: "warning", onClick: ce }, { default: f(() => e[16] || (e[16] = [k(" 重置 ")])), _: 1, __: [16] })]), $("div", null, [a(E)((W = g.permission) == null ? void 0 : W.checkIn) ? (c(), b(S, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: oe }, { default: f(() => e[17] || (e[17] = [k(" 项目信息登记 ")])), _: 1, __: [17] })) : A("", true), a(E)((Q = g.permission) == null ? void 0 : Q.inbound) ? (c(), b(S, { key: 1, class: "filter-item", size: "default", type: "info", onClick: ue }, { default: f(() => e[18] || (e[18] = [k(" 备案任务下达 ")])), _: 1, __: [18] })) : A("", true), $("div", Me, [a(E)((X = g.permission) == null ? void 0 : X.print) ? (c(), b(pe, { key: 0, "api-key": "projectInfoReport", params: { ...o.value }, size: "default", type: "warning" }, null, 8, ["params"])) : A("", true)])])]), Ve((c(), b(fe, { style: { width: "100%" }, data: C.value, dataFormat: _.value, "max-height": a(ne), "empty-text": a(E)((Z = g.permission) == null ? void 0 : Z.get) ? "暂无数据" : "暂无权限" }, { default: f(() => [n(s, { label: "序号", type: "index", align: "center", "show-overflow-tooltip": true, prop: "index", width: "60", fixed: "left" }), n(s, { label: "登记日期", align: "center", "show-overflow-tooltip": true, prop: "informantDateTime", width: "100", fixed: "left" }), n(s, { label: "备案号", align: "center", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "170", fixed: "left" }), n(s, { label: "项目名称", align: "center", "show-overflow-tooltip": true, prop: "projectName", "min-width": "170", fixed: "left" }), n(s, { label: "所属省市", align: "center", "show-overflow-tooltip": true, prop: "regionNameList", "min-width": "170" }), n(s, { label: "项目等级", align: "center", "show-overflow-tooltip": true, prop: "projectLevelConfigName", "min-width": "90" }), n(s, { label: "结构类型", align: "center", "show-overflow-tooltip": true, prop: "structureTypeConfigurationName", "min-width": "90" }), n(s, { label: "有效期剩余", align: "center", "show-overflow-tooltip": true, prop: "informantUserName", width: "100" }, { default: f(({ row: t }) => [t.crmProjectScheduleTypeEnum === a(O).FOLLOW_UP_STATUS.V || t.crmProjectScheduleTypeEnum === a(O).FILING_STATUS.V ? (c(), z("span", Ye, Y(t.effectiveRemainingTime) + " 天 ", 1)) : (c(), z("span", Ge, "-"))]), _: 1 }), n(s, { label: "跟踪次数", align: "center", "show-overflow-tooltip": true, prop: "followUpTimes", width: "100" }), n(s, { label: "登记人", align: "center", "show-overflow-tooltip": true, prop: "createUserName", "min-width": "160" }), n(s, { label: "填报人", align: "center", "show-overflow-tooltip": true, prop: "informantUserName", "min-width": "160" }), n(s, { label: "项目状态", align: "center", "show-overflow-tooltip": true, prop: "crmProjectScheduleTypeEnum", width: "170", fixed: "right" }, { default: f(({ row: t }) => {
      var h;
      return [t.crmProjectScheduleTypeEnum ? (c(), b(J, { key: 0, type: (h = a(O).V[t.crmProjectScheduleTypeEnum]) == null ? void 0 : h.TYPE }, { default: f(() => [k(Y(a(O).VL[t.crmProjectScheduleTypeEnum]), 1)]), _: 2 }, 1032, ["type"])) : (c(), z("span", He, "-"))];
    }), _: 1 }), n(s, { label: "审核状态", align: "center", "show-overflow-tooltip": true, prop: "crmCheckStatusEnum", width: "170", fixed: "right" }, { default: f(({ row: t }) => {
      var h;
      return [t.crmCheckStatusEnum ? (c(), b(J, { key: 0, type: (h = a(L).V[t.crmCheckStatusEnum]) == null ? void 0 : h.TYPE }, { default: f(() => [k(Y(a(L).VL[t.crmCheckStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : (c(), z("span", Ke, "-"))];
    }), _: 1 }), n(s, { label: "操作", align: "center", width: "120", fixed: "right" }, { default: f(({ row: t }) => {
      var h;
      return [n(S, { icon: "el-icon-edit", type: "primary", size: "small", onClick: (ye) => se(t) }, null, 8, ["onClick"]), a(E)((h = g.permission) == null ? void 0 : h.detail) ? (c(), b(S, { key: 0, icon: "el-icon-view", type: "info", size: "small", onClick: (ye) => me(t) }, null, 8, ["onClick"])) : A("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data", "dataFormat", "max-height", "empty-text"])), [[ge, R.value]]), n(ve, { total: a(ie), "current-page": a(U).pageNumber, "page-size": a(U).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(ae), onCurrentChange: a(le) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), n(Be, { modelValue: w.value, "onUpdate:modelValue": e[12] || (e[12] = (t) => w.value = t), tabType: P.tabType, isAdd: j.value, "current-row": V.value, title: "项目信息登记", onSuccess: K }, null, 8, ["modelValue", "tabType", "isAdd", "current-row"]), n(Re, { modelValue: T.value, "onUpdate:modelValue": e[13] || (e[13] = (t) => T.value = t), "project-options": u.value, "simple-firm-options": l.value, "simple-firm-map": y.value, onSuccess: K }, null, 8, ["modelValue", "project-options", "simple-firm-options", "simple-firm-map"]), n(Fe, { modelValue: x.value, "onUpdate:modelValue": e[14] || (e[14] = (t) => x.value = t), "current-information": B.value, onSubmitSuccess: de }, null, 8, ["modelValue", "current-information"])]);
  };
} }, gt = Pe(qe, [["__scopeId", "data-v-56c1eb93"]]);
export {
  gt as default
};
