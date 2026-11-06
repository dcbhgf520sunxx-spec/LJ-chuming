import { ref as r } from "vue";
import { computed as $ } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as g } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as Z } from "vue";
import { unref as t } from "vue";
import { createBlock as d } from "vue";
import { toDisplayString as v } from "vue";
import { createCommentVNode as c } from "vue";
import { withModifiers as _ } from "vue";
import { Fragment as L } from "vue";
import { renderList as ee } from "vue";
import { ElTableColumn as te } from "element-plus";
import { vLoading as se } from "element-plus";
import { c as oe } from "../../../../modules/product-statistics-2cabaaff.js";
import { x as ae, ny as ie, a3 as b, o as le, bo as y, aU as re, P as ne } from "../../../../shared/runtime.js";
import { u as ue } from "../../../../modules/use-process-af1f8c99.js";
import pe from "./module/header.vue.js";
import de from "./module/total-raw-material-outbound.vue.js";
import ce from "./module/month-raw-material-outbound.vue.js";
import fe from "./module/task-detail.vue.js";
import he from "./module/process-detail.vue.js";
import ve from "./module/ups-detail.vue.js";
const ge = { class: "app-container" }, me = { class: "head-container" }, ye = ["onClick"], be = ["onClick"], we = ["onClick"], ke = ["onClick"], _e = { class: "tc-primary" }, xe = { class: "tc-primary" }, Ne = { key: 1 }, We = ["onClick"], $e = { __name: "index", setup(Te) {
  const P = r([["rawTotalNetWeight", ["to-fixed", 2]], ["rawTotalGrossWeight", ["to-fixed", 2]], ["rawNetWeight", ["to-fixed", 2]], ["rawGrossWeight", ["to-fixed", 2]], ["taskNetWeight", ["to-fixed", 2]], ["taskGrossWeight", ["to-fixed", 2]], ["finishNetWeight", ["to-fixed", 2]], ["finishGrossWeight", ["to-fixed", 2]], ["totalNetWeight", ["to-fixed", 2]], ["totalGrossWeight", ["to-fixed", 2]], ["lossNetWeight", ["to-fixed", 2]], ["lossGrossWeight", ["to-fixed", 2]]]), C = r(), x = r(false), E = r({}), N = r(false), I = r({}), W = r(false), S = r({}), T = r(false), D = r({}), R = r({}), V = r(false), G = r({}), U = { add: false, edit: false, del: false, download: false }, { crud: o, CRUD: B, columns: f } = ae({ title: "生产统计", sort: [], optShow: { ...U }, permission: { ...ie }, crudApi: { ...oe }, hasPagination: true }, C), { loaded: j, process: q } = ue(), O = $(() => {
    const l = q.value.filter((h) => h.productType === b.MACHINE_PART.V), s = q.value.filter((h) => h.productType === b.ASSEMBLE.V), a = q.value.filter((h) => h.productType === b.ARTIFACT.V);
    return [...l, ...s, ...a];
  }), F = $(() => ({ startDate: o.query.startDate, endDate: o.query.endDate }));
  B.HOOK.handleRefresh = (l, s) => {
    var a;
    s.data.content = (a = s.data.content) == null ? void 0 : a.map((m) => {
      var h;
      return m.processMap = {}, (h = m.processDTOList) == null || h.forEach((e) => {
        m.processMap[e.id] = e;
      }), m;
    });
  };
  const { maxHeight: H } = le({ extraBox: [".head-container"], paginate: true });
  function K(l) {
    x.value = true, E.value = l;
  }
  function Q(l) {
    N.value = true, I.value = l;
  }
  function z(l) {
    W.value = true, S.value = l;
  }
  function J(l, s) {
    T.value = true, D.value = s, R.value = l;
  }
  function X(l) {
    V.value = true, G.value = l;
  }
  return (l, s) => {
    const a = te, m = Y("common-table"), h = se;
    return i(), k("div", ge, [n("div", me, [g(pe, { ref: "headerRef" }, { viewLeft: p(() => s[5] || (s[5] = [])), _: 1 }, 512)]), Z((i(), d(m, { ref_key: "tableRef", ref: C, data: t(o).data, "empty-text": t(o).emptyText, "max-height": t(H), "data-format": P.value, "show-empty-symbol": false, "row-key": "id", style: { width: "100%" } }, { default: p(() => [g(a, { type: "index", prop: "index", label: "序号", align: "center", width: "60px", fixed: "left" }), t(f).visible("project") ? (i(), d(a, { key: 0, "show-overflow-tooltip": true, prop: "project", label: "项目", "header-align": "center", width: "160px", fixed: "left" }, { default: p(({ row: e }) => {
      var u, w;
      return [n("span", null, v(e.project ? ((u = e.project) == null ? void 0 : u.serialNumber) + "-" + ((w = e.project) == null ? void 0 : w.name) : "-"), 1)];
    }), _: 1 })) : c("", true), t(f).visible("unit") ? (i(), d(a, { key: 1, prop: "unit", label: "单位", align: "center", fixed: "left" })) : c("", true), t(f).visible("rawTotalNetWeight") ? (i(), d(a, { key: 2, "show-overflow-tooltip": true, prop: "rawTotalNetWeight", label: "原材料累计出库", align: "center", width: "130px", fixed: "left" }, { default: p(({ row: e }) => [n("span", { style: { cursor: "pointer" }, class: "tc-primary", onClick: _((u) => K(e), ["stop"]) }, v(t(o).query.weightStatus === t(y).NET.V ? e.rawTotalNetWeight : e.rawTotalGrossWeight), 9, ye)]), _: 1 })) : c("", true), t(f).visible("rawNetWeight") ? (i(), d(a, { key: 3, "show-overflow-tooltip": true, prop: "rawNetWeight", label: "原材料本月出库", align: "center", width: "130px", fixed: "left" }, { default: p(({ row: e }) => [n("span", { style: { cursor: "pointer" }, class: "tc-primary", onClick: _((u) => Q(e), ["stop"]) }, v(t(o).query.weightStatus === t(y).NET.V ? e.rawNetWeight : e.rawGrossWeight), 9, be)]), _: 1 })) : c("", true), t(f).visible("taskNetWeight") ? (i(), d(a, { key: 4, prop: "taskNetWeight", label: "任务量", align: "center", "show-overflow-tooltip": true, fixed: "left" }, { default: p(({ row: e }) => [n("span", { style: { cursor: "pointer" }, class: "tc-primary", onClick: _((u) => z(e), ["stop"]) }, v(t(o).query.weightStatus === t(y).NET.V ? e.taskNetWeight : e.taskGrossWeight), 9, we)]), _: 1 })) : c("", true), t(f).visible("unit") ? (i(), d(a, { key: 5, prop: "unit", label: "在制品", align: "center" }, { default: p(() => [(i(true), k(L, null, ee(O.value, (e) => (i(), k(L, { key: e.id }, [e.productType && t(b).ARTIFACT.V | e.productType && t(b).ASSEMBLE.V && e.productionLineTypeEnum & t(re).TRADITION.V && e.productType !== t(b).ENCLOSURE.V ? (i(), d(a, { key: 0, "show-overflow-tooltip": true, label: e.name, align: "center", width: "110px" }, { default: p(({ row: u }) => {
      var w, M, A;
      return [n("div", null, [u.processMap[e.id] ? (i(), k("div", { key: 0, onClick: _((Ve) => J(u, e), ["stop"]), style: { cursor: "pointer" } }, [n("span", _e, v((w = u.processMap[e.id]) == null ? void 0 : w.unQuantity), 1), s[6] || (s[6] = n("span", null, " / ", -1)), n("span", xe, v(t(o).query.weightStatus === t(y).NET.V ? (M = u.processMap[e.id]) == null ? void 0 : M.unNetWeight : (A = u.processMap[e.id]) == null ? void 0 : A.unGrossWeight), 1)], 8, ke)) : (i(), k("span", Ne, " - "))])];
    }), _: 2 }, 1032, ["label"])) : c("", true)], 64))), 128))]), _: 1 })) : c("", true), t(f).visible("finishNetWeight") ? (i(), d(a, { key: 6, prop: "finishNetWeight", label: "制成品", align: "center", "show-overflow-tooltip": true, fixed: "right" }, { default: p(({ row: e }) => [n("span", { style: { cursor: "pointer" }, class: "tc-primary", onClick: _((u) => X(e), ["stop"]) }, v(t(o).query.weightStatus === t(y).NET.V ? e.finishNetWeight : e.finishGrossWeight), 9, We)]), _: 1 })) : c("", true), t(f).visible("totalNetWeight") ? (i(), d(a, { key: 7, "show-overflow-tooltip": true, prop: "totalNetWeight", label: `合计
（在制品+制成品）`, align: "center", width: "140px", fixed: "right" }, { default: p(({ row: e }) => [n("span", null, v(t(o).query.weightStatus === t(y).NET.V ? e.totalNetWeight : e.totalGrossWeight), 1)]), _: 1 })) : c("", true), t(f).visible("lossNetWeight") ? (i(), d(a, { key: 8, prop: "lossNetWeight", label: "损耗量", align: "center", "show-overflow-tooltip": true, fixed: "right" }, { default: p(({ row: e }) => [n("span", null, v(t(o).query.weightStatus === t(y).NET.V ? e.lossNetWeight : e.lossGrossWeight), 1)]), _: 1 })) : c("", true), t(f).visible("lossRate") ? (i(), d(a, { key: 9, prop: "lossRate", label: "损耗率", align: "center", fixed: "right" }, { default: p(({ row: e }) => [n("span", null, v(e.lossRate) + "%", 1)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[h, t(o).loading || !t(j)]]), g(t(ne)), g(de, { visible: x.value, "onUpdate:visible": s[0] || (s[0] = (e) => x.value = e), info: E.value }, null, 8, ["visible", "info"]), g(ce, { visible: N.value, "onUpdate:visible": s[1] || (s[1] = (e) => N.value = e), info: I.value, "time-query": F.value }, null, 8, ["visible", "info", "time-query"]), g(fe, { visible: W.value, "onUpdate:visible": s[2] || (s[2] = (e) => W.value = e), "task-info": S.value, workshopId: t(o).query.workshopId, "query-date": t(o).query.date }, null, 8, ["visible", "task-info", "workshopId", "query-date"]), g(he, { visible: T.value, "onUpdate:visible": s[3] || (s[3] = (e) => T.value = e), "process-info": D.value, "process-data": R.value, workshopId: t(o).query.workshopId }, null, 8, ["visible", "process-info", "process-data", "workshopId"]), g(ve, { visible: V.value, "onUpdate:visible": s[4] || (s[4] = (e) => V.value = e), "ups-info": G.value, workshopId: t(o).query.workshopId, "query-date": t(o).query.date }, null, 8, ["visible", "ups-info", "workshopId", "query-date"])]);
  };
} };
export {
  $e as default
};
