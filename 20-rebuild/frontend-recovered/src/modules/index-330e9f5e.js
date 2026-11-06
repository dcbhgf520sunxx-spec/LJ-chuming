import { _ as n } from "../shared/runtime.js";
import { openBlock as i } from "vue";
import { createElementBlock as a } from "vue";
import { Fragment as l } from "vue";
import { createElementVNode as e } from "vue";
import { normalizeClass as r } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as c } from "vue";
import { normalizeStyle as d } from "vue";
const z = { __name: "index", props: { sizeInfo: { type: String }, direction: { type: String, default: "horizontal" }, customStyle: { type: String }, showType: { type: String, default: void 0 } }, setup(t) {
  const o = t;
  return (h, p) => (i(), a("div", { class: "mark-size", style: d(o.customStyle + `${o.direction === "horizontal" ? "flex-direction: row;" : "flex-direction: column;"}`) }, [t.showType !== "unshow" ? (i(), a(l, { key: 0 }, [e("div", { class: r(`line ${o.direction === "horizontal" ? "line-horizontal" : "line-vertical"}`) }, null, 2), e("div", { class: r(`arrow ${o.direction === "horizontal" ? "arrow-horizontal arrow-horizontal-left" : "arrow-vertical arrow-horizontal-top"}`) }, null, 2), e("div", null, s(o.sizeInfo), 1), e("div", { class: r(`arrow ${o.direction === "horizontal" ? "arrow-horizontal arrow-horizontal-right" : "arrow-vertical arrow-horizontal-bottom"}`) }, null, 2), e("div", { class: r(`line ${o.direction === "horizontal" ? "line-horizontal" : "line-vertical"}`) }, null, 2)], 64)) : c("", true)], 4));
} }, m = n(z, [["__scopeId", "data-v-3f719675"]]);
export {
  m as M
};
