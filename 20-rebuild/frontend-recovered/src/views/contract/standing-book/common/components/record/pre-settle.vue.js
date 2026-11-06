import { ref as s } from "vue";
import { inject as h } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as y } from "vue";
import { withCtx as u } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as j } from "vue";
import { unref as r } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElButton as I } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as U, o as M, eb as $, ec as z } from "../../../../../../shared/runtime.js";
import { u as A } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { c as F } from "../../../../../../modules/self-healing-6f411a5c.js";
import G from "./file-download.vue.js";
const J = { class: "collection-container" }, K = { class: "special-box" }, O = { class: "download-container" }, Q = { key: 1 }, R = { __name: "pre-settle", props: { level: { type: [Number, String], required: true } }, setup(w, { expose: x }) {
  const k = w, c = s(false), { _commonFn: D } = h("selfParentData"), { requestData: p, total: _, getSummaries: L } = A(false, { defineData: ["amount"] }), { maxHeight: S } = M({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), f = s([]), { projectInfo: C } = h("tableItem"), o = async () => {
    try {
      c.value = true;
      const { totalElements: a, content: n } = await F({ projectId: C.value.project.id, ...p, level: k.level });
      _.value = a, f.value = z(n);
    } catch (a) {
      console.log(a);
    } finally {
      c.value = false;
    }
  };
  o(), D.value.getPreSettleList = o;
  const m = s(false), g = s([]), B = async (a) => {
    g.value = a.attachmentList, m.value = true;
  };
  return x({ getList: o }), (a, n) => {
    const t = E, V = I, q = P("common-table"), N = H;
    return i(), b("div", J, [T((i(), y(q, { data: f.value, "max-height": r(S), "summary-method": r(L), border: "", "show-summary": "", stripe: "" }, { default: u(() => [e(t, { align: "center", label: "序号", type: "index" }), e(t, { align: "center", label: "结算日期", prop: "settlementDate", width: "140" }), e(t, { align: "center", label: "结算金额", prop: "amount" }, { default: u(({ row: l }) => [d("div", K, [d("span", null, j(l.amount), 1)])]), _: 1 }), e(t, { align: "center", label: "申请人", "min-width": "160", prop: "createUserName" }), e(t, { align: "center", label: "审核人", "min-width": "160", prop: "auditUserName" }), e(t, { align: "center", label: "审核时间", "min-width": "140", prop: "auditTime", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "备注", prop: "remark" }), e(t, { align: "center", label: "附件", width: "80" }, { default: u(({ row: l }) => {
      var v;
      return [d("div", O, [(v = l.attachmentList) != null && v.length ? (i(), y(V, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: (W) => B(l) }, null, 8, ["onClick"])) : (i(), b("span", Q, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[N, c.value]]), e($, { "request-data": r(p), total: r(_), onHandleChange: o }, null, 8, ["request-data", "total"]), e(G, { modelValue: m.value, "onUpdate:modelValue": n[0] || (n[0] = (l) => m.value = l), "file-list": g.value }, null, 8, ["modelValue", "file-list"])]);
  };
} }, ae = U(R, [["__scopeId", "data-v-a38042a7"]]);
export {
  ae as default
};
