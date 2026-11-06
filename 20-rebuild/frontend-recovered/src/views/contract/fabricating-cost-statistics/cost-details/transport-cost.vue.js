import { ref as c } from "vue";
import { inject as L } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as v } from "vue";
import { createBlock as w } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as m } from "vue";
import { createElementVNode as P } from "vue";
import { unref as p } from "vue";
import { withDirectives as S } from "vue";
import { isRef as U } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as z } from "element-plus";
import { x as E } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as F, u as H, D as f, ba as O } from "../../../../shared/runtime.js";
const G = { class: "content-header" }, J = { __name: "transport-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(a, { emit: T }) {
  const x = T, _ = a, k = c(), b = c(), i = c(false), y = L("query"), { visible: u, handleClose: C } = H({ emit: x, props: _, showHook: j, closeHook: V }), I = c([["costMonthTotal", ["to-thousand", f.YUAN]], ["transportCostPerTon", ["to-thousand", f.YUAN]]]);
  async function D() {
    var n;
    i.value = true;
    try {
      const o = { projectId: (n = _.currentData) == null ? void 0 : n.projectId, boolTaxIncluded: y.boolTaxIncluded }, s = await E(o);
      b.value = s;
    } catch (o) {
      console.log(o);
    } finally {
      i.value = false;
    }
  }
  function j() {
    D();
  }
  function V() {
  }
  function A(n) {
    return O(n, { props: [["transportAmount", f.YUAN]], toThousandFields: ["transportAmount"] });
  }
  return (n, o) => {
    const s = q, N = d("print-table"), l = Y, M = d("common-table"), R = d("common-drawer"), B = z;
    return v(), w(R, { ref: "drawerRef", title: "运输费明细", "close-on-click-modal": false, modelValue: p(u), "onUpdate:modelValue": o[0] || (o[0] = (e) => U(u) ? u.value = e : null), direction: "rtl", "before-close": p(C), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: r(() => [t(s, null, { default: r(() => {
      var e, h;
      return [g("项目：" + m(((e = a.currentData) == null ? void 0 : e.serialNumber) || "-") + " " + m(((h = a.currentData) == null ? void 0 : h.projectName) || "-"), 1)];
    }), _: 1 })]), content: r(() => {
      var e;
      return [P("div", G, [t(s, null, { default: r(() => [g("统计日期：" + m(a.timeInterval || "-"), 1)]), _: 1 }), t(N, { "api-key": "transportationCost", params: { projectId: (e = a.currentData) == null ? void 0 : e.projectId, boolTaxIncluded: p(y).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), S((v(), w(M, { ref_key: "tableRef", ref: k, data: b.value, "data-format": I.value, "summary-method": A, "show-summary": "" }, { default: r(() => [t(l, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), t(l, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }), t(l, { "show-overflow-tooltip": "", prop: "transportAmount", key: "transportAmount", label: "运输量（吨）", align: "center" }), t(l, { "show-overflow-tooltip": "", prop: "costMonthTotal", key: "costMonthTotal", label: "运输费总额（元）", align: "center" }), t(l, { "show-overflow-tooltip": "", prop: "transportCostPerTon", key: "transportCostPerTon", label: "吨单价（元/吨）", align: "center" })]), _: 1 }, 8, ["data", "data-format"])), [[B, i.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = F(J, [["__scopeId", "data-v-7b5ff9c6"]]);
export {
  X as default
};
