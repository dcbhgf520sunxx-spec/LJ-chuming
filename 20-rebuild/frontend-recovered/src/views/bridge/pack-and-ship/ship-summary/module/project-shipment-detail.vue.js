import { ref as c } from "vue";
import { watch as q } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as e } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as h } from "vue";
import { unref as o } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as O } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElPagination as H } from "element-plus";
import { vLoading as A } from "element-plus";
import { i as K } from "../../../../../modules/ship-summary-9143cc4e.js";
import { o as U, J as W, q as J, bV as b, D as I } from "../../../../../shared/runtime.js";
const $ = { class: "detail-container" }, F = { style: { "margin-bottom": "10px", "min-height": "28px" }, class: "tag-div" }, X = { style: { float: "left" } }, Y = { style: { float: "right" } }, oe = { __name: "project-shipment-detail", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, productionLineTypeEnum: { type: Number }, workshopId: { type: Number } }, setup(w) {
  const t = w, d = c([]), p = c(false), y = c([]), l = c({ monomerId: void 0, areaId: void 0 }), { maxHeight: k } = U({ extraBox: ".tag-div", wrapperBox: [".app-container", ".detail-container"] }), { handleSizeChange: x, handleCurrentChange: C, total: j, setTotalPage: N, queryPage: g } = W({ fetchHook: u });
  q(() => t.currentRow.projectId, (n) => {
    n && u();
  }, { deep: true, immediate: true });
  function T(n) {
    y.value = n || [];
  }
  async function u() {
    if (d.value = [], !!t.currentRow.projectId) {
      p.value = true;
      try {
        const { content: n = [], totalElements: a } = await K({ projectId: t.currentRow.projectId, ...l.value, productionLineTypeEnum: t.productionLineTypeEnum, workshopId: t.workshopId, ...g });
        d.value = n, N(a), p.value = false;
      } catch (n) {
        console.log("获取详情失败", n), p.value = false;
      }
    }
  }
  return (n, a) => {
    const E = Q, R = f("common-select"), V = f("print-table"), r = G, z = f("common-table"), S = H, D = B("permission"), L = A;
    return v(), M("div", $, [s("div", F, [s("div", X, [e(E, { style: { "margin-right": "3px" } }, { default: m(() => [P(h(`项目:${t.currentRow.project.serialNumber + " " + t.currentRow.project.shortName}`), 1)]), _: 1 }), e(o(J), { ref: "monomerSelectRef", modelValue: l.value.monomerId, "onUpdate:modelValue": a[0] || (a[0] = (i) => l.value.monomerId = i), "project-id": t.currentRow.projectId, default: false, clearable: "", class: "filter-item", onChange: u, onGetAreaInfo: T }, null, 8, ["modelValue", "project-id"]), e(R, { modelValue: l.value.areaId, "onUpdate:modelValue": a[1] || (a[1] = (i) => l.value.areaId = i), options: y.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: u }, null, 8, ["modelValue", "options"])]), s("div", Y, [_(e(V, { "api-key": "bridgeProjectShipDetail", params: { projectId: t.currentRow.projectId, productionLineTypeEnum: t.productionLineTypeEnum, workshopId: t.workshopId, monomerId: l.value.monomerId, areaId: l.value.areaId }, size: "default", type: "warning" }, null, 8, ["params"]), [[D, w.permission.print]])])]), _((v(), O(z, { data: d.value, "max-height": o(k) - 70 }, { default: m(() => [e(r, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": true }), e(r, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": true }), e(r, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), e(r, { key: "weight", prop: "weight", label: "单重", align: "right", "show-overflow-tooltip": true }, { default: m((i) => [s("span", null, h(o(b)(i.row.weight, o(I).COM_WT__KG)), 1), a[2] || (a[2] = s("span", { style: { "margin-left": "3px" } }, "kg", -1))]), _: 1 }), e(r, { key: "quantity", prop: "quantity", label: "清单数", align: "center", "show-overflow-tooltip": true }), e(r, { key: "inboundQuantity", prop: "inboundQuantity", label: "入库数", align: "center", "show-overflow-tooltip": true }), e(r, { key: "cargoQuantity", prop: "cargoQuantity", label: "发运数", align: "center", "show-overflow-tooltip": true }), e(r, { key: "cargoMete", prop: "cargoMete", label: "发运量", align: "right", "show-overflow-tooltip": true }, { default: m((i) => [s("span", null, h(o(b)(i.row.cargoMete, o(I).COM_WT__KG)), 1), a[3] || (a[3] = s("span", { style: { "margin-left": "3px" } }, "kg", -1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[L, p.value]]), e(S, { total: o(j), "current-page": o(g).pageNumber, "page-size": o(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(x), onCurrentChange: o(C) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} };
export {
  oe as default
};
