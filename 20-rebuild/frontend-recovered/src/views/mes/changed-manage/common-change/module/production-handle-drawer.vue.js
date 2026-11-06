import { ref as u } from "vue";
import { computed as b } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as te } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as ae } from "vue";
import { unref as p } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as ne } from "vue";
import { createBlock as le } from "vue";
import { toDisplayString as _ } from "vue";
import { isRef as oe } from "vue";
import { Fragment as ie } from "vue";
import { ElMessage as se } from "element-plus";
import { ElDivider as ue } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElInputNumber as de } from "element-plus";
import { vLoading as ce } from "element-plus";
import { e as pe } from "../../../../../modules/common-b3e76e54.js";
import { _ as me, u as fe, o as ye, na as ve, b as M, a3 as j, ba as _e } from "../../../../../shared/runtime.js";
import be from "../components/handle-operation.vue.js";
import he from "./production-preview.vue.js";
import we from "../components/item-detail-info.vue.js";
import { _ as ge } from "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/index-490fd9d7.js";
import "../../../../../modules/mes-ee117a22.js";
import "../../../../../modules/index-c83b228b.js";
import "../../../../../modules/index-897a9ea4.js";
const Qe = { style: { "font-size": "9pt", color: "red", "margin-top": "10px" } }, Ie = { __name: "production-handle-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(m, { emit: A }) {
  const $ = u(), V = u(), E = A, h = m, { visible: w, handleClose: R } = fe({ emit: E, props: h, field: "visible", showHook: O, closeHook: N }), { maxHeight: z } = ye({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, V), g = u(false), Q = u(false), d = u([]), o = u([]), I = u(), c = u({}), F = b(() => Object.assign(h.info, { handleQuantity: I.value }));
  function N() {
    d.value = [], o.value = [];
  }
  async function O() {
    var e;
    c.value = {};
    try {
      g.value = true;
      const { reportList: t, limitList: f, quantity: k } = await pe({ id: (e = h.info) == null ? void 0 : e.id });
      I.value = k;
      for (let a = 0; a < f.length; a++) {
        const s = f[a];
        c.value[s.taskId] = {};
        for (let v = 0; v < s.processAndQuantitys.length; v++) {
          const { processId: T, quantity: H } = s.processAndQuantitys[v];
          c.value[s.taskId][parseInt(T)] = H || 0;
        }
      }
      d.value = t && t.map((a) => {
        a.reportTypeText = ve.VL[a.reportType];
        const s = c.value[a.taskId] && c.value[a.taskId][parseInt(a.processId)] || 0;
        return a.canHandleQuantity = Math.min(s, a.quantity), a;
      }), o.value = d.value;
    } catch {
      console.log("获取处理列表失败");
    } finally {
      g.value = false;
    }
  }
  function P(e) {
    return _e(e, { props: ["quantity", "canHandleQuantity", "dealQuantity"] });
  }
  const U = b(() => d.value.reduce((e, t) => t.dealQuantity ? e + t.dealQuantity : e, 0)), B = b(() => I.value - U.value), G = b(() => d.value.reduce((e, t) => (M(e[t.taskId]) && (e[t.taskId] = {}), M(e[t.taskId][t.processId]) && (e[t.taskId][t.processId] = 0), t.dealQuantity && (e[t.taskId][t.processId] += t.dealQuantity), e), {}));
  function x(e) {
    const t = c.value[e.taskId] && c.value[e.taskId][e.processId] || 0, f = G.value[e.taskId][e.processId];
    return Math.min(e.canHandleQuantity, B.value + (e.dealQuantity || 0), t - f + (e.dealQuantity || 0));
  }
  function J() {
    if (B.value > 0) {
      se.warning("存在未处理数量！");
      return;
    }
    Q.value = true;
  }
  function K() {
    R(), E("success");
  }
  function W(e) {
    o.value = o.value.filter((t) => t.dealQuantity);
  }
  function X(e) {
    o.value = d.value;
  }
  function Y() {
    o.value = o.value.map((e) => (e.dealQuantity = x(e) || void 0, e));
  }
  function Z() {
    o.value = o.value.map((e) => (e.dealQuantity = void 0, e));
  }
  return (e, t) => {
    var S;
    const f = L("common-button"), k = ue, a = re, s = de, v = L("common-table"), T = L("common-drawer"), H = ce;
    return D(), te(ie, null, [n(T, { ref_key: "drawerRef", ref: V, title: `${p(j).VL[(S = m.info) == null ? void 0 : S.productType]}异常处理`, modelValue: p(w), "onUpdate:modelValue": t[0] || (t[0] = (y) => oe(w) ? w.value = y : null), direction: "rtl", "before-close": p(R), size: "80%" }, { titleRight: i(() => [n(f, { size: "default", type: "primary", onClick: J }, { default: i(() => t[2] || (t[2] = [ae("提交预览")])), _: 1, __: [2] })]), content: i(() => {
      var y, q, C;
      return [n(p(we), { productType: (y = m.info) == null ? void 0 : y.productType, data: F.value, showInProductionQ: "", showHandleQ: "" }, null, 8, ["productType", "data"]), n(k, null, { default: i(() => t[3] || (t[3] = [r("span", { class: "title" }, "生产变更", -1)])), _: 1, __: [3] }), n(be, { productType: (q = m.info) == null ? void 0 : q.productType, onShowEditList: W, onShowAllList: X, onFill: Y, onReset: Z }, null, 8, ["productType"]), ne((D(), le(v, { ref_key: "tableRef", ref: $, "summary-method": P, "return-source-data": "", "show-empty-symbol": false, "show-summary": "", data: o.value, "max-height": p(z), style: { width: "100%" } }, { default: i(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(p(ge), { showProductionLine: "", showFactory: "", showProcess: "" }), n(a, { prop: "reportTypeText", "show-overflow-tooltip": true, label: "上报类型", align: "center" }, { default: i(({ row: l }) => [r("span", null, _(l.reportTypeText), 1)]), _: 1 }), n(a, { prop: "completeTime", "show-overflow-tooltip": true, label: "上报时间", align: "center", width: "160" }, { default: i(({ row: l }) => [r("span", null, _(l.completeTime), 1)]), _: 1 }), n(a, { prop: "quantity", "show-overflow-tooltip": true, label: "生产数量", align: "center" }, { default: i(({ row: l }) => [r("span", null, _(l.quantity), 1)]), _: 1 }), n(a, { prop: "canHandleQuantity", "show-overflow-tooltip": true, label: "可处理数量", align: "center" }, { default: i(({ row: l }) => [r("span", null, _(l.canHandleQuantity), 1)]), _: 1 }), n(a, { prop: "dealQuantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: i(({ row: l }) => [n(s, { modelValue: l.dealQuantity, "onUpdate:modelValue": (ee) => l.dealQuantity = ee, min: 0, max: x(l), disabled: !x(l), style: { width: "100%" }, size: "default", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[H, g.value]]), r("div", Qe, [t[4] || (t[4] = r("span", null, "*", -1)), r("span", null, "被处理的" + _(p(j).VL[(C = m.info) == null ? void 0 : C.productType]) + "会加入到多余产品列表，可在该列表中进行报废或二次利用 ", 1)])];
    }), _: 1 }, 8, ["title", "modelValue", "before-close"]), n(he, { visible: Q.value, "onUpdate:visible": t[1] || (t[1] = (y) => Q.value = y), info: m.info, list: d.value, onSuccess: K }, null, 8, ["visible", "info", "list"])], 64);
  };
} }, Ce = me(Ie, [["__scopeId", "data-v-782c398c"]]);
export {
  Ce as default
};
