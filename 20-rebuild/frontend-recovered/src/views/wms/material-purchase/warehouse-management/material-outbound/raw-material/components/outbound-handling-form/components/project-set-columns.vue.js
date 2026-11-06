import { ref as I } from "vue";
import { watchEffect as p } from "vue";
import { computed as n } from "vue";
import { watch as k } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as c } from "vue";
import { withCtx as f } from "vue";
import { createBlock as M } from "vue";
import { createCommentVNode as P } from "vue";
import { unref as S } from "vue";
import { Fragment as x } from "vue";
import { ElTableColumn as D } from "element-plus";
import { fg as B, y0 as g, i as F, z as A, aV as L } from "../../../../../../../../../shared/runtime.js";
const G = { __name: "project-set-columns", props: { form: { type: Object, default: () => ({}) }, projectClearable: { type: Boolean, default: false } }, setup(j) {
  const s = j, o = I({ list: [] }), { projectTree: d, projectMap: U, monomerMap: E } = B();
  p(() => {
    o.value = s.form;
  });
  const { initScopeList: V, handleValueChange: b, getNotDittoArr: _, getRealVal: R } = g("projectId"), { initScopeList: v, handleValueChange: T, getNotDittoArr: C, getRealVal: O } = g("monomerId");
  n(() => _()), n(() => C());
  const i = n(() => {
    if (F(d.value)) {
      const e = d.value.map((a) => ({ id: a.id, name: a.id !== "common" ? A(a, { showSerialNumber: false }) : "公共库" }));
      return e.unshift({ id: "common", name: "公共库" }), e;
    } else return null;
  });
  p(() => {
    V(o.value.list || []), v(o.value.list || []);
  }), k(i, (e) => {
    e && e.length === 1 && o.value.list[0] && (o.value.list[0].projectId = e[0].id);
  }, { immediate: true });
  function y(e, a, m) {
    b(e, a);
  }
  return (e, a) => {
    const m = N("common-select"), u = D;
    return h(), w(x, null, [c(u, { prop: "projectId", align: "center", "min-width": "170px", label: "所属项目" }, { default: f(({ row: t, $index: l }) => [t ? (h(), M(m, { key: Math.random(), modelValue: t.projectId, "onUpdate:modelValue": (r) => t.projectId = r, options: i.value, dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": l !== 0, clearable: s.projectClearable, "disabled-val": t.disabledProjectId, type: "other", filterable: "", placeholder: "所属项目", onChange: (r) => y(r, l, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "clearable", "disabled-val", "onChange"])) : P("", true)]), _: 1 }), c(u, { prop: "workshopId", label: "车间", width: "170px", align: "center" }, { default: f(({ row: t }) => {
      var l;
      return [c(S(L), { modelValue: t.workshopId, "onUpdate:modelValue": (r) => t.workshopId = r, "factory-id": (l = t.factory) == null ? void 0 : l.id, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue", "factory-id"])];
    }), _: 1 })], 64);
  };
} };
export {
  G as default
};
