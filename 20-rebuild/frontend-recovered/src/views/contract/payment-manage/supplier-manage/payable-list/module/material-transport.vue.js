import { computed as y } from "vue";
import { ref as n } from "vue";
import { watch as T } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as U } from "vue";
import { createElementBlock as W } from "vue";
import { createVNode as t } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as c } from "vue";
import { unref as r } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElPagination as L } from "element-plus";
import { b as j } from "../../../../../../modules/payable-list-dd7ea2e5.js";
import { t as q, J as O, by as R, i as $ } from "../../../../../../shared/runtime.js";
import F from "./detail-table/purchase-detail.vue.js";
import J from "./detail-table/inbound-detail.vue.js";
const M = ["onClick"], A = ["onClick"], ee = { __name: "material-transport", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(b, { emit: G }) {
  const { decimalPrecision: C } = q(), s = b, { handleSizeChange: k, handleCurrentChange: S, total: V, setTotalPage: x, queryPage: d } = O({ fetchHook: _ }), I = y(() => {
    var o;
    return { supplierId: (o = s.detailInfo) == null ? void 0 : o.supplierId };
  }), m = n([]);
  n();
  const v = n(false), u = n({}), f = n(false), h = n(false), P = y(() => [["inboundTime", ["parse-time", "{y}-{m}-{d}"]], ["freightWeight", ["to-fixed", 2]], ["freight", ["to-thousand", C.value.supplyChain]], ["shipmentStatus", ["parse-enum", R]]]);
  T([() => s.detailInfo, () => s.isVisible], () => {
    _();
  }, { immediate: true, deep: true });
  async function _() {
    var l;
    if (!$((l = s.detailInfo) == null ? void 0 : l.supplierId)) {
      m.value = [];
      return;
    }
    let o = [];
    v.value = true;
    try {
      const { content: a = [], totalElements: g } = await j({ ...I.value, ...d });
      o = a, x(g);
    } catch (a) {
      console.log("获取原材料物流记录失败", a);
    } finally {
      m.value = o, v.value = false;
    }
  }
  function z(o) {
    u.value = o, f.value = true;
  }
  function N(o) {
    u.value = o, h.value = true;
  }
  return (o, l) => {
    const a = H, g = w("table-cell-tag"), B = w("common-table"), D = L;
    return U(), W("div", null, [t(B, { data: m.value, "data-format": P.value, "max-height": b.maxHeight }, { default: i(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { key: "inboundTime", prop: "inboundTime", label: "入库日期", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "licensePlate", prop: "licensePlate", label: "车牌/物流号", align: "center", "show-overflow-tooltip": "" }, { default: i(({ row: e }) => [t(g, { show: !!e.boolPersonalEnum, name: "个人", offset: 15 }, null, 8, ["show"]), p("span", null, c(e.licensePlate), 1)]), _: 1 }), t(a, { key: "freightWeight", prop: "freightWeight", label: "装载重量", align: "center", "show-overflow-tooltip": "" }, { default: i(({ row: e }) => [p("span", null, c(e.freightWeight), 1)]), _: 1 }), t(a, { key: "freight", prop: "freight", label: "运输费", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "show-overflow-tooltip": "" }, { default: i(({ row: e }) => [p("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (E) => z(e) }, c(e.purchaseSn), 9, M)]), _: 1 }), t(a, { key: "purchaseUserName", prop: "purchaseUserName", label: "采购员", align: "center", "show-overflow-tooltip": "" }), t(a, { key: "inboundSn", prop: "inboundSn", label: "关联入库单", align: "center", "show-overflow-tooltip": "" }, { default: i(({ row: e }) => [p("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (E) => N(e) }, c(e.inboundSn), 9, A)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"]), t(D, { total: r(V), "current-page": r(d).pageNumber, "page-size": r(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(k), onCurrentChange: r(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), t(F, { modelValue: f.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => f.value = e), id: u.value.purchaseId }, null, 8, ["modelValue", "id"]), t(J, { modelValue: h.value, "onUpdate:modelValue": l[1] || (l[1] = (e) => h.value = e), id: u.value.inboundId }, null, 8, ["modelValue", "id"])]);
  };
} };
export {
  ee as default
};
