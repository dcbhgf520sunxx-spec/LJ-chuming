import { ref as P } from "vue";
import { watch as G } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as D } from "vue";
import { unref as l } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as p } from "vue";
import { withCtx as g } from "vue";
import { createCommentVNode as m } from "vue";
import { Fragment as _ } from "vue";
import { renderList as L } from "vue";
import { normalizeClass as b } from "vue";
import { normalizeStyle as K } from "vue";
import { toDisplayString as v } from "vue";
import { withModifiers as O } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { c as Y, _ as z } from "./module/detail.vue.js";
import { _ as W, m as J, x as Z, o as k, kQ as d, K as B, D as N, G as ee } from "../../../shared/runtime.js";
import { G as j } from "../../../modules/project-19a12d6b.js";
import te from "./module/header.vue.js";
const ae = { class: "app-container" }, oe = { key: 1, class: "sandwich-cell-bottom" }, re = { key: 1, class: "sandwich-cell-bottom" }, le = { key: 1, class: "sandwich-cell-bottom" }, ie = { key: 1, class: "sandwich-cell-bottom" }, se = ["onClick"], ne = { key: 1, class: "sandwich-cell-bottom" }, ce = { key: 1, class: "sandwich-cell-bottom" }, de = ["onClick"], ue = { key: 1, class: "sandwich-cell-bottom" }, pe = { key: 1, class: "sandwich-cell-bottom" }, ye = { __name: "index", setup(he) {
  const { globalProjectId: C, globalProject: R } = J(["globalProjectId", "globalProject"]), q = { add: false, edit: false, del: false, download: false }, E = P(), V = P({}), M = P(""), x = P(false), { crud: w, columns: y, CRUD: U } = Z({ title: "生产进度", sort: ["id.desc"], permission: { ...j }, optShow: { ...q }, requiredQuery: ["projectId"], crudApi: { ...Y }, hasPagination: false }, E), { maxHeight: F } = k({ wrapperBox: ".subcontract-plan", paginate: true, extraHeight: 100 });
  G(() => C.value, (T) => {
    T && (w.query.projectId = C.value, w.query.monomerId = void 0, w.toQuery());
  }, { immediate: true, deep: true }), U.HOOK.beforeRefresh = () => (w.query.projectId = C.value || void 0, !!w.query.projectId), U.HOOK.handleRefresh = (T, h) => {
    var c;
    h.data.content = h.data || [], (c = h.data.content) == null || c.forEach((i, A) => {
      var e, t, s, u, f, S;
      i.map = /* @__PURE__ */ new Map(), i.productTypeMap = {}, (e = i.manageAreaList) == null || e.forEach((o) => {
        o.unit = o.projectPlanProductCategory === d.STRUCTURE.V || R.value.projectType === B.BRIDGE.V ? "t" : "m", o.decimal = o.projectPlanProductCategory === d.STRUCTURE.V || R.value.projectType === B.BRIDGE.V ? N.COM_WT__KG : N.MES_ENCLOSURE_L__M;
      }), i.structureList = (t = i.manageAreaList) == null ? void 0 : t.filter((o) => o.projectPlanProductCategory === d.STRUCTURE.V), i.enclosureList = (s = i.manageAreaList) == null ? void 0 : s.filter((o) => o.projectPlanProductCategory === d.ENCLOSURE.V), i.auxiliaryList = (u = i.manageAreaList) == null ? void 0 : u.filter((o) => o.projectPlanProductCategory === d.AUXILIARY_MATERIAL.V), i.productTypeList = [...i.structureList, ...i.enclosureList, ...i.auxiliaryList], (f = i.productTypeList) == null || f.forEach((o) => {
        o.deepenRate = o != null && o.deepenMete && o.budgetVolume ? (o.deepenMete / o.budgetVolume * 100).toFixed(2) + "%" : "-", o.produceRate = o != null && o.produceMete && o.budgetVolume ? (o.produceMete / o.budgetVolume * 100).toFixed(2) + "%" : "-";
      }), i.productTypeMap = (S = i.productTypeList) == null ? void 0 : S.filter((o) => !i.map.has(o.projectPlanProductCategory) && i.map.set(o.projectPlanProductCategory, o));
    }), console.log(h.data.content, "data.data.content");
  };
  function I(T, h) {
    ee(j.detail) && (M.value = h, V.value = T, x.value = true);
  }
  return (T, h) => {
    const c = Q, i = $("common-table"), A = X;
    return a(), r(_, null, [n("div", ae, [D(l(te)), H((a(), p(i, { ref_key: "tableRef", ref: E, data: l(w).data, "empty-text": l(w).emptyText, "max-height": l(F), "return-source-data": "", showEmptySymbol: false, stripe: false, class: "upload-table", style: { width: "100%", "margin-top": "10px" } }, { default: g(() => [l(y).visible("name") ? (a(), p(c, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "单体" })) : m("", true), l(y).visible("type") ? (a(), p(c, { key: "type", prop: "type", label: "类别", align: "center" }, { default: g((e) => [e.row.productTypeMap.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeMap, (t, s) => (a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeMap.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top"), style: K(`height: ${t.projectPlanProductCategory === l(d).STRUCTURE.V ? e.row.structureList.length * 40 : t.projectPlanProductCategory === l(d).ENCLOSURE.V ? e.row.enclosureList.length * 40 : t.projectPlanProductCategory === l(d).AUXILIARY_MATERIAL.V ? e.row.auxiliaryList.length * 40 : 40}px; line-height: ${t.projectPlanProductCategory === l(d).STRUCTURE.V ? e.row.structureList.length * 30 + 10 : t.projectPlanProductCategory === l(d).ENCLOSURE.V ? e.row.enclosureList.length * 30 + 10 : t.projectPlanProductCategory === l(d).AUXILIARY_MATERIAL.V ? e.row.auxiliaryList.length * 30 + 10 : 30}px`) }, v(t.projectPlanProductCategory ? l(d).VL[t.projectPlanProductCategory] : "-"), 7)]))), 128)) : (a(), r("div", oe, "-"))]), _: 1 })) : m("", true), l(y).visible("unit") ? (a(), p(c, { key: "unit", prop: "unit", label: "区域", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => (a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(t.name), 3)]))), 128)) : (a(), r("div", re, "-"))]), _: 1 })) : m("", true), l(y).visible("unit") ? (a(), p(c, { key: "unit", prop: "unit", label: "单位", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => (a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n("span", null, v(t.unit || "-"), 1)], 2)]))), 128)) : (a(), r("div", le, "-"))]), _: 1 })) : m("", true), l(y).visible("areaList") ? (a(), p(c, { key: "areaList", prop: "areaList", label: "合同量", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => {
      var u;
      return a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n("span", null, v(((u = t.budgetVolume) == null ? void 0 : u.toFixed(t.decimal)) || "-"), 1)], 2)]);
    }), 128)) : (a(), r("div", ie, "-"))]), _: 1 })) : m("", true), l(y).visible("areaList") ? (a(), p(c, { key: "areaList", prop: "areaList", label: "深化完成", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => {
      var u;
      return a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: O((f) => I(t, "deepen"), ["stop"]) }, v(((u = t.deepenMete) == null ? void 0 : u.toFixed(t == null ? void 0 : t.decimal)) || "-"), 9, se)], 2)]);
    }), 128)) : (a(), r("div", ne, "-"))]), _: 1 })) : m("", true), l(y).visible("deepenRate") ? (a(), p(c, { key: "deepenRate", prop: "deepenRate", label: "完成率", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => (a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n("span", null, v(t.deepenRate || "-"), 1)], 2)]))), 128)) : (a(), r("div", ce, "-"))]), _: 1 })) : m("", true), l(y).visible("areaList") ? (a(), p(c, { key: "areaList", prop: "areaList", label: "生产完成", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => {
      var u;
      return a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n("span", { class: "tc-primary", style: { cursor: "pointer" }, onClick: O((f) => I(t, "product"), ["stop"]) }, v(((u = t.produceMete) == null ? void 0 : u.toFixed(t == null ? void 0 : t.decimal)) || "-"), 9, de)], 2)]);
    }), 128)) : (a(), r("div", ue, "-"))]), _: 1 })) : m("", true), l(y).visible("produceRate") ? (a(), p(c, { key: "produceRate", prop: "produceRate", label: "完成率", align: "center" }, { default: g((e) => [e.row.productTypeList.length > 0 ? (a(true), r(_, { key: 0 }, L(e.row.productTypeList, (t, s) => (a(), r("div", { key: t.id }, [n("div", { class: b(s === e.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [n("span", null, v(t.produceRate || "-"), 1)], 2)]))), 128)) : (a(), r("div", pe, "-"))]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[A, l(w).loading]])]), D(z, { modelValue: x.value, "onUpdate:modelValue": h[0] || (h[0] = (e) => x.value = e), "detail-data": V.value, permission: l(j), showType: M.value, globalProject: l(R) }, null, 8, ["modelValue", "detail-data", "permission", "showType", "globalProject"])], 64);
  };
} }, be = W(ye, [["__scopeId", "data-v-9cda771e"]]);
export {
  be as default
};
