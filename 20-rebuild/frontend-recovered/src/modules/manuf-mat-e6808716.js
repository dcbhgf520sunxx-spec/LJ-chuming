import { b as s } from "../shared/runtime.js";
import { computed as c } from "vue";
import { resolveComponent as a } from "vue";
import { openBlock as i } from "vue";
import { createBlock as l } from "vue";
import { createCommentVNode as u } from "vue";
const x = { __name: "manuf-mat", props: { basicClass: { type: Number }, columns: { type: Object }, fixed: { type: String } }, setup(t) {
  const n = t, o = c(() => s(n.columns) || n.columns.visible("length"));
  function r({ cellValue: e }) {
    return e || "-";
  }
  return (e, f) => {
    const m = a("vxe-column");
    return o.value ? (i(), l(m, { key: "length", fixed: t.fixed, formatter: r, align: "center", field: "length", "min-width": "100px", title: "长度 (mm)" }, null, 8, ["fixed"])) : u("", true);
  };
} };
export {
  x as default
};
