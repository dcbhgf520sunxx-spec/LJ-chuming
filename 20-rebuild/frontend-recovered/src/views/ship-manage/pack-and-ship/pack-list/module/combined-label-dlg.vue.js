import { computed as k } from "vue";
import { ref as L } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as s } from "vue";
import { createBlock as M } from "vue";
import { withCtx as I } from "vue";
import { createVNode as h } from "vue";
import { unref as u } from "vue";
import { createElementVNode as t } from "vue";
import O from "qrcode.vue";
import { toDisplayString as l } from "vue";
import { createElementBlock as a } from "vue";
import { createCommentVNode as r } from "vue";
import { normalizeStyle as R } from "vue";
import { Fragment as x } from "vue";
import { renderList as A } from "vue";
import { isRef as S } from "vue";
import { ElPagination as j } from "element-plus";
import { _ as Q, u as z, bj as m, bi as V, uh as q } from "../../../../../shared/runtime.js";
const H = { class: "table-1", border: "1", bordercolor: "#000000" }, P = { rowspan: "2" }, W = { class: "qr-content" }, X = { colspan: 4, style: { "font-weight": "bold", width: "50%" } }, Y = { colspan: 4, style: { "font-weight": "bold" } }, F = { border: "1", bordercolor: "#000000" }, $ = { key: 0 }, G = { key: 0 }, J = { key: 1 }, K = { key: 0 }, Z = { key: 0 }, ee = { key: 0, class: "col-1" }, te = { class: "col-1" }, oe = { class: "col-1" }, le = { class: "col-1" }, se = { class: "col-1" }, ae = { key: 1 }, ne = { key: 0, class: "col-1" }, ue = { class: "col-1" }, de = { class: "col-1" }, re = { class: "col-1" }, ie = { class: "col-1" }, ce = { class: "col-1" }, pe = { __name: "combined-label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => ({}) } }, emits: ["saveSuccess", "update:visible"], setup(N, { emit: E }) {
  const U = E, w = N, { visible: y, handleClose: B } = z({ emit: U, props: w, field: "visible", showHook: D }), n = k(() => w.labelData.packageInfo || {}), d = L(), i = k(() => n.value.showMonomer === true), c = L(1), g = k(() => {
    var b;
    const _ = [];
    for (var e = 0, v = (b = n.value.list) == null ? void 0 : b.length; e < v; e += 11) _.push(n.value.list.slice(e, Math.min(e + 11, v)));
    return console.log(n.value), console.log(_), _;
  });
  function D() {
    c.value = 1, d.value = n.value.labelType;
  }
  return (_, e) => {
    const v = T("common-radio-button"), b = j, C = T("common-dialog");
    return s(), M(C, { title: `${n.value.serialNumber}`, top: "5vh", modelValue: u(y), "onUpdate:modelValue": e[2] || (e[2] = (o) => S(y) ? y.value = o : null), width: "600px", "before-close": u(B) }, { titleAfter: I(() => [h(v, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => d.value = o), options: u(m).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), default: I(() => [e[12] || (e[12] = t("div", { style: { "font-weight": "bold", "font-size": "16pt", color: "#333", "padding-bottom": "10pt", "text-align": "center" } }, "打包单", -1)), t("table", H, [t("thead", null, [t("tr", null, [t("td", P, [t("div", W, [h(O, { value: N.labelData.qrCode, size: 90, margin: 2 }, null, 8, ["value"])])]), e[3] || (e[3] = t("td", { colspan: 1 }, "项目", -1)), t("td", X, l(n.value.project.name), 1)]), t("tr", null, [e[4] || (e[4] = t("td", { colspan: 1 }, "包单号", -1)), t("td", Y, l(n.value.serialNumber), 1)])])]), t("table", F, [t("thead", null, [d.value === u(m).ONE.V ? (s(), a("tr", $, [i.value ? (s(), a("td", G, "单体")) : r("", true), e[5] || (e[5] = t("td", null, "类型", -1)), t("td", null, l(n.value.productType === u(V).AUXILIARY_MATERIAL.V ? "名称" : "编号"), 1), e[6] || (e[6] = t("td", null, "单位", -1)), e[7] || (e[7] = t("td", null, "数量", -1))])) : d.value === u(m).TWO.V ? (s(), a("tr", J, [i.value ? (s(), a("td", K, "单体")) : r("", true), e[8] || (e[8] = t("td", null, "名称", -1)), e[9] || (e[9] = t("td", null, "编号", -1)), t("td", { style: R({ width: i.value ? "20%" : "25%" }) }, "规格", 4), e[10] || (e[10] = t("td", { style: { width: "15%" } }, "数量", -1)), e[11] || (e[11] = t("td", null, "核算量", -1))])) : r("", true)]), d.value === u(m).ONE.V ? (s(), a("tbody", Z, [(s(true), a(x, null, A(g.value[c.value - 1], (o, f) => {
      var p;
      return s(), a("tr", { key: f }, [i.value ? (s(), a("td", ee, l(o.monomerName || ((p = o.monomer) == null ? void 0 : p.name) || n.value.monomerName || "-"), 1)) : r("", true), t("td", te, l(o.productType ? u(q)(u(V), o.productType, "SL") : ""), 1), t("td", oe, l(o.productType === u(V).AUXILIARY_MATERIAL.V ? o.name : o.serialNumber), 1), t("td", le, l(o.measureUnit), 1), t("td", se, l(o.packageQuantity), 1)]);
    }), 128))])) : d.value === u(m).TWO.V ? (s(), a("tbody", ae, [(s(true), a(x, null, A(g.value[c.value - 1], (o, f) => {
      var p;
      return s(), a("tr", { key: f }, [i.value ? (s(), a("td", ne, l(o.monomerName || ((p = o.monomer) == null ? void 0 : p.name) || n.value.monomerName || "-"), 1)) : r("", true), t("td", ue, l(o.name), 1), t("td", de, l(o.serialNumber), 1), t("td", re, l(o.specification), 1), t("td", ie, l(o.packageQuantity), 1), t("td", ce, l(o.mete) + l(o.accountingUnit), 1)]);
    }), 128))])) : r("", true)]), h(b, { style: { "justify-content": "center", "margin-top": "10px" }, small: "", layout: "prev, pager, next", "page-count": g.value.length, "current-page": c.value, "onUpdate:currentPage": e[1] || (e[1] = (o) => c.value = o) }, null, 8, ["page-count", "current-page"])]), _: 1, __: [12] }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ve = Q(pe, [["__scopeId", "data-v-a9e29c9f"]]);
export {
  ve as default
};
