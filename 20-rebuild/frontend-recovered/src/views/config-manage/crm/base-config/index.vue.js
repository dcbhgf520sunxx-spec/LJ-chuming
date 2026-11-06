import { openBlock as r } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { ElCol as a } from "element-plus";
import { ElRow as l } from "element-plus";
import { du as m } from "../../../../shared/runtime.js";
import _ from "./card-module/unit-type.vue.js";
import p from "./card-module/belong-industry.vue.js";
import c from "./card-module/firm-reputation.vue.js";
import "../../../../modules/base-config-98ce5914.js";
const f = { class: "app-container" }, E = { __name: "index", setup(d) {
  return (u, x) => {
    const e = a, n = l;
    return r(), i("div", f, [o(n, { gutter: 20 }, { default: s(() => [o(e, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(c, { permission: t(m) }, null, 8, ["permission"])]), _: 1 }), o(e, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(_, { style: { "margin-bottom": "20px" }, permission: t(m) }, null, 8, ["permission"])]), _: 1 }), o(e, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [o(p, { style: { "margin-bottom": "20px" }, permission: t(m) }, null, 8, ["permission"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  E as default
};
