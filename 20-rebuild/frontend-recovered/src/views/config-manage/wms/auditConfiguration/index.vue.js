import { computed as C } from "vue";
import { ref as k } from "vue";
import q from "moment";
import { onMounted as U } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as S } from "vue";
import { unref as o } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as p } from "vue";
import { withCtx as b } from "vue";
import { toDisplayString as O } from "vue";
import { createCommentVNode as r } from "vue";
import { ElMessageBox as P } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElSwitch as K } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as $, o as z, x as J, gJ as j, gK as D, i as d, gz as Q, aS as _, G as v, an as W, gL as X } from "../../../../shared/runtime.js";
import Z from "./component/header.vue.js";
import ee from "./component/form.vue.js";
import "../../../../modules/use-filter-item-enum-82000272.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
const te = { class: "app-container section-steel" }, ae = { class: "head-container" }, oe = { key: 0 }, se = { key: 1 }, ie = { key: 2 }, ne = { key: 3 }, le = { __name: "index", setup(pe) {
  const { maxHeight: I } = z({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 }), L = { add: true, edit: false, del: false }, A = C(() => w.status.edit > 0), E = k(), { crud: w, columns: m, CRUD: N } = J({ title: "审批设置", sort: [], dataPath: "", permission: { ...j }, optShow: { ...L }, crudApi: { ...D, add: D.edit }, invisibleColumns: [] }, E), F = k([["targetProductionShow", ["to-fixed", 2]]]);
  N.HOOK.handleRefresh = (s, u) => {
    var i;
    (i = u.data) == null || i.forEach((t) => {
      var c, f, a, l, h, y, V, R;
      t.updateTimes = t.updateTime ? q(t.updateTime).format("YYYY-MM-DD HH:mm:ss") : "-", t.createBy = (c = t.applicationUser) == null ? void 0 : c.name, t.jobResponseNames = (f = t.jobResponseVOS) == null ? void 0 : f.map((e) => e == null ? void 0 : e.name), t.userSimpleResponseNames = (a = t.userSimpleResponseVOS) == null ? void 0 : a.map((e) => e == null ? void 0 : e.name), t.departmentNames = (l = t.departmentDTOS) == null ? void 0 : l.map((e) => e == null ? void 0 : e.name), t.status = t.id ? t.status : false, t.objIdsList = [], t.crmTenderApprovalFlowsType = [], d(t.jobResponseVOS) && ((h = t.jobResponseVOS) == null || h.forEach((e) => t.objIdsList.push(e == null ? void 0 : e.id))), d(t.userSimpleResponseVOS) && ((y = t.userSimpleResponseVOS) == null || y.forEach((e) => t.objIdsList.push(e == null ? void 0 : e.id))), d(t.departmentDTOS) && ((V = t.departmentDTOS) == null || V.forEach((e) => t.objIdsList.push(e == null ? void 0 : e.id))), (R = t.wmsApproveTemplateVersionsFlowDTOS) == null || R.forEach((e) => {
        e.userIdsList = [], e.userSimpleResponseVOS.forEach((T) => {
          e.userIdsList.push(T.id);
        }), e.wmsApproveFlowOperationDTOParams = e.wmsApproveFlowOperationDTOS, e.wmsApproveFlowOperationDTOS.length !== 0 && e.wmsApproveFlowOperationDTOS.findIndex((T) => T.operationType === 1) > -1 && (e.boolEditMoney = true), e.wmsApproveFlowOperationDTOS.length !== 0 && e.wmsApproveFlowOperationDTOS.findIndex((T) => T.operationType === 2) > -1 && (e.editFreight = true), e.type == Q.SINGLE_SIGNATURE.V ? e.num = 1 : e.num = 0;
      });
    }), u.data = u.data.filter((t) => {
      var f, a, l, h;
      let c = false;
      return (f = s.query.objIdsList) == null || f.forEach((y) => {
        t.objIdsList.indexOf(y) !== -1 ? c = true : c = false;
      }), (d(s.query.status) ? t.status === s.query.status : true) && (d(s.query.templateName) ? ((a = t.templateName) == null ? void 0 : a.indexOf(s.query.templateName)) !== -1 : true) && (d(s.query.moduleType) ? t.moduleType === s.query.moduleType : true) && (d(s.query.objType) && s.query.objType ? t.objType === s.query.objType : true) && ((l = s.query.objIdsList) != null && l.length && ((h = s.query.objIdsList) == null ? void 0 : h.length) !== 0 ? c : true);
    });
  }, N.HOOK.afterSubmit = () => {
  }, N.HOOK.afterDelete = () => {
  };
  function re() {
  }
  async function B(s, u) {
    try {
      await P.confirm('此操作将 "' + _.VL[u] + '"' + s.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await X({ id: s.id, status: u }), w.refresh(), w.notify(_.VL[u] + "成功", N.NOTIFICATION_TYPE.SUCCESS);
    } catch (i) {
      console.log("变更仓库状态", i), s.status = s.status === _.TRUE.V ? _.FALSE.V : _.TRUE.V;
    }
  }
  return U(() => {
  }), (s, u) => {
    const i = Y, t = K, c = H("common-table"), f = G;
    return n(), g("div", te, [x("div", ae, [S(o(Z))]), M((n(), p(c, { ref_key: "tableRef", ref: E, data: o(w).data, "data-format": F.value, "default-expand-all": false, "empty-text": o(w).emptyText, "max-height": o(I), stripe: false, "highlight-current-row": "", style: { width: "100%" } }, { default: b(() => [S(i, { align: "center", label: "序号", type: "index", width: "60" }), o(m).visible("moduleName") ? (n(), p(i, { key: "moduleName", "show-overflow-tooltip": true, align: "center", label: "业务模块", prop: "moduleName", width: "150px" }, { default: b(({ row: a }) => [x("span", null, O(a.moduleName || "-"), 1)]), _: 1 })) : r("", true), o(m).visible("templateName") ? (n(), p(i, { key: "templateName", "show-overflow-tooltip": true, align: "center", label: "功能审批流程", prop: "templateName", width: "150px" }, { default: b(({ row: a }) => [x("span", null, O(a.templateName), 1)]), _: 1 })) : r("", true), o(m).visible("name") ? (n(), p(i, { key: "sort", align: "center", label: "流程名称", prop: "name", "show-overflow-tooltip": "", width: "150px" })) : r("", true), o(m).visible("approveTemplateFlowStr") ? (n(), p(i, { key: "sort", align: "center", label: "审批流程", prop: "approveTemplateFlowStr" })) : r("", true), o(m).visible("createBy") ? (n(), p(i, { key: "sort", align: "center", label: "最后编辑人", prop: "createBy", "show-overflow-tooltip": "", width: "120px" })) : r("", true), o(m).visible("updateTimes") ? (n(), p(i, { key: "updateTimes", align: "center", label: "最后编辑时间", prop: "updateTimes", "show-overflow-tooltip": "", width: "200px" })) : r("", true), o(m).visible("objTypeName") ? (n(), p(i, { key: "objTypeName", align: "center", label: "适用对象", prop: "objTypeName", "show-overflow-tooltip": "", width: "100px" })) : r("", true), o(m).visible("userSimpleResponseNames") ? (n(), p(i, { key: "sort", align: "center", label: "部门/岗位/人员", "show-overflow-tooltip": "", width: "150px" }, { default: b(({ row: a }) => {
      var l, h, y;
      return [a.objType === 1 ? (n(), g("span", oe, O(((l = a.departmentNames) == null ? void 0 : l.join(",")) || "-"), 1)) : a.objType === 2 ? (n(), g("span", se, O(((h = a.jobResponseNames) == null ? void 0 : h.join(",")) || "-"), 1)) : a.objType === 3 ? (n(), g("span", ie, O(((y = a.userSimpleResponseNames) == null ? void 0 : y.join(",")) || "-"), 1)) : (n(), g("span", ne, "-"))];
    }), _: 1 })) : r("", true), o(m).visible("status") ? (n(), p(i, { key: "status", align: "center", label: "状态", prop: "status", width: "80px" }, { default: b((a) => [S(t, { modelValue: a.row.status, "onUpdate:modelValue": (l) => a.row.status = l, "active-value": o(_).TRUE.V, disabled: !o(v)(o(j).editStatus) && !o(d)(a.row.id), "inactive-value": o(_).FALSE.V, "active-color": "#13ce66", onChange: (l) => B(a.row, a.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : r("", true), o(v)([...o(j).edit]) ? (n(), p(i, { key: 9, fixed: "right", label: "操作", width: "130px" }, { default: b((a) => [S(o(W), { data: a.row.sourceRow, showDel: o(d)(a.row.id) }, null, 8, ["data", "showDel"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[f, o(w).loading]]), S(o(ee), { edit: A.value }, null, 8, ["edit"])]);
  };
} }, be = $(le, [["__scopeId", "data-v-91c091f6"]]);
export {
  be as default
};
