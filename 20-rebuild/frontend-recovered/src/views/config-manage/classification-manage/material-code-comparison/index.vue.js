import { ref as u } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as m } from "vue";
import { unref as a } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as l } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as g } from "vue";
import { ElTableColumn as x } from "element-plus";
import { vLoading as C } from "element-plus";
import { c as S } from "./module/form.vue.js";
import { _ as T, x as B, cN as V, o as D, cJ as E, P as H } from "../../../../shared/runtime.js";
import P from "./module/header.vue.js";
import "./module/application/table/index.vue.js";
import "./module/application/table/module/steel-plate.vue.js";
import "./module/application/table/module/section-steel.vue.js";
import "./module/application/table/module/other.vue.js";
import "./module/application/table/module/edit-table.vue.js";
import "./module/application/table/module/steel-coil.vue.js";
import "./module/application/table/module/other-steel-material.vue.js";
import "./module/application/table/module/auxiliary-material.vue.js";
import "./module/application/table/module/gas.vue.js";
const R = { class: "app-container" }, M = { __name: "index", setup(A) {
  const f = { add: true, edit: false, del: false, download: false }, _ = u([["updateTime", ["parse-time", "{y}-{m}-{d}"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]]]), d = u(), { crud: c, columns: r } = B({ title: "物料编码对照表", sort: [], permission: { ...V }, optShow: { ...f }, crudApi: { ...S }, invisibleColumns: [], hasPagination: true }, d), { maxHeight: w } = D({ wrapperBox: ".changeReason", paginate: true, extraHeight: 40 });
  return (F, L) => {
    const t = x, h = v("common-table"), b = C;
    return i(), y(g, null, [o("div", R, [m(a(P)), N((i(), l(h, { ref_key: "tableRef", ref: d, data: a(c).data, "data-format": _.value, "max-height": a(w), showEmptySymbol: false, "return-source-data": "", style: { width: "100%" }, onSelectionChange: a(c).selectionChangeHandler }, { default: s(() => [m(t, { align: "center", fixed: "left", type: "selection", width: "40" }), m(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), a(r).visible("basicClass") ? (i(), l(t, { key: "basicClass", "show-overflow-tooltip": true, label: "材料类型", "min-width": "80", prop: "basicClass" }, { default: s(({ row: e }) => [o("span", null, n(a(E).VL[e.basicClass] || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("classifyName") ? (i(), l(t, { key: "classifyName", "show-overflow-tooltip": true, label: "物料名称", "min-width": "80", prop: "classifyName" }, { default: s(({ row: e }) => [o("span", null, n(e.classifyName || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("specificationNew") ? (i(), l(t, { key: "specificationNew", "show-overflow-tooltip": true, label: "规格", "min-width": "80", prop: "specificationNew" }, { default: s(({ row: e }) => [o("span", null, n(e.specificationNew || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("materialSn") ? (i(), l(t, { key: "materialSn", "show-overflow-tooltip": true, label: "物料编码", "min-width": "80", prop: "materialSn" }, { default: s(({ row: e }) => [o("span", null, n(e.materialSn || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("materialSnNew") ? (i(), l(t, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", "min-width": "80", prop: "materialSnNew" }, { default: s(({ row: e }) => [o("span", null, n(e.materialSnNew || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("applicantName") ? (i(), l(t, { key: "applicantName", "show-overflow-tooltip": true, label: "创建人", "min-width": "80", prop: "applicantName" }, { default: s(({ row: e }) => [o("span", null, n(e.applicantName || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("createTime") ? (i(), l(t, { key: "createTime", "show-overflow-tooltip": true, label: "创建时间", "min-width": "80", prop: "createTime" }, { default: s(({ row: e }) => [o("span", null, n(e.createTime || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("editorName") ? (i(), l(t, { key: "editorName", "show-overflow-tooltip": true, label: "编辑人", "min-width": "80", prop: "editorName" }, { default: s(({ row: e }) => [o("span", null, n(e.editorName || "-"), 1)]), _: 1 })) : p("", true), a(r).visible("updateTime") ? (i(), l(t, { key: "updateTime", "show-overflow-tooltip": true, label: "编辑时间", "min-width": "80", prop: "updateTime" }, { default: s(({ row: e }) => [o("span", null, n(e.updateTime || "-"), 1)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[b, a(c).loading]]), m(H)])], 64);
  };
} }, Z = T(M, [["__scopeId", "data-v-e512272c"]]);
export {
  Z as default
};
