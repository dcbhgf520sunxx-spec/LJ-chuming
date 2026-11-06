import { s as t } from "../../../../modules/crm-c6ba92ff.js";
import o from "../../components/bid-list/index.vue.js";
import { lq as r } from "../../../../shared/runtime.js";
import { computed as m } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as n } from "vue";
import { unref as s } from "vue";
import "../../components/bid-list/module/header.vue.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../components/bid-list/module/detail.vue.js";
import "../../../../modules/user-template-config-16e71de8.js";
import "../../../../modules/bid-list-077bf24b.js";
import "../../../../modules/use-crm-project-information-18afe991.js";
import "../../../../modules/use-form-config-data-098a0552.js";
import "../../../../modules/project-information-053c195b.js";
import "../../components/information-description/index.vue.js";
import "../../../../modules/tender-apply-config-select-032e3e0f.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
import "../../../../modules/project-config-3fa4f850.js";
const H = { __name: "index", setup(a) {
  const e = m(() => r.STRUCTURAL_DESIGN_METHOD.V + r.DEEPEN_DESIGN_METHOD.V);
  return (c, u) => (i(), p("div", null, [n(o, { "module-type": e.value, permission: s(t) }, null, 8, ["module-type", "permission"])]));
} };
export {
  H as default
};
