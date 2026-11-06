import { withDirectives as a } from "vue";
import { vShow as t } from "vue";
import { unref as o } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { B as n } from "../../../../../shared/runtime.js";
const p = { __name: "header", setup(l) {
  const e = {}, { crud: r } = n(e);
  return (u, _) => a((s(), c("div", null, null, 512)), [[t, o(r).searchToggle]]);
} };
export {
  p as default
};
