import { ref as r } from "vue";
import { computed as y } from "vue";
import { watch as w } from "vue";
import { cloneDeep as d } from "lodash";
import { resolveComponent as J } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as a } from "vue";
import { unref as f } from "vue";
import { Fragment as _ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as x } from "vue";
import { withDirectives as Y } from "vue";
import { createBlock as G } from "vue";
import { normalizeStyle as Q } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { mergeProps as R } from "vue";
import { ElCheckbox as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { _ as te, sD as L, b as oe, kc as se, sJ as N, iX as ie, jN as le } from "../../../../../../../shared/runtime.js";
import ae from "./tech-list/structure.vue.js";
import re from "./tech-list/enclosure.vue.js";
import ne from "./tech-list/aux-material.vue.js";
import ce from "./match-table.vue.js";
import { _ as ue } from "./tech-add-form.vue.js";
import "../../../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../../../modules/use-table-operate-4f84437f.js";
const de = { class: "list-container" }, pe = { class: "filter-container" }, fe = { class: "filter-right-box" }, he = { class: "filter-item" }, me = { class: "match-container" }, ve = { class: "match-table-wrapper" }, ye = { __name: "index", props: { height: { type: Number, default: 250 } }, emits: ["selected-change"], setup(A, { emit: K }) {
  const M = K, V = A, k = r(), E = r(), C = r(false), c = r(), u = r(), i = r(), S = y(() => o.form.technologyListType === L.STRUCTURE.V), h = r({ boolPreparationLessThanList: false }), U = y(() => o.props.boolTechEditMode ? u.value : c.value ? c.value.filter((t) => {
    let e = true;
    if (h.value.boolPreparationLessThanList) {
      const s = o.props.techPrepMeteKV[t.id];
      e = oe(s) || !s.isEnough;
    }
    return e;
  }) : []), D = y(() => o.props.boolTechEditMode ? i.value : o.props.techPrepMeteKV), { CRUD: I, crud: o } = se(), P = o.form, O = y(() => {
    switch (P.technologyListType) {
      case L.STRUCTURE.V:
        return ae;
      case L.ENCLOSURE.V:
        return re;
      case L.AUXILIARY_MATERIAL.V:
        return ne;
      default:
        return null;
    }
  });
  w(() => o.form.technologyList, (t) => {
    if (Array.isArray(t) && (t.sort(H), c.value = d(o.form.technologyList), o.props.boolTechEditMode && u.value)) {
      const e = o.props.technologyListKV;
      u.value.forEach((s) => {
        var l, m;
        s.boundPurIds = (l = e[s.id]) == null ? void 0 : l.boundPurIds, s.boundInvIds = (m = e[s.id]) == null ? void 0 : m.boundInvIds;
      });
    }
  }, { immediate: true, deep: true }), w(() => o.props.techPrepMeteKV, (t) => {
    o.props.boolTechEditMode && typeof i.value == "object" && Object.getOwnPropertyNames(i.value).forEach((s) => {
      const l = i.value[s].listMete;
      i.value[s] = d(t[s]), i.value[s].listMete = l;
    });
  }, { deep: true }), I.HOOK.beforeToEdit = (t, e) => {
    z();
  }, I.HOOK.beforeEditDetailLoaded = (t, e) => {
  };
  function z() {
    X(), h.value.boolPreparationLessThanList = false, u.value = void 0, i.value = void 0;
  }
  function B(t) {
    E.value = t, M("selected-change", t);
  }
  function j(t) {
    t.forEach((e) => {
      const s = {};
      s.purchase = 0, s.preparation = 0, s.diff = ie(s.preparation, le.weight.precision), s.isEnough = s.diff >= 0, o.props.techPrepMeteKV[e.id] = s;
    }), o.form.technologyList = [...c.value, ...t];
  }
  function $() {
    o.props.boolTechEditMode = true, u.value = d(c.value), i.value = d(o.props.techPrepMeteKV);
  }
  function F() {
    o.form.technologyList = d(u.value), o.props.techPrepMeteKV = d(i.value), o.props.boolTechEditMode = false;
  }
  function q() {
    o.props.boolTechEditMode = false;
  }
  function H(t, e) {
    return t.steelClassifyConfId === e.steelClassifyConfId ? t.material === e.material ? N.test(t.specification) && N.test(e.specification) ? Number(t.specification) < Number(e.specification) ? -1 : 1 : t.specification < e.specification ? -1 : 1 : t.material < e.material ? -1 : 1 : t.steelClassifyConfId < e.steelClassifyConfId ? -1 : 1;
  }
  function X(t) {
    E.value = t, k.value.setCurrentRow(t), M("selected-change", t);
  }
  return (t, e) => {
    const s = Z, l = J("common-button"), m = ee;
    return p(), g(_, null, [a("div", R(t.$attrs, { class: "list-and-batch flex-rbs" }), [a("div", de, [a("div", pe, [e[7] || (e[7] = a("div", { class: "filter-left-box" }, [a("span", { class: "table-title" }, "清单汇总列表")], -1)), a("div", fe, [f(o).form.withoutList ? (p(), g(_, { key: 0 }, [f(o).props.boolTechEditMode ? (p(), g(_, { key: 1 }, [n(l, { class: "filter-item", size: "default", type: "primary", onClick: F }, { default: b(() => e[5] || (e[5] = [T("保 存")])), _: 1, __: [5] }), n(l, { class: "filter-item", size: "default", type: "danger", onClick: q }, { default: b(() => e[6] || (e[6] = [T("取 消")])), _: 1, __: [6] })], 64)) : (p(), g(_, { key: 0 }, [a("div", he, [n(s, { modelValue: h.value.boolPreparationLessThanList, "onUpdate:modelValue": e[0] || (e[0] = (v) => h.value.boolPreparationLessThanList = v), label: "只显示备料量小于清单量", size: "default", border: "" }, null, 8, ["modelValue"])]), n(l, { class: "filter-item", type: "success", size: "default", onClick: e[1] || (e[1] = (v) => C.value = true) }, { default: b(() => e[3] || (e[3] = [T(" 添 加 ")])), _: 1, __: [3] }), n(l, { class: "filter-item", type: "warning", size: "default", onClick: $ }, { default: b(() => e[4] || (e[4] = [T("编 辑")])), _: 1, __: [4] })], 64))], 64)) : x("", true)])]), f(P).technologyListType ? Y((p(), G(W(O.value), { key: 0, ref_key: "technologyListRef", ref: k, list: U.value, "tech-prep-mete-k-v": D.value, height: V.height, stripe: false, "edit-mode": f(o).props.boolTechEditMode, "highlight-current-row": "", onRowClick: B, style: Q({ width: S.value ? "750px" : "900px" }) }, null, 40, ["list", "tech-prep-mete-k-v", "height", "edit-mode", "style"])), [[m, f(o).editDetailLoading]]) : x("", true)]), a("div", me, [a("div", ve, [n(ce, R(t.$attrs, { height: V.height, matchInfo: E.value }), null, 16, ["height", "matchInfo"])])])], 16), n(ue, { modelValue: C.value, "onUpdate:modelValue": e[2] || (e[2] = (v) => C.value = v), "technology-list": c.value, onSuccess: j }, null, 8, ["modelValue", "technology-list"])], 64);
  };
} }, ke = te(ye, [["__scopeId", "data-v-80d9aa6b"]]);
export {
  ke as default
};
