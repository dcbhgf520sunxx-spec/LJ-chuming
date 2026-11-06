import { openBlock as u } from "vue";
import { createElementBlock as d } from "vue";
import { withDirectives as i } from "vue";
import { vShow as p } from "vue";
import { unref as e } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { withKeys as c } from "vue";
import { withCtx as f } from "vue";
import { ElInput as h } from "element-plus";
import { B as _, aV as w, C as y, E as V } from "../../../../../shared/runtime.js";
const q = { __name: "header", setup(b) {
  const s = { workshopId: void 0, quotaNumber: void 0 }, { crud: l, query: o } = _(s);
  return (x, a) => {
    const n = h;
    return u(), d("div", null, [i(m("div", null, [t(e(w), { modelValue: e(o).workshopId, "onUpdate:modelValue": a[0] || (a[0] = (r) => e(o).workshopId = r), placeholder: "请选择车间", style: { width: "270px" }, class: "filter-item", clearable: "", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), t(n, { modelValue: e(o).quotaNumber, "onUpdate:modelValue": a[1] || (a[1] = (r) => e(o).quotaNumber = r), size: "default", placeholder: "定额编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: c(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), t(e(y))], 512), [[p, e(l).searchToggle]]), t(e(V), { addText: "创建" }, { optLeft: f(() => a[2] || (a[2] = [])), _: 1 })]);
  };
} };
export {
  q as default
};
