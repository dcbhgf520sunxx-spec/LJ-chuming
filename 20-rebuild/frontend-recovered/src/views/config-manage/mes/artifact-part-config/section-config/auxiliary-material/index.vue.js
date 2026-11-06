import { _, G as m, fb as d, fc as l, a3 as f, eu as s, f9 as N, i as E } from "../../../../../../shared/runtime.js";
import y from "./module/product-name/index.vue.js";
import { ref as u } from "vue";
import { openBlock as S } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as T } from "vue";
import { unref as a } from "vue";
import "../component/form.vue.js";
const x = { class: "app-container" }, A = { __name: "index", setup(C) {
  const n = u(false), o = u({});
  i();
  async function i() {
    if (m(d.get)) {
      n.value = true;
      try {
        const t = await l.get({ productType: f.AUXILIARY_MATERIAL.V }) || {};
        for (const c in t) t[c].map((e) => {
          var r;
          Number(c) === s.SECTION_TYPE_ENUM.V ? e.typeName = "截面" : e.typeName = N.V[e.productClassificationEnum].SL, e.productSectionNameList = ((r = e.sectionWarehouseConfigDTOList) == null ? void 0 : r.map((p) => p.name)) || [], e.originProductSectionNameList = JSON.parse(JSON.stringify(e.productSectionNameList));
        });
        o.value = t;
      } catch (t) {
        console.log("error", t);
      } finally {
        n.value = false;
      }
    }
  }
  return (t, c) => (S(), g("div", x, [T(a(y), { data: a(E)(o.value[a(s).PRODUCT_NAME.V]) ? o.value[a(s).PRODUCT_NAME.V] : [], onSuccess: i }, null, 8, ["data"])]));
} }, V = _(A, [["__scopeId", "data-v-c2d75769"]]);
export {
  V as default
};
