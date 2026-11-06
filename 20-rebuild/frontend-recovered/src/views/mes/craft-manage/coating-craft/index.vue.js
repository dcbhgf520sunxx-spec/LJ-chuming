import e from "./coating-list/index.vue.js";
import m from "./inventory-list/index.vue.js";
import { ref as a } from "vue";
import { provide as p } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as i } from "vue";
import "../../../../modules/coating-list-667107a8.js";
import "../../../../shared/runtime.js";
import "./coating-list/module/from.vue.js";
import "./coating-list/editList/index.vue.js";
import "./coating-list/editList/module/detail.vue.js";
import "./coating-list/editList/module/header.vue.js";
import "./coating-list/module/header.vue.js";
import "../../../../modules/user-2de6904c.js";
import "./inventory-list/project-detail/module/from.vue.js";
import "./inventory-list/project-detail/index.vue.js";
import "./inventory-list/project-detail/module/header.vue.js";
import "./inventory-list/module/header.vue.js";
const c = { class: "app-container" }, N = { __name: "index", setup(_) {
  const o = a();
  function r() {
    var t;
    (t = o.value) == null || t.getCoatingList();
  }
  return p("getCoatingList", r), (t, f) => (n(), s("div", c, [i(e, { ref_key: "coatingListRef", ref: o }, null, 512), i(m)]));
} };
export {
  N as default
};
