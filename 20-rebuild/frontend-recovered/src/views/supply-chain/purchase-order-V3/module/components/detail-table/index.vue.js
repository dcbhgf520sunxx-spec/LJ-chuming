import { j_ as t } from "../../../../../../shared/runtime.js";
import s from "./module/manufactured.vue.js";
import a from "./module/raw-material.vue.js";
import { computed as r } from "vue";
import { openBlock as o } from "vue";
import { createBlock as m } from "vue";
import { resolveDynamicComponent as n } from "vue";
const h = { __name: "index", props: { materialType: { type: Number }, list: { type: Array, default: () => [] }, maxHeight: { type: Number }, boolUseRequisitions: { type: Boolean, default: false }, level: { type: [String, Number], default: void 0 } }, setup(e) {
  const i = e, l = r(() => {
    switch (i.materialType) {
      case t.MANUFACTURED.V:
        return s;
      case t.STEEL.V:
      case t.MATERIAL.V:
        return a;
      default:
        return a;
    }
  });
  return (u, c) => (o(), m(n(l.value), { list: e.list, maxHeight: e.maxHeight, materialType: e.materialType, "bool-use-requisitions": e.boolUseRequisitions, level: e.level }, null, 8, ["list", "maxHeight", "materialType", "bool-use-requisitions", "level"]));
} };
export {
  h as default
};
