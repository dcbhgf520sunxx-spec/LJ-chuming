import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withKeys as d } from "vue";
import { ElInput as p } from "element-plus";
import { _ as m, B as i, C as _ } from "../../../../../../../shared/runtime.js";
const f = { class: "search" }, y = { __name: "header", setup(b) {
  const u = { projectName: void 0, productSerialNumber: void 0 }, { crud: l, query: t } = i(u);
  return (N, r) => {
    const s = p;
    return n(), c("div", f, [a(s, { modelValue: e(t).projectName, "onUpdate:modelValue": r[0] || (r[0] = (o) => e(t).projectName = o), modelModifiers: { trim: true }, placeholder: "项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(s, { modelValue: e(t).productSerialNumber, "onUpdate:modelValue": r[1] || (r[1] = (o) => e(t).productSerialNumber = o), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(e(_))]);
  };
} }, x = m(y, [["__scopeId", "data-v-c64bb857"]]);
export {
  x as default
};
