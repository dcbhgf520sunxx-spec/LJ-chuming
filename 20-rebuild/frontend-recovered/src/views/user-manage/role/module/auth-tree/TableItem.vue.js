import u from "./TableCheckBox.vue.js";
import { _ as O } from "../../../../../shared/runtime.js";
import { computed as k } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as o } from "vue";
import { createElementVNode as m } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as h } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as f } from "vue";
import { unref as p } from "vue";
import { Fragment as v } from "vue";
import { renderList as b } from "vue";
import { createVNode as B } from "vue";
import { createCommentVNode as I } from "vue";
const N = { class: "tree-item" }, V = { class: "tree-item-left" }, j = { key: 0, class: "tree-item-right" }, w = { key: 0 }, S = { name: "TableItem" }, D = Object.assign(S, { props: { item: { type: Object, default: () => ({}) }, keys: { type: Array, default: () => [] } }, emits: ["on-click"], setup(d, { emit: C }) {
  const a = d, e = { key: "id", label: "label", children: "children" }, g = C, x = k(() => {
    for (const c of a.item[e.children]) if (c[e.children] && c[e.children].length > 0) return true;
    return false;
  }), t = k(() => {
    const c = /* @__PURE__ */ new Set([...a.keys]);
    if (a.item[e.children]) for (const r of a.item[e.children]) r.checked = c.has(r[e.key]);
    const n = c.has(a.item[e.key]);
    return { ...a.item, checked: n };
  });
  function i(c, n) {
    g("on-click", c, n);
  }
  return (c, n) => {
    const r = T("table-item", true);
    return s(), o("div", N, [m("div", V, [(s(), _(p(u), { key: t.value[e.key], value: t.value[e.key], checked: t.value.checked, onOnClick: i }, { default: h(() => [y(f(t.value[e.label]), 1)]), _: 1 }, 8, ["value", "checked"]))]), t.value && t.value[e.children] ? (s(), o("div", j, [x.value ? (s(true), o(v, { key: 1 }, b(t.value[e.children], (l) => (s(), _(r, { key: l[e.key], item: l, keys: d.keys, onOnClick: i }, null, 8, ["item", "keys"]))), 128)) : (s(), o("span", w, [(s(true), o(v, null, b(t.value[e.children], (l) => (s(), o("label", { key: l[e.key] }, [B(p(u), { value: l[e.key], checked: l.checked, onOnClick: i }, { default: h(() => [y(f(l[e.label]), 1)]), _: 2 }, 1032, ["value", "checked"])]))), 128))]))])) : I("", true), n[0] || (n[0] = m("div", { class: "tree-item-clear" }, null, -1))]);
  };
} }), F = O(D, [["__scopeId", "data-v-6463d404"]]);
export {
  F as default
};
