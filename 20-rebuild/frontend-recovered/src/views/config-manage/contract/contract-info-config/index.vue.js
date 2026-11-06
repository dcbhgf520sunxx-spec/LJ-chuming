import { openBlock as m } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { unref as r } from "vue";
import { ElCol as _ } from "element-plus";
import { ElRow as c } from "element-plus";
import n from "./structure-type-config/index.vue.js";
import p from "./technical-disclosure-config/index.vue.js";
import "../../../../modules/structure-type-config-b977de76.js";
import "../../../../shared/runtime.js";
import "./structure-type-config/module/form.vue.js";
import "./structure-type-config/module/batchForm.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "../../../../modules/technical-disclosure-config-24634047.js";
const i = { class: "app-container" }, B = { __name: "index", setup(l) {
  return (d, f) => {
    const e = _, s = c;
    return m(), a("div", i, [t(s, { gutter: 20 }, { default: o(() => [t(e, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: o(() => [t(r(n))]), _: 1 }), t(e, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: o(() => [t(r(p))]), _: 1 })]), _: 1 })]);
  };
} };
export {
  B as default
};
