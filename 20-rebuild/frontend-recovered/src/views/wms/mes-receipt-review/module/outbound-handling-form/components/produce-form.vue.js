import { ref as T } from "vue";
import { inject as V } from "vue";
import { computed as A } from "vue";
import { watchEffect as S } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as p } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as s } from "vue";
import { unref as u } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as m } from "vue";
import { Fragment as N } from "vue";
import { ElFormItem as Q } from "element-plus";
import { ElDivider as j } from "element-plus";
import { _ as F, rJ as f, am as l, c as b } from "../../../../../../shared/runtime.js";
const I = { style: { display: "flex", "margin-top": "10px" } }, D = { style: { flex: "1" } }, U = { class: "item-detail" }, B = { class: "cal-label" }, M = { key: 0, class: "item-detail" }, P = { key: 1, class: "item-detail" }, q = { class: "cal-label" }, H = { style: { flex: "1" } }, z = { class: "item-detail current-detail" }, J = { class: "cal-label" }, $ = { key: 0, class: "item-detail current-detail" }, G = { key: 1, class: "item-detail current-detail" }, K = { __name: "produce-form", props: { material: { type: Object }, form: { type: Object }, currentRow: { type: Object, default: () => ({}) }, maxHeight: { type: Number, default: 100 } }, setup(a, { expose: g }) {
  const e = a, t = T({ outboundQuantity: void 0 }), w = V("handleDetailList"), v = A(() => {
    var _;
    return ((_ = w.value) == null ? void 0 : _.find((o) => {
      var d;
      return o.uid === ((d = e.currentRow) == null ? void 0 : d.uid);
    })) || {};
  });
  S(() => {
    t.value = e.form;
  });
  function C() {
    t.value.outboundMete = t.value.outboundQuantity && t.value.outboundQuantity / e.material.quantity * e.material.mete || 0, t.value.currentArea = e.currentRow.basicClass === l.STEEL_PLATE.V ? (e.material.width || 0) * (e.material.length || 0) * (t.value.outboundQuantity || 0) : 0, t.value.currentLength = e.currentRow.basicClass === l.SECTION_STEEL.V ? (e.material.length || 0) * (t.value.outboundQuantity || 0) : 0;
  }
  return g({}), (_, o) => {
    var y, h, E;
    const d = O("common-input-number"), L = Q, R = j;
    return i(), r(N, null, [p(L, { label: `出库数量(${a.material.outboundUnit})`, prop: "outboundQuantity" }, { default: k(() => [p(d, { modelValue: t.value.outboundQuantity, "onUpdate:modelValue": o[0] || (o[0] = (x) => t.value.outboundQuantity = x), max: e.material.operableQuantity, min: 0, precision: a.material.outboundUnitPrecision, "controls-position": "right", onChange: C }, null, 8, ["modelValue", "max", "precision"])]), _: 1 }, 8, ["label"]), p(R), n("div", I, [n("div", D, [n("div", U, [n("span", B, "申请量（" + s(u(f)[a.currentRow.basicClass].weight.unit) + "）：", 1), c(s(a.currentRow.pickingAmount), 1)]), a.currentRow.basicClass === u(l).STEEL_PLATE.V ? (i(), r("div", M, [o[1] || (o[1] = n("span", { class: "cal-label" }, "面积（㎡）：", -1)), c(s(u(b)(a.currentRow.pickingArea, "mm²", "㎡", 4)), 1)])) : m("", true), a.currentRow.basicClass === u(l).SECTION_STEEL.V ? (i(), r("div", P, [n("span", q, "长度（m）：" + s(u(b)(a.currentRow.pickingLength, "mm", "m", 3)), 1)])) : m("", true)]), n("div", H, [n("div", z, [n("span", J, "累计办理（" + s(u(f)[a.currentRow.basicClass].weight.unit) + "）：", 1), c(s(((e.currentRow.volume || 0) + (((y = v.value) == null ? void 0 : y.currentOutboundMete) || 0) + (t.value.outboundMete || 0)).toFixed(0)), 1)]), a.currentRow.basicClass === u(l).STEEL_PLATE.V ? (i(), r("div", $, [o[2] || (o[2] = n("span", { class: "cal-label" }, "累计办理面积（㎡）：", -1)), c(s(u(b)((e.currentRow.handlingArea || 0) + (((h = v.value) == null ? void 0 : h.currentOutboundArea) || 0) + (t.value.currentArea || 0), "mm²", "㎡", 4)), 1)])) : m("", true), a.currentRow.basicClass === u(l).SECTION_STEEL.V ? (i(), r("div", G, [o[3] || (o[3] = n("span", { class: "cal-label" }, "累计办理长度（m）：", -1)), c(s(u(b)((e.currentRow.handlingLength || 0) + (((E = v.value) == null ? void 0 : E.currentOutboundLength) || 0) + (t.value.currentLength || 0), "mm", "m", 3)), 1)])) : m("", true)])])], 64);
  };
} }, Y = F(K, [["__scopeId", "data-v-5eca266d"]]);
export {
  Y as default
};
