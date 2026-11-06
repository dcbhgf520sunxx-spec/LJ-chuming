import { ref as D } from "vue";
import { watch as F } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as B } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as a } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as r } from "vue";
import { isRef as O } from "vue";
import { ElTableColumn as K } from "element-plus";
import { InfoFilled as L } from "@element-plus/icons-vue";
import { ElIcon as U } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as Q } from "../../../../modules/artifact-bbca1257.js";
import { _ as z, m as J, x as X, o as Y, T as Z, D as g, P as ee } from "../../../../shared/runtime.js";
import { u as te } from "../../../../modules/use-drawing-8a7ba23b.js";
import oe from "./module/header.vue.js";
import { y as ie } from "../../../../modules/plan-d12d7ccf.js";
import { a as ae } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const le = { class: "app-container" }, re = { class: "head-container" }, ne = { style: { display: "inline-block" } }, se = ["onDblclick"], de = { key: 1, style: { color: "red", "font-size": "13px" } }, pe = { __name: "index", setup(ue) {
  const { globalProject: b, globalProjectId: _ } = J(["globalProject", "globalProjectId"]), { showDrawing: f, drawingRow: c, drawingPreview: M } = te({ pidField: "id", productTypeField: "ARTIFACT" }), j = { add: false, edit: false, del: false, download: false }, W = D(), v = D(true), { crud: d, columns: l } = X({ title: "构件清单", sort: ["id.asc"], permission: { ...ie }, optShow: { ...j }, requiredQuery: ["areaId", "areaBatchId"], invisibleColumns: ["createTime", "updateTime", "printedCode"], crudApi: { ...Q }, hasPagination: true }, W), { maxHeight: E } = Y({ wrapperBox: ".artifact", paginate: true, extraHeight: 40 });
  return F(() => _.value, (y) => {
    y && (d.query.projectId = _.value, d.toQuery());
  }, { immediate: true, deep: true }), F(() => b.value, (y) => {
    var p, o, w;
    ((o = (p = b.value) == null ? void 0 : p.projectContentList) == null ? void 0 : o.length) > 0 ? v.value = ((w = b.value) == null ? void 0 : w.projectContentList.findIndex((x) => x.no === Z.STRUCTURE.V)) > -1 : v.value = true;
  }, { deep: true, immediate: true }), (y, p) => {
    var C, N, T, I, A, S;
    const o = K, w = L, x = U, G = H, P = V("common-table"), R = $;
    return i(), k("div", le, [v.value ? (i(), k(B, { key: 0 }, [h("div", re, [u(e(oe), { "project-id": e(_) }, null, 8, ["project-id"])]), q((i(), a(P, { ref_key: "tableRef", ref: W, data: e(d).data, "empty-text": e(d).emptyText !== "加载失败" ? e(d).emptyText : "暂无权限，请联系管理员", "max-height": e(E), showEmptySymbol: false, "return-source-data": "", style: { width: "100%" }, onSortChange: e(d).handleSortChange }, { default: n(() => [u(o, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(l).visible("batchNumber") ? (i(), a(o, { key: "batchNumber", "show-overflow-tooltip": true, label: "批次", "min-width": "100px", prop: "batchNumber", sortable: "custom" }, { default: n((t) => [m(s(t.row.batchNumber || "-"), 1)]), _: 1 })) : r("", true), e(l).visible("name") ? (i(), a(o, { key: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "100px", prop: "name", sortable: "custom" })) : r("", true), e(l).visible("serialNumber") ? (i(), a(o, { key: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140px", prop: "serialNumber", sortable: "custom" }, { header: n(() => [u(G, { content: "双击编号可预览图纸", class: "item", effect: "light", placement: "top" }, { default: n(() => [h("div", ne, [p[1] || (p[1] = h("span", null, "编号", -1)), u(x, null, { default: n(() => [u(w)]), _: 1 })])]), _: 1 })]), default: n((t) => [h("span", { style: { cursor: "pointer" }, onDblclick: (me) => e(M)(t.row) }, s(t.row.serialNumber), 41, se)]), _: 1 })) : r("", true), e(l).visible("specification") ? (i(), a(o, { key: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", prop: "specification", sortable: "custom" })) : r("", true), e(l).visible("length") ? (i(), a(o, { key: "length", label: `长度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "85px", prop: "length", sortable: "custom" }, { default: n((t) => [m(s(t.row.length ? t.row.length.toFixed(e(g).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : r("", true), e(l).visible("material") ? (i(), a(o, { key: "material", "show-overflow-tooltip": true, align: "center", label: "材质", "min-width": "80px", prop: "material", sortable: "custom" })) : r("", true), e(l).visible("quantity") ? (i(), a(o, { key: "quantity", align: "left", label: "数量", "min-width": "80px", prop: "quantity", sortable: "custom" })) : r("", true), e(l).visible("netWeight") ? (i(), a(o, { key: "netWeight", label: `单净重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "netWeight", sortable: "custom" }, { default: n((t) => [m(s(t.row.netWeight ? t.row.netWeight.toFixed(e(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : r("", true), e(l).visible("grossWeight") ? (i(), a(o, { key: "grossWeight", label: `单毛重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "grossWeight", sortable: "custom" }, { default: n((t) => [m(s(t.row.grossWeight ? t.row.grossWeight.toFixed(e(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : r("", true), e(l).visible("totalNetWeight") ? (i(), a(o, { key: "totalNetWeight", label: `总净重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "95px", prop: "totalNetWeight" }, { default: n((t) => [m(s(t.row.totalNetWeight ? t.row.totalNetWeight.toFixed(e(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : r("", true), e(l).visible("totalGrossWeight") ? (i(), a(o, { key: "totalGrossWeight", label: `总毛重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "95px", prop: "totalGrossWeight" }, { default: n((t) => [m(s(t.row.totalGrossWeight ? t.row.totalGrossWeight.toFixed(e(g).COM_WT__KG) : "-"), 1)]), _: 1 })) : r("", true), e(l).visible("drawingWeight") ? (i(), a(o, { prop: "drawingWeight", key: "drawingWeight", "show-overflow-tooltip": true, label: "图纸单重(kg)", align: "left", "min-width": "95px" })) : r("", true), e(l).visible("totalDrawingWeight") ? (i(), a(o, { prop: "totalDrawingWeight", key: "totalDrawingWeight", "show-overflow-tooltip": true, label: "图纸总重(kg)", align: "left", "min-width": "95px" })) : r("", true), e(l).visible("surfaceArea") ? (i(), a(o, { key: "surfaceArea", label: `面积
(㎡)`, align: "left", "min-width": "80px", prop: "surfaceArea", sortable: "custom" }, { default: n((t) => [m(s(t.row.surfaceArea ? t.row.surfaceArea.toFixed(e(g).COM_AREA__M2) : "-"), 1)]), _: 1 })) : r("", true), e(l).visible("drawingNumber") ? r("", true) : (i(), a(o, { key: "drawingNumber", "show-overflow-tooltip": true, label: "图号", "min-width": "100px", prop: "drawingNumber", sortable: "custom" })), e(l).visible("printedCode") ? (i(), a(o, { label: "喷印编码", key: "printedCode", prop: "printedCode", "min-width": "140px" }, { default: n((t) => [h("div", null, s(t.row.printedCode || "-"), 1)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[R, e(d).loading]]), u(e(ee)), u(e(ae), { modelValue: e(f), "onUpdate:modelValue": p[0] || (p[0] = (t) => O(f) ? f.value = t : null), "bool-bim": (C = e(c)) == null ? void 0 : C.boolBim, drawingSN: (N = e(c)) == null ? void 0 : N.drawingSN, monomerId: (T = e(c)) == null ? void 0 : T.monomerId, productId: (I = e(c)) == null ? void 0 : I.productId, productType: (A = e(c)) == null ? void 0 : A.productType, "serial-number": (S = e(c)) == null ? void 0 : S.serialNumber }, null, 8, ["modelValue", "bool-bim", "drawingSN", "monomerId", "productId", "productType", "serial-number"])], 64)) : (i(), k("span", de, "当前项目内容没有包含构件,请到合同管理中进行配置"))]);
  };
} }, ke = z(pe, [["__scopeId", "data-v-5abcbd92"]]);
export {
  ke as default
};
