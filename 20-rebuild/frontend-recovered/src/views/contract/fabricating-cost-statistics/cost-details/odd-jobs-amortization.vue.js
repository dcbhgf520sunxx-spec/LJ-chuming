import { ref as d } from "vue";
import { inject as M } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as r } from "vue";
import { unref as m } from "vue";
import { withDirectives as S } from "vue";
import { isRef as U } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { r as J } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as O, u as W, o as P, D as p, ba as G } from "../../../../shared/runtime.js";
const K = { class: "content-header" }, Q = { __name: "odd-jobs-amortization", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(s, { emit: A }) {
  const j = A, w = s, h = d(), z = d(), y = d(), f = d(false), g = M("query"), { visible: _, handleClose: I } = W({ emit: j, props: w, showHook: N, closeHook: T }), { maxHeight: D } = P({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, h), Y = d([["amortizationAmount", ["to-thousand", p.YUAN]], ["totalFee", ["to-thousand", p.YUAN]]]);
  async function F() {
    var c;
    f.value = true;
    try {
      const i = { projectId: (c = w.currentData) == null ? void 0 : c.projectId, boolTaxIncluded: g.boolTaxIncluded }, u = await J(i);
      y.value = u;
    } catch (i) {
      console.log(i);
    } finally {
      f.value = false;
    }
  }
  function N() {
    F();
  }
  function T() {
  }
  function V(c) {
    return G(c, { props: ["totalYield", ["amortizationAmount", p.YUAN], ["totalFee", p.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (c, i) => {
    const u = L, H = b("print-table"), l = q, B = b("common-table"), C = b("common-drawer"), R = E;
    return v(), x(C, { ref_key: "drawerRef", ref: h, title: "零工摊销成本", "close-on-click-modal": false, modelValue: m(_), "onUpdate:modelValue": i[0] || (i[0] = (n) => U(_) ? _.value = n : null), direction: "rtl", "before-close": m(I), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(u, null, { default: t(() => {
      var n, e;
      return [k("项目：" + a(((n = s.currentData) == null ? void 0 : n.serialNumber) || "-") + " " + a(((e = s.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var n;
      return [r("div", K, [o(u, null, { default: t(() => [k("统计日期：" + a(s.timeInterval || "-"), 1)]), _: 1 }), o(H, { "api-key": "tempWorkAmortizationCost", params: { projectId: (n = s.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: m(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), S((v(), x(B, { ref_key: "tableRef", ref: z, data: y.value, "max-height": m(D), "data-format": Y.value, "summary-method": V, showEmptySymbol: false, "show-summary": "" }, { default: t(() => [o(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), o(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [r("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalYield || "0"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.projectYield || "0"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [r("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) : "0.00") + "%", 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "零工总金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalFee || "0.00"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.amortizationAmount || "0.00"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[R, f.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = O(Q, [["__scopeId", "data-v-7addf796"]]);
export {
  ee as default
};
