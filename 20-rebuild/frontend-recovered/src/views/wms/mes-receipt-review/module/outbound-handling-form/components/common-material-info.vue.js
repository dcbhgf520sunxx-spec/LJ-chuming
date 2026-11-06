import { resolveDirective as p } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as s } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as i } from "vue";
import { createElementVNode as l } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as r } from "vue";
import { renderSlot as y } from "vue";
import { Fragment as k } from "vue";
import { ElFormItem as g } from "element-plus";
import { ElTag as x } from "element-plus";
import { ElTooltip as N } from "element-plus";
import { _ as w } from "../../../../../../shared/runtime.js";
const B = { __name: "common-material-info", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const u = e;
  return (d, o) => {
    const t = g, f = x, b = N, n = p("empty");
    return m(), v(k, null, [s(t, { label: "编号", class: "detail-item" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.brand }]])]), _: 1 }), s(t, { label: "物料种类", class: "detail-item" }, { label: a(() => [o[1] || (o[1] = l("span", null, "物料种类", -1)), e.material.boolPartyA ? (m(), c(f, { key: 0, style: { "margin-left": "10px" }, type: "danger" }, { default: a(() => o[0] || (o[0] = [_("甲供")])), _: 1, __: [0] })) : r("", true)]), default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (m(), c(t, { key: 0, label: "规格", class: "detail-item" }, { default: a(() => [s(b, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : r("", true), y(d.$slots, "afterSpec", {}, void 0, true), s(t, { label: "品牌", class: "detail-item" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.brand }]])]), _: 1 }), e.material.color ? (m(), c(t, { key: 1, label: "颜色", class: "detail-item" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.color }]])]), _: 1 })) : r("", true), s(t, { label: "所属仓库", class: "detail-item" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: u.material.workshop.name }]])]), _: 1 }), s(t, { label: "库位", class: "detail-item" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.warehouse.name }]])]), _: 1 }), s(t, { label: "库存", class: "detail-item" }, { default: a(() => [i(l("span", null, null, 512), [[n, { val: e.material.operableQuantity }]])]), _: 1 })], 64);
  };
} }, V = w(B, [["__scopeId", "data-v-5a79bef1"]]);
export {
  V as default
};
