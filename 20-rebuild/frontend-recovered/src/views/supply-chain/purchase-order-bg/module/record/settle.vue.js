import { ref as _ } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as B } from "vue";
import { unref as n } from "vue";
import { createTextVNode as I } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElButton as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { _ as S, o as H, p as L, eb as V, ec as j } from "../../../../../shared/runtime.js";
import { u as M } from "../../../../../modules/useTableTotal-3d22365a.js";
import { e as U } from "../../../../../modules/supplier-e2667d36.js";
import { d as z } from "../../../../../modules/upload-file-download-812f558c.js";
import { j as A } from "../../../../../modules/self-healing-6f411a5c.js";
const F = { class: "collection-container" }, P = { class: "download-container" }, R = { key: 1 }, $ = { __name: "settle", props: { orderId: { type: [Number, String] } }, setup(f) {
  const c = _(false), b = f, { requestData: i, total: d, getSummaries: y } = M(false, { defineData: ["amount"] }), { maxHeight: v } = H({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), m = _([]), p = async () => {
    try {
      c.value = true;
      const { content: t, totalElements: l } = await U({ ...i, orderId: b.orderId });
      d.value = l, m.value = j(t);
    } catch (t) {
      console.log(t);
    } finally {
      c.value = false;
    }
  };
  p();
  const x = async (t) => {
    await z(t, A);
  };
  return (t, l) => {
    const a = N, T = q, w = D("common-table"), C = E;
    return s(), u("div", F, [k((s(), g(w, { data: m.value, "max-height": n(v), "summary-method": n(y), border: "", "show-summary": "", stripe: "" }, { default: r(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "创建时间", prop: "createTime" }), e(a, { align: "center", label: "结算金额", prop: "amount" }), e(a, { align: "center", label: "申请人", prop: "applyUserName" }), e(a, { align: "center", label: "审核人", prop: "auditUserName" }), e(a, { align: "center", label: "审核时间", prop: "auditTime" }, { default: r(({ row: o }) => [h("span", null, B(n(L)(o.auditTime)), 1)]), _: 1 }), e(a, { align: "center", label: "附件", prop: "attachment", width: "100" }, { default: r(({ row: o }) => [h("div", P, [o != null && o.attachmentIds ? (s(), g(T, { key: 0, icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (G) => x(o.attachmentIds) }, { default: r(() => l[0] || (l[0] = [I("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (s(), u("span", R, "-"))])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[C, c.value]]), e(V, { "request-data": n(i), total: n(d), onHandleChange: p }, null, 8, ["request-data", "total"])]);
  };
} }, Y = S($, [["__scopeId", "data-v-e151ab6a"]]);
export {
  Y as default
};
