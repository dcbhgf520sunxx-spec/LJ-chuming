import { o as p } from "../../../../../shared/runtime.js";
import c from "./leftTable/index.vue.js";
import l from "./rightTable/index.vue.js";
import { provide as m } from "vue";
import { ref as d } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as o } from "vue";
import "../../../../../modules/quality-ring-config-c8639e5f.js";
import "./leftTable/module/header.vue.js";
import "./leftTable/module/form.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
import "./leftTable/module/editFrom.vue.js";
import "./rightTable/module/header.vue.js";
import "./rightTable/module/form.vue.js";
import "./rightTable/module/editFrom.vue.js";
const u = { class: "app-container" }, x = { style: { display: "flex" } }, V = { __name: "index", setup(f) {
  const { maxHeight: a } = p({ wrapperBox: [".app-container", "#factory-and-workshop"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  m("maxHeight", a);
  const t = d({});
  function n(e) {
    e && (t.value = e);
  }
  const s = (e) => {
    t.value = e;
  };
  return (e, r) => (h(), _("div", u, [i("div", x, [o(c, { style: { width: "38%" }, onClickLine: n, onDelLine: s }), r[0] || (r[0] = i("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 180px)" } }, null, -1)), o(l, { style: { flex: "1" }, currentLine: t.value }, null, 8, ["currentLine"])])]));
} };
export {
  V as default
};
