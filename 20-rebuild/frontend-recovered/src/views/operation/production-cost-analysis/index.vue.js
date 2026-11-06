import { computed as H } from "vue";
import { ref as h } from "vue";
import { onMounted as R } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as W } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as r } from "vue";
import { withCtx as N } from "vue";
import { toDisplayString as z } from "vue";
import { unref as x } from "vue";
import { ElDatePicker as G } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { l as Q, t as q, p as I, G as P, c as S, D as J, o as K } from "../../../shared/runtime.js";
import { e as k } from "../../../modules/operation-4e9312fe.js";
function X(_) {
  return Q({ url: "/api/contract/finance/operationAnalysis/cost-analysis", method: "get", params: _ });
}
const Z = { class: "app-container" }, $ = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, oe = { __name: "index", setup(_) {
  const { decimalPrecision: a } = q(), L = H(() => [["laborFee", ["to-thousand", a.value.operation]], ["auxiliaryFee", ["to-thousand", a.value.operation]], ["gasFee", ["to-thousand", a.value.operation]], ["waterElectricityFee", ["to-thousand", a.value.operation]], ["plantDepreciationFee", ["to-thousand", a.value.operation]], ["deviceDepreciationFee", ["to-thousand", a.value.operation]], ["testingFee", ["to-thousand", a.value.operation]], ["managementFee", ["to-thousand", a.value.operation]], ["totalFee", ["to-thousand", a.value.operation]], ["avgProductionFee", ["to-thousand", a.value.operation]]]), b = h(I(/* @__PURE__ */ new Date(), "{y}")), M = h(), D = h([]);
  R(() => {
    w();
  });
  async function w() {
    if (!P(k.get)) return false;
    try {
      const { content: n } = await X({ year: b.value }), v = n.map((e) => e.laborFee), y = n.map((e) => e.auxiliaryFee), i = n.map((e) => e.gasFee), f = n.map((e) => e.waterElectricityFee), g = n.map((e) => e.plantDepreciationFee), V = n.map((e) => e.deviceDepreciationFee), A = n.map((e) => e.testingFee), B = n.map((e) => e.managementFee), T = n.map((e) => S(e.productionMete, "kg", "t", J.COM_WT__T)), l = v.reduce((e, o) => o ? e + Number(o) : e, 0), s = y.reduce((e, o) => o ? e + Number(o) : e, 0), c = i.reduce((e, o) => o ? e + Number(o) : e, 0), u = f.reduce((e, o) => o ? e + Number(o) : e, 0), p = g.reduce((e, o) => o ? e + Number(o) : e, 0), d = V.reduce((e, o) => o ? e + Number(o) : e, 0), F = A.reduce((e, o) => o ? e + Number(o) : e, 0), m = B.reduce((e, o) => o ? e + Number(o) : e, 0), t = T.reduce((e, o) => o ? e + Number(o) : e, 0);
      n.push({ month: "合计", productionMete: (t * 1e3).toFixed(a.value.operation), laborFee: l.toFixed(a.value.operation), auxiliaryFee: s.toFixed(a.value.operation), gasFee: c.toFixed(a.value.operation), waterElectricityFee: u.toFixed(a.value.operation), plantDepreciationFee: p.toFixed(a.value.operation), deviceDepreciationFee: d.toFixed(a.value.operation), testingFee: F.toFixed(a.value.operation), managementFee: m.toFixed(a.value.operation) }, { month: "单项成本", laborFee: t ? (l / t).toFixed(a.value.operation) : l, auxiliaryFee: t ? (s / t).toFixed(a.value.operation) : s, gasFee: t ? (c / t).toFixed(a.value.operation) : c, waterElectricityFee: t ? (u / t).toFixed(a.value.operation) : u, plantDepreciationFee: t ? (p / t).toFixed(a.value.operation) : p, deviceDepreciationFee: t ? (d / t).toFixed(a.value.operation) : d, testingFee: t ? (F / t).toFixed(a.value.operation) : F, managementFee: t ? (m / t).toFixed(a.value.operation) : m }, { month: "占比", laborFee: t && l ? (l / t / l * 100).toFixed(2) + "%" : 0, auxiliaryFee: t && s ? (s / t / s * 100).toFixed(2) + "%" : 0, gasFee: t && c ? (c / t / c * 100).toFixed(2) + "%" : 0, waterElectricityFee: t && u ? (u / t / u * 100).toFixed(2) + "%" : 0, plantDepreciationFee: t && p ? (p / t / p * 100).toFixed(2) + "%" : 0, deviceDepreciationFee: t && d ? (d / t / d * 100).toFixed(2) + "%" : 0, testingFee: t && F ? (F / t / F * 100).toFixed(2) + "%" : 0, managementFee: t && m ? (m / t / m * 100).toFixed(2) + "%" : 0 }), D.value = n || [];
    } catch (n) {
      console.log("获取生产成本分析失败", n);
    }
  }
  function Y(n) {
    return n > /* @__PURE__ */ new Date();
  }
  const { maxHeight: C } = K({ extraBox: [".head-container"], paginate: true });
  return (n, v) => {
    const y = G, i = O, f = U("common-table");
    return W(), j("div", Z, [E("div", $, [r(y, { modelValue: b.value, "onUpdate:modelValue": v[0] || (v[0] = (g) => b.value = g), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", format: "YYYY", "value-format": "YYYY", clearable: "", "disabled-date": Y, onChange: w }, null, 8, ["modelValue"])]), r(f, { ref_key: "tableRef", ref: M, data: D.value, "empty-text": x(P)(x(k).get) ? "暂无数据" : "暂无权限", "data-format": L.value, "max-height": x(C), "row-key": "id", showEmptySymbol: false, style: { width: "100%" } }, { default: N(() => [r(i, { label: "月份", prop: "month", width: "70", align: "center" }), r(i, { label: "月产（吨）", prop: "productionMete", align: "center" }, { default: N(({ row: g }) => [E("span", null, z(x(S)(g.productionMete, "kg", "t", 2)), 1)]), _: 1 }), r(i, { label: "人工费", prop: "laborFee", align: "center" }), r(i, { label: "辅材费", prop: "auxiliaryFee", align: "center" }), r(i, { label: "气体", prop: "gasFee", align: "center" }), r(i, { label: "水电费", prop: "waterElectricityFee", align: "center" }), r(i, { label: "厂房折旧", prop: "plantDepreciationFee", align: "center" }), r(i, { label: "设备折旧", prop: "deviceDepreciationFee", align: "center" }), r(i, { label: "检测费", prop: "testingFee", align: "center" }), r(i, { label: "管理费", prop: "managementFee", align: "center" }), r(i, { label: "总额", prop: "totalFee", align: "center" }), r(i, { label: "平均单价", prop: "avgProductionFee", align: "center" }), r(i, { label: "考勤人数", prop: "attendanceQuantity", width: "70", align: "center" }), r(i, { label: "人均产量", prop: "avgWorkerProductionMete", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])]);
  };
} };
export {
  oe as default
};
