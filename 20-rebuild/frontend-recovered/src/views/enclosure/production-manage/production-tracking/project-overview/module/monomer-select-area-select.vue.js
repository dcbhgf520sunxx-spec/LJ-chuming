import { c as S } from "../../../../../../modules/convert-product-type-fcb585d7.js";
import { _ as T, q as h } from "../../../../../../shared/runtime.js";
import { computed as B } from "vue";
import { ref as u } from "vue";
import { watch as f } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as p } from "vue";
import { unref as x } from "vue";
import { renderSlot as V } from "vue";
const N = { style: { display: "inline-block" } }, k = { __name: "monomer-select-area-select", props: { monomerId: { type: [Number, String, void 0] }, areaId: { type: [Number, String, Array, void 0] }, projectId: { type: [Number, String, void 0] }, productType: { type: [Number, String, void 0] }, category: { type: [Number, String, void 0] }, needConvert: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, areaClearable: { type: Boolean, default: false }, monomerDefault: { type: Boolean, default: true }, areaDefault: { type: Boolean, default: false }, monomerDisabled: { type: Boolean, default: false }, areaDisabled: { type: Boolean, default: false }, filterArea: { type: Boolean, default: true }, areaMultiple: { type: Boolean, default: false } }, emits: ["change", "update:monomerId", "update:areaId", "monomerChange", "areaChange"], setup(a, { expose: y, emit: v }) {
  const o = v, t = a, i = B(() => t.needConvert ? S(t.productType, t.category) : t.productType), s = u(), l = u(), r = u(), n = u([]);
  f(() => t.monomerId, (e) => {
    l.value = e;
  }, { immediate: true }), f(() => t.areaId, (e) => {
    r.value = e;
  }, { immediate: true });
  function b(e) {
    o("update:areaId", r.value), o("areaChange", e), o("change", { monomerId: l.value, areaId: r.value, areaList: n.value });
  }
  function g(e, d) {
    t.filterArea && (n.value = e && e.filter((m) => m.productType & i.value)), n.value = e || [], o("update:monomerId", d), o("monomerChange", n.value), o("change", { monomerId: l.value, areaId: r.value, areaList: n.value });
  }
  function I() {
    var e;
    return ((e = s.value) == null ? void 0 : e.getProductType(l.value)) || {};
  }
  return y({ getProductType: I }), (e, d) => {
    const m = C("common-select");
    return D(), A("div", N, [p(x(h), { ref_key: "monomerRef", ref: s, modelValue: l.value, "onUpdate:modelValue": d[0] || (d[0] = (c) => l.value = c), clearable: a.clearable, default: a.monomerDefault, disabled: a.monomerDisabled, filterArea: false, "plan-product-category-enum": 4, productType: i.value, "project-id": a.projectId, class: "filter-item", onGetAreaInfo: g }, null, 8, ["modelValue", "clearable", "default", "disabled", "productType", "project-id"]), V(e.$slots, "middle", {}, void 0, true), p(m, { modelValue: r.value, "onUpdate:modelValue": d[1] || (d[1] = (c) => r.value = c), clearable: a.areaClearable, dataStructure: { key: "id", label: "name", value: "id" }, default: a.areaDefault, disabled: a.areaDisabled, multiple: a.areaMultiple, noDataText: l.value ? "暂无数据" : "未选择单体", options: n.value, class: "filter-item", placeholder: "请选择区域", size: "default", style: { width: "200px" }, onChange: b }, null, 8, ["modelValue", "clearable", "default", "disabled", "multiple", "noDataText", "options"])]);
  };
} }, w = T(k, [["__scopeId", "data-v-8a724d99"]]);
export {
  w as default
};
