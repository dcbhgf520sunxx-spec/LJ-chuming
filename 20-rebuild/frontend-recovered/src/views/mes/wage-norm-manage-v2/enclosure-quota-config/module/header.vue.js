import { E as e } from "../../../../../shared/runtime.js";
import { inject as r } from "vue";
import { openBlock as s } from "vue";
import { createBlock as n } from "vue";
import { withCtx as i } from "vue";
import { unref as t } from "vue";
const l = { __name: "header", setup(d) {
  const a = r("boolConfig");
  return (p, o) => (s(), n(t(e), { addText: "创建", disabled: !t(a) }, { optRight: i(() => o[0] || (o[0] = [])), _: 1 }, 8, ["disabled"]));
} };
export {
  l as default
};
