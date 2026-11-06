import { ref as f } from "vue";
import { watch as k } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as B } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as K } from "vue";
import { createVNode as i } from "vue";
import { createBlock as E } from "vue";
import { createCommentVNode as g } from "vue";
import { Fragment as H } from "vue";
import { withCtx as j } from "vue";
import { a as z } from "../../../../../../modules/area-ca564e60.js";
import { m as F, K as S, kM as s, F as G, B as X, bN as Z, q as M, T as v, E as Y } from "../../../../../../shared/runtime.js";
import { u as J } from "../../../../../../modules/use-dashboard-header-292e247c.js";
import { C as W } from "../../../../../../modules/index-d6a37d29.js";
import { S as _ } from "../../../../../../modules/index-21d3d7d7.js";
const $ = { class: "head-container" }, ne = { __name: "header", props: { globalProject: { type: Object, default: () => {
} }, projectId: { type: [Number, String], default: void 0 } }, emits: "load", setup(T, { expose: U, emit: A }) {
  const { installTypeEnumArr: O } = F("installTypeEnumArr"), d = T, R = { productType: d.globalProject.projectType === S.STEEL.V ? s.ARTIFACT.V : G.BOX.V, monomerId: { value: void 0, resetAble: false }, category: void 0, areaId: { value: void 0, resetAble: false }, receivingStatus: void 0 }, { crud: a, query: t, CRUD: I } = X(R), w = A, m = f(1), C = { key: "id", label: "name", value: "id" }, p = f([]), n = f([]), { colors: q, boxZoomOut: N, getColor: L } = J({ colorCardTitles: ["未收货", "部分收货", "全部收货"], emit: w, crud: a });
  k(() => d.projectId, (l) => {
    l && (a.query.projectId = d.projectId, p.value = [], a.query.productType === s.ENCLOSURE.V && V(), a.toQuery());
  }, { immediate: true, deep: true }), I.HOOK.beforeRefresh = () => (a.query.projectId = d.globalProject.businessType === Z.INSTALLATION.V ? d.globalProject.id : void 0, !!a.query.projectId), I.HOOK.handleRefresh = (l, o) => {
    o.data.content = o.data.content.map((u) => (u.boxColor = L(u, { quantity: "receivingQuantity", compare: "quantity" }), u));
  };
  function P(l) {
    n.value = l || [], n.value.length > 0 && (a.query.areaId = n.value[0].id);
  }
  function x(l) {
    t.areaId = void 0, l === s.ENCLOSURE.V && V(), a.toQuery();
  }
  function Q(l) {
    var o;
    n.value = ((o = p.value) == null ? void 0 : o.filter((u) => u.category === l)) || [], a.toQuery();
  }
  async function V() {
    var l;
    if (a.query.monomerId = void 0, n.value = [], d.projectId) try {
      const o = await z(d.projectId) || [];
      p.value = o || [], a.query.category ? n.value = (l = p.value) == null ? void 0 : l.filter((u) => u.category === a.query.category) : n.value = p.value;
    } catch (o) {
      console.log("获取项目所有围护计划", o);
    }
  }
  return U({ boxScale: m }), (l, o) => {
    const u = b("common-radio-button"), y = b("common-select");
    return c(), h("div", $, [B(K("div", null, [i(u, { modelValue: e(t).productType, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(t).productType = r), options: e(O), type: "enum", class: "filter-item", onChange: x }, null, 8, ["modelValue", "options"]), e(t).productType !== e(s).ENCLOSURE.V ? (c(), E(e(M), { key: 0, ref: "monomerSelectRef", modelValue: e(t).monomerId, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(t).monomerId = r), "project-id": e(t).projectId, "main-product-type": T.globalProject.projectType === e(S).STEEL.V && e(t).productType !== e(s).AUXILIARY.V ? e(t).productType : "", clearable: "", class: "filter-item", onChange: e(a).toQuery, onGetAreaInfo: P }, null, 8, ["modelValue", "project-id", "main-product-type", "onChange"])) : g("", true), e(t).productType !== e(s).AUXILIARY.V && e(t).productType !== e(s).ENCLOSURE.V ? (c(), E(y, { key: 1, modelValue: e(t).areaId, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(t).areaId = r), options: n.value, type: "other", dataStructure: C, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : g("", true), e(t).productType === e(s).ENCLOSURE.V ? (c(), h(H, { key: 2 }, [i(y, { modelValue: e(t).category, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(t).category = r), options: e(v).ENUM, "unshow-options": [e(v).STRUCTURE.K, e(v).BRIDGE.K], type: "enum", size: "default", clearable: "", placeholder: "请选择围护类型", class: "filter-item", style: { width: "200px" }, onChange: Q }, null, 8, ["modelValue", "options", "unshow-options"]), i(y, { modelValue: e(t).areaId, "onUpdate:modelValue": o[4] || (o[4] = (r) => e(t).areaId = r), options: n.value, type: "other", dataStructure: C, size: "default", clearable: "", placeholder: "请选择批次", class: "filter-item", style: { width: "200px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 64)) : g("", true)], 512), [[D, e(a).searchToggle]]), i(e(Y), { "show-grid": false, "show-refresh": false }, { optRight: j(() => [i(e(W), { class: "filter-item", value: e(t).receivingStatus, "onUpdate:value": o[5] || (o[5] = (r) => e(t).receivingStatus = r), colors: e(q), "color-border": "", "select-able": "", onChange: e(a).toQuery }, null, 8, ["value", "colors", "onChange"])]), viewLeft: j(() => [i(e(_), { class: "filter-item", value: m.value, "onUpdate:value": o[6] || (o[6] = (r) => m.value = r), intervals: 400, onZoomOut: e(N) }, null, 8, ["value", "onZoomOut"])]), _: 1 })]);
  };
} };
export {
  ne as default
};
