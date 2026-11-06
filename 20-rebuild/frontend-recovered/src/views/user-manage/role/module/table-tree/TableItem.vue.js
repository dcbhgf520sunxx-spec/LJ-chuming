import { inject as o } from "vue";
import { ref as O } from "vue";
import { computed as y } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as D } from "vue";
import { unref as m } from "vue";
import { createBlock as S } from "vue";
import { toDisplayString as j } from "vue";
import { normalizeClass as w } from "vue";
import { normalizeStyle as g } from "vue";
import { Fragment as z } from "vue";
import { renderList as P } from "vue";
import { createCommentVNode as H } from "vue";
import { ElCheckbox as F } from "element-plus";
import { _ as q, i as r, b as E } from "../../../../../shared/runtime.js";
const A = { class: "tree-item-left" }, G = { key: 1, class: "label-text" }, J = { name: "TableItem" }, Q = Object.assign(J, { props: { item: { type: Object, default: () => ({}) } }, setup(K, { expose: N }) {
  const x = K, n = { CHECKED: 1, SEMI_CHECKED: 2, UN_CHECKED: 3, UN_SEMI_CHECKED: 4 }, i = o("checkedSet"), I = o("checkStrictly"), d = o("returnLeaf"), _ = o("returnIndeterminate"), U = o("disabled"), B = o("checkable"), L = o("onlyShowChecked"), t = O(x.item), M = y(() => !t.value.checked && t.value.semiChecked), V = y(() => L ? t.value.checked || t.value.semiChecked : true);
  function b(s) {
    (!d || d && E(t.value.children)) && (s ? i.value.add(t.value.key) : i.value.delete(t.value.key)), t.value.semiChecked = s;
    const c = s ? n.CHECKED : n.UN_CHECKED;
    I || (C(t.value, c), f(t.value, c));
  }
  function C(s, l) {
    let c;
    const e = s.parent;
    if (!e) return;
    const a = !d || d && E(e.children);
    if (_ && a && (s.checked || s.semiChecked ? i.value.add(e.key) : (e.checked || e.semiChecked) && (e.children.some((k) => k.semiChecked || k.checked) || i.value.delete(e.key))), l === n.CHECKED) {
      e.semiChecked || (e.semiChecked = true, c = n.SEMI_CHECKED), e.checked = e.children.every((h) => h.checked), e.checked && (c = n.CHECKED, a && i.value.add(e.key)), c && r(e.parent) && C(e, c);
      return;
    }
    if (l === n.SEMI_CHECKED) {
      e.semiChecked || (e.semiChecked = true, c = n.SEMI_CHECKED), c && r(e.parent) && C(e, c);
      return;
    }
    if (l === n.UN_CHECKED) {
      let h = true;
      const k = e.children.some((p) => p.semiChecked || p.checked);
      k === e.semiChecked && !e.checked && (h = false), e.semiChecked = k, e.checked && (e.checked = false, a && !_ && i.value.delete(e.key)), h && r(e.parent) && C(e, n.UN_CHECKED);
      return;
    }
  }
  function f(s, l) {
    const c = s.children || [];
    l === n.CHECKED && c.forEach((e) => {
      const a = !d || d && E(e.children);
      e.semiChecked = true, e.checked = true, a && i.value.add(e.key), r(e.children) && f(e, l);
    }), l === n.UN_CHECKED && c.forEach((e) => {
      const a = !d || d && E(e.children);
      e.semiChecked = false, e.checked = false, a && i.value.delete(e.key), r(e.children) && f(e, l);
    });
  }
  return N({ handleChange: b, setChildNode: f }), (s, l) => {
    const c = F, e = T("table-item", true);
    return V.value ? (u(), v("div", { key: 0, class: "tree-item", style: g({ "border-bottom": t.value.isSecondLevel || t.value.children ? "1px solid #e5e5e5" : "none", "border-left": m(r)(t.value.parent.parent) ? "none" : "1px solid #e5e5e5", "border-right": m(r)(t.value.parent.parent) ? "none" : "1px solid #e5e5e5" }) }, [D("div", A, [m(B) ? (u(), S(c, { key: 0, modelValue: t.value.checked, "onUpdate:modelValue": l[0] || (l[0] = (a) => t.value.checked = a), indeterminate: M.value, label: t.value.label, disabled: m(U), onChange: b }, null, 8, ["modelValue", "indeterminate", "label", "disabled"])) : (u(), v("span", G, j(t.value.label), 1))]), m(r)(t.value.children) ? (u(), v("div", { key: 0, class: w(["tree-item-right", t.value.isSecondLevel && t.value.children ? "tree-item-right-last" : ""]), style: g({ "border-left": t.value.isSecondLevel || t.value.children ? "1px solid #e5e5e5" : "none" }) }, [(u(true), v(z, null, P(t.value.children, (a) => (u(), S(e, { key: a.key, item: a }, null, 8, ["item"]))), 128))], 6)) : H("", true), l[1] || (l[1] = D("div", { class: "tree-item-clear" }, null, -1))], 4)) : H("", true);
  };
} }), X = q(Q, [["__scopeId", "data-v-196b4c22"]]);
export {
  X as default
};
