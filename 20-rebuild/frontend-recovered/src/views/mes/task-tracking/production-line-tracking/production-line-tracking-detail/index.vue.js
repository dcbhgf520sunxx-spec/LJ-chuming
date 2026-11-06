import { ref as g } from "vue";
import { watch as D } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as d } from "vue";
import { createBlock as T } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { withKeys as F } from "vue";
import { withModifiers as x } from "vue";
import { createTextVNode as I } from "vue";
import { withDirectives as J } from "vue";
import { createElementVNode as Y } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as L } from "vue";
import { createElementBlock as b } from "vue";
import { isRef as Z } from "vue";
import { ElInput as X } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElPagination as te } from "element-plus";
import { l as S, u as ae, J as oe, o as le, bb as ne, bZ as re, ng as ie, oo as se, z as ue, a3 as N, cg as w } from "../../../../../shared/runtime.js";
function de(s) {
  return S({ module: "mes", url: "task/tracking/productionLine", method: "get", params: s });
}
function pe(s) {
  return S({ module: "mes", url: "task/tracking/productionLine/detail/page", method: "get", params: s });
}
const be = { get: de }, ce = { key: 0 }, me = { key: 1, style: { color: "red" } }, fe = { key: 0, style: { color: "red" } }, ge = { key: 1 }, ye = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: j }) {
  const z = j, V = g([]), u = g(), p = g(), c = g(), f = g(), n = s;
  D(() => u.value, (m) => {
    i();
  }), D(() => p.value, (m) => {
    i();
  }), D(() => c.value, (m) => {
    i();
  });
  const { visible: v, handleClose: E } = ae({ emit: z, props: n, field: "visible", showHook: i }), { handleSizeChange: B, handleCurrentChange: M, total: P, setTotalPage: R, queryPage: _ } = oe({ fetchHook: i }), { maxHeight: W } = le({ mainBox: ".production-line-tracking-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, v);
  async function i() {
    let m = [];
    try {
      const { content: a = [], totalElements: k } = await pe({ productionLineId: n.detailData.id, taskType: n.detailData.productType, startTime: n.detailData.startDate, endTime: n.detailData.endDate, projectId: u.value, monomerId: p.value, areaId: c.value, serialNumber: f.value, ..._ });
      R(k), m = a;
    } catch (a) {
      console.log("获取产线跟踪详情失败", a);
    } finally {
      V.value = m;
    }
  }
  function A() {
    i();
  }
  function U() {
    p.value = void 0, c.value = void 0, u.value = void 0, f.value = void 0, i();
  }
  function H() {
    i();
  }
  return (m, a) => {
    const k = X, C = h("common-button"), Q = h("print-table"), l = ee, O = h("common-table"), q = te, G = h("common-drawer"), K = $("permission");
    return d(), T(G, { ref: "drawerRef", "custom-class": "production-line-tracking-drawer", title: `产线：${s.detailData.workShopName}>${s.detailData.name}`, modelValue: o(v), "onUpdate:modelValue": a[4] || (a[4] = (e) => Z(v) ? v.value = e : null), direction: "rtl", "before-close": o(E), size: "100%" }, { titleAfter: r(() => [t(ne, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => u.value = e), clearable: "", class: "filter-item", style: { width: "300px" } }, null, 8, ["modelValue"]), t(o(re), { monomerId: p.value, "onUpdate:monomerId": a[1] || (a[1] = (e) => p.value = e), areaId: c.value, "onUpdate:areaId": a[2] || (a[2] = (e) => c.value = e), productType: o(ie).STRUCTURE.V, needConvert: "", clearable: "", "project-id": u.value }, null, 8, ["monomerId", "areaId", "productType", "project-id"]), t(k, { modelValue: f.value, "onUpdate:modelValue": a[3] || (a[3] = (e) => f.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: F(H, ["enter"]) }, null, 8, ["modelValue"]), t(C, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: x(A, ["stop"]) }, { default: r(() => a[5] || (a[5] = [I("搜索")])), _: 1, __: [5] }), t(C, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: x(U, ["stop"]) }, { default: r(() => a[6] || (a[6] = [I(" 重置 ")])), _: 1, __: [6] })]), titleRight: r(() => [J(t(Q, { "api-key": "mesProductionLineList", params: { productionLineId: n.detailData.id, taskType: n.detailData.productType, startTime: n.detailData.startDate, endTime: n.detailData.endDate, projectId: u.value, monomerId: p.value, areaId: c.value, serialNumber: f.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[K, o(se).print]])]), content: r(() => [t(O, { ref: "tableRef", "max-height": o(W), data: V.value, "return-source-data": "", style: { width: "100%" } }, { default: r(() => [t(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "180" }, { default: r((e) => [Y("span", null, y(o(ue)(e.row.project)), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", "min-width": "120", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "任务数", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "netWeight", key: "netWeight", label: "单净重", align: "center" }), n.detailData.productType !== o(N).ASSEMBLE.V ? (d(), T(l, { "show-overflow-tooltip": true, prop: "grossWeight", key: "grossWeight", label: "单毛重", align: "center" })) : L("", true), t(l, { "show-overflow-tooltip": true, prop: "totalNetWeight", key: "totalNetWeight", label: "总净重", align: "center" }), n.detailData.productType !== o(N).ASSEMBLE.V ? (d(), T(l, { "show-overflow-tooltip": true, prop: "totalGrossWeight", key: "totalGrossWeight", label: "总毛重", align: "center" })) : L("", true), t(l, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: r(({ row: e }) => [e.status === o(w).NORMAL.V ? (d(), b("span", ce, y(e.completeQuantity), 1)) : (d(), b("span", me, y(e.completeQuantity), 1))]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "status", label: "状态", align: "center", sortable: "" }, { default: r(({ row: e }) => [e.status === o(w).DELAY.V ? (d(), b("span", fe, y(o(w).VL[e.status]), 1)) : (d(), b("span", ge, y(o(w).VL[e.status]), 1))]), _: 1 })]), _: 1 }, 8, ["max-height", "data"]), t(q, { total: o(P), "current-page": o(_).pageNumber, "page-size": o(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(B), onCurrentChange: o(M) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, we = Object.freeze(Object.defineProperty({ __proto__: null, default: ye }, Symbol.toStringTag, { value: "Module" }));
export {
  ye as _,
  be as c,
  we as i
};
