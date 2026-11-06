import { ref as f } from "vue";
import { provide as N } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as a } from "vue";
import { unref as l } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as B } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as p } from "vue";
import { ElTableColumn as F } from "element-plus";
import { InfoFilled as O } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { ElTooltip as U } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as K } from "../../../../modules/daily-production-statistics-18379024.js";
import { x as $, nC as g, o as G, i as m, G as M, e2 as P } from "../../../../shared/runtime.js";
import L from "./module/header.vue.js";
import j from "./module/pack-detail.vue.js";
import z from "./module/production-detail.vue.js";
const J = { class: "app-container" }, W = { class: "head-container" }, X = { key: 0 }, Y = { key: 1 }, Z = ["onClick"], tt = { key: 1 }, et = { style: { display: "inline-block" } }, at = ["onClick"], ot = { key: 1 }, lt = { style: { display: "inline-block" } }, nt = ["onClick"], it = { key: 1 }, ft = { __name: "index", setup(st) {
  const x = f(), w = f(false), D = f(false), b = f(), y = f(), { crud: _, CRUD: C } = $({ title: "当日产量统计", sort: [], permission: { permission: g }, crudApi: { ...K }, dataPath: "", hasPagination: false }, x), { maxHeight: S } = G({ paginate: false });
  C.HOOK.handleRefresh = (d, o) => {
    o.data = o.data.map((e, k) => (e.idx = k + 1, e.workShopId = e.id, e.workShopName = e.name, e.teamArtifactSumDTOS.length && e.teamArtifactSumDTOS.forEach((s, h) => {
      s.idx = e.idx + "." + (h + 1), s.workShopId = e.id, s.workShopName = e.name, s.teamId = s.id, s.teamName = s.name;
    }), e.rowKey = e.id, e));
  };
  function T(d, o) {
    if (!M(g.PackDetail)) {
      P("warning", "暂无权限");
      return;
    }
    b.value = o, w.value = true, y.value = d;
  }
  function V(d) {
    if (!M(g.productionDetail)) {
      P("warning", "暂无权限");
      return;
    }
    D.value = true, y.value = d;
  }
  function E(d) {
    return d == null ? void 0 : d.idx;
  }
  return N("query", _.query), (d, o) => {
    const e = F, k = O, s = H, h = U, Q = R("common-table"), I = q;
    return r(), c("div", J, [u("div", W, [a(l(L))]), A((r(), B(Q, { ref_key: "tableRef", ref: x, data: l(_).data, "empty-text": l(_).emptyText, "max-height": l(S), "tree-props": { children: "teamArtifactSumDTOS" }, stripe: false, showEmptySymbol: false, "return-source-data": "", "row-key": (t) => E(t), style: { width: "100%" } }, { default: n(() => [a(e, { label: "序号", key: "idx", prop: "idx", align: "center", width: "55" }, { default: n(({ row: t }) => [u("span", null, p(t.idx), 1)]), _: 1 }), a(e, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称" }, { default: n((t) => [u("span", null, p(t.row.name || "-"), 1)]), _: 1 }), a(e, { align: "center", key: "dayTotalQuantity", prop: "dayTotalQuantity", "show-overflow-tooltip": "", label: "当日焊接新增数量/重量" }, { default: n((t) => {
      var i;
      return [l(m)(t.row.dayTotalQuantity) || l(m)(t.row.dayTotalMete) ? (r(), c("span", X, p(t.row.dayTotalQuantity) + "/" + p((i = t.row.dayTotalMete) == null ? void 0 : i.toFixed(2)), 1)) : (r(), c("span", Y, "-"))];
    }), _: 1 }), a(e, { align: "center", key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": "", label: "焊接总数量/重量" }, { default: n((t) => {
      var i;
      return [l(m)(t.row.totalQuantity) || l(m)(t.row.totalMete) ? (r(), c("span", { key: 0, style: { color: "#409eff", cursor: "pointer" }, onClick: (v) => V(t.row) }, p(t.row.totalQuantity) + "/" + p((i = t.row.totalMete) == null ? void 0 : i.toFixed(2)), 9, Z)) : (r(), c("span", tt, "-"))];
    }), _: 1 }), a(e, { align: "center", key: "dayTotalPackMete", prop: "dayTotalPackMete", "show-overflow-tooltip": "", label: "当日打包实际增量" }, { header: n(() => [a(h, { class: "item", effect: "light", content: "为搜索当天实际增加量，历史打包及当日打包在当日减少的量不扣减。", placement: "top" }, { default: n(() => [u("div", et, [o[2] || (o[2] = u("span", { style: { "margin-left": "10px" } }, "当日打包实际增量", -1)), a(s, null, { default: n(() => [a(k)]), _: 1 })])]), _: 1 })]), default: n((t) => {
      var i;
      return [l(m)(t.row.dayTotalPackMete) ? (r(), c("span", { key: 0, style: { color: "#409eff", cursor: "pointer" }, onClick: (v) => T(t.row) }, p((i = t.row.dayTotalPackMete) == null ? void 0 : i.toFixed(2)), 9, at)) : (r(), c("span", ot, "-"))];
    }), _: 1 }), a(e, { align: "center", key: "totalPackMete", prop: "totalPackMete", "show-overflow-tooltip": "", label: "打包总重量" }, { header: n(() => [a(h, { class: "item", effect: "light", content: "为历史所有时间区间 ，累计打包总重量（并需减去减少量）。", placement: "top" }, { default: n(() => [u("div", lt, [o[3] || (o[3] = u("span", { style: { "margin-left": "10px" } }, "打包总重量", -1)), a(s, null, { default: n(() => [a(k)]), _: 1 })])]), _: 1 })]), default: n((t) => {
      var i;
      return [l(m)(t.row.totalPackMete) ? (r(), c("span", { key: 0, style: { color: "#409eff", cursor: "pointer" }, onClick: (v) => T(t.row, "total") }, p((i = t.row.totalPackMete) == null ? void 0 : i.toFixed(2)), 9, nt)) : (r(), c("span", it, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "row-key"])), [[I, l(_).loading]]), a(l(j), { modelValue: w.value, "onUpdate:modelValue": o[0] || (o[0] = (t) => w.value = t), packDetailData: y.value, packDetailType: b.value }, null, 8, ["modelValue", "packDetailData", "packDetailType"]), a(l(z), { modelValue: D.value, "onUpdate:modelValue": o[1] || (o[1] = (t) => D.value = t), packDetailData: y.value }, null, 8, ["modelValue", "packDetailData"])]);
  };
} };
export {
  ft as default
};
