import { c as B } from "../../../../../modules/convert-product-type-fcb585d7.js";
import { q as S } from "../../../../../shared/runtime.js";
import { a as k } from "../../../../../modules/index-8356a01a.js";
import { computed as w } from "vue";
import { ref as l } from "vue";
import { watch as A } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as p } from "vue";
import { unref as y } from "vue";
import { normalizeStyle as _ } from "vue";
const P = { style: { display: "flex" } }, D = { __name: "monomer-select-area-tabs", props: { projectId: { type: [Number, String] }, productType: { type: [Number, String, void 0] }, category: { type: [Number, String, void 0] }, areaType: { type: Number }, needConvert: { type: Boolean, default: false } }, emits: ["change"], setup(i, { expose: T, emit: b }) {
  const g = b, n = i, h = w(() => n.needConvert ? B(n.productType, n.category) : n.productType), f = l(), c = l(), u = l(), m = l(void 0), v = l({}), t = l([]), o = l([]), s = l({});
  A([() => u, () => t.value], (a) => {
    var e;
    a && (t.value.length > 0 ? (o.value = (e = t.value.filter((r) => u.value === r.id)[0]) == null ? void 0 : e.planAreaBatchDTOS, s.value = { id: o.value ? o.value[0].id + "" : "", name: o.value ? o.value[0].name : "" }) : (s.value = {}, o.value = []));
  }, { immediate: true, deep: true });
  function I(a) {
    const { name: e, label: r } = a;
    v.value = { id: e, name: r }, g("change", { monomerId: c.value, areaId: u.value, areaBatchId: m.value, currentArea: v.value });
  }
  function V(a) {
    var e;
    n.areaType ? t.value = a.filter((r) => r.itemizedType === n.areaType) : t.value = a || [], u.value = (e = t.value[0]) == null ? void 0 : e.id;
  }
  function x() {
    var a;
    return ((a = f.value) == null ? void 0 : a.getProductType(c.value)) || {};
  }
  return T({ getProductType: x }), (a, e) => {
    const r = C("common-select");
    return N(), j("div", P, [p(y(S), { ref_key: "monomerRef", ref: f, modelValue: c.value, "onUpdate:modelValue": e[0] || (e[0] = (d) => c.value = d), productType: h.value, "project-id": i.projectId, class: "filter-item", default: false, style: { width: "200px" }, clearable: "", onGetAreaInfo: V }, null, 8, ["modelValue", "productType", "project-id"]), p(r, { modelValue: u.value, "onUpdate:modelValue": e[1] || (e[1] = (d) => u.value = d), options: t.value, type: "other", clearable: "", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" } }, null, 8, ["modelValue", "options"]), p(y(k), { modelValue: m.value, "onUpdate:modelValue": e[2] || (e[2] = (d) => m.value = d), "area-info": o.value, "default-tab": s.value, style: _(t.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: I }, null, 8, ["modelValue", "area-info", "default-tab", "style"])]);
  };
} };
export {
  D as default
};
