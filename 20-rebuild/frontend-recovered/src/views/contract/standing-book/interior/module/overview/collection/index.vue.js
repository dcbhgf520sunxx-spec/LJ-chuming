import { inject as w } from "vue";
import { ref as d } from "vue";
import { computed as D } from "vue";
import { watch as C } from "vue";
import { onUnmounted as T } from "vue";
import { onBeforeMount as U } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as e } from "vue";
import { unref as r } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as A } from "vue";
import { withCtx as P } from "vue";
import { Fragment as V } from "vue";
import { ElDatePicker as Y } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { vLoading as Q } from "element-plus";
import { _ as R, x as j, D as i, P as q } from "../../../../../../../shared/runtime.js";
import { d as E } from "../../../../../../../modules/index-1f7d934b.js";
import { u as I } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const M = { class: "header box-container" }, O = { class: "table-container" }, S = { __name: "index", setup(H) {
  const { projectId: c } = w("common"), _ = d(), s = /* @__PURE__ */ new Date(), n = d([new Date(s.getFullYear(), s.getMonth(), 1).getTime(), new Date(s.getFullYear(), s.getMonth() + 1, 0).getTime()]), o = { projectId: D(() => c.value) }, { crud: a, CRUD: g } = j({ title: "收支台账", crudApi: { get: E }, queryOnPresenterCreated: false }, _);
  g.HOOK.beforeToQuery = () => {
    var l;
    (l = n.value) != null && l.length ? (o.startDate = n.value[0], o.endDate = n.value[1]) : (o.startDate = void 0, o.endDate = void 0);
  }, C(() => c.value, (l) => {
    l && (a.query = o, a.toQuery());
  }, { immediate: true });
  const { getSummaries: f } = I(false, { defineData: ["income", "expenditure"] }), h = d([["date", ["parse-time", "{y}-{m}-{d}"]], ["income", ["to-thousand", i.YUAN]], ["expenditure", ["to-thousand", i.YUAN]], ["balance", ["to-thousand", i.YUAN]]]);
  return T(() => {
    a.data = [];
  }), U(() => {
    a.data = [];
  }), (l, m) => {
    const b = Y, t = F, v = k("common-table"), x = Q;
    return u(), B(V, null, [p("div", M, [e(b, { modelValue: n.value, "onUpdate:modelValue": m[0] || (m[0] = (y) => n.value = y), "end-placeholder": "结束时间", "range-separator": "至", "start-placeholder": "开始时间", type: "daterange", "value-format": "x", onChange: r(a).toQuery }, null, 8, ["modelValue", "onChange"])]), p("div", O, [N((u(), A(v, { data: r(a).data, "data-format": h.value, "empty-text": r(a).emptyText, "summary-method": r(f), re: "tableRef", "show-summary": "" }, { default: P(() => [e(t, { align: "center", label: "序号", type: "index", width: "60px" }), e(t, { align: "center", label: "日期", prop: "date" }), e(t, { align: "center", label: "凭证号", prop: "voucherNumber" }), e(t, { align: "center", label: "收支形式", prop: "type" }), e(t, { align: "center", label: "摘要", "min-width": "160", prop: "summary" }), e(t, { align: "center", label: "收入", "min-width": "140", prop: "income" }), e(t, { align: "center", label: "支出", "min-width": "140", prop: "expenditure" }), e(t, { align: "center", label: "结余", "min-width": "140", prop: "balance" })]), _: 1 }, 8, ["data", "data-format", "empty-text", "summary-method"])), [[x, r(a).loading]]), e(q)])], 64);
  };
} }, J = R(S, [["__scopeId", "data-v-87979ea4"]]);
export {
  J as default
};
