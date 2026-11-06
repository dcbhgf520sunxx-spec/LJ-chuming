import { inject as W } from "vue";
import { ref as p } from "vue";
import { computed as v } from "vue";
import { watch as C } from "vue";
import { nextTick as E } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as O } from "vue";
import { unref as I } from "vue";
import { Fragment as Q } from "vue";
import { renderList as R } from "vue";
import { createBlock as V } from "vue";
import { withCtx as B } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as F } from "vue";
import { withDirectives as U } from "vue";
import { resolveDynamicComponent as $ } from "vue";
import { ElTag as H } from "element-plus";
import { vLoading as K } from "element-plus";
import { _ as z, f3 as G, jP as T, vc as J, cO as X, jl as Y, am as d, k3 as Z, sT as ee, sU as te, v9 as ae } from "../../../../../../shared/runtime.js";
import se from "./module/requisition-order.vue.js";
import ie from "./module/steel/index.vue.js";
import L from "./module/auxiliary-material/index.vue.js";
import "./module/steel/module/steel-plate-table.vue.js";
import "./module/steel/module/section-steel-table.vue.js";
import "./module/steel/module/steel-coil-table.vue.js";
import "./module/steel/module/other-steel-material-table.vue.js";
const ne = { class: "requisition-main-content" }, re = { class: "content-left" }, ce = { class: "content-right" }, oe = { class: "right-head flex-rbs" }, ue = { class: "requisitions-list" }, le = { __name: "index", emits: "add-purchase", setup(de, { expose: P, emit: A }) {
  var q;
  const M = A, r = (q = W("cu")) == null ? void 0 : q.form, S = p(), _ = p(), m = p(false), n = p([]), g = v(() => {
    var a;
    return ((a = r.requisitions) == null ? void 0 : a.map((s) => s.id)) || [];
  });
  C(g, (a, s) => {
    G(a, s) || y();
  }, { immediate: true, deep: true });
  const N = v(() => r == null ? void 0 : r.currentMaterial);
  C(N, (a) => {
    y();
  });
  const j = v(() => {
    switch (N.value) {
      case T.STEEL.V:
        return ie;
      case T.MATERIAL.V:
        return L;
      case T.OTHER.V:
        return L;
      default:
        return L;
    }
  });
  async function y() {
    var a, s, f;
    if (n.value = [], !((a = g.value) != null && a.length)) {
      E(() => {
        var i;
        return (i = _.value) == null ? void 0 : i.initList([]);
      });
      return;
    }
    try {
      m.value = true;
      const i = await J({ ids: g.value }) || [];
      let c = i == null ? void 0 : i.filter((t) => t.basicClass & r.currentMaterial);
      c.map((t) => {
        var e, u;
        t.accountingUnit = void 0, t.projectId = (e = t.project) == null ? void 0 : e.id, t.projectAttribute = (u = t.project) == null ? void 0 : u.projectAttribute;
      }), c = c.filter((t) => !t.projectAttribute || t.projectAttribute === r.projectAttribute), await X(c), n.value = await Y(c, { toSmallest: false, toNum: true }, { mete: ["mete", "productMete"] });
      for (let t = 0; t < n.value.length; t++) {
        n.value[t].basicClass === d.SECTION_STEEL.V && (n.value[t].standardId = n.value[t].standardId || ((s = n.value[t].nationalStandardOptions.find((o) => o.boolDefault === true)) == null ? void 0 : s.standardId));
        const e = n.value[t];
        e.purchaseSN = (f = r.requisitionsKV[e.applyPurchaseId]) == null ? void 0 : f.serialNumber, e.productQuantity = e.productQuantity || 0, e.productMete = e.productMete || 0;
        const u = e.mete, b = e.quantity;
        if (e.originMete = u, e.originQuantity = b, e.canPurchaseQuantity = b - e.productQuantity > 0 ? b - e.productQuantity : 0, e.canPurchaseMete = u - e.productMete > 0 ? u - e.productMete : 0, e.quantity = e.canPurchaseQuantity, e.basicClass & Z) {
          if (e.purchaseTotalWeight = e.mete, e.weighingTotalWeight = e.canPurchaseMete, e.model) {
            if (e.basicClass & d.STEEL_PLATE.V || e.basicClass & d.STEEL_COIL.V) {
              const o = e.model.split("*");
              e.thickness = typeof Number(o[0]) == "number" ? Number(o[0]) : void 0, e.width = typeof Number(o[1]) == "number" ? Number(o[1]) : void 0, e.length = typeof Number(o[2]) == "number" ? Number(o[2]) : void 0;
            }
            e.basicClass & d.SECTION_STEEL.V && (e.length = typeof Number(e.model) == "number" ? Number(e.model) : void 0);
          }
          e.basicClass & d.STEEL_PLATE.V && (e.theoryWeight = await ee({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness }), e.theoryTotalWeight = e.theoryWeight * e.quantity), e.basicClass & d.SECTION_STEEL.V && (e.theoryWeight = await te({ length: e.length, unitWeight: e.unitWeight }), e.theoryTotalWeight = e.theoryWeight * e.quantity, e.totalLength = ae({ length: e.length, quantity: e.quantity }));
        } else e.mete = e.canPurchaseMete;
      }
      E(() => {
        var t;
        (t = _.value) == null || t.initList(n.value), m.value = false;
      });
    } catch (i) {
      m.value = false, console.log(i, "获取可采购列表失败");
    }
  }
  function k(a, s) {
    M("add-purchase", a);
  }
  async function x() {
    E(() => {
      var a;
      return (a = S.value) == null ? void 0 : a.fetchList();
    }), await y();
  }
  return P({ openInit: x }), (a, s) => {
    const f = H, i = K;
    return h(), w("div", ne, [l("div", re, [O(I(se), { ref_key: "requisitionOrderRef", ref: S }, null, 512)]), s[1] || (s[1] = l("div", { class: "vertical-dashed-divider" }, null, -1)), l("div", ce, [l("div", oe, [l("span", ue, [s[0] || (s[0] = l("span", { class: "label" }, "申购清单", -1)), (h(true), w(Q, null, R(I(r).requisitions, (c) => (h(), V(f, { key: c.id, class: "requisitions-sn-tag", effect: "plain", type: "success" }, { default: B(() => [D(F(c.serialNumber), 1)]), _: 2 }, 1024))), 128))])]), U((h(), V($(j.value), { ref_key: "compRef", ref: _, onAddPurchase: k }, null, 544)), [[i, m.value]])])]);
  };
} }, Ee = z(le, [["__scopeId", "data-v-f256dcb8"]]);
export {
  Ee as default
};
