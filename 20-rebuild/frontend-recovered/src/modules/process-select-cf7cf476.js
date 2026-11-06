import { ref as d } from "vue";
import { computed as z } from "vue";
import { watch as T } from "vue";
import { openBlock as i } from "vue";
import { createBlock as y } from "vue";
import { withCtx as v } from "vue";
import { createElementBlock as O } from "vue";
import { Fragment as B } from "vue";
import { renderList as E } from "vue";
import { unref as I } from "vue";
import { ElOption as R } from "element-plus";
import { ElOptionGroup as D } from "element-plus";
import { ElSelect as F } from "element-plus";
import { aD as o, i as g } from "../shared/runtime.js";
import { R as P } from "./raf-ac2cc4f2.js";
import { u as M } from "./use-bridge-process-6f90ba68.js";
const K = { __name: "process-select", props: { productType: { type: [Number, Boolean, Array], default: void 0 }, modelValue: { type: [Number, Array] }, containsMachinePart: { type: Boolean, default: false }, multiple: { type: Boolean, default: true }, collapseTags: { type: Boolean, default: true }, clearable: { type: Boolean, default: false }, size: { type: String, default: "default" }, disabledProductType: { type: Array, default: () => [] }, disabledValue: { type: Array, default: () => [] } }, emits: ["change", "update:modelValue"], setup(l, { expose: A, emit: S }) {
  const b = S, c = l, p = d(false), f = d([]), m = d([]), h = d(), { loaded: _, process: n } = M(), k = z(() => {
    let e = c.productType;
    return c.containsMachinePart && e & o.CELL.V && g(c.productType) && (e = e | o.MACHINE_PART.V), m.value.filter((t) => (t.originOptions && t.originOptions.length && (t.options = t.originOptions.filter((a) => g(e) ? e & a.productType : true)), g(e) ? e & t.type : true));
  });
  T(() => c.modelValue, (e) => {
    f.value = e, V(e);
  }, { immediate: true }), T(n, (e) => {
    N();
  }, { immediate: true, deep: true });
  function V(e) {
    b("update:modelValue", e), b("change", e);
  }
  function w(e) {
    return n.value.find((t) => t.id === e);
  }
  async function x() {
    return p.value || await L(), h;
  }
  async function L() {
    return new Promise((e, t) => {
      P.setInterval(() => {
        p.value && (P.clearInterval(), e());
      }, 100);
    });
  }
  function N() {
    m.value = [];
    const e = [];
    try {
      h.value = JSON.parse(JSON.stringify(n.value)), o.KEYS.forEach((t) => {
        const a = {};
        a.type = o[t].V, a.name = o[t].L + "工序", a.options = n.value.filter((r) => r.productType === o[t].V), a.originOptions = n.value.filter((r) => r.productType === o[t].V), a.options && a.options.length && e.push(a);
      });
    } catch (t) {
      console.log("获取工序", t);
    } finally {
      m.value = e, p.value = true;
    }
  }
  return A({ getSourceData: x, getOption: w }), (e, t) => {
    const a = R, r = D, C = F;
    return i(), y(C, { modelValue: f.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => f.value = s), size: l.size, multiple: l.multiple, "collapse-tags": l.collapseTags, loading: !I(_), clearable: l.clearable, filterable: "", placeholder: "请选择工序", onChange: V }, { default: v(() => [(i(true), O(B, null, E(k.value, (s) => (i(), y(r, { key: s.type, label: s.name }, { default: v(() => [(i(true), O(B, null, E(s.options, (u) => (i(), y(a, { key: u.id, label: u.name, value: u.id, disabled: l.disabledValue ? l.disabledValue.indexOf(u.id) > -1 || l.disabledProductType.indexOf(u.productType) > -1 : false }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "multiple", "collapse-tags", "loading", "clearable"]);
  };
} };
export {
  K as _
};
