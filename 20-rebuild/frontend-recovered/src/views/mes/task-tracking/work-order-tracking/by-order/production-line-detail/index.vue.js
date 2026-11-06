import { ref as y } from "vue";
import { watch as A } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as te } from "vue";
import { openBlock as v } from "vue";
import { createBlock as V } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as l } from "vue";
import { withKeys as O } from "vue";
import { createCommentVNode as z } from "vue";
import { withModifiers as P } from "vue";
import { createTextVNode as h } from "vue";
import { withDirectives as ae } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as u } from "vue";
import { normalizeStyle as oe } from "vue";
import { createElementBlock as B } from "vue";
import { isRef as le } from "vue";
import { ElInput as re } from "element-plus";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElDescriptions as ie } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElPagination as ue } from "element-plus";
import { l as _, u as de, J as pe, o as ce, bZ as me, ng as fe, a3 as N, rU as ge, p as ye, cg as E } from "../../../../../../shared/runtime.js";
function De(o) {
  return _({ module: "mes", url: "task/order/tracking/artifact/page", method: "get", params: o });
}
function Te(o) {
  return _({ module: "mes", url: "task/order/tracking/machine_part/page", method: "get", params: o });
}
function Ce(o) {
  return _({ module: "mes", url: "task/process/artifact/process", method: "get", params: o });
}
function xe(o) {
  return _({ module: "mes", url: "task/process/artifact/page", method: "get", params: o });
}
function Ve(o) {
  return _({ module: "mes", url: "task/process/machine_part/process", method: "get", params: o });
}
function ve(o) {
  return _({ module: "mes", url: "task/process/product/page", method: "get", params: o });
}
const he = { class: "head-container" }, be = { key: 0, style: { color: "red" } }, _e = { key: 1 }, we = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, projectId: { type: Number }, query: { type: Object } }, emits: ["update:visible"], setup(o, { emit: H }) {
  const M = H, S = y([]), d = y(), p = y(), m = y(), f = y(), R = y(), a = o;
  A([() => d.value, () => p.value, () => R.value], (w) => {
    c();
  }), A(() => a.detailData.id, (w) => {
    R.value = void 0, d.value = void 0, p.value = void 0, m.value = void 0, f.value = void 0, c();
  });
  const { visible: C, handleClose: U } = de({ emit: M, props: a, field: "visible", showHook: c }), { handleSizeChange: F, handleCurrentChange: L, total: Q, setTotalPage: W, queryPage: j } = pe({ fetchHook: c }), { maxHeight: K } = ce({ mainBox: ".common-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 50, minHeight: 300, paginate: true }, C);
  async function c() {
    var r, k, I;
    let w = [];
    try {
      const { content: D = [], totalElements: g } = await ve({ processId: a.detailData.id, taskType: a.detailData.productType, orderId: a.detailData.taskOrderId, groupId: (r = a.detailData.group) == null ? void 0 : r.id, name: m.value, projectId: a.projectId, monomerId: d.value ? d.value : (k = a.query) == null ? void 0 : k.monomerId, areaId: p.value ? p.value : (I = a.query) == null ? void 0 : I.areaId, serialNumber: f.value, ...j });
      W(g), w = D;
    } catch (D) {
      console.log("获取工序详情失败", D);
    } finally {
      S.value = w;
    }
  }
  function $() {
    c();
  }
  function G() {
    d.value = void 0, p.value = void 0, m.value = void 0, f.value = void 0, c();
  }
  function q() {
    c();
  }
  return (w, r) => {
    const k = re, I = x("common-button"), D = x("print-table"), g = ne, J = ie, i = se, Y = x("common-table"), Z = ue, X = x("common-drawer"), ee = te("permission");
    return v(), V(X, { ref: "drawerRef", title: `${o.detailData.name}工序详细清单`, modelValue: l(C), "onUpdate:modelValue": r[4] || (r[4] = (e) => le(C) ? C.value = e : null), direction: "rtl", "before-close": l(U), size: "100%" }, { titleAfter: n(() => [t(l(me), { monomerId: d.value, "onUpdate:monomerId": r[0] || (r[0] = (e) => d.value = e), areaId: p.value, "onUpdate:areaId": r[1] || (r[1] = (e) => p.value = e), needConvert: "", clearable: "", areaClearable: "", productType: l(fe).STRUCTURE.V, "project-id": a.projectId }, null, 8, ["monomerId", "areaId", "productType", "project-id"]), a.detailData.productType === l(N).ARTIFACT.V ? (v(), V(k, { key: 0, modelValue: m.value, "onUpdate:modelValue": r[2] || (r[2] = (e) => m.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: O(q, ["enter"]) }, null, 8, ["modelValue"])) : z("", true), t(k, { modelValue: f.value, "onUpdate:modelValue": r[3] || (r[3] = (e) => f.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: O(q, ["enter"]) }, null, 8, ["modelValue"]), t(I, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: P($, ["stop"]) }, { default: n(() => r[5] || (r[5] = [h("搜索")])), _: 1, __: [5] }), t(I, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: P(G, ["stop"]) }, { default: n(() => r[6] || (r[6] = [h(" 重置 ")])), _: 1, __: [6] })]), titleRight: n(() => {
      var e, s, T;
      return [ae(t(D, { "api-key": "mesWorkOrderTrackingList", params: { processId: a.detailData.id, taskType: a.detailData.productType, orderId: a.detailData.taskOrderId, name: m.value, projectId: a.projectId, groupId: (e = a.detailData.group) == null ? void 0 : e.id, monomerId: d.value ? d.value : (s = a.query) == null ? void 0 : s.monomerId, areaId: p.value ? p.value : (T = a.query) == null ? void 0 : T.areaId, serialNumber: f.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[ee, l(ge).print]])];
    }), content: n(() => [b("div", he, [t(J, { direction: "vertical", column: 4, border: "" }, { default: n(() => [t(g, { align: "center", label: "工单号" }, { default: n(() => [h(u(o.detailData.orderNumber || "-"), 1)]), _: 1 }), t(g, { align: "center", label: "车间" }, { default: n(() => {
      var e;
      return [h(u(((e = o.detailData.workShop) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 }), t(g, { align: "center", label: "产线" }, { default: n(() => {
      var e;
      return [h(u(((e = o.detailData.productionLine) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 }), t(g, { align: "center", label: "排产人" }, { default: n(() => [h(u(o.detailData.operator || "-"), 1)]), _: 1 })]), _: 1 })]), t(Y, { ref: "tableRef", data: S.value, "max-height": l(K) + 50, style: { width: "100%" } }, { default: n(() => [t(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(i, { "show-overflow-tooltip": true, prop: "project.shortName", key: "project.shortName", label: "项目", align: "center" }, { default: n(({ row: e }) => {
      var s, T;
      return [b("span", null, u(e.project ? ((s = e.project) == null ? void 0 : s.serialNumber) + "-" + ((T = e.project) == null ? void 0 : T.name) : "/"), 1)];
    }), _: 1 }), t(i, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }, { default: n(({ row: e }) => {
      var s;
      return [b("span", null, u(e.monomer ? (s = e.monomer) == null ? void 0 : s.name : "/"), 1)];
    }), _: 1 }), t(i, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }, { default: n(({ row: e }) => {
      var s;
      return [b("span", null, u(e.area ? (s = e.area) == null ? void 0 : s.name : "/"), 1)];
    }), _: 1 }), a.detailData.productType === l(N).ARTIFACT.V ? (v(), V(i, { "show-overflow-tooltip": true, prop: "name", label: "名称", key: "name", align: "center", "min-width": "100" })) : z("", true), t(i, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), t(i, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center", "min-width": "120px" }), t(i, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "数量", align: "center" }), t(i, { "show-overflow-tooltip": true, prop: "netWeight", key: "netWeight", label: "单净重", align: "center" }), a.detailData.productType === l(N).ARTIFACT.V ? (v(), V(i, { "show-overflow-tooltip": true, prop: "grossWeight", key: "grossWeight", label: "单毛重", align: "center" })) : z("", true), t(i, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: n(({ row: e }) => [b("span", { style: oe(`color: ${e.completeQuantity === e.quantity ? "#409EFF" : "#F56C6C"}`) }, u(e.completeQuantity), 5)]), _: 1 }), t(i, { "show-overflow-tooltip": true, prop: "completeDate", key: "completeDate", label: "完成日期", align: "center" }, { default: n((e) => [b("span", null, u(e.row.completeDate ? l(ye)(e.row.completeDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(i, { "show-overflow-tooltip": true, prop: "status", label: "状态", align: "center", sortable: "" }, { default: n(({ row: e }) => [e.status === l(E).DELAY.V ? (v(), B("span", be, u(l(E).VL[e.status]), 1)) : (v(), B("span", _e, u(l(E).VL[e.status]), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), t(Z, { total: l(Q), "current-page": l(j).pageNumber, "page-size": l(j).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(F), onCurrentChange: l(L) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, je = Object.freeze(Object.defineProperty({ __proto__: null, default: we }, Symbol.toStringTag, { value: "Module" }));
export {
  we as _,
  Ve as a,
  De as g,
  je as i,
  Te as m,
  Ce as p,
  xe as s
};
