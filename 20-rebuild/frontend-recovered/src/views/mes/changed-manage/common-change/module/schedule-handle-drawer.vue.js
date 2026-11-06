import { ref as s } from "vue";
import { computed as g } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as W } from "vue";
import { createVNode as a } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as X } from "vue";
import { unref as d } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as Y } from "vue";
import { createBlock as Z } from "vue";
import { toDisplayString as y } from "vue";
import { isRef as ee } from "vue";
import { Fragment as te } from "vue";
import { ElMessage as ae } from "element-plus";
import { ElDivider as ne } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { vLoading as ie } from "element-plus";
import { t as se } from "../../../../../modules/common-b3e76e54.js";
import { _ as ue, u as re, o as de, a3 as ce, ba as me } from "../../../../../shared/runtime.js";
import pe from "../components/handle-operation.vue.js";
import fe from "./schedule-preview.vue.js";
import ye from "../components/item-detail-info.vue.js";
import { _ as _e } from "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/mes-ee117a22.js";
import "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-897a9ea4.js";
const ve = { __name: "schedule-handle-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(c, { emit: R }) {
  const S = s(), x = s(), H = R, p = c, { visible: _, handleClose: T } = re({ emit: H, props: p, field: "visible", showHook: M, closeHook: I }), { maxHeight: B } = de({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, x), v = s(false), b = s(false), u = s([]), o = s([]), w = s(), D = g(() => Object.assign(p.info, { handleQuantity: w }));
  function I() {
    u.value = [], o.value = [];
  }
  async function M() {
    var e, t;
    try {
      v.value = true;
      const { abnormalTaskList: f, handleQuantity: Q } = await se({ productType: (e = p.info) == null ? void 0 : e.productType, productId: (t = p.info) == null ? void 0 : t.productId });
      u.value = f.map((l) => (l.canHandleQuantity = l.taskQuantity - l.inProductionQuantity, l)), o.value = u.value, w.value = Q;
    } catch {
      console.log("获取处理列表失败");
    } finally {
      v.value = false;
    }
  }
  function P(e) {
    return me(e, { props: ["taskQuantity", "inProductionQuantity", "canHandleQuantity", "dealQuantity"] });
  }
  const $ = g(() => u.value.reduce((e, t) => t.dealQuantity ? e + t.dealQuantity : e, 0)), V = g(() => w.value - $.value);
  function h(e) {
    return Math.min(e.canHandleQuantity, V.value + (e.dealQuantity || 0));
  }
  function F() {
    if (V.value > 0) {
      ae.warning("存在未处理数量！");
      return;
    }
    b.value = true;
  }
  function N() {
    T(), H("success");
  }
  function U(e) {
    o.value = o.value.filter((t) => t.dealQuantity);
  }
  function j(e) {
    o.value = u.value;
  }
  function z() {
    o.value = o.value.map((e) => (e.dealQuantity = h(e) || void 0, e));
  }
  function A() {
    o.value = o.value.map((e) => (e.dealQuantity = void 0, e));
  }
  return (e, t) => {
    var L;
    const f = k("common-button"), Q = ne, l = le, O = oe, q = k("common-table"), G = k("common-drawer"), J = ie;
    return E(), W(te, null, [a(G, { ref_key: "drawerRef", ref: x, title: `${d(ce).VL[(L = c.info) == null ? void 0 : L.productType]}异常处理`, modelValue: d(_), "onUpdate:modelValue": t[0] || (t[0] = (r) => ee(_) ? _.value = r : null), direction: "rtl", "before-close": d(T), size: "80%" }, { titleRight: i(() => [a(f, { size: "default", type: "primary", onClick: F }, { default: i(() => t[2] || (t[2] = [X("提交预览")])), _: 1, __: [2] })]), content: i(() => {
      var r, C;
      return [a(d(ye), { productType: (r = c.info) == null ? void 0 : r.productType, data: D.value, showTaskQ: "", showHandleQ: "" }, null, 8, ["productType", "data"]), a(Q, null, { default: i(() => t[3] || (t[3] = [m("span", { class: "title" }, "排产变更", -1)])), _: 1, __: [3] }), a(pe, { productType: (C = c.info) == null ? void 0 : C.productType, onShowEditList: U, onShowAllList: j, onFill: z, onReset: A }, null, 8, ["productType"]), Y((E(), Z(q, { ref_key: "tableRef", ref: S, "return-source-data": "", "show-empty-symbol": false, "summary-method": P, "show-summary": "", data: o.value, "max-height": d(B), style: { width: "100%" } }, { default: i(() => [a(l, { label: "序号", type: "index", align: "center", width: "60" }), a(l, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "要求完成日期", align: "center" }, { default: i(({ row: n }) => [m("span", null, y(n.askCompleteTime), 1)]), _: 1 }), a(d(_e), { showProductionLine: "", showFactory: "" }), a(l, { prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数量", align: "center" }, { default: i(({ row: n }) => [m("span", null, y(n.taskQuantity), 1)]), _: 1 }), a(l, { prop: "inProductionQuantity", "show-overflow-tooltip": true, label: "已生产数量", align: "center" }, { default: i(({ row: n }) => [m("span", null, y(n.inProductionQuantity), 1)]), _: 1 }), a(l, { prop: "canHandleQuantity", "show-overflow-tooltip": true, label: "可处理数量", align: "center" }, { default: i(({ row: n }) => [m("span", null, y(n.canHandleQuantity), 1)]), _: 1 }), a(l, { prop: "dealQuantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: i(({ row: n }) => [a(O, { modelValue: n.dealQuantity, "onUpdate:modelValue": (K) => n.dealQuantity = K, min: 0, max: h(n), disabled: !h(n), style: { width: "100%" }, size: "default", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, v.value]])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]), a(fe, { visible: b.value, "onUpdate:visible": t[1] || (t[1] = (r) => b.value = r), info: c.info, list: u.value, onSuccess: N }, null, 8, ["visible", "info", "list"])], 64);
  };
} }, Ce = ue(ve, [["__scopeId", "data-v-c90718d3"]]);
export {
  Ce as default
};
