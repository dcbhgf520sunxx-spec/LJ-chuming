import { ref as g } from "vue";
import { computed as V } from "vue";
import { watch as R } from "vue";
import { nextTick as U } from "vue";
import { resolveComponent as $ } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as r } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as j } from "vue";
import { withDirectives as B } from "vue";
import { unref as q } from "vue";
import { createCommentVNode as F } from "vue";
import { withModifiers as W } from "vue";
import { createBlock as G } from "vue";
import { normalizeClass as J } from "vue";
import { Plus as O } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElPopover as X } from "element-plus";
import { _ as Y, ll as Z, lm as L, ln as ee, i as ae, b as f, iW as le, ai as se } from "../../../../../../shared/runtime.js";
import te from "./module/add-supplier.vue.js";
const oe = { class: "customize-option-item" }, ne = { class: "flex-rsc label" }, ie = { key: 0, class: "extra-label" }, ue = { key: 1 }, ce = { __name: "index", props: { modelValue: { type: [Number, String, Array] }, basicClass: { type: Number }, logisticsCreateable: { type: Boolean, default: false }, showType: { type: Boolean, default: true }, type: { type: Number }, mode: { type: String, default: "contained" }, typeMode: { type: String, default: "cross" }, showHide: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择供应商" }, isAnnual: { type: Boolean, default: false } }, emits: ["change", "info-change", "update:modelValue"], setup(S, { emit: k }) {
  const m = k, e = S, w = { add: ["scm_supplier:add"] }, i = g(false), s = g(), { loaded: x, suppliers: b, supplierKV: N } = Z(M), { annualLoaded: A, annualSuppliers: z, annualSupplierKV: E } = L(), D = V(() => e.isAnnual ? A : x), _ = V(() => {
    let l = [];
    if (e.isAnnual ? l = z.value : l = e.showHide ? b.value : b.value.filter((a) => a.boolHide === ee.FALSE.V), e.basicClass) {
      if (e.mode === "contained") return l == null ? void 0 : l.filter((a) => (a.basicClass & e.basicClass) === a.basicClass);
      if (e.mode === "contain") return l == null ? void 0 : l.filter((a) => (a.basicClass & e.basicClass) === e.basicClass);
      if (e.mode === "cross") return l == null ? void 0 : l.filter((a) => a.basicClass & e.basicClass);
    }
    if (e.type) {
      if (e.typeMode === "contained") return l == null ? void 0 : l.filter((a) => (a.type & e.type) === a.type);
      if (e.typeMode === "contain") return l == null ? void 0 : l.filter((a) => (a.type & e.type) === e.type);
      if (e.typeMode === "cross") return l == null ? void 0 : l.filter((a) => a.type & e.type);
    }
    return l;
  });
  R(() => e.modelValue, (l) => {
    s.value = l;
  }, { immediate: true });
  function v(l) {
    let a = l;
    f(a) && (a = void 0);
    const o = !se(a, e.modelValue), u = f(a) && f(e.modelValue);
    o && !u && (m("update:modelValue", a), m("change", a), C(a, e.modelValue));
  }
  function C(l, a) {
    const o = e.isAnnual ? E.value : N.value, u = l ? o[l] : null, y = a ? o[a] : null;
    m("info-change", u, y);
  }
  function M() {
    ae(s.value) ? C(s.value) : H();
  }
  function T() {
    i.value = false;
  }
  function H() {
    U(() => {
      if (!(f(_.value) || s.value) && e.default) {
        s.value = _.value[0].id, v(s.value);
        return;
      }
    });
  }
  return (l, a) => {
    const o = $("common-select"), u = O, y = Q, I = X, K = h("parse-enum"), P = h("permission");
    return c(), d("span", { class: J([{ "show-add-icon": e.logisticsCreateable }, "supplier-sn-select-container"]) }, [r(o, { modelValue: s.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => s.value = t), clearable: e.clearable, "collapse-tags": e.collapseTags, disabled: e.disabled, filterable: e.filterable, loading: !D.value, multiple: e.multiple, options: _.value, placeholder: e.placeholder, size: e.size, class: "supplier-sn-select", onChange: v }, { view: p(({ data: t }) => [n("span", oe, [n("span", ne, [n("span", null, j(t.name), 1)]), n("span", null, [e.showType ? (c(), d("span", ie, [a[3] || (a[3] = n("span", { class: "title" }, "类型：", -1)), B(n("span", null, null, 512), [[K, { e: q(le), v: t.basicClass, bit: true, split: " | " }]])])) : F("", true)])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "filterable", "loading", "multiple", "options", "placeholder", "size"]), r(I, { visible: i.value, "onUpdate:visible": a[2] || (a[2] = (t) => i.value = t), placement: "top", width: "450" }, { reference: p(() => [e.logisticsCreateable ? (c(), d("span", { key: 0, class: "add-icon pointer", onClick: a[1] || (a[1] = W((t) => i.value = !i.value, ["stop"])) }, [B((c(), G(y, { color: "#1881ef" }, { default: p(() => [r(u)]), _: 1 })), [[P, w.add]])])) : (c(), d("span", ue))]), default: p(() => [r(te, { onClose: T })]), _: 1 }, 8, ["visible"])], 2);
  };
} }, fe = Y(ce, [["__scopeId", "data-v-f1365ece"]]);
export {
  fe as default
};
