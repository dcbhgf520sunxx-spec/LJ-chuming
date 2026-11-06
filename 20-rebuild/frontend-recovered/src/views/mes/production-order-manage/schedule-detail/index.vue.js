import { ref as c } from "vue";
import { provide as C } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as n } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as d } from "vue";
import { Fragment as j } from "vue";
import { renderList as R } from "vue";
import { createElementVNode as B } from "vue";
import { toDisplayString as H } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as N } from "element-plus";
import { _ as V, x as q, p_ as v, o as F } from "../../../../shared/runtime.js";
import L from "./module/header.vue.js";
const M = { class: "app-container" }, O = { __name: "index", setup(P) {
  const b = { add: false, edit: false, del: false, download: false }, _ = c([]);
  for (let o = 1; o <= 12; o++) _.value.push(o + "月");
  const g = c([["project", "parse-project"]]), u = c(), { crud: r, columns: l, CRUD: x } = q({ title: "排期详情", sort: [], permission: { ...v }, optShow: { ...b }, invisibleColumns: [], hasPagination: true }, u);
  C("permission", v);
  const { maxHeight: w } = F({ paginate: true, extraHeight: 40 });
  return x.HOOK.handleRefresh = (o, { data: s }) => {
    var e;
    s.content = (e = s.content) == null ? void 0 : e.map((i) => i);
  }, (o, s) => {
    const e = E, i = D("common-table"), y = N;
    return a(), h("div", M, [p(t(L)), S((a(), n(i, { ref_key: "tableRef", ref: u, data: t(r).data, "data-format": g.value, "empty-text": t(r).emptyText, "max-height": t(w), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: m(() => [p(e, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(l).visible("project") ? (a(), n(e, { key: "project", prop: "project", label: "所属项目", width: "130", "show-overflow-tooltip": true })) : d("", true), t(l).visible("monomer.name") ? (a(), n(e, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true })) : d("", true), t(l).visible("area.name") ? (a(), n(e, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true })) : d("", true), p(e, { align: "center", label: "月度计划交货明细（单位：件/吨）", "show-overflow-tooltip": true }, { default: m(() => [(a(true), h(j, null, R(_.value, (f) => (a(), n(e, { key: f, label: f, align: "center", "show-overflow-tooltip": true }, { default: m(({ row: k }) => [B("span", null, H(k.quantity), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[y, t(r).loading]])]);
  };
} }, I = V(O, [["__scopeId", "data-v-f53ff20d"]]);
export {
  I as default
};
