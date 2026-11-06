import { computed as y } from "vue";
import { ref as l } from "vue";
import { inject as V } from "vue";
import { watch as j } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as P } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as t } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as B } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElPagination as T } from "element-plus";
import { g as D } from "../../../../../../modules/payable-list-dd7ea2e5.js";
import { t as E, J as q, i as H } from "../../../../../../shared/runtime.js";
import U from "./detail-table/purchase-detail.vue.js";
const O = ["onClick"], M = { __name: "purchase-list", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(h, { emit: F }) {
  const { decimalPrecision: i } = E(), r = h, { handleSizeChange: b, handleCurrentChange: C, total: _, setTotalPage: k, queryPage: p } = q({ fetchHook: v }), N = y(() => {
    var a;
    return { supplierId: (a = r.detailInfo) == null ? void 0 : a.supplierId };
  }), u = l([]);
  l();
  const f = l(false);
  V("query");
  const g = l({}), c = l(false), x = y(() => [["createTime", ["parse-time", "{y}-{m}-{d}"]], ["projectList", ["parse-project"]], ["amount", ["to-thousand", i.value.supplyChain]], ["settlementAmount", ["to-thousand", i.value.supplyChain]], ["paidAmount", ["to-thousand", i.value.supplyChain]], ["receivedInvoiceAmount", ["to-thousand", i.value.supplyChain]]]);
  j([() => r.detailInfo, () => r.isVisible], () => {
    v();
  }, { immediate: true, deep: true });
  async function v() {
    var o;
    if (!H((o = r.detailInfo) == null ? void 0 : o.supplierId)) {
      u.value = [];
      return;
    }
    let a = [];
    f.value = true;
    try {
      const { content: e = [], totalElements: m } = await D({ ...N.value, ...p });
      a = e, k(m);
    } catch (e) {
      console.log("获取采购订单记录失败", e);
    } finally {
      u.value = a, f.value = false;
    }
  }
  function I(a) {
    g.value = a, c.value = true;
  }
  return (a, o) => {
    const e = S, m = z("common-table"), A = T;
    return P(), L("div", null, [t(m, { data: u.value, "data-format": x.value, "max-height": h.maxHeight }, { default: d(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { key: "serialNumber", prop: "serialNumber", label: "采购合同", align: "center", "show-overflow-tooltip": "" }, { default: d(({ row: s }) => [w("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (J) => I(s) }, B(s.serialNumber), 9, O)]), _: 1 }), t(e, { key: "type", prop: "type", label: "合同类型", align: "center", width: "80", "show-overflow-tooltip": "" }, { default: d(() => o[1] || (o[1] = [w("span", null, "采购", -1)])), _: 1 }), t(e, { key: "branchCompanyName", prop: "branchCompanyName", label: "采购单位/签约主体", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), t(e, { key: "projectList", prop: "projectList", label: "关联项目", align: "center", "min-width": "170", "show-overflow-tooltip": "" }), t(e, { key: "amount", prop: "amount", label: "合同额", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "settlementAmount", prop: "settlementAmount", label: "结算额", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "paidAmount", prop: "paidAmount", label: "累计付款", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "receivedInvoiceAmount", prop: "receivedInvoiceAmount", label: "累计收票", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "createTime", prop: "createTime", label: "创建日期", align: "center", "show-overflow-tooltip": "", width: "120" }), t(e, { key: "createUserName", prop: "createUserName", label: "创建人", align: "center", "show-overflow-tooltip": "", width: "90" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), t(A, { total: n(_), "current-page": n(p).pageNumber, "page-size": n(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(b), onCurrentChange: n(C) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), t(U, { modelValue: c.value, "onUpdate:modelValue": o[0] || (o[0] = (s) => c.value = s), id: g.value.id }, null, 8, ["modelValue", "id"])]);
  };
} };
export {
  M as default
};
