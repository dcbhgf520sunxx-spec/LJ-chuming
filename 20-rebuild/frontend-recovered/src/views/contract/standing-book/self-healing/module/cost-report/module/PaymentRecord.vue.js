import { inject as H } from "vue";
import { ref as u } from "vue";
import { computed as f } from "vue";
import { watchEffect as M } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as e } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as S } from "vue";
import { createElementVNode as s } from "vue";
import { Fragment as z } from "vue";
import { renderList as F } from "vue";
import { createBlock as y } from "vue";
import { toDisplayString as m } from "vue";
import { unref as d } from "vue";
import { ElButton as O } from "element-plus";
import { ElTooltip as q } from "element-plus";
import { ElCol as G } from "element-plus";
import { ElRow as J } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElDrawer as Q } from "element-plus";
import { _ as U, e3 as W, o as X, lp as v, ec as Y, dp as h, iv as Z } from "../../../../../../../shared/runtime.js";
import { u as $ } from "../../../../../../../modules/useTableTotal-3d22365a.js";
import { a as ee } from "../../../../../../../modules/index-d4be09aa.js";
const te = { class: "record-container" }, ae = { class: "basic-info" }, oe = { class: "item" }, ne = { class: "truncate" }, se = { key: 1, class: "truncate" }, le = { class: "table-container" }, ce = { __name: "PaymentRecord", props: { visible: Boolean, itemInfo: Object, printParams: Object }, emits: ["update:visible"], setup(g, { emit: w }) {
  const { radioType: o } = H("common"), x = u([{ label: "供应商", isTruncated: false, key: "supplierName" }, { label: "合同号", isTruncated: false, key: "serialNumber" }]), E = f(() => W(x.value, l.itemInfo)), l = g, k = w, I = () => k("update:visible", false), { maxHeight: T } = X({ wrapperBox: [".el-drawer__body"] }), { getSummaries: D } = $(false, { defineData: ["paymentAmount"] });
  M(async () => {
    var c;
    (c = l.itemInfo) != null && c.id && (o != null && o.value) && await B({ orderId: l.itemInfo.id, costTypeEnum: v[o.value].V });
  });
  const _ = u([]), B = async (c) => {
    try {
      const { content: n } = await ee(c);
      _.value = Y(n);
    } catch (n) {
      console.error("获取支付记录失败:getDataList", n);
    }
  }, P = f(() => ({ orderId: l.itemInfo.id, costTypeEnum: v[o == null ? void 0 : o.value].V }));
  return (c, n) => {
    const R = O, C = b("print-table"), L = q, V = G, N = J, r = K, j = b("common-table"), A = Q;
    return i(), p("div", te, [e(A, { "model-value": l.visible, "show-close": false, "destroy-on-close": "", size: "50%" }, { header: t(() => [e(h, { "type-one": false, "header-title": "支付记录" }), e(R, { onClick: I }, { default: t(() => n[0] || (n[0] = [S("关闭")])), _: 1, __: [0] })]), default: t(() => [e(h, { "header-title": "" }, { headerRight: t(() => [e(C, { params: { ...P.value }, "api-key": "selfPaymentRecord", size: "default", type: "warning" }, null, 8, ["params"])]), _: 1 }), s("div", ae, [e(N, null, { default: t(() => [(i(true), p(z, null, F(E.value, (a) => (i(), y(V, { key: a.key, span: 12 }, { default: t(() => [s("div", oe, [s("span", null, m(a.label), 1), a.isTruncated ? (i(), y(L, { key: 0, content: a.value, placement: "top-start" }, { default: t(() => [s("span", ne, m(a.value), 1)]), _: 2 }, 1032, ["content"])) : (i(), p("span", se, m(a.value), 1))])]), _: 2 }, 1024))), 128))]), _: 1 })]), s("div", le, [e(j, { data: _.value, "max-height": d(T), "summary-method": d(D), border: "", "show-summary": "", stripe: "" }, { default: t(() => [e(r, { align: "center", label: "序号", type: "index", width: "60" }), e(r, { align: "center", label: "编号", prop: "number", width: "100" }), e(r, { align: "center", label: "支付日期", prop: "paymentDate" }), e(r, { align: "center", label: "支付金额（元）", prop: "paymentAmount" }), e(r, { align: "center", label: "支付方式", prop: "type" }, { default: t(({ row: a }) => [s("span", null, m(d(Z).VL[a.type]), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "summary-method"])])]), _: 1 }, 8, ["model-value"])]);
  };
} }, de = U(ce, [["__scopeId", "data-v-71a6813c"]]);
export {
  de as default
};
