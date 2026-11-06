import { computed as m } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as b } from "vue";
import { createBlock as v } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as e } from "vue";
import { toDisplayString as t } from "vue";
import { createVNode as g } from "vue";
import h from "qrcode.vue";
import { unref as i } from "vue";
import { isRef as N } from "vue";
import { _ as D, u as y } from "../../../../../shared/runtime.js";
const x = { border: "1", bordercolor: "#000000" }, w = { colspan: "2" }, C = { style: { "font-size": "25pt", "font-weight": "bold" }, colspan: "3" }, V = { colspan: "2" }, B = { colspan: "2" }, k = { rowspan: "3" }, q = { class: "qr-content" }, j = { colspan: "2" }, z = { colspan: "2" }, I = { __name: "label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => ({}) } }, emits: ["update:visible"], setup(a, { emit: d }) {
  const u = d, s = a, l = m(() => s.labelData.component || {}), { visible: o, handleClose: c } = y({ emit: u, props: s, field: "visible" });
  return (Q, n) => {
    const r = p("common-dialog");
    return b(), v(r, { title: `${l.value.name}-${l.value.serialNumber}`, visible: i(o), "onUpdate:visible": n[0] || (n[0] = (_) => N(o) ? o.value = _ : null), width: "640px", "before-close": i(c) }, { default: f(() => [e("table", x, [e("tr", null, [e("td", w, t(l.value.projectName), 1), e("td", null, t(l.value.monomerName), 1)]), e("tr", null, [e("td", C, t(l.value.serialNumber), 1)]), e("tr", null, [e("td", null, "名称： " + t(l.value.name), 1), e("td", V, "规格： " + t(l.value.specification), 1)]), e("tr", null, [e("td", null, "数量：" + t(l.value.quantity), 1), e("td", null, "长度(m): " + t(l.value.length), 1), e("td", null, "单重(kg): " + t(l.value.weight), 1)]), e("tr", null, [e("td", B, t(l.value.areaName ? "区域：" + l.value.areaName : ""), 1), e("td", k, [e("div", q, [g(h, { value: a.labelData.qrCode, size: 180, margin: 2 }, null, 8, ["value"])])])]), e("tr", null, [e("td", j, t(a.labelData.productionLineName), 1)]), e("tr", null, [e("td", z, t(a.labelData.manufacturerName), 1)])])]), _: 1 }, 8, ["title", "visible", "before-close"]);
  };
} }, O = D(I, [["__scopeId", "data-v-7d341a5e"]]);
export {
  O as default
};
