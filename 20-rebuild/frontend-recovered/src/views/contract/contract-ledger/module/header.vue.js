import { ref as E } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as M } from "vue";
import { unref as e } from "vue";
import { createElementVNode as Y } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { createBlock as p } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as V } from "vue";
import { ElDatePicker as D } from "element-plus";
import { ElInput as T } from "element-plus";
import { ElTag as z } from "element-plus";
import { l as B } from "../../../../modules/contract-ledger-2ee7c4ce.js";
import { t as Q, iF as S, B as $, C as I, bV as g, E as L } from "../../../../shared/runtime.js";
const H = { __name: "header", setup(O) {
  const { decimalPrecision: i } = Q(), w = { projectId: void 0, settlementStatus: S.UNSETTLEMENT.V, serialNumber: void 0, name: void 0, year: String((/* @__PURE__ */ new Date()).getFullYear()), projectManagerName: void 0 }, { crud: r, query: t, CRUD: N } = $(w), a = E({});
  N.HOOK.afterToQuery = () => {
    C();
  };
  async function C() {
    try {
      const m = await B({ ...r.query });
      a.value = m || {};
    } catch (m) {
      console.log("获取累计金额", m);
    }
  }
  return (m, l) => {
    const U = v("project-radio-button"), b = v("common-radio-button"), h = D, d = T, c = z, k = v("print-table"), A = j("permission");
    return u(), x("div", null, [_(Y("div", null, [n(U, { size: "default", type: "all", modelValue: e(t).projectId, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(t).projectId = o), class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), n(b, { modelValue: e(t).settlementStatus, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(t).settlementStatus = o), options: e(S).ENUM, showOptionAll: "", optionAllValue: void 0, type: "enum", class: "filter-item", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(h, { modelValue: e(t).year, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(t).year = o), type: "year", size: "default", class: "date-item filter-item", style: { width: "100px!important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), n(d, { modelValue: e(t).serialNumber, "onUpdate:modelValue": l[3] || (l[3] = (o) => e(t).serialNumber = o), modelModifiers: { trim: true }, placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(d, { modelValue: e(t).name, "onUpdate:modelValue": l[4] || (l[4] = (o) => e(t).name = o), modelModifiers: { trim: true }, placeholder: "项目搜索", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(d, { modelValue: e(t).projectManagerName, "onUpdate:modelValue": l[5] || (l[5] = (o) => e(t).projectManagerName = o), modelModifiers: { trim: true }, placeholder: "业务负责人搜索", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(d, { modelValue: e(t).customerUnit, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(t).customerUnit = o), modelModifiers: { trim: true }, placeholder: "客户名称搜索", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"]), n(e(I))], 512), [[M, e(r).searchToggle]]), n(e(L), null, { optLeft: s(() => [a.value ? (u(), p(c, { key: 0, size: "large", class: "filter-item" }, { default: s(() => [f(y(`累计合同额:${a.value.contractAmountSum ? e(g)(a.value.contractAmountSum, e(i).contract) : "-"}元`), 1)]), _: 1 })) : V("", true), a.value ? (u(), p(c, { key: 1, type: "success", size: "large", class: "filter-item" }, { default: s(() => [f(y(`累计结算额:${a.value.settlementAmountSum ? e(g)(a.value.settlementAmountSum, e(i).contract) : "-"}元`), 1)]), _: 1 })) : V("", true), a.value ? (u(), p(c, { key: 2, type: "success", size: "large", class: "filter-item" }, { default: s(() => [f(y(`累计收款额:${a.value.collectionAmountSum ? e(g)(a.value.collectionAmountSum, e(i).contract) : "-"}元`), 1)]), _: 1 })) : V("", true), a.value ? (u(), p(c, { key: 3, type: "success", size: "large", class: "filter-item" }, { default: s(() => [f(y(`累计开票额:${a.value.invoiceAmountSum ? e(g)(a.value.invoiceAmountSum, e(i).contract) : "-"}元`), 1)]), _: 1 })) : V("", true)]), viewLeft: s(() => [_(n(k, { "api-key": "contractLedger", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[A, e(r).permission.print]])]), _: 1 })]);
  };
} };
export {
  H as default
};
