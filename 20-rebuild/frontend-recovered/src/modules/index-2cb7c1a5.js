import { _ as D, V as j, i as V, b as d, bl as w, ai as z } from "../shared/runtime.js";
import { useStore as I } from "vuex";
import { computed as p } from "vue";
import { watch as B } from "vue";
import { ref as T } from "vue";
import { nextTick as E } from "vue";
import { resolveComponent as K } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as P } from "vue";
import { withCtx as R } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as q } from "vue";
import { unref as x } from "vue";
import { createCommentVNode as O } from "vue";
const L = (o, f = false) => {
  const r = I(), a = p(() => r.state.config.loaded.purchaseOrders);
  if ((!a.value || f) && (r.commit("config/SET_LOADED", { key: "purchaseOrders", loaded: false }), r.dispatch("config/fetchPurchaseOrder")), o) {
    const m = B(a, (s) => {
      s && setTimeout(() => {
        o(), m();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: a, purchaseOrders: p(() => r.state.config.purchaseOrders), purchaseOrderKV: p(() => r.state.config.purchaseOrderKV) };
};
const M = { class: "purchase-order-select-container" }, U = { class: "customize-option-item" }, Y = { class: "flex-rsc label" }, F = { class: "extra-label" }, G = { key: 0, class: "extra-label" }, H = { class: "more-text-info ellipsis-text" }, J = { key: 1, class: "extra-label" }, Q = { class: "more-text-info ellipsis-text" }, W = { __name: "index", props: { modelValue: { type: [Array, Number, String] }, info: { type: Object }, reload: { type: Boolean, default: true }, detailable: { type: Boolean, default: true }, basicClass: { type: Number }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择采购合同" }, supplierId: { type: [Number, String], default: "" }, year: { type: String, default: "" } }, emits: ["change", "info-change", "update:modelValue"], setup(o, { emit: f }) {
  const r = f, a = o, m = p(() => ({ value: "id", label: "serialNumber", key: "id" })), s = T(), { loaded: C, purchaseOrders: N, purchaseOrderKV: _ } = L(S, a.reload), u = p(() => {
    let l = j(N.value);
    return a.basicClass && (l = l.filter((e) => e.basicClass & a.basicClass), l = l.map((e) => (e.projectNames = e.projects ? e.projects.map((n) => n.shortName).join("、") : "", e))), a.supplierId && (l = l.filter((e) => {
      var n;
      return ((n = e.supplier) == null ? void 0 : n.id) === a.supplierId;
    })), a.year && (l = l.filter((e) => e.createYear === a.year)), l;
  });
  B(() => a.modelValue, (l) => {
    s.value = l;
  }, { immediate: true });
  function h(l) {
    let e = l;
    d(e) && (e = void 0);
    const n = !z(e, a.modelValue), c = d(e) && d(a.modelValue);
    n && !c && (r("update:modelValue", e), r("change", e, a.modelValue), b(e, a.modelValue));
  }
  function b(l, e) {
    const n = l ? _.value[l] : null, c = e ? _.value[e] : null;
    r("info-change", n, c);
  }
  function S() {
    V(s.value) ? b(s.value) : k();
  }
  function k() {
    E(() => {
      if (!(d(u.value) || s.value)) {
        if (a.onlyOneDefault && u.value.length === 1) {
          s.value = u.value[0].id, h(s.value);
          return;
        }
        if (a.default) {
          s.value = u.value[0].id, h(s.value);
          return;
        }
        d(s.value) && V(a.info) && b();
      }
    });
  }
  return (l, e) => {
    const n = K("common-select"), c = A("parse-enum");
    return v(), y("span", M, [P(n, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (i) => s.value = i), size: o.size, disabled: o.disabled, multiple: o.multiple, "collapse-tags": o.collapseTags, loading: !x(C), clearable: o.clearable, filterable: "", placeholder: o.placeholder, options: u.value, "data-structure": m.value, class: "purchase-order-select", onChange: h }, { view: R(({ data: i }) => [t("span", U, [t("span", Y, [t("span", null, g(i.serialNumber), 1)]), t("span", null, [t("span", F, [e[1] || (e[1] = t("span", { class: "title" }, "类型：", -1)), q(t("span", null, null, 512), [[c, { e: x(w), v: i.basicClass, bit: true, split: " | " }]])]), i.supplier ? (v(), y("span", G, [e[2] || (e[2] = t("span", { class: "title" }, "供应商：", -1)), t("span", H, g(i.supplier.name), 1)])) : O("", true), i.projectNames ? (v(), y("span", J, [e[3] || (e[3] = t("span", { class: "title" }, "项目：", -1)), t("span", Q, g(i.projectNames), 1)])) : O("", true)])])]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "placeholder", "options", "data-structure"])]);
  };
} }, $ = D(W, [["__scopeId", "data-v-61eb9572"]]);
export {
  $ as p
};
