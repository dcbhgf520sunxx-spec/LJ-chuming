import { ref as o } from "vue";
import { computed as b } from "vue";
import { watch as C } from "vue";
import { nextTick as L } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as c } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as V } from "vue";
import { createElementVNode as p } from "vue";
import { normalizeStyle as W } from "vue";
import { Fragment as q } from "vue";
import { renderList as z } from "vue";
import { toDisplayString as h } from "vue";
import { createTextVNode as A } from "vue";
import { ArrowLeft as D } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { ArrowRight as O } from "@element-plus/icons-vue";
import { ElTag as Q } from "element-plus";
import { _ as F, b as w } from "../../../../shared/runtime.js";
const K = { class: "project-header-time-query" }, P = ["onClick"], X = { key: 1 }, G = { __name: "project-header-time", props: { modelValue: { type: [Number, String, Array, void 0], default: void 0 }, data: { type: Array, default: () => [] }, multiple: { type: Boolean, default: false }, emptyText: { type: String, default: "暂无数据" } }, emits: ["update:modelValue", "change"], setup(d, { emit: T }) {
  const y = T, u = d, f = o(), g = o(), a = o(), m = o(0), v = b(() => {
    var e, t;
    return console.log((e = a.value) == null ? void 0 : e.clientWidth, (t = f.value) == null ? void 0 : t.clientWidth), !!(a.value && f.value && a.value.clientWidth > f.value.clientWidth);
  }), s = o();
  C(() => v.value, () => {
    L(() => {
      var e;
      s.value = ((e = g.value) == null ? void 0 : e.clientWidth) || 0;
    });
  }, { immediate: true });
  const l = o();
  C(() => u.modelValue, (e) => {
    l.value = e;
  }, { immediate: true });
  const j = b(() => {
    var t;
    let e = m.value * s.value;
    return (t = a.value) != null && t.clientWidth && (m.value + 1) * s.value > a.value.clientWidth && (e = a.value.clientWidth - s.value), v.value ? `transform:translateX(-${e}px)` : "";
  });
  function x(e) {
    let t = m.value;
    e === "left" && t--, e === "right" && (t + 1) * s.value < a.value.clientWidth && t++, m.value = t >= 0 ? t : 0;
  }
  function R(e) {
    var t;
    if (u.multiple) {
      if (w(l.value) || ((t = l.value) == null ? void 0 : t.indexOf(e)) === -1) return false;
    } else if (u.modelValue !== e) return false;
    return true;
  }
  function B(e) {
    if (u.multiple) {
      w(l.value) && (l.value = []);
      const t = l.value.indexOf(e);
      t === -1 ? l.value.push(e) : l.value.splice(t, 1), k(l.value);
    } else u.modelValue !== e && k(e);
  }
  function k(e) {
    y("update:modelValue", e), y("change");
  }
  return (e, t) => {
    const N = D, S = H, $ = O, E = Q;
    return n(), i("div", K, [d.data.length ? (n(), i("div", { key: 0, class: "project-header-time-query-content", ref_key: "timeQueryContentRef", ref: f }, [v.value ? (n(), i("div", { key: 0, style: { padding: "0 2px", cursor: "pointer", "border-right": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[0] || (t[0] = (r) => x("left")) }, [c(S, null, { default: _(() => [c(N)]), _: 1 })])) : V("", true), p("div", { class: "time-scroll", ref_key: "timeScrollRef", ref: g }, [p("div", { class: "time-list", ref_key: "timeListRef", ref: a, style: W(j.value) }, [(n(true), i(q, null, z(d.data, (r, I) => (n(), i("div", { class: "time-item", style: W(R(r.timeStamp) ? "background: rgb(64 158 255);color: #fff;" : ""), key: I, onClick: (J) => B(r.timeStamp) }, [p("div", null, h(r.year), 1), p("div", null, h(r.month) + "月", 1)], 12, P))), 128))], 4)], 512), v.value ? (n(), i("div", { key: 1, style: { padding: "0 2px", cursor: "pointer", "border-left": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[1] || (t[1] = (r) => x("right")) }, [c(S, null, { default: _(() => [c($)]), _: 1 })])) : V("", true)], 512)) : (n(), i("div", X, [c(E, { type: "warning", size: "large" }, { default: _(() => [A(" * " + h(d.emptyText), 1)]), _: 1 })]))]);
  };
} }, Y = F(G, [["__scopeId", "data-v-ef591191"]]);
export {
  Y as default
};
