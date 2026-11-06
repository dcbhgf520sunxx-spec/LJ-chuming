import { computed as g } from "vue";
import { ref as p } from "vue";
import { inject as N } from "vue";
import { watch as S } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as t } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as z } from "vue";
import { toDisplayString as B } from "vue";
import { unref as o } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElPagination as T } from "element-plus";
import { d as V } from "../../../../../../modules/payable-list-dd7ea2e5.js";
import { t as j, J as L, by as q, i as H, jN as M } from "../../../../../../shared/runtime.js";
const J = { __name: "manuf-transport", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(c, { emit: W }) {
  const { decimalPrecision: b } = j(), l = c, { handleSizeChange: y, handleCurrentChange: v, total: w, setTotalPage: _, queryPage: n } = L({ fetchHook: m }), P = g(() => {
    var a;
    return { supplierId: (a = l.detailInfo) == null ? void 0 : a.supplierId };
  }), i = p([]);
  p();
  const u = p(false);
  N("query");
  const C = g(() => [["shipDate", ["parse-time", "{y}-{m}-{d}"]], ["loadingWeight", ["to-fixed", 2]], ["totalPrice", ["to-thousand", b.value.supplyChain]], ["shipmentStatus", ["parse-enum", q]]]);
  S([() => l.detailInfo, () => l.isVisible], () => {
    m();
  }, { immediate: true, deep: true });
  async function m() {
    var r;
    if (!H((r = l.detailInfo) == null ? void 0 : r.supplierId)) {
      i.value = [];
      return;
    }
    let a = [];
    u.value = true;
    try {
      const { content: e = [], totalElements: s } = await V({ ...P.value, ...n });
      a = e, _(s);
    } catch (e) {
      console.log("获取制成品物流记录失败", e);
    } finally {
      i.value = a, u.value = false;
    }
  }
  return (a, r) => {
    const e = D, s = h("table-cell-tag"), k = h("common-table"), x = T;
    return E(), I("div", null, [t(k, { data: i.value, "data-format": C.value, "max-height": c.maxHeight }, { default: f(() => [t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { key: "shipDate", prop: "shipDate", label: "运输日期", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": "" }, { default: f(({ row: d }) => [t(s, { show: !!d.boolPersonalEnum, name: "个人", offset: 15 }, null, 8, ["show"]), z("span", null, B(d.licensePlate), 1)]), _: 1 }), t(e, { key: "loadingWeight", prop: "loadingWeight", label: `装载重量${o(M).weight.unit}`, align: "center", "show-overflow-tooltip": "" }, null, 8, ["label"]), t(e, { key: "totalPrice", prop: "totalPrice", label: "运输费", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "carModel", prop: "carModel", label: "车型", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "driverName", prop: "driverName", label: "司机姓名", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "driverPhone", prop: "driverPhone", label: "电话", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "serialNumber", prop: "serialNumber", label: "车次", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "shipmentStatus", prop: "shipmentStatus", label: "状态", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), t(x, { total: o(w), "current-page": o(n).pageNumber, "page-size": o(n).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(y), onCurrentChange: o(v) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} };
export {
  J as default
};
