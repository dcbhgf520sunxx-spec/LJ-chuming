import { openBlock as a } from "vue";
import { createElementBlock as c } from "vue";
import { unref as o } from "vue";
import { createBlock as m } from "vue";
import { withCtx as r } from "vue";
import { createVNode as s } from "vue";
import { createCommentVNode as p } from "vue";
import { ElCol as i } from "element-plus";
import { ElRow as _ } from "element-plus";
import { m as d, i as f } from "../../../../shared/runtime.js";
import { I as u } from "../../../../modules/project-19a12d6b.js";
import g from "./module/project.vue.js";
import "../../../../modules/install-config-0f2e817e.js";
const b = { class: "app-container" }, E = { __name: "index", setup(j) {
  const { globalProject: t } = d(["globalProject"]);
  return (k, x) => {
    var e;
    const l = i, n = _;
    return a(), c("div", b, [o(f)((e = o(t)) == null ? void 0 : e.installReportMethod) ? (a(), m(n, { key: 0, gutter: 40 }, { default: r(() => [s(l, { span: 14 }, { default: r(() => [s(o(g), { style: { "margin-bottom": "20px" }, globalProject: o(t), permission: o(u) }, null, 8, ["globalProject", "permission"])]), _: 1 })]), _: 1 })) : p("", true)]);
  };
} };
export {
  E as default
};
