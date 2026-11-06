import { computed as b } from "vue";
import { ref as l } from "vue";
import { watch as A } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as t } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as P } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElPagination as B } from "element-plus";
import { a as T } from "../../../../../../modules/payable-list-dd7ea2e5.js";
import { t as D, J as E, i as H } from "../../../../../../shared/runtime.js";
import O from "./detail-table/subcontract-detail.vue.js";
const U = ["onClick"], K = { __name: "subcontract-list", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, isVisible: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(f, { emit: q }) {
  const { decimalPrecision: i } = D(), r = f, { handleSizeChange: w, handleCurrentChange: C, total: _, setTotalPage: k, queryPage: p } = E({ fetchHook: v }), N = b(() => {
    var a;
    return { supplierId: (a = r.detailInfo) == null ? void 0 : a.supplierId };
  }), u = l([]);
  l();
  const h = l(false), g = l({}), c = l(false), x = b(() => [["createTime", ["parse-time", "{y}-{m}-{d}"]], ["projectList", ["parse-project"]], ["amount", ["to-thousand", i.value.supplyChain]], ["settlementAmount", ["to-thousand", i.value.supplyChain]], ["paidAmount", ["to-thousand", i.value.supplyChain]], ["receivedInvoiceAmount", ["to-thousand", i.value.supplyChain]]]);
  A([() => r.detailInfo, () => r.isVisible], () => {
    v();
  }, { immediate: true, deep: true });
  async function v() {
    var o;
    if (!H((o = r.detailInfo) == null ? void 0 : o.supplierId)) {
      u.value = [];
      return;
    }
    let a = [];
    h.value = true;
    try {
      const { content: e = [], totalElements: m } = await T({ ...N.value, ...p });
      a = e, k(m);
    } catch (e) {
      console.log("获取分包订单记录失败", e);
    } finally {
      u.value = a, h.value = false;
    }
  }
  function I(a) {
    g.value = a, c.value = true;
  }
  return (a, o) => {
    const e = S, m = j("common-table"), V = B;
    return z(), L("div", null, [t(m, { data: u.value, "data-format": x.value, "max-height": f.maxHeight }, { default: d(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { key: "serialNumber", prop: "serialNumber", label: "分包合同", align: "center", "show-overflow-tooltip": "" }, { default: d(({ row: s }) => [y("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (F) => I(s) }, P(s.serialNumber), 9, U)]), _: 1 }), t(e, { key: "type", prop: "type", label: "合同类型", align: "center", width: "80", "show-overflow-tooltip": "" }, { default: d(() => o[1] || (o[1] = [y("span", null, "分包", -1)])), _: 1 }), t(e, { key: "branchCompanyName", prop: "branchCompanyName", label: "采购单位/签约主体", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), t(e, { key: "projectList", prop: "projectList", label: "关联项目", align: "center", "min-width": "170", "show-overflow-tooltip": "" }), t(e, { key: "amount", prop: "amount", label: "合同额", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "settlementAmount", prop: "settlementAmount", label: "结算额", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "paidAmount", prop: "paidAmount", label: "累计付款", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "receivedInvoiceAmount", prop: "receivedInvoiceAmount", label: "累计收票", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "createTime", prop: "createTime", label: "创建日期", align: "center", "show-overflow-tooltip": "", width: "120" }), t(e, { key: "createUserName", prop: "createUserName", label: "创建人", align: "center", "show-overflow-tooltip": "", width: "90" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), t(V, { total: n(_), "current-page": n(p).pageNumber, "page-size": n(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(w), onCurrentChange: n(C) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), t(O, { modelValue: c.value, "onUpdate:modelValue": o[0] || (o[0] = (s) => c.value = s), id: g.value.id }, null, 8, ["modelValue", "id"])]);
  };
} };
export {
  K as default
};
