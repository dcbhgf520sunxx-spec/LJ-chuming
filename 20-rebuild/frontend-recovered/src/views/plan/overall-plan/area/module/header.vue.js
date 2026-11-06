import { useRouter as S } from "vue-router";
import { ref as i } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as y } from "vue";
import { vShow as P } from "vue";
import { unref as n } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as f } from "vue";
import { createBlock as g } from "vue";
import { withCtx as T } from "vue";
import { withModifiers as M } from "vue";
import { createTextVNode as N } from "vue";
import { createCommentVNode as x } from "vue";
import { B as L, q as U, E as O, sV as Q, T as G, K as h } from "../../../../../shared/runtime.js";
const A = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, emits: ["monomerChangeType", "monomerValChange"], setup(v, { emit: V }) {
  const c = S(), C = { monomerId: void 0, productType: void 0 }, I = i(), { crud: e, query: a } = L(C), _ = { key: "no", label: "name", value: "no" }, r = i([]), s = v, u = V;
  async function j() {
    try {
      e.query.monomerId ? await q() : (r.value = [], u("monomerChangeType", r.value));
    } catch (o) {
      console.log(o);
    } finally {
      e.toQuery();
    }
  }
  function b(o) {
    u("monomerValChange", o);
  }
  async function q() {
    r.value = [];
    try {
      const { productTypeList: o } = await Q(e.query.monomerId), t = [];
      o && o.length > 0 && (o.forEach((m) => {
        m.no === G.STRUCTURE.V ? t.unshift(m) : t.push(m);
      }), r.value = t), e.query.productType = r.value.length > 0 ? r.value[0].no : void 0, u("monomerChangeType", r.value);
    } catch (o) {
      console.log(o);
    }
  }
  function k() {
    s.globalProject.projectType === h.STEEL.V ? c.push({ name: "PlanMakeManage", params: { monomerId: e.query.monomerId, productType: e.query.productType } }) : s.globalProject.projectType === h.BRIDGE.V && c.push({ name: "BridgeMakeManage", params: { monomerId: e.query.monomerId, productType: e.query.productType } });
  }
  return (o, t) => {
    const m = d("common-radio-button"), E = d("common-button"), w = B("permission");
    return p(), R("div", null, [y(D("div", null, [f(n(U), { ref_key: "monomerSelectRef", ref: I, modelValue: n(a).monomerId, "onUpdate:modelValue": t[0] || (t[0] = (l) => n(a).monomerId = l), "project-id": s.projectId, class: "filter-item", onChange: j, onGetCurrentInfo: b }, null, 8, ["modelValue", "project-id"]), f(m, { modelValue: n(a).productType, "onUpdate:modelValue": t[1] || (t[1] = (l) => n(a).productType = l), options: r.value, type: "other", dataStructure: _, class: "filter-item", onChange: n(e).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[P, n(e).searchToggle]]), n(a).productType ? (p(), g(n(O), { key: 0 }, { viewLeft: T(() => [y((p(), g(E, { type: "primary", size: "default", onClick: M(k, ["stop"]) }, { default: T(() => t[2] || (t[2] = [N("办理计划")])), _: 1, __: [2] })), [[w, n(e).permission.planList]])]), _: 1 })) : x("", true)]);
  };
} };
export {
  A as default
};
