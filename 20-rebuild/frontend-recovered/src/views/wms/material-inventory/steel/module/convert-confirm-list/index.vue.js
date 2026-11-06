import { computed as j } from "vue";
import { ref as w } from "vue";
import { watch as L } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as M } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as O } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElTag as I } from "element-plus";
import { vLoading as $ } from "element-plus";
import { _ as q, x as F, z3 as f, z4 as K, o as Q, G as k, an as W, z5 as J, P as X } from "../../../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import Z from "./module/review.vue.js";
import "../../../../../../modules/material-inventory-71cd4559.js";
import "../../../../../../modules/review-confirm-button-aa3600ad.js";
const ee = { class: "app-container" }, te = { __name: "index", props: { showType: { type: String, default: void 0 }, visible: { type: Boolean, default: void 0 } }, emits: ["success"], setup(m, { emit: N }) {
  const T = N, x = { add: false, edit: false, del: false, download: false }, b = m, S = j(() => [["applyTime", ["parse-time", "{y}-{m}-{d}"]], ["reviewTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), v = w(), d = w(false), y = w({}), { crud: p, CRUD: C, columns: l } = F({ title: "存货转换单", sort: [], permission: { ...f }, invisibleColumns: ["applyTime", "applyUserName", "reviewTime", "reviewerName"], optShow: { ...x }, crudApi: { ...K }, hasPagination: true }, v);
  L(() => b.visible, (s) => {
    s && p.toQuery();
  }, { immediate: true });
  const { maxHeight: R } = Q({ paginate: true, extraHeight: 40 });
  function V(s) {
    y.value = s, d.value = true;
  }
  function E() {
    T("success"), p.refresh();
  }
  return C.HOOK.handleRefresh = (s, { data: u }) => {
    u.content.forEach((t) => {
      t.widthThick = t.thickness || t.width ? (t.thickness || "-") + "*" + (t.width || "-") : "-";
    });
  }, (s, u) => {
    const t = G, P = h("table-cell-tag"), A = h("common-button"), B = I, U = h("common-table"), D = $;
    return o(), z("div", ee, [n(e(Y), { showType: b.showType }, null, 8, ["showType"]), H((o(), a(U, { ref_key: "tableRef", ref: v, data: e(p).data, "data-format": S.value, "empty-text": e(p).emptyText, "max-height": e(R), stripe: false, class: "collection-table", style: { width: "100%", "margin-top": "10px" } }, { default: c(() => [n(t, { align: "center", label: "序号", prop: "index", type: "index", width: "55" }), e(l).visible("receiptSerialNumber") ? (o(), a(t, { key: "receiptSerialNumber", align: "center", label: "转换单号", "min-width": "150", prop: "receiptSerialNumber", "show-overflow-tooltip": "" }, { default: c(({ row: r }) => [n(P, { show: !!r.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), M("span", null, _(r.receiptSerialNumber), 1)]), _: 1 })) : i("", true), e(l).visible("outSerialNumber") && m.showType !== "coilPlate" ? (o(), a(t, { key: "outSerialNumber", align: "center", label: "出库单号", prop: "outSerialNumber", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("serialNumber") ? (o(), a(t, { key: "serialNumber", align: "center", label: "物料编号", prop: "serialNumber", "show-overflow-tooltip": "", width: "100" })) : i("", true), e(l).visible("classifyName") ? (o(), a(t, { key: "classifyName", align: "center", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "", width: "100" })) : i("", true), e(l).visible("specification") ? (o(), a(t, { key: "specification", align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("widthThick") ? (o(), a(t, { key: "widthThick", align: "center", label: "厚(mm)*宽(mm)", "min-width": "120", prop: "widthThick", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("mete") ? (o(), a(t, { key: "mete", align: "center", label: "转换总重(kg)", prop: "mete", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("brand") ? (o(), a(t, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("color") ? (o(), a(t, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("heatNoAndBatchNo") ? (o(), a(t, { key: "heatNoAndBatchNo", align: "center", label: "卷号", prop: "heatNoAndBatchNo", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("project") ? (o(), a(t, { key: "project", align: "center", label: "所属项目", prop: "project", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("warehouse.name") ? (o(), a(t, { key: "warehouse.name", align: "center", label: "仓库位置", prop: "warehouse.name", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("applyTime") ? (o(), a(t, { key: "applyTime", align: "center", label: "申请时间", prop: "applyTime", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("applyUserName") ? (o(), a(t, { key: "applyUserName", align: "center", label: "申请人", prop: "applyUserName", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("reviewTime") && m.showType !== "coilPlate" ? (o(), a(t, { key: "reviewTime", align: "center", label: "审核时间", prop: "reviewTime", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("reviewerName") && m.showType !== "coilPlate" ? (o(), a(t, { key: "reviewerName", align: "center", label: "审核人", prop: "reviewerName", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("status") ? (o(), a(t, { key: "status", "show-overflow-tooltip": true, align: "center", label: "审核状态", prop: "status", width: "80" }, { default: c(({ row: { sourceRow: r } }) => {
      var g;
      return [e(k)(e(f).audit) && r.status === s.reviewStatusEnum.UNREVIEWED.V ? (o(), a(A, { key: 0, icon: "el-icon-stamp", size: "default", type: "warning", onClick: (oe) => V(r) }, null, 8, ["onClick"])) : (o(), a(B, { key: 1, type: (g = s.reviewStatusEnum.V[r.status]) == null ? void 0 : g.TAG }, { default: c(() => [O(_(s.reviewStatusEnum.VL[r.status]), 1)]), _: 2 }, 1032, ["type"]))];
    }), _: 1 })) : i("", true), e(k)([...e(f).detail]) ? (o(), a(t, { key: 17, align: "center", label: "操作", width: "80px" }, { default: c(({ row: r }) => [n(W, { data: r, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[D, e(p).loading]]), n(e(J)), n(Z, { modelValue: d.value, "onUpdate:modelValue": u[0] || (u[0] = (r) => d.value = r), "detail-info": y.value, onRefresh: E }, null, 8, ["modelValue", "detail-info"]), n(e(X))]);
  };
} }, pe = q(te, [["__scopeId", "data-v-c3d89fb8"]]);
export {
  pe as default
};
