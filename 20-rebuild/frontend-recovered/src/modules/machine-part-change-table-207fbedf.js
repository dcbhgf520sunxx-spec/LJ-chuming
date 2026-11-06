import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { Fragment as A } from "vue";
import { createBlock as u } from "vue";
import { withCtx as s } from "vue";
import { normalizeStyle as g } from "vue";
import { unref as _ } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as v } from "element-plus";
import { renderList as P } from "vue";
import { ref as B } from "vue";
import { resolveComponent as T } from "vue";
import { c as k, b as S } from "./common-ac6e385c.js";
import { a as j, _ as L, b as x } from "../shared/runtime.js";
const O = { key: 0, style: { color: "#d00000" } }, Q = { style: { "font-weight": "600" } }, $ = { key: 1, style: { color: "#00d064" } }, N = { style: { "font-weight": "600" } }, V = { key: 1 }, y = { __name: "cell-compare-preview", props: { value: null }, setup(i) {
  const d = i;
  return (b, o) => {
    const p = j;
    return d.value ? (a(), h(A, { key: 0 }, [d.value > 0 ? (a(), h("span", O, [t(p, { "icon-class": "comp-compare-down" }), r("span", Q, c(d.value), 1)])) : (a(), h("span", $, [t(p, { "icon-class": "comp-compare-down", style: { transform: "rotate(180deg)" } }), r("span", N, c(-d.value), 1)]))], 64)) : (a(), h("span", V, "/"));
  };
} };
const W = { __name: "change-type-table-column", setup(i) {
  return (d, b) => {
    const o = v;
    return a(), u(o, { key: "invoiceType", prop: "invoiceType", label: "类型", align: "center", width: "60px" }, { default: s(({ row: p }) => [p.changeType ? (a(), h("div", { key: 0, class: "change-type-con", style: g({ backgroundColor: _(k).V[p.changeType].C }) }, c(_(k).VL[p.changeType]), 5)) : w("", true)]), _: 1 });
  };
} }, R = L(W, [["__scopeId", "data-v-6555b243"]]);
const E = { style: { display: "flex" } }, q = { __name: "production-status-box", props: { processList: { type: Array, default: () => [] }, processObj: { type: Object, default: () => {
} } }, setup(i) {
  return (d, b) => (a(), h("div", E, [(a(true), h(A, null, P(i.processList, (o) => (a(), h("div", { key: o.name, class: "process-item" }, [r("span", { class: "name", style: g(["未生产", "套料"].includes(o.name) ? "background-color: #36ae81;" : ["入库", "发运", "装配"].includes(o.name) ? "background-color: #2179eb;" : "") }, c(o.name), 5), r("span", null, c(i.processObj[o.name].quantity), 1)]))), 128))]));
} }, C = L(q, [["__scopeId", "data-v-632b876f"]]), D = { key: 1 }, G = { __name: "assemble-change-table", props: { assembleCompareList: { type: Array, default: () => [] }, showProcess: { type: Boolean, default: false } }, setup(i) {
  const d = i, b = B([["handleType", ["parse-enum", S, { bit: true, split: " 、 " }]]]);
  function o({ row: p, column: f, rowIndex: n, columnIndex: m }) {
    if (x(p.oldAssemble)) {
      if (m === 2) return { rowspan: 1, colspan: 5 };
      if (m > 2 && m <= 6) return { rowspan: 0, colspan: 0 };
    }
    if (x(p.newAssemble)) {
      if (m === 8) return { rowspan: 1, colspan: d.showProcess ? 4 : 5 };
      if (m > 8 && m <= 12 && !d.showProcess) return { rowspan: 0, colspan: 0 };
      if (m > 8 && m <= 11 && d.showProcess) return { rowspan: 0, colspan: 0 };
    }
  }
  return (p, f) => {
    const n = v, m = T("common-table");
    return a(), u(m, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: i.assembleCompareList, style: { width: "100%" }, "span-method": o, "data-format": b.value }, { default: s(() => [t(n, { label: "序号", type: "index", align: "center", width: "60" }), t(_(R)), t(n, { label: "原清单（仅显示涉及变更的部件）", align: "center" }, { default: s(() => [t(n, { label: "编号", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c(((l = e == null ? void 0 : e.oldAssemble) == null ? void 0 : l.serialNumber) || "/"), 1)];
    }), _: 1 }), t(n, { label: "规格", "show-overflow-tooltip": "", align: "left", "min-width": "120" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.oldAssemble) == null ? void 0 : l.specification), 1)];
    }), _: 1 }), t(n, { label: "长度(mm)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.oldAssemble) == null ? void 0 : l.length), 1)];
    }), _: 1 }), t(n, { label: "数量", prop: "oldQuantity", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c(e.oldQuantity || ((l = e == null ? void 0 : e.oldAssemble) == null ? void 0 : l.quantity)), 1)];
    }), _: 1 }), t(n, { label: "单重(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.oldAssemble) == null ? void 0 : l.netWeight), 1)];
    }), _: 1 })]), _: 1 }), i.showProcess ? (a(), u(n, { key: 1, label: "部件状态", align: "center", "min-width": "400" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [e.oldAssemble ? (a(), u(_(C), { key: 0, processList: ((l = e.oldAssemble) == null ? void 0 : l.processSummaryList) || [], processObj: e.processSummary }, null, 8, ["processList", "processObj"])) : (a(), h("span", D, "/"))];
    }), _: 1 })) : (a(), u(n, { key: 0, width: "10px" })), t(n, { label: "变更清单（仅显示涉及变更的部件）", align: "center" }, { default: s(() => [t(n, { label: "编号", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c(((l = e == null ? void 0 : e.newAssemble) == null ? void 0 : l.serialNumber) || "/"), 1)];
    }), _: 1 }), i.showProcess ? w("", true) : (a(), u(n, { key: 0, label: "规格", "show-overflow-tooltip": "", align: "left", "min-width": "120" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.newAssemble) == null ? void 0 : l.specification), 1)];
    }), _: 1 })), t(n, { label: "长度(mm)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.newAssemble) == null ? void 0 : l.length), 1)];
    }), _: 1 }), t(n, { label: "数量", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.newAssemble) == null ? void 0 : l.quantity), 1)];
    }), _: 1 }), t(n, { label: "单重(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => {
      var l;
      return [r("span", null, c((l = e == null ? void 0 : e.newAssemble) == null ? void 0 : l.netWeight), 1)];
    }), _: 1 })]), _: 1 }), i.showProcess ? w("", true) : (a(), u(n, { key: 2, width: "10px" })), t(n, { label: "差异", align: "center" }, { default: s(() => [t(n, { label: "数量", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: s(({ row: { sourceRow: e } }) => [t(_(y), { value: e.diffQuantity }, null, 8, ["value"])]), _: 1 }), t(n, { label: "总重量(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: s(({ row: { sourceRow: e } }) => [t(_(y), { value: e.diffTotalWeight }, null, 8, ["value"])]), _: 1 })]), _: 1 }), t(n, { label: "处理", prop: "handleType", "show-overflow-tooltip": "", align: "center", "min-width": "100" })]), _: 1 }, 8, ["data", "data-format"]);
  };
} }, F = { key: 1 }, J = { __name: "machine-part-change-table", props: { partCompareList: { type: Array, default: () => [] }, showProcess: { type: Boolean, default: false } }, setup(i) {
  return (d, b) => {
    const o = v, p = T("common-table");
    return a(), u(p, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: i.partCompareList, style: g(i.showProcess ? "width:100%" : "max-width: 1200px") }, { default: s(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(_(R)), t(o, { label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), t(o, { label: "规格", prop: "specification", "show-overflow-tooltip": "", align: "left", "min-width": "150" }), t(o, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), t(o, { label: "单重(kg)", prop: "netWeight", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), t(o, { label: "原清单数量", prop: "oldQuantity", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), i.showProcess ? (a(), u(o, { key: 1, label: "零件状态", align: "center", "min-width": "400" }, { default: s(({ row: { sourceRow: f } }) => [f.oldQuantity ? (a(), u(_(C), { key: 0, processList: f.processSummaryList || [], processObj: f.processSummary }, null, 8, ["processList", "processObj"])) : (a(), h("span", F, "/"))]), _: 1 })) : (a(), u(o, { key: 0, width: "10px" })), t(o, { label: "变更后清单数量", prop: "newQuantity", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), i.showProcess ? w("", true) : (a(), u(o, { key: 2, width: "10px" })), t(o, { label: "差异", align: "center" }, { default: s(() => [t(o, { label: "数量", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: s(({ row: f }) => [t(_(y), { value: f.diffQuantity }, null, 8, ["value"])]), _: 1 }), t(o, { label: "总重量(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: s(({ row: f }) => [t(_(y), { value: f.diffTotalWeight }, null, 8, ["value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "style"]);
  };
} };
export {
  G as _,
  J as a,
  y as b,
  C as p
};
