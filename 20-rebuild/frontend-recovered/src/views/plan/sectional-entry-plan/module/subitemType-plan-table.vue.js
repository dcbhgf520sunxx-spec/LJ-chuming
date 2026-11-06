import { ref as U } from "vue";
import { inject as le } from "vue";
import { resolveComponent as D } from "vue";
import { withDirectives as oe } from "vue";
import { openBlock as a } from "vue";
import { createBlock as r } from "vue";
import { withCtx as i } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as c } from "vue";
import { createElementBlock as s } from "vue";
import { withModifiers as g } from "vue";
import { createCommentVNode as y } from "vue";
import { normalizeStyle as ie } from "vue";
import { unref as f } from "vue";
import { Fragment as de } from "vue";
import { reactive as se } from "vue";
import { ElTableColumn as re } from "element-plus";
import { ElInput as ue } from "element-plus";
import { Plus as ce } from "@element-plus/icons-vue";
import { ElIcon as pe } from "element-plus";
import { Minus as me } from "@element-plus/icons-vue";
import { ElDatePicker as ye } from "element-plus";
import { ElTooltip as fe } from "element-plus";
import { vLoading as _e } from "element-plus";
import { _ as ge, kQ as x, mw as P, aw as he, aI as be, V as ke, c7 as S, p as E } from "../../../../shared/runtime.js";
const ve = { class: "flex-rbc" }, De = { key: 0 }, xe = { class: "flex-r" }, Ee = ["onClick"], Ve = ["onClick"], Ce = { key: 0 }, Pe = { key: 1 }, Me = { key: 0 }, je = { key: 1 }, Te = { key: 0 }, Le = { key: 0 }, Ue = { key: 0 }, Se = { key: 0 }, Ie = { key: 1 }, $e = { key: 0 }, qe = { __name: "subitemType-plan-table", props: { monomerList: { type: Array, default: () => [] }, maxHeight: { type: Number }, fetchMonomerLoading: { type: Boolean, default: false } }, emits: ["to-edit-monomer", "area-row-watch", "del-row", "virtual-del-row", "undelete"], setup(V, { expose: I, emit: $ }) {
  const k = $, q = U([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), M = le("projectInfo"), C = U([]), N = { name: [{ required: true, message: "请填写区段名称", trigger: "blur" }], projectPlanProductCategory: [{ required: true, message: "请选择分项分类", trigger: "change" }], budgetVolume: [{ required: true, message: "请输入预算量", trigger: "blur" }], deliveryDate: [{ required: true, message: "请选择日期", trigger: "change" }], productionWay: [{ required: true, message: "请选择自制或外协", trigger: "change" }] }, { tableValidate: R, wrongCellMask: W } = he({ rules: N });
  function z({ row: t, column: n, rowIndex: o, columnIndex: u }) {
    if (t.operateType === "del") return { color: "#ccc", background: "#f2f2f2", cursor: "not-allowed" };
  }
  function A(t) {
    k("to-edit-monomer", t);
  }
  function B(t) {
    var o, u;
    C.value.indexOf(t.uid) === -1 && C.value.push(t.uid), t.areaList || (t.areaList = []);
    const n = se({ uid: be(), idx: t.idx + "." + (((o = t.areaList) == null ? void 0 : o.length) + 1), name: void 0, projectPlanProductCategory: void 0, startDate: void 0, endDate: void 0, remark: void 0, mete: void 0, deepenStartDate: void 0, deepenEndDate: void 0, purchaseStartDate: void 0, purchaseEndDate: void 0, installStartDate: void 0, installEndDate: void 0, isEdit: true, isPlanEdit: true, productionWay: P.HOMEMADE.V });
    (u = t.areaList) == null || u.push(n), k("area-row-watch", n, t);
  }
  function H(t) {
    t.isEdit = true, t.sourceRow = ke({ name: t.name, projectPlanProductCategory: t.projectPlanProductCategory, mete: t.mete, remark: t.remark, type: t.type });
  }
  function O(t, n) {
    t ? (n.deliveryStartDate = t[0], n.deliveryEndDate = t[1], n.deliveryDuration = S(t[0], t[1])) : (n.deliveryStartDate = void 0, n.deliveryEndDate = void 0, n.deliveryDuration = void 0);
  }
  function F(t) {
    var n;
    if (((n = t.areaList) == null ? void 0 : n.length) > 0) {
      const o = [], u = [];
      t.areaList.forEach((b) => {
        b.deliveryStartDate && o.push(b.deliveryStartDate), b.deliveryEndDate && u.push(b.deliveryEndDate);
      });
      const h = o.length > 0 ? Math.min(...o) : "", _ = u.length > 0 ? Math.max(...u) : "";
      return h && _ ? (t.deliveryDuration = S(h, _), t.deliveryStartDate = h, t.deliveryEndDate = _, E(h, "{y}-{m}-{d}") + " ~ " + E(_, "{y}-{m}-{d}")) : (t.deliveryDuration = "", "-");
    } else return t.deliveryStartDate && t.deliveryEndDate ? E(t.deliveryStartDate, "{y}-{m}-{d}") + " ~ " + E(t.deliveryEndDate, "{y}-{m}-{d}") : "-";
  }
  function K(t) {
    return t < /* @__PURE__ */ new Date(M.value.startDate + " 00:00:00") || t > /* @__PURE__ */ new Date(M.value.endDate + " 00:00:00");
  }
  function Q(t) {
    Object.assign(t, t.sourceRow), t.isEdit = false;
  }
  function G(t, n) {
    k("del-row", t, n);
  }
  function J(t) {
    k("virtual-del-row", t);
  }
  function X(t) {
    k("undelete", t);
  }
  return I({ tableValidate: R }), (t, n) => {
    const o = re, u = ue, h = ce, _ = pe, b = me, Y = D("common-select"), Z = D("common-input-number"), w = D("common-radio-button"), ee = ye, v = D("common-button"), j = fe, te = D("common-table"), ae = _e;
    return oe((a(), r(te, { ref: "tableRef", data: V.monomerList, "empty-text": "暂无数据", "max-height": V.maxHeight, "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" }, "row-key": "uid", stripe: false, "expand-row-keys": C.value, "default-expand-all": "", "cell-class-name": f(W), "cell-style": z, "tree-props": { children: "areaList" }, class: "subitemType-plan-table-wrapper table-input-border-none" }, { default: i(() => [d(o, { label: "序号", prop: "idx", align: "center", width: "55" }, { default: i(({ row: e }) => [m("span", null, c(e.idx), 1)]), _: 1 }), d(o, { prop: "name", "show-overflow-tooltip": true, "min-width": "130px" }, { header: i(() => n[0] || (n[0] = [m("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), m("span", null, "单体/区段", -1)])), default: i(({ row: e, $index: l }) => [m("div", ve, [e.isMonomer || !e.isEdit ? (a(), s("span", De, c(e.name), 1)) : (a(), r(u, { key: 1, modelValue: e.name, "onUpdate:modelValue": (p) => e.name = p, size: "default", maxlength: 64, class: "input-border-none", clearable: "", placeholder: "区段", style: { flex: "1" } }, null, 8, ["modelValue", "onUpdate:modelValue"])), m("div", xe, [e.isMonomer ? (a(), s("div", { key: 0, class: "add-btn", onClick: g((p) => B(e), ["stop"]) }, [d(_, null, { default: i(() => [d(h)]), _: 1 })], 8, Ee)) : y("", true), e.isEdit && !e.id ? (a(), s("div", { key: 1, class: "del-btn", style: ie({ "margin-right": e.isMonomer ? "" : "10px", "margin-left": e.isMonomer ? "5px" : "" }), onClick: g((p) => G(e, l), ["stop"]) }, [d(_, null, { default: i(() => [d(b)]), _: 1 })], 12, Ve)) : y("", true)])])]), _: 1 }), d(o, { key: "projectPlanProductCategory", prop: "projectPlanProductCategory", align: "center", label: "", width: "150px" }, { header: i(() => n[1] || (n[1] = [m("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), m("span", null, "类别", -1)])), default: i(({ row: e }) => [e.isMonomer ? (a(), s("span", Ce)) : y("", true), !e.isMonomer && !e.isEdit ? (a(), s("span", Pe, c(parseInt(e.projectPlanProductCategory) ? f(x).VL[e.projectPlanProductCategory] : e.projectPlanProductCategory), 1)) : y("", true), !e.isMonomer && e.isEdit ? (a(), r(Y, { key: 2, modelValue: e.projectPlanProductCategory, "onUpdate:modelValue": (l) => e.projectPlanProductCategory = l, options: f(x).ENUM, type: "enum", size: "default", clearable: "", class: "input-border-none", placeholder: "类别", style: { width: "100%" }, disabled: e.haveDetailedList === 1 }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"])) : y("", true)]), _: 1 }), d(o, { prop: "unit", align: "center", label: "单位", width: "90px" }, { default: i(({ row: e }) => {
      var l, p;
      return [e.projectPlanProductCategory ? (a(), s("span", Me, c(((p = (l = f(x).V) == null ? void 0 : l[e.projectPlanProductCategory]) == null ? void 0 : p.unit) || "-"), 1)) : (a(), s("span", je))];
    }), _: 1 }), d(o, { key: "budgetVolume", prop: "budgetVolume", label: "预算量", align: "center", width: "130px" }, { header: i(() => n[2] || (n[2] = [m("span", { style: { color: "#ff4949", "margin-right": "4px" } }, "*", -1), m("span", null, "预算量", -1)])), default: i(({ row: e }) => {
      var l, p, T, L;
      return [e.isMonomer || !e.isEdit ? (a(), s("span", Te, c(e.budgetVolume) + c((p = (l = f(x).V) == null ? void 0 : l[e.projectPlanProductCategory]) == null ? void 0 : p.unit), 1)) : (a(), r(Z, { key: 1, modelValue: e.budgetVolume, "onUpdate:modelValue": (ne) => e.budgetVolume = ne, step: 1, min: 0, precision: 2, size: "default", controls: false, class: "input-border-none", clearable: "", placeholder: `单位：${((L = (T = f(x).V) == null ? void 0 : T[e.projectPlanProductCategory]) == null ? void 0 : L.unit) || "-"}`, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"]))];
    }), _: 1 }), d(o, { key: "productionWay", prop: "productionWay", label: "自制或外协", align: "center", width: "150px" }, { default: i(({ row: e }) => [e.isMonomer || !e.isEdit ? (a(), s("span", Le, c(f(P).VL[e.productionWay]), 1)) : (a(), r(w, { key: 1, modelValue: e.productionWay, "onUpdate:modelValue": (l) => e.productionWay = l, options: f(P).ENUM, size: "default", type: "enum", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]))]), _: 1 }), d(o, { key: "deliveryDate", prop: "deliveryDate", label: "交货期", align: "center", width: "260px" }, { default: i(({ row: e }) => [e.isMonomer || !e.isEdit ? (a(), s("span", Ue, c(F(e)), 1)) : (a(), r(ee, { key: 1, modelValue: e.deliveryDate, "onUpdate:modelValue": (l) => e.deliveryDate = l, "default-time": q.value, type: "daterange", "range-separator": ":", class: "filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", "disabled-date": K, style: { width: "230px" }, onChange: (l) => O(l, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "default-time", "onChange"]))]), _: 1 }), d(o, { key: "deliveryDuration", prop: "deliveryDuration", label: "工期", align: "center", width: "150px" }, { default: i(({ row: e }) => [e.deliveryDuration ? (a(), s("span", Se, c(e.deliveryDuration) + " 天 ", 1)) : (a(), s("span", Ie, "-"))]), _: 1 }), d(o, { prop: "remark", label: "备注", "show-overflow-tooltip": true, "min-width": "160px" }, { default: i(({ row: e }) => [e.isMonomer || !e.isEdit ? (a(), s("span", $e, c(e.remark), 1)) : (a(), r(u, { key: 1, modelValue: e.remark, "onUpdate:modelValue": (l) => e.remark = l, size: "default", maxlength: 200, class: "input-border-none", "show-word-limit": "", clearable: "", placeholder: "备注", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), d(o, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: i(({ row: e }) => [e.operateType !== "del" ? (a(), s(de, { key: 0 }, [e.isMonomer ? (a(), r(v, { key: 0, type: "primary", icon: "el-icon-edit", onClick: g((l) => A(e), ["stop"]) }, null, 8, ["onClick"])) : y("", true), e.id && !e.isEdit && !e.isMonomer ? (a(), r(v, { key: 1, disabled: e.isEdit, type: "primary", icon: "el-icon-edit", onClick: g((l) => H(e), ["stop"]) }, null, 8, ["disabled", "onClick"])) : y("", true), e.id && e.isEdit && !e.isMonomer ? (a(), r(j, { key: 2, effect: "dark", content: "取消编辑", placement: "left" }, { default: i(() => [d(v, { type: "info", icon: "el-icon-close", onClick: g((l) => Q(e), ["stop"]) }, null, 8, ["onClick"])]), _: 2 }, 1024)) : y("", true), e.operateType !== "add" ? (a(), r(v, { key: 3, type: "danger", icon: "el-icon-delete", disabled: e.isEdit || e.haveDetailedList === 1, onClick: g((l) => J(e), ["stop"]) }, null, 8, ["disabled", "onClick"])) : y("", true)], 64)) : (a(), r(j, { key: 1, effect: "dark", content: "撤销删除", placement: "left" }, { default: i(() => [d(v, { type: "warning", icon: "el-icon-refresh-left", disabled: !e.isMonomer && !e.canUnDel, onClick: g((l) => X(e), ["stop"]) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1024))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys", "cell-class-name"])), [[ae, V.fetchMonomerLoading]]);
  };
} }, We = ge(qe, [["__scopeId", "data-v-683f43e0"]]);
export {
  We as default
};
