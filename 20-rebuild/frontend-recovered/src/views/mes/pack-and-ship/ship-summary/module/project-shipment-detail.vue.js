import { ref as v } from "vue";
import { computed as G } from "vue";
import { watch as T } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as n } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as m } from "vue";
import { unref as a } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as V } from "vue";
import { withModifiers as A } from "vue";
import { resolveDynamicComponent as z } from "vue";
import { nextTick as L } from "vue";
import { ElTag as H } from "element-plus";
import { ElDescriptionsItem as P } from "element-plus";
import { ElDescriptions as F } from "element-plus";
import { vLoading as K } from "element-plus";
import { p as Y } from "../../../../../modules/ship-summary-06293e56.js";
import { q as J, bo as g, c as s } from "../../../../../shared/runtime.js";
import Q from "./detail.vue.js";
import W from "./detail-drawer.vue.js";
const X = { class: "detail-container" }, Z = { style: { "margin-bottom": "10px" }, class: "head-container" }, re = { __name: "project-shipment-detail", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, productionLineTypeEnum: { type: Number }, workshopId: { type: Number }, weightStatus: { type: Number } }, setup(j) {
  const o = j, _ = v([]), d = v({ monomerId: void 0, areaId: void 0 }), k = v(false), r = v({}), w = v(), I = v(false), b = v(false), E = G(() => Q);
  T(() => o.currentRow.projectId, (u) => {
    u && (w.value = void 0, N());
  }), T(() => d.value, (u) => {
    w.value = void 0, N();
  }, { immediate: true, deep: true });
  function M(u) {
    _.value = u.filter((e) => e.itemizedType === 1) || [];
  }
  async function N() {
    var u;
    if (r.value = {}, k.value = true, !!((u = o.currentRow) != null && u.projectId)) try {
      const e = await Y({ projectId: o.currentRow.projectId, ...d.value, workshopId: o.workshopId });
      r.value = e || {};
    } catch (e) {
      console.log("获取项目发运数据汇总", e);
    } finally {
      k.value = false;
    }
  }
  function f(u) {
    w.value = u, L(() => {
      I.value = true;
    });
  }
  function C() {
    b.value = true;
  }
  return (u, e) => {
    const R = H, B = S("common-select"), p = P, x = S("common-button"), $ = F, D = K;
    return h(), q("div", X, [c("div", Z, [c("div", null, [n(R, { class: "filter-item", style: { "margin-right": "3px" } }, { default: i(() => [U(m(`项目:${o.currentRow.project.serialNumber + " " + o.currentRow.project.shortName}`), 1)]), _: 1 }), n(a(J), { ref: "monomerSelectRef", modelValue: d.value.monomerId, "onUpdate:modelValue": e[0] || (e[0] = (t) => d.value.monomerId = t), "project-id": o.currentRow.projectId, default: false, clearable: "", class: "filter-item", onGetAreaInfo: M }, null, 8, ["modelValue", "project-id"]), n(B, { modelValue: d.value.areaId, "onUpdate:modelValue": e[1] || (e[1] = (t) => d.value.areaId = t), options: _.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" } }, null, 8, ["modelValue", "options"])]), O((h(), V($, { data: r.value, direction: "vertical", column: 8, size: "large", border: "", class: "project-summary" }, { default: i(() => [n(p, { align: "center", label: "清单总量（吨）" }, { default: i(() => {
      var t, l;
      return [c("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[2] || (e[2] = (y) => f("INVENTORY")) }, m(o.weightStatus === a(g).NET.V ? a(s)(((t = r.value) == null ? void 0 : t.mete) || 0, "kg", "t", 2) : a(s)(((l = r.value) == null ? void 0 : l.grossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), n(p, { align: "center", label: "任务总量（吨）" }, { default: i(() => {
      var t, l;
      return [c("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[3] || (e[3] = (y) => f("ASSIGNMENT")) }, m(o.weightStatus === a(g).NET.V ? a(s)(((t = r.value) == null ? void 0 : t.schedulingMete) || 0, "kg", "t", 2) : a(s)(((l = r.value) == null ? void 0 : l.schedulingGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), n(p, { align: "center", label: "入库量（吨）" }, { default: i(() => {
      var t, l;
      return [c("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[4] || (e[4] = (y) => f("STORAGE")) }, m(o.weightStatus === a(g).NET.V ? a(s)(((t = r.value) == null ? void 0 : t.inBoundMete) || 0, "kg", "t", 2) : a(s)(((l = r.value) == null ? void 0 : l.inBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), n(p, { align: "center", label: "累计发运" }, { default: i(() => {
      var t, l;
      return [c("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[5] || (e[5] = (y) => f("CUMULATIVE_SHIPMENT")) }, m(o.weightStatus === a(g).NET.V ? a(s)(((t = r.value) == null ? void 0 : t.outBoundMete) || 0, "kg", "t", 2) : a(s)(((l = r.value) == null ? void 0 : l.outBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), n(p, { align: "center", label: "本月发运" }, { default: i(() => {
      var t, l;
      return [c("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[6] || (e[6] = (y) => f("SHIPMENT_MONTH")) }, m(o.weightStatus === a(g).NET.V ? a(s)(((t = r.value) == null ? void 0 : t.outMounthBoundMete) || 0, "kg", "t", 2) : a(s)(((l = r.value) == null ? void 0 : l.outMounthBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), n(p, { align: "center", label: "库存（吨）" }, { default: i(() => {
      var t, l;
      return [c("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[7] || (e[7] = (y) => f("IN_STOCK")) }, m(o.weightStatus === a(g).NET.V ? a(s)(((t = r.value) == null ? void 0 : t.stockMete) || 0, "kg", "t", 2) : a(s)(((l = r.value) == null ? void 0 : l.stockGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), n(p, { align: "center", label: "累计车次/船次" }, { default: i(() => [c("span", null, m(r.value.trainNumber || 0), 1)]), _: 1 }), n(p, { align: "center", label: "操作" }, { default: i(() => [n(x, { type: "primary", icon: "el-icon-view", size: "default", onClick: A(C, ["stop"]) })]), _: 1 })]), _: 1 }, 8, ["data"])), [[D, k.value]])]), (h(), V(z(E.value), { showType: w.value, modelValue: I.value, "onUpdate:modelValue": e[8] || (e[8] = (t) => I.value = t), query: d.value, workshopId: o.workshopId, projectId: o.currentRow.projectId, weightStatus: o.weightStatus }, null, 8, ["showType", "modelValue", "query", "workshopId", "projectId", "weightStatus"])), n(W, { visible: b.value, "onUpdate:visible": e[9] || (e[9] = (t) => b.value = t), query: d.value, workshopId: o.workshopId, projectId: o.currentRow.projectId, "detail-data": o.currentRow }, null, 8, ["visible", "query", "workshopId", "projectId", "detail-data"])]);
  };
} };
export {
  re as default
};
