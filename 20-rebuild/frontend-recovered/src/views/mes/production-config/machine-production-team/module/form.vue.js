import { ref as g } from "vue";
import { computed as k } from "vue";
import { reactive as Z } from "vue";
import { watch as V } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as u } from "vue";
import { createBlock as p } from "vue";
import { withCtx as d } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as R } from "vue";
import { createCommentVNode as P } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as _ } from "vue";
import { renderList as b } from "vue";
import { toDisplayString as z } from "vue";
import { ElCascader as $ } from "element-plus";
import { ElFormItem as ee } from "element-plus";
import { ElOption as te } from "element-plus";
import { ElSelect as le } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElRadio as ae } from "element-plus";
import { ElRadioGroup as de } from "element-plus";
import { ElForm as re } from "element-plus";
import { a as ne, g as ue } from "../../../../../modules/production-machine-team -25d37afa.js";
import { cf as s, aY as se, oU as M, ao as ie, g8 as pe, oT as K, oS as I, hE as ce, oW as me } from "../../../../../shared/runtime.js";
const Te = { __name: "form", props: { schedulingProductionLine: { type: Array, default: () => [] } }, setup(H) {
  const c = g(), L = g([]), S = g([]), D = g([]), G = g([s.MAKINGS, s.DRILL_HOLE]), B = { id: void 0, processId: void 0, leaderId: void 0, organizationType: se.IN_STAFF.V, groupsId: void 0, partProdMode: void 0, partType: void 0, deviceName: void 0, deviceTypeId: void 0, ncSystemId: void 0, ncFileFormatId: void 0, productionLineId: void 0, MID: void 0, cuttingReportMethod: M.APP.V, drillReportMethod: M.APP.V, processType: void 0, partFeature: void 0 }, { crud: n, form: e, CRUD: h } = ie(B, c), N = k(() => n.status.edit >= 1);
  g([s.MAKINGS, s.DRILL_HOLE]);
  const O = pe(["device_type", "nc_system", "nc_file_type"]), i = Z({ productionLineId: [{ required: true, message: "请选择生产线", trigger: "change" }], partType: [{ required: true, message: "请选择零件类型", trigger: "change" }], organizationType: [{ required: true, message: "请选择编制属性", trigger: "change" }], leaderId: [{ required: true, message: "请选择组长", trigger: "change" }], groupsId: [{ required: true, message: "请选择班组", trigger: "change" }], partProdMode: [{ required: true, message: "请选择生产方式", trigger: "change" }], deviceTypeId: [{ required: true, message: "请选择", trigger: "change" }], deviceName: [{ required: true, message: "请输入设备名称", trigger: "change" }], ncSystemId: [{ required: true, message: "请选择数控系统", trigger: "change" }], ncFileFormatId: [{ required: true, message: "请选择数控文件格式", trigger: "change" }], MID: [{ required: true, message: "请输入MID", trigger: "change" }], drillReportMethod: [{ required: true, message: "请选择钻孔报工方式", trigger: "change" }], cuttingReportMethod: [{ required: true, message: "请选择切割报工方式", trigger: "change" }], processType: [{ required: true, message: "请选择工序类", trigger: "change" }], partFeature: [{ required: true, message: "请选择零件特征", trigger: "blur" }] }), m = k(() => e.partProdMode === K.SEMI_AUTOMATIC.V || e.processType === s.DRILL_HOLE.V || e.partType === I.PROFILE_PART.V);
  V(() => m.value, () => {
    Q(), N.value && c.value.validate(["deviceName", "ncSystemId", "ncFileFormatId", "MID"]), m.value;
  }), V([() => e.partProdMode, () => e.processType, () => e.partType], () => {
    e.partType && e.partProdMode && e.processType && Y(), i.partFeature[0].required = e.partType === I.PROFILE_PART.V;
  }, { flush: "sync" }), V(() => e.processType, () => {
    e.processType === s.DRILL_HOLE.V && (e.deviceName = void 0, e.ncSystemId = void 0, e.ncFileFormatId = void 0, e.MID = void 0), i.drillReportMethod[0].required = e.processType !== s.MAKINGS.V, i.cuttingReportMethod[0].required = e.processType !== s.DRILL_HOLE.V;
  }, { immediate: true }), V([() => e.deviceTypeId, () => e.productionLineId], () => {
    e.deviceTypeId && e.productionLineId ? q(e.productionLineId, e.deviceTypeId) : e.groupsId = void 0;
  });
  function W() {
    N.value && c.value.validate(["processType"]);
  }
  async function q(y, o) {
    const T = await ne({ productionLineId: y, processId: o });
    T.length ? L.value = T.map((E) => E.userLinkList.filter((r) => r.boolLeaderEnum)).flat() : L.value = [];
  }
  async function Y() {
    const y = await ue({ partProdMode: e.partProdMode, productCategoryType: e.partType, type: e.processType });
    S.value = y;
  }
  async function j() {
    const { content: y } = await ce({ productClassificationEnum: me.SECTION_STEEL.V, mesProductEnum: n.query.mesProductEnum });
    D.value = y;
  }
  j();
  function Q() {
    i.deviceName[0].required = !m.value, i.ncSystemId[0].required = !m.value, i.ncFileFormatId[0].required = !m.value, i.MID[0].required = !m.value;
  }
  return h.HOOK.beforeToAdd = async () => {
    c.value && c.value.clearValidate();
  }, h.HOOK.beforeToEdit = async () => {
    q(e.productionLineId, e.deviceTypeId || e.processType);
  }, h.HOOK.beforeSubmit = () => {
    n.form.teamStatus = true, n.form.ncSystem = n.form.ncSystemId, n.form.ncFileFormat = n.form.ncFileFormatId, n.form.deviceType = n.form.deviceTypeId;
  }, (y, o) => {
    const T = F("common-button"), E = $, r = ee, f = F("common-select"), C = te, w = le, U = oe, A = ae, x = de, J = re, X = F("common-dialog");
    return u(), p(X, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(n).cancelCU, visible: t(n).status.cu > 0, title: t(n).status.title, width: "500px" }, { titleRight: d(() => [a(T, { loading: t(n).status.cu === 2, type: "primary", size: "default", onClick: t(n).submitCU }, { default: d(() => o[13] || (o[13] = [R("确认")])), _: 1, __: [13] }, 8, ["loading", "onClick"])]), default: d(() => [a(J, { ref_key: "formRef", ref: c, model: t(e), rules: i, size: "default", "label-width": "130px" }, { default: d(() => [a(r, { label: "生产线", prop: "productionLineId" }, { default: d(() => [a(E, { modelValue: t(e).productionLineId, "onUpdate:modelValue": o[0] || (o[0] = (l) => t(e).productionLineId = l), options: H.schedulingProductionLine, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": true, separator: " > ", style: { width: "270px" }, filterable: "", placeholder: "请选择生产线" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(r, { label: "零件类型", prop: "partType" }, { default: d(() => [a(f, { modelValue: t(e).partType, "onUpdate:modelValue": o[1] || (o[1] = (l) => t(e).partType = l), options: t(I).ENUM, unshowOptions: [t(I).PRIMARY_SECONDARY.K, t(I).WELDED_PROFILE.K], type: "enum", style: { width: "270px" } }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 }), t(e).partType === t(I).PROFILE_PART.V ? (u(), p(r, { key: 0, label: "零件特征", prop: "partFeature" }, { default: d(() => [a(f, { modelValue: t(e).partFeature, "onUpdate:modelValue": o[2] || (o[2] = (l) => t(e).partFeature = l), options: D.value, dataStructure: { key: "id", label: "name", value: "id" }, type: "other", size: "default", clearable: "", multiple: "", disabled: !t(e).partType, placeholder: "零件特征", style: { width: "270px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 })) : P("", true), a(r, { label: "生产方式", prop: "partProdMode" }, { default: d(() => [a(f, { class: "filter-item", modelValue: t(e).partProdMode, "onUpdate:modelValue": o[3] || (o[3] = (l) => t(e).partProdMode = l), options: t(K).ENUM, type: "enum", size: "default", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(r, { label: "工序类", prop: "processType" }, { default: d(() => [a(f, { modelValue: t(e).processType, "onUpdate:modelValue": o[4] || (o[4] = (l) => t(e).processType = l), options: G.value, type: "enum", size: "default", placeholder: "请选择工序类型", class: "filter-item", style: { width: "270px" }, onChange: W }, null, 8, ["modelValue", "options"])]), _: 1 }), a(r, { label: t(e).processType === t(s).MAKINGS.V ? "切割方式" : "钻孔方式", prop: "deviceTypeId" }, { default: d(() => [a(w, { modelValue: t(e).deviceTypeId, "onUpdate:modelValue": o[5] || (o[5] = (l) => t(e).deviceTypeId = l), disabled: !t(e).partType || !t(e).partProdMode, clearable: "", size: "default", placeholder: t(e).processType === t(s).MAKINGS.V ? "切割方式" : "钻孔方式", style: { width: "270px" } }, { default: d(() => [(u(true), v(_, null, b(S.value, (l) => (u(), p(C, { key: l.id, label: l.name, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled", "placeholder"])]), _: 1 }, 8, ["label"]), a(r, { label: "班组", prop: "groupsId" }, { default: d(() => [a(w, { modelValue: t(e).groupsId, "onUpdate:modelValue": o[6] || (o[6] = (l) => t(e).groupsId = l), disabled: !t(e).deviceTypeId, clearable: "", size: "default", placeholder: "请选择班组", style: { width: "270px" } }, { default: d(() => [(u(true), v(_, null, b(L.value, (l) => (u(), p(C, { key: l.teamId, label: l.userName, value: l.teamId }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 }), a(r, { label: "MID", prop: "MID" }, { default: d(() => [a(U, { modelValue: t(e).MID, "onUpdate:modelValue": o[7] || (o[7] = (l) => t(e).MID = l), placeholder: "请输入MID", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), a(r, { label: "设备名称", prop: "deviceName" }, { default: d(() => [a(U, { modelValue: t(e).deviceName, "onUpdate:modelValue": o[8] || (o[8] = (l) => t(e).deviceName = l), placeholder: "请输入设备名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), a(r, { label: "数控系统", prop: "ncSystemId" }, { default: d(() => [a(f, { modelValue: t(e).ncSystemId, "onUpdate:modelValue": o[9] || (o[9] = (l) => t(e).ncSystemId = l), options: t(O).nc_system, type: "dict", size: "default", clearable: "", placeholder: "数控系统", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(r, { label: "数控文件格式", prop: "ncFileFormatId" }, { default: d(() => [a(f, { modelValue: t(e).ncFileFormatId, "onUpdate:modelValue": o[10] || (o[10] = (l) => t(e).ncFileFormatId = l), options: t(O).nc_file_type, type: "dict", size: "default", clearable: "", placeholder: "数控文件格式", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(e).processType === t(s).MAKINGS.V ? (u(), p(r, { key: 1, label: "切割报工方式", prop: "cuttingReportMethod" }, { default: d(() => [a(x, { modelValue: t(e).cuttingReportMethod, "onUpdate:modelValue": o[11] || (o[11] = (l) => t(e).cuttingReportMethod = l) }, { default: d(() => [(u(true), v(_, null, b(t(M).ENUM, (l) => (u(), p(A, { value: l.V, label: l.V, size: "default", key: l.V }, { default: d(() => [R(z(l.L), 1)]), _: 2 }, 1032, ["value", "label"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })) : P("", true), t(e).processType === t(s).DRILL_HOLE.V ? (u(), p(r, { key: 2, label: "钻孔报工方式", prop: "drillReportMethod" }, { default: d(() => [a(x, { modelValue: t(e).drillReportMethod, "onUpdate:modelValue": o[12] || (o[12] = (l) => t(e).drillReportMethod = l) }, { default: d(() => [(u(true), v(_, null, b(t(M).ENUM, (l) => (u(), p(A, { value: l.V, label: l.V, size: "default", key: l.V }, { default: d(() => [R(z(l.L), 1)]), _: 2 }, 1032, ["value", "label"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })) : P("", true)]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Te as default
};
