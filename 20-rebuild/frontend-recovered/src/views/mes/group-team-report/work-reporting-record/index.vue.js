import { ref as w } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as o } from "vue";
import { unref as n } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as r } from "vue";
import { ElTableColumn as y } from "element-plus";
import { vLoading as b } from "element-plus";
import { c as N, _ as g } from "./module/header.vue.js";
import { x as k, nJ as v, o as x, P as Q } from "../../../../shared/runtime.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const B = { class: "app-container" }, j = { class: "head-container" }, E = { __name: "index", setup(C) {
  const p = w(), { crud: i } = k({ title: "报工记录", sort: [], permission: { permission: v }, crudApi: { ...N }, hasPagination: true }, p), { maxHeight: m } = x({ paginate: true });
  return (R, S) => {
    const t = y, c = d("common-table"), u = b;
    return s(), h("div", B, [a("div", j, [o(n(g))]), f((s(), _(c, { ref_key: "tableRef", ref: p, data: n(i).data, "empty-text": n(i).emptyText, "max-height": n(m), showEmptySymbol: false, "row-key": "id", style: { width: "100%" } }, { default: l(() => [o(t, { label: "序号", type: "index", align: "center", width: "50" }), o(t, { align: "center", key: "workshopName", prop: "workshopName", "show-overflow-tooltip": "", label: "车间" }, { default: l((e) => [a("span", null, r(e.row.workshopName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "productionLineName", prop: "productionLineName", "show-overflow-tooltip": "", label: "产线" }, { default: l((e) => [a("span", null, r(e.row.productionLineName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "projectName", prop: "projectName", "show-overflow-tooltip": "", label: "项目名称", "min-width": "120" }, { default: l((e) => [a("span", null, r(e.row.projectName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "projectSerialNumber", prop: "projectSerialNumber", "show-overflow-tooltip": "", label: "项目编号", width: "100" }, { default: l((e) => [a("span", null, r(e.row.projectSerialNumber || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体名称" }, { default: l((e) => [a("span", null, r(e.row.monomerName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "areaName", prop: "areaName", "show-overflow-tooltip": "", label: "区域名称" }, { default: l((e) => [a("span", null, r(e.row.areaName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "areaBatchName", prop: "areaBatchName", "show-overflow-tooltip": "", label: "批次名称" }, { default: l((e) => [a("span", null, r(e.row.areaBatchName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "processName", prop: "processName", "show-overflow-tooltip": "", label: "工序", width: "100" }, { default: l((e) => [a("span", null, r(e.row.processName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "产品编号" }, { default: l((e) => [a("span", null, r(e.row.serialNumber || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "清单数量", width: "80" }, { default: l((e) => [a("span", null, r(e.row.quantity ?? "-"), 1)]), _: 1 }), o(t, { align: "center", key: "reportQuantity", prop: "reportQuantity", "show-overflow-tooltip": "", label: "生产数量", width: "80" }, { default: l((e) => [a("span", null, r(e.row.reportQuantity ?? "-"), 1)]), _: 1 }), o(t, { align: "center", key: "inspectionQuantity", prop: "inspectionQuantity", "show-overflow-tooltip": "", label: "质检通过数量", width: "100" }, { default: l((e) => [a("span", null, r(e.row.inspectionQuantity ?? "-"), 1)]), _: 1 }), o(t, { align: "center", key: "problemQuantity", prop: "problemQuantity", "show-overflow-tooltip": "", label: "问题数量", width: "80" }, { default: l((e) => [a("span", null, r(e.row.problemQuantity ?? "-"), 1)]), _: 1 }), o(t, { align: "center", key: "number", prop: "number", "show-overflow-tooltip": "", label: "一物一码号", width: "100" }, { default: l((e) => [a("span", null, r(e.row.number || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "teamUserName", prop: "teamUserName", "show-overflow-tooltip": "", label: "班组长名", width: "100" }, { default: l((e) => [a("span", null, r(e.row.teamUserName || "-"), 1)]), _: 1 }), o(t, { align: "center", key: "reportTime", prop: "reportTime", "show-overflow-tooltip": "", label: "上报时间" }, { default: l((e) => [a("span", null, r(e.row.reportTime || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[u, n(i).loading]]), o(n(Q))]);
  };
} };
export {
  E as default
};
