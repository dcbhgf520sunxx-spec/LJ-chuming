import { ku as c, mx as h, z as v } from "../shared/runtime.js";
import { ref as i } from "vue";
import { computed as m } from "vue";
import { watch as f } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as j } from "vue";
import { createBlock as N } from "vue";
const B = { __name: "project-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "fullName", value: "id" }) }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, projectType: { type: Number, default: c }, placeholder: { type: String, default: "请选择项目" } }, emits: ["update:modelValue", "change", "projectChange"], setup(t, { emit: p }) {
  const d = p, l = t, g = i(false), u = i(), { userProjectsMap: b } = h(), n = m(() => {
    const e = b.value[c];
    return e == null || e.map((a) => {
      a.fullName = v(a, null, false);
    }), e;
  }), y = m(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.map((a) => a.id).includes(l.defaultId);
  });
  f(() => y.value, (e) => {
    const a = e ? l.defaultId : void 0;
    r(a);
  }, { immediate: true }), f(() => l.modelValue, (e) => {
    u.value = e, r(u.value);
  }, { immediate: true });
  function r(e) {
    var o;
    d("update:modelValue", e), d("change", e);
    const a = ((o = n.value) == null ? void 0 : o.find((s) => s.id === e)) || {};
    d("projectChange", a);
  }
  return (e, a) => {
    const o = V("common-select");
    return j(), N(o, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (s) => u.value = s), clearable: t.clearable, "data-structure": t.dataStructure, "default-id": l.defaultId, disabled: l.disabled, loading: g.value, options: n.value, placeholder: t.placeholder, size: t.size, type: "other", filterable: "", onChange: r }, null, 8, ["modelValue", "clearable", "data-structure", "default-id", "disabled", "loading", "options", "placeholder", "size"]);
  };
} };
export {
  B as _
};
