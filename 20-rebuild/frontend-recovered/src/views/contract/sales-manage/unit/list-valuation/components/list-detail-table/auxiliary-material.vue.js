import { openBlock as t } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as e } from "vue";
import { Fragment as n } from "vue";
import { ElTableColumn as a } from "element-plus";
import { _ as r } from "../../../../../../../shared/runtime.js";
const i = {};
function c(p, s) {
  const o = a;
  return t(), l(n, null, [e(o, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), e(o, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), e(o, { "show-overflow-tooltip": "", prop: "measureUnit", label: "计量单位", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center" }), e(o, { "show-overflow-tooltip": "", prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "100" })], 64);
}
const w = r(i, [["render", c]]);
export {
  w as default
};
