import { _ as u, i as d } from "../../../../../shared/runtime.js";
import { openBlock as e } from "vue";
import { createElementBlock as t } from "vue";
import { createElementVNode as r } from "vue";
import { Fragment as o } from "vue";
import { renderList as c } from "vue";
import { toDisplayString as n } from "vue";
import { unref as p } from "vue";
const y = { class: "separate-table", cellspacing: "0", cellpadding: "0", border: "1" }, h = { class: "separate-thead" }, k = { style: { width: "120px" } }, f = { key: 0 }, m = { key: 1 }, b = { class: "separate-td-img" }, g = ["src"], L = { key: 1 }, x = { key: 0 }, N = { key: 1 }, B = { __name: "separate-order-table", props: { separateOrderInfo: { type: Array, default: () => [] } }, setup(l) {
  return (O, v) => (e(), t("table", y, [r("tbody", null, [(e(true), t(o, null, c(l.separateOrderInfo, (a, i) => (e(), t(o, { key: i }, [r("tr", h, [r("td", k, n(a.serialNumber), 1), (e(true), t(o, null, c(a.productionLineList, (s, _) => (e(), t("td", { key: _ }, [p(d)(s) ? (e(), t("span", f, n(s.productionLineName) + ">" + n(s.groupName), 1)) : (e(), t("span", m, "\\"))]))), 128))]), r("tr", null, [r("td", b, [a.picturePath ? (e(), t("img", { key: 0, src: a.picturePath, alt: "加载失败" }, null, 8, g)) : (e(), t("span", L, "\\"))]), (e(true), t(o, null, c(a.productionLineList, (s, _) => (e(), t("td", { key: _ }, [p(d)(s) ? (e(), t("span", x, n(s.quantity), 1)) : (e(), t("span", N, "\\"))]))), 128))])], 64))), 128))])]));
} }, S = u(B, [["__scopeId", "data-v-6fa02704"]]);
export {
  S as default
};
