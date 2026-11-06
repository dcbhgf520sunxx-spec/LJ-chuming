import { xW as W, b as m, zF as N, xP as C, bl as p } from "../shared/runtime.js";
import { computed as u } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as L } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { unref as v } from "vue";
import { createCommentVNode as n } from "vue";
import { createVNode as T } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as k } from "vue";
import { createElementVNode as g } from "vue";
import { Fragment as P } from "vue";
import { ElTooltip as S } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { mergeProps as O } from "vue";
import { resolveDynamicComponent as I } from "vue";
const R = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, j = { __name: "raw-mat", props: { showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showOutboundWorkshop: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: true }, columns: { type: Object }, fixed: { type: String }, workshopLabel: { type: String, default: "出库车间" }, showAreaBatchName: { type: Boolean, default: false } }, setup(a) {
  const e = a, { workshopNameV2KV: f } = W();
  function d(r) {
    var s;
    const B = r.workshop ? r.workshop.id : r.workshopId, w = (s = f.value[B]) == null ? void 0 : s.name, h = r.warehouse ? r.warehouse.name : r.warehouseName;
    return w ? w + "【" + h + "】" : h;
  }
  const y = u(() => m(e.columns) || e.columns.visible("warehouse")), b = u(() => e.showProject && (m(e.columns) || e.columns.visible("project"))), A = u(() => e.showMonomer && (m(e.columns) || e.columns.visible("monomerName"))), E = u(() => e.showArea && (m(e.columns) || e.columns.visible("areaName"))), V = u(() => e.showOutboundWorkshop && (m(e.columns) || e.columns.visible("workshop")));
  return (r, B) => {
    const w = _("table-cell-tag"), h = S, s = M;
    return t(), L(P, null, [b.value ? (t(), l(s, { key: "project", fixed: a.fixed, align: "left", label: "项目", "min-width": "130px", prop: "project" }, { default: i(({ row: o }) => {
      var c;
      return [a.showTransfer && o.outboundRelationType && o.outboundRelationType !== v(N).ROUTINE.V ? (t(), l(w, { key: 0, name: (c = v(N).VL) == null ? void 0 : c[o.outboundRelationType], offset: 15, type: "transfer" }, null, 8, ["name"])) : n("", true), T(h, { content: `来源项目：${o.sourceProject}`, disabled: !o.sourceProject, "show-after": 500, placement: "top" }, { default: i(() => [x(k(o.project), 1)]), _: 2 }, 1032, ["content", "disabled"])];
    }), _: 1 }, 8, ["fixed"])) : n("", true), b.value && a.showAreaBatchName ? (t(), l(s, { key: "areaBatchName", "show-overflow-tooltip": true, align: "left", label: "批次", "min-width": "100", prop: "areaBatchName" })) : n("", true), A.value ? (t(), l(s, { key: "monomerName", "show-overflow-tooltip": true, align: "left", label: "单体", "min-width": "100", prop: "monomerName" })) : n("", true), E.value ? (t(), l(s, { key: "areaName", "show-overflow-tooltip": true, align: "left", label: "区域", "min-width": "100", prop: "areaName" })) : n("", true), V.value ? (t(), l(s, { key: "mesWorkshop.name", label: a.workshopLabel, "show-overflow-tooltip": true, align: "left", "min-width": "100", prop: "mesWorkshop.name" }, { default: i(({ row: o }) => {
      var c;
      return [x(k(((c = o.mesWorkshop) == null ? void 0 : c.name) || "-"), 1)];
    }), _: 1 }, 8, ["label"])) : n("", true), y.value ? (t(), l(s, { key: "warehouse", fixed: a.fixed, align: "left", label: "仓库", "min-width": "130px", prop: "warehouse" }, { default: i(({ row: o }) => [g("div", R, [e.showWorkshop ? (t(), l(C, { key: 0, id: o.workshop ? o.workshop.id : o.workshopId }, null, 8, ["id"])) : n("", true), T(h, { class: "item", effect: "dark", content: d(o), placement: "top-start" }, { default: i(() => [g("span", null, k(o.warehouse ? o.warehouse.name : o.warehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 }, 8, ["fixed"])) : n("", true)], 64);
  };
} }, F = { __name: "index", props: { basicClass: { type: Number }, showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: true }, showFactory: { type: Boolean, default: true }, columns: { type: Object }, workshopLabel: { type: String, default: "出库车间" }, showAreaBatchName: { type: Boolean, default: false } }, setup(a) {
  const e = a, f = u(() => {
    switch (e.basicClass) {
      case p.STEEL_PLATE.V:
      case p.SECTION_STEEL.V:
      case p.STEEL_COIL.V:
      case p.MATERIAL.V:
      case p.GAS.V:
        return j;
      default:
        return j;
    }
  });
  return (d, y) => (t(), l(I(f.value), O(d.$attrs, { columns: a.columns, "show-project": a.showProject, "show-transfer": a.showTransfer, "show-monomer": a.showMonomer, "show-area": a.showArea, showAreaBatchName: a.showAreaBatchName, "show-workshop": a.showWorkshop }), null, 16, ["columns", "show-project", "show-transfer", "show-monomer", "show-area", "showAreaBatchName", "show-workshop"]));
} };
export {
  F as _
};
