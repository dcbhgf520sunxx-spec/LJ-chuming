import { ref as I } from "vue";
import { watch as ee } from "vue";
import { nextTick as le } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as te } from "vue";
import { openBlock as g } from "vue";
import { createBlock as E } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as ae } from "vue";
import { createElementBlock as q } from "vue";
import { unref as o } from "vue";
import { normalizeClass as M } from "vue";
import { Fragment as ie } from "vue";
import { createCommentVNode as F } from "vue";
import { isRef as oe } from "vue";
import { ElNotification as ne } from "element-plus";
import { ElDivider as se } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElCol as ue } from "element-plus";
import { ElRow as ce } from "element-plus";
import { ElInputNumber as de } from "element-plus";
import { ElInput as pe } from "element-plus";
import { ElForm as me } from "element-plus";
import { c as fe } from "../../../../../modules/receipt-status-4b335dc2.js";
import { _ as ge, t as ye, u as ve, bz as y, bC as _e, bB as c, bs as w } from "../../../../../shared/runtime.js";
const he = { style: { "margin-right": "3px" } }, Te = { style: { "margin-right": "3px" } }, be = { style: { "margin-right": "3px" } }, Ve = { __name: "cancel-form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} }, projectType: { type: Number }, cargoListReceiptTypeEnum: { type: Number, default: void 0 } }, emits: ["success", "update:modelValue"], setup(u, { emit: P }) {
  const { decimalPrecision: v } = ye(), m = u, D = { id: void 0, changeFreight: void 0, priceType: void 0, price: void 0, changeFreightReason: void 0, cancelDeliveryReason: void 0 }, e = I(JSON.parse(JSON.stringify(D))), C = I(), f = I(), J = { changeFreight: { required: true, message: "请选择运费变更类型", trigger: "change" }, priceType: { required: true, message: "请选择计价方式", trigger: "change" }, price: { required: true, message: "请填写价格", trigger: "blur" } }, N = P, { visible: _, handleClose: R } = ve({ emit: N, props: m });
  ee(() => _.value, (d) => {
    d && (m.auditStatus || L());
  }, { deep: true, immediate: true });
  function L(d) {
    f.value && f.value.resetFields(), e.value = JSON.parse(JSON.stringify(D)), e.value.id = m.detailInfo.id, e.value.cargoListReceiptTypeEnum = m.cargoListReceiptTypeEnum, e.value.changeFreight = y.CONTINUE.V, f.value && le(() => {
      f.value.clearValidate();
    }), _e(f, e);
  }
  function j(d) {
    var t, T;
    d === y.CHANGE.V ? (e.value.priceType = (t = m.detailInfo.logisticsDTO) == null ? void 0 : t.priceType, e.value.price = (T = m.detailInfo.logisticsDTO) == null ? void 0 : T.price, h()) : (e.value.priceType = void 0, e.value.price = void 0, h());
  }
  function h() {
    C.value = e.value.priceType === c.WEIGHT.V ? m.detailInfo.logisticsDTO.actualWeight * e.value.price / 1e3 : void 0;
  }
  async function A() {
    try {
      if (!await f.value.validate()) return;
      await fe(e.value), ne({ title: "取消送货成功", type: "success" }), N("success"), R();
    } catch (d) {
      console.log("取消送货失败", d);
    }
  }
  return (d, t) => {
    const T = V("common-button"), O = se, s = re, b = ue, k = ce, K = V("common-radio"), Q = V("common-radio-button"), X = de, U = pe, Y = me, Z = V("common-dialog"), $ = te("empty-text");
    return g(), E(Z, { "append-to-body": "", modelValue: o(_), "onUpdate:modelValue": t[5] || (t[5] = (l) => oe(_) ? _.value = l : null), top: "10vh", width: "600px", "before-close": o(R), title: "取消送货", center: false, "close-on-click-modal": false }, { titleRight: i(() => [a(T, { type: "primary", size: "small", onClick: A }, { default: i(() => t[6] || (t[6] = [x("提交")])), _: 1, __: [6] })]), default: i(() => [a(Y, { ref_key: "formRef", ref: f, model: e.value, rules: J, size: "small", "label-width": "100px" }, { default: i(() => [a(O, null, { default: i(() => t[7] || (t[7] = [r("span", { class: "title" }, "运费信息", -1)])), _: 1, __: [7] }), a(k, null, { default: i(() => [a(b, { span: 10 }, { default: i(() => [a(s, { label: "车型" }, { default: i(() => {
      var l, n;
      return [r("span", null, p((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.carModel), 1)];
    }), _: 1 })]), _: 1 }), a(b, { span: 10 }, { default: i(() => [a(s, { label: "计价方式" }, { default: i(() => {
      var l, n;
      return [ae((g(), q("span", null, [x(p(o(c).VL[(n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.priceType]), 1)])), [[$]])];
    }), _: 1 })]), _: 1 })]), _: 1 }), a(k, null, { default: i(() => [a(b, { span: 10 }, { default: i(() => [a(s, { label: "装载重量(t)" }, { default: i(() => {
      var l, n;
      return [r("span", null, p((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) != null && n.actualWeight ? u.detailInfo.logisticsDTO.actualWeight / 1e3 : "-"), 1)];
    }), _: 1 })]), _: 1 }), a(b, { span: 10 }, { default: i(() => [a(s, { label: "运输单价" }, { default: i(() => {
      var l, n, S, W, z, B, G, H;
      return [r("span", he, p(o(w)((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.price, o(v).shipment)), 1), r("span", { class: M(((W = (S = u.detailInfo) == null ? void 0 : S.logisticsDTO) == null ? void 0 : W.priceType) === o(c).WEIGHT.V ? "blue" : "orange") }, p((B = (z = u.detailInfo) == null ? void 0 : z.logisticsDTO) != null && B.priceType ? o(c).V[(H = (G = u.detailInfo) == null ? void 0 : G.logisticsDTO) == null ? void 0 : H.priceType].unit : ""), 3)];
    }), _: 1 })]), _: 1 })]), _: 1 }), a(s, { label: "运输费" }, { default: i(() => {
      var l, n;
      return [r("span", null, [r("span", Te, p(o(w)((n = (l = u.detailInfo) == null ? void 0 : l.logisticsDTO) == null ? void 0 : n.totalPrice, o(v).shipment)), 1), t[8] || (t[8] = x("元"))])];
    }), _: 1 }), a(O, null, { default: i(() => t[9] || (t[9] = [r("span", { class: "title" }, "运费变更", -1)])), _: 1, __: [9] }), a(s, { label: "运费变更", prop: "changeFreight" }, { default: i(() => [a(K, { modelValue: e.value.changeFreight, "onUpdate:modelValue": t[0] || (t[0] = (l) => e.value.changeFreight = l), options: o(y).ENUM, type: "enum", onChange: j }, null, 8, ["modelValue", "options"])]), _: 1 }), e.value.changeFreight === o(y).CHANGE.V ? (g(), q(ie, { key: 0 }, [a(s, { label: "计价方式", prop: "priceType" }, { default: i(() => [a(Q, { class: "filter-item", modelValue: e.value.priceType, "onUpdate:modelValue": t[1] || (t[1] = (l) => e.value.priceType = l), options: o(c).ENUM, type: "enum", size: "small", onChange: h }, null, 8, ["modelValue", "options"])]), _: 1 }), a(s, { label: e.value.priceType === o(c).WEIGHT.V ? "运输单价" : "运输费", prop: "price" }, { default: i(() => [a(X, { modelValue: e.value.price, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.price = l), max: 999999999999, precision: o(v).shipment, step: 100, controls: false, style: { width: "150px", "margin-right": "3px" }, placeholder: "请填写", autocomplete: "off", onChange: h }, null, 8, ["modelValue", "precision"]), r("span", { class: M(e.value.priceType === o(c).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, p(e.value.priceType ? o(c).V[e.value.priceType].unit : ""), 3)]), _: 1 }, 8, ["label"]), e.value.priceType === o(c).WEIGHT.V ? (g(), E(s, { key: 0, label: "运输费" }, { default: i(() => [r("span", null, [r("span", be, p(o(w)(C.value, o(v).shipment)), 1), t[10] || (t[10] = x("元"))])]), _: 1 })) : F("", true)], 64)) : F("", true), e.value.changeFreight && e.value.changeFreight !== o(y).CONTINUE.V ? (g(), E(s, { key: 1, label: "变更原因", prop: "changeFreightReason" }, { default: i(() => [a(U, { modelValue: e.value.changeFreightReason, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.changeFreightReason = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "运费变更原因", style: { width: "280px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })) : F("", true), a(s, { label: "" }, { default: i(() => [a(U, { modelValue: e.value.cancelDeliveryReason, "onUpdate:modelValue": t[4] || (t[4] = (l) => e.value.cancelDeliveryReason = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 8 }, placeholder: "取消送货原因", style: { width: "280px" }, maxlength: 500, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Fe = ge(Ve, [["__scopeId", "data-v-e75e063f"]]);
export {
  Fe as default
};
