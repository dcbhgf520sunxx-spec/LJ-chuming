import { ref as A } from "vue";
import { watch as pe } from "vue";
import { onMounted as re } from "vue";
import { ElMessage as ie } from "element-plus";
import { resolveComponent as S } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { createTextVNode as O } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementBlock as ue } from "vue";
import { Fragment as de } from "vue";
import { renderList as me } from "vue";
import { toDisplayString as Te } from "vue";
import { createElementVNode as I } from "vue";
import { ElInput as ye } from "element-plus";
import { ElFormItem as ce } from "element-plus";
import { ElSelectV2 as fe } from "element-plus";
import { ElCheckbox as be } from "element-plus";
import { ElCheckboxGroup as ge } from "element-plus";
import { ElTableColumn as we } from "element-plus";
import { ElTooltip as _e } from "element-plus";
import { ElForm as Ve } from "element-plus";
import { _ as Oe, gy as ve, o as Ae, ao as Se, gz as C, i as f, gA as Ee, b as he, gB as Ue, V as Ie, gC as p, gD as Ce, gE as Fe, cJ as Me, gF as De, gG as F, gH as Pe, aw as Ne, gI as Le } from "../../../../../shared/runtime.js";
import { u as Re } from "../../../../../modules/use-filter-item-enum-82000272.js";
import { u as ke } from "../../../../../modules/use-table-operate-4f84437f.js";
import { _ as je } from "../../../../../modules/dept-cascader-6af417b9.js";
import "../../../../../modules/use-dept-b8e95315.js";
const xe = { class: "add-row-box" }, Be = { __name: "form", props: { edit: { type: Boolean, default: false } }, setup(B) {
  const { filterItemsEnum: W } = Re(), { BusinessModuleEnum: N } = ve(), L = B, M = A(), z = A(), R = A([]), H = { name: void 0, objType: void 0, moduleType: void 0, approveProcessType: void 0, objIdsList: void 0, functionType: void 0, wmsApproveTemplateVersionsFlowDTOS: [{ moduleType: void 0, userIdsList: void 0, wmsApproveFlowOperationDTOParams: [], boolEditMoney: false, editFreight: false }], basicClass: [], materialType: [], workshopId: [], outboundType: [], mountMessageDTO: { basicClass: [], materialType: [], projectAttribute: [], outboundType: [], crmTenderApprovalFlowsType: [], workshopId: [] }, projectAttribute: [], crmTenderApprovalFlowsType: [] }, { maxHeight: Y } = Ae({ wrapperBox: ".auditAddForm", paginate: true, extraHeight: 40 }), k = A([]), { CRUD: D, crud: _, form: l } = Se(H, M), q = { name: [{ required: true, message: "请输入流程名称", trigger: "blur" }], moduleType: [{ required: true, message: "请选择业务模块", trigger: "change" }], approveProcessType: [{ required: true, message: "请选择流程名称", trigger: "change" }], objType: [{ required: true, message: "请选择类型", trigger: "change" }], objIdsList: [{ required: true, validator: (a, e, r) => {
    l.objType && l.objType !== E.COMPANY.V && !e && r(new Error(a.message)), r();
  }, message: "请选择部门/岗位/人员", trigger: "change" }], basicClass: [{ required: true, message: "请选择材料类型", trigger: "change" }], materialType: [{ required: true, message: "请选择材料类型", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], outboundType: [{ required: true, message: "请选择出库类型", trigger: "change" }], projectAttribute: [{ required: true, message: "请选择项目类型", trigger: "change" }], crmTenderApprovalFlowsType: [{ required: true, message: "请选择标书类型", trigger: "change" }] }, $ = { userIdsList: [{ required: true, validator: (a, e) => {
    if (f(e.type) && e.type === C.COUNTERSIGNATURE.V && e.userIdsList.length < 2) return false;
  }, message: "请选择人员", trigger: "change" }], type: [{ required: true, message: "请选择类型", trigger: "change" }] }, G = /* @__PURE__ */ new Map([]), { init: j, addRow: K, removeRow: J } = ke({ type: C.SINGLE_SIGNATURE.V, num: 1, wmsApproveFlowOperationDTOParams: [] }, 5, G), { tableValidate: Q, wrongCellMask: X, cleanUpData: Z } = Ne({ rules: $ }), E = { COMPANY: { L: "公司", K: "COMPANY", V: 4 }, DEPARTMENT: { L: "部门", K: "DEPARTMENT", V: 1 }, POST: { L: "岗位", K: "POST", V: 2 }, PERSONNEL: { L: "人员", K: "PERSONNEL", V: 3 } }, P = A([]);
  async function ee() {
    const a = await Le();
    k.value = a.content;
  }
  function oe(a, e) {
    if (a.boolEditMoney) l.wmsApproveTemplateVersionsFlowDTOS[e].wmsApproveFlowOperationDTOParams.push({ operationType: 1, operation: "1" });
    else {
      const r = l.wmsApproveTemplateVersionsFlowDTOS[e].wmsApproveFlowOperationDTOParams.findIndex((T) => T.operationType === 1);
      l.wmsApproveTemplateVersionsFlowDTOS[e].wmsApproveFlowOperationDTOParams.splice(r, 1);
    }
  }
  function le(a, e) {
    if (a.editFreight) l.wmsApproveTemplateVersionsFlowDTOS[e].wmsApproveFlowOperationDTOParams.push({ operationType: 2, operation: "1" });
    else {
      const r = l.wmsApproveTemplateVersionsFlowDTOS[e].wmsApproveFlowOperationDTOParams.findIndex((T) => T.operationType === 2);
      l.wmsApproveTemplateVersionsFlowDTOS[e].wmsApproveFlowOperationDTOParams.splice(r, 1);
    }
  }
  function te(a) {
    a.userIdsList = [], a.type === C.SINGLE_SIGNATURE.V ? a.num = 1 : a.num = 0;
  }
  pe(() => l.moduleType, (a) => {
    const e = N.value.find((r) => a === r.moduleType);
    e && (P.value = e.wmsModuleApproveTemplateDTOS);
  }, { deep: true, immediatet: true });
  function ae(a) {
    const e = P.value.find((r) => a === r.approveProcessType);
    l.functionType = e.functionType;
  }
  function x(a) {
    l.objIdsList = [], R.value = W.value[a] || [];
  }
  return re(() => {
    ee();
  }), D.HOOK.beforeToAdd = () => {
    j(l.wmsApproveTemplateVersionsFlowDTOS);
  }, D.HOOK.beforeToEdit = (a, e) => {
    var T, i, m, b, v, V, h, c, U;
    const r = JSON.parse(JSON.stringify([{ type: void 0, userIdsList: void 0, wmsApproveFlowOperationDTOParams: [], boolEditMoney: false, editFreight: false }]));
    f(e.wmsApproveTemplateVersionsFlowDTOS) || (e.wmsApproveTemplateVersionsFlowDTOS = r), e.basicClass = (T = e.mountMessageDTO) == null ? void 0 : T.basicClass, e.workshopId = (i = e.mountMessageDTO) == null ? void 0 : i.workshopId, e.materialType = (m = e.mountMessageDTO) == null ? void 0 : m.materialType, e.crmTenderApprovalFlowsType = Ee((b = e.mountMessageDTO) == null ? void 0 : b.crmTenderApprovalFlowsType) || [], e.outboundType = (v = e.mountMessageDTO) == null ? void 0 : v.outboundType, e.projectAttribute = (V = e.mountMessageDTO) == null ? void 0 : V.projectAttribute, e.id || j(e.wmsApproveTemplateVersionsFlowDTOS), x(e.objType), f(e.jobResponseVOS) && (e.objIdsList = ((h = e.jobResponseVOS) == null ? void 0 : h.map((w) => w.id)) || []), f(e.userSimpleResponseVOS) && (e.objIdsList = ((c = e.userSimpleResponseVOS) == null ? void 0 : c.map((w) => w.id)) || []), f(e.departmentDTOS) && (e.objIdsList = ((U = e.departmentDTOS) == null ? void 0 : U.map((w) => w.id)) || []);
  }, D.HOOK.beforeValidateCU = async (a, e) => {
    if (!await M.value.validate()) return false;
    if (a.form.wmsApproveTemplateVersionsFlowDTOS.length <= 0) return ie({ message: "请添加审批流程", type: "error" }), false;
    a.form.wmsApproveTemplateVersionsFlowDTOS.forEach((b) => {
      he(b.userIdsList) && (b.type = void 0, b.num = void 0);
    }), a.form.crmTenderApprovalFlowsType = [Ue(a.form.crmTenderApprovalFlowsType)];
    const { validResult: T, dealList: i } = Q(a.form.wmsApproveTemplateVersionsFlowDTOS), m = Z(Ie(i));
    if (T) a.form.wmsApproveTemplateVersionsFlowDTOS = m, a.form.status = true, a.form.wmsApproveTemplateVersionsFlowDTOParams = a.form.wmsApproveTemplateVersionsFlowDTOS, a.form.mountMessageDTO = { basicClass: a.form.functionType === p.WMS_SELF_BUYING_IN.V || a.form.functionType === p.WMS_PARTY_A_SUPPLY_IN.V ? a.form.basicClass : [], materialType: a.form.functionType === p.WMS_RETURN.V || a.form.functionType === p.WMS_SELF_OUTBOUND_PURCHASE.V || a.form.functionType === p.WMS_PARTY_A_OUTBOUND_PURCHASE.V ? a.form.materialType : [], workshopId: a.form.functionType === p.WMS_RETURN.V ? a.form.workshopId : [], crmTenderApprovalFlowsType: a.form.functionType === p.BID_APPLICATION.V ? a.form.crmTenderApprovalFlowsType : [], outboundType: a.form.functionType === p.WMS_SELF_OUTBOUND_PURCHASE.V ? a.form.outboundType : [], projectAttribute: a.form.functionType === p.SUPPLY_CHAIN_PURCHASE_ORDER.V ? a.form.projectAttribute : [] };
    else return T;
  }, (a, e) => {
    const r = S("common-button"), T = ye, i = ce, m = S("common-select"), b = fe, v = S("common-select-v2"), V = be, h = ge, c = we, U = S("common-table"), w = _e, se = Ve, ne = S("common-dialog");
    return u(), d(ne, { "before-close": o(_).cancelCU, "close-on-click-modal": false, title: o(_).status.title, visible: o(_).status.cu > 0, "append-to-body": "", top: "5vh", width: "900px" }, { titleRight: n(() => [s(r, { loading: o(_).status.cu === 2, size: "default", type: "primary", onClick: o(_).submitCU }, { default: n(() => e[14] || (e[14] = [O("确认 ")])), _: 1, __: [14] }, 8, ["loading", "onClick"])]), default: n(() => [s(se, { ref_key: "formRef", ref: M, model: o(l), rules: q, "label-width": "130px", size: "default" }, { default: n(() => [s(i, { label: "流程名称", prop: "name" }, { default: n(() => [s(T, { modelValue: o(l).name, "onUpdate:modelValue": e[0] || (e[0] = (t) => o(l).name = t), modelModifiers: { trim: true }, class: "input-underline", clearable: "", placeholder: "请输入流程名称", size: "small", style: { width: "260px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "业务模块", prop: "moduleType" }, { default: n(() => [s(m, { modelValue: o(l).moduleType, "onUpdate:modelValue": e[1] || (e[1] = (t) => o(l).moduleType = t), dataStructure: { key: "moduleType", label: "moduleTypeName", value: "moduleType" }, disabled: o(f)(o(l).id) || L.edit, options: o(N), class: "input-underline", clearable: "", placeholder: "请选择业务模块", style: { width: "260px" }, type: "other", onChange: e[2] || (e[2] = (t) => o(l).approveProcessType = void 0) }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), s(i, { label: "功能审批流程", prop: "approveProcessType" }, { default: n(() => [s(b, { modelValue: o(l).approveProcessType, "onUpdate:modelValue": e[3] || (e[3] = (t) => o(l).approveProcessType = t), disabled: o(f)(o(l).id) || L.edit || !o(f)(o(l).moduleType), options: P.value, placeholder: o(l).moduleType ? "请选择功能审批流程" : "请先选择业务模块", props: { label: "approveProcessName", value: "approveProcessType" }, class: "input-underline", clearable: "", style: { width: "260px" }, onChange: ae }, null, 8, ["modelValue", "disabled", "options", "placeholder"])]), _: 1 }), s(i, { label: "适用对象", prop: "objType" }, { default: n(() => [s(m, { modelValue: o(l).objType, "onUpdate:modelValue": e[4] || (e[4] = (t) => o(l).objType = t), options: E, class: "input-underline", clearable: "", placeholder: "请选择适用对象", style: { width: "260px" }, type: "enum", onChange: x }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "部门/岗位/人员", prop: "objIdsList" }, { default: n(() => [o(l).objType !== E.DEPARTMENT.V ? (u(), d(v, { key: "objIdsList", modelValue: o(l).objIdsList, "onUpdate:modelValue": e[5] || (e[5] = (t) => o(l).objIdsList = t), dataStructure: { value: "id", label: "name", key: "id" }, disabled: o(l).objType === E.COMPANY.V || !o(f)(o(l).objType), options: R.value, class: "input-underline", clearable: "", "collapse-tags": "", "collapse-tags-tooltip": "", filterable: "", multiple: "", placeholder: "请选择部门/岗位/人员", size: "default", style: { width: "260px" } }, null, 8, ["modelValue", "disabled", "options"])) : (u(), d(je, { key: 1, modelValue: o(l).objIdsList, "onUpdate:modelValue": e[6] || (e[6] = (t) => o(l).objIdsList = t), "check-strictly": "", clearable: "", filterable: "", multiple: "", placeholder: "请选择部门/岗位/人员", size: "small", style: { width: "260px" }, type: "other" }, null, 8, ["modelValue"]))]), _: 1 }), o(l).functionType === o(p).SUPPLY_CHAIN_PURCHASE_ORDER.V ? (u(), d(i, { key: 0, label: "项目类型", prop: "projectAttribute" }, { default: n(() => [s(m, { modelValue: o(l).projectAttribute, "onUpdate:modelValue": e[7] || (e[7] = (t) => o(l).projectAttribute = t), options: o(Ce).ENUM, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择项目类型", size: "small", style: { width: "200px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : g("", true), o(l).functionType === o(p).WMS_SELF_BUYING_IN.V || o(l).functionType === o(p).WMS_PARTY_A_SUPPLY_IN.V ? (u(), d(i, { key: 1, label: "材料类型", prop: "basicClass" }, { default: n(() => [s(m, { modelValue: o(l).basicClass, "onUpdate:modelValue": e[8] || (e[8] = (t) => o(l).basicClass = t), options: o(Fe).ENUM, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择材料类型", size: "small", style: { width: "260px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : g("", true), o(l).functionType === o(p).WMS_RETURN.V || o(l).functionType === o(p).WMS_SELF_OUTBOUND_PURCHASE.V || o(l).functionType === o(p).WMS_PARTY_A_OUTBOUND_PURCHASE.V ? (u(), d(i, { key: 2, label: "材料类型", prop: "materialType" }, { default: n(() => [s(m, { modelValue: o(l).materialType, "onUpdate:modelValue": e[9] || (e[9] = (t) => o(l).materialType = t), options: o(Me).ENUM, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择材料类型", size: "small", style: { width: "260px" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : g("", true), o(l).functionType === o(p).WMS_RETURN.V ? (u(), d(i, { key: 3, label: "仓库", prop: "workshopId" }, { default: n(() => [s(De, { modelValue: o(l).workshopId, "onUpdate:modelValue": e[10] || (e[10] = (t) => o(l).workshopId = t), class: "input-underline", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: o(_).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 })) : g("", true), o(l).functionType === o(p).WMS_SELF_OUTBOUND_PURCHASE.V ? (u(), d(i, { key: 4, label: "出库类型", prop: "outboundType" }, { default: n(() => [s(m, { modelValue: o(l).outboundType, "onUpdate:modelValue": e[11] || (e[11] = (t) => o(l).outboundType = t), options: o(F).ENUM, unshowOptions: [o(F).SCRAPS.K, o(F).OUTSOURCE.K, o(F).TEMPORARY_LOAN.K], class: "input-underline", clearable: "", multiple: "", placeholder: "请选择出库类型", size: "small", style: { width: "260px" }, type: "enum" }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 })) : g("", true), o(l).functionType === o(p).BID_APPLICATION.V ? (u(), d(i, { key: 5, label: "标书类型", prop: "crmTenderApprovalFlowsType" }, { default: n(() => [s(h, { modelValue: o(l).crmTenderApprovalFlowsType, "onUpdate:modelValue": e[12] || (e[12] = (t) => o(l).crmTenderApprovalFlowsType = t) }, { default: n(() => [(u(true), ue(de, null, me(o(Pe).ENUM, (t) => (u(), d(V, { key: t.V, label: t.V }, { default: n(() => [O(Te(t.L), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })) : g("", true), s(U, { ref_key: "detailRef", ref: z, "cell-class-name": o(X), data: o(l).wmsApproveTemplateVersionsFlowDTOS, "max-height": o(Y), showEmptySymbol: false, stripe: false, border: "", class: "table-form table-input-border-none", "return-source-data": "", style: { width: "100%", "margin-top": "10px" } }, { default: n(() => [s(c, { align: "center", label: "序号", type: "index", width: "55" }), s(c, { key: "type", align: "center", label: "审批类型", prop: "type", width: "120px" }, { default: n((t) => [(u(), d(m, { key: Math.random(), modelValue: t.row.type, "onUpdate:modelValue": (y) => t.row.type = y, options: o(C).ENUM, placeholder: "审批类型", size: "default", type: "enum", onChange: (y) => te(t.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), s(c, { key: "userIdsList", align: "center", label: "审批人", prop: "userIdsList" }, { default: n((t) => [s(v, { modelValue: t.row.userIdsList, "onUpdate:modelValue": (y) => t.row.userIdsList = y, dataStructure: { value: "id", label: "name", key: "id" }, "multiple-limit": t.row.num, options: k.value, props: { value: "id", label: "name" }, clearable: "", "collapse-tags": "", "collapse-tags-tooltip": "", filterable: "", multiple: "", placeholder: "审批人", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "multiple-limit", "options"])]), _: 1 }), o(l).functionType === o(p).WMS_SELF_BUYING_IN.V ? (u(), d(c, { key: "boolEditMoney", align: "center", label: "允许填写金额", prop: "boolEditMoney", width: "110px" }, { default: n((t) => [s(V, { modelValue: t.row.boolEditMoney, "onUpdate:modelValue": (y) => t.row.boolEditMoney = y, size: "large", onChange: (y) => oe(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })) : g("", true), o(l).functionType === o(p).WMS_SELF_BUYING_IN.V ? (u(), d(c, { key: "editFreight", align: "center", label: "允许填写运费信息", prop: "editFreight", width: "120px" }, { default: n((t) => [s(V, { modelValue: t.row.editFreight, "onUpdate:modelValue": (y) => t.row.editFreight = y, size: "large", onChange: (y) => le(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })) : g("", true), s(c, { align: "center", label: "操作", width: "100" }, { default: n((t) => [s(r, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (y) => o(J)(o(l).wmsApproveTemplateVersionsFlowDTOS, t.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"]), I("div", xe, [s(r, { icon: "el-icon-circle-plus", size: "default", style: { "margin-right": "15px" }, type: "warning", onClick: e[13] || (e[13] = (t) => o(K)(o(l).wmsApproveTemplateVersionsFlowDTOS)) }, { default: n(() => e[15] || (e[15] = [O(" 继续添加 ")])), _: 1, __: [15] }), s(w, { class: "box-item", effect: "light", placement: "bottom" }, { content: n(() => e[16] || (e[16] = [O(" 审批流程添加规则："), I("br", null, null, -1), O(" 1、审批类型为单签时，必须要设置一个审批人；"), I("br", null, null, -1), O(" 2、审批类型为会签、或签时，最少要设置两个审批人。 ")])), default: n(() => [e[17] || (e[17] = I("span", { class: "process_rules" }, " 审批流程添加规则 ", -1))]), _: 1, __: [17] })])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Qe = Oe(Be, [["__scopeId", "data-v-705b41d2"]]);
export {
  Qe as default
};
