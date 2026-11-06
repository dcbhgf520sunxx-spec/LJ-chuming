import { ref as b } from "vue";
import { inject as h } from "vue";
import { computed as v } from "vue";
import { watchEffect as y } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { unref as m } from "vue";
import { createElementVNode as V } from "vue";
import { Fragment as k } from "vue";
import { ElFormItem as W } from "element-plus";
import { ElInput as C } from "element-plus";
import { _ as E, bl as d, y3 as O } from "../../../../../../../shared/runtime.js";
import { _ as q } from "../../../../../../../modules/workshop-select-210dd661.js";
const U = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object } }, setup(l) {
  const n = l, e = b({ directionWarehouseId: void 0, directionWorkshopId: void 0, quantity: void 0, remark: void 0 }), r = h("maxQuantity"), c = v(() => {
    var u;
    return [((u = n.material.warehouse) == null ? void 0 : u.id) || n.material.warehouseId];
  });
  y(() => {
    e.value = n.form, n.material.basicClass === d.STEEL_COIL.V && (e.value.quantity = r.value);
  });
  function p() {
    e.value.quantity = r.value;
  }
  return (u, a) => {
    const i = W, f = w("common-input-number"), _ = C;
    return I(), x(k, null, [o(i, { label: "目的仓库", prop: "directionWorkshopId" }, { default: s(() => [o(q, { modelValue: e.value.directionWorkshopId, "onUpdate:modelValue": a[0] || (a[0] = (t) => e.value.directionWorkshopId = t), placeholder: "可选择目的仓库", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), o(i, { label: "目的存储位置", prop: "directionWarehouseId" }, { default: s(() => [o(O, { modelValue: e.value.directionWarehouseId, "onUpdate:modelValue": a[1] || (a[1] = (t) => e.value.directionWarehouseId = t), "basic-class": l.material.basicClass, unshowOptions: c.value, "workshop-id": e.value.directionWorkshopId, clearable: "", placeholder: "可选择目的存储位置", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "unshowOptions", "workshop-id"])]), _: 1 }), o(i, { label: `数量(${l.material.outboundUnit})`, prop: "quantity" }, { default: s(() => [o(f, { modelValue: e.value.quantity, "onUpdate:modelValue": a[2] || (a[2] = (t) => e.value.quantity = t), disabled: l.material.basicClass === m(d).STEEL_COIL.V, max: m(r), min: 0, precision: l.material.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "disabled", "max", "precision"]), V("span", { class: "text-clickable set-max-text", onClick: p }, "全部移库")]), _: 1 }, 8, ["label"]), o(i, { label: "备注", prop: "remark" }, { default: s(() => [o(_, { modelValue: e.value.remark, "onUpdate:modelValue": a[3] || (a[3] = (t) => e.value.remark = t), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, S = E(U, [["__scopeId", "data-v-d6457e5d"]]);
export {
  S as default
};
