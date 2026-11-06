import { _, u as R, G as y } from "../../../../../../../shared/runtime.js";
import T from "./payment/index.vue.js";
import x from "./invoice/index.vue.js";
import { ref as N } from "vue";
import { watch as g } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as B } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { ElTabs as I } from "element-plus";
import { ElTabPane as b } from "element-plus";
import { createCommentVNode as f } from "vue";
import { isRef as S } from "vue";
import "../../../../../../../modules/pay-9ccccafb.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../../modules/invoice-bc8acad8.js";
import "../../../../../../../modules/UploadBtn-b4cfb47a.js";
import "./invoice/form.vue.js";
const D = { __name: "index", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, tabName: { type: [String], default: "payment" }, propertyType: { type: [Number, String], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: v }) {
  const n = N("payment"), a = t, m = v, { visible: s, handleClose: V } = R({ emit: m, props: a });
  return g(() => a.tabName, (c) => {
    n.value = c;
  }, { deep: true, immediate: true }), (c, o) => {
    const w = k("common-drawer");
    return i(), u(w, { "append-to-body": "", modelValue: e(s), "onUpdate:modelValue": o[2] || (o[2] = (r) => S(s) ? s.value = r : null), top: "10vh", width: "600px", "before-close": e(V), title: "付款收票", "wrapper-closable": false, size: "100%" }, { titleAfter: l(() => [C("span", null, "采购合同编号:" + B(t.currentRow.serialNumber), 1)]), content: l(() => [p(e(I), { modelValue: n.value, "onUpdate:modelValue": o[1] || (o[1] = (r) => n.value = r), class: "tab-container" }, { default: l(() => {
      var r, d;
      return [e(y)((r = t.permission.payment) == null ? void 0 : r.get) ? (i(), u(e(b), { key: 0, label: "付款列表", name: "payment" }, { default: l(() => [p(e(T), { class: "tab-content", currentRow: a.currentRow, propertyType: a.propertyType, visibleValue: t.modelValue }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 })) : f("", true), e(y)((d = t.permission.invoice) == null ? void 0 : d.get) ? (i(), u(e(b), { key: 1, label: "收票列表", name: "invoice" }, { default: l(() => [p(e(x), { class: "tab-content", currentRow: a.currentRow, propertyType: a.propertyType, visibleValue: t.modelValue, onSuccess: o[0] || (o[0] = (E) => m("success")) }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 })) : f("", true)];
    }), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, $ = _(D, [["__scopeId", "data-v-d3ee0b3b"]]);
export {
  $ as default
};
