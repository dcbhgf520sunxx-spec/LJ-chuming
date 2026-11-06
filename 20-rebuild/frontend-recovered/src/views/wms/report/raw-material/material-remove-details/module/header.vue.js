import { ref as N } from "vue";
import { inject as j } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as _ } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { withCtx as r } from "vue";
import { withKeys as x } from "vue";
import { createElementVNode as k } from "vue";
import { createCommentVNode as h } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as y } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as d } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElTag as K } from "element-plus";
import { l as g, B as P, sQ as $, cJ as R, jZ as A, fv as F, gF as I, y3 as v, I as H, ya as J, C as Z, L as G, j_ as f, bV as c, E as X } from "../../../../../../shared/runtime.js";
import { r as Y } from "../../../../../../modules/reset-query-5216307c.js";
function ie(n) {
  return g({ url: "/api/wms/report/raw-materials/moveMaterial/details", method: "get", params: n });
}
function ee(n) {
  return g({ url: "/api/wms/report/raw-materials/moveMaterial/details/excel", method: "get", responseType: "blob", timeout: 6e7, params: n });
}
function ue(n) {
  return g({ url: "/api/wms/report/raw-materials/moveMaterial/detailsCount", method: "get", params: n });
}
const te = { class: "head-container" }, oe = { key: 0 }, ae = { class: "flex gap-2" }, le = { __name: "header", props: { DetailsCount: { type: Object } }, setup(n) {
  const p = n, T = N([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), E = { projectIds: [], sourceWorkshopIds: [], sourceWarehouseIds: [], directionWorkshopIds: [], directionWarehouseIds: [], outboundTime: [], basicClass: void 0, moveMaterialSN: void 0, orderSupplyType: void 0, operatorName: void 0 }, S = j("permission"), { crud: s, query: t } = P(E), { baseUnit: W } = $(t.basicClass);
  async function D(U) {
    await Y(t), s.toQuery(), s.data = [], s.setColumns();
  }
  return (U, a) => {
    const C = L("common-radio-button"), Q = O, V = z, m = K, M = q("permission");
    return i(), _("div", te, [e(s).searchToggle ? (i(), _("div", oe, [l(J, { "basic-class": e(t).basicClass, query: e(t), "show-warehouse": false, "to-query": e(s).toQuery, multiple: "" }, { afterProjectWarehouseType: r(() => [l(C, { modelValue: e(t).basicClass, "onUpdate:modelValue": a[0] || (a[0] = (o) => e(t).basicClass = o), options: e(R).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: D }, null, 8, ["modelValue", "options"]), l(C, { modelValue: e(t).orderSupplyType, "onUpdate:modelValue": a[1] || (a[1] = (o) => e(t).orderSupplyType = o), options: e(A).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enumSL", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), beforeWarehouse: r(() => [l(e(F), { modelValue: e(t).projectIds, "onUpdate:modelValue": a[2] || (a[2] = (o) => e(t).projectIds = o), class: "filter-item", clearable: "", multiple: "", placeholder: "关联项目", style: { width: "300px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(I, { modelValue: e(t).sourceWorkshopIds, "onUpdate:modelValue": a[3] || (a[3] = (o) => e(t).sourceWorkshopIds = o), class: "filter-item", clearable: "", multiple: "", placeholder: "原仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(v, { modelValue: e(t).sourceWarehouseIds, "onUpdate:modelValue": a[4] || (a[4] = (o) => e(t).sourceWarehouseIds = o), "workshop-id": e(t).sourceWorkshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "原存储位置", showAll: "", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "workshop-id", "onChange"])]), secondLineFirstItem: r(() => [l(I, { modelValue: e(t).directionWorkshopIds, "onUpdate:modelValue": a[5] || (a[5] = (o) => e(t).directionWorkshopIds = o), class: "filter-item", clearable: "", multiple: "", placeholder: "目标仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(v, { modelValue: e(t).directionWarehouseIds, "onUpdate:modelValue": a[6] || (a[6] = (o) => e(t).directionWarehouseIds = o), "workshop-id": e(t).directionWorkshopIds, class: "filter-item", clearable: "", multiple: "", placeholder: "目标存储位置", showAll: "", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "workshop-id", "onChange"]), l(Q, { modelValue: e(t).outboundTime, "onUpdate:modelValue": a[7] || (a[7] = (o) => e(t).outboundTime = o), "default-time": T.value, shortcuts: e(H), class: "filter-item", "end-placeholder": "移库时间", "range-separator": ":", size: "default", "start-placeholder": "移库时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), l(V, { modelValue: e(t).moveMaterialSN, "onUpdate:modelValue": a[8] || (a[8] = (o) => e(t).moveMaterialSN = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "移库单号", size: "default", style: { width: "160px" }, onKeyup: x(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(V, { modelValue: e(t).operatorName, "onUpdate:modelValue": a[9] || (a[9] = (o) => e(t).operatorName = o), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人/审核人", size: "default", style: { width: "140px" }, onKeyup: x(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a[10] || (a[10] = k("br", null, null, -1))]), _: 1 }, 8, ["basic-class", "query", "to-query"]), l(e(Z))])) : h("", true), l(e(X), null, { optLeft: r(() => [B((i(), y(G, { fn: e(ee), params: e(t), "response-header-result": "" }, { default: r(() => a[11] || (a[11] = [u(" 下载移库明细（根据查询条件） ")])), _: 1, __: [11] }, 8, ["fn", "params"])), [[M, e(S).get]])]), viewLeft: r(() => [k("div", ae, [e(t).basicClass & e(f).STEEL.V ? (i(), y(m, { key: 0, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "primary" }, { default: r(() => {
      var o;
      return [u(" 数量汇总：" + d(e(c)(((o = p.DetailsCount) == null ? void 0 : o.quantityCount) || 0)), 1)];
    }), _: 1 })) : h("", true), e(t).basicClass & e(f).STEEL.V ? (i(), y(m, { key: 1, class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "success" }, { default: r(() => {
      var o, b, w;
      return [u(" 核算量汇总：" + d(e(c)(((o = p.DetailsCount) == null ? void 0 : o.meteCount) || 0)) + " " + d(((b = e(t)) == null ? void 0 : b.basicClass) & e(f).STEEL.V ? e(W)[(w = e(t)) == null ? void 0 : w.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : h("", true), l(m, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "info" }, { default: r(() => {
      var o;
      return [u(" 含税金额汇总：" + d(e(c)(((o = p.DetailsCount) == null ? void 0 : o.amountCount) || 0)) + " 元 ", 1)];
    }), _: 1 }), l(m, { class: "filter-item", style: { height: "30px", "line-height": "28px" }, type: "warning" }, { default: r(() => {
      var o;
      return [u(" 不含税金额汇总：" + d(e(c)(((o = p.DetailsCount) == null ? void 0 : o.amountExcludingVatCount) || 0)) + " 元 ", 1)];
    }), _: 1 })])]), _: 1 })]);
  };
} }, de = Object.freeze(Object.defineProperty({ __proto__: null, default: le }, Symbol.toStringTag, { value: "Module" }));
export {
  le as _,
  ue as a,
  ie as g,
  de as h
};
