import { ref as C } from "vue";
import { computed as O } from "vue";
import { watch as B } from "vue";
import { resolveComponent as H } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as p } from "vue";
import { vShow as w } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as x } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as A } from "element-plus";
import { x as N, x6 as P, o as E, G as S, an as V, P as K } from "../../../../shared/runtime.js";
import T from "./module/header.vue.js";
import U from "./module/form.vue.js";
const $ = { class: "head-container" }, Q = { __name: "index", props: { line: { type: Object, default: () => {
} } }, setup(y, { expose: v }) {
  const o = { get: ["systemDictDetail:get"], add: ["systemDictDetail:add"], edit: ["systemDictDetail:edit"], del: ["systemDictDetail:del"] }, u = C(), { crud: t, columns: n, CRUD: f } = N({ title: "字典详情", sort: [], permission: { ...o }, crudApi: { ...P }, queryOnPresenterCreated: false }, u), { maxHeight: _ } = E({ wrapperBox: ".dict-detail-card", paginate: true, extraHeight: 190 }), d = y, c = O(() => d.line && d.line.name);
  return B(() => c, (h) => {
    h.value && t.toQuery();
  }, { deep: true, immediate: true }), f.HOOK.beforeRefresh = () => (t.query.name = d.line.name, !!t.query.name), f.HOOK.beforeSubmit = () => {
    t.form.name = d.line.name;
  }, v({ permission: o, toAdd: t.toAdd }), (h, b) => {
    const r = q, g = H("common-table"), k = A;
    return a(), R("div", null, [p(m("div", null, b[0] || (b[0] = [m("div", { class: "my-code" }, "点击字典查看详情", -1)]), 512), [[w, !c.value]]), p(m("div", null, [m("div", $, [s(e(T), { ref: "header", permission: o }, null, 512)]), p((a(), i(g, { ref_key: "tableRef", ref: u, data: e(t).data, "empty-text": e(t).emptyText, "max-height": e(_), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: x(() => [s(r, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("name") ? (a(), i(r, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "所属字典", width: "120px" })) : l("", true), e(n).visible("remark") ? (a(), i(r, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "字典标签", width: "120px" })) : l("", true), e(n).visible("label") ? (a(), i(r, { key: "label", prop: "label", "show-overflow-tooltip": true, label: "字典值", width: "120px" })) : l("", true), e(n).visible("sort") ? (a(), i(r, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", "min-width": "160px" })) : l("", true), e(S)([...o.edit, ...o.del]) ? (a(), i(r, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: x((D) => [s(e(V), { data: D.row, permission: o }, null, 8, ["data"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[k, e(t).loading]]), s(e(K)), s(e(U))], 512), [[w, c.value]])]);
  };
} };
export {
  Q as default
};
