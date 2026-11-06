import { provide as l } from "vue";
import { ref as n } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as e } from "vue";
import { withCtx as o } from "vue";
import { unref as i } from "vue";
import { ElCol as u } from "element-plus";
import { ElRow as f } from "element-plus";
import x from "./module/warehouse-list/index.vue.js";
import h from "./module/Memory-list/index.vue.js";
import { o as g } from "../../../../shared/runtime.js";
import "./module/warehouse-list/module/header.vue.js";
import "./module/warehouse-list/module/form.vue.js";
import "../../../../modules/production-line-c52339bd.js";
import "./module/warehouse-list/module/batch-add.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
import "../../../../modules/use-add-form-local-storage-75741656.js";
import "./module/Memory-list/module/header.vue.js";
import "./module/Memory-list/module/form.vue.js";
import "./module/Memory-list/module/batch-add.vue.js";
const w = { class: "app-container" }, z = { __name: "index", setup(k) {
  const { maxHeight: s } = g({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".el-card__header"], paginate: true, extraHeight: 55 });
  l("maxHeight", s);
  const t = n({}), m = n();
  function p(r) {
    t.value = r;
  }
  return (r, L) => {
    const a = u, c = f;
    return _(), d("div", w, [e(c, { id: "production-line-content", gutter: 10 }, { default: o(() => [e(a, { lg: 12, md: 24, sm: 24, xl: 12, xs: 24, style: { "margin-bottom": "10px" } }, { default: o(() => [e(i(x), { onClickLine: p })]), _: 1 }), e(a, { lg: 12, md: 24, sm: 24, xl: 12, xs: 24 }, { default: o(() => [e(i(h), { ref_key: "memoryListRef", ref: m, workshop: t.value }, null, 8, ["workshop"])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  z as default
};
