import { ref as f } from "vue";
import { watch as D } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as g } from "vue";
import { createBlock as K } from "vue";
import { withCtx as r } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { withKeys as $ } from "vue";
import { withModifiers as I } from "vue";
import { createTextVNode as V } from "vue";
import { withDirectives as F } from "vue";
import { createElementVNode as G } from "vue";
import { toDisplayString as v } from "vue";
import { createElementBlock as y } from "vue";
import { isRef as Y } from "vue";
import { ElInput as Z } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { l as L, o as ee, u as te, J as ae, bb as oe, bZ as le, z as ne, cg as h } from "../../../../../shared/runtime.js";
import { J as re } from "../../../../../modules/bridge-86f96a4f.js";
function ie(s) {
  return L({ module: "bridge", url: "task/tracking/productionLine", method: "get", params: s });
}
function se(s) {
  return L({ module: "bridge", url: "task/tracking/productionLine/detail/page", method: "get", params: s });
}
const be = { get: ie }, ue = { key: 0 }, de = { key: 1, style: { color: "red" } }, pe = { key: 0, style: { color: "red" } }, ce = { key: 1 }, me = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: j }) {
  const z = j, x = f([]), u = f(), d = f(), p = f(), m = f(), n = s;
  D(() => u.value, (c) => {
    i();
  }), D(() => d.value, (c) => {
    i();
  }), D(() => p.value, (c) => {
    i();
  });
  const { maxHeight: T } = ee({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }), { visible: w, handleClose: N } = te({ emit: z, props: n, field: "visible", showHook: i }), { handleSizeChange: P, handleCurrentChange: S, total: M, setTotalPage: B, queryPage: _ } = ae({ fetchHook: i });
  async function i() {
    let c = [];
    try {
      const { content: t = [], totalElements: k } = await se({ productionLineId: n.detailData.id, taskType: n.detailData.productType, startTime: n.detailData.startDate, endTime: n.detailData.endDate, projectId: u.value, monomerId: d.value, areaId: p.value, serialNumber: m.value, ..._ });
      B(k), c = t;
    } catch (t) {
      console.log("获取产线跟踪详情失败", t);
    } finally {
      x.value = c;
    }
  }
  function E() {
    i();
  }
  function R() {
    d.value = void 0, p.value = void 0, u.value = void 0, m.value = void 0, i();
  }
  function H() {
    i();
  }
  return (c, t) => {
    const k = Z, C = b("common-button"), Q = b("print-table"), l = W, A = b("common-table"), O = X, U = b("common-drawer"), q = J("permission");
    return g(), K(U, { ref: "drawerRef", title: `产线：${s.detailData.workShopName}>${s.detailData.name}`, modelValue: o(w), "onUpdate:modelValue": t[4] || (t[4] = (e) => Y(w) ? w.value = e : null), direction: "rtl", "before-close": o(N), size: "100%" }, { titleAfter: r(() => [a(oe, { modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => u.value = e), clearable: "", class: "filter-item", style: { width: "300px" } }, null, 8, ["modelValue"]), a(o(le), { monomerId: d.value, "onUpdate:monomerId": t[1] || (t[1] = (e) => d.value = e), areaId: p.value, "onUpdate:areaId": t[2] || (t[2] = (e) => p.value = e), needConvert: "", clearable: "", "project-id": u.value }, null, 8, ["monomerId", "areaId", "project-id"]), a(k, { modelValue: m.value, "onUpdate:modelValue": t[3] || (t[3] = (e) => m.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: $(H, ["enter"]) }, null, 8, ["modelValue"]), a(C, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: I(E, ["stop"]) }, { default: r(() => t[5] || (t[5] = [V("搜索")])), _: 1, __: [5] }), a(C, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: I(R, ["stop"]) }, { default: r(() => t[6] || (t[6] = [V(" 重置 ")])), _: 1, __: [6] })]), titleRight: r(() => [F(a(Q, { "api-key": "bridgeProductionLineList", params: { productionLineId: n.detailData.id, taskType: n.detailData.productType, startTime: n.detailData.startDate, endTime: n.detailData.endDate, projectId: u.value, monomerId: d.value, areaId: p.value, serialNumber: m.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[q, o(re).print]])]), content: r(() => [a(A, { ref: "tableRef", "max-height": o(T), data: x.value, "return-source-data": "", style: { width: "100%" } }, { default: r(() => [a(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(l, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "180" }, { default: r((e) => [G("span", null, v(o(ne)(e.row.project)), 1)]), _: 1 }), a(l, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }), a(l, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }), a(l, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), a(l, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", "min-width": "120", align: "center" }), a(l, { "show-overflow-tooltip": true, prop: "quantity", key: "quantity", label: "任务数", align: "center" }), a(l, { "show-overflow-tooltip": true, prop: "weight", key: "weight", label: "单重", align: "center" }), a(l, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: r(({ row: e }) => [e.status === o(h).NORMAL.V ? (g(), y("span", ue, v(e.completeQuantity), 1)) : (g(), y("span", de, v(e.completeQuantity), 1))]), _: 1 }), a(l, { "show-overflow-tooltip": true, prop: "status", label: "状态", align: "center", sortable: "" }, { default: r(({ row: e }) => [e.status === o(h).DELAY.V ? (g(), y("span", pe, v(o(h).VL[e.status]), 1)) : (g(), y("span", ce, v(o(h).VL[e.status]), 1))]), _: 1 })]), _: 1 }, 8, ["max-height", "data"]), a(O, { total: o(M), "current-page": o(_).pageNumber, "page-size": o(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(P), onCurrentChange: o(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ye = Object.freeze(Object.defineProperty({ __proto__: null, default: me }, Symbol.toStringTag, { value: "Module" }));
export {
  me as _,
  be as c,
  ye as i
};
