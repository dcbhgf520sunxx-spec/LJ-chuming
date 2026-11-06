import { ku as c, mx as y, z as h } from "../../../../../../../shared/runtime.js";
import { ref as i } from "vue";
import { computed as m } from "vue";
import { watch as p } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as j } from "vue";
import { createBlock as V } from "vue";
const B = { __name: "project-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "serialNumber", label: "fullName", value: "serialNumber" }) }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, projectType: { type: Number, default: c }, placeholder: { type: String, default: "请选择项目" } }, emits: ["update:modelValue", "change", "projectChange"], setup(l, { emit: f }) {
  const s = f, a = l, b = i(false), u = i(), { userProjectsMap: g } = y(), d = m(() => {
    const e = g.value[c];
    return e == null || e.map((t) => {
      t.fullName = h(t, null, false);
    }), e;
  }), v = m(() => {
    var e;
    return (e = d.value) == null ? void 0 : e.map((t) => t.id).includes(a.defaultId);
  });
  p(() => v.value, (e) => {
    const t = e ? a.defaultId : void 0;
    r(t);
  }, { immediate: true }), p(() => a.modelValue, (e) => {
    u.value = e, r(u.value);
  }, { immediate: true });
  function r(e) {
    var o;
    s("update:modelValue", e);
    const t = (o = d.value) == null ? void 0 : o.find((n) => n.serialNumber === e);
    s("change", t || { projectId: void 0, projectFullName: void 0 });
  }
  return (e, t) => {
    const o = N("common-select");
    return j(), V(o, { modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => u.value = n), clearable: true, "data-structure": l.dataStructure, "default-id": a.defaultId, disabled: a.disabled, loading: b.value, options: d.value, placeholder: l.placeholder, size: l.size, type: "other", filterable: "", onChange: r }, null, 8, ["modelValue", "data-structure", "default-id", "disabled", "loading", "options", "placeholder", "size"]);
  };
} };
export {
  B as default
};
