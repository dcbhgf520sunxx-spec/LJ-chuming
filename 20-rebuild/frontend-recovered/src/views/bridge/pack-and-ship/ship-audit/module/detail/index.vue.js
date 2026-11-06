import { ref as h } from "vue";
import { computed as y } from "vue";
import { watch as z } from "vue";
import { resolveComponent as J } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { renderSlot as N } from "vue";
import { createElementVNode as B } from "vue";
import { withDirectives as D } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as n } from "vue";
import { unref as a } from "vue";
import { createElementBlock as K } from "vue";
import { Fragment as Z } from "vue";
import { renderList as ee } from "vue";
import { createCommentVNode as A } from "vue";
import { ElRadioGroup as ae } from "element-plus";
import { resolveDynamicComponent as te } from "vue";
import { isRef as le } from "vue";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElImage as ie } from "element-plus";
import { ElDescriptions as se } from "element-plus";
import { ElRadioButton as oe } from "element-plus";
import { vLoading as ue } from "element-plus";
import { _ as re, bo as S, t as ce, u as de, o as me, bv as _e, bw as i, bS as H, bs as d, D as U, c as R, bR as be, bT as pe } from "../../../../../../shared/runtime.js";
import fe from "./module/structure.vue.js";
import ge from "./module/enclosure.vue.js";
import ve from "./module/auxiliary-material.vue.js";
const he = { class: "head-container" }, ye = { class: "imgs-box" }, Ae = { __name: "index", props: { visible: { type: Boolean, default: false }, title: { type: String, default: "" }, detailInfo: { type: Object, required: true }, weightType: { type: [Number, String], default: S.NET.V }, detailFunc: { type: Function, required: true }, quantityFelid: { type: String, default: "shipQuantity" } }, emits: ["update:visible"], setup(w, { emit: k }) {
  const { decimalPrecision: m } = ce(), O = k, r = w, { visible: L, handleClose: F } = de({ emit: O, props: r, field: "visible" }), { maxHeight: X } = me({ mainBox: ".audit-detail", extraBox: [".el-dialog__header", ".head-container"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, L), I = h(false), b = h([]), p = h([]), f = h([]), t = h({}), g = h(), E = y(() => r.detailInfo && r.detailInfo.productType), x = y(() => _e.getBits(i, E.value, "V")), P = y(() => r.detailInfo && r.detailInfo.id || void 0), $ = y(() => {
    switch (g.value) {
      case i.BOX.V:
        return fe;
      case i.MACHINE_PART.V:
        return ge;
      case i.AUXILIARY_MATERIAL.V:
        return ve;
      default:
        return null;
    }
  }), q = y(() => {
    switch (g.value) {
      case i.BOX.V:
        return b.value && b.value.map((e) => (e.showQuantity = e[r.quantityFelid], e.weight = (r.weightType === S.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = R(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = t.value.structureMeasureMode === be.OVERWEIGHT.V ? R(e.totalWeight, "kg", "t") : R(e.weight * e.showQuantity, "kg", "t"), e.totalPrice = e.pricingManner === pe.WEIGHT.V ? e.totalMete * (e.unitPrice || 0) : e.totalLength * (e.unitPrice || 0), e));
      case i.MACHINE_PART.V:
        return p.value && p.value.map((e) => (e.showQuantity = e[r.quantityFelid], e.totalMete = t.value.enclosureMeasureMode === H.AREA.V ? d(e.totalArea, U.COM_AREA__M2) : R(e.totalLength, "mm", "m", U.MES_ENCLOSURE_L__M), e.totalPrice = e.unitPrice * e.totalMete || 0, e));
      case i.AUXILIARY_MATERIAL.V:
        return f.value && f.value.map((e) => (e.showQuantity = e[r.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e.totalPrice = e.unitPrice * e.showQuantity || 0, e));
      default:
        return [];
    }
  });
  z(() => P.value, (e) => {
    e && W();
  });
  function Q() {
    b.value = [], p.value = [], f.value = [], t.value = {}, g.value = void 0;
  }
  async function W() {
    try {
      Q(), I.value = true, g.value = x.value[0];
      const e = await r.detailFunc(P.value);
      b.value = e.boxList || [], p.value = e.partList || [], f.value = e.auxiliaryMaterialList || [], t.value = e.review || {}, t.value.attachmentImgSrc = t.value.attachmentDTOS && t.value.attachmentDTOS.map((v) => v.imageUrl);
    } catch (e) {
      console.log("详情", e);
    } finally {
      I.value = false;
    }
  }
  return (e, v) => {
    const o = ne, Y = ie, G = se, T = oe, j = J("common-dialog"), C = ue;
    return c(), _(j, { "append-to-body": "", "close-on-click-modal": false, modelValue: a(L), "onUpdate:modelValue": v[1] || (v[1] = (V) => le(L) ? L.value = V : null), title: w.title, top: "5vh", width: "65vw", "custom-class": "audit-detail", onClosed: a(F) }, { titleAfter: l(() => [N(e.$slots, "tip", {}, void 0, true)]), titleRight: l(() => [N(e.$slots, "titleRight", {}, void 0, true)]), default: l(() => {
      var V;
      return [B("div", he, [t.value ? D((c(), _(G, { key: 0, column: 2, border: "", style: { "margin-bottom": "10px" } }, { default: l(() => [u(o, { "label-class-name": "contractLabel", label: "项目名称" }, { default: l(() => [s(n(t.value.name), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "车牌/船牌号" }, { default: l(() => [s(n(t.value.licensePlate), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "本次发货额" }, { default: l(() => [s(n(a(d)(t.value.deliveryAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "安全余额" }, { default: l(() => [s(n(a(d)(t.value.safeAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "合同额" }, { default: l(() => [s(n(a(d)(t.value.contractAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "累计收款" }, { default: l(() => [s(n(a(d)(t.value.totalCollectionAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "累计发运" }, { default: l(() => [s(n(a(d)(t.value.totalDeliveryAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "累计发运额" }, { default: l(() => [s(n(a(d)(t.value.totalDeliveryAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "合同应收" }, { default: l(() => [s(n(a(d)(t.value.contractReceivableAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "开票应收" }, { default: l(() => [s(n(a(d)(t.value.billingReceivableAmount, a(m).bridge)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "附件" }, { default: l(() => [B("div", ye, [(c(true), K(Z, null, ee(t.value.attachmentDTOS, (M) => (c(), _(Y, { "preview-src-list": t.value.attachmentImgSrc, "initial-index": 1, key: M.id, src: M.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })]), _: 1 })), [[C, I.value]]) : A("", true), x.value.length > 1 ? (c(), _(a(ae), { key: 1, modelValue: g.value, "onUpdate:modelValue": v[0] || (v[0] = (M) => g.value = M), size: "default", class: "filter-item" }, { default: l(() => [a(i).BOX.V & E.value ? (c(), _(T, { key: 0, value: a(i).BOX.V, disabled: b.value.length == 0 }, { default: l(() => [s(n(a(i).BOX.L) + "(" + n(b.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : A("", true), a(i).MACHINE_PART.V & E.value ? (c(), _(T, { key: 1, value: a(i).MACHINE_PART.V, disabled: p.value.length == 0 }, { default: l(() => [s(n(a(i).MACHINE_PART.L) + "(" + n(p.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : A("", true), a(i).AUXILIARY_MATERIAL.V & E.value ? (c(), _(T, { key: 2, value: a(i).AUXILIARY_MATERIAL.V, disabled: f.value.length == 0 }, { default: l(() => [s(n(a(i).AUXILIARY_MATERIAL.L) + "(" + n(f.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : A("", true)]), _: 1 }, 8, ["modelValue"])) : A("", true)]), D((c(), _(te($.value), { measureUnit: ((V = t.value) == null ? void 0 : V.enclosureMeasureMode) === a(H).AREA.V ? "㎡" : "m", maxHeight: a(X), list: q.value }, null, 8, ["measureUnit", "maxHeight", "list"])), [[C, I.value]])];
    }), _: 3 }, 8, ["modelValue", "title", "onClosed"]);
  };
} }, Re = re(Ae, [["__scopeId", "data-v-f9aaaf88"]]);
export {
  Re as default
};
