import { ref as o } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { createBlock as r } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTabPane as d } from "element-plus";
import { ElTabs as C } from "element-plus";
import g from "./common-config/index.vue.js";
import b from "./project-config/index.vue.js";
import "../../../../modules/project-config-5f01cdbc.js";
import "../../../../shared/runtime.js";
const k = { class: "app-container" }, D = { __name: "index", setup(v) {
  const e = o("commonConfig"), s = o(), i = o();
  return (j, m) => {
    const c = d, p = C;
    return n(), u("div", k, [t(p, { modelValue: e.value, "onUpdate:modelValue": m[0] || (m[0] = (_) => e.value = _), class: "tab-container" }, { default: a(() => [t(c, { label: "通用配置", name: "commonConfig" }, { default: a(() => [e.value === "commonConfig" ? (n(), r(l(g), { key: 0, ref_key: "commonConfigRef", ref: s }, null, 512)) : f("", true)]), _: 1 }), t(c, { label: "项目配置", name: "projectConfig" }, { default: a(() => [e.value === "projectConfig" ? (n(), r(l(b), { key: 0, ref_key: "projectConfigRef", ref: i }, null, 512)) : f("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  D as default
};
