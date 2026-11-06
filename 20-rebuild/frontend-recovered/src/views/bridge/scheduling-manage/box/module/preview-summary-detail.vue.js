import { ref as m } from "vue";
import { inject as Be } from "vue";
import { computed as Z } from "vue";
import { resolveComponent as W } from "vue";
import { resolveDirective as Me } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as C } from "vue";
import { withCtx as d } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as z } from "vue";
import { createTextVNode as x } from "vue";
import { unref as s } from "vue";
import { vShow as Oe } from "vue";
import { normalizeStyle as We } from "vue";
import { createCommentVNode as R } from "vue";
import { withKeys as je } from "vue";
import { withModifiers as re } from "vue";
import { normalizeClass as Ge } from "vue";
import { isRef as Pe } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElTag as Ae } from "element-plus";
import { ElInput as Fe } from "element-plus";
import { ElTooltip as $e } from "element-plus";
import { ElTableColumn as qe } from "element-plus";
import { ElCheckbox as Ke } from "element-plus";
import { ElPagination as Je } from "element-plus";
import { vLoading as Xe } from "element-plus";
import { e as Ye, r as Ze, f as et } from "../../../../../modules/box-3fab54f9.js";
import { _ as tt, J as lt, u as nt, aU as L, o as at, bW as ot, G as it } from "../../../../../shared/runtime.js";
import { B as D } from "../../../../../modules/bridge-86f96a4f.js";
import { u as st } from "../../../../../modules/use-get-box-type-list-1288a5cc.js";
import ut from "./edit-form.vue.js";
import rt from "./batch-edit-form.vue.js";
import dt from "./del-form.vue.js";
import ct from "./batch-del-form.vue.js";
import pt from "./element-scheduling-form.vue.js";
import "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import "../../../../../modules/common-8949b382.js";
import "./handle-surplus-element-dialog.vue.js";
const mt = { class: "head-container" }, ft = { class: "filter-item" }, gt = { style: { float: "right", "margin-right": "5px" } }, vt = { class: "flex-rsc" }, ht = { class: "flex-ccc", style: { flex: "1" } }, bt = { __name: "preview-summary-detail", props: { visible: { type: Boolean, default: false }, otherQuery: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(de, { emit: ce }) {
  const { handleSizeChange: pe, handleCurrentChange: me, total: fe, setTotalPage: ge, queryPage: j } = lt({ fetchHook: k }), te = m(), N = m(), le = m(), ne = ce, H = de, I = { SCHEDULING: { K: "SCHEDULING", L: "排产模式", V: 1 }, EDIT: { K: "EDIT", L: "编辑模式", V: 2 } }, T = m(I.SCHEDULING.V), { visible: G, handleClose: ve } = nt({ emit: ne, props: H, field: "visible", showHook: Ie, closeHook: Te }), { boxTypeList: w, refreshBoxType: P } = st({ getApi: Ye, initHook: Ce }, true), he = Be("areaIdObj"), be = m([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), ye = Z(() => {
    var t, e;
    return ((e = (t = H.otherQuery) == null ? void 0 : t.areaIdList) == null ? void 0 : e.map((o) => he.value[o].name).join("、")) || "";
  }), E = m([]), A = m(false), b = m({}), B = m({}), u = m({ productionLineTypeEnum: L.TRADITION.V }), ae = m(false), F = Z(() => ({ areaIdList: H.otherQuery.areaIdList, productionLineTypeEnum: u.value.productionLineTypeEnum })), M = Z(() => {
    var t, e;
    return ((e = (t = le.value) == null ? void 0 : t.getOption(u.value.boxClassId)) == null ? void 0 : e.productionLineTypeEnum) || u.value.productionLineTypeEnum;
  }), { maxHeight: _e } = at({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true, extraHeight: 50 }, te);
  function Ce() {
    var t, e, o, a;
    (!((t = w.value) != null && t.length) || u.value.boxClassId && ((e = w.value) != null && e.length) && w.value.findIndex((l) => l.boxClassId === u.value.boxClassId) === -1) && (u.value.boxClassId = void 0), (o = w.value) != null && o.length && (((a = w.value) == null ? void 0 : a.length) === 1 || u.value.productionLineTypeEnum === L.INTELLECT.V) && (u.value.boxClassId = w.value[0].boxClassId), k();
  }
  function xe() {
    var t;
    (t = N.value) == null || t.clearSelection();
  }
  function Ie() {
    var t;
    P({ ...F.value }), (t = N.value) == null || t.clearSelection(), oe();
  }
  function Te() {
    ae.value && ne("refresh");
  }
  function oe() {
    u.value.serialNumber = void 0, u.value.productionLineTypeEnum !== L.INTELLECT.V && (u.value.boxClassId = void 0), k();
  }
  async function k() {
    var t, e;
    if (E.value = [], b.value = {}, B.value = {}, !(u.value.productionLineTypeEnum === L.INTELLECT.V && !u.value.boxClassId || !u.value.productionLineTypeEnum)) try {
      A.value = true, B.value = await Ze({ ...H.otherQuery, ...u.value }) || {};
      const { content: o, totalElements: a } = await et({ ...H.otherQuery, ...u.value, ...j });
      ge(a);
      const l = o;
      let r = 0, y = 0, p = 0, V = 0;
      for (let c = 0; c < l.length; c++) {
        const S = (t = l[c].groups) == null ? void 0 : t.id;
        c === 0 && (y++, p += l[c].schedulingQuantity, V += l[c].schedulingTotalNetWeight), c > 0 && (S === ((e = l[c - 1].groups) == null ? void 0 : e.id) ? (y++, p += l[c].schedulingQuantity, V += l[c].schedulingTotalNetWeight, l[r].rowspan = 0) : (l[r].rowspan = y, l[r].mergeQuantity = p, l[r].mergeWeight = V.toFixed(2), y = 1, p = l[c].schedulingQuantity, V = l[c].schedulingTotalNetWeight, r = c)), c === l.length - 1 && (l[r].rowspan = y, l[r].mergeQuantity = p, l[r].mergeWeight = V.toFixed(2)), l[c].mergeIndex = r, l[c].needSchedulingQuantity = l[c].schedulingQuantity, l[c].groupCheck = false, l[c].isIndeterminateCheck = false, b.value[S] || (b.value[S] = []), b.value[S].push(l[c].id);
      }
      E.value = l;
    } catch (o) {
      console.log("获取分段排产预览记录失败", o);
    } finally {
      A.value = false;
    }
  }
  function we(t, e, o) {
    var l;
    const a = (l = e.groups) == null ? void 0 : l.id;
    console.log(e, a, t, b.value[a], "handleCheckAllChange"), a && b.value[a] && E.value.forEach((r) => {
      var y;
      b.value[a].includes(r.id) && ((y = N == null ? void 0 : N.value) == null || y.toggleRowSelection(r, t));
    }), t || (E.value[o].isIndeterminateCheck = false);
  }
  function Ee({ row: t, column: e, rowIndex: o, columnIndex: a }) {
    if (a === 1 || a === 2) return { rowspan: t.rowspan || 0, colspan: 1 };
  }
  function ke(t, e) {
    var o, a, l, r;
    return (T.value === I.EDIT.V || M.value === L.INTELLECT.V) && (o = h.value) != null && o.length ? ((a = t.groups) == null ? void 0 : a.id) === ((r = (l = h.value[0]) == null ? void 0 : l.groups) == null ? void 0 : r.id) : true;
  }
  function Ve(t) {
    var e, o, a, l;
    return (T.value === I.EDIT.V || M.value === L.INTELLECT.V) && (e = h.value) != null && e.length ? ((o = t.groups) == null ? void 0 : o.id) !== ((l = (a = h.value[0]) == null ? void 0 : a.groups) == null ? void 0 : l.id) : false;
  }
  const O = m({}), h = m([]);
  function Le(t) {
    if (console.log(t, "selectionChangeHandler"), t.length) for (const e in b.value) {
      const o = Number(e), a = b.value[e].length, l = t.filter((r) => r.groups.id === o);
      if (l.length) {
        const r = l[0].mergeIndex;
        console.log(r, l, b.value[e], "selectionChangeHandler_index"), E.value[r].isIndeterminateCheck = l.length > 0 && l.length < a, E.value[r].groupCheck = l.length > 0 && l.length === a;
      }
    }
    else for (let e = 0; e < E.value.length; e++) {
      const o = E.value[e];
      o.isIndeterminateCheck = false, o.groupCheck = false;
    }
    h.value = t;
  }
  const $ = m(false), q = m(false);
  function De(t) {
    O.value = Object.assign({}, t), $.value = true;
  }
  function Ne() {
    var t;
    if (!((t = h.value) != null && t.length)) {
      ee.warning("请至少选择一条数据");
      return;
    }
    q.value = true;
  }
  const K = m(false), J = m(false);
  function ie() {
    P({ ...F.value }), ae.value = true;
  }
  function Se(t) {
    O.value = Object.assign({}, t), K.value = true;
  }
  function ze() {
    var t;
    if (!((t = h.value) != null && t.length)) {
      ee.warning("请至少选择一条数据");
      return;
    }
    J.value = true;
  }
  const X = m(false);
  function He() {
    var t;
    if (!((t = h.value) != null && t.length)) {
      ee.warning("请至少选择一条数据");
      return;
    }
    X.value = true;
  }
  function Qe() {
    P({ ...F.value });
  }
  return (t, e) => {
    const o = Ae, a = W("common-button"), l = Fe, r = W("common-radio-button"), y = $e, p = qe, V = Ke, c = W("common-table"), S = Je, Ue = W("common-drawer"), Q = Me("permission"), Re = Xe;
    return _(), C(Ue, { ref_key: "drawerRef", ref: te, title: "分段排产预览", modelValue: s(G), "onUpdate:modelValue": e[8] || (e[8] = (n) => Pe(G) ? G.value = n : null), direction: "rtl", "before-close": s(ve), size: "100%" }, { titleAfter: d(() => [i(o, { size: "default" }, { default: d(() => [e[9] || (e[9] = f("span", null, "当前区域：", -1)), f("span", null, g(ye.value), 1)]), _: 1, __: [9] })]), titleRight: d(() => [z((_(), C(a, { size: "default", type: "success", onClick: He }, { default: d(() => e[10] || (e[10] = [x(" 下一步【单元件排产】 ")])), _: 1, __: [10] })), [[Q, s(D).elementGet], [Oe, T.value === I.SCHEDULING.V]])]), content: d(() => [f("div", mt, [s(w).length ? (_(), C(s(ot), { key: 0, ref_key: "tagTabsRef", ref: le, modelValue: u.value.boxClassId, "onUpdate:modelValue": e[0] || (e[0] = (n) => u.value.boxClassId = n), class: "filter-item", style: We(["width:calc(100% - 150px)", { display: "inline-block" }]), data: s(w), unselectable: s(w).length > 1, itemKey: "boxClassId", onChange: k }, { default: d(({ item: n }) => [f("span", null, g(n.name) + "：", 1), f("span", null, g(n.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data", "unselectable"])) : R("", true), i(l, { modelValue: u.value.serialNumber, "onUpdate:modelValue": e[1] || (e[1] = (n) => u.value.serialNumber = n), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: je(k, ["enter"]) }, null, 8, ["modelValue"]), i(a, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: re(k, ["stop"]) }, { default: d(() => e[11] || (e[11] = [x("搜索")])), _: 1, __: [11] }), i(a, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: re(oe, ["stop"]) }, { default: d(() => e[12] || (e[12] = [x(" 重置 ")])), _: 1, __: [12] }), i(r, { modelValue: T.value, "onUpdate:modelValue": e[2] || (e[2] = (n) => T.value = n), size: "default", options: I, type: "enum", class: "filter-item", onChange: xe }, null, 8, ["modelValue"]), f("span", ft, [i(o, { size: "large", effect: "plain", style: { "margin-left": "5px" } }, { default: d(() => [x(" 数量(件)：" + g(B.value.quantity || 0), 1)]), _: 1 }), i(o, { size: "large", effect: "plain", style: { "margin-left": "5px" } }, { default: d(() => {
      var n;
      return [x(" 重量(kg)：" + g(((n = B.value.totalNetWeight) == null ? void 0 : n.toFixed(2)) || 0), 1)];
    }), _: 1 })]), T.value === I.EDIT.V ? z((_(), C(a, { key: 1, size: "default", type: "danger", style: { float: "right" }, onClick: ze }, { default: d(() => e[13] || (e[13] = [x(" 批量删除 ")])), _: 1, __: [13] })), [[Q, s(D).recordDel]]) : R("", true), i(y, { class: "item", effect: "light", disabled: !!u.value.boxClassId, content: "请选择分段类型", placement: "left" }, { default: d(() => [f("span", gt, [T.value === I.EDIT.V ? z((_(), C(a, { key: 0, disabled: !u.value.boxClassId, size: "default", type: "primary", onClick: Ne }, { default: d(() => e[14] || (e[14] = [x(" 批量重新分配 ")])), _: 1, __: [14] }, 8, ["disabled"])), [[Q, s(D).recordEdit]]) : R("", true)])]), _: 1 }, 8, ["disabled"])]), z((_(), C(c, { ref_key: "recordTableRef", ref: N, data: E.value, "span-method": Ee, "max-height": s(_e), stripe: false, "data-format": be.value, "row-key": "id", class: Ge(T.value === I.EDIT.V || M.value === s(L).INTELLECT.V ? "hidden-table-check-all" : ""), style: { width: "100%" }, onSelectionChange: Le }, { default: d(() => [i(p, { label: "序号", type: "index", align: "center", width: "60" }), i(p, { prop: "groups.name", "show-overflow-tooltip": true, label: "车间>生产线>生产组", "min-width": "170", align: "center" }, { default: d(({ row: n, $index: v }) => {
      var U, se, ue;
      return [f("div", vt, [i(V, { modelValue: n.groupCheck, "onUpdate:modelValue": (Y) => n.groupCheck = Y, indeterminate: n.isIndeterminateCheck, disabled: Ve(n), onChange: (Y) => we(Y, n, v) }, null, 8, ["modelValue", "onUpdate:modelValue", "indeterminate", "disabled", "onChange"]), f("div", ht, [f("span", null, g((U = n.workshop) == null ? void 0 : U.name) + ">" + g((se = n.productionLine) == null ? void 0 : se.name) + ">" + g((ue = n.groups) == null ? void 0 : ue.name), 1), i(o, { type: "success", effect: "plain", style: { "margin-top": "5px", padding: "0px 15px" } }, { default: d(() => [f("span", null, g(n.mergeQuantity) + " 件", 1), e[15] || (e[15] = f("span", { style: { "margin-right": "5px", "margin-left": "5px" } }, "|", -1)), f("span", null, g(n.mergeWeight) + " kg", 1)]), _: 2, __: [15] }, 1024)])])];
    }), _: 1 }), i(p, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100", align: "center" }, { default: d(({ row: n }) => {
      var v;
      return [f("span", null, g((v = n.monomer) == null ? void 0 : v.name), 1)];
    }), _: 1 }), i(p, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100", align: "center" }, { default: d(({ row: n }) => {
      var v;
      return [f("span", null, g((v = n.area) == null ? void 0 : v.name), 1)];
    }), _: 1 }), i(p, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: d(({ row: n }) => {
      var v;
      return [f("span", null, g(n.serialNumber), 1), e[16] || (e[16] = f("br", null, null, -1)), (v = n.structureClass) != null && v.name ? (_(), C(o, { key: 0 }, { default: d(() => {
        var U;
        return [x(g((U = n.structureClass) == null ? void 0 : U.name), 1)];
      }), _: 2 }, 1024)) : R("", true)];
    }), _: 1 }), i(p, { type: "selection", width: "55", align: "center", class: "selection", selectable: ke }), i(p, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), i(p, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), i(p, { prop: "schedulingQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }), i(p, { prop: "schedulingTotalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "90", align: "center" }), i(p, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "完成日期", "min-width": "90", align: "center" }), s(it)([...s(D).recordEdit, ...s(D).recordDel]) && T.value === I.EDIT.V ? (_(), C(p, { key: 0, label: "操作", width: "200", align: "center" }, { default: d(({ row: n }) => [z((_(), C(a, { size: "default", type: "primary", onClick: (v) => De(n) }, { default: d(() => e[17] || (e[17] = [x("重新分配")])), _: 2, __: [17] }, 1032, ["onClick"])), [[Q, s(D).recordEdit]]), z((_(), C(a, { size: "default", type: "danger", onClick: (v) => Se(n) }, { default: d(() => e[18] || (e[18] = [x("删除任务")])), _: 2, __: [18] }, 1032, ["onClick"])), [[Q, s(D).recordDel]])]), _: 1 })) : R("", true)]), _: 1 }, 8, ["data", "max-height", "data-format", "class"])), [[Re, A.value]]), i(S, { total: s(fe), "current-page": s(j).pageNumber, "page-size": s(j).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(pe), onCurrentChange: s(me) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), i(s(ut), { visible: $.value, "onUpdate:visible": e[3] || (e[3] = (n) => $.value = n), itemInfo: O.value, onRefresh: k }, null, 8, ["visible", "itemInfo"]), i(s(rt), { visible: q.value, "onUpdate:visible": e[4] || (e[4] = (n) => q.value = n), selections: h.value, boxClassId: u.value.boxClassId, onRefresh: k }, null, 8, ["visible", "selections", "boxClassId"]), i(s(dt), { visible: K.value, "onUpdate:visible": e[5] || (e[5] = (n) => K.value = n), itemInfo: O.value, onDelSuccess: ie }, null, 8, ["visible", "itemInfo"]), i(s(ct), { visible: J.value, "onUpdate:visible": e[6] || (e[6] = (n) => J.value = n), selections: h.value, onDelSuccess: ie }, null, 8, ["visible", "selections"]), i(s(pt), { visible: X.value, "onUpdate:visible": e[7] || (e[7] = (n) => X.value = n), "box-list": h.value, productionLineTypeEnum: M.value, onTaskIssueSuccess: Qe }, null, 8, ["visible", "box-list", "productionLineTypeEnum"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, St = tt(bt, [["__scopeId", "data-v-54147c0b"]]);
export {
  St as default
};
