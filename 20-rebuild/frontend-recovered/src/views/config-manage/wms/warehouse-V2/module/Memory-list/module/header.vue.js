import { computed as V } from "vue";
import { ref as _ } from "vue";
import { watch as b } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as C } from "vue";
import { withDirectives as U } from "vue";
import { vShow as g } from "vue";
import { unref as e } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as l } from "vue";
import { withKeys as v } from "vue";
import { Fragment as I } from "vue";
import { ElInput as N } from "element-plus";
import { aS as u, cP as m, B as T, C as x, E as M } from "../../../../../../../shared/runtime.js";
const A = { __name: "header", props: { workshopId: { type: Number, default: void 0 } }, setup(d) {
  const p = d, i = V(() => p.workshopId), c = { name: void 0, enabled: u.TRUE.V, materialType: void 0, workshopId: void 0 }, f = _([m.AUX_MANUFACTURED.K]), { crud: t, query: o } = T(c);
  return b(() => i, (s) => {
    s.value && (o.workshopId = s.value, t.toQuery());
  }, { deep: true, immediate: true }), (s, n) => {
    const h = r("common-radio-button"), w = r("common-select"), y = N;
    return E(), C(I, null, [U(k("div", null, [l(h, { modelValue: e(o).enabled, "onUpdate:modelValue": n[0] || (n[0] = (a) => e(o).enabled = a), options: e(u).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(w, { modelValue: e(o).materialType, "onUpdate:modelValue": n[1] || (n[1] = (a) => e(o).materialType = a), multiple: true, options: e(m).ENUM, unshowOptions: f.value, showExtra: false, class: "filter-item", clearable: "", mode: "bit", placeholder: "材料类型", style: { width: "170px" }, type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), l(y, { modelValue: e(o).name, "onUpdate:modelValue": n[2] || (n[2] = (a) => e(o).name = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入存储位置搜索", size: "default", style: { width: "170px" }, onKeyup: v(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(x))], 512), [[g, e(t).searchToggle]]), l(e(M))], 64);
  };
} };
export {
  A as default
};
