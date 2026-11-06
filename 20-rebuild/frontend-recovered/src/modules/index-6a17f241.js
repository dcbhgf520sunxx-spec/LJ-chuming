import { b as u, F as N } from "../shared/runtime.js";
import { openBlock as l } from "vue";
import { createElementBlock as x } from "vue";
import { unref as s } from "vue";
import { createBlock as o } from "vue";
import { createSlots as F } from "vue";
import { withCtx as i } from "vue";
import { createVNode as b } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as a } from "vue";
import { createCommentVNode as f } from "vue";
import { Fragment as W } from "vue";
import { InfoFilled as C } from "@element-plus/icons-vue";
import { ElIcon as P } from "element-plus";
import { ElTooltip as p } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { renderSlot as g } from "vue";
import { computed as B } from "vue";
import { resolveDynamicComponent as A } from "vue";
const E = { style: { display: "inline-block" } }, I = { key: 0 }, D = ["onDblclick"], V = { __name: "box", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean, default: false }, snClickable: { type: Boolean, default: false }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, emits: ["drawingPreview"], setup(e, { emit: h }) {
  const k = h;
  function m(c) {
    k("drawingPreview", c);
  }
  return (c, n) => {
    const w = C, v = P, y = p, r = S;
    return l(), x(W, null, [!e.unShowField.includes("serialNumber") && (s(u)(e.columns) || e.columns.visible("serialNumber")) ? (l(), o(r, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "分段编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, F({ default: i(({ row: t }) => [e.snClickable ? (l(), x("span", { key: 1, style: { cursor: "pointer" }, onDblclick: ($) => m(t) }, a(t.serialNumber), 41, D)) : (l(), x("span", I, a(t.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [b(y, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", E, [n[0] || (n[0] = d("span", null, "分段编号", -1)), b(v, null, { default: i(() => [b(w)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("specification") && (s(u)(e.columns) || e.columns.visible("specification")) ? (l(), o(r, { key: 1, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: t }) => [d("span", null, a(t.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("material") && (s(u)(e.columns) || e.columns.visible("material")) ? (l(), o(r, { key: 2, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed }, { default: i(({ row: t }) => [d("span", null, a(t.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, T = { style: { display: "inline-block" } }, O = { key: 0 }, j = ["onDblclick"], L = { __name: "machine-part", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false }, unShowField: { type: Array, default: () => [] }, category: { type: Number } }, emits: ["drawingPreview"], setup(e, { emit: h }) {
  const k = h;
  function m(c) {
    k("drawingPreview", c);
  }
  return (c, n) => {
    const w = C, v = P, y = p, r = S;
    return l(), x(W, null, [!e.unShowField.includes("serialNumber") && (s(u)(e.columns) || e.columns.visible("serialNumber")) ? (l(), o(r, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "零件编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, F({ default: i(({ row: t }) => [e.snClickable ? (l(), x("span", { key: 1, style: { cursor: "pointer" }, onDblclick: ($) => m(t) }, a(t.serialNumber), 41, j)) : (l(), x("span", O, a(t.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [b(y, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", T, [n[0] || (n[0] = d("span", null, "零件编号", -1)), b(v, null, { default: i(() => [b(w)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("specification") && (s(u)(e.columns) || e.columns.visible("specification")) ? (l(), o(r, { key: 1, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: t }) => [d("span", null, a(t.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("material") && (s(u)(e.columns) || e.columns.visible("material")) ? (l(), o(r, { key: 2, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed }, { default: i(({ row: t }) => [d("span", null, a(t.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, M = { style: { display: "inline-block" } }, R = { key: 0 }, X = ["onDblclick"], H = { __name: "element", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false }, unShowField: { type: Array, default: () => [] }, category: { type: Number } }, emits: ["drawingPreview"], setup(e, { emit: h }) {
  const k = h;
  function m(c) {
    k("drawingPreview", c);
  }
  return (c, n) => {
    const w = C, v = P, y = p, r = S;
    return l(), x(W, null, [!e.unShowField.includes("serialNumber") && (s(u)(e.columns) || e.columns.visible("serialNumber")) ? (l(), o(r, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "单元件编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, F({ default: i(({ row: t }) => [e.snClickable ? (l(), x("span", { key: 1, style: { cursor: "pointer" }, onDblclick: ($) => m(t) }, a(t.serialNumber), 41, X)) : (l(), x("span", R, a(t.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [b(y, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", M, [n[0] || (n[0] = d("span", null, "单元件编号", -1)), b(v, null, { default: i(() => [b(w)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("specification") && (s(u)(e.columns) || e.columns.visible("specification")) ? (l(), o(r, { key: 1, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: t }) => [d("span", null, a(t.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("material") && (s(u)(e.columns) || e.columns.visible("material")) ? (l(), o(r, { key: 2, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed }, { default: i(({ row: t }) => [d("span", null, a(t.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, U = { __name: "auxiliary-material", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean, default: false }, snClickable: { type: Boolean, default: false }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (h, k) => {
    const m = S, c = p;
    return l(), x(W, null, [!e.unShowField.includes("serialNumber") && (s(u)(e.columns) || e.columns.visible("serialNumber")) ? (l(), o(m, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: n }) => [g(h.$slots, "snPrefix", { row: n }), d("span", null, a(n.serialNumber), 1)]), _: 3 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("classifyName") && (s(u)(e.columns) || e.columns.visible("classifyName")) ? (l(), o(m, { key: 1, "show-overflow-tooltip": true, prop: "classifyName", label: "名称", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: n }) => [g(h.$slots, "namePrefix", { row: n }), b(c, { content: n.classifyFullName, disabled: !n.classifyFullName, "show-after": 500, placement: "top" }, { default: i(() => [d("span", null, a(n.classifyName), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 3 }, 8, ["width", "min-width", "fixed"])) : f("", true), !e.unShowField.includes("specification") && (s(u)(e.columns) || e.columns.visible("specification")) ? (l(), o(m, { key: 2, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: n }) => [d("span", null, a(n.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : f("", true)], 64);
  };
} }, z = { __name: "index", props: { productType: { type: Number }, category: { type: Number }, columns: { type: Object }, unShowField: { type: Array, default: () => [] }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false } }, emits: ["drawingPreview"], setup(e, { emit: h }) {
  const k = h, m = e, c = B(() => {
    switch (m.productType) {
      case N.BOX.V:
        return V;
      case N.MACHINE_PART.V:
        return L;
      case N.AUXILIARY_MATERIAL.V:
        return U;
      case N.CELL.V:
        return H;
      default:
        return null;
    }
  });
  function n(w) {
    k("drawingPreview", w);
  }
  return (w, v) => (l(), o(A(c.value), { columns: e.columns, category: e.category, fixed: e.fixed, fixedWidth: e.fixedWidth, unShowField: e.unShowField, snClickable: e.snClickable, onDrawingPreview: n }, { snPrefix: i(({ row: y }) => [g(w.$slots, "snPrefix", { row: y })]), namePrefix: i(({ row: y }) => [g(w.$slots, "namePrefix", { row: y })]), _: 3 }, 40, ["columns", "category", "fixed", "fixedWidth", "unShowField", "snClickable"]));
} };
export {
  z as _
};
