import { ref as A } from "vue";
import { watchEffect as j } from "vue";
import { computed as c } from "vue";
import { watch as B } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as M } from "vue";
import { createBlock as d } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as p } from "vue";
import { Fragment as U } from "vue";
import { ElTableColumn as E } from "element-plus";
import { fg as w, mx as T, y0 as b, i as m, z as g, b as N } from "../../../../../../shared/runtime.js";
const K = { __name: "project-set-columns", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, form: { type: Object, default: () => ({}) } }, setup(S) {
  const a = S, u = A({ list: [] });
  w();
  const { projects: q } = T();
  j(() => {
    u.value = a.form;
  });
  const { initScopeList: V, handleValueChange: C, getNotDittoArr: I, getRealVal: _ } = b("projectId"), { initScopeList: v, handleValueChange: z, getNotDittoArr: y, getRealVal: G } = b("monomerId"), { initScopeList: k, handleValueChange: P, getRealVal: R } = b("requisitionsSN");
  c(() => I()), c(() => y());
  const D = c(() => m(a.order) && m(a.order.requisitionsSN) ? a.order.requisitionsSN.map((o) => ({ serialNumber: o })) : null), h = c(() => {
    const o = a.order;
    return m(o) && m(o.projects) ? o.projects.map((t) => ({ id: t.id, name: g(t, { showSerialNumber: true }) })) : q.value.map((t) => ({ id: t.id, name: g(t, { showSerialNumber: true }) }));
  });
  j(() => {
    k(u.value.list || []), V(u.value.list || []), v(u.value.list || []);
  }), B(h, (o) => {
  }, { immediate: true });
  function O(o, t, r) {
    P(o, r);
    const s = R(r);
    if (s) {
      const e = a.requisitions;
      t.projectId = e ? e[s].projectId : void 0, console.log("row.projectId: ", t.projectId), t.disabledProjectId = a.order.projectIds.filter((i) => i !== t.projectId);
    } else t.disabledProjectId = [];
  }
  function L(o, t) {
    let r = [];
    const s = _(o);
    return N(s) ? r = a.order.requisitionsSN.map((e) => ({ serialNumber: e })) : Object.keys(a.requisitions).forEach((e) => {
      a.requisitions[e].projectId === s && r.push({ serialNumber: e });
    }), N(r) ? (t.requisitionsDittoable = false, t.requisitionsSN = void 0) : t.requisitionsDittoable = true, r;
  }
  function x(o, t, r) {
    C(o, t);
  }
  return (o, t) => {
    const r = F("common-select"), s = E;
    return n(), M(U, null, [D.value ? (n(), d(s, { key: 0, align: "center", label: "申购单", "min-width": "130", prop: "requisitionsSN" }, { default: f(({ row: { sourceRow: e }, $index: i }) => [e ? (n(), d(r, { key: 0, modelValue: e.requisitionsSN, "onUpdate:modelValue": (l) => e.requisitionsSN = l, dataStructure: { key: "serialNumber", label: "serialNumber", value: "serialNumber" }, options: L(i, e), "show-extra": i !== 0 && e.requisitionsDittoable, clearable: "", placeholder: "申购单", type: "other", onChange: (l) => O(l, e, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])) : p("", true)]), _: 1 })) : p("", true), h.value ? (n(), d(s, { key: 1, align: "center", label: "所属项目", "min-width": "170px", prop: "projectId" }, { default: f(({ row: { sourceRow: e }, $index: i }) => [e ? (n(), d(r, { key: Math.random(), modelValue: e.projectId, "onUpdate:modelValue": (l) => e.projectId = l, dataStructure: { key: "id", label: "name", value: "id" }, disabled: e.boolApplyPurchase, "disabled-val": e.disabledProjectId, options: h.value, "show-extra": i !== 0, filterable: "", placeholder: "所属项目", type: "other", onChange: (l) => x(l, i, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "disabled-val", "options", "show-extra", "onChange"])) : p("", true)]), _: 1 })) : p("", true)], 64);
  };
} };
export {
  K as default
};
