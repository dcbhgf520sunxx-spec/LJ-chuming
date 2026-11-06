import { aP as o } from "../../../../../shared/runtime.js";
import e from "./team/index.vue.js";
import p from "./inspection/index.vue.js";
import { ref as a } from "vue";
import { computed as i } from "vue";
import { openBlock as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as c } from "vue";
import { resolveDynamicComponent as u } from "vue";
import "./team/module/form.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
import "./team/module/header.vue.js";
import "./inspection/module/header.vue.js";
import "./inspection/module/form.vue.js";
const C = { __name: "index", setup(_) {
  const r = a(o.TEAM.V), m = i(() => r.value & o.TEAM.V ? e : p);
  return (f, t) => (n(), s(u(m.value), null, { teamType: c(() => t[0] || (t[0] = [])), _: 1 }));
} };
export {
  C as default
};
