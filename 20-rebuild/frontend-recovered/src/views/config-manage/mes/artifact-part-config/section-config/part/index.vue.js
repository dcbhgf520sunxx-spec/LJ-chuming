import { _ as f, G as d, fb as N, fc as E, a3 as T, eu as o, f9 as u, i as _ } from "../../../../../../shared/runtime.js";
import S from "./module/type-name/index.vue.js";
import y from "./module/section-name/index.vue.js";
import { ref as p } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as m } from "vue";
import { unref as a } from "vue";
import "../component/form.vue.js";
const g = { class: "app-container" }, V = { __name: "index", setup(O) {
  const i = p(false), n = p({});
  c();
  async function c() {
    if (d(N.get)) {
      i.value = true;
      try {
        const t = await E.get({ productType: T.MACHINE_PART.V }) || {};
        for (const s in t) t[s].map((e) => {
          var r;
          Number(s) === o.SECTION_TYPE_ENUM.V ? e.typeName = u.V[e.productClassificationEnum].SL + "截面" : Number(s) === o.PRODUCT_TYPE_ENUM.V ? e.typeName = u.V[e.productClassificationEnum].SL + "制品" : e.typeName = void 0, e.productSectionNameList = ((r = e.sectionWarehouseConfigDTOList) == null ? void 0 : r.map((l) => l.name)) || [], e.originProductSectionNameList = JSON.parse(JSON.stringify(e.productSectionNameList));
        });
        n.value = t;
      } catch (t) {
        console.log("error", t);
      } finally {
        i.value = false;
      }
    }
  }
  return (t, s) => (P(), C("div", g, [m(a(S), { data: a(_)(n.value[a(o).PRODUCT_TYPE_ENUM.V]) ? n.value[a(o).PRODUCT_TYPE_ENUM.V] : [], onSuccess: c }, null, 8, ["data"]), m(a(y), { data: a(_)(n.value[a(o).SECTION_TYPE_ENUM.V]) ? n.value[a(o).SECTION_TYPE_ENUM.V] : [], style: { "margin-top": "20px" }, onSuccess: c }, null, 8, ["data"])]));
} }, L = f(V, [["__scopeId", "data-v-32baee62"]]);
export {
  L as default
};
