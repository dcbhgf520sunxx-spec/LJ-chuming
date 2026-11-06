import { _ as d, cP as f, o as _ } from "../../../../../../shared/runtime.js";
import y from "./common-footer.vue.js";
import v from "./confirm-dialog.vue.js";
import { useRoute as h } from "vue-router";
import { computed as b } from "vue";
import { ref as g } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as V } from "vue";
import { renderSlot as x } from "vue";
import { createBlock as B } from "vue";
import { createCommentVNode as N } from "vue";
import { createVNode as S } from "vue";
import { normalizeStyle as T } from "vue";
import { unref as r } from "vue";
const q = { class: "main-content" }, D = { __name: "common-wrapper", props: { validate: { type: Function }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "下一步" }, showTotal: { type: Boolean, default: true }, showFooter: { type: Boolean, default: true }, edit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false }, basicClass: { type: Number, default: void 0 } }, setup(u, { expose: c }) {
  const s = h(), e = u, m = b(() => {
    var t, a;
    if (e.isTsData) {
      if (e.basicClass & f.MATERIAL.V) return (t = s.fullPath) == null ? void 0 : t.includes("requisitions-v2");
    } else return ((a = s.fullPath) == null ? void 0 : a.includes("requisitions-v2")) && !e.isTsData;
    return false;
  }), o = g(false), { heightStyle: H, maxHeight: l } = _({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".requisitions-application-select"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false });
  async function n() {
    let t = true;
    typeof e.validate == "function" && (t = await e.validate()), o.value = t;
  }
  return c({ submit: n }), (t, a) => (i(), w("div", { style: T(`height: ${m.value ? r(l) - 95 : r(l)}px`), class: "requisitions-application-container" }, [V("div", q, [x(t.$slots, "default", {}, void 0, true)]), e.showFooter ? (i(), B(y, { key: 0, "btn-name": e.btnName, "show-total": e.showTotal, "total-name": e.totalName, "total-value": e.totalValue, unit: e.unit, class: "footer", onSubmit: n }, null, 8, ["btn-name", "show-total", "total-name", "total-value", "unit"])) : N("", true), S(v, { modelValue: o.value, "onUpdate:modelValue": a[0] || (a[0] = (p) => o.value = p) }, null, 8, ["modelValue"])], 4));
} }, E = d(D, [["__scopeId", "data-v-8ce5e0e3"]]);
export {
  E as default
};
