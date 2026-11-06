import m from "./header.vue.js";
import i from "./pre-settlement-info.vue.js";
import { _ as u } from "../../../../../../shared/runtime.js";
import { inject as _ } from "vue";
import { reactive as t } from "vue";
import { ref as p } from "vue";
import { provide as d } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as r } from "vue";
import "../../../../../../modules/data-33e35578.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/hook-467b8301.js";
const b = { class: "settlement-container" }, v = { __name: "index", setup(h, { expose: a }) {
  const l = _("size");
  l.value = "50%";
  function n() {
    return { inboundAmountSum: null, paymentAmountSum: null, preSettlementAmount: null, residualPresettlement: null, settlementAmount: null, uPThisPresettlement: null };
  }
  function c() {
    Object.assign(e, n()), Object.assign(o, {});
  }
  const e = t({ createTime: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderId: null, userId: null, boolPreSettlement: true, ...n() }), o = t({}), s = p(null);
  return d("pre_settlement_data", t({ formData: e, resetForm: c, projectInfo: o })), a({ formData: e, headerRef: s }), (I, g) => (f(), x("div", b, [r(m, { ref_key: "headerRef", ref: s, class: "box-container" }, null, 512), r(i, { class: "box-container" })]));
} }, z = u(v, [["__scopeId", "data-v-e9839b04"]]);
export {
  z as default
};
