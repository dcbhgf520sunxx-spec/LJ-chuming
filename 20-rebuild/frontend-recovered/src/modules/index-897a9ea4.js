import { b as u, kA as y, a3 as g } from "../shared/runtime.js";
import { openBlock as i } from "vue";
import { createElementBlock as W } from "vue";
import { unref as l } from "vue";
import { createBlock as n } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as a } from "vue";
import { createCommentVNode as f } from "vue";
import { renderSlot as s } from "vue";
import { Fragment as r } from "vue";
import { ElTableColumn as b } from "element-plus";
import { computed as v } from "vue";
import { resolveDynamicComponent as S } from "vue";
const N = { __name: "artifact", props: { columns: { type: Object }, fixed: { type: String }, unitNewLine: { type: Boolean, default: true }, fixedWidth: { type: Boolean, default: false }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (c, m) => {
    const w = b;
    return i(), W(r, null, [!e.unShowField.includes("length") && (l(u)(e.columns) || e.columns.visible("length")) ? (i(), n(w, { key: 0, "show-overflow-tooltip": true, prop: "length", label: `长度${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.length), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), s(c.$slots, "quantity"), !e.unShowField.includes("netWeight") && (l(u)(e.columns) || e.columns.visible("netWeight")) ? (i(), n(w, { key: 1, "show-overflow-tooltip": true, prop: "netWeight", label: `单净重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.netWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("grossWeight") && (l(u)(e.columns) || e.columns.visible("grossWeight")) ? (i(), n(w, { key: 2, "show-overflow-tooltip": true, prop: "grossWeight", label: `单毛重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.grossWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("totalNetWeight") && (l(u)(e.columns) || e.columns.visible("totalNetWeight")) ? (i(), n(w, { key: 3, "show-overflow-tooltip": true, prop: "totalNetWeight", label: `总净重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.totalNetWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("totalGrossWeight") && (l(u)(e.columns) || e.columns.visible("totalGrossWeight")) ? (i(), n(w, { key: 4, "show-overflow-tooltip": true, prop: "totalGrossWeight", label: `总毛重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.totalGrossWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("surfaceArea") && (l(u)(e.columns) || e.columns.visible("surfaceArea")) ? (i(), n(w, { key: 5, "show-overflow-tooltip": true, prop: "surfaceArea", label: `面积${e.unitNewLine ? `
` : ""}(㎡)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.surfaceArea), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, k = { __name: "machine-part", props: { columns: { type: Object }, unitNewLine: { type: Boolean, default: true }, fixed: { type: String }, fixedWidth: { type: Boolean }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (c, m) => {
    const w = b;
    return i(), W(r, null, [!e.unShowField.includes("length") && (l(u)(e.columns) || e.columns.visible("length")) ? (i(), n(w, { key: 0, "show-overflow-tooltip": true, prop: "length", label: `长度${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.length), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), s(c.$slots, "quantity"), !e.unShowField.includes("netWeight") && (l(u)(e.columns) || e.columns.visible("netWeight")) ? (i(), n(w, { key: 1, "show-overflow-tooltip": true, prop: "netWeight", label: `单净重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.netWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("grossWeight") && (l(u)(e.columns) || e.columns.visible("grossWeight")) ? (i(), n(w, { key: 2, "show-overflow-tooltip": true, prop: "grossWeight", label: `单毛重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.grossWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("totalNetWeight") && (l(u)(e.columns) || e.columns.visible("totalNetWeight")) ? (i(), n(w, { key: 3, "show-overflow-tooltip": true, prop: "totalNetWeight", label: `总净重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.totalNetWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("totalGrossWeight") && (l(u)(e.columns) || e.columns.visible("totalGrossWeight")) ? (i(), n(w, { key: 4, "show-overflow-tooltip": true, prop: "totalGrossWeight", label: `总毛重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.totalGrossWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("surfaceArea") && (l(u)(e.columns) || e.columns.visible("surfaceArea")) ? (i(), n(w, { key: 5, "show-overflow-tooltip": true, prop: "surfaceArea", label: `面积${e.unitNewLine ? `
` : ""}(㎡)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.surfaceArea), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, L = { __name: "enclosure", props: { columns: { type: Object }, unitNewLine: { type: Boolean, default: true }, fixed: { type: String }, fixedWidth: { type: Boolean }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  const c = v(() => 0), m = v(() => y.TRUSS_FLOOR_PLATE.V);
  return (w, t) => {
    const x = b;
    return i(), W(r, null, [!e.unShowField.includes("width") && !(c.value & e.category) && (l(u)(e.columns) || e.columns.visible("width")) ? (i(), n(x, { key: 0, "show-overflow-tooltip": true, prop: "width", label: `有效宽度${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.width), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("unfoldedWidth") && !(c.value & e.category) && (l(u)(e.columns) || e.columns.visible("unfoldedWidth")) && e.category !== l(y).SANDWICH_BOARD.V && e.category !== l(y).TRUSS_FLOOR_PLATE.V ? (i(), n(x, { key: 1, "show-overflow-tooltip": true, prop: "width", label: `展开宽度${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.unfoldedWidth), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("thickness") && !(m.value & e.category) && (l(u)(e.columns) || e.columns.visible("thickness")) ? (i(), n(x, { key: 2, "show-overflow-tooltip": true, prop: "thickness", label: `板厚${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.thickness), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("length") && (l(u)(e.columns) || e.columns.visible("length")) ? (i(), n(x, { key: 3, "show-overflow-tooltip": true, prop: "length", label: `单长${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.length), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), s(w.$slots, "quantity"), !e.unShowField.includes("totalArea") && (l(u)(e.columns) || e.columns.visible("totalArea")) ? (i(), n(x, { key: 4, "show-overflow-tooltip": true, prop: "totalArea", label: `总面积${e.unitNewLine ? `
` : ""}(㎡)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.totalArea), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("totalLength") && (l(u)(e.columns) || e.columns.visible("totalLength")) ? (i(), n(x, { key: 5, "show-overflow-tooltip": true, prop: "totalLength", label: `总长度${e.unitNewLine ? `
` : ""}(m)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.totalLength), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("weight") && (l(u)(e.columns) || e.columns.visible("weight")) ? (i(), n(x, { key: 6, "show-overflow-tooltip": true, prop: "weight", label: `重量${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: o }) => [h("span", null, a(o.weight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, F = { __name: "assemble", props: { columns: { type: Object }, unitNewLine: { type: Boolean, default: true }, fixed: { type: String }, fixedWidth: { type: Boolean }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (c, m) => {
    const w = b;
    return i(), W(r, null, [!e.unShowField.includes("length") && (l(u)(e.columns) || e.columns.visible("length")) ? (i(), n(w, { key: 0, "show-overflow-tooltip": true, prop: "length", label: `长度${e.unitNewLine ? `
` : ""}(mm)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.length), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), s(c.$slots, "quantity"), !e.unShowField.includes("netWeight") && (l(u)(e.columns) || e.columns.visible("netWeight")) ? (i(), n(w, { key: 1, "show-overflow-tooltip": true, prop: "netWeight", label: `单净重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.netWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("totalNetWeight") && (l(u)(e.columns) || e.columns.visible("totalNetWeight")) ? (i(), n(w, { key: 2, "show-overflow-tooltip": true, prop: "totalNetWeight", label: `总净重${e.unitNewLine ? `
` : ""}(kg)`, width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", align: "center", fixed: e.fixed }, { default: d(({ row: t }) => [h("span", null, a(t.totalNetWeight), 1)]), _: 1 }, 8, ["label", "width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, B = { __name: "index", props: { productType: { type: Number }, category: { type: Number }, unShowField: { type: Array, default: () => [] }, columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean } }, setup(e) {
  const c = e, m = v(() => {
    switch (c.productType) {
      case g.ARTIFACT.V:
        return N;
      case g.MACHINE_PART.V:
        return k;
      case g.ENCLOSURE.V:
        return L;
      case g.AUXILIARY_MATERIAL.V:
        return null;
      case g.ASSEMBLE.V:
        return F;
      default:
        return null;
    }
  });
  return (w, t) => (i(), n(S(m.value), { columns: e.columns, fixed: e.fixed, fixedWidth: e.fixedWidth, unShowField: e.unShowField, category: e.category }, { quantity: d(() => [s(w.$slots, "quantity")]), _: 3 }, 8, ["columns", "fixed", "fixedWidth", "unShowField", "category"]));
} };
export {
  B as _
};
