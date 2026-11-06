import { ref as _ } from "vue";
import { inject as T } from "vue";
import { watch as j } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as x } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as i } from "vue";
import { unref as p } from "vue";
import { createCommentVNode as M } from "vue";
import { Fragment as N } from "vue";
import { ElTableColumn as V } from "element-plus";
import { ElTable as q } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as I, o as L, bv as R, iW as P, eb as S, l5 as U, ec as $ } from "../../../../../../../../shared/runtime.js";
import { u as F } from "../../../../../../../../modules/useTableTotal-3d22365a.js";
import O from "./expend-detail/index.vue.js";
const W = { class: "table-container" }, z = { class: "" }, G = { key: 0 }, J = { key: 1 }, K = ["onClick"], Q = { key: 1 }, X = ["onClick"], Y = { key: 1 }, Z = { __name: "ExpendTable", setup(ee, { expose: w }) {
  const v = _([]), { projectInfo: u } = T("parent_data"), { maxHeight: k } = L({ extraBox: [".el-button-group", ".box-container", ".header-btn-container"], wrapperBox: [".app-container", ".drawer-container"], paginate: true, extraHeight: 60 }), d = _(false), b = _(false), { requestData: g, total: h, getSummaries: C } = F(false, { defineData: ["projectAmount", "expenseMoney", "invoiceAmount"] }), f = _(), m = async () => {
    b.value = true;
    try {
      const { content: a, totalElements: c } = await U({ projectId: u.project.id, ...g });
      v.value = $(a, ["expenseType"]), h.value = c, console.log(v.value);
    } catch (a) {
      console.log("获取项目支出信息失败" + a);
    } finally {
      b.value = false;
    }
  };
  m(), j(() => {
    var a;
    return (a = u == null ? void 0 : u.project) == null ? void 0 : a.id;
  }, (a) => {
    m();
  });
  const y = (a, c) => {
    f.value = { ...c, mark: a }, d.value = true;
  };
  return w({ getList: m }), (a, c) => {
    const n = V, E = q, A = H;
    return o(), s(N, null, [r("div", W, [B((o(), x(E, { data: v.value, "max-height": p(k), "summary-method": p(C), border: "", "show-summary": "" }, { default: l(() => [t(n, { align: "center", label: "序号", type: "index", width: "60" }), t(n, { align: "center", label: "供应商", "min-width": "140", prop: "supplierName", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [r("div", z, [r("span", null, i(e.supplierName), 1)])]), _: 1 }), t(n, { align: "center", label: "类型", "min-width": "80", prop: "expenseType" }, { default: l(({ row: e }) => [r("span", null, i(p(R).getBits(p(P).ENUM, e.expenseType, "L").join(" | ")), 1)]), _: 1 }), t(n, { align: "center", label: "合同编号", "min-width": "120", prop: "purchaseContractNumber", "show-overflow-tooltip": "" }), t(n, { align: "center", label: "合同额", "min-width": "100", prop: "projectAmount" }), t(n, { align: "center", label: "结算额", prop: "settlementAmount" }, { default: l(({ row: e }) => [e.settlementAmount ? (o(), s("span", G, i(e.settlementAmount), 1)) : (o(), s("span", J, "-"))]), _: 1 }), t(n, { align: "center", label: "累计付款", "min-width": "100", prop: "expenseMoney" }, { default: l(({ row: e }) => [e.expenseMoney ? (o(), s("span", { key: 0, class: "accessible", onClick: (D) => y("payment", e) }, i(e.expenseMoney), 9, K)) : (o(), s("span", Q, "-"))]), _: 1 }), t(n, { align: "center", label: "付款率", prop: "paymentRate" }, { default: l(({ row: e }) => [r("span", null, i(e.paymentRate + "%"), 1)]), _: 1 }), t(n, { align: "center", label: "累计收票", prop: "invoiceAmount", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [e.invoiceAmount ? (o(), s("span", { key: 0, class: "accessible", onClick: (D) => y("collect_ticket", e) }, i(e.invoiceAmount), 9, X)) : (o(), s("span", Y, "-"))]), _: 1 }), t(n, { align: "center", label: "收票率", prop: "invoiceRate" }, { default: l(({ row: e }) => [r("span", null, i(e.invoiceRate + "%"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[A, b.value]]), t(S, { "request-data": p(g), total: p(h), onHandleChange: m }, null, 8, ["request-data", "total"])]), d.value ? (o(), x(O, { key: 0, visible: d.value, "onUpdate:visible": c[0] || (c[0] = (e) => d.value = e), item_info: f.value }, null, 8, ["visible", "item_info"])) : M("", true)], 64);
  };
} }, le = I(Z, [["__scopeId", "data-v-c1fdd432"]]);
export {
  le as default
};
