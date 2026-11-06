import { _ as m, u as d } from "../../../../../../../shared/runtime.js";
import b from "./list.vue.js";
import { resolveComponent as y } from "vue";
import { openBlock as a } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as p } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as V } from "vue";
import { createVNode as v } from "vue";
import { unref as s } from "vue";
import { isRef as x } from "vue";
import "../../../../../../../modules/pay-9ccccafb.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "./detail.vue.js";
import "../../../../../../../modules/collection-9275714a.js";
const R = { key: 0 }, C = { __name: "index", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, propertyType: { type: [Number, String], default: void 0 } }, emits: ["success", "update:modelValue"], setup(e, { emit: u }) {
  const o = e, n = u, { visible: r, handleClose: i } = d({ emit: n, props: o });
  return (N, t) => {
    const c = y("common-drawer");
    return a(), _(c, { "append-to-body": "", modelValue: s(r), "onUpdate:modelValue": t[1] || (t[1] = (l) => x(r) ? r.value = l : null), top: "10vh", width: "600px", "before-close": s(i), title: "审核记录", "wrapper-closable": false, size: "90%" }, { titleAfter: p(() => [e.currentRow.serialNumber ? (a(), f("span", R, w(`采购合同编号:${e.currentRow.serialNumber}`), 1)) : V("", true)]), content: p(() => [v(s(b), { currentRow: o.currentRow, propertyType: o.propertyType, visibleValue: e.modelValue, onSuccess: t[0] || (t[0] = (l) => n("success")) }, null, 8, ["currentRow", "propertyType", "visibleValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, D = m(C, [["__scopeId", "data-v-b871b181"]]);
export {
  D as default
};
