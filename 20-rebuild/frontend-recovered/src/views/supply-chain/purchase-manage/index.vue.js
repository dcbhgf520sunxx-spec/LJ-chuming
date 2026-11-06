import { ref as t } from "vue";
import { provide as f } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as y } from "vue";
import { withCtx as g } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as n } from "vue";
import { withDirectives as x } from "vue";
import { vShow as k } from "vue";
import { normalizeClass as D } from "vue";
import { ElDivider as T } from "element-plus";
import B from "./module/LeftPage.vue.js";
import w from "./module/RightPage.vue.js";
import C from "./detail/index.vue.js";
import { _ as L } from "../../../shared/runtime.js";
import "../../../modules/useTableTotal-3d22365a.js";
import "./components/SectionSelect.vue.js";
import "../../../modules/right-page-12d526dc.js";
import "./detail/header.vue.js";
import "../../../modules/raw-materials.vue_vue_type_script_setup_true_lang-78536997.js";
import "./detail/finished-products.vue.js";
const N = { class: "app-container" }, P = { __name: "index", setup(R) {
  const l = t({}), u = t({}), o = t(null), i = t(null), _ = t({}), e = t("rough");
  f("topLevel", { formData: l, _commonFn: u, leftRef: o, orderId: i, itemData: _ });
  function m() {
    var r;
    (r = o.value) == null || r.getTableList();
  }
  return (r, p) => {
    const d = T;
    return a(), v("div", N, [h("div", { class: D(e.value === "rough" ? "top-container" : "") }, [y(B, { ref_key: "leftRef", ref: o, class: "left-container", "purchase-type": e.value, "onUpdate:purchaseType": p[0] || (p[0] = (s) => e.value = s) }, { default: g((s) => [e.value === "details" ? (a(), c(C, { key: 0, props: s, purchaseType: e.value }, null, 8, ["props", "purchaseType"])) : n("", true)]), _: 1 }, 8, ["purchase-type"]), e.value === "rough" ? (a(), c(d, { key: 0, class: "direction", direction: "vertical" })) : n("", true), e.value === "rough" ? x((a(), c(w, { key: 1, class: "right-container", onPrintSuccess: m }, null, 512)), [[k, i.value]]) : n("", true)], 2)]);
  };
} }, j = L(P, [["__scopeId", "data-v-0332fa1f"]]);
export {
  j as default
};
