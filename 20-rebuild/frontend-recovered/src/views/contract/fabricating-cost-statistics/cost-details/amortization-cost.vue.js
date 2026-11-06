import { ref as d } from "vue";
import { inject as M } from "vue";
import { resolveComponent as w } from "vue";
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
import { g as O } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as P, u as G, o as J, D as p, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "amortization-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(s, { emit: j }) {
  const z = j, b = s, h = d(), A = d(), y = d(), f = d(false), g = M("query"), { visible: _, handleClose: I } = G({ emit: z, props: b, showHook: F, closeHook: N }), { maxHeight: Y } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, h), D = d([["amortizationAmount", ["to-thousand", p.YUAN]], ["totalFee", ["to-thousand", p.YUAN]]]);
  async function C() {
    var c;
    f.value = true;
    try {
      const i = { projectId: (c = b.currentData) == null ? void 0 : c.projectId, boolTaxIncluded: g.boolTaxIncluded }, u = await O(i);
      y.value = u;
    } catch (i) {
      console.log(i);
    } finally {
      f.value = false;
    }
  }
  function F() {
    C();
  }
  function N() {
  }
  function V(c) {
    return K(c, { props: ["totalYield", "projectYield", ["amortizationAmount", p.YUAN], ["totalFee", p.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (c, i) => {
    const u = L, H = w("print-table"), l = q, R = w("common-table"), T = w("common-drawer"), B = E;
    return v(), x(T, { ref_key: "drawerRef", ref: h, title: "期间费-摊销费", "close-on-click-modal": false, modelValue: m(_), "onUpdate:modelValue": i[0] || (i[0] = (n) => U(_) ? _.value = n : null), direction: "rtl", "before-close": m(I), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(u, null, { default: t(() => {
      var n, e;
      return [k("项目：" + a(((n = s.currentData) == null ? void 0 : n.serialNumber) || "-") + " " + a(((e = s.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var n;
      return [r("div", Q, [o(u, null, { default: t(() => [k("统计日期：" + a(s.timeInterval || "-"), 1)]), _: 1 }), o(H, { "api-key": "amortizationCostReport", params: { projectId: (n = s.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: m(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), S((v(), x(R, { ref_key: "tableRef", ref: A, data: y.value, "max-height": m(Y), "data-format": D.value, "summary-method": V, "show-summary": "", showEmptySymbol: false }, { default: t(() => [o(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), o(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [r("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalYield || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.projectYield || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [r("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "总金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalFee || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.amortizationAmount || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[B, f.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = P(W, [["__scopeId", "data-v-6ad15ce4"]]);
export {
  ee as default
};
