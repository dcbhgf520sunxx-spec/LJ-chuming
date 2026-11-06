import { ref as v } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as k } from "vue";
import { createTextVNode as C } from "vue";
import { unref as l } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElButton as I } from "element-plus";
import { vLoading as V } from "element-plus";
import { _ as q, o as $, eb as A, ec as H, bD as d } from "../../../../../shared/runtime.js";
import { d as P } from "../../../../../modules/upload-file-download-812f558c.js";
import { u as R } from "../../../../../modules/useTableTotal-3d22365a.js";
import { j as S } from "../../../../../modules/self-healing-6f411a5c.js";
import { b as j } from "../../../../../modules/supplier-e2667d36.js";
const M = { class: "invoice-container" }, z = { class: "download-container" }, F = { key: 1 }, G = { __name: "invoice", props: { orderId: { type: [Number, String] } }, setup(h) {
  const y = h, c = v(false), { requestData: p, total: m, getSummaries: b } = R(false, { defineData: ["invoiceAmount"] }), { maxHeight: x } = $({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), s = v([]), _ = async () => {
    try {
      c.value = true;
      const { content: o, totalElements: t } = await j({ ...p, orderId: y.orderId });
      s.value = H(o), s.value.forEach((e) => {
        e.invoiceType === d.RECEIPT.V ? e.invoiceTypeName = `${d.VL[e.invoiceType]}` : e.invoiceTypeName = `${d.VL[e.invoiceType]} ( ${e.taxRate} % )`;
      }), m.value = t;
    } catch (o) {
      console.log(o);
    } finally {
      c.value = false;
    }
  };
  _();
  const T = async (o) => {
    var t;
    await P((t = o[0]) == null ? void 0 : t.id, S);
  };
  return (o, t) => {
    const e = L, w = I, D = B("common-table"), N = V;
    return i(), f("div", M, [E((i(), g(D, { data: s.value, "max-height": l(x), "summary-method": l(b), border: "", "show-summary": "", stripe: "" }, { default: r(() => [a(e, { align: "center", fixed: "", label: "序号", type: "index", width: "60" }), a(e, { align: "center", fixed: "", label: "收票日期", prop: "invoiceDate", width: "100" }), a(e, { align: "center", fixed: "", label: "发票类型", prop: "invoiceTypeName" }), a(e, { align: "center", fixed: "", label: "发票金额", prop: "invoiceAmount" }), a(e, { align: "center", label: "开票单位", prop: "supplierName" }), a(e, { align: "center", label: "收票单位", prop: "invoiceSignBody.name" }), a(e, { align: "center", label: "发票编号", prop: "invoiceNumber" }), a(e, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), a(e, { align: "center", label: "附件", prop: "attachment", width: "100" }, { default: r(({ row: n }) => {
      var u;
      return [k("div", z, [(u = n == null ? void 0 : n.attachmentList) != null && u.length ? (i(), g(w, { key: 0, icon: "el-icon-download", plain: "", size: "default", type: "primary", onClick: (J) => T(n.attachmentList) }, { default: r(() => t[0] || (t[0] = [C("下载 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : (i(), f("span", F, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[N, c.value]]), a(A, { "request-data": l(p), total: l(m), onHandleChange: _ }, null, 8, ["request-data", "total"])]);
  };
} }, Y = q(G, [["__scopeId", "data-v-02a5f97e"]]);
export {
  Y as default
};
