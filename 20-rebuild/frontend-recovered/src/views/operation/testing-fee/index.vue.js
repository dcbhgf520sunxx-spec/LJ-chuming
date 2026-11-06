import { ref as d } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as i } from "vue";
import { unref as n } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as j } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as f } from "vue";
import { Fragment as z } from "vue";
import { renderList as H } from "vue";
import { ElDatePicker as M } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { l as A, t as q, p as G, g8 as K, G as V, o as $, bb as J, L as O, z as Q, bV as m } from "../../../shared/runtime.js";
import { t as T } from "../../../modules/operation-4e9312fe.js";
function W(y) {
  return A({ url: "/api/contract/testing-fee/findAll", method: "get", params: y });
}
function X(y) {
  return A({ url: "/api/contract/testing-fee/exportExcel", method: "get", params: y, responseType: "blob" });
}
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = { style: { float: "left" } }, ae = { style: { float: "right" } }, se = { __name: "index", setup(y) {
  const { decimalPrecision: g } = q(), _ = d(G(/* @__PURE__ */ new Date(), "{y}")), h = d(), x = d([]), D = K(["testing_fee_type"]), b = d([]), Y = d();
  w();
  async function w() {
    if (!V(T.get)) return false;
    try {
      b.value = [];
      const { content: r } = await W({ year: _.value, projectId: h.value });
      r.map((e) => {
        var p, t;
        e.totalAmount = 0;
        for (const s in e.checkType) e["fee_" + s] = e.checkType[s], e.totalAmount += e.checkType[s], b.value.findIndex((o) => o.key === "fee_" + s) < 0 && b.value.push({ key: "fee_" + s, name: (t = (p = D.value) == null ? void 0 : p.testing_fee_type) == null ? void 0 : t.find((o) => o.id === Number(s)).label });
        return e.averageTestingFee = e.capacity ? e.totalAmount / e.capacity : e.totalAmount, e;
      }), x.value = r || [];
    } catch (r) {
      console.log("检测费用", r);
    }
  }
  function C(r) {
    return r > /* @__PURE__ */ new Date();
  }
  function E(r) {
    const { columns: e, data: p } = r, t = [];
    return e.forEach((o, a) => {
      if (a === 0) {
        t[a] = "合计";
        return;
      }
      if (o.property !== "project" && o.property !== "averageTestingFee") {
        const v = p.map((u) => Number(u[o.property]));
        v.every((u) => isNaN(u)) || (t[a] = v.reduce((u, F) => {
          const P = Number(F);
          return isNaN(P) ? u : u + F;
        }, 0));
      }
      o.property === "averageTestingFee" && (t[a] = t[2] ? t[6] / t[2] : 0);
    }), [2, 3, 4, 5, 6, 7].forEach((o) => {
      t[o] = t[o] ? o !== 2 ? m(t[o], g.value.operation) : m(t[o]) : 0;
    }), t;
  }
  const { maxHeight: I } = $({ extraBox: [".head-container"], paginate: true });
  return (r, e) => {
    const p = M, t = U, s = B("common-table"), o = L("permission");
    return k(), N("div", Z, [l("div", ee, [l("div", te, [i(p, { modelValue: _.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => _.value = a), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", format: "YYYY", "value-format": "YYYY", clearable: false, "disabled-date": C, onChange: w }, null, 8, ["modelValue"]), i(n(J), { modelValue: h.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => h.value = a), class: "filter-item", onChange: w, clearable: "" }, null, 8, ["modelValue"])]), l("div", ae, [R((k(), j(O, { fn: n(X), params: { projectId: h.value, year: _.value } }, { default: c(() => e[2] || (e[2] = [S(" 检测费清单 ")])), _: 1, __: [2] }, 8, ["fn", "params"])), [[o, n(T).download]])])]), i(s, { ref_key: "tableRef", ref: Y, data: x.value, "empty-text": n(V)(n(T).get) ? "暂无数据" : "暂无权限", "max-height": n(I), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": E }, { default: c(() => [i(t, { type: "index", label: "序号", prop: "indx", align: "center" }), i(t, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "120" }, { default: c((a) => [l("span", null, f(n(Q)(a.row.project)), 1)]), _: 1 }), i(t, { label: "产量（吨）", prop: "capacity", key: "capacity", align: "center" }, { default: c((a) => [l("span", null, f(n(m)(a.row.capacity)), 1)]), _: 1 }), (k(true), N(z, null, H(b.value, (a) => (k(), j(t, { label: a.name, prop: a.key, key: a.key, align: "center" }, { default: c((v) => [l("span", null, f(n(m)(v.row[a.key], n(g).operation)), 1)]), _: 2 }, 1032, ["label", "prop"]))), 128)), i(t, { label: "合计", prop: "totalAmount", align: "center" }, { default: c((a) => [l("span", null, f(n(m)(a.row.totalAmount, n(g).operation)), 1)]), _: 1 }), i(t, { label: "平均检测费（元/吨）", prop: "averageTestingFee", key: "averageTestingFee", align: "center" }, { default: c((a) => [l("span", null, f(n(m)(a.row.averageTestingFee, n(g).operation)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])]);
  };
} };
export {
  se as default
};
