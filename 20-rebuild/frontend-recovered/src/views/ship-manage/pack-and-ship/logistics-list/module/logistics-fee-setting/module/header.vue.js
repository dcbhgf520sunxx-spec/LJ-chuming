import { openBlock as s } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withKeys as m } from "vue";
import { ElInput as p } from "element-plus";
import { B as c, bb as i, C as f } from "../../../../../../../shared/runtime.js";
const h = { __name: "header", setup(y) {
  const r = { projectId: void 0, name: void 0 }, { crud: o, query: a } = c(r);
  return (_, l) => {
    const d = p;
    return s(), u("div", null, [n(i, { modelValue: e(a).projectId, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).projectId = t), class: "filter-item", style: { width: "300px" }, clearable: "", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(d, { modelValue: e(a).name, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).name = t), placeholder: "可输入物流公司搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: m(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(f))]);
  };
} };
export {
  h as default
};
