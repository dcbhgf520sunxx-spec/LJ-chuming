import { inject as j } from "vue";
import { ref as i } from "vue";
import { computed as g } from "vue";
import { reactive as k } from "vue";
import { onMounted as q } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as b } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as E } from "vue";
import { createTextVNode as O } from "vue";
import { unref as n } from "vue";
import { createVNode as f } from "vue";
import { toDisplayString as V } from "vue";
import { ElNotification as T } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElForm as G } from "element-plus";
import { ElCard as W } from "element-plus";
import { vLoading as H } from "element-plus";
import { d as J, bC as K, hz as Q, V as w, gR as m, gT as x, hA as X } from "../../../../../shared/runtime.js";
import { u as Y } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const Z = { class: "clearfix" }, $ = { class: "flex-r" }, ee = { class: "form-item-tip" }, ne = { __name: "steel-inbound", setup(ae) {
  const C = j("permission"), l = i({ trainsDiff: void 0, trainsDiffType: void 0 }), p = i(), a = i(l.value), r = i(false), u = i(false), h = g(() => J(a.value, l.value)), N = g(() => r.value || u.value), R = k({ trainsDiffType: [{ validator: I }] });
  q(() => {
    S();
  }), K(p, a);
  async function S() {
    r.value = true;
    try {
      const t = await Q();
      a.value = w(t), l.value = t;
    } catch (t) {
      console.log("获取入库钢材配置", t);
    } finally {
      r.value = false;
    }
  }
  async function B() {
    try {
      if (!await p.value.validate()) return;
      u.value = true, await X(a.value), T({ title: "入库钢材配置设置成功", type: "success", duration: 2500 }), l.value = w(a.value), Y("wmsConfig");
    } catch {
      T({ title: "基础钢材配置设置失败", type: "error", duration: 2500 });
    } finally {
      u.value = false;
    }
  }
  function I(t, e, d) {
    e === m.PERCENTAGE.V && a.value.trainsDiff > 100 && d(new Error("误差百分比不可超过100")), d();
  }
  return (t, e) => {
    const d = v("common-tip-button"), y = v("common-radio-button"), U = v("common-input-number"), D = P, z = G, F = W, L = A("permission"), M = H;
    return _(), b(F, { shadow: "always" }, { header: o(() => [s("div", Z, [e[3] || (e[3] = s("span", { class: "card-title" }, "钢材入库过磅重量配置", -1)), E((_(), b(d, { loading: u.value, disabled: h.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: B }, { default: o(() => e[2] || (e[2] = [O(" 保存 ")])), _: 1, __: [2] }, 8, ["loading", "disabled"])), [[L, n(C).steelInboundEdit]])])]), default: o(() => [E((_(), b(z, { ref_key: "formRef", ref: p, disabled: N.value, model: a.value, rules: R, "label-position": "top", "label-width": "170px" }, { default: o(() => [f(D, { class: "form-tip-item", prop: "trainsDiffType" }, { label: o(() => [s("span", null, "车次/船次钢材总重误差(" + V(a.value.trainsDiffType === n(m).NUMBER.V ? n(x) : "%") + ")", 1)]), default: o(() => [s("div", $, [f(y, { modelValue: a.value.trainsDiffType, "onUpdate:modelValue": e[0] || (e[0] = (c) => a.value.trainsDiffType = c), options: n(m).ENUM, default: "", type: "enum", size: "default" }, null, 8, ["modelValue", "options"]), f(U, { modelValue: a.value.trainsDiff, "onUpdate:modelValue": e[1] || (e[1] = (c) => a.value.trainsDiff = c), max: (a.value.trainsDiffType === n(m).NUMBER.V, 999999999999), "controls-position": "right", size: "default", placeholder: "请输入允许的误差值", style: { width: "200px", "margin-left": "10px" }, min: 0, precision: 0 }, null, 8, ["modelValue", "max"])])]), _: 1 }), f(D, null, { default: o(() => [e[4] || (e[4] = s("span", { class: "form-item-tip" }, " 可配置一车次/船次钢材的最大误差。【入库钢材的总重量】与【当前车过磅重量】的差值（绝对值）超过该误差，将无法提交入库申请。 ", -1)), s("span", ee, "固定重量(" + V(n(x)) + ")：误差不可超过 固定重量；", 1), e[5] || (e[5] = s("span", { class: "form-item-tip" }, "百分比(%)：误差不可超过 入库钢材总重量*百分比。", -1))]), _: 1, __: [4, 5] })]), _: 1 }, 8, ["disabled", "model", "rules"])), [[M, r.value]])]), _: 1 });
  };
} };
export {
  ne as default
};
