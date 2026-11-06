import { ref as L } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as i } from "vue";
import { withDirectives as v } from "vue";
import { unref as s } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as f } from "vue";
import { Fragment as q } from "vue";
import { renderList as T } from "vue";
import { createCommentVNode as x } from "vue";
import { ElTableColumn as C } from "element-plus";
import { ElTooltip as B } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as R, g as j } from "../../../../../modules/product-process-bb521ab3.js";
import { x as O, aJ as h, o as $, G as E, an as H, P as I } from "../../../../../shared/runtime.js";
import M from "./module/form.vue.js";
import "../../../../../modules/process-select-cf7cf476.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-bridge-process-6f90ba68.js";
const N = { class: "app-container" }, V = { style: { display: "flex", "align-items": "center", "flex-wrap": "wrap", "white-space": "nowrap" } }, A = { key: 0, style: { display: "flex", "align-items": "center", "flex-direction": "column", height: "35px", width: "25px", "text-align": "center", "justify-content": "center", position: "relative" } }, F = { key: 0, style: { position: "absolute", top: "-5px", "font-weight": "600", left: "44%", transform: "translateX(-50%)" }, class: "tc-warning" }, W = { __name: "index", setup(U) {
  const w = { add: false, edit: false, del: false, download: false }, _ = L(), { crud: u, CRUD: y } = O({ title: "分段工序", sort: [], permission: { ...h }, optShow: { ...w }, crudApi: { ...R, get: j } }, _), { maxHeight: b } = $({ paginate: true });
  return y.HOOK.handleRefresh = (P, { data: a }) => {
    a.content = a.content.map((t) => {
      var l, c, p;
      return t.processSequenceObj = {}, t.specPrefixSequence = ((l = t.specPrefixList) == null ? void 0 : l.map((e) => `【${e.specPrefix}】`).join("")) || "", t.processSequence = (c = t.productProcessLinkList) == null ? void 0 : c.map((e) => `【${e.name}】${e.nodeTime ? "→ " + e.nodeTime + " " : ""}`).join("→"), t.processSequenceIds = (p = t.productProcessLinkList) == null ? void 0 : p.map((e) => (t.processSequenceObj[e.processId] = e.nodeTime, e.processId)), t;
    });
  }, (P, a) => {
    const t = C, l = B, c = S("common-table"), p = D;
    return n(), i("div", N, [v((n(), g(c, { ref_key: "tableRef", ref: _, stripe: false, data: s(u).data, "empty-text": s(u).emptyText, "max-height": s(b), style: { width: "100%" } }, { default: r(() => [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { prop: "name", align: "center", "show-overflow-tooltip": true, label: "分段类型" }, { default: r(({ row: e }) => [m("span", null, f(e.name), 1)]), _: 1 }), o(t, { prop: "specPrefixSequence", align: "center", "show-overflow-tooltip": true, label: "分段前缀" }), o(t, { prop: "productProcessLinkList", label: "工序", "min-width": "200" }, { default: r(({ row: { sourceRow: e } }) => [o(l, { content: `${e.processSequence}`, placement: "top-start" }, { default: r(() => [m("div", V, [(n(true), i(q, null, T(e.productProcessLinkList, (d, k) => (n(), i("div", { style: { display: "flex", "align-items": "center" }, key: d.id }, [m("span", null, "【" + f(d.name) + "】", 1), k !== e.productProcessLinkList.length - 1 ? (n(), i("div", A, [d.nodeTime ? (n(), i("div", F, f(d.nodeTime), 1)) : x("", true), a[0] || (a[0] = m("div", { style: { "font-size": "25px", "margin-top": "1px", position: "absolute", top: "50%", transform: "translateY(-50%)" } }, "→", -1))])) : x("", true)]))), 128))])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(E)([...s(h).edit]) ? (n(), g(t, { key: 0, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: r((e) => [o(s(H), { data: e.row, showDel: false }, null, 8, ["data"])]), _: 1 })) : x("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[p, s(u).loading]]), o(s(I)), o(s(M))]);
  };
} };
export {
  W as default
};
