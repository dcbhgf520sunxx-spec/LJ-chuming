import { ref as j } from "vue";
import { inject as B } from "vue";
import { watchEffect as M } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as V } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { withCtx as o } from "vue";
import { withKeys as T } from "vue";
import { createCommentVNode as i } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as u } from "vue";
import { createTextVNode as d } from "vue";
import { createElementVNode as K } from "vue";
import { toDisplayString as m } from "vue";
import { ElInput as L } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { ElTag as P } from "element-plus";
import { d as $ } from "../../../../../../../modules/outbound-13fff63c.js";
import { jY as H, gG as F, B as J, sQ as G, jJ as w, cJ as X, aV as Y, I as E, ya as Z, C as ee, L as ae, i as v, bV as f, j_ as k, E as te } from "../../../../../../../shared/runtime.js";
import { r as se } from "../../../../../../../modules/reset-query-5216307c.js";
const oe = { class: "head-container" }, le = { key: 0 }, ne = { class: "flex gap-2" }, me = { __name: "header", props: { DetailsCount: { type: Object } }, setup(x) {
  const { reportCfg: y } = H(), C = j([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), D = { reviewTime: [], materialOutboundTime: [], basicClass: void 0, orderSupplyType: void 0, monomerId: void 0, areaId: void 0, workshopId: void 0, projectWarehouseType: void 0, outboundSN: void 0, operatorName: void 0, outboundTypeSelection: { value: F.OUTSOURCE.V, resetAble: false } }, p = x, S = B("permission"), { crud: l, query: a, CRUD: U } = J(D), { baseUnit: N } = G(a.basicClass);
  U.HOOK.beforeToQuery = () => {
  }, M(() => {
    a.purchaseType & w.MANUFACTURED.V && (a.orderSupplyType = void 0, a.basicClass = void 0), a.purchaseType & w.RAW_MATERIAL.V && (a.basicClass = void 0);
  });
  async function O(I) {
    await se(a), l.toQuery(), l.data = [], l.setColumns();
  }
  return (I, s) => {
    const Q = R("common-radio-button"), h = L, _ = W, c = P, z = q("permission");
    return r(), V("div", oe, [e(l).searchToggle ? (r(), V("div", le, [n(Z, { "basic-class": e(a).basicClass, query: e(a), "to-query": e(l).toQuery }, { afterProjectWarehouseType: o(() => [n(Q, { modelValue: e(a).basicClass, "onUpdate:modelValue": s[0] || (s[0] = (t) => e(a).basicClass = t), options: e(X).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: O }, null, 8, ["modelValue", "options"])]), beforeWarehouse: o(() => [n(e(Y), { modelValue: e(a).workshopId, "onUpdate:modelValue": s[1] || (s[1] = (t) => e(a).workshopId = t), class: "filter-item", placeholder: "可选择车间", size: "default", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"])]), afterWarehouse: o(() => [n(h, { modelValue: e(a).outboundSN, "onUpdate:modelValue": s[2] || (s[2] = (t) => e(a).outboundSN = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "出库单号", size: "default", style: { width: "160px" }, onKeyup: T(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(h, { modelValue: e(a).operatorName, "onUpdate:modelValue": s[3] || (s[3] = (t) => e(a).operatorName = t), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请/审核/领用人", size: "default", style: { width: "150px" }, onKeyup: T(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"])]), secondLineFirstItem: o(() => [n(_, { modelValue: e(a).materialOutboundTime, "onUpdate:modelValue": s[4] || (s[4] = (t) => e(a).materialOutboundTime = t), "default-time": C.value, shortcuts: e(E), class: "filter-item", "end-placeholder": "出库时间", "range-separator": ":", size: "default", "start-placeholder": "出库时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), n(_, { modelValue: e(a).reviewTime, "onUpdate:modelValue": s[5] || (s[5] = (t) => e(a).reviewTime = t), "default-time": C.value, shortcuts: e(E), class: "filter-item", "end-placeholder": "审核时间", "range-separator": ":", size: "default", "start-placeholder": "审核时间", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), n(e(ee))])) : i("", true), n(e(te), null, { optLeft: o(() => [A((r(), u(ae, { fn: e($), params: e(a), "response-header-result": "" }, { default: o(() => s[6] || (s[6] = [d(" 下载外协原料出库明细（根据查询条件） ")])), _: 1, __: [6] }, 8, ["fn", "params"])), [[z, e(S).get]])]), viewLeft: o(() => [K("div", ne, [e(v)(e(a).basicClass) ? (r(), u(c, { key: 0, class: "filter-item", size: "large", type: "primary" }, { default: o(() => {
      var t;
      return [d(" 数量汇总：" + m(e(f)((t = p.DetailsCount) == null ? void 0 : t.quantityCount) || "0"), 1)];
    }), _: 1 })) : i("", true), e(a).basicClass & e(k).STEEL.V || e(v)(e(a).basicClass) ? (r(), u(c, { key: 1, class: "filter-item", size: "large", type: "success" }, { default: o(() => {
      var t, b, g;
      return [d(" 核算量汇总：" + m(e(f)((t = p.DetailsCount) == null ? void 0 : t.meteCount) || "0") + " " + m(((b = e(a)) == null ? void 0 : b.basicClass) & e(k).STEEL.V ? e(N)[(g = e(a)) == null ? void 0 : g.basicClass].weight.unit : ""), 1)];
    }), _: 1 })) : i("", true), e(y).amountShow ? (r(), u(c, { key: 2, class: "filter-item", size: "large", type: "info" }, { default: o(() => {
      var t;
      return [d(" 含税金额汇总：" + m(e(f)((t = p.DetailsCount) == null ? void 0 : t.amountCount) || "0") + " 元 ", 1)];
    }), _: 1 })) : i("", true), e(y).amountExcludingTAXShow ? (r(), u(c, { key: 3, class: "filter-item", size: "large", type: "warning" }, { default: o(() => {
      var t;
      return [d(" 不含税金额汇总：" + m(e(f)((t = p.DetailsCount) == null ? void 0 : t.amountExcludingVatCount) || "0") + " 元 ", 1)];
    }), _: 1 })) : i("", true)])]), _: 1 })]);
  };
} };
export {
  me as default
};
