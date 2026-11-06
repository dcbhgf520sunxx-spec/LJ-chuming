import { _ as b, o as h } from "../../../../../../shared/runtime.js";
import y from "./common-header.vue.js";
import w from "./common-footer.vue.js";
import v from "./confirm-dialog.vue.js";
import { ref as i } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as r } from "vue";
import { createElementVNode as _ } from "vue";
import { renderSlot as V } from "vue";
import { normalizeStyle as C } from "vue";
import { unref as S } from "vue";
import "../../../../../../modules/index-e817c507.js";
import "../../components/project-set-columns.vue.js";
import "../../components/warehouse-set-columns.vue.js";
const N = { class: "main-content" }, T = { __name: "common-wrapper", props: { basicClass: { type: Number }, currentBasicClass: { type: Number }, validate: { type: Function }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, contractUnit: { type: String, default: "" }, contractValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "下一步" }, inboundUnit: { type: String, default: "" }, inboundValue: { type: [Number, String], default: 0 }, showInboundTotal: { type: Boolean, default: false }, showContractTotal: { type: Boolean, default: false }, showTotal: { type: Boolean, default: true }, showTotalAmount: { type: Boolean, default: true }, isManuf: { type: Boolean, default: false }, totalAmount: { type: [Number, String], default: 0 }, edit: { type: Boolean, default: false } }, emits: ["purchase-order-change", "submit"], setup(e, { emit: u }) {
  const c = u, t = e, s = i(), n = i(false);
  let l = {};
  t.edit ? l = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false } : l = { extraBox: null, wrapperBox: null };
  const { heightStyle: d } = h(l);
  async function m() {
    const o = await s.value.validate();
    let a = true;
    typeof t.validate == "function" && (a = await t.validate()), o && a && (n.value = true);
  }
  function f(o, a) {
    c("purchase-order-change", o, a);
  }
  return (o, a) => (g(), B("div", { class: "inbound-application-container", style: C(S(d)) }, [r(y, { "basic-class": t.basicClass, "current-basic-class": t.currentBasicClass ?? t.basicClass, isManuf: e.isManuf, edit: t.edit, validate: e.validate, class: "header", ref_key: "headerRef", ref: s, onPurchaseOrderChange: f }, null, 8, ["basic-class", "current-basic-class", "isManuf", "edit", "validate"]), _("div", N, [V(o.$slots, "default", {}, void 0, true)]), r(w, { class: "footer", unit: t.unit, "total-name": t.totalName, "total-value": t.totalValue, showContractTotal: e.showContractTotal, "contract-value": t.contractValue, "contract-unit": t.contractUnit, showInboundTotal: e.showInboundTotal, "inbound-value": t.inboundValue, "inbound-unit": t.inboundUnit, "show-total": t.showTotal, "show-total-amount": t.showTotalAmount, "total-amount": t.totalAmount, "btn-name": t.btnName, onSubmit: m }, null, 8, ["unit", "total-name", "total-value", "showContractTotal", "contract-value", "contract-unit", "showInboundTotal", "inbound-value", "inbound-unit", "show-total", "show-total-amount", "total-amount", "btn-name"]), r(v, { modelValue: n.value, "onUpdate:modelValue": a[0] || (a[0] = (p) => n.value = p), "basic-class": t.basicClass }, null, 8, ["modelValue", "basic-class"])], 4));
} }, F = b(T, [["__scopeId", "data-v-29cff770"]]);
export {
  F as default
};
