import { openBlock as t } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as e } from "vue";
import { Fragment as n } from "vue";
import { ElTableColumn as r } from "element-plus";
import { _ as a } from "../../../../../../../shared/runtime.js";
const i = {};
function p(c, s) {
  const o = r;
  return t(), l(n, null, [e(o, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "serialNumber", label: "编号", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), e(o, { "show-overflow-tooltip": "", prop: "length", label: "长度(mm)", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "material", label: "材质", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center", "min-width": "100px" })], 64);
}
const f = a(i, [["render", p]]);
export {
  f as default
};
