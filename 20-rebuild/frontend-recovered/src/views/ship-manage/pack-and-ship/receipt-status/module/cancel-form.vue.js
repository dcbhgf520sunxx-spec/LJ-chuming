import { ref as I } from "vue";
import { watch as ee } from "vue";
import { nextTick as le } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as te } from "vue";
import { openBlock as g } from "vue";
import { createBlock as E } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as ae } from "vue";
import { createElementBlock as j } from "vue";
import { unref as i } from "vue";
import { normalizeClass as q } from "vue";
import { Fragment as oe } from "vue";
import { createCommentVNode as F } from "vue";
import { isRef as ie } from "vue";
import { ElNotification as ne } from "element-plus";
import { ElDivider as se } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElCol as ue } from "element-plus";
import { ElRow as ce } from "element-plus";
import { ElInputNumber as de } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElForm as me } from "element-plus";
import { b as fe, c as ge } from "../../../../../modules/receipt-status-4b335dc2.js";
import { _ as ye, t as ve, u as _e, bz as y, bC as he, bB as c, bs as w, K as Te } from "../../../../../shared/runtime.js";
const be = { style: { "margin-right": "3px" } }, Ve = { style: { "margin-right": "3px" } }, xe = { style: { "margin-right": "3px" } }, Ie = { __name: "cancel-form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, projectType: { type: Number } }, emits: ["success", "update:modelValue"], setup(u, { emit: M }) {
  const { decimalPrecision: v } = ve(), m = u, D = { id: void 0, changeFreight: void 0, priceType: void 0, price: void 0, changeFreightReason: void 0, cancelDeliveryReason: void 0 }, e = I(JSON.parse(JSON.stringify(D))), C = I(), f = I(), P = { changeFreight: { required: true, message: "请选择运费变更类型", trigger: "change" }, priceType: { required: true, message: "请选择计价方式", trigger: "change" }, price: { required: true, message: "请填写价格", trigger: "blur" } }, N = M, { visible: _, handleClose: O } = _e({ emit: N, props: m });
  ee(() => _.value, (d) => {
    d && (m.auditStatus || J());
  }, { deep: true, immediate: true });
  function J(d) {
    f.value && f.value.resetFields(), e.value = JSON.parse(JSON.stringify(D)), e.value.id = m.detailInfo.id, e.value.changeFreight = y.CONTINUE.V, f.value && le(() => {
      f.value.clearValidate();
    }), he(f, e);
  }
  function A(d) {
    var t, T;
    d === y.CHANGE.V ? (e.value.priceType = (t = m.detailInfo.logisticsDTO) == null ? void 0 : t.priceType, e.value.price = (T = m.detailInfo.logisticsDTO) == null ? void 0 : T.price, h()) : (e.value.priceType = void 0, e.value.price = void 0, h());
  }
  function h() {
    C.value = e.value.priceType === c.WEIGHT.V ? m.detailInfo.logisticsDTO.actualWeight * e.value.price / 1e3 : void 0;
  }
  async function K() {
    try {
      if (!await f.value.validate()) return;
      m.projectType === Te.BRIDGE.V ? await fe(e.value) : await ge(e.value), ne({ title: "取消送货成功", type: "success" }), N("success"), O();
    } catch (d) {
      console.log("取消送货失败", d);
    }
  }
  return (d, t) => {
    const T = V("common-button"), R = se, s = re, b = ue, k = ce, L = V("common-radio"), Q = V("common-radio-button"), X = de, U = pe, Y = me, Z = V("common-dialog"), $ = te("empty-text");
    return g(), E(Z, { "append-to-body": "", modelValue: i(_), "onUpdate:modelValue": t[5] || (t[5] = (l) => ie(_) ? _.value = l : null), top: "10vh", width: "600px", "before-close": i(O), title: "取消送货", center: false, "close-on-click-modal": false }, { titleRight: o(() => [a(T, { type: "primary", size: "default", onClick: K }, { default: o(() => t[6] || (t[6] = [x("提交")])), _: 1, __: [6] })]), default: o(() => [a(Y, { ref_key: "formRef", ref: f, model: e.value, rules: P, size: "default", "label-width": "100px" }, { default: o(() => [a(R, null, { default: o(() => t[7] || (t[7] = [r("span", { class: "title" }, "运费信息", -1)])), _: 1, __: [7] }), a(k, null, { default: o(() => [a(b, { span: 10 }, { default: o(() => [a(s, { label: "车型" }, { default: o(() => {
      var l, n;
      return [r("span", null, p((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.carModel), 1)];
    }), _: 1 })]), _: 1 }), a(b, { span: 10 }, { default: o(() => [a(s, { label: "计价方式" }, { default: o(() => {
      var l, n;
      return [ae((g(), j("span", null, [x(p(i(c).VL[(n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.priceType]), 1)])), [[$]])];
    }), _: 1 })]), _: 1 })]), _: 1 }), a(k, null, { default: o(() => [a(b, { span: 10 }, { default: o(() => [a(s, { label: "装载重量(t)" }, { default: o(() => {
      var l, n;
      return [r("span", null, p((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) != null && n.actualWeight ? u.detailInfo.logisticsDTO.actualWeight / 1e3 : "-"), 1)];
    }), _: 1 })]), _: 1 }), a(b, { span: 10 }, { default: o(() => [a(s, { label: "运输单价" }, { default: o(() => {
      var l, n, S, W, z, B, G, H;
      return [r("span", be, p(i(w)((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.price, i(v).shipment)), 1), r("span", { class: q(((W = (S = u.detailInfo) == null ? void 0 : S.logisticsDTO) == null ? void 0 : W.priceType) === i(c).WEIGHT.V ? "blue" : "orange") }, p((B = (z = u.detailInfo) == null ? void 0 : z.logisticsDTO) != null && B.priceType ? i(c).V[(H = (G = u.detailInfo) == null ? void 0 : G.logisticsDTO) == null ? void 0 : H.priceType].unit : ""), 3)];
    }), _: 1 })]), _: 1 })]), _: 1 }), a(s, { label: "运输费" }, { default: o(() => {
      var l, n;
      return [r("span", null, [r("span", Ve, p(i(w)((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.totalPrice, i(v).shipment)), 1), t[8] || (t[8] = x("元"))])];
    }), _: 1 }), a(R, null, { default: o(() => t[9] || (t[9] = [r("span", { class: "title" }, "运费变更", -1)])), _: 1, __: [9] }), a(s, { label: "运费变更", prop: "changeFreight" }, { default: o(() => [a(L, { modelValue: e.value.changeFreight, "onUpdate:modelValue": t[0] || (t[0] = (l) => e.value.changeFreight = l), options: i(y).ENUM, type: "enum", onChange: A }, null, 8, ["modelValue", "options"])]), _: 1 }), e.value.changeFreight === i(y).CHANGE.V ? (g(), j(oe, { key: 0 }, [a(s, { label: "计价方式", prop: "priceType" }, { default: o(() => [a(Q, { class: "filter-item", modelValue: e.value.priceType, "onUpdate:modelValue": t[1] || (t[1] = (l) => e.value.priceType = l), options: i(c).ENUM, type: "enum", size: "default", onChange: h }, null, 8, ["modelValue", "options"])]), _: 1 }), a(s, { label: e.value.priceType === i(c).WEIGHT.V ? "运输单价" : "运输费", prop: "price" }, { default: o(() => [a(X, { modelValue: e.value.price, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.price = l), max: 999999999999, precision: i(v).shipment, step: 100, controls: false, style: { width: "150px", "margin-right": "3px" }, placeholder: "请填写", autocomplete: "off", onChange: h }, null, 8, ["modelValue", "precision"]), r("span", { class: q(e.value.priceType === i(c).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, p(e.value.priceType ? i(c).V[e.value.priceType].unit : ""), 3)]), _: 1 }, 8, ["label"]), e.value.priceType === i(c).WEIGHT.V ? (g(), E(s, { key: 0, label: "运输费" }, { default: o(() => [r("span", null, [r("span", xe, p(i(w)(C.value, i(v).shipment)), 1), t[10] || (t[10] = x("元"))])]), _: 1 })) : F("", true)], 64)) : F("", true), e.value.changeFreight && e.value.changeFreight !== i(y).CONTINUE.V ? (g(), E(s, { key: 1, label: "变更原因", prop: "changeFreightReason" }, { default: o(() => [a(U, { modelValue: e.value.changeFreightReason, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.changeFreightReason = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "运费变更原因", style: { width: "280px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })) : F("", true), a(s, { label: "" }, { default: o(() => [a(U, { modelValue: e.value.cancelDeliveryReason, "onUpdate:modelValue": t[4] || (t[4] = (l) => e.value.cancelDeliveryReason = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 8 }, placeholder: "取消送货原因", style: { width: "280px" }, maxlength: 500, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, De = ye(Ie, [["__scopeId", "data-v-c8cb381e"]]);
export {
  De as default
};
