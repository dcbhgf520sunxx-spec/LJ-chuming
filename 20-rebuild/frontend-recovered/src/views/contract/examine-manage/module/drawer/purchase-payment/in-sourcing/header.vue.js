import { h as s } from "../../../../../../../modules/pc-insourc-data-b34c8a60.js";
import { e3 as r, dp as o, e5 as c } from "../../../../../../../shared/runtime.js";
import { inject as l } from "vue";
import { computed as n } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as e } from "vue";
const m = { class: "header-container" }, D = { __name: "header", setup(p) {
  const a = l("tableItemData"), t = n(() => r(s, a));
  return (u, _) => (i(), d("div", m, [e(o, { "header-title": "基本信息" }), e(c, { column: 2, "table-list": t.value, size: "default" }, null, 8, ["table-list"])]));
} };
export {
  D as default
};
