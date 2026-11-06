import { ref as f } from "vue";
import { computed as S } from "vue";
import { watch as N } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as V } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as l } from "vue";
import { ElTag as R } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as L } from "element-plus";
import { g as H } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as q, J as O, t as X, o as Y, am as J, jp as b, jl as G, bV as m, p as K, ba as Q } from "../../../../../shared/runtime.js";
const W = { class: "app-container" }, Z = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, $ = { style: { width: "300px" } }, ee = { __name: "auxiliary-material-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(_) {
  const { handleSizeChange: x, handleCurrentChange: w, total: v, setTotalPage: C, queryPage: d } = O({ fetchHook: y }), u = _, { decimalPrecision: r } = X(), T = f(), p = f([]), { maxHeight: k } = Y({ paginate: true }), P = S(() => [["basicClass", ["parse-enum", J, { bit: true }]], ["avgPrice", ["to-thousand", r.value.contract]]]);
  N(() => u.costTypeData.projectId, (n) => {
    y();
  }, { immediate: true, deep: true });
  function j(n) {
    return Q(n, { props: ["mete", ["amount", r.value.contract]], toThousandFields: ["mete", "amount"] });
  }
  async function y() {
    try {
      const { content: n = [], totalElements: g } = await H({ basicClassEnum: b.AUXILIARY.V, projectId: u.costTypeData.projectId, ...d });
      n.map((c) => {
        c.unitPrice = c.amount / c.mete;
      }), p.value = n || [], p.value = await G(p.value, { toSmallest: false, toNum: true }, { mete: ["mete"], amount: ["unitPrice"] }), C(g);
    } catch (n) {
      console.log("辅材费用", n);
    }
  }
  return (n, g) => {
    const c = h("print-table"), D = R, o = U, I = h("common-table"), E = L, z = A("permission");
    return F(), M("div", W, [i("div", Z, [i("div", $, [V(t(c, { "api-key": "auxiliaryMaterialList", params: { basicClassEnum: a(b).AUXILIARY.V, projectId: u.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[z, _.permission.print]])]), t(D, null, { default: s(() => {
      var e;
      return [B("合计（单位：元）：" + l(a(m)((e = u.costTypeData) == null ? void 0 : e.amount, a(r).contract)), 1)];
    }), _: 1 })]), t(I, { ref_key: "tableRef", ref: T, data: p.value, "empty-text": "暂无数据", "max-height": a(k), "row-key": "id", style: { width: "100%" }, "data-format": P.value, "show-summary": "", "summary-method": j }, { default: s(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { prop: "classifyName", key: "classifyName", label: "物料种类", align: "center" }), t(o, { prop: "specification", key: "specification", label: "规格", align: "center" }, { default: s((e) => [i("span", null, l(e.row.specification), 1)]), _: 1 }), t(o, { prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }, { default: s((e) => [i("span", null, l(e.row.accountingUnit), 1)]), _: 1 }), t(o, { prop: "mete", key: "mete", label: "核算量", align: "center" }, { default: s((e) => [i("span", null, l(a(m)(e.row.mete)), 1)]), _: 1 }), t(o, { prop: "unitPrice", key: "unitPrice", label: "单价", align: "center" }, { default: s((e) => [i("span", null, l(a(m)(e.row.unitPrice, a(r).contract)), 1)]), _: 1 }), t(o, { prop: "amount", key: "amount", label: "总价", align: "center" }, { default: s((e) => [i("span", null, l(a(m)(e.row.amount, a(r).contract) || "月末未加权"), 1)]), _: 1 }), t(o, { prop: "outboundTime", key: "outboundTime", label: "出库日期", align: "center" }, { default: s((e) => [i("span", null, l(e.row.outboundTime ? a(K)(e.row.outboundTime) : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"]), t(E, { total: a(v), "current-page": a(d).pageNumber, "page-size": a(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(x), onCurrentChange: a(w) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} }, oe = q(ee, [["__scopeId", "data-v-0366ea95"]]);
export {
  oe as default
};
