import { computed as F } from "vue";
import { ref as _ } from "vue";
import { inject as G } from "vue";
import { watch as A } from "vue";
import { nextTick as H } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as h } from "vue";
import { unref as e } from "vue";
import { createBlock as u } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as w } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as S } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { vLoading as $ } from "element-plus";
import { b as K } from "../../../../../../modules/payment-application-18cdaf45.js";
import { _ as W, t as X, x as Y, o as Z, jF as ee, G as C, c3 as m, an as te, P as ae } from "../../../../../../shared/runtime.js";
import { L as oe } from "../../../../../../modules/project-19a12d6b.js";
import le from "./form.vue.js";
import ie from "./detail.vue.js";
import "../../../../../../modules/UploadBtn-b4cfb47a.js";
const ne = { __name: "index", props: { detailInfo: { type: Object, default: () => {
} }, visibleValue: { type: Boolean, default: false } }, setup(s) {
  const { decimalPrecision: N } = X(), d = oe.paymentManage, P = { add: true, edit: false, del: false, download: false }, U = s, E = F(() => [["applyDate", ["parse-time", "{y}-{m}-{d}"]], ["paymentDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["applyAmount", ["to-thousand", N.value.project]]]), b = _(), B = G("orderId"), g = _(false), k = _({}), { crud: i, CRUD: re } = Y({ title: "付款申请记录", sort: [], permission: { ...d }, optShow: { ...P }, crudApi: { ...K }, requiredQuery: ["propertyType", "orderId"], hasPagination: true }, b), { maxHeight: j } = Z({ paginate: true, extraHeight: 40 });
  A(() => U.visibleValue, (p) => {
    p && i.toQuery();
  }, { deep: true, immediate: true }), A(B, (p) => {
    H(() => {
      i.query.orderId = p, i.query.propertyType = ee.SUBCONTRACT.V, i.refresh();
    });
  }, { immediate: true });
  function q(p, l) {
    k.value = p.sourceRow, g.value = true;
  }
  return (p, l) => {
    var V, I;
    const x = D("common-button"), y = Q, o = J, z = D("common-table"), T = R("thousand"), L = R("permission"), O = $;
    return n(), M("div", null, [h("div", null, [e(C)(e(d).add) ? (n(), u(x, { key: 0, type: "primary", size: "default", onClick: e(i).toAdd, style: { "margin-right": "10px" } }, { default: r(() => l[1] || (l[1] = [c("添加")])), _: 1, __: [1] }, 8, ["onClick"])) : f("", true), s.detailInfo.amount ? (n(), u(y, { key: 1, type: "success", size: "large" }, { default: r(() => [l[2] || (l[2] = c("合同金额:")), w(h("span", null, null, 512), [[T, s.detailInfo.amount]])]), _: 1, __: [2] })) : f("", true), (I = (V = s.detailInfo) == null ? void 0 : V.sourceRow) != null && I.settlementAmount ? (n(), u(y, { key: 2, type: "success", size: "large", style: { "margin-left": "5px" } }, { default: r(() => {
      var a, v;
      return [l[3] || (l[3] = c("结算金额:")), w(h("span", null, null, 512), [[T, (v = (a = s.detailInfo) == null ? void 0 : a.sourceRow) == null ? void 0 : v.settlementAmount]])];
    }), _: 1, __: [3] })) : f("", true)]), w((n(), u(z, { ref_key: "tableRef", ref: b, data: e(i).data, "data-format": E.value, "empty-text": e(i).emptyText, "max-height": e(j), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: r(() => [t(o, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(o, { key: "receivingUnit", prop: "receivingUnit", label: "分包公司", align: "center", "show-overflow-tooltip": "" }), t(o, { key: "applyUserName", prop: "applyUserName", label: "申请人", align: "center", "show-overflow-tooltip": "" }), t(o, { key: "paymentDate", prop: "paymentDate", label: "申请日期", align: "center", "show-overflow-tooltip": "" }), t(o, { key: "applyAmount", prop: "applyAmount", label: "申请金额", align: "right", "show-overflow-tooltip": "" }), t(o, { key: "paymentReasonName", prop: "paymentReasonName", label: "付款事由", align: "center", "show-overflow-tooltip": "" }), t(o, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center", "show-overflow-tooltip": "" }, { default: r((a) => [a.row.auditStatus === e(m).REJECT.V ? (n(), u(y, { key: 0, type: "warning" }, { default: r(() => [c(S(e(m).VL[a.row.auditStatus]), 1)]), _: 2 }, 1024)) : (n(), u(y, { key: 1, type: a.row.auditStatus === e(m).PASS.V ? "success" : "primary" }, { default: r(() => [c(S(e(m).VL[a.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 }), t(o, { key: "actuallyPaymentAmount", prop: "actuallyPaymentAmount", label: "实付金额", align: "right", "show-overflow-tooltip": "" }), t(o, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center", "show-overflow-tooltip": "" }), t(o, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center", "show-overflow-tooltip": "" }), e(C)([...e(d).edit, ...e(d).del]) ? (n(), u(o, { key: 0, label: "操作", width: "190px", align: "center" }, { default: r((a) => [w(t(x, { icon: "el-icon-view", type: "primary", size: "default", onClick: (v) => q(a.row, "detail") }, null, 8, ["onClick"]), [[L, e(d).detail]]), t(e(te), { data: a.row, "show-edit": a.row.auditStatus === e(m).AUDITING.V, "show-del": a.row.auditStatus === e(m).AUDITING.V, permission: e(d) }, null, 8, ["data", "show-edit", "show-del", "permission"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[O, e(i).loading]]), t(e(le), { "detail-info": s.detailInfo }, null, 8, ["detail-info"]), t(e(ie), { "detail-info": s.detailInfo, modelValue: g.value, "onUpdate:modelValue": l[0] || (l[0] = (a) => g.value = a), currentRow: k.value }, null, 8, ["detail-info", "modelValue", "currentRow"]), t(e(ae))]);
  };
} }, fe = W(ne, [["__scopeId", "data-v-58e0f532"]]);
export {
  fe as default
};
