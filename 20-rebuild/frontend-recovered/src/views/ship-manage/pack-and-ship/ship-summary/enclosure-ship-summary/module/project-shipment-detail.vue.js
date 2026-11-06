import { ref as v } from "vue";
import { computed as k } from "vue";
import { watch as V } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as r } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as G } from "vue";
import { toDisplayString as c } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as I } from "vue";
import { unref as o } from "vue";
import { vShow as H } from "vue";
import { createCommentVNode as z } from "vue";
import { withKeys as F } from "vue";
import { resolveDynamicComponent as U } from "vue";
import { ElTag as Y } from "element-plus";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as Q } from "element-plus";
import { ElInput as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { on as w, ue as Z, c as f, D as _, up as j } from "../../../../../../shared/runtime.js";
import { p as ee } from "../../../../../../modules/enclosure-ship-summary-6941ca85.js";
import te from "./detail.vue.js";
import oe from "./ship-list.vue.js";
import ae from "./train-number-list.vue.js";
import "../../../../../../modules/ship-summary-d5d4a58f.js";
import "./package-detail-drawer.vue.js";
const le = { class: "detail-container" }, ne = { style: { "margin-bottom": "10px" }, class: "head-container" }, re = { class: "my-code", style: { "margin-top": "20px" } }, ve = { __name: "project-shipment-detail", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, productionLineTypeEnum: { type: Number }, workshopId: { type: Number }, categoryList: { type: Array, default: () => [] } }, setup(h) {
  const l = h, S = v(), C = v([]), n = v({ category: void 0, enclosurePlanId: void 0 }), T = v(false), s = v({}), m = v(), E = v(false), O = k(() => te), A = k(() => m.value === w.ACCUMULATED_NUMBER.K ? ae : oe);
  V(() => l.currentRow.projectId, (a) => {
    a && (m.value = void 0, D(), L());
  }, { immediate: true }), V(() => n.value.category, (a) => {
    L();
  });
  async function L() {
    try {
      const a = await Z(l.currentRow.projectId);
      C.value = a || [], C.value = C.value.filter((t) => t.category === n.value.category);
    } catch (a) {
      console.log("获取围护的批次失败", a);
    }
  }
  async function D() {
    if (s.value = {}, T.value = true, !!l.currentRow.projectId) try {
      const a = await ee({ projectId: l.currentRow.projectId });
      s.value = a || {};
    } catch (a) {
      console.log("获取项目发运数据汇总", a);
    } finally {
      T.value = false;
    }
  }
  function d(a) {
    m.value = a, E.value = true;
  }
  function g() {
    var a;
    (a = S.value) == null || a.refresh();
  }
  return (a, t) => {
    const B = Y, y = J, P = Q, M = b("common-radio-button"), $ = b("common-select"), x = W, K = X;
    return N(), q("div", le, [u("div", ne, [u("div", null, [r(B, { class: "filter-item", size: "large", style: { "margin-right": "3px" } }, { default: i(() => {
      var e, p;
      return [G(c(`项目:${((e = l.currentRow.project) == null ? void 0 : e.serialNumber) + "-" + ((p = l.currentRow) == null ? void 0 : p.project.shortName)}`), 1)];
    }), _: 1 })]), R((N(), I(P, { data: s.value, direction: "vertical", column: 8, size: "large", border: "", class: "project-summary" }, { default: i(() => [r(y, { align: "center", label: "清单总量（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[0] || (t[0] = (p) => d("INVENTORY")) }, c(o(f)(((e = s.value) == null ? void 0 : e.totalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "排产量（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[1] || (t[1] = (p) => d("ASSIGNMENT")) }, c(o(f)(((e = s.value) == null ? void 0 : e.schedulingTotalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "入库量（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[2] || (t[2] = (p) => d("STORAGE")) }, c(o(f)(((e = s.value) == null ? void 0 : e.inBoundTotalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "累计发运（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[3] || (t[3] = (p) => d("CUMULATIVE_SHIPMENT")) }, c(o(f)(((e = s.value) == null ? void 0 : e.outBoundTotalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "本月发运（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[4] || (t[4] = (p) => d("SHIPMENT_MONTH")) }, c(o(f)(((e = s.value) == null ? void 0 : e.outMounthBoundTotalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "库存（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[5] || (t[5] = (p) => d("IN_STOCK")) }, c(o(f)(((e = s.value) == null ? void 0 : e.stockTotalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "打包发运（米）" }, { default: i(() => {
      var e;
      return [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[6] || (t[6] = (p) => d("PACKING_SHIPMENT")) }, c(o(f)(((e = s.value) == null ? void 0 : e.packageTotalLength) || 0, "mm", "m", o(_).MES_ENCLOSURE_L__M)), 1)];
    }), _: 1 }), r(y, { align: "center", label: "累计车次/船次" }, { default: i(() => [u("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: t[7] || (t[7] = (e) => d("ACCUMULATED_NUMBER")) }, c(s.value.trainNumber || 0), 1)]), _: 1 })]), _: 1 }, 8, ["data"])), [[K, T.value]])]), R(u("div", re, "*点击上方表格数据查看详情", 512), [[H, !m.value]]), m.value !== o(w).PACKING_SHIPMENT.K && m.value !== o(w).ACCUMULATED_NUMBER.K ? (N(), I(U(O.value), { key: 0, ref_key: "componentRef", ref: S, showType: m.value, modelValue: E.value, "onUpdate:modelValue": t[12] || (t[12] = (e) => E.value = e), query: n.value, workshopId: l.workshopId, projectId: l.currentRow.projectId, permission: l.permission }, { query: i(() => [m.value !== o(w).ASSIGNMENT.K ? (N(), I(M, { key: 0, "show-option-all": "", modelValue: n.value.productSourceType, "onUpdate:modelValue": t[8] || (t[8] = (e) => n.value.productSourceType = e), options: o(j).ENUM, unshowVal: [o(j).INTERNAL_COOPERATION.V], type: "enum", class: "filter-item", onChange: g }, null, 8, ["modelValue", "options", "unshowVal"])) : z("", true), r(M, { "show-option-all": "", modelValue: n.value.category, "onUpdate:modelValue": t[9] || (t[9] = (e) => n.value.category = e), options: h.categoryList, type: "other", dataStructure: { key: "no", label: "name", value: "no" }, class: "filter-item", onChange: g }, null, 8, ["modelValue", "options"]), r($, { modelValue: n.value.enclosurePlanId, "onUpdate:modelValue": t[10] || (t[10] = (e) => n.value.enclosurePlanId = e), options: C.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", placeholder: "请选择批次", class: "filter-item", style: { width: "180px", "margin-left": "3px" }, onChange: g }, null, 8, ["modelValue", "options"]), r(x, { modelValue: n.value.serialNumber, "onUpdate:modelValue": t[11] || (t[11] = (e) => n.value.serialNumber = e), modelModifiers: { trim: true }, placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: F(g, ["enter"]), onChange: g }, null, 8, ["modelValue"])]), _: 1 }, 8, ["showType", "modelValue", "query", "workshopId", "projectId", "permission"])) : (N(), I(U(A.value), { key: 1, ref_key: "componentRef", ref: S, showType: m.value, modelValue: E.value, "onUpdate:modelValue": t[13] || (t[13] = (e) => E.value = e), query: n.value, workshopId: l.workshopId, projectId: l.currentRow.projectId, permission: l.permission }, null, 8, ["showType", "modelValue", "query", "workshopId", "projectId", "permission"]))]);
  };
} };
export {
  ve as default
};
