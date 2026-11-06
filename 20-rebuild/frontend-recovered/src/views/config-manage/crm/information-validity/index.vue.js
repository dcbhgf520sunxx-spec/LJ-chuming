import { openBlock as e } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { unref as m } from "vue";
import { ElCol as p } from "element-plus";
import { ElRow as a } from "element-plus";
import { dx as i } from "../../../../shared/runtime.js";
import _ from "./module/validity-config.vue.js";
import l from "./module/ca-lock.vue.js";
import c from "./module/number-places.vue.js";
import f from "./module/firm-information-number.vue.js";
import "../../../../modules/information-validity-6783e35a.js";
import "./component/custom-user-dialog.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "../../../../modules/index-9d220fe1.js";
import "../../../../modules/use-users-4d979987.js";
const d = { class: "app-container" }, M = { __name: "index", setup(u) {
  return (x, g) => {
    const t = p, r = a;
    return e(), n("div", d, [o(r, { gutter: 20 }, { default: s(() => [o(t, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(_, { style: { "margin-bottom": "10px" }, permission: m(i) }, null, 8, ["permission"]), o(f, { permission: m(i) }, null, 8, ["permission"])]), _: 1 }), o(t, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(l, { permission: m(i) }, null, 8, ["permission"])]), _: 1 }), o(t, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(c, { permission: m(i) }, null, 8, ["permission"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  M as default
};
