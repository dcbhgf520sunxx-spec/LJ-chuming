import { ref as C } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as a } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as r } from "vue";
import { withCtx as l } from "vue";
import { createCommentVNode as n } from "vue";
import { Fragment as g } from "vue";
import { renderList as b } from "vue";
import { toDisplayString as _ } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTooltip as R } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as B, b as T } from "../../../../../modules/product-process-bb521ab3.js";
import { x as j, aM as k, o as q, i as E, at as V, G as H, an as O } from "../../../../../shared/runtime.js";
import A from "./module/header.vue.js";
import F from "./module/form.vue.js";
import "../../../../../modules/use-bridge-process-6f90ba68.js";
import "../../../../../modules/process-select-cf7cf476.js";
import "../../../../../modules/raf-ac2cc4f2.js";
const I = { class: "app-container" }, U = { class: "head-container" }, z = { key: 1 }, G = { style: { display: "flex", "align-items": "center", "flex-wrap": "wrap", "white-space": "nowrap" } }, K = { key: 0, style: { display: "flex", "align-items": "center", "flex-direction": "column", height: "35px", width: "25px", "text-align": "center", "justify-content": "center", position: "relative" } }, X = { key: 0, style: { position: "absolute", top: "-5px", "font-weight": "600", left: "44%", transform: "translateX(-50%)" }, class: "tc-warning" }, ie = { __name: "index", setup(Y) {
  const L = { add: false, edit: false, del: false, download: false }, y = C(), { crud: w, columns: c, CRUD: P } = j({ title: "桥梁-零件工序定义", sort: [], hasPagination: false, permission: { ...k }, optShow: { ...L }, crudApi: { ...B, get: T } }, y), { maxHeight: S } = q();
  return P.HOOK.handleRefresh = (v, p) => {
    p.data.content = p.data.content.map((e) => {
      var u, f, h, o;
      return e.classifyLinkName = (u = e.classifyLinks) == null ? void 0 : u.map((i) => `【${i.name}】`).join(""), e.specPrefix = (f = e.pecPrefixList) == null ? void 0 : f.map((i) => `【${i}】`).join(""), e.processSequence = (h = e.productProcessLinkList) == null ? void 0 : h.map((i) => `【${i.name}】`).join("→"), e.processSequenceIds = (o = e.productProcessLinkList) == null ? void 0 : o.map((i) => i.processId), e;
    });
  }, (v, p) => {
    const e = M, u = R, f = N("common-table"), h = $;
    return s(), a("div", I, [d("div", U, [m(t(A))]), D((s(), r(f, { ref_key: "tableRef", ref: y, data: t(w).data, "empty-text": t(w).emptyText, "max-height": t(S), style: { width: "100%" } }, { default: l(() => [m(e, { label: "序号", type: "index", align: "center", width: "60" }), t(c).visible("name") ? (s(), r(e, { key: 0, prop: "name", align: "center", "show-overflow-tooltip": true, label: "零件类型" })) : n("", true), t(c).visible("classifyLinkName") ? (s(), r(e, { key: 1, prop: "classifyLinkName", "show-overflow-tooltip": true, label: "零件科目", "min-width": "200" })) : n("", true), t(c).visible("specPrefixList") ? (s(), r(e, { key: "specPrefixList", prop: "specPrefixList", "show-overflow-tooltip": true, label: "规格前缀索引", align: "center", "min-width": "200" }, { default: l((o) => [o.row.specPrefixList && o.row.specPrefixList.length > 0 ? (s(true), a(g, { key: 0 }, b(o.row.specPrefixList, (i, x) => (s(), a("span", { key: x }, _(`【${i}】`), 1))), 128)) : (s(), a("div", z, "-"))]), _: 1 })) : n("", true), t(c).visible("productProcessLinkList") ? (s(), r(e, { key: 3, prop: "productProcessLinkList", label: "工序", "min-width": "220" }, { default: l(({ row: { sourceRow: o } }) => [m(u, { content: `${o.processSequence}`, placement: "top-start" }, { default: l(() => [d("div", G, [(s(true), a(g, null, b(o.productProcessLinkList, (i, x) => (s(), a("div", { style: { display: "flex", "align-items": "center" }, key: i.id }, [d("span", null, "【" + _(i.name) + "】", 1), x !== o.productProcessLinkList.length - 1 ? (s(), a("div", K, [i.nodeTime ? (s(), a("div", X, _(i.nodeTime), 1)) : n("", true), p[0] || (p[0] = d("div", { style: { "font-size": "25px", "margin-top": "1px", position: "absolute", top: "50%", transform: "translateY(-50%)" } }, "→", -1))])) : n("", true)]))), 128))])]), _: 2 }, 1032, ["content"])]), _: 1 })) : n("", true), t(c).visible("boolSectionSteel") ? (s(), r(e, { key: "boolSectionSteel", prop: "boolSectionSteel", "show-overflow-tooltip": true, label: "是否型材", width: "100", align: "center" }, { default: l((o) => [d("span", null, _(t(E)(o.row.boolSectionSteel) ? t(V).VL[o.row.boolSectionSteel] : "-"), 1)]), _: 1 })) : n("", true), t(H)([...t(k).edit]) ? (s(), r(e, { key: 5, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: l((o) => [m(t(O), { data: o.row, showDel: false }, null, 8, ["data"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[h, t(w).loading]]), m(t(F))]);
  };
} };
export {
  ie as default
};
