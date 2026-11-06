import { computed as j } from "vue";
import { ref as d } from "vue";
import { watch as D } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as a } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as H } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as M } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTag as z } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as q, x as F, z3 as g, zY as I, o as K, ib as _, G as Q, an as Y, P as $ } from "../../../../../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import W from "./module/detail.vue.js";
import X from "./module/review.vue.js";
import "../../../../../../../../modules/material-inventory-71cd4559.js";
import "../../../../../../../../modules/review-confirm-button-aa3600ad.js";
const Z = { class: "app-container" }, ee = { __name: "index", props: { showType: { type: String, default: void 0 }, visible: { type: Boolean, default: void 0 } }, emits: ["success"], setup(c, { emit: k }) {
  const N = k, T = { add: false, edit: false, del: false, download: false }, w = c, x = j(() => [["applyTime", ["parse-time", "{y}-{m}-{d}"]], ["reviewTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), h = d(), b = d(false), S = d({}), { crud: n, CRUD: R, columns: l } = F({ title: "存货转换单", sort: [], permission: { ...g }, invisibleColumns: ["applyTime", "applyUserName", "reviewTime", "reviewerName"], optShow: { ...T }, crudApi: { ...I }, hasPagination: true }, h);
  D(() => w.visible, (u) => {
    u && n.toQuery();
  }, { immediate: true });
  const { maxHeight: V } = K({ paginate: true, extraHeight: 40 });
  function C() {
    N("success"), n.refresh();
  }
  return R.HOOK.handleRefresh = (u, { data: m }) => {
    m.content.forEach((t) => {
      t.widthThick = t.thickness || t.width ? (t.thickness || "-") + "*" + (t.width || "-") : "-";
    });
  }, (u, m) => {
    const t = O, P = v("table-cell-tag"), A = z, B = v("common-table"), U = G;
    return o(), E("div", Z, [s(e(J), { showType: w.showType }, null, 8, ["showType"]), L((o(), a(B, { ref_key: "tableRef", ref: h, data: e(n).data, "data-format": x.value, "empty-text": e(n).emptyText, "max-height": e(V), stripe: false, class: "collection-table", style: { width: "100%", "margin-top": "10px" } }, { default: p(() => [s(t, { align: "center", label: "序号", prop: "index", type: "index", width: "55" }), e(l).visible("receiptSerialNumber") ? (o(), a(t, { key: "receiptSerialNumber", align: "center", label: "转换单号", "min-width": "150", prop: "receiptSerialNumber", "show-overflow-tooltip": "" }, { default: p(({ row: r }) => [s(P, { show: !!r.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), H("span", null, y(r.receiptSerialNumber), 1)]), _: 1 })) : i("", true), e(l).visible("outSerialNumber") && c.showType !== "coilPlate" ? (o(), a(t, { key: "outSerialNumber", align: "center", label: "出库单号", prop: "outSerialNumber", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("serialNumber") ? (o(), a(t, { key: "serialNumber", align: "center", label: "物料编号", prop: "serialNumber", "show-overflow-tooltip": "", width: "100" })) : i("", true), e(l).visible("classifyName") ? (o(), a(t, { key: "classifyName", align: "center", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "", width: "100" })) : i("", true), e(l).visible("specification") ? (o(), a(t, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("widthThick") ? (o(), a(t, { key: "widthThick", align: "center", label: "厚(mm)*宽(mm)", "min-width": "120", prop: "widthThick", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("mete") ? (o(), a(t, { key: "mete", align: "center", label: "转换总重(kg)", prop: "mete", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("brand") ? (o(), a(t, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("color") ? (o(), a(t, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("heatNoAndBatchNo") ? (o(), a(t, { key: "heatNoAndBatchNo", align: "center", label: "卷号", prop: "heatNoAndBatchNo", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("project") ? (o(), a(t, { key: "project", align: "center", label: "所属项目", prop: "project", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("warehouse.name") ? (o(), a(t, { key: "warehouse.name", align: "center", label: "车间位置", prop: "warehouse.name", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("applyTime") ? (o(), a(t, { key: "applyTime", align: "center", label: "申请时间", prop: "applyTime", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("applyUserName") ? (o(), a(t, { key: "applyUserName", align: "center", label: "申请人", prop: "applyUserName", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("reviewTime") && c.showType !== "coilPlate" ? (o(), a(t, { key: "reviewTime", align: "center", label: "审核时间", prop: "reviewTime", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("reviewerName") && c.showType !== "coilPlate" ? (o(), a(t, { key: "reviewerName", align: "center", label: "审核人", prop: "reviewerName", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("status") ? (o(), a(t, { key: "status", "show-overflow-tooltip": true, align: "center", label: "审核状态", prop: "status", width: "80" }, { default: p(({ row: { sourceRow: r } }) => {
      var f;
      return [s(A, { type: (f = e(_).V[r.status]) == null ? void 0 : f.TAG }, { default: p(() => [M(y(e(_).VL[r.status]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), e(Q)([...e(g).detail]) ? (o(), a(t, { key: 17, align: "center", label: "操作", width: "80px" }, { default: p(({ row: r }) => [s(Y, { data: r, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[U, e(n).loading]]), s(e(W)), s(X, { modelValue: b.value, "onUpdate:modelValue": m[0] || (m[0] = (r) => b.value = r), "detail-info": S.value, onRefresh: C }, null, 8, ["modelValue", "detail-info"]), s(e($))]);
  };
} }, ne = q(ee, [["__scopeId", "data-v-b3a1b651"]]);
export {
  ne as default
};
