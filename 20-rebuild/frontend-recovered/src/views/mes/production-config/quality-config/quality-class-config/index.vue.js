import p from "./leftTable/index.vue.js";
import c from "./rightTable/index.vue.js";
import { o as l } from "../../../../../shared/runtime.js";
import { provide as m } from "vue";
import { ref as d } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as o } from "vue";
import "../../../../../modules/quality-class-config-61380f5b.js";
import "./leftTable/module/header.vue.js";
import "./leftTable/module/form.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
import "./leftTable/module/editFrom.vue.js";
import "./rightTable/module/header.vue.js";
import "./rightTable/module/form.vue.js";
import "./rightTable/module/editFrom.vue.js";
const _ = { class: "app-container" }, f = { style: { display: "flex" } }, V = { __name: "index", setup(x) {
  const { maxHeight: a } = l({ wrapperBox: [".app-container", "#factory-and-workshop"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  m("maxHeight", a);
  const t = d({});
  function n(e) {
    e && (t.value = e);
  }
  function s(e) {
    t.value = e;
  }
  return (e, r) => (h(), u("div", _, [i("div", f, [o(p, { style: { width: "38%" }, onClickLine: n, onDelLine: s }), r[0] || (r[0] = i("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 100px)" } }, null, -1)), o(c, { style: { flex: "1" }, currentLine: t.value }, null, 8, ["currentLine"])])]));
} };
export {
  V as default
};
