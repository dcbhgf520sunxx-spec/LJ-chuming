import { _ as m, u as d } from "../../../../../../../shared/runtime.js";
import y from "./list.vue.js";
import { resolveComponent as _ } from "vue";
import { openBlock as a } from "vue";
import { createBlock as f } from "vue";
import { withCtx as p } from "vue";
import { createElementBlock as b } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as V } from "vue";
import { createVNode as v } from "vue";
import { unref as s } from "vue";
import { isRef as x } from "vue";
import "../../../../../../../modules/logistics-payment-1a755fb1.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "./detail.vue.js";
import "../../../../../../../modules/pay-9ccccafb.js";
const R = { key: 0 }, C = { __name: "index", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success", "update:modelValue"], setup(e, { emit: u }) {
  const o = e, n = u, { visible: r, handleClose: c } = d({ emit: n, props: o });
  return (N, t) => {
    const i = _("common-drawer");
    return a(), f(i, { "append-to-body": "", modelValue: s(r), "onUpdate:modelValue": t[1] || (t[1] = (l) => x(r) ? r.value = l : null), top: "10vh", width: "600px", "before-close": s(c), title: "审核记录", "wrapper-closable": false, size: "80%" }, { titleAfter: p(() => [e.currentRow.supplierName ? (a(), b("span", R, w(`物流公司:${e.currentRow.supplierName}`), 1)) : V("", true)]), content: p(() => [v(s(y), { currentRow: o.currentRow, propertyType: o.propertyType, visibleValue: e.modelValue, onSuccess: t[0] || (t[0] = (l) => n("success")) }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, D = m(C, [["__scopeId", "data-v-e8728cc5"]]);
export {
  D as default
};
