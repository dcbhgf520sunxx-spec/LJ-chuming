import { ref as d } from "vue";
import { inject as J } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as U } from "vue";
import { createBlock as V } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as z } from "vue";
import { isRef as K } from "vue";
import { ElTag as W } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElPagination as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { g as ee } from "../../../../../modules/product-statistics-2cabaaff.js";
import { nz as b, u as te, J as ae, am as oe, o as ne, cO as le, jl as se, p as C } from "../../../../../shared/runtime.js";
const ie = { class: "head-drawer", style: { display: "flex", "justify-content": "space-between", "margin-bottom": "8px" } }, ce = { __name: "month-raw-material-outbound", props: { visible: { type: Boolean, default: false }, info: { type: Object }, timeQuery: { type: Object } }, emits: ["update:visible"], setup(u, { emit: O }) {
  const x = d(), p = d(b.OUTBOUND.V), k = O, w = u, j = J("permission"), { visible: v, handleClose: D } = te({ emit: k, props: w, field: "visible", showHook: h }), { handleSizeChange: N, handleCurrentChange: S, total: E, setTotalPage: H, queryPage: _ } = ae({ fetchHook: h }), L = d([["basicClass", ["parse-enum", oe, { bit: true }]]]), { maxHeight: M } = ne({ extraBox: [".el-drawer__header", ".head-drawer"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, x), y = d(false), c = d([]), B = $(() => {
    var r;
    return { projectId: (r = w.info.project) == null ? void 0 : r.id, type: p.value, ...w.timeQuery };
  });
  async function h() {
    try {
      c.value = [], y.value = true;
      const { content: r = [], totalElements: n } = await ee({ ...B.value, ..._ });
      H(n), c.value = r.map((f) => f), await le(c.value), await se(c.value, { toSmallest: false, accountingUnit: "kg" });
    } catch (r) {
      console.log("获取当月出库记录详情失败", r);
    } finally {
      y.value = false;
    }
  }
  return (r, n) => {
    const f = W, R = g("common-radio-button"), q = g("print-table"), i = X, P = g("common-table"), Q = Y, I = g("common-drawer"), F = G("permission"), A = Z;
    return U(), V(I, { ref_key: "drawerRef", ref: x, title: "当月出库记录", modelValue: t(v), "onUpdate:modelValue": n[1] || (n[1] = (e) => K(v) ? v.value = e : null), direction: "rtl", "before-close": t(D), size: "70%" }, { titleAfter: o(() => [a(f, { size: "default", effect: "plain" }, { default: o(() => {
      var e, m;
      return [n[2] || (n[2] = T(" 项目：")), l("span", null, s((e = u.info.project) == null ? void 0 : e.serialNumber) + "-" + s((m = u.info.project) == null ? void 0 : m.name), 1)];
    }), _: 1, __: [2] }), a(f, { size: "default", type: "warning", effect: "plain" }, { default: o(() => {
      var e, m;
      return [n[3] || (n[3] = T(" 统计日期：")), l("span", null, s(t(C)((e = u.timeQuery) == null ? void 0 : e.startDate, "{y}-{m}-{d}")) + "~" + s(t(C)((m = u.timeQuery) == null ? void 0 : m.endDate, "{y}-{m}-{d}")), 1)];
    }), _: 1, __: [3] })]), content: o(() => [l("div", ie, [a(R, { modelValue: p.value, "onUpdate:modelValue": n[0] || (n[0] = (e) => p.value = e), options: t(b).ENUM, class: "filter-item", type: "enum", onChange: h }, null, 8, ["modelValue", "options"]), l("div", null, [z(a(q, { "api-key": p.value === t(b).OUTBOUND.V ? "mesOutBoundStatisticsList" : "mesBackBoundStatisticsList", params: { ...B.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[F, t(j).print]])])]), z((U(), V(P, { data: c.value, "data-format": L.value, "max-height": t(M), style: { width: "100%" } }, { default: o(() => [a(i, { label: "序号", type: "index", align: "center", width: "60" }), a(i, { prop: "basicClass", "show-overflow-tooltip": true, label: "物料种类", width: "150" }), a(i, { "show-overflow-tooltip": true, key: "specMerge", prop: "specMerge", label: "规格", align: "center" }, { default: o((e) => [l("span", null, s(e.row.specMerge), 1)]), _: 1 }), a(i, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }, { default: o(({ row: e }) => [l("span", null, s(e.measureUnit), 1)]), _: 1 }), a(i, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }, { default: o(({ row: e }) => [l("span", null, s(e.quantity), 1)]), _: 1 }), a(i, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位", width: "120" }, { default: o(({ row: e }) => [l("span", null, s(e.accountingUnit), 1)]), _: 1 }), a(i, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量", width: "100" }, { default: o(({ row: e }) => [l("span", null, s(e.mete), 1)]), _: 1 }), a(i, { "show-overflow-tooltip": true, align: "center", prop: "outboundTime", label: `${p.value === t(b).OUTBOUND.V ? "出库" : "退库"}日期`, width: "120" }, { default: o(({ row: e }) => [l("span", null, s(t(C)(e.outboundTime, "{y}-{m}-{d}")), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[A, y.value]]), a(Q, { total: t(E), "current-page": t(_).pageNumber, "page-size": t(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(N), onCurrentChange: t(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ce as default
};
