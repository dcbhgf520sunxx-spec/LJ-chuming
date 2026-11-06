import { ref as _ } from "vue";
import { computed as T } from "vue";
import { watch as J } from "vue";
import { resolveComponent as K } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { renderSlot as N } from "vue";
import { createElementVNode as H } from "vue";
import { withDirectives as k } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as n } from "vue";
import { unref as t } from "vue";
import { createElementBlock as Z } from "vue";
import { Fragment as ee } from "vue";
import { renderList as te } from "vue";
import { createCommentVNode as A } from "vue";
import { ElRadioGroup as ae } from "element-plus";
import { resolveDynamicComponent as le } from "vue";
import { isRef as ne } from "vue";
import { ElDescriptionsItem as ie } from "element-plus";
import { ElImage as se } from "element-plus";
import { ElDescriptions as oe } from "element-plus";
import { ElRadioButton as ue } from "element-plus";
import { vLoading as re } from "element-plus";
import { _ as ce, bo as M, t as de, u as me, o as pe, bv as _e, bi as i, c as v, bR as D, bT as B, bs as p, bS as ge } from "../../../../../../shared/runtime.js";
import be from "./module/structure.vue.js";
import fe from "./module/part.vue.js";
import he from "./module/auxiliary-material.vue.js";
const ye = { class: "head-container" }, ve = { class: "imgs-box" }, Te = { __name: "index", props: { visible: { type: Boolean, default: false }, title: { type: String, default: "" }, detailInfo: { type: Object, required: true }, weightType: { type: [Number, String], default: M.NET.V }, detailFunc: { type: Function, required: true }, quantityFelid: { type: String, default: "shipQuantity" } }, emits: ["update:visible"], setup(U, { emit: W }) {
  const { decimalPrecision: d } = de(), F = W, r = U, { visible: L, handleClose: Q } = me({ emit: F, props: r, field: "visible" }), { maxHeight: $ } = pe({ mainBox: ".audit-detail", extraBox: [".el-dialog__header", ".head-container"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, L), E = _(false), g = _([]), b = _([]), x = _([]), f = _([]), a = _({}), h = _(), I = T(() => r.detailInfo && r.detailInfo.productType), C = T(() => _e.getBits(i, I.value, "V")), P = T(() => r.detailInfo && r.detailInfo.id || void 0), O = T(() => {
    switch (h.value) {
      case i.STRUCTURE.V:
        return be;
      case i.MACHINE_PART.V:
        return fe;
      case i.AUXILIARY_MATERIAL.V:
        return he;
      default:
        return null;
    }
  }), q = T(() => {
    switch (h.value) {
      case i.STRUCTURE.V:
        return g.value && g.value.map((e) => (e.showQuantity = e[r.quantityFelid], e.weight = (r.weightType === M.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = v(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = a.value.structureMeasureMode === D.OVERWEIGHT.V ? v(e.totalWeight, "kg", "t") : v(e.weight * e.showQuantity, "kg", "t"), e.totalPrice = e.boolAllPartSendDirectly ? e.totalPrice : e.pricingManner === B.WEIGHT.V ? e.totalMete * (e.unitPrice || 0) : e.totalLength * (e.unitPrice || 0), e));
      case i.MACHINE_PART.V:
        return b.value && b.value.map((e) => (e.showQuantity = e[r.quantityFelid], e.weight = (r.weightType === M.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = v(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = a.value.structureMeasureMode === D.OVERWEIGHT.V ? v(e.totalWeight, "kg", "t") : v(e.weight * e.showQuantity, "kg", "t"), e.totalPrice = e.pricingManner === B.WEIGHT.V ? e.totalMete * (e.unitPrice || 0) : e.totalLength * (e.unitPrice || 0), e));
      case i.AUXILIARY_MATERIAL.V:
        return f.value && f.value.map((e) => (e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e.totalPrice = e.unitPrice * e.shipQuantity || 0, e));
      default:
        return [];
    }
  });
  J(() => P.value, (e) => {
    e && X();
  });
  function G() {
    g.value = [], b.value = [], x.value = [], f.value = [], a.value = {}, h.value = void 0;
  }
  async function X() {
    try {
      G(), E.value = true, h.value = C.value[0];
      const e = await r.detailFunc(P.value);
      g.value = e.artifactList || [], b.value = e.partList || [], x.value = e.enclosureList || [], f.value = e.auxiliaryMaterialList || [], a.value = e.review || {}, a.value.attachmentImgSrc = a.value.attachmentDTOS && a.value.attachmentDTOS.map((y) => y.imageUrl);
    } catch (e) {
      console.log("详情", e);
    } finally {
      E.value = false;
    }
  }
  return (e, y) => {
    const o = ie, Y = se, j = oe, w = ue, z = K("common-dialog"), S = re;
    return c(), m(z, { "append-to-body": "", "close-on-click-modal": false, modelValue: t(L), "onUpdate:modelValue": y[1] || (y[1] = (R) => ne(L) ? L.value = R : null), title: U.title, top: "5vh", width: "65vw", "custom-class": "audit-detail", onClosed: t(Q) }, { titleAfter: l(() => [N(e.$slots, "tip", {}, void 0, true)]), titleRight: l(() => [N(e.$slots, "titleRight", {}, void 0, true)]), default: l(() => {
      var R;
      return [H("div", ye, [a.value ? k((c(), m(j, { key: 0, column: 2, border: "", style: { "margin-bottom": "10px" } }, { default: l(() => [u(o, { "label-class-name": "contractLabel", label: "项目名称" }, { default: l(() => [s(n(a.value.name), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "车牌/船牌号" }, { default: l(() => [s(n(a.value.licensePlate), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "本次发货额" }, { default: l(() => [s(n(t(p)(a.value.deliveryAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "安全余额" }, { default: l(() => [s(n(t(p)(a.value.safeAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "合同额" }, { default: l(() => [s(n(t(p)(a.value.contractAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "累计收款" }, { default: l(() => [s(n(t(p)(a.value.totalCollectionAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "累计发运" }, { default: l(() => [s(n(t(p)(a.value.totalDeliveryAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "累计发运额" }, { default: l(() => [s(n(t(p)(a.value.totalDeliveryAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "合同应收" }, { default: l(() => [s(n(t(p)(a.value.contractReceivableAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "开票应收" }, { default: l(() => [s(n(t(p)(a.value.billingReceivableAmount, t(d).mes)), 1)]), _: 1 }), u(o, { "label-class-name": "contractLabel", label: "附件" }, { default: l(() => [H("div", ve, [(c(true), Z(ee, null, te(a.value.attachmentDTOS, (V) => (c(), m(Y, { "preview-src-list": a.value.attachmentImgSrc, "initial-index": 1, key: V.id, src: V.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })]), _: 1 })), [[S, E.value]]) : A("", true), C.value.length > 1 ? (c(), m(t(ae), { key: 1, modelValue: h.value, "onUpdate:modelValue": y[0] || (y[0] = (V) => h.value = V), size: "default", class: "filter-item" }, { default: l(() => [t(i).STRUCTURE.V & I.value ? (c(), m(w, { key: 0, value: t(i).STRUCTURE.V, disabled: g.value.length == 0 }, { default: l(() => [s(n(t(i).STRUCTURE.L) + "(" + n(g.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : A("", true), t(i).MACHINE_PART.V & I.value ? (c(), m(w, { key: 1, value: t(i).MACHINE_PART.V, disabled: b.value.length == 0 }, { default: l(() => [s(n(t(i).MACHINE_PART.L) + "(" + n(b.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : A("", true), t(i).AUXILIARY_MATERIAL.V & I.value ? (c(), m(w, { key: 2, value: t(i).AUXILIARY_MATERIAL.V, disabled: f.value.length == 0 }, { default: l(() => [s(n(t(i).AUXILIARY_MATERIAL.L) + "(" + n(f.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : A("", true)]), _: 1 }, 8, ["modelValue"])) : A("", true)]), k((c(), m(le(O.value), { measureUnit: ((R = a.value) == null ? void 0 : R.enclosureMeasureMode) === t(ge).AREA.V ? "㎡" : "m", maxHeight: t($), list: q.value }, null, 8, ["measureUnit", "maxHeight", "list"])), [[S, E.value]])];
    }), _: 3 }, 8, ["modelValue", "title", "onClosed"]);
  };
} }, Ve = ce(Te, [["__scopeId", "data-v-d2b18c4a"]]);
export {
  Ve as default
};
