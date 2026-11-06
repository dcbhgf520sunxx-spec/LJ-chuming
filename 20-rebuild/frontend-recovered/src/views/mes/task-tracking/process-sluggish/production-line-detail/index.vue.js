import { ref as V } from "vue";
import { watch as I } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as a } from "vue";
import { createElementVNode as o } from "vue";
import { Fragment as u } from "vue";
import { renderList as y } from "vue";
import { unref as l } from "vue";
import { toDisplayString as c } from "vue";
import { createVNode as _ } from "vue";
import { createCommentVNode as k } from "vue";
import { normalizeStyle as b } from "vue";
import { ElDivider as q } from "element-plus";
import { _ as A, a3 as x, o as D, bo as v, c as h } from "../../../../../shared/runtime.js";
import { a as W } from "../../../../../modules/process-sluggish-cb943bdd.js";
const L = { style: "display: flex; flex-direction: column; " }, m = { key: 0 }, B = { class: "process-detail", style: { display: "flex", "flex-wrap": "wrap" } }, G = ["onClick"], $ = { class: "process-way" }, H = { class: "process-data" }, M = { key: 0 }, P = { class: "process-detail", style: { display: "flex", "flex-wrap": "wrap" } }, z = ["onClick"], F = { class: "process-way" }, R = { class: "process-data" }, j = { key: 0 }, O = { class: "process-detail", style: { display: "flex", "flex-wrap": "wrap" } }, U = ["onClick"], J = { class: "process-way" }, K = { class: "process-data" }, Q = { __name: "index", props: { workShopId: { type: Number }, weightStatus: { type: Number } }, emits: ["change"], setup(g, { emit: S }) {
  const d = V([]), N = S, w = g;
  I(() => w.workShopId, (p) => {
    C();
  });
  async function C() {
    d.value = [];
    try {
      (await W({ workShopId: w.workShopId })).map((n) => {
        var i, t;
        n.uuid = n.productType + "_" + ((i = n.productionLine) == null ? void 0 : i.id), d.value.findIndex((e) => e.uuid === n.uuid) > -1 ? d.value.find((r) => r.uuid === n.uuid).arr.push(n) : d.value.push({ uuid: n.uuid, productType: n.productType, name: x.VL[n.productType] + ">" + ((t = n.productionLine) == null ? void 0 : t.name), arr: [n] });
      }), console.log(d.value, "data");
    } catch (p) {
      console.log("获取车间的所有工序失败", p);
    }
  }
  const { maxHeight: E } = D({ extraBox: [".head-container"], paginate: true });
  function f(p) {
    N("change", p);
  }
  return (p, n) => {
    const i = q;
    return s(), a(u, null, [n[0] || (n[0] = o("div", { class: "head-container", style: { display: "flex", "justify-content": "flex-end" } }, [o("span", { style: { "font-size": "14px" } }, "单位：件|吨")], -1)), o("div", { class: "app-container", style: b(`height: ${l(E) - 40}px; overflow-y: auto`) }, [o("div", L, [(s(true), a(u, null, y(d.value, (t) => (s(), a("div", { class: "item-side", key: t }, [t.productType === l(x).MACHINE_PART.V ? (s(), a("div", m, [o("span", null, c(t.name), 1), _(i, { style: { margin: "0 0 10px" } }), o("div", B, [(s(true), a(u, null, y(t == null ? void 0 : t.arr, (e) => {
      var r;
      return s(), a("div", { class: "show-detail", key: e, style: { "background-color": "#e6a23c", margin: "0 15px 10px 0" }, onClick: (T) => f(e) }, [o("span", $, c((r = e.process) == null ? void 0 : r.name), 1), _(i, { style: { margin: "0" } }), o("span", H, c(g.weightStatus === l(v).NET.V ? e.quantity + "/" + l(h)(e.totalNetWeight, "kg", "t", 2) : e.quantity + "/" + l(h)(e.totalGrossWeight, "kg", "t", 2)), 1)], 8, G);
    }), 128))])])) : k("", true)]))), 128)), (s(true), a(u, null, y(d.value, (t) => (s(), a("div", { class: "item-side", key: t }, [t.productType === l(x).ASSEMBLE.V ? (s(), a("div", M, [o("span", null, c(t.name), 1), _(i, { style: { margin: "0 0 10px" } }), o("div", P, [(s(true), a(u, null, y(t == null ? void 0 : t.arr, (e) => {
      var r;
      return s(), a("div", { class: "show-detail", key: e, style: { "background-color": "#409eff", margin: "0 15px 10px 0" }, onClick: (T) => f(e) }, [o("span", F, c((r = e.process) == null ? void 0 : r.name), 1), _(i, { style: { margin: "0" } }), o("span", R, c(g.weightStatus === l(v).NET.V ? e.quantity + "/" + l(h)(e.totalNetWeight, "kg", "t", 2) : e.totalGrossWeight ? e.quantity + "/" + l(h)(e.totalGrossWeight, "kg", "t", 2) : e.quantity + "/-"), 1)], 8, z);
    }), 128))])])) : k("", true)]))), 128)), (s(true), a(u, null, y(d.value, (t) => (s(), a("div", { class: "item-side", key: t }, [t.productType === l(x).ARTIFACT.V ? (s(), a("div", j, [o("span", null, c(t.name), 1), _(i, { style: { margin: "0 0 10px" } }), o("div", O, [(s(true), a(u, null, y(t == null ? void 0 : t.arr, (e) => {
      var r;
      return s(), a("div", { class: "show-detail", key: e, style: { "background-color": "#67c23a", margin: "0 15px 10px 0" }, onClick: (T) => f(e) }, [o("span", J, c((r = e.process) == null ? void 0 : r.name), 1), _(i, { style: { margin: "0" } }), o("span", K, c(g.weightStatus === l(v).NET.V ? e.quantity + "/" + l(h)(e.totalNetWeight, "kg", "t", 2) : e.quantity + "/" + l(h)(e.totalGrossWeight, "kg", "t", 2)), 1)], 8, U);
    }), 128))])])) : k("", true)]))), 128))])], 4)], 64);
  };
} }, ee = A(Q, [["__scopeId", "data-v-5e321c52"]]);
export {
  ee as default
};
