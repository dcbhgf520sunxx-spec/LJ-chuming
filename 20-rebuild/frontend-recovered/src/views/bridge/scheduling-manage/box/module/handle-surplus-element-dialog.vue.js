import { ref as h } from "vue";
import { watch as C } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as b } from "vue";
import { createBlock as q } from "vue";
import { withCtx as d } from "vue";
import { renderSlot as X } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as i } from "vue";
import { unref as g } from "vue";
import { normalizeClass as Y } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementBlock as E } from "vue";
import { Fragment as Z } from "vue";
import { createCommentVNode as ee } from "vue";
import { isRef as te } from "vue";
import { ElTableColumn as le } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElInputNumber as ae } from "element-plus";
import { _ as ie, u as oe, o as se, aw as ue, V as I, i as L, b as de } from "../../../../../shared/runtime.js";
const ce = { class: "wrap" }, re = { class: "wrap-left" }, he = { class: "wrap-item" }, pe = { key: 1 }, ge = { class: "wrap-right" }, me = { __name: "handle-surplus-element-dialog", props: { visible: { type: Boolean, default: false }, surplusList: { type: Array, default: () => [] }, groupsId: { type: [String, Number] } }, emits: ["update:visible"], setup(H, { expose: N, emit: T }) {
  const m = h(), S = h(), M = T, f = H, { visible: y, handleClose: U } = oe({ emit: M, props: f, field: "visible", showHook: j }), { maxHeight: x } = se({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, y), W = { unHandleQuantity: [{ validator: (e, o) => !e, message: "请选择匹配数量", trigger: "change" }] }, { tableValidate: D, wrongCellMask: z } = ue({ rules: W }), w = h({}), B = h([]), p = h({}), V = h([]), Q = h([]);
  function j() {
    B.value = f.surplusList.map((e) => (e.unHandleQuantity = e.quantity, e.selectBox = [], A(e), e));
  }
  function A(e) {
    C([() => e.selectBox], () => {
      O(e);
    }, { deep: true });
  }
  function O(e) {
    const o = e.selectBox.reduce((t, a) => t + ((a == null ? void 0 : a.allHandledQ) || 0), 0);
    e.unHandleQuantity = e.quantity - o;
  }
  function F(e) {
    var t, a;
    w.value = e, (t = m.value) == null || t.setCurrentRow(), Q.value = [], console.log(e, "handleElementRowClick");
    const o = ((a = e == null ? void 0 : e.selectBox) == null ? void 0 : a.length) && I(e.selectBox) || [];
    V.value = (e == null ? void 0 : e.boxList.map((l) => {
      var u;
      const s = o.find((n) => n.id === l.id);
      return console.log(o, l, s), L(s) ? (l.editQuantity = s.editQuantity, l.allHandledQ = s.allHandledQ, l.boxCanHandleQ = s.boxCanHandleQ, l.schedulingCanHandleQ = s.schedulingCanHandleQ, l.selectScheduling = s.selectScheduling, (u = m.value) == null || u.toggleRowSelection(l)) : (l.editQuantity = 0, l.selectScheduling = [], l.schedulingCanHandleQ = l.boxSchedulingList.reduce((n, c) => n + c.quantity, 0), l.boxCanHandleQ = l.quantity - l.schedulingCanHandleQ), $(l), l;
    })) || [];
  }
  function $(e) {
    C([() => e.editQuantity, () => e.selectScheduling], () => {
      k(e);
    }, { deep: true });
  }
  function G(e) {
    var t;
    if (de(e)) return;
    p.value = e, console.log(e, "handleBoxClickRow");
    const o = ((t = e == null ? void 0 : e.selectScheduling) == null ? void 0 : t.length) && I(e.selectScheduling) || [];
    Q.value = e.boxSchedulingList.map((a) => {
      var s;
      const l = o.find((u) => u.id === a.id);
      return L(l) ? (a.editQuantity = l.editQuantity, (s = S.value) == null || s.toggleRowSelection(a, true)) : a.editQuantity = 0, J(a), a;
    });
  }
  function J(e) {
    C(() => e.editQuantity, () => {
      k(p.value);
    });
  }
  function k(e) {
    const o = e.selectScheduling.reduce((t, a) => t + a.editQuantity, 0);
    e.allHandledQ = o + e.editQuantity;
  }
  function K(e) {
    console.log(e, "handleBoxSelectionChange"), w.value.selectBox = e;
  }
  function R(e) {
    var o, t, a, l;
    p.value.selectScheduling = e, e.length && ((t = (o = p.value) == null ? void 0 : o.boxSchedulingList) != null && t.length) ? (a = m.value) == null || a.toggleRowSelection(p.value, true) : (l = m.value) == null || l.toggleRowSelection(p.value, false);
  }
  function P() {
    const { validResult: e, dealList: o } = D(B.value), t = [];
    if (e) {
      for (let a = 0; a < o.length; a++) {
        const l = o[a];
        for (let s = 0; s < l.selectBox.length; s++) {
          const u = l.selectBox[s];
          if (u.editQuantity && t.push({ groupsId: f.groupsId, productId: u.id, quantity: u.editQuantity }), u != null && u.selectScheduling) for (let n = 0; n < u.selectScheduling.length; n++) {
            const c = u.selectScheduling[n];
            c.editQuantity && t.push({ groupsId: f.groupsId, productId: u.id, schedulingId: c.id, quantity: c.editQuantity });
          }
        }
      }
      return t;
    }
  }
  return N({ handleValidate: P }), (e, o) => {
    const t = le, a = v("common-table"), l = ne, s = ae, u = v("common-dialog");
    return b(), q(u, { title: "多余单元件处理", modelValue: g(y), "onUpdate:modelValue": o[0] || (o[0] = (n) => te(y) ? y.value = n : null), width: "95%", fullscreen: "", "before-close": g(U) }, { titleRight: d(() => [X(e.$slots, "saveBtn", {}, void 0, true)]), default: d(() => [r("div", ce, [r("div", re, [i(a, { data: H.surplusList, "max-height": g(x), stripe: false, "return-source-data": "", style: { width: "100%" }, "cell-class-name": g(z), "highlight-current-row": "", onCurrentChange: F }, { default: d(() => [i(t, { label: "序号", type: "index", align: "center", width: "60" }), i(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }), i(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), i(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), i(t, { prop: "netWeight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), i(t, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", width: "90", align: "center" }), i(t, { prop: "unHandleQuantity", "show-overflow-tooltip": true, label: "未匹配数量", width: "90", align: "center" }, { default: d(({ row: n }) => [r("span", { class: Y(n.unHandleQuantity ? "tc-danger" : "tc-success") }, _(n.unHandleQuantity), 3)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), r("div", he, [i(a, { ref_key: "boxTableRef", ref: m, data: V.value, "max-height": g(x), stripe: false, style: { width: "100%" }, "return-source-data": "", "highlight-current-row": "", onCurrentChange: G, onSelectionChange: K }, { default: d(() => [i(t, { type: "selection", width: "55", align: "center" }), i(t, { prop: "name", "show-overflow-tooltip": true, label: "分段名称", "min-width": "100", align: "center" }), i(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "分段编号", "min-width": "100", align: "center" }), i(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), i(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), i(t, { prop: "netWeight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), i(t, { "show-overflow-tooltip": true, label: "可匹配数量", width: "90", align: "center" }, { default: d(({ row: n }) => [i(l, { content: "未排产数量", placement: "top" }, { default: d(() => [r("span", null, _(n.boxCanHandleQ), 1)]), _: 2 }, 1024), n.schedulingCanHandleQ ? (b(), E(Z, { key: 0 }, [o[1] || (o[1] = r("span", null, " | ", -1)), i(l, { content: "已排产数量", placement: "top" }, { default: d(() => [r("span", null, _(n.schedulingCanHandleQ), 1)]), _: 2 }, 1024)], 64)) : ee("", true)]), _: 1 }), i(t, { prop: "quantity", "show-overflow-tooltip": true, label: "匹配数量", width: "100", align: "center" }, { default: d(({ row: n }) => [n.boxCanHandleQ ? (b(), q(s, { key: 0, modelValue: n.editQuantity, "onUpdate:modelValue": (c) => n.editQuantity = c, step: 1, min: 0, max: Math.min(w.value.unHandleQuantity + n.boxCanHandleQ, n.boxCanHandleQ), precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])) : (b(), E("span", pe, _(n.quantity), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), r("div", ge, [i(a, { ref_key: "schedulingTableRef", ref: S, data: Q.value, "max-height": g(x), stripe: false, "return-source-data": "", style: { width: "100%" }, onSelect: R, onSelectAll: R }, { default: d(() => [i(t, { type: "selection", width: "55", align: "center" }), i(t, { prop: "groups.name", "show-overflow-tooltip": true, label: "生产组", "min-width": "100", align: "center" }), i(t, { prop: "quantity", "show-overflow-tooltip": true, label: "可匹配数量", width: "90", align: "center" }), i(t, { prop: "editQuantity", "show-overflow-tooltip": true, label: "匹配数量", width: "100", align: "center" }, { default: d(({ row: n }) => [i(s, { modelValue: n.editQuantity, "onUpdate:modelValue": (c) => n.editQuantity = c, step: 1, min: 0, max: Math.min(w.value.unHandleQuantity + n.editQuantity, n.quantity), precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])])])]), _: 3 }, 8, ["modelValue", "before-close"]);
  };
} }, be = ie(me, [["__scopeId", "data-v-28d4824f"]]);
export {
  be as default
};
