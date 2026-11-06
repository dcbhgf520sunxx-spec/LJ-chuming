import { _ as i, bj as n } from "../../../../../shared/runtime.js";
import { openBlock as e } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as u } from "vue";
import a from "qrcode.vue";
import { unref as d } from "vue";
import { createCommentVNode as r } from "vue";
import { normalizeStyle as b } from "vue";
const y = { class: "ship-label-preview" }, p = { class: "table-1", border: "1", bordercolor: "#000000" }, m = { rowspan: "2" }, w = { class: "qr-content" }, f = { border: "1", bordercolor: "#000000" }, v = { key: 0 }, k = { key: 1 }, T = { key: 0 }, V = { key: 0 }, g = { key: 1 }, N = { key: 0, class: "col-1" }, x = { __name: "ship-label-preview", props: { labelType: { type: Number }, showMonomer: { type: Boolean, default: false } }, setup(o) {
  return (B, l) => (e(), s("div", y, [l[14] || (l[14] = t("div", { style: { "font-weight": "bold", "font-size": "16pt", color: "#333", "padding-bottom": "10pt", "text-align": "center" } }, "打包单", -1)), t("table", p, [t("thead", null, [t("tr", null, [t("td", m, [t("div", w, [u(a, { value: "qr", size: 70, margin: 2 })])]), l[0] || (l[0] = t("td", { colspan: 1 }, "项目", -1)), l[1] || (l[1] = t("td", { colspan: 4, style: { "font-weight": "bold", width: "50%" } }, "XXXX项目", -1))]), l[2] || (l[2] = t("tr", null, [t("td", { colspan: 1 }, "包单号"), t("td", { colspan: 4, style: { "font-weight": "bold" } }, "2025-01-01-01")], -1))])]), t("table", f, [t("thead", null, [o.labelType === d(n).ONE.V ? (e(), s("tr", v, l[3] || (l[3] = [t("td", null, "类型", -1), t("td", null, "名称", -1), t("td", null, "单位", -1), t("td", null, "数量", -1)]))) : o.labelType === d(n).TWO.V ? (e(), s("tr", k, [o.showMonomer ? (e(), s("td", T, "单体")) : r("", true), l[4] || (l[4] = t("td", null, "名称", -1)), l[5] || (l[5] = t("td", null, "编号", -1)), t("td", { style: b({ width: o.showMonomer ? "20%" : "25%" }) }, "规格", 4), l[6] || (l[6] = t("td", null, "数量", -1)), l[7] || (l[7] = t("td", null, "核算量", -1))])) : r("", true)]), o.labelType === d(n).ONE.V ? (e(), s("tbody", V, l[8] || (l[8] = [t("tr", null, [t("td", { class: "col-1" }), t("td", { class: "col-1" }), t("td", { class: "col-1" }), t("td", { class: "col-1" })], -1)]))) : o.labelType === d(n).TWO.V ? (e(), s("tbody", g, [t("tr", null, [o.showMonomer ? (e(), s("td", N)) : r("", true), l[9] || (l[9] = t("td", { class: "col-1" }, null, -1)), l[10] || (l[10] = t("td", { class: "col-1" }, null, -1)), l[11] || (l[11] = t("td", { class: "col-1" }, null, -1)), l[12] || (l[12] = t("td", { class: "col-1" }, null, -1)), l[13] || (l[13] = t("td", { class: "col-1" }, null, -1))])])) : r("", true)])]));
} }, O = i(x, [["__scopeId", "data-v-04202e6b"]]);
export {
  O as default
};
