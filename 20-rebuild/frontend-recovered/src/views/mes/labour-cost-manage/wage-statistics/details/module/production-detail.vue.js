import { inject as A } from "vue";
import { ref as b } from "vue";
import { computed as G } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as k } from "vue";
import { createBlock as C } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as r } from "vue";
import { unref as l } from "vue";
import { withDirectives as U } from "vue";
import { isRef as $ } from "vue";
import { ElTag as F } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElPagination as K } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as f, _ as Y, u as Z, J as ee, o as te, G as ae, nW as oe, D as T, p as z, nX as ne, d$ as re } from "../../../../../../shared/runtime.js";
function le(o) {
  return f({ url: "/api/mes/building/wage-manage/wage-statistics/month-summary-page", method: "get", params: o });
}
function se(o) {
  return f({ url: "/api/mes/building/wage-manage/wage-statistics/date-range", method: "get", params: o });
}
function ie(o) {
  return f({ url: "/api/mes/building/wage-manage/wage-statistics/reverse-inference-mode-page", method: "get", params: o });
}
function ge(o) {
  return f({ url: "/api/mes/building/wage-manage/wage-statistics/month-summary/export", responseType: "blob", method: "get", params: o });
}
function fe(o) {
  return f({ url: "/api/mes/building/wage-manage/wage-statistics/reverse-inference-mode/export", responseType: "blob", method: "post", data: o });
}
const we = { get: le };
const ce = { class: "header" }, pe = { __name: "production-detail", props: { visible: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} }, yearMonth: { type: String, default: "" }, openDetailType: { type: String, default: "" } }, emits: ["update:visible"], setup(o, { emit: I }) {
  const S = A("query"), P = I, i = o, x = b(), w = b(), h = b(), j = b(false), { visible: _, handleClose: L } = Z({ emit: P, props: i, field: "visible", showHook: q, closeHook: B }), { handleSizeChange: V, handleCurrentChange: R, total: W, setTotalPage: E, queryPage: v } = ee({ fetchHook: N }), { maxHeight: H } = te({ paginate: true });
  async function O() {
    var d, u, m, y;
    const g = (d = i.yearMonth) == null ? void 0 : d.lastIndexOf("-");
    let s = (m = i.yearMonth) == null ? void 0 : m.substring(g + 1, (u = i.yearMonth) == null ? void 0 : u.length), c = (y = i.yearMonth) == null ? void 0 : y.substring(0, g);
    i.openDetailType && (s === "01" ? (s = 12, c = c - 1) : s = s - 1);
    const t = { month: s, year: c, projectId: S.projectId };
    try {
      const e = await se(t);
      w.value = e.startDate, h.value = e.endDate, N();
    } catch (e) {
      console.log(e);
    }
  }
  async function N() {
    var s, c, t, d;
    if (!ae(oe.detail)) return;
    const g = { startDate: w.value, endDate: h.value, productProcessType: (s = i.rowData) == null ? void 0 : s.productProcessType, processId: (c = i.rowData) == null ? void 0 : c.processId, teamLeaderName: (t = i.rowData) == null ? void 0 : t.teamLeaderName, workshopId: (d = i.rowData) == null ? void 0 : d.workshopId, projectId: S.projectId };
    try {
      const { content: u = [], totalElements: m } = await ie({ ...g, ...v });
      x.value = u, E(m);
    } catch (u) {
      console.log(u);
    }
  }
  const Q = G(() => [["wage", ["to-thousand", T.YUAN]], ["totalWage", ["to-thousand", 3]], ["totalNetWeight", ["to-fixed", T.COM_WT__KG]]]);
  function q() {
    O();
  }
  function B() {
  }
  return (g, s) => {
    const c = F, t = J, d = M("common-table"), u = K, m = M("common-drawer"), y = X;
    return k(), C(m, { "append-to-body": "", ref: "drawerRef", title: "生产明细", modelValue: l(_), "onUpdate:modelValue": s[0] || (s[0] = (e) => $(_) ? _.value = e : null), direction: "rtl", "before-close": l(L), size: "70%" }, { content: n(() => [p("div", ce, [a(c, { size: "large", style: { "margin-right": "10px" } }, { default: n(() => {
      var e;
      return [D(" 工序： " + r(((e = o.rowData) == null ? void 0 : e.processName) || "-"), 1)];
    }), _: 1 }), a(c, { size: "large", style: { "margin-right": "10px" } }, { default: n(() => {
      var e;
      return [D(" 班组： " + r(((e = o.rowData) == null ? void 0 : e.teamLeaderName) || "-"), 1)];
    }), _: 1 }), a(c, { size: "large" }, { default: n(() => [D(" 统计日期： " + r(w.value ? l(z)(w.value, "{y}-{m}-{d}") : "-") + " ~ " + r(h.value ? l(z)(h.value, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), U((k(), C(d, { ref: "serialNumberRef", data: x.value, "data-format": Q.value, "max-height": l(H), "return-source-data": "", showEmptySymbol: false }, { default: n(() => [a(t, { type: "index", label: "序号", align: "center", width: "80" }), a(t, { "show-overflow-tooltip": "", align: "center", label: "项目", width: "180px" }, { default: n((e) => [p("span", null, r(e.row.projectSerialNumber) + " - " + r(e.row.projectShortName), 1)]), _: 1 }), a(t, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", align: "center", label: "单体" }), a(t, { key: "areaName", prop: "areaName", "show-overflow-tooltip": "", align: "center", label: "区域" }), a(t, { key: "typeName", prop: "typeName", "show-overflow-tooltip": "", align: "center", label: "类型" }, { default: n((e) => [p("span", null, r(e.row.typeName || e.row.productName || "-"), 1)]), _: 1 }), a(t, { key: "productSerialNumber", prop: "productSerialNumber", "show-overflow-tooltip": "", align: "center", label: "编号" }, { default: n((e) => [p("span", null, r(e.row.productSerialNumber || "-"), 1)]), _: 1 }), a(t, { key: "productSpecification", prop: "productSpecification", "show-overflow-tooltip": "", align: "center", label: "规格" }, { default: n((e) => [p("span", null, r(e.row.productSpecification || "-"), 1)]), _: 1 }), a(t, { key: "productMaterial", prop: "productMaterial", "show-overflow-tooltip": "", align: "center", label: "材质" }, { default: n((e) => [p("span", null, r(e.row.productMaterial || "-"), 1)]), _: 1 }), a(t, { key: "wageStatisticsMode", prop: "wageStatisticsMode", "show-overflow-tooltip": "", align: "center", label: "工价统计模式", width: "120px" }, { default: n((e) => [p("span", null, r(l(ne).VL[e.row.wageStatisticsMode] || "-"), 1)]), _: 1 }), a(t, { key: "inboundQuantity", prop: "inboundQuantity", "show-overflow-tooltip": "", align: "center", label: "入库数量" }), a(t, { key: "measurementManner", prop: "measurementManner", "show-overflow-tooltip": "", align: "center", label: "计量方式", width: "100px" }, { default: n((e) => [p("span", null, r(l(re).VL[e.row.measurementManner] || "-"), 1)]), _: 1 }), a(t, { key: "measurementQuantity", prop: "measurementQuantity", "show-overflow-tooltip": "", align: "center", label: "计量量" }, { default: n((e) => [p("span", null, r(e.row.measurementQuantity || "-"), 1)]), _: 1 }), a(t, { key: "wage", prop: "wage", "show-overflow-tooltip": "", align: "center", label: "单价（元）", width: "90px" }), a(t, { key: "totalWage", prop: "totalWage", "show-overflow-tooltip": "", align: "center", label: "金额(元)" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[y, j.value]]), a(u, { total: l(W), "current-page": l(v).pageNumber, "page-size": l(v).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(V), onCurrentChange: l(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = Y(pe, [["__scopeId", "data-v-37f802df"]]), he = Object.freeze(Object.defineProperty({ __proto__: null, default: ue }, Symbol.toStringTag, { value: "Module" }));
export {
  fe as a,
  he as b,
  we as c,
  ge as d,
  se as g,
  ue as p
};
