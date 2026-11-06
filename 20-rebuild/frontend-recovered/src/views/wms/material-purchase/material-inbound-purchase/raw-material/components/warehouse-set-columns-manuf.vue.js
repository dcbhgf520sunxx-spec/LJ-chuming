import { ref as x } from "vue";
import { watchEffect as d } from "vue";
import { computed as p } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as h } from "vue";
import { withCtx as i } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as f } from "vue";
import { unref as B } from "vue";
import { Fragment as D } from "vue";
import { nextTick as L } from "vue";
import { ElTableColumn as W } from "element-plus";
import { y0 as F, gF as N, r9 as R, b as S } from "../../../../../../shared/runtime.js";
const E = { __name: "warehouse-set-columns-manuf", props: { parentList: { type: Array, default: () => [] }, boolManuf: { type: Boolean, default: false } }, setup(w) {
  const k = w, n = x([]);
  d(() => {
    n.value = k.parentList;
  });
  const { getNotDittoArr: V, initScopeList: g, handleValueChange: _, getRealVal: b } = F("workshopId"), C = p(() => V()), t = p(() => n.value || []);
  d(() => g(t.value));
  function I(l, u, o) {
    _(l, u), l !== -1 ? o.warehouseId = void 0 : L(() => {
      S(o.warehouseId) && (o.warehouseId = -1);
    });
  }
  return (l, u) => {
    const o = W;
    return r(), y(D, null, [h(o, { prop: "workshopId", align: "center", "min-width": "140px", label: "仓库" }, { default: i(({ row: { sourceRow: e }, $index: a }) => [e ? (r(), m(N, { key: 0, modelValue: e.workshopId, "onUpdate:modelValue": (s) => e.workshopId = s, placeholder: "请选择车间", "show-extra": a !== 0, onChange: (s) => I(s, a, e) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])) : f("", true)]), _: 1 }), h(o, { prop: "warehouseId", label: "存储位置", "min-width": "140px", align: "center" }, { default: i(({ row: { sourceRow: e }, $index: a }) => {
      var s, c;
      return [e ? (r(), m(R, { key: 0, modelValue: e.warehouseId, "onUpdate:modelValue": (v) => e.warehouseId = v, "workshop-id": B(b)(a), "basic-class": e.basicClass, "show-extra": t.value[a - 1] && ((s = t.value[a]) == null ? void 0 : s.basicClass) === ((c = t.value[a - 1]) == null ? void 0 : c.basicClass) && !C.value.includes(a), placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra"])) : f("", true)];
    }), _: 1 })], 64);
  };
} };
export {
  E as default
};
