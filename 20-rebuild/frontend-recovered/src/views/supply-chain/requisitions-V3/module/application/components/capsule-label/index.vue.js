import { _ as o } from "../../../../../../../shared/runtime.js";
import { openBlock as a } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as t } from "vue";
import { normalizeStyle as n } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as l } from "vue";
const r = { class: "basic_subscription_information_right" }, d = { key: 0 }, u = { __name: "index", props: { leftLabel: { type: String, default: "物料种类" }, rightLabel: { type: [Number, String], default: void 0 }, unit: { type: [Number, String], default: "种" }, showUnit: { type: Boolean, default: false }, bgc: { type: String, default: "#f0940a" } }, setup(e) {
  return (_, f) => (a(), s("div", { style: n(`border: ${e.bgc} solid 1px;`), class: "basic_subscription_information" }, [i("div", { style: n(`background-color:${e.bgc};`), class: "basic_subscription_information_left" }, t(e.leftLabel), 5), i("div", r, [c(t(e.rightLabel) + " ", 1), e.showUnit ? (a(), s("span", d, t(e.unit), 1)) : l("", true)])], 4));
} }, g = o(u, [["__scopeId", "data-v-14fce906"]]);
export {
  g as default
};
