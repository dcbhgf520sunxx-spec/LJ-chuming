import { inject as M } from "vue";
import { computed as G } from "vue";
import { ref as y } from "vue";
import { watch as L } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as $ } from "vue";
import { createElementVNode as k } from "vue";
import { createBlock as p } from "vue";
import { withCtx as b } from "vue";
import { toDisplayString as R } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as u } from "vue";
import { createVNode as g } from "vue";
import { createTextVNode as z } from "vue";
import { withDirectives as J } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { d as ee, p as te } from "../../../../../modules/wage-adjust-5476478d.js";
import { a3 as ae, x as oe, o as se, bW as ne, cf as I, aT as re, P as le, a9 as ie } from "../../../../../shared/runtime.js";
import { p as pe } from "../../../../../modules/mes-ee117a22.js";
import ue from "./module/header.vue.js";
import ce from "../module/edit-dialog.vue.js";
import "../../../../../modules/use-table-change-32e98420.js";
import "../module/edit-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const de = { class: "app-container" }, me = { class: "head-container" }, _e = { __name: "index", props: { fQuery: { type: Object, default: () => {
} }, fInfo: { type: Object, default: () => {
} } }, setup(x, { expose: j }) {
  const O = M("permission"), d = x, T = G(() => {
    var t;
    return ((t = d.fQuery) == null ? void 0 : t.taskTypeEnum) || ae.ARTIFACT.V;
  }), A = { add: false, edit: false, del: false, download: false }, D = y(), Q = y(), { crud: r, columns: c, CRUD: q } = oe({ title: "工价调整", permission: { ...O }, optShow: { ...A }, crudApi: { get: ee }, sort: [], requiredQuery: ["processId"], hasPagination: true, queryOnPresenterCreated: false }, Q), { maxHeight: H } = se({ paginate: true }), f = y([]), m = y({}), w = y([]), _ = y(false);
  q.HOOK.beforeToQuery = async (t) => {
    var s, a, o, n, v, h;
    t.query.monomerId = (s = d.fQuery) == null ? void 0 : s.monomerId, t.query.areaId = (a = d.fQuery) == null ? void 0 : a.areaId, t.query.projectId = (o = d.fQuery) == null ? void 0 : o.projectId, t.query.taskTypeEnum = (n = d.fQuery) == null ? void 0 : n.taskTypeEnum, t.query.configId = (h = (v = d.fInfo) == null ? void 0 : v.productClass) == null ? void 0 : h.id;
  }, q.HOOK.handleRefresh = (t, s) => {
    s.data.content = s.data.content.map((a, o) => {
      var n;
      return a.rowId = o + "" + Math.random(), a.taskTypeEnum = (n = d.fQuery) == null ? void 0 : n.taskTypeEnum, a.processId = t.query.processId, a.sourceWage = a.wage, a.sourceIntermediatePaintWage = a.intermediatePaintWage, a.sourcePrimerWage = a.primerWage, a.sourceTopcoatWage = a.topcoatWage, a;
    });
  }, L(() => T.value, () => {
    r.data = [], f.value = [], m.value = {};
  });
  function S(t) {
    w.value = t;
  }
  function U() {
    var t;
    if (!((t = w.value) != null && t.length)) {
      X.warning("请至少选择一条数据");
      return;
    }
    _.value = true;
  }
  async function B(t) {
    var s, a, o;
    try {
      const { content: n } = await te({ taskTypeEnum: T.value, configId: (s = t == null ? void 0 : t.productClass) == null ? void 0 : s.id });
      f.value = n, m.value = ie(n, "id"), (a = f.value) != null && a.length && (r.query.processId = (o = f.value[0]) == null ? void 0 : o.id), r.toQuery();
    } catch (n) {
      console.log(n, "获取工序失败");
    }
  }
  function F(t) {
    var s, a, o, n;
    if (((a = (s = m.value) == null ? void 0 : s[t.processId]) == null ? void 0 : a.type) !== I.PAINT.V) return t.wageQuotaType !== null;
    if (((n = (o = m.value) == null ? void 0 : o[t.processId]) == null ? void 0 : n.type) === I.PAINT.V) return !(!t.primerWageQuotaType && !t.topcoatWageQuotaType && !t.intermediatePaintWageQuotaType);
  }
  return j({ fetchProcess: B }), (t, s) => {
    var h, C;
    const a = N("common-button"), o = Y, n = N("common-table"), v = Z;
    return l(), $("div", de, [k("div", me, [(h = f.value) != null && h.length ? (l(), p(e(ne), { key: 0, modelValue: e(r).query.processId, "onUpdate:modelValue": s[0] || (s[0] = (i) => e(r).query.processId = i), class: "filter-item", style: { width: "100%" }, data: f.value, itemKey: "id", onChange: e(r).toQuery }, { default: b(({ item: i }) => [k("span", null, R(i.name), 1)]), _: 1 }, 8, ["modelValue", "data", "onChange"])) : u("", true), g(e(ue), { ref_key: "headRef", ref: D, fInfo: x.fInfo }, { btn: b(() => {
      var i;
      return [g(a, { type: "primary", size: "default", onClick: U, disabled: !((i = w.value) != null && i.length) }, { default: b(() => s[2] || (s[2] = [z("批量调整")])), _: 1, __: [2] }, 8, ["disabled"])];
    }), _: 1 }, 8, ["fInfo"])]), J((l(), p(n, { ref_key: "tableRef", ref: Q, data: e(r).data, "data-format": e(pe)[T.value], "empty-text": e(r).emptyText, "show-empty-symbol": false, "max-height": e(H) - 50, "row-key": "rowId", style: { width: "100%" }, onSelectionChange: S }, { default: b(() => {
      var i, W, V, E;
      return [g(o, { type: "selection", selectable: F, align: "center", width: "60" }), g(o, { label: "序号", type: "index", align: "center", width: "60" }), e(c).visible("monomer.name") ? (l(), p(o, { key: 0, "show-overflow-tooltip": "", prop: "monomer.name", label: "单体", align: "center", "min-width": "100px" })) : u("", true), e(c).visible("area.name") ? (l(), p(o, { key: 1, "show-overflow-tooltip": "", prop: "area.name", label: "区域", align: "center", "min-width": "100px" })) : u("", true), e(c).visible("serialNumber") ? (l(), p(o, { key: 2, "show-overflow-tooltip": "", prop: "serialNumber", label: "编号", align: "center", "min-width": "100px" })) : u("", true), e(c).visible("specification") ? (l(), p(o, { key: 3, "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "110px" })) : u("", true), e(c).visible("quantity") ? (l(), p(o, { key: 4, "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center", "min-width": "70px" })) : u("", true), e(c).visible("netWeight") ? (l(), p(o, { key: 5, "show-overflow-tooltip": "", prop: "netWeight", label: "单净重(kg)", align: "center", "min-width": "90px" })) : u("", true), e(c).visible("grossWeight") ? (l(), p(o, { key: 6, "show-overflow-tooltip": "", prop: "grossWeight", label: "单毛重(kg)", align: "center", "min-width": "90px" })) : u("", true), e(c).visible("wageQuotaType") && ((W = (i = m.value) == null ? void 0 : i[e(r).query.processId]) == null ? void 0 : W.type) !== e(I).PAINT.V ? (l(), p(o, { key: 7, "show-overflow-tooltip": "", prop: "wageQuotaType", label: "核算单位", align: "center" }, { default: b(({ row: K }) => {
        var P;
        return [k("span", null, R((P = e(re).V[K.wageQuotaType]) == null ? void 0 : P.meteUnit), 1)];
      }), _: 1 })) : u("", true), e(c).visible("wage") && ((E = (V = m.value) == null ? void 0 : V[e(r).query.processId]) == null ? void 0 : E.type) !== e(I).PAINT.V ? (l(), p(o, { key: 8, "show-overflow-tooltip": "", prop: "wage", label: "定额单价", align: "center" })) : u("", true)];
    }), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[v, e(r).loading]]), g(e(le)), g(e(ce), { visible: _.value, "onUpdate:visible": s[1] || (s[1] = (i) => _.value = i), selections: w.value, processInfo: (C = m.value) == null ? void 0 : C[e(r).query.processId], onRefresh: e(r).toQuery }, null, 8, ["visible", "selections", "processInfo", "onRefresh"])]);
  };
} };
export {
  _e as default
};
