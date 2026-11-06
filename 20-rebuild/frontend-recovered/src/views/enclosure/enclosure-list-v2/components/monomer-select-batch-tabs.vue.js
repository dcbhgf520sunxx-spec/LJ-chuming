import { c as g } from "../../../../modules/convert-product-type-fcb585d7.js";
import { q as V, m4 as h } from "../../../../shared/runtime.js";
import { a as x } from "../../../../modules/index-8356a01a.js";
import { computed as A } from "vue";
import { ref as l } from "vue";
import { watchEffect as S } from "vue";
import { openBlock as $ } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as m } from "vue";
import { unref as p } from "vue";
import { normalizeStyle as k } from "vue";
const N = { __name: "monomer-select-batch-tabs", props: { projectId: { type: [Number, String] }, productType: { type: [Number, String, void 0] }, category: { type: [Number, String, void 0] }, needConvert: { type: Boolean, default: false }, query: { type: Object, default: () => {
} } }, emits: ["change"], setup(c, { expose: f, emit: i }) {
  const v = i, n = c, y = A(() => n.needConvert ? g(n.productType, n.category) : n.productType), d = l(), s = l({}), a = l([]), u = l({}), o = l({});
  S(() => {
    o.value = n.query;
  });
  function b(t) {
    const { name: e, label: r } = t;
    s.value = { id: e, name: r }, v("change", { monomerId: o.value.monomerId, areaId: o.value.areaId, currentArea: s });
  }
  function I(t) {
    a.value = t || [], a.value.length > 0 ? u.value = { id: a.value[0].id + "", name: `${a.value[0].name}(${a.value[0].axis})` } : u.value = {}, a.value.forEach((e) => {
      e != null && e.specialAnnotation || (e.name = e.type == h.OUTSOURCE.V ? `${e.name} (外协)` : `${e.name} (自制)`, e.specialAnnotation = true), e.customLabel = `${e.name} ( ${e.axis} )`;
    });
  }
  function T() {
    var t;
    return ((t = d.value) == null ? void 0 : t.getProductType(o.value.monomerId)) || {};
  }
  return f({ getProductType: T }), (t, e) => ($(), j("div", null, [m(p(V), { ref_key: "monomerRef", ref: d, modelValue: o.value.monomerId, "onUpdate:modelValue": e[0] || (e[0] = (r) => o.value.monomerId = r), productType: y.value, "project-id": c.projectId, "show-tips": a.value.length <= 0, class: "filter-item", onGetAreaInfo: I }, null, 8, ["modelValue", "productType", "project-id", "show-tips"]), m(p(x), { modelValue: o.value.areaId, "onUpdate:modelValue": e[1] || (e[1] = (r) => o.value.areaId = r), "area-info": a.value, "default-tab": u.value, style: k(a.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), class: "filter-item", onTabClick: b }, null, 8, ["modelValue", "area-info", "default-tab", "style"])]));
} };
export {
  N as default
};
