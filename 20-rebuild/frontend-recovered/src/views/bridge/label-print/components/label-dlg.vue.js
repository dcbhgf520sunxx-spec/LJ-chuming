import { computed as f } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as w } from "vue";
import { createBlock as C } from "vue";
import { withCtx as D } from "vue";
import { renderSlot as N } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as V } from "vue";
import z from "qrcode.vue";
import { normalizeStyle as B } from "vue";
import { unref as g } from "vue";
import { isRef as H } from "vue";
import { a as x } from "../../../../modules/index-3b2e6e51.js";
import { u as L } from "../../../../shared/runtime.js";
import "../../../../modules/label-logo-8a01bd73.js";
const k = { style: { position: "relative" } }, I = ["innerHTML"], O = { __name: "label-dlg", props: { visible: { type: Boolean, default: false }, labelData: { type: Object, default: () => {
} }, productType: { type: Number }, labelType: { type: Number } }, emits: ["update:visible"], setup(a, { emit: h }) {
  const _ = h, t = a, s = f(() => t.labelData.component || {}), e = f(() => x({ productType: t.productType, labelType: t.labelType, labelData: t.labelData })), { visible: l, handleClose: T } = L({ emit: _, props: t, field: "visible" });
  return ($, i) => {
    const q = P("common-dialog");
    return w(), C(q, { title: `${s.value.name}-${s.value.serialNumber}`, visible: g(l), "onUpdate:visible": i[0] || (i[0] = (o) => H(l) ? l.value = o : null), width: "640px", top: "4vh", "before-close": g(T) }, { default: D(() => {
      var o, n, r, p, u, m, b, d, c, v;
      return [N($.$slots, "oneCode"), y("div", k, [y("span", { innerHTML: e.value.showHtml }, null, 8, I), V(z, { value: a.labelData.qrCode, size: (n = (o = e.value) == null ? void 0 : o.qrPosition) == null ? void 0 : n.size, margin: 2, style: B(`position: absolute;
        right: ${(p = (r = e.value) == null ? void 0 : r.qrPosition) == null ? void 0 : p.right};
        left: ${(m = (u = e.value) == null ? void 0 : u.qrPosition) == null ? void 0 : m.left};
        top: ${(d = (b = e.value) == null ? void 0 : b.qrPosition) == null ? void 0 : d.top};
        bottom: ${(v = (c = e.value) == null ? void 0 : c.qrPosition) == null ? void 0 : v.bottom};`) }, null, 8, ["value", "size", "style"])])];
    }), _: 3 }, 8, ["title", "visible", "before-close"]);
  };
} };
export {
  O as default
};
