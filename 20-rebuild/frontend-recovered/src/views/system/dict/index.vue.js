import { ref as c } from "vue";
import { reactive as C } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as a } from "vue";
import { withCtx as e } from "vue";
import { unref as t } from "vue";
import { createElementVNode as h } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as v } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElCol as E } from "element-plus";
import { ElTag as R } from "element-plus";
import { ElCard as B } from "element-plus";
import { ElRow as D } from "element-plus";
import { G as N } from "../../../shared/runtime.js";
import V from "./dict/index.vue.js";
import w from "./dict-detail/index.vue.js";
import "./dict/module/header.vue.js";
import "./dict-detail/module/header.vue.js";
import "./dict-detail/module/form.vue.js";
const j = { class: "app-container" }, $ = { __name: "index", setup(z) {
  const p = c(), n = c();
  let o = C({});
  function f(s) {
    s && (o = Object.assign(o, s));
  }
  return (s, r) => {
    const i = E, u = R, g = y("common-button"), x = B, k = D;
    return l(), b("div", j, [a(k, { gutter: 10 }, { default: e(() => [a(i, { xs: 24, sm: 24, md: 24, lg: 10, xl: 10, style: { "margin-bottom": "10px" } }, { default: e(() => [a(t(V), { onClickLine: f, ref_key: "dicRef", ref: p }, null, 512)]), _: 1 }), a(i, { xs: 24, sm: 24, md: 24, lg: 14, xl: 14 }, { default: e(() => [a(x, { class: "box-card team-card" }, { header: e(() => [r[1] || (r[1] = h("span", { style: { "margin-right": "5px" } }, "详情", -1)), t(o).remark ? (l(), m(u, { key: 0, size: "large" }, { default: e(() => [d(v(t(o).remark), 1)]), _: 1 })) : _("", true), t(o).name && n.value && t(N)(n.value.permission.add) ? (l(), m(g, { key: 1, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-plus", onClick: n.value.toAdd }, { default: e(() => r[0] || (r[0] = [d(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])) : _("", true)]), default: e(() => [a(t(w), { ref_key: "dictDetailRef", ref: n, line: t(o) }, null, 8, ["line"])]), _: 1 })]), _: 1 })]), _: 1 })]);
  };
} };
export {
  $ as default
};
