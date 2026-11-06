import { _ as T } from "./index-490fd9d7.js";
import { _ as W } from "./index-897a9ea4.js";
import { computed as l } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as g } from "vue";
import { unref as t } from "vue";
import { createBlock as c } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as f } from "vue";
import { Fragment as N } from "vue";
import { ElTableColumn as F } from "element-plus";
import { createVNode as s } from "vue";
import { renderSlot as E } from "vue";
import { a3 as S, kA as u, b as h } from "../shared/runtime.js";
const k = { __name: "index", props: { productType: { type: Number }, category: { type: Number }, columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  const w = l(() => S.ENCLOSURE.V), x = l(() => S.ENCLOSURE.V), y = l(() => S.ENCLOSURE.V), d = l(() => u.PRESSED_FLOOR_PLATE.V | u.TRUSS_FLOOR_PLATE.V | u.SANDWICH_BOARD.V), b = l(() => u.SANDWICH_BOARD.V | u.TRUSS_FLOOR_PLATE.V);
  return (v, V) => {
    const o = F;
    return n(), g(N, null, [!e.unShowField.includes("brand") && y.value & e.productType && !(b.value & e.category) && (t(h)(e.columns) || e.columns.visible("brand")) ? (n(), c(o, { key: 0, "show-overflow-tooltip": true, prop: "brand", label: "品牌", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: a(({ row: i }) => [r("span", null, m(i.brand), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("color") && x.value & e.productType && !(d.value & e.category) && (t(h)(e.columns) || e.columns.visible("color")) ? (n(), c(o, { key: 1, "show-overflow-tooltip": true, prop: "color", label: "颜色", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: a(({ row: i }) => [r("span", null, m(i.color), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("drawingNumber") && !(w.value & e.productType) && (t(h)(e.columns) || e.columns.visible("drawingNumber")) ? (n(), c(o, { key: 2, "show-overflow-tooltip": true, prop: "drawingNumber", label: "图号", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: a(({ row: i }) => [r("span", null, m(i.drawingNumber), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("remark") && (t(h)(e.columns) || e.columns.visible("remark")) ? (n(), c(o, { key: 3, "show-overflow-tooltip": true, prop: "remark", label: "备注", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: a(({ row: i }) => [r("span", null, m(i.remark), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, R = { __name: "index", props: { productType: { type: Number }, category: { type: Number }, columns: { type: Object }, unitNewLine: { type: Boolean, default: true }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false }, unShowField: { type: Array, default: () => [] } }, emits: ["drawingPreview"], setup(e, { emit: w }) {
  const x = w;
  function y(d) {
    x("drawingPreview", d);
  }
  return (d, b) => (n(), g(N, null, [s(t(T), { productType: e.productType, category: e.category, columns: e.columns, fixed: e.fixed, onDrawingPreview: y, snClickable: e.snClickable, unShowField: e.unShowField, fixedWidth: e.fixedWidth }, null, 8, ["productType", "category", "columns", "fixed", "snClickable", "unShowField", "fixedWidth"]), s(t(W), { productType: e.productType, category: e.category, columns: e.columns, unitNewLine: e.unitNewLine, fixed: e.fixed, unShowField: e.unShowField, fixedWidth: e.fixedWidth }, { quantity: a(() => [E(d.$slots, "quantity")]), _: 3 }, 8, ["productType", "category", "columns", "unitNewLine", "fixed", "unShowField", "fixedWidth"]), s(t(k), { productType: e.productType, category: e.category, columns: e.columns, fixed: e.fixed, unShowField: e.unShowField, fixedWidth: e.fixedWidth }, null, 8, ["productType", "category", "columns", "fixed", "unShowField", "fixedWidth"])], 64));
} };
export {
  R as _
};
