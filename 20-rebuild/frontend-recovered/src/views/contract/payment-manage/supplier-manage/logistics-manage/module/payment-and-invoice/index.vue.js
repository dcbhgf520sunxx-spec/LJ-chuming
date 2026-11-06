import { _, u as R, G as f } from "../../../../../../../shared/runtime.js";
import T from "./payment/index.vue.js";
import x from "./invoice/index.vue.js";
import { ref as N } from "vue";
import { watch as g } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as l } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createElementBlock as C } from "vue";
import { toDisplayString as B } from "vue";
import { createCommentVNode as p } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { ElTabs as E } from "element-plus";
import { ElTabPane as b } from "element-plus";
import { isRef as I } from "vue";
import "../../../../../../../modules/logistics-payment-1a755fb1.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../../modules/UploadBtn-b4cfb47a.js";
import "./invoice/form.vue.js";
const S = { key: 0 }, D = { __name: "index", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, tabName: { type: [String], default: "payment" }, propertyType: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: v }) {
  const s = N("payment"), a = t, c = v, { visible: u, handleClose: V } = R({ emit: c, props: a });
  return g(() => a.tabName, (d) => {
    s.value = d;
  }, { deep: true, immediate: true }), (d, o) => {
    const w = k("common-drawer");
    return l(), i(w, { "append-to-body": "", modelValue: e(u), "onUpdate:modelValue": o[2] || (o[2] = (r) => I(u) ? u.value = r : null), top: "10vh", width: "600px", "before-close": e(V), title: "付款收票", "wrapper-closable": false, size: "100%" }, { titleAfter: n(() => [t.currentRow.supplierName ? (l(), C("span", S, B(`物流公司:${t.currentRow.supplierName}`), 1)) : p("", true)]), content: n(() => [m(e(E), { modelValue: s.value, "onUpdate:modelValue": o[1] || (o[1] = (r) => s.value = r), class: "tab-container" }, { default: n(() => {
      var r, y;
      return [e(f)((r = t.permission.payment) == null ? void 0 : r.get) ? (l(), i(e(b), { key: 0, label: "付款列表", name: "payment" }, { default: n(() => [m(e(T), { class: "tab-content", currentRow: a.currentRow, propertyType: a.propertyType, visibleValue: t.modelValue }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 })) : p("", true), e(f)((y = t.permission.invoice) == null ? void 0 : y.get) ? (l(), i(e(b), { key: 1, label: "收票列表", name: "invoice" }, { default: n(() => [m(e(x), { class: "tab-content", currentRow: a.currentRow, propertyType: a.propertyType, visibleValue: t.modelValue, onSuccess: o[0] || (o[0] = (P) => c("success")) }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 })) : p("", true)];
    }), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, G = _(D, [["__scopeId", "data-v-f25a4f58"]]);
export {
  G as default
};
