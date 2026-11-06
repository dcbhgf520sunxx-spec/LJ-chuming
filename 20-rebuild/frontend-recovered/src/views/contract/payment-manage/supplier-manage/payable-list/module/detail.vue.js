import { ref as d } from "vue";
import { computed as f } from "vue";
import { watch as C } from "vue";
import { resolveComponent as l } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as s } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as I } from "vue";
import { createElementVNode as V } from "vue";
import { unref as o } from "vue";
import { resolveDynamicComponent as O } from "vue";
import { isRef as U } from "vue";
import { ElTag as B } from "element-plus";
import { u as M, jK as e, o as k } from "../../../../../../shared/runtime.js";
import E from "./purchase-list.vue.js";
import P from "./subcontract-list.vue.js";
import j from "./material-transport.vue.js";
import $ from "./manuf-transport.vue.js";
import "../../../../../../modules/payable-list-dd7ea2e5.js";
import "./detail-table/purchase-detail.vue.js";
import "./detail-table/subcontract-detail.vue.js";
import "./detail-table/inbound-detail.vue.js";
const L = { class: "filter-item", style: { width: "320px", float: "right" } }, Y = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, type: { type: [String, Number], default: void 0 }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(r, { emit: R }) {
  const h = R, u = r, t = d(void 0), c = d(), { visible: a, handleClose: b } = M({ emit: h, props: u }), g = f(() => {
    switch (t.value) {
      case e.PURCHASE.V:
        return E;
      case e.SUBCONTRACT.V:
        return P;
      case e.MANUF_TRANSPORT.V:
        return $;
      case e.MATERIAL_TRANSPORT.V:
        return j;
      default:
        return null;
    }
  }), A = f(() => {
    switch (t.value) {
      case e.PURCHASE.V:
        return "paymentPurchaseOrderRecord";
      case e.SUBCONTRACT.V:
        return "paymentSubcontractRecord";
      case e.MANUF_TRANSPORT.V:
        return "paymentManufShippingRecord";
      case e.MATERIAL_TRANSPORT.V:
        return "paymentMaterialShippingRecord";
      default:
        return null;
    }
  });
  C(a, (p) => {
    p && (t.value = u.type || e.PURCHASE.V);
  }, { immediate: true, deep: true });
  const { maxHeight: T } = k({ mainBox: ".logistics-record-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, c);
  return (p, i) => {
    const v = B, x = l("common-radio-button"), S = l("print-table"), w = l("common-drawer");
    return _(), y(w, { ref_key: "dialogRef", ref: c, title: "关联合同/记录", "close-on-click-modal": false, modelValue: o(a), "onUpdate:modelValue": i[1] || (i[1] = (n) => U(a) ? a.value = n : null), direction: "rtl", "before-close": o(b), "custom-class": "invoice-record", size: "95%" }, { titleAfter: s(() => [m(v, { effect: "plain" }, { default: s(() => [H(I(r.detailInfo.supplierName), 1)]), _: 1 })]), content: s(() => {
      var n;
      return [V("div", null, [m(x, { modelValue: t.value, "onUpdate:modelValue": i[0] || (i[0] = (N) => t.value = N), options: o(e).ENUM, class: "filter-item", showOptionAll: false, type: "enum", style: { "margin-bottom": "10px" } }, null, 8, ["modelValue", "options"]), V("div", L, [m(S, { "api-key": A.value, params: { supplierId: (n = r.detailInfo) == null ? void 0 : n.supplierId }, size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), (_(), y(O(g.value), { key: t.value, detailInfo: r.detailInfo, maxHeight: o(T) - 80, isVisible: o(a) }, null, 8, ["detailInfo", "maxHeight", "isVisible"]))];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Y as default
};
