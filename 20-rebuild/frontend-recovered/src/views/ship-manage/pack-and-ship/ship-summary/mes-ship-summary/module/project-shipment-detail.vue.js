import { ref as f } from "vue";
import { computed as B } from "vue";
import { watch as G } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as W } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as Z } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as u } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as ee } from "vue";
import { toDisplayString as y } from "vue";
import { unref as o } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as E } from "vue";
import { withModifiers as te } from "vue";
import { vShow as oe } from "vue";
import { createCommentVNode as ae } from "vue";
import { withKeys as le } from "vue";
import { resolveDynamicComponent as q } from "vue";
import { ElTag as re } from "element-plus";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElDescriptions as se } from "element-plus";
import { ElInput as ue } from "element-plus";
import { vLoading as ie } from "element-plus";
import { e as de, f as me } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { uo as I, on as N, q as pe, bo as w, c as i, up as ce } from "../../../../../../shared/runtime.js";
import ve from "./detail.vue.js";
import fe from "./direct-detail.vue.js";
import ye from "./ship-list.vue.js";
import ge from "./train-number-list.vue.js";
import Ie from "./detail-drawer.vue.js";
import "./package-detail-drawer.vue.js";
import "../../../../../../modules/ship-manage-3066b2ed.js";
const we = { class: "detail-container" }, ke = { style: { "margin-bottom": "10px" }, class: "head-container" }, Te = { class: "my-code", style: { "margin-top": "20px" } }, Ue = { __name: "project-shipment-detail", props: { currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, productionLineTypeEnum: { type: Number }, workshopId: { type: Number }, weightStatus: { type: Number } }, setup($) {
  const a = $, _ = f(), c = f(I.STRUCTURE.V), b = f([]), l = f({ monomerId: void 0, areaId: void 0 }), M = f(false), n = f({}), p = f(), h = f(false), R = f(false), x = B(() => c.value === I.STRUCTURE.V ? ve : fe), K = B(() => p.value === N.ACCUMULATED_NUMBER.K ? ge : ye);
  G(() => a.currentRow.projectId, (s) => {
    s && (l.value = { monomerId: void 0, areaId: void 0 }, p.value = void 0, C());
  }, { immediate: true }), G(() => l.value.monomerId, (s) => {
    C(), S();
  });
  const L = (s) => {
    s ? (l.value.startDate = s[0], l.value.endDate = s[1]) : (l.value.startDate = void 0, l.value.endDate = void 0);
  };
  function z(s) {
    (c.value === I.STRUCTURE.V || I.DIRECT.V) && (b.value = s.filter((e) => e.itemizedType === 1) || []), c.value === I.AUXILIARY_MATERIAL.V && (b.value = s.filter((e) => e.itemizedType === 64) || []);
  }
  function P() {
    p.value = void 0, l.value = {}, C();
  }
  function O() {
    C(), S();
  }
  async function C() {
    var s, e;
    if (n.value = {}, M.value = true, !(!((s = a.currentRow) != null && s.projectId) || !((e = a.permission) != null && e.detail))) try {
      const V = { projectId: a.currentRow.projectId, workshopId: a.workshopId, monomerId: l.value.monomerId, areaId: l.value.areaId }, j = await (c.value === I.STRUCTURE.V ? de : me)(V);
      n.value = j || {};
    } catch (V) {
      console.log("获取项目发运数据汇总", V);
    } finally {
      M.value = false;
    }
  }
  function g(s) {
    p.value = s, h.value = true;
  }
  function S() {
    var s;
    (s = _.value) == null || s.refresh();
  }
  function H() {
    R.value = true;
  }
  return (s, e) => {
    const V = re, U = D("common-radio-button"), j = D("common-select"), v = ne, Y = D("common-button"), F = se, X = ue, J = W("permission"), Q = ie;
    return T(), Z("div", we, [m("div", ke, [m("div", null, [u(V, { class: "filter-item", size: "large", style: { "margin-right": "3px" } }, { default: d(() => [ee(y(`项目:${a.currentRow.project.serialNumber + "-" + a.currentRow.project.shortName}`), 1)]), _: 1 }), u(U, { modelValue: c.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => c.value = t), options: o(I).ENUM, type: "enum", class: "filter-item", onChange: P }, null, 8, ["modelValue", "options"]), u(o(pe), { ref: "monomerSelectRef", modelValue: l.value.monomerId, "onUpdate:modelValue": e[1] || (e[1] = (t) => l.value.monomerId = t), "project-id": a.currentRow.projectId, default: false, clearable: "", class: "filter-item", onGetAreaInfo: z }, null, 8, ["modelValue", "project-id"]), u(j, { modelValue: l.value.areaId, "onUpdate:modelValue": e[2] || (e[2] = (t) => l.value.areaId = t), options: b.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: O }, null, 8, ["modelValue", "options"])]), A((T(), E(F, { data: n.value, direction: "vertical", column: 9, size: "large", border: "", class: "project-summary" }, { default: d(() => [u(v, { align: "center", label: "清单总量（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[3] || (e[3] = (k) => g("INVENTORY")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.mete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.grossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "排产量（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[4] || (e[4] = (k) => g("ASSIGNMENT")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.schedulingMete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.schedulingGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "入库量（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[5] || (e[5] = (k) => g("STORAGE")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.inBoundMete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.inBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "累计发运（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[6] || (e[6] = (k) => g("CUMULATIVE_SHIPMENT")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.outBoundMete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.outBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "本月发运（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[7] || (e[7] = (k) => g("SHIPMENT_MONTH")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.outMounthBoundMete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.outMounthBoundGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "库存（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[8] || (e[8] = (k) => g("IN_STOCK")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.stockMete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.stockGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "打包发运（吨）" }, { default: d(() => {
      var t, r;
      return [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[9] || (e[9] = (k) => g("PACKING_SHIPMENT")) }, y(a.weightStatus === o(w).NET.V ? o(i)(((t = n.value) == null ? void 0 : t.packageMete) || 0, "kg", "t", 2) : o(i)(((r = n.value) == null ? void 0 : r.packageGrossMete) || 0, "kg", "t", 2)), 1)];
    }), _: 1 }), u(v, { align: "center", label: "累计车次/船次" }, { default: d(() => [m("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: e[10] || (e[10] = (t) => g("ACCUMULATED_NUMBER")) }, y(n.value.trainNumber || 0), 1)]), _: 1 }), A((T(), E(v, { align: "center", label: "操作" }, { default: d(() => [u(Y, { type: "primary", icon: "el-icon-view", size: "mini", onClick: te(H, ["stop"]) })]), _: 1 })), [[J, $.permission.detail]])]), _: 1 }, 8, ["data"])), [[Q, M.value]])]), A(m("div", Te, "*点击上方表格数据查看详情", 512), [[oe, !p.value]]), p.value !== o(N).PACKING_SHIPMENT.K && p.value !== o(N).ACCUMULATED_NUMBER.K ? (T(), E(q(x.value), { key: 0, ref_key: "componentRef", ref: _, showType: p.value, modelValue: h.value, "onUpdate:modelValue": e[13] || (e[13] = (t) => h.value = t), query: l.value, category: c.value, workshopId: a.workshopId, projectId: a.currentRow.projectId, weightStatus: a.weightStatus }, { query: d(() => [p.value !== o(N).ASSIGNMENT.K ? (T(), E(U, { key: 0, "show-option-all": "", modelValue: l.value.productSourceType, "onUpdate:modelValue": e[11] || (e[11] = (t) => l.value.productSourceType = t), options: o(ce).ENUM, type: "enum", class: "filter-item", onChange: S }, null, 8, ["modelValue", "options"])) : ae("", true), u(X, { modelValue: l.value.serialNumber, "onUpdate:modelValue": e[12] || (e[12] = (t) => l.value.serialNumber = t), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: le(S, ["enter"]), onChange: S }, null, 8, ["modelValue"])]), _: 1 }, 8, ["showType", "modelValue", "query", "category", "workshopId", "projectId", "weightStatus"])) : (T(), E(q(K.value), { key: 1, ref_key: "componentRef", ref: _, showType: p.value, modelValue: h.value, "onUpdate:modelValue": e[14] || (e[14] = (t) => h.value = t), query: l.value, category: c.value, workshopId: a.workshopId, projectId: a.currentRow.projectId, weightStatus: a.weightStatus }, null, 8, ["showType", "modelValue", "query", "category", "workshopId", "projectId", "weightStatus"])), u(Ie, { visible: R.value, "onUpdate:visible": e[15] || (e[15] = (t) => R.value = t), query: l.value, workshopId: a.workshopId, projectId: a.currentRow.projectId, "detail-data": a.currentRow, category: c.value, onChangeDate: L }, null, 8, ["visible", "query", "workshopId", "projectId", "detail-data", "category"])]);
  };
} };
export {
  Ue as default
};
