import { E as a } from "../../../../../shared/runtime.js";
import { inject as r } from "vue";
import { openBlock as t } from "vue";
import { createBlock as n } from "vue";
import { unref as e } from "vue";
const p = { __name: "header", setup(s) {
  const o = r("boolConfig");
  return (c, d) => (t(), n(e(a), { addText: "创建", disabled: !e(o) }, null, 8, ["disabled"]));
} };
export {
  p as default
};
