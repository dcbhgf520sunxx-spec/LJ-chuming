import { dC as i, u as O, dA as l } from "../../../../../shared/runtime.js";
import w from "../detail/record-page.vue.js";
import { ref as b } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as f } from "vue";
import { createBlock as p } from "vue";
import { withCtx as v } from "vue";
import { createElementVNode as g } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as R } from "vue";
import { createVNode as E } from "vue";
import { isRef as T } from "vue";
import "../../components/table-config-card.vue.js";
import "../../../../../modules/project-config-3fa4f850.js";
import "../../../../../modules/tender-apply-c04ffc5b.js";
const h = { class: "head-container" }, B = { __name: "record-config-drawer", props: { modelValue: { type: Boolean, default: void 0 }, title: { type: String, default: void 0 }, rowValue: { type: Number, default: void 0 }, detailInfo: { type: Object, default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(o, { emit: V }) {
  const e = b(i.DOMESTIC.V), t = o, r = V, { visible: s, handleClose: C } = O({ props: t, emit: r, showHook: c, closseHook: c });
  function y() {
    r("success");
  }
  async function c() {
    t.rowValue === l.FIRM_RECORD_CONFIG.V || t.rowValue === l.PROJECT_SIGN_IN_CONFIG.V ? e.value = i.DOMESTIC.V : e.value = void 0;
  }
  function _(d) {
    e.value = d;
  }
  return (d, a) => {
    const I = m("common-radio-button"), N = m("common-drawer");
    return f(), p(N, { size: "30%", title: t.title, "close-on-click-modal": false, modelValue: n(s), "onUpdate:modelValue": a[1] || (a[1] = (u) => T(s) ? s.value = u : null), "before-close": n(C) }, { content: v(() => [g("div", h, [o.rowValue === n(l).FIRM_RECORD_CONFIG.V || o.rowValue === n(l).PROJECT_SIGN_IN_CONFIG.V ? (f(), p(I, { key: 0, modelValue: e.value, "onUpdate:modelValue": a[0] || (a[0] = (u) => e.value = u), options: n(i).ENUM, class: "filter-item", size: "default", type: "enum", onChange: _ }, null, 8, ["modelValue", "options"])) : R("", true)]), E(w, { "config-enum": o.detailInfo, countryType: e.value, permission: o.permission, onSuccess: y }, null, 8, ["config-enum", "countryType", "permission"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  B as default
};
