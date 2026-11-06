import { _ as m, o as p } from "../../../../../../shared/runtime.js";
import c from "./common-footer.vue.js";
import d from "./confirm-dialog.vue.js";
import { ref as f } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as y } from "vue";
import { renderSlot as v } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as w } from "vue";
import { createVNode as h } from "vue";
import { normalizeStyle as B } from "vue";
import { unref as V } from "vue";
import "../../../../../../modules/use-approval-cfg-0a67817c.js";
const g = { class: "main-content" }, x = { __name: "common-wrapper", props: { validate: { type: Function }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "下一步" }, showTotal: { type: Boolean, default: true }, showFooter: { type: Boolean, default: true }, edit: { type: Boolean, default: false } }, setup(r, { expose: s }) {
  const e = r, a = f(false), { heightStyle: i } = p({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".requisitions-application-select"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false });
  async function o() {
    let t = true;
    typeof e.validate == "function" && (t = await e.validate()), a.value = t;
  }
  return s({ submit: o }), (t, l) => (n(), _("div", { style: B(V(i)), class: "requisitions-application-container" }, [y("div", g, [v(t.$slots, "default", {}, void 0, true)]), e.showFooter ? (n(), b(c, { key: 0, "btn-name": e.btnName, "show-total": e.showTotal, "total-name": e.totalName, "total-value": e.totalValue, unit: e.unit, class: "footer", onSubmit: o }, null, 8, ["btn-name", "show-total", "total-name", "total-value", "unit"])) : w("", true), h(d, { modelValue: a.value, "onUpdate:modelValue": l[0] || (l[0] = (u) => a.value = u) }, null, 8, ["modelValue"])], 4));
} }, H = m(x, [["__scopeId", "data-v-143cbf88"]]);
export {
  H as default
};
