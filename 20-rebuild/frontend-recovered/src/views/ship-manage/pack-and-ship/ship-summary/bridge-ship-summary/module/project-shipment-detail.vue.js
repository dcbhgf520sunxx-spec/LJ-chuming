import { ref as m } from "vue";
import { computed as J } from "vue";
import { watch as C } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as l } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as Z } from "vue";
import { toDisplayString as w } from "vue";
import { unref as t } from "vue";
import { withDirectives as T } from "vue";
import { vShow as B } from "vue";
import { createBlock as A } from "vue";
import { withModifiers as ee } from "vue";
import { resolveDynamicComponent as te } from "vue";
import { nextTick as oe } from "vue";
import { ElTag as ae } from "element-plus";
import { ElDescriptionsItem as le } from "element-plus";
import { ElDescriptions as ne } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { vLoading as se } from "element-plus";
import { p as ie, a as ue, b as pe } from "../../../../../../modules/bridge-ship-summary-aa634ae7.js";
import { un as i, q as ce, bo as b, c as p } from "../../../../../../shared/runtime.js";
import de from "./detail.vue.js";
import me from "./direct-detail.vue.js";
import ve from "./detail-drawer.vue.js";
import "../../../../../../modules/ship-manage-3066b2ed.js";
const ye = { class: "detail-container" }, fe = { style: { "margin-bottom": "10px" }, class: "head-container" }, we = { key: 1 }, Te = { __name: "project-shipment-detail", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, productionLineTypeEnum: { type: Number }, workshopId: { type: Number }, weightStatus: { type: Number } }, setup(E) {
  const a = E, u = m(i.BOX.V), U = m([]), G = m(false), D = m([]), d = m({ monomerId: void 0, areaId: void 0 }), R = m(false), r = m({}), V = m(), M = m(false), N = m(false), Y = J(() => u.value === i.BOX.V ? de : me);
  C(() => a.currentRow.projectId, (s) => {
    s && (V.value = void 0, j(), O());
  }), C(() => d.value, (s) => {
    V.value = void 0, j();
  }, { immediate: true, deep: true }), C(() => u.value, (s) => {
    s === i.AUXILIARY_MATERIAL.V ? O() : j();
  });
  function z(s) {
    D.value = s || [];
  }
  async function j() {
    var s, o;
    if (r.value = {}, R.value = true, !(!((s = a.currentRow) != null && s.projectId) || !((o = a.permission) != null && o.detail))) try {
      const k = u.value === i.BOX.V ? ie : ue, S = { projectId: a.currentRow.projectId, ...d.value, workshopId: a.workshopId }, x = await k(S);
      r.value = x || {};
    } catch (k) {
      console.log("获取项目发运数据汇总", k);
    } finally {
      R.value = false;
    }
  }
  async function O() {
    try {
      const { content: s } = await pe({ projectId: a.currentRow.projectId, workshopId: a.workshopId, relationType: i.AUXILIARY_MATERIAL.V, ...d.value });
      U.value = s || [];
    } catch {
      console.log("获取配套件详情失败");
    }
  }
  function I(s) {
    V.value = s, oe(() => {
      M.value = true;
    });
  }
  function Q() {
    N.value = true;
  }
  return (s, o) => {
    var q;
    const k = ae, S = _("common-radio-button"), x = _("common-select"), H = _("print-table"), y = le, P = _("common-button"), F = ne, v = re, K = _("common-table"), X = W("permission"), $ = se;
    return g(), L("div", ye, [f("div", fe, [f("div", null, [l(k, { class: "filter-item", size: "large", style: { "margin-right": "3px" } }, { default: c(() => [Z(w(`项目:${a.currentRow.project.serialNumber + "-" + a.currentRow.project.shortName}`), 1)]), _: 1 }), l(S, { modelValue: u.value, "onUpdate:modelValue": o[0] || (o[0] = (e) => u.value = e), options: t(i).ENUM, disabledVal: [t(i).AUXILIARY_MATERIAL.V], type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options", "disabledVal"]), l(t(ce), { ref: "monomerSelectRef", modelValue: d.value.monomerId, "onUpdate:modelValue": o[1] || (o[1] = (e) => d.value.monomerId = e), "project-id": a.currentRow.projectId, default: false, clearable: "", class: "filter-item", onGetAreaInfo: z }, null, 8, ["modelValue", "project-id"]), l(x, { modelValue: d.value.areaId, "onUpdate:modelValue": o[2] || (o[2] = (e) => d.value.areaId = e), options: D.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" } }, null, 8, ["modelValue", "options"]), T(l(H, { "api-key": "bridgeAuxMatDetail", params: { projectId: (q = a.currentRow) == null ? void 0 : q.projectId, workshopId: a.workshopId, relationType: t(i).AUXILIARY_MATERIAL.V, ...d.value }, size: "default", type: "warning", class: "filter-item", style: { float: "right" } }, null, 8, ["params"]), [[B, u.value === t(i).AUXILIARY_MATERIAL.V], [X, E.permission.print]])]), T((g(), A(F, { data: r.value, direction: "vertical", column: 8, size: "large", border: "", class: "project-summary" }, { default: c(() => [l(y, { align: "center", label: "清单总量（吨）" }, { default: c(() => {
      var e, n;
      return [f("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: o[3] || (o[3] = (h) => I("INVENTORY")) }, w(a.weightStatus === t(b).NET.V ? t(p)(((e = r.value) == null ? void 0 : e.mete) || 0, "kg", "t", 2) : t(p)(((n = r.value) == null ? void 0 : n.grossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), l(y, { align: "center", label: "任务总量（吨）" }, { default: c(() => {
      var e, n;
      return [u.value === t(i).BOX.V ? (g(), L("span", { key: 0, class: "tc-primary", style: { cursor: "pointer" }, onClick: o[4] || (o[4] = (h) => I("ASSIGNMENT")) }, w(a.weightStatus === t(b).NET.V ? t(p)(((e = r.value) == null ? void 0 : e.schedulingMete) || 0, "kg", "t", 2) : t(p)(((n = r.value) == null ? void 0 : n.schedulingGrossMete) || 0, "kg", "t", 2)), 1)) : (g(), L("span", we, "-"))];
    }), _: 1 }), l(y, { align: "center", label: "入库量（吨）" }, { default: c(() => {
      var e, n;
      return [f("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: o[5] || (o[5] = (h) => I("STORAGE")) }, w(a.weightStatus === t(b).NET.V ? t(p)(((e = r.value) == null ? void 0 : e.inBoundMete) || 0, "kg", "t", 2) : t(p)(((n = r.value) == null ? void 0 : n.inBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), l(y, { align: "center", label: "累计发运" }, { default: c(() => {
      var e, n;
      return [f("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: o[6] || (o[6] = (h) => I("CUMULATIVE_SHIPMENT")) }, w(a.weightStatus === t(b).NET.V ? t(p)(((e = r.value) == null ? void 0 : e.outBoundMete) || 0, "kg", "t", 2) : t(p)(((n = r.value) == null ? void 0 : n.outBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), l(y, { align: "center", label: "本月发运" }, { default: c(() => {
      var e, n;
      return [f("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: o[7] || (o[7] = (h) => I("SHIPMENT_MONTH")) }, w(a.weightStatus === t(b).NET.V ? t(p)(((e = r.value) == null ? void 0 : e.outMounthBoundMete) || 0, "kg", "t", 2) : t(p)(((n = r.value) == null ? void 0 : n.outMounthBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), l(y, { align: "center", label: "库存（吨）" }, { default: c(() => {
      var e, n;
      return [f("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: o[8] || (o[8] = (h) => I("IN_STOCK")) }, w(a.weightStatus === t(b).NET.V ? t(p)(((e = r.value) == null ? void 0 : e.stockMete) || 0, "kg", "t", 2) : t(p)(((n = r.value) == null ? void 0 : n.stockGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), l(y, { align: "center", label: "累计车次/船次" }, { default: c(() => [f("span", null, w(r.value.trainNumber || 0), 1)]), _: 1 }), T((g(), A(y, { align: "center", label: "操作" }, { default: c(() => [l(P, { type: "primary", icon: "el-icon-view", size: "default", onClick: ee(Q, ["stop"]) })]), _: 1 })), [[X, E.permission.detail]])]), _: 1 }, 8, ["data"])), [[B, u.value === t(i).BOX.V || u.value === t(i).DIRECT.V], [$, R.value]]), T((g(), A(K, { data: U.value, "show-empty-symbol": false }, { default: c(() => [l(v, { prop: "index", label: "序号", align: "center", width: "45", type: "index" }), l(v, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), l(v, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), l(v, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true, "min-width": "100px" }), l(v, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, "min-width": "120px" }), l(v, { key: "unit", prop: "unit", label: "单位", align: "center", "show-overflow-tooltip": true }), l(v, { key: "quantity", prop: "quantity", label: "清单量", align: "center", "show-overflow-tooltip": true }), l(v, { key: "shipQuantity", prop: "shipQuantity", label: "已发运", align: "center", "show-overflow-tooltip": true }), l(v, { key: "unCargoQuantity", prop: "unCargoQuantity", label: "未发运", align: "center", "show-overflow-tooltip": true })]), _: 1 }, 8, ["data"])), [[B, u.value === t(i).AUXILIARY_MATERIAL.V], [$, G.value]])]), (g(), A(te(Y.value), { showType: V.value, modelValue: M.value, "onUpdate:modelValue": o[9] || (o[9] = (e) => M.value = e), query: d.value, category: u.value, workshopId: a.workshopId, projectId: a.currentRow.projectId, weightStatus: a.weightStatus }, null, 8, ["showType", "modelValue", "query", "category", "workshopId", "projectId", "weightStatus"])), l(ve, { visible: N.value, "onUpdate:visible": o[10] || (o[10] = (e) => N.value = e), query: d.value, workshopId: a.workshopId, projectId: a.currentRow.projectId, "detail-data": a.currentRow, category: u.value }, null, 8, ["visible", "query", "workshopId", "projectId", "detail-data", "category"])]);
  };
} };
export {
  Te as default
};
