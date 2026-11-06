import { _ as k, u as A, z as I, j0 as r } from "../../../../../../shared/runtime.js";
import { ref as m } from "vue";
import { inject as d } from "vue";
import { watch as B } from "vue";
import { computed as P } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as N } from "vue";
import { unref as n } from "vue";
import { resolveDynamicComponent as O } from "vue";
import { defineAsyncComponent as l } from "vue";
import { ElTag as z } from "element-plus";
import { ElRadioButton as U } from "element-plus";
import { ElRadioGroup as F } from "element-plus";
const G = { __name: "index", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:visible"], setup(p, { emit: f }) {
  const v = p, y = m(null), b = f, { visible: V, handleClose: x } = A({ emit: b, props: v }), a = m("payment"), { current_key: E } = d("common");
  B(() => E.value, (i) => {
    a.value = i;
  }, { immediate: true });
  const { table_item_data: w } = d("common"), g = { settle: l(() => r(() => import("./settle.vue.js"), ["static/js/settle-b9fa831e.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css"])), payment: l(() => r(() => import("./payment.vue.js"), ["static/js/payment-ec7eb4d0.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-69cea220.js", "static/js/upload-file-download-812f558c.js", "static/js/self-healing-6f411a5c.js"])), invoice: l(() => r(() => import("./invoice.vue.js"), ["static/js/invoice-6cd92fc4.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/index-69cea220.js", "static/js/upload-file-download-812f558c.js", "static/js/self-healing-6f411a5c.js"])) }, C = P(() => g[a.value]);
  return (i, e) => {
    const D = z, _ = U, R = F, T = L("common-drawer");
    return c(), u(T, { ref_key: "drawer_ref", ref: y, "append-to-body": true, "before-close": n(x), visible: n(V), "custom-class": "detail-record", size: "100%", title: "明细记录" }, { titleAfter: t(() => [o(D, null, { default: t(() => [s(N(n(I)(n(w).project)), 1)]), _: 1 })]), content: t(() => [o(R, { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (j) => a.value = j), class: "box-container" }, { default: t(() => [o(_, { value: "settle" }, { default: t(() => e[1] || (e[1] = [s("结算记录")])), _: 1, __: [1] }), o(_, { value: "payment" }, { default: t(() => e[2] || (e[2] = [s("收款记录")])), _: 1, __: [2] }), o(_, { value: "invoice" }, { default: t(() => e[3] || (e[3] = [s("开票记录")])), _: 1, __: [3] })]), _: 1 }, 8, ["modelValue"]), (c(), u(O(C.value), { class: "animate__fadeIn" }))]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, J = k(G, [["__scopeId", "data-v-028808c1"]]);
export {
  J as default
};
