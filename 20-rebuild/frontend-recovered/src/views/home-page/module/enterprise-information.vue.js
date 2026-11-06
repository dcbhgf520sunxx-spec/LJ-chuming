import o from "./components/home-card-head.vue.js";
import { Q as r } from "../../../shared/runtime.js";
import { openBlock as t } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as a } from "vue";
import "../../../modules/home-page-66a3681d.js";
const n = { class: "home-card enterprise-information-card" }, c = { class: "home-card-content" }, h = { __name: "enterprise-information", setup(i) {
  return (m, p) => (t(), s("div", n, [e(o, { icon: "comp-home-enterprise", title: "企业信息" }), a("div", c, [e(r)])]));
} };
export {
  h as default
};
