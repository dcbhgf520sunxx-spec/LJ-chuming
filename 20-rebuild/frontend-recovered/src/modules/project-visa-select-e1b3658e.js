import { useStore as y } from "vuex";
import { computed as i } from "vue";
import { watch as u } from "vue";
import { ref as m } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as v } from "vue";
import { createBlock as V } from "vue";
const B = (l) => {
  const o = y(), s = i(() => o.state.project.visaLoaded);
  if (s.value || o.dispatch("project/fetchUserVisaProjects"), l) {
    const t = u(s, (n) => {
      n && setTimeout(() => {
        l(), t();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: s, visaProjects: i(() => o.state.project.userVisaProjects) };
}, P = { __name: "project-visa-select", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "fullName", value: "id" }) }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, placeholder: { type: String, default: "请选择项目" }, filterSettlement: { type: Boolean, default: false }, isRefresh: { type: Boolean, default: false }, businessType: { type: Number, default: void 0 }, projectStatus: { type: Number, default: void 0 }, saveSettlement: { type: Boolean, default: false }, isFilterBusinessType: { type: Boolean, default: true } }, emits: ["update:modelValue", "change", "projectChange"], setup(l, { emit: o }) {
  const s = o, t = l, n = m(false), r = m(), b = y(), { visaProjects: f } = B(), d = i(() => {
    let e = f.value;
    return t.isFilterBusinessType && (e = f.value.filter((a) => a.businessType === t.businessType)), t.projectStatus && (e = e.filter((a) => a.status === t.projectStatus)), t.saveSettlement && (e = e.filter((a) => a.isSubmitSettle === true)), e.filter((a) => !t.filterSettlement || t.filterSettlement === !a.isSubmitSettle);
  }), g = i(() => d.value.map((e) => e.id).includes(t.defaultId));
  u(() => g.value, (e) => {
    const a = e ? t.defaultId : void 0;
    p(a);
  }, { immediate: true }), u(() => t.modelValue, (e) => {
    r.value = e;
  }), u(() => t.isRefresh, (e) => {
    e && S();
  });
  function S() {
    b.dispatch("project/fetchUserVisaProjects");
  }
  function p(e) {
    s("update:modelValue", e), s("change", e);
    const a = d.value.find((c) => c.id === e) || {};
    s("projectChange", a);
  }
  return (e, a) => {
    const c = j("common-select");
    return v(), V(c, { modelValue: r.value, "onUpdate:modelValue": a[0] || (a[0] = (h) => r.value = h), loading: n.value, options: d.value, type: "other", "collapse-tags": l.collapseTags, "data-structure": l.dataStructure, size: l.size, clearable: l.clearable, "default-id": t.defaultId, disabled: t.disabled, filterable: "", placeholder: l.placeholder, onChange: p }, null, 8, ["modelValue", "loading", "options", "collapse-tags", "data-structure", "size", "clearable", "default-id", "disabled", "placeholder"]);
  };
} };
export {
  P as _
};
