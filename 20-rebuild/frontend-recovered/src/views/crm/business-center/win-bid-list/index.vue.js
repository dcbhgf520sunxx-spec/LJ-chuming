import { ref as s } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as m } from "vue";
import { withCtx as w } from "vue";
import { unref as e } from "vue";
import { createBlock as r } from "vue";
import { createCommentVNode as a } from "vue";
import { createTextVNode as U } from "vue";
import { ElTableColumn as B } from "element-plus";
import H from "./module/header.vue.js";
import { x as I, o as L, G as g, lR as T, P as W } from "../../../../shared/runtime.js";
import { c as $ } from "../../../../modules/win-bid-list-285b5b2e.js";
import { q as u } from "../../../../modules/crm-c6ba92ff.js";
import q from "./module/project-drawer.vue.js";
import A from "./module/upload-dialog.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/project-config-3fa4f850.js";
import "../../../../modules/use-users-4d979987.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
const G = { class: "app-container" }, ae = { __name: "index", setup(O) {
  const j = s([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]]]), N = s(), _ = s(), h = s(false), b = s({}), k = s(false), C = s(false), D = { add: false, edit: false, del: false, download: false }, { crud: p, CRUD: V, columns: i } = I({ title: "中标项目列表", optShow: { ...D }, crudApi: { ...$ }, permission: { ...u }, queryOnPresenterCreated: true }, _), { maxHeight: P } = L({ extraBox: [".head-container"], paginate: true });
  function x(v, n) {
    h.value = true, b.value = v, C.value = n;
  }
  V.HOOK.handleRefresh = (v, n) => {
    var d;
    n.data.content = (d = n.data.content) == null ? void 0 : d.map((t) => {
      var c;
      return (c = t.sealContractAttachmentList) == null || c.map((f) => (f.rowDelDisabled = true, f)), t;
    });
  };
  function E() {
    p.toQuery(), N.value.handleChange();
  }
  return (v, n) => {
    const d = y("print-table"), t = B, c = y("common-button"), f = y("common-table");
    return o(), R("div", G, [m(H, { ref_key: "headerRef", ref: N, permission: e(u) }, { printBtn: w(() => [e(g)(e(u).print) ? (o(), r(d, { key: 0, "api-key": "bidProjectInfoList", params: { ...e(p).query }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : a("", true)]), _: 1 }, 8, ["permission"]), m(f, { ref_key: "tableRef", ref: _, style: { width: "100%" }, data: e(p).data, maxHeight: e(P), "row-key": "id", "data-format": j.value }, { default: w(() => [m(t, { type: "index", align: "center", label: "序号", width: "60", fixed: "left" }), e(i).visible("informantDateTime") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "结果登记日期", prop: "informantDateTime", key: "informantDateTime", width: "120", fixed: "left" })) : a("", true), e(i).visible("serialNumber") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", key: "serialNumber", "min-width": "170", fixed: "left" })) : a("", true), e(i).visible("projectName") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", key: "projectName", fixed: "left", "min-width": "170" })) : a("", true), e(i).visible("crmEnterpriseWarehousingName") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "建设单位", prop: "crmEnterpriseWarehousingName", key: "crmEnterpriseWarehousingName", "min-width": "130" })) : a("", true), e(i).visible("regionNames") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "regionNames", key: "regionNames", "min-width": "130" })) : a("", true), e(i).visible("structureTypeConfigurationName") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", key: "structureTypeConfigurationName", "min-width": "120" })) : a("", true), e(i).visible("estimatedCost") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "预估造价(万元)", prop: "estimatedCost", key: "estimatedCost", "min-width": "120" })) : a("", true), e(i).visible("projectLevelConfigName") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "项目等级", prop: "projectLevelConfigName", key: "projectLevelConfigName", "min-width": "120" })) : a("", true), e(i).visible("departmentName") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", key: "departmentName", "min-width": "120" })) : a("", true), e(i).visible("informantUserName") ? (o(), r(t, { align: "center", "show-overflow-tooltip": true, label: "结果登记人", prop: "informantUserName", key: "informantUserName", "min-width": "120" })) : a("", true), e(i).visible("crmProjectScheduleTypeEnumName") ? (o(), r(t, { align: "center", label: "状态", prop: "crmProjectScheduleTypeEnumName", key: "crmProjectScheduleTypeEnumName", "min-width": "120", fixed: "right" })) : a("", true), m(t, { align: "center", label: "操作", fixed: "right", width: "160" }, { default: w(({ row: l }) => [e(g)(e(u).detail) && l.crmProjectScheduleTypeEnum !== e(T).BIDDING.V ? (o(), r(c, { key: 0, icon: "el-icon-view", type: "warning", onClick: (S) => x(l, true) }, null, 8, ["onClick"])) : a("", true), e(g)(e(u).add) && l.crmProjectScheduleTypeEnum === e(T).BIDDING.V ? (o(), r(c, { key: 1, type: "success", onClick: (S) => x(l, false) }, { default: w(() => n[2] || (n[2] = [U("结果登记")])), _: 2, __: [2] }, 1032, ["onClick"])) : a("", true)]), _: 1 })]), _: 1 }, 8, ["data", "maxHeight", "data-format"]), m(e(W)), m(q, { modelValue: h.value, "onUpdate:modelValue": n[0] || (n[0] = (l) => h.value = l), "current-row": b.value, permission: e(u), "is-view": C.value, onSuccess: E }, null, 8, ["modelValue", "current-row", "permission", "is-view"]), m(A, { modelValue: k.value, "onUpdate:modelValue": n[1] || (n[1] = (l) => k.value = l), "current-row": b.value, onUploadSuccess: e(p).toQuery }, null, 8, ["modelValue", "current-row", "onUploadSuccess"])]);
  };
} };
export {
  ae as default
};
