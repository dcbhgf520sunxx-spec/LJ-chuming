import { openBlock as e } from "vue";
import { createElementBlock as c } from "vue";
import { createBlock as a } from "vue";
import { createCommentVNode as l } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as r } from "vue";
import { unref as u } from "vue";
import { createVNode as s } from "vue";
import { Fragment as p } from "vue";
import { ElTableColumn as d } from "element-plus";
import { z as b, jQ as w, p as f } from "../../../../shared/runtime.js";
const h = { key: 0 }, N = { __name: "finished-products", props: ["columns"], setup(o) {
  return (y, v) => {
    const t = d;
    return e(), c(p, null, [o.columns.visible("manufacturedName") ? (e(), a(t, { key: "manufacturedName", align: "center", label: "商品名称", prop: "manufacturedName", "show-overflow-tooltip": "", width: "100" })) : l("", true), o.columns.visible("finishedGoodsTypeName") ? (e(), a(t, { key: "finishedGoodsTypeName", align: "center", label: "分类名称", prop: "finishedGoodsTypeName", "show-overflow-tooltip": "", width: "100" })) : l("", true), o.columns.visible("manufacturedSn") ? (e(), a(t, { key: "manufacturedSn", align: "center", label: "编号", prop: "manufacturedSn", "show-overflow-tooltip": "", width: "100" })) : l("", true), o.columns.visible("project") ? (e(), a(t, { key: "project", align: "left", label: "项目", prop: "project.shortName", "show-overflow-tooltip": "", width: "180" }, { default: n(({ row: i }) => [m("span", null, r(u(b)(i.project)), 1)]), _: 1 })) : l("", true), o.columns.visible("quantity") ? (e(), a(t, { key: "quantity", align: "center", label: "入库数量", prop: "quantity", "show-overflow-tooltip": "", width: "100" })) : l("", true), o.columns.visible("specification") ? (e(), a(t, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "180" })) : l("", true), o.columns.visible("material") ? (e(), a(t, { key: "material", align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "", width: "100" })) : l("", true), s(t, { key: "accountingUnit", align: "center", label: "核算单位", prop: "manufacturedUnit", "show-overflow-tooltip": "" }, { default: n(({ row: i }) => [i.wageQuotaType ? (e(), c("span", h, r(u(w).V[i.wageQuotaType].C_UNIT), 1)) : l("", true)]), _: 1 }), o.columns.visible("mete") ? (e(), a(t, { key: "mete", align: "center", label: "核算量", prop: "mete", width: "90" })) : l("", true), o.columns.visible("priceExcludingVat") ? (e(), a(t, { key: "priceExcludingVat", align: "center", label: "不含税单价", prop: "priceExcludingVat", "show-overflow-tooltip": "", width: "120" })) : l("", true), o.columns.visible("amountExcludingVat") ? (e(), a(t, { key: 9, align: "center", label: "不含税金额", prop: "amountExcludingVat", "show-overflow-tooltip": "", width: "120" })) : l("", true), o.columns.visible("price") ? (e(), a(t, { key: "price", align: "center", label: "含税单价", prop: "price", "show-overflow-tooltip": "" })) : l("", true), o.columns.visible("amount") ? (e(), a(t, { key: "amount", align: "center", label: "含税金额", prop: "amount", "show-overflow-tooltip": "" })) : l("", true), o.columns.visible("rejectAmount") ? (e(), a(t, { key: "rejectAmount", align: "center", label: "退货金额", prop: "rejectAmount", "show-overflow-tooltip": "" })) : l("", true), o.columns.visible("realityInboundAmount") ? (e(), a(t, { key: "realityInboundAmount", align: "center", label: "实际入库额", prop: "realityInboundAmount", "show-overflow-tooltip": "", width: "100" })) : l("", true), o.columns.visible("inboundSerialNumber") ? (e(), a(t, { key: "inboundSerialNumber", align: "center", label: "入库单号", prop: "inboundSerialNumber", width: "160" })) : l("", true), o.columns.visible("applicant") ? (e(), a(t, { key: "applicant", align: "center", label: "办理人", prop: "applicant.name", width: "100" })) : l("", true), o.columns.visible("applicantDate") ? (e(), a(t, { key: "applicantDate", align: "center", label: "办理日期", width: "140" }, { default: n(({ row: i }) => [m("span", null, r(u(f)(i.applicantDate, "{y}-{m}-{d}")), 1)]), _: 1 })) : l("", true)], 64);
  };
} };
export {
  N as default
};
