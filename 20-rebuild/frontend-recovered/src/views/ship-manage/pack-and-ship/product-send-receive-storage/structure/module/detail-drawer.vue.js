import { ref as d } from "vue";
import { computed as Y } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as g } from "vue";
import { createBlock as f } from "vue";
import { withCtx as s } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as _ } from "vue";
import { withDirectives as W } from "vue";
import { unref as i } from "vue";
import { createElementVNode as h } from "vue";
import { withKeys as ee } from "vue";
import { createCommentVNode as j } from "vue";
import { isRef as te } from "vue";
import { ElTag as ae } from "element-plus";
import { ElInput as le } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElPagination as ne } from "element-plus";
import { vLoading as ie } from "element-plus";
import { g as re } from "../../../../../../modules/ship-manage-3066b2ed.js";
import { b as se, a as ue } from "../../../../../../modules/product-receive-send-storage-7de51d86.js";
import { u as me, J as de, D as v, bb as ce, q as pe } from "../../../../../../shared/runtime.js";
const ge = { class: "head-container" }, fe = { class: "header-div" }, be = { __name: "detail-drawer", props: { showDetailDrawer: { type: Boolean }, query: { type: Object, default: () => {
} }, inventoryType: { type: Number } }, emits: ["update:showDetailDrawer"], setup(x, { emit: P }) {
  const o = x, q = P, { visible: y, handleClose: z } = me({ emit: q, props: o, field: "showDetailDrawer", showHook: u }), { handleSizeChange: G, handleCurrentChange: K, total: A, setTotalPage: E, queryPage: b } = de({ fetchHook: V }), L = d([["netWeight", ["to-fixed", v.COM_WT__KG]], ["grossWeight", ["to-fixed", v.COM_WT__KG]], ["totalNetWeight", ["to-fixed", v.COM_WT__KG]], ["totalGrossWeight", ["to-fixed", v.COM_WT__KG]]]), p = d({}), w = d([]), C = d(false), D = d([]), n = d({ monomerId: void 0, areaId: void 0, serialNumber: void 0 }), m = Y(() => ({ projectId: o.query.projectId, productType: o.query.productType, dateTime: o.query.dateTime, type: o.inventoryType, dateTimeList: o.query.dateTimeList }));
  function M(r) {
    D.value = r || [];
  }
  async function u() {
    V();
    const r = await se({ ...m.value, ...n.value });
    p.value = r;
  }
  async function V() {
    w.value = [], C.value = true;
    try {
      const r = await ue({ ...m.value, ...n.value, ...b });
      w.value = r.content, E(r.totalElements);
    } catch (r) {
      console.log(r);
    } finally {
      C.value = false;
    }
  }
  function O() {
    n.value = {}, u();
  }
  return (r, a) => {
    const F = ae, R = c("print-table"), U = c("common-select"), B = le, S = c("common-button"), l = oe, I = c("table-cell-tag"), $ = c("common-table"), H = ne, J = c("common-drawer"), Q = Z("permission"), X = ie;
    return g(), f(J, { onClose: i(z), modelValue: i(y), "onUpdate:modelValue": a[4] || (a[4] = (t) => te(y) ? y.value = t : null), size: "90%", title: o.inventoryType === 1 ? "期初库存量" : o.inventoryType === 2 ? "入库量" : o.inventoryType === 3 ? "出库量" : "期末库存量" }, { titleAfter: s(() => [e(F, { size: "large" }, { default: s(() => [T(_(`总数量：${p.value.quantity || 0} | 总净重：${p.value.totalNetWeight || 0} KG | 总毛重：${p.value.totalGrossWeight || 0} KG`), 1)]), _: 1 })]), titleRight: s(() => [W(e(R, { "api-key": o.inventoryType === 1 ? "structureFinishedStartDetail" : o.inventoryType === 2 ? "structureFinishedInDetail" : o.inventoryType === 3 ? "structureFinishedOutDetail" : "structureFinishedEndtDetail", params: { ...m.value, ...n.value } }, null, 8, ["api-key", "params"]), [[Q, i(re).detailPrint]])]), content: s(() => [h("div", ge, [h("div", fe, [e(i(ce), { class: "filter-item", modelValue: m.value.projectId, "onUpdate:modelValue": a[0] || (a[0] = (t) => m.value.projectId = t), onChange: u, clearable: "" }, null, 8, ["modelValue"]), e(i(pe), { class: "filter-item", ref: "monomerSelectRef", modelValue: n.value.monomerId, "onUpdate:modelValue": a[1] || (a[1] = (t) => n.value.monomerId = t), "project-id": m.value.projectId, clearable: "", default: false, onChange: u, onGetAreaInfo: M }, null, 8, ["modelValue", "project-id"]), e(U, { class: "filter-item", placeholder: "请选择区域", modelValue: n.value.areaId, "onUpdate:modelValue": a[2] || (a[2] = (t) => n.value.areaId = t), options: D.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", onChange: u }, null, 8, ["modelValue", "options"]), e(B, { class: "filter-item", style: { width: "200px" }, placeholder: "编号搜索", modelValue: n.value.serialNumber, "onUpdate:modelValue": a[3] || (a[3] = (t) => n.value.serialNumber = t), modelModifiers: { trim: true }, onKeyup: ee(u, ["enter"]) }, null, 8, ["modelValue"]), e(S, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: u, style: { "margin-left": "10px" } }, { default: s(() => a[5] || (a[5] = [T(" 搜索 ")])), _: 1, __: [5] }), e(S, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: O }, { default: s(() => a[6] || (a[6] = [T(" 重置 ")])), _: 1, __: [6] })]), W((g(), f($, { data: w.value, "data-format": L.value }, { default: s(() => [e(l, { label: "序号", align: "center", type: "index", "min-width": "55" }), e(l, { label: "项目简称", align: "center", "min-width": "120", prop: "project" }, { default: s(({ row: t }) => {
      var k, N;
      return [h("span", null, _(((k = t.project) == null ? void 0 : k.serialNumber) || "") + "-" + _(((N = t.project) == null ? void 0 : N.shortName) || ""), 1)];
    }), _: 1 }), e(l, { label: "单体", align: "center", "min-width": "100", prop: "monomer.name" }, { default: s(({ row: t }) => [t.boolAllPartSendDirectly && t.boolShowSign ? (g(), f(I, { key: 0, name: "檩条直发", color: "#f56c6c" })) : j("", true), !t.boolAllPartSendDirectly && t.boolShowSign ? (g(), f(I, { key: 1, name: "直发件" })) : j("", true), h("span", null, _(t.monomer.name), 1)]), _: 1 }), e(l, { label: "区域", align: "center", "min-width": "100", prop: "area.name" }), e(l, { label: "编号", align: "center", "min-width": "100", prop: "serialNumber" }), e(l, { label: "规格", align: "center", "min-width": "100", prop: "specification" }), e(l, { label: "长度(mm)", align: "center", "min-width": "80", prop: "length" }), e(l, { label: "材质", align: "center", "min-width": "80", prop: "material" }), e(l, { label: "数量", align: "center", "min-width": "55", prop: "quantity" }), e(l, { label: "单净重(kg)", align: "center", "min-width": "80", prop: "netWeight" }), e(l, { label: "单毛重(kg)", align: "center", "min-width": "80", prop: "grossWeight" }), e(l, { label: "总净重(kg)", align: "center", "min-width": "80", prop: "totalNetWeight" }), e(l, { label: "总毛重(kg)", align: "center", "min-width": "80", prop: "totalGrossWeight" })]), _: 1 }, 8, ["data", "data-format"])), [[X, C.value]]), e(H, { total: i(A), "current-page": i(b).pageNumber, "page-size": i(b).pageSize, onSizeChange: i(G), onCurrentChange: i(K), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" } }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])]), _: 1 }, 8, ["onClose", "modelValue", "title"]);
  };
} };
export {
  be as default
};
