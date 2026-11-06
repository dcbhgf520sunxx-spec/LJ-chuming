import { inject as m } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as u } from "vue";
import { unref as l } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as p } from "vue";
import { ElTableColumn as b } from "element-plus";
const y = { __name: "electric-cost-table", emits: ["changeStatus"], setup(_, { emit: g }) {
  const t = m("columns");
  return (h, d) => {
    const n = b;
    return a(), u(p, null, [l(t).visible("month") ? (a(), r(n, { prop: "month", key: "month", label: "月份", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.month) + "月", 1)]), _: 1 })) : s("", true), l(t).visible("consumption") ? (a(), r(n, { prop: "consumption", key: "consumption", label: "用电量（kw/h）", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.consumption), 1)]), _: 1 })) : s("", true), l(t).visible("totalFee") ? (a(), r(n, { prop: "totalFee", key: "totalFee", label: "电费总额（元）", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.totalFee), 1)]), _: 1 })) : s("", true), l(t).visible("averageUnitPrice") ? (a(), r(n, { prop: "averageUnitPrice", key: "averageUnitPrice", label: "平均电费（元/kw/h）", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.averageUnitPrice), 1)]), _: 1 })) : s("", true), l(t).visible("branchCompanyName") ? (a(), r(n, { prop: "branchCompanyName", key: "branchCompanyName", label: "费用归属", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.branchCompanyName), 1)]), _: 1 })) : s("", true), l(t).visible("userName") ? (a(), r(n, { prop: "userName", key: "userName", label: "录入人", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.userName), 1)]), _: 1 })) : s("", true), l(t).visible("createTime") ? (a(), r(n, { prop: "createTime", key: "createTime", label: "日期", align: "center" }, { default: o(({ row: e }) => [i("span", null, c(e.createTime), 1)]), _: 1 })) : s("", true)], 64);
  };
} };
export {
  y as default
};
