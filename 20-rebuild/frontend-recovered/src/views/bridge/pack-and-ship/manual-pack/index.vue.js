import { useRoute as q } from "vue-router";
import { ref as l } from "vue";
import { reactive as G } from "vue";
import { computed as A } from "vue";
import { provide as x } from "vue";
import { watch as C } from "vue";
import { nextTick as J } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as u } from "vue";
import { unref as d } from "vue";
import { createBlock as N } from "vue";
import { createCommentVNode as F } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as K } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { ElBadge as Z } from "element-plus";
import { _ as ee, m as ae, bw as t, o as te, i as U, b as k, aV as oe, q as le } from "../../../../shared/runtime.js";
import { n as ne } from "../../../../modules/bridge-86f96a4f.js";
import se from "./box/index.vue.js";
import ie from "./cell/index.vue.js";
import de from "./auxiliary-material/index.vue.js";
import ue from "./pack-list-drawer/index.vue.js";
import { o as re } from "../../../../modules/one-code-number-list-d40dfaf0.js";
import "../../../../modules/manual-pack-01ad3a57.js";
import "./box/module/header.vue.js";
import "./cell/module/header.vue.js";
import "./chose-add-method-dialog/index.vue.js";
const ce = { class: "app-container manual-pack-wrapper" }, me = { class: "filter-container manual-pack-common-header" }, pe = { class: "filter-left-box" }, ve = { class: "filter-right-box" }, fe = { __name: "index", setup(_e) {
  const X = q(), y = l(), { globalProjectId: p } = ae(["globalProjectId"]), v = l(t.BOX.V), b = l(), h = l(), V = l(), w = l(), f = l(false), M = l(), r = l([]), T = l([]), c = l({}), g = l(), _ = l(false), o = G({ [t.BOX.K]: {}, [t.MACHINE_PART.K]: {}, [t.AUXILIARY_MATERIAL.K]: {} }), E = A(() => {
    let a = 0;
    for (const e in o) a += o[e] ? Object.keys(o[e]).length : 0;
    return a;
  }), { maxHeight: H } = te({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"] });
  x("packData", o), x("permission", ne), x("projectId", p);
  const P = A(() => X.params);
  C(() => p.value, (a, e) => {
    U(a) && (o[t.BOX.K] = {}, o[t.MACHINE_PART.K] = {}, o[t.AUXILIARY_MATERIAL.K] = {});
  }), C(() => P, (a) => {
    if (U(a.value)) {
      c.value = { ...a.value, data: JSON.parse(a.value.data) }, g.value = a.value.id;
      const e = c.value.data;
      o[t.BOX.K] = e.boxList && e.boxList.reduce((i, s) => (i[s.id] = s, i), {}), o[t.MACHINE_PART.K] = e.partList && e.partList.reduce((i, s) => (i[s.id] = s, i), {}) || {}, o[t.AUXILIARY_MATERIAL.K] = e.auxiliaryMaterialList && e.auxiliaryMaterialList.reduce((i, s) => (i[s.id] = s, i), {}) || {}, J(() => {
        _.value = true;
      }), console.log(a.value, c.value, "editData");
    }
  }, { immediate: true, deep: true });
  const O = A(() => {
    switch (v.value) {
      case t.BOX.V:
        return se;
      case t.MACHINE_PART.V:
        return ie;
      case t.AUXILIARY_MATERIAL.V:
        return de;
      default:
        return null;
    }
  }), Y = A(() => k(o[t.BOX.K]) && k(o[t.MACHINE_PART.K]) && k(o[t.AUXILIARY_MATERIAL.K]));
  function D() {
    o[t.BOX.K] = {}, o[t.MACHINE_PART.K] = {}, o[t.AUXILIARY_MATERIAL.K] = {}, y.value.refresh(), g.value = void 0, c.value = {};
  }
  function j(a, e) {
    a.boolOneCode ? (M.value = { row: a, packTypeK: e }, r.value = [], T.value = a.originNumberList, f.value = true) : B(a, e);
  }
  function S() {
    const { row: a, packTypeK: e } = M.value;
    a.numberList = r.value, a.productQuantity = r.value.length, f.value = false, B(a, e);
  }
  function B(a, e) {
    o[e][a.id] = { ...a };
  }
  return (a, e) => {
    const i = R("component-radio-button"), s = R("common-button"), z = Z, $ = R("common-dialog");
    return L(), Q("div", ce, [I("div", null, [I("div", me, [I("div", pe, [u(i, { modelValue: v.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => v.value = n), options: d(t).ENUM, disabledVal: [d(t).AUXILIARY_MATERIAL.V], type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "disabledVal"]), v.value !== d(t).AUXILIARY_MATERIAL.V ? (L(), N(d(oe), { key: 0, modelValue: b.value, "onUpdate:modelValue": e[1] || (e[1] = (n) => b.value = n), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"])) : F("", true), u(d(le), { modelValue: V.value, "onUpdate:modelValue": e[2] || (e[2] = (n) => V.value = n), default: false, clearable: "", "project-id": d(p), class: "filter-item" }, null, 8, ["modelValue", "project-id"])]), I("div", ve, [u(z, { value: E.value, max: 99, hidden: E.value < 1 }, { default: m(() => [u(s, { type: "primary", size: "default", disabled: Y.value, onClick: e[3] || (e[3] = (n) => _.value = true) }, { default: m(() => e[7] || (e[7] = [K("打包列表")])), _: 1, __: [7] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])])])]), (L(), N(W(O.value), { ref_key: "mainRef", ref: y, maxHeight: d(H), "project-id": d(p), "workshop-id": b.value, "monomer-id": V.value, "area-id": w.value, category: h.value, onAdd: j }, null, 40, ["maxHeight", "project-id", "workshop-id", "monomer-id", "area-id", "category"])), u(d(ue), { visible: _.value, "onUpdate:visible": e[4] || (e[4] = (n) => _.value = n), bagId: g.value, "edit-data": c.value, onHandleSuccess: D }, null, 8, ["visible", "bagId", "edit-data"]), u($, { title: "选择一物一码编号", modelValue: f.value, "onUpdate:modelValue": e[6] || (e[6] = (n) => f.value = n), center: false, "close-on-click-modal": false, width: "680px", "custom-class": "code-dialog" }, { titleRight: m(() => [u(s, { type: "primary", size: "default", onClick: S }, { default: m(() => e[8] || (e[8] = [K("确认")])), _: 1, __: [8] })]), default: m(() => [u(d(re), { modelValue: r.value, "onUpdate:modelValue": e[5] || (e[5] = (n) => r.value = n), list: T.value, maxHeight: 560 }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Ee = ee(fe, [["__scopeId", "data-v-4cd8c8ed"]]);
export {
  Ee as default
};
