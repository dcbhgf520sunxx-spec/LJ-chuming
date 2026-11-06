import { ref as s } from "vue";
import { watch as y } from "vue";
import { onBeforeUnmount as $ } from "vue";
import { onMounted as L } from "vue";
import { nextTick as j } from "vue";
import { computed as P } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as p } from "vue";
import { withCtx as W } from "vue";
import { createCommentVNode as B } from "vue";
import { createElementVNode as x } from "vue";
import { normalizeStyle as I } from "vue";
import { Fragment as q } from "vue";
import { renderList as A } from "vue";
import { toDisplayString as w } from "vue";
import { createTextVNode as D } from "vue";
import { ArrowLeft as H } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ArrowRight as F } from "@element-plus/icons-vue";
import { ElTag as K } from "element-plus";
import { _ as U, b as E } from "../../../../shared/runtime.js";
const X = { class: "project-header-time-query" }, G = ["onClick"], J = { key: 1 }, Y = { __name: "project-header-time", props: { modelValue: { type: [Number, String, Array, void 0], default: void 0 }, data: { type: Array, default: () => [] }, multiple: { type: Boolean, default: false }, emptyText: { type: String, default: "暂无数据" } }, emits: ["update:modelValue", "change"], setup(h, { emit: M }) {
  const C = M, l = h, b = s(), k = s(), a = s(), f = s(0), d = s(false), V = new ResizeObserver((e) => {
    var o, r;
    if (!(typeof ((o = a.value) == null ? void 0 : o.clientWidth) == "number" && typeof ((r = b.value) == null ? void 0 : r.clientWidth) == "number")) {
      d.value = false;
      return;
    }
    d.value = a.value.clientWidth > b.value.clientWidth;
  });
  y(() => a.value, (e) => {
    e && V.observe(e);
  }), $(() => {
    a.value && V.unobserve(a.value);
  });
  const m = s();
  async function S() {
    await j();
    const e = a.value, t = k.value;
    if (!e || !t) return;
    const o = e.children;
    if (o.length === 0) return;
    const r = o[0].getBoundingClientRect().width || 65, _ = t.clientWidth || 1, g = l.multiple ? l.data.findIndex((v) => v.timeStamp === l.modelValue[0]) : l.data.findIndex((v) => v.timeStamp === l.modelValue);
    if (g === -1) return;
    const i = Math.max(0, Math.ceil(e.clientWidth / _) - 1);
    f.value = Math.min(Math.floor(g * r / _), i);
  }
  L(() => {
    S();
  }), y(() => d.value, () => {
    j(() => {
      var e;
      m.value = ((e = k.value) == null ? void 0 : e.clientWidth) || 0;
    });
  }, { immediate: true });
  const n = s();
  y(() => l.modelValue, (e) => {
    S(), n.value = e;
  }, { immediate: true }), y(() => l.data, () => {
    S();
  }, { immediate: true, deep: true });
  const N = P(() => {
    var t;
    let e = f.value * m.value;
    return (t = a.value) != null && t.clientWidth && (f.value + 1) * m.value > a.value.clientWidth && (e = a.value.clientWidth - m.value), d.value ? `transform:translateX(-${e}px)` : "";
  });
  function R(e) {
    let t = f.value;
    e === "left" && t--, e === "right" && (t + 1) * m.value < a.value.clientWidth && t++, f.value = t >= 0 ? t : 0;
  }
  function z(e) {
    var t;
    if (l.multiple) {
      if (E(n.value) || ((t = n.value) == null ? void 0 : t.indexOf(e)) === -1) return false;
    } else if (l.modelValue !== e) return false;
    return true;
  }
  function O(e) {
    if (l.multiple) {
      E(n.value) && (n.value = []);
      const t = n.value.indexOf(e);
      t === -1 ? n.value.push(e) : n.value.splice(t, 1), T(n.value);
    } else l.modelValue !== e && T(e);
  }
  function T(e) {
    C("update:modelValue", e), C("change");
  }
  return (e, t) => {
    const o = H, r = Q, _ = F, g = K;
    return u(), c("div", X, [h.data.length ? (u(), c("div", { key: 0, class: "project-header-time-query-content", ref_key: "timeQueryContentRef", ref: b }, [d.value ? (u(), c("div", { key: 0, style: { padding: "0 2px", cursor: "pointer", "border-right": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[0] || (t[0] = (i) => R("left")) }, [p(r, null, { default: W(() => [p(o)]), _: 1 })])) : B("", true), x("div", { class: "time-scroll", ref_key: "timeScrollRef", ref: k }, [x("div", { class: "time-list", ref_key: "timeListRef", ref: a, style: I(N.value) }, [(u(true), c(q, null, A(h.data, (i, v) => (u(), c("div", { class: "time-item", style: I(z(i.timeStamp) ? "background: rgb(64 158 255);color: #fff;" : ""), key: v, onClick: (Z) => O(i.timeStamp) }, [x("div", null, w(i.year), 1), x("div", null, w(i.month) + "月", 1)], 12, G))), 128))], 4)], 512), d.value ? (u(), c("div", { key: 1, style: { padding: "0 2px", cursor: "pointer", "border-left": "1px solid #ebebeb", height: "51px", "line-height": "51px" }, onClick: t[1] || (t[1] = (i) => R("right")) }, [p(r, null, { default: W(() => [p(_)]), _: 1 })])) : B("", true)], 512)) : (u(), c("div", J, [p(g, { type: "warning", size: "large" }, { default: W(() => [D(" * " + w(h.emptyText), 1)]), _: 1 })]))]);
  };
} }, le = U(Y, [["__scopeId", "data-v-246ee62b"]]);
export {
  le as default
};
