import { useStore as x } from "vuex";
import { ref as m } from "vue";
import { watch as C } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as s } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as p } from "vue";
import { toDisplayString as P } from "vue";
import { Fragment as U } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as L, yb as u, x as B, y6 as F, yf as V, o as M, cO as j, jl as Y, ux as q, P as H } from "../../../../../../shared/runtime.js";
import G from "./module/header.vue.js";
const Q = { key: 0 }, $ = { key: 1 }, J = { __name: "index", emits: ["click-line"], setup(K, { expose: y, emit: N }) {
  const T = x(), w = N, R = { add: false, edit: false, del: false, download: false }, _ = m(), b = m(), g = m([["project", ["parse-project", { onlyShortName: true }]], ["projectFullName", "parse-project", { source: "project" }], ["frozenTime", ["parse-time", "{y}-{m}-{d}"]], ["freezeTypeName", ["parse-enum", u], ["suffix", "冻结"], { source: "freezeType" }]]), { CRUD: O, crud: o, columns: i } = B({ title: "钢材物料仓", sort: [], permission: { ...F }, optShow: { ...R }, crudApi: { ...V } }, _), { maxHeight: S } = M({ paginate: true });
  O.HOOK.handleRefresh = async (a, { data: n }) => {
    await j(n.content), n.content = await Y(n.content, { toSmallest: false, toNum: false });
  };
  function v(a) {
    a && w("click-line", a);
  }
  return C(() => T.state.approval_list.isRefresh, (a) => {
    a && o.toQuery();
  }, { deep: true }), y({ query: o.query }), (a, n) => {
    const r = D, E = z("common-table"), k = I;
    return t(), f(U, null, [c(e(G), { ref_key: "headerRef", ref: b }, null, 512), A((t(), s(E, { key: `material_freeze_${e(o).query.basicClass}`, ref_key: "tableRef", ref: _, data: e(o).data, "data-format": g.value, "max-height": e(S), "highlight-current-row": "", "row-key": "idList", onRowClick: v }, { default: h(() => [c(r, { align: "center", label: "序号", type: "index", width: "60" }), e(i).visible("frozenTime") ? (t(), s(r, { key: "frozenTime", "show-overflow-tooltip": true, align: "left", label: "冻结日期", "min-width": "100", prop: "frozenTime" })) : p("", true), e(i).visible("freezeTypeName") ? (t(), s(r, { key: "freezeTypeName", "show-overflow-tooltip": true, align: "left", label: "类型", "min-width": "100", prop: "freezeTypeName" })) : p("", true), e(i).visible("receipt") ? (t(), s(r, { key: "receipt", "show-overflow-tooltip": true, align: "center", label: "单据编号", "min-width": "120", prop: "receipt" }, { default: h(({ row: l }) => {
      var d;
      return [l.freezeType !== e(u).MES_OUTBOUND_APPLY.V && l.freezeType !== e(u).NESTING.V ? (t(), f("div", Q, [c(q, { receipt: l.receipt, "receipt-types": ["REQUISITIONS", "PREPARATION", "OUTBOUND_APPLY", "TRANSFER", "REJECTED", "CONVERT", "OUTBOUND", "FOR_SALE", "TEMPORARY_LOAN", "OUTSOURCE", "SCRAPS", "INVENTORY_LOSS", "MOVING_INVENTORY"] }, null, 8, ["receipt"])])) : (t(), f("span", $, P(((d = l.receipt) == null ? void 0 : d.serialNumber) || "-"), 1))];
    }), _: 1 })) : p("", true), e(i).visible("operatorName") ? (t(), s(r, { key: "operatorName", "show-overflow-tooltip": true, align: "left", label: "冻结人", "min-width": "100", prop: "operatorName" })) : p("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[k, e(o).loading]]), c(e(H))], 64);
  };
} }, ee = L(J, [["__scopeId", "data-v-c21fde5b"]]);
export {
  ee as default
};
