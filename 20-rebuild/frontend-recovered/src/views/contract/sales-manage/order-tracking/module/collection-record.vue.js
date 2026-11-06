import { computed as v } from "vue";
import { watch as A } from "vue";
import { ref as p } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as T } from "vue";
import { createBlock as F } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as y } from "vue";
import { withDirectives as L } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { toDisplayString as O } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as J } from "element-plus";
import { a as G } from "../../../../../modules/order-tracking-9be524cd.js";
import { t as K, g8 as Q, u as W, J as X, c3 as Y, iv as Z, o as $ } from "../../../../../shared/runtime.js";
const ee = { class: "print-wrap" }, le = { __name: "collection-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(x, { emit: C }) {
  const { decimalPrecision: B } = K(), D = C, r = x, R = Q(["payment_reason"]), { visible: d, handleClose: z } = W({ emit: D, props: r }), { handleSizeChange: S, handleCurrentChange: k, total: H, setTotalPage: P, queryPage: s } = X({ fetchHook: w }), u = v(() => {
    var a;
    return { projectId: (a = r.detailInfo.project) == null ? void 0 : a.id, auditStatus: Y.PASS.V };
  });
  A(d, (a) => {
    a && w();
  });
  const h = p([]), g = p(), f = p(false), V = v(() => [["collectionDate", ["parse-time", "{y}-{m}-{d}"]], ["collectionMode", ["parse-enum", Z]], ["collectionAmount", ["to-thousand", B.value.contract]], ["taxRate", ["to-fixed", 2]]]), { maxHeight: j } = $({ mainBox: ".collection-record", extraBox: ".el-dialog__header", wrapperBox: ".el-dialog__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, g);
  async function w() {
    let a = [];
    f.value = true;
    try {
      const { content: l = [], totalElements: c } = await G({ ...u.value, ...s });
      a = l, P(c);
    } catch (l) {
      console.log("获取收款记录失败", l);
    } finally {
      h.value = a, f.value = false;
    }
  }
  return (a, l) => {
    const c = m("print-table"), o = U, E = m("common-table"), M = J, N = m("common-dialog"), q = I("permission");
    return T(), F(N, { ref_key: "dialogRef", ref: g, title: "收款记录", "append-to-body": "", visible: t(d), width: "1300px", "close-on-click-modal": false, "before-close": t(z), "custom-class": "collection-record", "show-close": "", top: "10vh" }, { titleRight: i(() => {
      var n;
      return [y("div", ee, [L(e(c, { "api-key": "projectCollectionDetail", params: { ...u.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[q, (n = r.permission) == null ? void 0 : n.print]])])];
    }), default: i(() => [e(E, { data: h.value, "data-format": V.value, "max-height": t(j) }, { default: i(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "collectionDate", label: "收款日期", align: "center", width: "100", "show-overflow-tooltip": "" }), e(o, { prop: "collectionAmount", label: "收款额", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), e(o, { prop: "collectionReason", label: "收款事由", align: "center", width: "100", "show-overflow-tooltip": "" }, { default: i(({ row: n }) => {
      var _, b;
      return [y("span", null, O((b = (_ = t(R).label) == null ? void 0 : _.payment_reason) == null ? void 0 : b[n.collectionReason]), 1)];
    }), _: 1 }), e(o, { prop: "collectionMode", label: "收款方式", align: "center", width: "100", "show-overflow-tooltip": "" }), e(o, { prop: "collectionUnit", label: "收款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "collectionDepositBank", label: "收款开户行", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(o, { prop: "writtenByName", label: "办理人", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(o, { prop: "auditorName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), e(M, { total: t(H), "current-page": t(s).pageNumber, "page-size": t(s).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(S), onCurrentChange: t(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  le as default
};
