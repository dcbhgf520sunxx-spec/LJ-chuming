import { inject as E } from "vue";
import { watch as z } from "vue";
import { nextTick as v } from "vue";
import { computed as S } from "vue";
import { ref as g } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as x } from "vue";
import { vShow as ae } from "vue";
import { unref as n } from "vue";
import { createElementVNode as oe } from "vue";
import { createVNode as i } from "vue";
import { withKeys as j } from "vue";
import { createSlots as ie } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as p } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as B } from "vue";
import { toDisplayString as O } from "vue";
import { Fragment as se } from "vue";
import { mergeProps as re } from "vue";
import { ElInput as le } from "element-plus";
import { Loading as ce } from "@element-plus/icons-vue";
import { ElIcon as ue } from "element-plus";
import { ElTag as de } from "element-plus";
import { l as T, _ as me, F as pe, B as fe, c as q, D as K, bn as _e, bV as ge, bT as N, G as C, C as ye, E as be } from "../../../../../../shared/runtime.js";
import { _ as he } from "../../preview.vue.js";
function ke(d) {
  return T({ module: "contract", url: "business/bridge-box", method: "get", params: d });
}
function Pe({ projectId: d, monomerId: b }) {
  return T({ module: "contract", url: "business/bridge-box/summary", method: "get", params: { projectId: d, monomerId: b } });
}
function Ie(d) {
  return T({ module: "contract", url: `business/bridge-box/businessId/${d}`, method: "get" });
}
const je = { get: ke, detail: Ie };
const we = { class: "head-container" }, Ve = { key: 0, style: { "margin-right": "6px" } }, ve = { key: 0 }, xe = { key: 0 }, Ce = { key: 0 }, Te = { key: 0 }, Ue = { key: 0 }, Me = { key: 1 }, Ee = { __name: "header", props: { showAble: { type: Boolean, default: false } }, emits: ["checkSubmit"], setup(d, { expose: b, emit: Q }) {
  const h = E("projectId"), $ = E("monomerId"), H = Q, L = d;
  z($, (a) => {
    v(() => {
      o.query.monomerId = a, J(), o.toQuery();
    });
  }, { immediate: true }), z(h, (a) => {
    v(() => {
      o.query.projectId = a, o.toQuery();
    });
  }, { immediate: true });
  const A = S(() => o.data.filter((a) => a.pricingManner !== a.originPricingManner && a.unitPrice !== "-" || a.unitPrice !== a.originUnitPrice)), R = S(() => ({ monomerId: l.monomerId, type: pe.BOX.V })), _ = g(false), f = g(false), k = g(false), U = { mete: 0, price: 0, quantity: 0 }, m = g({ ...U }), F = { name: void 0, material: void 0, monomerId: { value: void 0, resetAble: false } }, { crud: o, query: l, CRUD: G } = fe(F);
  G.HOOK.handleRefresh = (a, { data: t }) => {
    t.content.forEach((e) => {
      e.totalWeight = q(e.totalWeight, "kg", "t", K.COM_WT__T), e.newUnitPrice = e.unitPrice, e.originNewUnitPrice = e.newUnitPrice, e.originUnitPrice = _e(ge(e.unitPrice)), e.totalPrice = (e.pricingManner === N.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.newUnitPrice || 0), e.originPricingManner = e.pricingManner;
    }), X();
  };
  async function X() {
    if (!(!C(o.permission.cost) || !h.value)) {
      f.value = true;
      try {
        const a = await Pe({ monomerId: l.monomerId, projectId: h.value, areaId: l.areaId });
        m.value = a;
      } catch (a) {
        console.log("获取商务构件成本失败", a);
      } finally {
        f.value = false;
      }
    }
  }
  function J() {
    m.value = { ...U };
  }
  function M(a, t = false) {
    t && o.data.forEach((e) => {
      e.unitPrice = e.originUnitPrice, e.newUnitPrice = e.originNewUnitPrice, e.pricingManner = e.originPricingManner, e.totalPrice = (e.pricingManner === N.WEIGHT.V ? e.totalWeight : e.totalLength) * (e.newUnitPrice || 0);
    }), _.value = a;
  }
  function Y() {
    H("checkSubmit"), v(() => {
      k.value = L.showAble;
    });
  }
  function Z() {
    _.value = false, o.toQuery();
  }
  return b({ modifying: _ }), (a, t) => {
    const e = le, P = D("common-button"), ee = D("print-table"), I = ce, w = ue, V = de, te = W("permission"), ne = W("thousand");
    return s(), u("div", we, [x(oe("div", null, [i(e, { modelValue: n(l).name, "onUpdate:modelValue": t[0] || (t[0] = (c) => n(l).name = c), placeholder: "可输入名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: j(n(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), i(e, { modelValue: n(l).material, "onUpdate:modelValue": t[1] || (t[1] = (c) => n(l).material = c), placeholder: "输入材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: j(n(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), i(n(ye))], 512), [[ae, n(o).searchToggle]]), i(n(be), null, ie({ viewLeft: r(() => [n(C)(n(o).permission.cost) && n(l).monomerId ? (s(), u("span", xe, [i(V, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: r(() => [t[8] || (t[8] = p(" 分段总量(t)： ")), f.value ? (s(), y(w, { key: 1 }, { default: r(() => [i(I)]), _: 1 })) : (s(), u("span", Ce, O(n(q)(m.value.mete, "kg", "t", n(K).COM_WT__T)), 1))]), _: 1, __: [8] }), i(V, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: r(() => [t[9] || (t[9] = p(" 分段总数(件)： ")), f.value ? (s(), y(w, { key: 1 }, { default: r(() => [i(I)]), _: 1 })) : (s(), u("span", Te, O(m.value.quantity), 1))]), _: 1, __: [9] }), i(V, { effect: "plain", type: "success", size: "large", class: "filter-item" }, { default: r(() => {
      var c;
      return [t[10] || (t[10] = p(" 分段造价(元)： ")), f.value ? (s(), y(w, { key: 1 }, { default: r(() => [i(I)]), _: 1 })) : (s(), u(se, { key: 0 }, [(c = m.value) != null && c.price ? x((s(), u("span", Ue, null, 512)), [[ne, m.value.price]]) : (s(), u("span", Me))], 64))];
    }), _: 1, __: [10] })])) : B("", true)]), _: 2 }, [n(l).monomerId ? { name: "optRight", fn: r(() => [n(C)(n(o).permission.save) ? (s(), u("span", Ve, [_.value ? (s(), u("span", ve, [i(P, { type: "warning", size: "default", onClick: t[2] || (t[2] = (c) => M(false, true)) }, { default: r(() => t[5] || (t[5] = [p("取消录入")])), _: 1, __: [5] }), i(P, { type: "success", size: "default", onClick: Y }, { default: r(() => t[6] || (t[6] = [p("预览并保存")])), _: 1, __: [6] })])) : (s(), y(P, { key: 1, type: "primary", size: "default", onClick: t[3] || (t[3] = (c) => M(true)) }, { default: r(() => t[7] || (t[7] = [p("录入价格")])), _: 1, __: [7] }))])) : B("", true), x(i(ee, { "api-key": "contractBoxPrice", params: { ...n(l) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[te, n(o).permission.print]])]), key: "0" } : void 0]), 1024), i(n(he), re({ modelValue: k.value, "onUpdate:modelValue": t[4] || (t[4] = (c) => k.value = c), "modified-data": A.value }, a.$attrs, { params: R.value, onSuccess: Z }), null, 16, ["modelValue", "modified-data", "params"])]);
  };
} }, ze = me(Ee, [["__scopeId", "data-v-ac3d799c"]]), Be = Object.freeze(Object.defineProperty({ __proto__: null, default: ze }, Symbol.toStringTag, { value: "Module" }));
export {
  je as c,
  Be as h,
  ze as m
};
