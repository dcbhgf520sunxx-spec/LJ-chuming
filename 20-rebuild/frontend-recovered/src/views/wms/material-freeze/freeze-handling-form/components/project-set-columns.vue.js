import { ref as R } from "vue";
import { watchEffect as j } from "vue";
import { computed as h } from "vue";
import { watch as O } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as m } from "vue";
import { withCtx as p } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as V } from "vue";
import { unref as s } from "vue";
import { Fragment as q } from "vue";
import { nextTick as _ } from "vue";
import { ElTableColumn as G } from "element-plus";
import { fg as H, y0 as y, i as J, z as K, aV as Q, b as C } from "../../../../../shared/runtime.js";
const Y = { __name: "project-set-columns", props: { form: { type: Object, default: () => ({}) }, projectClearable: { type: Boolean, default: false } }, setup(k) {
  const I = k, r = R({ list: [] }), { projectTree: g, projectMap: v, monomerMap: x } = H();
  j(() => {
    r.value = I.form;
  });
  const { initScopeList: M, handleValueChange: N, getNotDittoArr: S, getRealVal: D } = y("projectId"), { initScopeList: U, handleValueChange: P, getNotDittoArr: B, getRealVal: F } = y("monomerId"), A = h(() => S()), L = h(() => B()), b = h(() => {
    if (J(g.value)) {
      const a = g.value.map((n) => ({ id: n.id, name: n.id !== "common" ? K(n, { showSerialNumber: false }) : "公共库" }));
      return a.unshift({ id: "common", name: "公共库" }), a;
    } else return null;
  });
  j(() => {
    M(r.value.list || []), U(r.value.list || []);
  }), O(b, (a) => {
    a && a.length === 1 && r.value.list[0] && (r.value.list[0].projectId = a[0].id);
  }, { immediate: true });
  function T(a, n, t) {
    N(a, n), a !== -1 ? t.monomerId = void 0 : _(() => {
      C(t.monomerId) && (t.monomerId = -1, t.areaId = -1);
    });
  }
  function E(a, n, t) {
    P(a, n), a !== -1 ? t.areaId = void 0 : _(() => {
      C(t.areaId) && (t.areaId = -1);
    });
  }
  return (a, n) => {
    const t = w("common-select"), i = G;
    return u(), z(q, null, [m(i, { prop: "projectId", align: "center", "min-width": "170px", label: "所属项目" }, { default: p(({ row: e, $index: o }) => [e ? (u(), f(t, { key: Math.random(), modelValue: e.projectId, "onUpdate:modelValue": (l) => e.projectId = l, options: b.value, dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": o !== 0, clearable: I.projectClearable, "disabled-val": e.disabledProjectId, type: "other", placeholder: "所属项目", onChange: (l) => T(l, o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "clearable", "disabled-val", "onChange"])) : V("", true)]), _: 1 }), m(i, { prop: "monomerId", align: "center", "min-width": "170px", label: "单体" }, { default: p(({ row: e, $index: o }) => {
      var l, d;
      return [e && e.projectId !== "common" ? (u(), f(t, { key: Math.random(), modelValue: e.monomerId, "onUpdate:modelValue": (c) => e.monomerId = c, options: ((d = (l = s(v)) == null ? void 0 : l[s(D)(o)]) == null ? void 0 : d.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": !A.value.includes(o), clearable: "", type: "other", placeholder: "单体", onChange: (c) => E(c, o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])) : V("", true)];
    }), _: 1 }), m(i, { prop: "areaId", align: "center", "min-width": "170px", label: "区域" }, { default: p(({ row: e, $index: o }) => {
      var l, d;
      return [e && e.projectId !== "common" ? (u(), f(t, { key: Math.random(), modelValue: e.areaId, "onUpdate:modelValue": (c) => e.areaId = c, options: ((d = (l = s(x)) == null ? void 0 : l[s(F)(o)]) == null ? void 0 : d.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": !L.value.includes(o), clearable: "", type: "other", placeholder: "区域" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])) : V("", true)];
    }), _: 1 }), m(i, { prop: "workshopId", label: "车间", width: "170px", align: "center" }, { default: p(({ row: e }) => {
      var o;
      return [m(s(Q), { modelValue: e.workshopId, "onUpdate:modelValue": (l) => e.workshopId = l, "factory-id": (o = e.factory) == null ? void 0 : o.id, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue", "factory-id"])];
    }), _: 1 })], 64);
  };
} };
export {
  Y as default
};
