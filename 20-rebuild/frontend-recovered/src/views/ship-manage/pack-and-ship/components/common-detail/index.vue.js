import { ref as h } from "vue";
import { computed as f } from "vue";
import { watch as ie } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as i } from "vue";
import { createBlock as s } from "vue";
import { withCtx as r } from "vue";
import { renderSlot as _ } from "vue";
import { createElementVNode as O } from "vue";
import { unref as t } from "vue";
import { createElementBlock as k } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as o } from "vue";
import { ElRadioGroup as X } from "element-plus";
import { createTextVNode as E } from "vue";
import { withDirectives as $ } from "vue";
import { resolveDynamicComponent as Q } from "vue";
import { Fragment as ue } from "vue";
import { isRef as ne } from "vue";
import { ElRadioButton as se } from "element-plus";
import { vLoading as oe } from "element-plus";
import { bo as L, u as re, o as de, bv as F, bi as a, bw as n, c as b, bx as W, by as q, K as ce } from "../../../../../shared/runtime.js";
import me from "./module/structure.vue.js";
import Y from "./module/part.vue.js";
import ge from "./module/enclosure.vue.js";
import j from "./module/auxiliary-material.vue.js";
import he from "./module/box.vue.js";
const ye = { class: "head-container" }, fe = { key: 0, style: { color: "red", "margin-bottom": "8px" } }, Re = { class: "head-container" }, pe = { key: 0, style: { color: "red", "margin-bottom": "8px" } }, be = { __name: "index", props: { visible: { type: Boolean, default: false }, title: { type: String, default: "" }, detailInfo: { type: Object, required: true }, weightType: { type: [Number, String], default: L.NET.V }, detailFunc: { type: Function, required: true }, quantityFelid: { type: String, default: "shipQuantity" }, projectType: { type: Number } }, emits: ["update:visible", "getDetail"], setup(d, { emit: z }) {
  const S = { PROCESS: { L: "单体汇总", K: "PROCESS", V: 0 }, SUSPEND: { L: "区域汇总", K: "SUSPEND", V: 1 } }, M = z, l = d, { visible: N, handleClose: K } = re({ emit: M, props: l, field: "visible" }), { maxHeight: P } = de({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, extraHeight: 150 }, N), w = h(S.PROCESS.V), U = h(false), V = h([]), m = h([]), v = h([]), g = h([]), A = h([]), T = h(), I = h(), c = f(() => l.detailInfo && l.detailInfo.productType), H = f(() => F.getBits(a, c.value, "V")), x = f(() => F.getBits(n, c.value, "V")), C = f(() => l.detailInfo && l.detailInfo.id || void 0), G = f(() => {
    switch (T.value) {
      case a.STRUCTURE.V:
        return me;
      case a.MACHINE_PART.V:
        return Y;
      case a.ENCLOSURE.V:
        return ge;
      case a.AUXILIARY_MATERIAL.V:
        return j;
      default:
        return null;
    }
  }), J = f(() => {
    switch (T.value) {
      case a.STRUCTURE.V:
        return V.value && V.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === L.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = b(e.weight * e.showQuantity, "kg", "t"), e));
      case a.MACHINE_PART.V:
        return m.value && m.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === L.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = b(e.weight * e.showQuantity, "kg", "t"), e));
      case a.ENCLOSURE.V:
        return v.value && v.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.totalLength = b(e.length * e.showQuantity, "mm", "m"), e));
      case a.AUXILIARY_MATERIAL.V:
        return g.value && g.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e));
      default:
        return [];
    }
  }), Z = f(() => {
    switch (I.value) {
      case n.BOX.V:
        return he;
      case n.MACHINE_PART.V:
        return Y;
      case n.AUXILIARY_MATERIAL.V:
        return j;
      default:
        return null;
    }
  }), ee = f(() => {
    switch (I.value) {
      case n.BOX.V:
        return A.value && A.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === L.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = b(e.weight * e.showQuantity, "kg", "t"), e));
      case n.MACHINE_PART.V:
        return m.value && m.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.weight = (l.weightType === L.NET.V ? e.netWeight : e.grossWeight) || 0, e.totalWeight = b(e.weight * e.showQuantity, "kg", "t"), e));
      case n.AUXILIARY_MATERIAL.V:
        return g.value && g.value.map((e) => (e.showQuantity = e[l.quantityFelid], e.fullClassName = `${e.firstName}/${e.secondName}/${e.thirdName}`, e));
      default:
        return [];
    }
  });
  ie(() => C.value, (e) => {
    e && te();
  });
  async function te() {
    try {
      U.value = true, T.value = H.value[0], I.value = x.value[0];
      const e = await l.detailFunc(C.value);
      console.log(e, "data"), M("getDetail", C.value, e), V.value = e.artifactList || [], m.value = e.partList || [], v.value = e.enclosureList || [], g.value = e.auxiliaryMaterialList || [], A.value = e.boxList || [];
    } catch (e) {
      console.log("详情", e);
    } finally {
      U.value = false;
    }
  }
  return (e, y) => {
    const R = se, ae = D("common-radio-button"), le = D("common-dialog"), B = oe;
    return i(), s(le, { modelValue: t(N), "onUpdate:modelValue": y[3] || (y[3] = (p) => ne(N) ? N.value = p : null), "close-on-click-modal": false, title: d.title, "append-to-body": "", top: "5vh", width: "85vw", onClosed: t(K) }, { titleAfter: r(() => [_(e.$slots, "tip")]), titleRight: r(() => [_(e.$slots, "titleRight")]), default: r(() => [_(e.$slots, "topContent"), O("div", ye, [(d.detailInfo.deliveryStatus === t(W).RETURN.V || d.detailInfo.shipmentStatus === t(q).RETURN.V) && d.detailInfo.cancelDeliveryReason ? (i(), k("div", fe, " 当前发运已取消，取消原因：" + u(d.detailInfo.cancelDeliveryReason), 1)) : o("", true), H.value.length > 1 ? (i(), s(t(X), { key: 1, modelValue: T.value, "onUpdate:modelValue": y[0] || (y[0] = (p) => T.value = p), class: "filter-item", size: "default" }, { default: r(() => [t(a).STRUCTURE.V & c.value ? (i(), s(R, { key: 0, disabled: V.value.length == 0, value: t(a).STRUCTURE.V }, { default: r(() => [E(u(t(a).STRUCTURE.L) + "(" + u(V.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true), t(a).MACHINE_PART.V & c.value ? (i(), s(R, { key: 1, disabled: m.value.length == 0, value: t(a).MACHINE_PART.V }, { default: r(() => [E(u(t(a).MACHINE_PART.L) + "(" + u(m.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true), t(a).ENCLOSURE.V & c.value ? (i(), s(R, { key: 2, disabled: v.value.length == 0, value: t(a).ENCLOSURE.V }, { default: r(() => [E(u(t(a).ENCLOSURE.L) + "(" + u(v.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true), t(a).AUXILIARY_MATERIAL.V & c.value ? (i(), s(R, { key: 3, disabled: g.value.length == 0, value: t(a).AUXILIARY_MATERIAL.V }, { default: r(() => [E(u(t(a).AUXILIARY_MATERIAL.L) + "(" + u(g.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true)]), _: 1 }, 8, ["modelValue"])) : o("", true), c.value !== t(a).ENCLOSURE.V ? (i(), s(ae, { key: 2, modelValue: w.value, "onUpdate:modelValue": y[1] || (y[1] = (p) => w.value = p), options: S, class: "filter-item", size: "default", type: "enum" }, null, 8, ["modelValue"])) : o("", true), _(e.$slots, "upload")]), $((i(), s(Q(G.value), { isSuspend: w.value === S.SUSPEND.V, list: J.value, maxHeight: t(P) }, null, 8, ["isSuspend", "list", "maxHeight"])), [[B, U.value]]), d.projectType === t(ce).BRIDGE.V ? (i(), k(ue, { key: 0 }, [O("div", Re, [(d.detailInfo.deliveryStatus === t(W).RETURN.V || d.detailInfo.shipmentStatus === t(q).RETURN.V) && d.detailInfo.cancelDeliveryReason ? (i(), k("div", pe, " 当前发运已取消，取消原因：" + u(d.detailInfo.cancelDeliveryReason), 1)) : o("", true), x.value.length > 1 ? (i(), s(t(X), { key: 1, modelValue: I.value, "onUpdate:modelValue": y[2] || (y[2] = (p) => I.value = p), class: "filter-item", size: "default" }, { default: r(() => [t(n).BOX.V & c.value ? (i(), s(R, { key: 0, disabled: A.value.length == 0, value: t(n).BOX.V }, { default: r(() => [E(u(t(n).BOX.L) + "(" + u(A.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true), t(n).MACHINE_PART.V & c.value ? (i(), s(R, { key: 1, disabled: m.value.length == 0, value: t(n).MACHINE_PART.V }, { default: r(() => [E(u(t(n).MACHINE_PART.L) + "(" + u(m.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true), t(n).AUXILIARY_MATERIAL.V & c.value ? (i(), s(R, { key: 2, disabled: g.value.length == 0, value: t(n).AUXILIARY_MATERIAL.V }, { default: r(() => [E(u(t(n).AUXILIARY_MATERIAL.L) + "(" + u(g.value.length) + ") ", 1)]), _: 1 }, 8, ["disabled", "value"])) : o("", true)]), _: 1 }, 8, ["modelValue"])) : o("", true)]), $((i(), s(Q(Z.value), { isSuspend: w.value === S.SUSPEND.V, list: ee.value, maxHeight: t(P) }, null, 8, ["isSuspend", "list", "maxHeight"])), [[B, U.value]])], 64)) : o("", true)]), _: 3 }, 8, ["modelValue", "title", "onClosed"]);
  };
} };
export {
  be as default
};
