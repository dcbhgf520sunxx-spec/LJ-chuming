import { inject as B } from "vue";
import { computed as S } from "vue";
import { resolveDirective as c } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as o } from "vue";
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
import { ElTag as F } from "element-plus";
import { ElFormItem as V } from "element-plus";
import { ElTooltip as $ } from "element-plus";
const C = { style: { color: "green" } }, L = { style: { "margin-left": "10px" } }, Q = { __name: "common-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const m = e, k = B("maxQuantity"), x = S(() => {
    const u = m.material.workshop ? m.material.workshop.name : "", i = m.material.warehouse ? m.material.warehouse.name : "";
    return `${u} - ${i}`;
  });
  return (u, i) => {
    const g = F, n = V, j = $, r = c("empty"), w = c("empty-text"), h = c("parse-project"), b = c("to-fixed");
    return s(), y(N, null, [o(n, { label: "物料" }, { label: a(() => [i[1] || (i[1] = t("span", null, "物料", -1)), e.material.boolPartyA ? (s(), f(g, { key: 0, style: { "margin-left": "10px" }, type: "danger" }, { default: a(() => i[0] || (i[0] = [p("甲供")])), _: 1, __: [0] })) : d("", true)]), default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (s(), f(n, { key: 0, label: "规格" }, { default: a(() => [o(j, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : d("", true), v(u.$slots, "afterSpec"), e.material.color ? (s(), f(n, { key: 1, label: "颜色" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.color }]])]), _: 1 })) : d("", true), o(n, { label: "品牌" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.brand }]])]), _: 1 }), v(u.$slots, "afterBrand"), e.material.project ? (s(), y(N, { key: 2 }, [o(n, { label: "项目" }, { default: a(() => [l(t("span", null, null, 512), [[w], [h, { project: e.material.project, onlyShortName: true }]])]), _: 1 }), o(n, { label: "单体" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.monomerName }]])]), _: 1 }), o(n, { label: "区域" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: e.material.areaName }]])]), _: 1 })], 64)) : d("", true), o(n, { label: "仓库" }, { default: a(() => [l(t("span", null, null, 512), [[r, { val: x.value }]])]), _: 1 }), o(n, { label: e.material.isFreeze ? "可冻结/库存" : "可出库/库存" }, { default: a(() => [l(t("span", C, null, 512), [[b, { val: D(k), dp: e.material.outboundUnitPrecision }]]), i[2] || (i[2] = p(" / ")), l(t("span", null, null, 512), [[b, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), t("span", L, E(e.material.outboundUnit), 1)]), _: 1, __: [2] }, 8, ["label"])], 64);
  };
} };
export {
  Q as default
};
