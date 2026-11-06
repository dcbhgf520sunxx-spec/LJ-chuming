import { inject as p } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withKeys as y } from "vue";
import { ElInput as f } from "element-plus";
import { B as _, C as b } from "../../../../../../shared/runtime.js";
const v = { __name: "header", setup(C) {
  const n = { productClassId: void 0, productSerialNumber: void 0 }, s = p("artifactTypeList"), { crud: r, query: t } = _(n);
  return (V, o) => {
    const u = c("common-select-v2"), d = f;
    return m(), i("div", null, [l(u, { modelValue: e(t).productClassId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).productClassId = a), options: e(s), placeholder: "选择构件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, clearable: "", filterable: "", class: "filter-item", style: { width: "150px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(d, { modelValue: e(t).productSerialNumber, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).productSerialNumber = a), modelModifiers: { trim: true }, clearable: "", placeholder: "编号搜索", class: "filter-item", style: { width: "150px" }, onKeyup: y(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(e(b))]);
  };
} };
export {
  v as default
};
