import { inject as p } from "vue";
import { computed as A } from "vue";
import { watch as Z } from "vue";
import { nextTick as x } from "vue";
import { ref as f } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as B } from "vue";
import { vShow as te } from "vue";
import { unref as e } from "vue";
import { createElementVNode as ne } from "vue";
import { createVNode as i } from "vue";
import { withKeys as j } from "vue";
import { createBlock as V } from "vue";
import { createCommentVNode as g } from "vue";
import { createSlots as ae } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as P } from "vue";
import { mergeProps as oe } from "vue";
import { ElInput as se } from "element-plus";
import { ElBadge as re } from "element-plus";
import { l as N, kz as ie, B as le, iB as M, G as _, kA as ue, C as ce, kB as de, E as me } from "../../../../../../shared/runtime.js";
import { _ as pe } from "../../preview.vue.js";
function fe(c) {
  return N({ url: "/api/business/enclosure", method: "get", params: c });
}
function ye({ projectId: c, monomerId: h }) {
  return N({ url: "/api/business/enclosure/summary", method: "get", params: { projectId: c, monomerId: h } });
}
const Ie = { get: fe }, ge = { class: "head-container" }, Pe = { key: 0, style: { "margin-right": "6px" } }, _e = { key: 0 }, he = { key: 0 }, be = { __name: "header", props: { showAble: { type: Boolean, default: false }, submitList: { type: Array, default: () => [] }, rowIds: { type: Array, default: () => [] } }, emits: ["checkSubmit", "showVisible"], setup(c, { expose: h, emit: O }) {
  const k = p("projectId"), U = p("enclosurePlanId"), E = p("saveCount"), D = p("priceEditMode"), I = O, w = c, v = A(() => {
    var o;
    return (o = a.data[0]) == null ? void 0 : o.category;
  }), K = A(() => ({ enclosurePlanId: s.enclosurePlanId, type: ie.ENCLOSURE.V }));
  Z(U, (o) => {
    x(() => {
      a.query.enclosurePlanId = o, H(), a.toQuery();
    });
  }, { immediate: true });
  const m = f(false), C = f(false), b = f(false), L = { totalArea: 0, totalAreaPrice: 0, totalLength: 0, totalLengthPrice: 0, totalQuantity: 0 }, S = f({ ...L }), Q = { name: void 0, plateType: void 0 }, { crud: a, query: s, CRUD: R } = le(Q);
  function $() {
    I("checkSubmit"), x(() => {
      b.value = w.showAble;
    });
  }
  R.HOOK.handleRefresh = (o, { data: n }) => {
    n.content.forEach((t, d) => {
      t.unitPrice = t.unitPrice || "同上", t.originUnitPrice = t.unitPrice, t.totalPrice = (t.pricingManner === M.LENGTH.V ? t.totalLength : t.totalArea) * (t.unitPrice && typeof t.unitPrice == "number" ? t.unitPrice : 0), t.orderIndex = d + 1;
    }), G();
  };
  async function G() {
    if (_(a.permission.cost)) {
      C.value = true;
      try {
        const o = await ye({ enclosurePlanId: s.enclosurePlanId, projectId: k.value });
        S.value = o;
      } catch (o) {
        console.log("获取商务围护成本失败", o);
      } finally {
        C.value = false;
      }
    }
  }
  function H() {
    S.value = { ...L };
  }
  function T(o, n = false) {
    n && a.data.forEach((t) => {
      t.unitPrice = t.originUnitPrice, t.totalPrice = (t.pricingManner === M.LENGTH.V ? t.totalLength : t.totalArea) * (t.unitPrice && typeof t.unitPrice == "number" ? t.unitPrice : 0);
    }), m.value = o;
  }
  function q() {
    m.value = false, a.toQuery();
  }
  function F() {
    I("showVisible");
  }
  return h({ modifying: m }), (o, n) => {
    const t = se, d = z("common-button"), J = z("print-table"), W = re, X = ee("permission");
    return l(), y("div", ge, [B(ne("div", null, [i(t, { modelValue: e(s).name, "onUpdate:modelValue": n[0] || (n[0] = (r) => e(s).name = r), placeholder: "可输入名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: j(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), v.value !== e(ue).FOLDING_PIECE.V ? (l(), V(t, { key: 0, modelValue: e(s).plateType, "onUpdate:modelValue": n[1] || (n[1] = (r) => e(s).plateType = r), placeholder: "输入板型搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: j(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])) : g("", true), i(e(ce))], 512), [[te, e(a).searchToggle]]), i(e(me), null, ae({ viewLeft: u(() => [e(_)(e(a).permission.cost) && e(s).monomerId ? (l(), y("span", he)) : g("", true)]), _: 2 }, [e(s).enclosurePlanId ? { name: "optRight", fn: u(() => {
      var r;
      return [e(_)(e(a).permission.save) ? (l(), y("span", Pe, [m.value ? (l(), y("span", _e, [i(d, { type: "warning", size: "default", onClick: n[2] || (n[2] = (Y) => T(false, true)) }, { default: u(() => n[5] || (n[5] = [P("取消录入")])), _: 1, __: [5] }), i(d, { type: "success", size: "default", onClick: $ }, { default: u(() => n[6] || (n[6] = [P("预览并保存")])), _: 1, __: [6] })])) : (l(), V(d, { key: 1, type: "primary", size: "default", disabled: ((r = e(a).selections) == null ? void 0 : r.length) === 0, onClick: n[3] || (n[3] = (Y) => T(true)) }, { default: u(() => n[7] || (n[7] = [P("录入价格")])), _: 1, __: [7] }, 8, ["disabled"]))])) : g("", true), B(i(J, { "api-key": "contractEnclosurePrice", params: { projectId: e(k), enclosurePlanId: e(s).enclosurePlanId, ids: w.rowIds }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[X, e(a).permission.print]]), e(_)(e(a).permission.log) && e(D) === e(de).SAVE.V ? (l(), V(W, { key: 1, value: e(E), hidden: e(E) <= 0 }, { default: u(() => [i(d, { type: "success", size: "default", onClick: F }, { default: u(() => n[8] || (n[8] = [P("保存记录")])), _: 1, __: [8] })]), _: 1 }, 8, ["value", "hidden"])) : g("", true)];
    }), key: "0" } : void 0]), 1024), i(e(pe), oe({ modelValue: b.value, "onUpdate:modelValue": n[4] || (n[4] = (r) => b.value = r), "modified-data": c.submitList }, o.$attrs, { params: K.value, onSuccess: q, categoryValue: v.value }), null, 16, ["modelValue", "modified-data", "params", "categoryValue"])]);
  };
} }, we = Object.freeze(Object.defineProperty({ __proto__: null, default: be }, Symbol.toStringTag, { value: "Module" }));
export {
  be as _,
  Ie as c,
  we as h
};
