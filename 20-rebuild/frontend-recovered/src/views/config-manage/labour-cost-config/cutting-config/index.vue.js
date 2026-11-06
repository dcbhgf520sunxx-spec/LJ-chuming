import i from "./header.vue.js";
import _ from "./table.vue.js";
import { _ as d } from "../../../../shared/runtime.js";
import { ref as o } from "vue";
import { provide as a } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as m } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as u } from "vue";
import "./create/index.vue.js";
import "./create/calculation/index.vue.js";
import "../../../../modules/cutting-config-59e818a6.js";
import "./create/reverse-thrust/index.vue.js";
import "../../../../modules/project-cutting-config-562d5e35.js";
import "./create/batch/index.vue.js";
const x = { class: "app-container" }, v = { class: "box-container" }, b = { class: "box-container" }, h = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(s, { expose: n }) {
  const p = s, e = o(null), t = o(null);
  return a("parentData", { headerRef: e, tableRef: t }), a("projectData", p.projectData), n({ tableRef: t }), (k, y) => (r(), l("div", x, [c("div", v, [m(i, { ref_key: "headerRef", ref: e }, null, 512)]), c("div", b, [e.value ? (r(), f(_, { key: 0, ref_key: "tableRef", ref: t }, null, 512)) : u("", true)])]));
} }, O = d(h, [["__scopeId", "data-v-eda79f4c"]]);
export {
  O as default
};
