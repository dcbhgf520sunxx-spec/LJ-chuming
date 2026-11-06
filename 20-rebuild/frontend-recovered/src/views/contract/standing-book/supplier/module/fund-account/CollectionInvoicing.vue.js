import { inject as h } from "vue";
import { ref as g } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as e } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as s } from "vue";
import { unref as m } from "vue";
import { ElTableColumn as b } from "element-plus";
import { ElTable as f } from "element-plus";
import { e as x } from "../../../../../../modules/self-healing-6f411a5c.js";
import { o as v, ec as y } from "../../../../../../shared/runtime.js";
import { u as w } from "../../../../../../modules/useTableTotal-3d22365a.js";
const C = { class: "el-table" }, D = { key: 0 }, I = { key: 0 }, N = { __name: "CollectionInvoicing", setup(A) {
  const { projectInfo: d } = h("tableItem"), { maxHeight: p } = v({ paginate: true, extraBox: [".el-drawer__header", ".header-container", ".basic-info", ".collection-info"], mainBox: [".el-drawer__body"], extraHeight: "40" }), { getSummaries: _ } = w(false, { defineData: ["collectionAmount", "invoiceAmount"] }), i = g([]);
  return (async () => {
    try {
      const o = await x({ projectId: d.value.project.id });
      i.value = y(o);
    } catch (o) {
      console.error("获取收款开票详情失败:collection-invoicing.vue", o);
    }
  })(), (o, j) => {
    const t = b, u = f;
    return n(), l("div", C, [e(u, { data: i.value, "max-height": m(p), "summary-method": m(_), border: "", fit: "", "show-summary": "" }, { default: r(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "日期", prop: "date" }), e(t, { align: "center", label: "摘要", "min-width": "140", prop: "remark" }), e(t, { align: "right", label: "收款金额", prop: "collectionAmount" }, { default: r(({ row: { collectionAmount: a } }) => [a ? (n(), l("span", D, c(a), 1)) : s("", true)]), _: 1 }), e(t, { align: "right", label: "开票金额", prop: "invoiceAmount" }, { default: r(({ row: { invoiceAmount: a } }) => [a ? (n(), l("span", I, c(a), 1)) : s("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])]);
  };
} };
export {
  N as default
};
