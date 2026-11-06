import { ref as x } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as v } from "element-plus";
import { vLoading as k } from "element-plus";
import { _ as C, x as B, fs as l, ft as R, o as D, G as S, an as E } from "../../../../shared/runtime.js";
import H from "./module/header.vue.js";
import N from "./module/form.vue.js";
const P = { class: "app-container" }, V = { class: "head-container" }, A = { __name: "index", setup(M) {
  const _ = { add: true, edit: false, del: false, download: false }, c = x(), { crud: o, columns: p } = B({ title: "变更原因", sort: [], permission: { ...l }, optShow: { ..._ }, crudApi: { ...R }, hasPagination: false }, c), { maxHeight: f } = D({ wrapperBox: ".changeReason", paginate: true, extraHeight: 40 });
  return (T, q) => {
    const s = v, u = g("common-table"), h = k;
    return a(), w("div", P, [d("div", V, [t(e(H))]), y((a(), i(u, { ref_key: "tableRef", ref: c, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(f), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: r(() => [t(s, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(p).visible("name") ? (a(), i(s, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "变更原因", "min-width": "80" }, { default: r((n) => [d("span", null, b(n.row.name), 1)]), _: 1 })) : m("", true), e(S)([...e(l).del, ...e(l).edit]) ? (a(), i(s, { key: 1, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: r((n) => [t(e(E), { data: n.row }, null, 8, ["data"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[h, e(o).loading]]), t(e(N))]);
  };
} }, O = C(A, [["__scopeId", "data-v-ae5ff565"]]);
export {
  O as default
};
