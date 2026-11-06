import { _, a as f } from "../../../../shared/runtime.js";
import { C as l } from "../../../../modules/vue3-count-to.esm-8987f38d.js";
import { openBlock as a } from "vue";
import { createElementBlock as t } from "vue";
import { normalizeClass as c } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as d } from "vue";
import { createElementVNode as n } from "vue";
import { normalizeStyle as r } from "vue";
import { toDisplayString as p } from "vue";
import { Fragment as g } from "vue";
import { renderList as v } from "vue";
import { unref as u } from "vue";
import { createBlock as S } from "vue";
const x = { class: "card-panel-description" }, C = { key: 0, class: "card-panel-num", style: { color: "#1a8ef9" } }, h = { style: { "margin-left": "2px" } }, k = { key: 0, style: { margin: "0 3px" } }, A = { __name: "index", props: { name: { type: [String, Number], default: void 0 }, icon: { type: String, default: void 0 }, precision: { type: Number, default: 0 }, separator: { type: String, default: "," }, startVal: { type: [String, Number, Array], default: 0 }, endVal: { type: [String, Number, Array], default: void 0 }, color: { type: String, default: "blue" }, textColor: { type: String, default: "rgba(0, 0, 0, 0.45)" }, numColor: { type: String, default: "" }, cursor: { type: Boolean, default: false }, alwaysShow: { type: Boolean, default: false }, isArray: { type: Boolean, default: false }, numArr: { type: Array, default: () => {
} } }, setup(y) {
  const e = y;
  return (b, w) => {
    const m = f;
    return a(), t("div", { class: c(["card-panel", e.alwaysShow ? "alwaysShow" : ""]), style: r({ cursor: e.cursor ? "pointer" : "" }) }, [e.icon ? (a(), t("div", { key: 0, class: c(["card-panel-icon-wrapper", [`icon-${e.color}`]]) }, [i(m, { "icon-class": e.icon, "class-name": "card-panel-icon" }, null, 8, ["icon-class"])], 2)) : d("", true), n("div", x, [n("div", { class: "card-panel-text", style: r({ color: e.textColor }) }, p(e.name), 5), e.isArray ? (a(), t("div", C, [(a(true), t(g, null, v(e.numArr, (s, o) => (a(), t("span", { key: o }, [i(u(l), { style: r({ color: e.numColor }), "start-val": 0, "end-val": s.quantity, decimals: s.precision, separator: e.separator, duration: 2600 }, null, 8, ["style", "end-val", "decimals", "separator"]), n("span", h, p(s.unit), 1), o !== e.numArr.length - 1 ? (a(), t("span", k, "|")) : d("", true)]))), 128))])) : (a(), S(u(l), { key: 1, style: r({ color: e.numColor }), "start-val": e.startVal, "end-val": e.endVal, decimals: e.precision, separator: e.separator, duration: 2600, class: "card-panel-num" }, null, 8, ["style", "start-val", "end-val", "decimals", "separator"]))])], 6);
  };
} }, z = _(A, [["__scopeId", "data-v-d17135f6"]]);
export {
  z as default
};
