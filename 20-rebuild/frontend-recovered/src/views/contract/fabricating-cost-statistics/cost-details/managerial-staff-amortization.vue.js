import { ref as m } from "vue";
import { inject as S } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as r } from "vue";
import { unref as d } from "vue";
import { withDirectives as M } from "vue";
import { isRef as U } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { i as O } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as P, u as G, o as J, D as p, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "managerial-staff-amortization", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(s, { emit: A }) {
  const z = A, w = s, h = m(), j = m(), g = m(), f = m(false), y = S("query"), { visible: _, handleClose: I } = G({ emit: z, props: w, showHook: N, closeHook: V }), { maxHeight: D } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, h), Y = m([["amortizationAmount", ["to-thousand", p.YUAN]], ["totalFee", ["to-thousand", p.YUAN]]]);
  async function F() {
    var c;
    f.value = true;
    try {
      const i = { projectId: (c = w.currentData) == null ? void 0 : c.projectId, boolTaxIncluded: y.boolTaxIncluded }, u = await O(i);
      g.value = u;
    } catch (i) {
      console.log(i);
    } finally {
      f.value = false;
    }
  }
  function N() {
    F();
  }
  function V() {
  }
  function H(c) {
    return K(c, { props: ["totalYield", ["amortizationAmount", p.YUAN], ["totalFee", p.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (c, i) => {
    const u = L, T = b("print-table"), l = q, B = b("common-table"), C = b("common-drawer"), R = E;
    return v(), x(C, { ref_key: "drawerRef", ref: h, title: "管理人员摊销成本", "close-on-click-modal": false, modelValue: d(_), "onUpdate:modelValue": i[0] || (i[0] = (n) => U(_) ? _.value = n : null), direction: "rtl", "before-close": d(I), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(u, null, { default: t(() => {
      var n, e;
      return [k("项目：" + a(((n = s.currentData) == null ? void 0 : n.serialNumber) || "-") + " " + a(((e = s.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var n;
      return [r("div", Q, [o(u, null, { default: t(() => [k("统计日期：" + a(s.timeInterval || "-"), 1)]), _: 1 }), o(T, { "api-key": "managerAmortizationCost", params: { projectId: (n = s.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: d(y).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), M((v(), x(B, { ref_key: "tableRef", ref: j, data: g.value, "max-height": d(D), "data-format": Y.value, "summary-method": H, showEmptySymbol: false, "show-summary": "" }, { default: t(() => [o(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), o(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [r("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalYield || "0"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.projectYield || "0"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [r("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) : "0.00") + "%", 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "管理人员工资（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.totalFee || "0.00"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [r("span", null, a(e.row.amortizationAmount || "0.00"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[R, f.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = P(W, [["__scopeId", "data-v-7e3623bf"]]);
export {
  ee as default
};
