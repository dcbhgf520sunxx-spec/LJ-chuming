import { ref as y } from "vue";
import { resolveComponent as s } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as r } from "vue";
import { vShow as V } from "vue";
import { unref as e } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as a } from "vue";
import { withKeys as C } from "vue";
import { withCtx as g } from "vue";
import { ElInput as E } from "element-plus";
import { aS as i, B as x, C as S, E as U } from "../../../../../../shared/runtime.js";
const k = { class: "head-container" }, D = { __name: "header", props: { branchList: { type: Array, default: () => [] } }, setup(m) {
  const u = { boolStatus: i.TRUE.V, name: void 0 };
  y();
  const { crud: n, query: t } = x(u);
  return (B, o) => {
    const d = s("common-radio-button"), p = E, c = s("common-select-v2"), f = s("print-table"), _ = b("permission");
    return h(), v("div", k, [r(w("div", null, [a(d, { modelValue: e(t).boolStatus, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).boolStatus = l), showOptionAll: "", options: e(i).ENUM, class: "filter-item", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(p, { modelValue: e(t).name, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).name = l), modelModifiers: { trim: true }, clearable: "", style: { width: "150px" }, size: "default", placeholder: "输入名称搜索", class: "filter-item", onKeyup: C(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), a(c, { modelValue: e(t).branchCompanyId, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).branchCompanyId = l), options: m.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择分支机构", class: "filter-item", style: { width: "270px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(e(S))], 512), [[V, e(n).searchToggle]]), a(e(U), null, { viewLeft: g(() => [r(a(f, { "api-key": "factoryDepreciation", params: e(t), size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[_, e(n).permission.print]])]), _: 1 })]);
  };
} };
export {
  D as default
};
