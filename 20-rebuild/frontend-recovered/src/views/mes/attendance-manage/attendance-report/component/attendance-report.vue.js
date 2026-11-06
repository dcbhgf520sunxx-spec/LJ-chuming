import { ref as g } from "vue";
import s from "moment";
import { computed as B } from "vue";
import { watch as I } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as r } from "vue";
import { createBlock as m } from "vue";
import { withCtx as p } from "vue";
import { unref as l } from "vue";
import { createTextVNode as U } from "vue";
import { createCommentVNode as y } from "vue";
import { createElementVNode as R } from "vue";
import { createVNode as c } from "vue";
import { resolveDynamicComponent as L } from "vue";
import { isRef as j } from "vue";
import { ElDatePicker as F } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElPagination as W } from "element-plus";
import { b as q, c as $, e as G, f as J } from "../../../../../modules/attendance-report-ce8c4447.js";
import { n as Q, u as X, J as Z, o as ee, G as te, L as ae, I as ne } from "../../../../../shared/runtime.js";
import _ from "./day.vue.js";
import oe from "./month.vue.js";
const le = { class: "head-container" }, de = { __name: "attendance-report", props: { visible: { type: Boolean, default: false }, projectId: { type: [Number, String] }, supplierId: { type: [Number, String] }, permission: { type: Object, degfault: () => {
} } }, emits: ["update:visible"], setup(b, { emit: C }) {
  const T = C, D = b, a = { DAY: { K: "DAY", L: "考勤日报", V: 1 }, MONTH: { K: "MONTH", L: "考勤月报", V: 2 } };
  Q(a);
  const f = g([]), e = g({ type: a.DAY.V, month: s().valueOf(), date: [s().subtract(30, "days").valueOf(), s().valueOf()], startDate: s().subtract(30, "days").valueOf(), endDate: s().valueOf() }), w = g([["attendanceDate", ["parse-time", "{y}-{m}-{d}"]], ["morningWorkingTime", ["parse-time", "{h}:{i}"]], ["morningClosingTime", ["parse-time", "{h}:{i}"]], ["afternoonWorkingTime", ["parse-time", "{h}:{i}"]], ["afternoonClosingTime", ["parse-time", "{h}:{i}"]], ["overtimeWorkingTime", ["parse-time", "{h}:{i}"]], ["overtimeClosingTime", ["parse-time", "{h}:{i}"]]]), x = B(() => {
    switch (e.value.type) {
      case a.DAY.V:
        return _;
      case a.MONTH.V:
        return oe;
      default:
        return _;
    }
  }), { visible: u, handleClose: O } = X({ emit: T, props: D, field: "visible" });
  I(() => D.visible, (n) => {
    n && i();
  }, { immediate: true });
  const { handleSizeChange: Y, handleCurrentChange: k, total: N, setTotalPage: A, queryPage: d } = Z({ fetchHook: i }), { maxHeight: M } = ee({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, u);
  function z(n) {
    n && (n == null ? void 0 : n.length) > 1 ? (e.value.startDate = n[0], e.value.endDate = n[1]) : (e.value.startDate = s().startOf("month").valueOf(), e.value.endDate = s().valueOf()), i();
  }
  async function i() {
    let n = [];
    try {
      const { content: t = [], totalElements: h } = e.value.type === a.DAY.V ? await q({ ...e.value, ...d }) : await $({ monthDate: e.value.month, ...d });
      n = t, A(h);
    } catch (t) {
      console.log(t, "获取打卡明细失败");
    } finally {
      f.value = n;
    }
  }
  return (n, t) => {
    const h = v("common-radio-button"), V = F, H = K, S = v("common-table"), P = W, E = v("common-drawer");
    return r(), m(E, { title: "考勤明细", modelValue: l(u), "onUpdate:modelValue": t[3] || (t[3] = (o) => j(u) ? u.value = o : null), size: "70%", "before-close": l(O) }, { titleRight: p(() => {
      var o;
      return [l(te)(b.permission.export) ? (r(), m(ae, { key: 0, params: { monthDate: e.value.type === a.DAY.V ? void 0 : e.value.month, startDate: e.value.type === a.DAY.V ? e.value.startDate : void 0, endDate: e.value.type === a.DAY.V ? e.value.endDate : void 0, isSummaryDetail: e.value.type === a.DAY.V ? false : void 0 }, fn: e.value.type === a.DAY.V ? l(G) : l(J), disabled: !((o = f.value) != null && o.length) }, { default: p(() => t[4] || (t[4] = [U(" 下载考勤明细 ")])), _: 1, __: [4] }, 8, ["params", "fn", "disabled"])) : y("", true)];
    }), content: p(() => [R("div", le, [c(h, { modelValue: e.value.type, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.value.type = o), options: a.ENUM, class: "filter-item", type: "enum", onChange: i }, null, 8, ["modelValue", "options"]), e.value.type === a.MONTH.V ? (r(), m(V, { key: 0, modelValue: e.value.month, "onUpdate:modelValue": t[1] || (t[1] = (o) => e.value.month = o), type: "month", size: "default", class: "filter-item", placeholder: "选择月", clearable: false, "value-format": "x", format: "YYYY-MM", style: { width: "150px" }, onChange: i }, null, 8, ["modelValue"])) : y("", true), e.value.type === a.DAY.V ? (r(), m(V, { key: 1, modelValue: e.value.date, "onUpdate:modelValue": t[2] || (t[2] = (o) => e.value.date = o), disabledDate: (o) => o.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: l(ne), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", clearable: false, "value-format": "x", onChange: z }, null, 8, ["modelValue", "disabledDate", "shortcuts"])) : y("", true)]), c(S, { data: f.value, "data-format": w.value, "max-height": l(M) - 160, style: { width: "100%" } }, { default: p(() => [c(H, { label: "序号", type: "index", align: "center", width: "60" }), (r(), m(L(x.value)))]), _: 1 }, 8, ["data", "data-format", "max-height"]), c(P, { total: l(N), "current-page": l(d).pageNumber, "page-size": l(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(Y), onCurrentChange: l(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  de as default
};
