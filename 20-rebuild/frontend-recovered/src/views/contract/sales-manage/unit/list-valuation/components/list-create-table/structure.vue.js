import { inject as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as t } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as f } from "vue";
import { unref as i } from "vue";
import { Fragment as W } from "vue";
import { ElTableColumn as b } from "element-plus";
import { kO as e, bs as T } from "../../../../../../../shared/runtime.js";
const K = { __name: "structure", setup(v) {
  const l = h("weightType"), r = { [e.NET_WEIGHT.K]: "netWeight", [e.GROSS_WEIGHT.K]: "grossWeight", [e.DRAW_WEIGHT.K]: "drawingWeight" }, p = { [e.NET_WEIGHT.K]: "totalNetWeight", [e.GROSS_WEIGHT.K]: "totalGrossWeight", [e.DRAW_WEIGHT.K]: "drawingTotalWeight" };
  function c(a) {
    a[p[e.V[l.value].K]] = T(a.quantity * a[r[e.V[l.value].K]], 2, { toNum: true });
  }
  return (a, x) => {
    const o = b, u = g("common-input-number");
    return d(), w(W, null, [t(o, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), t(o, { "show-overflow-tooltip": "", prop: "serialNumber", label: "编号", align: "center", "min-width": "100px" }), t(o, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), t(o, { "show-overflow-tooltip": "", prop: "length", label: "长度(mm)", align: "center", "min-width": "100px" }), t(o, { "show-overflow-tooltip": "", prop: "material", label: "材质", align: "center", "min-width": "100px" }), t(o, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center", "min-width": "100px" }, { default: m(({ row: { sourceRow: n } }) => [t(u, { modelValue: n.quantity, "onUpdate:modelValue": (s) => n.quantity = s, "controls-position": "right", max: n.originQuantity, min: 1, size: "default", step: 1, placeholder: "数量", onChange: (s) => c(n) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), t(o, { "show-overflow-tooltip": "", prop: "netWeight", label: "单重(kg)", align: "center", "min-width": "110" }, { default: m(({ row: { sourceRow: n } }) => [_("span", null, f(n[r[i(e).V[i(l)].K]]), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": "", prop: p[i(e).V[i(l)].K], label: "总重(kg)", align: "center", "min-width": "110" }, null, 8, ["prop"])], 64);
  };
} };
export {
  K as default
};
