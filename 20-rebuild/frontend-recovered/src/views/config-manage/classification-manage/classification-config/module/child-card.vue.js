import { inject as C } from "vue";
import { ref as H } from "vue";
import { reactive as R } from "vue";
import { computed as k } from "vue";
import { watch as re } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as me } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as s } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as w } from "vue";
import { withDirectives as U } from "vue";
import { createTextVNode as pe } from "vue";
import { vShow as fe } from "vue";
import { unref as o } from "vue";
import { createBlock as D } from "vue";
import { createCommentVNode as he } from "vue";
import { normalizeStyle as ve } from "vue";
import { ElMessageBox as O } from "element-plus";
import { ElMessage as G } from "element-plus";
import { ElTag as be } from "element-plus";
import { ElInput as _e } from "element-plus";
import { ElTableColumn as ge } from "element-plus";
import { ElSwitch as Ve } from "element-plus";
import { ElCard as ye } from "element-plus";
import { cH as Se, i as _, b as ke, cK as z, aS as c, G as Ee } from "../../../../../shared/runtime.js";
import { D as xe } from "../../../../../modules/index-fd3331da.js";
const Be = { class: "card-header flex-css" }, Ce = { class: "flex-rbc" }, Re = { class: "flex-rsc" }, we = { class: "flex-rbc" }, Ue = { class: "card-body" }, $e = { key: 1 }, Te = { key: 1 }, De = { __name: "child-card", props: { level: { type: Number, required: true }, data: { type: Object, default: () => ({}) } }, emits: ["add", "del"], setup(K, { emit: Y }) {
  const E = C("permission"), J = C("crudApi"), M = C("maxHeight"), g = C("selectMap"), V = Y, d = K, F = d.level - 1, x = H(), f = R({ name: "", serialNumber: "" }), a = R({ checkRow: null, rows: [], delBtn: false }), i = R({ rows: [], editBtn: false }), $ = R({ del: false }), B = k(() => `${Se(d.level)}级科目`), Q = `此操作不可逆，确认删除【${B.value}】中选中的记录`, T = k(() => g[`current_LV${F}`]), P = k(() => {
    const e = T.value;
    return _(e) ? `上级科目：【${e.serialNumber}】${e.basicClassName}-${e.name}` : null;
  }), W = k(() => {
    const e = g[`current_list_LV${F}`];
    return T.value ? [T.value.id] : e ? e.map((t) => t.id) : [];
  }), L = k(() => {
    var t;
    const e = ((t = d.data) == null ? void 0 : t.filter((n) => W.value.includes(n.parent.id) && n.name.includes(f.name) && n.serialNumber.includes(f.serialNumber))) || [];
    return ne(e), e;
  });
  g[`current_list_LV${d.level}`] = L, re(L.value, (e) => {
    _(a.checkRow) && e.some((n) => a.checkRow.id !== n.id) || (a.checkRow = null);
  });
  function X() {
    V("add", d.level);
  }
  function Z() {
    _(a.rows) ? $.del = true : a.delBtn = !a.delBtn;
  }
  async function ee() {
    try {
      const e = a.rows.map((t) => t.id);
      await J.del(e);
    } catch (e) {
      console.log("删除科目", e);
    }
  }
  function I() {
    x.value.clearSelection(), a.delBtn = false;
  }
  function te() {
    I(), V("del");
  }
  const y = H([]);
  function j(e, t) {
    var h;
    const n = y.value.findIndex((v) => v.id === e.id);
    n !== -1 && y.value.splice(n, 1), y.value.push({ id: e.id, parentId: (h = e.parent) == null ? void 0 : h.id, name: e.name, code: e.code }), e.serialNumber = `${_(e.parent) ? e.parent.serialNumber : ""}${e.code}`, i.rows = y.value;
  }
  function le() {
    _(i.rows) && V("handleEdit", i.rows, i.editBtn, d.level), i.rows = [], y.value = [], i.editBtn = !i.editBtn, console.log(i.rows, "editSelected.rows");
  }
  function ae(e) {
    _(a.checkRow) && a.checkRow.id === e.id ? (a.checkRow = null, x.value.setCurrentRow()) : a.checkRow = e, g[`current_LV${d.level}`] = a.checkRow;
  }
  function ne(e) {
    if (ke(a.checkRow)) return;
    e.some((n) => n.id === a.checkRow.id) || se();
  }
  function se() {
    a.checkRow = null, x.value.setCurrentRow(), g[`current_LV${d.level}`] = a.checkRow;
  }
  function oe(e) {
    a.rows = e;
  }
  async function ie(e, t) {
    try {
      t ? O.confirm("是否要启用此科目(此操作会将其下科目全部启用)", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(() => {
        V("changeBoolStatusSuccess", e, d.level, t);
      }).catch(() => {
        e.boolStatus = e.boolStatus === c.TRUE.V ? c.FALSE.V : c.TRUE.V, G({ type: "info", message: "取消禁用" });
      }) : O.confirm("是否要禁用此科目(此操作会将其下科目全部禁用)", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(() => {
        V("changeBoolStatusSuccess", e, d.level, t);
      }).catch(() => {
        e.boolStatus = e.boolStatus === c.TRUE.V ? c.FALSE.V : c.TRUE.V, G({ type: "info", message: "取消禁用" });
      });
    } catch (n) {
      console.log("申购单状态", n), e.boolStatus = e.boolStatus === c.TRUE.V ? c.FALSE.V : c.TRUE.V;
    }
  }
  return (e, t) => {
    const n = be, h = q("common-button"), v = _e, S = ge, ce = Ve, de = q("common-table"), ue = ye, N = me("permission");
    return b(), A("div", null, [s(ue, { style: ve({ height: `${o(M)}px` }) }, { header: m(() => [p("div", Be, [p("div", Ce, [p("div", Re, [p("span", null, w(B.value), 1), U(s(n, { size: "default", style: { "margin-left": "5px" } }, { default: m(() => [pe(w(P.value), 1)]), _: 1 }, 512), [[fe, P.value]])]), p("div", null, [U(s(h, { icon: "el-icon-plus", size: "default", type: "success", onClick: t[0] || (t[0] = (l) => X()) }, null, 512), [[N, o(E).add]]), U(s(h, { type: a.delBtn ? "danger" : void 0, icon: "el-icon-delete", size: "default", onClick: t[1] || (t[1] = (l) => Z()) }, null, 8, ["type"]), [[N, o(E).del]]), U(s(h, { type: i.editBtn ? "primary" : void 0, icon: "el-icon-edit", size: "default", onClick: t[2] || (t[2] = (l) => le()) }, null, 8, ["type"]), [[N, o(E).edit]])])]), p("div", we, [s(v, { modelValue: f.name, "onUpdate:modelValue": t[3] || (t[3] = (l) => f.name = l), modelModifiers: { trim: true }, placeholder: `名称查询（${B.value}）`, class: "search-name", clearable: "", size: "default" }, null, 8, ["modelValue", "placeholder"]), s(v, { modelValue: f.serialNumber, "onUpdate:modelValue": t[4] || (t[4] = (l) => f.serialNumber = l), modelModifiers: { trim: true }, placeholder: `编号查询（${B.value}）`, class: "search-name", clearable: "", size: "default", style: { "margin-left": "15px" } }, null, 8, ["modelValue", "placeholder"])])])]), default: m(() => [p("div", Ue, [s(de, { ref_key: "tableRef", ref: x, data: L.value, "max-height": o(M) - 170, "show-empty-symbol": false, "empty-text": "暂无数据", "highlight-current-row": "", "return-source-data": "", "row-key": "id", onRowClick: t[5] || (t[5] = (l, u, r) => ae(l, u, r, 1)), onSelectionChange: t[6] || (t[6] = (l) => oe(l, 1)) }, { default: m(() => [a.delBtn ? (b(), D(S, { key: 0, align: "center", type: "selection", width: "45" })) : he("", true), s(S, { label: "编码", "min-width": "120", prop: "serialNumber" }), s(S, { label: "名称", "min-width": "110", prop: "name" }, { default: m(({ row: l, $index: u }) => [i.editBtn && (l.classifyUpdateStatus === o(z).ONLY_NAME_UPDATE.V || l.classifyUpdateStatus === o(z).ALL_UPDATE.V) ? (b(), D(v, { key: 0, modelValue: l.name, "onUpdate:modelValue": (r) => l.name = r, modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "名称", size: "default", style: { width: "100%" }, onChange: (r) => j(l, u) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (b(), A("span", $e, w(l.name), 1))]), _: 1 }), s(S, { align: "center", label: "代码", "min-width": "90", prop: "code" }, { default: m(({ row: l, $index: u }) => [i.editBtn && l.classifyUpdateStatus === o(z).ALL_UPDATE.V ? (b(), D(v, { key: 0, modelValue: l.code, "onUpdate:modelValue": (r) => l.code = r, modelModifiers: { trim: true }, class: "filter-item", clearable: "", maxlength: "3", placeholder: "代码", size: "default", style: { width: "100%" }, onChange: (r) => j(l, u) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (b(), A("span", Te, w(l.code), 1))]), _: 1 }), s(S, { align: "center", label: "状态", prop: "boolStatus" }, { default: m(({ row: l }) => [s(ce, { modelValue: l.boolStatus, "onUpdate:modelValue": (u) => l.boolStatus = u, "active-value": o(c).TRUE.V, disabled: !o(Ee)(o(E).editStatus), "inactive-value": o(c).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (u) => ie(l, l.boolStatus) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])])]), _: 1 }, 8, ["style"]), s(xe, { modelValue: $.del, "onUpdate:modelValue": t[7] || (t[7] = (l) => $.del = l), fn: ee, tip: Q, "show-exit": "", onExit: t[8] || (t[8] = (l) => I()), onSuccess: te }, null, 8, ["modelValue"])]);
  };
} };
export {
  De as default
};
