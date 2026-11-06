import { ref as p } from "vue";
import { computed as C } from "vue";
import { watch as E } from "vue";
import { openBlock as d } from "vue";
import { createBlock as b } from "vue";
import { withCtx as O } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as B } from "vue";
import { renderList as S } from "vue";
import { unref as I } from "vue";
import { ElOption as M } from "element-plus";
import { ElOptionGroup as R } from "element-plus";
import { ElSelect as F } from "element-plus";
import { a3 as n, i as f } from "../shared/runtime.js";
import { R as A } from "./raf-ac2cc4f2.js";
import { u as j } from "./use-process-af1f8c99.js";
const K = { __name: "process-select", props: { productType: { type: [Number, Boolean, Array], default: void 0 }, productionLineTypeEnum: { type: [Number, Boolean, Array], default: void 0 }, modelValue: { type: [Number, Array] }, containsMachinePart: { type: Boolean, default: false }, multiple: { type: Boolean, default: true }, collapseTags: { type: Boolean, default: true }, clearable: { type: Boolean, default: false }, size: { type: String, default: "default" }, disabledProductType: { type: Array, default: () => [] }, disabledValue: { type: Array, default: () => [] }, placeholder: { type: String, default: "请选择工序" } }, emits: ["change", "update:modelValue"], setup(l, { expose: L, emit: N }) {
  const h = N, r = l, m = p(false), y = p([]), g = p([]), T = p(), { loaded: P, process: u } = j(), k = C(() => {
    let e = r.productType;
    return r.containsMachinePart && e & n.ASSEMBLE.V && f(r.productType) && (e = e | n.MACHINE_PART.V), g.value.filter((t) => {
      var a;
      return t.originOptions && t.originOptions.length && (t.options = t.originOptions.filter((o) => {
        let i = true;
        return f(e) && !(e & o.productType) && (i = false), f(r.productionLineTypeEnum) && !(r.productionLineTypeEnum & o.productionLineTypeEnum) && (i = false), i;
      })), f(e) ? e & t.type : (a = t.options) == null ? void 0 : a.length;
    });
  });
  E(() => r.modelValue, (e) => {
    y.value = e, V(e);
  }, { immediate: true }), E(u, (e) => {
    z();
  }, { immediate: true, deep: true });
  function V(e) {
    h("update:modelValue", e), h("change", e);
  }
  function w(e) {
    return u.value.find((t) => t.id === e);
  }
  async function x() {
    return m.value || await _(), T;
  }
  async function _() {
    return new Promise((e, t) => {
      A.setInterval(() => {
        m.value && (A.clearInterval(), e());
      }, 100);
    });
  }
  function z() {
    g.value = [];
    const e = [];
    try {
      T.value = JSON.parse(JSON.stringify(u.value)), n.KEYS.forEach((t) => {
        const a = {};
        a.type = n[t].V, a.name = n[t].L + "工序", a.options = u.value.filter((o) => o.productType === n[t].V), a.originOptions = u.value.filter((o) => o.productType === n[t].V), a.options && a.options.length && e.push(a);
      });
    } catch (t) {
      console.log("获取工序", t);
    } finally {
      g.value = e, m.value = true;
    }
  }
  return L({ getSourceData: x, getOption: w }), (e, t) => {
    const a = M, o = R, i = F;
    return d(), b(i, { modelValue: y.value, "onUpdate:modelValue": t[0] || (t[0] = (s) => y.value = s), size: l.size, multiple: l.multiple, "collapse-tags": l.collapseTags, loading: !I(P), clearable: l.clearable, filterable: "", placeholder: l.placeholder, onChange: V }, { default: O(() => [(d(true), v(B, null, S(k.value, (s) => (d(), b(o, { key: s.type, label: s.name }, { default: O(() => [(d(true), v(B, null, S(s.options, (c) => (d(), b(a, { key: c.id, label: c.name, value: c.id, disabled: l.disabledValue ? l.disabledValue.indexOf(c.id) > -1 || l.disabledProductType.indexOf(c.productType) > -1 : false }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "multiple", "collapse-tags", "loading", "clearable", "placeholder"]);
  };
} };
export {
  K as _
};
