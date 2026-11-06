import { ref as b } from "vue";
import { computed as S } from "vue";
import { watch as F } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as B } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as l } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElPagination as R } from "element-plus";
import { g as U } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as q, J, t as G, o as K, am as Q, jp as w, cO as W, bV as x, p as X, ba as Y } from "../../../../../shared/runtime.js";
const Z = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, $ = { style: { width: "300px" } }, ee = { __name: "main-material-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(g) {
  const { handleSizeChange: C, handleCurrentChange: k, total: v, setTotalPage: T, queryPage: m } = J({ fetchHook: _ }), { decimalPrecision: c } = G(), u = g, M = b(), p = b([]), { maxHeight: P } = K({ extraBox: [".head-container"], paginate: true }), j = S(() => [["basicClass", ["parse-enum", Q, { bit: true }]], ["avgPrice", ["to-thousand", c.value.contract]]]);
  F(() => u.costTypeData.projectId, (r) => {
    _();
  }, { immediate: true, deep: true });
  function D(r) {
    return Y(r, { props: ["mete", ["amount", c.value.contract]], toThousandFields: ["mete", "amount"] });
  }
  async function _() {
    try {
      const { content: r = [], totalElements: h } = await U({ basicClassEnum: w.MAIN.V, projectId: u.costTypeData.projectId, ...m });
      T(h), r.forEach((n) => {
        n.unitPrice = n.mete ? n.amount / n.mete : 0;
      }), p.value = r.map((n, d) => (n.rowId = d + "" + Math.random(), n)), console.log(p.value, "value"), await W(p.value);
    } catch (r) {
      console.log("主材费用", r);
    }
  }
  return (r, h) => {
    const n = f("print-table"), d = L, o = O, E = f("common-table"), I = R, z = N("permission");
    return V(), A("div", null, [s("div", Z, [s("div", $, [B(t(n, { "api-key": "conMainMaterialList", params: { basicClassEnum: a(w).MAIN.V, projectId: u.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[z, g.permission.print]])]), t(d, null, { default: i(() => {
      var e;
      return [H("合计（单位：元）：" + l(a(x)((e = u.costTypeData) == null ? void 0 : e.amount, a(c).contract)), 1)];
    }), _: 1 })]), t(E, { ref_key: "tableRef", ref: M, data: p.value, "empty-text": "暂无数据", "max-height": a(P) + 60, "row-key": "id", style: { width: "100%" }, "data-format": j.value, "show-summary": "", "summary-method": D }, { default: i(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { prop: "basicClass", key: "basicClass", label: "物料种类", align: "center" }), t(o, { prop: "thickness", key: "thickness", label: "厚度", align: "center" }, { default: i((e) => [s("span", null, l(e.row.thickness), 1)]), _: 1 }), t(o, { prop: "specMerge", key: "specMerge", label: "规格", align: "center", width: "160" }, { default: i((e) => [s("span", null, l(e.row.specMerge), 1)]), _: 1 }), t(o, { prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }, { default: i((e) => [s("span", null, l(e.row.accountingUnit), 1)]), _: 1 }), t(o, { prop: "mete", key: "mete", label: "核算量", align: "center" }, { default: i((e) => [s("span", null, l(e.row.mete), 1)]), _: 1 }), t(o, { prop: "unitPrice", key: "unitPrice", label: "单价", align: "center" }, { default: i((e) => {
      var y;
      return [s("span", null, l((y = e.row.unitPrice) == null ? void 0 : y.toFixed(a(c).contract)), 1)];
    }), _: 1 }), t(o, { prop: "amount", key: "amount", label: "总价", align: "center" }, { default: i((e) => [s("span", null, l(e.row.amount ? a(x)(e.row.amount, a(c).contract) : "月末未加权"), 1)]), _: 1 }), t(o, { prop: "outboundTime", key: "outboundTime", label: "出库日期", align: "center", width: "140" }, { default: i((e) => [s("span", null, l(e.row.outboundTime ? a(X)(e.row.outboundTime) : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"]), t(I, { total: a(v), "current-page": a(m).pageNumber, "page-size": a(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(C), onCurrentChange: a(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} }, oe = q(ee, [["__scopeId", "data-v-b6763241"]]);
export {
  oe as default
};
