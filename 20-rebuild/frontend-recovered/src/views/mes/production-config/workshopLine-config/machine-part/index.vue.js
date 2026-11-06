import { ref as v } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as r } from "vue";
import { withDirectives as _ } from "vue";
import { unref as s } from "vue";
import { createBlock as x } from "vue";
import { withCtx as m } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as f } from "vue";
import { Fragment as R } from "vue";
import { renderList as q } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElTooltip as M } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as B, b as I } from "../../../../../modules/product-process-55b57b27.js";
import { x as $, p4 as y, o as j, an as H } from "../../../../../shared/runtime.js";
import N from "./module/form.vue.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
const O = { class: "app-container" }, V = { style: { display: "flex", "align-items": "center", "flex-wrap": "wrap", "white-space": "nowrap" } }, A = { key: 0, style: { display: "flex", "align-items": "center", "flex-direction": "column", height: "35px", width: "25px", "text-align": "center", "justify-content": "center", position: "relative" } }, F = { key: 0, style: { position: "absolute", top: "-5px", "font-weight": "600", left: "44%", transform: "translateX(-50%)" }, class: "tc-warning" }, W = { __name: "index", setup(U) {
  const b = { add: false, edit: false, del: false, download: false }, h = v(), { crud: u, CRUD: k } = $({ title: "零件工序定义", sort: [], hasPagination: false, permission: { ...y }, optShow: { ...b }, crudApi: { ...B, get: I } }, h), { maxHeight: L } = j();
  return k.HOOK.handleRefresh = (P, i) => {
    i.data.content = i.data.content.map((e) => {
      var l, c, d;
      return e.specSequence = (l = e.links) == null ? void 0 : l.map((t) => `${t.keyword}【${t.specIndex ? t.specIndex : "全部"}】`).join("、"), e.processSequence = (c = e.productProcessLinkList) == null ? void 0 : c.map((t) => `【${t.name}】`).join("→"), e.processSequenceIds = (d = e.productProcessLinkList) == null ? void 0 : d.map((t) => t.processId), e;
    });
  }, (P, i) => {
    const e = E, l = M, c = C("common-table"), d = D("permission"), t = T;
    return o(), r("div", O, [_((o(), x(c, { ref_key: "tableRef", ref: h, data: s(u).data, "empty-text": s(u).emptyText, "max-height": s(L), style: { width: "100%" } }, { default: m(() => [a(e, { label: "序号", type: "index", align: "center", width: "60" }), a(e, { prop: "name", align: "center", "show-overflow-tooltip": true, label: "零件类型", "min-width": "200" }), a(e, { prop: "specSequence", "show-overflow-tooltip": true, label: "规格前缀索引", "min-width": "300" }), a(e, { prop: "productProcessLinkList", label: "工序", "min-width": "200" }, { default: m(({ row: { sourceRow: n } }) => [a(l, { content: `${n.processSequence}`, placement: "top-start" }, { default: m(() => [f("div", V, [(o(true), r(R, null, q(n.productProcessLinkList, (p, S) => (o(), r("div", { style: { display: "flex", "align-items": "center" }, key: p.id }, [f("span", null, "【" + g(p.name) + "】", 1), S !== n.productProcessLinkList.length - 1 ? (o(), r("div", A, [p.nodeTime ? (o(), r("div", F, g(p.nodeTime), 1)) : w("", true), i[0] || (i[0] = f("div", { style: { "font-size": "25px", "margin-top": "1px", position: "absolute", top: "50%", transform: "translateY(-50%)" } }, "→", -1))])) : w("", true)]))), 128))])]), _: 2 }, 1032, ["content"])]), _: 1 }), _((o(), x(e, { label: "操作", width: "100px", align: "center", fixed: "right" }, { default: m((n) => [a(s(H), { data: n.row, disabledEdit: n.row.basicClass !== 1, showDel: false }, null, 8, ["data", "disabledEdit"])]), _: 1 })), [[d, [...s(y).edit]]])]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[t, s(u).loading]]), a(s(N))]);
  };
} };
export {
  W as default
};
