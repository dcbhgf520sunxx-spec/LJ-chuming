import { ref as i } from "vue";
import { watch as C } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as S } from "vue";
import { withDirectives as f } from "vue";
import { vShow as E } from "vue";
import { unref as e } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as d } from "vue";
import { createBlock as b } from "vue";
import { withCtx as w } from "vue";
import { createTextVNode as B } from "vue";
import { d as x } from "../../../../../modules/machine-part-99f84d79.js";
import { tw as k, B as A, T as U, q as N, oW as P, L as R } from "../../../../../shared/runtime.js";
const j = { style: { display: "flex" } }, D = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(y) {
  const h = { monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, permissionCheck: k.CHECK_PERMISSION.V, relationType: void 0, steelPlateTypeEnum: void 0, areaBatchId: void 0 }, v = i(), n = i([]), m = i([]), { crud: t, query: o } = A(h), g = y;
  C([() => o.areaId, () => n.value], (r) => {
    var a;
    r && (m.value = (a = n.value.filter((s) => s.id + "" == o.areaId + "")[0]) == null ? void 0 : a.planAreaBatchDTOS);
  }, { immediate: true, deep: true });
  function I(r) {
    n.value = r.filter((a) => a.itemizedType === 1) || [];
  }
  return (r, a) => {
    const s = p("common-select"), V = p("common-radio-button"), T = _("permission");
    return c(), S("div", null, [f(u("div", null, [u("div", j, [d(e(N), { ref_key: "monomerSelectRef", ref: v, modelValue: e(o).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).monomerId = l), "project-id": g.projectId, productType: e(U).STRUCTURE.V, default: false, clearable: "", class: "filter-item", onChange: e(t).toQuery, onGetAreaInfo: I }, null, 8, ["modelValue", "project-id", "productType", "onChange"]), d(s, { modelValue: e(o).areaId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(o).areaId = l), options: n.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), d(s, { modelValue: e(o).areaBatchId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(o).areaBatchId = l), options: m.value, dataStructure: { key: "id", label: "name", value: "id" }, size: "default", type: "other", placeholder: "请选择批次号", style: { width: "170px", "margin-right": "6px" }, onChange: e(t).toQuery, clearable: "" }, null, 8, ["modelValue", "options", "onChange"])]), u("div", null, [d(V, { modelValue: e(o).steelPlateTypeEnum, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(o).steelPlateTypeEnum = l), options: e(P).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), f((c(), b(R, { fn: e(x), params: e(t).query, class: "filter-item" }, { default: w(() => a[4] || (a[4] = [B(" 零件汇总 ")])), _: 1, __: [4] }, 8, ["fn", "params"])), [[T, e(t).permission.get]])])], 512), [[E, e(t).searchToggle]])]);
  };
} };
export {
  D as default
};
