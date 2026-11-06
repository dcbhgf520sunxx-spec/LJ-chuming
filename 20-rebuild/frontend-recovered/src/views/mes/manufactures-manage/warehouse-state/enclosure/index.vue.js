import { ref as y } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as h } from "vue";
import { unref as t } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as u } from "vue";
import { ElTableColumn as x } from "element-plus";
import { vLoading as E } from "element-plus";
import { b as S } from "../../../../../modules/common-85b8c78d.js";
import { x as M, oa as C, o as N, bs as c, D as p, c as d, P as Q } from "../../../../../shared/runtime.js";
import R from "./module/header.vue.js";
import "../../../../../modules/index-b238c21c.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const U = { class: "app-container" }, I = { __name: "index", setup(O) {
  const w = { add: false, edit: false, del: false, download: false }, b = y(), { crud: m, columns: n } = M({ title: "围护出入库状态", sort: [], permission: { ...C }, optShow: { ...w }, crudApi: { get: S }, requiredQuery: ["areaId"], invisibleColumns: ["surfaceArea", "inboundLength", "outboundLength", "stockLength"], queryOnPresenterCreated: false }, b), { maxHeight: _ } = N({ paginate: true });
  return (q, D) => {
    const o = x, g = v("common-table"), f = E;
    return e(), k("div", U, [h(t(R)), L((e(), i(g, { ref_key: "tableRef", ref: b, data: t(m).data, "empty-text": t(m).emptyText, "max-height": t(_), style: { width: "100%" }, onSortChange: t(m).handleSortChange }, { default: r(() => [h(o, { label: "序号", fixed: "", type: "index", align: "center", width: "60" }), t(n).visible("name") ? (e(), i(o, { key: "name", prop: "name", fixed: "", sortable: "custom", "show-overflow-tooltip": true, label: "名称", "min-width": "120" })) : l("", true), t(n).visible("serialNumber") ? (e(), i(o, { key: "serialNumber", prop: "serialNumber", fixed: "", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "100px" })) : l("", true), t(n).visible("plate") ? (e(), i(o, { key: "plate", prop: "plate", sortable: "custom", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" })) : l("", true), t(n).visible("color") ? (e(), i(o, { key: "color", prop: "color", sortable: "custom", "show-overflow-tooltip": true, label: "颜色", "min-width": "100px" })) : l("", true), t(n).visible("thickness") ? (e(), i(o, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: r((a) => [s(u(t(c)(a.row.thickness, t(p).MES_ENCLOSURE_T__MM)), 1)]), _: 1 })) : l("", true), t(n).visible("width") ? (e(), i(o, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `有效宽度
(mm)`, align: "left", "min-width": "85px" }, { default: r((a) => [s(u(t(c)(a.row.width, t(p).MES_ENCLOSURE_W__MM)), 1)]), _: 1 })) : l("", true), t(n).visible("length") ? (e(), i(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: r((a) => [s(u(t(c)(a.row.length, t(p).MES_ENCLOSURE_L__MM)), 1)]), _: 1 })) : l("", true), t(n).visible("totalLength") ? (e(), i(o, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": true, label: `总长度
(m)`, align: "left", "min-width": "100px" }, { default: r((a) => [s(u(t(d)(a.row.totalLength, "mm", "m", t(p).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : l("", true), t(n).visible("quantity") ? (e(), i(o, { key: "quantity", prop: "quantity", label: "清单数量", align: "center", "min-width": "100px" })) : l("", true), t(n).visible("taskQuantity") ? (e(), i(o, { key: "taskQuantity", prop: "taskQuantity", label: "任务数量", align: "center", "min-width": "100px" })) : l("", true), t(n).visible("inboundQuantity") ? (e(), i(o, { key: "inboundQuantity", prop: "inboundQuantity", "show-overflow-tooltip": true, label: "入库数量", align: "center", "min-width": "100px" })) : l("", true), t(n).visible("outboundQuantity") ? (e(), i(o, { key: "outboundQuantity", prop: "outboundQuantity", "show-overflow-tooltip": true, label: "出库数量", align: "center", "min-width": "100px" })) : l("", true), t(n).visible("stockQuantity") ? (e(), i(o, { key: "stockQuantity", prop: "stockQuantity", "show-overflow-tooltip": true, label: "库存数量", align: "center", "min-width": "100px" })) : l("", true), t(n).visible("inboundLength") ? (e(), i(o, { key: "inboundLength", prop: "inboundLength", "show-overflow-tooltip": true, label: `入库长度
(m)`, align: "center", "min-width": "120" }, { default: r((a) => [s(u(t(d)(a.row.inboundLength, "mm", "m", t(p).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : l("", true), t(n).visible("outboundLength") ? (e(), i(o, { key: "outboundLength", prop: "outboundLength", "show-overflow-tooltip": true, label: `出库长度
(m)`, align: "center", "min-width": "120" }, { default: r((a) => [s(u(t(d)(a.row.outboundLength, "mm", "m", t(p).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : l("", true), t(n).visible("stockLength") ? (e(), i(o, { key: "stockLength", prop: "stockLength", "show-overflow-tooltip": true, label: `库存长度
(m)`, align: "center", "min-width": "120" }, { default: r((a) => [s(u(t(d)(a.row.stockLength, "mm", "m", t(p).MES_ENCLOSURE_L__M)), 1)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[f, t(m).loading]]), h(t(Q))]);
  };
} };
export {
  I as default
};
