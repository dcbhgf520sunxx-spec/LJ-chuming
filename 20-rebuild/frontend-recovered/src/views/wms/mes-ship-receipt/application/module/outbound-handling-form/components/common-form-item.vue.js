import c from "./produce-form.vue.js";
import { _ as n } from "../../../../../../../shared/runtime.js";
import { ref as u } from "vue";
import { watchEffect as l } from "vue";
import { computed as s } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as i } from "vue";
import { renderSlot as f } from "vue";
import { createBlock as d } from "vue";
import { resolveDynamicComponent as p } from "vue";
const _ = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object }, currentRow: { type: Object, default: () => ({}) }, maxHeight: { type: Number, default: 100 } }, setup(e) {
  const r = e, t = u({ outboundTypeSelection: void 0 });
  l(async () => {
    t.value = r.form;
  });
  const a = s(() => {
    switch (t.value.outboundTypeSelection) {
      default:
        return c;
    }
  });
  return (m, v) => (o(), i("div", null, [f(m.$slots, "extra", {}, void 0, true), (o(), d(p(a.value), { form: t.value, material: e.material, currentRow: e.currentRow, maxHeight: e.maxHeight }, null, 8, ["form", "material", "currentRow", "maxHeight"]))]));
} }, b = n(_, [["__scopeId", "data-v-6271e121"]]);
export {
  b as default
};
