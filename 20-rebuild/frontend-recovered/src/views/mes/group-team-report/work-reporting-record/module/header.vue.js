import h from "moment";
import { ref as p } from "vue";
import { computed as D } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as O } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { withCtx as B } from "vue";
import { withKeys as A } from "vue";
import { withDirectives as E } from "vue";
import { ElCascader as P } from "element-plus";
import { ElInput as R } from "element-plus";
import { ElDatePicker as z } from "element-plus";
import { l as y, a3 as I, B as K, fv as M, i as $, bZ as q, C as J } from "../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../modules/process-select-b35dffc0.js";
function W(i) {
  return y({ module: "mes", url: "production/signage/project/page/teamReport/product", method: "get", params: i });
}
function F(i) {
  return y({ module: "mes", url: "production/signage/project/workshop/list", method: "get", params: i });
}
const oe = { get: W }, H = { class: "head-container" }, Y = { class: "flex-rbc" }, Z = { __name: "header", setup(i) {
  const _ = { productType: void 0, projectId: void 0, monomerId: void 0, areaId: void 0, areaBatchId: void 0, workshopId: void 0, productionLineId: void 0, teamId: void 0, serialNumber: void 0, processId: void 0, workshopProductionLine: [], dateTimeList: [h().valueOf(), h().valueOf()] }, g = p(), b = p([I.ARTIFACT, I.ASSEMBLE]), w = p([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = p(), V = D(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", checkStrictly: true })), T = async () => {
    const r = await F({ productType: e.productType });
    if (r.length) {
      const t = JSON.parse(JSON.stringify(r));
      t.map((l) => {
        l.children = l.projectProductionLineDTOS || [], l.children.map((d) => {
          d.children = d.projectTeamDTOS || [], d.children.map((s) => {
            s.name = s.userName + " - " + s.processName || "";
          });
        });
      }), c.value = t;
    }
  };
  function v(r) {
    r ? (e.workshopId = r[0] || void 0, e.productionLineId = r[1] || void 0, e.teamId = r[2] || void 0) : (e.workshopId = void 0, e.productionLineId = void 0, e.teamId = void 0);
  }
  function k(r) {
    T();
  }
  const { crud: f, query: e } = K(_);
  return (r, t) => {
    const l = u("common-radio-button"), d = u("common-select"), s = P, x = R, S = z, j = u("print-table"), L = N("permission");
    return O(), U("div", H, [m("div", null, [n(l, { modelValue: o(e).productType, "onUpdate:modelValue": t[0] || (t[0] = (a) => o(e).productType = a), options: b.value, type: "enum", default: "", size: "default", class: "filter-item", onChange: k }, null, 8, ["modelValue", "options"]), n(o(M), { modelValue: o(e).projectId, "onUpdate:modelValue": t[1] || (t[1] = (a) => o(e).projectId = a), class: "filter-item", style: { width: "300px" }, filterable: "", clearable: "", placeholder: "可选择项目搜索" }, null, 8, ["modelValue"]), n(o(q), { ref_key: "monomerAreaRef", ref: g, areaId: o(e).areaId, "onUpdate:areaId": t[3] || (t[3] = (a) => o(e).areaId = a), monomerId: o(e).monomerId, "onUpdate:monomerId": t[4] || (t[4] = (a) => o(e).monomerId = a), "project-id": o(e).projectId, areaClearable: "", clearable: "" }, { right: B(({ batchList: a }) => [n(d, { modelValue: o(e).areaBatchId, "onUpdate:modelValue": t[2] || (t[2] = (C) => o(e).areaBatchId = C), options: a, size: "default", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: o($)(o(e).projectId) ? "暂无数据" : "未选择项目", class: "filter-item", placeholder: "请选择批次", style: { width: "350px" } }, null, 8, ["modelValue", "options", "noDataText"])]), _: 1 }, 8, ["areaId", "monomerId", "project-id"])]), m("div", Y, [m("div", null, [n(s, { class: "filter-item", modelValue: o(e).workshopProductionLine, "onUpdate:modelValue": t[5] || (t[5] = (a) => o(e).workshopProductionLine = a), options: c.value, props: V.value, filterable: "", clearable: "", "show-all-levels": "", placeholder: "请选择车间/生产线", onChange: v, style: { width: "250px" } }, null, 8, ["modelValue", "options", "props"]), n(x, { modelValue: o(e).serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (a) => o(e).serialNumber = a), placeholder: "输入产品编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: A(o(f).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(o(Q), { modelValue: o(e).processId, "onUpdate:modelValue": t[7] || (t[7] = (a) => o(e).processId = a), class: "filter-item", multiple: false, clearable: "", placeholder: "请选择工序", "product-type": o(e).productType, style: { width: "200px" } }, null, 8, ["modelValue", "product-type"]), n(S, { modelValue: o(e).dateTimeList, "onUpdate:modelValue": t[8] || (t[8] = (a) => o(e).dateTimeList = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", "default-time": w.value, "value-format": "x", style: { width: "240px" } }, null, 8, ["modelValue", "default-time"]), n(o(J))]), E(n(j, { "api-key": "workReportingRecord", params: o(e), size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, o(f).permission.print]])])]);
  };
} }, te = Object.freeze(Object.defineProperty({ __proto__: null, default: Z }, Symbol.toStringTag, { value: "Module" }));
export {
  Z as _,
  oe as c,
  te as h
};
