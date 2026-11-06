import { inject as V } from "vue";
import { ref as D } from "vue";
import { reactive as g } from "vue";
import { computed as M } from "vue";
import { watch as le } from "vue";
import { resolveComponent as F } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as o } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as x } from "vue";
import { renderSlot as ne } from "vue";
import { withDirectives as oe } from "vue";
import { unref as n } from "vue";
import { createBlock as U } from "vue";
import { createCommentVNode as ce } from "vue";
import { normalizeStyle as ie } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElInput as de } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElSwitch as re } from "element-plus";
import { ElCard as me } from "element-plus";
import { cH as pe, b as P, i as B, L as he, cI as fe, cJ as be, cK as w, aS as c, G as ve } from "../../../../../shared/runtime.js";
import { D as _e } from "../../../../../modules/index-fd3331da.js";
const Ve = { class: "card-header flex-css" }, ge = { class: "flex-rbc" }, Se = { class: "flex-rbc" }, ye = { class: "card-body" }, Ce = { key: 1 }, ke = { key: 1 }, Ue = { __name: "root-card", props: { level: { type: Number, default: 1 }, data: { type: Object, default: () => ({}) } }, emits: ["add", "del", "handleEdit", "changeBoolStatusSuccess"], setup(H, { emit: j }) {
  const L = V("permission"), O = V("crudApi"), T = V("maxHeight"), S = V("selectMap"), y = j, d = H, b = D(), u = g({ name: "", basicClass: void 0 }), l = g({ checkRow: null, rows: [], delBtn: false }), C = g({ rows: [], editBtn: false }), $ = g({ del: false }), k = M(() => `${pe(d.level)}级科目`), q = `此操作不可逆，确认删除【${k.value}】中选中的记录`, E = M(() => {
    var a;
    const e = ((a = d.data) == null ? void 0 : a.filter((s) => s.name.includes(u.name) && (P(u.basicClass) || s.basicClass === u.basicClass))) || [];
    return Y(e), e;
  });
  S[`current_list_LV${d.level}`] = E, le(E.value, (e) => {
    B(l.checkRow) && e.some((s) => l.checkRow.id !== s.id) || (l.checkRow = null);
  });
  async function G() {
    try {
      const e = l.rows.map((a) => a.id);
      await O.del(e);
    } catch (e) {
      console.log("删除科目", e);
    }
  }
  function A() {
    b.value.clearSelection(), l.delBtn = false;
  }
  function J() {
    A(), y("del");
  }
  const v = D([]);
  function N(e, a) {
    var _;
    const s = v.value.findIndex((r) => r.id === e.id);
    s !== -1 && v.value.splice(s, 1), v.value.push({ id: e.id, parentId: (_ = e.parent) == null ? void 0 : _.id, name: e.name, code: e.code }), e.serialNumber = `${B(e.parent) ? e.parent.serialNumber : ""}${e.code}`, C.rows = v.value;
  }
  function K(e) {
    B(l.checkRow) && l.checkRow.id === e.id ? (l.checkRow = null, b.value.setCurrentRow()) : l.checkRow = e, S[`current_LV${d.level}`] = l.checkRow;
  }
  function Y(e) {
    if (P(l.checkRow)) return;
    e.some((s) => s.id === l.checkRow.id) || Q();
  }
  function Q() {
    l.checkRow = null, b.value.setCurrentRow(), S[`current_LV${d.level}`] = l.checkRow;
  }
  function W(e) {
    l.rows = e;
  }
  async function X(e, a) {
    try {
      a ? I.confirm("是否要启用此科目(此操作会将其下科目全部启用)", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(() => {
        y("changeBoolStatusSuccess", e, d.level, a);
      }).catch(() => {
        e.boolStatus = e.boolStatus === c.TRUE.V ? c.FALSE.V : c.TRUE.V, z({ type: "info", message: "取消启用" });
      }) : I.confirm("是否要禁用此科目(此操作会将其下科目全部禁用)", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(() => {
        y("changeBoolStatusSuccess", e, d.level, a);
      }).catch(() => {
        e.boolStatus = e.boolStatus === c.TRUE.V ? c.FALSE.V : c.TRUE.V, z({ type: "info", message: "取消禁用" });
      });
    } catch (s) {
      console.log("申购单状态", s), e.boolStatus = e.boolStatus === c.TRUE.V ? c.FALSE.V : c.TRUE.V;
    }
  }
  return (e, a) => {
    const s = de, _ = F("common-select"), r = ue, Z = re, ee = F("common-table"), te = me, ae = se("permission");
    return p(), R("div", null, [o(te, { style: ie({ height: `${n(T)}px` }) }, { header: h(() => [f("div", Ve, [f("div", ge, [f("span", null, x(k.value), 1), f("div", null, [ne(e.$slots, "statusSearch"), oe(o(he, { fn: n(fe), class: "filter-item", "response-header-result": "" }, null, 8, ["fn"]), [[ae, n(L).get]])])]), f("div", Se, [o(s, { modelValue: u.name, "onUpdate:modelValue": a[0] || (a[0] = (t) => u.name = t), modelModifiers: { trim: true }, placeholder: `名称查询（${k.value}）`, class: "search-name", clearable: "", size: "default" }, null, 8, ["modelValue", "placeholder"]), o(_, { modelValue: u.basicClass, "onUpdate:modelValue": a[1] || (a[1] = (t) => u.basicClass = t), options: n(be).ENUM, class: "search-type", clearable: "", placeholder: "材料类型", size: "default", type: "enum" }, null, 8, ["modelValue", "options"])])])]), default: h(() => [f("div", ye, [o(ee, { ref_key: "tableRef", ref: b, data: E.value, "max-height": n(T) - 170, "show-empty-symbol": false, "empty-text": "暂无数据", "highlight-current-row": "", "return-source-data": "", "row-key": "id", onRowClick: a[2] || (a[2] = (t, i, m) => K(t, i, m, 1)), onSelectionChange: a[3] || (a[3] = (t) => W(t, 1)) }, { default: h(() => [l.delBtn ? (p(), U(r, { key: 0, align: "center", type: "selection", width: "45" })) : ce("", true), o(r, { label: "名称", "min-width": "110", prop: "name" }, { default: h(({ row: t, $index: i }) => [C.editBtn && (t.classifyUpdateStatus === n(w).ONLY_NAME_UPDATE.V || t.classifyUpdateStatus === n(w).ALL_UPDATE.V) ? (p(), U(s, { key: 0, modelValue: t.name, "onUpdate:modelValue": (m) => t.name = m, modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "名称", size: "default", style: { width: "100%" }, onChange: (m) => N(t, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (p(), R("span", Ce, x(t.name), 1))]), _: 1 }), o(r, { align: "center", label: "代码", "min-width": "90", prop: "code" }, { default: h(({ row: t, $index: i }) => [C.editBtn && t.classifyUpdateStatus === n(w).ALL_UPDATE.V ? (p(), U(s, { key: 0, modelValue: t.code, "onUpdate:modelValue": (m) => t.code = m, modelModifiers: { trim: true }, class: "filter-item", clearable: "", maxlength: "3", placeholder: "代码", size: "default", style: { width: "100%" }, onChange: (m) => N(t, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (p(), R("span", ke, x(t.code), 1))]), _: 1 }), o(r, { align: "center", label: "类型", prop: "basicClassName" }), o(r, { align: "center", label: "状态", prop: "boolStatus" }, { default: h(({ row: t }) => [o(Z, { modelValue: t.boolStatus, "onUpdate:modelValue": (i) => t.boolStatus = i, "active-value": n(c).TRUE.V, disabled: !n(ve)(n(L).editStatus), "inactive-value": n(c).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (i) => X(t, t.boolStatus) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])])]), _: 3 }, 8, ["style"]), o(_e, { modelValue: $.del, "onUpdate:modelValue": a[4] || (a[4] = (t) => $.del = t), fn: G, "fn-data": l.rows, tip: q, "show-exit": "", onExit: a[5] || (a[5] = (t) => A()), onSuccess: J }, null, 8, ["modelValue", "fn-data"])]);
  };
} };
export {
  Ue as default
};
