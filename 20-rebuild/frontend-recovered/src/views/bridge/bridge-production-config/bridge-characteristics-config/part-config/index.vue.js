import { ref as k } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as f } from "vue";
import { unref as t } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as I } from "vue";
import { renderList as A } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as _, _ as P, x as R, as as w, o as H, i as V, at as F, G as O, an as M } from "../../../../../shared/runtime.js";
import T from "./module/header.vue.js";
import U from "./module/form.vue.js";
function $(l) {
  return _({ url: "/api/bridge/steel-class", method: "get", params: l });
}
function j(l) {
  return _({ url: "/api/bridge/steel-class", method: "post", data: l });
}
function q(l) {
  return _({ url: "/api/bridge/steel-class", method: "put", data: l });
}
function G(l) {
  return _({ url: "/api/bridge/steel-class", method: "delete", data: l });
}
const K = { get: $, add: j, edit: q, del: G };
const z = { class: "app-container" }, J = { class: "head-container" }, Q = { key: 1 }, W = { __name: "index", setup(l) {
  const x = { add: true, edit: false, del: false, download: false }, b = k(), { crud: h, columns: d, CRUD: v } = R({ title: "桥梁零件特征定义", sort: [], permission: { ...w }, optShow: { ...x }, crudApi: { ...K }, hasPagination: false }, b), { maxHeight: S } = H({ wrapperBox: ".part-config", paginate: true, extraHeight: 40 }), p = k([]);
  return v.HOOK.handleRefresh = (C, { data: y }) => {
    p.value = [], y.content.forEach((e) => {
      e.classifyNames = e.classifyLinks.map((o) => o.name).join("、"), e.classifyIds = e.classifyLinks.map((o) => o.id), e.links = [];
      for (let o = 0; o < e.specPrefixList.length; o++) e.links.push({ keyword: e.specPrefixList[o] });
      p.value = p.value.concat(e.boundFinalClassifyIds);
    });
  }, (C, y) => {
    const e = D, o = L("common-table"), N = E;
    return s(), m("div", z, [c("div", J, [f(t(T))]), B((s(), i(o, { class: "upload-table", ref_key: "tableRef", ref: b, data: t(h).data, "empty-text": t(h).emptyText, "max-height": t(S), stripe: false, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: n(() => [f(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(d).visible("name") ? (s(), i(e, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", align: "center", "min-width": "150" }, { default: n((a) => [c("span", null, u(a.row.name), 1)]), _: 1 })) : r("", true), t(d).visible("classifyNames") ? (s(), i(e, { key: "classifyNames", prop: "classifyNames", "show-overflow-tooltip": true, label: "零件科目", "min-width": "260" }, { default: n((a) => [c("span", null, u(a.row.classifyNames), 1)]), _: 1 })) : r("", true), t(d).visible("links") ? (s(), i(e, { key: "links", prop: "links", "show-overflow-tooltip": true, label: "规格前缀索引", align: "center", "min-width": "260" }, { default: n((a) => [a.row.links && a.row.links.length > 0 ? (s(true), m(I, { key: 0 }, A(a.row.links, (g) => (s(), m("span", { key: g.id }, u(`【${g.keyword}】`), 1))), 128)) : (s(), m("div", Q, "-"))]), _: 1 })) : r("", true), t(d).visible("boolSectionSteel") ? (s(), i(e, { key: "boolSectionSteel", prop: "boolSectionSteel", "show-overflow-tooltip": true, label: "是否型材", width: "100", align: "center" }, { default: n((a) => [c("span", null, u(t(V)(a.row.boolSectionSteel) ? t(F).VL[a.row.boolSectionSteel] : "-"), 1)]), _: 1 })) : r("", true), t(d).visible("sort") ? (s(), i(e, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", width: "80", align: "center" }, { default: n((a) => [c("span", null, u(a.row.sort), 1)]), _: 1 })) : r("", true), t(O)([...t(w).del, ...t(w).edit]) ? (s(), i(e, { key: 5, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((a) => [f(t(M), { data: a.row }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, t(h).loading]]), f(t(U), { boundAllClassifyIds: p.value }, null, 8, ["boundAllClassifyIds"])]);
  };
} }, te = P(W, [["__scopeId", "data-v-d62843a2"]]);
export {
  te as default
};
