import { _ as c } from "../shared/runtime.js";
import { openBlock as a } from "vue";
import { createElementBlock as s } from "vue";
import { Fragment as d } from "vue";
import { renderList as r } from "vue";
import { normalizeClass as u } from "vue";
import { createElementVNode as n } from "vue";
import { normalizeStyle as _ } from "vue";
import { toDisplayString as f } from "vue";
const h = { props: { value: { type: null, default: void 0 }, colors: { type: Array, default: () => [] }, colorBorder: { type: Boolean, default: false }, selectAble: { type: Boolean, default: false }, multiple: { type: Boolean, default: false } }, methods: { handleSelectChange(e) {
  this.selectAble && (this.multiple || (e.value !== this.value ? this.handleEmit(e) : this.handleEmit()));
}, handleEmit(e) {
  console.log(e), this.$emit("update:value", e ? e.value : void 0), this.$emit("change", e);
} } }, m = { class: "color-container" }, p = ["onClick"], v = { class: "title ellipsis-text" };
function y(e, b, t, C, g, o) {
  return a(), s("div", m, [(a(true), s(d, null, r(t.colors, (l, i) => (a(), s("span", { key: i, class: u([{ "select-able": t.selectAble, active: t.value !== void 0 && t.value === l.value }, "color-drawer"]), onClick: (B) => o.handleSelectChange(l) }, [n("span", { style: _({ "background-color": l.color, border: t.colorBorder ? "" : "none" }), class: "color" }, null, 4), n("span", v, f(l.title), 1)], 10, p))), 128))]);
}
const S = c(h, [["render", y], ["__scopeId", "data-v-640b64cb"]]);
export {
  S as C
};
