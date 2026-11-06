import { ref as i } from "vue";
import { inject as b } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as d } from "vue";
import { withCtx as u } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as p } from "vue";
import { createCommentVNode as I } from "vue";
import { toDisplayString as H } from "vue";
import { unref as s } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElButton as R } from "element-plus";
import { vLoading as S } from "element-plus";
import { _ as U, o as P, eb as $, ec as z } from "../../../../../../shared/runtime.js";
import { u as F } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { g as G } from "../../../../../../modules/self-healing-6f411a5c.js";
import J from "./file-download.vue.js";
const K = { class: "collection-container" }, O = { class: "special-box" }, Q = { class: "download-container" }, W = { key: 1 }, X = { __name: "collection-table", props: { level: { type: [Number, String], required: true } }, setup(x, { expose: C }) {
  const D = x, r = i(false), { _commonFn: k } = b("selfParentData"), { requestData: _, total: g, getSummaries: B } = F(false, { defineData: ["collectionAmount"] }), { maxHeight: V } = P({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), f = i([]), { projectInfo: L } = b("tableItem"), n = async () => {
    try {
      r.value = true;
      const { totalElements: o, content: c } = await G({ projectId: L.value.project.id, ..._, level: D.level });
      g.value = o, f.value = z(c);
    } catch (o) {
      console.log(o);
    } finally {
      r.value = false;
    }
  };
  n(), k.value.getCollectionRecordList = n;
  const m = i(false), h = i([]), T = async (o) => {
    h.value = o.attachments, m.value = true;
  };
  return C({ getList: n }), (o, c) => {
    const t = M, q = y("table-cell-tag"), A = R, N = y("common-table"), j = S;
    return l(), w("div", K, [E((l(), d(N, { data: f.value, "max-height": s(V), "summary-method": s(B), border: "", "show-summary": "", stripe: "" }, { default: u(() => [e(t, { align: "center", label: "序号", type: "index" }), e(t, { align: "center", label: "收款日期", prop: "collectionDate", width: "140" }), e(t, { align: "center", label: "收款类型", prop: "collectionMode" }), e(t, { align: "center", label: "收款金额", prop: "collectionAmount" }, { default: u(({ row: a }) => [p("div", O, [a.collectionAmount.includes("-") ? (l(), d(q, { key: 0, color: "red", name: "退 减" })) : I("", true), p("span", null, H(a.collectionAmount), 1)])]), _: 1 }), e(t, { align: "center", label: "付款单位", "min-width": "160", prop: "paymentUnit" }), e(t, { align: "center", label: "收款单位", "min-width": "160", prop: "collectionUnit" }), e(t, { align: "center", label: "收款行", "min-width": "140", prop: "collectionDepositBank", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "办理人", prop: "writtenByName", width: "120" }), e(t, { align: "center", label: "凭证", prop: "collectionDate", width: "80" }, { default: u(({ row: a }) => {
      var v;
      return [p("div", Q, [(v = a.attachments) != null && v.length ? (l(), d(A, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: (Y) => T(a) }, null, 8, ["onClick"])) : (l(), w("span", W, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[j, r.value]]), e($, { "request-data": s(_), total: s(g), onHandleChange: n }, null, 8, ["request-data", "total"]), e(J, { modelValue: m.value, "onUpdate:modelValue": c[0] || (c[0] = (a) => m.value = a), "file-list": h.value }, null, 8, ["modelValue", "file-list"])]);
  };
} }, le = U(X, [["__scopeId", "data-v-e0c1a659"]]);
export {
  le as default
};
