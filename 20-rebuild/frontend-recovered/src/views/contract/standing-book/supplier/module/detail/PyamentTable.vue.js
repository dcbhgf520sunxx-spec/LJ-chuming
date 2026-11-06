import { ref as i } from "vue";
import { inject as E } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as y } from "vue";
import { withCtx as r } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as w } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as F } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as M } from "element-plus";
import { _ as R, kc as S, o as I, iv as $, eb as z, ec as U } from "../../../../../../shared/runtime.js";
import { u as j } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { g as G } from "../../../../../../modules/detail-991649ef.js";
import J from "../../../common/components/record/file-download.vue.js";
const K = { class: "collection-container" }, O = { class: "special-box" }, Q = { class: "download-container" }, W = { key: 1 }, X = { __name: "PyamentTable", setup(Y, { expose: T }) {
  const p = i(false), { crud: k } = S(), { _commonFn: C, projectInfo: u } = E("tableItem"), { requestData: g, total: b, getSummaries: D } = j(false, { defineData: ["paymentAmount"] }), { maxHeight: V } = I({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), h = i([]), c = async () => {
    var o;
    try {
      p.value = true;
      const { content: n, totalElements: e } = await G({ ...g, orderId: (o = u == null ? void 0 : u.value) == null ? void 0 : o.id, purchaseType: k.query.purchaseType });
      b.value = e, h.value = U(n);
    } catch (n) {
      console.log(n);
    } finally {
      p.value = false;
    }
  };
  c(), C.value.getCollectionRecordList = c;
  const d = i(false), f = i([]);
  function B(o) {
    f.value = o.attachments, d.value = true;
  }
  return T({ getList: c }), (o, n) => {
    const e = H, A = _("table-cell-tag"), L = _("common-button"), P = _("common-table"), q = M;
    return l(), x("div", K, [N((l(), y(P, { data: h.value, "max-height": s(V), "summary-method": s(D), border: "", "show-summary": "", stripe: "" }, { default: r(() => [a(e, { align: "center", label: "序号", type: "index" }), a(e, { align: "center", label: "付款日期", prop: "paymentDate", width: "100" }), a(e, { align: "center", label: "付款类型", prop: "paymentType" }, { default: r(({ row: t }) => [m("span", null, w(s($).VL[t.paymentType]), 1)]), _: 1 }), a(e, { align: "center", label: "付款属性", prop: "paymentAttributeName" }), a(e, { align: "center", label: "付款金额", prop: "paymentAmount" }, { default: r(({ row: t }) => [m("div", O, [t.paymentAmount.includes("-") ? (l(), y(A, { key: 0, color: "red", name: "退 减" })) : F("", true), m("span", null, w(t.paymentAmount), 1)])]), _: 1 }), a(e, { align: "center", label: "付款单位", "min-width": "160", prop: "contractSignBody.name" }), a(e, { align: "center", label: "收款单位", "min-width": "160", prop: "supplierName" }), a(e, { align: "center", label: "付款行", "min-width": "140", prop: "paymentBank" }), a(e, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), a(e, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: r(({ row: t }) => {
      var v;
      return [m("div", Q, [(v = t.attachments) != null && v.length ? (l(), y(L, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (Z) => B(t) }, null, 8, ["onClick"])) : (l(), x("span", W, "-"))])];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[q, p.value]]), a(z, { "request-data": s(g), total: s(b), onHandleChange: c }, null, 8, ["request-data", "total"]), a(J, { "file-list": f.value, modelValue: d.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => d.value = t) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, le = R(X, [["__scopeId", "data-v-9e177bc4"]]);
export {
  le as default
};
