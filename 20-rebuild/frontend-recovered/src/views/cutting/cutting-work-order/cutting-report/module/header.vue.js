import { ref as s } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as o } from "vue";
import { withCtx as _ } from "vue";
import { withDirectives as h } from "vue";
import { createElementVNode as w } from "vue";
import { unref as e } from "vue";
import { withKeys as y } from "vue";
import { vShow as k } from "vue";
import { ElDatePicker as v } from "element-plus";
import { ElInput as V } from "element-plus";
import { B as g, I as C, C as I, E as T } from "../../../../../shared/runtime.js";
const x = { class: "head-container" }, B = { __name: "header", setup(O) {
  const r = s(""), u = s([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), d = { workshopInf: void 0, online: void 0 }, { CRUD: i, query: a, crud: l } = g(d);
  return i.HOOK.beforeResetQuery = () => {
    r.value = "";
  }, (D, t) => {
    const c = v, p = V;
    return m(), f("div", x, [o(e(T), null, { optLeft: _(() => [h(w("div", null, [o(c, { modelValue: e(a).createTime, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(a).createTime = n), "default-time": u.value, type: "daterange", "range-separator": ":", size: "default", "value-format": "x", shortcuts: e(C), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o(p, { modelValue: e(a).workshopInf, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(a).workshopInf = n), placeholder: "请输入车间", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: y(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(I))], 512), [[k, e(l).searchToggle]])]), _: 1 })]);
  };
} };
export {
  B as default
};
