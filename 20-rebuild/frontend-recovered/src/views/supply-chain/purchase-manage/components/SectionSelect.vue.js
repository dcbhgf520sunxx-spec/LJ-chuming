import { mergeModels as u } from "vue";
import { useModel as d } from "vue";
import { computed as C } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as v } from "vue";
import { createBlock as p } from "vue";
import { mergeProps as S } from "vue";
import { resolveDynamicComponent as V } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as x } from "vue";
import { ElButton as k } from "element-plus";
import { _, uL as B } from "../../../../shared/runtime.js";
const M = { class: "section-select" }, D = { __name: "SectionSelect", props: u(["data", "searchTypeList", "currentComponent"], { searchType: { default: "suppliers", type: String }, searchTypeModifiers: {}, selected: {}, selectedModifiers: {} }), emits: u(["search", "change", "typeChange"], ["update:searchType", "update:selected"]), setup(t, { emit: m }) {
  const r = t, s = m, a = d(t, "searchType"), c = d(t, "selected");
  function i() {
    c.value = void 0, s("typeChange");
  }
  const y = C(() => {
    var e;
    const n = {};
    return (e = r.currentComponent) != null && e.useInternalData || (n.options = r.data), n;
  });
  function f(n) {
    s("change", n);
  }
  return (n, e) => {
    const h = k;
    return l(), g("section", M, [v(B, { modelValue: a.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value = o), "data-structure": { label: "name", value: "value" }, options: t.searchTypeList, class: "left", style: { width: "130px", "margin-bottom": "8px" }, onChange: i }, null, 8, ["modelValue", "options"]), (l(), p(V(t.currentComponent.component), S({ key: a.value, modelValue: c.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => c.value = o), dataStructure: t.currentComponent.dataStructure, placeholder: t.currentComponent.placeholder, style: t.currentComponent.style, type: t.currentComponent.type || "other", class: "right", clearable: "", filterable: "" }, y.value, { onChange: f }), null, 16, ["modelValue", "dataStructure", "placeholder", "style", "type"])), a.value === "contract" ? (l(), p(h, { key: 0, class: "btn", icon: "el-icon-search", size: "default", type: "success", onClick: e[2] || (e[2] = (o) => s("search")) }, { default: b(() => e[3] || (e[3] = [T(" 搜索 ")])), _: 1, __: [3] })) : x("", true)]);
  };
} }, w = _(D, [["__scopeId", "data-v-bc88fd9f"]]);
export {
  w as default
};
