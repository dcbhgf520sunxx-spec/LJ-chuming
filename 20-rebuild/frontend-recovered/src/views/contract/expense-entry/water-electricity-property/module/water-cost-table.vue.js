import { inject as m } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as u } from "vue";
import { unref as l } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as p } from "vue";
import { ElTableColumn as b } from "element-plus";
const h = { __name: "water-cost-table", emits: ["changeStatus"], setup(_, { emit: g }) {
  const t = m("columns");
  return (d, y) => {
    const n = b;
    return a(), u(p, null, [l(t).visible("month") ? (a(), r(n, { prop: "month", key: "month", label: "月份", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.month) + "月", 1)]), _: 1 })) : c("", true), l(t).visible("consumption") ? (a(), r(n, { prop: "consumption", key: "consumption", label: "用水量（吨）", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.consumption), 1)]), _: 1 })) : c("", true), l(t).visible("totalFee") ? (a(), r(n, { prop: "totalFee", key: "totalFee", label: "水费总额（元）", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.totalFee), 1)]), _: 1 })) : c("", true), l(t).visible("averageUnitPrice") ? (a(), r(n, { prop: "averageUnitPrice", key: "averageUnitPrice", label: "平均水费（元/吨）", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.averageUnitPrice), 1)]), _: 1 })) : c("", true), l(t).visible("branchCompanyName") ? (a(), r(n, { prop: "branchCompanyName", key: "branchCompanyName", label: "费用归属", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.branchCompanyName), 1)]), _: 1 })) : c("", true), l(t).visible("userName") ? (a(), r(n, { prop: "userName", label: "录入人", key: "userName", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.userName), 1)]), _: 1 })) : c("", true), l(t).visible("createTime") ? (a(), r(n, { prop: "createTime", label: "日期", key: "createTime", align: "center" }, { default: o(({ row: e }) => [i("span", null, s(e.createTime || "-"), 1)]), _: 1 })) : c("", true)], 64);
  };
} };
export {
  h as default
};
