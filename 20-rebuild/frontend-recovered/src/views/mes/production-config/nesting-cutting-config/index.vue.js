import n from "./left/index.vue.js";
import p from "./right/index.vue.js";
import { ref as s } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as r } from "vue";
import "../../../../modules/nesting-cutting-config-6d0e9e39.js";
import "../../../../shared/runtime.js";
import "./left/module/header.vue.js";
import "./left/module/form.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const c = { class: "app-container", style: { display: "flex", "justify-content": "space-between" } }, b = { __name: "index", setup(f) {
  const e = s([]), t = s(false);
  function a(i) {
    e.value = i;
  }
  return (i, o) => (l(), m("div", c, [r(n, { style: { width: "59%" }, onList: a, isRefresh: t.value }, null, 8, ["isRefresh"]), r(p, { style: { width: "40%", height: "400px" }, originData: e.value, onSuccess: o[0] || (o[0] = (u) => t.value = !t.value) }, null, 8, ["originData"])]));
} };
export {
  b as default
};
