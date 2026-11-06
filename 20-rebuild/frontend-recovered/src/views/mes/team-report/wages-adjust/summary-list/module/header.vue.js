import { inject as l } from "vue";
import { ref as g } from "vue";
import { watch as h } from "vue";
import { resolveComponent as w } from "vue";
import { withDirectives as C } from "vue";
import { vShow as E } from "vue";
import { unref as e } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as R } from "vue";
import { createBlock as U } from "vue";
import { createCommentVNode as A } from "vue";
import { createVNode as p } from "vue";
import { B as L, a3 as n, q as j, C as v } from "../../../../../../shared/runtime.js";
import { u as b } from "../../../../../../modules/use-unshow-productType-by-mode-dfef77e4.js";
const O = { __name: "header", setup(k, { expose: i }) {
  const s = l("projectId"), f = l("organizationType"), y = { monomerId: void 0 }, { crud: r, query: o, CRUD: V } = L(y), { unshowVal: u, showComponent: I } = b({ resetQuery: function() {
    o.productType = void 0;
  } }), d = g();
  V.HOOK.beforeToQuery = () => {
    r.query.projectId = s;
  }, h(() => o.monomerId, (t) => {
    t && r.toQuery();
  }, { immediate: true, deep: true });
  function _() {
    var t;
    return ((t = d.value) == null ? void 0 : t.getOption(o.monomerId)) || {};
  }
  return i({ getMonomer: _ }), (t, a) => {
    const T = w("component-radio-button");
    return C((c(), R("div", null, [e(I) ? (c(), U(T, { key: 0, modelValue: e(o).productType, "onUpdate:modelValue": a[0] || (a[0] = (m) => e(o).productType = m), options: e(n).ENUM, type: "enumSL", default: "", unshowVal: e(f) ? [e(n).ENCLOSURE.V, e(n).AUXILIARY_MATERIAL.V, ...e(u)] : [e(n).ENCLOSURE.V, e(n).AUXILIARY_MATERIAL.V, ...e(u)], class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : A("", true), p(e(j), { ref_key: "monomerRef", ref: d, modelValue: e(o).monomerId, "onUpdate:modelValue": a[1] || (a[1] = (m) => e(o).monomerId = m), clearable: "", default: false, "project-id": e(s), class: "filter-item" }, null, 8, ["modelValue", "project-id"]), p(e(v))], 512)), [[E, e(r).searchToggle]]);
  };
} };
export {
  O as default
};
