import { ref as Y } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as n } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as y } from "vue";
import { createElementBlock as p } from "vue";
import { withModifiers as f } from "vue";
import { createCommentVNode as r } from "vue";
import { normalizeStyle as w } from "vue";
import { unref as i } from "vue";
import { Fragment as ee } from "vue";
import { withDirectives as T } from "vue";
import { reactive as te } from "vue";
import { ElTableColumn as ne } from "element-plus";
import { ElInput as le } from "element-plus";
import { Plus as ae } from "@element-plus/icons-vue";
import { ElIcon as ie } from "element-plus";
import { Minus as se } from "@element-plus/icons-vue";
import { ElTooltip as oe } from "element-plus";
import { _ as de, ng as _, mw as x, aw as me, aI as pe, V as ue } from "../../../../../shared/runtime.js";
import { j as v } from "../../../../../modules/plan-d12d7ccf.js";
const ce = { class: "flex-rbc" }, re = { key: 0 }, _e = { class: "flex-r" }, ye = ["onClick"], fe = ["onClick"], be = { key: 0 }, he = { key: 1 }, ke = { key: 0 }, ge = { key: 1 }, xe = { key: 0 }, Ve = { key: 0 }, Ee = { key: 0 }, Te = { __name: "subitemType-plan-table", props: { monomerList: { type: Array, default: () => [] }, maxHeight: { type: Number } }, emits: ["to-edit-monomer", "area-row-watch", "del-row", "virtual-del-row", "undelete"], setup(C, { expose: L, emit: R }) {
  const h = R, V = Y([]), O = { name: [{ required: true, message: "请填写区段名称", trigger: "blur" }], itemizedType: [{ required: true, message: "请选择分项分类", trigger: "change" }], mete: [{ required: true, message: "请输入预算量", trigger: "blur" }] }, { tableValidate: S, wrongCellMask: N } = me({ rules: O });
  function I({ row: t, column: o, rowIndex: d, columnIndex: b }) {
    if (t.operateType === "del") return { color: "#ccc", background: "#f2f2f2", cursor: "not-allowed" };
  }
  function P(t) {
    h("to-edit-monomer", t);
  }
  function $(t) {
    var d, b;
    V.value.indexOf(t.uid) === -1 && V.value.push(t.uid), t.areaList || (t.areaList = []);
    const o = te({ uid: pe(), idx: t.idx + "." + (((d = t.areaList) == null ? void 0 : d.length) + 1), name: void 0, itemizedType: void 0, startDate: void 0, endDate: void 0, remark: void 0, mete: void 0, deepenStartDate: void 0, deepenEndDate: void 0, purchaseStartDate: void 0, purchaseEndDate: void 0, installStartDate: void 0, installEndDate: void 0, isEdit: true, isPlanEdit: true, type: x.HOMEMADE.V });
    (b = t.areaList) == null || b.push(o), h("area-row-watch", o, t);
  }
  function A(t) {
    t.isEdit = true, t.sourceRow = ue({ name: t.name, itemizedType: t.itemizedType, mete: t.mete, remark: t.remark, type: t.type });
  }
  function q(t) {
    Object.assign(t, t.sourceRow), t.isEdit = false;
  }
  function j(t, o) {
    h("del-row", t, o);
  }
  function B(t) {
    h("virtual-del-row", t);
  }
  function H(t) {
    h("undelete", t);
  }
  return L({ tableValidate: S }), (t, o) => {
    const d = ne, b = le, F = ae, M = ie, K = se, J = g("common-select"), G = g("common-input-number"), Q = g("common-radio-button"), k = g("common-button"), z = oe, W = g("common-table"), E = Z("permission");
    return n(), m(W, { ref: "tableRef", data: C.monomerList, "empty-text": "暂无数据", "max-height": C.maxHeight, "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" }, "row-key": "uid", stripe: false, "expand-row-keys": V.value, "default-expand-all": "", "cell-class-name": i(N), "cell-style": I, "tree-props": { children: "areaList" }, class: "subitemType-plan-table-wrapper" }, { default: a(() => [s(d, { label: "序号", prop: "idx", align: "center", width: "55" }, { default: a(({ row: e }) => [c("span", null, y(e.idx), 1)]), _: 1 }), s(d, { prop: "name", "show-overflow-tooltip": true, "min-width": "130px" }, { header: a(() => o[0] || (o[0] = [c("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), c("span", null, "单体/区段", -1)])), default: a(({ row: e, $index: l }) => [c("div", ce, [e.isMonomer || !e.isEdit ? (n(), p("span", re, y(e.name), 1)) : (n(), m(b, { key: 1, modelValue: e.name, "onUpdate:modelValue": (u) => e.name = u, size: "small", maxlength: 64, class: "input-border-none", clearable: "", placeholder: "区段", style: { flex: "1" } }, null, 8, ["modelValue", "onUpdate:modelValue"])), c("div", _e, [e.isMonomer ? (n(), p("div", { key: 0, class: "add-btn", onClick: f((u) => $(e), ["stop"]) }, [s(M, null, { default: a(() => [s(F)]), _: 1 })], 8, ye)) : r("", true), e.isEdit && !e.id ? (n(), p("div", { key: 1, class: "del-btn", style: w({ "margin-right": e.isMonomer ? "" : "10px", "margin-left": e.isMonomer ? "5px" : "" }), onClick: f((u) => j(e, l), ["stop"]) }, [s(M, null, { default: a(() => [s(K)]), _: 1 })], 12, fe)) : r("", true)])])]), _: 1 }), s(d, { prop: "itemizedType", align: "center", label: "", width: "150px" }, { header: a(() => o[1] || (o[1] = [c("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), c("span", null, "分项分类", -1)])), default: a(({ row: e }) => [e.isMonomer ? (n(), p("span", be, "-")) : r("", true), !e.isMonomer && !e.isEdit ? (n(), p("span", he, y(parseInt(e.itemizedType) ? i(_).VL[e.itemizedType] : e.itemizedType), 1)) : r("", true), !e.isMonomer && e.isEdit ? (n(), m(J, { key: 2, modelValue: e.itemizedType, "onUpdate:modelValue": (l) => e.itemizedType = l, options: i(_).ENUM, unshowOptions: [i(_).OTHERS.K], disabledVal: [i(_).PAINT_PROJECT.V, i(_).DOORS.V, i(_).ENCLOSURE.V], type: "enum", size: "small", clearable: "", class: "input-border-none", placeholder: "分项分类", style: { width: "100%" }, disabled: e.haveDetailedList === 1 }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshowOptions", "disabledVal", "disabled"])) : r("", true)]), _: 1 }), s(d, { prop: "unit", align: "center", label: "单位", width: "90px" }, { default: a(({ row: e }) => {
      var l, u;
      return [e.itemizedType ? (n(), p("span", ke, y((u = (l = i(_).V) == null ? void 0 : l[e.itemizedType]) == null ? void 0 : u.unit), 1)) : (n(), p("span", ge, "-"))];
    }), _: 1 }), s(d, { prop: "mete", label: "预算量", align: "center", width: "130px" }, { header: a(() => o[2] || (o[2] = [c("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), c("span", null, "预算量", -1)])), default: a(({ row: e }) => {
      var l, u, D, U;
      return [e.isMonomer || !e.isEdit ? (n(), p("span", xe, y(e.mete) + y((u = (l = i(_).V) == null ? void 0 : l[e.itemizedType]) == null ? void 0 : u.unit), 1)) : (n(), m(G, { key: 1, modelValue: e.mete, "onUpdate:modelValue": (X) => e.mete = X, step: 1, min: 0, precision: 2, size: "small", controls: false, class: "input-border-none", clearable: "", placeholder: `单位：${((U = (D = i(_).V) == null ? void 0 : D[e.itemizedType]) == null ? void 0 : U.unit) || "-"}`, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"]))];
    }), _: 1 }), s(d, { prop: "type", label: "外协/自制选项", align: "center", width: "150px" }, { default: a(({ row: e }) => [e.isMonomer || !e.isEdit ? (n(), p("span", Ve, y(i(x).VL[e.type]), 1)) : (n(), m(Q, { key: 1, modelValue: e.type, "onUpdate:modelValue": (l) => e.type = l, disabledVal: [i(x).OUTSOURCE.V], options: i(x).ENUM, size: "small", type: "enum", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledVal", "options"]))]), _: 1 }), s(d, { prop: "remark", label: "备注", "show-overflow-tooltip": true, "min-width": "160px" }, { default: a(({ row: e }) => [e.isMonomer || !e.isEdit ? (n(), p("span", Ee, y(e.remark), 1)) : (n(), m(b, { key: 1, modelValue: e.remark, "onUpdate:modelValue": (l) => e.remark = l, size: "small", maxlength: 200, class: "input-border-none", "show-word-limit": "", clearable: "", placeholder: "备注", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), s(d, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: a(({ row: e }) => [e.operateType !== "del" ? (n(), p(ee, { key: 0 }, [e.isMonomer ? T((n(), m(k, { key: 0, type: "primary", icon: "el-icon-edit", onClick: f((l) => P(e), ["stop"]) }, null, 8, ["onClick"])), [[E, i(v).edit]]) : r("", true), e.id && !e.isEdit && !e.isMonomer ? T((n(), m(k, { key: 1, disabled: e.isEdit, type: "primary", icon: "el-icon-edit", onClick: f((l) => A(e), ["stop"]) }, null, 8, ["disabled", "onClick"])), [[E, i(v).edit]]) : r("", true), e.id && e.isEdit && !e.isMonomer ? (n(), m(z, { key: 2, effect: "dark", content: "取消编辑", placement: "left" }, { default: a(() => [s(k, { type: "info", icon: "el-icon-close", onClick: f((l) => q(e), ["stop"]) }, null, 8, ["onClick"])]), _: 2 }, 1024)) : r("", true), e.operateType !== "add" ? T((n(), m(k, { key: 3, type: "danger", icon: "el-icon-delete", disabled: e.isMonomer && e.canDel || e.isEdit || e.haveDetailedList === 1, onClick: f((l) => B(e), ["stop"]) }, null, 8, ["disabled", "onClick"])), [[E, i(v).del]]) : r("", true)], 64)) : (n(), m(z, { key: 1, effect: "dark", content: "撤销删除", placement: "left" }, { default: a(() => [s(k, { type: "warning", icon: "el-icon-refresh-left", disabled: !e.isMonomer && !e.canUnDel, onClick: f((l) => H(e), ["stop"]) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1024))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys", "cell-class-name"]);
  };
} }, ze = de(Te, [["__scopeId", "data-v-b85ada8f"]]);
export {
  ze as default
};
