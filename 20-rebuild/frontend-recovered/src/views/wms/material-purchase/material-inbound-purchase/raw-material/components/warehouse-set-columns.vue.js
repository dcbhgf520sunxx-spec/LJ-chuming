import { ref as v } from "vue";
import { watchEffect as m } from "vue";
import { computed as f } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as W } from "vue";
import { withCtx as b } from "vue";
import { createBlock as u } from "vue";
import { unref as w } from "vue";
import { createCommentVNode as d } from "vue";
import { Fragment as x } from "vue";
import { nextTick as E } from "vue";
import { ElTableColumn as N } from "element-plus";
import { y0 as S, gF as T, fE as D, r9 as R, b as U } from "../../../../../../shared/runtime.js";
const O = { __name: "warehouse-set-columns", props: { form: { type: Object, default: () => ({}) }, boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, disabled: { type: Boolean, default: false } }, setup(l) {
  const c = l, i = v({ list: [] });
  m(() => {
    i.value = c.form;
  });
  const { getNotDittoArr: k, initScopeList: V, handleValueChange: g, getRealVal: C } = S("workshopId"), I = f(() => k()), t = f(() => i.value.list || []);
  m(() => V(t.value));
  function y(r, h, o) {
    g(r, h), r !== -1 ? o.warehouseId = void 0 : E(() => {
      U(o.warehouseId) && (o.warehouseId = -1);
    });
  }
  return (r, h) => {
    const o = N;
    return n(), B(x, null, [W(o, { prop: "workshopId", align: "center", "min-width": "140px", label: "仓库" }, { default: b(({ row: { sourceRow: e }, $index: a }) => [e ? (n(), u(T, { key: 0, modelValue: e.workshopId, "onUpdate:modelValue": (s) => e.workshopId = s, placeholder: "请选择仓库", disabled: (c.boolManuf ? e.destination === w(D).CONSTRUCTION_SITE.V : false) || l.disabled, "show-extra": a !== 0, onChange: (s) => y(s, a, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra", "onChange"])) : d("", true)]), _: 1 }), l.showWarehouse ? (n(), u(o, { key: 0, prop: "warehouseId", label: "存储位置", "min-width": "140px", align: "center" }, { default: b(({ row: { sourceRow: e }, $index: a }) => {
      var s, p;
      return [e ? (n(), u(R, { key: 0, modelValue: e.warehouseId, "onUpdate:modelValue": (_) => e.warehouseId = _, "workshop-id": w(C)(a), "basic-class": e.basicClass, "show-extra": t.value[a - 1] && ((s = t.value[a]) == null ? void 0 : s.basicClass) === ((p = t.value[a - 1]) == null ? void 0 : p.basicClass) && !I.value.includes(a), disabled: l.disabled, placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra", "disabled"])) : d("", true)];
    }), _: 1 })) : d("", true)], 64);
  };
} };
export {
  O as default
};
