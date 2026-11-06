import { _ as m, G as d, fb as f, fc as E, a3 as N, f9 as S, i as u, eu as n } from "../../../../../../shared/runtime.js";
import y from "./module/type-name/index.vue.js";
import T from "./module/section-name/index.vue.js";
import { ref as p } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as _ } from "vue";
import { unref as a } from "vue";
import "../component/form.vue.js";
const x = { class: "app-container" }, C = { __name: "index", setup(O) {
  const c = p(false), o = p({});
  s();
  async function s() {
    if (d(f.get)) {
      c.value = true;
      try {
        const e = await E.get({ productType: N.ASSEMBLE.V }) || {};
        for (const i in e) e[i].map((t) => {
          var r;
          t.typeName = S.V[t.productClassificationEnum].SL, t.productSectionNameList = ((r = t.sectionWarehouseConfigDTOList) == null ? void 0 : r.map((l) => l.name)) || [], t.originProductSectionNameList = JSON.parse(JSON.stringify(t.productSectionNameList));
        });
        o.value = e;
      } catch (e) {
        console.log("error", e);
      } finally {
        c.value = false;
      }
    }
  }
  return (e, i) => (g(), P("div", x, [_(a(y), { data: a(u)(o.value[a(n).PRODUCT_TYPE_ENUM.V]) ? o.value[a(n).PRODUCT_TYPE_ENUM.V] : [], onSuccess: s }, null, 8, ["data"]), _(a(T), { data: a(u)(o.value[a(n).SECTION_TYPE_ENUM.V]) ? o.value[a(n).SECTION_TYPE_ENUM.V] : [], style: { "margin-top": "20px" }, onSuccess: s }, null, 8, ["data"])]));
} }, U = m(C, [["__scopeId", "data-v-85d8ba43"]]);
export {
  U as default
};
