import { provide as n } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as s } from "vue";
import { withCtx as a } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as m } from "vue";
import { ElCol as l } from "element-plus";
import { ElRow as p } from "element-plus";
import { cs as t, G as d } from "../../../../shared/runtime.js";
import f from "./component/approval-config.vue.js";
const u = { class: "app-container" }, b = { __name: "index", setup(g) {
  return n("permission", t), (k, x) => {
    const c = l, r = p;
    return o(), _("div", u, [s(r, { gutter: 20 }, { default: a(() => [s(c, { xs: 24, sm: 24, md: 12, lg: 10 }, { default: a(() => [e(d)(e(t).approvalConfigGet) ? (o(), i(e(f), { key: 0 })) : m("", true)]), _: 1 })]), _: 1 })]);
  };
} };
export {
  b as default
};
