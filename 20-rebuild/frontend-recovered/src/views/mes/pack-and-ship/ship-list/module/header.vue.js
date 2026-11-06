import { inject as J } from "vue";
import { ref as m } from "vue";
import { onMounted as X } from "vue";
import { computed as Z } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as k } from "vue";
import { withDirectives as y } from "vue";
import { vShow as te } from "vue";
import { unref as e } from "vue";
import { createElementVNode as P } from "vue";
import { createVNode as n } from "vue";
import { withKeys as g } from "vue";
import { createTextVNode as b } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as I } from "vue";
import { ElMessage as ae } from "element-plus";
import W from "moment";
import { ElDatePicker as le } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElInputNumber as oe } from "element-plus";
import { ElCol as ie } from "element-plus";
import { ElRow as se } from "element-plus";
import { Loading as ue } from "@element-plus/icons-vue";
import { ElIcon as re } from "element-plus";
import { ElTag as de } from "element-plus";
import { vLoading as me } from "element-plus";
import { g as pe, a as ce } from "../../../../../modules/ship-list-822ce00f.js";
import { _ as fe, B as ye, G as D, i as ge, bA as _e, bi as A, bx as ve, I as he, C as Ve, c as N, E as be, b as Ne } from "../../../../../shared/runtime.js";
import { P as x } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const xe = { class: "head-container" }, we = { key: 0 }, Se = { key: 0 }, ke = { __name: "header", setup(De) {
  const B = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, minNum: void 0, maxNum: void 0 }, { crud: o, query: a, CRUD: E } = ye(B), d = J("permission"), v = m(false), U = m(0), C = m(0), p = m(), w = m([]), c = m({});
  X(() => {
    D(d.print) && w.value.push("mesShipmentSummary"), D(d.detailPrint) && w.value.push("mesShipmentDetail");
  });
  const K = Z(() => {
    if (p.value === "mesShipmentSummary") return { ...a };
    if (p.value === "mesShipmentDetail" && ge(o.selections)) return o.selections.map((s) => s.id);
  });
  function R() {
    if (p.value === "mesShipmentDetail" && Ne(K.value)) return ae.warning("至少选择一条需要打印的发运信息"), false;
  }
  E.HOOK.afterToQuery = () => {
    j(), L();
  }, E.HOOK.handleRefresh = (s, t) => {
    t.data.content = t.data.content.map((i) => (i.acceptDifference = i.totalNetWeight - i.actualWeight >= 0, i.difference = Math.abs(i.totalNetWeight - i.actualWeight), i.differenceRate = i.totalNetWeight ? (i.difference / i.totalNetWeight * 100).toFixed(1) + "%" : "-", i));
  };
  async function j() {
    if (D(d.get)) try {
      v.value = true;
      const { weight: s, actualWeight: t } = await pe(a);
      U.value = s, C.value = t;
    } catch (s) {
      console.log("获取汇总信息", s);
    } finally {
      v.value = false;
    }
  }
  async function L() {
    try {
      const s = await ce({ dateTime: (/* @__PURE__ */ new Date()).getTime() });
      c.value = s || {};
    } catch (s) {
      console.log("获取发运记录汇总失败", s);
    }
  }
  function H() {
    a.deliveryDate && a.deliveryDate.length > 1 ? (a.auditStartDate = W(a.deliveryDate[0]).valueOf(), a.auditEndDate = W(a.deliveryDate[1]).valueOf()) : (a.auditStartDate = void 0, a.auditEndDate = void 0), o.toQuery();
  }
  return (s, t) => {
    const i = V("project-radio-button"), T = V("common-radio-button"), q = V("component-radio-button"), F = le, f = ne, z = oe, h = ie, G = se, Y = V("print-table"), M = ue, O = re, Q = de, $ = me, S = ee("permission");
    return r(), k("div", xe, [y(P("div", null, [n(i, { size: "default", modelValue: e(a).projectId, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).projectId = l), class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(T, { modelValue: e(a).manufactureType, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).manufactureType = l), options: e(_e).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(q, { modelValue: e(a).productType, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).productType = l), options: e(A).ENUM, showOptionAll: "", type: "enum", size: "default", disabledVal: [e(A).ENCLOSURE.V], class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"]), n(T, { modelValue: e(a).deliveryStatus, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).deliveryStatus = l), options: e(ve).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(F, { modelValue: e(a).deliveryDate, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).deliveryDate = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, shortcuts: e(he), onChange: H }, null, 8, ["modelValue", "shortcuts"]), P("div", null, [n(f, { modelValue: e(a).blurry, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(a).blurry = l), placeholder: "产品名称/产品编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(f, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).serialNumber = l), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(f, { modelValue: e(a).licensePlate, "onUpdate:modelValue": t[7] || (t[7] = (l) => e(a).licensePlate = l), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(f, { modelValue: e(a).driverName, "onUpdate:modelValue": t[8] || (t[8] = (l) => e(a).driverName = l), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(f, { modelValue: e(a).auditUserName, "onUpdate:modelValue": t[9] || (t[9] = (l) => e(a).auditUserName = l), placeholder: "可输入办理人搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(z, { modelValue: e(a).minNum, "onUpdate:modelValue": t[10] || (t[10] = (l) => e(a).minNum = l), modelModifiers: { number: true }, min: 0, max: e(a).maxNum || 999, precision: 2, controls: false, size: "default", style: { width: "80px" }, class: "filter-item", placeholder: "差值率" }, null, 8, ["modelValue", "max"]), t[13] || (t[13] = b("%~")), n(z, { modelValue: e(a).maxNum, "onUpdate:modelValue": t[11] || (t[11] = (l) => e(a).maxNum = l), modelModifiers: { number: true }, class: "filter-item", min: e(a).minNum || 0, precision: 2, max: 999, controls: false, size: "default", style: { width: "80px" }, placeholder: "差值率" }, null, 8, ["modelValue", "min"]), t[14] || (t[14] = b("% ")), n(e(Ve))])], 512), [[te, e(o).searchToggle]]), y((r(), _(G, { gutter: 20, class: "panel-group" }, { default: u(() => [n(h, { span: 6, class: "card-panel-col" }, { default: u(() => [n(e(x), { name: "今年发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(N)(c.value.yearMete, "kg", "t", 2) || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), n(h, { span: 6, class: "card-panel-col" }, { default: u(() => [n(e(x), { name: "今年发运车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": c.value.yearQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(h, { span: 6, class: "card-panel-col" }, { default: u(() => [n(e(x), { name: "本月发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(N)(c.value.monthMete, "kg", "t", 2) || 0, precision: 2 }, null, 8, ["end-val"])]), _: 1 }), n(h, { span: 6, class: "card-panel-col" }, { default: u(() => [n(e(x), { name: "本月发运车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": c.value.monthQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[$, e(o).loading]]), n(e(be), null, { optLeft: u(() => [y(n(Y, { "current-key": p.value, "onUpdate:currentKey": t[12] || (t[12] = (l) => p.value = l), "api-key": w.value, params: K.value, "before-print": R, size: "default", type: "warning", class: "filter-item" }, null, 8, ["current-key", "api-key", "params"]), [[S, [...e(d).print, ...e(d).detailPrint]]])]), viewLeft: u(() => [y((r(), _(Q, { type: "warning", effect: "plain", class: "filter-item", size: "large" }, { default: u(() => [t[15] || (t[15] = b(" 过磅重量汇总（磅计）： ")), v.value ? (r(), _(O, { key: 1 }, { default: u(() => [n(M)]), _: 1 })) : (r(), k("span", we, I(e(N)(C.value, "kg", "t", 2)) + " t", 1))]), _: 1, __: [15] })), [[S, e(d).get]]), y((r(), _(Q, { effect: "plain", class: "filter-item", size: "large" }, { default: u(() => [t[16] || (t[16] = b(" 累计发运重量（理计）： ")), v.value ? (r(), _(O, { key: 1 }, { default: u(() => [n(M)]), _: 1 })) : (r(), k("span", Se, I(e(N)(U.value, "kg", "t", 2)) + " t", 1))]), _: 1, __: [16] })), [[S, e(d).get]])]), _: 1 })]);
  };
} }, ze = fe(ke, [["__scopeId", "data-v-d3f02c18"]]);
export {
  ze as default
};
