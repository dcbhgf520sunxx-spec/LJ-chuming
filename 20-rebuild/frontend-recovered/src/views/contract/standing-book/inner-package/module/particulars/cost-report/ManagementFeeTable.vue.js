import { inject as b } from "vue";
import { ref as f } from "vue";
import { watch as h } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as y } from "vue";
import { renderSlot as v } from "vue";
import { createVNode as e } from "vue";
import { withCtx as w } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as M } from "element-plus";
import { g as T } from "../../../../../../../modules/cost-report-60aee68e.js";
import { _ as D, o as j, eb as B, ec as C } from "../../../../../../../shared/runtime.js";
import { u as i } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const q = { class: "managementFee-table" }, A = { __name: "ManagementFeeTable", setup(E) {
  const p = b("parent_data"), { projectInfo: r } = p, l = f([]), { requestData: s, total: m } = i(), { maxHeight: d } = j({ extraBox: [".el-button-group", ".report-container", ".el-radio-group", ".header-container"], mainBox: [".app-container", ".drawer-container"], wrapperBox: [], paginate: true }), o = async () => {
    try {
      const { content: a, totalElements: c } = await T({ ...s, projectId: r.project.id });
      l.value = C(a), m.value = c;
    } catch (a) {
      console.log("获取管理费失败" + a);
    }
  };
  o();
  const { getSummaries: u } = i(false, { defineData: ["incomeAmount", "managementFee"] }), _ = [["managementFeeRate", ["suffix", "%"]]];
  return h(() => r, (a) => {
    a.project.id && o();
  }, { deep: true }), (a, c) => {
    const t = M, g = x("common-table");
    return F(), y("div", q, [v(a.$slots, "default", {}, void 0, true), e(g, { data: l.value, "data-format": _, "max-height": n(d), "summary-method": n(u), border: "", fit: "", "show-summary": "", stripe: "" }, { default: w(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "日期", prop: "createTime" }), e(t, { align: "center", label: "编号", prop: "serialNumber" }), e(t, { align: "center", label: "收入", prop: "incomeAmount" }), e(t, { align: "center", label: "管理费率", prop: "managementFeeRate" }), e(t, { align: "center", label: "金额", prop: "managementFee" })]), _: 1 }, 8, ["data", "max-height", "summary-method"]), e(B, { "request-data": n(s), total: n(m), onHandleChange: o }, null, 8, ["request-data", "total"])]);
  };
} }, R = D(A, [["__scopeId", "data-v-9c7427d6"]]);
export {
  R as default
};
