import { computed as j } from "vue";
import { ref as h } from "vue";
import { watch as A } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as a } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as I } from "vue";
import { toDisplayString as P } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as L, D as O, x as U, z4 as M, o as z, cO as F, jl as W, G as $, P as G, BB as K } from "../../../../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../../../../modules/material-inventory-71cd4559.js";
const J = { class: "app-container" }, X = { __name: "index", props: { currentInfo: { type: Object, default: () => {
} } }, setup(_) {
  const g = { add: false, edit: false, del: false, download: false }, u = K.list, k = j(() => [["applyTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["amountExcludingVat", ["to-thousand", O.YUAN]]]), m = _, f = h(), d = h(false), y = h({}), { crud: n, CRUD: x, columns: l } = U({ title: "存货转换单", sort: [], invisibleColumns: [], permission: { ...u }, optShow: { ...g }, crudApi: { ...M }, hasPagination: true }, f);
  A(() => m.currentInfo, (p) => {
    var r, e;
    p && (n.query.projectId = (e = (r = m.currentInfo) == null ? void 0 : r.project) == null ? void 0 : e.id, n.query.projectWarehouseType = m.currentInfo.projectWarehouseType, n.toQuery());
  }, { immediate: true, deep: true });
  const { maxHeight: N } = z({ paginate: true, extraHeight: 40 });
  function T(p) {
    y.value = p, d.value = true;
  }
  return x.HOOK.handleRefresh = async (p, { data: r }) => {
    r.content.forEach((e) => {
      e.widthThick = e.thickness || e.width ? (e.thickness || "-") + "*" + (e.width || "-") : "-";
    }), await F(r.content), r.content = await W(r.content, { toSmallest: false, toNum: true });
  }, (p, r) => {
    const e = q, C = b("table-cell-tag"), S = b("common-button"), B = b("common-table"), V = R("permission"), D = H;
    return o(), E("div", J, [c(t(Q)), v((o(), a(B, { ref_key: "tableRef", ref: f, data: t(n).data, "data-format": k.value, "empty-text": t(n).emptyText, "max-height": t(N), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false }, { default: w(() => [c(e, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(l).visible("receiptSerialNumber") ? (o(), a(e, { key: "receiptSerialNumber", prop: "receiptSerialNumber", label: "转换单号", align: "center", "min-width": "150", "show-overflow-tooltip": "" }, { default: w(({ row: s }) => [c(C, { show: !!s.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), I("span", null, P(s.receiptSerialNumber), 1)]), _: 1 })) : i("", true), t(l).visible("applyTime") ? (o(), a(e, { key: "applyTime", prop: "applyTime", label: "转换时间", align: "center", "show-overflow-tooltip": "" })) : i("", true), t(l).visible("outSerialNumber") ? (o(), a(e, { key: "outSerialNumber", prop: "outSerialNumber", label: "出库单号", align: "center", "show-overflow-tooltip": "" })) : i("", true), t(l).visible("serialNumber") ? (o(), a(e, { key: "serialNumber", prop: "serialNumber", label: "物料编号", align: "center", "show-overflow-tooltip": "", width: "100" })) : i("", true), t(l).visible("classifyName") ? (o(), a(e, { key: "classifyName", prop: "classifyName", label: "物料名称", align: "center", "show-overflow-tooltip": "", width: "100" })) : i("", true), t(l).visible("specification") ? (o(), a(e, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" })) : i("", true), t(l).visible("widthThick") ? (o(), a(e, { key: "widthThick", prop: "widthThick", label: "厚(mm)*宽(mm)", align: "center", "show-overflow-tooltip": "", "min-width": "120" })) : i("", true), t(l).visible("quantity") ? (o(), a(e, { key: "quantity", prop: "quantity", label: "转换总长度(m)", align: "center", "show-overflow-tooltip": "", "min-width": "120" })) : i("", true), t(l).visible("mete") ? (o(), a(e, { key: "mete", prop: "mete", label: "转换总重(kg)", align: "center", "show-overflow-tooltip": "", "min-width": "120" })) : i("", true), t(l).visible("amountExcludingVat") ? (o(), a(e, { key: "amountExcludingVat", prop: "amountExcludingVat", label: "转换总金额(不含税)", align: "center", "show-overflow-tooltip": "", "min-width": "120" })) : i("", true), t(l).visible("brand") ? (o(), a(e, { key: "brand", prop: "brand", label: "品牌", align: "center", "show-overflow-tooltip": "" })) : i("", true), t(l).visible("color") ? (o(), a(e, { key: "color", prop: "color", label: "颜色", align: "center", "show-overflow-tooltip": "" })) : i("", true), t(l).visible("heatNoAndBatchNo") ? (o(), a(e, { key: "heatNoAndBatchNo", prop: "heatNoAndBatchNo", label: "卷号", align: "center", "show-overflow-tooltip": "" })) : i("", true), t(l).visible("warehouse.name") ? (o(), a(e, { key: "warehouse.name", prop: "warehouse.name", label: "仓库", align: "center", "show-overflow-tooltip": "" })) : i("", true), t($)([...t(u).detail]) ? (o(), a(e, { key: 14, label: "操作", width: "80px", align: "center" }, { default: w((s) => [v(c(S, { icon: "el-icon-view", type: "primary", size: "default", onClick: (Z) => T(s.row) }, null, 8, ["onClick"]), [[V, t(u).detail]])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[D, t(n).loading]]), c(t(Y), { "detail-info": y.value, modelValue: d.value, "onUpdate:modelValue": r[0] || (r[0] = (s) => d.value = s) }, null, 8, ["detail-info", "modelValue"]), c(t(G))]);
  };
} }, le = L(X, [["__scopeId", "data-v-0c46bbc2"]]);
export {
  le as default
};
