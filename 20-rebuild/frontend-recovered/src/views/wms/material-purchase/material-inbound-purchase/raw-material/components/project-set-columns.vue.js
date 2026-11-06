import { ref as M } from "vue";
import { watchEffect as g } from "vue";
import { computed as p } from "vue";
import { watch as x } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as E } from "vue";
import { createBlock as m } from "vue";
import { withCtx as S } from "vue";
import { createCommentVNode as h } from "vue";
import { Fragment as T } from "vue";
import { ElTableColumn as U } from "element-plus";
import { v5 as w, fg as z, y0 as b, i as c, z as q, b as V } from "../../../../../../shared/runtime.js";
const Q = { __name: "project-set-columns", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, form: { type: Object, default: () => ({}) }, projectClearable: { type: Boolean, default: true } }, setup(f) {
  const { projectAllType: C } = w(), a = f, d = M({ list: [] });
  z(), g(() => {
    d.value = a.form;
  });
  const { initScopeList: _, handleValueChange: v, getNotDittoArr: y, getRealVal: I } = b("projectId"), { initScopeList: k, handleValueChange: G, getNotDittoArr: R, getRealVal: H } = b("monomerId"), { initScopeList: P, handleValueChange: D, getRealVal: A } = b("requisitionsSN");
  p(() => y()), p(() => R());
  const O = p(() => c(a.order) && c(a.order.requisitionsSN) ? a.order.requisitionsSN.map((t) => ({ serialNumber: t })) : null), j = p(() => {
    const t = a.order;
    return c(t) && c(t.projects) ? t.projects.map((e) => ({ id: e.id, name: q(e, { showSerialNumber: true }) })) : C.value.filter((o) => c(t) ? o.projectAttribute === t.projectAttribute : true).map((o) => ({ id: o.id, name: q(o, { showSerialNumber: true }) }));
  });
  g(() => {
    P(d.value.list || []), _(d.value.list || []), k(d.value.list || []);
  }), x(j, (t) => {
  }, { immediate: true });
  function B(t, e, o) {
    D(t, o);
    const n = A(o);
    if (n) {
      const l = a.requisitions;
      e.projectId = l ? l[n].projectId : void 0, console.log("row.projectId: ", e.projectId), e.disabledProjectId = a.order.projectIds.filter((r) => r !== e.projectId);
    } else e.disabledProjectId = [];
  }
  function L(t, e) {
    let o = [];
    const n = I(t);
    return V(n) ? o = a.order.requisitionsSN.map((l) => ({ serialNumber: l })) : Object.keys(a.requisitions).forEach((l) => {
      a.requisitions[l].projectId === n && o.push({ serialNumber: l });
    }), V(o) ? (e.requisitionsDittoable = false, e.requisitionsSN = void 0) : e.requisitionsDittoable = true, o;
  }
  function F(t, e, o) {
    v(t, e);
  }
  return (t, e) => {
    const o = N("common-select"), n = U, l = N("common-select-v2");
    return u(), E(T, null, [O.value ? (u(), m(n, { key: 0, align: "center", label: "申购单", "min-width": "130", prop: "requisitionsSN" }, { default: S(({ row: { sourceRow: r }, $index: s }) => [r ? (u(), m(o, { key: 0, modelValue: r.requisitionsSN, "onUpdate:modelValue": (i) => r.requisitionsSN = i, dataStructure: { key: "serialNumber", label: "serialNumber", value: "serialNumber" }, options: L(s, r), "show-extra": s !== 0 && r.requisitionsDittoable, clearable: "", placeholder: "申购单", type: "other", onChange: (i) => B(i, r, s) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])) : h("", true)]), _: 1 })) : h("", true), j.value ? (u(), m(n, { key: 1, align: "center", label: "所属项目", "min-width": "170px", prop: "projectId" }, { default: S(({ row: { sourceRow: r }, $index: s }) => [r ? (u(), m(l, { key: Math.random(), modelValue: r.projectId, "onUpdate:modelValue": (i) => r.projectId = i, clearable: f.projectClearable, dataStructure: { key: "id", label: "name", value: "id" }, "disabled-val": r.disabledProjectId, options: j.value, "show-extra": s !== 0, filterable: "", placeholder: "所属项目", type: "other", onChange: (i) => F(i, s, r) }, null, 8, ["modelValue", "onUpdate:modelValue", "clearable", "disabled-val", "options", "show-extra", "onChange"])) : h("", true)]), _: 1 })) : h("", true)], 64);
  };
} };
export {
  Q as default
};
