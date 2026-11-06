import { ref as I } from "vue";
import { watchEffect as p } from "vue";
import { computed as n } from "vue";
import { watch as k } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as c } from "vue";
import { withCtx as f } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as M } from "vue";
import { unref as V } from "vue";
import { Fragment as x } from "vue";
import { ElTableColumn as D } from "element-plus";
import { fg as B, y0 as g, i as F, z as A, aV as E, hV as L } from "../../../../../../../../../shared/runtime.js";
const W = { __name: "project-set-columns", props: { form: { type: Object, default: () => ({}) }, projectClearable: { type: Boolean, default: false } }, setup(j) {
  const s = j, o = I({ list: [] }), { projectTree: m, projectMap: O, monomerMap: R } = B();
  p(() => {
    o.value = s.form;
  });
  const { initScopeList: b, handleValueChange: _, getNotDittoArr: v, getRealVal: T } = g("projectId"), { initScopeList: C, handleValueChange: U, getNotDittoArr: w, getRealVal: z } = g("monomerId");
  n(() => v()), n(() => w());
  const d = n(() => {
    if (F(m.value)) {
      const e = m.value.map((a) => ({ id: a.id, name: a.id !== "common" ? A(a, { showSerialNumber: false }) : "公共库" }));
      return e.unshift({ id: "common", name: "公共库" }), e;
    } else return null;
  });
  p(() => {
    b(o.value.list || []), C(o.value.list || []);
  }), k(d, (e) => {
    e && e.length === 1 && o.value.list[0] && (o.value.list[0].projectId = e[0].id);
  }, { immediate: true });
  function y(e, a, u) {
    _(e, a);
  }
  return (e, a) => {
    const u = N("common-select"), i = D;
    return h(), P(x, null, [c(i, { prop: "projectId", align: "center", "min-width": "170px", label: "所属项目" }, { default: f(({ row: t, $index: l }) => [t ? (h(), S(u, { key: Math.random(), modelValue: t.projectId, "onUpdate:modelValue": (r) => t.projectId = r, options: d.value, dataStructure: { key: "id", label: "name", value: "id" }, "show-extra": l !== 0, clearable: s.projectClearable, "disabled-val": t.disabledProjectId, type: "other", filterable: "", placeholder: "所属项目", onChange: (r) => y(r, l, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "clearable", "disabled-val", "onChange"])) : M("", true)]), _: 1 }), c(i, { prop: "workshopId", label: "车间", width: "170px", align: "center" }, { default: f(({ row: t }) => [c(V(E), { modelValue: t.workshopId, "onUpdate:modelValue": (l) => t.workshopId = l, type: V(L).WORKSHOP.V, placeholder: "可选择车间", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue", "type"])]), _: 1 })], 64);
  };
} };
export {
  W as default
};
