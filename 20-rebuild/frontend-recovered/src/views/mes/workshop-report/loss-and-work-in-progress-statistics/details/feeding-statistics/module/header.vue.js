import { ref as V } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as X } from "vue";
import { vShow as k } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as a } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as r } from "vue";
import { ElDatePicker as C } from "element-plus";
import { ElInput as E } from "element-plus";
import { ElTag as T } from "element-plus";
import { d as v } from "../../../../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import { B as N, sj as x, aV as U, sk as z, L as I, E as b } from "../../../../../../../shared/runtime.js";
const P = { __name: "header", setup(S) {
  const i = { status: void 0, date: [], workshopId: void 0, classifyName: void 0 }, u = V([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: n, query: l } = N(i);
  return (p, t) => {
    const f = d("common-radio-button"), c = C, y = d("common-select"), _ = E, m = T;
    return w(), g("div", null, [X(h("div", null, [a(f, { modelValue: e(l).productType, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(l).productType = o), options: e(x).ENUM, "show-option-all": "", type: "enum", size: "small", class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(c, { modelValue: e(l).date, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(l).date = o), "default-time": u.value, shortcuts: p.PICKER_OPTIONS_SHORTCUTS, class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(n).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), a(e(U), { modelValue: e(l).workshopId, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(l).workshopId = o), placeholder: "领用车间", class: "filter-item", style: { width: "240px" }, clearable: "" }, null, 8, ["modelValue"]), a(y, { modelValue: e(l).name, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(l).name = o), options: e(z).ENUM, type: "enum", size: "small", class: "filter-item", placeholder: "材料类型", style: { width: "240px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(_, { modelValue: e(l).classifyName, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(l).classifyName = o), class: "filter-item", clearable: "", placeholder: "物料种类", size: "small", style: { width: "240px" } }, null, 8, ["modelValue"])], 512), [[k, e(n).searchToggle]]), a(e(b), null, { optLeft: s(() => [a(e(I), { fn: e(v), params: e(n).query, "response-header-result": "" }, { default: s(() => t[5] || (t[5] = [r(" 领料记录下载 ")])), _: 1, __: [5] }, 8, ["fn", "params"])]), viewLeft: s(() => [a(m, { size: "medium", type: "primary", class: "filter-item" }, { default: s(() => t[6] || (t[6] = [r("出库量合计：XXXX吨")])), _: 1, __: [6] }), a(m, { size: "medium", type: "primary", class: "filter-item" }, { default: s(() => t[7] || (t[7] = [r("退库量合计：XXXX吨")])), _: 1, __: [7] }), a(m, { size: "medium", type: "primary", class: "filter-item" }, { default: s(() => t[8] || (t[8] = [r("实际出库量：XXXX吨")])), _: 1, __: [8] })]), _: 1 })]);
  };
} };
export {
  P as default
};
