import { ref as d } from "vue";
import { watch as f } from "vue";
import { computed as g } from "vue";
import { openBlock as h } from "vue";
import { createBlock as V } from "vue";
import { unref as C } from "vue";
import { createCommentVNode as w } from "vue";
import { ElDatePicker as _ } from "element-plus";
import { yW as k, yY as y, I as T, b as s, ai as S } from "../shared/runtime.js";
const x = { __name: "closing-time-date-query", props: { modelValue: { type: [Number, String], default: void 0 }, showLabel: { type: String, default: "" } }, emits: ["change", "update:modelValue"], setup(u, { emit: m }) {
  const i = m, t = u, r = d([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), l = d();
  f(() => t.modelValue, (a) => {
    l.value = a;
  }, { immediate: true });
  const c = g(() => {
    const a = k();
    return a && a === y.SELF.V;
  });
  function p(a) {
    let e = a;
    s(e) && (e = void 0);
    const o = !S(e, t.modelValue), n = s(e) && s(t.modelValue);
    o && !n && (i("update:modelValue", e), i("change", e));
  }
  return (a, e) => {
    const o = _;
    return c.value ? (h(), V(o, { key: 0, modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => l.value = n), "default-time": r.value, shortcuts: C(T), class: "filter-item", "range-separator": ":", size: "default", "value-format": "x", "unlink-panels": "", "start-placeholder": `实际${t.showLabel}日期`, "end-placeholder": `实际${u.showLabel}日期`, style: { width: "240px" }, type: "daterange", onChange: p }, null, 8, ["modelValue", "default-time", "shortcuts", "start-placeholder", "end-placeholder"])) : w("", true);
  };
} };
export {
  x as _
};
