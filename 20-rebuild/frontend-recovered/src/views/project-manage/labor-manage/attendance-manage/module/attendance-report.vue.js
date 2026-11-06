import { ref as y } from "vue";
import s from "moment";
import { computed as P } from "vue";
import { watch as E } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as c } from "vue";
import { unref as l } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as V } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as f } from "vue";
import { resolveDynamicComponent as R } from "vue";
import { isRef as F } from "vue";
import { ElDatePicker as K } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { ElPagination as W } from "element-plus";
import { a as q, b as G, d as J, c as $ } from "../../../../../modules/attendance-manage-750617cc.js";
import { n as Q, u as X, J as Z, o as ee, G as te, L as ae, I as ne } from "../../../../../shared/runtime.js";
import _ from "../component/day.vue.js";
import oe from "../component/month.vue.js";
const le = { class: "head-container" }, de = { __name: "attendance-report", props: { visible: { type: Boolean, default: false }, projectId: { type: [Number, String] }, supplierId: { type: [Number, String] }, permission: { type: Object, degfault: () => {
} } }, emits: ["update:visible"], setup(h, { emit: C }) {
  const T = C, i = h, a = { DAY: { K: "DAY", L: "考勤日报", V: 1 }, MONTH: { K: "MONTH", L: "考勤月报", V: 2 } };
  Q(a);
  const g = y([]), e = y({ type: a.DAY.V, month: s().valueOf(), dateTime: [s().startOf(1, "day").valueOf(), s().valueOf()], startDate: s().startOf(1, "day").valueOf(), endDate: s().valueOf() }), w = y([["attendanceDate", ["parse-time", "{y}-{m}-{d}"]], ["morningWorkingTime", ["parse-time", "{h}:{i}"]], ["morningClosingTime", ["parse-time", "{h}:{i}"]], ["afternoonWorkingTime", ["parse-time", "{h}:{i}"]], ["afternoonClosingTime", ["parse-time", "{h}:{i}"]], ["overtimeWorkingTime", ["parse-time", "{h}:{i}"]], ["overtimeClosingTime", ["parse-time", "{h}:{i}"]]]), x = P(() => {
    switch (e.value.type) {
      case a.DAY.V:
        return _;
      case a.MONTH.V:
        return oe;
      default:
        return _;
    }
  }), { visible: d, handleClose: O } = X({ emit: T, props: i, field: "visible" });
  E(() => i.visible, (n) => {
    n && r();
  }, { immediate: true });
  const { handleSizeChange: I, handleCurrentChange: Y, total: k, setTotalPage: N, queryPage: p } = Z({ fetchHook: r }), { maxHeight: M } = ee({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, d);
  function z(n) {
    n && (n == null ? void 0 : n.length) > 1 ? (e.value.startDate = n[0], e.value.endDate = n[1]) : (e.value.startDate = s().startOf("month").valueOf(), e.value.endDate = s().valueOf()), r();
  }
  async function r() {
    let n = [];
    try {
      const { content: t = [], totalElements: v } = e.value.type === a.DAY.V ? await q({ startDate: e.value.startDate, endDate: e.value.endDate, projectId: i.projectId, supplierId: i.supplierId, isSummaryDetail: false, ...p }) : await G({ monthDate: e.value.month, projectId: i.projectId, supplierId: i.supplierId, ...p });
      n = t, N(v);
    } catch (t) {
      console.log(t, "获取打卡明细失败");
    } finally {
      g.value = n;
    }
  }
  return (n, t) => {
    const v = D("common-radio-button"), b = K, A = L, H = D("common-table"), S = W, j = D("common-drawer");
    return m(), u(j, { title: "考勤明细", modelValue: l(d), "onUpdate:modelValue": t[3] || (t[3] = (o) => F(d) ? d.value = o : null), size: "70%", "before-close": l(O) }, { titleRight: c(() => {
      var o;
      return [l(te)(h.permission.export) ? (m(), u(ae, { key: 0, params: { monthDate: e.value.type === a.DAY.V ? void 0 : e.value.month, startDate: e.value.type === a.DAY.V ? e.value.startDate : void 0, endDate: e.value.type === a.DAY.V ? e.value.endDate : void 0, isSummaryDetail: e.value.type === a.DAY.V ? false : void 0, projectId: h.projectId }, fn: e.value.type === a.DAY.V ? l(J) : l($), disabled: !((o = g.value) != null && o.length) }, { default: c(() => t[4] || (t[4] = [B(" 下载考勤明细 ")])), _: 1, __: [4] }, 8, ["params", "fn", "disabled"])) : V("", true)];
    }), content: c(() => [U("div", le, [f(v, { modelValue: e.value.type, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.value.type = o), options: a.ENUM, class: "filter-item", type: "enum", onChange: r }, null, 8, ["modelValue", "options"]), e.value.type === a.MONTH.V ? (m(), u(b, { key: 0, modelValue: e.value.month, "onUpdate:modelValue": t[1] || (t[1] = (o) => e.value.month = o), type: "month", size: "default", class: "filter-item", placeholder: "选择月", clearable: false, "value-format": "x", format: "YYYY-MM", style: { width: "150px" }, onChange: r }, null, 8, ["modelValue"])) : V("", true), e.value.type === a.DAY.V ? (m(), u(b, { key: 1, modelValue: e.value.dateTime, "onUpdate:modelValue": t[2] || (t[2] = (o) => e.value.dateTime = o), disabledDate: (o) => o.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: l(ne), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", clearable: false, "value-format": "x", onChange: z }, null, 8, ["modelValue", "disabledDate", "shortcuts"])) : V("", true)]), f(H, { data: g.value, "data-format": w.value, "max-height": l(M), style: { width: "100%" } }, { default: c(() => [f(A, { label: "序号", type: "index", align: "center", width: "60" }), (m(), u(R(x.value)))]), _: 1 }, 8, ["data", "data-format", "max-height"]), f(S, { total: l(k), "current-page": l(p).pageNumber, "page-size": l(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(I), onCurrentChange: l(Y) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  de as default
};
