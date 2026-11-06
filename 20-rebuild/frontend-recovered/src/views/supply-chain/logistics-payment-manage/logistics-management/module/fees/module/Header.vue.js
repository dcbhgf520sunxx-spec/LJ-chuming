import { openBlock as s } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withKeys as m } from "vue";
import { ElInput as p } from "element-plus";
import { B as c, bb as i, C as f } from "../../../../../../../shared/runtime.js";
const j = { __name: "Header", setup(y) {
  const r = { projectId: void 0, name: void 0 }, { query: a, crud: o } = c(r);
  return (_, l) => {
    const d = p;
    return s(), u("div", null, [n(i, { modelValue: e(a).projectId, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).projectId = t), class: "filter-item", clearable: "", style: { width: "300px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(d, { modelValue: e(a).name, "onUpdate:modelValue": l[1] || (l[1] = (t) => e(a).name = t), class: "filter-item", clearable: "", placeholder: "可输入物流公司搜索", size: "default", style: { width: "200px" }, onKeyup: m(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(f))]);
  };
} };
export {
  j as default
};
