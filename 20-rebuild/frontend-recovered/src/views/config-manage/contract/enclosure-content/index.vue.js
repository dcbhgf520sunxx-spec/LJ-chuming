import { ref as r } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { unref as t } from "vue";
import { createElementVNode as E } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as v } from "vue";
import { vShow as g } from "vue";
import { ElCol as O } from "element-plus";
import { ElTag as b } from "element-plus";
import { ElCard as V } from "element-plus";
import { ElRow as h } from "element-plus";
import { dn as l, G as A, i as P } from "../../../../shared/runtime.js";
import w from "./dict/index.vue.js";
import B from "./truss-detail/index.vue.js";
import D from "./dict-detail/index.vue.js";
import "./dict/module/header.vue.js";
import "../../../../modules/base-6bc46ddf.js";
import "./dict/module/form.vue.js";
import "./dict-detail/module/header.vue.js";
import "./dict-detail/module/form.vue.js";
const F = { class: "app-container" }, M = { __name: "index", setup(N) {
  const y = r(), k = r(), n = r(), e = r({});
  function R(c) {
    P(c) ? e.value = Object.assign(e.value, c) : e.value = {};
  }
  return (c, s) => {
    const p = O, d = b, x = S("common-button"), T = V, L = h;
    return i(), C("div", F, [o(L, { gutter: 10 }, { default: a(() => [o(p, { xs: 24, sm: 24, md: 24, lg: 10, xl: 10, style: { "margin-bottom": "10px" } }, { default: a(() => [o(t(w), { onClickLine: R, ref_key: "dicRef", ref: y }, null, 512)]), _: 1 }), o(p, { xs: 24, sm: 24, md: 24, lg: 14, xl: 14 }, { default: a(() => [o(T, { class: "box-card team-card" }, { header: a(() => [s[1] || (s[1] = E("span", { style: { "margin-right": "5px" } }, "详情", -1)), e.value.type != t(l).TRUSS_FLOOR_PLATE.V && e.value.remark ? (i(), m(d, { key: 0, size: "large" }, { default: a(() => [_(f(e.value.remark), 1)]), _: 1 })) : u("", true), e.value.type === t(l).TRUSS_FLOOR_PLATE.V && e.value.code ? (i(), m(d, { key: 1, size: "large" }, { default: a(() => [_(f(e.value.code), 1)]), _: 1 })) : u("", true), e.value.type != t(l).TRUSS_FLOOR_PLATE.V && e.value.name && n.value && t(A)(n.value.permission.add) ? (i(), m(x, { key: 2, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-plus", onClick: n.value.toAdd }, { default: a(() => s[0] || (s[0] = [_(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])) : u("", true)]), default: a(() => [v(o(t(B), { ref_key: "trussRef", ref: k, line: e.value }, null, 8, ["line"]), [[g, e.value.type === t(l).TRUSS_FLOOR_PLATE.V]]), v(o(t(D), { ref_key: "dictDetailRef", ref: n, line: e.value }, null, 8, ["line"]), [[g, e.value.type != t(l).TRUSS_FLOOR_PLATE.V]])]), _: 1 })]), _: 1 })]), _: 1 })]);
  };
} };
export {
  M as default
};
