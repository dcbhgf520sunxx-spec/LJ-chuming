import { ref as r } from "vue";
import { computed as L } from "vue";
import { watch as R } from "vue";
import { nextTick as F } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as o } from "vue";
import { createVNode as d } from "vue";
import { withCtx as g } from "vue";
import { createCommentVNode as T } from "vue";
import { createElementVNode as c } from "vue";
import { normalizeStyle as B } from "vue";
import { Fragment as H } from "vue";
import { renderList as O } from "vue";
import { toDisplayString as f } from "vue";
import { createTextVNode as Q } from "vue";
import { ArrowLeft as K } from "@element-plus/icons-vue";
import { ElIcon as P } from "element-plus";
import { ArrowRight as X } from "@element-plus/icons-vue";
import { ElTag as G } from "element-plus";
import { _ as J, b as N } from "../../../../shared/runtime.js";
const M = { class: "project-header-time-query" }, U = ["onClick"], Y = { style: { display: "flex", padding: "4px 8px", "align-self": "center" } }, Z = { key: 1, style: { "margin-bottom": "8px" } }, ee = { __name: "group-header", props: { modelValue: { type: [Number, String, Array, void 0], default: void 0 }, data: { type: Array, default: () => [] }, multiple: { type: Boolean, default: false }, emptyText: { type: String, default: "暂无班组数据" } }, emits: ["update:modelValue", "change"], setup(p, { emit: j }) {
  const h = j, s = p, v = r(), y = r(), n = r(), m = r(0), _ = L(() => {
    var e, t;
    return console.log((e = n.value) == null ? void 0 : e.clientWidth, (t = v.value) == null ? void 0 : t.clientWidth), !!(n.value && v.value && n.value.clientWidth > v.value.clientWidth);
  }), u = r();
  R(() => _.value, () => {
    F(() => {
      var e;
      u.value = ((e = y.value) == null ? void 0 : e.clientWidth) || 0;
    });
  }, { immediate: true });
  const a = r();
  R(() => s.modelValue, (e) => {
    a.value = e;
  }, { immediate: true });
  const $ = L(() => {
    var t;
    let e = m.value * u.value;
    return (t = n.value) != null && t.clientWidth && (m.value + 1) * u.value > n.value.clientWidth && (e = n.value.clientWidth - u.value), _.value ? `transform:translateX(-${e}px)` : "";
  });
  function x(e) {
    let t = m.value;
    e === "left" && t--, e === "right" && (t + 1) * u.value < n.value.clientWidth && t++, m.value = t >= 0 ? t : 0;
  }
  function q(e) {
    var t;
    if (s.multiple) {
      if (N(a.value) || ((t = a.value) == null ? void 0 : t.indexOf(e)) === -1) return false;
    } else if (s.modelValue !== e) return false;
    return true;
  }
  function E(e) {
    if (s.multiple) {
      N(a.value) && (a.value = []);
      const t = a.value.indexOf(e);
      t === -1 ? a.value.push(e) : a.value.splice(t, 1), k(a.value);
    } else s.modelValue !== e && k(e);
  }
  function k(e) {
    h("update:modelValue", e), h("change");
  }
  return (e, t) => {
    const I = K, b = P, z = X, A = G;
    return i(), o("div", M, [p.data.length ? (i(), o("div", { key: 0, style: { "margin-bottom": "8px" }, class: "project-header-time-query-content", ref_key: "timeQueryContentRef", ref: v }, [_.value ? (i(), o("div", { key: 0, style: { padding: "0 2px", cursor: "pointer", "border-right": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[0] || (t[0] = (l) => x("left")) }, [d(b, null, { default: g(() => [d(I)]), _: 1 })])) : T("", true), c("div", { class: "time-scroll", ref_key: "timeScrollRef", ref: y }, [c("div", { class: "time-list", ref_key: "timeListRef", ref: n, style: B($.value) }, [(i(true), o(H, null, O(p.data, (l, D) => {
      var S, W, C, V;
      return i(), o("div", { class: "time-item", style: B([q((S = l.productionLine) == null ? void 0 : S.id) ? "background: rgb(64 158 255);color: #fff;" : "", { display: "flex", height: "50px" }]), key: D, onClick: (te) => {
        var w;
        return E((w = l.productionLine) == null ? void 0 : w.id);
      } }, [c("div", Y, [c("div", null, f((W = l.workshop) == null ? void 0 : W.name) + ">" + f((C = l.productionLine) == null ? void 0 : C.name) + ":", 1), c("div", null, f(l.mete ? (V = l.mete) == null ? void 0 : V.quantity : 0) + "件/" + f(l.mete ? (l.mete.netWeight / 1e3).toFixed(2) : 0) + "吨", 1)])], 12, U);
    }), 128))], 4)], 512), _.value ? (i(), o("div", { key: 1, style: { padding: "0 2px", cursor: "pointer", "border-left": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[1] || (t[1] = (l) => x("right")) }, [d(b, null, { default: g(() => [d(z)]), _: 1 })])) : T("", true)], 512)) : (i(), o("div", Z, [d(A, { type: "warning", size: "large" }, { default: g(() => [Q(" * " + f(p.emptyText), 1)]), _: 1 })]))]);
  };
} }, ne = J(ee, [["__scopeId", "data-v-9fa49666"]]);
export {
  ne as default
};
