import { o as t } from "../../../../shared/runtime.js";
import o from "./line/index.vue.js";
import { provide as r } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as n } from "vue";
import { unref as p } from "vue";
import "../../../../modules/production-line-c52339bd.js";
import "./line/module/header.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../modules/mes-bridge-enum-radio-5a510e87.js";
import "./line/module/form.vue.js";
const c = { class: "app-container" }, H = { __name: "index", setup(s) {
  const { maxHeight: e } = t({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  return r("maxHeight", e), (m, _) => (a(), i("div", c, [n(p(o))]));
} };
export {
  H as default
};
