import { lf as l, G as u, lg as m, lh as d, li as f, lj as h } from "../shared/runtime.js";
import { resolveComponent as _ } from "vue";
import { unref as e } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as y } from "vue";
import { mergeProps as D } from "vue";
import { createCommentVNode as N } from "vue";
const O = { key: 0, class: "purchase-detail-button" }, I = { __name: "index", props: { purchaseId: { type: Number }, btnName: { type: String, default: "采购合同详情" } }, setup(a) {
  const r = a, { detailRef: n, openDetail: c } = l();
  return (p, s) => {
    const i = _("common-button");
    return e(u)(e(m)) && a.purchaseId ? (C(), b("span", O, [t(i, D(p.$attrs, { onClick: s[0] || (s[0] = (g) => e(c)(r.purchaseId)), type: "info" }), { default: o(() => [k(y(r.btnName), 1)]), _: 1 }, 16), t(h, { ref_key: "purchaseOrderRef", ref: n, api: e(f) }, { default: o(() => [t(d)]), _: 1 }, 8, ["api"])])) : N("", true);
  };
} };
export {
  I as _
};
