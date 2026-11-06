import { ref as _ } from "vue";
import { watch as T } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as a } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as d } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as H } from "vue";
import { unref as c } from "vue";
import { ElTag as V } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { ElPagination as P } from "element-plus";
import { vLoading as B } from "element-plus";
import { l as C, J as I, ba as U } from "../../../../../shared/runtime.js";
function L(e) {
  return C({ module: "project", url: "receiving/receivedInstallStore/summary", method: "get", params: e });
}
function M(e) {
  return C({ module: "project", url: "receiving/receivedInstallStore/details", method: "get", params: e });
}
const Q = { get: L }, A = ["maxHeight"], J = { key: 1 }, R = { class: "head-container" }, F = { __name: "detail", props: { maxHeight: { type: [String, Number], default: void 0 }, showType: { type: String, default: "" }, detailData: { type: Object, default: () => {
} }, queryVO: { type: Object, default: () => {
} } }, setup(e) {
  const n = e, v = _([]), p = _(false), { handleSizeChange: S, handleCurrentChange: z, total: j, setTotalPage: D, queryPage: m } = I({ fetchHook: g });
  T(() => n.showType, (o) => {
    o && g();
  }, { immediate: true }), T(() => {
    var o;
    return (o = n.detailData) == null ? void 0 : o.date;
  }, (o) => {
    o && g();
  }, { immediate: true });
  async function g() {
    var h, l, t, u;
    let o = [];
    if ((h = n.detailData) != null && h.date) try {
      p.value = true;
      const { content: i = [], totalElements: y } = await M({ productType: (l = n.queryVO) == null ? void 0 : l.productType, projectId: (t = n.queryVO) == null ? void 0 : t.projectId, yearMonth: (u = n.detailData) == null ? void 0 : u.date, storeType: n.showType === "begin" ? 1 : n.showType === "inbound" ? 2 : n.showType === "outbound" ? 3 : n.showType === "end" ? 4 : void 0, ...m });
      o = i, D(y);
    } catch (i) {
      console.log(i, "获取详情数据失败");
    } finally {
      p.value = false, v.value = o;
    }
  }
  function q(o) {
    return U(o, { props: ["quantity", "mete"] });
  }
  return (o, h) => {
    const l = V, t = E, u = N("common-table"), i = P, y = B;
    return e.showType ? (w(), k("div", J, [b("div", R, [a(l, { type: "primary", size: "default", class: "filter-item" }, { default: s(() => [x(d(e.detailData.date), 1)]), _: 1 }), a(l, { type: "warning", size: "default", class: "filter-item" }, { default: s(() => [x(d(e.showType === "begin" ? "期初库存" : e.showType === "inbound" ? "入库量" : e.showType === "outbound" ? "出库量" : e.showType === "end" ? "期末库存" : ""), 1)]), _: 1 })]), O((w(), H(u, { ref: "tableRef", data: v.value, "empty-text": "暂无数据", "max-height": e.maxHeight, stripe: false, "show-summary": "", "summary-method": q, "row-key": "id", style: { width: "100%" } }, { default: s(() => [a(t, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), a(t, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: s(({ row: f }) => {
      var r;
      return [b("span", null, d(((r = f.monomer) == null ? void 0 : r.name) || "-"), 1)];
    }), _: 1 }), a(t, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: s(({ row: f }) => {
      var r;
      return [b("span", null, d(((r = f.area) == null ? void 0 : r.name) || "-"), 1)];
    }), _: 1 }), a(t, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), a(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), a(t, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120" }), a(t, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": true, width: "90" }), a(t, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true }), a(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": true, width: "90" }), a(t, { key: "mete", prop: "mete", label: "核算量", align: "center", "show-overflow-tooltip": true })]), _: 1 }, 8, ["data", "max-height"])), [[y, p.value]]), a(i, { total: c(j), "current-page": c(m).pageNumber, "page-size": c(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: c(S), onCurrentChange: c(z) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])) : (w(), k("div", { key: 0, style: { flex: "1", width: "61%" }, maxHeight: e.maxHeight, class: "red-tip" }, "*点击左侧蓝色字体展示详情", 8, A));
  };
} }, W = Object.freeze(Object.defineProperty({ __proto__: null, default: F }, Symbol.toStringTag, { value: "Module" }));
export {
  F as _,
  Q as c,
  W as d
};
