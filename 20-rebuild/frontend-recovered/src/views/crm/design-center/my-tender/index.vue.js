import { u as t } from "../../../../modules/crm-c6ba92ff.js";
import o from "../../components/my-project/index.vue.js";
import { lq as e } from "../../../../shared/runtime.js";
import { computed as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import "../../components/my-project/module/header.vue.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../components/my-project/module/detail.vue.js";
import "../../../../modules/use-form-config-data-098a0552.js";
import "../../../../modules/project-information-053c195b.js";
import "../../components/information-description/index.vue.js";
import "../../../../modules/project-config-3fa4f850.js";
const k = { __name: "index", setup(a) {
  const r = m(() => e.STRUCTURAL_DESIGN_METHOD.V + e.DEEPEN_DESIGN_METHOD.V);
  return (c, u) => (p(), i("div", null, [n(o, { "module-type": r.value, permission: s(t) }, null, 8, ["module-type", "permission"])]));
} };
export {
  k as default
};
