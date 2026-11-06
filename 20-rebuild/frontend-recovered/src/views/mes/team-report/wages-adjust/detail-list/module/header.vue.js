import { computed as f } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as g } from "vue";
import { vShow as h } from "vue";
import { unref as t } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as o } from "vue";
import { withCtx as v } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as V } from "vue";
import { withKeys as b } from "vue";
import { renderSlot as w } from "vue";
import { ElTag as B } from "element-plus";
import { ElInput as E } from "element-plus";
import { kA as N, B as T, C as k } from "../../../../../../shared/runtime.js";
const S = { style: { display: "flex", "justify-content": "space-between" } }, C = { __name: "header", props: { fInfo: { type: Object, default: () => {
} } }, setup(u) {
  const c = u, d = {}, p = f(() => {
    const { name: s, steelSpec: e, material: a, category: l } = c.fInfo || {};
    return l ? N.VL[l] : s ? s + `${e ? "-" + e : ""}${a ? "-" + a : ""}` : "未选择";
  }), { crud: r, query: n } = T(d);
  return (s, e) => {
    const a = B, l = E;
    return y(), _("div", S, [g(i("div", null, [o(a, { class: "filter-item", size: "large" }, { default: v(() => [x(V(p.value), 1)]), _: 1 }), o(l, { modelValue: t(n).serialNumber, "onUpdate:modelValue": e[0] || (e[0] = (m) => t(n).serialNumber = m), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: b(t(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(t(k))], 512), [[h, t(r).searchToggle]]), i("div", null, [w(s.$slots, "auditBox")])]);
  };
} };
export {
  C as default
};
