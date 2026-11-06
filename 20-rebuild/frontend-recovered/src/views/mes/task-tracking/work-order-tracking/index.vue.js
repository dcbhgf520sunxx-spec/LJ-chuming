import { n as i } from "../../../../shared/runtime.js";
import r from "./by-order/index.vue.js";
import c from "./by-project/index.vue.js";
import { ref as p } from "vue";
import { computed as l } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as f } from "vue";
import { createBlock as B } from "vue";
import { resolveDynamicComponent as R } from "vue";
import "./by-order/production-line-detail/index.vue.js";
import "./by-order/module/header.vue.js";
import "./by-order/process-detail/index.vue.js";
import "../../../../modules/project-overview-1b3937a7.js";
import "./by-project/module/header.vue.js";
import "./by-project/project-process-detail/index.vue.js";
import "../../../../modules/use-product-lines-79a95221.js";
import "./by-project/process-detail/index.vue.js";
import "../../../../modules/production-line-select-f08e245b.js";
const V = { class: "app-container" }, E = { class: "head-contaienr" }, K = { __name: "index", setup(v) {
  const o = { BY_ORDER: { L: "按工单查询", K: "BY_ORDER", V: 1 }, BY_PROJECT: { L: "按项目查询", K: "BY_PROJECT", V: 2 } };
  i(o);
  const e = p(o.BY_ORDER.V), n = l(() => {
    switch (e.value) {
      case o.BY_ORDER.V:
        return r;
      case o.BY_PROJECT.V:
        return c;
      default:
        return r;
    }
  });
  return (O, t) => {
    const s = _("common-radio-button");
    return a(), u("div", V, [d("div", E, [f(s, { modelValue: e.value, "onUpdate:modelValue": t[0] || (t[0] = (m) => e.value = m), options: o.ENUM, type: "enum", size: "default", default: "", class: "filter-item" }, null, 8, ["modelValue", "options"])]), (a(), B(R(n.value)))]);
  };
} };
export {
  K as default
};
