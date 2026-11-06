import { ref as p } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as a } from "vue";
import { withCtx as t } from "vue";
import { createBlock as c } from "vue";
import { unref as r } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTabPane as f } from "element-plus";
import { ElTabs as u } from "element-plus";
import d from "./common-config/index.vue.js";
import C from "./project-config/index.vue.js";
import "../../../../modules/inventory-error-config-927b9f3e.js";
import "../../../../shared/runtime.js";
import "./project-config/module/form.vue.js";
const b = { class: "app-container" }, y = { __name: "index", setup(g) {
  const e = p("commonConfig");
  return (v, n) => {
    const m = f, s = u;
    return o(), _("div", b, [a(s, { modelValue: e.value, "onUpdate:modelValue": n[0] || (n[0] = (i) => e.value = i), class: "tab-container" }, { default: t(() => [a(m, { label: "通用配置", name: "commonConfig" }, { default: t(() => [e.value === "commonConfig" ? (o(), c(r(d), { key: 0 })) : l("", true)]), _: 1 }), a(m, { label: "项目配置", name: "projectConfig" }, { default: t(() => [e.value === "projectConfig" ? (o(), c(r(C), { key: 0 })) : l("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  y as default
};
