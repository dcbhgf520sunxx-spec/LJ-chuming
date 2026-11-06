import { _ as b, u as f } from "../../../../../../../shared/runtime.js";
import v from "./payment/index.vue.js";
import V from "./invoice/index.vue.js";
import { ref as w } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as T } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as g } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { ElTabs as B } from "element-plus";
import { ElTabPane as m } from "element-plus";
import { isRef as C } from "vue";
import "../../../../../../../modules/pay-9ccccafb.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../../modules/invoice-bc8acad8.js";
import "../../../../../../../modules/UploadBtn-b4cfb47a.js";
import "./invoice/form.vue.js";
const I = { __name: "index", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, tabName: { type: [String], default: "payment" }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success", "update:modelValue"], setup(l, { emit: c }) {
  const s = w("payment"), t = l, u = c, { visible: p, handleClose: d } = f({ emit: u, props: t });
  return _(() => t.tabName, (i) => {
    s.value = i;
  }, { deep: true, immediate: true }), (i, a) => {
    const y = R("common-drawer");
    return T(), x(y, { "append-to-body": "", modelValue: e(p), "onUpdate:modelValue": a[2] || (a[2] = (n) => C(p) ? p.value = n : null), top: "10vh", width: "600px", "before-close": e(d), title: "付款收票", "wrapper-closable": false, size: "100%" }, { titleAfter: o(() => [N("span", null, "采购合同编号:" + g(l.currentRow.serialNumber), 1)]), content: o(() => [r(e(B), { modelValue: s.value, "onUpdate:modelValue": a[1] || (a[1] = (n) => s.value = n), class: "tab-container" }, { default: o(() => [r(e(m), { label: "付款列表", name: "payment" }, { default: o(() => [r(e(v), { class: "tab-content", currentRow: t.currentRow, propertyType: t.propertyType, visibleValue: l.modelValue }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 }), r(e(m), { label: "收票列表", name: "invoice" }, { default: o(() => [r(e(V), { class: "tab-content", currentRow: t.currentRow, propertyType: t.propertyType, visibleValue: l.modelValue, onSuccess: a[0] || (a[0] = (n) => u("success")) }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, z = b(I, [["__scopeId", "data-v-d4466b89"]]);
export {
  z as default
};
