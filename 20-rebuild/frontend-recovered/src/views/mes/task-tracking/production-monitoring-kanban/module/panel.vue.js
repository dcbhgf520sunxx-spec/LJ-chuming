import { _ as y, a as m } from "../../../../../shared/runtime.js";
import { C as n } from "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import { openBlock as a } from "vue";
import { createElementBlock as t } from "vue";
import { normalizeClass as o } from "vue";
import { createVNode as c } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as u } from "vue";
import { normalizeStyle as r } from "vue";
import { toDisplayString as _ } from "vue";
import { Fragment as g } from "vue";
import { renderList as v } from "vue";
import { unref as p } from "vue";
import { createBlock as S } from "vue";
const x = { class: "card-panel-description" }, C = { key: 0, class: "card-panel-num", style: { color: "#1a8ef9" } }, h = { key: 0, style: { margin: "0 3px" } }, k = { __name: "panel", props: { name: { type: [String, Number], default: void 0 }, icon: { type: String, default: void 0 }, precision: { type: Number, default: 0 }, separator: { type: String, default: "," }, startVal: { type: [String, Number, Array], default: 0 }, endVal: { type: [String, Number, Array], default: void 0 }, suffix: { type: String }, color: { type: String, default: "blue" }, textColor: { type: String, default: "rgba(0, 0, 0, 0.45)" }, numColor: { type: String, default: "" }, cursor: { type: Boolean, default: false }, alwaysShow: { type: Boolean, default: false }, isArray: { type: Boolean, default: false }, numArr: { type: Array, default: () => {
} } }, setup(d) {
  const e = d;
  return (A, N) => {
    const f = m;
    return a(), t("div", { class: o(["card-panel", e.alwaysShow ? "alwaysShow" : ""]), style: r({ cursor: e.cursor ? "pointer" : "" }) }, [e.icon ? (a(), t("div", { key: 0, class: o(["card-panel-icon-wrapper", [`icon-${e.color}`]]) }, [c(f, { "icon-class": e.icon, "class-name": "card-panel-icon" }, null, 8, ["icon-class"])], 2)) : i("", true), u("div", x, [u("div", { class: "card-panel-text", style: r({ color: e.textColor }) }, _(e.name), 5), e.isArray ? (a(), t("div", C, [(a(true), t(g, null, v(e.numArr, (s, l) => (a(), t("span", { key: l }, [c(p(n), { style: r({ color: e.numColor }), "start-val": 0, "end-val": s.taskNetWeight, decimals: s.precision, separator: e.separator, suffix: e.suffix, duration: 2600 }, null, 8, ["style", "end-val", "decimals", "separator", "suffix"]), l !== e.numArr.length - 1 ? (a(), t("span", h, "/")) : i("", true)]))), 128))])) : (a(), S(p(n), { key: 1, style: r({ color: e.numColor }), "start-val": e.startVal, "end-val": e.endVal, decimals: e.precision, separator: e.separator, suffix: e.suffix, duration: 2600, class: "card-panel-num" }, null, 8, ["style", "start-val", "end-val", "decimals", "separator", "suffix"]))])], 6);
  };
} }, V = y(k, [["__scopeId", "data-v-dec5fea7"]]);
export {
  V as default
};
