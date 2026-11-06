import { resolveComponent as V } from "vue";
import { resolveDirective as c } from "vue";
import { openBlock as b } from "vue";
import { createBlock as h } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as d } from "vue";
import { createElementVNode as a } from "vue";
import { unref as n } from "vue";
import { toDisplayString as x } from "vue";
import { isRef as I } from "vue";
import { ElTag as w } from "element-plus";
import { t as D, u as k } from "../../../../../shared/runtime.js";
import z from "./happened-detail/index.vue.js";
import "../../../../../modules/order-tracking-9be524cd.js";
import "../../../../../modules/contract-9b18cc88.js";
import "./happened-detail/module/header.vue.js";
const P = { __name: "happened-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(t, { emit: u }) {
  const { decimalPrecision: m } = D(), f = u, _ = t, { visible: r, handleClose: v } = k({ emit: f, props: _ });
  return (B, e) => {
    const i = w, y = V("common-drawer"), j = c("parse-project"), p = c("empty-text"), g = c("thousand");
    return b(), h(y, { ref: "shipDrawerRef", title: "出库记录", "close-on-click-modal": false, modelValue: n(r), "onUpdate:modelValue": e[0] || (e[0] = (l) => I(r) ? r.value = l : null), direction: "rtl", "before-close": n(v), "custom-class": "sales-happened-record", size: "90%" }, { titleAfter: o(() => [s(i, { type: "success", effect: "plain", size: "large" }, { default: o(() => [d(a("span", null, null, 512), [[j, { project: t.detailInfo.project, onlyShortName: true }], [p]])]), _: 1 }), s(i, { effect: "plain", size: "large" }, { default: o(() => [e[1] || (e[1] = a("span", null, "累计出库额：", -1)), d(a("span", null, null, 512), [[g, { val: t.detailInfo.happenedAmount || 0, dp: n(m).contract }], [p]])]), _: 1, __: [1] }), s(i, { effect: "plain", size: "large" }, { default: o(() => [e[2] || (e[2] = a("span", null, "运输车次/船次：", -1)), a("span", null, x(t.detailInfo.transportQuantity || 0), 1)]), _: 1, __: [2] })]), content: o(() => {
      var l;
      return [s(n(z), { "project-id": (l = t.detailInfo.project) == null ? void 0 : l.id }, null, 8, ["project-id"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  P as default
};
