import { ref as g } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as s } from "vue";
import { createBlock as V } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as l } from "vue";
import { createElementBlock as t } from "vue";
import { Fragment as x } from "vue";
import { renderList as y } from "vue";
import { createVNode as b } from "vue";
import { toDisplayString as k } from "vue";
import { unref as n } from "vue";
import { isRef as w } from "vue";
import { ElImage as B } from "element-plus";
import { _ as C, u as D } from "../../../../shared/runtime.js";
const I = "/static/png/plm-android-a5d600e5.png";
const N = { class: "app-list" }, E = { class: "app-name" }, L = { __name: "show-dialog", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue"], setup(c, { emit: d }) {
  const i = c, p = d, { visible: o, handleClose: r } = D({ emit: p, props: i }), m = g([{ name: "数字化系统安卓手机应用", code: I }]);
  return (S, a) => {
    const _ = B, u = v("common-dialog");
    return s(), V(u, { modelValue: n(o), "onUpdate:modelValue": a[0] || (a[0] = (e) => w(o) ? o.value = e : null), "before-close": n(r), title: "手机端应用", width: "400px", "close-on-click-modal": false, "destroy-on-close": "" }, { default: h(() => [l("div", N, [(s(true), t(x, null, y(m.value, (e, f) => (s(), t("div", { class: "app-item", key: f }, [b(_, { class: "app-code", src: e.code, fit: "fill" }, null, 8, ["src"]), l("div", E, k(e.name), 1)]))), 128))])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, G = C(L, [["__scopeId", "data-v-3c7a3d67"]]);
export {
  G as default
};
