import { ref as z } from "vue";
import { provide as ce } from "vue";
import { computed as me } from "vue";
import { resolveComponent as pe } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as q } from "vue";
import { unref as a } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as ue } from "vue";
import { toDisplayString as N } from "vue";
import { withDirectives as de } from "vue";
import { createBlock as y } from "vue";
import { normalizeClass as H } from "vue";
import { createCommentVNode as f } from "vue";
import { withModifiers as he } from "vue";
import { Fragment as G } from "vue";
import { renderList as Y } from "vue";
import { ElTag as ge } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { InfoFilled as _e } from "@element-plus/icons-vue";
import { ElIcon as ye } from "element-plus";
import { ElTooltip as fe } from "element-plus";
import { vLoading as Te } from "element-plus";
import { c as xe } from "../../../../modules/scheduling-data-3ad04307.js";
import { _ as We, x as be, rE as oe, o as Ge, bo as Re, jg as _, p as ae } from "../../../../shared/runtime.js";
import Ae from "./module/header.vue.js";
import je from "./module/scheduling-detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Fe = { class: "app-container" }, Ee = { class: "head-container" }, qe = { class: "table-header" }, Ce = { style: { display: "inline-block" } }, Me = { key: 1 }, Ve = { key: 0 }, ve = { key: 0 }, Ie = { key: 0 }, ke = { key: 1 }, Le = { __name: "index", setup(He) {
  const le = { add: false, edit: false, del: false, download: false }, R = z([]);
  for (let m = 1; m <= 12; m++) R.value.push(m);
  const $ = z(), U = z([]), w = z(false), { crud: n, columns: C, CRUD: se } = be({ title: "排产数据", sort: [], permission: { ...oe }, optShow: { ...le }, invisibleColumns: [], crudApi: { ...xe }, hasPagination: true }, $);
  ce("permission", oe);
  const { maxHeight: re } = Ge({ extraBox: [".head-container", ".table-header"], paginate: true, extraHeight: 40 }), A = me(() => n.query.weightType === Re.NET.V);
  se.HOOK.handleRefresh = (m, { data: h }) => {
    U.value = [];
    let j = 0, c = 0, F = 0, E = 0, M = [], V = [], v = [], t = 0, p = 0, W = 0, g = 0;
    const T = [], P = [], K = [], J = [], Q = [], X = [];
    let I = [], k = [], D = [], O = [], B = [];
    if (h.content = h == null ? void 0 : h.map((o) => {
      var S, Z;
      M = [], V = [], v = [], I = [], k = [], D = [], O = [], B = [], o.type = 1, o.projectName = o.project && o.project.shortName ? o.project.serialNumber + " " + o.project.shortName : "-", o.monomerName = o.monomer && o.monomer.name ? o.monomer.name : "-", o.completeRateNet = o.schedulingTotalNetWeight ? (o.completeTotalNetWeight / o.schedulingTotalNetWeight * 100).toFixed(2) : 0, o.completeRateGross = o.schedulingTotalGrossWeight ? (o.completeTotalGrossWeight / o.schedulingTotalGrossWeight * 100).toFixed(2) : 0, m.query.type === _.ALL_YEAR.V ? o.mete && o.mete.length > 0 && o.mete.forEach((e) => {
        o[Number(e.date)] = e.totalNetWeight ? (e.totalNetWeight / 1e3).toFixed(2) : 0, o[`gross_${Number(e.date)}`] = e.totalGrossWeight ? (e.totalGrossWeight / 1e3).toFixed(2) : 0, e.totalNetWeight = (e.totalNetWeight / 1e3).toFixed(2), e.totalGrossWeight = (e.totalGrossWeight / 1e3).toFixed(2), e.completeNetWeight = (e.completeNetWeight / 1e3).toFixed(2), e.completeGrossWeight = (e.completeGrossWeight / 1e3).toFixed(2);
      }) : o.mete && o.mete.length > 0 && (o.mete.forEach((e) => {
        o[e.date] = e, e.totalNetWeight = (e.totalNetWeight / 1e3).toFixed(2) || 0, e.totalGrossWeight = (e.totalGrossWeight / 1e3).toFixed(2) || 0;
      }), U.value = o.mete);
      for (let e = 1; e <= R.value.length; e++) {
        ((S = o.mete) == null ? void 0 : S.findIndex((s) => Number(s.date) === e)) > -1 && T.push(o.mete[(Z = o.mete) == null ? void 0 : Z.findIndex((s) => Number(s.date) === e)]);
        const r = T.filter((s) => Number(s == null ? void 0 : s.date) === e), ee = r.map((s) => Number(s.totalNetWeight)), te = r.map((s) => Number(s.completeNetWeight));
        j = ee.reduce((s, b) => s + (b || 0), 0), F = te.reduce((s, b) => s + (b || 0), 0);
        const u = r.map((s) => Number(s.totalGrossWeight)), L = r.map((s) => Number(s.completeGrossWeight));
        c = u.reduce((s, b) => s + (b || 0), 0), E = L.reduce((s, b) => s + (b || 0), 0), t = j && F ? Number((F / j * 100).toFixed(2)) + "%" : "0%", p = c && E ? Number((E / c * 100).toFixed(2)) + "%" : "0%", M.push({ date: R.value[e - 1].toString(), totalNetWeight: j.toFixed(2), totalGrossWeight: c.toFixed(2) }), V.push({ date: R.value[e - 1].toString(), totalNetWeight: F.toFixed(2), totalGrossWeight: E.toFixed(2) }), v.push({ date: R.value[e - 1].toString(), totalNetWeight: t, totalGrossWeight: p });
      }
      return m.query.type === _.CURRENT_MONTH.V && (K.push(o.schedulingTotalNetWeight), J.push(o.schedulingTotalGrossWeight), Q.push(o.completeTotalNetWeight), X.push(o.completeTotalGrossWeight), I = K.reduce((e, r) => e + Number(r || 0), 0), k = J.reduce((e, r) => e + Number(r || 0), 0), D = Q.reduce((e, r) => e + Number(r || 0), 0), O = X.reduce((e, r) => e + Number(r || 0), 0), U.value.forEach((e) => {
        if (o.mete.findIndex((r) => r.date === e.date) > -1) {
          P.push(o.mete[o.mete.findIndex((u) => u.date === e.date)]);
          const r = P.filter((u) => u.date === e.date);
          W = r.map((u) => Number(u.totalNetWeight)).reduce((u, L) => u + (L || 0), 0), g = r.map((u) => Number(u.totalGrossWeight)).reduce((u, L) => u + (L || 0), 0), B.push({ date: e.date, totalNetWeight: W.toFixed(2), totalGrossWeight: g.toFixed(2) });
        }
      })), o;
    }), h.content.length > 0 && m.query.type === _.ALL_YEAR.V && h.content.push({ type: 2, index: "", projectName: "合计", monomerName: "", mete: M }, { type: 2, index: "", projectName: "实际完成", monomerName: "", mete: V }, { type: 2, index: "", projectName: "完成率", monomerName: "", mete: v }), h.content.length > 0 && m.query.type === _.CURRENT_MONTH.V) {
      const o = I ? (D / I * 100).toFixed(2) : 0, S = k ? (O / k * 100).toFixed(2) : 0;
      h.content.push({ type: 2, index: "", projectName: "合计", monomerName: "", schedulingTotalNetWeight: I, schedulingTotalGrossWeight: k, completeTotalNetWeight: D, completeTotalGrossWeight: O, completeRateNet: o, completeRateGross: S, mete: B });
    }
  };
  function ie() {
    w.value = true;
  }
  function ne({ row: m, rowIndex: h }) {
    if (m.projectName === "完成率") return { position: "sticky", bottom: "0 !important", "z-index": "99" };
    if (m.projectName === "合计") return n.query.type === _.CURRENT_MONTH.V ? { position: "sticky", bottom: "0 !important", "z-index": "99" } : { position: "sticky", bottom: "80px !important", "z-index": "99" };
    if (m.projectName === "实际完成") return { position: "sticky", bottom: "40px !important", "z-index": "99" };
  }
  return (m, h) => {
    const j = ge, c = Ne, F = _e, E = ye, M = fe, V = pe("common-table"), v = Te;
    return l(), i("div", Fe, [x("div", Ee, [q(a(Ae))]), x("div", null, [x("div", qe, [q(j, { style: { "margin-bottom": "8px" }, size: "large" }, { default: d(() => [ue(N(a(n).query.type === a(_).ALL_YEAR.V ? a(ae)(a(n).query.dateTime, "{y}") : a(ae)(a(n).query.dateTime, "{y}-{m}")), 1)]), _: 1 })]), de((l(), y(V, { ref_key: "tableRef", ref: $, data: a(n).data, "empty-text": a(n).emptyText, "max-height": a(re), style: { width: "100%" }, class: "collection-table", stripe: false, "show-empty-symbol": false, "row-style": ne }, { default: d(() => [q(c, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }, { default: d(({ row: t, $index: p }) => [x("span", null, N(t.type === 1 ? p + 1 : ""), 1)]), _: 1 }), a(C).visible("projectName") ? (l(), y(c, { key: "projectName", prop: "projectName", label: "所属项目", "min-width": "160", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [t.projectName === "实际完成" ? (l(), y(M, { key: 0, class: "item", effect: "dark", content: "实际完成包含以往月份排产的任务在当月完成", placement: "top-start" }, { default: d(() => [x("div", Ce, [x("span", { class: H(t.type === 2 && t.projectName !== "合计" ? "tc-success" : "") }, N(t.projectName), 3), q(E, null, { default: d(() => [q(F)]), _: 1 })])]), _: 2 }, 1024)) : (l(), i("span", { key: 1, class: H(t.type === 2 && t.projectName !== "合计" ? "tc-success" : "") }, N(t.projectName), 3))]), _: 1 })) : f("", true), a(C).visible("monomerName") ? (l(), y(c, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [x("span", { class: H(t.type === 2 && t.projectName !== "合计" ? "tc-success" : "") }, N(t.monomerName), 3)]), _: 1 })) : f("", true), a(C).visible("schedulingTotalNetWeight") && a(n).query.type === a(_).CURRENT_MONTH.V ? (l(), y(c, { key: "schedulingTotalNetWeight", prop: "schedulingTotalNetWeight", label: "排产量", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [t.projectName === "合计" ? (l(), i("span", { key: 0, style: { color: "#409eff", cursor: "pointer" }, onClick: he(ie, ["stop"]) }, N(((A.value ? t.schedulingTotalNetWeight : t.schedulingTotalGrossWeight) / 1e3).toFixed(2) || 0), 1)) : (l(), i("span", Me, N(((A.value ? t.schedulingTotalNetWeight : t.schedulingTotalGrossWeight) / 1e3).toFixed(2) || 0), 1))]), _: 1 })) : f("", true), a(C).visible("completeTotalNetWeight") && a(n).query.type === a(_).CURRENT_MONTH.V ? (l(), y(c, { key: "completeTotalNetWeight", prop: "completeTotalNetWeight", label: "实际完成", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [x("span", null, N(((A.value ? t.completeTotalNetWeight : t.completeTotalGrossWeight) / 1e3).toFixed(2) || 0), 1)]), _: 1 })) : f("", true), a(C).visible("completeRate") && a(n).query.type === a(_).CURRENT_MONTH.V ? (l(), y(c, { key: "completeRate", prop: "completeRate", label: "完成率", align: "center", "show-overflow-tooltip": true }, { default: d(({ row: t }) => [x("span", null, N(A.value ? t.completeRateNet || 0 : t.completeRateGross || 0) + "%", 1)]), _: 1 })) : f("", true), a(n).query.type === a(_).ALL_YEAR.V ? (l(), y(c, { key: 5, align: "center", label: "排产计划及执行（单位：吨）", "show-overflow-tooltip": true }, { default: d(() => [(l(true), i(G, null, Y(R.value, (t) => (l(), y(c, { key: t, label: t.toString(), align: "center", "show-overflow-tooltip": true }, { default: d(({ row: p }) => {
      var W;
      return [((W = p.mete) == null ? void 0 : W.findIndex((g) => g.date == t)) > -1 ? (l(), i("div", Ve, [(l(true), i(G, null, Y(p.mete, (g) => (l(), i(G, { key: g }, [g.date == t ? (l(), i("span", { key: 0, class: H(p.type === 2 && p.projectName !== "合计" ? "tc-success" : "") }, N(A.value ? g.totalNetWeight || 0 : g.totalGrossWeight || 0), 3)) : f("", true)], 64))), 128))])) : (l(), i("div", { key: 1, class: H(p.type === 2 && p.projectName !== "合计" ? "tc-success" : "") }, "0", 2))];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })) : f("", true), a(n).data.length > 0 ? (l(true), i(G, { key: 6 }, Y(U.value, (t, p) => (l(), i(G, { key: t }, [a(n).query.type === a(_).CURRENT_MONTH.V ? (l(), y(c, { key: 0, label: `第${p + 1}周
${t == null ? void 0 : t.date}`, align: "center", prop: "monthTotal", "show-overflow-tooltip": true, width: "180px" }, { default: d(({ row: W }) => {
      var g;
      return [((g = W.mete) == null ? void 0 : g.findIndex((T) => T.date == t.date)) > -1 ? (l(), i("div", ve, [(l(true), i(G, null, Y(W.mete, (T) => (l(), i(G, { key: T }, [T.date == t.date ? (l(), i("span", Ie, N(A.value ? T.totalNetWeight ?? 0 : T.totalGrossWeight ?? 0), 1)) : f("", true)], 64))), 128))])) : (l(), i("div", ke, "-"))];
    }), _: 2 }, 1032, ["label"])) : f("", true)], 64))), 128)) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, a(n).loading]]), q(je, { visible: w.value, "onUpdate:visible": h[0] || (h[0] = (t) => w.value = t), workshopId: a(n).query.workshopId, dateTime: a(n).query.dateTime }, null, 8, ["visible", "workshopId", "dateTime"])])]);
  };
} }, Be = We(Le, [["__scopeId", "data-v-a62e83d9"]]);
export {
  Be as default
};
