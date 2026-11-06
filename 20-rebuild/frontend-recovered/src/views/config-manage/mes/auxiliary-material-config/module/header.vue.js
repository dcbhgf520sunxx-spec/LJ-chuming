import { openBlock as r } from "vue";
import { createElementBlock as s } from "vue";
import { withDirectives as o } from "vue";
import { vShow as t } from "vue";
import { unref as e } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as n } from "vue";
import { B as i, E as d } from "../../../../../shared/runtime.js";
const f = { __name: "header", setup(l) {
  const { crud: a } = i({});
  return (u, p) => (r(), s("div", null, [o(c("div", null, [n(e(d))], 512), [[t, e(a).searchToggle]])]));
} };
export {
  f as default
};
