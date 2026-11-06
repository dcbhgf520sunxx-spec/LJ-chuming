import p from "./header.vue.js";
import i from "./table.vue.js";
import { _ } from "../../../../shared/runtime.js";
import { ref as o } from "vue";
import { provide as a } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as l } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as d } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as m } from "vue";
import "./create/index.vue.js";
import "./create/calculation/index.vue.js";
import "../../../../modules/project-group-welding-config-ee2755b6.js";
import "./create/reverse-thrust/index.vue.js";
import "../../../../modules/drilling-config-d5ae6cbb.js";
import "./create/batch/index.vue.js";
const u = { class: "lc-borehole-v2-container app-container" }, v = { class: "box-container" }, b = { class: "box-container" }, x = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, setup(s) {
  const n = s, e = o(null), t = o(null);
  return a("parentData", { headerRef: e, tableRef: t }), a("projectData", n.projectData), (h, k) => (r(), l("div", u, [c("div", v, [d(p, { ref_key: "headerRef", ref: e }, null, 512)]), c("div", b, [e.value ? (r(), f(i, { key: 0, ref_key: "tableRef", ref: t }, null, 512)) : m("", true)])]));
} }, H = _(x, [["__scopeId", "data-v-cef954c4"]]);
export {
  H as default
};
