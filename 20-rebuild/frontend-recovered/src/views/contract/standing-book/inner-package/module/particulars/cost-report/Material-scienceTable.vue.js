import { inject as k } from "vue";
import { ref as T } from "vue";
import { watch as g } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as M } from "vue";
import { renderSlot as B } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as h } from "vue";
import { unref as c } from "vue";
import { ElTableColumn as C } from "element-plus";
import { ElTag as E } from "element-plus";
import { a as I } from "../../../../../../../modules/cost-report-60aee68e.js";
import { _ as A, o as N, eb as S, ec as q } from "../../../../../../../shared/runtime.js";
import { u as H } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const P = { class: "managementFee-table" }, V = { __name: "Material-scienceTable", props: { reportItem: { type: Object } }, setup(y) {
  const p = y, x = k("parent_data"), { projectInfo: u } = x, n = T([]), { requestData: m, total: d, getSummaries: v } = H(false, { defineData: ["contractAmount", "settlementAmount", "totalPaid", "unpaid"] }), { maxHeight: w } = N({ extraBox: [".el-button-group", ".report-container", ".el-radio-group", ".header-container"], mainBox: [".app-container", ".drawer-container"], wrapperBox: [], paginate: true }), l = async () => {
    if (p.reportItem.key !== "materialCost") {
      n.value = [];
      return;
    }
    try {
      const { content: a, totalElements: o } = await I({ ...m, projectId: u.project.id });
      n.value = q(a), d.value = o, n.value.forEach((e) => {
        Object.keys(e).forEach((r) => {
          (e[r] == null || e[r] === "") && (e[r] = "-");
        });
      });
    } catch (a) {
      console.log("获取材料支出明细失败" + a);
    }
  };
  return l(), g(() => u, (a) => {
    a.project.id && l();
  }, { deep: true }), g(() => p.reportItem, async (a) => {
    a && await l();
  }, { deep: true }), (a, o) => {
    const e = C, r = E, j = D("common-table");
    return i(), M("div", P, [B(a.$slots, "default", {}, void 0, true), t(j, { data: n.value, "max-height": c(w), "summary-method": c(v), border: "", "show-summary": "", stripe: "" }, { default: s(() => [t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { align: "center", label: "状态" }, { default: s(({ row: _ }) => [_.status === 0 ? (i(), f(r, { key: 0, type: "danger" }, { default: s(() => o[0] || (o[0] = [b("未结算")])), _: 1, __: [0] })) : h("", true), _.status === 1 ? (i(), f(r, { key: 1, type: "success" }, { default: s(() => o[1] || (o[1] = [b("已结算")])), _: 1, __: [1] })) : h("", true)]), _: 1 }), t(e, { align: "center", label: "供应商", prop: "supplierName" }), t(e, { align: "center", label: "合同编号", "min-width": "120", prop: "serialNumber", "show-overflow-tooltip": "" }), t(e, { align: "center", label: "合同额", prop: "contractAmount" }), t(e, { align: "center", label: "结算额", prop: "settlementAmount" }), t(e, { align: "center", label: "累计已付款", prop: "totalPaid" }), t(e, { align: "center", label: "未付款", prop: "unpaid" })]), _: 1 }, 8, ["data", "max-height", "summary-method"]), t(S, { "request-data": c(m), total: c(d), onHandleChange: l }, null, 8, ["request-data", "total"])]);
  };
} }, G = A(V, [["__scopeId", "data-v-54131aa1"]]);
export {
  G as default
};
