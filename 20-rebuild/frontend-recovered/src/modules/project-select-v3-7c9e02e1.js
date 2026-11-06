import { ref as y } from "vue";
import { computed as g } from "vue";
import { watch as S } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as A } from "vue";
import { createBlock as B } from "vue";
import { withCtx as h } from "vue";
import { createVNode as k } from "vue";
import { createElementVNode as M } from "vue";
import { toDisplayString as O } from "vue";
import { unref as x } from "vue";
import { ElTooltip as v } from "element-plus";
import { ku as P, mx as U, i as s, gD as j } from "../shared/runtime.js";
const D = { __name: "project-select-v3", props: { modelValue: { type: [Number, String], default: void 0 }, dataStructure: { type: Object, default: () => ({ key: "id", label: "fullName", value: "id" }) }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, defaultId: { type: [Number, String], default: void 0 }, projectType: { type: Number, default: P }, placeholder: { type: String, default: "请选择项目" }, projectAttribute: { type: [Number, String], default: void 0 }, projectManagerId: { type: [Number, String], default: void 0 }, branchCompanyId: { type: [Number, String], default: void 0 }, isNotInternalContractSystem: { type: Boolean, default: false }, isNotSelfSupport: { type: Boolean, default: false }, defaultOptions: { type: Array, default: () => [] }, businessType: { type: [Number, String], default: void 0 } }, emits: ["update:modelValue", "change", "projectChange"], setup(r, { emit: N }) {
  const c = N, t = r, I = y(false), d = y(), { loaded: C, projects: b } = U(), p = g(() => {
    var u, i, n;
    const l = t.businessType ? (i = (u = b.value) == null ? void 0 : u.filter((e) => e.businessType === t.businessType)) == null ? void 0 : i.map((e) => (e.fullName = e.serialNumber + " " + e.shortName, e)) : (n = b.value) == null ? void 0 : n.map((e) => (e.fullName = e.serialNumber + " " + e.shortName, e));
    let a = s(t.defaultOptions) ? t.defaultOptions : l;
    return a = a.filter((e) => {
      var o;
      return (s(t.projectAttribute) ? e.projectAttribute === t.projectAttribute || ((o = e.companyLinkDTO) == null ? void 0 : o.findIndex((m) => m.branchCompanyId === t.branchCompanyId)) > -1 : true) && (t.projectManagerId ? e.projectManagerId === t.projectManagerId : true);
    }), t.isNotInternalContractSystem && (a = a.filter((e) => s(e.projectAttribute) && e.projectAttribute !== j.LUMP_SUM_SYSTEM.V)), t.isNotSelfSupport && (a = a.filter((e) => s(e.projectAttribute) && e.projectAttribute !== j.SELF_SUPPORT.V)), t.branchCompanyId && (a = a.filter((e) => {
      var o;
      return e.contractSignBodyId === t.branchCompanyId || ((o = e.companyLinkDTO) == null ? void 0 : o.findIndex((m) => m.branchCompanyId === t.branchCompanyId)) > -1;
    })), a;
  }), V = g(() => {
    var l;
    return (l = p.value) == null ? void 0 : l.map((a) => a.id).includes(t.defaultId);
  });
  S(() => V.value, (l) => {
    const a = l ? t.defaultId : void 0;
    f(a);
  }, { immediate: true }), S(() => t.modelValue, (l) => {
    d.value = l, f(d.value);
  }, { immediate: true });
  function f(l) {
    c("update:modelValue", l), c("change", l);
    const a = p.value.find((u) => u.id === l) || {};
    c("projectChange", a);
  }
  return (l, a) => {
    const u = v, i = T("common-select-v2");
    return A(), B(i, { modelValue: d.value, "onUpdate:modelValue": a[0] || (a[0] = (n) => d.value = n), clearable: r.clearable, "data-structure": r.dataStructure, "default-id": t.defaultId, disabled: t.disabled || !x(C), loading: I.value, multiple: r.multiple, options: p.value, placeholder: r.placeholder, size: r.size, type: "other", filterable: "", onChange: f }, { view: h(({ data: n }) => [k(u, { class: "item", effect: "dark", content: n[r.dataStructure.label], placement: "left" }, { default: h(() => [M("span", null, O(n[r.dataStructure.label]), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }, 8, ["modelValue", "clearable", "data-structure", "default-id", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} };
export {
  D as _
};
