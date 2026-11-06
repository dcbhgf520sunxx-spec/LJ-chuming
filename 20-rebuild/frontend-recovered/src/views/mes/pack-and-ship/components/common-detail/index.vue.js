import { ref as i } from "vue";
import { computed as y } from "vue";
import { watch as F } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as o } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { renderSlot as w } from "vue";
import { createElementVNode as Q } from "vue";
import { unref as a } from "vue";
import { createElementBlock as W } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as h } from "vue";
import { ElRadioGroup as O } from "element-plus";
import { createTextVNode as S } from "vue";
import { createVNode as X } from "vue";
import { withDirectives as Y } from "vue";
import { resolveDynamicComponent as j } from "vue";
import { isRef as z } from "vue";
import { ElRadioButton as K } from "element-plus";
import { vLoading as G } from "element-plus";
import { bo as _, u as J, o as Z, bv as ee, bi as t, c as C, bx as te, by as ae } from "../../../../../shared/runtime.js";
import le from "./module/structure.vue.js";
import ie from "./module/part.vue.js";
import oe from "./module/auxiliary-material.vue.js";
const ne = { class: "head-container" }, se = { key: 0, style: { color: "red", "margin-bottom": "8px" } }, fe = { __name: "index", props: { visible: { type: Boolean, default: false }, title: { type: String, default: "" }, detailInfo: { type: Object, required: true }, weightType: { type: [Number, String], default: _.NET.V }, detailFunc: { type: Function, required: true }, quantityFelid: { type: String, default: "shipQuantity" } }, emits: ["update:visible", "getDetail"], setup(u, { emit: N }) {
  const V = { PROCESS: { L: "单体汇总", K: "PROCESS", V: 0 }, SUSPEND: { L: "区域汇总", K: "SUSPEND", V: 1 } }, b = N, l = u, { visible: v, handleClose: x } = J({ emit: b, props: l, field: "visible" }), { maxHeight: M } = Z({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, extraHeight: 150 }, v), T = i(V.PROCESS.V), E = i(false), c = i([]), m = i([]), k = i([]), f = i([]), p = i(), R = y(() => l.detailInfo && l.detailInfo.productType), L = y(() => ee.getBits(t, R.value, "V")), A = y(() => l.detailInfo && l.detailInfo.id || void 0), D = y(() => {
    switch (p.value) {
      case t.STRUCTURE.V:
        return le;
      case t.MACHINE_PART.V:
        return ie;
      case t.AUXILIARY_MATERIAL.V:
        return oe;
      default:
        return null;
    }
  }), H = y(() => {
    switch (p.value) {
      case t.STRUCTURE.V:
        return c.value && c.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === _.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = C(e.weight * e.showQuantity, "kg", "t"), e));
      case t.MACHINE_PART.V:
        return m.value && m.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === _.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = C(e.weight * e.showQuantity, "kg", "t"), e));
      case t.AUXILIARY_MATERIAL.V:
        return f.value && f.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e));
      default:
        return [];
    }
  });
  F(() => A.value, (e) => {
    e && P();
  });
  async function P() {
    try {
      E.value = true, p.value = L.value[0];
      const e = await l.detailFunc(A.value);
      b("getDetail", A.value, e), c.value = e.artifactList || [], m.value = e.partList || [], k.value = e.enclosureList || [], f.value = e.auxiliaryMaterialList || [];
    } catch (e) {
      console.log("详情", e);
    } finally {
      E.value = false;
    }
  }
  return (e, r) => {
    const I = K, B = U("common-radio-button"), $ = U("common-dialog"), q = G;
    return o(), d($, { "append-to-body": "", "close-on-click-modal": false, modelValue: a(v), "onUpdate:modelValue": r[2] || (r[2] = (g) => z(v) ? v.value = g : null), title: u.title, top: "5vh", width: "85vw", onClosed: a(x) }, { titleAfter: n(() => [w(e.$slots, "tip")]), titleRight: n(() => [w(e.$slots, "titleRight")]), default: n(() => [Q("div", ne, [(u.detailInfo.deliveryStatus === a(te).RETURN.V || u.detailInfo.shipmentStatus === a(ae).RETURN.V) && u.detailInfo.cancelDeliveryReason ? (o(), W("div", se, "当前发运已取消，取消原因：" + s(u.detailInfo.cancelDeliveryReason), 1)) : h("", true), L.value.length > 1 ? (o(), d(a(O), { key: 1, modelValue: p.value, "onUpdate:modelValue": r[0] || (r[0] = (g) => p.value = g), size: "default", class: "filter-item" }, { default: n(() => [a(t).STRUCTURE.V & R.value ? (o(), d(I, { key: 0, value: a(t).STRUCTURE.V, disabled: c.value.length == 0 }, { default: n(() => [S(s(a(t).STRUCTURE.L) + "(" + s(c.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : h("", true), a(t).MACHINE_PART.V & R.value ? (o(), d(I, { key: 1, value: a(t).MACHINE_PART.V, disabled: m.value.length == 0 }, { default: n(() => [S(s(a(t).MACHINE_PART.L) + "(" + s(m.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : h("", true), a(t).AUXILIARY_MATERIAL.V & R.value ? (o(), d(I, { key: 2, value: a(t).AUXILIARY_MATERIAL.V, disabled: f.value.length == 0 }, { default: n(() => [S(s(a(t).AUXILIARY_MATERIAL.L) + "(" + s(f.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : h("", true)]), _: 1 }, 8, ["modelValue"])) : h("", true), X(B, { modelValue: T.value, "onUpdate:modelValue": r[1] || (r[1] = (g) => T.value = g), options: V, type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue"])]), Y((o(), d(j(D.value), { maxHeight: a(M), list: H.value, isSuspend: T.value === V.SUSPEND.V }, null, 8, ["maxHeight", "list", "isSuspend"])), [[q, E.value]])]), _: 3 }, 8, ["modelValue", "title", "onClosed"]);
  };
} };
export {
  fe as default
};
