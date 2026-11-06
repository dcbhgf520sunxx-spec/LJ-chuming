import { ref as l } from "vue";
import { reactive as Re } from "vue";
import { watch as U } from "vue";
import { computed as b } from "vue";
import { provide as P } from "vue";
import { onMounted as Te } from "vue";
import { nextTick as Ie } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as d } from "vue";
import { unref as r } from "vue";
import { withDirectives as H } from "vue";
import { vShow as B } from "vue";
import { withCtx as v } from "vue";
import { createTextVNode as F } from "vue";
import { createBlock as J } from "vue";
import { resolveDynamicComponent as Ve } from "vue";
import { Fragment as he } from "vue";
import { renderList as Ce } from "vue";
import { toDisplayString as Ue } from "vue";
import { ElBadge as be } from "element-plus";
import { ElCheckbox as ge } from "element-plus";
import { ElTag as Le } from "element-plus";
import { _ as ye, m as Ne, uc as t, o as ke, i as Z, cM as ee, oV as Se, od as Me, ud as D, ue as xe, b as y, ng as Oe } from "../../../../shared/runtime.js";
import { b as Ke } from "../../../../modules/ship-manage-3066b2ed.js";
import we from "./structure/index.vue.js";
import Pe from "./enclosure/index.vue.js";
import He from "./auxiliary-material/index.vue.js";
import Be from "./part/index.vue.js";
import De from "./pack-list-drawer/index.vue.js";
import Xe from "./components/monomer-select-area-tabs.vue.js";
import { a as je } from "../../../../modules/index-8356a01a.js";
import { o as Ye } from "../../../../modules/one-code-number-list-af2f89eb.js";
import "../../../../modules/manual-pack-aab80853.js";
import "./structure/module/header.vue.js";
import "./enclosure/module/header.vue.js";
import "./auxiliary-material/module/header.vue.js";
import "./part/module/header.vue.js";
import "./chose-add-method-dialog/index.vue.js";
import "../../../../modules/index-828ab502.js";
import "../../../../modules/convert-product-type-fcb585d7.js";
const qe = { class: "app-container manual-pack-wrapper" }, We = { class: "head-container" }, ze = { class: "manual-pack-common-header", style: { display: "flex", "justify-content": "space-between" } }, Ge = { class: "qhseNumbers-dialog" }, $e = { __name: "index", setup(Qe) {
  const c = l(), { globalProjectId: f, globalProject: T } = Ne(["globalProjectId", "globalProject"]), s = l(), N = l(), I = l(), k = l(), S = l(), V = l(), M = l(), X = l([]), x = l([]), ae = l({}), O = l(false), j = l(), p = l([]), E = l([]), _ = l(false), A = l(false), h = l({}), K = l(), C = l(false), o = Re({ [t.STRUCTURE.K]: {}, [t.ENCLOSURE.K]: {}, [t.MACHINE_PART.K]: {}, [t.AUXILIARY_MATERIAL.K]: {} }), w = l(false), Y = l([]), R = l();
  U(() => T.value, (e) => {
    var a;
    s.value = void 0, R.value = void 0, R.value = (a = T.value) == null ? void 0 : a.productCategory;
  }, { immediate: true, deep: true });
  const te = b(() => {
    switch (R.value) {
      case t.STRUCTURE.V:
        return [t.ENCLOSURE.V];
      case t.ENCLOSURE.V:
        return [t.STRUCTURE.V, t.MACHINE_PART.V];
      case t.STRUCTURE.V + t.ENCLOSURE.V:
        return [];
      default:
        return [];
    }
  }), q = b(() => {
    let e = 0;
    for (const a in o) e += o[a] ? Object.keys(o[a]).length : 0;
    return e;
  }), { maxHeight: le } = ke({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"], paginate: true, extraHeight: 20 });
  P("packData", o), P("permission", Ke), P("projectId", f), U(() => f.value, (e, a) => {
    Z(e) && (o[t.STRUCTURE.K] = {}, o[t.ENCLOSURE.K] = {}, o[t.MACHINE_PART.K] = {}, o[t.AUXILIARY_MATERIAL.K] = {});
  }, { immediate: true, deep: true }), U(() => s.value, (e) => {
    M.value = M.value ? M.value : f.value, s.value === t.ENCLOSURE.V && (I.value = void 0, ne()), oe();
  }), Te(() => {
    const e = ee.get("EDIT_SHIP_MANAGE_MANUAL_PACK");
    if (Z(e)) {
      h.value = { ...e, data: JSON.parse(e.data) }, K.value = e.id;
      const a = h.value.data;
      o[t.STRUCTURE.K] = a.artifactList && a.artifactList.reduce((n, i) => (n[i.id] = i, n), {}), o[t.MACHINE_PART.K] = a.partList && a.partList.reduce((n, i) => (n[i.id] = i, n), {}) || {}, o[t.ENCLOSURE.K] = a.enclosureList && a.enclosureList.reduce((n, i) => (n[i.id] = i, n), {}) || {}, o[t.AUXILIARY_MATERIAL.K] = a.auxiliaryMaterialList && a.auxiliaryMaterialList.reduce((n, i) => (n[i.id] = i, n), {}) || {}, Ie(() => {
        C.value = true, ee.remove("EDIT_SHIP_MANAGE_MANUAL_PACK");
      });
    }
  }), U([I, k, S], () => {
    var e;
    (e = c == null ? void 0 : c.value) == null || e.refresh();
  });
  async function oe() {
    if (!(!T.value || s.value === t.AUXILIARY_MATERIAL.V)) try {
      const { content: e } = await Se({ boolEnabledEnum: true, type: R.value === Me.BOX.V ? D.BRIDGE_WORKSHOP.V : s.value === t.ENCLOSURE.V ? D.ENCLOSURE_WORKSHOP.V : D.MES_WORKSHOP.V });
      console.log(e, "content"), X.value = e || [];
    } catch (e) {
      console.log("获取车间信息失败", e);
    }
  }
  async function ne() {
    if (!(!T.value || s.value === t.STRUCTURE.V || s.value === t.MACHINE_PART.V)) try {
      const e = await xe(f.value);
      x.value = e || [];
    } catch (e) {
      console.log("获取围护的批次失败", e);
    }
  }
  const ue = b(() => {
    switch (s.value) {
      case t.STRUCTURE.V:
        return we;
      case t.ENCLOSURE.V:
        return Pe;
      case t.MACHINE_PART.V:
        return Be;
      case t.AUXILIARY_MATERIAL.V:
        return He;
      default:
        return null;
    }
  }), se = b(() => y(o[t.STRUCTURE.K]) && y(o[t.ENCLOSURE.K]) && y(o[t.MACHINE_PART.K]) && y(o[t.AUXILIARY_MATERIAL.K]));
  function re() {
    o[t.STRUCTURE.K] = {}, o[t.ENCLOSURE.K] = {}, o[t.MACHINE_PART.K] = {}, o[t.AUXILIARY_MATERIAL.K] = {}, c.value.refresh(), K.value = void 0, h.value = {};
  }
  function ie(e, a) {
    e.boolOneCode ? (j.value = { row: e, packTypeK: a }, E.value = e.originNumberList, A.value = false, p.value = E.value.map((n) => n.number), W()) : z(e, a);
  }
  function de(e) {
    w.value = true, Y.value = e.qhseNumbers || [];
  }
  function ce() {
    _.value ? p.value = E.value.map((e) => e.number) : p.value = [];
  }
  function me(e) {
    e.length === 0 ? (A.value = false, _.value = false) : e.length === E.value.length ? (A.value = false, _.value = true) : A.value = true;
  }
  function W() {
    const { row: e, packTypeK: a } = j.value;
    e.numberList = p.value, e.productQuantity = p.value.length, O.value = false, z(e, a);
  }
  function z(e, a) {
    o[a][e.id] = { ...e };
  }
  function pe(e) {
    I.value = e == null ? void 0 : e.monomerId, k.value = e == null ? void 0 : e.areaId, S.value = e == null ? void 0 : e.areaBatchId;
  }
  function ve(e) {
    var n;
    const { name: a } = e;
    V.value = a, (n = c == null ? void 0 : c.value) == null || n.refresh();
  }
  return (e, a) => {
    const n = g("component-radio-button"), i = g("common-select"), G = g("common-button"), fe = be, Ee = ge, $ = g("common-dialog"), _e = Le;
    return L(), Q("div", qe, [m("div", We, [m("div", ze, [m("div", null, [d(n, { modelValue: s.value, "onUpdate:modelValue": a[0] || (a[0] = (u) => s.value = u), options: r(t).ENUM, unshowVal: te.value || [], default: "", type: "enum", size: "small", class: "filter-item" }, null, 8, ["modelValue", "options", "unshowVal"]), H(d(i, { modelValue: N.value, "onUpdate:modelValue": a[1] || (a[1] = (u) => N.value = u), options: X.value, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择车间" }, null, 8, ["modelValue", "options"]), [[B, s.value !== r(t).AUXILIARY_MATERIAL.V]])]), d(fe, { value: q.value, max: 99, hidden: q.value < 1 }, { default: v(() => [d(G, { type: "primary", size: "mini", disabled: se.value, onClick: a[2] || (a[2] = (u) => C.value = true) }, { default: v(() => a[9] || (a[9] = [F(" 打包列表 ")])), _: 1, __: [9] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])]), H(m("div", null, [d(Xe, { "project-id": r(f), onChange: pe, default: false, productType: s.value, areaType: r(Oe).STRUCTURE.V, needConvert: "" }, null, 8, ["project-id", "productType", "areaType"])], 512), [[B, s.value === r(t).STRUCTURE.V || s.value === r(t).MACHINE_PART.V || s.value === r(t).AUXILIARY_MATERIAL.V]]), H(m("div", null, [d(r(je), { class: "filter-item", style: { width: "100%" }, modelValue: V.value, "onUpdate:modelValue": a[3] || (a[3] = (u) => V.value = u), "area-info": x.value, "default-tab": ae.value, "show-type": 2, onTabClick: ve }, null, 8, ["modelValue", "area-info", "default-tab"])], 512), [[B, s.value === r(t).ENCLOSURE.V && x.value.length]])]), (L(), J(Ve(ue.value), { ref_key: "mainRef", ref: c, maxHeight: r(le), "project-id": r(f), "workshop-id": N.value, "monomer-id": I.value, "areaBatch-id": S.value, "area-id": s.value === r(t).ENCLOSURE.V ? V.value : k.value, onAdd: ie, onQhseNumbers: de }, null, 40, ["maxHeight", "project-id", "workshop-id", "monomer-id", "areaBatch-id", "area-id"])), d(r(De), { visible: C.value, "onUpdate:visible": a[4] || (a[4] = (u) => C.value = u), bagId: K.value, "type-val": R.value, "edit-data": h.value, onHandleSuccess: re }, null, 8, ["visible", "bagId", "type-val", "edit-data"]), d($, { title: "选择一物一码编号", modelValue: O.value, "onUpdate:modelValue": a[7] || (a[7] = (u) => O.value = u), center: false, "close-on-click-modal": false, width: "680px", "custom-class": "code-dialog" }, { titleRight: v(() => [d(G, { type: "primary", size: "default", onClick: W }, { default: v(() => a[10] || (a[10] = [F("确认")])), _: 1, __: [10] }), m("span", null, [d(Ee, { modelValue: _.value, "onUpdate:modelValue": a[5] || (a[5] = (u) => _.value = u), indeterminate: A.value, label: "全选", size: "default", border: "", style: { height: "29px" }, onChange: ce }, null, 8, ["modelValue", "indeterminate"])])]), default: v(() => [d(r(Ye), { modelValue: p.value, "onUpdate:modelValue": a[6] || (a[6] = (u) => p.value = u), list: E.value, color: "#ffff00", maxHeight: 560, onChange: me }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"]), d($, { title: "问题码号列表", modelValue: w.value, "onUpdate:modelValue": a[8] || (a[8] = (u) => w.value = u), center: false, "close-on-click-modal": false, width: "680px" }, { default: v(() => [m("div", Ge, [(L(true), Q(he, null, Ce(Y.value, (u, Ae) => (L(), J(_e, { key: Ae, type: "danger", size: "large", effect: "plain" }, { default: v(() => [m("span", null, Ue(u), 1)]), _: 2 }, 1024))), 128))])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Ea = ye($e, [["__scopeId", "data-v-c2ae4100"]]);
export {
  Ea as default
};
