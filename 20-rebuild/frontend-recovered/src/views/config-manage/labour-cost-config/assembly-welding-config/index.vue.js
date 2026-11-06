import p from "./header.vue.js";
import _ from "./table.vue.js";
import { _ as i } from "../../../../shared/runtime.js";
import { ref as o } from "vue";
import { provide as a } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as d } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as f } from "vue";
import "./create/index.vue.js";
import "./create/calculation/index.vue.js";
import "../../../../modules/project-assembly-welding-config-107f9ee1.js";
import "./create/reverse-thrust/index.vue.js";
import "../../../../modules/cutting-config-59e818a6.js";
import "./create/batch/index.vue.js";
const u = { class: "app-container" }, b = { class: "box-container" }, v = { class: "box-container" }, x = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(c) {
  const n = c, e = o(null), t = o(null);
  return a("parentData", { headerRef: e, tableRef: t }), a("projectData", n.projectData), (y, h) => (r(), l("div", u, [s("div", b, [d(p, { ref_key: "headerRef", ref: e }, null, 512)]), s("div", v, [e.value ? (r(), m(_, { key: 0, ref_key: "tableRef", ref: t }, null, 512)) : f("", true)])]));
} }, H = i(x, [["__scopeId", "data-v-261765d0"]]);
export {
  H as default
};
