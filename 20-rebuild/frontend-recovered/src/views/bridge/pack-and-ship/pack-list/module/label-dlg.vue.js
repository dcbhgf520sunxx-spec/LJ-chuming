import { computed as b } from "vue";
import { ref as C } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as u } from "vue";
import { createBlock as w } from "vue";
import { withCtx as B } from "vue";
import { createElementVNode as e } from "vue";
import { toDisplayString as a } from "vue";
import { createVNode as f } from "vue";
import D from "qrcode.vue";
import { unref as s } from "vue";
import { createElementBlock as _ } from "vue";
import { createCommentVNode as y } from "vue";
import { Fragment as T } from "vue";
import { renderList as I } from "vue";
import { isRef as E } from "vue";
import { ElPagination as P } from "element-plus";
import { _ as z, u as A, bw as i } from "../../../../../shared/runtime.js";
const q = { style: { "font-weight": "bold", "font-size": "16pt", color: "#333", "padding-bottom": "10pt" } }, M = { border: "1", bordercolor: "#000000" }, O = { rowspan: "2" }, R = { class: "qr-content" }, S = { colspan: "2", style: { "font-weight": "bold" } }, U = { key: 0 }, j = { class: "col-1" }, H = { class: "col-1" }, L = { class: "col-1" }, Q = { class: "col-1" }, X = { __name: "label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => ({}) } }, emits: ["saveSuccess", "update:visible"], setup(g, { emit: h }) {
  const V = h, m = g, { visible: d, handleClose: k } = A({ emit: V, props: m, field: "visible" }), l = b(() => m.labelData.packageInfo || {}), c = C(1), v = b(() => {
    var r;
    const p = [];
    for (var t = 0, n = (r = l.value.list) == null ? void 0 : r.length; t < n; t += 11) p.push(l.value.list.slice(t, Math.min(t + 11, n)));
    return p;
  });
  return (p, t) => {
    const n = P, r = N("common-dialog");
    return u(), w(r, { title: `${l.value.serialNumber}`, top: "5vh", modelValue: s(d), "onUpdate:modelValue": t[1] || (t[1] = (o) => E(d) ? d.value = o : null), width: "600px", "before-close": s(k) }, { default: B(() => [e("div", q, a(l.value.project.name), 1), e("table", M, [e("tr", null, [e("td", O, [e("div", R, [f(D, { value: g.labelData.qrCode, size: 90, margin: 2 }, null, 8, ["value"])])]), t[2] || (t[2] = e("td", { colspan: "3" }, [e("span", { style: { "font-weight": "bold", "font-size": "10pt" } }, "打包单")], -1))]), e("tr", null, [t[3] || (t[3] = e("td", null, "包单号", -1)), e("td", S, a(l.value.serialNumber), 1)]), l.value.productType === s(i).BOX.V || l.value.productType === s(i).MACHINE_PART.V ? (u(), _("tr", U, t[4] || (t[4] = [e("td", null, "编号", -1), e("td", null, "材质", -1), e("td", null, "数量", -1), e("td", null, "重量(kg)", -1)]))) : y("", true), l.value.productType === s(i).BOX.V || l.value.productType === s(i).MACHINE_PART.V ? (u(true), _(T, { key: 1 }, I(v.value[c.value - 1], (o, x) => (u(), _("tr", { key: x }, [e("td", j, a(o.serialNumber), 1), e("td", H, a(o.material), 1), e("td", L, a(o.quantity), 1), e("td", Q, a(o.totalWeight), 1)]))), 128)) : y("", true)]), f(n, { style: { "text-align": "center", "margin-top": "10px" }, size: "small", layout: "prev, pager, next", "page-count": v.value.length, "current-page": c.value, "onUpdate:currentPage": t[0] || (t[0] = (o) => c.value = o) }, null, 8, ["page-count", "current-page"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, $ = z(X, [["__scopeId", "data-v-908a6489"]]);
export {
  $ as default
};
