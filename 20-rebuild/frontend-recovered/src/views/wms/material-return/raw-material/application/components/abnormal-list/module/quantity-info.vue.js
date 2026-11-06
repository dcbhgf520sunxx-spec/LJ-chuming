import { computed as o } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as u } from "vue";
import { createBlock as b } from "vue";
import { withCtx as y } from "vue";
import { withDirectives as c } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as U } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as h } from "vue";
import { createElementVNode as v } from "vue";
import { ElTableColumn as V } from "element-plus";
import { bl as s, cV as C, b as E } from "../../../../../../../../shared/runtime.js";
const F = { class: "color-coral" }, q = { key: 1 }, A = { class: "color-coral" }, M = { __name: "quantity-info", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, showSteelUnit: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, showQuantity: { type: Boolean, default: false } }, setup(n) {
  const e = n, g = o(() => {
    let l = "";
    if (e.showUnit && e.showSteelUnit) l = "核算量";
    else switch (e.basicClass) {
      case s.STEEL_PLATE.V:
      case s.SECTION_STEEL.V:
      case s.STEEL_COIL.V:
        l = "重量(kg)";
        break;
      case s.MATERIAL.V:
      case s.GAS.V:
      default:
        l = "核算量";
        break;
    }
    return (e.labelPrefix || "") + l;
  }), k = o(() => {
    let l = "";
    if (e.showUnit && e.showSteelUnit) l = "数量";
    else switch (e.basicClass) {
      case s.STEEL_PLATE.V:
        l = "数量(张)";
        break;
      case s.SECTION_STEEL.V:
        l = "数量(根)";
        break;
      case s.STEEL_COIL.V:
        l = "长度(mm)";
        break;
      case s.MATERIAL.V:
      case s.GAS.V:
      default:
        l = "数量";
        break;
    }
    return (e.labelPrefix || "") + l;
  }), w = o(() => e.basicClass & C ? e.showSteelUnit && e.showUnit : e.showUnit), x = o(() => w.value && (E(e.columns) || e.columns.visible("measureUnit"))), _ = o(() => w.value && (E(e.columns) || e.columns.visible("accountingUnit"))), L = o(() => e.showQuantity && (E(e.columns) || e.columns.visible(e.quantityField))), T = o(() => E(e.columns) || e.columns.visible(e.meteField));
  return (l, m) => {
    const d = V, i = S("empty-text"), p = S("to-fixed");
    return a(), u(h, null, [x.value ? (a(), b(d, { key: 0, prop: "measureUnit", label: "计量单位", align: "center", width: "70px", "show-overflow-tooltip": "" }, { default: y(({ row: t }) => [c((a(), u("span", null, [f(U(t.measureUnit), 1)])), [[i]])]), _: 1 })) : r("", true), L.value ? (a(), b(d, { key: 1, prop: n.quantityField, label: k.value, align: "right", width: "180px", "show-overflow-tooltip": "" }, { default: y(({ row: t }) => [t.measureUnit ? (a(), u(h, { key: 0 }, [c(v("span", null, null, 512), [[i], [p, { val: t[n.quantityField], dp: t.measurePrecision }]]), t.maxQuantity < t[n.quantityField] ? (a(), u(h, { key: 0 }, [m[0] || (m[0] = f(" -> ")), c(v("span", F, null, 512), [[i], [p, { val: t.maxQuantity, dp: t.measurePrecision }]])], 64)) : r("", true)], 64)) : c((a(), u("span", q, null, 512)), [[i]])]), _: 1 }, 8, ["prop", "label"])) : r("", true), _.value ? (a(), b(d, { key: 2, prop: "accountingUnit", label: "核算单位", align: "center", width: "70px", "show-overflow-tooltip": "" }, { default: y(({ row: t }) => [c((a(), u("span", null, [f(U(t.accountingUnit), 1)])), [[i]])]), _: 1 })) : r("", true), T.value ? (a(), b(d, { key: 3, prop: n.meteField, label: g.value, align: "right", width: "180px", "show-overflow-tooltip": "" }, { default: y(({ row: t }) => [c(v("span", null, null, 512), [[i], [p, { val: t[n.meteField], dp: t.accountingPrecision }]]), t.maxMete < t[n.meteField] ? (a(), u(h, { key: 0 }, [m[1] || (m[1] = f(" -> ")), c(v("span", A, null, 512), [[i], [p, { val: t.maxMete, dp: t.accountingPrecision }]])], 64)) : r("", true)]), _: 1 }, 8, ["prop", "label"])) : r("", true)], 64);
  };
} };
export {
  M as default
};
