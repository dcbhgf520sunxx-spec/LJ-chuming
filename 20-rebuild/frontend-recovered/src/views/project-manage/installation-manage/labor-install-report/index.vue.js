import { ref as x } from "vue";
import { watch as K } from "vue";
import { resolveComponent as J } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as X } from "vue";
import { unref as o } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { createVNode as I } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as m } from "vue";
import { withModifiers as Q } from "vue";
import { normalizeStyle as Y } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { ElProgress as tt } from "element-plus";
import { ElDivider as et } from "element-plus";
import { vLoading as nt } from "element-plus";
import { c as ot, _ as at } from "./module/detail.vue.js";
import { _ as lt, m as st, x as it, o as rt, tQ as k, G as pt } from "../../../../shared/runtime.js";
import { t as C } from "../../../../modules/project-19a12d6b.js";
const dt = { class: "app-container" }, ut = { key: 1 }, ht = ["onClick"], mt = ["onClick"], yt = ["onClick"], ft = { __name: "index", setup(Mt) {
  const { globalProject: ct, globalProjectId: L } = st(["globalProject", "globalProjectId"]), O = { add: false, edit: false, del: false, download: false }, R = x(), S = x({}), N = x(false), P = x(""), { crud: f, columns: u, CRUD: G } = it({ title: "劳务安装报表", sort: [], permission: { ...C }, optShow: { ...O }, crudApi: { ...ot }, requiredQuery: ["projectId"], hasPagintion: false }, R), { maxHeight: w } = rt({ extraBox: [".head-container"], paginate: false });
  K(() => L.value, (p) => {
    p && (f.query.projectId = p, f.toQuery());
  }, { immediate: true });
  function T(p, a) {
    pt(C.detail) && (S.value = p, P.value = a, N.value = true);
  }
  function W({ row: p, rowIndex: a }) {
    if (p.supplierName === "结构制品合计") return { position: "sticky", zIndex: 2, fontWeight: "bold", bottom: "40px !important" };
    if (p.supplierName === "围护制品合计") return { position: "sticky", zIndex: 2, fontWeight: "bold", bottom: "0 !important" };
  }
  return G.HOOK.handleRefresh = (p, a) => {
    var A, V, B, H, $, z;
    let l = 0, _ = 0, g = 0, b = 0, v = 0, n = 0, y = 0, q = 0, U = 0, j = 0, E = 0, D = 0;
    a.data.content = a.data, (A = a.data.content) == null || A.forEach((e) => {
      e.totalInstallRate = e.mete && e.taskMete ? (e.mete / e.taskMete * 100).toFixed(2) : 0;
    });
    const M = (B = (V = a.data) == null ? void 0 : V.content) == null ? void 0 : B.filter((e) => e.productType === k.ARTIFACT.V);
    l = M.reduce((e, t) => t != null && t.mete ? e + (t == null ? void 0 : t.mete) : e, 0), _ = M.reduce((e, t) => t != null && t.quantity ? e + (t == null ? void 0 : t.quantity) : e, 0), b = M.reduce((e, t) => t != null && t.lastMonthMete ? e + (t == null ? void 0 : t.lastMonthMete) : e, 0), v = M.reduce((e, t) => t != null && t.lastMonthQuantity ? e + (t == null ? void 0 : t.lastMonthQuantity) : e, 0), y = M.reduce((e, t) => t != null && t.currentMonthMete ? e + (t == null ? void 0 : t.currentMonthMete) : e, 0), q = M.reduce((e, t) => t != null && t.currentMonthQuantity ? e + (t == null ? void 0 : t.currentMonthQuantity) : e, 0);
    const c = ($ = (H = a.data) == null ? void 0 : H.content) == null ? void 0 : $.filter((e) => e.productType === k.ENCLOSURE.V);
    g = c.reduce((e, t) => t != null && t.mete ? e + (t == null ? void 0 : t.mete) : e, 0), j = c.reduce((e, t) => t != null && t.quantity ? e + (t == null ? void 0 : t.quantity) : e, 0), n = c.reduce((e, t) => t != null && t.lastMonthMete ? e + (t == null ? void 0 : t.lastMonthMete) : e, 0), E = c.reduce((e, t) => t != null && t.lastMonthQuantity ? e + (t == null ? void 0 : t.lastMonthQuantity) : e, 0), U = c.reduce((e, t) => t != null && t.currentMonthMete ? e + (t == null ? void 0 : t.currentMonthMete) : e, 0), D = c.reduce((e, t) => t != null && t.currentMonthQuantity ? e + (t == null ? void 0 : t.currentMonthQuantity) : e, 0), a.data.content && ((z = a.data.content) == null ? void 0 : z.length) > 0 && a.data.content.push({ index: "", type: 2, supplierName: "结构制品合计", productType: 2, accountingUnit: "", mete: l, quantity: _, totalInstallRate: "-", lastMonthMete: b, lastMonthQuantity: v, currentMonthMete: y, currentMonthQuantity: q }, { index: "", type: 2, supplierName: "围护制品合计", productType: 4, accountingUnit: "", mete: g, quantity: j, totalInstallRate: "-", lastMonthMete: n, lastMonthQuantity: E, currentMonthMete: U, currentMonthQuantity: D });
  }, (p, a) => {
    const l = Z, _ = tt, g = J("common-table"), b = et, v = nt;
    return s(), F("div", dt, [d("div", { style: Y(`height: ${o(w) / 2}px`) }, [X((s(), i(g, { ref_key: "tableRef", ref: R, data: o(f).data, "empty-text": o(f).emptyText, "max-height": o(w) / 2, style: { width: "100%" }, stripe: false, "show-empty-symbol": false, "row-style": W }, { default: r(() => [I(l, { label: "序号", type: "index", align: "center", width: "60" }, { default: r(({ row: n, $index: y }) => [d("span", null, h(n.type !== 2 ? y + 1 : ""), 1)]), _: 1 }), o(u).visible("supplierName") ? (s(), i(l, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "劳务单位", align: "center" }, { default: r(({ row: n }) => [d("span", null, h(n.supplierName || ""), 1)]), _: 1 })) : m("", true), o(u).visible("productType") ? (s(), i(l, { key: "productType", prop: "productType", "show-overflow-tooltip": true, label: "分类", align: "center" }, { default: r(({ row: n }) => [d("span", null, h(n.type !== 2 ? o(k).VL[n.productType] : ""), 1)]), _: 1 })) : m("", true), o(u).visible("accountingUnit") ? (s(), i(l, { key: "accountingUnit", prop: "accountingUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: r(({ row: n }) => [d("span", null, h(n.accountingUnit ? n.accountingUnit : ""), 1)]), _: 1 })) : m("", true), o(u).visible("taskMete") ? (s(), i(l, { key: "taskMete", prop: "taskMete", "show-overflow-tooltip": true, label: "任务总量", align: "center" }, { default: r(({ row: n }) => [d("span", null, h(n.taskMete), 1)]), _: 1 })) : m("", true), o(u).visible("totalInstallRate") ? (s(), i(l, { key: "totalInstallRate", prop: "totalInstallRate", "show-overflow-tooltip": true, label: "完成率", width: "170px", align: "center" }, { default: r(({ row: n }) => [n.type !== 2 ? (s(), i(_, { key: 0, "text-inside": true, "stroke-width": 18, percentage: n.totalInstallRate, status: n.productType === o(k).ARTIFACT.V ? "primary" : "success" }, null, 8, ["percentage", "status"])) : (s(), F("span", ut))]), _: 1 })) : m("", true), o(u).visible("mete") ? (s(), i(l, { key: "mete", prop: "mete", "show-overflow-tooltip": true, label: "累计安装量", align: "center" }, { default: r(({ row: n }) => [d("span", { onClick: Q((y) => T(n, "total"), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, h(n.mete), 9, ht)]), _: 1 })) : m("", true), o(u).visible("lastMonthMete") ? (s(), i(l, { key: "lastMonthMete", prop: "lastMonthMete", "show-overflow-tooltip": true, label: "上月安装量", align: "center" }, { default: r(({ row: n }) => [d("span", { onClick: Q((y) => T(n, "last"), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, h(n.lastMonthMete), 9, mt)]), _: 1 })) : m("", true), o(u).visible("currentMonthMete") ? (s(), i(l, { key: "currentMonthMete", prop: "currentMonthMete", "show-overflow-tooltip": true, label: "本月安装量", align: "center" }, { default: r(({ row: n }) => [d("span", { onClick: Q((y) => T(n, "current"), ["stop"]), style: { color: "#409eff", cursor: "pointer" } }, h(n.currentMonthMete), 9, yt)]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, o(f).loading]])], 4), I(b, { class: "divider" }), I(at, { "detail-data": S.value, isShow: N.value, permission: o(C), showType: P.value, projectId: o(f).query.projectId, maxHeight: o(w) }, null, 8, ["detail-data", "isShow", "permission", "showType", "projectId", "maxHeight"])]);
  };
} }, kt = lt(ft, [["__scopeId", "data-v-7e250255"]]);
export {
  kt as default
};
