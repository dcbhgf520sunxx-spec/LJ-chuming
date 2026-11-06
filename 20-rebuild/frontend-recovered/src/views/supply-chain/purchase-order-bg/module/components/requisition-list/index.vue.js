import { inject as k } from "vue";
import { ref as u } from "vue";
import { computed as _ } from "vue";
import { watch as A } from "vue";
import { nextTick as g } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as I } from "vue";
import { unref as w } from "vue";
import { Fragment as b } from "vue";
import { renderList as R } from "vue";
import { createBlock as L } from "vue";
import { withCtx as Q } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as D } from "vue";
import { withDirectives as U } from "vue";
import { resolveDynamicComponent as F } from "vue";
import { ElTag as O } from "element-plus";
import { vLoading as j } from "element-plus";
import { _ as $, f3 as H, j_ as o, vJ as J, cO as K, jl as z, cV as G, am as S, sT as X, sU as Y, v9 as Z } from "../../../../../../shared/runtime.js";
import ee from "./module/requisition-order.vue.js";
import te from "./module/steel/index.vue.js";
import x from "./module/auxiliary-material/index.vue.js";
import ae from "./module/manufactured/index.vue.js";
import "./module/steel/module/steel-plate-table.vue.js";
import "./module/steel/module/section-steel-table.vue.js";
import "./module/steel/module/steel-coil-table.vue.js";
const se = { class: "requisition-main-content" }, ie = { class: "content-left" }, ne = { class: "content-right" }, ce = { class: "right-head flex-rbs" }, re = { class: "requisitions-list" }, oe = { __name: "index", emits: "add-purchase", setup(le, { expose: M, emit: V }) {
  var E;
  const C = V, n = (E = k("cu")) == null ? void 0 : E.form, y = u(), h = u(), l = u(false), c = u([]), m = _(() => {
    var t;
    return ((t = n.requisitions) == null ? void 0 : t.map((a) => a.id)) || [];
  });
  A(m, (t, a) => {
    H(t, a) || T();
  }, { immediate: true, deep: true });
  const v = _(() => n == null ? void 0 : n.materialType), N = _(() => {
    switch (v.value) {
      case o.STEEL.V:
        return te;
      case o.MATERIAL.V:
        return x;
      case o.OTHER.V:
        return x;
      case o.MANUFACTURED.V:
        return ae;
      default:
        return null;
    }
  });
  async function T() {
    var t, a;
    if (c.value = [], !((t = m.value) != null && t.length)) {
      g(() => {
        var s;
        return (s = h.value) == null ? void 0 : s.initList([]);
      });
      return;
    }
    try {
      l.value = true;
      const s = await J({ ids: m.value }) || [];
      if (v.value & o.MANUFACTURED.V) c.value = s;
      else {
        await K(s), c.value = await z(s, { toSmallest: false, toNum: true }, { mete: ["mete", "productMete"] });
        for (let i = 0; i < c.value.length; i++) {
          const e = c.value[i];
          e.purchaseSN = (a = n.requisitionsKV[e.applyPurchaseId]) == null ? void 0 : a.serialNumber, e.productQuantity = e.productQuantity || 0, e.productMete = e.productMete || 0;
          const f = e.mete, p = e.quantity;
          e.originMete = f, e.originQuantity = p, e.canPurchaseQuantity = p - e.productQuantity > 0 ? p - e.productQuantity : 0, e.canPurchaseMete = f - e.productMete > 0 ? f - e.productMete : 0, e.quantity = e.canPurchaseQuantity, e.basicClass & G ? (e.purchaseTotalWeight = e.mete, e.weighingTotalWeight = e.canPurchaseMete, e.basicClass & S.STEEL_PLATE.V && (e.theoryWeight = await X({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness }), e.theoryTotalWeight = e.theoryWeight * e.quantity), e.basicClass & S.SECTION_STEEL.V && (e.theoryWeight = await Y({ length: e.length, unitWeight: e.unitWeight }), e.theoryTotalWeight = e.theoryWeight * e.quantity, e.totalLength = Z({ length: e.length, quantity: e.quantity }))) : e.mete = e.canPurchaseMete;
        }
      }
      g(() => {
        var i;
        (i = h.value) == null || i.initList(c.value), l.value = false;
      });
    } catch (s) {
      l.value = false, console.log(s, "获取可采购列表失败");
    }
  }
  function P(t, a) {
    C("add-purchase", t);
  }
  async function W() {
    g(() => {
      var t;
      return (t = y.value) == null ? void 0 : t.fetchList();
    }), await T();
  }
  return M({ openInit: W }), (t, a) => {
    const s = O, i = j;
    return d(), q("div", se, [r("div", ie, [I(w(ee), { ref_key: "requisitionOrderRef", ref: y }, null, 512)]), a[1] || (a[1] = r("div", { class: "vertical-dashed-divider" }, null, -1)), r("div", ne, [r("div", ce, [r("span", re, [a[0] || (a[0] = r("span", { class: "label" }, "申购清单", -1)), (d(true), q(b, null, R(w(n).requisitions, (e) => (d(), L(s, { type: "success", key: e.id, effect: "plain", class: "requisitions-sn-tag" }, { default: Q(() => [B(D(e.serialNumber), 1)]), _: 2 }, 1024))), 128))])]), U((d(), L(F(N.value), { ref_key: "compRef", ref: h, onAddPurchase: P }, null, 544)), [[i, l.value]])])]);
  };
} }, ve = $(oe, [["__scopeId", "data-v-4045c5fd"]]);
export {
  ve as default
};
