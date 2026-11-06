import { useRoute as g } from "vue-router";
import { inject as n } from "vue";
import { ref as y } from "vue";
import { onMounted as Y } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as k } from "vue";
import { withDirectives as w } from "vue";
import { unref as e } from "vue";
import { normalizeStyle as B } from "vue";
import { createBlock as V } from "vue";
import { createCommentVNode as C } from "vue";
import { ElDatePicker as H } from "element-plus";
import { vLoading as b } from "element-plus";
import { _ as I, p as N, o as P } from "../../../../shared/runtime.js";
import z from "./module/chart.vue.js";
import "../../../../modules/index-18acf776.js";
const E = { class: "project-chart" }, M = { class: "chart-head" }, R = { __name: "index", emits: ["update:year"], setup(q, { emit: c }) {
  const d = c, l = g(), p = n("projectInfo"), _ = n("permission"), a = y(N(/* @__PURE__ */ new Date(), "{y}")), { maxHeight: m } = P({ extraBox: ".chart-head", wrapperBox: ".chart-container", minHeight: 566, extraHeight: 40 });
  Y(() => {
    s(a.value);
  });
  function u(t) {
    return t > /* @__PURE__ */ new Date();
  }
  function s(t) {
    d("update:year", t);
  }
  return (t, r) => {
    const h = H, f = b, v = j("permission");
    return o(), i("div", E, [D("div", M, [k(h, { modelValue: a.value, "onUpdate:modelValue": r[0] || (r[0] = (x) => a.value = x), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", "value-format": "YYYY", format: "YYYY", "disabled-date": u, onChange: s }, null, 8, ["modelValue"])]), w((o(), i("div", { class: "chart-container", style: B({ height: e(m) + "px" }) }, [e(l).name !== "PlanProject" ? (o(), V(e(z), { key: 0, id: "projectChart", width: "300px" })) : C("", true)], 4)), [[f, e(p).loading], [v, e(_).statistics]])]);
  };
} }, $ = I(R, [["__scopeId", "data-v-16df5398"]]);
export {
  $ as default
};
