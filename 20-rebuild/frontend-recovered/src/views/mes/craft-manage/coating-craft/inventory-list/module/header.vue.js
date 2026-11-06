import { m as p, B as I, q as y } from "../../../../../../shared/runtime.js";
import { ref as s } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
const V = { class: "head-container" }, k = { __name: "header", setup(j) {
  const { globalProjectId: r } = p(["globalProjectId"]), c = s(), d = s([]), u = { projectId: { value: void 0, resetAble: false }, monomerId: void 0, areaId: void 0 }, { crud: n, query: o } = I(u);
  _(() => r, (t) => {
    t && (n.query.projectId = r);
  }, { immediate: true, deep: true });
  function i(t) {
    d.value = t || [];
  }
  return (t, a) => {
    const f = h("common-select");
    return g(), b("div", V, [m(e(y), { ref_key: "monomerSelectRef", ref: c, modelValue: e(o).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).monomerId = l), "project-id": e(r), default: false, clearable: "", class: "filter-item", style: { width: "180px" }, onChange: e(n).toQuery, onGetAreaInfo: i }, null, 8, ["modelValue", "project-id", "onChange"]), m(f, { modelValue: e(o).areaId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(o).areaId = l), options: d.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "180px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"])]);
  };
} };
export {
  k as default
};
