import { inject as w } from "vue";
import { computed as h } from "vue";
import { resolveDirective as u } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as s } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as t } from "vue";
import { createBlock as d } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as n } from "vue";
import { renderSlot as y } from "vue";
import { unref as B } from "vue";
import { toDisplayString as D } from "vue";
import { ElTag as E } from "element-plus";
import { ElFormItem as S } from "element-plus";
import { ElTooltip as V } from "element-plus";
const $ = { style: { color: "green" } }, C = { style: { "margin-left": "10px" } }, P = { __name: "common-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const m = e, v = w("maxQuantity"), k = h(() => {
    const c = m.material.workshop ? m.material.workshop.name : "", l = m.material.warehouse ? m.material.warehouse.name : "";
    return `${c} - ${l}`;
  });
  return (c, l) => {
    const x = E, o = S, j = V, i = u("empty"), N = u("empty-text"), g = u("parse-project"), p = u("to-fixed");
    return r(), _("div", null, [s(o, { label: "物料" }, { label: a(() => [l[1] || (l[1] = t("span", null, "物料", -1)), e.material.boolPartyA ? (r(), d(x, { key: 0, style: { "margin-left": "10px" }, type: "danger" }, { default: a(() => l[0] || (l[0] = [b("甲供")])), _: 1, __: [0] })) : f("", true)]), default: a(() => [n(t("span", null, null, 512), [[i, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (r(), d(o, { key: 0, label: "规格" }, { default: a(() => [s(j, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: a(() => [n(t("span", null, null, 512), [[i, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : f("", true), y(c.$slots, "afterSpec"), e.material.color ? (r(), d(o, { key: 1, label: "颜色" }, { default: a(() => [n(t("span", null, null, 512), [[i, { val: e.material.color }]])]), _: 1 })) : f("", true), s(o, { label: "品牌" }, { default: a(() => [n(t("span", null, null, 512), [[i, { val: e.material.brand }]])]), _: 1 }), y(c.$slots, "afterBrand"), e.material.project ? (r(), d(o, { key: 2, label: "项目" }, { default: a(() => [n(t("span", null, null, 512), [[N], [g, { project: e.material.project, onlyShortName: true }]])]), _: 1 })) : f("", true), s(o, { label: "仓库" }, { default: a(() => [n(t("span", null, null, 512), [[i, { val: k.value }]])]), _: 1 }), s(o, { label: "可出库/库存" }, { default: a(() => [n(t("span", $, null, 512), [[p, { val: B(v), dp: e.material.outboundUnitPrecision }]]), l[2] || (l[2] = b(" / ")), n(t("span", null, null, 512), [[p, { val: e.material.corQuantity, dp: e.material.outboundUnitPrecision }]]), t("span", C, D(e.material.outboundUnit), 1)]), _: 1, __: [2] })]);
  };
} };
export {
  P as default
};
