import n from "./produce-form.vue.js";
import { _ as c } from "../../../../../../shared/runtime.js";
import { ref as u } from "vue";
import { watchEffect as l } from "vue";
import { computed as s } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as f } from "vue";
import { renderSlot as i } from "vue";
import { createBlock as d } from "vue";
import { resolveDynamicComponent as p } from "vue";
import { Fragment as _ } from "vue";
const y = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object }, currentRow: { type: Object, default: () => ({}) }, maxHeight: { type: Number, default: 100 } }, setup(e) {
  const r = e, t = u({ outboundTypeSelection: void 0 });
  l(async () => {
    t.value = r.form;
  });
  const a = s(() => {
    switch (t.value.outboundTypeSelection) {
      default:
        return n;
    }
  });
  return (m, v) => (o(), f(_, null, [i(m.$slots, "extra", {}, void 0, true), (o(), d(p(a.value), { form: t.value, material: e.material, currentRow: e.currentRow, maxHeight: e.maxHeight }, null, 8, ["form", "material", "currentRow", "maxHeight"]))], 64));
} }, b = c(y, [["__scopeId", "data-v-92418e5d"]]);
export {
  b as default
};
