import { inject as b } from "vue";
import { computed as w } from "vue";
import { resolveComponent as T } from "vue";
import { withDirectives as y } from "vue";
import { unref as t } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as e } from "vue";
import { withCtx as o } from "vue";
import { Fragment as x } from "vue";
import { renderList as W } from "vue";
import { createBlock as N } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as _ } from "vue";
import { ElCol as P } from "element-plus";
import { ElRow as j } from "element-plus";
import { ElTableColumn as C } from "element-plus";
import { vLoading as E } from "element-plus";
import { P as s } from "../../../../../../modules/index-5b9e6004.js";
import { u as G } from "../../../../../../modules/use-monomer-area-change-do-01946f79.js";
import { _ as k, bo as S } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../../modules/project-production-statistics-850038ba.js";
const D = { class: "panel-table-container" }, Q = { __name: "panel-table", setup(R) {
  const m = b("commonQuery"), l = w(() => m.weightType === S.NET.V), { projectProductionTotal: n, loading: f, projectProductionDetail: p } = G();
  return (B, M) => {
    const r = P, g = j, a = C, h = T("common-table"), v = E;
    return y((i(), u("div", D, [e(g, { gutter: 10, class: "panel-group" }, { default: o(() => [e(r, { span: 5, class: "card-panel-col" }, { default: o(() => [e(t(s), { name: "项目总量(吨)", "text-color": "#626262", "num-color": "#2d2d2d", "end-val": t(n)[l.value ? "totalNetWeight" : "totalGrossWeight"] || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 5, class: "card-panel-col" }, { default: o(() => [e(t(s), { name: "在制品(吨)", "text-color": "#626262", "num-color": "#ff9f2c", "end-val": t(n)[l.value ? "inProductionTotalNetWeight" : "inProductionTotalGrossWeight"] || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 5, class: "card-panel-col" }, { default: o(() => [e(t(s), { name: "制成品(吨)", "text-color": "#626262", "num-color": "#00751f", "end-val": t(n)[l.value ? "companyTotalNetWeight" : "companyTotalGrossWeight"] || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 5, class: "card-panel-col" }, { default: o(() => [e(t(s), { name: "完成率", "text-color": "#626262", "num-color": "#2d2d2d", "end-val": t(n).finishingRate || 0, suffix: "%", precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(r, { span: 5, class: "card-panel-col" }, { default: o(() => [e(t(s), { name: "领料(吨)", "text-color": "#626262", "num-color": "#ff0f1a", "end-val": t(n).projectGetMaterialsTotalWeight || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }), e(h, { ref: "tableRef", data: [t(p)], stripe: false, style: { width: "100%" }, "max-height": "200" }, { default: o(() => [e(a, { label: "清单量(吨)", align: "center", prop: l.value ? "totalNetWeight" : "totalGrossWeight", "show-overflow-tooltip": true }, null, 8, ["prop"]), e(a, { label: "排产量(吨)", align: "center", prop: l.value ? "totalSchedulingNetWeight" : "totalSchedulingGrossWeight", "show-overflow-tooltip": true }, null, 8, ["prop"]), e(a, { label: "领料量(吨)", align: "center", prop: "projectGetMaterialsTotalWeight", "show-overflow-tooltip": true }), (i(true), u(x, null, W(t(p).productionStatisticsProcessDTOS, (c) => (i(), N(a, { key: c.id, label: c.processName, align: "center" }, { default: o(() => [e(a, { label: "任务数", align: "center", width: "100", "show-overflow-tooltip": true }, { default: o(() => [d(_(c.taskTotalQuantity), 1)]), _: 2 }, 1024), e(a, { label: "完成数", align: "center", width: "100", "show-overflow-tooltip": true }, { default: o(() => [d(_(c.taskCompanyTotalQuantity), 1)]), _: 2 }, 1024)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data"])])), [[v, t(f)]]);
  };
} }, O = k(Q, [["__scopeId", "data-v-439fe04b"]]);
export {
  O as default
};
