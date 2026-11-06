import { t } from "../../../../modules/crm-c6ba92ff.js";
import o from "../../components/file-management/index.vue.js";
import { lq as e } from "../../../../shared/runtime.js";
import { computed as m } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as p } from "vue";
import { unref as a } from "vue";
import "../../components/file-management/module/detail.vue.js";
import "../../components/file-management/module/header.vue.js";
const T = { __name: "index", setup(i) {
  const r = m(() => e.STRUCTURAL_DESIGN_METHOD.V + e.DEEPEN_DESIGN_METHOD.V);
  return (c, u) => (n(), s("div", null, [p(o, { "module-type": r.value, permission: a(t) }, null, 8, ["module-type", "permission"])]));
} };
export {
  T as default
};
