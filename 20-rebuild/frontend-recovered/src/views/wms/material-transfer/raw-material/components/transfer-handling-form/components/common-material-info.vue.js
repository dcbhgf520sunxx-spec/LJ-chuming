import { computed as h } from "vue";
import { resolveDirective as c } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as i } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as l } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as d } from "vue";
import { withDirectives as t } from "vue";
import { renderSlot as v } from "vue";
import { Fragment as N } from "vue";
import { toDisplayString as B } from "vue";
import { ElTag as S } from "element-plus";
import { ElFormItem as D } from "element-plus";
import { ElTooltip as E } from "element-plus";
const V = { style: { color: "green" } }, $ = { style: { "margin-left": "10px" } }, F = { __name: "common-material-info", props: { material: { type: Object } }, setup(e) {
  const m = e, k = h(() => {
    const u = m.material.workshop ? m.material.workshop.name : "", o = m.material.warehouse ? m.material.warehouse.name : "";
    return `${u} - ${o}`;
  });
  return (u, o) => {
    const g = S, n = D, w = E, r = c("empty"), x = c("parse-project"), j = c("empty-text"), b = c("to-fixed");
    return s(), y(N, null, [i(n, { label: "物料" }, { label: a(() => [o[1] || (o[1] = l("span", null, "物料", -1)), e.material.boolPartyA ? (s(), f(g, { key: 0, type: "danger", style: { "margin-left": "10px" } }, { default: a(() => o[0] || (o[0] = [p("甲供")])), _: 1, __: [0] })) : d("", true)]), default: a(() => [t(l("span", null, null, 512), [[r, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (s(), f(n, { key: 0, label: "规格" }, { default: a(() => [i(w, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: a(() => [t(l("span", null, null, 512), [[r, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : d("", true), v(u.$slots, "afterSpec"), e.material.color ? (s(), f(n, { key: 1, label: "颜色" }, { default: a(() => [t(l("span", null, null, 512), [[r, { val: e.material.color }]])]), _: 1 })) : d("", true), i(n, { label: "品牌" }, { default: a(() => [t(l("span", null, null, 512), [[r, { val: e.material.brand }]])]), _: 1 }), v(u.$slots, "afterBrand"), e.material.project ? (s(), y(N, { key: 2 }, [i(n, { label: "项目" }, { default: a(() => [t(l("span", null, null, 512), [[x, { project: e.material.project, onlyShortName: true }], [j]])]), _: 1 }), i(n, { label: "单体" }, { default: a(() => [t(l("span", null, null, 512), [[r, { val: e.material.monomerName }]])]), _: 1 }), i(n, { label: "区域" }, { default: a(() => [t(l("span", null, null, 512), [[r, { val: e.material.areaName }]])]), _: 1 })], 64)) : d("", true), i(n, { label: "仓库" }, { default: a(() => [t(l("span", null, null, 512), [[r, { val: k.value }]])]), _: 1 }), i(n, { label: "可调拨/库存" }, { default: a(() => [t(l("span", V, null, 512), [[b, { val: e.material.corOperableQuantity, dp: e.material.outboundUnitPrecision }]]), o[2] || (o[2] = p(" / ")), t(l("span", null, null, 512), [[b, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), l("span", $, B(e.material.outboundUnit), 1)]), _: 1, __: [2] })], 64);
  };
} };
export {
  F as default
};
