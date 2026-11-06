import { openBlock as s } from "vue";
import { createElementBlock as t } from "vue";
import { withDirectives as o } from "vue";
import { vShow as c } from "vue";
import { unref as e } from "vue";
import { createElementVNode as n } from "vue";
import { renderSlot as l } from "vue";
import { createVNode as d } from "vue";
import { Fragment as i } from "vue";
import { B as m, E as p } from "../../../../../../../shared/runtime.js";
const g = { __name: "header", setup(u) {
  const { crud: a } = m({});
  return (r, _) => (s(), t(i, null, [o(n("div", null, [l(r.$slots, "teamType")], 512), [[c, e(a).searchToggle]]), d(e(p))], 64));
} };
export {
  g as default
};
