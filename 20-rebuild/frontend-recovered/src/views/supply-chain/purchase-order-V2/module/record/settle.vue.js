import { ref as s } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as b } from "vue";
import { withCtx as m } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as N } from "vue";
import { toDisplayString as q } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as I } from "element-plus";
import { vLoading as S } from "element-plus";
import { _ as E, o as H, p as L, eb as U, ec as M } from "../../../../../shared/runtime.js";
import { u as $ } from "../../../../../modules/useTableTotal-3d22365a.js";
import { e as z } from "../../../../../modules/supplier-e2667d36.js";
import A from "../../../../contract/standing-book/common/components/record/file-download.vue.js";
const F = { class: "collection-container" }, P = { key: 1 }, R = { __name: "settle", props: { orderId: { type: [Number, String] } }, setup(y) {
  const i = s(false), x = y, { requestData: u, total: d, getSummaries: w } = $(false, { defineData: ["amount"] }), { maxHeight: C } = H({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), p = s([]), _ = async () => {
    try {
      i.value = true;
      const { content: a, totalElements: n } = await z({ ...u, orderId: x.orderId });
      d.value = n, p.value = M(a);
    } catch (a) {
      console.log(a);
    } finally {
      i.value = false;
    }
  };
  _();
  const c = s(false), f = s([]);
  function D(a) {
    f.value = a.attachments, c.value = true;
  }
  return (a, n) => {
    const t = I, T = h("common-button"), k = h("common-table"), V = S;
    return r(), v("div", F, [B((r(), b(k, { data: p.value, "max-height": l(C), "summary-method": l(w), border: "", "show-summary": "", stripe: "" }, { default: m(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "创建时间", prop: "createTime" }), e(t, { align: "center", label: "结算金额", prop: "amount" }), e(t, { align: "center", label: "申请人", prop: "applyUserName" }), e(t, { align: "center", label: "审核人", prop: "auditUserName" }), e(t, { align: "center", label: "审核时间", prop: "auditTime" }, { default: m(({ row: o }) => [N("span", null, q(l(L)(o.auditTime)), 1)]), _: 1 }), e(t, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: m(({ row: o }) => {
      var g;
      return [(g = o.attachments) != null && g.length ? (r(), b(T, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (j) => D(o) }, null, 8, ["onClick"])) : (r(), v("span", P, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[V, i.value]]), e(U, { "request-data": l(u), total: l(d), onHandleChange: _ }, null, 8, ["request-data", "total"]), e(A, { "file-list": f.value, modelValue: c.value, "onUpdate:modelValue": n[0] || (n[0] = (o) => c.value = o) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, W = E(R, [["__scopeId", "data-v-38f822f1"]]);
export {
  W as default
};
