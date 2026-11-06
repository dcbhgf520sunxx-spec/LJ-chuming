import { inject as S } from "vue";
import { computed as B } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as s } from "vue";
import { createBlock as c } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as a } from "vue";
import { createTextVNode as y } from "vue";
import { createCommentVNode as m } from "vue";
import { withDirectives as l } from "vue";
import { renderSlot as p } from "vue";
import { createElementBlock as P } from "vue";
import { Fragment as U } from "vue";
import { unref as v } from "vue";
import { toDisplayString as g } from "vue";
import { ElTag as V } from "element-plus";
import { ElDescriptionsItem as h } from "element-plus";
import { ElTooltip as C } from "element-plus";
import { ElDescriptions as L } from "element-plus";
import { cV as T } from "../../../../../../../shared/runtime.js";
const $ = { style: { color: "green" } }, F = { style: { "margin-left": "10px" } }, M = { style: { color: "green" } }, Q = { style: { "margin-left": "10px" } }, q = { __name: "descriptions-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const u = e, N = S("maxQuantity"), x = B(() => {
    const d = u.material.factory ? u.material.factory.name : "", n = u.material.warehouse ? u.material.warehouse.name : "";
    return `${d} - ${n}`;
  });
  return (d, n) => {
    const j = V, i = h, k = C, E = L, r = b("empty"), w = b("parse-project"), D = b("empty-text"), f = b("to-fixed");
    return s(), c(E, { border: "", column: 4 }, { default: t(() => [o(i, { label: "物料" }, { label: t(() => [n[1] || (n[1] = a("span", null, "物料", -1)), e.material.boolPartyA ? (s(), c(j, { key: 0, type: "danger", style: { "margin-left": "10px" } }, { default: t(() => n[0] || (n[0] = [y("甲供")])), _: 1, __: [0] })) : m("", true)]), default: t(() => [l(a("span", null, null, 512), [[r, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (s(), c(i, { key: 0, label: "规格" }, { default: t(() => [o(k, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: t(() => [l(a("span", null, null, 512), [[r, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : m("", true), p(d.$slots, "afterSpec"), e.material.color ? (s(), c(i, { key: 1, label: "颜色" }, { default: t(() => [l(a("span", null, null, 512), [[r, { val: e.material.color }]])]), _: 1 })) : m("", true), o(i, { label: "品牌" }, { default: t(() => [l(a("span", null, null, 512), [[r, { val: e.material.brand }]])]), _: 1 }), p(d.$slots, "afterBrand"), e.material.project ? (s(), P(U, { key: 2 }, [o(i, { label: "项目" }, { default: t(() => [l(a("span", null, null, 512), [[w, { project: e.material.project, onlyShortName: true }], [D]])]), _: 1 }), o(i, { label: "单体" }, { default: t(() => [l(a("span", null, null, 512), [[r, { val: e.material.monomerName }]])]), _: 1 }), o(i, { label: "区域" }, { default: t(() => [l(a("span", null, null, 512), [[r, { val: e.material.areaName }]])]), _: 1 })], 64)) : m("", true), o(i, { label: "仓库" }, { default: t(() => [l(a("span", null, null, 512), [[r, { val: x.value }]])]), _: 1 }), o(i, { label: "可出库/库存" }, { default: t(() => [l(a("span", $, null, 512), [[f, { val: v(N), dp: e.material.outboundUnitPrecision }]]), n[2] || (n[2] = y(" / ")), l(a("span", null, null, 512), [[f, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), a("span", F, g(e.material.outboundUnit), 1)]), _: 1, __: [2] }), e.material.basicClass & v(T) ? (s(), c(i, { key: 3, label: "库存重量" }, { default: t(() => [l(a("span", M, null, 512), [[f, { val: e.material.operableMete, dp: e.material.accountingPrecision }]]), n[3] || (n[3] = y(" / ")), l(a("span", null, null, 512), [[f, { val: e.material.mete, dp: e.material.accountingPrecision }]]), a("span", Q, g(e.material.accountingUnit), 1)]), _: 1, __: [3] })) : m("", true)]), _: 3 });
  };
} };
export {
  q as default
};
