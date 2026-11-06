import { ref as m } from "vue";
import { onMounted as S } from "vue";
import { provide as B } from "vue";
import { watch as H } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as g } from "vue";
import { withDirectives as U } from "vue";
import { unref as n } from "vue";
import { createBlock as c } from "vue";
import { withCtx as C } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as A } from "vue";
import { renderList as K } from "vue";
import { normalizeStyle as D } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as z } from "element-plus";
import { g as P, a as $, b as G, _ as J, c as W, d as X } from "./module/header.vue.js";
import { x as Y, pD as Z, o as w, a3 as Q, aU as ee, P as ae } from "../../../../../shared/runtime.js";
import "../../../../../modules/index-8356a01a.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
const te = { class: "app-container" }, se = { class: "head-container" }, ne = { key: 0, style: { color: "#13ce66" } }, re = { key: 1 }, ie = { key: 2 }, fe = { __name: "index", setup(oe) {
  const R = { add: false, edit: false, del: false, download: false }, _ = m(), h = m([]), { crud: e, CRUD: q, columns: u } = Y({ title: "生产跟踪", sort: [], optShow: { ...R }, permission: { ...Z }, crudApi: { artifactTrack: P }, requiredQuery: ["areaId", "areaBatchId"], hasPagination: true }, _), { maxHeight: N } = w({ extraBox: [".head-container"], paginate: true }), b = m();
  S(async () => {
    try {
      const t = await $();
      b.value = t || [];
    } catch (t) {
      console.log(t);
    }
  });
  const I = m([]);
  B("artifactTypeList", I), B("productionLineList", h);
  async function V() {
    if (e.query.areaId) try {
      const { content: t } = await W({ areaBatchId: e.query.areaBatchId, areaId: e.query.areaId, factoryId: e.query.factoryId, taskTypeEnum: e.query.processType });
      I.value = t || [];
    } catch (t) {
      console.log(t, "获取构件类型失败");
    }
  }
  async function O() {
    if (h.value = [], !!e.query.areaId) try {
      const t = await X({ areaBatchId: e.query.areaBatchId, areaId: e.query.areaId, factoryId: e.query.factoryId, taskTypeEnum: e.query.processType });
      for (const i in t) h.value.push({ id: i, name: t[i] });
    } catch (t) {
      console.log("获取生产线失败", t);
    }
  }
  return H([() => e.query.areaId, () => e.query.processType, () => e.query.factoryId, () => e.query.areaBatchId], (t) => {
    e.query.classificationId = void 0, V(), O();
  }, { immediate: true }), q.HOOK.beforeToQuery = async (t) => {
    t.crudApi.get = t.query.processType === Q.ARTIFACT.V ? P : G;
  }, q.HOOK.handleRefresh = (t, i) => {
    var o, f;
    i.data.content = (f = (o = i.data) == null ? void 0 : o.content) == null ? void 0 : f.map((p) => {
      var s;
      return p.processMap = {}, (s = p.process) == null || s.forEach((a) => {
        p.processMap[a.id] = a;
      }), p;
    });
  }, (t, i) => {
    const o = j, f = F("common-table"), p = z;
    return r(), d("div", te, [y("div", se, [g(J)]), U((r(), c(f, { ref_key: "tableRef", ref: _, data: n(e).data, "empty-text": n(e).emptyText, "max-height": n(N), "row-key": "projectId", style: { width: "100%" } }, { default: C(() => [g(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), n(u).visible("name") && n(e).query.processType === n(Q).ARTIFACT.V ? (r(), c(o, { prop: "name", key: "name", label: "名称", align: "center", "min-width": "120", fixed: "left" })) : l("", true), n(u).visible("serialNumber") ? (r(), c(o, { prop: "serialNumber", key: "serialNumber", label: "编号", align: "center", fixed: "left" })) : l("", true), n(u).visible("quantity") ? (r(), c(o, { prop: "quantity", key: "quantity", label: "清单数量", align: "center", fixed: "left", width: "100px" })) : l("", true), n(u).visible("specification") ? (r(), c(o, { prop: "specification", key: "specification", label: "规格", align: "center", fixed: "left", width: "220px" })) : l("", true), n(u).visible("taskQuantity") ? (r(), c(o, { label: "任务数", align: "center", width: "80px", prop: "taskQuantity", key: "taskQuantity" })) : l("", true), (r(true), d(A, null, K(b.value, (s) => (r(), d(A, { key: s.id }, [n(e).query.processType === s.productType && s.productionLineTypeEnum & n(ee).TRADITION.V ? (r(), c(o, { key: 0, label: s.name, align: "center" }, { default: C(({ row: a }) => {
      var T, k, x, v, M, L;
      return [a.processMap && a.processMap[s.id] && ((T = a.processMap[s.id]) == null ? void 0 : T.inspectionQuantity) === (a == null ? void 0 : a.quantity) && ((k = a.processMap[s.id]) == null ? void 0 : k.quantity) === (a == null ? void 0 : a.quantity) ? (r(), d("div", ne, " √ ")) : a.processMap && a.processMap[s.id] ? (r(), d("div", re, [y("span", { class: "tc-danger", style: D(((x = a.processMap[s.id]) == null ? void 0 : x.quantity) === 0 ? "color: #303133" : "") }, E((v = a.processMap[s.id]) == null ? void 0 : v.quantity), 5), i[0] || (i[0] = y("span", null, " / ", -1)), y("span", { style: D(((M = a.processMap[s.id]) == null ? void 0 : M.inspectionQuantity) === 0 ? "color: #1682e6" : "") }, E((L = a.processMap[s.id]) == null ? void 0 : L.inspectionQuantity), 5)])) : (r(), d("div", ie, i[1] || (i[1] = [y("span", null, " / ", -1)])))];
    }), _: 2 }, 1032, ["label"])) : l("", true)], 64))), 128))]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[p, n(e).loading]]), g(n(ae))]);
  };
} };
export {
  fe as default
};
