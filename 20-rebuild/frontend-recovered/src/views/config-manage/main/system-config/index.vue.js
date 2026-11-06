import t from "./module/project.vue.js";
import e from "./module/logo.vue.js";
import m from "./module/company.vue.js";
import p from "./module/print-logo.vue.js";
import a from "./module/home-page.vue.js";
import i from "./module/watermark.vue.js";
import { openBlock as n } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as o } from "vue";
import { unref as r } from "vue";
import "../../../../shared/runtime.js";
const c = { class: "app-container" }, j = { __name: "index", setup(f) {
  return (_, l) => (n(), s("div", c, [o(r(m)), o(r(e), { style: { "margin-top": "20px" } }), o(p, { style: { "margin-top": "20px" } }), o(r(t), { style: { "margin-top": "20px" } }), o(a, { style: { "margin-top": "20px" } }), o(i, { style: { "margin-top": "20px" } })]));
} };
export {
  j as default
};
