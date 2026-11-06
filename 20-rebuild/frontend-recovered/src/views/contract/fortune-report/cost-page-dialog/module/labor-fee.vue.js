import { ref as l } from "vue";
import { computed as w } from "vue";
import { watch as k } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as F } from "vue";
import { createVNode as e } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as P } from "vue";
import { unref as n } from "vue";
import { ElTag as C } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { a as V } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as B, t as E, o as N, bV as R, ba as S } from "../../../../../shared/runtime.js";
const H = { class: "app-container" }, O = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, q = { style: { width: "300px" } }, z = { __name: "labor-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(c) {
  const o = c, u = l(), r = l([]), { decimalPrecision: s } = E(), { maxHeight: _ } = N({ paginate: true }), y = w(() => [["price", ["to-thousand", s.value.contract]], ["mete", "to-thousand"], ["avgPrice", ["to-thousand", s.value.contract]]]);
  k(() => o.costTypeData.projectId, (t) => {
    h();
  }, { immediate: true, deep: true });
  function f(t) {
    return S(t, { props: [["price", s.value.contract], "mete"], toThousandFields: ["price", "mete"] });
  }
  async function h() {
    try {
      const { content: t } = await V({ projectId: o.costTypeData.projectId });
      r.value = t || [];
    } catch (t) {
      console.log("人工费用", t);
    }
  }
  return (t, M) => {
    const b = p("print-table"), g = C, a = L, v = p("common-table"), x = D("permission");
    return T(), j("div", H, [m("div", O, [m("div", q, [F(e(b, { "api-key": "manualList", params: { projectId: o.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[x, c.permission.print]])]), e(g, null, { default: d(() => {
      var i;
      return [I("合计（单位：元）：" + P(n(R)((i = o.costTypeData) == null ? void 0 : i.amount, n(s).contract)), 1)];
    }), _: 1 })]), e(v, { ref_key: "tableRef", ref: u, data: r.value, "empty-text": "暂无数据", "max-height": n(_), "row-key": "id", style: { width: "100%" }, "data-format": y.value, "show-summary": "", "summary-method": f }, { default: d(() => [e(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(a, { prop: "name", key: "name", label: "工序", align: "center" }), e(a, { prop: "price", key: "price", label: "人工费总额（元）", align: "center" }), e(a, { prop: "mete", key: "mete", label: "累计产量（吨）", align: "center" }), e(a, { prop: "avgPrice", key: "avgPrice", label: "平均单价（元/吨）", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])]);
  };
} }, K = B(z, [["__scopeId", "data-v-8260de75"]]);
export {
  K as default
};
