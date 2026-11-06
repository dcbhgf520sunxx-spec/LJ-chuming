import { openBlock as s } from "vue";
import { createElementBlock as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as t } from "vue";
import { unref as n } from "vue";
import { ElCol as m } from "element-plus";
import { ElRow as _ } from "element-plus";
import c from "./module/bond.vue.js";
import p from "./module/management-expense.vue.js";
import "./module/bond-dialog.vue.js";
import "../../../../modules/management-config-46730d2f.js";
import "../../../../shared/runtime.js";
import "../../../../modules/contract-9b18cc88.js";
import "./module/management-expense-dialog.vue.js";
const l = { class: "app-container" }, k = { __name: "index", setup(i) {
  return (d, f) => {
    const e = m, r = _;
    return s(), a("div", l, [o(r, { gutter: 20 }, { default: t(() => [o(e, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: t(() => [o(n(p))]), _: 1 }), o(e, { xs: 24, sm: 24, md: 12, lg: 12 }, { default: t(() => [o(c)]), _: 1 })]), _: 1 })]);
  };
} };
export {
  k as default
};
