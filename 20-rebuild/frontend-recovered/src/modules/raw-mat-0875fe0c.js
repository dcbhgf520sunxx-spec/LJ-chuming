import { b as s } from "../shared/runtime.js";
import { computed as c } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as i } from "vue";
import { createBlock as l } from "vue";
import { createCommentVNode as u } from "vue";
const x = { __name: "raw-mat", props: { basicClass: { type: Number }, showBrand: { type: Boolean, default: true }, columns: { type: Object }, fixed: { type: String } }, setup(n) {
  const e = n, o = c(() => e.showBrand && (s(e.columns) || e.columns.visible("brand")));
  function r({ cellValue: t }) {
    return t || "-";
  }
  return (t, d) => {
    const a = m("vxe-column");
    return o.value ? (i(), l(a, { key: "brand", fixed: n.fixed, formatter: r, align: "left", field: "brand", "min-width": "100px", title: "品牌" }, null, 8, ["fixed"])) : u("", true);
  };
} };
export {
  x as default
};
