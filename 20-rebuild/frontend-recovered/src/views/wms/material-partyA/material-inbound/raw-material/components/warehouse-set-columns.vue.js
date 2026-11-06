import { ref as v } from "vue";
import { watchEffect as m } from "vue";
import { computed as f } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as W } from "vue";
import { createVNode as x } from "vue";
import { withCtx as w } from "vue";
import { createBlock as n } from "vue";
import { unref as k } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as B } from "vue";
import { nextTick as E } from "vue";
import { ElTableColumn as N } from "element-plus";
import { y0 as S, gF as T, fE as D, r9 as R, b as U } from "../../../../../../shared/runtime.js";
const O = { __name: "warehouse-set-columns", props: { form: { type: Object, default: () => ({}) }, boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true } }, setup(c) {
  const d = c, h = v({ list: [] });
  m(() => {
    h.value = d.form;
  });
  const { getNotDittoArr: b, initScopeList: V, handleValueChange: g, getRealVal: C } = S("workshopId"), I = f(() => b()), t = f(() => h.value.list || []);
  m(() => V(t.value));
  function _(r, i, o) {
    g(r, i), r !== -1 ? o.warehouseId = void 0 : E(() => {
      U(o.warehouseId) && (o.warehouseId = -1);
    });
  }
  return (r, i) => {
    const o = N;
    return l(), W(B, null, [x(o, { prop: "workshopId", align: "center", "min-width": "140px", label: "仓库" }, { default: w(({ row: { sourceRow: e }, $index: a }) => [e ? (l(), n(T, { key: 0, modelValue: e.workshopId, "onUpdate:modelValue": (s) => e.workshopId = s, placeholder: "请选择仓库", disabled: d.boolManuf ? e.destination === k(D).CONSTRUCTION_SITE.V : false, "show-extra": a !== 0, onChange: (s) => _(s, a, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra", "onChange"])) : u("", true)]), _: 1 }), c.showWarehouse ? (l(), n(o, { key: 0, prop: "warehouseId", label: "存储位置", "min-width": "140px", align: "center" }, { default: w(({ row: { sourceRow: e }, $index: a }) => {
      var s, p;
      return [e ? (l(), n(R, { key: 0, modelValue: e.warehouseId, "onUpdate:modelValue": (y) => e.warehouseId = y, "workshop-id": k(C)(a), "basic-class": e.basicClass, "show-extra": t.value[a - 1] && ((s = t.value[a]) == null ? void 0 : s.basicClass) === ((p = t.value[a - 1]) == null ? void 0 : p.basicClass) && !I.value.includes(a), placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra"])) : u("", true)];
    }), _: 1 })) : u("", true)], 64);
  };
} };
export {
  O as default
};
