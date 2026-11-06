import { openBlock as r } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as t } from "vue";
import { withCtx as e } from "vue";
import { unref as c } from "vue";
import { ElCol as n } from "element-plus";
import { ElRow as _ } from "element-plus";
import m from "./component/subcontract-payment-attribute/index.vue.js";
import "../../../../modules/subcontract-payment-attribute-37f9bab7.js";
import "../../../../shared/runtime.js";
import "./component/subcontract-payment-attribute/module/form.vue.js";
const l = { class: "app-container" }, w = { __name: "index", setup(p) {
  return (i, u) => {
    const o = n, a = _;
    return r(), s("div", l, [t(a, { gutter: 20 }, { default: e(() => [t(o, { xs: 24, sm: 24, md: 12, lg: 10 }, { default: e(() => [t(c(m))]), _: 1 })]), _: 1 })]);
  };
} };
export {
  w as default
};
