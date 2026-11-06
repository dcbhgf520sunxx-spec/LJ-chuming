import { _ as p, a as d } from "../../../../../../../shared/runtime.js";
import { resolveDirective as _ } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as t } from "vue";
import { normalizeClass as n } from "vue";
import { createVNode as u } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as c } from "vue";
import { normalizeStyle as o } from "vue";
import { toDisplayString as l } from "vue";
import { withDirectives as m } from "vue";
const f = { class: "card-panel-description" }, g = { key: 0, class: "card-panel-empty" }, v = { __name: "index", props: { cursor: { type: Boolean, default: false }, alwaysShow: { type: Boolean, default: false }, color: { type: String, default: "blue" }, textColor: { type: String, default: "rgba(0, 0, 0)" }, showEmpty: { type: Boolean, default: false }, name: { type: [String, Number], default: void 0 }, content: { type: String, default: "" }, icon: { type: String, default: void 0 }, numColor: { type: String, default: "" } }, setup(s) {
  const e = s;
  return (S, w) => {
    const r = d, i = _("empty");
    return a(), t("div", { class: n([e.alwaysShow ? "alwaysShow" : "", "card-panel"]), style: o({ cursor: e.cursor ? "pointer" : "" }) }, [e.icon ? (a(), t("div", { key: 0, class: n([[`icon-${e.color}`], "card-panel-icon-wrapper"]) }, [u(r, { "icon-class": e.icon, "class-name": "card-panel-icon" }, null, 8, ["icon-class"])], 2)) : y("", true), c("div", f, [c("span", { style: o({ color: e.textColor }), class: "card-panel-text" }, l(e.name) + "： ", 5), s.showEmpty ? m((a(), t("span", g, null, 512)), [[i]]) : (a(), t("span", { key: 1, style: o({ color: e.numColor }), class: "card-panel-text" }, l(e.content), 5))])], 6);
  };
} }, C = p(v, [["__scopeId", "data-v-dcc1c3c5"]]);
export {
  C as default
};
