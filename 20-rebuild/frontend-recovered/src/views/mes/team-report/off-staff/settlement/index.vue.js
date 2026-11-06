import { ref as c } from "vue";
import { provide as U } from "vue";
import { computed as k } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as r } from "vue";
import { unref as t } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as u } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as m } from "vue";
import { createTextVNode as B } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as A, _ as H } from "./module/detail.vue.js";
import { x as I, o as O, pr as W, ps as M, G as j } from "../../../../../shared/runtime.js";
import { _ as E } from "../../../../../modules/index-3b2628f3.js";
import z from "./module/header.vue.js";
import "../../../../../modules/index-490fd9d7.js";
const F = { class: "app-container" }, G = { class: "head-container" }, ae = { __name: "index", setup(K) {
  const C = { add: false, edit: false, del: false, download: false }, g = { get: [] }, T = c([["price", ["to-fixed-ck", "YUAN"]]]), b = c(), { crud: s, columns: p, CRUD: N } = I({ title: "编外-工资结算", sort: [], permission: { ...g }, optShow: { ...C }, crudApi: { ...A }, hasPagination: false }, b), { maxHeight: D } = O({ paginate: true });
  U("query", s.query);
  const f = k(() => s.query.productType), a = k(() => W({ productType: f.value }));
  N.HOOK.handleRefresh = (_, n) => {
    n.data.content = n.data.content.map((e, v) => (e.rowId = v + "" + Math.random(), e.taskMete = M({ productType: f.value, weight: { num: e.taskNetWeight, to: a.value.unit, dp: a.value.dp }, length: { num: e.taskLength, to: a.value.unit, dp: a.value.dp } }), e.completeMete = M({ productType: f.value, weight: { num: e.completeNetWeight, to: a.value.unit, dp: a.value.dp }, length: { num: e.completeLength, to: a.value.unit, dp: a.value.dp } }), e));
  };
  const h = c(false), y = c({});
  function P(_) {
    y.value = _, h.value = true;
  }
  return (_, n) => {
    const e = L, v = x("common-button"), $ = x("common-table"), R = S;
    return l(), V("div", F, [d("div", G, [r(t(z))]), q((l(), u($, { ref_key: "tableRef", ref: b, data: t(s).data, "data-format": T.value, "empty-text": t(s).emptyText, "max-height": t(D), "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [r(e, { label: "序号", type: "index", align: "center", width: "60" }), r(t(E), { columns: t(p), showWorkshop: "", showProductionLine: "", showProcess: "", showTeam: "" }, null, 8, ["columns"]), t(p).visible("taskMete") ? (l(), u(e, { key: 0, prop: "taskMete", align: "center", "show-overflow-tooltip": true, label: `任务量(${a.value.unit})`, "min-width": "100px" }, { default: i(({ row: o }) => [d("span", null, w(o.taskMete), 1)]), _: 1 }, 8, ["label"])) : m("", true), t(p).visible("completeMete") ? (l(), u(e, { key: 1, prop: "completeMete", align: "center", "show-overflow-tooltip": true, label: `生产量(${a.value.unit})`, "min-width": "100px" }, { default: i(({ row: o }) => [d("span", null, w(o.completeMete), 1)]), _: 1 }, 8, ["label"])) : m("", true), t(p).visible("price") ? (l(), u(e, { key: "price", prop: "price", align: "center", "show-overflow-tooltip": true, label: "工资总额(元)", "min-width": "100px" }, { default: i(({ row: o }) => [d("span", null, w(o.price), 1)]), _: 1 })) : m("", true), t(j)([...g.detail]) ? (l(), u(e, { key: 3, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: i(({ row: o }) => [r(v, { type: "primary", size: "default", onClick: (Y) => P(o) }, { default: i(() => n[1] || (n[1] = [B("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[R, t(s).loading]]), r(t(H), { visible: h.value, "onUpdate:visible": n[0] || (n[0] = (o) => h.value = o), info: y.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  ae as default
};
