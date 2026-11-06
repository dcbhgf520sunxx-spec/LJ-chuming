import { openBlock as s } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withKeys as d } from "vue";
import { ElInput as m } from "element-plus";
import { B as p, C as c } from "../../../../../../shared/runtime.js";
const f = { class: "head-container" }, b = { __name: "header", setup(y) {
  const n = { projectName: void 0, productSerialNumber: void 0 }, { crud: a, query: t } = p(n);
  return (_, r) => {
    const u = m;
    return s(), i("div", f, [l(u, { modelValue: e(t).projectName, "onUpdate:modelValue": r[0] || (r[0] = (o) => e(t).projectName = o), modelModifiers: { trim: true }, placeholder: "项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(u, { modelValue: e(t).productSerialNumber, "onUpdate:modelValue": r[1] || (r[1] = (o) => e(t).productSerialNumber = o), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(c))]);
  };
} };
export {
  b as default
};
