import { inject as W } from "vue";
import { ref as f } from "vue";
import { computed as D } from "vue";
import { watchEffect as K } from "vue";
import { onMounted as Q } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as A } from "vue";
import { createTextVNode as L } from "vue";
import { unref as v } from "vue";
import { createVNode as t } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as M } from "vue";
import { renderList as P } from "vue";
import { vShow as Y } from "vue";
import { ElNotification as x } from "element-plus";
import { ElFormItem as Z } from "element-plus";
import { ElCheckbox as ee } from "element-plus";
import { ElSwitch as ae } from "element-plus";
import { ElForm as le } from "element-plus";
import { ElCard as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { cJ as d, d as ne, gV as se, V as S, aS as C, au as ie, gW as ue } from "../../../../../shared/runtime.js";
import { u as re } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const de = { class: "clearfix" }, ve = { __name: "basic-purchase", setup(fe) {
  const k = W("permission"), R = { [d.STEEL_PLATE.V]: { spec: { L: "规格", V: false }, thickness: { L: "厚度", V: false }, length: { L: "长度", V: false }, width: { L: "宽度", V: false }, quantity: { L: "数量", V: false } }, [d.SECTION_STEEL.V]: { spec: { L: "规格", V: false }, length: { L: "定尺长度", V: false }, quantity: { L: "数量", V: false } }, [d.OTHER_STEEL_MATERIALS.V]: { quantity: { L: "数量", V: false }, mete: { L: "核算量", V: false } }, [d.MATERIAL.V]: { quantity: { L: "数量", V: false }, mete: { L: "核算量", V: false } }, [d.GAS.V]: { quantity: { L: "数量", V: false }, mete: { L: "核算量", V: false } }, [d.OTHER.V]: { quantity: { L: "数量", V: false }, mete: { L: "核算量", V: false } } }, u = f(), p = f({ steelDiff: void 0, steelDiffType: void 0, applyAndProcureMeteDiff: void 0, applyAndProcureMeteDiffState: void 0, applyAndProcureDetailMeteRatio: void 0 }), T = f(), a = f(p.value), V = f(false), y = f(false), I = D(() => ne(a.value, p.value)), U = D(() => V.value || y.value);
  K(() => {
    const l = {};
    for (const e in u.value) for (const s in u.value[e]) l[s] || (l[s] = 0), u.value[e][s].V && (l[s] |= Number(e));
    a.value = { ...a.value, ...l };
  }), Q(() => {
    q();
  });
  async function q() {
    V.value = true;
    try {
      const l = await se();
      l.settlementInventoryAmountChecked = l.settlementInventoryAmount === 1, a.value = S(l), p.value = l, u.value = R;
      for (const e in u.value) for (const s in u.value[e]) a.value[s] & e && (u.value[e][s].V = true);
    } catch (l) {
      console.log("wms基础配置", l);
    } finally {
      V.value = false;
    }
  }
  function B(l) {
    l === false && (a.value.applyAndProcureMeteDiff = p.value.applyAndProcureMeteDiff);
  }
  async function N() {
    var l;
    try {
      y.value = true, a.value.settlementInventoryAmount = (l = a.value) != null && l.settlementInventoryAmountChecked ? 1 : 2, await ue(a.value), x({ title: "采购基础配置设置成功", type: "success", duration: 2500 }), p.value = S(a.value), re("wmsConfig");
    } catch {
      x({ title: "采购基础配置设置失败", type: "error", duration: 2500 });
    } finally {
      y.value = false;
    }
  }
  return (l, e) => {
    const s = _("common-tip-button"), i = Z, E = ee, F = ae, h = _("common-input-number"), z = _("common-radio"), H = le, O = te, j = X("permission"), $ = oe;
    return r(), c(O, { shadow: "always" }, { header: n(() => [m("div", de, [e[7] || (e[7] = m("span", { class: "card-title" }, "采购基础配置", -1)), A((r(), c(s, { disabled: I.value, loading: y.value, "show-tip": "", size: "default", style: { float: "right" }, type: "primary", onClick: N }, { default: n(() => e[6] || (e[6] = [L(" 保存 ")])), _: 1, __: [6] }, 8, ["disabled", "loading"])), [[j, v(k).basicPurchaseEdit]])])]), default: n(() => [A((r(), c(H, { ref_key: "formRef", ref: T, disabled: U.value, model: a.value, "label-position": "left", "label-width": "130px" }, { default: n(() => [t(i, { label: "采购信息是否可修改配置：", "label-width": "200px" }), (r(true), g(M, null, P(u.value, (o, w) => (r(), c(i, { key: w, label: `【${v(d).VL[w]}】`, "label-width": "100px" }, { default: n(() => [(r(true), g(M, null, P(o, (b, G) => (r(), c(E, { key: G, modelValue: b.V, "onUpdate:modelValue": (J) => b.V = J, label: b.L }, null, 8, ["modelValue", "onUpdate:modelValue", "label"]))), 128))]), _: 2 }, 1032, ["label"]))), 128)), t(i, { class: "form-tip-item", label: "申购比采购比误差值(%)", "label-width": "165px", prop: "applyAndProcureMeteDiff" }, { default: n(() => [t(F, { modelValue: a.value.applyAndProcureMeteDiffState, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.applyAndProcureMeteDiffState = o), "active-value": v(C).TRUE.V, "inactive-value": v(C).FALSE.V, style: { "margin-right": "5px" }, onChange: e[1] || (e[1] = (o) => B(a.value.applyAndProcureMeteDiffState, a.value.applyAndProcureMeteDiff)) }, null, 8, ["modelValue", "active-value", "inactive-value"]), A(t(h, { modelValue: a.value.applyAndProcureMeteDiff, "onUpdate:modelValue": e[2] || (e[2] = (o) => a.value.applyAndProcureMeteDiff = o), max: 999999999999, min: 0, "controls-position": "right", placeholder: "请输入允许的误差值", size: "small", style: { width: "200px" } }, null, 8, ["modelValue"]), [[Y, a.value.applyAndProcureMeteDiffState]])]), _: 1 }), t(i, null, { default: n(() => e[8] || (e[8] = [m("span", { class: "form-item-tip" }, [L(" 启用：可配置申购比采购比误差值。【申购重量】与【采购重量】的差值（最大值）超过该误差，将不支持创建采购单。"), m("br"), L(" 关闭：不做限制。 ")], -1)])), _: 1, __: [8] }), t(i, { label: "是否有明细：", "label-width": "120px" }, { default: n(() => [t(z, { modelValue: a.value.boolHaveDetail, "onUpdate:modelValue": e[3] || (e[3] = (o) => a.value.boolHaveDetail = o), options: v(ie).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(i, { label: "是否默认采购物料明细：", "label-width": "180px" }, { default: n(() => e[9] || (e[9] = [m("span", { style: { color: "#e6a23cc2" } }, "当选择否时，采购订单无需填写物料明细", -1)])), _: 1, __: [9] }), t(i, { class: "form-tip-item", label: "申购已采购状态比例配置(%)", "label-width": "200px", prop: "applyAndProcureDetailMeteRatio" }, { default: n(() => [t(h, { modelValue: a.value.applyAndProcureDetailMeteRatio, "onUpdate:modelValue": e[4] || (e[4] = (o) => a.value.applyAndProcureDetailMeteRatio = o), max: 100, min: 0, "controls-position": "right", placeholder: "请输入允许的误差值", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), t(i, null, { default: n(() => e[10] || (e[10] = [m("span", { class: "form-item-tip" }, ' 说明：设置采购百分比，当已采购量大于该比例时即可允许手动将申购单状态改为"已采购"。 ', -1)])), _: 1, __: [10] }), t(i, { label: "采购合同结算前置条件：", "label-width": "180px" }, { default: n(() => [t(E, { modelValue: a.value.settlementInventoryAmountChecked, "onUpdate:modelValue": e[5] || (e[5] = (o) => a.value.settlementInventoryAmountChecked = o), label: "必须有入库金额", size: "large" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["disabled", "model"])), [[$, V.value]])]), _: 1 });
  };
} };
export {
  ve as default
};
