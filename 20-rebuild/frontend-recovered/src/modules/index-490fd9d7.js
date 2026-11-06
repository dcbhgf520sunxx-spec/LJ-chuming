import { b as c, kA as I, a3 as g } from "../shared/runtime.js";
import { openBlock as t } from "vue";
import { createElementBlock as w } from "vue";
import { unref as u } from "vue";
import { createBlock as o } from "vue";
import { withCtx as i } from "vue";
import { renderSlot as S } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as a } from "vue";
import { createCommentVNode as s } from "vue";
import { createSlots as p } from "vue";
import { createVNode as x } from "vue";
import { Fragment as W } from "vue";
import { ElTableColumn as F } from "element-plus";
import { InfoFilled as E } from "@element-plus/icons-vue";
import { ElIcon as B } from "element-plus";
import { ElTooltip as P } from "element-plus";
import { computed as $ } from "vue";
import { resolveDynamicComponent as D } from "vue";
const V = { style: { display: "inline-block" } }, T = { key: 0 }, O = ["onDblclick"], j = { __name: "artifact", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean, default: false }, snClickable: { type: Boolean, default: false }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, emits: ["drawingPreview"], setup(e, { emit: b }) {
  const k = b;
  function r(f) {
    k("drawingPreview", f);
  }
  return (f, n) => {
    const m = F, v = E, y = B, h = P;
    return t(), w(W, null, [!e.unShowField.includes("name") && (u(c)(e.columns) || e.columns.visible("name")) ? (t(), o(m, { key: 0, "show-overflow-tooltip": true, prop: "name", label: "名称", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: l }) => [S(f.$slots, "namePrefix", { row: l }), d("span", null, a(l.name), 1)]), _: 3 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("serialNumber") && (u(c)(e.columns) || e.columns.visible("serialNumber")) ? (t(), o(m, { key: 1, "show-overflow-tooltip": true, prop: "serialNumber", label: "构件编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, p({ default: i(({ row: l }) => [e.snClickable ? (t(), w("span", { key: 1, style: { cursor: "pointer" }, onDblclick: (C) => r(l) }, a(l.serialNumber), 41, O)) : (t(), w("span", T, a(l.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [x(h, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", V, [n[0] || (n[0] = d("span", null, "构件编号", -1)), x(y, null, { default: i(() => [x(v)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("specification") && (u(c)(e.columns) || e.columns.visible("specification")) ? (t(), o(m, { key: 2, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: l }) => [d("span", null, a(l.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("material") && (u(c)(e.columns) || e.columns.visible("material")) ? (t(), o(m, { key: 3, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed }, { default: i(({ row: l }) => [d("span", null, a(l.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true)], 64);
  };
} }, L = { style: { display: "inline-block" } }, R = { key: 0 }, M = ["onDblclick"], U = { __name: "machine-part", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false }, unShowField: { type: Array, default: () => [] }, category: { type: Number } }, emits: ["drawingPreview"], setup(e, { emit: b }) {
  const k = b;
  function r(f) {
    k("drawingPreview", f);
  }
  return (f, n) => {
    const m = E, v = B, y = P, h = F;
    return t(), w(W, null, [!e.unShowField.includes("serialNumber") && (u(c)(e.columns) || e.columns.visible("serialNumber")) ? (t(), o(h, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "零件编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, p({ default: i(({ row: l }) => [e.snClickable ? (t(), w("span", { key: 1, style: { cursor: "pointer" }, onDblclick: (C) => r(l) }, a(l.serialNumber), 41, M)) : (t(), w("span", R, a(l.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [x(y, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", L, [n[0] || (n[0] = d("span", null, "零件编号", -1)), x(v, null, { default: i(() => [x(m)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("specification") && (u(c)(e.columns) || e.columns.visible("specification")) ? (t(), o(h, { key: 1, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: l }) => [d("span", null, a(l.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("material") && (u(c)(e.columns) || e.columns.visible("material")) ? (t(), o(h, { key: 2, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed }, { default: i(({ row: l }) => [d("span", null, a(l.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true)], 64);
  };
} }, G = { style: { display: "inline-block" } }, H = { key: 0 }, X = ["onDblclick"], Y = { __name: "enclosure", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, emits: ["drawingPreview"], setup(e, { emit: b }) {
  const k = b, r = $(() => 0), f = $(() => 0), n = $(() => I.FOLDING_PIECE.V);
  function m(v) {
    k("drawingPreview", v);
  }
  return (v, y) => {
    const h = F, l = E, C = B, A = P;
    return t(), w(W, null, [!e.unShowField.includes("name") && !(r.value & e.category) && (u(c)(e.columns) || e.columns.visible("name")) ? (t(), o(h, { key: 0, "show-overflow-tooltip": true, prop: "name", label: "名称", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: N }) => [S(v.$slots, "namePrefix", { row: N }), d("span", null, a(N.name), 1)]), _: 3 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("serialNumber") && !(f.value & e.category) && (u(c)(e.columns) || e.columns.visible("serialNumber")) ? (t(), o(h, { key: 1, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, p({ default: i(({ row: N }) => [e.snClickable ? (t(), w("span", { key: 1, style: { cursor: "pointer" }, onDblclick: (Z) => m(N) }, a(N.serialNumber), 41, X)) : (t(), w("span", H, a(N.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [x(A, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", G, [y[0] || (y[0] = d("span", null, "编号", -1)), x(C, null, { default: i(() => [x(l)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("plate") && !(n.value & e.category) && (u(c)(e.columns) || e.columns.visible("plate")) ? (t(), o(h, { key: 2, "show-overflow-tooltip": true, prop: "plate", label: "板型", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: N }) => [d("span", null, a(N.plate), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true)], 64);
  };
} }, q = { style: { display: "inline-block" } }, z = { key: 0 }, J = ["onDblclick"], K = { __name: "assemble", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false }, unShowField: { type: Array, default: () => [] }, category: { type: Number } }, emits: ["drawingPreview"], setup(e, { emit: b }) {
  const k = b;
  function r(f) {
    k("drawingPreview", f);
  }
  return (f, n) => {
    const m = E, v = B, y = P, h = F;
    return t(), w(W, null, [!e.unShowField.includes("serialNumber") && (u(c)(e.columns) || e.columns.visible("serialNumber")) ? (t(), o(h, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "部件号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, p({ default: i(({ row: l }) => [e.snClickable ? (t(), w("span", { key: 1, style: { cursor: "pointer" }, onDblclick: (C) => r(l) }, a(l.serialNumber), 41, J)) : (t(), w("span", z, a(l.serialNumber), 1))]), _: 2 }, [e.snClickable ? { name: "header", fn: i(() => [x(y, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: i(() => [d("div", q, [n[0] || (n[0] = d("span", null, "部件号", -1)), x(v, null, { default: i(() => [x(m)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1032, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("specification") && (u(c)(e.columns) || e.columns.visible("specification")) ? (t(), o(h, { key: 1, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: l }) => [d("span", null, a(l.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("material") && (u(c)(e.columns) || e.columns.visible("material")) ? (t(), o(h, { key: 2, "show-overflow-tooltip": true, prop: "material", label: "材质", width: e.fixedWidth ? "80px" : "", "min-width": e.fixedWidth ? "" : "80px", fixed: e.fixed }, { default: i(({ row: l }) => [d("span", null, a(l.material), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true)], 64);
  };
} }, Q = { __name: "auxiliary-material", props: { columns: { type: Object }, fixed: { type: String }, fixedWidth: { type: Boolean, default: false }, snClickable: { type: Boolean, default: false }, category: { type: Number }, unShowField: { type: Array, default: () => [] } }, setup(e) {
  return (b, k) => {
    const r = F, f = P;
    return t(), w(W, null, [!e.unShowField.includes("serialNumber") && (u(c)(e.columns) || e.columns.visible("serialNumber")) ? (t(), o(r, { key: 0, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: n }) => [S(b.$slots, "snPrefix", { row: n }), d("span", null, a(n.serialNumber), 1)]), _: 3 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("classifyName") && (u(c)(e.columns) || e.columns.visible("classifyName")) ? (t(), o(r, { key: 1, "show-overflow-tooltip": true, prop: "classifyName", label: "名称", width: e.fixedWidth ? "120px" : "", "min-width": e.fixedWidth ? "" : "120px", fixed: e.fixed }, { default: i(({ row: n }) => [S(b.$slots, "namePrefix", { row: n }), x(f, { content: n.classifyFullName, disabled: !n.classifyFullName, "show-after": 500, placement: "top" }, { default: i(() => [d("span", null, a(n.classifyName), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 3 }, 8, ["width", "min-width", "fixed"])) : s("", true), !e.unShowField.includes("specification") && (u(c)(e.columns) || e.columns.visible("specification")) ? (t(), o(r, { key: 2, "show-overflow-tooltip": true, prop: "specification", label: "规格", width: e.fixedWidth ? "140px" : "", "min-width": e.fixedWidth ? "" : "140px", fixed: e.fixed }, { default: i(({ row: n }) => [d("span", null, a(n.specification), 1)]), _: 1 }, 8, ["width", "min-width", "fixed"])) : s("", true)], 64);
  };
} }, ie = { __name: "index", props: { productType: { type: Number }, category: { type: Number }, columns: { type: Object }, unShowField: { type: Array, default: () => [] }, fixed: { type: String }, fixedWidth: { type: Boolean }, snClickable: { type: Boolean, default: false } }, emits: ["drawingPreview"], setup(e, { emit: b }) {
  const k = b, r = e, f = $(() => {
    switch (r.productType) {
      case g.ARTIFACT.V:
        return j;
      case g.MACHINE_PART.V:
        return U;
      case g.ENCLOSURE.V:
        return Y;
      case g.AUXILIARY_MATERIAL.V:
        return Q;
      case g.ASSEMBLE.V:
        return K;
      default:
        return null;
    }
  });
  function n(m) {
    k("drawingPreview", m);
  }
  return (m, v) => (t(), o(D(f.value), { columns: e.columns, category: e.category, fixed: e.fixed, fixedWidth: e.fixedWidth, unShowField: e.unShowField, snClickable: e.snClickable, onDrawingPreview: n }, { snPrefix: i(({ row: y }) => [S(m.$slots, "snPrefix", { row: y })]), namePrefix: i(({ row: y }) => [S(m.$slots, "namePrefix", { row: y })]), _: 3 }, 40, ["columns", "category", "fixed", "fixedWidth", "unShowField", "snClickable"]));
} };
export {
  ie as _
};
