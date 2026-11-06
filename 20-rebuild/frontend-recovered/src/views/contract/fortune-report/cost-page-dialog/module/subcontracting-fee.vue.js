import { ref as l } from "vue";
import { computed as w } from "vue";
import { watch as D } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as C } from "vue";
import { createVNode as e } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as F } from "vue";
import { unref as n } from "vue";
import { ElTag as N } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { i as V } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as B, t as E, o as R, bV as H, ba as L } from "../../../../../shared/runtime.js";
const O = { class: "app-container" }, P = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, q = { style: { width: "300px" } }, z = { __name: "subcontracting-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(c) {
  const { decimalPrecision: o } = E(), a = c, d = l(), r = l([]), { maxHeight: _ } = R({ paginate: true }), b = w(() => [["amount", ["to-thousand", o.value.contract]]]);
  D(() => a.costTypeData.projectId, (t) => {
    f();
  }, { immediate: true, deep: true });
  function y(t) {
    return L(t, { props: [["amount", o.value.contract]], toThousandFields: ["amount"] });
  }
  async function f() {
    try {
      const { content: t } = await V({ projectId: a.costTypeData.projectId });
      r.value = t || [];
    } catch (t) {
      console.log("分包费用", t);
    }
  }
  return (t, M) => {
    const h = p("print-table"), g = N, s = S, v = p("common-table"), x = T("permission");
    return j(), k("div", O, [m("div", P, [m("div", q, [C(e(h, { "api-key": "subcontractFee", params: { projectId: a.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[x, c.permission.print]])]), e(g, null, { default: u(() => {
      var i;
      return [I("合计（单位：元）：" + F(n(H)((i = a.costTypeData) == null ? void 0 : i.amount, n(o).contract)), 1)];
    }), _: 1 })]), e(v, { ref_key: "tableRef", ref: d, data: r.value, "empty-text": "暂无数据", "max-height": n(_), "row-key": "id", style: { width: "100%" }, "data-format": b.value, "show-summary": "", "summary-method": y }, { default: u(() => [e(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(s, { prop: "subcontractClassName", key: "subcontractClassName", label: "科目", align: "center" }), e(s, { prop: "amount", key: "amount", label: "累计支付总额（元）", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])]);
  };
} }, K = B(z, [["__scopeId", "data-v-2beb6528"]]);
export {
  K as default
};
