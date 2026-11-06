import { _ as l } from "../shared/runtime.js";
import { computed as o } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { toDisplayString as c } from "vue";
import { normalizeStyle as n } from "vue";
const i = { __name: "vertical-label", props: { name: { type: String, default: "" }, color: { type: String, default: "#1682e6" }, textColor: { type: String, default: "#FFFFFF" }, top: { type: String, default: "-2px" }, left: { type: String, default: "10px" }, letterSpacing: { type: String, default: "2px" }, height: { type: String, default: void 0 }, opacity: { type: Number, default: 1 } }, setup(t) {
  const e = t, a = o(() => ({ "background-color": e.color, color: e.textColor, top: e.top, left: e.left, letterSpacing: e.letterSpacing, height: e.height, opacity: e.opacity }));
  return (s, _) => (r(), p("span", { class: "vertical-label", style: n(a.value) }, c(e.name), 5));
} }, y = l(i, [["__scopeId", "data-v-e0ee1f91"]]);
export {
  y as v
};
