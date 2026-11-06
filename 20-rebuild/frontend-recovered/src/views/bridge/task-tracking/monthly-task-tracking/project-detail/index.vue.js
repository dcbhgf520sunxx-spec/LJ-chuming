import { ref as d } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as O } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { withKeys as A } from "vue";
import { withModifiers as x } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as K } from "vue";
import { toDisplayString as F } from "vue";
import { isRef as J } from "vue";
import { ElInput as L } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as Z } from "element-plus";
import { l as v, o as G, u as X, J as Y, bZ as $, z as ee } from "../../../../../shared/runtime.js";
import { H as te } from "../../../../../modules/bridge-86f96a4f.js";
function oe(n) {
  return v({ module: "bridge", url: "task/tracking/month", method: "get", params: n });
}
function pe(n) {
  return v({ module: "bridge", url: "task/tracking/month/page", method: "get", params: n });
}
function ae(n) {
  return v({ module: "bridge", url: "task/tracking/month/project/page", method: "get", params: n });
}
const ue = { get: oe }, le = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, ne = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(n, { emit: k }) {
  const I = k, _ = d([]), r = d(), i = d(), s = d(), c = n, { maxHeight: z } = G({ extraBox: [".head-container"], paginate: true }), { visible: g, handleClose: D } = X({ emit: I, props: c, field: "visible", showHook: p }), { handleSizeChange: V, handleCurrentChange: N, total: S, setTotalPage: M, queryPage: h } = Y({ fetchHook: p });
  async function p() {
    let b = [];
    try {
      const { content: t = [], totalElements: w } = await ae({ projectId: c.detailData.project.id, monomerId: r.value, areaId: i.value, serialNumber: s.value, ...h });
      M(w), b = t;
    } catch (t) {
      console.log("获取项目详情失败", t);
    } finally {
      _.value = b;
    }
  }
  function P() {
    p();
  }
  function T() {
    r.value = void 0, i.value = void 0, s.value = void 0, p();
  }
  function y() {
    p();
  }
  return (b, t) => {
    const w = L, j = m("common-button"), B = m("print-table"), o = W, E = m("common-table"), H = Z, R = m("common-drawer"), U = q("permission");
    return O(), Q(R, { ref: "drawerRef", modelValue: a(g), "onUpdate:modelValue": t[3] || (t[3] = (l) => J(g) ? g.value = l : null), direction: "rtl", size: "80%", title: "项目详情", "before-close": a(D), "show-close": true, "close-on-click-modal": false, top: "10vh" }, { content: u(() => [f("div", le, [f("div", null, [e(a($), { monomerId: r.value, "onUpdate:monomerId": t[0] || (t[0] = (l) => r.value = l), areaId: i.value, "onUpdate:areaId": t[1] || (t[1] = (l) => i.value = l), needConvert: "", clearable: "", default: false, "project-id": c.detailData.project.id, onChange: y }, null, 8, ["monomerId", "areaId", "project-id"]), e(w, { modelValue: s.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => s.value = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: A(y, ["enter"]) }, null, 8, ["modelValue"]), e(j, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: x(P, ["stop"]) }, { default: u(() => t[4] || (t[4] = [C("搜索")])), _: 1, __: [4] }), e(j, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: x(T, ["stop"]) }, { default: u(() => t[5] || (t[5] = [C(" 重置 ")])), _: 1, __: [5] })]), f("div", null, [K(e(B, { "api-key": "bridgeMonthlyTaskList", params: { projectId: c.detailData.project.id, monomerId: r.value, areaId: i.value, serialNumber: s.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[U, a(te).print]])])]), e(E, { ref: "tableRef", data: _.value, "return-source-data": "", "max-height": a(z) + 30, "highlight-current-row": "", showEmptySymbol: false, style: { width: "100%" } }, { default: u(() => [e(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "150" }, { default: u((l) => [f("span", null, F(a(ee)(l.row.project)), 1)]), _: 1 }), e(o, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center", width: "160px" }), e(o, { "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", width: "150px" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "单重", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "排产数", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "完成数", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "completeMete", label: "完成量", align: "center" })]), _: 1 }, 8, ["data", "max-height"]), e(H, { total: a(S), "current-page": a(h).pageNumber, "page-size": a(h).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(V), onCurrentChange: a(N) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = Object.freeze(Object.defineProperty({ __proto__: null, default: ne }, Symbol.toStringTag, { value: "Module" }));
export {
  ne as _,
  ue as c,
  ce as i,
  pe as m
};
