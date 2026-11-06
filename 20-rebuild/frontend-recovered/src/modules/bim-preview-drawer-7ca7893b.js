import { _ as R, b as C, a as P, u as $ } from "../shared/runtime.js";
import { b as H } from "./bim-model-view-dbf77a11.js";
import { provide as l } from "vue";
import { computed as c } from "vue";
import { ref as b } from "vue";
import { watch as L } from "vue";
import { nextTick as x } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as S } from "vue";
import { unref as f } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as B } from "vue";
import { withCtx as I } from "vue";
import { Fragment as F } from "vue";
import { renderList as A } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as U } from "vue";
import { ElRadioGroup as z } from "element-plus";
import { ElRadioButton as q } from "element-plus";
import { vLoading as G } from "element-plus";
import { resolveComponent as M } from "vue";
import { normalizeStyle as J } from "vue";
import { isRef as K } from "vue";
import { b as O, _ as Q, a as W } from "./drawing-preview-fullscreen-dialog-60155503.js";
const X = { key: 2, class: "quick-operation-small" }, Y = { key: 0, class: "operate-left" }, Z = { __name: "drawing-preview-small-view", props: { boolBim: { type: Boolean, default: false }, serialNumber: { type: String, default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, drawingSN: { type: [String, Array] }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, projectType: { type: Number, default: void 0 } }, setup(e, { expose: V }) {
  const a = e;
  l("productId", c(() => a.productId)), l("productType", c(() => a.productType)), l("projectType", c(() => a.projectType)), l("serialNumber", c(() => a.serialNumber)), l("monomerId", c(() => a.monomerId)), l("isPreview", true), l("id", "small"), l("boolBim", c(() => a.boolBim));
  const t = b(), v = b(), N = b(false), d = b(false), r = b(), g = c(() => {
    var o;
    return Array.isArray(a.drawingSN) && ((o = a.drawingSN) == null ? void 0 : o.length);
  });
  l("multipleDrawing", g), l("drawingSN", r), L(() => r.value, () => {
    C(r.value) || x(() => {
      var o, i, p, w, u;
      a.boolBim ? ((o = t.value) == null || o.fetchDrawing(), (i = t.value) == null || i.reset()) : ((p = v.value) == null || p.fetchDrawing(), (w = t.value) == null || w.reset(), (u = v.value) == null || u.setScale(0.5));
    });
  });
  function _() {
    r.value = void 0;
  }
  function k() {
    g.value ? r.value = a.drawingSN[0] : x(() => {
      var o, i, p, w, u;
      a.boolBim ? ((o = t.value) == null || o.fetchDrawing(), (i = t.value) == null || i.reset()) : ((p = v.value) == null || p.fetchDrawing(), (w = t.value) == null || w.reset(), (u = v.value) == null || u.setScale(0.5));
    });
  }
  function n(o) {
    N.value = o;
  }
  function y() {
    d.value = true;
  }
  return V({ fetch: k, closeHandle: _ }), (o, i) => {
    const p = P, w = q, u = G;
    return m(), h("div", null, [e.boolBim ? D((m(), T(O, { key: 0, ref_key: "viewBimRef", ref: t, onChangeFileLoading: n, style: { overflow: "auto", height: "100%" } }, null, 512)), [[u, N.value]]) : S("", true), e.boolBim ? S("", true) : D((m(), T(f(Q), { key: 1, ref_key: "viewPdfRef", ref: v, onChangeFileLoading: n, style: { overflow: "auto", height: "100%" } }, null, 512)), [[u, N.value]]), e.boolBim ? S("", true) : (m(), h("div", X, [j("div", { class: "icon-box", onClick: y }, [B(p, { class: "icon", "icon-class": "fullscreen" })]), g.value ? (m(), h("div", Y, [B(f(z), { modelValue: r.value, "onUpdate:modelValue": i[0] || (i[0] = (s) => r.value = s), size: "default" }, { default: I(() => [(m(true), h(F, null, A(e.drawingSN, (s) => (m(), T(w, { key: s, value: s }, { default: I(() => [E(U(`${e.serialNumber}${s ? "_" + s : ""}`), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])])) : S("", true)])), B(f(W), { modelValue: d.value, "onUpdate:modelValue": i[1] || (i[1] = (s) => d.value = s), "bool-bim": e.boolBim, drawingSN: e.drawingSN, "cur-drawing-s-n": r.value, "serial-number": e.serialNumber, productId: e.productId, productType: e.productType, projectType: e.projectType, "monomer-id": e.monomerId }, null, 8, ["modelValue", "bool-bim", "drawingSN", "cur-drawing-s-n", "serial-number", "productId", "productType", "projectType", "monomer-id"])]);
  };
} }, ee = R(Z, [["__scopeId", "data-v-8d2d249a"]]);
const ae = { class: "model-drawer-container" }, oe = { __name: "bim-preview-drawer", props: { visible: { type: Boolean, default: false }, boolBim: { type: Boolean, default: false }, isBridge: { type: Boolean, default: false }, monomerId: { type: Number, default: void 0 }, areaId: { type: [Number, String], default: void 0 }, drawingSN: { type: [String, Array] }, serialNumber: { type: String }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, projectType: { type: Number, default: void 0 } }, emits: ["update:visible"], setup(e, { emit: V }) {
  const a = b(), t = b(), v = V, N = e, { visible: d, handleClose: r } = $({ emit: v, props: N, field: "visible", showHook: _, closeHook: k }), g = c(() => document.documentElement.clientHeight * 0.5);
  function _() {
    x(() => {
      var n;
      (n = t.value) == null || n.fetch();
    });
  }
  function k() {
    var n;
    (n = t.value) == null || n.closeHandle();
  }
  return (n, y) => {
    const o = M("common-drawer");
    return m(), T(o, { ref_key: "drawerRef", ref: a, title: "", modelValue: f(d), "onUpdate:modelValue": y[0] || (y[0] = (i) => K(d) ? d.value = i : null), direction: "btt", "with-header": false, "before-close": f(r), size: "50%", "custom-class": "model-drawer" }, { titleRight: I(() => y[1] || (y[1] = [])), content: I(() => [j("div", ae, [B(f(H), { "monomer-id": e.monomerId, "area-id": e.areaId, "serial-number": e.serialNumber, productId: e.productId, productType: e.productType, boolBim: e.boolBim, isBridge: e.isBridge, "is-preview": "", visible: f(d), class: "model", "max-height": g.value }, null, 8, ["monomer-id", "area-id", "serial-number", "productId", "productType", "boolBim", "isBridge", "visible", "max-height"]), B(f(ee), { ref_key: "drawingRef", ref: t, boolBim: e.boolBim, drawingSN: e.drawingSN, "serial-number": e.serialNumber, "monomer-id": e.monomerId, productId: e.productId, productType: e.productType, projectType: e.projectType, class: "drawing", style: J([{ position: "relative" }, { height: `${g.value}px` }]) }, null, 8, ["boolBim", "drawingSN", "serial-number", "monomer-id", "productId", "productType", "projectType", "style"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = R(oe, [["__scopeId", "data-v-42ec817d"]]);
export {
  ne as b
};
