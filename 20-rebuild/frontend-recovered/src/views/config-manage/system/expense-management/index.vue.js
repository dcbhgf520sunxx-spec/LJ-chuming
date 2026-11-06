import { ref as v } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as n } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as D } from "vue";
import { renderList as L } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as R } from "element-plus";
import { c as S } from "../../../../modules/expense-config-93f15b94.js";
import { _ as E, x as H, g6 as h, o as V, g7 as I, G as M, an as N, P as O } from "../../../../shared/runtime.js";
import T from "./module/header.vue.js";
import A from "./module/form.vue.js";
const F = { class: "app-container" }, U = { class: "head-container" }, $ = { __name: "index", setup(q) {
  const w = { add: true, edit: false, del: false, download: false }, f = v(), { crud: p, columns: l, CRUD: y } = H({ title: "费用归类", sort: [], permission: { ...h }, optShow: { ...w }, crudApi: { ...S }, hasPagination: true }, f), { maxHeight: x } = V({ wrapperBox: ".collection", paginate: true, extraHeight: 40 });
  return y.HOOK.handleRefresh = (k, m) => {
    m.data.content = m.data.content.map((t) => (t.dictionaryIdList = [], t.links && t.links.length > 0 && t.links.map((u) => {
      t.dictionaryIdList.push(u.id);
    }), t));
  }, (k, m) => {
    const t = P, u = C("common-table"), b = R;
    return o(), _("div", F, [d("div", U, [s(e(T))]), B((o(), n(u, { ref_key: "tableRef", ref: f, data: e(p).data, "empty-text": e(p).emptyText, "max-height": e(x), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: i(() => [s(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(l).visible("name") ? (o(), n(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "费用类型名称", "min-width": "150" }, { default: i((a) => [d("div", null, c(a.row.name), 1)]), _: 1 })) : r("", true), e(l).visible("category") ? (o(), n(t, { key: "category", prop: "category", "show-overflow-tooltip": true, label: "费用类别", "min-width": "150" }, { default: i((a) => [d("div", null, c(e(I).VL[a.row.category] || "-"), 1)]), _: 1 })) : r("", true), e(l).visible("sort") ? (o(), n(t, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", "min-width": "80" }, { default: i((a) => [d("span", null, c(a.row.sort), 1)]), _: 1 })) : r("", true), e(l).visible("links") ? (o(), n(t, { key: "links", prop: "links", label: "费用明细", align: "center", "min-width": "260" }, { default: i((a) => [a.row.links && a.row.links.length > 0 ? (o(true), _(D, { key: 0 }, L(a.row.links, (g) => (o(), _("span", { key: g.id }, c(`【${g.label}】`), 1))), 128)) : r("", true)]), _: 1 })) : r("", true), e(M)([...e(h).del, ...e(h).edit]) ? (o(), n(t, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: i((a) => [s(e(N), { data: a.row }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[b, e(p).loading]]), s(e(O)), s(e(A))]);
  };
} }, Q = E($, [["__scopeId", "data-v-405e5ee9"]]);
export {
  Q as default
};
