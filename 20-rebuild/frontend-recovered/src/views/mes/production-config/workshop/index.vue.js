import { ref as p } from "vue";
import { provide as m } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as o } from "vue";
import { withCtx as t } from "vue";
import { unref as n } from "vue";
import { ElCol as d } from "element-plus";
import { ElRow as f } from "element-plus";
import { o as u } from "../../../../shared/runtime.js";
import x from "./factory/index.vue.js";
import h from "./workshop/index.vue.js";
import "../../../../modules/factory-7a1d88b2.js";
import "./factory/module/header.vue.js";
import "../../../../modules/workshop-e9af8725.js";
import "./workshop/module/header.vue.js";
import "./workshop/module/form.vue.js";
const g = { class: "app-container" }, N = { __name: "index", setup(y) {
  const a = p(), { maxHeight: c } = u({ wrapperBox: [".app-container", "#factory-and-workshop"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  m("maxHeight", c);
  function s(e) {
    a.value = e;
  }
  return (e, w) => {
    const r = d, i = f;
    return l(), _("div", g, [o(i, { gutter: 10, id: "factory-and-workshop" }, { default: t(() => [o(r, { xs: 24, sm: 24, md: 24, lg: 10, xl: 10, style: { "margin-bottom": "10px" } }, { default: t(() => [o(n(x), { onClickFactory: s })]), _: 1 }), o(r, { xs: 24, sm: 24, md: 24, lg: 14, xl: 14 }, { default: t(() => [o(n(h), { factory: a.value }, null, 8, ["factory"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  N as default
};
