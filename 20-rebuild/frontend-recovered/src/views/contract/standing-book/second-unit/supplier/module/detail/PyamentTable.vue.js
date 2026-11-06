import { ref as r } from "vue";
import { inject as E } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as m } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as w } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as F } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as M } from "element-plus";
import { _ as R, kc as S, o as I, iv as $, eb as z, ec as U } from "../../../../../../../shared/runtime.js";
import { u as j } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import { g as G } from "../../../../../../../modules/detail-991649ef.js";
import J from "../../../../common/components/record/file-download.vue.js";
const K = { class: "collection-container" }, O = { class: "special-box" }, Q = { key: 1 }, W = { __name: "PyamentTable", setup(X, { expose: T }) {
  const p = r(false), { crud: k } = S(), { _commonFn: C, projectInfo: c } = E("tableItem"), { requestData: g, total: b, getSummaries: D } = j(false, { defineData: ["paymentAmount"] }), { maxHeight: V } = I({ paginate: true, extraBox: [".el-drawer__header", ".header-container"] }), h = r([]), i = async () => {
    var l;
    try {
      p.value = true, console.log(c);
      const { content: n, totalElements: e } = await G({ ...g, orderId: (l = c == null ? void 0 : c.value) == null ? void 0 : l.id, purchaseType: k.query.purchaseType });
      b.value = e, h.value = U(n);
    } catch (n) {
      console.log(n);
    } finally {
      p.value = false;
    }
  };
  i(), C.value.getCollectionRecordList = i;
  const u = r(false), f = r([]);
  function B(l) {
    f.value = l.attachments, u.value = true;
  }
  return T({ getList: i }), (l, n) => {
    const e = H, A = d("table-cell-tag"), L = d("common-button"), P = d("common-table"), q = M;
    return o(), x("div", K, [N((o(), _(P, { data: h.value, "max-height": s(V), "summary-method": s(D), border: "", "show-summary": "", stripe: "" }, { default: m(() => [a(e, { align: "center", label: "序号", type: "index" }), a(e, { align: "center", label: "付款日期", prop: "paymentDate", width: "100" }), a(e, { align: "center", label: "付款类型", prop: "paymentType" }, { default: m(({ row: t }) => [y("span", null, w(s($).VL[t.paymentType]), 1)]), _: 1 }), a(e, { align: "center", label: "付款属性", prop: "paymentAttributeName" }), a(e, { align: "center", label: "付款金额", prop: "paymentAmount" }, { default: m(({ row: t }) => [y("div", O, [t.paymentAmount.includes("-") ? (o(), _(A, { key: 0, color: "red", name: "退 减" })) : F("", true), y("span", null, w(t.paymentAmount), 1)])]), _: 1 }), a(e, { align: "center", label: "付款单位", "min-width": "160", prop: "contractSignBody.name" }), a(e, { align: "center", label: "收款单位", "min-width": "160", prop: "supplierName" }), a(e, { align: "center", label: "付款行", "min-width": "140", prop: "paymentBank" }), a(e, { align: "center", label: "办理人", prop: "paymentPerson.name", width: "120" }), a(e, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: m(({ row: t }) => {
      var v;
      return [(v = t.attachments) != null && v.length ? (o(), _(L, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (Y) => B(t) }, null, 8, ["onClick"])) : (o(), x("span", Q, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])), [[q, p.value]]), a(z, { "request-data": s(g), total: s(b), onHandleChange: i }, null, 8, ["request-data", "total"]), a(J, { "file-list": f.value, modelValue: u.value, "onUpdate:modelValue": n[0] || (n[0] = (t) => u.value = t) }, null, 8, ["file-list", "modelValue"])]);
  };
} }, le = R(W, [["__scopeId", "data-v-28d80548"]]);
export {
  le as default
};
