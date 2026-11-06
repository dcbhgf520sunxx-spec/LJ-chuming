import { _ as y, xX as b, cP as w } from "../../../../../../../shared/runtime.js";
import { ref as g } from "vue";
import { computed as v } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as C } from "vue";
import { createBlock as I } from "vue";
import { withCtx as S } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as V } from "vue";
import { withDirectives as x } from "vue";
import { unref as p } from "vue";
const A = { class: "customize-option-item" }, z = { class: "label" }, D = { class: "extra-label" }, N = { __name: "warehouse-select", props: { modelValue: { type: [Array, Number, String] }, workshopId: { type: [Array, Number] }, dataStructure: { type: Object, default: () => ({ value: "name", label: "name", key: "id" }) }, showAll: { type: Boolean, default: false }, showForbidden: { type: Boolean, default: false }, basicClass: { type: Number }, viewsDetail: { type: Boolean, default: false }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择存储位置" } }, emits: ["change", "update:modelValue", "infoChange"], setup(l, { emit: m }) {
  const d = m, t = l, i = g(), { loaded: f, warehouseV2: h } = b(), n = v(() => {
    let e = h.value;
    return t.workshopId ? Array.isArray(t.workshopId) ? e = e.filter((a) => t.workshopId.includes(a.workshopId)) : e = e.filter((a) => t.workshopId === a.workshopId) : e = t.showAll ? e : [], t.basicClass && (e = e.filter((a) => a.materialType & t.basicClass)), e;
  });
  _([() => n.value, () => t.modelValue], ([e, a]) => {
    a && (e != null && e.length) && (i.value = a, c(a));
  }, { immediate: true });
  function c(e) {
    var r, u;
    if (((r = n.value) == null ? void 0 : r.length) === 0) return;
    const a = (u = n.value.find((s) => s.name === e)) == null ? void 0 : u.id;
    d("change", a), d("update:modelValue", e);
  }
  return (e, a) => {
    const r = B("common-select"), u = k("parse-enum");
    return C(), I(r, { modelValue: i.value, "onUpdate:modelValue": a[0] || (a[0] = (s) => i.value = s), clearable: l.clearable, "collapse-tags": l.collapseTags, "data-structure": l.dataStructure, disabled: l.disabled, loading: !p(f), multiple: l.multiple, options: n.value, placeholder: l.placeholder, size: l.size, filterable: "", onChange: c }, { view: S(({ data: s }) => [o("span", A, [o("span", z, V(s.name), 1), o("span", null, [o("span", D, [a[1] || (a[1] = o("span", { class: "title" }, "存储类型：", -1)), x(o("span", null, null, 512), [[u, { e: p(w), v: s.materialType, bit: true, split: " | " }]])])])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "data-structure", "disabled", "loading", "multiple", "options", "placeholder", "size"]);
  };
} }, j = y(N, [["__scopeId", "data-v-75847206"]]);
export {
  j as default
};
