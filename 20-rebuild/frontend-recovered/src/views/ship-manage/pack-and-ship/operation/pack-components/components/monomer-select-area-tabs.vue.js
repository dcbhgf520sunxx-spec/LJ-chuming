import { c as x } from "../../../../../../modules/convert-product-type-fcb585d7.js";
import { q as V } from "../../../../../../shared/runtime.js";
import { a as k } from "../../../../../../modules/index-8356a01a.js";
import { computed as h } from "vue";
import { ref as o } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as p } from "vue";
import { unref as i } from "vue";
const C = { style: { display: "flex" } }, _ = { __name: "monomer-select-area-tabs", props: { projectId: { type: [Number, String] }, productType: { type: [Number, String, void 0] }, category: { type: [Number, String, void 0] }, needConvert: { type: Boolean, default: false } }, emits: ["change"], setup(c, { expose: f, emit: v }) {
  const y = v, n = c, g = h(() => n.needConvert ? x(n.productType, n.category) : n.productType), m = o(), l = o(), u = o(), s = o({}), t = o([]), d = o({});
  function b(e) {
    const { name: a, label: r } = e;
    s.value = { id: a, name: r }, y("change", { monomerId: l.value, areaId: u.value, currentArea: s });
  }
  function T(e) {
    t.value = e || [], t.value.length > 0 ? d.value = { id: t.value[0].id + "", name: `${t.value[0].name}(${t.value[0].axis})` } : d.value = {};
  }
  function I() {
    var e;
    return ((e = m.value) == null ? void 0 : e.getProductType(l.value)) || {};
  }
  return f({ getProductType: I }), (e, a) => (j(), A("div", C, [p(i(V), { ref_key: "monomerRef", ref: m, modelValue: l.value, "onUpdate:modelValue": a[0] || (a[0] = (r) => l.value = r), default: true, productType: g.value, "project-id": c.projectId, class: "filter-item", style: { width: "200px" }, onGetAreaInfo: T }, null, 8, ["modelValue", "productType", "project-id"]), p(i(k), { modelValue: u.value, "onUpdate:modelValue": a[1] || (a[1] = (r) => u.value = r), "area-info": t.value, "default-tab": d.value, class: "filter-item", style: { width: "calc(100% - 206px)", marginright: "0px" }, onTabClick: b }, null, 8, ["modelValue", "area-info", "default-tab"])]));
} };
export {
  _ as default
};
