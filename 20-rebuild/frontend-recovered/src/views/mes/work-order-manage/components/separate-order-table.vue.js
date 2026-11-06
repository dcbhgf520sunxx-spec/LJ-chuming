import { _ as u, i as p } from "../../../../shared/runtime.js";
import { openBlock as e } from "vue";
import { createElementBlock as t } from "vue";
import { createElementVNode as a } from "vue";
import { Fragment as o } from "vue";
import { renderList as c } from "vue";
import { toDisplayString as n } from "vue";
import { unref as _ } from "vue";
import { normalizeStyle as y } from "vue";
const h = { class: "separate-table", cellspacing: "0", cellpadding: "0", border: "1" }, k = { class: "separate-thead" }, f = { style: { width: "120px" } }, b = { key: 0 }, m = { key: 1 }, g = { class: "separate-td-img" }, v = ["src"], L = { key: 1 }, O = { key: 0, style: { position: "relative" } }, x = { key: 0 }, I = { key: 1 }, N = { key: 1 }, B = { __name: "separate-order-table", props: { separateOrderInfo: { type: Array, default: () => [] } }, setup(d) {
  return console.log(d.separateOrderInfo, "separateOrderInfo"), (E, S) => (e(), t("table", h, [a("tbody", null, [(e(true), t(o, null, c(d.separateOrderInfo, (r, i) => (e(), t(o, { key: i }, [a("tr", k, [a("td", f, n(r.serialNumber), 1), (e(true), t(o, null, c(r.productionLineList, (s, l) => (e(), t("td", { key: l }, [_(p)(s) ? (e(), t("div", b, [a("span", null, n(s.productionLineName) + ">" + n(s.groupName), 1)])) : (e(), t("span", m, "\\"))]))), 128))]), a("tr", null, [a("td", g, [r.picturePath ? (e(), t("img", { key: 0, src: r.picturePath, alt: "加载失败" }, null, 8, v)) : (e(), t("span", L, "\\"))]), (e(true), t(o, null, c(r.productionLineList, (s, l) => (e(), t("td", { key: l }, [_(p)(s) ? (e(), t("div", O, [a("span", null, n(s.quantity), 1), a("div", { class: "filter-class", style: y(s.boolDrillEnum ? "background: #40ed8d" : "background: #f56c6c") }, [s.boolDrillEnum ? (e(), t("span", I, "钻孔")) : (e(), t("span", x, "总装"))], 4)])) : (e(), t("span", N, "\\"))]))), 128))])], 64))), 128))])]));
} }, q = u(B, [["__scopeId", "data-v-724af96e"]]);
export {
  q as default
};
