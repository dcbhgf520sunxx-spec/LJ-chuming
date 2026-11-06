import { ref as Q } from "vue";
import { watchEffect as y } from "vue";
import { computed as f } from "vue";
import { watch as W } from "vue";
import { resolveComponent as X } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as q } from "vue";
import { createBlock as m } from "vue";
import { withCtx as j } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as v } from "vue";
import { createVNode as V } from "vue";
import { unref as I } from "vue";
import { nextTick as C } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { fg as Z, y0 as N, i as h, z as w, b } from "../../../../../shared/runtime.js";
const te = { __name: "project-set-columns", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, form: { type: Object, default: () => ({}) } }, setup(_) {
  const n = _, s = Q({ list: [] }), { projectMap: k, monomerMap: P } = Z();
  y(() => {
    s.value = n.form;
  });
  const { initScopeList: R, handleValueChange: D, getNotDittoArr: x, getRealVal: S } = N("projectId"), { initScopeList: M, handleValueChange: U, getNotDittoArr: A, getRealVal: O } = N("monomerId"), { initScopeList: L, handleValueChange: B, getRealVal: F } = N("requisitionsSN"), E = f(() => x()), T = f(() => A()), z = f(() => h(n.order) && h(n.order.requisitionsSN) ? n.order.requisitionsSN.map((a) => ({ serialNumber: a })) : null), g = f(() => {
    const a = n.order;
    return h(a) && h(a.projects) ? a.projects.map((o) => ({ id: o.id, name: w(o, { showSerialNumber: false }) })) : null;
  });
  y(() => {
    L(s.value.list || []), R(s.value.list || []), M(s.value.list || []);
  }), W(g, (a) => {
    a && a.length === 1 && s.value.list[0] && !(h(s.value.list[0].applyPurchaseId) && b(s.value.list[0].projectId)) && (s.value.list[0].projectId = a[0].id);
  }, { immediate: true });
  function G(a, o, t) {
    B(a, t);
    const i = F(t);
    if (i) {
      const e = n.requisitions;
      o.projectId = e ? e[i].projectId : void 0, console.log("row.projectId: ", o.projectId), o.disabledProjectId = n.order.projectIds.filter((l) => l !== o.projectId);
    } else o.disabledProjectId = [];
  }
  function H(a, o) {
    let t = [];
    const i = S(a);
    return b(i) ? t = n.order.requisitionsSN.map((e) => ({ serialNumber: e })) : Object.keys(n.requisitions).forEach((e) => {
      n.requisitions[e].projectId === i && t.push({ serialNumber: e });
    }), b(t) ? (o.requisitionsDittoable = false, o.requisitionsSN = void 0) : o.requisitionsDittoable = true, t;
  }
  function J(a, o, t) {
    D(a, o), a !== -1 ? t.monomerId = void 0 : C(() => {
      b(t.monomerId) && (t.monomerId = -1, t.areaId = -1);
    });
  }
  function K(a, o, t) {
    U(a, o), a !== -1 ? t.areaId = void 0 : C(() => {
      b(t.areaId) && (t.areaId = -1);
    });
  }
  return (a, o) => {
    const t = X("common-select"), i = Y;
    return d(), q(v, null, [z.value ? (d(), m(i, { key: 0, align: "center", label: "申购单", "min-width": "130", prop: "requisitionsSN" }, { default: j(({ row: { sourceRow: e }, $index: l }) => [e ? (d(), m(t, { key: 0, modelValue: e.requisitionsSN, "onUpdate:modelValue": (r) => e.requisitionsSN = r, dataStructure: { key: "serialNumber", label: "serialNumber", value: "serialNumber" }, options: H(l, e), "show-extra": l !== 0 && e.requisitionsDittoable, clearable: "", placeholder: "申购单", type: "other", onChange: (r) => G(r, e, l) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])) : u("", true)]), _: 1 })) : u("", true), g.value ? (d(), q(v, { key: 1 }, [V(i, { align: "center", label: "所属项目", "min-width": "170px", prop: "projectId" }, { default: j(({ row: { sourceRow: e }, $index: l }) => [e ? (d(), m(t, { key: Math.random(), modelValue: e.projectId, "onUpdate:modelValue": (r) => e.projectId = r, dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": l !== 0, disabled: e.boolApplyPurchase, "disabled-val": e.disabledProjectId, options: g.value, filterable: "", placeholder: "所属项目", type: "other", onChange: (r) => J(r, l, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "disabled", "disabled-val", "options", "onChange"])) : u("", true)]), _: 1 }), V(i, { align: "center", label: "单体", "min-width": "170px", prop: "monomerId" }, { default: j(({ row: { sourceRow: e }, $index: l }) => {
      var r, c;
      return [e ? (d(), m(t, { key: Math.random(), modelValue: e.monomerId, "onUpdate:modelValue": (p) => e.monomerId = p, dataStructure: { key: "id", label: "name", value: "id" }, options: ((c = (r = I(k)) == null ? void 0 : r[I(S)(l)]) == null ? void 0 : c.children) || [], "show-extra": !E.value.includes(l), disabled: e.boolApplyPurchase && !e.projectId, clearable: "", placeholder: "单体", type: "other", onChange: (p) => K(p, l, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "disabled", "onChange"])) : u("", true)];
    }), _: 1 }), V(i, { align: "center", label: "区域", "min-width": "170px", prop: "areaId" }, { default: j(({ row: { sourceRow: e }, $index: l }) => {
      var r, c;
      return [e ? (d(), m(t, { key: Math.random(), modelValue: e.areaId, "onUpdate:modelValue": (p) => e.areaId = p, dataStructure: { key: "id", label: "name", value: "id" }, options: ((c = (r = I(P)) == null ? void 0 : r[I(O)(l)]) == null ? void 0 : c.children) || [], "show-extra": !T.value.includes(l), disabled: e.boolApplyPurchase && !e.projectId, clearable: "", placeholder: "区域", type: "other" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "disabled"])) : u("", true)];
    }), _: 1 })], 64)) : u("", true)], 64);
  };
} };
export {
  te as default
};
