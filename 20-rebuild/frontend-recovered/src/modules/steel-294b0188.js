import { bl as o, b as c } from "../shared/runtime.js";
import { computed as n } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as B } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as u } from "vue";
import { Fragment as p } from "vue";
const w = { __name: "steel", props: { basicClass: { type: Number }, columns: { type: Object }, showBatchNo: { type: Boolean, default: true }, showBrand: { type: Boolean, default: true }, fixed: { type: String, default: "left" } }, setup(t) {
  const e = t, d = n(() => {
    switch (e.basicClass) {
      case o.STEEL_PLATE.V:
      case o.SECTION_STEEL.V:
        return "炉批号";
      case o.STEEL_COIL.V:
        return "卷号";
      default:
        return "炉批号/卷号";
    }
  }), m = n(() => e.showBrand && (c(e.columns) || e.columns.visible("brand"))), f = n(() => e.showBatchNo && (c(e.columns) || e.columns.visible("heatNoAndBatchNo")));
  function s({ cellValue: a }) {
    return a || "-";
  }
  return (a, N) => {
    const r = h("vxe-column");
    return l(), B(p, null, [m.value ? (l(), i(r, { key: "brand", fixed: t.fixed, formatter: s, align: "left", field: "brand", "min-width": "100px", title: "品牌" }, null, 8, ["fixed"])) : u("", true), f.value ? (l(), i(r, { key: "heatNoAndBatchNo", fixed: t.fixed, formatter: s, title: d.value, align: "left", field: "heatNoAndBatchNo", "min-width": "150px" }, null, 8, ["fixed", "title"])) : u("", true)], 64);
  };
} };
export {
  w as default
};
