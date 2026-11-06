import { ref as d } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as o } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as R } from "vue";
import { Fragment as k } from "vue";
import { renderList as V } from "vue";
import { normalizeStyle as M } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTooltip as z } from "element-plus";
import { ElPopover as H } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as L, h4 as U, x as W, BN as x, o as G, G as O, P as J, a as K } from "../../../../../shared/runtime.js";
import { c as Q, _ as X } from "./module/detail.vue.js";
import Y from "./module/header.vue.js";
const Z = { class: "app-container" }, ee = { class: "spec-box" }, te = { class: "icon expand-click-8 pointer" }, ae = { style: { "margin-top": "20px" } }, oe = { style: { "font-weight": "bold" } }, ie = { key: 0 }, le = { __name: "index", setup(ne) {
  const N = { add: false, edit: false, del: false, download: false }, P = d([["project", ["parse-project", { onlyShortName: true }]], ["weightedPriceType", ["parse-enum", U]], ["formatSpecArr", "split"]]), b = d({}), u = d(false), g = d(), { crud: f, columns: c } = W({ title: "存货明细帐", sort: ["id.desc"], permission: { ...x }, optShow: { ...N }, crudApi: { ...Q }, invisibleColumns: ["weightedPriceType"] }, g), { maxHeight: S } = G({ paginate: true });
  function A(y) {
    b.value = Object.assign({ ...f.query }, y.sourceRow), u.value = true;
  }
  return (y, v) => {
    const T = h("table-cell-tag"), l = q, w = z, C = K, B = H, j = h("common-button"), D = h("common-table"), F = I;
    return t(), m("div", Z, [n(a(Y)), E((t(), o(D, { ref_key: "tableRef", ref: g, data: a(f).data, "data-format": P.value, "max-height": a(S), "highlight-current-row": "" }, { default: s(() => [n(l, { align: "center", label: "序号", type: "index", width: "55" }, { default: s(({ row: e, $index: p }) => [n(T, { show: !!e.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), r("span", null, _(p + 1), 1)]), _: 1 }), a(c).visible("classification") ? (t(), o(l, { key: "classification", align: "center", label: "分类", "min-width": "100", prop: "classification", "show-overflow-tooltip": "" })) : i("", true), a(c).visible("classifyName") ? (t(), o(l, { key: "classifyName", align: "center", label: "名称", "min-width": "100", prop: "classifyName", "show-overflow-tooltip": "" }, { default: s(({ row: e }) => [n(w, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: s(() => [R(_(e.classifyName), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 })) : i("", true), a(c).visible("specification") ? (t(), o(l, { key: "specification", align: "left", label: "规格", "min-width": "160", prop: "specification" }, { default: s(({ row: e }) => [r("div", ee, [e.multipleSpec ? (t(), o(B, { key: 0, title: `${e.classifyName}（${e.specTip}）【${e.sourceFormatSpecArr.length}种】`, width: 500, placement: "top", trigger: "click" }, { reference: s(() => [r("span", te, [n(C, { "icon-class": "more", style: { flex: "none", color: "#2c2c2c" } })])]), default: s(() => [r("div", ae, [(t(true), m(k, null, V(e.sourceFormatSpecArr, (p, $) => (t(), m(k, { key: p }, [r("span", oe, _(p), 1), $ < e.sourceFormatSpecArr.length - 1 ? (t(), m("span", ie, "   /   ")) : i("", true)], 64))), 128))])]), _: 2 }, 1032, ["title"])) : i("", true), n(w, { content: e.specTip, placement: "top" }, { default: s(() => [r("span", { style: M({ "padding-left": e.multipleSpec ? "20px" : 0 }), class: "spec-info ellipsis-text" }, _(e.formatSpecArr), 5)]), _: 2 }, 1032, ["content"])])]), _: 1 })) : i("", true), a(c).visible("weightedPriceType") ? (t(), o(l, { key: "weightedPriceType", align: "center", label: "加权方式", "min-width": "100", prop: "weightedPriceType", "show-overflow-tooltip": "" })) : i("", true), a(c).visible("heatNoAndBatchNo") ? (t(), o(l, { key: "heatNoAndBatchNo", align: "center", label: "炉批号", "min-width": "120", prop: "heatNoAndBatchNo", "show-overflow-tooltip": "" })) : i("", true), a(c).visible("brand") ? (t(), o(l, { key: "brand", align: "center", label: "品牌", "min-width": "100", prop: "brand", "show-overflow-tooltip": "" })) : i("", true), a(c).visible("project") ? (t(), o(l, { key: "project", align: "center", label: "项目", "min-width": "140", prop: "project", "show-overflow-tooltip": "" })) : i("", true), a(c).visible("workshop.name") ? (t(), o(l, { key: "workshop.name", align: "center", label: "仓库", "min-width": "140", prop: "workshop.name", "show-overflow-tooltip": "" })) : i("", true), a(O)(a(x).detail) ? (t(), o(l, { key: 8, align: "center", fixed: "right", label: "操作", width: "80px" }, { default: s(({ row: e }) => [n(j, { icon: "el-icon-view", size: "default", type: "info", onClick: (p) => A(e) }, null, 8, ["onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[F, a(f).loading]]), n(a(J)), n(X, { visible: u.value, "onUpdate:visible": v[0] || (v[0] = (e) => u.value = e), "row-detail": b.value }, null, 8, ["visible", "row-detail"])]);
  };
} }, de = L(le, [["__scopeId", "data-v-afac9bfa"]]);
export {
  de as default
};
