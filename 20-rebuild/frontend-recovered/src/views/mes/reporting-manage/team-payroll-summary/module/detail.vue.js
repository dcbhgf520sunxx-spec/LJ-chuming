import { ref as g } from "vue";
import { inject as W } from "vue";
import { computed as X } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as r } from "vue";
import { createBlock as b } from "vue";
import { withCtx as n } from "vue";
import { unref as a } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as l } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as j } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as R } from "vue";
import { isRef as Z } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElPagination as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { a as ae } from "../../../../../modules/team-payroll-summary-ec5d2034.js";
import { u as re, J as ne, o as le, p as k, ql as ie, bV as N } from "../../../../../shared/runtime.js";
const se = { key: 0 }, ce = { key: 1 }, pe = { key: 0 }, de = { key: 1 }, ue = { key: 0 }, me = { key: 1 }, we = { key: 0 }, _e = { key: 1 }, fe = { key: 0 }, he = { key: 1 }, ye = { key: 0 }, ge = { key: 1 }, be = { key: 0 }, ke = { key: 1 }, Re = { __name: "detail", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(h, { emit: V }) {
  const E = V, w = h, B = g(), T = g(), z = g([]), I = g(false), u = W("query"), { visible: v, handleClose: S } = re({ emit: E, props: w, field: "visible", showHook: M, closeHook: A }), { handleSizeChange: H, handleCurrentChange: U, total: Q, setTotalPage: L, queryPage: x } = ne({ fetchHook: P });
  function M() {
    P();
  }
  const C = X(() => {
    var _, d, m, y, p;
    return { startDate: u == null ? void 0 : u.startDate, endDate: u == null ? void 0 : u.endDate, productTypeEnum: (_ = w.currentRow) == null ? void 0 : _.productTypeEnum, workshopId: (d = w.currentRow) == null ? void 0 : d.workshopId, processId: (m = w.currentRow) == null ? void 0 : m.processId, teamId: (y = w.currentRow) == null ? void 0 : y.teamId, teamName: (p = w.currentRow) == null ? void 0 : p.teamName };
  }), { maxHeight: q } = le({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, minHeight: 300, paginate: true }, () => T.value.loaded);
  async function P() {
    let _ = [];
    try {
      const { content: d = [], totalElements: m } = await ae({ ...C.value, ...x });
      L(m), _ = d;
    } catch (d) {
      console.log(d);
    } finally {
      z.value = _;
    }
  }
  function A() {
  }
  return (_, d) => {
    const m = $, y = D("print-table"), p = ee, G = D("common-table"), J = te, O = D("common-drawer"), F = Y("permission"), K = oe;
    return r(), b(O, { ref_key: "drawerRef", ref: T, title: "班组产量表", modelValue: a(v), "onUpdate:modelValue": d[0] || (d[0] = (e) => Z(v) ? v.value = e : null), "before-close": a(S), size: "70%" }, { titleAfter: n(() => {
      var e, t;
      return [(e = a(u)) != null && e.startDate && ((t = a(u)) != null && t.endDate) ? (r(), b(m, { key: 0, size: "large" }, { default: n(() => {
        var o, s;
        return [f(" 统计时间：" + l(a(k)((o = a(u)) == null ? void 0 : o.startDate, "{y}-{m}-{d}")) + " ~ " + l(a(k)((s = a(u)) == null ? void 0 : s.endDate, "{y}-{m}-{d}")), 1)];
      }), _: 1 })) : (r(), b(m, { key: 1, size: "large" }, { default: n(() => d[1] || (d[1] = [f("统计时间：-")])), _: 1, __: [1] })), i(m, { size: "large" }, { default: n(() => {
        var o, s;
        return [f("车间：" + l((s = (o = h.currentRow) == null ? void 0 : o.workshop) == null ? void 0 : s.name), 1)];
      }), _: 1 }), i(m, { size: "large" }, { default: n(() => {
        var o, s;
        return [f("班组：" + l((s = (o = h.currentRow) == null ? void 0 : o.team) == null ? void 0 : s.name), 1)];
      }), _: 1 }), i(m, { size: "large" }, { default: n(() => {
        var o, s;
        return [f("工序：" + l((s = (o = h.currentRow) == null ? void 0 : o.process) == null ? void 0 : s.name), 1)];
      }), _: 1 })];
    }), titleRight: n(() => [j(i(y, { "api-key": "mesTeamProduction", params: { ...C.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[F, a(ie).detailsPrint]])]), content: n(() => [j((r(), b(G, { ref_key: "tableRef", ref: B, data: z.value, "empty-text": "暂无数据", "max-height": a(q), showEmptySymbol: false, style: { width: "100%" } }, { default: n(() => [i(p, { label: "序号", type: "index", align: "center", width: "60" }), i(p, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", width: "180px" }, { default: n((e) => {
      var t, o, s;
      return [(t = e.row.project) != null && t.id ? (r(), c("span", se, l(((o = e.row.project) == null ? void 0 : o.serialNumber) || "-") + " - " + l(((s = e.row.project) == null ? void 0 : s.shortName) || "-"), 1)) : (r(), c("span", ce, l(e.row.name), 1))];
    }), _: 1 }), i(p, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "零件编号", align: "center" }, { default: n((e) => {
      var t, o;
      return [(t = e.row.project) != null && t.id ? (r(), c("span", pe, l(((o = e.row.product) == null ? void 0 : o.serialNumber) || "-"), 1)) : (r(), c("span", de, " - "))];
    }), _: 1 }), i(p, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", width: "160px" }, { default: n((e) => {
      var t, o;
      return [(t = e.row.project) != null && t.id ? (r(), c("span", ue, l(((o = e.row.product) == null ? void 0 : o.specification) || "-"), 1)) : (r(), c("span", me, " - "))];
    }), _: 1 }), i(p, { key: "accountingQuantity", prop: "accountingQuantity", "show-overflow-tooltip": "", label: "核算量", align: "center" }, { default: n((e) => {
      var t;
      return [(t = e.row.project) != null && t.id ? (r(), c("span", we, l(e.row.accountingQuantity || "-"), 1)) : (r(), c("span", _e, " - "))];
    }), _: 1 }), i(p, { key: "defineType", prop: "defineType", "show-overflow-tooltip": "", label: "定义类型", align: "center", width: "180px" }, { default: n((e) => {
      var t;
      return [(t = e.row.project) != null && t.id ? (r(), c("span", fe, l(e.row.defineType || "-"), 1)) : (r(), c("span", he, " - "))];
    }), _: 1 }), i(p, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "定额单价", align: "center" }, { default: n((e) => {
      var t;
      return [(e.row.price || e.row.price === 0) && ((t = e.row.project) != null && t.id) ? (r(), c("span", ye, l(a(N)(e.row.price, 2)), 1)) : (r(), c("span", ge, "-"))];
    }), _: 1 }), i(p, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": "", label: "金额", align: "center" }, { default: n((e) => [e.row.totalPrice || e.row.totalPrice === 0 ? (r(), c("span", be, l(a(N)(e.row.totalPrice, 2)), 1)) : (r(), c("span", ke, "-"))]), _: 1 }), i(p, { key: "productionDate", prop: "productionDate", "show-overflow-tooltip": "", label: "生产日期", align: "center", width: "160px" }, { default: n((e) => [R("span", null, l(e.row.productionDate ? a(k)(e.row.productionDate, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), i(p, { key: "approvalUser", prop: "approvalUser", "show-overflow-tooltip": "", label: "审核人", align: "center", width: "160px" }, { default: n((e) => {
      var t;
      return [R("div", null, l(((t = e.row.approvalUser) == null ? void 0 : t.name) || "-"), 1), R("div", null, l(e.row.approvalTime ? a(k)(e.row.approvalTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[K, I.value]]), i(J, { total: a(Q), "current-page": a(x).pageNumber, "page-size": a(x).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(H), onCurrentChange: a(U) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Re as default
};
