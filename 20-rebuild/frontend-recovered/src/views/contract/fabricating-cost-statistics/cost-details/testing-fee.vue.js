import { ref as r } from "vue";
import { inject as A } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as w } from "vue";
import { createBlock as v } from "vue";
import { withCtx as s } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as L } from "vue";
import { unref as i } from "vue";
import { withDirectives as M } from "vue";
import { isRef as P } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { vLoading as z } from "element-plus";
import { w as E } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as O, u as G, o as J, D as f, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "testing-fee", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(o, { emit: k }) {
  const I = k, _ = o, b = r(), j = r(), g = r(), d = r(false), h = A("query"), { visible: u, handleClose: D } = G({ emit: I, props: _, showHook: H, closeHook: N }), { maxHeight: F } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, b), T = r([["tonUnitPrice", ["to-thousand", f.YUAN]], ["totalFee", ["to-thousand", f.YUAN]]]);
  async function V() {
    var l;
    d.value = true;
    try {
      const a = { projectId: (l = _.currentData) == null ? void 0 : l.projectId, boolTaxIncluded: h.boolTaxIncluded }, c = await E(a);
      g.value = c;
    } catch (a) {
      console.log(a);
    } finally {
      d.value = false;
    }
  }
  function H() {
    V();
  }
  function N() {
  }
  function R(l) {
    return K(l, { props: ["totalYield", ["totalFee", f.YUAN]], toThousandFields: ["totalFee"] });
  }
  return (l, a) => {
    const c = S, B = m("print-table"), n = q, U = m("common-table"), Y = m("common-drawer"), C = z;
    return w(), v(Y, { ref_key: "drawerRef", ref: b, title: "检测费", "close-on-click-modal": false, modelValue: i(u), "onUpdate:modelValue": a[0] || (a[0] = (t) => P(u) ? u.value = t : null), direction: "rtl", "before-close": i(D), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: s(() => [e(c, null, { default: s(() => {
      var t, y;
      return [x("项目：" + p(((t = o.currentData) == null ? void 0 : t.serialNumber) || "-") + " " + p(((y = o.currentData) == null ? void 0 : y.projectName) || "-"), 1)];
    }), _: 1 })]), content: s(() => {
      var t;
      return [L("div", Q, [e(c, null, { default: s(() => [x("统计日期：" + p(o.timeInterval || "-"), 1)]), _: 1 }), e(B, { "api-key": "testingFeeReport", params: { projectId: (t = o.currentData) == null ? void 0 : t.projectId, boolTaxIncluded: i(h).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), M((w(), v(U, { ref_key: "tableRef", ref: j, data: g.value, "max-height": i(F), "data-format": T.value, "summary-method": R, "show-summary": "" }, { default: s(() => [e(n, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), e(n, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }), e(n, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "产量（吨）", align: "center" }), e(n, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "检测费总额（元）", align: "center" }), e(n, { "show-overflow-tooltip": "", prop: "tonUnitPrice", key: "tonUnitPrice", label: "吨单价（元/吨））", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[C, d.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = O(W, [["__scopeId", "data-v-8e857e62"]]);
export {
  ee as default
};
