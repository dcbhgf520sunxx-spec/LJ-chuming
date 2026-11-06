import { ref as O } from "vue";
import { computed as P } from "vue";
import { watch as q } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as H } from "vue";
import { withDirectives as u } from "vue";
import { vShow as v } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createBlock as d } from "vue";
import { withCtx as g } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as A } from "element-plus";
import { l as c, x as N, o as S, G as E, an as V, P as I, dm as K } from "../../../../../shared/runtime.js";
import M from "./module/header.vue.js";
import T from "./module/form.vue.js";
function U(a) {
  return c({ module: "contract", url: "enclosure/dictionaries/dictDetail/all", method: "get", params: a });
}
function $(a) {
  return c({ module: "contract", url: "enclosure/dictionaries/dictDetailSave", method: "post", data: a });
}
function j(a) {
  return c({ module: "contract", url: "enclosure/dictionaries/dictDetail/upDate", method: "put", data: a });
}
function F(a) {
  return c({ module: "contract", url: `enclosure/dictionaries/dictDetail/${a}`, method: "delete" });
}
const G = { get: U, add: $, edit: j, del: F }, L = { class: "head-container" }, X = { __name: "index", props: { line: { type: Object, default: () => {
} } }, setup(a, { expose: _ }) {
  const n = K.detailInfo, p = O(), { crud: t, columns: f, CRUD: h } = N({ title: "围护配置", sort: [], permission: { ...n }, crudApi: { ...G }, queryOnPresenterCreated: false, hasPagination: false }, p), { maxHeight: w } = S({ wrapperBox: ".dict-detail-card", paginate: true, extraHeight: 40 }), o = a, y = P(() => o.line ? o.line.name : void 0);
  return q(() => o.line, (b) => {
    b.name ? t.toQuery() : t.data = [];
  }, { deep: true, immediate: true }), h.HOOK.beforeRefresh = () => (t.query.name = o.line.name, t.query.type = o.line.type, !!t.query.name), h.HOOK.beforeSubmit = () => {
    t.form.name = o.line.name, t.form.type = o.line.type;
  }, _({ permission: n, toAdd: t.toAdd }), (b, x) => {
    const l = R, D = B("common-table"), k = A;
    return i(), H("div", null, [u(s("div", null, x[0] || (x[0] = [s("div", { class: "my-code" }, "点击围护配置查看详情", -1)]), 512), [[v, !y.value]]), u(s("div", null, [s("div", L, [r(e(M), { ref: "header", permission: e(n) }, null, 8, ["permission"])]), u((i(), d(D, { ref_key: "tableRef", ref: p, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(w), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: g(() => [r(l, { label: "序号", type: "index", align: "center", width: "60" }), e(f).visible("label") ? (i(), d(l, { key: "label", prop: "label", "show-overflow-tooltip": true, label: "字典标签", width: "120px" })) : m("", true), e(f).visible("sort") ? (i(), d(l, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", "min-width": "160px" })) : m("", true), e(E)([...e(n).edit, ...e(n).del]) ? (i(), d(l, { key: 2, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: g((C) => [r(e(V), { data: C.row, permission: e(n) }, null, 8, ["data", "permission"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, e(t).loading]]), r(e(I)), r(e(T), { line: a.line }, null, 8, ["line"])], 512), [[v, y.value]])]);
  };
} };
export {
  X as default
};
