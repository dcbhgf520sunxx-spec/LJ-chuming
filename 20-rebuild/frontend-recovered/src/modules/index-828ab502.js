import { ref as d } from "vue";
import { watch as f } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as B } from "vue";
import { createElementBlock as T } from "vue";
import { Fragment as V } from "vue";
import { renderList as N } from "vue";
import { ElOption as j } from "element-plus";
import { ElSelect as w } from "element-plus";
import { od as x, oe as I, of as S, i as z } from "../shared/runtime.js";
const C = { __name: "index", props: { modelValue: { type: [Number, String] }, projectId: { type: Number, default: void 0 }, packType: { type: Number, default: void 0 }, size: { type: String, default: "default" }, placeholder: { type: String, default: "请选择包单号" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, typeVal: { type: Number } }, emits: ["update:modelValue", "change", "fetchData"], setup(t, { expose: g, emit: v }) {
  const s = v, l = t, i = d(false), o = d(), u = d([]), p = d([]);
  f(() => l.modelValue, (e) => {
    o.value = e;
  }, { immediate: true }), f(o, (e) => {
    r(e);
  }), f(() => l.packType, (e) => {
    e && (u.value = p.value.filter((a) => a.productType === e));
  }, { immediate: true });
  function r(e) {
    s("update:modelValue", e), s("change", e);
  }
  function b() {
    return u.value;
  }
  async function h() {
    u.value = [];
    let e = [];
    i.value = true;
    try {
      const { content: a } = l.type === x.BOX.V ? await I({ projectId: l.projectId }) : await S({ projectId: l.projectId }) || [];
      s("fetchData", a), e = a.map((n) => ({ value: n.id, label: `${n.serialNumber}`, productType: n.productType }));
    } catch (a) {
      console.log("获取包单号列表", a);
    } finally {
      p.value = e, u.value = l.packType ? p.value.filter((a) => a.productType === l.packType) : e, l.default && z(u.value) ? o.value = u.value[0].value : o.value = void 0, r(o.value), i.value = false;
    }
  }
  return h(), g({ getOptions: b }), (e, a) => {
    const n = j, k = w;
    return m(), y(k, { modelValue: o.value, "onUpdate:modelValue": a[0] || (a[0] = (c) => o.value = c), size: t.size, disabled: t.disabled, multiple: t.multiple, "collapse-tags": t.collapseTags, loading: i.value, clearable: t.clearable, placeholder: t.placeholder, filterable: "", onChange: r }, { default: B(() => [(m(true), T(V, null, N(u.value, (c) => (m(), y(n, { key: c.value, label: c.label, value: c.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "placeholder"]);
  };
} };
export {
  C as _
};
