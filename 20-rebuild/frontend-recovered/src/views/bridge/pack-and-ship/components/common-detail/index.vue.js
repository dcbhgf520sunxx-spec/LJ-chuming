import { ref as r } from "vue";
import { computed as y } from "vue";
import { watch as X } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as o } from "vue";
import { renderSlot as N } from "vue";
import { createElementVNode as $ } from "vue";
import { unref as a } from "vue";
import { createElementBlock as q } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as h } from "vue";
import { ElRadioGroup as F } from "element-plus";
import { createTextVNode as E } from "vue";
import { createVNode as Q } from "vue";
import { withDirectives as W } from "vue";
import { resolveDynamicComponent as Y } from "vue";
import { isRef as j } from "vue";
import { ElRadioButton as z } from "element-plus";
import { vLoading as K } from "element-plus";
import { bo as x, u as G, o as J, bv as Z, bw as t, c as S, bx as ee, by as te } from "../../../../../shared/runtime.js";
import ae from "./module/structure.vue.js";
import le from "./module/enclosure.vue.js";
import ie from "./module/auxiliary-material.vue.js";
const oe = { class: "head-container" }, ne = { key: 0, style: { color: "red", "margin-bottom": "8px" } }, me = { __name: "index", props: { visible: { type: Boolean, default: false }, title: { type: String, default: "" }, detailInfo: { type: Object, required: true }, weightType: { type: [Number, String], default: x.NET.V }, detailFunc: { type: Function, required: true }, quantityFelid: { type: String, default: "shipQuantity" } }, emits: ["update:visible", "getDetail"], setup(u, { emit: C }) {
  const A = { PROCESS: { L: "单体汇总", K: "PROCESS", V: 0 }, SUSPEND: { L: "区域汇总", K: "SUSPEND", V: 1 } }, L = C, l = u, { visible: v, handleClose: B } = G({ emit: L, props: l, field: "visible" }), { maxHeight: U } = J({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, extraHeight: 150 }, v), I = r(A.PROCESS.V), R = r(false), c = r([]), m = r([]), f = r([]), p = r(), V = y(() => l.detailInfo && l.detailInfo.productType), T = y(() => Z.getBits(t, V.value, "V")), b = y(() => l.detailInfo && l.detailInfo.id || void 0), M = y(() => {
    switch (p.value) {
      case t.BOX.V:
        return ae;
      case t.MACHINE_PART.V:
        return le;
      case t.AUXILIARY_MATERIAL.V:
        return ie;
      default:
        return null;
    }
  }), P = y(() => {
    switch (p.value) {
      case t.BOX.V:
        return c.value && c.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === x.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = S(e.weight * e.showQuantity, "kg", "t"), e));
      case t.MACHINE_PART.V:
        return m.value && m.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.totalLength = S(e.length * e.showQuantity, "mm", "m"), e.totalWeight = S(e.totalWeight, "kg", "t"), e));
      case t.AUXILIARY_MATERIAL.V:
        return f.value && f.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e));
      default:
        return [];
    }
  });
  X(() => b.value, (e) => {
    e && k();
  });
  async function k() {
    try {
      R.value = true, p.value = T.value[0];
      const e = await l.detailFunc(b.value);
      L("getDetail", b.value, e), c.value = e.boxList || [], m.value = e.partList || [], f.value = e.auxiliaryMaterialList || [];
    } catch (e) {
      console.log("详情", e);
    } finally {
      R.value = false;
    }
  }
  return (e, s) => {
    const _ = z, D = w("common-radio-button"), H = w("common-dialog"), O = K;
    return i(), d(H, { "append-to-body": "", "close-on-click-modal": false, modelValue: a(v), "onUpdate:modelValue": s[2] || (s[2] = (g) => j(v) ? v.value = g : null), title: u.title, top: "5vh", width: "85vw", onClosed: a(B) }, { titleAfter: o(() => [N(e.$slots, "tip")]), titleRight: o(() => [N(e.$slots, "titleRight")]), default: o(() => [$("div", oe, [(u.detailInfo.deliveryStatus === a(ee).RETURN.V || u.detailInfo.shipmentStatus === a(te).RETURN.V) && u.detailInfo.cancelDeliveryReason ? (i(), q("div", ne, "当前发运已取消，取消原因：" + n(u.detailInfo.cancelDeliveryReason), 1)) : h("", true), T.value.length > 1 ? (i(), d(a(F), { key: 1, modelValue: p.value, "onUpdate:modelValue": s[0] || (s[0] = (g) => p.value = g), size: "default", class: "filter-item" }, { default: o(() => [a(t).BOX.V & V.value ? (i(), d(_, { key: 0, value: a(t).BOX.V, disabled: c.value.length == 0 }, { default: o(() => [E(n(a(t).BOX.L) + "(" + n(c.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : h("", true), a(t).MACHINE_PART.V & V.value ? (i(), d(_, { key: 1, value: a(t).MACHINE_PART.V, disabled: m.value.length == 0 }, { default: o(() => [E(n(a(t).MACHINE_PART.L) + "(" + n(m.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : h("", true), a(t).AUXILIARY_MATERIAL.V & V.value ? (i(), d(_, { key: 2, value: a(t).AUXILIARY_MATERIAL.V, disabled: f.value.length == 0 }, { default: o(() => [E(n(a(t).AUXILIARY_MATERIAL.L) + "(" + n(f.value.length) + ")", 1)]), _: 1 }, 8, ["value", "disabled"])) : h("", true)]), _: 1 }, 8, ["modelValue"])) : h("", true), Q(D, { modelValue: I.value, "onUpdate:modelValue": s[1] || (s[1] = (g) => I.value = g), options: A, type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue"])]), W((i(), d(Y(M.value), { maxHeight: a(U), list: P.value, isSuspend: I.value === A.SUSPEND.V }, null, 8, ["maxHeight", "list", "isSuspend"])), [[O, R.value]])]), _: 3 }, 8, ["modelValue", "title", "onClosed"]);
  };
} };
export {
  me as default
};
