import { inject as h } from "vue";
import { ref as b } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as e } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as i } from "vue";
import { unref as p } from "vue";
import { ElTableColumn as g } from "element-plus";
import { ElTable as f } from "element-plus";
import { d as x } from "../../../../../../modules/self-healing-6f411a5c.js";
import { o as y, ec as w } from "../../../../../../shared/runtime.js";
import { u as E } from "../../../../../../modules/useTableTotal-3d22365a.js";
const j = { class: "el-table" }, T = { key: 0 }, k = { key: 1 }, v = { key: 0 }, D = { key: 1 }, M = { __name: "AccumulatedExpenses", setup(A) {
  const { projectInfo: m } = h("tableItem"), { maxHeight: u } = y({ paginate: true, extraBox: [".el-drawer__header", ".header-container", ".basic-info", ".collection-info"], mainBox: [".el-drawer__body"], extraHeight: "60" }), { getSummaries: d } = E(false, { defineData: ["projectAmount", "expenseMoney", "surplus"] }), c = b([]);
  return (async () => {
    try {
      const { content: t } = await x({ projectId: m.value.project.id });
      t.forEach((s) => {
        s.surplus = Number(s.projectAmount) - Number(s.expenseMoney);
      }), c.value = w(t);
    } catch (t) {
      console.error("获取收款开票详情失败:collection-invoicing.vue", t);
    }
  })(), (t, s) => {
    const a = g, _ = f;
    return n(), r("div", j, [e(_, { data: c.value, "max-height": p(u), "summary-method": p(d), border: "", fit: "", "show-summary": "" }, { default: l(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "类别", prop: "purchaseContractNumber" }), e(a, { align: "right", label: "合同额", prop: "projectAmount" }), e(a, { align: "right", label: "累计支出", prop: "expenseMoney" }, { default: l(({ row: { expenseMoney: o } }) => [o ? (n(), r("span", T, i(o), 1)) : (n(), r("span", k, "-"))]), _: 1 }), e(a, { align: "right", label: "预计剩余未支付", prop: "surplus" }, { default: l(({ row: { surplus: o } }) => [o ? (n(), r("span", v, i(o.toFixed(2)), 1)) : (n(), r("span", D, "-"))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])]);
  };
} };
export {
  M as default
};
