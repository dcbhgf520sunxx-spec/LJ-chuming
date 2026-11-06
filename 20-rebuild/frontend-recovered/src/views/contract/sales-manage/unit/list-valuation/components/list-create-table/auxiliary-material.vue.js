import { resolveComponent as s } from "vue";
import { resolveDirective as d } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as f } from "vue";
import { createElementVNode as _ } from "vue";
import { Fragment as w } from "vue";
import { ElTableColumn as v } from "element-plus";
import { bs as u } from "../../../../../../../shared/runtime.js";
const C = { __name: "auxiliary-material", setup(b) {
  function m(e) {
    e.mete = u(e.originMete / e.originQuantity * e.quantity, 2, { toNum: true }), a(e);
  }
  function p(e) {
    e.quantity = u(e.mete / (e.originMete / e.originQuantity), 2, { toNum: true }), a(e);
  }
  function a(e) {
    e.totalPrice = u(e.mete * e.unitPrice, 2, { toNum: true });
  }
  return (e, V) => {
    const n = v, r = s("common-input-number"), c = d("thousand");
    return h(), g(w, null, [o(n, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), o(n, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), o(n, { "show-overflow-tooltip": "", prop: "measureUnit", label: "计量单位", align: "center" }), o(n, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center", "min-width": "100px" }, { default: i(({ row: { sourceRow: t } }) => [o(r, { modelValue: t.quantity, "onUpdate:modelValue": (l) => t.quantity = l, "controls-position": "right", max: t.originQuantity, min: 1, size: "default", step: 1, placeholder: "数量", onChange: (l) => m(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "100" }), o(n, { "show-overflow-tooltip": "", prop: "mete", label: "核算量", align: "center", "min-width": "100" }, { default: i(({ row: { sourceRow: t } }) => [o(r, { modelValue: t.mete, "onUpdate:modelValue": (l) => t.mete = l, "controls-position": "right", max: t.originMete, min: 1, size: "default", step: 1, placeholder: "核算量", onChange: (l) => p(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), o(n, { prop: "unitPrice", "show-overflow-tooltip": "", label: "单价（元）", align: "center", "min-width": "120" }, { default: i(({ row: { sourceRow: t } }) => [o(r, { modelValue: t.unitPrice, "onUpdate:modelValue": (l) => t.unitPrice = l, step: 1, min: 0, max: 99999999, precision: 2, size: "default", "controls-position": "right", style: { width: "100%" }, onChange: (l) => a(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), o(n, { prop: "totalPrice", "show-overflow-tooltip": "", align: "center", "min-width": "120", label: "金额（元）" }, { default: i(({ row: { sourceRow: t } }) => [f(_("span", null, null, 512), [[c, { val: t.totalPrice || 0 }]])]), _: 1 })], 64);
  };
} };
export {
  C as default
};
