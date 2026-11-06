import { ref as f } from "vue";
import r from "moment";
import { resolveComponent as c } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as N } from "vue";
import { withCtx as O } from "vue";
import { createTextVNode as S } from "vue";
import { ElDatePicker as B } from "element-plus";
import { ElInput as I } from "element-plus";
import { b as L } from "../../../../../modules/scrap-ledger-452ee452.js";
import { B as Q, C as T } from "../../../../../shared/runtime.js";
import E from "./detail.vue.js";
import "../../../../../modules/scrap-sell-e306ced6.js";
const j = { class: "head-container" }, q = { style: { display: "flex", "justify-content": "space-between" } }, A = { __name: "header", setup($) {
  const i = f([]), d = f(false), y = { purchaser: void 0, createUserName: void 0, auditUserName: void 0, wasteClassificationId: void 0, date: [r().startOf("month").valueOf(), r().valueOf()], startDate: r().startOf("month").valueOf(), endDate: r().valueOf() }, { crud: n, query: e } = Q(y);
  V();
  async function V() {
    try {
      const { content: s } = await L();
      console.log(s), i.value = s;
    } catch (s) {
      console.log(s);
    }
  }
  function h() {
    d.value = true;
  }
  function g() {
    n.toQuery();
  }
  function U(s) {
    e.date && e.date.length > 1 ? (e.startDate = e.date[0], e.endDate = e.date[1]) : (e.startDate = void 0, e.endDate = void 0), n.toQuery();
  }
  return (s, t) => {
    const w = B, C = c("common-select"), D = c("common-button"), u = I, b = c("print-table"), p = k("permission");
    return _(), x("div", j, [m("div", null, [o(w, { modelValue: a(e).date, "onUpdate:modelValue": t[0] || (t[0] = (l) => a(e).date = l), type: "daterange", "range-separator": "-", "value-format": "x", "start-placeholder": "开始时间", "end-placeholder": "结束时间", class: "filter-item", onChange: U }, null, 8, ["modelValue"]), o(C, { placeholder: "请选择类型", class: "filter-item", options: i.value, "data-structure": { key: "id", label: "name", value: "id" }, modelValue: a(e).wasteClassificationId, "onUpdate:modelValue": t[1] || (t[1] = (l) => a(e).wasteClassificationId = l), clearable: "", onChange: a(n).toQuery }, null, 8, ["options", "modelValue", "onChange"])]), m("div", q, [m("div", null, [v((_(), N(D, { icon: "el-icon-plus", type: "success", class: "filter-item", size: "default", onClick: h }, { default: O(() => t[6] || (t[6] = [S("创建")])), _: 1, __: [6] })), [[p, a(n).permission.add]]), o(u, { style: { width: "200px" }, class: "filter-item", placeholder: "购买方搜索", modelValue: a(e).purchaser, "onUpdate:modelValue": t[2] || (t[2] = (l) => a(e).purchaser = l) }, null, 8, ["modelValue"]), o(u, { style: { width: "200px" }, class: "filter-item", placeholder: "创建人搜索", modelValue: a(e).createUserName, "onUpdate:modelValue": t[3] || (t[3] = (l) => a(e).createUserName = l) }, null, 8, ["modelValue"]), o(u, { style: { width: "200px" }, class: "filter-item", placeholder: "审核人搜索", modelValue: a(e).auditUserName, "onUpdate:modelValue": t[4] || (t[4] = (l) => a(e).auditUserName = l) }, null, 8, ["modelValue"]), o(a(T))]), v(o(b, { class: "filter-item", "api-key": "wmsScrapSell" }, null, 512), [[p, a(n).permission.print]])]), o(E, { modelValue: d.value, "onUpdate:modelValue": t[5] || (t[5] = (l) => d.value = l), typeList: i.value, onSuccess: g }, null, 8, ["modelValue", "typeList"])]);
  };
} };
export {
  A as default
};
