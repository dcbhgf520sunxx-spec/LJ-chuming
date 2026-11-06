import { ref as c } from "vue";
import { watchEffect as p } from "vue";
import { inject as f } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as n } from "vue";
import { withCtx as l } from "vue";
import { unref as v } from "vue";
import { createElementVNode as b } from "vue";
import { Fragment as I } from "vue";
import { ElFormItem as k } from "element-plus";
import { ElInput as w } from "element-plus";
import { _ as V } from "../../../../../shared/runtime.js";
const h = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object } }, setup(o) {
  const i = o, e = c({ projectId: void 0, monomerId: void 0, areaId: void 0, workshopId: void 0, recipientId: void 0, quantity: void 0, remark: void 0 });
  p(() => {
    e.value = i.form;
  });
  const m = f("maxQuantity");
  function u() {
    e.value.quantity = m.value;
  }
  return (q, t) => {
    const s = _("common-input-number"), r = k, d = w;
    return x(), y(I, null, [n(r, { label: `数量(${o.material.outboundUnit})`, prop: "quantity" }, { default: l(() => [n(s, { modelValue: e.value.quantity, "onUpdate:modelValue": t[0] || (t[0] = (a) => e.value.quantity = a), max: v(m), min: 0, precision: o.material.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"]), b("span", { class: "text-clickable set-max-text", onClick: u }, "全部冻结")]), _: 1 }, 8, ["label"]), n(r, { label: "备注", prop: "remark" }, { default: l(() => [n(d, { modelValue: e.value.remark, "onUpdate:modelValue": t[1] || (t[1] = (a) => e.value.remark = a), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, j = V(h, [["__scopeId", "data-v-c4f33e2e"]]);
export {
  j as default
};
