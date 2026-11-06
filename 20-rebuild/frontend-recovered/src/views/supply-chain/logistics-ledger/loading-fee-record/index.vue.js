import { ref as f } from "vue";
import { computed as N } from "vue";
import { watch as T } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as o } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as S, g as U, _ as R } from "./module/header.vue.js";
import { t as O, uv as E, x as H, uw as W, o as A, jU as B, ux as b, P as M } from "../../../../shared/runtime.js";
const V = { class: "app-container" }, I = { __name: "index", setup(F) {
  const { decimalPrecision: g } = O(), w = { batchAdd: false, add: false, edit: false, del: false, download: false }, c = f(), _ = N(() => [...E, ["loadingWeight", ["to-fixed-ck", "COM_WT__T"]], ["loadingCharge", ["to-thousand", g.value.supplyChain]], ["inboundPassTime", "parse-time"]]), { CRUD: m, crud: l, columns: n } = H({ title: "原材料装车费记录", sort: ["id.desc"], invisibleColumns: [], permission: { ...W }, optShow: { ...w }, crudApi: { ...S } }, c), { maxHeight: y } = A({ paginate: true }), h = f();
  return T(() => l.query, async () => {
    h.value = await U(l.query);
  }, { deep: true, immediate: true }), m.HOOK.beforeRefresh = (i) => {
    i.query.inboundTime ? (i.query.passStartDate = i.query.inboundTime[0] || void 0, i.query.passEndDate = i.query.inboundTime[1] || void 0) : (i.query.passStartDate = void 0, i.query.passEndDate = void 0);
  }, m.HOOK.handleRefresh = (i, { data: u }) => {
    u.content = u.content.map((t) => t);
  }, (i, u) => {
    const t = q, v = k("common-table"), C = D;
    return a(), P("div", V, [r(e(R), { "details-count": h.value }, null, 8, ["details-count"]), x((a(), o(v, { ref_key: "tableRef", ref: c, data: e(l).data, "data-format": _.value, "default-expand-all": false, "max-height": e(y), "row-key": "id" }, { default: p(() => [r(t, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("inboundPassTime") ? (a(), o(t, { key: "inboundPassTime", "show-overflow-tooltip": true, align: "center", label: "入库时间", prop: "inboundPassTime", width: "150" })) : s("", true), e(l).query && e(l).query.logisticsTransportType !== e(B).POST.V && e(n).visible("licensePlate") ? (a(), o(t, { key: "licensePlate", align: "left", label: "车牌/船牌号", "min-width": "100", prop: "licensePlate", "show-overflow-tooltip": "" })) : s("", true), e(n).visible("loadingCharge") ? (a(), o(t, { key: "loadingCharge", "show-overflow-tooltip": true, align: "right", label: "装车费", "min-width": "90", prop: "loadingCharge" })) : s("", true), e(n).visible("purchaseSN") ? (a(), o(t, { key: "purchaseSN", "show-overflow-tooltip": true, align: "center", label: "采购合同编号", "min-width": "170", prop: "purchaseSN" }, { default: p(({ row: d }) => [r(e(b), { receipt: d.purchaseOrder, "receipt-types": ["PURCHASE"] }, null, 8, ["receipt"])]), _: 1 })) : s("", true), e(n).visible("loadingWeight") ? (a(), o(t, { key: "loadingWeight", "show-overflow-tooltip": true, align: "right", label: "装载重量(吨)", "min-width": "120", prop: "loadingWeight" })) : s("", true), e(n).visible("inboundSN") ? (a(), o(t, { key: "inboundSN", "show-overflow-tooltip": true, align: "center", label: "入库单号", "min-width": "170", prop: "inboundSN" }, { default: p(({ row: d }) => [r(e(b), { receipt: d.inboundReceipt, "receipt-types": ["INBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : s("", true), e(n).visible("purchaseUserName") ? (a(), o(t, { key: "purchaseUserName", "show-overflow-tooltip": true, label: "采购员", "min-width": "200", prop: "purchaseUserName" })) : s("", true), e(n).visible("inboundUserName") ? (a(), o(t, { key: "inboundUserName", "show-overflow-tooltip": true, label: "入库申请人", "min-width": "200", prop: "inboundUserName" })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[C, e(l).loading]]), r(e(M))]);
  };
} };
export {
  I as default
};
