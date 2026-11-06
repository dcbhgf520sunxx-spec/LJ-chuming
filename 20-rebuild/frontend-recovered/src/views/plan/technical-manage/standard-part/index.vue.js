import { ref as g } from "vue";
import { provide as U } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as ne } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as m } from "vue";
import { unref as o } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as O } from "vue";
import { createTextVNode as j } from "vue";
import { ElMessage as ie } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElInput as se } from "element-plus";
import { ElPopconfirm as ue } from "element-plus";
import { vLoading as de } from "element-plus";
import { c as C } from "../../../../modules/standard-part-8c26f414.js";
import { _ as ce, m as me, x as pe, o as fe, i as I, tN as ye, tO as A, ky as q, G as R, P as ge, fK as z } from "../../../../shared/runtime.js";
import { G as h } from "../../../../modules/plan-d12d7ccf.js";
import _e from "./module/header.vue.js";
import be from "./module/form.vue.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../../modules/index-8356a01a.js";
const he = { class: "app-container" }, ve = { class: "head-container" }, ke = { key: 1 }, xe = { key: 1 }, Ve = { key: 1 }, Ue = { key: 0, style: { display: "flex", "justify-content": "center", "align-items": "center" } }, Ce = { key: 1 }, Ie = { key: 1 }, Me = { key: 1 }, Se = { key: 1 }, Pe = { __name: "index", setup(we) {
  const { globalProject: B, globalProjectId: D } = me(["globalProject", "globalProjectId"]), F = { add: true, edit: false, del: true, download: false }, L = g([{ value: true, label: "重量" }, { value: false, label: "其它" }]), H = g([{ value: "吨", label: "吨" }, { value: "千克", label: "千克" }]), M = g(), S = g({}), P = g({}), w = g({}), { crud: y, columns: p, CRUD: x } = pe({ title: "配套件清单", sort: ["id.desc"], permission: { ...h }, optShow: { ...F }, requiredQuery: ["projectId"], invisibleColumns: [], crudApi: { ...C }, hasPagination: true }, M), { maxHeight: $ } = fe({ wrapperBox: ".plan-standard-part", paginate: true, extraHeight: 40 }), J = g([["createTime", ["parse-time", "{y}-{m}-{d}"]]]);
  function G(a) {
    return !a.boolArtifactImport;
  }
  function W(a) {
    P.value = a;
  }
  function K(a) {
    w.value = a;
  }
  U("currentMonomer", P), U("globalProject", B), U("currentArea", w);
  const N = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], useProperty: [{ required: true, message: "请输入选择使用范围", trigger: "change" }], specification: [{ required: true, message: "请输入规格", trigger: "blur" }], measureUnit: [{ required: true, message: "请输入单位", trigger: "blur" }], quantity: [{ required: true, message: "请输入数量", trigger: "change" }] };
  function Q({ row: a, column: r }) {
    if (!a) return;
    const l = N;
    let d = true;
    return a.verify && Object.keys(a.verify) && Object.keys(a.verify).length > 0 && (a.verify[r.property] === false && (d = z(r.property, l[r.property], a)), d && (a.verify[r.property] = true)), d ? "" : "mask-td";
  }
  function Y(a) {
    S.value = JSON.parse(JSON.stringify(a)), a.isModify = true;
  }
  async function X(a) {
    try {
      await C.del([a.id]), y.notify("删除成功", x.NOTIFICATION_TYPE.SUCCESS), y.toQuery();
    } catch (r) {
      console.log("删除", r);
    }
  }
  function Z(a) {
    a = Object.assign(a, JSON.parse(JSON.stringify(S.value))), a.isModify = false;
  }
  async function ee(a) {
    const r = N;
    let l = true;
    a.verify = {};
    for (const d in r) a.verify[d] = z(d, r[d], a), a.verify[d] || (l = false);
    if (!l) {
      ie.error("请填写表格中标红数据");
      return;
    }
    try {
      await C.edit(a), y.notify("修改成功", x.NOTIFICATION_TYPE.SUCCESS), a.isModify = false;
    } catch (d) {
      console.log("修改", d);
    }
  }
  return x.HOOK.handleRefresh = (a, r) => {
    r.data.content.map((l) => (l.projectId = l.project.id, I(l.monomer) && (l.monomerId = l.monomer.id), I(l.area) && (l.areaId = l.area.id), l));
  }, (a, r) => {
    const l = re, d = _("table-cell-tag"), v = se, T = _("common-input-number"), V = _("common-select"), k = _("common-button"), te = ue, oe = _("common-table"), ae = ne("permission"), le = de;
    return t(), c("div", he, [b("div", ve, [m(o(_e), { "project-id": o(D), onCurrentChange: W, onCurrentAreaChange: K }, null, 8, ["project-id"])]), E((t(), n(oe, { ref_key: "tableRef", ref: M, data: o(y).data, "empty-text": o(y).emptyText, "data-format": J.value, "max-height": o($), "return-source-data": "", style: { width: "100%" }, onSortChange: o(y).handleSortChange, class: "enclosure-table", "cell-class-name": Q, onSelectionChange: o(y).selectionChangeHandler }, { default: s(() => [m(l, { key: "selection", type: "selection", width: "55", selectable: G }), m(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), o(p).visible("boolArtifactImport") ? (t(), n(l, { key: 0, "show-overflow-tooltip": true, prop: "boolArtifactImport", label: "来源", align: "center", "min-width": "120px", fixed: "left" }, { default: s(({ row: e }) => [b("span", null, f(o(ye).VL[e.boolArtifactImport] || "-"), 1)]), _: 1 })) : u("", true), o(p).visible("name") ? (t(), n(l, { key: 1, prop: "name", label: "名称", align: "center", fixed: "left", "min-width": "150", "show-overflow-tooltip": true }, { default: s(({ row: e }) => [!e.configStatus && !e.isModify ? (t(), n(d, { key: 0, name: "未配置", offset: 0 })) : u("", true), e.configStatus && !e.isModify && o(I)(e.boolInbound) ? (t(), n(d, { key: 1, name: o(A).VL[e.boolInbound], color: o(A).V[e.boolInbound].COLOR, offset: 0 }, null, 8, ["name", "color"])) : u("", true), b("span", null, f(e.name || "-"), 1)]), _: 1 })) : u("", true), o(p).visible("specification") ? (t(), n(l, { key: 2, "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", "min-width": "200px" }, { default: s(({ row: e }) => [e.isModify ? (t(), n(v, { key: 0, modelValue: e.specification, "onUpdate:modelValue": (i) => e.specification = i, modelModifiers: { trim: true }, type: "text", placeholder: "规格", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), c("span", ke, f(e.specification), 1))]), _: 1 })) : u("", true), o(p).visible("measureUnit") ? (t(), n(l, { key: 3, "show-overflow-tooltip": true, prop: "measureUnit", label: "计量单位", align: "center", "min-width": "70px" }, { default: s(({ row: e }) => [e.isModify ? (t(), n(v, { key: 0, modelValue: e.measureUnit, "onUpdate:modelValue": (i) => e.measureUnit = i, placeholder: "单位", type: "text", style: { width: "100%" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), c("span", xe, f(e.measureUnit), 1))]), _: 1 })) : u("", true), o(p).visible("quantity") ? (t(), n(l, { key: 4, "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center", "min-width": "120px" }, { default: s(({ row: e }) => [e.isModify ? (t(), n(T, { key: 0, modelValue: e.quantity, "onUpdate:modelValue": (i) => e.quantity = i, min: 0, max: 999999999, controls: false, precision: 3, step: 1e-3, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), c("span", Ve, f(e.quantity), 1))]), _: 1 })) : u("", true), o(p).visible("accountingUnit") ? (t(), n(l, { key: 5, "show-overflow-tooltip": true, prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "200px" }, { default: s(({ row: e }) => [e.isModify ? (t(), c("div", Ue, [b("div", null, [e.boolWeightTypeEnum ? (t(), n(V, { key: 1, style: { width: "100px" }, modelValue: e.accountingUnit, "onUpdate:modelValue": (i) => e.accountingUnit = i, placeholder: "核算单位", options: H.value, "data-structure": { key: "value", label: "label", value: "value" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (t(), n(v, { key: 0, modelValue: e.accountingUnit, "onUpdate:modelValue": (i) => e.accountingUnit = i, modelModifiers: { trim: true }, placeholder: "核算单位", type: "text", style: { width: "100px" }, maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), m(V, { modelValue: e.boolWeightTypeEnum, "onUpdate:modelValue": (i) => e.boolWeightTypeEnum = i, style: { width: "100px", "margin-left": "10px" }, options: L.value, "data-structure": { key: "value", label: "label", value: "value" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])) : (t(), c("span", Ce, f(e.accountingUnit), 1))]), _: 1 })) : u("", true), o(p).visible("mete") ? (t(), n(l, { key: 6, "show-overflow-tooltip": true, prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: s(({ row: e }) => [e.isModify ? (t(), n(T, { key: 0, modelValue: e.mete, "onUpdate:modelValue": (i) => e.mete = i, placeholder: "核算量", size: "default", controls: false, precision: 3, step: 1e-3, min: 0, max: 9999999 }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), c("span", Ie, f(e.mete), 1))]), _: 1 })) : u("", true), o(p).visible("useProperty") ? (t(), n(l, { key: 7, "show-overflow-tooltip": true, prop: "useProperty", label: "使用范围", align: "center", "min-width": "120px" }, { default: s(({ row: e }) => [e.isModify ? (t(), n(V, { key: 0, modelValue: e.useProperty, "onUpdate:modelValue": (i) => e.useProperty = i, options: o(q).ENUM, type: "enum", size: "default", clearable: "", placeholder: "使用范围" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (t(), c("span", Me, f(o(q).VL[e.useProperty]), 1))]), _: 1 })) : u("", true), o(p).visible("userName") ? (t(), n(l, { key: 8, "show-overflow-tooltip": true, prop: "userName", label: "导入人", align: "center", "min-width": "120px" })) : u("", true), o(p).visible("createTime") ? (t(), n(l, { key: 9, "show-overflow-tooltip": true, prop: "createTime", label: "导入时间", align: "center", "min-width": "120px" }, { default: s(({ row: e }) => [b("span", null, f(e.createTime), 1)]), _: 1 })) : u("", true), m(l, { prop: "remark", label: "备注", "show-overflow-tooltip": true, align: "center" }, { default: s(({ row: e }) => [e.isModify ? (t(), n(v, { key: 0, modelValue: e.remark, "onUpdate:modelValue": (i) => e.remark = i, modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 1, maxRows: 6 }, maxlength: 200, placeholder: "备注", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), c("span", Se, f(e.remark), 1))]), _: 1 }), o(R)([...o(h).edit, ...o(h).del]) ? (t(), n(l, { key: 10, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: s((e) => [e.row.isModify ? (t(), c(O, { key: 0 }, [m(k, { type: "info", size: "default", onClick: (i) => Z(e.row) }, { default: s(() => r[0] || (r[0] = [j("取消")])), _: 2, __: [0] }, 1032, ["onClick"]), m(k, { type: "primary", size: "default", onClick: (i) => ee(e.row) }, { default: s(() => r[1] || (r[1] = [j("保存")])), _: 2, __: [1] }, 1032, ["onClick"])], 64)) : (t(), c(O, { key: 1 }, [E(m(k, { size: "default", icon: "el-icon-edit", type: "primary", onClick: (i) => Y(e.row), disabled: e.row.boolArtifactImport || e.row.boolInbound }, null, 8, ["onClick", "disabled"]), [[ae, o(h).edit]]), o(R)(o(h).del) ? (t(), n(te, { key: 0, "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (i) => X(e.row) }, { reference: s(() => [m(k, { size: "default", icon: "el-icon-delete", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : u("", true)], 64))]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "onSortChange", "onSelectionChange"])), [[le, o(y).loading]]), m(o(ge)), m(o(be))]);
  };
} }, ze = ce(Pe, [["__scopeId", "data-v-615c5a8b"]]);
export {
  ze as default
};
