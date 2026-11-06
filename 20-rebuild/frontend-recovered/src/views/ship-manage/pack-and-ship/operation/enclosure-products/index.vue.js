import { ref as n } from "vue";
import { reactive as Ce } from "vue";
import { watch as N } from "vue";
import { computed as V } from "vue";
import { provide as w } from "vue";
import { onMounted as ge } from "vue";
import { nextTick as he } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as Z } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { unref as r } from "vue";
import { createBlock as X } from "vue";
import { createCommentVNode as Le } from "vue";
import { withDirectives as D } from "vue";
import { vShow as Y } from "vue";
import { withCtx as E } from "vue";
import { createTextVNode as ee } from "vue";
import { resolveDynamicComponent as Ue } from "vue";
import { Fragment as ye } from "vue";
import { renderList as Ne } from "vue";
import { toDisplayString as ke } from "vue";
import { ElBadge as Me } from "element-plus";
import { ElCheckbox as Oe } from "element-plus";
import { ElTag as Se } from "element-plus";
import { _ as Ke, m as xe, uc as t, m4 as ae, bw as d, o as Pe, i as te, cM as le, oV as He, od as k, ud as j, ue as Be, b as _ } from "../../../../../shared/runtime.js";
import { e as we } from "../../../../../modules/ship-manage-3066b2ed.js";
import Xe from "../pack-components/structure/index.vue.js";
import oe from "../pack-components/enclosure/index.vue.js";
import De from "../pack-components/auxiliary-material/index.vue.js";
import Ye from "../pack-components/part/index.vue.js";
import je from "../pack-components/box/index.vue.js";
import qe from "../pack-components/cell/index.vue.js";
import We from "../pack-components/pack-list-drawer/index.vue.js";
import ze from "../pack-components/components/monomer-select-area-tabs.vue.js";
import { a as Ge } from "../../../../../modules/index-8356a01a.js";
import { o as Qe } from "../../../../../modules/one-code-number-list-af2f89eb.js";
import "../../../../../modules/manual-pack-aab80853.js";
import "../pack-components/structure/module/header.vue.js";
import "../pack-components/enclosure/module/header.vue.js";
import "../pack-components/auxiliary-material/module/header.vue.js";
import "../pack-components/part/module/header.vue.js";
import "../../../../../modules/manual-pack-01ad3a57.js";
import "../pack-components/box/module/header.vue.js";
import "../pack-components/cell/module/header.vue.js";
import "../pack-components/components/chose-pack-operation-form.vue.js";
import "../../../../../modules/index-828ab502.js";
import "../../../../../modules/manuf-warehouse-select-bae65ecc.js";
import "../../../../../modules/PicUpload-8580ccfc.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
const $e = { class: "app-container manual-pack-wrapper" }, Fe = { class: "head-container" }, Je = { class: "manual-pack-common-header", style: { display: "flex", "justify-content": "space-between" } }, Ze = { class: "qhseNumbers-dialog" }, ea = { __name: "index", setup(aa) {
  const p = n(), { globalProjectId: A, globalProject: g } = xe(["globalProjectId", "globalProject"]), i = n(t.ENCLOSURE.V), M = n(ae.HOMEMADE.V), O = n(), h = n(), S = n(), L = n(), K = n(), q = n([]), x = n([]), ne = n({}), P = n(false), W = n(), v = n([]), R = n([]), b = n(false), T = n(false), U = n({}), H = n(), y = n(false), l = Ce({ [t.STRUCTURE.K]: {}, [t.ENCLOSURE.K]: {}, [t.MACHINE_PART.K]: {}, [t.AUXILIARY_MATERIAL.K]: {}, [d.BOX.K]: {}, [d.MACHINE_PART.K]: {} }), B = n(false), z = n([]), f = n();
  N(() => g.value, (a) => {
    var e;
    f.value = void 0, f.value = (e = g.value) == null ? void 0 : e.productCategory, se();
  }, { immediate: true, deep: true });
  const G = V(() => {
    let a = 0;
    for (const e in l) a += l[e] ? Object.keys(l[e]).length : 0;
    return a;
  }), { maxHeight: ue } = Pe({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"], paginate: true });
  w("packData", l), w("permission", we), w("projectId", A), N(() => A.value, (a, e) => {
    te(a) && (l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[d.BOX.K] = {}, l[d.MACHINE_PART.K] = {});
  }, { immediate: true, deep: true }), N(() => i.value, (a) => {
    K.value = K.value ? K.value : A.value, i.value === t.ENCLOSURE.V && (h.value = void 0, re());
  }), ge(() => {
    const a = le.get("ROUTER_PARAMS");
    if (te(a)) {
      U.value = { ...a, data: JSON.parse(a.data) }, H.value = a.id;
      const e = U.value.data;
      l[t.STRUCTURE.K] = e.artifactList && e.artifactList.reduce((o, s) => (o[s.id] = s, o), {}), l[t.MACHINE_PART.K] = e.partList && e.partList.reduce((o, s) => (o[s.id] = s, o), {}) || {}, l[t.ENCLOSURE.K] = e.enclosureList && e.enclosureList.reduce((o, s) => (o[s.id] = s, o), {}) || {}, l[t.AUXILIARY_MATERIAL.K] = e.auxiliaryMaterialList && e.auxiliaryMaterialList.reduce((o, s) => (o[s.id] = s, o), {}) || {}, l[d.BOX.K] = e.boxList && e.boxList.reduce((o, s) => (o[s.id] = s, o), {}) || {}, l[d.MACHINE_PART.K] = e.partList && e.partList.reduce((o, s) => (o[s.id] = s, o), {}) || {}, he(() => {
        y.value = true, le.remove("ROUTER_PARAMS");
      });
    }
  }), N([h, S], () => {
    var a;
    (a = p == null ? void 0 : p.value) == null || a.refresh();
  });
  async function se() {
    if (!(!g.value || i.value === t.AUXILIARY_MATERIAL.V)) try {
      const { content: a } = await He({ boolEnabledEnum: true, type: f.value === k.BOX.V ? j.BRIDGE_WORKSHOP.V : i.value === t.ENCLOSURE.V ? j.ENCLOSURE_WORKSHOP.V : j.MES_WORKSHOP.V });
      console.log(a, "content"), q.value = a || [];
    } catch (a) {
      console.log("获取车间信息失败", a);
    }
  }
  async function re() {
    if (!(!g.value || i.value === t.STRUCTURE.V || i.value === t.MACHINE_PART.V)) try {
      const a = await Be(A.value);
      x.value = a || [];
    } catch (a) {
      console.log("获取围护的批次失败", a);
    }
  }
  V(() => {
    switch (i.value) {
      case t.STRUCTURE.V:
        return Xe;
      case t.ENCLOSURE.V:
        return oe;
      case t.MACHINE_PART.V:
        return Ye;
      case t.AUXILIARY_MATERIAL.V:
        return De;
      default:
        return null;
    }
  });
  const ie = V(() => {
    switch (i.value) {
      case d.BOX.V:
        return je;
      case d.MACHINE_PART.V:
        return qe;
      default:
        return null;
    }
  }), de = V(() => _(l[t.STRUCTURE.K]) && _(l[t.ENCLOSURE.K]) && _(l[t.MACHINE_PART.K]) && _(l[t.AUXILIARY_MATERIAL.K])), ce = V(() => _(l[d.BOX.K]) && _(l[d.MACHINE_PART.K]));
  function me() {
    l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[d.MACHINE_PART.K] = {}, l[d.BOX.K] = {}, p.value.refresh(), H.value = void 0, U.value = {};
  }
  function pe(a, e) {
    a.boolOneCode ? (W.value = { row: a, packTypeK: e }, R.value = a.originNumberList, T.value = false, v.value = R.value.map((o) => o.number), Q()) : $(a, e);
  }
  function ve(a) {
    B.value = true, z.value = a.qhseNumbers || [];
  }
  function fe() {
    b.value ? v.value = R.value.map((a) => a.number) : v.value = [];
  }
  function Ee(a) {
    a.length === 0 ? (T.value = false, b.value = false) : a.length === R.value.length ? (T.value = false, b.value = true) : T.value = true;
  }
  function Q() {
    const { row: a, packTypeK: e } = W.value;
    a.numberList = v.value, a.productQuantity = v.value.length, P.value = false, $(a, e);
  }
  function $(a, e) {
    l[e][a.id] = { ...a };
  }
  function Ae(a) {
    h.value = a == null ? void 0 : a.monomerId, S.value = a == null ? void 0 : a.areaId;
  }
  function _e(a) {
    var o;
    const { name: e } = a;
    L.value = e, (o = p == null ? void 0 : p.value) == null || o.refresh();
  }
  return (a, e) => {
    const o = I("common-radio-button"), s = I("component-radio-button"), Re = I("common-select"), F = I("common-button"), be = Me, Te = Oe, J = I("common-dialog"), Ve = Se;
    return C(), Z("div", $e, [m("div", Fe, [m("div", Je, [m("div", null, [m("div", null, [c(o, { modelValue: M.value, "onUpdate:modelValue": e[0] || (e[0] = (u) => M.value = u), options: r(ae).ENUM, class: "filter-item", type: "enum" }, null, 8, ["modelValue", "options"]), f.value === r(k).BOX.V ? (C(), X(s, { key: 0, modelValue: i.value, "onUpdate:modelValue": e[1] || (e[1] = (u) => i.value = u), disabledVal: [r(d).AUXILIARY_MATERIAL.V], options: r(d).ENUM, class: "filter-item", default: "", size: "small", type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"])) : Le("", true), D(c(Re, { modelValue: O.value, "onUpdate:modelValue": e[2] || (e[2] = (u) => O.value = u), "data-structure": { key: "id", label: "name", value: "id" }, options: q.value, class: "filter-item", clearable: "", placeholder: "请选择车间", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"]), [[Y, i.value !== r(t).AUXILIARY_MATERIAL.V]])])]), c(be, { hidden: G.value < 1, max: 99, value: G.value }, { default: E(() => [c(F, { disabled: f.value === r(k).BOX.V ? ce.value : de.value, size: "default", type: "primary", onClick: e[3] || (e[3] = (u) => y.value = true) }, { default: E(() => e[10] || (e[10] = [ee(" 打包列表 ")])), _: 1, __: [10] }, 8, ["disabled"])]), _: 1 }, 8, ["hidden", "value"])]), D(m("div", null, [c(ze, { default: false, productType: i.value, "project-id": r(A), needConvert: "", onChange: Ae }, null, 8, ["productType", "project-id"])], 512), [[Y, i.value === r(t).STRUCTURE.V || i.value === r(t).MACHINE_PART.V]]), D(m("div", null, [c(r(Ge), { modelValue: L.value, "onUpdate:modelValue": e[4] || (e[4] = (u) => L.value = u), "area-info": x.value, "default-tab": ne.value, "show-type": 2, class: "filter-item", style: { width: "100%" }, onTabClick: _e }, null, 8, ["modelValue", "area-info", "default-tab"])], 512), [[Y, i.value === r(t).ENCLOSURE.V && x.value.length]])]), (C(), X(Ue(f.value === r(k).BOX.V ? ie.value : r(oe)), { ref_key: "mainRef", ref: p, "area-id": i.value === r(t).ENCLOSURE.V ? L.value : S.value, manufactureType: M.value, maxHeight: r(ue) - 20, "monomer-id": h.value, "project-id": r(A), "workshop-id": O.value, onAdd: pe, onQhseNumbers: ve }, null, 40, ["area-id", "manufactureType", "maxHeight", "monomer-id", "project-id", "workshop-id"])), c(r(We), { visible: y.value, "onUpdate:visible": e[5] || (e[5] = (u) => y.value = u), bagId: H.value, "edit-data": U.value, "type-val": f.value, onHandleSuccess: me }, null, 8, ["visible", "bagId", "edit-data", "type-val"]), c(J, { modelValue: P.value, "onUpdate:modelValue": e[8] || (e[8] = (u) => P.value = u), center: false, "close-on-click-modal": false, "custom-class": "code-dialog", title: "选择一物一码编号", width: "680px" }, { titleRight: E(() => [c(F, { size: "default", type: "primary", onClick: Q }, { default: E(() => e[11] || (e[11] = [ee("确认")])), _: 1, __: [11] }), m("span", null, [c(Te, { modelValue: b.value, "onUpdate:modelValue": e[6] || (e[6] = (u) => b.value = u), indeterminate: T.value, border: "", label: "全选", size: "default", style: { height: "29px" }, onChange: fe }, null, 8, ["modelValue", "indeterminate"])])]), default: E(() => [c(r(Qe), { modelValue: v.value, "onUpdate:modelValue": e[7] || (e[7] = (u) => v.value = u), color: "#ffff00", list: R.value, maxHeight: 560, onChange: Ee }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"]), c(J, { modelValue: B.value, "onUpdate:modelValue": e[9] || (e[9] = (u) => B.value = u), center: false, "close-on-click-modal": false, title: "问题码号列表", width: "680px" }, { default: E(() => [m("div", Ze, [(C(true), Z(ye, null, Ne(z.value, (u, Ie) => (C(), X(Ve, { key: Ie, effect: "plain", size: "large", type: "danger" }, { default: E(() => [m("span", null, ke(u), 1)]), _: 2 }, 1024))), 128))])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Ua = Ke(ea, [["__scopeId", "data-v-4667740b"]]);
export {
  Ua as default
};
