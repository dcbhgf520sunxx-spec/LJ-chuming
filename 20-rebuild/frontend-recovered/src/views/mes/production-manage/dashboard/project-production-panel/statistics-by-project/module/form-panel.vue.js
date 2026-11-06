import { inject as x } from "vue";
import { ref as c } from "vue";
import { provide as K } from "vue";
import { watch as M } from "vue";
import { resolveComponent as W } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as S } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as _ } from "vue";
import { Fragment as $ } from "vue";
import { renderList as q } from "vue";
import { createBlock as E } from "vue";
import { createTextVNode as B } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as G } from "vue";
import H from "moment";
import { ElTableColumn as J } from "element-plus";
import { ElTag as Y } from "element-plus";
import { ElPagination as X } from "element-plus";
import Z from "./module/form-header.vue.js";
import ee from "./module/process-detail.vue.js";
import { _ as te, J as ae, G as oe, pI as ne, o as se, i as Q, pJ as v, pK as re, b as R, pL as b } from "../../../../../../../shared/runtime.js";
import { b as le, d as ie } from "../../../../../../../modules/project-production-panel-fb6946a2.js";
import "./components/panel-echarts.vue.js";
import "../../../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../../../modules/index-18acf776.js";
import "./components/workshop-cascader.vue.js";
import "../../../../../../../modules/project-production-statistics-850038ba.js";
import "./module/production-status.vue.js";
import "./module/shipping-table.vue.js";
import "./module/reported-detail.vue.js";
import "./module/inspection-table.vue.js";
const ce = { class: "table-container" }, pe = { __name: "form-panel", setup(ue) {
  const k = x("projectId"), I = x("globalLoading"), w = () => ({ areaIds: [], classId: "", monomerId: "", areaBatchIds: [], projectId: k, serialNumber: "", workShopId: void 0, productKanBanEnum: re.UNFINISHED_ARTIFACT.V, productionLineId: void 0, dateTimeList: [H().startOf("month").valueOf(), H().valueOf()] }), m = c(w()), C = c([]), d = c(false);
  async function j() {
    if (!k) return;
    const { content: a = [] } = await ie(m.value);
    C.value = a;
  }
  const { handleSizeChange: D, handleCurrentChange: O, total: z, setTotalPage: L, queryPage: g } = ae({ fetchHook: P }), N = c([]);
  async function P() {
    if (oe(ne.getFormList)) {
      I.value = true;
      try {
        const a = { ...m.value, ...g };
        j();
        const { content: i = [], totalElements: e = 0 } = await le(a);
        N.value = i, L(e);
      } finally {
        I.value = false;
      }
    }
  }
  K("tableRelated", { query: m, defaultQuery: w, renderTable: P });
  const y = c(), { maxHeight: U, fixMaxHeight: A } = se({ extraBox: [".form-panel-header", ".toggle-container"], extraHeight: 10, paginate: true }, () => {
    var a;
    return (a = y.value) == null ? void 0 : a.searchToggle;
  });
  M(() => {
    var a;
    return (a = y.value) == null ? void 0 : a.searchToggle;
  }, (a) => {
    A();
  }, { immediate: true });
  const l = (a, i) => {
    var u;
    const e = { type: "info", result: null, firstVal: null, lastVal: null, inspectionUserName: null }, t = (u = a.productionKanBanProcessDTOS) == null ? void 0 : u.find((h) => h.processName === i.name);
    if (R(t)) return { ...e, type: "info" };
    switch (t.productKanBanCompanyStatusEnum) {
      case b.NO_START.V:
        e.type = "warning";
        break;
      case b.PRODUCTION.V:
        e.type = "warning";
        break;
      case b.FINISH.V:
        e.type = "success";
        break;
    }
    return t.processType === v.INSPECTION.V && (t.totalReportQuantity === 0 ? e.type = "info" : t.totalTaskQuantity === t.totalInspectionQuantity ? e.type = "success" : (t.totalInspectionQuantity === 0 || t.totalInspectionQuantity < t.totalTaskQuantity) && (e.type = "warning")), t.processType === v.SHIPPING.V && t.totalNeedQuantity === 0 && (e.type = "info"), e.result = t, e.firstVal = t.totalReportQuantity, e.lastVal = t.totalTaskQuantity, e.inspectionUserName = t.inspectionUserName, e;
  }, T = c({}), F = (a) => {
    R(a) || (T.value = a, d.value = true);
  };
  return (a, i) => {
    const e = J, t = Y, u = W("common-table"), h = X;
    return f(), V("div", null, [n(Z, { ref_key: "formHeaderRef", ref: y }, null, 512), S("div", ce, [n(u, { ref: "tableRef", data: N.value, stripe: false, style: { width: "100%" }, "max-height": s(U) }, { default: p(() => [n(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), n(e, { label: "名称", align: "center", prop: "name", "show-overflow-tooltip": true, fixed: "left" }), n(e, { label: "编号", align: "center", prop: "serialNumber", "show-overflow-tooltip": true, fixed: "left", "min-width": "180" }), n(e, { label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120" }), n(e, { label: "单净重", align: "center", prop: "netWeight", key: "netWeight", "show-overflow-tooltip": "" }, { default: p((o) => [S("span", null, _(o.row.netWeight ?? "-"), 1)]), _: 1 }), n(e, { label: "排产数", align: "center", prop: "taskQuantity", "show-overflow-tooltip": true }), n(e, { label: "车间", align: "center", prop: "workshopName", key: "workshopName", "show-overflow-tooltip": "" }), (f(true), V($, null, q(C.value, (o) => (f(), E(e, { key: o.name, align: "center", "show-overflow-tooltip": true }, { header: p(() => [B(_(o.name), 1)]), default: p(({ row: r }) => [s(Q)(r) && s(Q)(o) ? (f(), E(t, { key: 0, size: "large", effect: "dark", type: l(r, o).type, onClick: (fe) => F(l(r, o).result), class: "filter-item table-column-tag", style: { cursor: "pointer" } }, { default: p(() => [B(_(o.processType === s(v).INSPECTION.V ? l(r, o).inspectionUserName || "-" : l(r, o).result ? `${l(r, o).firstVal} | ${l(r, o).lastVal}` : "-"), 1)]), _: 2 }, 1032, ["type", "onClick"])) : G("", true)]), _: 2 }, 1024))), 128))]), _: 1 }, 8, ["data", "max-height"]), n(h, { total: s(z), "current-page": s(g).pageNumber, "page-size": s(g).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(D), onCurrentChange: s(O) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), n(ee, { visible: d.value, "onUpdate:visible": i[0] || (i[0] = (o) => d.value = o), "process-info": T.value }, null, 8, ["visible", "process-info"])]);
  };
} }, Te = te(pe, [["__scopeId", "data-v-e418fa92"]]);
export {
  Te as default
};
