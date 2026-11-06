import { q2 as e, u as w } from "../../../../../shared/runtime.js";
import { _ as U } from "./output-wage/index.vue.js";
import y from "./hourly-worker/index.vue.js";
import { ref as i } from "vue";
import { computed as O } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as E } from "vue";
import { createVNode as k } from "vue";
import { unref as t } from "vue";
import { resolveDynamicComponent as T } from "vue";
import { isRef as W } from "vue";
import "./output-wage/module/header.vue.js";
import "./output-wage/module/update-record.vue.js";
const L = { __name: "index", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(l, { emit: c }) {
  const p = c, f = l, r = i(), a = i(e.OUTPUTWAGE.V), { visible: n, handleClose: b } = w({ emit: p, props: f, field: "visible", showHook: v }), V = O(() => {
    switch (a.value) {
      case e.OUTPUTWAGE.V:
        return U;
      case e.HOURLYWORKER.V:
        return y;
      default:
        return;
    }
  });
  async function v() {
    await r.value.fetchData();
  }
  return (g, o) => {
    const R = m("component-radio-button"), _ = m("common-drawer");
    return u(), d(_, { "append-to-body": "", ref: "drawerRef", title: "报表详情", modelValue: t(n), "onUpdate:modelValue": o[1] || (o[1] = (s) => W(n) ? n.value = s : null), direction: "rtl", "before-close": t(b), size: "80%" }, { content: E(() => [k(R, { modelValue: a.value, "onUpdate:modelValue": o[0] || (o[0] = (s) => a.value = s), options: t(e).ENUM, disabledVal: [t(e).HOURLYWORKER.V], type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "disabledVal"]), (u(), d(T(V.value), { detail: l.info, ref_key: "componentRef", ref: r }, null, 8, ["detail"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  L as default
};
