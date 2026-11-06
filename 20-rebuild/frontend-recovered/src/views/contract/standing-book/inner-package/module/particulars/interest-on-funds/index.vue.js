import { inject as T } from "vue";
import { ref as i } from "vue";
import { watch as I } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as j } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as D } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { unref as g } from "vue";
import { createTextVNode as B } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTable as C } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as E } from "element-plus";
import { a as R } from "../../../../../../../modules/interest-on-funds-096f2ac3.js";
import { o as H, i as N, ec as q } from "../../../../../../../shared/runtime.js";
import { u as V } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import M from "./detail.vue.js";
const S = { class: "interest-funds-container" }, K = { __name: "index", setup(U) {
  const { projectInfo: m } = T("parent_data"), l = i(false), n = i([]), o = i(false), c = i([]), { maxHeight: _ } = H({ extraBox: [".el-button-group"], mainBox: [".app-container", ".drawer-container"], extraHeight: 50 }), { requestData: b, getSummaries: v } = V(false, { defineData: ["dailyAmount", "settlementInterest", "liabilities", "negativeAmount"] }), p = async () => {
    o.value = true;
    try {
      const e = await R({ projectId: m.project.id, ...b });
      N(e) ? n.value = q(e) : n.value = [];
    } catch (e) {
      n.value = [], console.error("index.vue:获取资金利息列表失败-- /api/project/v2/costReportguarternterest" + e);
    } finally {
      o.value = false;
    }
  };
  p();
  const u = i(), f = (e) => {
    u.value = e.projectId, c.value.push(new Date(e.interestTime).getTime(), new Date(e.expireTime).getTime()), l.value = true;
  };
  return I(() => m.project.id, (e) => {
    e && p();
  }), (e, r) => {
    const a = A, x = C, h = L, y = E;
    return d(), j("div", S, [k((d(), D(x, { data: n.value, "max-height": g(_), "summary-method": g(v), border: "", "show-summary": "", style: { cursor: "pointer" }, onRowClick: f }, { default: s(() => [t(a, { align: "center", label: "序号", type: "index", width: "50" }), t(a, { align: "center", label: "垫资日积数", prop: "dailyAmount" }), t(a, { align: "center", label: "结息起至日期" }, { default: s(() => [t(a, { align: "center", label: "结息日期", prop: "interestTime" }), t(a, { align: "center", label: "到期日期", prop: "expireTime" })]), _: 1 }), t(a, { align: "center", label: "结息天数", prop: "settlementDay" }), t(a, { align: "center", label: "日利息", "min-width": "120", prop: "annualInterest" }), t(a, { align: "center", label: "结算利息金额", "min-width": "100", prop: "settlementInterest" }), t(a, { align: "center", label: "本次结算利息", "min-width": "120", prop: "liabilities" })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[y, o.value]]), t(h, { style: { "margin-top": "10px" }, type: "primary" }, { default: s(() => r[1] || (r[1] = [B("* 可点击单行查看当前资金明细")])), _: 1, __: [1] }), t(M, { visible: l.value, "onUpdate:visible": r[0] || (r[0] = (w) => l.value = w), itemId: u.value, time_array: c.value }, null, 8, ["visible", "itemId", "time_array"])]);
  };
} };
export {
  K as default
};
