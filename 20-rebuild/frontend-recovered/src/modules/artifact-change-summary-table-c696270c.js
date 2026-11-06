import { resolveComponent as _ } from "vue";
import { openBlock as f } from "vue";
import { createBlock as p } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { unref as r } from "vue";
import { createElementBlock as b } from "vue";
import { ElTableColumn as g } from "element-plus";
import { b as d } from "../shared/runtime.js";
import { p as v, b as u } from "./machine-part-change-table-207fbedf.js";
const y = { key: 1 }, B = { __name: "artifact-change-summary-table", props: { artifactCompareList: { type: Array, default: () => [] } }, setup(m) {
  function h({ row: c, column: w, rowIndex: a, columnIndex: s }) {
    if (d(c.oldArtifact)) {
      if (s === 1) return { rowspan: 1, colspan: 6 };
      if (s > 1 && s <= 6) return { rowspan: 0, colspan: 0 };
    }
    if (d(c.newArtifact)) {
      if (s === 7) return { rowspan: 1, colspan: 4 };
      if (s > 8 && s <= 11) return { rowspan: 0, colspan: 0 };
    }
  }
  return (c, w) => {
    const a = g, s = _("common-table");
    return f(), p(s, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: m.artifactCompareList, style: { width: "100%" }, "span-method": h }, { default: o(() => [l(a, { label: "序号", type: "index", align: "center", width: "60" }), l(a, { label: "原始清单", align: "center" }, { default: o(() => [l(a, { label: "编号", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i(((e = t == null ? void 0 : t.oldArtifact) == null ? void 0 : e.serialNumber) || "/"), 1)];
    }), _: 1 }), l(a, { label: "规格", "show-overflow-tooltip": "", align: "left", "min-width": "120" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i((e = t == null ? void 0 : t.oldArtifact) == null ? void 0 : e.specification), 1)];
    }), _: 1 }), l(a, { label: "长度(mm)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i((e = t == null ? void 0 : t.oldArtifact) == null ? void 0 : e.length), 1)];
    }), _: 1 }), l(a, { label: "数量", prop: "oldQuantity", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i(t.oldQuantity || ((e = t == null ? void 0 : t.oldArtifact) == null ? void 0 : e.quantity)), 1)];
    }), _: 1 }), l(a, { label: "单重(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i((e = t == null ? void 0 : t.oldArtifact) == null ? void 0 : e.netWeight), 1)];
    }), _: 1 })]), _: 1 }), l(a, { label: "构件状态", align: "center", "min-width": "400" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [t.oldArtifact ? (f(), p(r(v), { key: 0, processList: ((e = t.oldArtifact) == null ? void 0 : e.processSummaryList) || [], processObj: t.processSummary }, null, 8, ["processList", "processObj"])) : (f(), b("span", y, "/"))];
    }), _: 1 }), l(a, { label: "变更后清单", align: "center" }, { default: o(() => [l(a, { label: "编号", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i(((e = t == null ? void 0 : t.newArtifact) == null ? void 0 : e.serialNumber) || "/"), 1)];
    }), _: 1 }), l(a, { label: "长度(mm)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i((e = t == null ? void 0 : t.newArtifact) == null ? void 0 : e.length), 1)];
    }), _: 1 }), l(a, { label: "数量", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i((e = t == null ? void 0 : t.newArtifact) == null ? void 0 : e.quantity), 1)];
    }), _: 1 }), l(a, { label: "单重(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => {
      var e;
      return [n("span", null, i((e = t == null ? void 0 : t.newArtifact) == null ? void 0 : e.netWeight), 1)];
    }), _: 1 })]), _: 1 }), l(a, { label: "差异", align: "center" }, { default: o(() => [l(a, { label: "长度", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: o(({ row: { sourceRow: t } }) => [l(r(u), { value: t.diffQuantity }, null, 8, ["value"])]), _: 1 }), l(a, { label: "数量", "show-overflow-tooltip": "", align: "center", "min-width": "90" }, { default: o(({ row: { sourceRow: t } }) => [l(r(u), { value: t.diffQuantity }, null, 8, ["value"])]), _: 1 }), l(a, { label: "总重量(kg)", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: o(({ row: { sourceRow: t } }) => [l(r(u), { value: t.diffTotalWeight }, null, 8, ["value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data"]);
  };
} };
export {
  B as _
};
