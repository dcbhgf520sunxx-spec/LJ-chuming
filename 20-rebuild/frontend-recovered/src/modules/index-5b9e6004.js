import { _ as i, a as d } from "../shared/runtime.js";
import { C as p } from "./vue3-count-to.esm-8987f38d.js";
import { resolveDirective as u } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as s } from "vue";
import { normalizeClass as r } from "vue";
import { createVNode as f } from "vue";
import { createCommentVNode as m } from "vue";
import { createElementVNode as n } from "vue";
import { normalizeStyle as o } from "vue";
import { toDisplayString as y } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as v } from "vue";
import { unref as g } from "vue";
const S = { class: "card-panel-description" }, x = { key: 0, class: "card-panel-empty" }, w = { __name: "index", props: { name: { type: [String, Number], default: void 0 }, icon: { type: String, default: void 0 }, showEmpty: { type: Boolean, default: false }, precision: { type: Number, default: 0 }, separator: { type: String, default: "," }, startVal: { type: [Number, String], default: 0 }, endVal: { type: [Number, String], required: true }, color: { type: String, default: "blue" }, textColor: { type: String, default: "rgba(0, 0, 0, 0.45)" }, numColor: { type: String, default: "" }, suffix: { type: String, default: "" }, cursor: { type: Boolean, default: false }, alwaysShow: { type: Boolean, default: false } }, setup(t) {
  const e = t;
  return (h, C) => {
    const l = d, c = u("empty");
    return a(), s("div", { class: r(["card-panel", e.alwaysShow ? "alwaysShow" : ""]), style: o({ cursor: e.cursor ? "pointer" : "" }) }, [e.icon ? (a(), s("div", { key: 0, class: r(["card-panel-icon-wrapper", [`icon-${e.color}`]]) }, [f(l, { "icon-class": e.icon, "class-name": "card-panel-icon" }, null, 8, ["icon-class"])], 2)) : m("", true), n("div", S, [n("div", { class: "card-panel-text", style: o({ color: e.textColor }) }, y(e.name), 5), t.showEmpty ? _((a(), s("span", x, null, 512)), [[c]]) : (a(), v(g(p), { key: 1, style: o({ color: e.numColor }), "start-val": e.startVal, "end-val": e.endVal, decimals: e.precision, separator: e.separator, suffix: t.suffix, duration: 2600, class: "card-panel-num" }, null, 8, ["style", "start-val", "end-val", "decimals", "separator", "suffix"]))])], 6);
  };
} }, V = i(w, [["__scopeId", "data-v-9df9292d"]]);
export {
  V as P
};
