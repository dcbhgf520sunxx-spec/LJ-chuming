import { inject as f } from "vue";
import { computed as se } from "vue";
import { watch as j } from "vue";
import { nextTick as v } from "vue";
import { ref as h } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as V } from "vue";
import { vShow as re } from "vue";
import { unref as n } from "vue";
import { createElementVNode as le } from "vue";
import { createVNode as r } from "vue";
import { createSlots as ce } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as d } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as T } from "vue";
import { toDisplayString as N } from "vue";
import { mergeProps as ue } from "vue";
import { ElBadge as de } from "element-plus";
import { Loading as me } from "@element-plus/icons-vue";
import { ElIcon as pe } from "element-plus";
import { ElTag as fe } from "element-plus";
import { l as S, t as _e, kz as ge, B as ye, c as H, D as R, i as he, bT as U, G as k, kB as ke, E as Ie } from "../../../../../../shared/runtime.js";
import { _ as be } from "../../preview.vue.js";
function Pe(l) {
  return S({ module: "contract", url: "business/machine-part", method: "get", params: l });
}
function Me({ projectId: l, monomerId: I, areaId: b }) {
  return S({ module: "contract", url: "business/machine-part/summary", method: "get", params: { projectId: l, monomerId: I, areaId: b } });
}
function Ee(l) {
  return S({ module: "contract", url: `business/machine-part/${l}`, method: "get" });
}
const xe = { get: Pe, detail: Ee }, we = { class: "head-container" }, Ce = { key: 0, style: { "margin-right": "6px" } }, ve = { key: 0 }, Ve = { key: 0 }, Te = { key: 0 }, Se = { key: 0 }, ze = { key: 0 }, Ae = { __name: "header", props: { showAble: { type: Boolean, default: false }, submitList: { type: Array, default: () => [] }, rowIds: { type: Array, default: () => [] } }, emits: ["checkSubmit", "showVisible"], setup(l, { expose: I, emit: b }) {
  const { decimalPrecision: $ } = _e(), z = f("projectId"), Q = f("monomerId"), G = f("areaId"), A = f("saveCount"), K = f("priceEditMode"), B = b, D = l, F = se(() => ({ monomerId: c.monomerId, areaId: c.areaId, type: ge.MACHINE_PART.V }));
  j(Q, (o) => {
    v(() => {
      a.query.monomerId = o, x(), a.toQuery();
    });
  }, { immediate: true }), j(G, (o) => {
    v(() => {
      a.query.areaId = o, x(), a.toQuery();
    });
  }, { immediate: true });
  const g = h(false), m = h(false), P = h(false), W = { mete: 0, price: 0, quantity: 0 }, p = h({ ...W }), J = { name: void 0, material: void 0, monomerId: { value: void 0, resetAble: false } }, { crud: a, query: c, CRUD: X } = ye(J);
  X.HOOK.handleRefresh = (o, { data: t }) => {
    t.content.forEach((e, M) => {
      e.totalWeight = H(e.totalWeight, "kg", "t", R.COM_WT__T), e.pricingManner = he(e.pricingManner) ? e.pricingManner : -1, e.unitPrice = e.unitPrice || "同上", e.originUnitPrice = e.unitPrice, e.totalPrice = (e.pricingManner === U.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.unitPrice && typeof e.unitPrice == "number" ? e.unitPrice : 0), e.originPricingManner = e.pricingManner, e.orderIndex = M + 1;
    }), Y();
  };
  async function Y() {
    if (!(!k(a.permission.cost) || !z.value)) {
      m.value = true;
      try {
        const o = await Me({ monomerId: c.monomerId, projectId: z.value, areaId: c.areaId });
        p.value = o;
      } catch (o) {
        console.log("获取商务散发制品成本失败", o);
      } finally {
        m.value = false;
      }
    }
  }
  function x() {
    p.value = { ...W };
  }
  function L(o, t = false) {
    t && a.data.forEach((e) => {
      e.unitPrice = e.originUnitPrice, e.pricingManner = e.originPricingManner, e.totalPrice = (e.pricingManner === U.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.unitPrice && typeof e.unitPrice == "number" ? e.unitPrice : 0);
    }), g.value = o;
  }
  function Z() {
    B("checkSubmit"), v(() => {
      P.value = D.showAble;
    });
  }
  function ee() {
    g.value = false, a.toQuery();
  }
  function te() {
    B("showVisible");
  }
  return I({ modifying: g }), (o, t) => {
    const e = O("common-button"), M = O("print-table"), ne = de, E = me, w = pe, C = fe, ae = q("permission"), ie = q("thousand");
    return s(), u("div", we, [V(le("div", null, null, 512), [[re, n(a).searchToggle]]), r(n(Ie), null, ce({ viewLeft: i(() => [n(k)(n(a).permission.cost) && n(c).monomerId ? (s(), u("span", Ve, [r(C, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: i(() => [t[7] || (t[7] = d(" 散发制品总量(t)： ")), m.value ? (s(), _(w, { key: 1 }, { default: i(() => [r(E)]), _: 1 })) : (s(), u("span", Te, N(n(H)(p.value.mete, "kg", "t", n(R).COM_WT__T)), 1))]), _: 1, __: [7] }), r(C, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: i(() => [t[8] || (t[8] = d(" 散发制品总数： ")), m.value ? (s(), _(w, { key: 1 }, { default: i(() => [r(E)]), _: 1 })) : (s(), u("span", Se, N(p.value.quantity), 1))]), _: 1, __: [8] }), r(C, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: i(() => [t[9] || (t[9] = d(" 散发制品造价(元)： ")), m.value ? (s(), _(w, { key: 1 }, { default: i(() => [r(E)]), _: 1 })) : V((s(), u("span", ze, null, 512)), [[ie, { val: p.value.price || 0, dp: n($).contract }]])]), _: 1, __: [9] })])) : T("", true)]), _: 2 }, [n(c).monomerId ? { name: "optRight", fn: i(() => {
      var y;
      return [n(k)(n(a).permission.save) ? (s(), u("span", Ce, [g.value ? (s(), u("span", ve, [r(e, { type: "warning", size: "default", onClick: t[0] || (t[0] = (oe) => L(false, true)) }, { default: i(() => t[3] || (t[3] = [d("取消录入")])), _: 1, __: [3] }), r(e, { type: "success", size: "default", onClick: Z }, { default: i(() => t[4] || (t[4] = [d("预览并保存")])), _: 1, __: [4] })])) : (s(), _(e, { key: 1, type: "primary", size: "default", onClick: t[1] || (t[1] = (oe) => L(true)), disabled: ((y = n(a).selections) == null ? void 0 : y.length) === 0 }, { default: i(() => t[5] || (t[5] = [d("录入价格")])), _: 1, __: [5] }, 8, ["disabled"]))])) : T("", true), V(r(M, { "api-key": "contractMachinePartPrice", params: { ...n(c), ids: D.rowIds }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[ae, n(a).permission.print]]), n(k)(n(a).permission.log) && n(K) === n(ke).SAVE.V ? (s(), _(ne, { key: 1, value: n(A), hidden: n(A) <= 0 }, { default: i(() => [r(e, { type: "success", size: "default", onClick: te }, { default: i(() => t[6] || (t[6] = [d("保存记录")])), _: 1, __: [6] })]), _: 1 }, 8, ["value", "hidden"])) : T("", true)];
    }), key: "0" } : void 0]), 1024), r(n(be), ue({ modelValue: P.value, "onUpdate:modelValue": t[2] || (t[2] = (y) => P.value = y), "modified-data": l.submitList }, o.$attrs, { params: F.value, onSuccess: ee }), null, 16, ["modelValue", "modified-data", "params"])]);
  };
} }, Le = Object.freeze(Object.defineProperty({ __proto__: null, default: Ae }, Symbol.toStringTag, { value: "Module" }));
export {
  Ae as _,
  xe as c,
  Le as h
};
