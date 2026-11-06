import { defineComponent as s } from "vue";
import { openBlock as e } from "vue";
import { createElementBlock as b } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as n } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as u } from "vue";
import { unref as o } from "vue";
import { Fragment as d } from "vue";
import { ElTableColumn as p } from "element-plus";
import { z as y, p as m } from "../shared/runtime.js";
const h = s({ __name: "raw-materials", props: ["columns"], setup(t) {
  return (g, v) => {
    const l = p;
    return e(), b(d, null, [t.columns.visible("classifyName") ? (e(), i(l, { key: "classifyName", width: "140", label: "物料名称", align: "center", prop: "classifyName" })) : n("", true), t.columns.visible("specification") ? (e(), i(l, { key: "specification", label: "规格", align: "center", width: "180", prop: "specification", "show-overflow-tooltip": "" })) : n("", true), t.columns.visible("brand") ? (e(), i(l, { key: "brand", label: "品牌", align: "center", prop: "brand", "show-overflow-tooltip": "" })) : n("", true), t.columns.visible("measureUnit") ? (e(), i(l, { key: "measureUnit", label: "计量单位", align: "center", prop: "measureUnit", width: "120" })) : n("", true), t.columns.visible("quantity") ? (e(), i(l, { label: "入库数量", key: "quantity", align: "center", prop: "quantity", width: "100" })) : n("", true), t.columns.visible("accountingUnit") ? (e(), i(l, { key: "accountingUnit", label: "核算单位", align: "center", prop: "accountingUnit", width: "120" })) : n("", true), t.columns.visible("mete") ? (e(), i(l, { key: "mete", label: "核算量", align: "center", prop: "mete", width: "90" })) : n("", true), t.columns.visible("actualReceivedMete") ? (e(), i(l, { key: "actualReceivedMete", label: "实收量", align: "center", prop: "actualReceivedMete", width: "90" })) : n("", true), t.columns.visible("priceExcludingVat") ? (e(), i(l, { key: "priceExcludingVat", label: "不含税单价", align: "center", width: "120", prop: "priceExcludingVat" })) : n("", true), t.columns.visible("amountExcludingVat") ? (e(), i(l, { key: 9, label: "不含税金额", align: "center", width: "120", prop: "amountExcludingVat" })) : n("", true), t.columns.visible("price") ? (e(), i(l, { key: "price", label: "含税单价", align: "center", prop: "price" })) : n("", true), t.columns.visible("amount") ? (e(), i(l, { key: "amount", label: "含税金额", align: "center", prop: "amount" })) : n("", true), t.columns.visible("rejectAmount") ? (e(), i(l, { key: "rejectAmount", label: "退货金额", align: "center", prop: "rejectAmount" })) : n("", true), t.columns.visible("adjustAmount") ? (e(), i(l, { key: "adjustAmount", label: "调整金额", align: "center", prop: "adjustAmount" })) : n("", true), t.columns.visible("realityInboundAmount") ? (e(), i(l, { width: "100", key: "realityInboundAmount", label: "实际入库额", prop: "realityInboundAmount", align: "center" })) : n("", true), t.columns.visible("project") ? (e(), i(l, { key: "project", label: "项目", width: "200", align: "center" }, { default: c(({ row: a }) => [r("span", null, u(o(y)(a.project)), 1)]), _: 1 })) : n("", true), t.columns.visible("inboundSerialNumber") ? (e(), i(l, { key: "inboundSerialNumber", label: "入库单号", align: "center", prop: "inboundSerialNumber", width: "160" })) : n("", true), t.columns.visible("applicant") ? (e(), i(l, { key: "applicant", label: "办理人", align: "center", prop: "applicant.name", width: "100" })) : n("", true), t.columns.visible("applicantDate") ? (e(), i(l, { key: "applicantDate", label: "办理日期", width: "140", align: "center" }, { default: c(({ row: a }) => [r("span", null, u(o(m)(a.applicantDate, "{y}-{m}-{d}")), 1)]), _: 1 })) : n("", true), t.columns.visible("reviewer") ? (e(), i(l, { key: "reviewer", label: "审核人", width: "100", align: "center", prop: "reviewer.name" })) : n("", true), t.columns.visible("reviewerDate") ? (e(), i(l, { key: "reviewerDate", label: "审核日期", width: "140", align: "center" }, { default: c(({ row: a }) => [r("span", null, u(o(m)(a.reviewerDate, "{y}-{m}-{d}")), 1)]), _: 1 })) : n("", true)], 64);
  };
} });
export {
  h as _
};
