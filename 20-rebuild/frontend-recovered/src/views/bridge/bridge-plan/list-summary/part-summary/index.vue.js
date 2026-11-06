import { ref as N } from "vue";
import { watch as A } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as B } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as a } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as p } from "vue";
import { createTextVNode as m } from "vue";
import { isRef as K } from "vue";
import { ElTableColumn as q } from "element-plus";
import { InfoFilled as H } from "@element-plus/icons-vue";
import { ElIcon as L } from "element-plus";
import { ElTooltip as U } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as z, _ as Q } from "./module/header.vue.js";
import { _ as J, m as X, x as Y, o as Z, T as ee, F as te, K as oe, D as c, P as le } from "../../../../../shared/runtime.js";
import { u as ae } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { p as re } from "../../../../../modules/bridge-86f96a4f.js";
import { a as ie } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
const se = { class: "app-container" }, ne = { class: "head-container" }, pe = { style: { display: "inline-block" } }, ue = ["onDblclick"], de = { key: 1, style: { color: "red", "font-size": "13px" } }, me = { __name: "index", setup(ce) {
  const { globalProject: f, globalProjectId: b } = X(["globalProject", "globalProjectId"]), { showDrawing: y, drawingRow: h, drawingPreview: F } = ae({ pidField: "id" }), R = { add: false, edit: false, del: false, download: false }, T = N(), v = N(true), { crud: u, columns: r, CRUD: W } = Y({ title: "零件清单汇总", sort: ["id.asc"], permission: { ...re }, optShow: { ...R }, crudApi: { ...z }, hasPagination: true }, T), { maxHeight: D } = Z({ wrapperBox: ".part-summary", paginate: true, extraHeight: 40 });
  return A(() => b.value, (_) => {
    _ && u.toQuery();
  }, { immediate: true, deep: true }), A(() => f.value, (_) => {
    var n, o, w;
    ((o = (n = f.value) == null ? void 0 : n.projectContentList) == null ? void 0 : o.length) > 0 ? v.value = ((w = f.value) == null ? void 0 : w.projectContentList.findIndex((x) => x.no === ee.BRIDGE.V)) > -1 : v.value = false;
  }, { deep: true, immediate: true }), W.HOOK.beforeRefresh = () => (u.query.projectId = b.value, u.query.projectId), W.HOOK.handleRefresh = (_, n) => {
    n.data.content = n.data.content.map((o) => (o.productType = te.MACHINE_PART.V, o.projectType = oe.BRIDGE.V, o));
  }, (_, n) => {
    var C, I, M, j, E;
    const o = q, w = H, x = L, S = U, G = V("common-table"), P = $;
    return l(), k("div", se, [v.value ? (l(), k(B, { key: 0 }, [g("div", ne, [d(e(Q), { "project-id": e(b) }, null, 8, ["project-id"])]), O((l(), a(G, { ref_key: "tableRef", ref: T, data: e(u).data, "empty-text": e(u).emptyText, "return-source-data": "", showEmptySymbol: false, "max-height": e(D), style: { width: "100%" }, onSortChange: e(u).handleSortChange }, { default: s(() => [d(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(r).visible("monomer.name") ? (l(), a(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" })) : i("", true), e(r).visible("area.name") ? (l(), a(o, { key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域" })) : i("", true), e(r).visible("serialNumber") ? (l(), a(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "零件编号", "min-width": "120px" }, { header: s(() => [d(S, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: s(() => [g("div", pe, [n[1] || (n[1] = g("span", null, "零件编号", -1)), d(x, null, { default: s(() => [d(w)]), _: 1 })])]), _: 1 })]), default: s((t) => [g("span", { style: { cursor: "pointer" }, onDblclick: (he) => e(F)(t.row) }, p(t.row.serialNumber), 41, ue)]), _: 1 })) : i("", true), e(r).visible("specification") ? (l(), a(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })) : i("", true), e(r).visible("thickness") ? (l(), a(o, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [m(p(t.row.thickness ? t.row.thickness.toFixed(e(c).MES_ARTIFACT_T__MM) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("width") ? (l(), a(o, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `宽度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [m(p(t.row.width ? t.row.width.toFixed(e(c).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("length") ? (l(), a(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [m(p(t.row.length ? t.row.length.toFixed(e(c).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("material") ? (l(), a(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("quantity") ? (l(), a(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "left", "min-width": "80px" })) : i("", true), e(r).visible("netWeight") ? (l(), a(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: s((t) => [m(p(t.row.netWeight ? t.row.netWeight.toFixed(e(c).COM_WT__KG) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("totalNetWeight") ? (l(), a(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: `总净重
(kg)`, align: "left", "min-width": "95px" }, { default: s((t) => [m(p(t.row.totalNetWeight ? t.row.totalNetWeight.toFixed(e(c).COM_WT__KG) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("grossWeight") ? (l(), a(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: s((t) => [m(p(t.row.grossWeight ? t.row.grossWeight.toFixed(e(c).COM_WT__KG) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("totalGrossWeight") ? (l(), a(o, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: s((t) => [m(p(t.row.totalGrossWeight ? t.row.totalGrossWeight.toFixed(e(c).COM_WT__KG) : "-"), 1)]), _: 1 })) : i("", true), e(r).visible("surfaceArea") ? (l(), a(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", "show-overflow-tooltip": true, label: "面积", "min-width": "100px" })) : i("", true), e(r).visible("category") ? (l(), a(o, { key: "category", prop: "category", "show-overflow-tooltip": true, label: "类别", "min-width": "120" })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[P, e(u).loading]]), d(e(le))], 64)) : (l(), k("span", de, "当前项目内容没有包含桥梁分段,请到合同管理中进行配置")), d(e(ie), { modelValue: e(y), "onUpdate:modelValue": n[0] || (n[0] = (t) => K(y) ? y.value = t : null), "bool-bim": (C = e(h)) == null ? void 0 : C.boolBim, "serial-number": (I = e(h)) == null ? void 0 : I.serialNumber, productId: (M = e(h)) == null ? void 0 : M.productId, productType: (j = e(h)) == null ? void 0 : j.productType, projectType: (E = e(h)) == null ? void 0 : E.projectType }, null, 8, ["modelValue", "bool-bim", "serial-number", "productId", "productType", "projectType"])]);
  };
} }, ke = J(me, [["__scopeId", "data-v-35815c71"]]);
export {
  ke as default
};
