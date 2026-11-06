import { ref as n } from "vue";
import { reactive as Te } from "vue";
import { watch as k } from "vue";
import { computed as b } from "vue";
import { provide as X } from "vue";
import { onMounted as be } from "vue";
import { nextTick as Ve } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as J } from "vue";
import { createElementVNode as m } from "vue";
import { unref as i } from "vue";
import { createBlock as D } from "vue";
import { createCommentVNode as Ce } from "vue";
import { withDirectives as N } from "vue";
import { vShow as M } from "vue";
import { createVNode as c } from "vue";
import { withCtx as A } from "vue";
import { createTextVNode as Z } from "vue";
import { resolveDynamicComponent as ge } from "vue";
import { Fragment as he } from "vue";
import { renderList as Le } from "vue";
import { toDisplayString as Ue } from "vue";
import { ElBadge as ke } from "element-plus";
import { ElCheckbox as ye } from "element-plus";
import { ElTag as Ne } from "element-plus";
import { _ as Me, m as Se, uc as t, bw as d, o as Ke, i as ee, cM as ae, oV as Oe, od as S, ud as Y, ue as xe, b as E } from "../../../../../shared/runtime.js";
import { c as Pe } from "../../../../../modules/ship-manage-3066b2ed.js";
import He from "../pack-components/structure/index.vue.js";
import we from "../pack-components/enclosure/index.vue.js";
import Be from "../pack-components/auxiliary-material/index.vue.js";
import Xe from "../pack-components/part/index.vue.js";
import De from "../pack-components/box/index.vue.js";
import Ye from "../pack-components/cell/index.vue.js";
import je from "../pack-components/pack-list-drawer/index.vue.js";
import qe from "../pack-components/components/monomer-select-area-tabs.vue.js";
import { a as We } from "../../../../../modules/index-8356a01a.js";
import { o as ze } from "../../../../../modules/one-code-number-list-af2f89eb.js";
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
const Ge = { class: "app-container manual-pack-wrapper" }, Qe = { class: "head-container" }, $e = { class: "manual-pack-common-header", style: { display: "flex", "justify-content": "space-between" } }, Fe = { class: "qhseNumbers-dialog" }, Je = { __name: "index", setup(Ze) {
  const p = n(), { globalProjectId: _, globalProject: C } = Se(["globalProjectId", "globalProject"]), s = n(t.AUXILIARY_MATERIAL.V), K = n(), g = n(), O = n(), h = n(), x = n(), j = n([]), P = n([]), te = n({}), H = n(false), q = n(), v = n([]), R = n([]), I = n(false), T = n(false), L = n({}), w = n(), U = n(false), l = Te({ [t.STRUCTURE.K]: {}, [t.ENCLOSURE.K]: {}, [t.MACHINE_PART.K]: {}, [t.AUXILIARY_MATERIAL.K]: {}, [d.BOX.K]: {}, [d.MACHINE_PART.K]: {} }), B = n(false), W = n([]), f = n();
  k(() => C.value, (e) => {
    var a;
    f.value = void 0, f.value = (a = C.value) == null ? void 0 : a.productCategory;
  }, { immediate: true, deep: true });
  const z = b(() => {
    let e = 0;
    for (const a in l) e += l[a] ? Object.keys(l[a]).length : 0;
    return e;
  }), { maxHeight: le } = Ke({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"], paginate: true });
  X("packData", l), X("permission", Pe), X("projectId", _), k(() => _.value, (e, a) => {
    ee(e) && (l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[d.BOX.K] = {}, l[d.MACHINE_PART.K] = {});
  }, { immediate: true, deep: true }), k(() => s.value, (e) => {
    x.value = x.value ? x.value : _.value, s.value === t.ENCLOSURE.V && (g.value = void 0, ne()), oe();
  }), be(() => {
    const e = ae.get("ROUTER_PARAMS");
    if (ee(e)) {
      L.value = { ...e, data: JSON.parse(e.data) }, w.value = e.id;
      const a = L.value.data;
      l[t.STRUCTURE.K] = a.artifactList && a.artifactList.reduce((o, u) => (o[u.id] = u, o), {}), l[t.MACHINE_PART.K] = a.partList && a.partList.reduce((o, u) => (o[u.id] = u, o), {}) || {}, l[t.ENCLOSURE.K] = a.enclosureList && a.enclosureList.reduce((o, u) => (o[u.id] = u, o), {}) || {}, l[t.AUXILIARY_MATERIAL.K] = a.auxiliaryMaterialList && a.auxiliaryMaterialList.reduce((o, u) => (o[u.id] = u, o), {}) || {}, l[d.BOX.K] = a.boxList && a.boxList.reduce((o, u) => (o[u.id] = u, o), {}) || {}, l[d.MACHINE_PART.K] = a.partList && a.partList.reduce((o, u) => (o[u.id] = u, o), {}) || {}, Ve(() => {
        U.value = true, ae.remove("ROUTER_PARAMS");
      });
    }
  }), k([g, O], () => {
    var e;
    (e = p == null ? void 0 : p.value) == null || e.refresh();
  });
  async function oe() {
    if (!(!C.value || s.value === t.AUXILIARY_MATERIAL.V)) try {
      const { content: e } = await Oe({ boolEnabledEnum: true, type: f.value === S.BOX.V ? Y.BRIDGE_WORKSHOP.V : s.value === t.ENCLOSURE.V ? Y.ENCLOSURE_WORKSHOP.V : Y.MES_WORKSHOP.V });
      console.log(e, "content"), j.value = e || [];
    } catch (e) {
      console.log("获取车间信息失败", e);
    }
  }
  async function ne() {
    if (!(!C.value || s.value === t.STRUCTURE.V || s.value === t.MACHINE_PART.V)) try {
      const e = await xe(_.value);
      P.value = e || [];
    } catch (e) {
      console.log("获取围护的批次失败", e);
    }
  }
  const ue = b(() => {
    switch (s.value) {
      case t.STRUCTURE.V:
        return He;
      case t.ENCLOSURE.V:
        return we;
      case t.MACHINE_PART.V:
        return Xe;
      case t.AUXILIARY_MATERIAL.V:
        return Be;
      default:
        return null;
    }
  }), se = b(() => {
    switch (s.value) {
      case d.BOX.V:
        return De;
      case d.MACHINE_PART.V:
        return Ye;
      default:
        return null;
    }
  }), re = b(() => E(l[t.STRUCTURE.K]) && E(l[t.ENCLOSURE.K]) && E(l[t.MACHINE_PART.K]) && E(l[t.AUXILIARY_MATERIAL.K])), ie = b(() => E(l[d.BOX.K]) && E(l[d.MACHINE_PART.K]));
  function de() {
    l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[d.MACHINE_PART.K] = {}, l[d.BOX.K] = {}, p.value.refresh(), w.value = void 0, L.value = {};
  }
  function ce(e, a) {
    e.boolOneCode ? (q.value = { row: e, packTypeK: a }, R.value = e.originNumberList, T.value = false, v.value = R.value.map((o) => o.number), G()) : Q(e, a);
  }
  function me(e) {
    B.value = true, W.value = e.qhseNumbers || [];
  }
  function pe() {
    I.value ? v.value = R.value.map((e) => e.number) : v.value = [];
  }
  function ve(e) {
    e.length === 0 ? (T.value = false, I.value = false) : e.length === R.value.length ? (T.value = false, I.value = true) : T.value = true;
  }
  function G() {
    const { row: e, packTypeK: a } = q.value;
    e.numberList = v.value, e.productQuantity = v.value.length, H.value = false, Q(e, a);
  }
  function Q(e, a) {
    l[a][e.id] = { ...e };
  }
  function fe(e) {
    g.value = e == null ? void 0 : e.monomerId, O.value = e == null ? void 0 : e.areaId;
  }
  function Ae(e) {
    var o;
    const { name: a } = e;
    h.value = a, (o = p == null ? void 0 : p.value) == null || o.refresh();
  }
  return (e, a) => {
    const o = y("component-radio-button"), u = y("common-select"), $ = y("common-button"), _e = ke, Ee = ye, F = y("common-dialog"), Re = Ne;
    return V(), J("div", Ge, [m("div", Qe, [m("div", $e, [m("div", null, [m("div", null, [f.value === i(S).BOX.V ? (V(), D(o, { key: 0, modelValue: s.value, "onUpdate:modelValue": a[0] || (a[0] = (r) => s.value = r), disabledVal: [i(d).AUXILIARY_MATERIAL.V], options: i(d).ENUM, class: "filter-item", default: "", size: "small", type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"])) : Ce("", true), N(c(u, { modelValue: K.value, "onUpdate:modelValue": a[1] || (a[1] = (r) => K.value = r), "data-structure": { key: "id", label: "name", value: "id" }, options: j.value, class: "filter-item", clearable: "", placeholder: "请选择车间", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"]), [[M, s.value !== i(t).AUXILIARY_MATERIAL.V]])])]), c(_e, { hidden: z.value < 1, max: 99, value: z.value }, { default: A(() => [c($, { disabled: f.value === i(S).BOX.V ? ie.value : re.value, size: "default", type: "primary", onClick: a[2] || (a[2] = (r) => U.value = true) }, { default: A(() => a[9] || (a[9] = [Z(" 打包列表 ")])), _: 1, __: [9] }, 8, ["disabled"])]), _: 1 }, 8, ["hidden", "value"])]), N(m("div", null, [c(qe, { default: false, productType: s.value, "project-id": i(_), needConvert: "", onChange: fe }, null, 8, ["productType", "project-id"])], 512), [[M, s.value === i(t).STRUCTURE.V || s.value === i(t).MACHINE_PART.V]]), N(m("div", null, null, 512), [[M, s.value !== i(t).STRUCTURE.V && s.value !== i(t).MACHINE_PART.V]]), N(m("div", null, [c(i(We), { modelValue: h.value, "onUpdate:modelValue": a[3] || (a[3] = (r) => h.value = r), "area-info": P.value, "default-tab": te.value, "show-type": 2, class: "filter-item", style: { width: "100%" }, onTabClick: Ae }, null, 8, ["modelValue", "area-info", "default-tab"])], 512), [[M, s.value === i(t).ENCLOSURE.V && P.value.length]])]), (V(), D(ge(f.value === i(S).BOX.V ? se.value : ue.value), { ref_key: "mainRef", ref: p, "area-id": s.value === i(t).ENCLOSURE.V ? h.value : O.value, maxHeight: i(le) - 20, "monomer-id": g.value, "project-id": i(_), "workshop-id": K.value, onAdd: ce, onQhseNumbers: me }, null, 40, ["area-id", "maxHeight", "monomer-id", "project-id", "workshop-id"])), c(i(je), { visible: U.value, "onUpdate:visible": a[4] || (a[4] = (r) => U.value = r), bagId: w.value, "edit-data": L.value, "type-val": f.value, onHandleSuccess: de }, null, 8, ["visible", "bagId", "edit-data", "type-val"]), c(F, { modelValue: H.value, "onUpdate:modelValue": a[7] || (a[7] = (r) => H.value = r), center: false, "close-on-click-modal": false, "custom-class": "code-dialog", title: "选择一物一码编号", width: "680px" }, { titleRight: A(() => [c($, { size: "default", type: "primary", onClick: G }, { default: A(() => a[10] || (a[10] = [Z("确认")])), _: 1, __: [10] }), m("span", null, [c(Ee, { modelValue: I.value, "onUpdate:modelValue": a[5] || (a[5] = (r) => I.value = r), indeterminate: T.value, border: "", label: "全选", size: "default", style: { height: "29px" }, onChange: pe }, null, 8, ["modelValue", "indeterminate"])])]), default: A(() => [c(i(ze), { modelValue: v.value, "onUpdate:modelValue": a[6] || (a[6] = (r) => v.value = r), color: "#ffff00", list: R.value, maxHeight: 560, onChange: ve }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"]), c(F, { modelValue: B.value, "onUpdate:modelValue": a[8] || (a[8] = (r) => B.value = r), center: false, "close-on-click-modal": false, title: "问题码号列表", width: "680px" }, { default: A(() => [m("div", Fe, [(V(true), J(he, null, Le(W.value, (r, Ie) => (V(), D(Re, { key: Ie, effect: "plain", size: "large", type: "danger" }, { default: A(() => [m("span", null, Ue(r), 1)]), _: 2 }, 1024))), 128))])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ha = Me(Je, [["__scopeId", "data-v-0af89d65"]]);
export {
  ha as default
};
