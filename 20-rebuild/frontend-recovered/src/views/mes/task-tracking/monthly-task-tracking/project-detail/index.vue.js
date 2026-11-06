import { ref as m } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as H } from "vue";
import { createBlock as W } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { withKeys as q } from "vue";
import { withModifiers as x } from "vue";
import { createTextVNode as C } from "vue";
import { withDirectives as A } from "vue";
import { toDisplayString as K } from "vue";
import { isRef as F } from "vue";
import { ElInput as G } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElPagination as L } from "element-plus";
import { l as v, o as Z, u as X, J as Y, bZ as $, ng as ee, rO as te, z as oe } from "../../../../../shared/runtime.js";
function ae(r) {
  return v({ module: "mes", url: "task/tracking/month", method: "get", params: r });
}
function pe(r) {
  return v({ module: "mes", url: "task/tracking/month/page", method: "get", params: r });
}
function le(r) {
  return v({ module: "mes", url: "task/tracking/month/project/page", method: "get", params: r });
}
const ue = { get: ae }, ne = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, re = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, dateTime: { type: String, default: "" }, paramsQuery: { type: Object } }, emits: ["update:visible"], setup(r, { emit: T }) {
  const k = T, y = m([]), i = m(), s = m(), p = m(), n = r, { maxHeight: I } = Z({ extraBox: [".head-container"], paginate: true }), { visible: f, handleClose: z } = X({ emit: k, props: n, field: "visible", showHook: u }), { handleSizeChange: D, handleCurrentChange: S, total: V, setTotalPage: N, queryPage: h } = Y({ fetchHook: u });
  async function u() {
    let w = [];
    try {
      const { content: t = [], totalElements: b } = await le({ projectId: n.detailData.project.id, monomerId: i.value, areaId: s.value, serialNumber: p.value, dateTime: new Date(n.dateTime).getTime(), ...n.paramsQuery, ...h });
      N(b), w = t;
    } catch (t) {
      console.log("获取项目详情失败", t);
    } finally {
      y.value = w;
    }
  }
  function P() {
    u();
  }
  function M() {
    i.value = void 0, s.value = void 0, p.value = void 0, u();
  }
  function _() {
    u();
  }
  return (w, t) => {
    const b = G, j = d("common-button"), E = d("print-table"), o = J, Q = d("common-table"), R = L, U = d("common-drawer"), B = O("permission");
    return H(), W(U, { ref: "drawerRef", modelValue: a(f), "onUpdate:modelValue": t[3] || (t[3] = (l) => F(f) ? f.value = l : null), direction: "rtl", size: "80%", title: "项目详情", "before-close": a(z), "show-close": true, "close-on-click-modal": false, top: "10vh" }, { content: c(() => [g("div", ne, [g("div", null, [e(a($), { monomerId: i.value, "onUpdate:monomerId": t[0] || (t[0] = (l) => i.value = l), areaId: s.value, "onUpdate:areaId": t[1] || (t[1] = (l) => s.value = l), needConvert: "", clearable: "", default: false, productType: a(ee).STRUCTURE.V, "project-id": n.detailData.project.id, onChange: _ }, null, 8, ["monomerId", "areaId", "productType", "project-id"]), e(b, { modelValue: p.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => p.value = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: q(_, ["enter"]) }, null, 8, ["modelValue"]), e(j, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: x(P, ["stop"]) }, { default: c(() => t[4] || (t[4] = [C("搜索")])), _: 1, __: [4] }), e(j, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: x(M, ["stop"]) }, { default: c(() => t[5] || (t[5] = [C(" 重置 ")])), _: 1, __: [5] })]), g("div", null, [A(e(E, { "api-key": "mesMonthlyTaskList", params: { projectId: n.detailData.project.id, monomerId: i.value, dateTime: new Date(n.dateTime).getTime(), areaId: s.value, serialNumber: p.value, ...n.paramsQuery }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[B, a(te).print]])])]), e(Q, { ref: "tableRef", data: y.value, "return-source-data": "", "max-height": a(I) + 30, "highlight-current-row": "", showEmptySymbol: false, style: { width: "100%" } }, { default: c(() => [e(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "150" }, { default: c((l) => [g("span", null, K(a(oe)(l.row.project)), 1)]), _: 1 }), e(o, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center", width: "160px" }), e(o, { "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", width: "150px" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "单净重", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "grossWeight", label: "单毛重", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "排产数", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "完成数", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "completeNetWeight", label: "完成净重", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "completeGrossWeight", label: "完成毛重", align: "center" })]), _: 1 }, 8, ["data", "max-height"]), e(R, { total: a(V), "current-page": a(h).pageNumber, "page-size": a(h).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(D), onCurrentChange: a(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = Object.freeze(Object.defineProperty({ __proto__: null, default: re }, Symbol.toStringTag, { value: "Module" }));
export {
  re as _,
  ue as c,
  ce as i,
  pe as m
};
