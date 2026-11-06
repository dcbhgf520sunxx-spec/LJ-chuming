import { ref as P } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as a } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as L } from "vue";
import { withCtx as f } from "vue";
import { toDisplayString as r } from "vue";
import { Fragment as k } from "vue";
import { createCommentVNode as u } from "vue";
import { renderList as j } from "vue";
import { normalizeClass as B } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElTooltip as F } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as U, g as z } from "../../../../../modules/product-process-55b57b27.js";
import { aU as m, x as G, p2 as C, o as K, i as N, V as W, es as v, f7 as S, dM as X, G as Y, an as J, P as Q } from "../../../../../shared/runtime.js";
import Z from "./module/form.vue.js";
import ee from "./module/header.vue.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const te = { class: "app-container" }, ne = { class: "head-container" }, oe = { key: 0 }, se = { key: 1 }, ae = { key: 0 }, ie = { key: 1 }, re = { key: 2 }, ce = { key: 1 }, pe = { key: 0 }, le = { key: 1 }, de = { style: { display: "flex", "align-items": "center", "flex-wrap": "wrap", "white-space": "nowrap" } }, ue = { key: 0, style: { display: "flex", "align-items": "center", "flex-direction": "column", height: "35px", width: "25px", "text-align": "center", "justify-content": "center", position: "relative" } }, me = { key: 0, style: { position: "absolute", top: "-5px", "font-weight": "600", left: "44%", transform: "translateX(-50%)" }, class: "tc-warning" }, we = { __name: "index", setup(fe) {
  const I = { add: false, edit: false, del: false, download: false }, R = P([["productionLineTypeEnum", ["parse-enum", m]]]), E = P(), { crud: h, CRUD: V } = G({ title: "构件工序", sort: [], permission: { ...C }, optShow: { ...I }, crudApi: { ...U, get: z } }, E), { maxHeight: M } = K({ paginate: true });
  function q({ row: g, column: d, rowIndex: s, columnIndex: l }) {
    if (d.property === "productionLineTypeEnum") return { rowspan: g.rowspan || 0, colspan: 1 };
    if (d.property === "classificationName") return { rowspan: g.classRowSpan || 0, colspan: 1 };
  }
  return V.HOOK.handleRefresh = (g, { data: d }) => {
    var x, T, e;
    let s = [];
    const l = { [m.TRADITION.V]: [], [m.INTELLECT.V]: [] };
    if (N(d)) {
      const i = W(d.content);
      for (let _ = 0; _ < i.length; _++) {
        const { structureClassificationList: w, parentType: A = null } = i[_];
        for (let b = 0; b < w.length; b++) {
          const o = w[b];
          o.processSequenceObj = {}, o.specPrefixSequence = ((x = o.specPrefixList) == null ? void 0 : x.map((c) => `【${c.specPrefix}】`).join("")) || "", o.processSequence = (T = o.productProcessLinkList) == null ? void 0 : T.map((c) => `【${c.name}】${c.nodeTime ? "→ " + c.nodeTime + " " : ""}`).join("→"), o.processSequenceIds = (e = o.productProcessLinkList) == null ? void 0 : e.map((c) => (o.processSequenceObj[c.processId] = c.nodeTime, c.processId)), o.prefixListArr = o.serialNumberPrefixList && o.artifactType === v.SMALL.V ? o.serialNumberPrefixList.map((c) => `【${c.serialNumberPrefix}】`).join("") : "", A ? o.classRowSpan = b === 0 ? w.length : 0 : o.classRowSpan = 1, l[o.productionLineTypeEnum].push({ ...o });
        }
      }
    }
    for (const i in l) N(l[i]) && l[i].length && (l[i][0].rowspan = l[i].length), s = s.concat(l[i]);
    d.content = s;
  }, (g, d) => {
    const s = $, l = F, x = D("common-table"), T = H;
    return n(), a("div", te, [y("div", ne, [p(t(ee))]), O((n(), L(x, { ref_key: "tableRef", ref: E, stripe: false, data: t(h).data, "data-format": R.value, "empty-text": t(h).emptyText, "max-height": t(M), "span-method": q, style: { width: "100%" } }, { default: f(() => [p(s, { label: "序号", type: "index", align: "center", width: "60" }), p(s, { prop: "productionLineTypeEnum", align: "center", "show-overflow-tooltip": true, label: "生产线", width: "120" }), p(s, { prop: "classificationName", align: "center", "show-overflow-tooltip": true, label: "类型" }, { default: f(({ row: { sourceRow: e } }) => [e.productionLineTypeEnum & t(m).INTELLECT.V ? (n(), a("span", oe, r(t(S).VL[e.parentType]), 1)) : (n(), a("span", se, r(e.classificationName), 1))]), _: 1 }), t(h).query.productionLineTypeEnum !== t(m).TRADITION.V ? (n(), L(s, { key: 0, align: "center", "show-overflow-tooltip": true, label: "子分类" }, { default: f(({ row: { sourceRow: e } }) => [e.productionLineTypeEnum & t(m).INTELLECT.V ? (n(), a(k, { key: 0 }, [y("span", null, r(e.classificationName), 1), e.parentType & t(S).BRIDGE.V ? (n(), a(k, { key: 0 }, [e.minLength && e.maxLength ? (n(), a("span", ae, " （" + r(e.minLength) + "mm " + r(e.boolContainsMin ? "≤" : "<") + " 长度 " + r(e.boolContainsMax ? "≤" : "<") + " " + r(e.maxLength) + "mm） ", 1)) : e.minLength ? (n(), a("span", ie, "（" + r(e.boolContainsMin ? "≥" : ">") + r(e.minLength) + "mm）", 1)) : e.maxLength ? (n(), a("span", re, "（" + r(e.boolContainsMax ? "≤" : "<") + r(e.maxLength) + "mm）", 1)) : u("", true)], 64)) : u("", true)], 64)) : (n(), a("span", ce, "-"))]), _: 1 })) : u("", true), p(s, { prop: "artifactType", align: "center", "show-overflow-tooltip": true, label: "构件类型" }, { default: f(({ row: { sourceRow: e } }) => [e.artifactType ? (n(), a("span", pe, r(t(v).VL[e.artifactType]), 1)) : (n(), a("span", le, "-"))]), _: 1 }), p(s, { prop: "specPrefixSequence", align: "center", "show-overflow-tooltip": true, label: "构件前缀" }), t(h).query.productionLineTypeEnum !== t(m).INTELLECT.V ? (n(), L(s, { key: 1, prop: "prefixListArr", align: "center", "show-overflow-tooltip": true, label: "编号前缀" })) : u("", true), t(h).query.productionLineTypeEnum !== t(m).TRADITION.V ? (n(), L(s, { key: 2, prop: "definitionWord", align: "center", "show-overflow-tooltip": true, label: "标识" })) : u("", true), p(s, { prop: "productProcessLinkList", label: "工序", "min-width": "200" }, { default: f(({ row: { sourceRow: e } }) => [p(l, { content: `${e.processSequence}`, placement: "top-start" }, { default: f(() => [y("div", de, [(n(true), a(k, null, j(e.productProcessLinkList, (i, _) => (n(), a("div", { style: { display: "flex", "align-items": "center" }, key: i.id }, [y("span", { class: B(i.productType === t(X).ASSEMBLE.V ? "tc-success" : "") }, "【" + r(i.name) + "】", 3), _ !== e.productProcessLinkList.length - 1 ? (n(), a("div", ue, [i.nodeTime ? (n(), a("div", me, r(i.nodeTime), 1)) : u("", true), d[0] || (d[0] = y("div", { style: { "font-size": "25px", "margin-top": "1px", position: "absolute", top: "50%", transform: "translateY(-50%)" } }, "→", -1))])) : u("", true)]))), 128))])]), _: 2 }, 1032, ["content"])]), _: 1 }), t(Y)([...t(C).edit]) ? (n(), L(s, { key: 3, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: f((e) => [p(t(J), { data: e.row, showDel: false }, null, 8, ["data"])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[T, t(h).loading]]), p(t(Q)), p(t(Z))]);
  };
} };
export {
  we as default
};
