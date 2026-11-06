import { ref as l } from "vue";
import { inject as C } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as g } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as P } from "vue";
import { unref as i } from "vue";
import { withDirectives as q } from "vue";
import { isRef as F } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as E } from "element-plus";
import { d as O } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as Y, u as G, o as J, D as x, ba as K } from "../../../../shared/runtime.js";
const Q = { class: "content-header" }, W = { __name: "finished-product-scrap-loss", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(o, { emit: k }) {
  const I = k, f = o, _ = l(), D = l(), h = l(), d = l(false), b = C("query"), { visible: u, handleClose: A } = G({ emit: I, props: f, showHook: H, closeHook: L }), { maxHeight: j } = J({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, _), M = l([["scrapAmountMoney", ["to-thousand", x.YUAN]]]);
  async function V() {
    var n;
    d.value = true;
    try {
      const a = { projectId: (n = f.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: b.boolTaxIncluded }, s = await O(a);
      h.value = s;
    } catch (a) {
      console.log(a);
    } finally {
      d.value = false;
    }
  }
  function H() {
    V();
  }
  function L() {
  }
  function S(n) {
    return K(n, { props: [["scrapAmountMoney", x.YUAN]], toThousandFields: ["scrapAmountMoney"] });
  }
  return (n, a) => {
    const s = U, T = m("print-table"), c = z, B = m("common-table"), N = m("common-drawer"), R = E;
    return g(), v(N, { ref_key: "drawerRef", ref: _, title: "制成品报废损失", "close-on-click-modal": false, modelValue: i(u), "onUpdate:modelValue": a[0] || (a[0] = (e) => F(u) ? u.value = e : null), direction: "rtl", "before-close": i(A), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: r(() => [t(s, null, { default: r(() => {
      var e, y;
      return [w("项目：" + p(((e = o.currentData) == null ? void 0 : e.serialNumber) || "-") + " " + p(((y = o.currentData) == null ? void 0 : y.projectName) || "-"), 1)];
    }), _: 1 })]), content: r(() => {
      var e;
      return [P("div", Q, [t(s, null, { default: r(() => [w("统计日期：" + p(o.timeInterval || "-"), 1)]), _: 1 }), t(T, { "api-key": "finishedProductScrapLoss", params: { projectId: (e = o.currentData) == null ? void 0 : e.projectId, boolTaxIncluded: i(b).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), q((g(), v(B, { ref_key: "tableRef", ref: D, data: h.value, "max-height": i(j), "data-format": M.value, "summary-method": S, "show-summary": "" }, { default: r(() => [t(c, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), t(c, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }), t(c, { "show-overflow-tooltip": "", prop: "scrapAmount", key: "scrapAmount", label: "报废量（吨）", align: "center" }), t(c, { "show-overflow-tooltip": "", prop: "scrapAmountMoney", key: "scrapAmountMoney", label: "金额", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[R, d.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = Y(W, [["__scopeId", "data-v-089279f1"]]);
export {
  ee as default
};
