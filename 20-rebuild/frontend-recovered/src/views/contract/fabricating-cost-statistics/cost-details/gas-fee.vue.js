import { ref as u } from "vue";
import { inject as M } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as r } from "vue";
import { unref as p } from "vue";
import { withDirectives as S } from "vue";
import { isRef as U } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { f as G } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as O, u as P, o as J, D as m, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "gas-fee", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(i, { emit: j }) {
  const F = j, w = i, h = u(), I = u(), g = u(), f = u(false), y = M("query"), { visible: _, handleClose: Y } = P({ emit: F, props: w, showHook: V, closeHook: z }), { maxHeight: A } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, h), D = u([["amortizationAmount", ["to-thousand", m.YUAN]], ["totalFee", ["to-thousand", m.YUAN]]]);
  async function N() {
    var c;
    f.value = true;
    try {
      const s = { projectId: (c = w.currentData) == null ? void 0 : c.projectId, boolTaxIncluded: y.boolTaxIncluded }, d = await G(s);
      g.value = d;
    } catch (s) {
      console.log(s);
    } finally {
      f.value = false;
    }
  }
  function V() {
    N();
  }
  function z() {
  }
  function H(c) {
    return K(c, { props: ["totalYield", "projectYield", ["amortizationAmount", m.YUAN], ["totalFee", m.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (c, s) => {
    const d = L, T = b("print-table"), l = q, B = b("common-table"), R = b("common-drawer"), C = E;
    return v(), x(R, { ref_key: "drawerRef", ref: h, title: "气体费摊销", "close-on-click-modal": false, modelValue: p(_), "onUpdate:modelValue": s[0] || (s[0] = (n) => U(_) ? _.value = n : null), direction: "rtl", "before-close": p(Y), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(d, null, { default: t(() => {
      var n, e;
      return [k("项目：" + a(((n = i.currentData) == null ? void 0 : n.serialNumber) || "-") + " " + a(((e = i.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var n;
      return [r("div", Q, [o(d, null, { default: t(() => [k("统计日期：" + a(i.timeInterval || "-"), 1)]), _: 1 }), o(T, { "api-key": "fabricatingCostStatisticsGasFee", params: { projectId: (n = i.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: p(y).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), S((v(), x(B, { ref_key: "tableRef", ref: I, data: g.value, "max-height": p(A), "data-format": D.value, "summary-method": H, "show-summary": "" }, { default: t(() => [o(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), o(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [r("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalYield || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.projectYield || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [r("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "气体费总金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalFee || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.amortizationAmount || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[C, f.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = O(W, [["__scopeId", "data-v-83c9663b"]]);
export {
  ee as default
};
