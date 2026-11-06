import { ref as y } from "vue";
import { watch as I } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as p } from "vue";
import { createBlock as C } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { withKeys as z } from "vue";
import { createCommentVNode as N } from "vue";
import { withModifiers as O } from "vue";
import { createTextVNode as B } from "vue";
import { withDirectives as J } from "vue";
import { createElementBlock as _ } from "vue";
import { toDisplayString as v } from "vue";
import { createElementVNode as Y } from "vue";
import { isRef as Z } from "vue";
import { ElInput as $ } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElPagination as te } from "element-plus";
import { l as b, u as ae, J as oe, o as le, bZ as re, F as M, cg as k, p as ne } from "../../../../../shared/runtime.js";
import { K as ie } from "../../../../../modules/bridge-86f96a4f.js";
function ye(l) {
  return b({ module: "bridge", url: "task/order/tracking/box/page", method: "get", params: l });
}
function ve(l) {
  return b({ module: "bridge", url: "task/order/tracking/machine_part/page", method: "get", params: l });
}
function he(l) {
  return b({ module: "bridge", url: "task/process/box/process", method: "get", params: l });
}
function we(l) {
  return b({ module: "bridge", url: "task/process/box/page", method: "get", params: l });
}
function _e(l) {
  return b({ module: "bridge", url: "task/process/machine_part/process", method: "get", params: l });
}
function se(l) {
  return b({ module: "bridge", url: "task/process/product/page", method: "get", params: l });
}
const de = { key: 0 }, ue = { key: 1, style: { color: "red" } }, pe = { key: 0, style: { color: "red" } }, me = { key: 1 }, ce = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, projectId: { type: Number } }, emits: ["update:visible"], setup(l, { emit: P }) {
  const S = P, V = y([]), d = y(), u = y(), m = y(), c = y(), r = l;
  I(() => d.value, (g) => {
    s();
  }), I(() => u.value, (g) => {
    s();
  }), I(() => r.detailData.id, (g) => {
    d.value = void 0, u.value = void 0, m.value = void 0, c.value = void 0, s();
  });
  const { visible: x, handleClose: j } = ae({ emit: S, props: r, field: "visible", showHook: s }), { handleSizeChange: E, handleCurrentChange: H, total: R, setTotalPage: L, queryPage: D } = oe({ fetchHook: s }), { maxHeight: Q } = le({ mainBox: ".common-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, extraHeight: 50, minHeight: 300, paginate: true });
  async function s() {
    var t;
    let g = [];
    try {
      const { content: f = [], totalElements: h } = await se({ processId: r.detailData.id, taskType: r.detailData.productType, orderId: r.detailData.taskOrderId, groupId: (t = r.detailData.group) == null ? void 0 : t.id, name: m.value, monomerId: d.value, areaId: u.value, serialNumber: c.value, ...D });
      L(h), g = f;
    } catch (f) {
      console.log("获取工序详情失败", f);
    } finally {
      V.value = g;
    }
  }
  function U() {
    s();
  }
  function q() {
    d.value = void 0, u.value = void 0, m.value = void 0, c.value = void 0, s();
  }
  function T() {
    s();
  }
  return (g, t) => {
    const f = $, h = w("common-button"), A = w("print-table"), n = ee, K = w("common-table"), W = te, X = w("common-drawer"), F = G("permission");
    return p(), C(X, { ref: "drawerRef", title: `${l.detailData.name}工序详细清单`, modelValue: o(x), "onUpdate:modelValue": t[4] || (t[4] = (e) => Z(x) ? x.value = e : null), direction: "rtl", "before-close": o(j), size: "80%" }, { titleAfter: i(() => [a(o(re), { monomerId: d.value, "onUpdate:monomerId": t[0] || (t[0] = (e) => d.value = e), areaId: u.value, "onUpdate:areaId": t[1] || (t[1] = (e) => u.value = e), needConvert: "", clearable: "", areaClearable: "", "project-id": r.projectId }, null, 8, ["monomerId", "areaId", "project-id"]), r.detailData.productType === o(M).BOX.V ? (p(), C(f, { key: 0, modelValue: m.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => m.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入名称搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: z(T, ["enter"]) }, null, 8, ["modelValue"])) : N("", true), a(f, { modelValue: c.value, "onUpdate:modelValue": t[3] || (t[3] = (e) => c.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: z(T, ["enter"]) }, null, 8, ["modelValue"]), a(h, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: O(U, ["stop"]) }, { default: i(() => t[5] || (t[5] = [B("搜索")])), _: 1, __: [5] }), a(h, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: O(q, ["stop"]) }, { default: i(() => t[6] || (t[6] = [B(" 重置 ")])), _: 1, __: [6] })]), titleRight: i(() => {
      var e;
      return [J(a(A, { "api-key": "bridgeWorkOrderTrackingList", params: { processId: r.detailData.id, taskType: r.detailData.productType, orderId: r.detailData.taskOrderId, name: m.value, groupId: (e = r.detailData.group) == null ? void 0 : e.id, monomerId: d.value, areaId: u.value, serialNumber: c.value }, size: "default", type: "warning", class: "filter-item", style: { width: "300px" } }, null, 8, ["params"]), [[F, o(ie).print]])];
    }), content: i(() => [a(K, { ref: "tableRef", data: V.value, "max-height": o(Q) + 50, style: { width: "100%" } }, { default: i(() => [a(n, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(n, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }), a(n, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }), r.detailData.productType === o(M).BOX.V ? (p(), C(n, { "show-overflow-tooltip": true, prop: "name", label: "名称", key: "name", align: "center", "min-width": "100" })) : N("", true), a(n, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), a(n, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", align: "center", "min-width": "120px" }), a(n, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "数量", align: "center" }), a(n, { "show-overflow-tooltip": true, prop: "weight", key: "weight", label: "单重", align: "center" }), a(n, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: i(({ row: e }) => [e.status === o(k).NORMAL.V ? (p(), _("span", de, v(e.completeQuantity), 1)) : (p(), _("span", ue, v(e.completeQuantity), 1))]), _: 1 }), a(n, { "show-overflow-tooltip": true, prop: "completeDate", key: "completeDate", label: "完成日期", align: "center" }, { default: i((e) => [Y("span", null, v(e.row.completeDate ? o(ne)(e.row.completeDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(n, { "show-overflow-tooltip": true, prop: "status", label: "状态", align: "center", sortable: "" }, { default: i(({ row: e }) => [e.status === o(k).DELAY.V ? (p(), _("span", pe, v(o(k).VL[e.status]), 1)) : (p(), _("span", me, v(o(k).VL[e.status]), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(W, { total: o(R), "current-page": o(D).pageNumber, "page-size": o(D).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(E), onCurrentChange: o(H) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ke = Object.freeze(Object.defineProperty({ __proto__: null, default: ce }, Symbol.toStringTag, { value: "Module" }));
export {
  ce as _,
  _e as a,
  ye as g,
  ke as i,
  ve as m,
  he as p,
  we as s
};
