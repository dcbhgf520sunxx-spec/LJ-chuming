import { ref as _ } from "vue";
import { onMounted as F } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as u } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as d } from "vue";
import { unref as n } from "vue";
import { Fragment as w } from "vue";
import { renderList as I } from "vue";
import { createBlock as b } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { l as j, t as H, p as z, G as P, jl as T, c as N, o as G, bV as y, D as K } from "../../../shared/runtime.js";
import { a as D } from "../../../modules/operation-4e9312fe.js";
function R(v) {
  return j({ url: "/api/wms/outbound/application/use-classify", method: "get", params: v });
}
const q = { class: "app-container" }, J = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, $ = { __name: "index", setup(v) {
  const { decimalPrecision: p } = H(), A = _(z(/* @__PURE__ */ new Date(), "{y}")), m = _([]), M = _([]), S = _([]), h = _([]), W = _([]);
  F(() => {
    U();
  });
  async function U() {
    if (m.value = [], h.value = ["gasAmount", "gasWeight", "auxSubtotal", "totalAmount"], !P(D.get)) return false;
    try {
      const o = await R({ year: A.value });
      M.value = (o == null ? void 0 : o.auxiliary) || [], S.value = (o == null ? void 0 : o.gas) || [];
      for (const a in o) a !== "auxiliary" && a !== "gas" && m.value.push({ month: a, ...o[a] });
      m.value.forEach(async (a) => {
        var g, t, r;
        a.productWeightList = [], await T(a.gas, { toNum: true }), await T(a.auxiliary, { toNum: true }), a.gas.map((e) => {
          a["mete_" + e.classifyId] = e.mete, a["amountExcludingVAT_" + e.classifyId] = e.amountExcludingVAT, a["accountingUnit_" + e.classifyId] = e.accountingUnit, h.value.push("mete_" + e.classifyId), h.value.push("amountExcludingVAT_" + e.classifyId), W.value.push("mete_" + e.classifyId);
        }), a.auxiliary.map((e) => {
          a["amountExcludingVAT_" + e.classifyId] = e.amountExcludingVAT, a["accountingUnit_" + e.classifyId] = e.accountingUnit, h.value.push("amountExcludingVAT_" + e.classifyId);
        }), a.gasWeight = (g = a.gas) == null ? void 0 : g.reduce((e, l) => l ? e + Number(l == null ? void 0 : l.mete) : e, 0), a.gasAmount = (t = a.gas) == null ? void 0 : t.reduce((e, l) => l ? e + Number(l == null ? void 0 : l.amountExcludingVAT) : e, 0), a.auxSubtotal = (r = a.auxiliary) == null ? void 0 : r.reduce((e, l) => l ? e + Number(l == null ? void 0 : l.amountExcludingVAT) : e, 0), a.totalAmount = a.gasAmount + a.auxSubtotal, a.aveUnitPrice = a.productionMete ? (a.totalAmount / N(a.productionMete, "kg", "t")).toFixed(p.value.operation) : a.totalAmount;
      }), console.log("list.value", m.value), m.value = await T(m.value, { toSmallest: false, toNum: true });
    } catch (o) {
      console.log("获取已出库辅材和气体科目ID失败", o);
    }
  }
  function Y(o) {
    return o > /* @__PURE__ */ new Date();
  }
  const { maxHeight: B } = G({ extraBox: [".head-container"], paginate: true });
  function C(o) {
    const { columns: a, data: g } = o, t = [];
    return a.forEach((r, e) => {
      if (e === 0) {
        t[e] = "合计";
        return;
      }
      if (r.property === "productionMete") {
        const l = g.map((i) => N(i.productionMete, "kg", "t", K.COM_WT__T));
        l.every((i) => isNaN(i)) || (t[e] = l.reduce((i, x) => {
          const V = Number(x);
          return isNaN(V) ? i : i + x;
        }, 0), t[e] = t[e] ? t[e].toFixed(2) : 0);
      }
      if (h.value.indexOf(r.property) > -1) {
        const l = g.map((i) => Number(i[r.property]));
        l.every((i) => isNaN(i)) || (t[e] = l.reduce((i, x) => {
          const V = Number(x);
          return isNaN(V) ? i : i + x;
        }, 0), r.property !== "gasWeight" && r.property.indexOf("mete_") < 0 ? t[e] = t[e] ? t[e].toFixed(p.value.operation) : 0 : t[e] = t[e] ? t[e].toFixed(2) : 0);
      }
    }), t;
  }
  return (o, a) => {
    const g = k, t = O, r = L("common-table");
    return f(), E("div", q, [c("div", J, [c("div", null, [u(g, { modelValue: A.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => A.value = e), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", "value-format": "YYYY", format: "YYYY", clearable: false, "disabled-date": Y, onChange: U }, null, 8, ["modelValue"])])]), u(r, { ref: "tableRef", data: m.value, "empty-text": n(P)(n(D).get) ? "暂无数据" : "暂无权限", "max-height": n(B), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": C }, { default: s(() => [u(t, { label: "月份", prop: "month", align: "center", width: "60px", fixed: "left" }, { default: s(({ row: e }) => [c("span", null, d(e.month), 1)]), _: 1 }), u(t, { label: "完成量（吨）", prop: "productionMete", align: "center", width: "100px", fixed: "left" }, { default: s(({ row: e }) => [c("span", null, d(e.productionMete !== null ? n(N)(e.productionMete, "kg", "t", 2) : 0), 1)]), _: 1 }), u(t, { label: "气体", prop: "gas", align: "center" }, { default: s(() => [(f(true), E(w, null, I(S.value, (e) => (f(), b(t, { key: e, label: e.name, align: "center" }, { default: s(() => [(f(), b(t, { label: "重量", prop: "mete_" + e.id, key: "mete_" + e.id, align: "center" }, null, 8, ["prop"])), u(t, { label: "单位", prop: "accountingUnit_" + e.id, align: "center" }, null, 8, ["prop"]), (f(), b(t, { label: "金额", prop: "amountExcludingVAT_" + e.id, key: "amountExcludingVAT_" + e.id, align: "center" }, { default: s(({ row: l }) => [c("span", null, d(l["amountExcludingVAT_" + e.id] ? n(y)(l["amountExcludingVAT_" + e.id], n(p).operation) : "-"), 1)]), _: 2 }, 1032, ["prop"]))]), _: 2 }, 1032, ["label"]))), 128)), u(t, { label: "小计", prop: "gasSubtotal", align: "center" }, { default: s(() => [u(t, { label: "重量", prop: "gasWeight", align: "center" }), u(t, { label: "金额", prop: "gasAmount", align: "center" }, { default: s(({ row: e }) => [c("span", null, d(e.gasAmount ? n(y)(e.gasAmount, n(p).operation) : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }), u(t, { label: "辅材", prop: "auxiliaryMaterials", align: "center" }, { default: s(() => [(f(true), E(w, null, I(M.value, (e) => (f(), b(t, { key: e, label: e.name, prop: "amountExcludingVAT_" + e.id, align: "center" }, { default: s(({ row: l }) => [c("span", null, d(l["amountExcludingVAT_" + e.id] ? n(y)(l["amountExcludingVAT_" + e.id], n(p).operation) : "-"), 1)]), _: 2 }, 1032, ["label", "prop"]))), 128)), u(t, { label: "小计", prop: "auxSubtotal", align: "center" }, { default: s(({ row: e }) => [c("span", null, d(e.auxSubtotal ? n(y)(e.auxSubtotal, n(p).operation) : "-"), 1)]), _: 1 })]), _: 1 }), u(t, { label: "合计", prop: "totalAmount", align: "center", width: "140px", fixed: "right" }, { default: s(({ row: e }) => [c("span", null, d(e.totalAmount ? n(y)(e.totalAmount, n(p).operation) : "-"), 1)]), _: 1 }), u(t, { label: "平均单价（元/吨）", prop: "aveUnitPrice", align: "center", width: "140px", fixed: "right" }, { default: s(({ row: e }) => [c("span", null, d(e.aveUnitPrice ? n(y)(e.aveUnitPrice, n(p).operation) : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])]);
  };
} };
export {
  $ as default
};
