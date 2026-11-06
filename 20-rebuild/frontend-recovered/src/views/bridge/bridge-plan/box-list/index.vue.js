import { ref as C } from "vue";
import { watch as R } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { Fragment as U } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as h } from "vue";
import { unref as t } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as s } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as u } from "vue";
import { isRef as Q } from "vue";
import { nextTick as X } from "vue";
import { ElTableColumn as J } from "element-plus";
import { InfoFilled as Y } from "@element-plus/icons-vue";
import { ElIcon as Z } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { c as oe, _ as re, b as ie } from "./module/header.vue.js";
import { _ as ae, m as le, x as ne, o as se, T as de, F as G, K as P, D as _, P as pe } from "../../../../shared/runtime.js";
import { d as ue } from "../../../../modules/bridge-86f96a4f.js";
import { u as ce } from "../../../../modules/use-drawing-8a7ba23b.js";
import { b as me } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const he = { class: "app-container" }, _e = { class: "head-container" }, we = { key: 0 }, ge = { key: 1, class: "child" }, fe = { style: { display: "inline-block" } }, be = ["onDblclick"], ye = { key: 0 }, xe = { key: 1, style: { color: "red", "font-size": "13px" } }, ke = { __name: "index", setup(ve) {
  const { globalProject: y, globalProjectId: W } = le(["globalProject", "globalProjectId"]), { showDrawing: x, drawingRow: w, drawingPreview: B } = ce({ pidField: "id", typeField: "productType" }), K = { add: false, edit: false, del: true, download: false }, k = C(), v = C(false), T = C(), { crud: g, columns: d, CRUD: V } = ne({ title: "分段单元清单", sort: ["id.asc"], permission: { ...ue }, optShow: { ...K }, requiredQuery: ["areaId"], crudApi: { ...oe }, hasPagination: true }, k), { maxHeight: q } = se({ wrapperBox: ".box-list", paginate: true, extraHeight: 40 });
  R(() => W.value, (p) => {
    p && g.toQuery();
  }, { immediate: true, deep: true }), R(() => y.value, (p) => {
    var c, o, i;
    !((o = (c = y.value) == null ? void 0 : c.projectContentList) != null && o.length) || ((i = y.value) == null ? void 0 : i.projectContentList.findIndex((b) => b.no === de.BRIDGE.V)) < 0 ? (T.value = "当前项目内容没有包含分段,请到合同管理中进行配置", v.value = false) : (T.value = "", v.value = true);
  }, { deep: true, immediate: true });
  function N(p) {
    return p.dataType === 2 ? p.index : p.childIndex;
  }
  V.HOOK.handleRefresh = (p, c) => {
    let o = 1;
    c.data.content = c.data.content.map((i) => (i.dataType = 2, i.index = o, o++, i.rowKey = i.id, i.hasChildren = true, i.productType = G.BOX.V, i.projectType = P.BRIDGE.V, i));
  };
  async function O({ row: p, treeNode: c, resolve: o }) {
    try {
      const { content: i } = await ie({ boxId: p.id });
      let b = 1;
      i.length > 0 && i.map((m) => (m.dataType = 1, m.rowKey = `${p.id}__${m.id}`, m.childIndex = b, b++, m.productType = G.CELL.V, m.projectType = P.BRIDGE.V, m)), o(i), X(() => {
        k.value.toggleRowExpansion(p, true);
      });
    } catch (i) {
      console.log("获取单元信息", i);
    }
  }
  return (p, c) => {
    var E, M, j, S, A, D, F;
    const o = J, i = Y, b = Z, m = ee, L = $("common-table"), H = te;
    return r(), f("div", he, [v.value ? (r(), f(U, { key: 0 }, [I("div", _e, [h(t(re), { "project-id": t(W), globalProject: t(y) }, null, 8, ["project-id", "globalProject"])]), z((r(), s(L, { ref_key: "tableRef", ref: k, data: t(g).data, "empty-text": t(g).emptyText, "max-height": t(q), "tree-props": { children: "children", hasChildren: "hasChildren" }, "row-key": "rowKey", style: { width: "100%" }, stripe: false, lazy: "", load: O, "return-source-data": "", onSortChange: t(g).handleSortChange, onSelectionChange: t(g).selectionChangeHandler, showEmptySymbol: false }, { default: a(() => [h(o, { key: "selection", type: "selection", width: "55" }), h(o, { prop: "index", label: "序号", align: "center", width: "60" }, { default: a((e) => [e.row.dataType === 2 ? (r(), f("span", we, l(N(e.row)), 1)) : (r(), f("span", ge, l(N(e.row)), 1))]), _: 1 }), t(d).visible("serialNumber") ? (r(), s(o, { key: 0, prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "分段编号" }, { header: a(() => [h(m, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: a(() => [I("div", fe, [c[1] || (c[1] = I("span", null, "分段编号", -1)), h(b, null, { default: a(() => [h(i)]), _: 1 })])]), _: 1 })]), default: a((e) => [e.row.dataType === 2 ? (r(), f("span", { key: 0, style: { cursor: "pointer" }, onDblclick: (Te) => t(B)(e.row) }, l(e.row.serialNumber), 41, be)) : n("", true)]), _: 1 })) : n("", true), t(d).visible("serialNumber") ? (r(), s(o, { key: 1, prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "单元编号" }, { default: a((e) => [e.row.dataType === 1 ? (r(), f("span", ye, l(e.row.serialNumber), 1)) : n("", true)]), _: 1 })) : n("", true), t(d).visible("specification") ? (r(), s(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", align: "center", "min-width": "120" }, { default: a((e) => [u(l(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("thickness") ? (r(), s(o, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [u(l(e.row.thickness ? e.row.thickness.toFixed(t(_).MES_ARTIFACT_T__MM) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("width") ? (r(), s(o, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `宽度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [u(l(e.row.width ? e.row.width.toFixed(t(_).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("length") ? (r(), s(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [u(l(e.row.length ? e.row.length.toFixed(t(_).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("material") ? (r(), s(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" }, { default: a((e) => [u(l(e.row.material ? e.row.material : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("quantity") ? (r(), s(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "center", "min-width": "80px" }, { default: a((e) => [u(l(e.row.quantity ? e.row.quantity : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("netWeight") ? (r(), s(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: "单净重(kg)", align: "center", "min-width": "80px" }, { default: a((e) => [u(l(e.row.netWeight ? e.row.netWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("totalNetWeight") ? (r(), s(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: "总净重(kg)", align: "center", "min-width": "95px" }, { default: a((e) => [u(l(e.row.totalNetWeight ? e.row.totalNetWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("grossWeight") ? (r(), s(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: a((e) => [u(l(e.row.grossWeight ? e.row.grossWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("totalGrossWeight") ? (r(), s(o, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: a((e) => [u(l(e.row.totalGrossWeight ? e.row.totalGrossWeight.toFixed(t(_).COM_WT__KG) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("surfaceArea") ? (r(), s(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: a((e) => [u(l(e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(_).COM_AREA__M2) : "-"), 1)]), _: 1 })) : n("", true), t(d).visible("remark") ? (r(), s(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: a((e) => [u(l(e.row.remark ? e.row.remark : "-"), 1)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[H, t(g).loading]]), h(t(pe)), h(t(me), { visible: t(x), "onUpdate:visible": c[0] || (c[0] = (e) => Q(x) ? x.value = e : null), "bool-bim": (E = t(w)) == null ? void 0 : E.boolBim, drawingSN: (M = t(w)) == null ? void 0 : M.drawingSN, "monomer-id": (j = t(w)) == null ? void 0 : j.monomerId, "area-id": t(g).query.areaId, "serial-number": (S = t(w)) == null ? void 0 : S.serialNumber, productId: (A = t(w)) == null ? void 0 : A.productId, productType: (D = t(w)) == null ? void 0 : D.productType, projectType: (F = t(w)) == null ? void 0 : F.projectType, isBridge: "" }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType", "projectType"])], 64)) : (r(), f("span", xe, l(T.value), 1))]);
  };
} }, Ke = ae(ke, [["__scopeId", "data-v-7faf9e23"]]);
export {
  Ke as default
};
