import { ref as i } from "vue";
import { inject as C } from "vue";
import { computed as E } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as w } from "vue";
import { createBlock as g } from "vue";
import { withCtx as u } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as x } from "vue";
import { createElementVNode as A } from "vue";
import { withDirectives as k } from "vue";
import { unref as s } from "vue";
import { isRef as z } from "vue";
import { ElTag as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { h as Q } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as W, u as X, o as Z, D as t, G as I, ba as $ } from "../../../../shared/runtime.js";
import { z as v } from "../../../../modules/contract-9b18cc88.js";
const ee = { class: "content-header" }, te = { __name: "main-business-income", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(c, { emit: N }) {
  const B = N, b = c, y = i(), U = i(), r = i(), m = i(false), h = C("query"), { visible: d, handleClose: D } = X({ emit: B, props: b, showHook: j, closeHook: P }), { maxHeight: Y } = Z({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, y);
  E(() => {
    var n, a;
    return ((n = r.value) == null ? void 0 : n[0].yearMonth) + "~" + ((a = r.value) == null ? void 0 : a[r.value.length - 1].yearMonth);
  });
  const O = i([["totalAmount", ["to-thousand", t.YUAN]], ["income", ["to-thousand", t.YUAN]], ["visaFee", ["to-thousand", t.YUAN]], ["advancePayment", ["to-thousand", t.YUAN]], ["scrapAmountMoney", ["to-thousand", t.YUAN]], ["scrapAmountMoney", ["to-thousand", t.YUAN]], ["total", ["to-thousand", t.YUAN]]]);
  async function M() {
    var n;
    if (!I(v.mainBusinessIncome)) return false;
    m.value = true;
    try {
      const a = { projectId: (n = b.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: h.boolTaxIncluded }, p = await Q(a);
      r.value = p;
    } catch (a) {
      console.log(a);
    } finally {
      m.value = false;
    }
  }
  function j() {
    M();
  }
  function P() {
  }
  function V(n) {
    return $(n, { props: ["totalOutputArtifact", "totalOutputEnclosure", "totalOutputStandard", ["totalAmount", t.YUAN], ["income", t.YUAN], ["visaFee", t.YUAN], ["advancePayment", t.YUAN], ["total", t.YUAN]], toThousandFields: ["totalAmount", "income", "visaFee", "advancePayment", "total"] });
  }
  return (n, a) => {
    const p = G, H = f("print-table"), o = J, R = f("common-table"), S = f("common-drawer"), T = L("permission"), F = K;
    return w(), g(S, { ref_key: "drawerRef", ref: y, title: "主营业务收入", "close-on-click-modal": false, modelValue: s(d), "onUpdate:modelValue": a[0] || (a[0] = (l) => z(d) ? d.value = l : null), direction: "rtl", "before-close": s(D), "wrapper-closable": false, "custom-class": "amount-detail", size: "70%" }, { titleAfter: u(() => [e(p, null, { default: u(() => {
      var l, _;
      return [q("项目：" + x(((l = c.currentData) == null ? void 0 : l.serialNumber) || "-") + " " + x(((_ = c.currentData) == null ? void 0 : _.projectName) || "-"), 1)];
    }), _: 1 })]), content: u(() => {
      var l;
      return [A("div", ee, [a[1] || (a[1] = A("div", null, null, -1)), k(e(H, { "api-key": "mainBusinessIncome", params: { projectId: (l = c.currentData) == null ? void 0 : l.projectId, boolTaxIncluded: s(h).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"]), [[T, s(v).mainBusinessIncomePrint]])]), k((w(), g(R, { ref_key: "tableRef", ref: U, data: r.value, "max-height": s(Y), "empty-text": s(I)(s(v).mainBusinessIncome) ? "暂无数据" : "暂无权限", "data-format": O.value, "summary-method": V, "show-summary": "" }, { default: u(() => [e(o, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "totalOutputArtifact", key: "totalOutputArtifact", label: "结构发运量（t）", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "totalOutputEnclosure", key: "totalOutputEnclosure", label: "围护发运量（m）", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "totalOutputStandard", key: "totalOutputStandard", label: "配套制品发运量", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "发运额（元）", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "income", key: "income", label: "当月收入（元）", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "visaFee", key: "visaFee", label: "签证费（元）", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "advancePayment", key: "advancePayment", label: "预收额（元）", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "total", key: "total", label: "合计", align: "center" })]), _: 1 }, 8, ["data", "max-height", "empty-text", "data-format"])), [[F, m.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, se = W(te, [["__scopeId", "data-v-4bb29ec8"]]);
export {
  se as default
};
