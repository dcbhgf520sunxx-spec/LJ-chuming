import { ref as _ } from "vue";
import { inject as N } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as o } from "vue";
import { createBlock as a } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as D } from "vue";
import { unref as e } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as O } from "vue";
import { createCommentVNode as c } from "vue";
import { normalizeStyle as S } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElCard as E } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as P } from "../../../../../modules/factory-7a1d88b2.js";
import { _ as T, x as B, b7 as H, b8 as V, P as L } from "../../../../../shared/runtime.js";
import U from "./module/header.vue.js";
const j = { style: { "line-height": "1.7" } }, q = { class: "head-container" }, z = { __name: "index", emits: ["click-factory"], setup(G, { emit: h }) {
  const f = h, u = { add: false, edit: false, del: false, download: false }, m = _(), { crud: r, columns: s, CRUD: g } = B({ title: "工厂", sort: [], permission: { ...H }, optShow: { ...u }, crudApi: { ...P }, invisibleColumns: ["shortName", "remark"] }, m), b = _([["targetProduction", ["to-fixed", 2]]]), w = N("maxHeight");
  g.HOOK.handleRefresh = (n, { data: p }) => {
    p.content.forEach((t) => {
    });
  };
  function x(n) {
    n && f("click-factory", n);
  }
  return (n, p) => {
    const t = A, y = R("common-table"), C = E, v = F;
    return o(), a(C, null, { header: l(() => [d("span", j, D(e(r).title) + "列表", 1)]), default: l(() => [d("div", q, [i(e(U))]), O((o(), a(y, { ref_key: "tableRef", ref: m, data: e(r).data, "highlight-current-row": "", "data-format": b.value, "max-height": e(w), "empty-text": e(r).emptyText, style: { width: "100%" }, onCurrentChange: x }, { default: l(() => [i(t, { label: "序号", type: "index", align: "center", width: "60" }), i(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工厂名称", "min-width": "140px" }), e(s).visible("shortName") ? (o(), a(t, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, label: "工厂简称", "min-width": "140px" })) : c("", true), e(s).visible("tagColor") ? (o(), a(t, { key: "tagColor", prop: "tagColor", "show-overflow-tooltip": true, label: "标签颜色", align: "center", width: "100px" }, { default: l((k) => [d("span", { class: "color-card", style: S({ "background-color": k.row.tagColor || e(V) }) }, null, 4)]), _: 1 })) : c("", true), e(s).visible("sort") ? (o(), a(t, { key: "sort", prop: "sort", label: "排序", align: "center", width: "80px" })) : c("", true), e(s).visible("remark") ? (o(), a(t, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "160px" })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "empty-text"])), [[v, e(r).loading]]), i(e(L))]), _: 1 });
  };
} }, $ = T(z, [["__scopeId", "data-v-a060fcb4"]]);
export {
  $ as default
};
