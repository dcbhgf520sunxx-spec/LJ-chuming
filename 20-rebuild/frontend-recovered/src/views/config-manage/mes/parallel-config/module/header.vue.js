import { ref as c } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as y } from "vue";
import { vShow as V } from "vue";
import { unref as l } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as r } from "vue";
import { ElInput as b } from "element-plus";
import { g as k } from "../../../../../modules/parallel-config-554d8028.js";
import { B as _, C as w, E as x } from "../../../../../shared/runtime.js";
const E = { __name: "header", setup(C) {
  const d = { serialNumber: void 0, specification: void 0 }, { crud: s, query: a } = _(d), n = c([]), u = c([]);
  p();
  async function p() {
    n.value = [], u.value = [];
    try {
      const t = await k();
      for (let e = 0; e < t.material.length; e++) n.value.push({ value: t.material[e] });
      for (let e = 0; e < t.thick.length; e++) u.value.push({ value: t.thick[e] });
    } catch (t) {
      console.log("获取厚度材质筛选", t);
    }
  }
  return (t, e) => {
    const i = b, m = f("common-select");
    return v(), h("div", null, [y(g("div", null, [r(i, { modelValue: l(a).serialNumber, "onUpdate:modelValue": e[0] || (e[0] = (o) => l(a).serialNumber = o), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(i, { modelValue: l(a).specification, "onUpdate:modelValue": e[1] || (e[1] = (o) => l(a).specification = o), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), r(m, { modelValue: l(a).thick, "onUpdate:modelValue": e[2] || (e[2] = (o) => l(a).thick = o), options: u.value, type: "other", clearable: "", "data-structure": { key: "value", label: "value", value: "value" }, class: "filter-item", style: { width: "200px" }, placeholder: "请选择厚度", onChange: l(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(m, { modelValue: l(a).material, "onUpdate:modelValue": e[3] || (e[3] = (o) => l(a).material = o), options: n.value, type: "other", clearable: "", "data-structure": { key: "value", label: "value", value: "value" }, class: "filter-item", style: { width: "200px" }, placeholder: "请选择材质", onChange: l(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(l(w))], 512), [[V, l(s).searchToggle]]), r(l(x))]);
  };
} };
export {
  E as default
};
