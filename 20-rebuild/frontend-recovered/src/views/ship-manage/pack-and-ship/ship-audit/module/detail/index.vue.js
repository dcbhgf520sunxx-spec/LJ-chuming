import { ref as A } from "vue";
import { computed as E } from "vue";
import { watch as he } from "vue";
import { resolveComponent as ge } from "vue";
import { openBlock as r } from "vue";
import { createBlock as b } from "vue";
import { withCtx as l } from "vue";
import { renderSlot as j } from "vue";
import { unref as t } from "vue";
import { createElementBlock as H } from "vue";
import { Fragment as O } from "vue";
import { createElementVNode as B } from "vue";
import { withDirectives as D } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as n } from "vue";
import { renderList as z } from "vue";
import { createCommentVNode as g } from "vue";
import { ElRadioGroup as K } from "element-plus";
import { resolveDynamicComponent as J } from "vue";
import { isRef as _e } from "vue";
import { ElDescriptionsItem as pe } from "element-plus";
import { ElImage as ve } from "element-plus";
import { ElDescriptions as fe } from "element-plus";
import { ElRadioButton as ye } from "element-plus";
import { vLoading as Ae } from "element-plus";
import { _ as Le, bo as C, t as Ee, u as Re, o as Ve, bv as Z, bi as o, bw as h, bS as Q, bs as d, D as ee, c as _, bR as P, K as te } from "../../../../../../shared/runtime.js";
import Te from "./module/structure.vue.js";
import ae from "./module/part.vue.js";
import Ie from "./module/enclosure.vue.js";
import le from "./module/auxiliary-material.vue.js";
import we from "./module/box.vue.js";
const Me = { class: "head-container" }, Ue = { class: "imgs-box" }, Ce = { class: "head-container" }, Ne = { class: "imgs-box" }, xe = { __name: "index", props: { visible: { type: Boolean, default: false }, title: { type: String, default: "" }, detailInfo: { type: Object, required: true }, weightType: { type: [Number, String], default: C.NET.V }, detailFunc: { type: Function, required: true }, quantityFelid: { type: String, default: "shipQuantity" }, projectType: { type: Number } }, emits: ["update:visible"], setup(N, { emit: ne }) {
  const { decimalPrecision: m } = Ee(), ue = ne, c = N, { visible: x, handleClose: se } = Re({ emit: ue, props: c, field: "visible" }), { maxHeight: W } = Ve({ mainBox: ".audit-detail", extraBox: [".el-dialog__header", ".head-container"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, x), V = A(false), T = A([]), p = A([]), I = A([]), v = A([]), w = A([]), a = A({}), M = A(), U = A(), f = E(() => c.detailInfo && c.detailInfo.productType), X = E(() => Z.getBits(o, f.value, "V")), F = E(() => Z.getBits(h, f.value, "V")), $ = E(() => c.detailInfo && c.detailInfo.id || void 0), ie = E(() => {
    switch (M.value) {
      case o.STRUCTURE.V:
        return Te;
      case o.MACHINE_PART.V:
        return ae;
      case o.ENCLOSURE.V:
        return Ie;
      case o.AUXILIARY_MATERIAL.V:
        return le;
      default:
        return null;
    }
  }), oe = E(() => {
    switch (M.value) {
      case o.STRUCTURE.V:
        return T.value && T.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.weight = (c.weightType === C.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = _(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = a.value.structureMeasureMode === P.OVERWEIGHT.V ? _(e.totalWeight, "kg", "t") : _(e.weight * e.showQuantity, "kg", "t"), e));
      case o.MACHINE_PART.V:
        return p.value && p.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.weight = (c.weightType === C.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = _(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = a.value.structureMeasureMode === P.OVERWEIGHT.V ? _(e.totalWeight, "kg", "t") : _(e.weight * e.showQuantity, "kg", "t"), e));
      case o.ENCLOSURE.V:
        return I.value && I.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.totalMete = e.pricingManner === Q.AREA.V ? d(e.totalArea, ee.COM_ENCLOSURE_AREA__M2) : _(e.totalLength, "mm", "m", ee.MES_ENCLOSURE_L__M), e));
      case o.AUXILIARY_MATERIAL.V:
        return v.value && v.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e));
      default:
        return [];
    }
  }), re = E(() => {
    switch (U.value) {
      case h.BOX.V:
        return we;
      case h.MACHINE_PART.V:
        return ae;
      case h.AUXILIARY_MATERIAL.V:
        return le;
      default:
        return null;
    }
  }), ce = E(() => {
    switch (U.value) {
      case h.BOX.V:
        return w.value && w.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.weight = (c.weightType === C.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = _(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = a.value.structureMeasureMode === P.OVERWEIGHT.V ? _(e.totalWeight, "kg", "t") : _(e.weight * e.showQuantity, "kg", "t"), e));
      case h.MACHINE_PART.V:
        return p.value && p.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.weight = (c.weightType === C.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalLength = _(e.length * e.showQuantity || 0, "mm", "m"), e.totalMete = a.value.structureMeasureMode === P.OVERWEIGHT.V ? _(e.totalWeight, "kg", "t") : _(e.weight * e.showQuantity, "kg", "t"), e));
      case h.AUXILIARY_MATERIAL.V:
        return v.value && v.value.map((e) => (e.showQuantity = e[c.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e));
      default:
        return [];
    }
  });
  he(() => $.value, (e) => {
    e && me();
  });
  function de() {
    T.value = [], p.value = [], I.value = [], v.value = [], w.value = [], a.value = {}, M.value = void 0, U.value = void 0;
  }
  async function me() {
    try {
      de(), V.value = true, M.value = X.value[0], U.value = F.value[0];
      const e = await c.detailFunc($.value);
      T.value = e.artifactList || [], p.value = e.partList || [], I.value = e.enclosureList || [], v.value = e.auxiliaryMaterialList || [], w.value = e.boxList || [], a.value = e.review || {}, a.value.attachmentImgSrc = a.value.attachmentDTOS && a.value.attachmentDTOS.map((L) => L.imageUrl);
    } catch (e) {
      console.log("详情", e);
    } finally {
      V.value = false;
    }
  }
  return (e, L) => {
    const s = pe, q = ve, Y = fe, R = ye, be = ge("common-dialog"), k = Ae;
    return r(), b(be, { "append-to-body": "", "close-on-click-modal": false, modelValue: t(x), "onUpdate:modelValue": L[2] || (L[2] = (S) => _e(x) ? x.value = S : null), title: N.title, top: "5vh", width: "65vw", "custom-class": "audit-detail", onClosed: t(se) }, { titleAfter: l(() => [j(e.$slots, "tip", {}, void 0, true)]), titleRight: l(() => [j(e.$slots, "titleRight", {}, void 0, true)]), default: l(() => {
      var S, G;
      return [N.projectType !== t(te).BRIDGE.V ? (r(), H(O, { key: 0 }, [B("div", Me, [a.value ? D((r(), b(Y, { key: 0, column: 2, border: "", style: { "margin-bottom": "10px" } }, { default: l(() => [i(s, { "label-class-name": "contractLabel", label: "项目名称" }, { default: l(() => [u(n(a.value.name), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "车牌/船牌号" }, { default: l(() => [u(n(a.value.licensePlate), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "本次发货额" }, { default: l(() => [u(n(t(d)(a.value.deliveryAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "安全余额" }, { default: l(() => [u(n(t(d)(a.value.safeAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "合同额" }, { default: l(() => [u(n(t(d)(a.value.contractAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "累计收款" }, { default: l(() => [u(n(t(d)(a.value.totalCollectionAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "累计发运" }, { default: l(() => [u(n(t(d)(a.value.totalDeliveryAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "累计发运额" }, { default: l(() => [u(n(t(d)(a.value.totalDeliveryAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "合同应收" }, { default: l(() => [u(n(t(d)(a.value.contractReceivableAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "开票应收" }, { default: l(() => [u(n(t(d)(a.value.billingReceivableAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "附件" }, { default: l(() => [B("div", Ue, [(r(true), H(O, null, z(a.value.attachmentDTOS, (y) => (r(), b(q, { "preview-src-list": a.value.attachmentImgSrc, "initial-index": 1, key: y.id, src: y.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })]), _: 1 })), [[k, V.value]]) : g("", true), X.value.length > 1 ? (r(), b(t(K), { key: 1, modelValue: M.value, "onUpdate:modelValue": L[0] || (L[0] = (y) => M.value = y), size: "default", class: "filter-item" }, { default: l(() => [t(o).STRUCTURE.V & f.value ? (r(), b(R, { key: 0, value: t(o).STRUCTURE.V, disabled: T.value.length == 0 }, { default: l(() => [u(n(t(o).STRUCTURE.L) + "(" + n(T.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true), t(o).MACHINE_PART.V & f.value ? (r(), b(R, { key: 1, value: t(o).MACHINE_PART.V, disabled: p.value.length == 0 }, { default: l(() => [u(n(t(o).MACHINE_PART.L) + "(" + n(p.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true), t(o).ENCLOSURE.V & f.value ? (r(), b(R, { key: 2, value: t(o).ENCLOSURE.V, disabled: I.value.length == 0 }, { default: l(() => [u(n(t(o).ENCLOSURE.L) + "(" + n(I.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true), t(o).AUXILIARY_MATERIAL.V & f.value ? (r(), b(R, { key: 3, value: t(o).AUXILIARY_MATERIAL.V, disabled: v.value.length == 0 }, { default: l(() => [u(n(t(o).AUXILIARY_MATERIAL.L) + "(" + n(v.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true)]), _: 1 }, 8, ["modelValue"])) : g("", true)]), D((r(), b(J(ie.value), { measureUnit: ((S = a.value) == null ? void 0 : S.enclosureMeasureMode) === t(Q).AREA.V ? "㎡" : "m", maxHeight: t(W), list: oe.value }, null, 8, ["measureUnit", "maxHeight", "list"])), [[k, V.value]])], 64)) : g("", true), N.projectType === t(te).BRIDGE.V ? (r(), H(O, { key: 1 }, [B("div", Ce, [a.value ? D((r(), b(Y, { key: 0, column: 2, border: "", style: { "margin-bottom": "10px" } }, { default: l(() => [i(s, { "label-class-name": "contractLabel", label: "项目名称" }, { default: l(() => [u(n(a.value.name), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "车牌/船牌号" }, { default: l(() => [u(n(a.value.licensePlate), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "本次发货额" }, { default: l(() => [u(n(t(d)(a.value.deliveryAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "安全余额" }, { default: l(() => [u(n(t(d)(a.value.safeAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "合同额" }, { default: l(() => [u(n(t(d)(a.value.contractAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "累计收款" }, { default: l(() => [u(n(t(d)(a.value.totalCollectionAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "累计发运" }, { default: l(() => [u(n(t(d)(a.value.totalDeliveryAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "累计发运额" }, { default: l(() => [u(n(t(d)(a.value.totalDeliveryAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "合同应收" }, { default: l(() => [u(n(t(d)(a.value.contractReceivableAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "开票应收" }, { default: l(() => [u(n(t(d)(a.value.billingReceivableAmount, t(m).shipment)), 1)]), _: 1 }), i(s, { "label-class-name": "contractLabel", label: "附件" }, { default: l(() => [B("div", Ne, [(r(true), H(O, null, z(a.value.attachmentDTOS, (y) => (r(), b(q, { "preview-src-list": a.value.attachmentImgSrc, "initial-index": 1, key: y.id, src: y.tinyImageUrl, lazy: "", style: { margin: "0 2px" } }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })]), _: 1 })), [[k, V.value]]) : g("", true), F.value.length > 1 ? (r(), b(t(K), { key: 1, modelValue: U.value, "onUpdate:modelValue": L[1] || (L[1] = (y) => U.value = y), size: "default", class: "filter-item" }, { default: l(() => [t(h).BOX.V & f.value ? (r(), b(R, { key: 0, value: t(h).BOX.V, disabled: w.value.length == 0 }, { default: l(() => [u(n(t(h).BOX.L) + "(" + n(w.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true), t(h).MACHINE_PART.V & f.value ? (r(), b(R, { key: 1, value: t(h).MACHINE_PART.V, disabled: p.value.length == 0 }, { default: l(() => [u(n(t(h).MACHINE_PART.L) + "(" + n(p.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true), t(h).AUXILIARY_MATERIAL.V & f.value ? (r(), b(R, { key: 2, value: t(h).AUXILIARY_MATERIAL.V, disabled: v.value.length == 0 }, { default: l(() => [u(n(t(h).AUXILIARY_MATERIAL.L) + "(" + n(v.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : g("", true)]), _: 1 }, 8, ["modelValue"])) : g("", true)]), D((r(), b(J(re.value), { measureUnit: ((G = a.value) == null ? void 0 : G.enclosureMeasureMode) === t(Q).AREA.V ? "㎡" : "m", maxHeight: t(W), list: ce.value }, null, 8, ["measureUnit", "maxHeight", "list"])), [[k, V.value]])], 64)) : g("", true)];
    }), _: 3 }, 8, ["modelValue", "title", "onClosed"]);
  };
} }, Qe = Le(xe, [["__scopeId", "data-v-2b485482"]]);
export {
  Qe as default
};
