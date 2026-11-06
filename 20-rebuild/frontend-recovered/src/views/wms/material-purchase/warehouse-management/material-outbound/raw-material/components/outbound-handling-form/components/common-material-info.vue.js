import { inject as C } from "vue";
import { computed as S } from "vue";
import { resolveDirective as d } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as s } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as a } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as y } from "vue";
import { withDirectives as n } from "vue";
import { renderSlot as g } from "vue";
import { unref as k } from "vue";
import { Fragment as p } from "vue";
import { toDisplayString as x } from "vue";
import { ElTag as V } from "element-plus";
import { ElFormItem as B } from "element-plus";
import { ElTooltip as L } from "element-plus";
import { cJ as D } from "../../../../../../../../../shared/runtime.js";
const M = { style: { color: "green" } }, O = { style: { "margin-left": "10px" } }, T = { style: { color: "green" } }, U = { style: { "margin-left": "10px" } }, Q = { __name: "common-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const m = e, j = C("maxQuantity"), w = S(() => {
    const c = m.material.workshop ? m.material.workshop.name : "", t = m.material.warehouse ? m.material.warehouse.name : "";
    return `${c} - ${t}`;
  });
  return (c, t) => {
    const N = V, i = B, E = L, r = d("empty"), P = d("empty-text"), h = d("parse-project"), u = d("to-fixed");
    return o(), b(p, null, [s(i, { label: "物料" }, { label: l(() => [t[1] || (t[1] = a("span", null, "物料", -1)), e.material.boolPartyA ? (o(), f(N, { key: 0, style: { "margin-left": "10px" }, type: "danger" }, { default: l(() => t[0] || (t[0] = [v("甲供")])), _: 1, __: [0] })) : y("", true)]), default: l(() => [n(a("span", null, null, 512), [[r, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (o(), f(i, { key: 0, label: "规格" }, { default: l(() => [s(E, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: l(() => [n(a("span", null, null, 512), [[r, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : y("", true), g(c.$slots, "afterSpec"), e.material.color ? (o(), f(i, { key: 1, label: "颜色" }, { default: l(() => [n(a("span", null, null, 512), [[r, { val: e.material.color }]])]), _: 1 })) : y("", true), s(i, { label: "品牌" }, { default: l(() => [n(a("span", null, null, 512), [[r, { val: e.material.brand }]])]), _: 1 }), g(c.$slots, "afterBrand"), e.material.project ? (o(), f(i, { key: 2, label: "项目" }, { default: l(() => [n(a("span", null, null, 512), [[P], [h, { project: e.material.project, onlyShortName: true }]])]), _: 1 })) : y("", true), s(i, { label: "仓库" }, { default: l(() => [n(a("span", null, null, 512), [[r, { val: w.value }]])]), _: 1 }), s(i, { label: "可出库/库存" }, { default: l(() => [e.form.materialOutboundMode === 4 && e.material.basicClass === k(D).STEEL_COIL.V ? (o(), b(p, { key: 0 }, [n(a("span", M, null, 512), [[u, { val: e.material.operableMete, dp: e.material.accountingPrecisionPrecision }]]), t[2] || (t[2] = v(" / ")), n(a("span", null, null, 512), [[u, { val: e.material.mete, dp: e.material.accountingPrecisionPrecision }]]), a("span", O, x(e.material.accountingUnit), 1)], 64)) : (o(), b(p, { key: 1 }, [n(a("span", T, null, 512), [[u, { val: k(j), dp: e.material.outboundUnitPrecision }]]), t[3] || (t[3] = v(" / ")), n(a("span", null, null, 512), [[u, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), a("span", U, x(e.material.outboundUnit), 1)], 64))]), _: 1 })], 64);
  };
} };
export {
  Q as default
};
