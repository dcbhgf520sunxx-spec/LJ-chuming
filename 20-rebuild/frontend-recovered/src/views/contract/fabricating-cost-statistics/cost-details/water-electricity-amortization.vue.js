import { ref as u } from "vue";
import { inject as C } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as n } from "vue";
import { unref as m } from "vue";
import { withDirectives as M } from "vue";
import { isRef as S } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as q } from "element-plus";
import { y as O } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as P, u as W, o as G, D as p, ba as J } from "../../../../shared/runtime.js";
const K = { class: "content-header" }, Q = { __name: "water-electricity-amortization", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(s, { emit: A }) {
  const z = A, y = s, b = u(), j = u(), h = u(), f = u(false), g = C("query"), { visible: _, handleClose: I } = W({ emit: z, props: y, showHook: N, closeHook: V }), { maxHeight: D } = G({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, b), Y = u([["amortizationAmount", ["to-thousand", p.YUAN]], ["totalFee", ["to-thousand", p.YUAN]]]);
  async function F() {
    var c;
    f.value = true;
    try {
      const i = { projectId: (c = y.currentData) == null ? void 0 : c.projectId, boolTaxIncluded: g.boolTaxIncluded }, d = await O(i);
      h.value = d;
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
    return J(c, { props: ["totalYield", ["amortizationAmount", p.YUAN], ["totalFee", p.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (c, i) => {
    const d = U, T = w("print-table"), l = L, B = w("common-table"), E = w("common-drawer"), R = q;
    return v(), x(E, { ref_key: "drawerRef", ref: b, title: "水电费摊销", "close-on-click-modal": false, modelValue: m(_), "onUpdate:modelValue": i[0] || (i[0] = (r) => S(_) ? _.value = r : null), direction: "rtl", "before-close": m(I), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(d, null, { default: t(() => {
      var r, e;
      return [k("项目：" + a(((r = s.currentData) == null ? void 0 : r.serialNumber) || "-") + " " + a(((e = s.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var r;
      return [n("div", K, [o(d, null, { default: t(() => [k("统计日期：" + a(s.timeInterval || "-"), 1)]), _: 1 }), o(T, { "api-key": "waterElectricityAmortization", params: { projectId: (r = s.currentData) == null ? void 0 : r.projectId, boolTaxIncluded: m(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), M((v(), x(B, { ref_key: "tableRef", ref: j, data: h.value, "max-height": m(D), "data-format": Y.value, "summary-method": H, showEmptySymbol: false, "show-summary": "" }, { default: t(() => [o(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), o(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [n("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.totalYield || "0"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.projectYield || "0"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [n("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) : "0.00") + "%", 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "水电费总金额（元）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.totalFee || "0.00"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.amortizationAmount || "0.00"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[R, f.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = P(Q, [["__scopeId", "data-v-c5705700"]]);
export {
  ee as default
};
