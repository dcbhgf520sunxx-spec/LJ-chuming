import { inject as le } from "vue";
import { ref as k } from "vue";
import { reactive as ae } from "vue";
import { computed as oe } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as u } from "vue";
import { createBlock as b } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as O } from "vue";
import { withDirectives as ne } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementBlock as R } from "vue";
import { Fragment as ie } from "vue";
import { renderList as se } from "vue";
import { createElementVNode as P } from "vue";
import { withModifiers as L } from "vue";
import { nextTick as re } from "vue";
import { ElTableColumn as de } from "element-plus";
import { ElInput as ce } from "element-plus";
import { ElInputNumber as ue } from "element-plus";
import { ElDatePicker as me } from "element-plus";
import { Delete as pe } from "@element-plus/icons-vue";
import { ElIcon as fe } from "element-plus";
import { ElForm as _e } from "element-plus";
import { vLoading as ge } from "element-plus";
import { _ as Ve, a_ as ye, o as be, dj as c, i as z, aw as he } from "../../../../../../shared/runtime.js";
const Ee = ["onClick"], ve = 5, we = { __name: "batch-form", props: { modelValue: { type: Boolean, require: true }, line: { type: Object, default: () => {
} } }, setup(m) {
  const h = m, F = le("firstLevelDeptOptions"), Y = k(false), C = k(true), H = ae({ list: [] }), M = { parentId: [{ validator: (l, e) => {
    var r;
    return ((r = h.line) == null ? void 0 : r.fieldEnumType) === c.SECOND_LEVEL_DEPT.V ? !!l : true;
  }, message: "请选择所属一级部门", trigger: "change" }], fieldValue: [{ required: true, message: "请填写名称", trigger: "blur" }], fieldSort: [{ required: true, message: "请填写排序", trigger: "blur" }] }, S = k(), { CRUD: T, crud: p, form: s } = ye(H, S), D = oe(() => p.bStatus.cu > T.STATUS.NORMAL), { tableValidate: j, cleanUpData: q, wrongCellMask: $ } = he({ rules: M }), { maxHeight: A } = be({ mainBox: ".catalog-content-detail-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, D);
  function J() {
    G(s.list), C.value = true, re(() => {
      C.value = false;
    });
  }
  T.HOOK.beforeValidateBCU = () => {
    var e, r, d, E;
    const { validResult: l } = j(s.list);
    if (l) q(s.list), (((e = h.line) == null ? void 0 : e.V) === c.FIRST_LEVEL_DEPT.V || ((r = h.line) == null ? void 0 : r.V) === c.SECOND_LEVEL_DEPT.V) && ((d = s.list) == null || d.forEach((g) => {
      var V;
      g.deptJson = {}, (V = g.yearTarget) == null || V.forEach((f) => {
        f.year && f.weight && (g.deptJson[f.year] = f.weight);
      });
    })), s.fieldEnumType = (E = h.line) == null ? void 0 : E.V;
    else return l;
  };
  const G = (l) => {
    l.length = 0;
    for (let e = 0; e < ve; e++) U(l);
  }, U = (l) => {
    const e = {};
    l.push(e);
  }, B = (l, e) => {
    l.splice(e, 1);
  };
  function K(l, e) {
    z(l[e].yearTarget) ? l[e].yearTarget.push({}) : l[e].yearTarget = [{}];
  }
  return (l, e) => {
    const r = v("common-button"), d = de, E = v("common-select"), g = ce, V = ue, f = me, Q = pe, W = fe, X = v("common-table"), Z = _e, ee = v("common-dialog"), te = ge;
    return u(), b(ee, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(p).cancelBCU, visible: D.value, title: `${t(p).bStatus.title}`, "show-close": false, "custom-class": "catalog-content-detail-batch-add", onOpened: J, width: "1200px", top: "10vh" }, { titleRight: i(() => [a(r, { size: "default", type: "success", icon: "el-icon-plus", onClick: e[0] || (e[0] = (x) => U(t(s).list)) }), a(r, { loading: t(p).bStatus.cu === t(T).STATUS.PROCESSING, type: "primary", size: "default", onClick: t(p).submitBCU }, { default: i(() => e[1] || (e[1] = [O(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), a(r, { size: "default", onClick: t(p).cancelBCU }, { default: i(() => e[2] || (e[2] = [O("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: i(() => [a(Z, { ref_key: "formRef", ref: S, model: t(s), disabled: Y.value }, { default: i(() => [ne((u(), b(X, { ref: "table", data: t(s).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": t(A), "cell-class-name": t($), "row-key": "uid" }, { default: i(() => {
      var x, I, N;
      return [a(d, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), ((x = m.line) == null ? void 0 : x.V) === t(c).SECOND_LEVEL_DEPT.V ? (u(), b(d, { key: 0, prop: "parentId", "show-overflow-tooltip": true, label: "一级部门", align: "center" }, { default: i(({ row: o }) => [a(E, { modelValue: o.parentId, "onUpdate:modelValue": (n) => o.parentId = n, options: t(F), dataStructure: { key: "id", label: "fieldValue", value: "id" }, clearable: "", class: "filter-item", placeholder: "一级部门", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 })) : w("", true), a(d, { prop: "fieldValue", "show-overflow-tooltip": true, label: "名称", align: "center" }, { default: i(({ row: o }) => [a(g, { modelValue: o.fieldValue, "onUpdate:modelValue": (n) => o.fieldValue = n, placeholder: "输入名称", class: "filter-item", style: { width: "100%" }, size: "default", clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(d, { prop: "fieldSort", "show-overflow-tooltip": true, label: "排序", align: "center" }, { default: i(({ row: o }) => [a(V, { class: "align-left", modelValue: o.fieldSort, "onUpdate:modelValue": (n) => o.fieldSort = n, placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "100%" }, min: 0, max: 1e3 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), ((I = m.line) == null ? void 0 : I.V) === t(c).FIRST_LEVEL_DEPT.V || ((N = m.line) == null ? void 0 : N.V) === t(c).SECOND_LEVEL_DEPT.V ? (u(), b(d, { key: 1, prop: "year", width: "350", "show-overflow-tooltip": true, label: "目标任务", align: "center" }, { default: i(({ row: o }) => [t(z)(o.yearTarget) ? (u(true), R(ie, { key: 0 }, se(o.yearTarget, (n, y) => (u(), R("div", { style: { display: "flex" }, key: y }, [a(f, { modelValue: n.year, "onUpdate:modelValue": (_) => n.year = _, type: "year", size: "default", style: { width: "150px !important" }, format: "YYYY", clearable: true, "value-format": "YYYY", placeholder: "选择年" }, null, 8, ["modelValue", "onUpdate:modelValue"]), P("div", null, [a(V, { modelValue: n.weight, "onUpdate:modelValue": (_) => n.weight = _, placeholder: "目标任务（万元）", type: "text", size: "default", "controls-position": "right", style: { width: "150px", margin: "0 3px" }, min: 0, max: 9999999999 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), P("div", { onClick: L((_) => B(t(s).yearTarget, y), ["stop"]) }, [a(W, { style: { color: "#f56c6c", "font-size": "16px", "margin-top": "5px" } }, { default: i(() => [a(Q)]), _: 1 })], 8, Ee)]))), 128)) : w("", true)]), _: 1 })) : w("", true), a(d, { label: "操作", width: "110px", align: "center" }, { default: i(({ $index: o }) => {
        var n, y;
        return [((n = m.line) == null ? void 0 : n.V) === t(c).FIRST_LEVEL_DEPT.V || ((y = m.line) == null ? void 0 : y.V) === t(c).SECOND_LEVEL_DEPT.V ? (u(), b(r, { key: 0, type: "primary", icon: "el-icon-plus", size: "default", style: { padding: "6px" }, onClick: L((_) => K(t(s).list, o), ["stop"]) }, null, 8, ["onClick"])) : w("", true), a(r, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: L((_) => B(t(s).list, o), ["stop"]) }, null, 8, ["onClick"])];
      }), _: 1 })];
    }), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[te, C.value]])]), _: 1 }, 8, ["model", "disabled"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ke = Ve(we, [["__scopeId", "data-v-54619616"]]);
export {
  ke as default
};
