import { ref as h } from "vue";
import { inject as P } from "vue";
import { watchEffect as $ } from "vue";
import { resolveComponent as F } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as v } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { withCtx as n } from "vue";
import { createBlock as r } from "vue";
import { createCommentVNode as i } from "vue";
import { withKeys as N } from "vue";
import { createElementVNode as D } from "vue";
import { withDirectives as A } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as y } from "vue";
import { ElDatePicker as G } from "element-plus";
import { ElInput as J } from "element-plus";
import { ElTag as X } from "element-plus";
import { b as Y, e as Z, c as ee } from "../../../../../../modules/outbound-13fff63c.js";
import { jY as oe, jJ as p, gG as C, B as te, sQ as ae, cV as se, cJ as le, v0 as ne, jZ as ue, qS as re, aV as ie, gF as de, y3 as pe, I as W, ya as me, C as ye, L as j, i as R, bV as g, j_ as M, E as ce } from "../../../../../../shared/runtime.js";
import { _ as fe } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { r as he } from "../../../../../../modules/reset-query-5216307c.js";
const Ce = { class: "head-container" }, ge = { key: 0 }, Ve = { class: "flex gap-2" }, Se = { __name: "header", props: { DetailsCount: { type: Object } }, setup(Q) {
  const { reportCfg: T } = oe(), b = h([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), L = { outboundTime: [], reviewTime: [], purchaseType: { value: p.RAW_MATERIAL.V, resetAble: false }, basicClass: void 0, orderSupplyType: void 0, sourceWorkshopIds: [], projectWarehouseType: void 0, outboundSN: void 0, operatorName: void 0, outboundTypeSelection: C.PRODUCE.V, boolScheduling: void 0 }, O = h([C.PRODUCE, C.SCHEDULING_OUTBOUND, C.CONSTRUCTION_SITE_USE]), c = Q, E = P("permission"), { crud: s, query: o, CRUD: q } = te(L), { baseUnit: z } = ae(o.basicClass), w = h(false), B = h();
  q.HOOK.beforeToQuery = () => {
    K();
  };
  async function K() {
    if (o.basicClass & se) {
      w.value = true;
      try {
        B.value = await Y(s.query) || 0;
      } catch (V) {
        console.log("获取汇总数据", V);
      } finally {
        w.value = false;
      }
    }
  }
  $(() => {
    o.purchaseType & p.MANUFACTURED.V && (o.orderSupplyType = void 0, o.basicClass = void 0), o.purchaseType & p.RAW_MATERIAL.V && (o.basicClass = void 0);
  });
  async function U(V) {
    await he(o), s.toQuery(), s.data = [], s.setColumns();
  }
  return (V, a) => {
    const m = F("common-radio-button"), S = G, _ = J, f = X, x = H("permission");
    return u(), v("div", Ce, [e(s).searchToggle ? (u(), v("div", ge, [l(me, { "basic-class": e(o).basicClass, query: e(o), showWarehouse: false, "to-query": e(s).toQuery, "mes-workshop": "", multiple: "" }, { afterProjectWarehouseType: n(() => [e(o).purchaseType & e(p).RAW_MATERIAL.V ? (u(), r(m, { key: 0, modelValue: e(o).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(o).basicClass = t), options: e(le).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: U }, null, 8, ["modelValue", "options"])) : i("", true), e(o).purchaseType & e(p).MANUFACTURED.V ? (u(), r(m, { key: 1, modelValue: e(o).basicClass, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(o).basicClass = t), options: e(ne).ENUM, "show-option-all": "", size: "default", type: "enum", onChange: U }, null, 8, ["modelValue", "options"])) : i("", true), e(o).purchaseType & e(p).RAW_MATERIAL.V ? (u(), r(m, { key: 2, modelValue: e(o).orderSupplyType, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(o).orderSupplyType = t), options: e(ue).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : i("", true), l(m, { modelValue: e(o).outboundTypeSelection, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(o).outboundTypeSelection = t), options: O.value, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(m, { modelValue: e(o).outboundAddress, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(o).outboundAddress = t), options: e(re).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), beforeWarehouse: n(() => [l(e(ie), { modelValue: e(o).workshopId, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(o).workshopId = t), class: "filter-item", clearable: "", placeholder: "可选择车间", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(de, { modelValue: e(o).sourceWorkshopIds, "onUpdate:modelValue": a[6] || (a[6] = (t) => e(o).sourceWorkshopIds = t), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(pe, { modelValue: e(o).warehouseId, "onUpdate:modelValue": a[7] || (a[7] = (t) => e(o).warehouseId = t), "basic-class": e(o).basicClass, "workshop-id": e(o).sourceWorkshopIds, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: e(s).toQuery }, null, 8, ["modelValue", "basic-class", "workshop-id", "onChange"])]), afterWarehouse: n(() => a[14] || (a[14] = [])), secondLineFirstItem: n(() => [l(e(fe), { projectId: e(o).projectId, "onUpdate:projectId": a[8] || (a[8] = (t) => e(o).projectId = t), projectWarehouseType: e(o).projectWarehouseType, "onUpdate:projectWarehouseType": a[9] || (a[9] = (t) => e(o).projectWarehouseType = t), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), l(S, { modelValue: e(o).outboundTime, "onUpdate:modelValue": a[10] || (a[10] = (t) => e(o).outboundTime = t), "default-time": b.value, type: "daterange", "range-separator": ":", class: "filter-item", size: "default", "value-format": "x", shortcuts: e(W), "unlink-panels": "", "start-placeholder": "实际出库时间", "end-placeholder": "实际出库时间", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(S, { modelValue: e(o).reviewTime, "onUpdate:modelValue": a[11] || (a[11] = (t) => e(o).reviewTime = t), "default-time": b.value, type: "daterange", "range-separator": ":", class: "filter-item", size: "default", "value-format": "x", shortcuts: e(W), "unlink-panels": "", "start-placeholder": "审核时间", "end-placeholder": "审核时间", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(_, { modelValue: e(o).outboundSN, "onUpdate:modelValue": a[12] || (a[12] = (t) => e(o).outboundSN = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "160px" }, onKeyup: N(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(_, { modelValue: e(o).operatorName, "onUpdate:modelValue": a[13] || (a[13] = (t) => e(o).operatorName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请/审核/领用人", size: "default", style: { width: "150px" }, onKeyup: N(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a[15] || (a[15] = D("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), l(e(ye))])) : i("", true), l(e(ce), null, { optLeft: n(() => [A((u(), r(j, { fn: e(Z), params: e(o), "response-header-result": "" }, { default: n(() => a[16] || (a[16] = [d(" 下载出库明细（根据查询条件） ")])), _: 1, __: [16] }, 8, ["fn", "params"])), [[x, e(E).get]]), A((u(), r(j, { fn: e(ee), params: e(o), "response-header-result": "", type: "primary" }, { default: n(() => a[17] || (a[17] = [d(" 下载出库明细（体现退库，根据查询条件） ")])), _: 1, __: [17] }, 8, ["fn", "params"])), [[x, e(E).get]])]), viewLeft: n(() => [D("div", Ve, [e(R)(e(o).basicClass) ? (u(), r(f, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "primary" }, { default: n(() => {
      var t;
      return [d(" 数量汇总：" + y(e(g)(((t = c.DetailsCount) == null ? void 0 : t.quantityCount) || 0)), 1)];
    }), _: 1 })) : i("", true), e(o).basicClass & e(M).STEEL.V || e(R)(e(o).basicClass) ? (u(), r(f, { key: 1, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "success" }, { default: n(() => {
      var t, k, I;
      return [d(" 核算量汇总：" + y(e(g)(((t = c.DetailsCount) == null ? void 0 : t.meteCount) || 0)) + " " + y(((k = e(o)) == null ? void 0 : k.basicClass) & e(M).STEEL.V ? e(z)[(I = e(o)) == null ? void 0 : I.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : i("", true), e(T).amountShow ? (u(), r(f, { key: 2, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: n(() => {
      var t;
      return [d(" 含税金额汇总：" + y(e(g)(((t = c.DetailsCount) == null ? void 0 : t.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 })) : i("", true), e(T).amountExcludingTAXShow ? (u(), r(f, { key: 3, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: n(() => {
      var t;
      return [d(" 不含税金额汇总：" + y(e(g)(((t = c.DetailsCount) == null ? void 0 : t.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })) : i("", true)])]), _: 1 })]);
  };
} };
export {
  Se as default
};
