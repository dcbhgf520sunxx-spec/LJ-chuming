import { useAttrs as T } from "vue";
import { ref as u } from "vue";
import { watch as k } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as e } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as H } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as V } from "vue";
import { unref as s } from "vue";
import { ElButton as q } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElDrawer as A } from "element-plus";
import { vLoading as j } from "element-plus";
import { g as F } from "../../../../../../../modules/interest-on-funds-096f2ac3.js";
import { o as M, dp as N, eb as S, ec as z } from "../../../../../../../shared/runtime.js";
import { u as _ } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const P = { class: "interest-funds-container" }, Q = { __name: "detail", emits: ["update:visible"], setup(U, { emit: b }) {
  const t = T(), { maxHeight: g } = M({ extraBox: [".el-drawer__header"], wrapperBox: [], paginate: true, extraHeight: 20 }), i = u([]), r = u(false), { requestData: c, total: m } = _(), d = async () => {
    r.value = true;
    try {
      const { totalElements: o, content: l } = await F({ projectId: t.itemId, startDate: t.time_array[0], endDate: t.time_array[1], ...c });
      m.value = o, i.value = z(l);
    } catch (o) {
      console.error("获取资金利息详情失败" + o);
    } finally {
      r.value = false;
    }
  };
  k(() => t.itemId, (o) => {
    o && d();
  });
  const f = b, h = () => {
    f("update:visible", false);
  }, { getSummaries: v } = _(false, { defineData: ["income", "expenditure"] });
  return (o, l) => {
    const x = q, a = L, y = C("common-table"), w = A, D = j;
    return p(), E("div", P, [e(w, { modelValue: s(t).visible, "onUpdate:modelValue": l[0] || (l[0] = (B) => s(t).visible = B), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "50%" }, { header: n(() => [e(N, { "type-one": false, "header-title": "资金明细" }), e(x, { onClick: h }, { default: n(() => l[1] || (l[1] = [H("关闭")])), _: 1, __: [1] })]), default: n(() => [I((p(), V(y, { data: i.value, "max-height": s(g), "summary-method": s(v), border: "", "show-summary": "" }, { default: n(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "日期", prop: "createTime" }), e(a, { align: "center", label: "收入", prop: "income" }), e(a, { align: "center", label: "支出", prop: "expenditure" }), e(a, { align: "center", label: "余额", prop: "remainingSum" }), e(a, { align: "center", label: "负数金额", prop: "liabilities" }), e(a, { align: "center", label: "负数天数", prop: "liabilitiesDay" }), e(a, { align: "center", label: "日积数", prop: "dailyAmount" })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[D, r.value]]), e(S, { "request-data": s(c), total: s(m), onHandleChange: d }, null, 8, ["request-data", "total"])]), _: 1 }, 8, ["modelValue"])]);
  };
} };
export {
  Q as default
};
