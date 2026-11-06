import { inject as P } from "vue";
import { computed as S } from "vue";
import { resolveDirective as y } from "vue";
import { openBlock as o } from "vue";
import { createBlock as s } from "vue";
import { withCtx as a } from "vue";
import { createVNode as m } from "vue";
import { createElementVNode as t } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as n } from "vue";
import { renderSlot as p } from "vue";
import { unref as v } from "vue";
import { toDisplayString as g } from "vue";
import { ElTag as U } from "element-plus";
import { ElDescriptionsItem as V } from "element-plus";
import { ElTooltip as h } from "element-plus";
import { ElDescriptions as B } from "element-plus";
import { cV as C } from "../../../../../../../../../shared/runtime.js";
const L = { style: { color: "green" } }, T = { style: { "margin-left": "10px" } }, _ = { style: { color: "green" } }, $ = { style: { "margin-left": "10px" } }, F = { __name: "descriptions-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const d = e, x = P("maxQuantity"), N = S(() => {
    const r = d.material.factory ? d.material.factory.name : "", l = d.material.warehouse ? d.material.warehouse.name : "";
    return r ? `${r} - ${l}` : l;
  });
  return (r, l) => {
    const j = U, i = V, k = h, E = B, c = y("empty"), w = y("empty-text"), D = y("parse-project"), f = y("to-fixed");
    return o(), s(E, { column: 4, border: "" }, { default: a(() => [m(i, { label: "物料" }, { label: a(() => [l[1] || (l[1] = t("span", null, "物料", -1)), e.material.boolPartyA ? (o(), s(j, { key: 0, style: { "margin-left": "10px" }, type: "danger" }, { default: a(() => l[0] || (l[0] = [b("甲供")])), _: 1, __: [0] })) : u("", true)]), default: a(() => [n(t("span", null, null, 512), [[c, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (o(), s(i, { key: 0, label: "规格" }, { default: a(() => [m(k, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: a(() => [n(t("span", null, null, 512), [[c, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : u("", true), p(r.$slots, "afterSpec"), e.material.color ? (o(), s(i, { key: 1, label: "颜色" }, { default: a(() => [n(t("span", null, null, 512), [[c, { val: e.material.color }]])]), _: 1 })) : u("", true), m(i, { label: "品牌" }, { default: a(() => [n(t("span", null, null, 512), [[c, { val: e.material.brand }]])]), _: 1 }), p(r.$slots, "afterBrand"), e.material.project ? (o(), s(i, { key: 2, label: "项目" }, { default: a(() => [n(t("span", null, null, 512), [[w], [D, { project: e.material.project, onlyShortName: true }]])]), _: 1 })) : u("", true), m(i, { label: "存储位置" }, { default: a(() => [n(t("span", null, null, 512), [[c, { val: N.value }]])]), _: 1 }), m(i, { label: "可出库/库存" }, { default: a(() => [n(t("span", L, null, 512), [[f, { val: v(x), dp: e.material.outboundUnitPrecision }]]), l[2] || (l[2] = b(" / ")), n(t("span", null, null, 512), [[f, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), t("span", T, g(e.material.outboundUnit), 1)]), _: 1, __: [2] }), e.material.basicClass & v(C) ? (o(), s(i, { key: 3, label: "库存重量" }, { default: a(() => [n(t("span", _, null, 512), [[f, { val: e.material.operableMete, dp: e.material.accountingPrecision }]]), l[3] || (l[3] = b(" / ")), n(t("span", null, null, 512), [[f, { val: e.material.mete, dp: e.material.accountingPrecision }]]), t("span", $, g(e.material.accountingUnit), 1)]), _: 1, __: [3] })) : u("", true)]), _: 3 });
  };
} };
export {
  F as default
};
