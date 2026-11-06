import { watch as i } from "vue";
import { ref as c } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as e } from "vue";
import { withCtx as N } from "vue";
import { unref as r } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElPagination as w } from "element-plus";
import { f as z } from "../../../../modules/scrap-ledger-452ee452.js";
import { V as v } from "../../../../modules/contract-9b18cc88.js";
import { J as P, G as S } from "../../../../shared/runtime.js";
const I = { __name: "date-query", props: { queryId: { type: Number, default: 1 }, scrapType: { type: Number, default: void 0 }, startDate: { type: [String, Number], default: void 0 }, endDate: { type: [String, Number], default: void 0 } }, setup(m) {
  const { handleSizeChange: u, handleCurrentChange: d, total: g, setTotalPage: b, queryPage: o } = P({ fetchHook: l }), t = m;
  i(() => t.queryId, (n) => {
    n === 2 && l();
  }, { immediate: true }), i(() => [t.startDate, t.endDate], () => {
    l();
  }), i(() => t.scrapType, () => {
    l();
  });
  const f = c([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["saleDate", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]]]), s = c([]);
  async function l() {
    if (S(v.get)) try {
      const { content: n, totalElements: p } = await z({ ...o, startDate: t.startDate, endDate: t.endDate, wasteClassificationId: t.scrapType });
      console.log(n), s.value = n, b(p);
    } catch (n) {
      console.log(n);
    }
  }
  return (n, p) => {
    const a = T, y = _("common-table"), h = w;
    return C(), D("div", null, [e(y, { data: s.value, "data-format": f.value }, { default: N(() => [e(a, { label: "序号", align: "center", width: "60", type: "index" }), e(a, { label: "合同编号", align: "center", prop: "serialNumber" }), e(a, { label: "购买单位", align: "center", prop: "purchaser" }), e(a, { label: "废料类型", align: "center", prop: "wasteClassificationName" }), e(a, { label: "核算单位", align: "center", prop: "measureUnit" }), e(a, { label: "数量", align: "center", prop: "saleMete" }), e(a, { label: "单价(元)", align: "center", prop: "price" }), e(a, { label: "金额", align: "center", prop: "amount" }), e(a, { label: "车牌/船牌号", align: "center", prop: "plateNumber" }), e(a, { label: "创建人", align: "center", prop: "createUserName" }), e(a, { label: "出售日期", align: "center", prop: "saleDate" }), e(a, { label: "审核人", align: "center", prop: "auditUserName" }), e(a, { label: "审核日期", align: "center", prop: "auditTime" })]), _: 1 }, 8, ["data", "data-format"]), e(h, { total: r(g), "current-page": r(o).pageNumber, "page-size": r(o).pageSize, layout: "total, prev, pager, next, sizes", onSizeChange: r(u), onCurrentChange: r(d) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} };
export {
  I as default
};
