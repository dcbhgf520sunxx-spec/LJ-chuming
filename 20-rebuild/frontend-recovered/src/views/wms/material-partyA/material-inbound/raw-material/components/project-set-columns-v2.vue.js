import { ref as j } from "vue";
import { computed as h } from "vue";
import { watchEffect as c } from "vue";
import { watch as _ } from "vue";
import { openBlock as y } from "vue";
import { createBlock as V } from "vue";
import { withCtx as b } from "vue";
import { createVNode as w } from "vue";
import { ElTableColumn as g } from "element-plus";
import { v5 as v, fg as N, i as n, z as u, fE as O, y0 as x, zy as A } from "../../../../../../shared/runtime.js";
const I = { __name: "project-set-columns-v2", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, list: { type: Array, default: () => ({}) }, form: { type: Object, default: () => ({}) } }, setup(i) {
  const { projectAllType: p } = v(), a = i, o = j({ list: [] });
  N();
  const l = h(() => {
    const r = a.order;
    if (n(r) && n(r.projects)) return r.projects.map((t) => ({ id: t.id, name: u(t, { showSerialNumber: true }) }));
    {
      const t = [];
      return p.value.forEach((e) => {
        (e.level === O.FACTORY.V || e.level === 3) && t.push(e);
      }), t.map((e) => ({ id: e.id, name: u(e, { showSerialNumber: true }) }));
    }
  });
  c(() => {
    o.value = { list: a.list };
  });
  const { initScopeList: d, handleValueChange: P, getNotDittoArr: T, getRealVal: C } = x("projectId");
  return c(() => {
    d(o.value.list || []);
  }), _(l, (r) => {
  }, { immediate: true }), (r, t) => {
    const e = g;
    return y(), V(e, { align: "center", label: "所属项目", "min-width": "170px", prop: "projectId" }, { default: b(({ row: s, $index: m }) => [w(A, { modelValue: s.projectId, "onUpdate:modelValue": (f) => s.projectId = f, "show-extra": m !== 0, defaultOptions: l.value, clearable: "", placeholder: "所属项目", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "defaultOptions"])]), _: 1 });
  };
} };
export {
  I as default
};
