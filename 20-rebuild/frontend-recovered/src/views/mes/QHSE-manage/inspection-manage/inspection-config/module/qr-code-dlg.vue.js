import { l as y } from "../../../../../../modules/inspection-config-a69d9e2f.js";
import { u as g } from "../../../../../../shared/runtime.js";
import { ref as C } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as N } from "vue";
import { createBlock as q } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as p } from "vue";
import { createVNode as m } from "vue";
import I from "qrcode.vue";
import { unref as s } from "vue";
import { isRef as B } from "vue";
import { _ as Q } from "../../../../../../modules/index-c549a8fd.js";
import "../../../../../../modules/html2canvas.esm-e0a7d97b.js";
const j = { class: "flex-ccc" }, k = { style: { "font-weight": "600" } }, z = { style: { "margin-top": "20px" } }, D = { class: "flex-ccc pointer", style: { "margin-top": "20px" } }, F = { style: { display: "flex", "justify-content": "flex-end" } }, U = { __name: "qr-code-dlg", props: { visible: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["update:visible"], setup(u, { emit: f }) {
  const _ = f, l = u, { visible: a, handleClose: v } = g({ emit: _, props: l, field: "visible", showHook: h }), e = C({});
  function h() {
    x();
  }
  async function x() {
    const i = await y({ id: l.data.id });
    e.value = i, console.log(e.value, " qrcodeInfo.value");
  }
  return (i, n) => {
    const b = V("common-dialog");
    return N(), q(b, { title: "二维码预览", modelValue: s(a), "onUpdate:modelValue": n[0] || (n[0] = (t) => B(a) ? a.value = t : null), width: "540px", "before-close": s(v) }, { default: w(() => {
      var t, c, d, r;
      return [o("div", j, [o("span", k, p((t = e.value.header) == null ? void 0 : t.projectName), 1), o("span", z, " 巡检点：" + p((c = e.value.header) == null ? void 0 : c.inspectionName), 1)]), o("div", D, [m(I, { value: e.value.qrCode, size: 200 }, null, 8, ["value"])]), o("div", F, [m(s(Q), { exportInfo: { data: { inspectionName: (r = (d = e.value) == null ? void 0 : d.header) == null ? void 0 : r.inspectionName, qrCode: e.value.qrCode }, fnFormat: "{inspectionName}" }, labelType: "inspection" }, null, 8, ["exportInfo"])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  U as default
};
