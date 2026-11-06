import { ref as O } from "vue";
import { watchEffect as j } from "vue";
import { computed as h } from "vue";
import { watch as R } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as c } from "vue";
import { withCtx as p } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as V } from "vue";
import { unref as s } from "vue";
import { Fragment as H } from "vue";
import { nextTick as _ } from "vue";
import { ElTableColumn as K } from "element-plus";
import { fg as W, y0 as y, i as q, z as G, hV as J, b as C } from "../../../../../../../shared/runtime.js";
import { _ as Q } from "../../../../../../../modules/workshop-select-210dd661.js";
const $ = { __name: "project-set-columns", props: { form: { type: Object, default: () => ({}) }, projectClearable: { type: Boolean, default: false } }, setup(k) {
  const I = k, r = O({ list: [] }), { projectTree: g, projectMap: v, monomerMap: x } = W();
  j(() => {
    r.value = I.form;
  });
  const { initScopeList: M, handleValueChange: S, getNotDittoArr: N, getRealVal: D } = y("projectId"), { initScopeList: P, handleValueChange: U, getNotDittoArr: B, getRealVal: F } = y("monomerId"), T = h(() => N()), A = h(() => B()), b = h(() => {
    if (q(g.value)) {
      const a = g.value.map((n) => ({ id: n.id, name: n.id !== "common" ? G(n, { showSerialNumber: false }) : "公共库" }));
      return a.unshift({ id: "common", name: "公共库" }), a;
    } else return null;
  });
  j(() => {
    M(r.value.list || []), P(r.value.list || []);
  }), R(b, (a) => {
    a && a.length === 1 && r.value.list[0] && (r.value.list[0].projectId = a[0].id);
  }, { immediate: true });
  function E(a, n, t) {
    S(a, n), a !== -1 ? t.monomerId = void 0 : _(() => {
      C(t.monomerId) && (t.monomerId = -1, t.areaId = -1);
    });
  }
  function L(a, n, t) {
    U(a, n), a !== -1 ? t.areaId = void 0 : _(() => {
      C(t.areaId) && (t.areaId = -1);
    });
  }
  return (a, n) => {
    const t = w("common-select"), u = K;
    return i(), z(H, null, [c(u, { prop: "projectId", align: "center", "min-width": "170px", label: "所属项目" }, { default: p(({ row: e, $index: o }) => [e ? (i(), f(t, { key: Math.random(), modelValue: e.projectId, "onUpdate:modelValue": (l) => e.projectId = l, options: b.value, dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": o !== 0, clearable: I.projectClearable, "disabled-val": e.disabledProjectId, type: "other", placeholder: "所属项目", onChange: (l) => E(l, o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "clearable", "disabled-val", "onChange"])) : V("", true)]), _: 1 }), c(u, { prop: "monomerId", align: "center", "min-width": "170px", label: "单体" }, { default: p(({ row: e, $index: o }) => {
      var l, d;
      return [e && e.projectId !== "common" ? (i(), f(t, { key: Math.random(), modelValue: e.monomerId, "onUpdate:modelValue": (m) => e.monomerId = m, options: ((d = (l = s(v)) == null ? void 0 : l[s(D)(o)]) == null ? void 0 : d.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": !T.value.includes(o), clearable: "", type: "other", placeholder: "单体", onChange: (m) => L(m, o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])) : V("", true)];
    }), _: 1 }), c(u, { prop: "areaId", align: "center", "min-width": "170px", label: "区域" }, { default: p(({ row: e, $index: o }) => {
      var l, d;
      return [e && e.projectId !== "common" ? (i(), f(t, { key: Math.random(), modelValue: e.areaId, "onUpdate:modelValue": (m) => e.areaId = m, options: ((d = (l = s(x)) == null ? void 0 : l[s(F)(o)]) == null ? void 0 : d.children) || [], dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": !A.value.includes(o), clearable: "", type: "other", placeholder: "区域" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])) : V("", true)];
    }), _: 1 }), c(u, { prop: "workshopId", label: "车间", width: "170px", align: "center" }, { default: p(({ row: e }) => [c(Q, { modelValue: e.workshopId, "onUpdate:modelValue": (o) => e.workshopId = o, type: s(J).WORKSHOP.V, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue", "type"])]), _: 1 })], 64);
  };
} };
export {
  $ as default
};
