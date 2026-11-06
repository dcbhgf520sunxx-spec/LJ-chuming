import { inject as I } from "vue";
import { ref as n } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as e } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as w } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as D } from "vue";
import { unref as u } from "vue";
import { ElTag as j } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { ElTable as C } from "element-plus";
import { vLoading as L } from "element-plus";
import { a as A } from "../../../../../../../modules/interest-on-funds-096f2ac3.js";
import { o as R, i as E, ec as H } from "../../../../../../../shared/runtime.js";
import { u as N } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import q from "../../../../inner-package/module/particulars/interest-on-funds/detail.vue.js";
const V = { class: "interest-funds-container" }, J = { __name: "index", setup(M) {
  const { projectId: d } = I("common"), r = n(false), i = n([]), o = n(false), m = n([]), { maxHeight: g } = R({ extraBox: [".el-button-group"], mainBox: [".app-container", ".drawer-container"], extraHeight: 50 }), { requestData: b, getSummaries: _ } = N(false, { defineData: ["dailyAmount", "settlementInterest", "liabilities", "negativeAmount"] });
  (async () => {
    o.value = true;
    try {
      const t = await A({ projectId: d.value, ...b });
      E(t) ? i.value = H(t) : i.value = [];
    } catch (t) {
      i.value = [], console.error("index.vue:获取资金利息列表失败-- /api/project/v2/costReportguarternterest" + t);
    } finally {
      o.value = false;
    }
  })();
  const c = n(), v = (t) => {
    c.value = t.projectId, m.value.push(new Date(t.interestTime).getTime(), new Date(t.expireTime).getTime()), r.value = true;
  };
  return (t, l) => {
    const f = j, a = B, x = C, y = L;
    return p(), T("div", V, [e(f, { style: { "margin-bottom": "10px" }, type: "primary" }, { default: s(() => l[1] || (l[1] = [w("* 可点击单行查看当前资金明细")])), _: 1, __: [1] }), k((p(), D(x, { data: i.value, "max-height": u(g), "summary-method": u(_), border: "", "show-summary": "", style: { cursor: "pointer" }, onRowClick: v }, { default: s(() => [e(a, { align: "center", label: "序号", type: "index", width: "50" }), e(a, { align: "center", label: "垫资日积数", prop: "dailyAmount" }), e(a, { align: "center", label: "结息起至日期" }, { default: s(() => [e(a, { align: "center", label: "结息日期", prop: "interestTime" }), e(a, { align: "center", label: "到期日期", prop: "expireTime" })]), _: 1 }), e(a, { align: "center", label: "结息天数", prop: "settlementDay" }), e(a, { align: "center", label: "日利息", "min-width": "120", prop: "annualInterest" }), e(a, { align: "center", label: "结算利息金额", "min-width": "100", prop: "settlementInterest" }), e(a, { align: "center", label: "本次结算利息", "min-width": "120", prop: "liabilities" })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[y, o.value]]), e(q, { visible: r.value, "onUpdate:visible": l[0] || (l[0] = (h) => r.value = h), itemId: c.value, time_array: m.value }, null, 8, ["visible", "itemId", "time_array"])]);
  };
} };
export {
  J as default
};
