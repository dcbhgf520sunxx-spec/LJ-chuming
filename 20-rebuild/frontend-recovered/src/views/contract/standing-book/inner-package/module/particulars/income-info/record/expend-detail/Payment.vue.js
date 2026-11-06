import { useAttrs as p } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as u } from "vue";
import { unref as t } from "vue";
import { ElTableColumn as _ } from "element-plus";
import { ElTable as b } from "element-plus";
import { o as h, iv as g } from "../../../../../../../../../shared/runtime.js";
import { u as y } from "../../../../../../../../../modules/useTableTotal-3d22365a.js";
const C = { __name: "Payment", setup(x) {
  const { maxHeight: o } = h({ mainBox: [".app-container", "el-drawer", ".el-drawer__body"], extraBox: [".el-drawer__header", ".basic-info"], extraHeight: "20" }), { table_data: r } = p(), { getSummaries: l } = y(false, { defineData: ["paymentAmount"] });
  return (f, w) => {
    const e = _, s = b;
    return i(), c(s, { data: t(r), "max-height": t(o), "summary-method": t(l), border: "", "show-summary": "", stripe: "" }, { default: n(() => [a(e, { align: "center", label: "序号", type: "index", width: "60" }), a(e, { align: "center", label: "编号", prop: "number" }), a(e, { align: "center", label: "支付日期", prop: "paymentDate" }), a(e, { align: "center", label: "支付金额（元）", prop: "paymentAmount" }), a(e, { align: "center", label: "支付方式", prop: "type" }, { default: n(({ row: m }) => [d("span", null, u(t(g).VL[m.type]), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"]);
  };
} };
export {
  C as default
};
