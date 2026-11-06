import { ref as t } from "vue";
import { provide as a } from "vue";
import { withDirectives as c } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as r } from "vue";
import { vLoading as d } from "element-plus";
import l from "./statistics-by-project/index.vue.js";
import { _ as p, m } from "../../../../../shared/runtime.js";
const f = { class: "app-container" }, v = { style: { display: "flex" } }, b = { __name: "index", setup(g) {
  const { globalProjectId: o } = m(["globalProjectId"]), e = t(false);
  return a("projectId", o), a("globalLoading", e), (x, u) => {
    const s = d;
    return c((_(), i("div", f, [n("div", v, [r(l, { style: { flex: "1" } })])])), [[s, e.value]]);
  };
} }, j = p(b, [["__scopeId", "data-v-6b3490bc"]]);
export {
  j as default
};
