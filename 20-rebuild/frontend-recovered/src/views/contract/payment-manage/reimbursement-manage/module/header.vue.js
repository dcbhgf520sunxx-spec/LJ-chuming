import { ref as C } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as U } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as p } from "vue";
import { createBlock as b } from "vue";
import { createTextVNode as E } from "vue";
import { toDisplayString as q } from "vue";
import { createCommentVNode as j } from "vue";
import { ElDatePicker as v } from "element-plus";
import { ElInput as B } from "element-plus";
import { ElTag as I } from "element-plus";
import { t as k, jD as c, B as S, jC as z, C as Q, bV as R, E as P } from "../../../../../shared/runtime.js";
import { r as O } from "../../../../../modules/reimbursement-d297ed56.js";
import A from "./expense.vue.js";
import "../../../../../modules/expense-config-93f15b94.js";
const G = { __name: "header", setup(H) {
  const { decimalPrecision: y } = k(), f = { projectId: void 0, dateType: c.UPDATE_DATE.V, createTime: [], startDate: void 0, endDate: void 0, applyDepartName: void 0, applyUserName: void 0, type: void 0, choseId: void 0, writtenByName: void 0 }, { CRUD: V, crud: o, query: a } = S(f), s = C();
  g();
  async function g() {
    let r;
    try {
      r = await O();
    } catch (t) {
      console.log("报销总额", t);
    } finally {
      s.value = r;
    }
  }
  function h(r) {
    r ? r.type === 1 ? o.query.type = r.parentId : o.query.type = r.id : o.query.type = void 0, o.toQuery();
  }
  return V.HOOK.beforeRefresh = () => {
    o.query.createTime && o.query.createTime.length > 0 && (o.query.startDate = o.query.createTime[0], o.query.endDate = o.query.createTime[1]);
  }, (r, t) => {
    const u = i("common-select"), D = v, T = i("project-radio-button"), d = B, x = I;
    return m(), N("div", null, [U(_("div", null, [n(u, { modelValue: e(a).dateType, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).dateType = l), options: e(c).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "日期类型", style: { width: "110px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(D, { modelValue: e(a).createTime, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).createTime = l), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "200px" } }, null, 8, ["modelValue"]), n(T, { size: "default", type: "all", modelValue: e(a).projectId, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).projectId = l), class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), n(e(A), { ref: "expenseRef", modelValue: e(a).choseId, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).choseId = l), onChange: h, clearable: true, class: "filter-item", placeholder: "报销种类" }, null, 8, ["modelValue"]), n(d, { modelValue: e(a).applyDepartName, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).applyDepartName = l), placeholder: "申请部门", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(d, { modelValue: e(a).applyUserName, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(a).applyUserName = l), placeholder: "申请人", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(d, { modelValue: e(a).writtenByName, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).writtenByName = l), placeholder: "填报人", style: { width: "120px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(u, { modelValue: e(a).auditStatus, "onUpdate:modelValue": t[7] || (t[7] = (l) => e(a).auditStatus = l), options: e(z).ENUM, type: "enum", size: "default", clearable: "", class: "filter-item", placeholder: "状态", style: { width: "120px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(Q)), n(e(P), { "add-text": "报销填报" }, { viewLeft: p(() => [s.value ? (m(), b(x, { key: 0, type: "success", size: "large" }, { default: p(() => [E(q(`报销总额:${e(R)(s.value, e(y).contract)}元`), 1)]), _: 1 })) : j("", true)]), _: 1 })], 512), [[w, e(o).searchToggle]])]);
  };
} };
export {
  G as default
};
