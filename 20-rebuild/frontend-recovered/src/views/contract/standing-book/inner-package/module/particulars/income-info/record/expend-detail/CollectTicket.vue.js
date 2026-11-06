import { useAttrs as i } from "vue";
import { openBlock as p } from "vue";
import { createBlock as c } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as _ } from "vue";
import { unref as t } from "vue";
import { ElTableColumn as d } from "element-plus";
import { ElTable as b } from "element-plus";
import { o as h, bD as g } from "../../../../../../../../../shared/runtime.js";
import { u as x } from "../../../../../../../../../modules/useTableTotal-3d22365a.js";
const D = { __name: "CollectTicket", setup(y) {
  const { maxHeight: n } = h({ mainBox: [".app-container", "el-drawer", ".el-drawer__body"], extraBox: [".el-drawer__header", ".basic-info"], extraHeight: "20" }), { table_data: r } = i(), { getSummaries: l } = x(false, { defineData: ["paymentAmount"] });
  return (f, w) => {
    const e = d, s = b;
    return p(), c(s, { data: t(r), "max-heigh": t(n), "summary-method": t(l), border: "", "show-summary": "", stripe: "" }, { default: o(() => [a(e, { align: "center", label: "序号", type: "index", width: "60" }), a(e, { align: "center", label: "发票编号", prop: "number" }), a(e, { align: "center", label: "入账日期", prop: "paymentDate" }), a(e, { align: "center", label: "票面金额（元）", prop: "paymentAmount" }), a(e, { align: "center", label: "发票类型", prop: "type" }, { default: o(({ row: m }) => [u("span", null, _(t(g).VL[m.type]), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-heigh", "summary-method"]);
  };
} };
export {
  D as default
};
