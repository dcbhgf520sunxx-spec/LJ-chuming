import { provide as d } from "vue";
import { ref as c } from "vue";
import { watch as l } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { ElCol as m } from "element-plus";
import { ElRow as u } from "element-plus";
import x from "./record-detail/index.vue.js";
import h from "./record-List/index.vue.js";
import { _ as g, o as v } from "../../../../../shared/runtime.js";
import "./record-detail/module/header.vue.js";
import "./record-List/module/header.vue.js";
const w = { class: "app-container" }, y = { __name: "index", setup(L) {
  const { maxHeight: s } = v({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  d("maxHeight", s);
  const o = c({}), n = c();
  function i(e) {
    e && (o.value = e);
  }
  return l(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.query;
  }, () => {
    o.value = void 0;
  }, { deep: true }), (e, b) => {
    const r = m, _ = u;
    return p(), f("div", w, [t(_, { id: "production-line-content", gutter: 10 }, { default: a(() => [t(r, { lg: 9, md: 24, sm: 24, xl: 9, xs: 24, style: { "margin-bottom": "10px" } }, { default: a(() => [t(h, { ref_key: "recordListRef", ref: n, onClickLine: i }, null, 512)]), _: 1 }), t(r, { lg: 15, md: 24, sm: 24, xl: 15, xs: 24 }, { default: a(() => [t(x, { freeze: o.value }, null, 8, ["freeze"])]), _: 1 })]), _: 1 })]);
  };
} }, R = g(y, [["__scopeId", "data-v-ffad3c4f"]]);
export {
  R as default
};
