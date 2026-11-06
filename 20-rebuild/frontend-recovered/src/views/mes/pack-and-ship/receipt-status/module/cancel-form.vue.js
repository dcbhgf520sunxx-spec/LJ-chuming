import { ref as F } from "vue";
import { watch as te } from "vue";
import { nextTick as le } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as ae } from "vue";
import { openBlock as g } from "vue";
import { createBlock as w } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as oe } from "vue";
import { createElementBlock as P } from "vue";
import { unref as i } from "vue";
import { normalizeClass as q } from "vue";
import { Fragment as ne } from "vue";
import { createCommentVNode as E } from "vue";
import { isRef as ie } from "vue";
import { ElNotification as se } from "element-plus";
import { ElDivider as re } from "element-plus";
import { ElFormItem as ue } from "element-plus";
import { ElCol as de } from "element-plus";
import { ElRow as ce } from "element-plus";
import { ElInputNumber as pe } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElForm as fe } from "element-plus";
import { l as _, _ as ge, t as ye, u as _e, bz as y, bC as ve, bB as d, bs as D } from "../../../../../shared/runtime.js";
function he(n) {
  return _({ module: "mes", url: "cargo/receipt", method: "get", params: n });
}
function Te({ id: n }) {
  return _({ url: `api/mes/receipt/status/${n}/export`, method: "get", responseType: "blob" });
}
function Oe(n) {
  return _({ module: "mes", url: `cargo/receipt/${n}`, method: "get" });
}
function be(n) {
  return _({ module: "mes", url: "cargo/cancel", method: "put", data: n });
}
function Ce(n) {
  return _({ module: "mes", url: `cargo/sign/${n}`, method: "put" });
}
const Ne = { get: he, download: Te };
const Ve = { style: { "margin-right": "3px" } }, xe = { style: { "margin-right": "3px" } }, Ie = { style: { "margin-right": "3px" } }, Fe = { __name: "cancel-form", props: { modelValue: { type: Boolean, require: true }, showType: { type: String, default: void 0 }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(n, { emit: j }) {
  const { decimalPrecision: v } = ye(), f = n, O = { id: void 0, changeFreight: void 0, priceType: void 0, price: void 0, changeFreightReason: void 0, cancelDeliveryReason: void 0 }, e = F(JSON.parse(JSON.stringify(O))), C = F(), m = F(), A = { changeFreight: { required: true, message: "请选择运费变更类型", trigger: "change" }, priceType: { required: true, message: "请选择计价方式", trigger: "change" }, price: { required: true, message: "请填写价格", trigger: "blur" } }, N = j, { visible: h, handleClose: R } = _e({ emit: N, props: f });
  te(() => h.value, (c) => {
    c && (f.auditStatus || J());
  }, { deep: true, immediate: true });
  function J(c) {
    m.value && m.value.resetFields(), e.value = JSON.parse(JSON.stringify(O)), e.value.id = f.detailInfo.id, e.value.changeFreight = y.CONTINUE.V, m.value && le(() => {
      m.value.clearValidate();
    }), ve(m, e);
  }
  function $(c) {
    var l, b;
    c === y.CHANGE.V ? (e.value.priceType = (l = f.detailInfo.logisticsDTO) == null ? void 0 : l.priceType, e.value.price = (b = f.detailInfo.logisticsDTO) == null ? void 0 : b.price, T()) : (e.value.priceType = void 0, e.value.price = void 0, T());
  }
  function T() {
    C.value = e.value.priceType === d.WEIGHT.V ? f.detailInfo.logisticsDTO.actualWeight * e.value.price / 1e3 : void 0;
  }
  async function L() {
    try {
      if (!await m.value.validate()) return;
      await be(e.value), se({ title: "取消送货成功", type: "success" }), N("success"), R();
    } catch (c) {
      console.log("取消送货失败", c);
    }
  }
  return (c, l) => {
    const b = x("common-button"), S = re, r = ue, V = de, k = ce, K = x("common-radio"), Q = x("common-radio-button"), X = pe, U = me, Y = fe, Z = x("common-dialog"), ee = ae("empty-text");
    return g(), w(Z, { "append-to-body": "", modelValue: i(h), "onUpdate:modelValue": l[5] || (l[5] = (t) => ie(h) ? h.value = t : null), top: "10vh", width: "600px", "before-close": i(R), title: "取消送货", center: false, "close-on-click-modal": false }, { titleRight: o(() => [a(b, { type: "primary", size: "default", onClick: L }, { default: o(() => l[6] || (l[6] = [I("提交")])), _: 1, __: [6] })]), default: o(() => [a(Y, { ref_key: "formRef", ref: m, model: e.value, rules: A, size: "default", "label-width": "100px" }, { default: o(() => [a(S, null, { default: o(() => l[7] || (l[7] = [u("span", { class: "title" }, "运费信息", -1)])), _: 1, __: [7] }), a(k, null, { default: o(() => [a(V, { span: 10 }, { default: o(() => [a(r, { label: "车型" }, { default: o(() => {
      var t, s;
      return [u("span", null, p((s = (t = n.detailInfo) == null ? void 0 : t.logisticsDTO) == null ? void 0 : s.carModel), 1)];
    }), _: 1 })]), _: 1 }), a(V, { span: 10 }, { default: o(() => [a(r, { label: "计价方式" }, { default: o(() => {
      var t, s;
      return [oe((g(), P("span", null, [I(p(i(d).VL[(s = (t = n.detailInfo) == null ? void 0 : t.logisticsDTO) == null ? void 0 : s.priceType]), 1)])), [[ee]])];
    }), _: 1 })]), _: 1 })]), _: 1 }), a(k, null, { default: o(() => [a(V, { span: 10 }, { default: o(() => [a(r, { label: "装载重量(t)" }, { default: o(() => {
      var t, s;
      return [u("span", null, p((s = (t = n.detailInfo) == null ? void 0 : t.logisticsDTO) != null && s.actualWeight ? n.detailInfo.logisticsDTO.actualWeight / 1e3 : "-"), 1)];
    }), _: 1 })]), _: 1 }), a(V, { span: 10 }, { default: o(() => [a(r, { label: "运输单价" }, { default: o(() => {
      var t, s, z, W, B, G, H, M;
      return [u("span", Ve, p(i(D)((s = (t = n.detailInfo) == null ? void 0 : t.logisticsDTO) == null ? void 0 : s.price, i(v).mes)), 1), u("span", { class: q(((W = (z = n.detailInfo) == null ? void 0 : z.logisticsDTO) == null ? void 0 : W.priceType) === i(d).WEIGHT.V ? "blue" : "orange") }, p((G = (B = n.detailInfo) == null ? void 0 : B.logisticsDTO) != null && G.priceType ? i(d).V[(M = (H = n.detailInfo) == null ? void 0 : H.logisticsDTO) == null ? void 0 : M.priceType].unit : ""), 3)];
    }), _: 1 })]), _: 1 })]), _: 1 }), a(r, { label: "运输费" }, { default: o(() => {
      var t, s;
      return [u("span", null, [u("span", xe, p(i(D)((s = (t = n.detailInfo) == null ? void 0 : t.logisticsDTO) == null ? void 0 : s.totalPrice, i(v).mes)), 1), l[8] || (l[8] = I("元"))])];
    }), _: 1 }), a(S, null, { default: o(() => l[9] || (l[9] = [u("span", { class: "title" }, "运费变更", -1)])), _: 1, __: [9] }), a(r, { label: "运费变更", prop: "changeFreight" }, { default: o(() => [a(K, { modelValue: e.value.changeFreight, "onUpdate:modelValue": l[0] || (l[0] = (t) => e.value.changeFreight = t), options: i(y).ENUM, type: "enum", onChange: $ }, null, 8, ["modelValue", "options"])]), _: 1 }), e.value.changeFreight === i(y).CHANGE.V ? (g(), P(ne, { key: 0 }, [a(r, { label: "计价方式", prop: "priceType" }, { default: o(() => [a(Q, { class: "filter-item", modelValue: e.value.priceType, "onUpdate:modelValue": l[1] || (l[1] = (t) => e.value.priceType = t), options: i(d).ENUM, type: "enum", size: "default", onChange: T }, null, 8, ["modelValue", "options"])]), _: 1 }), a(r, { label: e.value.priceType === i(d).WEIGHT.V ? "运输单价" : "运输费", prop: "price" }, { default: o(() => [a(X, { modelValue: e.value.price, "onUpdate:modelValue": l[2] || (l[2] = (t) => e.value.price = t), max: 999999999999, precision: i(v).mes, step: 100, controls: false, style: { width: "150px", "margin-right": "3px" }, placeholder: "请填写", autocomplete: "off", onChange: T }, null, 8, ["modelValue", "precision"]), u("span", { class: q(e.value.priceType === i(d).WEIGHT.V ? "blue" : "orange"), style: { "margin-left": "3px" } }, p(e.value.priceType ? i(d).V[e.value.priceType].unit : ""), 3)]), _: 1 }, 8, ["label"]), e.value.priceType === i(d).WEIGHT.V ? (g(), w(r, { key: 0, label: "运输费" }, { default: o(() => [u("span", null, [u("span", Ie, p(i(D)(C.value, i(v).mes)), 1), l[10] || (l[10] = I("元"))])]), _: 1 })) : E("", true)], 64)) : E("", true), e.value.changeFreight && e.value.changeFreight !== i(y).CONTINUE.V ? (g(), w(r, { key: 1, label: "变更原因", prop: "changeFreightReason" }, { default: o(() => [a(U, { modelValue: e.value.changeFreightReason, "onUpdate:modelValue": l[3] || (l[3] = (t) => e.value.changeFreightReason = t), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "运费变更原因", style: { width: "280px" }, maxlength: 200, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })) : E("", true), a(r, { label: "" }, { default: o(() => [a(U, { modelValue: e.value.cancelDeliveryReason, "onUpdate:modelValue": l[4] || (l[4] = (t) => e.value.cancelDeliveryReason = t), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 8 }, placeholder: "取消送货原因", style: { width: "280px" }, maxlength: 500, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, we = ge(Fe, [["__scopeId", "data-v-38720ee6"]]), Re = Object.freeze(Object.defineProperty({ __proto__: null, default: we }, Symbol.toStringTag, { value: "Module" }));
export {
  we as a,
  Ce as b,
  Ne as c,
  Oe as d,
  Re as e
};
