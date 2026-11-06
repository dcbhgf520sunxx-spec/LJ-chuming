import { ref as p } from "vue";
import { inject as ae } from "vue";
import { watch as le } from "vue";
import { computed as j } from "vue";
import { onMounted as ne } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as E } from "vue";
import { withDirectives as V } from "vue";
import { vShow as re } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as r } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as A } from "vue";
import { withKeys as b } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as K } from "vue";
import { toDisplayString as P } from "vue";
import { ElMessage as ue } from "element-plus";
import Q from "moment";
import { ElDatePicker as ie } from "element-plus";
import { ElCheckbox as se } from "element-plus";
import { ElInput as de } from "element-plus";
import { Loading as me } from "@element-plus/icons-vue";
import { ElIcon as pe } from "element-plus";
import { ElTag as ce } from "element-plus";
import { g as fe, a as ye } from "../../../../../modules/ship-list-822ce00f.js";
import { _ as ve, B as ge, m as he, bi as d, G as C, i as M, od as z, bw as B, bx as _e, I as Ve, C as be, c as W, E as De, b as L } from "../../../../../shared/runtime.js";
const Se = { class: "head-container" }, Ee = { key: 0 }, Ce = { key: 0 }, ke = { __name: "header", setup(Ue) {
  const y = p(), H = { serialNumber: void 0, licensePlate: void 0, driverName: void 0, auditUserName: void 0, auditStartDate: void 0, auditEndDate: void 0, projectId: { value: void 0, resetAble: false }, productType: { value: void 0, resetAble: false }, manufactureType: { value: void 0, resetAble: false }, minNum: void 0, maxNum: void 0, boolAccurateQuery: false }, { crud: n, query: t, CRUD: k } = ge(H), { globalProject: U } = he(["globalProject"]), m = ae("permission"), v = p(false), w = p(0), N = p(0), i = p(), g = p([]), X = p({});
  le(() => U.value, (u) => {
    var a;
    t.productType = void 0, y.value = void 0, y.value = (a = U.value) == null ? void 0 : a.productCategory;
  }, { immediate: true });
  const q = j(() => {
    switch (y.value) {
      case d.STRUCTURE.V:
        return [d.ENCLOSURE.V];
      case d.ENCLOSURE.V:
        return [d.STRUCTURE.V, d.MACHINE_PART.V];
      case d.STRUCTURE.V + d.ENCLOSURE.V:
        return [];
      default:
        return [];
    }
  });
  ne(() => {
    C(m.print) && g.value.push("mesShipmentSummary"), C(m.detailPrint) && g.value.push("mesShipmentDetail"), g.value.push("mesMonthlyDeliverySummary", "mesDailyDeliverySummary");
  });
  const D = j(() => {
    if (i.value === "mesShipmentSummary" || i.value === "mesBridgeShipmentSummary") return { ...t };
    if (i.value === "mesShipmentDetail" && M(n.selections) || i.value === "mesBridgeShipmentDetail" && M(n.selections)) return n.selections.map((u) => u.id);
    if (i.value === "mesMonthlyDeliverySummary") return { projectId: t.projectId, startDate: t.auditStartDate, endDate: t.auditEndDate, type: 2 };
    if (i.value === "mesDailyDeliverySummary") return { projectId: t.projectId, startDate: t.auditStartDate, endDate: t.auditEndDate, type: 1 };
  });
  function F() {
    if (i.value === "mesShipmentDetail" && L(D.value) || i.value === "mesBridgeShipmentDetail" && L(D.value)) return ue.warning("至少选择一条需要打印的发运信息"), false;
  }
  k.HOOK.afterToQuery = () => {
    G(), Y();
  }, k.HOOK.handleRefresh = (u, a) => {
    a.data.content = a.data.content.map((o) => (o.acceptDifference = o.totalNetWeight - o.actualWeight >= 0, o.difference = Math.abs(o.totalNetWeight - o.actualWeight), o.differenceRate = o.totalNetWeight ? (o.difference / o.totalNetWeight * 100).toFixed(1) + "%" : "-", o));
  };
  async function G() {
    if (C(m.get)) try {
      v.value = true;
      const { weight: u, actualWeight: a } = await fe(t);
      w.value = u, N.value = a;
    } catch (u) {
      console.log("获取汇总信息", u);
    } finally {
      v.value = false;
    }
  }
  async function Y() {
    try {
      const u = await ye({ dateTime: (/* @__PURE__ */ new Date()).getTime(), projectId: t.projectId });
      X.value = u || {};
    } catch (u) {
      console.log("获取发运记录汇总失败", u);
    }
  }
  function $() {
    t.deliveryDate && t.deliveryDate.length > 1 ? (t.auditStartDate = Q(t.deliveryDate[0]).valueOf(), t.auditEndDate = Q(t.deliveryDate[1]).valueOf()) : (t.auditStartDate = void 0, t.auditEndDate = void 0), n.toQuery();
  }
  return (u, a) => {
    const o = _("project-radio-button"), T = _("component-radio-button"), J = _("common-radio-button"), Z = ie, ee = se, h = de, te = _("print-table"), I = me, O = pe, R = ce, S = oe("permission");
    return s(), E("div", Se, [V(x("div", null, [r(o, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), y.value !== e(z).BOX.V ? (s(), c(T, { key: 0, modelValue: e(t).productType, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).productType = l), options: e(d).ENUM, unshowVal: e(t).projectId ? q.value : [], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"])) : A("", true), y.value === e(z).BOX.V ? (s(), c(T, { key: 1, modelValue: e(t).productType, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).productType = l), options: e(B).ENUM, disabledVal: [e(B).AUXILIARY_MATERIAL.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "disabledVal", "onChange"])) : A("", true), r(J, { modelValue: e(t).deliveryStatus, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).deliveryStatus = l), options: e(_e).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(Z, { modelValue: e(t).deliveryDate, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).deliveryDate = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, shortcuts: e(Ve), onChange: $ }, null, 8, ["modelValue", "shortcuts"]), r(ee, { modelValue: e(t).boolAccurateQuery, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).boolAccurateQuery = l), onChange: e(n).toQuery, label: "精确查询", size: "default" }, null, 8, ["modelValue", "onChange"]), x("div", null, [r(h, { modelValue: e(t).blurry, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).blurry = l), placeholder: "产品名称/产品编号", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(h, { modelValue: e(t).serialNumber, "onUpdate:modelValue": a[7] || (a[7] = (l) => e(t).serialNumber = l), placeholder: "可输入车次/船次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(h, { modelValue: e(t).licensePlate, "onUpdate:modelValue": a[8] || (a[8] = (l) => e(t).licensePlate = l), placeholder: "可输入车牌/船牌搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(h, { modelValue: e(t).driverName, "onUpdate:modelValue": a[9] || (a[9] = (l) => e(t).driverName = l), placeholder: "可输入司机搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(be))])], 512), [[re, e(n).searchToggle]]), r(e(De), null, { optLeft: f(() => [V(r(te, { "current-key": i.value, "onUpdate:currentKey": a[10] || (a[10] = (l) => i.value = l), "api-key": g.value, params: D.value, "before-print": F, size: "default", type: "warning", class: "filter-item" }, null, 8, ["current-key", "api-key", "params"]), [[S, [...e(m).print, ...e(m).detailPrint]]])]), viewLeft: f(() => [V((s(), c(R, { type: "warning", effect: "plain", class: "filter-item", size: "large" }, { default: f(() => [a[11] || (a[11] = K(" 过磅重量汇总（磅计）： ")), v.value ? (s(), c(O, { key: 1 }, { default: f(() => [r(I)]), _: 1 })) : (s(), E("span", Ee, P(e(W)(N.value, "kg", "t", 2)) + " t", 1))]), _: 1, __: [11] })), [[S, e(m).get]]), V((s(), c(R, { effect: "plain", class: "filter-item", size: "large" }, { default: f(() => [a[12] || (a[12] = K(" 累计发运重量（理计）： ")), v.value ? (s(), c(O, { key: 1 }, { default: f(() => [r(I)]), _: 1 })) : (s(), E("span", Ce, P(e(W)(w.value, "kg", "t", 2)) + " t", 1))]), _: 1, __: [12] })), [[S, e(m).get]])]), _: 1 })]);
  };
} }, Ie = ve(ke, [["__scopeId", "data-v-a4cbff3f"]]);
export {
  Ie as default
};
