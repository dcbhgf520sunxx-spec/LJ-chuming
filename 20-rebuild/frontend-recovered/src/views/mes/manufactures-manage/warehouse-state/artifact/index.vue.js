import { ref as y } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as s } from "vue";
import { createTextVNode as u } from "vue";
import { ElTableColumn as W } from "element-plus";
import { vLoading as C } from "element-plus";
import { g as Q } from "../../../../../modules/common-85b8c78d.js";
import { x as M, o9 as A, o as N, bs as p, D as d, P as T } from "../../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const S = { class: "app-container" }, L = { __name: "index", setup(q) {
  const w = { add: false, edit: false, del: false, download: false }, h = y(), { crud: m, columns: a } = M({ title: "构件出入库状态", sort: [], permission: { ...A }, optShow: { ...w }, crudApi: { get: Q }, requiredQuery: ["areaId"], invisibleColumns: ["surfaceArea", "drawingNumber"], queryOnPresenterCreated: false }, h), { maxHeight: g } = N({ paginate: true });
  return (D, B) => {
    const o = W, f = v("common-table"), _ = C;
    return t(), k("div", S, [c(e(O)), x((t(), i(f, { ref_key: "tableRef", ref: h, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(g), style: { width: "100%" }, onSortChange: e(m).handleSortChange }, { default: n(() => [c(o, { label: "序号", fixed: "", type: "index", align: "center", width: "60" }), e(a).visible("name") ? (t(), i(o, { key: "name", prop: "name", sortable: "custom", fixed: "", "show-overflow-tooltip": true, label: "名称", "min-width": "120" })) : l("", true), e(a).visible("serialNumber") ? (t(), i(o, { key: "serialNumber", prop: "serialNumber", sortable: "custom", fixed: "", "show-overflow-tooltip": true, label: "编号", "min-width": "110px" })) : l("", true), e(a).visible("specification") ? (t(), i(o, { key: "specification", prop: "specification", sortable: "custom", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }, { default: n((r) => [b("span", null, s(r.row.specification), 1)]), _: 1 })) : l("", true), e(a).visible("length") ? (t(), i(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: n((r) => [u(s(e(p)(r.row.length, e(d).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : l("", true), e(a).visible("material") ? (t(), i(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: n((r) => [b("span", null, s(r.row.material), 1)]), _: 1 })) : l("", true), e(a).visible("weight") ? (t(), i(o, { key: "weight", prop: "weight", sortable: "custom", "show-overflow-tooltip": true, label: `单重
(kg)`, align: "left", "min-width": "80px" }, { default: n((r) => [u(s(e(p)(r.row.weight, e(d).COM_WT__KG)), 1)]), _: 1 })) : l("", true), e(a).visible("totalWeight") ? (t(), i(o, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": true, label: `总重
(kg)`, align: "center", "min-width": "120" }, { default: n((r) => [u(s(e(p)(r.row.totalWeight, e(d).COM_WT__KG)), 1)]), _: 1 })) : l("", true), e(a).visible("surfaceArea") ? (t(), i(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: n((r) => [u(s(e(p)(r.row.surfaceArea, e(d).COM_AREA__M2)), 1)]), _: 1 })) : l("", true), e(a).visible("drawingNumber") ? (t(), i(o, { key: "drawingNumber", prop: "drawingNumber", "show-overflow-tooltip": true, label: "图号", "min-width": "120" })) : l("", true), e(a).visible("quantity") ? (t(), i(o, { key: "quantity", prop: "quantity", label: "清单数量", align: "center", "min-width": "100px" })) : l("", true), e(a).visible("taskQuantity") ? (t(), i(o, { key: "taskQuantity", prop: "taskQuantity", label: "任务数量", align: "center", "min-width": "100px" })) : l("", true), e(a).visible("inboundQuantity") ? (t(), i(o, { key: "inboundQuantity", prop: "inboundQuantity", "show-overflow-tooltip": true, label: "入库数量", align: "center", "min-width": "100px" })) : l("", true), e(a).visible("outboundQuantity") ? (t(), i(o, { key: "outboundQuantity", prop: "outboundQuantity", "show-overflow-tooltip": true, label: "出库数量", align: "center", "min-width": "100px" })) : l("", true), e(a).visible("stockQuantity") ? (t(), i(o, { key: "stockQuantity", prop: "stockQuantity", "show-overflow-tooltip": true, label: "库存数量", align: "center", "min-width": "100px" })) : l("", true), e(a).visible("inboundWeight") ? (t(), i(o, { key: "inboundWeight", prop: "inboundWeight", "show-overflow-tooltip": true, label: `入库重量
(kg)`, align: "center", "min-width": "120" }, { default: n((r) => [u(s(e(p)(r.row.inboundWeight, e(d).COM_WT__KG)), 1)]), _: 1 })) : l("", true), e(a).visible("outboundWeight") ? (t(), i(o, { key: "outboundWeight", prop: "outboundWeight", "show-overflow-tooltip": true, label: `出库重量
(kg)`, align: "center", "min-width": "120" }, { default: n((r) => [u(s(e(p)(r.row.outboundWeight, e(d).COM_WT__KG)), 1)]), _: 1 })) : l("", true), e(a).visible("stockWeight") ? (t(), i(o, { key: "stockWeight", prop: "stockWeight", "show-overflow-tooltip": true, label: `库存重量
(kg)`, align: "center", "min-width": "120" }, { default: n((r) => [u(s(e(p)(r.row.stockWeight, e(d).COM_WT__KG)), 1)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[_, e(m).loading]]), c(e(T))]);
  };
} };
export {
  L as default
};
