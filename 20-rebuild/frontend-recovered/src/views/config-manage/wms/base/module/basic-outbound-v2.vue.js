import { inject as P } from "vue";
import { ref as s } from "vue";
import { computed as V } from "vue";
import { onMounted as q } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as d } from "vue";
import { createBlock as v } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as O } from "vue";
import { createTextVNode as E } from "vue";
import { unref as i } from "vue";
import { createVNode as l } from "vue";
import { createElementBlock as G } from "vue";
import { Fragment as H } from "vue";
import { renderList as W } from "vue";
import { toDisplayString as X } from "vue";
import { ElNotification as w } from "element-plus";
import { ElSwitch as Y } from "element-plus";
import { ElFormItem as Z } from "element-plus";
import { ElCheckbox as J } from "element-plus";
import { ElCheckboxGroup as K } from "element-plus";
import { ElForm as Q } from "element-plus";
import { ElCard as $ } from "element-plus";
import { vLoading as ee } from "element-plus";
import { gG as r, gX as oe, i as h, bv as te, V as c, au as f, gY as ae, gZ as x, g_ as le } from "../../../../../shared/runtime.js";
import { j as U } from "../../../../../modules/judgeSameValue-9683bdce.js";
import { u as ue } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const ne = { class: "clearfix" }, be = { __name: "basic-outbound-v2", setup(ie) {
  const C = P("permission"), p = s({ productionOutBoundUserIsRequired: void 0, boolAuxMatToWorkShopWay: void 0, boolGasOutAfterInbound: void 0, boolCanOutToOtherProject: void 0, outboundTypeList: [r.PRODUCE.V], outboundTypes: [], cancelDestination: void 0, returnedDestination: void 0, showHalfOut: void 0 }), e = s(p.value), m = s(false), b = s(false), D = s([r.PRODUCE, r.FOR_SALE]), B = V(() => U(e.value, p.value)), k = V(() => m.value || b.value);
  q(() => {
    T();
  });
  async function T() {
    m.value = true;
    try {
      const o = await oe();
      h(o.outboundType) && (o.originOutboundTypeList = [], o.outboundTypeList = te.getBits(r.ENUM, o.outboundType, "V"), h(o.outboundTypeList) || o.outboundTypeList.push(r.PRODUCE.V), o.originOutboundTypeList = c(o.outboundTypeList)), e.value = c(o), p.value = o;
    } catch (o) {
      console.log("出库基础配置", o);
    } finally {
      m.value = false;
    }
  }
  async function R() {
    try {
      if (b.value = true, !U(e.value.outboundTypeList, e.value.originOutboundTypeList)) {
        e.value.outboundTypes = [];
        for (let o = 0; o < e.value.originOutboundTypeList.length; o++) e.value.outboundTypeList.includes(e.value.originOutboundTypeList[o]) || e.value.outboundTypes.push(e.value.originOutboundTypeList[o]);
        for (let o = 0; o < e.value.outboundTypeList.length; o++) e.value.outboundType = o === 0 ? e.value.outboundTypeList[0] : e.value.outboundType | e.value.outboundTypeList[o];
      }
      await le(e.value), w({ title: "出库基础配置设置成功", type: "success", duration: 2500 }), T(), p.value = c(e.value), ue("wmsConfig");
    } catch {
      e.value.outboundTypeList = c(e.value.originOutboundTypeList), w({ title: "出库基础配置设置失败", type: "error", duration: 2500 });
    } finally {
      b.value = false;
    }
  }
  return (o, t) => {
    const S = L("common-tip-button"), g = Y, n = Z, y = L("common-radio"), N = J, j = K, F = Q, A = $, I = z("permission"), M = ee;
    return d(), v(A, { shadow: "always" }, { header: u(() => [_("div", ne, [t[7] || (t[7] = _("span", { class: "card-title" }, "出库基础配置", -1)), O((d(), v(S, { disabled: B.value, loading: b.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: R }, { default: u(() => t[6] || (t[6] = [E(" 保存 ")])), _: 1, __: [6] }, 8, ["disabled", "loading"])), [[I, i(C).basicOutboundEdit]])])]), default: u(() => [O((d(), v(F, { disabled: k.value, model: e.value, "label-position": "left", "label-width": "200px" }, { default: u(() => [l(n, { label: "项目仓物料可出库到其它项目" }, { default: u(() => [l(g, { modelValue: e.value.boolCanOutToOtherProject, "onUpdate:modelValue": t[0] || (t[0] = (a) => e.value.boolCanOutToOtherProject = a), "active-value": i(f).TRUE.V, "inactive-value": i(f).FALSE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 }), l(n, { "label-width": "0px" }, { default: u(() => t[8] || (t[8] = [_("span", { class: "form-item-tip" }, "在项目仓中可以选择原材料出库到其它项目, 在仓管确认出库后，会生成已审核的物料调拨单（审核人为确认出库的用户）。", -1)])), _: 1, __: [8] }), l(n, { label: "领料人是否必填：", "label-width": "140px", style: { "margin-left": "10px" } }, { default: u(() => [l(y, { modelValue: e.value.productionOutBoundUserIsRequired, "onUpdate:modelValue": t[1] || (t[1] = (a) => e.value.productionOutBoundUserIsRequired = a), options: i(ae).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(n, { label: "出库类型显示配置：" }), l(n, { label: "出库类型显示：", "label-width": "110px", style: { "margin-left": "10px" } }, { default: u(() => [l(j, { modelValue: e.value.outboundTypeList, "onUpdate:modelValue": t[2] || (t[2] = (a) => e.value.outboundTypeList = a) }, { default: u(() => [(d(true), G(H, null, W(D.value, (a) => (d(), v(N, { key: a.V, disabled: a.DISABLED, value: a.V }, { default: u(() => [E(X(a.L), 1)]), _: 2 }, 1032, ["disabled", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), l(n, { label: "出库撤销后数据返回：", "label-width": "160px", style: { "margin-left": "10px" } }, { default: u(() => [l(y, { modelValue: e.value.cancelDestination, "onUpdate:modelValue": t[3] || (t[3] = (a) => e.value.cancelDestination = a), options: i(x).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(n, { label: "出库驳回后数据返回：", "label-width": "160px", style: { "margin-left": "10px" } }, { default: u(() => [l(y, { modelValue: e.value.returnedDestination, "onUpdate:modelValue": t[4] || (t[4] = (a) => e.value.returnedDestination = a), options: i(x).ENUM, size: "small", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(n, { label: "钢板型材可半出", "label-width": "120px" }, { default: u(() => [l(g, { modelValue: e.value.showHalfOut, "onUpdate:modelValue": t[5] || (t[5] = (a) => e.value.showHalfOut = a), "active-value": i(f).TRUE.V, "inactive-value": i(f).FALSE.V, class: "drawer-switch" }, null, 8, ["modelValue", "active-value", "inactive-value"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[M, m.value]])]), _: 1 });
  };
} };
export {
  be as default
};
