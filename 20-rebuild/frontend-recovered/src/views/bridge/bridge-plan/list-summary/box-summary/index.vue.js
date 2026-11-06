import { ref as E } from "vue";
import { watch as F } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as K } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as i } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as d } from "vue";
import { createTextVNode as c } from "vue";
import { isRef as L } from "vue";
import { ElTableColumn as H } from "element-plus";
import { InfoFilled as U } from "@element-plus/icons-vue";
import { ElIcon as $ } from "element-plus";
import { ElTooltip as z } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as X, _ as J } from "./module/header.vue.js";
import { _ as Y, m as Z, x as ee, o as te, T as oe, F as re, K as ie, D as h, P as ae } from "../../../../../shared/runtime.js";
import { u as le } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { f as se } from "../../../../../modules/bridge-86f96a4f.js";
import { b as ne } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const pe = { class: "app-container" }, de = { class: "head-container" }, me = { style: { display: "inline-block" } }, ue = ["onDblclick"], ce = { key: 1, style: { color: "red", "font-size": "13px" } }, he = { __name: "index", setup(we) {
  const { globalProject: g, globalProjectId: f } = Z(["globalProject", "globalProjectId"]), { showDrawing: y, drawingRow: m, drawingPreview: R } = le({ pidField: "id" }), A = { add: false, edit: false, del: false, download: false }, T = E(), v = E(true), { crud: p, columns: a, CRUD: W } = ee({ title: "分段清单汇总", sort: ["id.asc"], permission: { ...se }, optShow: { ...A }, crudApi: { ...X }, hasPagination: true }, T), { maxHeight: G } = te({ wrapperBox: ".box-summary", paginate: true, extraHeight: 40 });
  return F(() => f.value, (w) => {
    w && p.toQuery();
  }, { immediate: true, deep: true }), F(() => g.value, (w) => {
    var n, o, _;
    ((o = (n = g.value) == null ? void 0 : n.projectContentList) == null ? void 0 : o.length) > 0 ? v.value = ((_ = g.value) == null ? void 0 : _.projectContentList.findIndex((x) => x.no === oe.BRIDGE.V)) > -1 : v.value = false;
  }, { deep: true, immediate: true }), W.HOOK.beforeRefresh = () => (p.query.projectId = f.value, p.query.projectId), W.HOOK.handleRefresh = (w, n) => {
    n.data.content = n.data.content.map((o) => (o.productType = re.BOX.V, o.projectType = ie.BRIDGE.V, o));
  }, (w, n) => {
    var C, I, N, j, M, S, D;
    const o = H, _ = U, x = $, P = z, B = q("common-table"), O = Q;
    return r(), k("div", pe, [v.value ? (r(), k(K, { key: 0 }, [b("div", de, [u(e(J), { "project-id": e(f) }, null, 8, ["project-id"])]), V((r(), i(B, { ref_key: "tableRef", ref: T, data: e(p).data, "empty-text": e(p).emptyText, "return-source-data": "", showEmptySymbol: false, "max-height": e(G), style: { width: "100%" }, onSortChange: e(p).handleSortChange }, { default: s(() => [u(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(a).visible("monomer.name") ? (r(), i(o, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体" })) : l("", true), e(a).visible("area.name") ? (r(), i(o, { key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域" })) : l("", true), e(a).visible("serialNumber") ? (r(), i(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "分段编号", "min-width": "140px" }, { header: s(() => [u(P, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: s(() => [b("div", me, [n[1] || (n[1] = b("span", null, "分段编号", -1)), u(x, null, { default: s(() => [u(_)]), _: 1 })])]), _: 1 })]), default: s((t) => [b("span", { style: { cursor: "pointer" }, onDblclick: (_e) => e(R)(t.row) }, d(t.row.serialNumber), 41, ue)]), _: 1 })) : l("", true), e(a).visible("specification") ? (r(), i(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })) : l("", true), e(a).visible("thickness") ? (r(), i(o, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [c(d(t.row.thickness ? t.row.thickness.toFixed(e(h).MES_ARTIFACT_T__MM) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("width") ? (r(), i(o, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `宽度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [c(d(t.row.width ? t.row.width.toFixed(e(h).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("length") ? (r(), i(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: s((t) => [c(d(t.row.length ? t.row.length.toFixed(e(h).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("material") ? (r(), i(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "center", "min-width": "80px" })) : l("", true), e(a).visible("quantity") ? (r(), i(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "数量", align: "left", "min-width": "80px" })) : l("", true), e(a).visible("netWeight") ? (r(), i(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: s((t) => [c(d(t.row.netWeight ? t.row.netWeight.toFixed(e(h).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("totalNetWeight") ? (r(), i(o, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": true, label: `总净重
(kg)`, align: "left", "min-width": "95px" }, { default: s((t) => [c(d(t.row.totalNetWeight ? t.row.totalNetWeight.toFixed(e(h).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("grossWeight") ? (r(), i(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: s((t) => [c(d(t.row.grossWeight ? t.row.grossWeight.toFixed(e(h).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("totalGrossWeight") ? (r(), i(o, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": true, label: `总毛重
(kg)`, align: "left", "min-width": "95px" }, { default: s((t) => [c(d(t.row.totalGrossWeight ? t.row.totalGrossWeight.toFixed(e(h).COM_WT__KG) : "-"), 1)]), _: 1 })) : l("", true), e(a).visible("surfaceArea") ? (r(), i(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", "show-overflow-tooltip": true, label: "面积", "min-width": "100px" })) : l("", true), e(a).visible("remark") ? (r(), i(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "120" })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[O, e(p).loading]]), u(e(ae))], 64)) : (r(), k("span", ce, "当前项目内容没有包含桥梁分段,请到合同管理中进行配置")), u(e(ne), { visible: e(y), "onUpdate:visible": n[0] || (n[0] = (t) => L(y) ? y.value = t : null), "bool-bim": (C = e(m)) == null ? void 0 : C.boolBim, drawingSN: (I = e(m)) == null ? void 0 : I.drawingSN, "monomer-id": (N = e(m)) == null ? void 0 : N.monomerId, "area-id": e(p).query.areaId, "serial-number": (j = e(m)) == null ? void 0 : j.serialNumber, productId: (M = e(m)) == null ? void 0 : M.productId, productType: (S = e(m)) == null ? void 0 : S.productType, projectType: (D = e(m)) == null ? void 0 : D.projectType, isBridge: "" }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType", "projectType"])]);
  };
} }, Me = Y(he, [["__scopeId", "data-v-ebd85875"]]);
export {
  Me as default
};
