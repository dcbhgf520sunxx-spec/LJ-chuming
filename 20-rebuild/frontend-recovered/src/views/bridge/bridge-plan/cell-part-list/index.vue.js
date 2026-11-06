import { ref as I } from "vue";
import { watch as R } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as Q } from "vue";
import { createElementVNode as W } from "vue";
import { createVNode as h } from "vue";
import { unref as t } from "vue";
import { withDirectives as J } from "vue";
import { createBlock as s } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as c } from "vue";
import { isRef as X } from "vue";
import { nextTick as Y } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { InfoFilled as ee } from "@element-plus/icons-vue";
import { ElIcon as te } from "element-plus";
import { ElTooltip as oe } from "element-plus";
import { vLoading as re } from "element-plus";
import { l as K, _ as ie, m as ae, x as le, o as ne, T as se, F as G, K as B, D as _, P as de } from "../../../../shared/runtime.js";
import { e as pe } from "../../../../modules/bridge-86f96a4f.js";
import { u as ce } from "../../../../modules/use-drawing-8a7ba23b.js";
import ue from "./module/header.vue.js";
import { b as me } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
function he(y) {
  return K({ url: "/api/bridge/tech-element", method: "get", params: y });
}
function _e(y) {
  return K({ url: "/api/bridge/tech-machinePart", method: "get", params: y });
}
const we = { get: he };
const ge = { class: "app-container" }, fe = { class: "head-container" }, be = { key: 0 }, ye = { key: 1, class: "child" }, xe = { style: { display: "inline-block" } }, ke = ["onDblclick"], ve = { key: 0 }, Te = { key: 1, style: { color: "red", "font-size": "13px" } }, Ce = { __name: "index", setup(y) {
  const { globalProject: x, globalProjectId: N } = ae(["globalProject", "globalProjectId"]), { showDrawing: k, drawingRow: w, drawingPreview: V } = ce({ pidField: "id", typeField: "productType" }), q = { add: false, edit: false, del: false, download: false }, v = I(), T = I(false), C = I(), { crud: g, columns: d, CRUD: L } = le({ title: "单元零件清单", sort: ["id.asc"], permission: { ...pe }, optShow: { ...q }, requiredQuery: ["areaId"], crudApi: { ...we }, hasPagination: true }, v), { maxHeight: O } = ne({ wrapperBox: ".box-list", paginate: true, extraHeight: 40 });
  R(() => N.value, (p) => {
    p && g.toQuery();
  }, { immediate: true, deep: true }), R(() => x.value, (p) => {
    var u, o, i;
    !((o = (u = x.value) == null ? void 0 : u.projectContentList) != null && o.length) || ((i = x.value) == null ? void 0 : i.projectContentList.findIndex((b) => b.no === se.BRIDGE.V)) < 0 ? (C.value = "当前项目内容没有包含分段,请到合同管理中进行配置", T.value = false) : (C.value = "", T.value = true);
  }, { deep: true, immediate: true });
  function E(p) {
    return p.dataType === 2 ? p.index : p.childIndex;
  }
  L.HOOK.handleRefresh = (p, u) => {
    let o = 1;
    u.data.content = u.data.content.map((i) => (i.dataType = 2, i.index = o, o++, i.rowKey = i.id, i.hasChildren = true, i.productType = G.CELL.V, i.projectType = B.BRIDGE.V, i));
  };
  async function H({ row: p, treeNode: u, resolve: o }) {
    try {
      const { content: i } = await _e({ elementId: p.id });
      let b = 1;
      i.length > 0 && i.map((m) => (m.dataType = 1, m.rowKey = `${p.id}__${m.id}`, m.childIndex = b, b++, m.productType = G.MACHINE_PART.V, m.projectType = B.BRIDGE.V, m)), o(i), Y(() => {
        v.value.toggleRowExpansion(p, true);
      });
    } catch (i) {
      console.log("获取零件信息", i);
    }
  }
  return (p, u) => {
    var M, A, j, S, D, F, P;
    const o = Z, i = ee, b = te, m = oe, $ = z("common-table"), U = re;
    return r(), f("div", ge, [T.value ? (r(), f(Q, { key: 0 }, [W("div", fe, [h(t(ue), { "project-id": t(N), globalProject: t(x) }, null, 8, ["project-id", "globalProject"])]), J((r(), s($, { ref_key: "tableRef", ref: v, data: t(g).data, "empty-text": t(g).emptyText, "max-height": t(O), "tree-props": { children: "children", hasChildren: "hasChildren" }, "row-key": "rowKey", style: { width: "100%" }, stripe: false, lazy: "", load: H, "return-source-data": "", onSortChange: t(g).handleSortChange, onSelectionChange: t(g).selectionChangeHandler, showEmptySymbol: false }, { default: a(() => [h(o, { key: "selection", type: "selection", width: "55" }), h(o, { prop: "index", label: "序号", align: "center", width: "60" }, { default: a((e) => [e.row.dataType === 2 ? (r(), f("span", be, l(E(e.row)), 1)) : (r(), f("span", ye, l(E(e.row)), 1))]), _: 1 }), t(d).visible("serialNumber") ? (r(), s(o, { key: 0, prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "单元编号" }, { header: a(() => [h(m, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: a(() => [W("div", xe, [u[1] || (u[1] = W("span", null, "单元编号", -1)), h(b, null, { default: a(() => [h(i)]), _: 1 })])]), _: 1 })]), default: a((e) => [e.row.dataType === 2 ? (r(), f("span", { key: 0, style: { cursor: "pointer" }, onDblclick: (Ie) => t(V)(e.row) }, l(e.row.serialNumber), 41, ke)) : n("", true)]), _: 1 })) : n("", true), t(d).visible("serialNumber") ? (r(), s(o, { key: 1, prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "零件编号" }, { default: a((e) => [e.row.dataType === 1 ? (r(), f("span", ve, l(e.row.serialNumber), 1)) : n("", true)]), _: 1 })) : n("", true), t(d).visible("specification") ? (r(), s(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", align: "center", "min-width": "120" }, { default: a((e) => [c(l(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("thickness") ? (r(), s(o, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [c(l(e.row.thickness ? e.row.thickness.toFixed(t(_).MES_ARTIFACT_T__MM) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("width") ? (r(), s(o, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `宽度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [c(l(e.row.width ? e.row.width.toFixed(t(_).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("length") ? (r(), s(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [c(l(e.row.length ? e.row.length.toFixed(t(_).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("material") ? (r(), s(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" }, { default: a((e) => [c(l(e.row.material ? e.row.material : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("quantity") ? (r(), s(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "80px" }, { default: a((e) => [c(l(e.row.quantity ? e.row.quantity : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("netWeight") ? (r(), s(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: "单净重(kg)", align: "center", "min-width": "80px" }, { default: a((e) => [c(l(e.row.netWeight ? e.row.netWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("totalNetWeight") ? (r(), s(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重(kg)", align: "center", "min-width": "95px" }, { default: a((e) => [c(l(e.row.totalNetWeight ? e.row.totalNetWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("grossWeight") ? (r(), s(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: a((e) => [c(l(e.row.grossWeight ? e.row.grossWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("totalGrossWeight") ? (r(), s(o, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: a((e) => [c(l(e.row.totalGrossWeight ? e.row.totalGrossWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("surfaceArea") ? (r(), s(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: a((e) => [c(l(e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(_).COM_AREA__M2) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("remark") ? (r(), s(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: a((e) => [c(l(e.row.remark ? e.row.remark : "-"), 1)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[U, t(g).loading]]), h(t(de)), h(t(me), { visible: t(k), "onUpdate:visible": u[0] || (u[0] = (e) => X(k) ? k.value = e : null), "bool-bim": (M = t(w)) == null ? void 0 : M.boolBim, drawingSN: (A = t(w)) == null ? void 0 : A.drawingSN, "monomer-id": (j = t(w)) == null ? void 0 : j.monomerId, "area-id": t(g).query.areaId, "serial-number": (S = t(w)) == null ? void 0 : S.serialNumber, productId: (D = t(w)) == null ? void 0 : D.productId, productType: (F = t(w)) == null ? void 0 : F.productType, projectType: (P = t(w)) == null ? void 0 : P.projectType, isBridge: "" }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType", "projectType"])], 64)) : (r(), f("span", Te, l(C.value), 1))]);
  };
} }, Ve = ie(Ce, [["__scopeId", "data-v-e60bce13"]]);
export {
  Ve as default
};
