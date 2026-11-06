import { ref as v } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as V } from "vue";
import { unref as n } from "vue";
import { createBlock as B } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as h } from "vue";
import { ElDatePicker as q } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { l as W, t as j, p as A, G as F, o as H, L as z, c as P, D as O } from "../../../shared/runtime.js";
import { k as w } from "../../../modules/operation-4e9312fe.js";
function G(b) {
  return W({ url: "/api/contract/water-electricity-property-fee/water-electricity-fee-statistics", method: "get", params: b });
}
function $(b) {
  return W({ url: "/api/contract/water-electricity-property-fee/water-electricity-fee-statistics/export", method: "get", responseType: "blob", params: b });
}
const I = { class: "app-container" }, J = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, Z = { __name: "index", setup(b) {
  const { decimalPrecision: _ } = j(), g = v(A(/* @__PURE__ */ new Date(), "{y}")), k = v(), M = v([]);
  D(() => {
    E();
  });
  async function E() {
    if (!F(w.get)) return false;
    try {
      const { content: m } = await G({ year: g.value });
      M.value = m || [];
    } catch (m) {
      console.log("获取水电费列表失败", m);
    }
  }
  function x(m) {
    return m > /* @__PURE__ */ new Date();
  }
  function L(m) {
    const { columns: f, data: l } = m, r = [];
    return f.forEach((p, i) => {
      if (i === 0) {
        r[i] = "合计";
        return;
      }
      if (i === 3) {
        r[i] = 0;
        const t = l.map((e) => e.usedElectricityMete), u = l.map((e) => e.electricityPrice), c = t.reduce((e, a) => a ? e + Number(a) : e, 0), s = u.reduce((e, a) => a ? e + Number(a) : e, 0);
        r[i] = c ? (s / c).toFixed(2) : s.toFixed(2);
        return;
      }
      if (i === 5) {
        r[i] = 0;
        const t = l.map((e) => e.monthOutput), u = l.map((e) => e.electricityPrice), c = t.reduce((e, a) => a ? e + Number(a) : e, 0), s = u.reduce((e, a) => a ? e + Number(a) : e, 0);
        r[i] = c ? (s / (c / 1e3)).toFixed(2) : s.toFixed(2);
        return;
      }
      if (i === 7) {
        r[i] = 0;
        const t = l.map((e) => e.usedWaterMete), u = l.map((e) => e.waterPrice), c = t.reduce((e, a) => a ? e + Number(a) : e, 0), s = u.reduce((e, a) => a ? e + Number(a) : e, 0);
        r[i] = c ? (s / c).toFixed(2) : s.toFixed(2);
        return;
      }
      if (i === 9) {
        r[i] = 0;
        const t = l.map((e) => e.monthOutput), u = l.map((e) => e.waterPrice), c = t.reduce((e, a) => a ? e + Number(a) : e, 0), s = u.reduce((e, a) => a ? e + Number(a) : e, 0);
        r[i] = c ? (s / (c / 1e3)).toFixed(2) : s.toFixed(2);
        return;
      }
      if (p.property === "monthOutput" || p.property === "usedElectricityMete" || p.property === "electricityPrice" || p.property === "usedWaterMete" || p.property === "waterPrice") {
        const t = l.map((c) => Number(c[p.property]));
        let u = 0;
        t.every((c) => isNaN(c)) || (u = t.reduce((c, s) => {
          const e = Number(s);
          return isNaN(e) ? c : c + s;
        }, 0)), r[i] = p.property === "electricityPrice" || p.property === "waterPrice" ? u.toFixed(_.value.operation) : u.toFixed(2);
      }
      i === 1 && (r[i] = P(r[i], "kg", "t", 2));
    }), r;
  }
  const { maxHeight: S } = H({ extraBox: [".head-container"], paginate: true });
  return (m, f) => {
    const l = q, r = R, p = T("common-table"), i = Y("permission");
    return N(), C("div", I, [y("div", J, [o(l, { modelValue: g.value, "onUpdate:modelValue": f[0] || (f[0] = (t) => g.value = t), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", format: "YYYY", "value-format": "YYYY", clearable: "", "disabled-date": x, onChange: E }, null, 8, ["modelValue"]), V((N(), B(z, { class: "filter-item", fn: n($), params: { year: g.value } }, { default: d(() => f[1] || (f[1] = [U(" 水电费清单 ")])), _: 1, __: [1] }, 8, ["fn", "params"])), [[i, n(w).download]])]), o(p, { ref_key: "tableRef", ref: k, data: M.value, "empty-text": n(F)(n(w).get) ? "暂无数据" : "暂无权限", "max-height": n(S), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": L }, { default: d(() => [o(r, { label: "月份", prop: "month", align: "center" }), o(r, { label: "月产（吨）", prop: "monthOutput", align: "center" }, { default: d(({ row: t }) => [y("span", null, h(n(P)(t.monthOutput, "kg", "t", 2)), 1)]), _: 1 }), o(r, { label: "用电度数", prop: "usedElectricityMete", align: "center" }), o(r, { label: "均价（元/度）", prop: "ElectricityAverageUnitPrice", align: "center" }, { default: d(({ row: t }) => [y("span", null, h(t.usedElectricityMete ? (t.electricityPrice / t.usedElectricityMete).toFixed(n(_).operation) : 0), 1)]), _: 1 }), o(r, { label: "电费（元）", prop: "electricityPrice", align: "center" }), o(r, { label: "折合电费（元/吨）", prop: "equivalentElectricity", align: "center" }, { default: d(({ row: t }) => [y("span", null, h(t.monthOutput ? (t.electricityPrice / n(P)(t.monthOutput, "kg", "t", n(O).COM_WT__T)).toFixed(n(_).operation) : t.electricityPrice), 1)]), _: 1 }), o(r, { label: "用水量（吨）", prop: "usedWaterMete", align: "center" }), o(r, { label: "均价（元/吨）", prop: "waterAverageUnitPrice", align: "center" }, { default: d(({ row: t }) => [y("span", null, h(t.usedWaterMete ? (t.waterPrice / t.usedWaterMete).toFixed(n(_).operation) : 0), 1)]), _: 1 }), o(r, { label: "水费（元）", prop: "waterPrice", align: "center" }), o(r, { label: "折合水费（元/吨）", prop: "equivalentWater", align: "center" }, { default: d(({ row: t }) => [y("span", null, h(t.monthOutput ? (t.waterPrice / n(P)(t.monthOutput, "kg", "t", n(O).COM_WT__T)).toFixed(n(_).operation) : t.waterPrice), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])]);
  };
} };
export {
  Z as default
};
