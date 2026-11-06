import { computed as o } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createBlock as s } from "vue";
import { createCommentVNode as r } from "vue";
import { withCtx as h } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as m } from "vue";
import { unref as x } from "vue";
import { Fragment as b } from "vue";
import { createVNode as g } from "vue";
import { ElTableColumn as N } from "element-plus";
import { sQ as j, rJ as q, bl as n, cV as y, b as d, cS as T } from "../../../../../../../../shared/runtime.js";
const $ = { __name: "raw-mat", props: { basicClass: { type: Number }, fixed: { type: String }, showQuantity: { type: Boolean, default: true }, showMete: { type: Boolean, default: true }, showNumber: { type: Boolean, default: true }, showUnit: { type: Boolean, default: true }, showSteelUnit: { type: Boolean, default: false }, outboundTypeMode: { type: Boolean, default: false }, rejectTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, numberPropField: { type: String, default: "quantity" }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, showTip: { type: Boolean, default: false } }, setup(t) {
  const e = t, { loaded: S, baseUnit: k } = j(), c = o(() => e.basicClass ? S.value ? k.value[e.basicClass] || {} : q[e.basicClass] || {} : {}), M = o(() => {
    let l = "";
    if (e.showUnit && e.showSteelUnit) l = "核算量";
    else switch (e.basicClass) {
      case n.STEEL_PLATE.V:
      case n.SECTION_STEEL.V:
      case n.STEEL_COIL.V:
      case y:
        l = `重量(${c.value.weight.unit})`;
        break;
      case n.MATERIAL.V:
      case n.GAS.V:
      default:
        l = "核算量";
        break;
    }
    return (e.labelPrefix || "") + l;
  }), C = o(() => {
    let l = "";
    if (e.showUnit && e.showSteelUnit) l = "数量";
    else switch (e.basicClass) {
      case n.STEEL_PLATE.V:
        l = `数量(${c.value.measure.unit})`;
        break;
      case n.SECTION_STEEL.V:
        l = `数量(${c.value.measure.unit})`;
        break;
      case n.STEEL_COIL.V:
        l = `长度(${c.value.measure.unit})`;
        break;
      case y:
        l = "数量";
        break;
      case n.MATERIAL.V:
      case n.GAS.V:
      default:
        l = "数量";
        break;
    }
    return (e.labelPrefix || "") + l;
  }), p = o(() => e.basicClass & y ? e.showSteelUnit && e.showUnit : e.showUnit), F = o(() => p.value && (d(e.columns) || e.columns.visible("measureUnit"))), L = o(() => p.value && (d(e.columns) || e.columns.visible("accountingUnit"))), V = o(() => e.showQuantity && (d(e.columns) || e.columns.visible(e.quantityField))), A = o(() => e.showMete && (d(e.columns) || e.columns.visible(e.meteField))), B = o(() => d(e.columns) || e.columns.visible("outboundUnit")), P = o(() => d(e.columns) || e.columns.visible("rejectUnit")), v = o(() => e.showNumber && (d(e.columns) || e.columns.visible(e.numberPropField)));
  return (l, I) => {
    var U, E;
    const u = N;
    return t.outboundTypeMode ? (i(), f(b, { key: 0 }, [B.value ? (i(), s(u, { key: "outboundUnit", prop: "outboundUnit", label: "单位", align: "center", width: "70px", fixed: t.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : r("", true), v.value ? (i(), s(u, { key: t.numberPropField, prop: t.numberPropField, label: "数量", align: "right", width: "100px", fixed: t.fixed, "show-overflow-tooltip": "" }, { default: h(({ row: a }) => [w(m(a.outboundUnitType === x(T).MEASURE.V ? a[t.quantityField] : a[t.meteField]), 1)]), _: 1 }, 8, ["prop", "fixed"])) : r("", true)], 64)) : t.rejectTypeMode ? (i(), f(b, { key: 1 }, [P.value ? (i(), s(u, { key: "rejectUnit", prop: "rejectUnit", label: "单位", align: "center", width: "70px", fixed: t.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : r("", true), v.value ? (i(), s(u, { key: t.numberPropField, prop: t.numberPropField, label: "数量", align: "right", width: "100px", fixed: t.fixed, "show-overflow-tooltip": "" }, { default: h(({ row: a }) => [w(m(a.rejectUnitType === x(T).MEASURE.V ? a[t.quantityField] : a[t.meteField]), 1)]), _: 1 }, 8, ["prop", "fixed"])) : r("", true)], 64)) : (i(), f(b, { key: 2 }, [F.value ? (i(), s(u, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "70px", fixed: t.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : r("", true), V.value ? (i(), s(u, { key: 1, prop: t.quantityField, label: C.value, align: "right", width: "100px", "show-overflow-tooltip": "", fixed: t.fixed }, null, 8, ["prop", "label", "fixed"])) : r("", true), L.value ? (i(), s(u, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "70px", fixed: t.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : r("", true), t.showTip && t.basicClass === x(n).STEEL_PLATE.V ? (i(), f(b, { key: 3 }, [g(u, { prop: "detailMete", label: `余料(${(U = c.value) == null ? void 0 : U.weight.unit})`, align: "right", width: "120px", "show-overflow-tooltip": "", fixed: t.fixed }, { default: h(({ row: a }) => [w(m(a.boolReturns ? a.detailMete : "-"), 1)]), _: 1 }, 8, ["label", "fixed"]), g(u, { prop: "actualMete", label: `总重(${(E = c.value) == null ? void 0 : E.weight.unit})`, align: "right", width: "120px", "show-overflow-tooltip": "", fixed: t.fixed }, { default: h(({ row: a }) => [w(m(a.mete), 1)]), _: 1 }, 8, ["label", "fixed"])], 64)) : (i(), f(b, { key: 4 }, [A.value ? (i(), s(u, { key: 0, prop: t.meteField, label: M.value, align: "right", width: "100px", "show-overflow-tooltip": "", fixed: t.fixed }, null, 8, ["prop", "label", "fixed"])) : r("", true)], 64))], 64));
  };
} };
export {
  $ as default
};
