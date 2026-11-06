import { _, G as d, fb as f, fc as N, a3 as E, eu as o, f9 as T, i } from "../../../../../../shared/runtime.js";
import y from "./module/product-name/index.vue.js";
import S from "./module/type-name/index.vue.js";
import C from "./module/section-name/index.vue.js";
import { ref as l } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import "../component/form.vue.js";
const O = { class: "app-container" }, V = { __name: "index", setup(x) {
  const u = l(false), a = l({});
  n();
  async function n() {
    if (d(f.get)) {
      u.value = true;
      try {
        const s = await N.get({ productType: E.ARTIFACT.V }) || {};
        for (const c in s) s[c].map((t) => {
          var p;
          Number(c) === o.SECTION_TYPE_ENUM.V ? t.typeName = "截面" : t.typeName = T.VL[t.productClassificationEnum], t.productSectionNameList = ((p = t.sectionWarehouseConfigDTOList) == null ? void 0 : p.map((m) => m.name)) || [], t.originProductSectionNameList = JSON.parse(JSON.stringify(t.productSectionNameList));
        });
        a.value = s;
      } catch (s) {
        console.log("error", s);
      } finally {
        u.value = false;
      }
    }
  }
  return (s, c) => (P(), g("div", O, [r(e(y), { data: e(i)(a.value[e(o).PRODUCT_NAME.V]) ? a.value[e(o).PRODUCT_NAME.V] : [], onSuccess: n }, null, 8, ["data"]), r(e(S), { data: e(i)(a.value[e(o).PRODUCT_TYPE_ENUM.V]) ? a.value[e(o).PRODUCT_TYPE_ENUM.V] : [], style: { "margin-top": "20px" }, onSuccess: n }, null, 8, ["data"]), r(e(C), { data: e(i)(a.value[e(o).SECTION_TYPE_ENUM.V]) ? a.value[e(o).SECTION_TYPE_ENUM.V] : [], style: { "margin-top": "20px" }, onSuccess: n }, null, 8, ["data"])]));
} }, I = _(V, [["__scopeId", "data-v-d4279910"]]);
export {
  I as default
};
