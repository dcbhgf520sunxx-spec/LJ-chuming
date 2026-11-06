import { ref as C } from "vue";
import { watchEffect as p } from "vue";
import { computed as m } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as x } from "vue";
import { withCtx as f } from "vue";
import { createBlock as n } from "vue";
import { unref as k } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as W } from "vue";
import { nextTick as v } from "vue";
import { ElTableColumn as B } from "element-plus";
import { y0 as E, gF as N, fE as S, r9 as T, b as D } from "../../../../../../shared/runtime.js";
const A = { __name: "warehouse-set-columns-v2", props: { boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, list: { type: Array, default: () => [] } }, setup(u) {
  const d = u, h = C({ list: [] });
  p(() => {
    h.value = { list: d.list };
  });
  const { getNotDittoArr: w, initScopeList: V, handleValueChange: b, getRealVal: g } = E("workshopId"), I = m(() => w()), c = m(() => h.value.list || []);
  p(() => V(c.value));
  function _(l, i, a) {
    b(l, i), l !== -1 ? a.warehouseId = void 0 : v(() => {
      D(a.warehouseId) && (a.warehouseId = -1);
    });
  }
  return (l, i) => {
    const a = B;
    return s(), y(W, null, [x(a, { prop: "workshopId", align: "center", "min-width": "140px", label: "仓库" }, { default: f(({ row: e, $index: o }) => [e ? (s(), n(N, { key: 0, modelValue: e.workshopId, "onUpdate:modelValue": (t) => e.workshopId = t, placeholder: "请选择仓库", disabled: d.boolManuf ? e.destination === k(S).CONSTRUCTION_SITE.V : false, "show-extra": o !== 0, onChange: (t) => _(t, o, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "show-extra", "onChange"])) : r("", true)]), _: 1 }), u.showWarehouse ? (s(), n(a, { key: 0, prop: "warehouseId", label: "存储位置", "min-width": "140px", align: "center" }, { default: f(({ row: e, $index: o }) => [e ? (s(), n(T, { key: 0, modelValue: e.warehouseId, "onUpdate:modelValue": (t) => e.warehouseId = t, "workshop-id": k(g)(o), "basic-class": e.basicClass, "show-extra": c.value[o - 1] && !I.value.includes(o), placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra"])) : r("", true)]), _: 1 })) : r("", true)], 64);
  };
} };
export {
  A as default
};
