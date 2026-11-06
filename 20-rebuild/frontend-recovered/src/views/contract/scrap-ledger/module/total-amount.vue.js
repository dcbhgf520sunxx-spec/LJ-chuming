import { ref as u } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as N } from "vue";
import { createBlock as x } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as S } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { isRef as T } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElPagination as W } from "element-plus";
import { t as B } from "../../../../modules/scrap-ledger-452ee452.js";
import { V as d } from "../../../../modules/contract-9b18cc88.js";
import { u as E, J as q, G as H } from "../../../../shared/runtime.js";
const F = { __name: "total-amount", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(g, { emit: b }) {
  const o = g, _ = b, { visible: l, handleClose: f } = E({ props: o, emit: _, showHook: m }), { handleSizeChange: h, handleCurrentChange: C, total: y, setTotalPage: w, queryPage: s } = q({ fetchHook: m }), v = u([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["saleDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]]]), p = u([]);
  async function m() {
    if (H(d.detail)) try {
      const { content: n, totalElements: r } = await B({ ...s, branchCompanyId: o.currentRow.branchCompanyId, contractWasteId: o.currentRow.contractWasteId });
      console.log(n), w(r), p.value = n;
    } catch (n) {
      console.log(n);
    }
  }
  return (n, r) => {
    const I = c("print-table"), a = U, z = c("common-table"), R = W, V = c("common-drawer"), D = k("permission");
    return N(), x(V, { modelValue: t(l), "onUpdate:modelValue": r[0] || (r[0] = (P) => T(l) ? l.value = P : null), "before-close": t(f), size: "100%", title: "累计出售额" }, { titleRight: i(() => [S(e(I, { "api-key": "totalScrapDetaile", params: { branchCompanyId: o.currentRow.branchCompanyId, contractWasteId: o.currentRow.contractWasteId } }, null, 8, ["params"]), [[D, t(d).detailPrint]])]), content: i(() => [e(z, { data: p.value, "data-format": v.value }, { default: i(() => [e(a, { label: "序号", align: "center", width: "60", type: "index" }), e(a, { label: "合同编号", align: "center", prop: "serialNumber" }), e(a, { label: "购买单位", align: "center", prop: "purchaser" }), e(a, { label: "废料类型", align: "center", prop: "wasteClassificationName" }), e(a, { label: "核算单位", align: "center", prop: "measureUnit" }), e(a, { label: "数量", align: "center", prop: "saleMete" }), e(a, { label: "单价(元)", align: "center", prop: "price" }), e(a, { label: "金额", align: "center", prop: "amount" }), e(a, { label: "创建人", align: "center", prop: "createUserName" }), e(a, { label: "出售日期", align: "center", prop: "saleDate" }), e(a, { label: "审核人", align: "center", prop: "auditUserName" }), e(a, { label: "审核日期", align: "center", prop: "auditTime" })]), _: 1 }, 8, ["data", "data-format"]), e(R, { total: t(y), "current-page": t(s).pageNumber, "page-size": t(s).pageSize, layout: "total, prev, pager, next, sizes", onSizeChange: t(h), onCurrentChange: t(C) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  F as default
};
