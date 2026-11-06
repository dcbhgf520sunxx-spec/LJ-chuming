import { ref as f } from "vue";
import { computed as g } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as d } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as v } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as U, t as q, uv as B, bD as M, x as H, uy as K, ll as W, o as F, bv as I, am as L, jJ as $, aR as G, jU as T, ux as x, P as J } from "../../../shared/runtime.js";
import z from "./module/header.vue.js";
import "../../../modules/warehouse-project-cascader-17e2b952.js";
function Q(w) {
  return U({ module: "scm", url: "logistics-order", method: "get", params: w });
}
const X = { get: Q }, Y = { class: "app-container" }, ae = { __name: "index", setup(w) {
  const { decimalPrecision: u } = q(), k = { batchAdd: false, add: false, edit: false, del: false, download: false }, b = f(), _ = g(() => [...B, ["loadingWeight", ["to-fixed-ck", "COM_WT__KG"]], ["invoiceType", ["parse-enum", M]], ["taxRate", ["suffix", "%"]], ["inputVAT", ["to-thousand", u.value.supplyChain]], ["amountExcludingVAT", ["to-thousand", u.value.supplyChain]], ["freight", ["to-thousand", u.value.supplyChain]], ["amount", ["to-thousand", u.value.supplyChain]], ["requisitionsSNStr", "empty-text"], ["remark", "empty-text"], ["auxMaterialNames", "split"]]), { CRUD: N, crud: n, columns: o } = H({ title: "物料物流订单", sort: ["id.desc"], invisibleColumns: ["projects", "purchaseSN", "serialNumber"], permission: { ...K }, optShow: { ...k }, crudApi: { ...X } }, b), m = f([]), { loaded: C, supplierKV: R } = W(), { maxHeight: V } = F({ paginate: true });
  return N.HOOK.handleRefresh = (S, { data: r }) => {
    r.content = r.content.map((t) => {
      const h = I.getBits(L.ENUM, t.basicClass, "L");
      return t.materialTypeText = $.VL[t.purchaseType] + " - " + h.join(" | "), t.supplier = g(() => R.value[t.supplierId]), t;
    });
  }, (S, r) => {
    const t = D, h = A("common-table"), E = O;
    return i(), P("div", Y, [p(e(z)), j((i(), a(h, { ref_key: "tableRef", ref: b, data: e(n).data, "data-format": _.value, "max-height": e(V), "default-expand-all": false, "expand-row-keys": m.value, "row-key": "id" }, { default: c(() => [p(G, { data: e(n).data, "expand-row-keys": m.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (s) => m.value = s), "row-key": "id" }, { default: c(({ row: s }) => [d("p", null, [r[1] || (r[1] = y(" 关联项目：")), d("span", null, v(s.projectsFullName), 1)]), d("p", null, [r[2] || (r[2] = y(" 备注：")), d("span", null, v(s.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), p(t, { label: "序号", type: "index", align: "center", width: "60" }), e(o).visible("createTime") ? (i(), a(t, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "日期", align: "center", width: "100" })) : l("", true), e(n).query && e(n).query.logisticsTransportType !== e(T).FREIGHT.V && e(o).visible("shipmentNumber") ? (i(), a(t, { key: "shipmentNumber", prop: "shipmentNumber", label: "物流单号", align: "left", "min-width": "150", "show-overflow-tooltip": "" })) : l("", true), e(n).query && e(n).query.logisticsTransportType !== e(T).POST.V && e(o).visible("licensePlate") ? (i(), a(t, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "left", "min-width": "100", "show-overflow-tooltip": "" })) : l("", true), e(o).visible("projects") ? (i(), a(t, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : l("", true), e(o).visible("materialTypeText") ? (i(), a(t, { key: "materialTypeText", "show-overflow-tooltip": true, prop: "materialTypeText", label: "物料种类", "min-width": "170" })) : l("", true), e(o).visible("loadingWeight") ? (i(), a(t, { key: "loadingWeight", "show-overflow-tooltip": true, prop: "loadingWeight", label: "装载重量(kg)", "min-width": "120", align: "right" })) : l("", true), e(o).visible("invoiceType") ? (i(), a(t, { key: "invoiceType", "show-overflow-tooltip": true, prop: "invoiceType", label: "票据类型", align: "center", "min-width": "130" })) : l("", true), e(o).visible("taxRate") ? (i(), a(t, { key: "taxRate", "show-overflow-tooltip": true, prop: "taxRate", label: "税率", align: "right", width: "70" })) : l("", true), e(o).visible("freight") ? (i(), a(t, { key: "freight", "show-overflow-tooltip": true, prop: "freight", label: "运费(含税)", align: "right", "min-width": "90" })) : l("", true), e(o).visible("amountExcludingVAT") ? (i(), a(t, { key: "amountExcludingVAT", "show-overflow-tooltip": true, prop: "amountExcludingVAT", label: "不含税金额", "min-width": "90", align: "right" })) : l("", true), e(o).visible("inputVAT") ? (i(), a(t, { key: "inputVAT", "show-overflow-tooltip": true, prop: "inputVAT", label: "进项税额", align: "right", "min-width": "80" })) : l("", true), e(o).visible("serialNumber") ? (i(), a(t, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", label: "物流单号(系统)", align: "center", "min-width": "170" })) : l("", true), e(o).visible("purchaseSN") ? (i(), a(t, { key: "purchaseSN", "show-overflow-tooltip": true, prop: "purchaseSN", label: "采购合同编号", align: "center", "min-width": "170" }, { default: c(({ row: s }) => [p(e(x), { "receipt-types": ["PURCHASE"], receipt: s.purchaseOrder }, null, 8, ["receipt"])]), _: 1 })) : l("", true), e(o).visible("inboundSN") ? (i(), a(t, { key: "inboundSN", "show-overflow-tooltip": true, prop: "inboundSN", label: "入库单号", align: "center", "min-width": "170" }, { default: c(({ row: s }) => [p(e(x), { "receipt-types": ["INBOUND"], receipt: s.inboundReceipt }, null, 8, ["receipt"])]), _: 1 })) : l("", true), e(o).visible("supplier.name") ? (i(), a(t, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "物流公司", "min-width": "200" })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[E, !e(C) || e(n).loading]]), p(e(J))]);
  };
} };
export {
  ae as default
};
