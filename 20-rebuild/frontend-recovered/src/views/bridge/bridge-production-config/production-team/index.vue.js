import { aP as e } from "../../../../shared/runtime.js";
import n from "./team/index.vue.js";
import p from "./inspection/index.vue.js";
import { ref as i } from "vue";
import { computed as s } from "vue";
import { resolveComponent as l } from "vue";
import { openBlock as u } from "vue";
import { createBlock as c } from "vue";
import { withCtx as _ } from "vue";
import { createVNode as f } from "vue";
import { unref as d } from "vue";
import { resolveDynamicComponent as V } from "vue";
import "./team/module/header.vue.js";
import "../../../../modules/process-select-cf7cf476.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-bridge-process-6f90ba68.js";
import "./team/module/form.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
import "./inspection/module/header.vue.js";
import "./inspection/module/form.vue.js";
const h = { __name: "index", setup(v) {
  const o = i(e.TEAM.V), m = s(() => o.value & e.TEAM.V ? n : p);
  return (y, t) => {
    const r = l("common-radio-button");
    return u(), c(V(m.value), null, { teamType: _(() => [f(r, { class: "filter-item", modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => o.value = a), size: "default", type: "enum", options: d(e).ENUM }, null, 8, ["modelValue", "options"])]), _: 1 });
  };
} };
export {
  h as default
};
