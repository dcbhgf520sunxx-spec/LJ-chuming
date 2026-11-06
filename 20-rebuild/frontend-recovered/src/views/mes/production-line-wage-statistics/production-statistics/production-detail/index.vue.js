import { inject as A } from "vue";
import { ref as x } from "vue";
import { watch as G } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as P } from "vue";
import { vShow as z } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as c } from "vue";
import { withKeys as W } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as T } from "vue";
import { withModifiers as I } from "vue";
import { createBlock as N } from "vue";
import { unref as w } from "vue";
import { toDisplayString as v } from "vue";
import { Fragment as b } from "vue";
import { renderList as R } from "vue";
import { createCommentVNode as M } from "vue";
import { ElInput as X } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { d as ee, e as te } from "../../../../../modules/production-statistics-aa5db1ec.js";
import { _ as ae, t as oe, o as le, L as ne, p as H } from "../../../../../shared/runtime.js";
const se = { class: "app-container" }, ie = { class: "my-code", style: { width: "100%" } }, re = { style: { width: "100%" } }, ue = { class: "production-detail", style: { display: "flex", "justify-content": "space-between" } }, de = { key: 0 }, ce = { key: 0 }, me = { key: 1 }, pe = { __name: "index", props: { detailRow: { type: Object, default: () => {
} }, commonParams: { type: Object } }, setup(k) {
  const { decimalPrecision: C } = oe(), K = A("permission"), h = k, { maxHeight: Q } = le({ extraBox: [".production-detail"], paginate: true }), g = x(), V = x([]), D = x([]), m = x([]), r = x([]);
  function q(n, a, _) {
    let o = n;
    const e = (a - n) / (24 * 60 * 60 * 1e3);
    for (var s = [], p = 0; p <= e; p++) s.push(H(o, "{y}/{m}/{d}")), o += _;
    D.value = s;
  }
  G(() => {
    var n;
    return (n = h.detailRow.process) == null ? void 0 : n.id;
  }, (n) => {
    n && L();
  });
  async function L() {
    var n, a, _;
    try {
      const { content: o } = await ee({ processId: (n = h.detailRow.process) == null ? void 0 : n.id, userName: g.value, ...h.commonParams });
      o == null || o.forEach((e) => {
        var s, p;
        e.startTime = (s = h.commonParams) == null ? void 0 : s.startTime, e.endTime = (p = h.commonParams) == null ? void 0 : p.endTime;
      }), q(Number((a = h.commonParams) == null ? void 0 : a.startTime), Number((_ = h.commonParams) == null ? void 0 : _.endTime), 24 * 60 * 60 * 1e3), m.value = [], r.value = [], D.value.forEach((e) => {
        m.value.indexOf(e.split("/")[0]) === -1 && m.value.push(e.split("/")[0]), m.value.sort(function(s, p) {
          return s - p;
        });
      }), D.value.forEach((e) => {
        r.value.indexOf(e.split("/")[1]) === -1 && r.value.push(e.split("/")[1]);
      }), V.value = o || [];
    } catch (o) {
      console.log("获取对应工序下的详情失败", o);
    }
  }
  function U() {
    L();
  }
  function Y() {
    g.value = void 0, L();
  }
  function $({ row: n, column: a, rowIndex: _, columnIndex: o }) {
    var s;
    const e = [];
    if (e.push((s = a.label) == null ? void 0 : s.split("/")[0]), a.property === "sum") {
      if (m.value.length === 1 && r.value.length === 1) return {};
      if (m.value.length === 1 && r.value.length > 1) {
        if (e[0] === r.value[0]) return { background: "#e1f3d8" };
        if (e[0] === r.value[1]) return { background: "#faecd8" };
      } else if (m.value.length > 1 && r.value.length > 1) return e[0] === r.value[0] ? { background: "#e1f3d8" } : { background: "#faecd8" };
    }
    if (a.property === "total") {
      if (m.value.length === 1 && (r.value.length === 1 || r.value.length > 1)) return {};
      if (o >= 6 && (o - 4) % 2 === 0) return { background: "#d1edc4" };
      if (o >= 7 && (o - 5) % 2 === 0) return { background: "#f8e3c5" };
    }
  }
  return (n, a) => {
    var E, j, B;
    const _ = X, o = S("common-button"), e = Z, s = S("common-table"), p = J("permission");
    return i(), f("div", se, [P(d("div", ie, "*点击左侧表格行查看详情", 512), [[z, !((E = k.detailRow.process) != null && E.id)]]), P(d("div", re, [d("div", ue, [d("div", null, [c(_, { modelValue: g.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => g.value = l), modelModifiers: { trim: true }, placeholder: "可输入姓名搜索", class: "filter-item", style: { width: "200px", "margin-bottom": "8px" }, size: "default", clearable: "", onKeyup: W(L, ["enter"]) }, null, 8, ["modelValue"]), c(o, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", style: { "margin-left": "8px", "margin-bottom": "8px" }, onClick: I(U, ["stop"]) }, { default: u(() => a[1] || (a[1] = [T(" 搜索 ")])), _: 1, __: [1] }), c(o, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: I(Y, ["stop"]), style: { "margin-left": "8px", "margin-bottom": "8px" } }, { default: u(() => a[2] || (a[2] = [T(" 重置 ")])), _: 1, __: [2] })]), d("div", null, [P((i(), N(ne, { class: "filter-item", fn: w(te), params: { processId: (j = k.detailRow.process) == null ? void 0 : j.id, userName: g.value, ...h.commonParams } }, { default: u(() => a[3] || (a[3] = [T(" 工资清单 ")])), _: 1, __: [3] }, 8, ["fn", "params"])), [[p, w(K).export]])])]), c(s, { ref: "tableRef", data: V.value, "empty-text": "暂无数据", "max-height": w(Q), "row-key": "id", style: { width: "100%" }, "header-cell-style": $ }, { default: u(() => [c(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), c(e, { align: "center", key: "workshop.name", prop: "workshop.name", "show-overflow-tooltip": true, label: "车间", "min-width": "120px", fixed: "left" }, { default: u(({ row: l }) => {
      var t;
      return [d("span", null, v((t = l.workshop) == null ? void 0 : t.name), 1)];
    }), _: 1 }), c(e, { align: "center", key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "产线", "min-width": "120px", fixed: "left" }, { default: u(({ row: l }) => {
      var t;
      return [d("span", null, v((t = l.productionLine) == null ? void 0 : t.name), 1)];
    }), _: 1 }), c(e, { align: "center", key: "groups.name", prop: "groups.name", "show-overflow-tooltip": true, label: "生产组", "min-width": "120px", fixed: "left" }, { default: u(({ row: l }) => {
      var t;
      return [d("span", null, v((t = l.groups) == null ? void 0 : t.name), 1)];
    }), _: 1 }), c(e, { align: "center", key: "team.name", prop: "team.name", "show-overflow-tooltip": true, label: "班组", "min-width": "120px", fixed: "left" }, { default: u(({ row: l }) => {
      var t;
      return [d("span", null, v((t = l.team) == null ? void 0 : t.name), 1)];
    }), _: 1 }), c(e, { align: "center", key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": true, label: "总额", "min-width": "120px", fixed: "left" }, { default: u(({ row: l }) => {
      var t;
      return [d("span", null, v((t = l.totalPrice) == null ? void 0 : t.toFixed(w(C).mes)), 1)];
    }), _: 1 }), (i(true), f(b, null, R(m.value, (l) => (i(), N(e, { prop: "total", align: "center", key: "_" + l, "show-overflow-tooltip": true, label: l }, { default: u(() => [(i(true), f(b, null, R(D.value, (t) => (i(), f(b, { key: t }, [new Date(t).getFullYear() == l ? (i(), N(e, { key: 0, prop: "sum", align: "center", "show-overflow-tooltip": true, label: w(H)(new Date(t).getTime(), "{m}/{d}"), "min-width": "120" }, { default: u((F) => [F.row.priceList.findIndex((y) => y.dayTime == t) > -1 ? (i(), f("div", de, [(i(true), f(b, null, R(F.row.priceList, (y) => {
      var O;
      return i(), f(b, { key: y }, [y.dayTime == t ? (i(), f("span", ce, v((O = y.price) == null ? void 0 : O.toFixed(w(C).mes)), 1)) : M("", true)], 64);
    }), 128))])) : (i(), f("span", me, "/"))]), _: 2 }, 1032, ["label"])) : M("", true)], 64))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["data", "max-height"])], 512), [[z, (B = k.detailRow.process) == null ? void 0 : B.id]])]);
  };
} }, we = ae(pe, [["__scopeId", "data-v-6dc786be"]]);
export {
  we as default
};
