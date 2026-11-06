import { ref as u } from "vue";
import { inject as R } from "vue";
import { reactive as K } from "vue";
import { watch as b } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as r } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as Q } from "vue";
import { createElementVNode as G } from "vue";
import { createElementBlock as T } from "vue";
import { Fragment as j } from "vue";
import { renderList as E } from "vue";
import { unref as i } from "vue";
import { withDirectives as J } from "vue";
import { ElButton as W } from "element-plus";
import { ElDatePicker as X } from "element-plus";
import { ElOption as Y } from "element-plus";
import { ElSelect as Z } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElDrawer as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { _ as ae, o as le, l2 as oe, dq as ne, ec as se, e6 as re, dp as ie, iv as ce, eb as de, l3 as ue } from "../../../../../../../../shared/runtime.js";
import { u as L } from "../../../../../../../../modules/useTableTotal-3d22365a.js";
const pe = { class: "head-container" }, me = { __name: "detailed", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(V, { expose: C, emit: A }) {
  const B = V, I = A, m = u(false), M = R("info_parent_data"), { projectInfo: c } = M, v = u([]), _ = u([(/* @__PURE__ */ new Date()).getTime(), (/* @__PURE__ */ new Date()).getTime()]), g = u([]), { maxHeight: q } = le({ extraHeight: "40" }), o = K({ remark: null, startDate: null, endDate: null, collectionMode: null }), { requestData: f, total: h } = L();
  b(() => _.value, (e) => {
    e != null && e.length ? (o.startDate = e[0], o.endDate = e[1]) : (o.startDate = null, o.endDate = null);
  }, { immediate: true, deep: true }), b(() => o, async (e) => {
    await d();
  }, { deep: true });
  const D = async () => {
    try {
      const e = await ue({ projectId: c.project.id });
      v.value = Object.keys(e).map((t) => ({ label: e[t], value: e[t] }));
    } catch (e) {
      console.error("获取项目摘要失败:getAbstractList" + e);
    }
  };
  D();
  const d = async () => {
    try {
      m.value = true;
      const { content: e, totalElements: t } = await oe(ne({ ...o, projectId: c.project.id, ...f }));
      g.value = se(e), h.value = t;
    } catch (e) {
      console.error("获取收支明细失败:detailedList", e);
    } finally {
      m.value = false;
    }
  };
  b(() => c.project.id, async (e) => {
    e && (re(o, { sustainable: ["startDate", "endData"] }), await D(), await d());
  });
  const y = () => {
    I("update:visible", false);
  }, { getSummaries: H } = L(false, { defineData: ["income", "expense"] }), F = [{ text: "上周", value: () => {
    const e = /* @__PURE__ */ new Date(), t = /* @__PURE__ */ new Date();
    return t.setTime(t.getTime() - 3600 * 1e3 * 24 * 7), [t, e];
  } }, { text: "上个月", value: () => {
    const e = /* @__PURE__ */ new Date(), t = /* @__PURE__ */ new Date();
    return t.setTime(t.getTime() - 3600 * 1e3 * 24 * 30), [t, e];
  } }, { text: "最近三个月", value: () => {
    const e = /* @__PURE__ */ new Date(), t = /* @__PURE__ */ new Date();
    return t.setTime(t.getTime() - 3600 * 1e3 * 24 * 90), [t, e];
  } }];
  return C({ detailedList: d }), (e, t) => {
    const N = W, P = X, w = Y, x = Z, S = k("print-table"), n = $, U = k("common-table"), z = ee, O = te;
    return r(), p(z, { "close-on-click-modal": false, "close-on-press-escape": true, "destroy-on-close": true, "model-value": B.visible, "show-close": false, size: "55%", onClosed: y }, { header: s(() => [a(ie, { "type-one": false, "header-title": "收支明细" }), a(N, { plain: "", onClick: y }, { default: s(() => t[3] || (t[3] = [Q("关闭")])), _: 1, __: [3] })]), default: s(() => [G("div", pe, [a(P, { modelValue: _.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => _.value = l), shortcuts: F, "end-placeholder": "结束日期", "range-separator": "-", "start-placeholder": "开始日期", type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e.changeDate }, null, 8, ["modelValue", "onChange"]), a(x, { modelValue: o.remark, "onUpdate:modelValue": t[1] || (t[1] = (l) => o.remark = l), clearable: "", placeholder: "全部摘要" }, { default: s(() => [(r(true), T(j, null, E(v.value, (l) => (r(), p(w, { key: l.value, label: l.label, value: l.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), a(x, { modelValue: o.collectionMode, "onUpdate:modelValue": t[2] || (t[2] = (l) => o.collectionMode = l), clearable: "", placeholder: "全部类型" }, { default: s(() => [(r(true), T(j, null, E(i(ce).V, (l) => (r(), p(w, { key: l.K, label: l.L, value: l.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), a(S, { params: { ...o, projectId: i(c).project.id }, "api-key": "innerIncomeDetail", size: "default", type: "warning" }, null, 8, ["params"])]), J((r(), p(U, { data: g.value, "max-height": i(q), "summary-method": i(H), "show-summary": "", style: { width: "100%" } }, { default: s(() => [a(n, { align: "center", label: "序号", "min-width": "60", type: "index" }), a(n, { align: "center", label: "日期", prop: "startDate", width: "180" }), a(n, { align: "center", label: "摘要", "min-width": "140", prop: "remark", "show-overflow-tooltip": "" }), a(n, { align: "center", label: "收入明细", prop: "incomeDetail" }, { default: s(() => [a(n, { align: "center", label: "类型", prop: "incomeType" }), a(n, { align: "center", label: "金额", prop: "income" })]), _: 1 }), a(n, { align: "center", label: "支出明细", prop: "expenseDetail" }, { default: s(() => [a(n, { align: "center", label: "类型", prop: "expenseType" }), a(n, { align: "center", label: "金额", prop: "expense" })]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[O, m.value]]), a(de, { "request-data": i(f), total: i(h), onHandleChange: d }, null, 8, ["request-data", "total"])]), _: 1 }, 8, ["model-value"]);
  };
} }, ge = ae(me, [["__scopeId", "data-v-efb0a4db"]]);
export {
  ge as default
};
