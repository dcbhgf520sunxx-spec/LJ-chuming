import { inject as te } from "vue";
import { ref as r } from "vue";
import { computed as N } from "vue";
import { reactive as oe } from "vue";
import { watchEffect as ne } from "vue";
import { onMounted as ie } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as p } from "vue";
import { createBlock as V } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as x } from "vue";
import { createTextVNode as S } from "vue";
import { unref as i } from "vue";
import { createVNode as a } from "vue";
import { createElementBlock as C } from "vue";
import { Fragment as L } from "vue";
import { renderList as h } from "vue";
import { toDisplayString as I } from "vue";
import { vShow as se } from "vue";
import { ElNotification as F } from "element-plus";
import { ElFormItem as de } from "element-plus";
import { ElCheckbox as fe } from "element-plus";
import { ElSwitch as me } from "element-plus";
import { ElForm as pe } from "element-plus";
import { ElCard as re } from "element-plus";
import { vLoading as ve } from "element-plus";
import { bl as U, gN as E, gO as v, gP as k, d as be, b as Ve, gQ as ce, V as z, gR as _, gS as ye, gT as B, aS as R, gU as ge } from "../../../../../shared/runtime.js";
import { u as Ee } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const _e = { class: "clearfix" }, we = { class: "flex-r" }, xe = { class: "form-item-tip" }, Te = { __name: "basic-inbound-v2", setup(Se) {
  const W = te("permission"), O = { [U.STEEL_PLATE.V]: { spec: { L: "规格", V: false }, thickness: { L: "厚度", V: false }, length: { L: "长度", V: false }, width: { L: "宽度", V: false } }, [U.SECTION_STEEL.V]: { spec: { L: "规格", V: false }, length: { L: "定尺长度", V: false } } }, m = r(), b = r({ amountFillWay: void 0, steelDiff: void 0, steelDiffType: void 0, procureMeteDiff: void 0, procureMeteDiffState: void 0, saveInboundState: E.UNSHOW.V, passedInboundState: E.UNSHOW.V, freightShowScene: v.INVENTORY_SUBMISSION.V, steelWeightCalculationType: k.TOTAL.V }), D = r(), l = r(b.value), c = r(false), y = r(false), P = N(() => be(l.value, b.value)), A = N(() => c.value || y.value), j = oe({ steelDiffType: [{ validator: G }] });
  ne(() => {
    const u = {};
    for (const e in m.value) for (const s in m.value[e]) Ve(u[s]) && (u[s] = 0), m.value[e][s].V && (u[s] |= Number(e));
    l.value = { ...l.value, ...u };
  }), ie(() => {
    H();
  });
  function q(u) {
    u === false && (l.value.procureMeteDiff = b.value.procureMeteDiff);
  }
  async function H() {
    c.value = true;
    try {
      const u = await ce();
      l.value = z(u), b.value = u, m.value = O;
      for (const e in m.value) for (const s in m.value[e]) l.value[s] & e && (m.value[e][s].V = true);
    } catch (u) {
      console.log("wms基础配置", u);
    } finally {
      c.value = false;
    }
  }
  async function $() {
    try {
      if (!await D.value.validate()) return;
      y.value = true, await ge(l.value), F({ title: "入库基础配置设置成功", type: "success", duration: 2500 }), b.value = z(l.value), Ee("wmsConfig");
    } catch {
      F({ title: "入库基础配置设置失败", type: "error", duration: 2500 });
    } finally {
      y.value = false;
    }
  }
  function G(u, e, s) {
    e === _.PERCENTAGE.V && l.value.steelDiff > 100 && s(new Error("误差百分比不可超过100")), s();
  }
  return (u, e) => {
    const s = g("common-tip-button"), f = g("common-radio"), n = de, Q = fe, Y = g("common-radio-button"), M = g("common-input-number"), J = me, K = pe, X = re, Z = ue("permission"), ee = ve;
    return p(), V(X, { shadow: "always" }, { header: o(() => [d("div", _e, [e[15] || (e[15] = d("span", { class: "card-title" }, "入库基础配置", -1)), x((p(), V(s, { disabled: P.value, loading: y.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: $ }, { default: o(() => e[14] || (e[14] = [S(" 保存 ")])), _: 1, __: [14] }, 8, ["disabled", "loading"])), [[Z, i(W).basicInboundEdit]])])]), default: o(() => [x((p(), V(K, { ref_key: "formRef", ref: D, disabled: A.value, model: l.value, rules: j, "label-position": "left", "label-width": "130px" }, { default: o(() => [a(n, { label: "无明细采购入库时金额显示场景：", "label-width": "240px" }, { default: o(() => [a(f, { modelValue: l.value.amountFillWay, "onUpdate:modelValue": e[0] || (e[0] = (t) => l.value.amountFillWay = t), options: i(ye).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "有明细采购入库时金额显示场景：", "label-width": "240px" }), a(n, { label: "入库办理时：", "label-width": "100px", style: { "margin-left": "10px" } }, { default: o(() => [a(f, { modelValue: l.value.saveInboundState, "onUpdate:modelValue": e[1] || (e[1] = (t) => l.value.saveInboundState = t), options: i(E).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "入库审核时：", "label-width": "100px", style: { "margin-left": "10px" } }, { default: o(() => [a(f, { modelValue: l.value.passedInboundState, "onUpdate:modelValue": e[2] || (e[2] = (t) => l.value.passedInboundState = t), options: i(E).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, null, { default: o(() => e[16] || (e[16] = [d("span", { class: "form-item-tip", style: { "margin-top": "-20px", "margin-left": "-20px" } }, " 特殊情况：当“入库办理时”“入库审核时”都为“不显示”，则默认为“入库办理时”显示金额。 ", -1)])), _: 1, __: [16] }), a(n, { label: "入库信息是否可修改配置：", "label-width": "200px" }), (p(true), C(L, null, h(m.value, (t, T) => (p(), V(n, { key: T, label: `【${i(U).VL[T]}】`, "label-width": "70px" }, { default: o(() => [(p(true), C(L, null, h(t, (w, le) => (p(), V(Q, { key: le, modelValue: w.V, "onUpdate:modelValue": (ae) => w.V = ae, label: w.L }, null, 8, ["modelValue", "onUpdate:modelValue", "label"]))), 128))]), _: 2 }, 1032, ["label"]))), 128)), a(n, { class: "form-tip-item", label: "重量允许误差(%)", "label-width": "165px", prop: "steelDiffType" }, { label: o(() => [d("span", null, "单件钢材重量误差(" + I(l.value.steelDiffType === i(_).NUMBER.V ? i(B) : "%") + ")", 1)]), default: o(() => [d("div", we, [a(Y, { modelValue: l.value.steelDiffType, "onUpdate:modelValue": e[3] || (e[3] = (t) => l.value.steelDiffType = t), options: i(_).ENUM, default: "", size: "default", style: { "min-width": "123px" }, type: "enum" }, null, 8, ["modelValue", "options"]), a(M, { modelValue: l.value.steelDiff, "onUpdate:modelValue": e[4] || (e[4] = (t) => l.value.steelDiff = t), max: l.value.steelDiffType === i(_).NUMBER.V ? 999999999999 : 100, min: 0, "controls-position": "right", placeholder: "请输入允许的误差值", size: "default", style: { width: "200px", "margin-left": "10px" } }, null, 8, ["modelValue", "max"])])]), _: 1 }), a(n, null, { default: o(() => [e[17] || (e[17] = d("span", { class: "form-item-tip" }, " 可配置单件钢材的最大误差。【钢材的入库重量】与【钢材的理论重量】的差值（绝对值）超过该误差，办理时将发出预警（可提交入库申请）。 ", -1)), d("span", xe, "固定重量(" + I(i(B)) + ")：误差不可超过 固定重量；", 1), e[18] || (e[18] = d("span", { class: "form-item-tip" }, "百分比(%)：误差不可超过 入库钢材的理论重量*百分比。", -1))]), _: 1, __: [17, 18] }), a(n, { class: "form-tip-item", label: "采购比入库比误差值(%)", "label-width": "165px", prop: "procureMeteDiff" }, { default: o(() => [a(J, { modelValue: l.value.procureMeteDiffState, "onUpdate:modelValue": e[5] || (e[5] = (t) => l.value.procureMeteDiffState = t), "active-value": i(R).TRUE.V, "inactive-value": i(R).FALSE.V, style: { "margin-right": "5px" }, onChange: e[6] || (e[6] = (t) => q(l.value.procureMeteDiffState, l.value.procureMeteDiff)) }, null, 8, ["modelValue", "active-value", "inactive-value"]), x(a(M, { modelValue: l.value.procureMeteDiff, "onUpdate:modelValue": e[7] || (e[7] = (t) => l.value.procureMeteDiff = t), max: 100, min: 0, "controls-position": "right", placeholder: "请输入允许的误差值", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), [[se, l.value.procureMeteDiffState]])]), _: 1 }), a(n, null, { default: o(() => e[19] || (e[19] = [d("span", { class: "form-item-tip" }, [S(" 启用：可配置采购比入库比误差值。【采购重量】与【入库重量】的差值（绝对值）超过该误差，将不支持入库。"), d("br"), S(" 关闭：不做限制。 ")], -1)])), _: 1, __: [19] }), a(n, { label: "运费金额显示场景：", "label-width": "140px" }), a(n, { label: "运费：", "label-width": "140px" }, { default: o(() => [a(f, { modelValue: l.value.money, "onUpdate:modelValue": e[8] || (e[8] = (t) => l.value.money = t), options: i(v).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "运输重量：", "label-width": "140px" }, { default: o(() => [a(f, { modelValue: l.value.weight, "onUpdate:modelValue": e[9] || (e[9] = (t) => l.value.weight = t), options: i(v).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "装车费：", "label-width": "140px" }, { default: o(() => [a(f, { modelValue: l.value.loadingFee, "onUpdate:modelValue": e[10] || (e[10] = (t) => l.value.loadingFee = t), options: i(v).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "发票及税率：", "label-width": "140px" }, { default: o(() => [a(f, { modelValue: l.value.invoiceTax, "onUpdate:modelValue": e[11] || (e[11] = (t) => l.value.invoiceTax = t), options: i(v).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "物流单位：", "label-width": "140px" }, { default: o(() => [a(f, { modelValue: l.value.logisticsUnit, "onUpdate:modelValue": e[12] || (e[12] = (t) => l.value.logisticsUnit = t), options: i(v).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { label: "钢材重量精度保留方式：", "label-width": "180px" }, { default: o(() => [a(f, { modelValue: l.value.steelWeightCalculationType, "onUpdate:modelValue": e[13] || (e[13] = (t) => l.value.steelWeightCalculationType = t), options: i(k).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(n, { "label-width": "0" }, { default: o(() => e[20] || (e[20] = [d("div", { class: "form-item-tip" }, "单重模式：总重=单重（长*宽*厚*密度 按配置的钢材小数精度四舍五入）*数量", -1), d("div", { class: "form-item-tip" }, "总重模式：总重=（单重（长*宽*厚*密度 最大保留10位小数）*数量）再按配置的钢材小数精度四舍五入 ", -1)])), _: 1, __: [20] })]), _: 1 }, 8, ["disabled", "model", "rules"])), [[ee, c.value]])]), _: 1 });
  };
} };
export {
  Te as default
};
