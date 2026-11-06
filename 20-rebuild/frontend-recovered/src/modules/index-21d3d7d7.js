import { _ as f, O as l, a as x } from "../shared/runtime.js";
import { ref as b } from "vue";
import { watch as y } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as N } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as m } from "vue";
import { unref as a } from "vue";
const k = { class: "scale-container" }, F = { __name: "index", props: { value: { type: Number, default: 1 }, step: { type: Number, default: 0.1 }, min: { type: Number, default: 0.5 }, max: { type: Number, default: 2 }, intervals: { type: Number, default: 200 } }, emits: ["update:value", "zoom", "zoom-out", "reset"], setup(v, { emit: _ }) {
  const c = b(200), t = _, o = v;
  y(() => o.intervals, (e) => {
    c.value = e;
  }, { immediate: true });
  const r = l(function() {
    let e = o.value + o.step;
    e = e > o.max ? o.max : e, e !== o.value && (t("update:value", +e.toFixed(1)), t("zoom", +e.toFixed(1)));
  }, c.value), p = l(function() {
    let e = o.value - o.step;
    e = e < o.min ? o.min : e, e !== o.value && (t("update:value", +e.toFixed(1)), t("zoom-out", +e.toFixed(1)));
  }, c.value), d = l(function() {
    o.value !== 1 && (t("update:value", 1), t("reset"));
  }, c.value);
  return (e, s) => {
    const i = x;
    return z(), N("div", k, [u("div", { class: "icon-box", onClick: s[0] || (s[0] = (...n) => a(r) && a(r)(...n)) }, [m(i, { class: "icon", "icon-class": "comp-zoom" })]), u("div", { class: "icon-box", onClick: s[1] || (s[1] = (...n) => a(p) && a(p)(...n)) }, [m(i, { class: "icon", "icon-class": "comp-zoom-out" })]), u("div", { class: "icon-box", onClick: s[2] || (s[2] = (...n) => a(d) && a(d)(...n)) }, [m(i, { class: "icon", "icon-class": "comp-restore-size" })])]);
  };
} }, C = f(F, [["__scopeId", "data-v-c662174c"]]);
export {
  C as S
};
