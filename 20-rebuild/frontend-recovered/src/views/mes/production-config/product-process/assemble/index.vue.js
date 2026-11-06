import { ref as y } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as r } from "vue";
import { unref as a } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as g } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as s } from "vue";
import { Fragment as L } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as M } from "vue";
import { renderList as R } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElTag as V } from "element-plus";
import { ElTooltip as B } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as $, a as A } from "../../../../../modules/product-process-55b57b27.js";
import { aU as I, x as N, p3 as b, o as w, f7 as k, G as F, an as H, P as U } from "../../../../../shared/runtime.js";
import G from "./module/form.vue.js";
import z from "./module/header.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const K = { class: "app-container" }, X = { class: "head-container" }, Y = { key: 0 }, J = { key: 1 }, Q = { key: 2 }, W = { style: { display: "flex", "align-items": "center", "flex-wrap": "wrap", "white-space": "nowrap" } }, Z = { key: 0, style: { display: "flex", "align-items": "center", "flex-direction": "column", height: "35px", width: "25px", "text-align": "center", "justify-content": "center", position: "relative" } }, ee = { key: 0, style: { position: "absolute", top: "-5px", "font-weight": "600", left: "44%", transform: "translateX(-50%)" }, class: "tc-warning" }, pe = { __name: "index", setup(te) {
  const P = { add: false, edit: false, del: false, download: false }, T = y([["productionLineTypeEnum", ["parse-enum", I]]]), x = y(), { crud: h, CRUD: S } = N({ title: "部件工序", sort: [], permission: { ...b }, optShow: { ...P }, crudApi: { ...$, get: A } }, x), { maxHeight: v } = w({ paginate: true });
  return S.HOOK.handleRefresh = (C, { data: p }) => {
    p.content = p.content.map((t) => {
      var d, u, f;
      return t.processSequenceObj = {}, t.specPrefixSequence = ((d = t.assembleSpecList) == null ? void 0 : d.map((o) => `【${o.specPrefix}】`).join("")) || "", t.processSequence = (u = t.productProcessLinkList) == null ? void 0 : u.map((o) => `【${o.name}】${o.nodeTime ? "→ " + o.nodeTime + " " : ""}`).join("→"), t.processSequenceIds = (f = t.productProcessLinkList) == null ? void 0 : f.map((o) => (t.processSequenceObj[o.processId] = o.nodeTime, o.processId)), t;
    });
  }, (C, p) => {
    const t = j, d = V, u = B, f = D("common-table"), o = O;
    return n(), i("div", K, [m("div", X, [r(a(z))]), E((n(), g(f, { ref_key: "tableRef", ref: x, stripe: false, data: a(h).data, "data-format": T.value, "empty-text": a(h).emptyText, "max-height": a(v), style: { width: "100%" } }, { default: l(() => [r(t, { label: "序号", type: "index", align: "center", width: "60" }), r(t, { prop: "name", align: "center", "show-overflow-tooltip": true, label: "部件类型" }, { default: l(({ row: e }) => [m("span", null, s(e.name), 1), e.parentType & a(k).BRIDGE.V ? (n(), i(L, { key: 0 }, [e.minLength && e.maxLength ? (n(), i("span", Y, " （" + s(e.minLength) + "mm " + s(e.boolContainsMin ? "≤" : "<") + " 长度 " + s(e.boolContainsMax ? "≤" : "<") + " " + s(e.maxLength) + "mm） ", 1)) : e.minLength ? (n(), i("span", J, "（" + s(e.boolContainsMin ? "≥" : ">") + s(e.minLength) + "mm）", 1)) : e.maxLength ? (n(), i("span", Q, "（" + s(e.boolContainsMax ? "≤" : "<") + s(e.maxLength) + "mm）", 1)) : c("", true)], 64)) : c("", true), e != null && e.parentType ? (n(), g(d, { key: 1, style: { "margin-left": "5px" } }, { default: l(() => [M(s(a(k).VL[e.parentType]), 1)]), _: 2 }, 1024)) : c("", true)]), _: 1 }), r(t, { prop: "specPrefixSequence", align: "center", "show-overflow-tooltip": true, label: "部件前缀" }), r(t, { prop: "productProcessLinkList", label: "工序", "min-width": "200" }, { default: l(({ row: { sourceRow: e } }) => [r(u, { content: `${e.processSequence}`, placement: "top-start" }, { default: l(() => [m("div", W, [(n(true), i(L, null, R(e.productProcessLinkList, (_, q) => (n(), i("div", { style: { display: "flex", "align-items": "center" }, key: _.id }, [m("span", null, "【" + s(_.name) + "】", 1), q !== e.productProcessLinkList.length - 1 ? (n(), i("div", Z, [_.nodeTime ? (n(), i("div", ee, s(_.nodeTime), 1)) : c("", true), p[0] || (p[0] = m("div", { style: { "font-size": "25px", "margin-top": "1px", position: "absolute", top: "50%", transform: "translateY(-50%)" } }, "→", -1))])) : c("", true)]))), 128))])]), _: 2 }, 1032, ["content"])]), _: 1 }), a(F)([...a(b).edit]) ? (n(), g(t, { key: 0, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: l((e) => [r(a(H), { data: e.row, showDel: false }, null, 8, ["data"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[o, a(h).loading]]), r(a(U)), r(a(G))]);
  };
} };
export {
  pe as default
};
