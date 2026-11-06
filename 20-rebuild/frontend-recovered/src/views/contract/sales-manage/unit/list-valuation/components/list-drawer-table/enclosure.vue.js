import { openBlock as t } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as e } from "vue";
import { Fragment as n } from "vue";
import { ElTableColumn as i } from "element-plus";
import { _ as r } from "../../../../../../../shared/runtime.js";
const a = {};
function p(c, w) {
  const o = i;
  return t(), l(n, null, [e(o, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "serialNumber", label: "编号", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), e(o, { "show-overflow-tooltip": "", prop: "length", label: "单长(mm)", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "totalLength", label: "总长(m)", align: "center", "min-width": "110" }), e(o, { "show-overflow-tooltip": "", prop: "weight", label: "单重(kg)", align: "center", "min-width": "110" }), e(o, { "show-overflow-tooltip": "", prop: "totalWeight", label: "总重(kg)", align: "center", "min-width": "110" })], 64);
}
const h = r(a, [["render", p]]);
export {
  h as default
};
