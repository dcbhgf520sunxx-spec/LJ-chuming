import { ref as E } from "vue";
import { inject as L } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as x } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { withCtx as n } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as y } from "vue";
import { withKeys as U } from "vue";
import { createElementVNode as j } from "vue";
import { withDirectives as z } from "vue";
import { createTextVNode as i } from "vue";
import { toDisplayString as d } from "vue";
import { ElDatePicker as B } from "element-plus";
import { ElInput as M } from "element-plus";
import { ElTag as K } from "element-plus";
import { l as V, B as $, sQ as A, gG as g, cJ as F, jZ as T, gF as H, y3 as Y, I as G, ya as J, C as Z, L as X, j_ as b, bV as f, E as ee } from "../../../../../../shared/runtime.js";
import { _ as te } from "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import { r as oe } from "../../../../../../modules/reset-query-5216307c.js";
import { _ as ae } from "../../../../../../modules/closing-time-date-query-82715fa2.js";
function ye(r) {
  return V({ module: "wms", url: "report/raw-materials/return/details", method: "get", params: r });
}
function se(r) {
  return V({ module: "wms", url: "report/raw-materials/return/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: r });
}
function fe(r) {
  return V({ module: "wms", url: "report/raw-materials/return/detailsCount", method: "get", params: r });
}
const le = { class: "head-container" }, ne = { key: 0 }, re = { class: "flex gap-2" }, ue = { __name: "header", props: { DetailsCount: { type: Object } }, setup(r) {
  const p = r, I = E([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), v = { realTime: [], reviewTime: [], basicClass: void 0, orderSupplyType: void 0, projectId: void 0, projectWarehouseType: void 0, outboundSN: void 0, operatorName: void 0, sourceWorkshopIds: void 0 }, k = L("permission"), { crud: s, query: t } = $(v), { baseUnit: D } = A(t.basicClass), N = E([g.PRODUCE, g.OUTSOURCE, g.CONSTRUCTION_SITE_USE]);
  async function Q(h) {
    await oe(t), s.toQuery(), s.data = [], s.setColumns();
  }
  function W(h) {
    h === T.PARTY_A.V && (t.outboundTypeSelection = void 0), s.toQuery();
  }
  return (h, a) => {
    const C = R("common-radio-button"), O = B, _ = M, m = K, P = q("permission");
    return u(), x("div", le, [e(s).searchToggle ? (u(), x("div", ne, [l(J, { "basic-class": e(t).basicClass, query: e(t), showWarehouse: false, "to-query": e(s).toQuery, multiple: "" }, { afterProjectWarehouseType: n(() => [l(C, { modelValue: e(t).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).basicClass = o), options: e(F).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: Q }, null, 8, ["modelValue", "options"]), l(C, { modelValue: e(t).orderSupplyType, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).orderSupplyType = o), options: e(T).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: W }, null, 8, ["modelValue", "options"]), e(t).orderSupplyType !== e(T).PARTY_A.V ? (u(), c(C, { key: 0, modelValue: e(t).outboundTypeSelection, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).outboundTypeSelection = o), options: N.value, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : y("", true)]), beforeWarehouse: n(() => [l(H, { modelValue: e(t).sourceWorkshopIds, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).sourceWorkshopIds = o), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(Y, { modelValue: e(t).warehouseId, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(t).warehouseId = o), "basic-class": e(t).basicClass, "workshop-id": e(t).sourceWorkshopIds, class: "filter-item", clearable: "", placeholder: "存储位置", "show-all": "", onChange: e(s).toQuery }, null, 8, ["modelValue", "basic-class", "workshop-id", "onChange"])]), secondLineFirstItem: n(() => [l(e(te), { projectId: e(t).projectId, "onUpdate:projectId": a[5] || (a[5] = (o) => e(t).projectId = o), projectWarehouseType: e(t).projectWarehouseType, "onUpdate:projectWarehouseType": a[6] || (a[6] = (o) => e(t).projectWarehouseType = o), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"]), l(ae, { modelValue: e(t).realTime, "onUpdate:modelValue": a[7] || (a[7] = (o) => e(t).realTime = o), label: "退库", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(O, { modelValue: e(t).reviewTime, "onUpdate:modelValue": a[8] || (a[8] = (o) => e(t).reviewTime = o), "default-time": I.value, type: "daterange", "range-separator": ":", class: "filter-item", size: "default", "value-format": "x", shortcuts: e(G), "unlink-panels": "", "start-placeholder": "审核时间", "end-placeholder": "审核时间", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(_, { modelValue: e(t).outboundSN, "onUpdate:modelValue": a[9] || (a[9] = (o) => e(t).outboundSN = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "退库单号", size: "default", style: { width: "160px" }, onKeyup: U(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(_, { modelValue: e(t).operatorName, "onUpdate:modelValue": a[10] || (a[10] = (o) => e(t).operatorName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/审核人", size: "default", style: { width: "140px" }, onKeyup: U(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a[11] || (a[11] = j("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), l(e(Z))])) : y("", true), l(e(ee), null, { optLeft: n(() => [z((u(), c(X, { fn: e(se), params: e(t), "response-header-result": "" }, { default: n(() => a[12] || (a[12] = [i(" 下载退库明细（根据查询条件） ")])), _: 1, __: [12] }, 8, ["fn", "params"])), [[P, e(k).get]])]), viewLeft: n(() => [j("div", re, [e(t).basicClass & e(b).STEEL.V ? (u(), c(m, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "primary" }, { default: n(() => {
      var o;
      return [i(" 数量汇总：" + d(e(f)(((o = p.DetailsCount) == null ? void 0 : o.quantityCount) || 0)), 1)];
    }), _: 1 })) : y("", true), e(t).basicClass & e(b).STEEL.V ? (u(), c(m, { key: 1, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "success" }, { default: n(() => {
      var o, w, S;
      return [i(" 核算量汇总：" + d(e(f)(((o = p.DetailsCount) == null ? void 0 : o.meteCount) || 0)) + " " + d(((w = e(t)) == null ? void 0 : w.basicClass) & e(b).STEEL.V ? e(D)[(S = e(t)) == null ? void 0 : S.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : y("", true), l(m, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: n(() => {
      var o;
      return [i(" 含税金额汇总：" + d(e(f)(((o = p.DetailsCount) == null ? void 0 : o.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 }), l(m, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: n(() => {
      var o;
      return [i(" 不含税金额汇总：" + d(e(f)(((o = p.DetailsCount) == null ? void 0 : o.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })])]), _: 1 })]);
  };
} }, he = Object.freeze(Object.defineProperty({ __proto__: null, default: ue }, Symbol.toStringTag, { value: "Module" }));
export {
  ue as _,
  fe as a,
  ye as g,
  he as h
};
