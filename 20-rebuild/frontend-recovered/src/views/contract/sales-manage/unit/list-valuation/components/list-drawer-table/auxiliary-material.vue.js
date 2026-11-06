import { openBlock as l } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { unref as p } from "vue";
import { Fragment as s } from "vue";
import { ElTableColumn as c } from "element-plus";
import { ky as m } from "../../../../../../../shared/runtime.js";
const b = { __name: "auxiliary-material", setup(w) {
  return (u, h) => {
    const e = c;
    return l(), a(s, null, [o(e, { "show-overflow-tooltip": "", prop: "monomer.name", label: "单体", align: "center", "min-width": "100px" }), o(e, { "show-overflow-tooltip": "", prop: "area.name", label: "区域", align: "center", "min-width": "100px" }), o(e, { "show-overflow-tooltip": "", prop: "useProperty", label: "使用范围", align: "center" }, { default: r(({ row: t }) => [n("span", null, i(t.useProperty ? p(m).VL[t.useProperty] : "-"), 1)]), _: 1 }), o(e, { "show-overflow-tooltip": "", prop: "name", label: "名称", align: "center", "min-width": "100px" }), o(e, { "show-overflow-tooltip": "", prop: "specification", label: "规格", align: "center", "min-width": "140px" }), o(e, { "show-overflow-tooltip": "", prop: "measureUnit", label: "计量单位", align: "center" }), o(e, { "show-overflow-tooltip": "", prop: "quantity", label: "数量", align: "center" }), o(e, { "show-overflow-tooltip": "", prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "100" }), o(e, { "show-overflow-tooltip": "", prop: "mete", label: "核算量", align: "center", "min-width": "100" })], 64);
  };
} };
export {
  b as default
};
