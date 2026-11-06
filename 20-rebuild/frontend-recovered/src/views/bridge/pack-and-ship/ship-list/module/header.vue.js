import { inject as J } from "vue";
import { ref as f } from "vue";
import { onMounted as X } from "vue";
import { computed as Z } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as V } from "vue";
import { vShow as te } from "vue";
import { unref as e } from "vue";
import { createElementVNode as z } from "vue";
import { createVNode as n } from "vue";
import { withKeys as g } from "vue";
import { createTextVNode as w } from "vue";
import { createBlock as D } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as ae } from "vue";
import { ElMessage as le } from "element-plus";
import Q from "moment";
import { ElDatePicker as ne } from "element-plus";
import { ElInput as oe } from "element-plus";
import { ElInputNumber as re } from "element-plus";
import { ElCol as ie } from "element-plus";
import { ElRow as ue } from "element-plus";
import { Loading as se } from "@element-plus/icons-vue";
import { ElIcon as de } from "element-plus";
import { ElTag as me } from "element-plus";
import { vLoading as pe } from "element-plus";
import { l as h, _ as ce, B as fe, G as S, i as ye, bA as ge, bw as _e, bx as he, I as ve, C as be, c as C, D as _, E as Ve, b as Ne } from "../../../../../shared/runtime.js";
import { P as N } from "../../../../../modules/index-5b9e6004.js";
function Te(u) {
  return h({ module: "bridge", url: "cargo/ship", method: "get", params: u });
}
function xe(u) {
  return h({ module: "bridge", url: "cargo/ship/summary", method: "get", params: u });
}
function we(u) {
  return h({ module: "bridge", url: "cargo/yearAndMonth/summary", method: "get", params: u });
}
function De({ id: u }) {
  return h({ url: `api/mes/ship/${u}/export`, method: "get", responseType: "blob" });
}
function Ke(u) {
  return h({ module: "bridge", url: `cargo/ship/${u}`, method: "get" });
}
const Pe = { get: Te, download: De };
const Se = { class: "head-container" }, Ce = { key: 0 }, Ue = { __name: "header", setup(u) {
  const W = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, minNum: void 0, maxNum: void 0 }, { crud: o, query: t, CRUD: U } = fe(W), d = J("permission"), T = f(false), E = f(0), m = f(), x = f([]), p = f({});
  X(() => {
    S(d.print) && x.value.push("bridgeShipmentSummary"), S(d.detailPrint) && x.value.push("bridgeShipmentDetail");
  });
  const M = Z(() => {
    if (m.value === "bridgeShipmentSummary") return { ...t };
    if (m.value === "bridgeShipmentDetail" && ye(o.selections)) return o.selections.map((i) => i.id);
  });
  function I() {
    if (m.value === "bridgeShipmentDetail" && Ne(M.value)) return le.warning("至少选择一条需要打印的发运信息"), false;
  }
  U.HOOK.afterToQuery = () => {
    A(), j();
  }, U.HOOK.handleRefresh = (i, a) => {
    a.data.content = a.data.content.map((r) => (r.acceptDifference = r.totalNetWeight - r.actualWeight >= 0, r.difference = Math.abs(r.totalNetWeight - r.actualWeight), r.differenceRate = r.totalNetWeight ? (r.difference / r.totalNetWeight * 100).toFixed(1) + "%" : "-", r));
  };
  async function A() {
    if (S(d.get)) try {
      T.value = true;
      const { weight: i } = await xe(t);
      E.value = i;
    } catch (i) {
      console.log("获取汇总信息", i);
    } finally {
      T.value = false;
    }
  }
  async function j() {
    try {
      const i = await we({ dateTime: (/* @__PURE__ */ new Date()).getTime() });
      p.value = i || {};
    } catch (i) {
      console.log("获取发运记录汇总失败", i);
    }
  }
  function B() {
    t.deliveryDate && t.deliveryDate.length > 1 ? (t.auditStartDate = Q(t.deliveryDate[0]).valueOf(), t.auditEndDate = Q(t.deliveryDate[1]).valueOf()) : (t.auditStartDate = void 0, t.auditEndDate = void 0), o.toQuery();
  }
  return (i, a) => {
    const r = b("project-radio-button"), k = b("common-radio-button"), R = b("component-radio-button"), H = ne, c = oe, O = re, v = ie, L = ue, $ = b("print-table"), q = se, F = de, G = me, Y = pe, K = ee("permission");
    return y(), P("div", Se, [V(z("div", null, [n(r, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(k, { modelValue: e(t).manufactureType, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).manufactureType = l), options: e(ge).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(R, { modelValue: e(t).productType, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).productType = l), options: e(_e).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(k, { modelValue: e(t).deliveryStatus, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).deliveryStatus = l), options: e(he).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(H, { modelValue: e(t).deliveryDate, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).deliveryDate = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, shortcuts: e(ve), onChange: B }, null, 8, ["modelValue", "shortcuts"]), z("div", null, [n(c, { modelValue: e(t).blurry, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).blurry = l), placeholder: "产品名称/产品编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(c, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).serialNumber = l), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(c, { modelValue: e(t).licensePlate, "onUpdate:modelValue": a[7] || (a[7] = (l) => e(t).licensePlate = l), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(c, { modelValue: e(t).driverName, "onUpdate:modelValue": a[8] || (a[8] = (l) => e(t).driverName = l), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(c, { modelValue: e(t).auditUserName, "onUpdate:modelValue": a[9] || (a[9] = (l) => e(t).auditUserName = l), placeholder: "可输入办理人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(O, { modelValue: e(t).minNum, "onUpdate:modelValue": a[10] || (a[10] = (l) => e(t).minNum = l), modelModifiers: { number: true }, min: 0, max: e(t).maxNum || 999, precision: 2, controls: false, size: "default", style: { width: "80px" }, class: "filter-item", placeholder: "差值率" }, null, 8, ["modelValue", "max"]), a[13] || (a[13] = w("%~")), n(O, { modelValue: e(t).maxNum, "onUpdate:modelValue": a[11] || (a[11] = (l) => e(t).maxNum = l), modelModifiers: { number: true }, class: "filter-item", min: e(t).minNum || 0, precision: 2, max: 999, controls: false, size: "default", style: { width: "80px" }, placeholder: "差值率" }, null, 8, ["modelValue", "min"]), a[14] || (a[14] = w("% ")), n(e(be))])], 512), [[te, e(o).searchToggle]]), V((y(), D(L, { gutter: 20, class: "panel-group" }, { default: s(() => [n(v, { span: 6, class: "card-panel-col" }, { default: s(() => [n(e(N), { name: "全年发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(C)(p.value.yearMete, "kg", "t", e(_).COM_WT__T) || 0, precision: e(_).COM_WT__T }, null, 8, ["end-val", "precision"])]), _: 1 }), n(v, { span: 6, class: "card-panel-col" }, { default: s(() => [n(e(N), { name: "全年发运车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": p.value.yearQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(v, { span: 6, class: "card-panel-col" }, { default: s(() => [n(e(N), { name: "本月发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(C)(p.value.monthMete, "kg", "t", e(_).COM_WT__T) || 0, precision: e(_).COM_WT__T }, null, 8, ["end-val", "precision"])]), _: 1 }), n(v, { span: 6, class: "card-panel-col" }, { default: s(() => [n(e(N), { name: "本月发运车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": p.value.monthQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[Y, e(o).loading]]), n(e(Ve), null, { optLeft: s(() => [V(n($, { "current-key": m.value, "onUpdate:currentKey": a[12] || (a[12] = (l) => m.value = l), "api-key": x.value, params: M.value, "before-print": I, size: "default", type: "warning", class: "filter-item" }, null, 8, ["current-key", "api-key", "params"]), [[K, [...e(d).print, ...e(d).detailPrint]]])]), viewLeft: s(() => [V((y(), D(G, { effect: "plain", class: "filter-item", size: "large" }, { default: s(() => [a[15] || (a[15] = w(" 累计发运重量（查询）： ")), T.value ? (y(), D(F, { key: 1 }, { default: s(() => [n(q)]), _: 1 })) : (y(), P("span", Ce, ae(e(C)(E.value, "kg", "t", e(_).COM_WT__T)) + " t", 1))]), _: 1, __: [15] })), [[K, e(d).get]])]), _: 1 })]);
  };
} }, Ee = ce(Ue, [["__scopeId", "data-v-38619b1a"]]), ze = Object.freeze(Object.defineProperty({ __proto__: null, default: Ee }, Symbol.toStringTag, { value: "Module" }));
export {
  Pe as c,
  Ke as d,
  ze as h,
  Ee as m
};
