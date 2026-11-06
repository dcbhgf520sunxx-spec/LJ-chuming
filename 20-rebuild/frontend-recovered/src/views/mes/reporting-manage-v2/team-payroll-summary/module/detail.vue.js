import { ref as f } from "vue";
import { inject as z } from "vue";
import { computed as X } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as Y } from "vue";
import { openBlock as o } from "vue";
import { createBlock as k } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as n } from "vue";
import { unref as i } from "vue";
import { withDirectives as I } from "vue";
import { createElementVNode as y } from "vue";
import { createElementBlock as s } from "vue";
import { isRef as Z } from "vue";
import { ElTag as $ } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { a as ae } from "../../../../../modules/team-payroll-summary-1754395b.js";
import { _ as re, u as le, o as ne, p as g, ql as se, i as S, bV as E } from "../../../../../shared/runtime.js";
const ie = { class: "header" }, pe = { key: 0 }, de = { key: 1 }, ce = { key: 0 }, ue = { key: 1 }, _e = { key: 0 }, me = { key: 1 }, we = { key: 0 }, fe = { key: 1 }, ye = { key: 0 }, he = { key: 1 }, be = { key: 0 }, ve = { key: 1 }, ke = { key: 0 }, ge = { key: 1 }, De = { key: 0 }, xe = { key: 1 }, je = { key: 0 }, Ne = { key: 1 }, Re = { key: 0 }, Be = { key: 1 }, Ve = { __name: "detail", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(D, { emit: H }) {
  const U = H, h = D, L = f(), R = f(), B = f([]), x = f(false), u = z("query"), V = z("wageDisplayPrecision"), b = f(), { visible: j, handleClose: M } = le({ emit: U, props: h, field: "visible", showHook: Q, closeHook: A });
  function Q() {
    N();
  }
  const C = X(() => {
    var m, p, _;
    return { startDate: u == null ? void 0 : u.startDate, endDate: u == null ? void 0 : u.endDate, productTypeEnum: u == null ? void 0 : u.productTypeEnum, workshopId: (m = h.currentRow) == null ? void 0 : m.workshopId, processId: (p = h.currentRow) == null ? void 0 : p.processId, teamId: (_ = h.currentRow) == null ? void 0 : _.teamId, productSerialNumber: b.value };
  }), { maxHeight: q } = ne({ mainBox: ".team-payroll-summary-detail", extraBox: [".el-drawer__header", ".header"], wrapperBox: [".el-drawer__body"], navbar: false, minHeight: 300, paginate: false }, () => R.value.loaded);
  function P() {
    b.value = void 0, N();
  }
  async function N() {
    let m = [];
    x.value = true;
    try {
      m = await ae(C.value) || [];
    } catch (p) {
      console.log(p);
    } finally {
      B.value = m, x.value = false;
    }
  }
  function A() {
    P();
  }
  return (m, p) => {
    const _ = $, G = v("print-table"), O = ee, T = v("common-button"), d = te, F = v("common-table"), J = v("common-drawer"), K = Y("permission"), W = oe;
    return o(), k(J, { ref_key: "drawerRef", ref: R, title: "班组产量表", modelValue: i(j), "onUpdate:modelValue": p[1] || (p[1] = (e) => Z(j) ? j.value = e : null), "before-close": i(M), size: "90%", "custom-class": "team-payroll-summary-detail" }, { titleAfter: a(() => {
      var e, t;
      return [l(_, { size: "large" }, { default: a(() => {
        var r, c;
        return [w("车间：" + n(((c = (r = D.currentRow) == null ? void 0 : r.workshop) == null ? void 0 : c.name) || "-"), 1)];
      }), _: 1 }), l(_, { size: "large" }, { default: a(() => {
        var r, c;
        return [w("班组：" + n(((c = (r = D.currentRow) == null ? void 0 : r.team) == null ? void 0 : c.name) || "-"), 1)];
      }), _: 1 }), (e = i(u)) != null && e.startDate && ((t = i(u)) != null && t.endDate) ? (o(), k(_, { key: 0, size: "large" }, { default: a(() => {
        var r, c;
        return [w(" 统计时间：" + n(i(g)((r = i(u)) == null ? void 0 : r.startDate, "{y}-{m}-{d}")) + " ~ " + n(i(g)((c = i(u)) == null ? void 0 : c.endDate, "{y}-{m}-{d}")), 1)];
      }), _: 1 })) : (o(), k(_, { key: 1, size: "large" }, { default: a(() => p[2] || (p[2] = [w("统计时间：-")])), _: 1, __: [2] }))];
    }), titleRight: a(() => [I(l(G, { "api-key": "mesTeamProduction", params: { ...C.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[K, i(se).detailsPrint]])]), content: a(() => [y("div", ie, [l(O, { modelValue: b.value, "onUpdate:modelValue": p[0] || (p[0] = (e) => b.value = e), modelModifiers: { trim: true }, size: "default", placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), l(T, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: N }, { default: a(() => p[3] || (p[3] = [w(" 搜索 ")])), _: 1, __: [3] }), l(T, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: P }, { default: a(() => p[4] || (p[4] = [w(" 重置 ")])), _: 1, __: [4] })]), I((o(), k(F, { ref_key: "tableRef", ref: L, data: B.value, "empty-text": "暂无数据", "max-height": i(q), showEmptySymbol: false, style: { width: "100%" } }, { default: a(() => [l(d, { label: "序号", type: "index", align: "center", width: "60" }), l(d, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "200" }, { default: a((e) => {
      var t, r, c;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", pe, n(((r = e.row.project) == null ? void 0 : r.serialNumber) || "-") + " - " + n(((c = e.row.project) == null ? void 0 : c.shortName) || "-"), 1)) : (o(), s("span", de, n(e.row.name), 1))];
    }), _: 1 }), l(d, { key: "areaBatch", prop: "areaBatch", "show-overflow-tooltip": "", label: "批次", align: "center" }, { default: a((e) => {
      var t, r, c;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", ce, n(((c = (r = e.row) == null ? void 0 : r.areaBatch) == null ? void 0 : c.name) || "-"), 1)) : (o(), s("span", ue, " - "))];
    }), _: 1 }), l(d, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: a((e) => {
      var t, r;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", _e, n(((r = e.row.product) == null ? void 0 : r.serialNumber) || "-"), 1)) : (o(), s("span", me, " - "))];
    }), _: 1 }), l(d, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: a((e) => {
      var t, r;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", we, n(((r = e.row.product) == null ? void 0 : r.specification) || "-"), 1)) : (o(), s("span", fe, " - "))];
    }), _: 1 }), l(d, { key: "process", prop: "process", "show-overflow-tooltip": "", label: "工序", align: "center", width: "100" }, { default: a((e) => {
      var t, r;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", ye, n(((r = e.row.process) == null ? void 0 : r.name) || "-"), 1)) : (o(), s("span", he, " - "))];
    }), _: 1 }), l(d, { key: "quotaConfigSerialNumber", prop: "quotaConfigSerialNumber", "show-overflow-tooltip": "", label: "定额编号", align: "center", width: "100" }, { default: a((e) => {
      var t;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", be, n(e.row.quotaConfigSerialNumber || "-"), 1)) : (o(), s("span", ve, " - "))];
    }), _: 1 }), l(d, { key: "measureUnit", prop: "measureUnit", "show-overflow-tooltip": "", label: "核算单位", align: "center", width: "80" }, { default: a((e) => {
      var t;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", ke, n(e.row.measureUnit || "-"), 1)) : (o(), s("span", ge, " - "))];
    }), _: 1 }), l(d, { key: "measurementQuantity", prop: "measurementQuantity", "show-overflow-tooltip": "", label: "核算量", align: "center", width: "100" }, { default: a((e) => {
      var t;
      return [(t = e.row.project) != null && t.id ? (o(), s("span", De, n(e.row.measurementQuantity || "-"), 1)) : (o(), s("span", xe, " - "))];
    }), _: 1 }), l(d, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "单价（元）", align: "center", width: "100" }, { default: a((e) => {
      var t;
      return [i(S)(e.row.price) && ((t = e.row.project) != null && t.id) ? (o(), s("span", je, n(i(E)(e.row.price, i(V))), 1)) : (o(), s("span", Ne, "-"))];
    }), _: 1 }), l(d, { key: "amount", prop: "amount", "show-overflow-tooltip": "", label: "金额（元）", align: "center", width: "100" }, { default: a((e) => [i(S)(e.row.amount) ? (o(), s("span", Re, n(i(E)(e.row.amount, i(V))), 1)) : (o(), s("span", Be, "-"))]), _: 1 }), l(d, { key: "reportPerson", prop: "reportPerson", "show-overflow-tooltip": "", label: "上报人", align: "center", width: "100" }, { default: a((e) => {
      var t;
      return [y("span", null, n(((t = e.row.reportPerson) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), l(d, { key: "reportDate", prop: "reportDate", "show-overflow-tooltip": "", label: "报工日期", align: "center", width: "100" }, { default: a((e) => [y("span", null, n(e.row.reportDate ? i(g)(e.row.reportDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), l(d, { key: "approver", prop: "approver", "show-overflow-tooltip": "", label: "审核人", align: "center", width: "100" }, { default: a((e) => {
      var t;
      return [y("div", null, n(((t = e.row.approver) == null ? void 0 : t.name) || "-"), 1)];
    }), _: 1 }), l(d, { key: "approvalDate", prop: "approvalDate", "show-overflow-tooltip": "", label: "审核日期", align: "center", width: "100" }, { default: a((e) => [y("span", null, n(e.row.approvalDate ? i(g)(e.row.approvalDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[W, x.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ze = re(Ve, [["__scopeId", "data-v-2cace3b4"]]);
export {
  ze as default
};
