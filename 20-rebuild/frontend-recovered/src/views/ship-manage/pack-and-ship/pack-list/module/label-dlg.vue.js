import { computed as h } from "vue";
import { ref as x } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as l } from "vue";
import { createBlock as A } from "vue";
import { withCtx as D } from "vue";
import { createElementVNode as t } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as T } from "vue";
import V from "qrcode.vue";
import { toDisplayString as n } from "vue";
import { unref as d } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as g } from "vue";
import { renderList as m } from "vue";
import { createTextVNode as q } from "vue";
import { isRef as B } from "vue";
import { ElPagination as S } from "element-plus";
import { _ as O, u as W, bi as c } from "../../../../../shared/runtime.js";
const X = { key: 0, border: "1", bordercolor: "#000000" }, Y = { rowspan: "2" }, z = { class: "qr-content" }, j = { colspan: 4, style: { "font-weight": "bold" } }, P = ["colspan"], Q = ["colspan"], F = { key: 0 }, $ = { key: 0 }, G = { key: 1 }, H = { key: 1 }, J = { key: 0 }, K = { key: 1 }, Z = { key: 2 }, tt = { key: 3 }, et = { key: 2 }, ot = { key: 0, class: "col-1" }, lt = { class: "col-1", style: { position: "relative", overflow: "hidden" } }, st = { class: "col-1" }, nt = { class: "col-1" }, at = { class: "col-1" }, ut = { key: 1, class: "col-1" }, dt = { class: "col-1" }, rt = { key: 0, class: "col-1" }, ct = { key: 1, class: "col-1" }, it = { class: "col-1" }, pt = { key: 2, class: "col-1" }, _t = { key: 3, class: "col-1" }, yt = { class: "col-1" }, vt = { class: "col-1" }, ht = { class: "col-1" }, gt = { class: "col-1" }, mt = { class: "col-1" }, bt = { key: 1, border: "1", bordercolor: "#000000" }, ft = { rowspan: "2" }, kt = { class: "qr-content" }, Tt = { colspan: "2", style: { "font-weight": "bold" } }, wt = { class: "col-1" }, Lt = { class: "col-1" }, Nt = { class: "col-1" }, At = { class: "col-1" }, Vt = { key: 0 }, Et = { key: 1 }, It = { key: 2 }, Rt = { key: 3 }, Ut = { class: "col-1" }, Ct = { class: "col-1" }, Mt = { class: "col-1" }, xt = { class: "col-1" }, Dt = { __name: "label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => ({}) }, unitType: { type: Number, default: 1 }, showMaterial: { type: Boolean, default: true }, showWidth: { type: Boolean, default: true }, showName: { type: Boolean, default: true }, showMonomer: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:visible"], setup(f, { emit: E }) {
  const I = E, u = f, { visible: k, handleClose: R } = W({ emit: I, props: u, field: "visible" }), a = h(() => u.labelData.packageInfo || {}), w = h(() => a.value.showMonomer === true || u.showMonomer === true), v = x(1), b = h(() => {
    var p;
    const i = [];
    for (var e = 0, y = (p = a.value.list) == null ? void 0 : p.length; e < y; e += 11) i.push(a.value.list.slice(e, Math.min(e + 11, y)));
    return console.log(a.value), console.log(i), i;
  }), U = h(() => {
    var p;
    const i = [];
    for (var e = 0, y = (p = a.value.structureList) == null ? void 0 : p.length; e < y; e++) i.push(a.value.structureList[e]);
    return i;
  }), C = h(() => {
    var p;
    const i = [];
    for (var e = 0, y = (p = a.value.auxList) == null ? void 0 : p.length; e < y; e++) i.push(a.value.auxList[e]);
    return i;
  });
  return (i, e) => {
    const y = N("table-cell-tag"), p = S, M = N("common-dialog");
    return l(), A(M, { title: `${a.value.serialNumber}`, top: "5vh", modelValue: d(k), "onUpdate:modelValue": e[1] || (e[1] = (o) => B(k) ? k.value = o : null), width: "600px", "before-close": d(R) }, { default: D(() => [e[17] || (e[17] = t("div", { style: { "font-weight": "bold", "font-size": "16pt", color: "#333", "padding-bottom": "10pt", "text-align": "center" } }, "打包单", -1)), a.value.productType !== 10 ? (l(), s("table", X, [t("tr", null, [t("td", Y, [t("div", z, [T(V, { value: f.labelData.qrCode, size: 90, margin: 2 }, null, 8, ["value"])])]), e[2] || (e[2] = t("td", { colspan: 1 }, "项目", -1)), t("td", j, n(a.value.project.name), 1)]), t("tr", null, [t("td", { colspan: a.value.productType !== d(c).AUXILIARY_MATERIAL.V && a.value.productType !== d(c).ENCLOSURE.V ? 2 : 1 }, " 包单号 ", 8, P), t("td", { colspan: a.value.productType === d(c).ENCLOSURE.V ? 3 : 2, style: { "font-weight": "bold" } }, n(a.value.serialNumber), 9, Q)]), a.value.productType !== d(c).AUXILIARY_MATERIAL.V && a.value.productType !== d(c).ENCLOSURE.V ? (l(), s("tr", F, [w.value ? (l(), s("td", $, "单体")) : r("", true), e[3] || (e[3] = t("td", null, "名称", -1)), e[4] || (e[4] = t("td", null, "编号", -1)), e[5] || (e[5] = t("td", null, "规格", -1)), e[6] || (e[6] = t("td", null, "数量", -1)), u.showWidth ? (l(), s("td", G, "重量(kg)")) : r("", true)])) : r("", true), a.value.productType === d(c).AUXILIARY_MATERIAL.V ? (l(), s("tr", H, [e[7] || (e[7] = t("td", null, "名称", -1)), u.unitType === 1 ? (l(), s("td", J, "核算单位")) : (l(), s("td", K, "计量单位")), e[8] || (e[8] = t("td", null, "规格", -1)), u.unitType === 1 ? (l(), s("td", Z, "核算量")) : (l(), s("td", tt, "数量"))])) : r("", true), a.value.productType === d(c).ENCLOSURE.V ? (l(), s("tr", et, e[9] || (e[9] = [t("td", null, "编号", -1), t("td", null, "板型", -1), t("td", null, "单长(mm)", -1), t("td", null, "单面积(mm²)", -1), t("td", null, "数量", -1)]))) : r("", true), a.value.productType !== d(c).AUXILIARY_MATERIAL.V && a.value.productType !== d(c).ENCLOSURE.V ? (l(true), s(g, { key: 3 }, m(b.value[v.value - 1], (o, _) => {
      var L;
      return l(), s("tr", { key: _ }, [w.value ? (l(), s("td", ot, n(o.monomerName || ((L = o.monomer) == null ? void 0 : L.name) || a.value.monomerName || "-"), 1)) : r("", true), t("td", lt, [o.warehouseType === 1 ? (l(), A(y, { key: 0, name: "回厂返修", color: "#e64242", offset: 0 })) : r("", true), q(" " + n(u.showName ? o.name : ""), 1)]), t("td", st, n(o.serialNumber), 1), t("td", nt, n(u.showMaterial ? o.specification : ""), 1), t("td", at, n(o.quantity), 1), u.showWidth ? (l(), s("td", ut, n(u.showWidth ? o.totalWeight : ""), 1)) : r("", true)]);
    }), 128)) : r("", true), a.value.productType === d(c).AUXILIARY_MATERIAL.V ? (l(true), s(g, { key: 4 }, m(b.value[v.value - 1], (o, _) => (l(), s("tr", { key: _ }, [t("td", dt, n(u.showName ? o.name : ""), 1), u.unitType === 1 ? (l(), s("td", rt, n(o.accountingUnit), 1)) : (l(), s("td", ct, n(o.measureUnit), 1)), t("td", it, n(o.specification), 1), u.unitType === 1 ? (l(), s("td", pt, n(o.packageMete), 1)) : (l(), s("td", _t, n(o.quantity), 1))]))), 128)) : r("", true), a.value.productType === d(c).ENCLOSURE.V ? (l(true), s(g, { key: 5 }, m(b.value[v.value - 1], (o, _) => (l(), s("tr", { key: _ }, [t("td", yt, n(o.serialNumber), 1), t("td", vt, n(o.plate), 1), t("td", ht, n(o.length), 1), t("td", gt, n(o.surfaceArea), 1), t("td", mt, n(o.quantity), 1)]))), 128)) : r("", true)])) : r("", true), a.value.productType === 10 ? (l(), s("table", bt, [t("tr", null, [t("td", ft, [t("div", kt, [T(V, { value: f.labelData.qrCode, size: 90, margin: 2 }, null, 8, ["value"])])]), e[10] || (e[10] = t("td", { colspan: "3" }, [t("span", { style: { "font-weight": "bold", "font-size": "10pt" } }, "打包单")], -1))]), t("tr", null, [e[11] || (e[11] = t("td", null, "包单号", -1)), t("td", Tt, n(a.value.serialNumber), 1)]), e[14] || (e[14] = t("tr", null, [t("td", { colspan: "4", style: { "font-weight": "bold" } }, "结构")], -1)), e[15] || (e[15] = t("tr", null, [t("td", null, "编号"), t("td", null, "材质"), t("td", null, "数量"), t("td", null, "重量(kg)")], -1)), (l(true), s(g, null, m(U.value, (o, _) => (l(), s("tr", { key: _ }, [t("td", wt, n(o.serialNumber), 1), t("td", Lt, n(o.material), 1), t("td", Nt, n(o.quantity), 1), t("td", At, n(o.totalWeight), 1)]))), 128)), e[16] || (e[16] = t("tr", null, [t("td", { colspan: "4", style: { "font-weight": "bold" } }, "辅材")], -1)), t("tr", null, [e[12] || (e[12] = t("td", null, "名称", -1)), u.unitType === 1 ? (l(), s("td", Vt, "核算单位")) : (l(), s("td", Et, "计量单位")), e[13] || (e[13] = t("td", null, "规格", -1)), u.unitType === 1 ? (l(), s("td", It, "核算量")) : (l(), s("td", Rt, "数量"))]), (l(true), s(g, null, m(C.value, (o, _) => (l(), s("tr", { key: _ }, [t("td", Ut, n(o.name), 1), t("td", Ct, n(o.measureUnit), 1), t("td", Mt, n(o.specification), 1), t("td", xt, n(o.quantity), 1)]))), 128))])) : r("", true), T(p, { style: { "text-align": "center", "margin-top": "10px" }, small: "", layout: "prev, pager, next", "page-count": b.value.length, "current-page": v.value, "onUpdate:currentPage": e[0] || (e[0] = (o) => v.value = o) }, null, 8, ["page-count", "current-page"])]), _: 1, __: [17] }, 8, ["title", "modelValue", "before-close"]);
  };
} }, St = O(Dt, [["__scopeId", "data-v-c228aa5b"]]);
export {
  St as default
};
