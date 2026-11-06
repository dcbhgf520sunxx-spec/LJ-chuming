import { ref as s } from "vue";
import { inject as L } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as w } from "vue";
import { createBlock as v } from "vue";
import { withCtx as o } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as d } from "vue";
import { createElementVNode as k } from "vue";
import { unref as u } from "vue";
import { withDirectives as M } from "vue";
import { isRef as P } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { a as E } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as O, u as G, o as J, D as _, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "direct-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(l, { emit: j }) {
  const D = j, b = l, h = s(), I = s(), y = s(), m = s(false), g = L("query"), { visible: p, handleClose: C } = G({ emit: D, props: b, showHook: R, closeHook: T }), { maxHeight: V } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, h), H = s([["tonUnitPrice", ["to-thousand", _.YUAN]], ["totalFee", ["to-thousand", _.YUAN]]]);
  async function N() {
    var n;
    m.value = true;
    try {
      const a = { projectId: (n = b.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: g.boolTaxIncluded }, c = await E(a);
      y.value = c;
    } catch (a) {
      console.log(a);
    } finally {
      m.value = false;
    }
  }
  function R() {
    N();
  }
  function T() {
  }
  function B(n) {
    return K(n, { props: ["totalYield", ["totalFee", _.YUAN]], toThousandFields: ["totalFee"] });
  }
  return (n, a) => {
    const c = S, F = f("print-table"), r = q, U = f("common-table"), Y = f("common-drawer"), A = z;
    return w(), v(Y, { ref_key: "drawerRef", ref: h, title: "期间费-直接费", "close-on-click-modal": false, modelValue: u(p), "onUpdate:modelValue": a[0] || (a[0] = (t) => P(p) ? p.value = t : null), direction: "rtl", "before-close": u(C), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: o(() => [e(c, null, { default: o(() => {
      var t, i;
      return [x("项目：" + d(((t = l.currentData) == null ? void 0 : t.serialNumber) || "-") + " " + d(((i = l.currentData) == null ? void 0 : i.projectName) || "-"), 1)];
    }), _: 1 })]), content: o(() => {
      var t;
      return [k("div", Q, [e(c, null, { default: o(() => [x("统计日期：" + d(l.timeInterval || "-"), 1)]), _: 1 }), e(F, { "api-key": "directCostReport", params: { projectId: (t = l.currentData) == null ? void 0 : t.projectId, boolTaxIncluded: u(g).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), M((w(), v(U, { ref_key: "tableRef", ref: I, data: y.value, "max-height": u(V), "data-format": H.value, "summary-method": B, "show-summary": "" }, { default: o(() => [e(r, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), e(r, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }), e(r, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "产量（吨）", align: "center" }, { default: o((i) => [k("span", null, d(i.row.projectYield || "-"), 1)]), _: 1 }), e(r, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "直接费总额（元）", align: "center" }), e(r, { "show-overflow-tooltip": "", prop: "tonUnitPrice", key: "tonUnitPrice", label: "吨单价（元/吨）", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[A, m.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = O(W, [["__scopeId", "data-v-95e5ad21"]]);
export {
  ee as default
};
