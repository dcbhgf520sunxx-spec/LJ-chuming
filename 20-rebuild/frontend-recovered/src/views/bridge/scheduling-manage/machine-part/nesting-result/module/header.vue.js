import { E as e } from "../../../../../../shared/runtime.js";
import { openBlock as r } from "vue";
import { createBlock as o } from "vue";
import { withCtx as a } from "vue";
import { renderSlot as s } from "vue";
import { unref as n } from "vue";
const l = { __name: "header", setup(p) {
  return (t, c) => (r(), o(n(e), null, { optRight: a(() => [s(t.$slots, "optRight")]), _: 3 }));
} };
export {
  l as default
};
