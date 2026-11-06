import { ref as I } from "vue";
import { watch as M } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as R } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as h } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as p } from "vue";
import { createTextVNode as d } from "vue";
import { isRef as V } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTooltip as B } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as K } from "../../../../modules/artifact-bbca1257.js";
import { _ as L, m as U, x as H, o as $, T as Q, D as m, P as z } from "../../../../shared/runtime.js";
import { u as J } from "../../../../modules/use-drawing-8a7ba23b.js";
import X from "./module/header.vue.js";
import { y as Y } from "../../../../modules/plan-d12d7ccf.js";
import { a as Z } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/index-8356a01a.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const ee = { class: "app-container" }, te = { class: "head-container" }, oe = ["onDblclick"], ae = { key: 1, style: { color: "red", "font-size": "13px" } }, ie = { __name: "index", setup(re) {
  const { globalProject: w, globalProjectId: f } = U(["globalProject", "globalProjectId"]), { showDrawing: b, drawingRow: c, drawingPreview: F } = J({ pidField: "id", productTypeField: "ARTIFACT" }), j = { add: false, edit: false, del: false, download: false }, W = I(), v = I(true), { crud: u, columns: r } = H({ title: "构件清单", sort: ["id.asc"], permission: { ...Y }, optShow: { ...j }, requiredQuery: ["areaId"], crudApi: { ...K }, hasPagination: true }, W), { maxHeight: D } = $({ wrapperBox: ".artifact", paginate: true, extraHeight: 40 });
  return M(() => f.value, (y) => {
    y && (u.query.projectId = f.value, u.toQuery());
  }, { immediate: true, deep: true }), M(() => w.value, (y) => {
    var n, o, _;
    ((o = (n = w.value) == null ? void 0 : n.projectContentList) == null ? void 0 : o.length) > 0 ? v.value = ((_ = w.value) == null ? void 0 : _.projectContentList.findIndex((x) => x.no === Q.STRUCTURE.V)) > -1 : v.value = true;
  }, { deep: true, immediate: true }), (y, n) => {
    var T, N, C, A, S;
    const o = q, _ = B, x = P("common-table"), G = O;
    return a(), k("div", ee, [v.value ? (a(), k(R, { key: 0 }, [g("div", te, [h(e(X), { "project-id": e(f) }, null, 8, ["project-id"])]), E((a(), i(x, { ref_key: "tableRef", ref: W, data: e(u).data, "empty-text": e(u).emptyText, "max-height": e(D), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, onSortChange: e(u).handleSortChange }, { default: s(() => [h(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(r).visible("name") ? (a(), i(o, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "100px" })) : l("", true), e(r).visible("serialNumber") ? (a(), i(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { header: s(() => [h(_, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: s(() => n[1] || (n[1] = [g("div", { style: { display: "inline-block" } }, [g("span", null, "编号"), g("i", { class: "el-icon-info" })], -1)])), _: 1, __: [1] })]), default: s((t) => [g("span", { style: { cursor: "pointer" }, onDblclick: (le) => e(F)(t.row) }, p(t.row.serialNumber), 41, oe)]), _: 1 })) : l("", true), e(r).visible("specification") ? (a(), i(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })) : l("", true), e(r).visible("length") ? (a(), i(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [d(p(t.row.length ? t.row.length.toFixed(e(m).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : l("", true), e(r).visible("material") ? (a(), i(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" })) : l("", true), e(r).visible("quantity") ? (a(), i(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "left", "min-width": "80px" })) : l("", true), e(r).visible("netWeight") ? (a(), i(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: s((t) => [d(p(t.row.netWeight ? t.row.netWeight.toFixed(e(m).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(r).visible("grossWeight") ? (a(), i(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: s((t) => [d(p(t.row.grossWeight ? t.row.grossWeight.toFixed(e(m).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(r).visible("totalNetWeight") ? (a(), i(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: `总净重
(kg)`, align: "left", "min-width": "95px" }, { default: s((t) => [d(p(t.row.totalNetWeight ? t.row.totalNetWeight.toFixed(e(m).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(r).visible("totalGrossWeight") ? (a(), i(o, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: s((t) => [d(p(t.row.totalGrossWeight ? t.row.totalGrossWeight.toFixed(e(m).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(r).visible("surfaceArea") ? (a(), i(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: s((t) => [d(p(t.row.surfaceArea ? t.row.surfaceArea.toFixed(e(m).COM_AREA__M2) : "-"), 1)]), _: 1 })) : l("", true), e(r).visible("drawingNumber") ? (a(), i(o, { key: "drawingNumber", prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "100px" })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[G, e(u).loading]]), h(e(z)), h(e(Z), { modelValue: e(b), "onUpdate:modelValue": n[0] || (n[0] = (t) => V(b) ? b.value = t : null), "bool-bim": (T = e(c)) == null ? void 0 : T.boolBim, drawingSN: (N = e(c)) == null ? void 0 : N.drawingSN, "serial-number": (C = e(c)) == null ? void 0 : C.serialNumber, productId: (A = e(c)) == null ? void 0 : A.productId, productType: (S = e(c)) == null ? void 0 : S.productType }, null, 8, ["modelValue", "bool-bim", "drawingSN", "serial-number", "productId", "productType"])], 64)) : (a(), k("span", ae, "当前项目内容没有包含构件,请到合同管理中进行配置"))]);
  };
} }, we = L(ie, [["__scopeId", "data-v-4351a4c4"]]);
export {
  we as default
};
