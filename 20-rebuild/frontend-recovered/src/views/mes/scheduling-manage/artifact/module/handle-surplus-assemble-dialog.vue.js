import { ref as h } from "vue";
import { watch as C } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as q } from "vue";
import { withCtx as d } from "vue";
import { renderSlot as X } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as i } from "vue";
import { unref as f } from "vue";
import { normalizeClass as Y } from "vue";
import { toDisplayString as b } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as Z } from "vue";
import { createCommentVNode as ee } from "vue";
import { isRef as te } from "vue";
import { ElTableColumn as le } from "element-plus";
import { ElTooltip as ae } from "element-plus";
import { ElInputNumber as ne } from "element-plus";
import { _ as ie, u as oe, o as se, aw as ue, V as L, i as B, b as de } from "../../../../../shared/runtime.js";
const ce = { class: "wrap" }, re = { class: "wrap-left" }, he = { class: "wrap-item" }, pe = { key: 1 }, fe = { class: "wrap-right" }, ge = { __name: "handle-surplus-assemble-dialog", props: { visible: { type: Boolean, default: false }, surplusList: { type: Array, default: () => [] }, groupsId: { type: [String, Number] } }, emits: ["update:visible"], setup(S, { expose: N, emit: T }) {
  const g = h(), x = h(), M = T, m = S, { visible: y, handleClose: U } = oe({ emit: M, props: m, field: "visible", showHook: z }), { maxHeight: Q } = se({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, y), W = { unHandleQuantity: [{ validator: (e, o) => !e, message: "请选择匹配数量", trigger: "change" }] }, { tableValidate: D, wrongCellMask: E } = ue({ rules: W }), w = h({}), A = h([]), p = h({}), V = h([]), H = h([]);
  function z() {
    A.value = m.surplusList.map((e) => (e.unHandleQuantity = e.quantity, e.selectArtifact = [], j(e), e));
  }
  function j(e) {
    C([() => e.selectArtifact], () => {
      O(e);
    }, { deep: true });
  }
  function O(e) {
    const o = e.selectArtifact.reduce((t, n) => t + ((n == null ? void 0 : n.allHandledQ) || 0), 0);
    e.unHandleQuantity = e.quantity - o;
  }
  function F(e) {
    var t, n;
    w.value = e, (t = g.value) == null || t.setCurrentRow(), H.value = [];
    const o = ((n = e == null ? void 0 : e.selectArtifact) == null ? void 0 : n.length) && L(e.selectArtifact) || [];
    V.value = (e == null ? void 0 : e.artifactList.map((l) => {
      var u;
      const s = o.find((a) => a.id === l.id);
      return B(s) ? (l.editQuantity = s.editQuantity, l.allHandledQ = s.allHandledQ, l.artifactCanHandleQ = s.artifactCanHandleQ, l.schedulingCanHandleQ = s.schedulingCanHandleQ, l.selectScheduling = s.selectScheduling, (u = g.value) == null || u.toggleRowSelection(l)) : (l.editQuantity = 0, l.selectScheduling = [], l.schedulingCanHandleQ = l.artifactSchedulingList.reduce((a, c) => a + c.quantity, 0), l.artifactCanHandleQ = l.quantity - l.schedulingCanHandleQ), $(l), l;
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
    p.value = e;
    const o = ((t = e == null ? void 0 : e.selectScheduling) == null ? void 0 : t.length) && L(e.selectScheduling) || [];
    H.value = e.artifactSchedulingList.map((n) => {
      var s;
      const l = o.find((u) => u.id === n.id);
      return B(l) ? (n.editQuantity = l.editQuantity, (s = x.value) == null || s.toggleRowSelection(n, true)) : n.editQuantity = 0, J(n), n;
    });
  }
  function J(e) {
    C(() => e.editQuantity, () => {
      k(p.value);
    });
  }
  function k(e) {
    const o = e.selectScheduling.reduce((t, n) => t + n.editQuantity, 0);
    e.allHandledQ = o + e.editQuantity;
  }
  function K(e) {
    w.value.selectArtifact = e;
  }
  function R(e) {
    var o, t, n, l;
    p.value.selectScheduling = e, e.length && ((t = (o = p.value) == null ? void 0 : o.artifactSchedulingList) != null && t.length) ? (n = g.value) == null || n.toggleRowSelection(p.value, true) : (l = g.value) == null || l.toggleRowSelection(p.value, false);
  }
  function P() {
    const { validResult: e, dealList: o } = D(A.value), t = [];
    if (e) {
      for (let n = 0; n < o.length; n++) {
        const l = o[n];
        for (let s = 0; s < l.selectArtifact.length; s++) {
          const u = l.selectArtifact[s];
          if (u.editQuantity && t.push({ groupsId: m.groupsId, productId: u.id, quantity: u.editQuantity }), u != null && u.selectScheduling) for (let a = 0; a < u.selectScheduling.length; a++) {
            const c = u.selectScheduling[a];
            c.editQuantity && t.push({ groupsId: m.groupsId, productId: u.id, schedulingId: c.id, quantity: c.editQuantity });
          }
        }
      }
      return t;
    }
  }
  return N({ handleValidate: P }), (e, o) => {
    const t = le, n = v("common-table"), l = ae, s = ne, u = v("common-dialog");
    return _(), q(u, { title: "多余部件处理", modelValue: f(y), "onUpdate:modelValue": o[0] || (o[0] = (a) => te(y) ? y.value = a : null), width: "95%", fullscreen: "", "before-close": f(U) }, { titleRight: d(() => [X(e.$slots, "saveBtn", {}, void 0, true)]), default: d(() => [r("div", ce, [r("div", re, [i(n, { data: S.surplusList, "max-height": f(Q), stripe: false, "return-source-data": "", style: { width: "100%" }, "cell-class-name": f(E), "highlight-current-row": "", onCurrentChange: F }, { default: d(() => [i(t, { label: "序号", type: "index", align: "center", width: "60" }), i(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }), i(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), i(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), i(t, { prop: "netWeight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), i(t, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", width: "90", align: "center" }), i(t, { prop: "unHandleQuantity", "show-overflow-tooltip": true, label: "未匹配数量", width: "90", align: "center" }, { default: d(({ row: a }) => [r("span", { class: Y(a.unHandleQuantity ? "tc-danger" : "tc-success") }, b(a.unHandleQuantity), 3)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), r("div", he, [i(n, { ref_key: "artifactTableRef", ref: g, data: V.value, "max-height": f(Q), stripe: false, style: { width: "100%" }, "return-source-data": "", "highlight-current-row": "", onCurrentChange: G, onSelectionChange: K }, { default: d(() => [i(t, { type: "selection", width: "55", align: "center" }), i(t, { prop: "name", "show-overflow-tooltip": true, label: "构件名称", "min-width": "100", align: "center" }), i(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "构件编号", "min-width": "100", align: "center" }), i(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), i(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), i(t, { prop: "netWeight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" }), i(t, { "show-overflow-tooltip": true, label: "可匹配数量", width: "90", align: "center" }, { default: d(({ row: a }) => [i(l, { content: "未排产数量", placement: "top" }, { default: d(() => [r("span", null, b(a.artifactCanHandleQ), 1)]), _: 2 }, 1024), a.schedulingCanHandleQ ? (_(), I(Z, { key: 0 }, [o[1] || (o[1] = r("span", null, " | ", -1)), i(l, { content: "已排产数量", placement: "top" }, { default: d(() => [r("span", null, b(a.schedulingCanHandleQ), 1)]), _: 2 }, 1024)], 64)) : ee("", true)]), _: 1 }), i(t, { prop: "quantity", "show-overflow-tooltip": true, label: "匹配数量", width: "100", align: "center" }, { default: d(({ row: a }) => [a.artifactCanHandleQ ? (_(), q(s, { key: 0, modelValue: a.editQuantity, "onUpdate:modelValue": (c) => a.editQuantity = c, step: 1, min: 0, max: Math.min(w.value.unHandleQuantity + a.artifactCanHandleQ, a.artifactCanHandleQ), precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])) : (_(), I("span", pe, b(a.quantity), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), r("div", fe, [i(n, { ref_key: "schedulingTableRef", ref: x, data: H.value, "max-height": f(Q), stripe: false, "return-source-data": "", style: { width: "100%" }, onSelect: R, onSelectAll: R }, { default: d(() => [i(t, { type: "selection", width: "55", align: "center" }), i(t, { prop: "groups.name", "show-overflow-tooltip": true, label: "生产组", "min-width": "100", align: "center" }), i(t, { prop: "quantity", "show-overflow-tooltip": true, label: "可匹配数量", width: "90", align: "center" }), i(t, { prop: "editQuantity", "show-overflow-tooltip": true, label: "匹配数量", width: "100", align: "center" }, { default: d(({ row: a }) => [i(s, { modelValue: a.editQuantity, "onUpdate:modelValue": (c) => a.editQuantity = c, step: 1, min: 0, max: Math.min(w.value.unHandleQuantity + a.editQuantity, a.quantity), precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])])])]), _: 3 }, 8, ["modelValue", "before-close"]);
  };
} }, _e = ie(ge, [["__scopeId", "data-v-4bd301f8"]]);
export {
  _e as default
};
