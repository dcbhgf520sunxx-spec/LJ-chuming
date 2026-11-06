import { c as h } from "./convert-product-type-fcb585d7.js";
import { q as x } from "../shared/runtime.js";
import { a as V } from "./index-8356a01a.js";
import { computed as N } from "vue";
import { ref as o } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as s } from "vue";
import { unref as i } from "vue";
import { normalizeStyle as P } from "vue";
const $ = { __name: "monomer-select-area-tabs", props: { projectId: { type: [Number, String] }, productType: { type: [Number, String, void 0] }, areaType: { type: Number }, category: { type: [Number, String, void 0] }, needConvert: { type: Boolean, default: false }, mainProductType: { type: [Number, String], default: void 0 } }, emits: ["change"], setup(u, { expose: f, emit: v }) {
  const y = v, n = u, b = N(() => n.needConvert ? h(n.productType, n.category) : n.productType), d = o(), l = o(), c = o(), p = o({}), a = o([]), m = o({});
  function T(t) {
    const { name: e, label: r } = t;
    p.value = { id: e, name: r }, y("change", { monomerId: l.value, areaId: c.value, currentArea: p });
  }
  function g(t) {
    a.value = t || [], a.value.length > 0 ? m.value = { id: a.value[0].id + "", name: `${a.value[0].name}(${a.value[0].axis})` } : m.value = {}, a.value.forEach((e) => {
      e.customLabel = `${e.name} ( ${e.axis} )`;
    });
  }
  function I() {
    var t;
    return ((t = d.value) == null ? void 0 : t.getProductType(l.value)) || {};
  }
  return f({ getProductType: I }), (t, e) => (S(), k("div", null, [s(i(x), { ref_key: "monomerRef", ref: d, modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => l.value = r), "main-product-type": u.mainProductType, productType: b.value, "project-id": u.projectId, "show-tips": a.value.length <= 0, class: "filter-item", onGetAreaInfo: g }, null, 8, ["modelValue", "main-product-type", "productType", "project-id", "show-tips"]), s(i(V), { modelValue: c.value, "onUpdate:modelValue": e[1] || (e[1] = (r) => c.value = r), "area-info": a.value, "default-tab": m.value, style: P(a.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), class: "filter-item", onTabClick: T }, null, 8, ["modelValue", "area-info", "default-tab", "style"])]));
} };
export {
  $ as _
};
