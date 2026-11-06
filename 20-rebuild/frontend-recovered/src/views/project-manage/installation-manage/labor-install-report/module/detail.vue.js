import { ref as u } from "vue";
import { watch as D } from "vue";
import h from "moment";
import { resolveComponent as E } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { withCtx as T } from "vue";
import { toDisplayString as k } from "vue";
import { unref as l } from "vue";
import { withDirectives as S } from "vue";
import { vShow as P } from "vue";
import { createBlock as V } from "vue";
import { createCommentVNode as Y } from "vue";
import { normalizeStyle as $ } from "vue";
import { ElTag as K } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as Z } from "element-plus";
import { l as B, J as _, tQ as x, p as v, G as ee } from "../../../../../shared/runtime.js";
function te(e) {
  return B({ module: "project", url: "install-report/supplierInstall/Summary", method: "get", params: e });
}
function ae(e) {
  return B({ module: "project", url: "install-report/supplierInstall/Details", method: "get", params: e });
}
const se = { get: te }, le = { key: 0, class: "red-tip" }, ne = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, oe = { __name: "detail", props: { detailData: { type: Object, default: () => {
} }, isShow: { type: Boolean, default: true }, showType: { type: String, default: "" }, maxHeight: { type: [Number, String], default: void 0 }, projectId: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, setup(e) {
  const Q = u(), U = u(false), r = u(), s = u(), C = u([]), F = u([["createTime", "parse-time"]]), o = e, { handleSizeChange: H, handleCurrentChange: R, total: q, setTotalPage: A, queryPage: w } = _({ fetchHook: y });
  D(() => o.showType, (t) => {
    t === "total" ? (r.value = void 0, s.value = void 0) : t === "last" ? (r.value = h().subtract(1, "months").startOf("month").valueOf(), s.value = h().subtract(1, "months").endOf("month").valueOf()) : t === "current" && (r.value = h().startOf("month").valueOf(), s.value = h().valueOf()), y();
  }, { immediate: true }), D(() => o.isShow, (t) => {
    t && y();
  }, { immediate: true }), D(() => {
    var t;
    return (t = o.detailData) == null ? void 0 : t.productType;
  }, (t) => {
    y();
  });
  async function y() {
    var c, d, f;
    if (!o.projectId || !((c = o.detailData) != null && c.productType)) return;
    let t = [];
    try {
      const { content: a = [], totalElements: b } = await ae({ projectId: o.projectId, supplierId: (d = o.detailData) == null ? void 0 : d.supplierId, productType: (f = o.detailData) == null ? void 0 : f.productType, startDate: r.value, endDate: s.value, ...w });
      t = a, A(b);
    } catch (a) {
      console.log(a, "获取详情数据失败");
    } finally {
      C.value = t;
    }
  }
  return (t, c) => {
    var I, j;
    const d = K, f = E("print-table"), a = W, b = E("common-table"), G = X, J = Z;
    return e.isShow ? (g(), L("div", { key: 1, style: $(`height: ${e.maxHeight / 2}px`) }, [i("div", ne, [i("div", null, [n(d, { type: "primary", size: "default", round: "", style: { "margin-right": "8px" } }, { default: T(() => {
      var p, m;
      return [i("span", null, k((p = e.detailData) != null && p.supplierId ? (m = e.detailData) == null ? void 0 : m.supplierName : "所有劳务单位（" + l(x).VL[e.detailData.productType] + "）"), 1), c[0] || (c[0] = i("span", { style: { margin: "0 10px" } }, "|", -1)), i("span", null, "统计日期： " + k(e.showType === "total" ? "所有" : e.showType === "last" ? l(v)(r.value, "{y}-{m}-{d}") + "~" + l(v)(s.value, "{y}-{m}-{d}") : e.showType === "current" ? l(v)(r.value, "{y}-{m}-{d}") + "~" + l(v)(s.value, "{y}-{m}-{d}") : ""), 1)];
    }), _: 1, __: [0] }), n(d, { type: "warning", size: "default", round: "" }, { default: T(() => {
      var p, m, z, O, N, M;
      return [S(i("span", null, "安装量（件/吨）：", 512), [[P, e.detailData.productType === l(x).ARTIFACT.V]]), S(i("span", null, "安装量（张/米）：", 512), [[P, e.detailData.productType === l(x).ENCLOSURE.V]]), i("span", null, k(e.showType === "total" ? ((p = e.detailData) == null ? void 0 : p.quantity) + "/" + ((m = e.detailData) == null ? void 0 : m.mete) : e.showType === "last" ? ((z = e.detailData) == null ? void 0 : z.lastMonthQuantity) + "/" + ((O = e.detailData) == null ? void 0 : O.lastMonthMete) : e.showType === "current" ? ((N = e.detailData) == null ? void 0 : N.currentMonthQuantity) + "/" + ((M = e.detailData) == null ? void 0 : M.currentMonthMete) : "0/0"), 1)];
    }), _: 1 })]), l(ee)(e.permission.print) ? (g(), V(f, { key: 0, "api-key": "laborInstallList", params: { projectId: o.projectId, supplierId: (I = o.detailData) == null ? void 0 : I.supplierId, productType: (j = o.detailData) == null ? void 0 : j.productType, startDate: r.value, endDate: s.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : Y("", true)]), S((g(), V(b, { ref_key: "tableRef", ref: Q, data: C.value, "empty-text": "暂无数据", "max-height": e.maxHeight / 2 - 75, style: { width: "100%" }, stripe: false, dataFormat: F.value, "show-empty-symbol": false }, { default: T(() => [n(a, { label: "序号", type: "index", align: "center", width: "60" }), n(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center" }), n(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }), n(a, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", align: "center" }), n(a, { key: "measureUnit", prop: "measureUnit", "show-overflow-tooltip": true, label: "计量单位", align: "center" }), n(a, { key: "reportQuantity", prop: "reportQuantity", "show-overflow-tooltip": true, label: "数量", align: "center" }), n(a, { key: "accountingUnit", prop: "accountingUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }), n(a, { key: "reportMete", prop: "reportMete", "show-overflow-tooltip": true, label: "核算量", align: "center" }), n(a, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "安装日期", align: "center" })]), _: 1 }, 8, ["data", "max-height", "dataFormat"])), [[J, U.value]]), n(G, { total: l(q), "current-page": l(w).pageNumber, "page-size": l(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(H), onCurrentChange: l(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 4)) : (g(), L("div", le, "* 点击上方累计、上月、本月数据展示详情"));
  };
} }, ue = Object.freeze(Object.defineProperty({ __proto__: null, default: oe }, Symbol.toStringTag, { value: "Module" }));
export {
  oe as _,
  se as c,
  ue as d
};
