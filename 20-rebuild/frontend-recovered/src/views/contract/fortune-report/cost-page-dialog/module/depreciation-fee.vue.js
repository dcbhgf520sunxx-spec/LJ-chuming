import { ref as m } from "vue";
import { watch as D } from "vue";
import { computed as k } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as o } from "vue";
import { withDirectives as I } from "vue";
import { createVNode as t } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as c } from "vue";
import { unref as l } from "vue";
import { ElTag as C } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { c as B } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as E, t as N, o as R, bV as S, ba as H } from "../../../../../shared/runtime.js";
const O = { class: "app-container" }, q = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, z = { style: { width: "300px" } }, L = { __name: "depreciation-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(p) {
  const r = p, { decimalPrecision: i } = N(), _ = m(), d = m([]), { maxHeight: y } = R({ paginate: true });
  D(() => r.costTypeData.projectId, (a) => {
    g();
  }, { immediate: true, deep: true });
  const f = k(() => [["amount", ["to-thousand", i.value.contract]], ["mete", "to-thousand"], ["avgPrice", ["to-thousand", i.value.contract]]]);
  function h(a) {
    return H(a, { props: [["amount", i.value.contract], "mete"], toThousandFields: ["amount", "mete"] });
  }
  async function g() {
    try {
      const { content: a } = await B({ projectId: r.costTypeData.projectId });
      d.value = a || [];
    } catch (a) {
      console.log("折旧费用", a);
    }
  }
  return (a, M) => {
    const v = u("print-table"), b = C, s = V, w = u("common-table"), x = T("permission");
    return j(), F("div", O, [o("div", q, [o("div", z, [I(t(v, { "api-key": "depreciationFee", params: { projectId: r.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[x, p.permission.print]])]), t(b, null, { default: n(() => {
      var e;
      return [P("合计（单位：元）：" + c(l(S)((e = r.costTypeData) == null ? void 0 : e.amount, l(i).contract)), 1)];
    }), _: 1 })]), t(w, { ref_key: "tableRef", ref: _, data: d.value, "empty-text": "暂无数据", "max-height": l(y), "row-key": "id", style: { width: "100%" }, "data-format": f.value, "show-summary": "", "summary-method": h }, { default: n(() => [t(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(s, { prop: "type", key: "type", label: "类别", align: "center" }, { default: n((e) => [o("span", null, c(e.row.type), 1)]), _: 1 }), t(s, { prop: "amount", key: "amount", label: "摊销总额（元）", align: "center" }, { default: n((e) => [o("span", null, c(e.row.amount), 1)]), _: 1 }), t(s, { prop: "mete", key: "mete", label: "累计产量（吨）", align: "center" }, { default: n((e) => [o("span", null, c(e.row.mete), 1)]), _: 1 }), t(s, { prop: "avgPrice", key: "avgPrice", label: "平均单价（元/吨）", align: "center" }, { default: n((e) => [o("span", null, c(e.row.avgPrice), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])]);
  };
} }, K = E(L, [["__scopeId", "data-v-d4269970"]]);
export {
  K as default
};
