import { useRoute as Ue } from "vue-router";
import { ref as n } from "vue";
import { reactive as ye } from "vue";
import { watch as N } from "vue";
import { computed as R } from "vue";
import { provide as Y } from "vue";
import { onMounted as Ne } from "vue";
import { nextTick as ee } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as ae } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as c } from "vue";
import { unref as s } from "vue";
import { withDirectives as ke } from "vue";
import { vShow as Me } from "vue";
import { withCtx as p } from "vue";
import { createBlock as j } from "vue";
import { createCommentVNode as Ke } from "vue";
import { createTextVNode as te } from "vue";
import { resolveDynamicComponent as Oe } from "vue";
import { Fragment as Se } from "vue";
import { renderList as xe } from "vue";
import { toDisplayString as Be } from "vue";
import { ElBadge as Pe } from "element-plus";
import { ElCheckbox as He } from "element-plus";
import { ElTag as we } from "element-plus";
import { _ as Xe, m4 as le, m as De, uc as t, bw as i, o as Ye, i as q, cM as oe, oV as je, od as k, ud as z, ue as qe, b as I, bZ as ze } from "../../../../../shared/runtime.js";
import { p as We } from "../../../../../modules/ship-manage-3066b2ed.js";
import Ge from "../pack-components/structure/index.vue.js";
import Qe from "../pack-components/enclosure/index.vue.js";
import $e from "../pack-components/auxiliary-material/index.vue.js";
import Fe from "../pack-components/part/index.vue.js";
import Je from "../pack-components/box/index.vue.js";
import Ze from "../pack-components/cell/index.vue.js";
import ea from "../pack-components/pack-list-drawer/index.vue.js";
import { o as aa } from "../../../../../modules/one-code-number-list-af2f89eb.js";
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
const ta = { class: "app-container manual-pack-wrapper" }, la = { class: "head-container" }, oa = { class: "manual-pack-common-header", style: { display: "flex", "justify-content": "space-between" } }, na = { class: "qhseNumbers-dialog" }, ua = { __name: "index", setup(ra) {
  const ne = Ue(), W = n(), ue = n({}), M = n(le.HOMEMADE.V), b = n(), { globalProjectId: v, globalProject: g } = De(["globalProjectId", "globalProject"]), d = n(t.STRUCTURE.V), K = n(), T = n(), L = n(), O = n(), re = n(), S = n(), G = n([]), se = n([]), x = n(false), B = n(), m = n([]), f = n([]), C = n(false), E = n(false), U = n({}), P = n(), y = n(false), l = ye({ [t.STRUCTURE.K]: {}, [t.ENCLOSURE.K]: {}, [t.MACHINE_PART.K]: {}, [t.AUXILIARY_MATERIAL.K]: {}, [i.BOX.K]: {}, [i.MACHINE_PART.K]: {} }), H = n(false), Q = n([]), A = n();
  N(() => g.value, (a) => {
    var e;
    A.value = void 0, A.value = (e = g.value) == null ? void 0 : e.productCategory, de();
  }, { immediate: true, deep: true });
  const $ = R(() => {
    let a = 0;
    for (const e in l) a += l[e] ? Object.keys(l[e]).length : 0;
    return a;
  }), { maxHeight: ie } = Ye({ wrapperBox: ".manual-pack-wrapper", extraBox: [".manual-pack-common-header", ".head-container"], extraHeight: 25, paginate: true });
  Y("packData", l), Y("permission", We), Y("projectId", v), R(() => ne.params), N(() => v.value, (a, e) => {
    q(a) && (l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[i.BOX.K] = {}, l[i.MACHINE_PART.K] = {});
  }, { immediate: true, deep: true }), N(() => d.value, (a) => {
    S.value = S.value ? S.value : v.value, d.value === t.ENCLOSURE.V && (T.value = void 0, ce());
  }), Ne(() => {
    const a = oe.get("ROUTER_PARAMS");
    if (console.log(a, "val"), q(a)) {
      U.value = { ...a, data: JSON.parse(a.data) }, P.value = a.id;
      const e = U.value.data;
      l[t.STRUCTURE.K] = e.artifactList && e.artifactList.reduce((o, r) => (o[r.id] = r, o), {}), l[t.MACHINE_PART.K] = e.partList && e.partList.reduce((o, r) => (o[r.id] = r, o), {}) || {}, l[t.ENCLOSURE.K] = e.enclosureList && e.enclosureList.reduce((o, r) => (o[r.id] = r, o), {}) || {}, l[t.AUXILIARY_MATERIAL.K] = e.auxiliaryMaterialList && e.auxiliaryMaterialList.reduce((o, r) => (o[r.id] = r, o), {}) || {}, l[i.BOX.K] = e.boxList && e.boxList.reduce((o, r) => (o[r.id] = r, o), {}) || {}, l[i.MACHINE_PART.K] = e.partList && e.partList.reduce((o, r) => (o[r.id] = r, o), {}) || {}, ee(() => {
        y.value = true, oe.remove("ROUTER_PARAMS");
      });
    }
  }), N([T, L], () => {
    var a;
    (a = b == null ? void 0 : b.value) == null || a.refresh();
  });
  async function de() {
    if (!(!g.value || d.value === t.AUXILIARY_MATERIAL.V)) try {
      const { content: a } = await je({ boolEnabledEnum: true, type: A.value === k.BOX.V ? z.BRIDGE_WORKSHOP.V : d.value === t.ENCLOSURE.V ? z.ENCLOSURE_WORKSHOP.V : z.MES_WORKSHOP.V });
      console.log(a, "content"), G.value = a || [];
    } catch (a) {
      console.log("获取车间信息失败", a);
    }
  }
  async function ce() {
    if (!(!g.value || d.value === t.STRUCTURE.V || d.value === t.MACHINE_PART.V)) try {
      const a = await qe(v.value);
      se.value = a || [];
    } catch (a) {
      console.log("获取围护的批次失败", a);
    }
  }
  const me = R(() => {
    switch (d.value) {
      case t.STRUCTURE.V:
        return Ge;
      case t.ENCLOSURE.V:
        return Qe;
      case t.MACHINE_PART.V:
        return Fe;
      case t.AUXILIARY_MATERIAL.V:
        return $e;
      default:
        return "";
    }
  }), pe = R(() => {
    switch (d.value) {
      case i.BOX.V:
        return Je;
      case i.MACHINE_PART.V:
        return Ze;
      default:
        return "";
    }
  }), ve = R(() => I(l[t.STRUCTURE.K]) && I(l[t.ENCLOSURE.K]) && I(l[t.MACHINE_PART.K]) && I(l[t.AUXILIARY_MATERIAL.K])), fe = R(() => I(l[i.BOX.K]) && I(l[i.MACHINE_PART.K]));
  function Ae() {
    ee(() => {
      const a = W.value.planAreaBatch;
      ue.value = a != null && a.length ? { id: `${a[0].id}`, name: a[0].name } : {};
    });
  }
  function Ee(a, e) {
    A.value === k.BOX.V ? delete l[i.VK[e]][a] : delete l[t.VK[e]][a];
  }
  function Re() {
    l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[i.MACHINE_PART.K] = {}, l[i.BOX.K] = {};
  }
  function _e() {
    l[t.STRUCTURE.K] = {}, l[t.ENCLOSURE.K] = {}, l[t.MACHINE_PART.K] = {}, l[t.AUXILIARY_MATERIAL.K] = {}, l[i.MACHINE_PART.K] = {}, l[i.BOX.K] = {}, b.value.refresh(), P.value = void 0, U.value = {};
  }
  function Ie(a, e) {
    a.boolOneCode ? (B.value = { row: a, packTypeK: e }, f.value = a.originNumberList, E.value = false, m.value = f.value.map((o) => o.number), w()) : X(a, e);
  }
  function be(a, e) {
    !Array.isArray(a) || a.length === 0 || (a.filter((o) => !o.boolOneCode).forEach((o) => X(o, e)), a.filter((o) => o.boolOneCode).forEach((o) => {
      B.value = { row: o, packTypeK: e }, f.value = o.originNumberList, E.value = false, m.value = f.value.map((r) => r.number), w();
    }));
  }
  function Te(a) {
    H.value = true, Q.value = a.qhseNumbers || [];
  }
  function Ce() {
    C.value ? m.value = f.value.map((a) => a.number) : m.value = [];
  }
  function Ve(a) {
    a.length === 0 ? (E.value = false, C.value = false) : a.length === f.value.length ? (E.value = false, C.value = true) : E.value = true;
  }
  function w() {
    const { row: a, packTypeK: e } = B.value;
    a.numberList = m.value, a.productQuantity = m.value.length, x.value = false, X(a, e);
  }
  function X(a, e) {
    l[e][a.id] = { ...a };
  }
  return (a, e) => {
    const o = V("component-radio-button"), r = V("common-radio-button"), F = V("common-select"), J = V("common-button"), he = Pe, ge = He, Z = V("common-dialog"), Le = we;
    return h(), ae("div", ta, [_("div", la, [_("div", oa, [_("div", null, [c(o, { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (u) => d.value = u), options: s(t).ENUM, class: "filter-item", default: "", size: "small", type: "enum" }, null, 8, ["modelValue", "options"]), c(r, { modelValue: M.value, "onUpdate:modelValue": e[1] || (e[1] = (u) => M.value = u), options: s(le).ENUM, class: "filter-item", type: "enum" }, null, 8, ["modelValue", "options"]), ke(c(F, { modelValue: K.value, "onUpdate:modelValue": e[2] || (e[2] = (u) => K.value = u), "data-structure": { key: "id", label: "name", value: "id" }, options: G.value, class: "filter-item", clearable: "", placeholder: "请选择车间", style: { width: "200px" }, type: "other" }, null, 8, ["modelValue", "options"]), [[Me, d.value !== s(t).AUXILIARY_MATERIAL.V]]), c(s(ze), { ref_key: "monomerAreaRef", ref: W, areaId: L.value, "onUpdate:areaId": e[4] || (e[4] = (u) => L.value = u), monomerId: T.value, "onUpdate:monomerId": e[5] || (e[5] = (u) => T.value = u), "project-id": s(v), areaClearable: "", clearable: "", onAreaChange: Ae }, { right: p(({ batchList: u }) => [d.value !== s(t).AUXILIARY_MATERIAL.V ? (h(), j(F, { key: 0, modelValue: O.value, "onUpdate:modelValue": e[3] || (e[3] = (D) => O.value = D), options: u, size: "default", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: s(q)(s(v)) ? "暂无数据" : "未选择项目", class: "filter-item", placeholder: "请选择批次", style: { width: "350px" } }, null, 8, ["modelValue", "options", "noDataText"])) : Ke("", true)]), _: 1 }, 8, ["areaId", "monomerId", "project-id"])]), c(he, { hidden: $.value < 1, max: 99, value: $.value }, { default: p(() => [c(J, { disabled: A.value === s(k).BOX.V ? fe.value : ve.value, size: "mini", type: "primary", onClick: e[6] || (e[6] = (u) => y.value = true) }, { default: p(() => e[12] || (e[12] = [te(" 打包列表 ")])), _: 1, __: [12] }, 8, ["disabled"])]), _: 1 }, 8, ["hidden", "value"])])]), (h(), j(Oe(A.value === s(k).BOX.V ? pe.value : me.value), { ref_key: "mainRef", ref: b, "area-id": d.value === s(t).ENCLOSURE.V ? re.value : L.value, manufactureType: M.value, maxHeight: s(ie) - 20, "monomer-id": T.value, "project-id": s(v), "workshop-id": K.value, areaBatchId: O.value, onAdd: Ie, onQhseNumbers: Te, onBatchAdd: be }, null, 40, ["area-id", "manufactureType", "maxHeight", "monomer-id", "project-id", "workshop-id", "areaBatchId"])), c(s(ea), { visible: y.value, "onUpdate:visible": e[7] || (e[7] = (u) => y.value = u), bagId: P.value, "edit-data": U.value, "type-val": A.value, onDel: Ee, onClearAll: Re, onHandleSuccess: _e }, null, 8, ["visible", "bagId", "edit-data", "type-val"]), c(Z, { modelValue: x.value, "onUpdate:modelValue": e[10] || (e[10] = (u) => x.value = u), center: false, "close-on-click-modal": false, "custom-class": "code-dialog", title: "选择一物一码编号", width: "680px" }, { titleRight: p(() => [c(J, { size: "mini", type: "primary", onClick: w }, { default: p(() => e[13] || (e[13] = [te("确认")])), _: 1, __: [13] }), _("span", null, [c(ge, { modelValue: C.value, "onUpdate:modelValue": e[8] || (e[8] = (u) => C.value = u), indeterminate: E.value, border: "", label: "全选", size: "mini", style: { height: "29px" }, onChange: Ce }, null, 8, ["modelValue", "indeterminate"])])]), default: p(() => [c(s(aa), { modelValue: m.value, "onUpdate:modelValue": e[9] || (e[9] = (u) => m.value = u), color: "#ffff00", list: f.value, maxHeight: 560, onChange: Ve }, null, 8, ["modelValue", "list"])]), _: 1 }, 8, ["modelValue"]), c(Z, { modelValue: H.value, "onUpdate:modelValue": e[11] || (e[11] = (u) => H.value = u), center: false, "close-on-click-modal": false, title: "问题码号列表", width: "680px" }, { default: p(() => [_("div", na, [(h(true), ae(Se, null, xe(Q.value, (u, D) => (h(), j(Le, { key: D, effect: "plain", size: "medium", type: "danger" }, { default: p(() => [_("span", null, Be(u), 1)]), _: 2 }, 1024))), 128))])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ka = Xe(ua, [["__scopeId", "data-v-3562d5db"]]);
export {
  ka as default
};
