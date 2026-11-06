import { j as y } from "../../../../../modules/roster-manage-12e649bc.js";
import { u as C } from "../../../../../shared/runtime.js";
import { ref as V } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as h } from "vue";
import { createBlock as N } from "vue";
import { withCtx as j } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as m } from "vue";
import q from "qrcode.vue";
import { unref as s } from "vue";
import { isRef as w } from "vue";
import { _ as B } from "../../../../../modules/index-c549a8fd.js";
import "../../../../../modules/html2canvas.esm-e0a7d97b.js";
const I = { class: "flex-ccc pointer", style: { "margin-top": "20px" } }, Q = { style: { display: "flex", "justify-content": "flex-end" } }, R = { __name: "qr-code-dlg", props: { visible: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["update:visible"], setup(p, { emit: u }) {
  const f = u, i = p, { visible: t, handleClose: v } = C({ emit: f, props: i, field: "visible", showHook: _ }), e = V({});
  function _() {
    b();
  }
  async function b() {
    const n = await y({ id: i.data.id });
    e.value = n;
  }
  return (n, o) => {
    const x = g("common-dialog");
    return h(), N(x, { title: "二维码预览", modelValue: s(t), "onUpdate:modelValue": o[0] || (o[0] = (a) => w(t) ? t.value = a : null), width: "540px", "before-close": s(v) }, { default: j(() => {
      var a, r, d, c;
      return [o[1] || (o[1] = l("div", { class: "flex-ccc" }, null, -1)), l("div", I, [m(q, { value: e.value.qrCode, size: 200 }, null, 8, ["value"])]), l("div", Q, [m(s(B), { exportInfo: { data: { inspectionName: (r = (a = e.value) == null ? void 0 : a.header) == null ? void 0 : r.inspectionName, qrCode: e.value.qrCode, projectName: (c = (d = e.value) == null ? void 0 : d.header) == null ? void 0 : c.projectName }, fnFormat: "花名册人员信息" }, labelType: "personal" }, null, 8, ["exportInfo"])])];
    }), _: 1, __: [1] }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  R as default
};
