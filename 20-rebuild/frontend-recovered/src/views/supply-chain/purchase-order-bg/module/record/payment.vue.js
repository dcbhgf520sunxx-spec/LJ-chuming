import { ref as u } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as y } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as h } from "vue";
import { toDisplayString as L } from "vue";
import { unref as l } from "vue";
import { createTextVNode as E } from "vue";
import { ElTableColumn as N } from "element-plus";
import { ElButton as q } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as S, o as V, iv as A, eb as H, ec as M } from "../../../../../shared/runtime.js";
import { u as P } from "../../../../../modules/useTableTotal-3d22365a.js";
import { d as j } from "../../../../../modules/supplier-e2667d36.js";
import { d as F } from "../../../../../modules/upload-file-download-812f558c.js";
import { j as z } from "../../../../../modules/self-healing-6f411a5c.js";
const R = { class: "collection-container" }, $ = { class: "download-container" }, G = { key: 1 }, J = { __name: "payment", props: { orderId: { type: [Number, String] } }, setup(b) {
  const i = u(false), f = b, { requestData: c, total: m, getSummaries: v } = P(false, { defineData: ["paymentAmount"] }), { maxHeight: x } = V({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), d = u([]), p = async () => {
    try {
      i.value = true;
      const { content: n, totalElements: t } = await j({ ...c, orderId: f.orderId });
      m.value = t, d.value = M(n);
    } catch (n) {
      console.log(n);
    } finally {
      i.value = false;
    }
  };
  p();
  const w = async (n) => {
    var t;
    await F((t = n[0]) == null ? void 0 : t.id, z);
  };
  return (n, t) => {
    const a = N, D = q, k = C("common-table"), B = I;
    return s(), y("div", R, [T((s(), g(k, { data: d.value, "max-height": l(x), "summary-method": l(v), border: "", "show-summary": "", stripe: "" }, { default: r(() => [e(a, { align: "center", label: "序号", type: "index" }), e(a, { align: "center", label: "付款日期", prop: "paymentDate", width: "100" }), e(a, { align: "center", label: "付款类型", prop: "paymentType" }, { default: r(({ row: o }) => [h("span", null, L(l(A).VL[o.paymentType]), 1)]), _: 1 }), e(a, { align: "center", label: "付款金额", prop: "paymentAmount" }), e(a, { align: "center", label: "付款单位", "min-width": "160", prop: "contractSignBody.name" }), e(a, { align: "center", label: "收款单位", "min-width": "160", prop: "supplierName" }), e(a, { align: "center", label: "付款行", "min-width": "140", prop: "paymentBank" }), e(a, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), e(a, { align: "center", label: "附件", prop: "attachment", width: "100" }, { default: r(({ row: o }) => {
      var _;
      return [h("div", $, [(_ = o == null ? void 0 : o.attachmentList) != null && _.length ? (s(), g(D, { key: 0, icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (K) => w(o.attachmentList) }, { default: r(() => t[0] || (t[0] = [E("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (s(), y("span", G, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[B, i.value]]), e(H, { "request-data": l(c), total: l(m), onHandleChange: p }, null, 8, ["request-data", "total"])]);
  };
} }, Z = S(J, [["__scopeId", "data-v-f11b9b53"]]);
export {
  Z as default
};
