import { ref as y } from "vue";
import { watch as T } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as I } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as r } from "vue";
import { unref as o } from "vue";
import { ElTag as C } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { b as B } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as N, t as R, o as S, bV as m, ba as H } from "../../../../../shared/runtime.js";
const O = { class: "app-container" }, W = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, q = { style: { width: "300px" } }, z = { __name: "water-electric-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(d) {
  const { decimalPrecision: l } = R(), i = d, h = y(), u = y([]), { maxHeight: b } = S({ paginate: true });
  T(() => {
    var t;
    return (t = i.costTypeData) == null ? void 0 : t.projectId;
  }, (t) => {
    g();
  }, { immediate: true, deep: true });
  async function g() {
    var t;
    try {
      const { content: p } = await B({ projectId: (t = i.costTypeData) == null ? void 0 : t.projectId });
      u.value = p || [];
    } catch (p) {
      console.log("获取水电费失败", p);
    }
  }
  function w(t) {
    return H(t, { props: [["amount", l.value.contract], "mete"], toThousandFields: ["amount", "mete"] });
  }
  return (t, p) => {
    const v = f("print-table"), x = C, s = V, k = f("common-table"), D = j("permission");
    return E(), F("div", O, [c("div", W, [c("div", q, [I(a(v, { "api-key": "waterElectricFee", params: { projectId: i.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[D, d.permission.print]])]), a(x, null, { default: n(() => {
      var e;
      return [P("合计（单位：元）：" + r(o(m)((e = i.costTypeData) == null ? void 0 : e.amount, o(l).contract)), 1)];
    }), _: 1 })]), a(k, { ref_key: "tableRef", ref: h, data: u.value, "empty-text": "暂无数据", "max-height": o(b), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": w }, { default: n(() => [a(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(s, { prop: "type", key: "type", label: "类别", align: "center" }, { default: n((e) => [c("span", null, r(e.row.type), 1)]), _: 1 }), a(s, { prop: "amount", key: "amount", label: "摊销总额（元）", align: "center" }, { default: n((e) => [c("span", null, r(o(m)(e.row.amount, o(l).contract)), 1)]), _: 1 }), a(s, { prop: "mete", key: "mete", label: "累计产量（吨）", align: "center" }, { default: n((e) => [c("span", null, r(o(m)(e.row.mete, 2)), 1)]), _: 1 }), a(s, { prop: "avgPrice", key: "avgPrice", label: "平均单价（元/吨）", align: "center" }, { default: n((e) => {
      var _;
      return [c("span", null, r((_ = e.row.avgPrice) == null ? void 0 : _.toFixed(o(l).contract)), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]);
  };
} }, G = N(z, [["__scopeId", "data-v-5367410c"]]);
export {
  G as default
};
