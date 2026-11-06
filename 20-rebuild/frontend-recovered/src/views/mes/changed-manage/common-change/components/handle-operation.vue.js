import { ref as _ } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as o } from "vue";
import { unref as h } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as a } from "vue";
import { ElCheckbox as k } from "element-plus";
import { a3 as w } from "../../../../../shared/runtime.js";
const g = { style: { display: "flex", "align-items": "center", "margin-bottom": "10px", "justify-content": "end" } }, L = { __name: "handle-operation", props: { productType: { type: Number } }, emits: ["showEditList", "showAllList", "fill", "reset"], setup(r, { emit: m }) {
  const t = m, n = _(false);
  function p(l) {
    t(l ? "showEditList" : "showAllList");
  }
  function u() {
    t("fill");
  }
  function c() {
    t("reset");
  }
  return (l, e) => {
    const d = k, s = y("common-button");
    return b(), x("div", g, [o(d, { modelValue: n.value, "onUpdate:modelValue": e[0] || (e[0] = (f) => n.value = f), label: `只查看填写处理数量的${h(w).VL[r.productType]}`, onChange: p, style: { "margin-right": "10px" } }, null, 8, ["modelValue", "label"]), o(s, { type: "primary", size: "default", onClick: u }, { default: i(() => e[1] || (e[1] = [a("一键填充")])), _: 1, __: [1] }), o(s, { type: "warning", size: "default", onClick: c }, { default: i(() => e[2] || (e[2] = [a("重置")])), _: 1, __: [2] })]);
  };
} };
export {
  L as default
};
