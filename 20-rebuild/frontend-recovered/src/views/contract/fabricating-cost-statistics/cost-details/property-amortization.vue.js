import { ref as p } from "vue";
import { inject as M } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as v } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as n } from "vue";
import { unref as d } from "vue";
import { withDirectives as S } from "vue";
import { isRef as U } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { v as O } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as P, u as G, o as J, D as m, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "property-amortization", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(s, { emit: A }) {
  const j = A, w = s, y = p(), z = p(), h = p(), f = p(false), g = M("query"), { visible: _, handleClose: I } = G({ emit: j, props: w, showHook: N, closeHook: V }), { maxHeight: Y } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, y), D = p([["amortizationAmount", ["to-thousand", m.YUAN]], ["totalFee", ["to-thousand", m.YUAN]]]);
  async function F() {
    var c;
    f.value = true;
    try {
      const i = { projectId: (c = w.currentData) == null ? void 0 : c.projectId, boolTaxIncluded: g.boolTaxIncluded }, u = await O(i);
      h.value = u;
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
    return K(c, { props: ["totalYield", "projectYield", ["amortizationAmount", m.YUAN], ["totalFee", m.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  return (c, i) => {
    const u = L, T = b("print-table"), l = q, B = b("common-table"), R = b("common-drawer"), C = E;
    return v(), x(R, { ref_key: "drawerRef", ref: y, title: "物业费摊销", "close-on-click-modal": false, modelValue: d(_), "onUpdate:modelValue": i[0] || (i[0] = (r) => U(_) ? _.value = r : null), direction: "rtl", "before-close": d(I), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(u, null, { default: t(() => {
      var r, e;
      return [k("项目：" + a(((r = s.currentData) == null ? void 0 : r.serialNumber) || "-") + " " + a(((e = s.currentData) == null ? void 0 : e.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var r;
      return [n("div", Q, [o(u, null, { default: t(() => [k("统计日期：" + a(s.timeInterval || "-"), 1)]), _: 1 }), o(T, { "api-key": "propertyAmortization", params: { projectId: (r = s.currentData) == null ? void 0 : r.projectId, boolTaxIncluded: d(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), S((v(), x(B, { ref_key: "tableRef", ref: z, data: h.value, "max-height": d(Y), "data-format": D.value, "summary-method": H, "show-summary": "", showEmptySymbol: false }, { default: t(() => [o(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), o(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [n("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.totalYield || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.projectYield || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [n("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "物业费总金额（元）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.totalFee || "-"), 1)]), _: 1 }), o(l, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [n("span", null, a(e.row.amortizationAmount || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[C, f.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = P(W, [["__scopeId", "data-v-8cc5c4b7"]]);
export {
  ee as default
};
