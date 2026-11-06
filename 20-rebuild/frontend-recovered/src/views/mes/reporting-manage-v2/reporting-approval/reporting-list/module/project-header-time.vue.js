import { ref as o } from "vue";
import { computed as S } from "vue";
import { watch as w } from "vue";
import { nextTick as L } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as c } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as C } from "vue";
import { createElementVNode as m } from "vue";
import { normalizeStyle as V } from "vue";
import { Fragment as q } from "vue";
import { renderList as z } from "vue";
import { toDisplayString as h } from "vue";
import { createTextVNode as A } from "vue";
import { ArrowLeft as D } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { ArrowRight as O } from "@element-plus/icons-vue";
import { ElTag as Q } from "element-plus";
import { _ as F, b as W } from "../../../../../../shared/runtime.js";
const K = { class: "project-header-time-query" }, P = ["onClick"], X = { key: 1 }, G = { __name: "project-header-time", props: { modelValue: { type: [Number, String, Array, void 0], default: void 0 }, data: { type: Array, default: () => [] }, multiple: { type: Boolean, default: false }, emptyText: { type: String, default: "暂无数据" } }, emits: ["update:modelValue", "change"], setup(d, { emit: T }) {
  const y = T, s = d, v = o(), g = o(), a = o(), f = o(0), p = S(() => !!(a.value && v.value && a.value.clientWidth > v.value.clientWidth)), u = o();
  w(() => p.value, () => {
    L(() => {
      var e;
      u.value = ((e = g.value) == null ? void 0 : e.clientWidth) || 0;
    });
  }, { immediate: true });
  const l = o();
  w(() => s.modelValue, (e) => {
    l.value = e;
  }, { immediate: true });
  const j = S(() => {
    var t;
    let e = f.value * u.value;
    return (t = a.value) != null && t.clientWidth && (f.value + 1) * u.value > a.value.clientWidth && (e = a.value.clientWidth - u.value), p.value ? `transform:translateX(-${e}px)` : "";
  });
  function x(e) {
    let t = f.value;
    e === "left" && t--, e === "right" && (t + 1) * u.value < a.value.clientWidth && t++, f.value = t >= 0 ? t : 0;
  }
  function R(e) {
    var t;
    if (s.multiple) {
      if (W(l.value) || ((t = l.value) == null ? void 0 : t.indexOf(e)) === -1) return false;
    } else if (s.modelValue !== e) return false;
    return true;
  }
  function B(e) {
    if (s.multiple) {
      W(l.value) && (l.value = []);
      const t = l.value.indexOf(e);
      t === -1 ? l.value.push(e) : l.value.splice(t, 1), k(l.value);
    } else s.modelValue !== e && k(e);
  }
  function k(e) {
    y("update:modelValue", e), y("change");
  }
  return (e, t) => {
    const N = D, b = H, $ = O, E = Q;
    return n(), i("div", K, [d.data.length ? (n(), i("div", { key: 0, class: "project-header-time-query-content", ref_key: "timeQueryContentRef", ref: v }, [p.value ? (n(), i("div", { key: 0, style: { padding: "0 2px", cursor: "pointer", "border-right": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[0] || (t[0] = (r) => x("left")) }, [c(b, null, { default: _(() => [c(N)]), _: 1 })])) : C("", true), m("div", { class: "time-scroll", ref_key: "timeScrollRef", ref: g, width: "322px" }, [m("div", { class: "time-list", ref_key: "timeListRef", ref: a, style: V(j.value) }, [(n(true), i(q, null, z(d.data, (r, I) => (n(), i("div", { class: "time-item", style: V(R(r.timeStamp) ? "background: rgb(64 158 255);color: #fff;" : ""), key: I, onClick: (J) => B(r.timeStamp) }, [m("div", null, h(r.day), 1), m("div", null, h(r.week), 1)], 12, P))), 128))], 4)], 512), p.value ? (n(), i("div", { key: 1, style: { padding: "0 2px", cursor: "pointer", "border-left": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[1] || (t[1] = (r) => x("right")) }, [c(b, null, { default: _(() => [c($)]), _: 1 })])) : C("", true)], 512)) : (n(), i("div", X, [c(E, { type: "warning", size: "large" }, { default: _(() => [A(" * " + h(d.emptyText), 1)]), _: 1 })]))]);
  };
} }, Y = F(G, [["__scopeId", "data-v-ba79e195"]]);
export {
  Y as default
};
