import { ref as p } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as o } from "vue";
import { withCtx as c } from "vue";
import { unref as e } from "vue";
import { withKeys as f } from "vue";
import { createCommentVNode as h } from "vue";
import { ElDatePicker as _ } from "element-plus";
import { ElInput as y } from "element-plus";
import { B as V, fv as I, I as g, gF as k, C as w, E as C } from "../../../../../../shared/runtime.js";
const T = { class: "head-container" }, x = { key: 0 }, b = { __name: "header", setup(v) {
  const r = p([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), u = { endTime: [], projectId: void 0, cutTaskId: void 0, workshopIds: [] }, { crud: s, query: t } = V(u);
  return (E, a) => {
    const i = _, m = y;
    return n(), d("div", T, [o(e(C), null, { optLeft: c(() => [e(s).searchToggle ? (n(), d("div", x, [o(e(I), { modelValue: e(t).projectId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).projectId = l), class: "filter-item", clearable: "", isAll: "", placeholder: "所属项目", style: { width: "250px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(i, { modelValue: e(t).endTime, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).endTime = l), "default-time": r.value, shortcuts: e(g), class: "filter-item", "end-placeholder": "生成日期", "range-separator": ":", size: "default", "start-placeholder": "生成日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(s).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(k, { modelValue: e(t).workshopIds, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).workshopIds = l), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(m, { modelValue: e(t).cutTaskId, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).cutTaskId = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "套料工单", size: "default", style: { width: "200px" }, onKeyup: f(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(w))])) : h("", true)]), _: 1 })]);
  };
} };
export {
  b as default
};
