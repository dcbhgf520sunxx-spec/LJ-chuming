import { resolveDirective as c } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as l } from "vue";
import { vShow as f } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as t } from "vue";
import { withKeys as v } from "vue";
import { withCtx as n } from "vue";
import { createBlock as w } from "vue";
import { createTextVNode as y } from "vue";
import { ElInput as g } from "element-plus";
import { d as h } from "../../../../modules/role-8519830b.js";
import { B as V, C as x, L as B, E as b } from "../../../../shared/runtime.js";
const C = { __name: "header", setup(k) {
  const i = { name: void 0 }, { crud: a, query: o } = V(i);
  return (E, s) => {
    const d = g, u = c("permission");
    return r(), p("div", null, [l(_("div", null, [t(d, { modelValue: e(o).name, "onUpdate:modelValue": s[0] || (s[0] = (m) => e(o).name = m), placeholder: "按角色名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: v(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(x))], 512), [[f, e(a).searchToggle]]), t(e(b), null, { viewLeft: n(() => [l((r(), w(B, { fn: e(h), class: "filter-item", disabled: e(a).data.length === 0 }, { default: n(() => s[1] || (s[1] = [y(" 人员设置清单 ")])), _: 1, __: [1] }, 8, ["fn", "disabled"])), [[u, e(a).permission.get]])]), _: 1 })]);
  };
} };
export {
  C as default
};
