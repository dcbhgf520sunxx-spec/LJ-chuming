import { inject as B } from "vue";
import { computed as S } from "vue";
import { resolveDirective as c } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as i } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as t } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as d } from "vue";
import { withDirectives as l } from "vue";
import { renderSlot as v } from "vue";
import { Fragment as N } from "vue";
import { unref as D } from "vue";
import { toDisplayString as E } from "vue";
import { ElTag as V } from "element-plus";
import { ElFormItem as _ } from "element-plus";
import { ElTooltip as $ } from "element-plus";
const C = { style: { color: "green" } }, F = { style: { "margin-left": "10px" } }, P = { __name: "common-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const u = e, k = B("maxQuantity"), x = S(() => {
    const s = u.material.workshop ? u.material.workshop.name : "", n = u.material.warehouse ? u.material.warehouse.name : "";
    return s ? `${s} - ${n}` : n;
  });
  return (s, n) => {
    const g = V, o = _, j = $, r = c("empty"), w = c("empty-text"), h = c("parse-project"), b = c("to-fixed");
    return m(), y(N, null, [i(o, { label: "物料" }, { label: a(() => [n[1] || (n[1] = t("span", null, "物料", -1)), e.material.boolPartyA ? (m(), f(g, { key: 0, style: { "margin-left": "10px" }, type: "danger" }, { default: a(() => n[0] || (n[0] = [p("甲供")])), _: 1, __: [0] })) : d("", true)]), default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (m(), f(o, { key: 0, label: "规格" }, { default: a(() => [i(j, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : d("", true), v(s.$slots, "afterSpec"), e.material.color ? (m(), f(o, { key: 1, label: "颜色" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.color }]])]), _: 1 })) : d("", true), i(o, { label: "品牌" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.brand }]])]), _: 1 }), v(s.$slots, "afterBrand"), e.material.project ? (m(), y(N, { key: 2 }, [i(o, { label: "项目" }, { default: a(() => [l(t("span", null, null, 512), [[w], [h, { project: e.material.project, onlyShortName: true }]])]), _: 1 }), i(o, { label: "单体" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.monomerName }]])]), _: 1 }), i(o, { label: "区域" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.areaName }]])]), _: 1 })], 64)) : d("", true), i(o, { label: "仓库" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: x.value }]])]), _: 1 }), i(o, { label: "可移库/库存" }, { default: a(() => [l(t("span", C, null, 512), [[b, { val: D(k), dp: e.material.outboundUnitPrecision }]]), n[2] || (n[2] = p(" / ")), l(t("span", null, null, 512), [[b, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), t("span", F, E(e.material.outboundUnit), 1)]), _: 1, __: [2] })], 64);
  };
} };
export {
  P as default
};
