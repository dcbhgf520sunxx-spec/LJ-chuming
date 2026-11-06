import { computed as _ } from "vue";
import { ref as x } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as n } from "vue";
import { createBlock as U } from "vue";
import { withCtx as q } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as h } from "vue";
import A from "qrcode.vue";
import { unref as i } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as v } from "vue";
import { renderList as g } from "vue";
import { isRef as N } from "vue";
import { ElPagination as C } from "element-plus";
import { _ as E, u as z, bi as b } from "../../../../../shared/runtime.js";
const B = { style: { "font-weight": "bold", "font-size": "16pt", color: "#333", "padding-bottom": "10pt" } }, M = { key: 0, border: "1", bordercolor: "#000000" }, X = { rowspan: "2" }, Y = { class: "qr-content" }, S = { colspan: "2", style: { "font-weight": "bold" } }, j = { key: 0 }, P = { key: 1 }, Q = { class: "col-1" }, W = { class: "col-1" }, F = { class: "col-1" }, O = { class: "col-1" }, $ = { class: "col-1" }, G = { class: "col-1" }, H = { class: "col-1" }, J = { class: "col-1" }, K = { key: 1, border: "1", bordercolor: "#000000" }, Z = { rowspan: "2" }, tt = { class: "qr-content" }, et = { colspan: "2", style: { "font-weight": "bold" } }, lt = { class: "col-1" }, st = { class: "col-1" }, ot = { class: "col-1" }, nt = { class: "col-1" }, at = { class: "col-1" }, ut = { class: "col-1" }, rt = { class: "col-1" }, dt = { class: "col-1" }, it = { __name: "label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => ({}) } }, emits: ["saveSuccess", "update:visible"], setup(m, { emit: I }) {
  const L = I, k = m, { visible: y, handleClose: V } = z({ emit: L, props: k, field: "visible" }), o = _(() => k.labelData.packageInfo || {}), p = x(1), f = _(() => {
    const u = [];
    for (var e = 0, r = o.value.list.length; e < r; e += 11) u.push(o.value.list.slice(e, Math.min(e + 11, r)));
    return u;
  }), D = _(() => {
    const u = [];
    for (var e = 0, r = o.value.structureList.length; e < r; e++) u.push(o.value.structureList[e]);
    return u;
  }), w = _(() => {
    const u = [];
    for (var e = 0, r = o.value.auxList.length; e < r; e++) u.push(o.value.auxList[e]);
    return u;
  });
  return (u, e) => {
    const r = C, T = R("common-dialog");
    return n(), U(T, { title: `${o.value.serialNumber}`, top: "5vh", modelValue: i(y), "onUpdate:modelValue": e[1] || (e[1] = (l) => N(y) ? y.value = l : null), width: "600px", "before-close": i(V) }, { default: q(() => [t("div", B, s(o.value.project.name), 1), o.value.productType !== 10 ? (n(), a("table", M, [t("tr", null, [t("td", X, [t("div", Y, [h(A, { value: m.labelData.qrCode, size: 90, margin: 2 }, null, 8, ["value"])])]), e[2] || (e[2] = t("td", { colspan: "3" }, [t("span", { style: { "font-weight": "bold", "font-size": "10pt" } }, "打包单")], -1))]), t("tr", null, [e[3] || (e[3] = t("td", null, "包单号", -1)), t("td", S, s(o.value.serialNumber), 1)]), o.value.productType !== i(b).AUXILIARY_MATERIAL.V ? (n(), a("tr", j, e[4] || (e[4] = [t("td", null, "编号", -1), t("td", null, "材质", -1), t("td", null, "数量", -1), t("td", null, "重量(kg)", -1)]))) : c("", true), o.value.productType === i(b).AUXILIARY_MATERIAL.V ? (n(), a("tr", P, e[5] || (e[5] = [t("td", null, "名称", -1), t("td", null, "单位", -1), t("td", null, "规格", -1), t("td", null, "数量", -1)]))) : c("", true), o.value.productType !== i(b).AUXILIARY_MATERIAL.V ? (n(true), a(v, { key: 2 }, g(f.value[p.value - 1], (l, d) => (n(), a("tr", { key: d }, [t("td", Q, s(l.serialNumber), 1), t("td", W, s(l.material), 1), t("td", F, s(l.quantity), 1), t("td", O, s(l.totalWeight), 1)]))), 128)) : c("", true), o.value.productType === i(b).AUXILIARY_MATERIAL.V ? (n(true), a(v, { key: 3 }, g(f.value[p.value - 1], (l, d) => (n(), a("tr", { key: d }, [t("td", $, s(l.name), 1), t("td", G, s(l.measureUnit), 1), t("td", H, s(l.specification), 1), t("td", J, s(l.quantity), 1)]))), 128)) : c("", true)])) : c("", true), o.value.productType === 10 ? (n(), a("table", K, [t("tr", null, [t("td", Z, [t("div", tt, [h(A, { value: m.labelData.qrCode, size: 90, margin: 2 }, null, 8, ["value"])])]), e[6] || (e[6] = t("td", { colspan: "3" }, [t("span", { style: { "font-weight": "bold", "font-size": "10pt" } }, "打包单")], -1))]), t("tr", null, [e[7] || (e[7] = t("td", null, "包单号", -1)), t("td", et, s(o.value.serialNumber), 1)]), e[8] || (e[8] = t("tr", null, [t("td", { colspan: "4", style: { "font-weight": "bold" } }, "结构")], -1)), e[9] || (e[9] = t("tr", null, [t("td", null, "编号"), t("td", null, "材质"), t("td", null, "数量"), t("td", null, "重量(kg)")], -1)), (n(true), a(v, null, g(D.value, (l, d) => (n(), a("tr", { key: d }, [t("td", lt, s(l.serialNumber), 1), t("td", st, s(l.material), 1), t("td", ot, s(l.quantity), 1), t("td", nt, s(l.totalWeight), 1)]))), 128)), e[10] || (e[10] = t("tr", null, [t("td", { colspan: "4", style: { "font-weight": "bold" } }, "辅材")], -1)), e[11] || (e[11] = t("tr", null, [t("td", null, "名称"), t("td", null, "单位"), t("td", null, "规格"), t("td", null, "数量")], -1)), (n(true), a(v, null, g(w.value, (l, d) => (n(), a("tr", { key: d }, [t("td", at, s(l.name), 1), t("td", ut, s(l.measureUnit), 1), t("td", rt, s(l.specification), 1), t("td", dt, s(l.quantity), 1)]))), 128))])) : c("", true), h(r, { style: { "text-align": "center", "margin-top": "10px" }, small: "", layout: "prev, pager, next", "page-count": f.value.length, "current-page": p.value, "onUpdate:currentPage": e[0] || (e[0] = (l) => p.value = l) }, null, 8, ["page-count", "current-page"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, _t = E(it, [["__scopeId", "data-v-3087968d"]]);
export {
  _t as default
};
