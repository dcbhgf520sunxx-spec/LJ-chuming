import { inject as K } from "vue";
import { ref as m } from "vue";
import { computed as L } from "vue";
import { reactive as X } from "vue";
import { watchEffect as Y } from "vue";
import { onMounted as Z } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as T } from "vue";
import { createTextVNode as le } from "vue";
import { unref as r } from "vue";
import { createVNode as s } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as C } from "vue";
import { renderList as N } from "vue";
import { toDisplayString as U } from "vue";
import { ElNotification as k } from "element-plus";
import { ElFormItem as ae } from "element-plus";
import { ElCheckbox as te } from "element-plus";
import { ElForm as oe } from "element-plus";
import { ElCard as se } from "element-plus";
import { vLoading as ne } from "element-plus";
import { bl as g, d as ie, gQ as ue, V as S, gR as V, gS as re, gT as F, gU as fe } from "../../../../../shared/runtime.js";
import { u as de } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const me = { class: "clearfix" }, pe = { class: "flex-r" }, ce = { class: "form-item-tip" }, ye = { __name: "basic-inbound", setup(ve) {
  const M = K("permission"), B = { [g.STEEL_PLATE.V]: { spec: { L: "规格", V: false }, thickness: { L: "厚度", V: false }, length: { L: "长度", V: false }, width: { L: "宽度", V: false } }, [g.SECTION_STEEL.V]: { spec: { L: "规格", V: false }, length: { L: "定尺长度", V: false } } }, i = m(), c = m({ amountFillWay: void 0, steelDiff: void 0, steelDiffType: void 0, procureMeteDiff: void 0 }), E = m(), l = m(c.value), v = m(false), _ = m(false), R = L(() => ie(l.value, c.value)), I = L(() => v.value || _.value), z = X({ steelDiffType: [{ validator: O }] });
  Y(() => {
    const a = {};
    for (const e in i.value) for (const t in i.value[e]) a[t] || (a[t] = 0), i.value[e][t].V && (a[t] |= Number(e));
    l.value = { ...l.value, ...a };
  }), Z(() => {
    W();
  });
  async function W() {
    v.value = true;
    try {
      const a = await ue();
      l.value = S(a), c.value = a, i.value = B;
      for (const e in i.value) for (const t in i.value[e]) l.value[t] & e && (i.value[e][t].V = true);
    } catch (a) {
      console.log("wms基础配置", a);
    } finally {
      v.value = false;
    }
  }
  async function j() {
    try {
      if (!await E.value.validate()) return;
      _.value = true, await fe(l.value), k({ title: "入库基础配置设置成功", type: "success", duration: 2500 }), c.value = S(l.value), de("wmsConfig");
    } catch {
      k({ title: "入库基础配置设置失败", type: "error", duration: 2500 });
    } finally {
      _.value = false;
    }
  }
  function O(a, e, t) {
    e === V.PERCENTAGE.V && l.value.steelDiff > 100 && t(new Error("误差百分比不可超过100")), t();
  }
  return (a, e) => {
    const t = b("common-tip-button"), D = b("common-radio"), f = ae, P = te, q = b("common-radio-button"), w = b("common-input-number"), A = oe, G = se, Q = ee("permission"), $ = ne;
    return d(), p(G, { shadow: "always" }, { header: o(() => [u("div", me, [e[5] || (e[5] = u("span", { class: "card-title" }, "入库基础配置", -1)), T((d(), p(t, { loading: _.value, disabled: R.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: j }, { default: o(() => e[4] || (e[4] = [le(" 保存 ")])), _: 1, __: [4] }, 8, ["loading", "disabled"])), [[Q, r(M).basicInboundEdit]])])]), default: o(() => [T((d(), p(A, { ref_key: "formRef", ref: E, disabled: I.value, model: l.value, rules: z, "label-position": "left", "label-width": "130px" }, { default: o(() => [s(f, { label: "金额显示场景" }, { default: o(() => [s(D, { modelValue: l.value.amountFillWay, "onUpdate:modelValue": e[0] || (e[0] = (n) => l.value.amountFillWay = n), options: r(re).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(f, { label: "入库信息是否可修改配置：", "label-width": "200px" }), (d(true), h(C, null, N(i.value, (n, x) => (d(), p(f, { key: x, label: `【${r(g).VL[x]}】`, "label-width": "70px" }, { default: o(() => [(d(true), h(C, null, N(n, (y, H) => (d(), p(P, { key: H, modelValue: y.V, "onUpdate:modelValue": (J) => y.V = J, label: y.L }, null, 8, ["modelValue", "onUpdate:modelValue", "label"]))), 128))]), _: 2 }, 1032, ["label"]))), 128)), s(f, { class: "form-tip-item", label: "重量允许误差(%)", prop: "steelDiffType", "label-width": "165px" }, { label: o(() => [u("span", null, "单件钢材重量误差(" + U(l.value.steelDiffType === r(V).NUMBER.V ? r(F) : "%") + ")", 1)]), default: o(() => [u("div", pe, [s(q, { modelValue: l.value.steelDiffType, "onUpdate:modelValue": e[1] || (e[1] = (n) => l.value.steelDiffType = n), options: r(V).ENUM, default: "", type: "enum", size: "default", style: { "min-width": "123px" } }, null, 8, ["modelValue", "options"]), s(w, { modelValue: l.value.steelDiff, "onUpdate:modelValue": e[2] || (e[2] = (n) => l.value.steelDiff = n), max: l.value.steelDiffType === r(V).NUMBER.V ? 999999999999 : 100, "controls-position": "right", size: "default", placeholder: "请输入允许的误差值", style: { width: "200px", "margin-left": "10px" }, min: 0 }, null, 8, ["modelValue", "max"])])]), _: 1 }), s(f, null, { default: o(() => [e[6] || (e[6] = u("span", { class: "form-item-tip" }, " 可配置单件钢材的最大误差。【钢材的入库重量】与【钢材的理论重量】的差值（绝对值）超过该误差，办理时将发出预警（可提交入库申请）。 ", -1)), u("span", ce, "固定重量(" + U(r(F)) + ")：误差不可超过 固定重量；", 1), e[7] || (e[7] = u("span", { class: "form-item-tip" }, "百分比(%)：误差不可超过 入库钢材的理论重量*百分比。", -1))]), _: 1, __: [6, 7] }), s(f, { class: "form-tip-item", label: "采购比入库比误差值(%)", prop: "procureMeteDiff", "label-width": "165px" }, { default: o(() => [s(w, { modelValue: l.value.procureMeteDiff, "onUpdate:modelValue": e[3] || (e[3] = (n) => l.value.procureMeteDiff = n), max: 100, "controls-position": "right", size: "default", placeholder: "请输入允许的误差值", style: { width: "200px" }, min: 0 }, null, 8, ["modelValue"])]), _: 1 }), s(f, null, { default: o(() => e[8] || (e[8] = [u("span", { class: "form-item-tip" }, " 可配置采购比入库比误差值。【采购重量】与【入库重量】的差值（绝对值）超过该误差，将不支持入库。 ", -1)])), _: 1, __: [8] })]), _: 1 }, 8, ["disabled", "model", "rules"])), [[$, v.value]])]), _: 1 });
  };
} };
export {
  ye as default
};
