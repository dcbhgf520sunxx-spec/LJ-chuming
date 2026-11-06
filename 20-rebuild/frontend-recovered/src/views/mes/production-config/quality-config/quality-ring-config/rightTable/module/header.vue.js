import { E as a } from "../../../../../../../shared/runtime.js";
import { openBlock as r } from "vue";
import { createElementBlock as s } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { renderSlot as c } from "vue";
import { Fragment as n } from "vue";
const m = { __name: "header", setup(l) {
  return (e, d) => (r(), s(n, null, [o(t(a), { addBatchText: "新增二级分类", showGrid: false, showSearch: false, showRefresh: false }), c(e.$slots, "header")], 64));
} };
export {
  m as default
};
