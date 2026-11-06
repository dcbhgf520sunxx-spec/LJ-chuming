import { ku as c, mx as y, z as h } from "../../../../../../../shared/runtime.js";
import { ref as i } from "vue";
import { computed as m } from "vue";
import { watch as f } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as j } from "vue";
import { createBlock as V } from "vue";
const B = { __name: "project-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "serialNumber", label: "fullName", value: "serialNumber" }) }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, projectType: { type: Number, default: c }, placeholder: { type: String, default: "请选择项目" } }, emits: ["update:modelValue", "change", "projectChange"], setup(l, { emit: p }) {
  const s = p, t = l, b = i(false), u = i(), { userProjectsMap: g } = y(), d = m(() => {
    const e = g.value[c];
    return e == null || e.map((a) => {
      a.fullName = h(a, null, false);
    }), e;
  }), v = m(() => {
    var e;
    return (e = d.value) == null ? void 0 : e.map((a) => a.id).includes(t.defaultId);
  });
  f(() => v.value, (e) => {
    const a = e ? t.defaultId : void 0;
    n(a);
  }, { immediate: true }), f(() => t.modelValue, (e) => {
    u.value = e, n(u.value);
  }, { immediate: true });
  function n(e) {
    var o;
    s("update:modelValue", e);
    const a = (o = d.value) == null ? void 0 : o.find((r) => r.serialNumber === e);
    s("change", a || { projectId: void 0, projectFullName: void 0 });
  }
  return (e, a) => {
    const o = N("common-select");
    return j(), V(o, { modelValue: u.value, "onUpdate:modelValue": a[0] || (a[0] = (r) => u.value = r), clearable: l.clearable, "data-structure": l.dataStructure, "default-id": t.defaultId, disabled: t.disabled, loading: b.value, options: d.value, placeholder: l.placeholder, size: l.size, type: "other", filterable: "", onChange: n }, null, 8, ["modelValue", "clearable", "data-structure", "default-id", "disabled", "loading", "options", "placeholder", "size"]);
  };
} };
export {
  B as default
};
