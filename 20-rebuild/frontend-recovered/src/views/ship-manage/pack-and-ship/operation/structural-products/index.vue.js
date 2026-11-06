import { ref as o } from "vue";
import { reactive as ge } from "vue";
import { watch as y } from "vue";
import { computed as C } from "vue";
import { provide as X } from "vue";
import { onMounted as he } from "vue";
import { nextTick as ye } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as ee } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as i } from "vue";
import { unref as r } from "vue";
import { createBlock as D } from "vue";
import { createCommentVNode as Ce } from "vue";
import { withCtx as A } from "vue";
import { createTextVNode as ae } from "vue";
import { normalizeStyle as Ue } from "vue";
import { resolveDynamicComponent as Le } from "vue";
import { Fragment as Ne } from "vue";
import { renderList as ke } from "vue";
import { toDisplayString as Se } from "vue";
import { ElBadge as xe } from "element-plus";
import { ElCheckbox as Me } from "element-plus";
import { ElTag as Oe } from "element-plus";
import { _ as Ke, m4 as le, m as Pe, uc as l, bw as c, o as we, i as te, cM as oe, oV as Be, od as Y, ud as j, ue as He, b as T, T as Xe, q as De } from "../../../../../shared/runtime.js";
import { s as Ye } from "../../../../../modules/ship-manage-3066b2ed.js";
import je from "../pack-components/structure/index.vue.js";
import ze from "../pack-components/enclosure/index.vue.js";
import qe from "../pack-components/auxiliary-material/index.vue.js";
import We from "../pack-components/part/index.vue.js";
import Ge from "../pack-components/box/index.vue.js";
import Qe from "../pack-components/cell/index.vue.js";
import Fe from "../pack-components/pack-list-drawer/index.vue.js";
import { o as Je } from "../../../../../modules/one-code-number-list-af2f89eb.js";
import { a as $e } from "../../../../../modules/index-8356a01a.js";
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
const Ze = { class: "app-container manual-pack-wrapper" }, ea = { class: "head-container" }, aa = { class: "manual-pack-common-header", style: { display: "flex", "justify-content": "space-between" } }, la = { class: "qhseNumbers-dialog" }, ta = { __name: "index", setup(oa) {
  const x = o(le.HOMEMADE.V), _ = o(), { globalProjectId: R, globalProject: N } = Pe(["globalProjectId", "globalProject"]), d = o(l.STRUCTURE.V), M = o(), b = o(), p = o(), ue = o(), O = o(), z = o([]), m = o([]), K = o(), v = o([]), P = o({}), w = o(false), q = o(), f = o([]), I = o([]), g = o(false), h = o(false), k = o({}), B = o(), S = o(false), t = ge({ [l.STRUCTURE.K]: {}, [l.ENCLOSURE.K]: {}, [l.MACHINE_PART.K]: {}, [l.AUXILIARY_MATERIAL.K]: {}, [c.BOX.K]: {}, [c.MACHINE_PART.K]: {} }), H = o(false), W = o([]), V = o();
  y(() => N.value, (a) => {
    var e;
    V.value = void 0, V.value = (e = N.value) == null ? void 0 : e.productCategory, re();
  }, { immediate: true, deep: true });
  const ne = o([l.ENCLOSURE.V, l.AUXILIARY_MATERIAL.V]), G = C(() => {
    let a = 0;
    for (const e in t) a += t[e] ? Object.keys(t[e]).length : 0;
    return a;
  }), { maxHeight: se } = we({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"], paginate: true });
  X("packData", t), X("permission", Ye), X("projectId", R), y(() => R.value, (a, e) => {
    te(a) && (t[l.STRUCTURE.K] = {}, t[l.ENCLOSURE.K] = {}, t[l.MACHINE_PART.K] = {}, t[l.AUXILIARY_MATERIAL.K] = {}, t[c.BOX.K] = {}, t[c.MACHINE_PART.K] = {});
  }, { immediate: true, deep: true }), y(() => d.value, (a) => {
    O.value = O.value ? O.value : R.value, d.value === l.ENCLOSURE.V && (b.value = void 0, ie());
  }), he(() => {
    const a = oe.get("ROUTER_PARAMS");
    if (te(a)) {
      k.value = { ...a, data: JSON.parse(a.data) }, B.value = a.id;
      const e = k.value.data;
      t[l.STRUCTURE.K] = e.artifactList && e.artifactList.reduce((u, s) => (u[s.id] = s, u), {}), t[l.MACHINE_PART.K] = e.partList && e.partList.reduce((u, s) => (u[s.id] = s, u), {}) || {}, t[l.ENCLOSURE.K] = e.enclosureList && e.enclosureList.reduce((u, s) => (u[s.id] = s, u), {}) || {}, t[l.AUXILIARY_MATERIAL.K] = e.auxiliaryMaterialList && e.auxiliaryMaterialList.reduce((u, s) => (u[s.id] = s, u), {}) || {}, t[c.BOX.K] = e.boxList && e.boxList.reduce((u, s) => (u[s.id] = s, u), {}) || {}, t[c.MACHINE_PART.K] = e.partList && e.partList.reduce((u, s) => (u[s.id] = s, u), {}) || {}, ye(() => {
        S.value = true, oe.remove("ROUTER_PARAMS");
      });
    }
  }), y([b, p], () => {
    var a;
    (a = _ == null ? void 0 : _.value) == null || a.refresh();
  });
  async function re() {
    if (!(!N.value || d.value === l.AUXILIARY_MATERIAL.V)) try {
      const { content: a } = await Be({ boolEnabledEnum: true, type: V.value === Y.BOX.V ? j.BRIDGE_WORKSHOP.V : d.value === l.ENCLOSURE.V ? j.ENCLOSURE_WORKSHOP.V : j.MES_WORKSHOP.V });
      console.log(a, "content"), z.value = a || [];
    } catch (a) {
      console.log("获取车间信息失败", a);
    }
  }
  async function ie() {
    if (!(!N.value || d.value === l.STRUCTURE.V || d.value === l.MACHINE_PART.V)) try {
      const a = await He(R.value);
      m.value = a || [];
    } catch (a) {
      console.log("获取围护的批次失败", a);
    }
  }
  const de = C(() => {
    switch (d.value) {
      case l.STRUCTURE.V:
        return je;
      case l.ENCLOSURE.V:
        return ze;
      case l.MACHINE_PART.V:
        return We;
      case l.AUXILIARY_MATERIAL.V:
        return qe;
      default:
        return null;
    }
  }), ce = C(() => {
    switch (d.value) {
      case c.BOX.V:
        return Ge;
      case c.MACHINE_PART.V:
        return Qe;
      default:
        return null;
    }
  }), me = C(() => T(t[l.STRUCTURE.K]) && T(t[l.ENCLOSURE.K]) && T(t[l.MACHINE_PART.K]) && T(t[l.AUXILIARY_MATERIAL.K])), pe = C(() => T(t[c.BOX.K]) && T(t[c.MACHINE_PART.K]));
  function ve() {
    t[l.STRUCTURE.K] = {}, t[l.ENCLOSURE.K] = {}, t[l.MACHINE_PART.K] = {}, t[l.AUXILIARY_MATERIAL.K] = {}, t[c.MACHINE_PART.K] = {}, t[c.BOX.K] = {}, _.value.refresh(), B.value = void 0, k.value = {};
  }
  function fe(a, e) {
    a.boolOneCode ? (q.value = { row: a, packTypeK: e }, I.value = a.originNumberList, h.value = false, f.value = I.value.map((u) => u.number), Q()) : F(a, e);
  }
  function Ee(a) {
    H.value = true, W.value = a.qhseNumbers || [];
  }
  function Ae() {
    g.value ? f.value = I.value.map((a) => a.number) : f.value = [];
  }
  function Re(a) {
    a.length === 0 ? (h.value = false, g.value = false) : a.length === I.value.length ? (h.value = false, g.value = true) : h.value = true;
  }
  function Q() {
    const { row: a, packTypeK: e } = q.value;
    a.numberList = f.value, a.productQuantity = f.value.length, w.value = false, F(a, e);
  }
  function F(a, e) {
    t[e][a.id] = { ...a };
  }
  function Ve(a, e) {
    var u;
    m.value = a.filter((s) => s.itemizedType === 1) || [], p.value = (u = m.value[0]) == null ? void 0 : u.id;
  }
  return y([() => p.value, () => m.value], (a) => {
    a && (m.value.length > 0 ? (v.value = m.value.filter((e) => p.value === e.id)[0].planAreaBatchDTOS, P.value = { id: v.value ? v.value[0].id + "" : "", name: v.value ? v.value[0].name : "" }) : (P.value = {}, v.value = []));
  }, { immediate: true, deep: true }), (a, e) => {
    const u = U("component-radio-button"), s = U("common-radio-button"), J = U("common-select"), $ = U("common-button"), Te = xe, _e = Me, Z = U("common-dialog"), be = Oe;
    return L(), ee("div", Ze, [E("div", ea, [E("div", aa, [E("div", null, [E("div", null, [i(u, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => d.value = n), options: r(l).ENUM, unshowVal: ne.value, class: "filter-item", default: "", size: "small", type: "enum" }, null, 8, ["modelValue", "options", "unshowVal"]), d.value !== r(l).MACHINE_PART.V ? (L(), D(s, { key: 0, modelValue: x.value, "onUpdate:modelValue": e[1] || (e[1] = (n) => x.value = n), options: r(le).ENUM, class: "filter-item", type: "enum" }, null, 8, ["modelValue", "options"])) : Ce("", true), i(J, { modelValue: M.value, "onUpdate:modelValue": e[2] || (e[2] = (n) => M.value = n), "data-structure": { key: "id", label: "name", value: "id" }, options: z.value, class: "filter-item", clearable: "", placeholder: "请选择车间", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"])])]), i(Te, { hidden: G.value < 1, max: 99, value: G.value }, { default: A(() => [i($, { disabled: V.value === r(Y).BOX.V ? pe.value : me.value, size: "default", type: "primary", onClick: e[3] || (e[3] = (n) => S.value = true) }, { default: A(() => e[12] || (e[12] = [ae(" 打包列表 ")])), _: 1, __: [12] }, 8, ["disabled"])]), _: 1 }, 8, ["hidden", "value"])]), i(r(De), { ref: "monomerSelectRef", modelValue: b.value, "onUpdate:modelValue": e[4] || (e[4] = (n) => b.value = n), productType: r(Xe).STRUCTURE.V, "project-id": r(R), "show-tips": m.value.length <= 0, onGetAreaInfo: Ve }, null, 8, ["modelValue", "productType", "project-id", "show-tips"]), i(J, { modelValue: p.value, "onUpdate:modelValue": e[5] || (e[5] = (n) => p.value = n), dataStructure: { key: "id", label: "name", value: "id" }, options: m.value, class: "filter-item", placeholder: "请选择区域", style: { width: "200px", "margin-left": "3px" }, type: "other" }, null, 8, ["modelValue", "options"]), i(r($e), { modelValue: K.value, "onUpdate:modelValue": e[6] || (e[6] = (n) => K.value = n), "area-info": v.value, "default-tab": P.value, style: Ue(m.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item" }, null, 8, ["modelValue", "area-info", "default-tab", "style"])]), (L(), D(Le(V.value === r(Y).BOX.V ? ce.value : de.value), { ref_key: "mainRef", ref: _, "area-batch-id": K.value, "area-id": d.value === r(l).ENCLOSURE.V ? ue.value : p.value, manufactureType: x.value, maxHeight: r(se) - 20, "monomer-id": b.value, "project-id": r(R), "workshop-id": M.value, onAdd: fe, onQhseNumbers: Ee }, null, 40, ["area-batch-id", "area-id", "manufactureType", "maxHeight", "monomer-id", "project-id", "workshop-id"])), i(r(Fe), { visible: S.value, "onUpdate:visible": e[7] || (e[7] = (n) => S.value = n), bagId: B.value, "edit-data": k.value, "type-val": V.value, onHandleSuccess: ve }, null, 8, ["visible", "bagId", "edit-data", "type-val"]), i(Z, { modelValue: w.value, "onUpdate:modelValue": e[10] || (e[10] = (n) => w.value = n), center: false, "close-on-click-modal": false, "custom-class": "code-dialog", title: "选择一物一码编号", width: "680px" }, { titleRight: A(() => [i($, { size: "default", type: "primary", onClick: Q }, { default: A(() => e[13] || (e[13] = [ae("确认")])), _: 1, __: [13] }), E("span", null, [i(_e, { modelValue: g.value, "onUpdate:modelValue": e[8] || (e[8] = (n) => g.value = n), indeterminate: h.value, border: "", label: "全选", size: "default", style: { height: "29px" }, onChange: Ae }, null, 8, ["modelValue", "indeterminate"])])]), default: A(() => [i(r(Je), { modelValue: f.value, "onUpdate:modelValue": e[9] || (e[9] = (n) => f.value = n), color: "#ffff00", list: I.value, maxHeight: 560, onChange: Re }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"]), i(Z, { modelValue: H.value, "onUpdate:modelValue": e[11] || (e[11] = (n) => H.value = n), center: false, "close-on-click-modal": false, title: "问题码号列表", width: "680px" }, { default: A(() => [E("div", la, [(L(true), ee(Ne, null, ke(W.value, (n, Ie) => (L(), D(be, { key: Ie, effect: "plain", size: "large", type: "danger" }, { default: A(() => [E("span", null, Se(n), 1)]), _: 2 }, 1024))), 128))])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, La = Ke(ta, [["__scopeId", "data-v-b130cf20"]]);
export {
  La as default
};
