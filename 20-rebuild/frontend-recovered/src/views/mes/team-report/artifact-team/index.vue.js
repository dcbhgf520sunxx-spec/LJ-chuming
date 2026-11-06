import { ref as w } from "vue";
import { provide as q } from "vue";
import { reactive as L } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as R } from "vue";
import { Fragment as z } from "vue";
import { renderList as A } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElProgress as Z } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as Q } from "../../../../modules/artifact-team-58f45cf9.js";
import { _ as X, x as Y, rZ as x, o as ee, ps as f, a3 as N, bs as te, G as oe } from "../../../../shared/runtime.js";
import { _ as ae } from "../../../../modules/index-3b2628f3.js";
import ne from "./module/header.vue.js";
import se from "./module/detail.vue.js";
import ie from "./module/item-detail.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../modules/index-490fd9d7.js";
const le = { class: "app-container" }, re = { class: "head-container" }, ce = { class: "status-content" }, pe = { style: { display: "flex", "flex-direction": "column" } }, de = { class: "percentage-label", style: { "margin-bottom": "5px" } }, me = { class: "percentage-value" }, ue = { class: "status-detail" }, _e = { __name: "index", setup(fe) {
  const V = [{ color: "#f56c6c", percentage: 30 }, { color: "#e6a23c", percentage: 70 }, { color: "#6f7ad3", percentage: 100 }], O = { add: false, edit: false, del: false, download: false }, k = w(), { crud: m, columns: C, CRUD: U } = Y({ title: "结构班组进度", permission: { ...x }, optShow: { ...O }, crudApi: { ...Q }, hasPagination: false }, k), { maxHeight: W } = ee({ paginate: false });
  q("query", m.query), U.HOOK.handleRefresh = (u, o) => {
    o.data.content = o.data.content.map((a) => (a.completeStatus = a.processSummaryList.map((t) => (t.completeMete = f({ productType: a.productType, weight: { num: t.completeNetWeight }, length: { num: t.completeLength } }), t.completeMeteShow = f({ productType: a.productType, weight: { num: t.completeNetWeight }, length: { num: t.completeLength, to: "m", dp: "COM_L__M" }, showUnit: true }), t.taskMete = f({ productType: a.productType, weight: { num: t.taskNetWeight }, length: { num: t.taskLength } }), t.taskMeteShow = f({ productType: a.productType, weight: { num: t.taskNetWeight }, length: { num: t.taskLength, to: "m", dp: "COM_L__M" }, showUnit: true }), t.completeRate = t.taskMete ? t.completeMete / t.taskMete * 100 : "0", t)), a));
  };
  let p = L({});
  const h = w(false);
  function $(u) {
    h.value = true, p = Object.assign(p, u);
  }
  let g = L({});
  const y = w(false);
  function E(u, o) {
    y.value = true, g = Object.assign(g, u), p = Object.assign(p, o);
  }
  return (u, o) => {
    const a = G, t = K, P = Z, T = S("common-button"), j = S("common-table"), B = F("permission"), H = J;
    return c(), v("div", le, [l("div", re, [s(e(ne))]), D((c(), _(j, { ref_key: "tableRef", ref: k, data: e(m).data, "empty-text": e(m).emptyText, "max-height": e(W), "row-key": "id", style: { width: "100%" }, onSelectionChange: e(m).selectionChangeHandler }, { default: r(() => [s(a, { type: "selection", width: "55", align: "center" }), s(a, { label: "序号", type: "index", align: "center", width: "60" }), s(e(ae), { columns: e(C), showFactory: "", showWorkshop: "", fixedWidth: "" }, null, 8, ["columns"]), e(C).visible("productionLine.name") ? (c(), _(a, { key: "productionLine.name", prop: "productionLine.name", "show-overflow-tooltip": true, label: "生产线", width: "250px" }, { default: r((n) => [s(t, { type: e(N).V[n.row.productType].T, effect: "plain" }, { default: r(() => {
      var i;
      return [b(d((i = n.row.productionLine) == null ? void 0 : i.name) + " > " + d(e(N).V[n.row.productType].SL), 1)];
    }), _: 2 }, 1032, ["type"])]), _: 1 })) : R("", true), s(a, { label: "完成状态" }, { default: r((n) => [l("div", ce, [(c(true), v(z, null, A(n.row.completeStatus, (i, I) => (c(), v("div", { key: I, class: "status-item" }, [s(P, { type: "circle", percentage: +i.completeRate, "stroke-width": 6, width: 70, color: V }, { default: r(({ percentage: M }) => [l("div", pe, [l("span", de, d(i.name), 1), l("span", me, d(e(te)(M, 2)) + "%", 1)])]), _: 2 }, 1032, ["percentage"]), l("div", ue, [l("div", null, "任务量：" + d(i.taskMeteShow), 1), l("div", null, "已完成：" + d(i.completeMeteShow), 1), D((c(), _(T, { link: "", type: "primary", size: "default", onClick: (M) => E(i, n.row) }, { default: r(() => o[2] || (o[2] = [b(" 查看详情 ")])), _: 2, __: [2] }, 1032, ["onClick"])), [[B, e(x).processDetail]])])]))), 128))])]), _: 1 }), e(oe)(e(x).detail) ? (c(), _(a, { key: 1, label: "操作", width: "120px", align: "center", fixed: "right" }, { default: r((n) => [s(T, { type: "primary", size: "default", onClick: (i) => $(n.row) }, { default: r(() => o[3] || (o[3] = [b("全景看板")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })) : R("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[H, e(m).loading]]), s(e(se), { visible: h.value, "onUpdate:visible": o[0] || (o[0] = (n) => h.value = n), info: e(p) }, null, 8, ["visible", "info"]), s(e(ie), { visible: y.value, "onUpdate:visible": o[1] || (o[1] = (n) => y.value = n), info: e(p), "item-info": e(g) }, null, 8, ["visible", "info", "item-info"])]);
  };
} }, Me = X(_e, [["__scopeId", "data-v-e02dbffb"]]);
export {
  Me as default
};
