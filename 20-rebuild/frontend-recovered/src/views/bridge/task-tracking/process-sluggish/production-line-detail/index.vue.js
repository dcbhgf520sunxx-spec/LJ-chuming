import { ref as L } from "vue";
import { watch as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as t } from "vue";
import { createElementVNode as o } from "vue";
import { Fragment as p } from "vue";
import { renderList as _ } from "vue";
import { unref as c } from "vue";
import { toDisplayString as l } from "vue";
import { createVNode as y } from "vue";
import { createCommentVNode as f } from "vue";
import { normalizeStyle as V } from "vue";
import { ElDivider as b } from "element-plus";
import { _ as B, F as h, o as E, c as g, D as k } from "../../../../../shared/runtime.js";
import { a as M } from "../../../../../modules/process-sluggish-6aee505d.js";
const N = { style: "display: flex; flex-direction: column; " }, O = { key: 0 }, A = { class: "process-detail", style: { display: "flex", "flex-wrap": "wrap" } }, P = ["onClick"], $ = { class: "process-way" }, q = { class: "process-data" }, H = { key: 0 }, W = { class: "process-detail", style: { display: "flex", "flex-wrap": "wrap" } }, z = ["onClick"], F = { class: "process-way" }, j = { class: "process-data" }, R = { key: 0 }, U = { class: "process-detail", style: { display: "flex", "flex-wrap": "wrap" } }, X = ["onClick"], G = { class: "process-way" }, J = { class: "process-data" }, K = { __name: "index", props: { workShopId: { type: Number } }, emits: ["change"], setup(T, { emit: m }) {
  const d = L([]), C = m, v = T;
  S(() => v.workShopId, (u) => {
    D();
  });
  async function D() {
    d.value = [];
    try {
      (await M({ workShopId: v.workShopId })).map((n) => {
        var i, e;
        n.uuid = n.productType + "_" + ((i = n.productionLine) == null ? void 0 : i.id), d.value.findIndex((s) => s.uuid === n.uuid) > -1 ? d.value.find((r) => r.uuid === n.uuid).arr.push(n) : d.value.push({ uuid: n.uuid, productType: n.productType, name: h.VL[n.productType] + ">" + ((e = n.productionLine) == null ? void 0 : e.name), arr: [n] });
      }), console.log(d.value, "data");
    } catch (u) {
      console.log("获取车间的所有工序失败", u);
    }
  }
  const { maxHeight: I } = E({ extraBox: [".head-container"], paginate: true });
  function x(u) {
    C("change", u);
  }
  return (u, n) => {
    const i = b;
    return a(), t(p, null, [n[0] || (n[0] = o("div", { class: "head-container", style: { display: "flex", "justify-content": "flex-end" } }, [o("span", { style: { "font-size": "14px" } }, "单位：件|吨")], -1)), o("div", { class: "app-container", style: V(`height: ${c(I) - 40}px; overflow-y: auto`) }, [o("div", N, [(a(true), t(p, null, _(d.value, (e) => (a(), t("div", { class: "item-side", key: e }, [e.productType === c(h).MACHINE_PART.V ? (a(), t("div", O, [o("span", null, l(e.name), 1), y(i, { style: { margin: "0 0 10px" } }), o("div", A, [(a(true), t(p, null, _(e == null ? void 0 : e.arr, (s) => {
      var r;
      return a(), t("div", { class: "show-detail", key: s, style: { "background-color": "#e6a23c", margin: "0 15px 10px 0" }, onClick: (w) => x(s) }, [o("span", $, l((r = s.process) == null ? void 0 : r.name), 1), y(i, { style: { margin: "0" } }), o("span", q, l(s.quantity) + "/" + l(c(g)(s.mete, "kg", "t", c(k).COM_WT__T)), 1)], 8, P);
    }), 128))])])) : f("", true)]))), 128)), (a(true), t(p, null, _(d.value, (e) => (a(), t("div", { class: "item-side", key: e }, [e.productType === c(h).CELL.V ? (a(), t("div", H, [o("span", null, l(e.name), 1), y(i, { style: { margin: "0 0 10px" } }), o("div", W, [(a(true), t(p, null, _(e == null ? void 0 : e.arr, (s) => {
      var r;
      return a(), t("div", { class: "show-detail", key: s, style: { "background-color": "#409eff", margin: "0 15px 10px 0" }, onClick: (w) => x(s) }, [o("span", F, l((r = s.process) == null ? void 0 : r.name), 1), y(i, { style: { margin: "0" } }), o("span", j, l(s.quantity) + "/" + l(c(g)(s.mete, "kg", "t", c(k).COM_WT__T)), 1)], 8, z);
    }), 128))])])) : f("", true)]))), 128)), (a(true), t(p, null, _(d.value, (e) => (a(), t("div", { class: "item-side", key: e }, [e.productType === c(h).BOX.V ? (a(), t("div", R, [o("span", null, l(e.name), 1), y(i, { style: { margin: "0 0 10px" } }), o("div", U, [(a(true), t(p, null, _(e == null ? void 0 : e.arr, (s) => {
      var r;
      return a(), t("div", { class: "show-detail", key: s, style: { "background-color": "#67c23a", margin: "0 15px 10px 0" }, onClick: (w) => x(s) }, [o("span", G, l((r = s.process) == null ? void 0 : r.name), 1), y(i, { style: { margin: "0" } }), o("span", J, l(s.quantity) + "/" + l(c(g)(s.mete, "kg", "t", c(k).COM_WT__T)), 1)], 8, X);
    }), 128))])])) : f("", true)]))), 128))])], 4)], 64);
  };
} }, ee = B(K, [["__scopeId", "data-v-d2118aaa"]]);
export {
  ee as default
};
