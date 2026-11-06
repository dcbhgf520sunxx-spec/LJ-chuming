import { ku as A, v5 as I, i as r, gD as c, wE as h } from "../../../../../shared/runtime.js";
import { ref as p } from "vue";
import { computed as s } from "vue";
import { watch as f } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as C } from "vue";
import { createBlock as V } from "vue";
import { unref as T } from "vue";
const v = { __name: "project-self-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "fullName", value: "id" }) }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, projectType: { type: Number, default: A }, placeholder: { type: String, default: "请选择项目" }, projectAttribute: { type: [Number, String], default: void 0 }, projectManagerId: { type: [Number, String], default: void 0 }, branchCompanyId: { type: [Number, String], default: void 0 }, isNotInternalContractSystem: { type: Boolean, default: false }, isNotSelfSupport: { type: Boolean, default: false }, isSelfSupport: { type: Boolean, default: true }, defaultOptions: { type: Array, default: () => [] } }, emits: ["update:modelValue", "change", "projectChange"], setup(l, { emit: m }) {
  const o = m, a = l, b = p(false), u = p(), { loaded: S, projectAllType: y } = I(), n = s(() => {
    let e = r(a.defaultOptions) ? a.defaultOptions : y.value;
    return console.log(a.defaultOptions), e = e.filter((t) => (r(a.projectAttribute) ? t.projectAttribute === a.projectAttribute : true) && (a.projectManagerId ? t.projectManagerId === a.projectManagerId : true)), a.isNotInternalContractSystem && (e = e.filter((t) => r(t.projectAttribute) && t.projectAttribute !== c.LUMP_SUM_SYSTEM.V)), a.isNotSelfSupport && (e = e.filter((t) => r(t.projectAttribute) && t.projectAttribute !== c.SELF_SUPPORT.V)), a.isSelfSupport && (e = e.filter((t) => r(t.projectAttribute) && t.projectAttribute === c.SELF_SUPPORT.V)), a.branchCompanyId && (e = e.filter((t) => t.contractSignBodyId === a.branchCompanyId || t.level === h.CONSTRUCTION_SITE_FACTORY.V)), e;
  }), g = s(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.map((t) => t.id).includes(a.defaultId);
  });
  f(() => g.value, (e) => {
    const t = e ? a.defaultId : void 0;
    d(t);
  }, { immediate: true }), f(() => a.modelValue, (e) => {
    u.value = e, d(u.value);
  }, { immediate: true });
  function d(e) {
    o("update:modelValue", e), o("change", e);
    const t = n.value.find((i) => i.id === e) || {};
    o("projectChange", t);
  }
  return (e, t) => {
    const i = N("common-select");
    return C(), V(i, { modelValue: u.value, "onUpdate:modelValue": t[0] || (t[0] = (j) => u.value = j), clearable: l.clearable, "data-structure": l.dataStructure, "default-id": a.defaultId, disabled: a.disabled || !T(S), loading: b.value, multiple: l.multiple, options: n.value, placeholder: l.placeholder, size: l.size, type: "other", filterable: "", onChange: d }, null, 8, ["modelValue", "clearable", "data-structure", "default-id", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} };
export {
  v as default
};
