import { ref as b } from "vue";
import { watch as x } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as g } from "vue";
import { createBlock as B } from "vue";
import { withCtx as o } from "vue";
import { renderSlot as l } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as r } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as p } from "vue";
import { ElPopover as C } from "element-plus";
const T = { style: { "text-align": "right", "margin-top": "10px" } }, w = { __name: "popover-confirm", props: { confirmButtonText: { type: String, default: "确认" }, cancelButtonText: { type: String, default: "取消" } }, emits: ["confirm", "cancel", "visible"], setup(f, { emit: m }) {
  const n = m, a = f, e = b(false);
  x(e, (t) => {
    t && n("visible");
  });
  function u() {
    e.value = false, n("confirm");
  }
  function d() {
    e.value = false, n("cancel");
  }
  return (t, s) => {
    const i = y("common-button"), v = C;
    return g(), B(v, { placement: "top-start", width: "450", visible: e.value, "onUpdate:visible": s[0] || (s[0] = (_) => e.value = _) }, { reference: o(() => [l(t.$slots, "reference")]), default: o(() => [l(t.$slots, "default"), k("div", T, [r(i, { size: "default", link: "", type: "primary", onClick: d }, { default: o(() => [c(p(a.cancelButtonText), 1)]), _: 1 }), r(i, { size: "default", type: "primary", onClick: u }, { default: o(() => [c(p(a.confirmButtonText), 1)]), _: 1 })])]), _: 3 }, 8, ["visible"]);
  };
} };
export {
  w as _
};
