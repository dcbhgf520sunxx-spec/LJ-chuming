import { computed as re } from "vue";
import { ref as t } from "vue";
import { watch as he } from "vue";
import { provide as y } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as Y } from "vue";
import { createElementVNode as L } from "vue";
import { createVNode as i } from "vue";
import { unref as a } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as R } from "vue";
import { Fragment as se } from "vue";
import { withCtx as T } from "vue";
import { createTextVNode as je } from "vue";
import { resolveDynamicComponent as be } from "vue";
import { ElBadge as Ae } from "element-plus";
import { ElCol as Le } from "element-plus";
import { ElRow as Se } from "element-plus";
import { c as Ue, p as Pe, b as Ne } from "../../../../modules/common-913d415d.js";
import { T as Oe } from "../../../../modules/base-6bc46ddf.js";
import { a as ke } from "../../../../modules/area-ca564e60.js";
import { _ as we, t as xe, K as j, kz as u, m as Me, T as S, F as Be, i as De, kC as b, q as Ge, G as U, O as F, b as ze } from "../../../../shared/runtime.js";
import { O as P } from "../../../../modules/contract-9b18cc88.js";
import $e from "./structure/index.vue.js";
import Xe from "./enclosure/index.vue.js";
import Ye from "./auxiliary-material/index.vue.js";
import Fe from "./machine-part/index.vue.js";
import He from "./price-modify-list/index.vue.js";
import qe from "./box/index.vue.js";
import { P as H } from "../../../../modules/index-5b9e6004.js";
import Ke from "./submit-log.vue.js";
import "../../../../modules/structure-70e27af9.js";
import "./structure/module/header.vue.js";
import "./preview.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "./structure/module/detail.vue.js";
import "./structure/module/adjust.vue.js";
import "./enclosure/module/header.vue.js";
import "./auxiliary-material/module/header.vue.js";
import "./machine-part/module/header.vue.js";
import "./machine-part/module/detail.vue.js";
import "./price-modify-list/module/header.vue.js";
import "./price-modify-list/module/detail.vue.js";
import "./box/module/header.vue.js";
import "./box/module/detail.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const We = { class: "app-container" }, Je = { class: "head-container" }, Qe = { class: "filter-container" }, Ze = { class: "filter-left-box" }, eo = { class: "filter-right-box" }, oo = { __name: "index", setup(ao) {
  const { decimalPrecision: x } = xe(), ce = re(() => {
    var e;
    if (((e = I.value) == null ? void 0 : e.projectType) === j.BRIDGE.V) return qe;
    switch (l.value) {
      case u.ENCLOSURE.V:
        return Xe;
      case u.MACHINE_PART.V:
        return Fe;
      case u.AUXILIARY_MATERIAL.V:
        return Ye;
      default:
        return $e;
    }
  }), { globalProject: I, globalProjectId: q, contractSaleTypeEnumArr: ie } = Me(["globalProject", "globalProjectId", "contractSaleTypeEnumArr"]), K = t(), m = t(), l = t(), M = t(0), W = t(false), B = t(0), D = t(0), G = t(0), p = t(), v = t(), N = t(false), O = t([]), V = t({}), z = t([]), f = t([]), s = t(), c = t(), A = t([]), J = t(), $ = t(false), Q = t(), r = t(), de = [{ name: "压型彩板", no: S.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: S.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: S.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: S.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: S.BENDING.V, alias: "ENCLOSURE" }], k = F(async function() {
    if (!U(P.cost) || ze(m.value) || l.value === u.ENCLOSURE.V || !l.value) {
      B.value = 0, D.value = 0, G.value = 0;
      return;
    }
    try {
      W.value = true;
      const e = { projectId: m.value, monomerId: p.value, areaId: v.value, type: l.value }, { monomerPrice: o, projectPrice: d, areaPrice: E } = await Ue(e);
      B.value = d || 0, D.value = o || 0, G.value = E || 0;
    } catch (e) {
      console.log(e);
    } finally {
      W.value = false;
    }
  }, 100, false), Z = F(async function() {
    if (U(P.list)) try {
      M.value = await Pe();
    } catch (e) {
      console.log("变更记录未审核数量", e);
    }
  }, 100, false), g = F(async function() {
    var e, o, d, E;
    if (U(P.list)) try {
      let C = {};
      switch (l.value) {
        case u.ENCLOSURE.V:
          C = { category: c.value, enclosurePlanId: s.value, projectId: m.value, projectType: (e = V.value) == null ? void 0 : e.projectType, type: l.value };
          break;
        case u.AUXILIARY_MATERIAL.V:
          C = r.value === b.STRUCTURE.V ? { areaId: v.value, monomerId: p.value, projectId: m.value, projectType: (o = V.value) == null ? void 0 : o.projectType, relationType: r.value, type: l.value } : { category: c.value, enclosurePlanId: s.value, projectId: m.value, projectType: (d = V.value) == null ? void 0 : d.projectType, relationType: r.value, type: l.value };
          break;
        default:
          C = { areaId: v.value, monomerId: p.value, projectId: m.value, projectType: (E = V.value) == null ? void 0 : E.projectType, type: l.value };
          break;
      }
      Q.value = await Ne(C);
    } catch (C) {
      console.log("提交记录待提交数量", C);
    }
  }, 100, false);
  he(q, (e) => {
    m.value = q.value, fe(I.value), ee();
  }, { immediate: true }), y("monomerId", p), y("areaId", v), y("projectId", m), y("modifyVisible", N), y("enclosurePlanId", s), y("globalProject", I), y("priceEditMode", J), y("saveCount", Q), y("relationType", r), y("category", c);
  const me = re(() => {
    var e, o;
    return ((e = I.value) == null ? void 0 : e.projectType) === j.BRIDGE.V ? [Be.BOX] : ((o = I.value) == null ? void 0 : o.projectType) === j.ENCLOSURE.V ? [u.ENCLOSURE, u.AUXILIARY_MATERIAL] : ie.value;
  });
  function ee() {
    k(), Z();
  }
  function pe() {
    k();
  }
  function oe() {
    Z(), g();
  }
  ve();
  async function ve() {
    try {
      const e = await Oe();
      J.value = e == null ? void 0 : e.priceEditMode;
    } catch (e) {
      console.log("获取特征定义审批配置", e);
    }
  }
  function fe(e) {
    V.value = e, A.value = [], f.value = [], s.value = void 0, De(V.value) && (de.forEach((o) => {
      var d;
      ((d = e == null ? void 0 : e.projectContentList) == null ? void 0 : d.findIndex((E) => Number(E.no) === o.no)) > -1 && A.value.push(o);
    }), A.value.length > 0 && (c.value = A.value[0].no, Ee())), g();
  }
  function ye(e) {
    s.value = void 0, f.value = z.value.filter((o) => o.category === c.value) || [], f.value && f.value.length > 0 && !r.value && (s.value = f.value[0].id), g();
  }
  function ae() {
    g(), k();
  }
  async function Ee() {
    try {
      const e = await ke(V.value.id) || [];
      z.value = e, f.value = z.value.filter((o) => o.category === c.value) || [], f.value && f.value.length > 0 && (s.value = f.value[0].id);
    } catch (e) {
      console.log("获取围护项目所有计划", e);
    }
  }
  function _e(e) {
    k(), g(), O.value = [], l.value === u.STRUCTURE.V || l.value === u.MACHINE_PART.V ? (console.log(e), O.value = e.filter((o) => o.itemizedType === 1)) : O.value = e.filter((o) => o.itemizedType === 64);
  }
  function te() {
    ee(), K.value.refresh();
  }
  function Ie() {
    $.value = true;
  }
  function Ve(e) {
    e === u.ENCLOSURE.V ? (p.value = void 0, v.value = void 0, r.value = void 0) : e === u.AUXILIARY_MATERIAL.V ? (p.value = void 0, v.value = void 0, c.value = void 0, r.value = b.STRUCTURE.V, s.value = void 0) : (c.value = void 0, s.value = void 0, r.value = void 0), g();
  }
  function Ce(e) {
    e === b.ENCLOSURE.V ? (p.value = void 0, v.value = void 0) : (c.value = void 0, s.value = void 0), g();
  }
  return (e, o) => {
    var le, ne;
    const d = w("common-radio-button"), E = w("common-select"), C = w("common-button"), ge = Ae, X = Le, Re = Se, Te = w("common-drawer");
    return _(), Y("div", We, [L("div", Je, [L("div", Qe, [L("div", Ze, [i(d, { modelValue: l.value, "onUpdate:modelValue": o[0] || (o[0] = (n) => l.value = n), options: me.value, default: "", type: "enumSL", size: "default", class: "filter-item", onChange: Ve }, null, 8, ["modelValue", "options"]), l.value === a(u).AUXILIARY_MATERIAL.V ? (_(), h(d, { key: 0, modelValue: r.value, "onUpdate:modelValue": o[1] || (o[1] = (n) => r.value = n), options: a(b).ENUM, type: "enum", size: "default", class: "filter-item", onChange: Ce }, null, 8, ["modelValue", "options"])) : R("", true), r.value && r.value !== a(b).ENCLOSURE.V && l.value !== a(u).ENCLOSURE.V || l.value !== a(u).ENCLOSURE.V && l.value !== a(u).AUXILIARY_MATERIAL.V ? (_(), Y(se, { key: 1 }, [i(a(Ge), { modelValue: p.value, "onUpdate:modelValue": o[2] || (o[2] = (n) => p.value = n), "project-id": m.value, class: "filter-item", default: !r.value, clearable: "", onChange: pe, onGetAreaInfo: _e }, null, 8, ["modelValue", "project-id", "default"]), ((le = a(I)) == null ? void 0 : le.projectType) !== a(j).BRIDGE.V ? (_(), h(E, { key: 0, modelValue: v.value, "onUpdate:modelValue": o[3] || (o[3] = (n) => v.value = n), options: O.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: ae }, null, 8, ["modelValue", "options"])) : R("", true)], 64)) : R("", true), l.value === a(u).ENCLOSURE.V || r.value === a(b).ENCLOSURE.V ? (_(), Y(se, { key: 2 }, [i(d, { modelValue: c.value, "onUpdate:modelValue": o[4] || (o[4] = (n) => c.value = n), options: A.value, type: "other", dataStructure: { key: "no", label: "name", value: "no" }, class: "filter-item", onChange: ye }, null, 8, ["modelValue", "options"]), i(E, { modelValue: s.value, "onUpdate:modelValue": o[5] || (o[5] = (n) => s.value = n), options: f.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择围护计划", class: "filter-item", style: { width: "200px" }, onChange: ae }, null, 8, ["modelValue", "options"])], 64)) : R("", true)]), L("div", eo, [a(U)(a(P).list) ? (_(), h(ge, { key: 0, value: M.value, hidden: M.value <= 0 }, { default: T(() => [i(C, { class: "filter-item", size: "default", type: "info", onClick: o[6] || (o[6] = (n) => N.value = true) }, { default: T(() => o[9] || (o[9] = [je("变更记录")])), _: 1, __: [9] })]), _: 1 }, 8, ["value", "hidden"])) : R("", true)])]), L("div", null, [a(U)(a(P).cost) && l.value !== a(u).ENCLOSURE.V ? (_(), h(Re, { key: 0, gutter: 20, class: "panel-group", style: { "margin-bottom": "10px" } }, { default: T(() => {
      var n, ue;
      return [i(X, { span: 8 }, { default: T(() => [i(a(H), { name: "项目造价（元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": B.value || 0, precision: a(x).contract }, null, 8, ["end-val", "precision"])]), _: 1 }), i(X, { span: 8 }, { default: T(() => [i(a(H), { name: "单体造价（元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": D.value || 0, precision: a(x).contract }, null, 8, ["end-val", "precision"])]), _: 1 }), ((n = a(I)) == null ? void 0 : n.projectType) !== a(j).BRIDGE.V ? (_(), h(X, { key: 0, span: ((ue = a(I)) == null ? void 0 : ue.projectType) === a(j).BRIDGE.V ? 12 : 8 }, { default: T(() => [i(a(H), { name: "选定区域造价（元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": G.value || 0, precision: a(x).contract }, null, 8, ["end-val", "precision"])]), _: 1 }, 8, ["span"])) : R("", true)];
    }), _: 1 })) : R("", true)])]), (_(), h(be(ce.value), { ref_key: "domRef", ref: K, onRefreshCount: oe, category: c.value, onShowLog: Ie }, null, 40, ["category"])), i(a(Ke), { modelValue: $.value, "onUpdate:modelValue": o[7] || (o[7] = (n) => $.value = n), projectId: m.value, type: l.value, monomerId: p.value, areaId: v.value, category: c.value, enclosurePlanId: s.value, projectType: (ne = V.value) == null ? void 0 : ne.projectType, relationType: r.value, onRefreshCount: oe, onSuccess: o[8] || (o[8] = (n) => te()) }, null, 8, ["modelValue", "projectId", "type", "monomerId", "areaId", "category", "enclosurePlanId", "projectType", "relationType"]), i(Te, { "append-to-body": "", "close-on-click-modal": false, visible: N.value, title: "变更记录", size: "80%", "before-close": () => {
      N.value = false;
    } }, { content: T(() => [i(a(He), { onRefreshData: te })]), _: 1 }, 8, ["visible", "before-close"])]);
  };
} }, No = we(oo, [["__scopeId", "data-v-0c77a00e"]]);
export {
  No as default
};
