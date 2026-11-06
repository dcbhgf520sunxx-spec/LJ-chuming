import { ref as P } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as c } from "vue";
import { unref as o } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as a } from "vue";
import { Fragment as S } from "vue";
import { renderList as q } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTooltip as R } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as T, b as $ } from "../../../../../modules/product-process-55b57b27.js";
import { x as B, p4 as x, o as I, f9 as V, G as j, an as H } from "../../../../../shared/runtime.js";
import N from "./module/form.vue.js";
import O from "./module/header.vue.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
const A = { class: "app-container" }, F = { class: "head-container" }, U = { style: { display: "flex", "align-items": "center", "flex-wrap": "wrap", "white-space": "nowrap" } }, z = { key: 0, style: { display: "flex", "align-items": "center", "flex-direction": "column", height: "35px", width: "25px", "text-align": "center", "justify-content": "center", position: "relative" } }, G = { key: 0, style: { position: "absolute", top: "-5px", "font-weight": "600", left: "44%", transform: "translateX(-50%)" }, class: "tc-warning" }, oe = { __name: "index", setup(K) {
  const y = { add: false, edit: false, del: false, download: false }, g = P(), { crud: _, columns: p, CRUD: b } = B({ title: "零件工序定义", sort: [], hasPagination: false, permission: { ...x }, optShow: { ...y }, crudApi: { ...T, get: $ } }, g), { maxHeight: k } = I();
  return b.HOOK.handleRefresh = (L, n) => {
    n.data.content = n.data.content.map((t) => {
      var u, m, f;
      return t.specSequence = (u = t.links) == null ? void 0 : u.map((e) => `${e.keyword}【${e.specIndex ? e.specIndex : "全部"}】`).join("、"), t.processSequence = (m = t.productProcessLinkList) == null ? void 0 : m.map((e) => `【${e.name}】`).join("→"), t.processSequenceIds = (f = t.productProcessLinkList) == null ? void 0 : f.map((e) => e.processId), t;
    });
  }, (L, n) => {
    const t = D, u = R, m = v("common-table"), f = M;
    return s(), r("div", A, [l("div", F, [c(o(O))]), E((s(), i(m, { ref_key: "tableRef", ref: g, data: o(_).data, "empty-text": o(_).emptyText, "max-height": o(k), style: { width: "100%" } }, { default: d(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }), o(p).visible("productClassificationEnum") ? (s(), i(t, { key: "productClassificationEnum", "show-overflow-tooltip": true, prop: "productClassificationEnum", label: "类型", align: "center", width: "120" }, { default: d((e) => [l("span", null, w(e.row.productClassificationEnum ? o(V).V[e.row.productClassificationEnum].SL : "-"), 1)]), _: 1 })) : a("", true), o(p).visible("name") ? (s(), i(t, { key: 1, prop: "name", align: "center", "show-overflow-tooltip": true, label: "零件类型", "min-width": "200" })) : a("", true), o(p).visible("specSequence") ? (s(), i(t, { key: 2, prop: "specSequence", "show-overflow-tooltip": true, label: "规格前缀索引", "min-width": "300" })) : a("", true), o(p).visible("productProcessLinkList") ? (s(), i(t, { key: 3, prop: "productProcessLinkList", label: "工序", "min-width": "200" }, { default: d(({ row: { sourceRow: e } }) => [c(u, { content: `${e.processSequence}`, placement: "top-start" }, { default: d(() => [l("div", U, [(s(true), r(S, null, q(e.productProcessLinkList, (h, C) => (s(), r("div", { style: { display: "flex", "align-items": "center" }, key: h.id }, [l("span", null, "【" + w(h.name) + "】", 1), C !== e.productProcessLinkList.length - 1 ? (s(), r("div", z, [h.nodeTime ? (s(), r("div", G, w(h.nodeTime), 1)) : a("", true), n[0] || (n[0] = l("div", { style: { "font-size": "25px", "margin-top": "1px", position: "absolute", top: "50%", transform: "translateY(-50%)" } }, "→", -1))])) : a("", true)]))), 128))])]), _: 2 }, 1032, ["content"])]), _: 1 })) : a("", true), o(j)([...o(x).edit]) ? (s(), i(t, { key: 4, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: d((e) => [c(o(H), { data: e.row, disabledEdit: e.row.basicClass !== 1, showDel: false }, null, 8, ["data", "disabledEdit"])]), _: 1 })) : a("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[f, o(_).loading]]), c(o(N))]);
  };
} };
export {
  oe as default
};
