import { computed as y } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as V } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as w } from "vue";
import { renderSlot as C } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as D } from "vue";
import I from "qrcode.vue";
import { normalizeStyle as L } from "vue";
import { unref as i } from "vue";
import { isRef as z } from "vue";
import { u as A, a3 as B } from "../../../../shared/runtime.js";
import { a as H } from "../../../../modules/index-90569c81.js";
import "../../../../modules/constant_2-1ad5d80f.js";
import "../../../../modules/label-logo-8a01bd73.js";
import "../../../../modules/index-f09320a8.js";
const x = { style: { position: "relative" } }, M = ["innerHTML"], j = { __name: "label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => {
} }, productType: { type: Number }, labelType: { type: Number } }, emits: ["update:visible"], setup(a, { emit: g }) {
  const h = g, t = a, o = y(() => t.labelData.component || {}), e = y(() => H({ productType: t.productType, labelType: t.labelType, labelData: t.labelData })), { visible: s, handleClose: _ } = A({ emit: h, props: t, field: "visible" });
  return (q, n) => {
    const N = P("common-dialog");
    return V(), $(N, { visible: i(s), "onUpdate:visible": n[0] || (n[0] = (l) => z(s) ? s.value = l : null), "before-close": i(_), title: `${a.productType === i(B).AUXILIARY_MATERIAL.V ? o.value.name : o.value.name ? o.value.name + "-" + o.value.serialNumber : o.value.serialNumber}`, width: "640px" }, { default: w(() => {
      var l, r, u, p, m, b, c, d, v, f;
      return [C(q.$slots, "oneCode"), T("div", x, [T("span", { innerHTML: e.value.showHtml }, null, 8, M), D(I, { margin: 2, size: (r = (l = e.value) == null ? void 0 : l.qrPosition) == null ? void 0 : r.size, style: L(`position: absolute;
        right: ${(p = (u = e.value) == null ? void 0 : u.qrPosition) == null ? void 0 : p.right};
        left: ${(b = (m = e.value) == null ? void 0 : m.qrPosition) == null ? void 0 : b.left};
        top: ${(d = (c = e.value) == null ? void 0 : c.qrPosition) == null ? void 0 : d.top};
        bottom: ${(f = (v = e.value) == null ? void 0 : v.qrPosition) == null ? void 0 : f.bottom};`), value: a.labelData.qrCode }, null, 8, ["size", "style", "value"])])];
    }), _: 3 }, 8, ["visible", "before-close", "title"]);
  };
} };
export {
  j as default
};
