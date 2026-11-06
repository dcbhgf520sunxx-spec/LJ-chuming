import { computed as q } from "vue";
import { ref as b } from "vue";
import { inject as z } from "vue";
import { watch as I } from "vue";
import { nextTick as H } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as G } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as L } from "vue";
import { createVNode as a } from "vue";
import { ElTag as M } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as J } from "../../../../../../modules/payment-application-502afb4b.js";
import { _ as $, t as K, x as W, o as X, jF as Y, G as S, bV as A, c3 as d, an as Z, P as ee, v_ as te } from "../../../../../../shared/runtime.js";
import ae from "./form.vue.js";
import oe from "./detail.vue.js";
import "../../../../../../modules/UploadBtn-b4cfb47a.js";
const ie = { __name: "index", props: { detailInfo: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false } }, setup(n) {
  const { decimalPrecision: _ } = K(), m = te.application, D = { add: true, edit: false, del: false, download: false }, P = n, R = q(() => [["paymentDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", "parse-time"], ["applyAmount", ["to-thousand", _.value.supplyChain]]]), x = b(), E = z("orderId"), w = b(false), k = b({}), { crud: o, CRUD: le } = W({ title: "付款申请记录", sort: [], permission: { ...m }, optShow: { ...D }, crudApi: { ...J }, requiredQuery: ["propertyType", "orderId"], hasPagination: true }, x), { maxHeight: N } = X({ paginate: true, extraHeight: 40 });
  I(() => P.visibleValue, (u) => {
    u && o.toQuery();
  }, { deep: true, immediate: true }), I(E, (u) => {
    H(() => {
      o.query.orderId = u, o.query.propertyType = Y.PURCHASE.V, o.refresh();
    });
  }, { immediate: true });
  function U(u, p) {
    k.value = u, w.value = true;
  }
  return (u, p) => {
    var V, C;
    const v = T("common-button"), y = M, r = O, B = T("common-table"), j = Q;
    return i(), F("div", null, [G("div", null, [e(S)(e(m).add) ? (i(), s(v, { key: 0, type: "primary", size: "default", onClick: e(o).toAdd, style: { "margin-right": "10px" } }, { default: l(() => p[1] || (p[1] = [c("添加")])), _: 1, __: [1] }, 8, ["onClick"])) : f("", true), n.detailInfo.amount ? (i(), s(y, { key: 1, type: "success", size: "large" }, { default: l(() => [c(g("合同金额:" + e(A)(n.detailInfo.amount, e(_).supplyChain)), 1)]), _: 1 })) : f("", true), (C = (V = n.detailInfo) == null ? void 0 : V.sourceRow) != null && C.settlementAmount ? (i(), s(y, { key: 2, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: l(() => {
      var t, h;
      return [c(g("结算金额:" + e(A)((h = (t = n.detailInfo) == null ? void 0 : t.sourceRow) == null ? void 0 : h.settlementAmount, e(_).supplyChain)), 1)];
    }), _: 1 })) : f("", true)]), L((i(), s(B, { ref_key: "tableRef", ref: x, data: e(o).data, "data-format": R.value, "empty-text": e(o).emptyText, "max-height": e(N), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: l(() => [a(r, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), a(r, { key: "paymentDate", prop: "paymentDate", label: "付款日期", align: "center" }), a(r, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "right" }), a(r, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center" }), a(r, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center" }), a(r, { key: "auditStatus", prop: "auditStatus", label: "审核状态", align: "center" }, { default: l((t) => [t.row.auditStatus === e(d).REJECT.V ? (i(), s(y, { key: 0, type: "warning" }, { default: l(() => [c(g(e(d).VL[t.row.auditStatus]), 1)]), _: 2 }, 1024)) : (i(), s(y, { key: 1, type: t.row.auditStatus === e(d).PASS.V ? "success" : "primary" }, { default: l(() => [c(g(e(d).VL[t.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 }), e(S)([...e(m).edit, ...e(m).del]) ? (i(), s(r, { key: 0, label: "操作", width: "190px", align: "center" }, { default: l((t) => [a(v, { icon: "el-icon-view", type: "primary", size: "default", onClick: (h) => U(t.row, "detail") }, null, 8, ["onClick"]), a(e(Z), { data: t.row, "show-edit": t.row.auditStatus === e(d).AUDITING.V, "show-del": t.row.auditStatus === e(d).AUDITING.V, permission: e(m) }, null, 8, ["data", "show-edit", "show-del", "permission"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[j, e(o).loading]]), a(e(ae), { "detail-info": n.detailInfo }, null, 8, ["detail-info"]), a(e(oe), { "detail-info": n.detailInfo, modelValue: w.value, "onUpdate:modelValue": p[0] || (p[0] = (t) => w.value = t), currentRow: k.value }, null, 8, ["detail-info", "modelValue", "currentRow"]), a(e(ee))]);
  };
} }, pe = $(ie, [["__scopeId", "data-v-b0a18fcd"]]);
export {
  pe as default
};
