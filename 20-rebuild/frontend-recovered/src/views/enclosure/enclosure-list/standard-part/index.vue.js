import { ref as p } from "vue";
import { watch as ne } from "vue";
import { provide as ie } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as u } from "vue";
import { Fragment as C } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as c } from "vue";
import { unref as a } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as s } from "vue";
import { withCtx as d } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as m } from "vue";
import { createTextVNode as L } from "vue";
import { ElMessage as re } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElPopconfirm as ce } from "element-plus";
import { vLoading as pe } from "element-plus";
import { l as x, _ as me, m as fe, T as h, x as ye, o as _e, mt as ge, i as he, ky as q, G as A, P as ve, fK as D } from "../../../../shared/runtime.js";
import be from "../components/enclosure-change.vue.js";
import { e as v } from "../../../../modules/enclosure-365a2177.js";
import ke from "./module/header.vue.js";
import xe from "./module/form.vue.js";
import "../../../../modules/change-reason-select-73e53277.js";
import "../../../../modules/standard-part-8c26f414.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../../modules/index-8356a01a.js";
function Ve(f) {
  return x({ module: "plan", url: "enclosureStandardPart", method: "get", params: f });
}
function Ue(f) {
  return x({ module: "plan", url: "enclosureStandardPart", method: "put", data: [f] });
}
function Ce(f) {
  return x({ module: "plan", url: "enclosureStandardPart", method: "post", data: f });
}
function Ee(f) {
  return x({ module: "plan", url: "enclosureStandardPart", method: "delete", data: f });
}
const E = { get: Ve, edit: Ue, del: Ee, add: Ce };
const Pe = { class: "app-container" }, Se = { class: "head-container" }, Oe = { key: 1 }, Re = { key: 1 }, Ne = { key: 1 }, Me = { key: 0, style: { display: "flex", "justify-content": "center", "align-items": "center" } }, Te = { key: 1 }, Ie = { key: 1 }, je = { key: 1 }, we = { key: 1 }, Le = { key: 1, style: { color: "red", "font-size": "13px" } }, qe = { __name: "index", setup(f) {
  const { globalProject: P, globalProjectId: z } = fe(["globalProject", "globalProjectId"]), B = { add: true, edit: false, del: false, download: false }, S = p(), O = p({}), F = p([]), R = p(false), N = p(false), H = p({}), M = p([]);
  h.PROFILED_PLATE.V, h.PRESSURE_BEARING_PLATE.V, h.TRUSS_FLOOR_PLATE.V, h.SANDWICH_BOARD.V, h.BENDING.V;
  const { crud: y, columns: _, CRUD: V } = ye({ title: "围护配套件清单", sort: ["id.desc"], permission: { ...v }, optShow: { ...B }, requiredQuery: ["projectId"], crudApi: { ...E }, hasPagination: true, queryOnPresenterCreated: false }, S), { maxHeight: $ } = _e({ wrapperBox: ".plan-standard-part", paginate: true, extraHeight: 40 }), G = p([{ value: true, label: "重量" }, { value: false, label: "其它" }]), J = p([{ value: "吨", label: "吨" }, { value: "千克", label: "千克" }]), { enclosureDictList: W } = ge();
  ne(() => P.value, (l) => {
    var o;
    F.value = [], he(l) && (R.value = (o = l.projectContentList) == null ? void 0 : o.length);
  }, { deep: true, immediate: true }), ie("globalProject", P);
  const T = { useProperty: [{ required: true, message: "请输入选择使用范围", trigger: "change" }], name: [{ required: true, message: "请输入名称", trigger: "blur" }], specification: [{ required: true, message: "请输入规格", trigger: "blur" }], measureUnit: [{ required: true, message: "请输入单位", trigger: "blur" }], quantity: [{ required: true, message: "请输入数量", trigger: "change" }] };
  function K(l) {
    M.value = l;
  }
  function Q({ row: l, column: o }) {
    if (!l) return;
    const i = T;
    let r = true;
    return l.verify && Object.keys(l.verify) && Object.keys(l.verify).length > 0 && (l.verify[o.property] === false && (r = D(o.property, i[o.property], l)), r && (l.verify[o.property] = true)), r ? "" : "mask-td";
  }
  function Y(l) {
    O.value = JSON.parse(JSON.stringify(l)), l.isModify = true;
  }
  async function X(l) {
    try {
      await E.del([l.id]), y.notify("删除成功", V.NOTIFICATION_TYPE.SUCCESS), y.toQuery();
    } catch (o) {
      console.log("删除", o);
    }
  }
  function Z(l) {
    l = Object.assign(l, JSON.parse(JSON.stringify(O.value))), l.isModify = false;
  }
  async function ee(l) {
    const o = T;
    let i = true;
    l.verify = {};
    for (const r in o) l.verify[r] = D(r, o[r], l), l.verify[r] || (i = false);
    if (!i) {
      re.error("请填写表格中标红数据");
      return;
    }
    try {
      await E.edit(l), y.notify("修改成功", V.NOTIFICATION_TYPE.SUCCESS), l.isModify = false;
    } catch (r) {
      console.log("修改", r);
    }
  }
  return V.HOOK.handleRefresh = (l, o) => {
    o.data.content.map((i) => (i.projectId = i.project.id, i));
  }, (l, o) => {
    const i = ue, r = de, I = k("common-input-number"), U = k("common-select"), b = k("common-button"), te = ce, le = k("common-table"), ae = se("permission"), oe = pe;
    return t(), u("div", Pe, [R.value ? (t(), u(C, { key: 0 }, [j("div", Se, [c(a(ke), { "project-id": a(z), typeOption: a(W), onEnclosurePlan: K }, null, 8, ["project-id", "typeOption"])]), w((t(), s(le, { ref_key: "tableRef", ref: S, "cell-class-name": Q, data: a(y).data, "empty-text": a(y).emptyText, "max-height": a($), class: "enclosure-table", "return-source-data": "", style: { width: "100%" }, onSortChange: a(y).handleSortChange }, { default: d(() => [c(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), a(_).visible("name") ? (t(), s(i, { key: 0, "show-overflow-tooltip": true, align: "center", fixed: "left", label: "名称", "min-width": "150", prop: "name" }, { default: d(({ row: e }) => [e.isModify ? (t(), s(r, { key: 0, modelValue: e.name, "onUpdate:modelValue": (n) => e.name = n, modelModifiers: { trim: true }, maxlength: "20", placeholder: "名称", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), u("span", Oe, g(e.name), 1))]), _: 1 })) : m("", true), a(_).visible("specification") ? (t(), s(i, { key: 1, "show-overflow-tooltip": true, align: "center", label: "规格", "min-width": "200px", prop: "specification" }, { default: d(({ row: e }) => [e.isModify ? (t(), s(r, { key: 0, modelValue: e.specification, "onUpdate:modelValue": (n) => e.specification = n, modelModifiers: { trim: true }, maxlength: "20", placeholder: "规格", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), u("span", Re, g(e.specification), 1))]), _: 1 })) : m("", true), a(_).visible("measureUnit") ? (t(), s(i, { key: 2, "show-overflow-tooltip": true, align: "center", label: "单位", "min-width": "70px", prop: "measureUnit" })) : m("", true), a(_).visible("quantity") ? (t(), s(i, { key: 3, "show-overflow-tooltip": true, align: "center", label: "数量", prop: "quantity" }, { default: d(({ row: e }) => [e.isModify ? (t(), s(I, { key: 0, modelValue: e.quantity, "onUpdate:modelValue": (n) => e.quantity = n, controls: false, max: 999999999, min: 0, step: 1, placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), u("span", Ne, g(e.quantity), 1))]), _: 1 })) : m("", true), a(_).visible("accountingUnit") ? (t(), s(i, { key: 4, "show-overflow-tooltip": true, align: "center", label: "核算单位", "min-width": "180px", prop: "accountingUnit" }, { default: d(({ row: e }) => [e.isModify ? (t(), u("div", Me, [j("div", null, [e.boolWeightTypeEnum ? (t(), s(U, { key: 1, modelValue: e.accountingUnit, "onUpdate:modelValue": (n) => e.accountingUnit = n, "data-structure": { key: "value", label: "label", value: "value" }, options: J.value, placeholder: "核算单位", style: { width: "100px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (t(), s(r, { key: 0, modelValue: e.accountingUnit, "onUpdate:modelValue": (n) => e.accountingUnit = n, modelModifiers: { trim: true }, maxlength: "20", placeholder: "核算单位", style: { width: "100px" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), c(U, { modelValue: e.boolWeightTypeEnum, "onUpdate:modelValue": (n) => e.boolWeightTypeEnum = n, "data-structure": { key: "value", label: "label", value: "value" }, options: G.value, style: { width: "100px", "margin-left": "10px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])) : (t(), u("span", Te, g(e.accountingUnit), 1))]), _: 1 })) : m("", true), a(_).visible("mete") ? (t(), s(i, { key: 5, "show-overflow-tooltip": true, align: "center", label: "核算量", "min-width": "120px", prop: "mete" }, { default: d(({ row: e }) => [e.isModify ? (t(), s(I, { key: 0, modelValue: e.mete, "onUpdate:modelValue": (n) => e.mete = n, controls: false, max: 9999999, min: 0, precision: 3, step: 1e-3, placeholder: "核算量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), u("span", Ie, g(e.mete), 1))]), _: 1 })) : m("", true), a(_).visible("useProperty") ? (t(), s(i, { key: 6, align: "center", label: "使用范围", "min-width": "120px", prop: "useProperty" }, { default: d(({ row: e }) => [e.isModify ? (t(), s(U, { key: 0, modelValue: e.useProperty, "onUpdate:modelValue": (n) => e.useProperty = n, options: a(q).ENUM, clearable: "", placeholder: "使用范围", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (t(), u("span", je, g(a(q).VL[e.useProperty]), 1))]), _: 1 })) : m("", true), c(i, { "show-overflow-tooltip": true, align: "center", label: "备注", "min-width": "120px", prop: "remark" }, { default: d(({ row: e }) => [e.isModify ? (t(), s(r, { key: 0, modelValue: e.remark, "onUpdate:modelValue": (n) => e.remark = n, modelModifiers: { trim: true }, autosize: { minRows: 1, maxRows: 6 }, maxlength: 200, placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), u("span", we, g(e.remark), 1))]), _: 1 }), a(A)([...a(v).edit, ...a(v).del]) ? (t(), s(i, { key: 7, align: "center", fixed: "right", label: "操作", width: "180px" }, { default: d((e) => [e.row.isModify ? (t(), u(C, { key: 0 }, [c(b, { size: "default", type: "info", onClick: (n) => Z(e.row) }, { default: d(() => o[1] || (o[1] = [L("取消")])), _: 2, __: [1] }, 1032, ["onClick"]), c(b, { size: "default", type: "primary", onClick: (n) => ee(e.row) }, { default: d(() => o[2] || (o[2] = [L("保存")])), _: 2, __: [2] }, 1032, ["onClick"])], 64)) : (t(), u(C, { key: 1 }, [w(c(b, { icon: "el-icon-edit", size: "default", type: "primary", onClick: (n) => Y(e.row) }, null, 8, ["onClick"]), [[ae, a(v).edit]]), a(A)(a(v).del) ? (t(), s(te, { key: 0, "cancel-button-text": "取消", "confirm-button-text": "确定", "icon-color": "red", title: "确定删除吗?", onConfirm: (n) => X(e.row) }, { reference: d(() => [c(b, { icon: "el-icon-delete", size: "default", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : m("", true)], 64))]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[oe, a(y).loading]]), c(a(ve)), c(a(xe), { enclosurePlan: M.value }, null, 8, ["enclosurePlan"]), c(be, { visible: N.value, "onUpdate:visible": o[0] || (o[0] = (e) => N.value = e), detailInfo: H.value }, null, 8, ["visible", "detailInfo"])], 64)) : (t(), u("span", Le, "当前项目内容没有包含围护制品，请到合同管理中进行配置"))]);
  };
} }, Ke = me(qe, [["__scopeId", "data-v-c61889ed"]]);
export {
  Ke as default
};
