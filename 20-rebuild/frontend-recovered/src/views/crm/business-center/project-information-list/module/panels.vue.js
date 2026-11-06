import { _ as p, a as u } from "../../../../../shared/runtime.js";
import { C as l } from "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import { openBlock as t } from "vue";
import { createElementBlock as e } from "vue";
import { Fragment as v } from "vue";
import { renderList as f } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as n } from "vue";
import { toDisplayString as x } from "vue";
import { unref as c } from "vue";
const b = { class: "panels-card" }, m = { class: "information-box" }, y = { class: "left-box" }, h = { class: "icon-box" }, g = { class: "sum-label" }, V = { class: "right-box" }, k = { key: 0, class: "prefix-label" }, S = { key: 1, class: "prefix-label" }, B = { __name: "panels", props: { dataList: { type: Array, default: () => [] }, separator: { type: String, default: "," } }, setup(r) {
  const d = r;
  return (C, o) => {
    const _ = u;
    return t(), e("div", b, [(t(true), e(v, null, f(d.dataList, (s, i) => (t(), e("div", { key: i, class: "content-box" }, [a("div", m, [a("div", y, [a("div", h, [n(_, { class: "icon", "icon-class": s.icon }, null, 8, ["icon-class"])]), a("span", g, x(s.label), 1)]), a("div", V, [a("div", null, [o[0] || (o[0] = a("span", { class: "prefix-label" }, "总", -1)), n(c(l), { class: "sum-data", "start-val": s.startVal, "end-val": s.endVal, separator: "" }, null, 8, ["start-val", "end-val"])]), a("div", null, [s.icon !== "crm-tender" ? (t(), e("span", k, "月")) : (t(), e("span", S, "中标率")), n(c(l), { class: "sum-data", "start-val": s.addStartVal, "end-val": s.addEndVal, separator: "", suffix: s.icon === "crm-tender" ? "%" : "" }, null, 8, ["start-val", "end-val", "suffix"])])])])]))), 128))]);
  };
} }, A = p(B, [["__scopeId", "data-v-edd05234"]]);
export {
  A as default
};
