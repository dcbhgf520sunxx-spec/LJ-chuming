import { inject as g } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as S } from "vue";
import { unref as a } from "vue";
import { createBlock as o } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as c } from "vue";
import { createVNode as f } from "vue";
import { Fragment as y } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElSwitch as C } from "element-plus";
import { aS as b } from "../../../../../shared/runtime.js";
const F = { __name: "property-cost-table", emits: ["changeStatus"], setup(k, { emit: _ }) {
  const l = g("columns"), d = _;
  function h(m, i) {
    d("changeStatus", m, i);
  }
  return (m, i) => {
    const n = N, v = C;
    return t(), S(y, null, [a(l).visible("month") ? (t(), o(n, { prop: "month", key: "month", label: "月份", align: "center" }, { default: s(({ row: e }) => [u("span", null, r(e.month) + "月", 1)]), _: 1 })) : c("", true), a(l).visible("totalFee") ? (t(), o(n, { prop: "totalFee", key: "totalFee", label: "物业费（元）", align: "center" }, { default: s(({ row: e }) => [u("span", null, r(e.totalFee), 1)]), _: 1 })) : c("", true), a(l).visible("branchCompanyName") ? (t(), o(n, { prop: "branchCompanyName", key: "branchCompanyName", label: "费用归属", align: "center" }, { default: s(({ row: e }) => [u("span", null, r(e.branchCompanyName), 1)]), _: 1 })) : c("", true), a(l).visible("userName") ? (t(), o(n, { prop: "userName", key: "userName", label: "录入人", align: "center" }, { default: s(({ row: e }) => [u("span", null, r(e.userName), 1)]), _: 1 })) : c("", true), a(l).visible("createTime") ? (t(), o(n, { prop: "createTime", key: "createTime", label: "日期", align: "center" }, { default: s(({ row: e }) => [u("span", null, r(e.createTime), 1)]), _: 1 })) : c("", true), a(l).visible("boolStatus") ? (t(), o(n, { key: 5, prop: "boolStatus", label: "状态", align: "center" }, { default: s(({ row: e }) => [f(v, { modelValue: e.boolStatus, "onUpdate:modelValue": (p) => e.boolStatus = p, "active-value": a(b).TRUE.V, "inactive-value": a(b).FALSE.V, class: "drawer-switch", onChange: (p) => h(e, e.boolStatus) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])]), _: 1 })) : c("", true)], 64);
  };
} };
export {
  F as default
};
