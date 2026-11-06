import { openBlock as s } from "vue";
import { createElementBlock as t } from "vue";
import { withDirectives as o } from "vue";
import { vShow as c } from "vue";
import { unref as e } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as d } from "vue";
import { B as u, E as i } from "../../../../../../shared/runtime.js";
const h = { __name: "header", setup(l) {
  const a = { name: void 0 }, { crud: r } = u(a);
  return (m, p) => (s(), t("div", null, [o(n("div", null, [d(e(i))], 512), [[c, e(r).searchToggle]])]));
} };
export {
  h as default
};
