import { bl as t } from "../../../../../../../shared/runtime.js";
import s from "./module/raw-mat.vue.js";
import { computed as n } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { mergeProps as c } from "vue";
import { resolveDynamicComponent as r } from "vue";
const y = { __name: "index", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, showMete: { type: Boolean, default: true }, outboundTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" } }, setup(a) {
  const e = a, o = n(() => {
    switch (e.basicClass) {
      case t.STEEL_PLATE.V:
      case t.SECTION_STEEL.V:
      case t.STEEL_COIL.V:
      case t.MATERIAL.V:
      case t.GAS.V:
        return s;
      default:
        return s;
    }
  });
  return (l, m) => (i(), u(r(o.value), c(l.$attrs, { columns: e.columns, "basic-class": e.basicClass, showUnit: e.showUnit, showMete: e.showMete, "outbound-type-mode": a.outboundTypeMode, "label-prefix": e.labelPrefix, "quantity-field": a.quantityField, "mete-field": a.meteField }), null, 16, ["columns", "basic-class", "showUnit", "showMete", "outbound-type-mode", "label-prefix", "quantity-field", "mete-field"]));
} };
export {
  y as default
};
