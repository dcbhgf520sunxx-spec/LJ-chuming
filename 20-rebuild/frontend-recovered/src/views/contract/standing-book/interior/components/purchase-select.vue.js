import { computed as j } from "vue";
import { ref as k } from "vue";
import { watch as U } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as d } from "vue";
import { withCtx as y } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as D } from "vue";
import { unref as r } from "vue";
import { createCommentVNode as C } from "vue";
import { normalizeClass as N } from "vue";
import { withModifiers as A } from "vue";
import { View as K } from "@element-plus/icons-vue";
import { ElIcon as F } from "element-plus";
import { _ as H, le as J, V as L, lf as Q, i as V, b as p, am as W, lg as O, lh as X, li as Y, lj as Z, G as ee, ai as ae } from "../../../../../shared/runtime.js";
const le = { class: "customize-option-item" }, se = { class: "flex-rsc label" }, te = { class: "extra-label" }, oe = { key: 0, class: "extra-label" }, ne = { class: "more-text-info ellipsis-text" }, ie = { key: 1, class: "extra-label" }, ue = { class: "more-text-info ellipsis-text" }, re = { __name: "purchase-select", props: { modelValue: { type: [Array, Number, String] }, info: { type: Object }, reload: { type: Boolean, default: true }, detailable: { type: Boolean, default: false }, basicClass: { type: Number }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择采购合同编号" }, projectId: { type: [String, Number] } }, emits: ["change", "info-change", "update:modelValue", "update:info"], setup(i, { emit: w }) {
  const f = w, l = i, S = j(() => ({ value: "id", label: "serialNumber", key: "id" })), s = k(), m = k({}), { loaded: I, purchaseOrder: z } = J(q, l.reload), u = j(() => {
    let a = L(z.value);
    return l.basicClass && (a = a.filter((e) => e.basicClass & l.basicClass), a = a.map((e) => (e.projectNames = e.projects ? e.projects.map((n) => n.shortName).join("、") : "", e))), l.projectId && (a = a.filter((e) => e.projectIds == l.projectId)), a;
  }), { detailRef: R, openDetail: E } = Q();
  U(() => l.modelValue, (a) => {
    s.value = a, B();
  }, { immediate: true });
  function P(a) {
    a && E(a);
  }
  function h(a) {
    let e = a;
    p(e) && (e = void 0);
    const n = !ae(e, l.modelValue), c = p(e) && p(l.modelValue);
    n && !c && (f("update:modelValue", e), f("change", e, l.modelValue), b(e, l.modelValue));
  }
  function b(a, e) {
    const n = a ? m.value[a] : null, c = e ? m.value[e] : null;
    f("update:info", n), f("info-change", n, c);
  }
  function q() {
    m.value = {}, V(u.value) && u.value.forEach((a) => {
      m.value[a.id] = a;
    }), V(s.value) ? b(s.value) : B();
  }
  function B() {
    if (!(p(u.value) || s.value)) {
      if (l.onlyOneDefault && u.value.length === 1) {
        s.value = u.value[0].value, h(s.value);
        return;
      }
      if (l.default) {
        s.value = u.value[0].value, h(s.value);
        return;
      }
      p(s.value) && V(l.info) && b();
    }
  }
  return (a, e) => {
    const n = $("common-select"), c = K, G = F, M = x("parse-enum"), T = x("permission");
    return v(), _("span", { class: N([{ "show-detail-icon": l.detailable && r(ee)(r(O)) }, "purchase-sn-select-container"]) }, [d(n, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => s.value = o), clearable: i.clearable, "collapse-tags": i.collapseTags, "data-structure": S.value, disabled: i.disabled, loading: !r(I), multiple: i.multiple, options: u.value, placeholder: i.placeholder, size: i.size, class: "purchase-sn-select", filterable: "", onChange: h }, { view: y(({ data: o }) => [t("span", le, [t("span", se, [t("span", null, g(o.serialNumber), 1)]), t("span", null, [t("span", te, [e[2] || (e[2] = t("span", { class: "title" }, "类型：", -1)), D(t("span", null, null, 512), [[M, { e: r(W), v: o.basicClass, bit: true, split: " | " }]])]), o.supplier ? (v(), _("span", oe, [e[3] || (e[3] = t("span", { class: "title" }, "供应商：", -1)), t("span", ne, g(o.supplier.name), 1)])) : C("", true), o.projectNames ? (v(), _("span", ie, [e[4] || (e[4] = t("span", { class: "title" }, "项目：", -1)), t("span", ue, g(o.projectNames), 1)])) : C("", true)])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "data-structure", "disabled", "loading", "multiple", "options", "placeholder", "size"]), l.detailable ? D((v(), _("span", { key: 0, class: N([{ "not-allowed": !s.value }, "detail-icon pointer"]), onClick: e[1] || (e[1] = A((o) => P(s.value), ["stop"])) }, [d(G, { color: s.value ? "#1881ef" : "#c1c2c5" }, { default: y(() => [d(c)]), _: 1 }, 8, ["color"])], 2)), [[T, r(O)]]) : C("", true), d(Z, { ref_key: "purchaseOrderRef", ref: R, api: r(Y) }, { default: y(() => [d(X)]), _: 1 }, 8, ["api"])], 2);
  };
} }, pe = H(re, [["__scopeId", "data-v-a8a38a00"]]);
export {
  pe as default
};
