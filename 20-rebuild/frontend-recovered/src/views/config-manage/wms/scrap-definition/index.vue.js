import { provide as _ } from "vue";
import { resolveDirective as i } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as e } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as l } from "vue";
import { unref as p } from "vue";
import { ElCol as d } from "element-plus";
import { ElRow as m } from "element-plus";
import { _ as f, hG as t } from "../../../../shared/runtime.js";
import u from "./module/steel.vue.js";
const v = { class: "app-container" }, x = { __name: "index", setup(b) {
  return _("permission", t), (h, g) => {
    const o = d, a = m, n = i("permission");
    return c(), r("div", v, [e(a, { gutter: 20 }, { default: s(() => [e(o, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: s(() => [l(e(u, { class: "card" }, null, 512), [[n, p(t).steelScrapDefinitionGet]])]), _: 1 })]), _: 1 })]);
  };
} }, k = f(x, [["__scopeId", "data-v-a94b38ab"]]);
export {
  k as default
};
