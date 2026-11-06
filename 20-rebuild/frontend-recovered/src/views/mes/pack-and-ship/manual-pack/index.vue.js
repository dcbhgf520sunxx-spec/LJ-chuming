import { useRoute as q } from "vue-router";
import { ref as l } from "vue";
import { reactive as G } from "vue";
import { computed as A } from "vue";
import { provide as V } from "vue";
import { watch as M } from "vue";
import { nextTick as J } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as R } from "vue";
import { createVNode as u } from "vue";
import { unref as r } from "vue";
import { createBlock as N } from "vue";
import { createCommentVNode as F } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as K } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { ElBadge as Z } from "element-plus";
import { _ as ee, m as ae, bi as t, o as te, og as oe, i as S, b as E, aV as le, q as ne } from "../../../../shared/runtime.js";
import se from "./structure/index.vue.js";
import ie from "./auxiliary-material/index.vue.js";
import re from "./part/index.vue.js";
import ue from "./pack-list-drawer/index.vue.js";
import { o as de } from "../../../../modules/one-code-number-list-af2f89eb.js";
import "../../../../modules/manual-pack-695cccc1.js";
import "./structure/module/header.vue.js";
import "./auxiliary-material/module/header.vue.js";
import "./part/module/header.vue.js";
import "./chose-add-method-dialog/index.vue.js";
import "../../../../modules/index-828ab502.js";
const me = { class: "app-container manual-pack-wrapper" }, ce = { class: "filter-container manual-pack-common-header" }, pe = { class: "filter-left-box" }, ve = { class: "filter-right-box" }, fe = { __name: "index", setup(_e) {
  const h = q(), x = l(), { globalProjectId: c } = ae(["globalProjectId"]), p = l(t.STRUCTURE.V), I = l(), H = l(), T = l(), w = l(), v = l(false), k = l(), d = l([]), C = l([]), f = l({}), b = l(), _ = l(false), o = G({ [t.STRUCTURE.K]: {}, [t.MACHINE_PART.K]: {}, [t.AUXILIARY_MATERIAL.K]: {} }), L = A(() => {
    let a = 0;
    for (const e in o) a += o[e] ? Object.keys(o[e]).length : 0;
    return a;
  }), { maxHeight: P } = te({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"] });
  V("packData", o), V("permission", oe), V("projectId", c);
  const B = A(() => h.params);
  M(() => c.value, (a, e) => {
    S(a) && (o[t.STRUCTURE.K] = {}, o[t.MACHINE_PART.K] = {}, o[t.AUXILIARY_MATERIAL.K] = {});
  }), M(() => B, (a) => {
    if (S(a.value)) {
      f.value = { ...a.value, data: JSON.parse(a.value.data) }, b.value = a.value.id;
      const e = f.value.data;
      o[t.STRUCTURE.K] = e.artifactList && e.artifactList.reduce((i, s) => (i[s.id] = s, i), {}), o[t.MACHINE_PART.K] = e.partList && e.partList.reduce((i, s) => (i[s.id] = s, i), {}) || {}, o[t.AUXILIARY_MATERIAL.K] = e.auxiliaryMaterialList && e.auxiliaryMaterialList.reduce((i, s) => (i[s.id] = s, i), {}) || {}, J(() => {
        _.value = true;
      });
    }
  }, { immediate: true, deep: true });
  const X = A(() => {
    switch (p.value) {
      case t.STRUCTURE.V:
        return se;
      case t.MACHINE_PART.V:
        return re;
      case t.AUXILIARY_MATERIAL.V:
        return ie;
      default:
        return null;
    }
  }), Y = A(() => E(o[t.STRUCTURE.K]) && E(o[t.MACHINE_PART.K]) && E(o[t.AUXILIARY_MATERIAL.K]));
  function j() {
    o[t.STRUCTURE.K] = {}, o[t.MACHINE_PART.K] = {}, o[t.AUXILIARY_MATERIAL.K] = {}, x.value.refresh(), b.value = void 0, f.value = {};
  }
  function D(a, e) {
    a.boolOneCode ? (k.value = { row: a, packTypeK: e }, d.value = [], C.value = a.originNumberList, v.value = true) : y(a, e);
  }
  function O() {
    const { row: a, packTypeK: e } = k.value;
    a.numberList = d.value, a.productQuantity = d.value.length, v.value = false, y(a, e);
  }
  function y(a, e) {
    o[e][a.id] = { ...a };
  }
  return (a, e) => {
    const i = U("component-radio-button"), s = U("common-button"), z = Z, $ = U("common-dialog");
    return g(), Q("div", me, [R("div", null, [R("div", ce, [R("div", pe, [u(i, { modelValue: p.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => p.value = n), options: r(t).ENUM, disabledVal: [r(t).ENCLOSURE.V], type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "disabledVal"]), p.value !== r(t).AUXILIARY_MATERIAL.V ? (g(), N(le, { key: 0, modelValue: I.value, "onUpdate:modelValue": e[1] || (e[1] = (n) => I.value = n), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"])) : F("", true), u(r(ne), { modelValue: T.value, "onUpdate:modelValue": e[2] || (e[2] = (n) => T.value = n), default: false, clearable: "", "project-id": r(c), class: "filter-item" }, null, 8, ["modelValue", "project-id"])]), R("div", ve, [u(z, { value: L.value, max: 99, hidden: L.value < 1 }, { default: m(() => [u(s, { type: "primary", size: "default", disabled: Y.value, onClick: e[3] || (e[3] = (n) => _.value = true) }, { default: m(() => e[7] || (e[7] = [K("打包列表")])), _: 1, __: [7] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])])])]), (g(), N(W(X.value), { ref_key: "mainRef", ref: x, maxHeight: r(P), "project-id": r(c), "workshop-id": I.value, "monomer-id": T.value, "area-id": w.value, category: H.value, onAdd: D }, null, 40, ["maxHeight", "project-id", "workshop-id", "monomer-id", "area-id", "category"])), u(r(ue), { visible: _.value, "onUpdate:visible": e[4] || (e[4] = (n) => _.value = n), bagId: b.value, "edit-data": f.value, onHandleSuccess: j }, null, 8, ["visible", "bagId", "edit-data"]), u($, { title: "选择一物一码编号", modelValue: v.value, "onUpdate:modelValue": e[6] || (e[6] = (n) => v.value = n), center: false, "close-on-click-modal": false, width: "680px", "custom-class": "code-dialog" }, { titleRight: m(() => [u(s, { type: "primary", size: "default", onClick: O }, { default: m(() => e[8] || (e[8] = [K("确认")])), _: 1, __: [8] })]), default: m(() => [u(r(de), { modelValue: d.value, "onUpdate:modelValue": e[5] || (e[5] = (n) => d.value = n), list: C.value, maxHeight: 560 }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ye = ee(fe, [["__scopeId", "data-v-d08797e1"]]);
export {
  ye as default
};
