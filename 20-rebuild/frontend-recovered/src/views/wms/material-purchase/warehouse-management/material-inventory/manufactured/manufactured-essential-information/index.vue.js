import { cP as a } from "../../../../../../../shared/runtime.js";
import t from "./module/enclosure.vue.js";
import r from "./module/structure.vue.js";
import { computed as m } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { mergeProps as u } from "vue";
import { resolveDynamicComponent as i } from "vue";
const U = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object } }, setup(s) {
  const c = s, e = m(() => {
    switch (c.basicClass) {
      case a.STRUC_MANUFACTURED.V:
        return r;
      case a.ENCL_MANUFACTURED.V:
        return t;
      default:
        return null;
    }
  });
  return (o, p) => (n(), l(i(e.value), u({ "basic-class": s.basicClass, columns: s.columns }, o.$attrs), null, 16, ["basic-class", "columns"]));
} };
export {
  U as default
};
