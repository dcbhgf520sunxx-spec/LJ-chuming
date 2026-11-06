import { ref as c } from "vue";
import M from "moment";
import { nextTick as F } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { createBlock as p } from "vue";
import { createCommentVNode as v } from "vue";
import { withDirectives as J } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as g } from "vue";
import { Fragment as T } from "vue";
import { createTextVNode as C } from "vue";
import { ElDatePicker as W } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElPagination as Q } from "element-plus";
import { vLoading as X } from "element-plus";
import { h as Z } from "../../../../../../modules/machine-part-b1b959c2.js";
import { cb as d, J as $, G as ee, i as te, az as S, cc as x } from "../../../../../../shared/runtime.js";
import { D as ae } from "../../../../../../modules/bridge-86f96a4f.js";
const ne = { class: "head-container" }, ie = { __name: "nesting-task-list", props: { maxHeight: { type: [Number, String], default: void 0 } }, emits: ["nesting-task-click"], setup(z, { expose: P, emit: D }) {
  const B = D, N = c(), f = c(M().startOf("month").valueOf()), n = c({ issueStatusEnum: d.IN_NESTING.V }), h = c([]), _ = c(false), O = c([["project", "parse-project"]]), { handleSizeChange: U, handleCurrentChange: L, total: q, setTotalPage: G, queryPage: y } = $({ fetchHook: i });
  i();
  async function i(r) {
    if (ee(ae.get)) try {
      _.value = true, h.value = [];
      const { content: a, totalElements: E } = await Z({ date: f.value, ...n.value, ...y });
      G(E), h.value = a.map((m) => (r && te(r) && m.id === r.id && F(() => {
        var o;
        (o = N.value) == null || o.setCurrentRow(m);
      }), m));
    } catch (a) {
      console.log("获取可排产的切割任务单错误", a);
    } finally {
      _.value = false;
    }
  }
  function H() {
    n.value.issueStatusEnum = void 0, i();
  }
  function I(r) {
    B("nesting-task-click", r, n);
  }
  return P({ refresh: i }), (r, a) => {
    const E = W, m = b("common-radio-button"), o = Y, k = K, R = b("common-table"), j = Q, A = X;
    return l(), V(T, null, [w("div", ne, [s(E, { modelValue: f.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => f.value = e), type: "month", size: "default", "value-format": "x", clearable: false, placeholder: "选择月份", style: { width: "120px" }, class: "filter-item", onChange: i }, null, 8, ["modelValue"]), s(m, { modelValue: n.value.boolNestCutEnum, "onUpdate:modelValue": a[1] || (a[1] = (e) => n.value.boolNestCutEnum = e), options: t(S).ENUM, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: H }, null, 8, ["modelValue", "options"]), n.value.boolNestCutEnum === t(S).NESTING.V ? (l(), p(m, { key: 0, modelValue: n.value.issueStatusEnum, "onUpdate:modelValue": a[2] || (a[2] = (e) => n.value.issueStatusEnum = e), options: t(d).ENUM, unshowVal: [t(d).HAS_ISSUED.V, t(d).NOT_NESTING.V], showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: i }, null, 8, ["modelValue", "options", "unshowVal"])) : v("", true)]), J((l(), p(R, { ref_key: "nestingTaskTableRef", ref: N, "data-format": O.value, "highlight-current-row": "", data: h.value, "return-source-data": "", "row-key": "id", stripe: false, "max-height": z.maxHeight - 45, style: { width: "100%" }, onCurrentChange: I }, { default: u(() => [s(o, { prop: "orderNumber", "show-overflow-tooltip": true, label: "任务单号", "min-width": "100", align: "center" }), s(o, { "show-overflow-tooltip": true, label: "数量（件）", "min-width": "60", align: "center" }, { default: u(({ row: e }) => [w("span", null, g(e.quantity), 1)]), _: 1 }), s(o, { "show-overflow-tooltip": true, label: "套料状态", "min-width": "60", align: "center" }, { default: u(({ row: e }) => [e.boolNestCutEnum ? (l(), V(T, { key: 0 }, [e.issueStatusEnum ? (l(), p(k, { key: 0, effect: "plain", type: t(d).V[e.issueStatusEnum].T }, { default: u(() => [C(g(t(d).VL[e.issueStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : v("", true)], 64)) : (l(), p(k, { key: 1, effect: "plain", type: "danger" }, { default: u(() => [C(g(t(S).VL[e.boolNestCutEnum]), 1)]), _: 2 }, 1024))]), _: 1 }), s(o, { "show-overflow-tooltip": true, label: "排产状态", "min-width": "60", align: "center" }, { default: u(({ row: e }) => [e.taskStatusEnum ? (l(), p(k, { key: 0, effect: "plain", type: t(x).V[e.taskStatusEnum].T }, { default: u(() => [C(g(t(x).VL[e.taskStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : v("", true)]), _: 1 })]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[A, _.value]]), s(j, { total: t(q), "current-page": t(y).pageNumber, "page-size": t(y).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(U), onCurrentChange: t(L) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 64);
  };
} };
export {
  ie as default
};
