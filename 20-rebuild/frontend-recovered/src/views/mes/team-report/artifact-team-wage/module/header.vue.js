import { a3 as o } from "../../../../../shared/runtime.js";
import t from "../../components/team-wage/header.vue.js";
import { provide as e } from "vue";
import { openBlock as p } from "vue";
import { createBlock as a } from "vue";
import { unref as m } from "vue";
import "../../../../../modules/piecework-system-3800a6fe.js";
import "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const d = { __name: "header", setup(n) {
  const r = o.MACHINE_PART.V | o.ASSEMBLE.V | o.ARTIFACT.V;
  return e("initProductType", r), (c, i) => (p(), a(m(t)));
} };
export {
  d as default
};
