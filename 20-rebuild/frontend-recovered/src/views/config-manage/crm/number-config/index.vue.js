import { openBlock as r } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { unref as n } from "vue";
import { ElCol as a } from "element-plus";
import { ElRow as c } from "element-plus";
import { dz as _ } from "../../../../shared/runtime.js";
import i from "./module/number-prefix.vue.js";
import "../components/table-config-card.vue.js";
import "../../../../modules/project-config-3fa4f850.js";
import "../../../../modules/tender-apply-c04ffc5b.js";
const l = { class: "app-container" }, C = { __name: "index", setup(p) {
  return (d, f) => {
    const e = a, t = c;
    return r(), m("div", l, [o(t, { gutter: 20 }, { default: s(() => [o(e, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(i, { permission: n(_) }, null, 8, ["permission"])]), _: 1 }), o(e, { xs: 24, sm: 24, md: 12, lg: 8 }), o(e, { xs: 24, sm: 24, md: 12, lg: 8 })]), _: 1 })]);
  };
} };
export {
  C as default
};
