import { ref as f } from "vue";
import { computed as O } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as l } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as U } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as L } from "element-plus";
import { l as C, uv as M, D as _, x as F, C1 as T, o as K, G as $, aR as G, gG as N, an as Y, P as q } from "../../../../../shared/runtime.js";
import I from "./module/header.vue.js";
import z from "./module/detail.vue.js";
import "../../../../../modules/record-v2-41933798.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../modules/index-4b5f34f4.js";
function J(b) {
  return C({ url: "/api/wms/report/raw-materials/outbound/receiptList", method: "get", params: b });
}
function Q(b) {
  return C({ url: `/api/wms/report/raw-materials/outbound/receiptDetailById/${b}`, method: "get" });
}
const W = { get: J, detail: Q }, X = { class: "app-container" }, ne = { __name: "index", setup(b) {
  const S = { batchAdd: false, add: false, edit: false, del: false, download: false }, h = f([]), y = f(), R = f([...M, ["outboundStartTime", ["parse-time", "{y}-{m}-{d}"]], ["outboundEndTime", ["parse-time", "{y}-{m}-{d}"]], ["amount", ["to-thousand", _.YUAN]], ["amountExcludingVAT", ["to-thousand", _.YUAN]]]), { CRUD: B, crud: p, columns: n } = F({ title: "出库单表", sort: ["id.desc"], permission: { ...T }, optShow: { ...S }, crudApi: { ...W } }, y), { maxHeight: D } = K({ paginate: true }), A = O(() => $(T.showAmount));
  return B.HOOK.handleRefresh = async (V, { data: i }) => {
    i.content = i.content.map((a) => {
      var u;
      return a.areaBatchNameStr = (u = a.areaBatchNames) == null ? void 0 : u.join("、"), a;
    });
  }, (V, i) => {
    const a = H, u = k("table-cell-tag"), E = k("common-table"), j = L;
    return o(), x("div", X, [s(e(I)), P((o(), l(E, { ref_key: "tableRef", ref: y, data: e(p).data, "data-format": R.value, "default-expand-all": false, "empty-text": e(p).emptyText, "expand-row-keys": h.value, "max-height": e(D), "row-key": "id", onRowDblclick: i[1] || (i[1] = (t) => e(p).toDetail(t)), onSelectionChange: e(p).selectionChangeHandler, onSortChange: e(p).handleSortChange }, { default: d(() => [s(G, { "expand-row-keys": h.value, "onUpdate:expandRowKeys": i[0] || (i[0] = (t) => h.value = t), data: e(p).data, "row-key": "id" }, { default: d(({ row: t }) => [c("p", null, [i[2] || (i[2] = g(" 关联项目：")), c("span", null, w(t.projectsFullName), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(a, { align: "center", type: "selection", width: "55" }), s(a, { align: "center", label: "序号", type: "index", width: "60" }, { default: d(({ row: t, $index: m }) => [s(u, { offset: 10, show: !!t.boolPrinted, color: "#67c23a", name: "已打印" }, null, 8, ["show"]), g(" " + w(m + 1), 1)]), _: 1 }), e(n).visible("serialNumber") ? (o(), l(a, { key: "serialNumber", "show-overflow-tooltip": true, label: "出库单号", prop: "serialNumber", width: "160" }, { default: d(({ row: t }) => {
      var m;
      return [s(u, { name: e(N).VL[t.outboundTypeSelection], color: (m = e(N).V[t.outboundTypeSelection]) == null ? void 0 : m.COLOR }, null, 8, ["name", "color"]), c("span", null, w(t.serialNumber), 1)];
    }), _: 1 })) : r("", true), e(n).visible("containBasicClass") ? (o(), l(a, { key: "containBasicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "containBasicClass", width: "200" }, { default: d(({ row: t }) => {
      var m, v;
      return [((m = t.sourceRow) == null ? void 0 : m.orderSupplyType) === 3 ? (o(), l(u, { key: 0, name: "甲供自购", color: "#17db9b" })) : ((v = t.sourceRow) == null ? void 0 : v.orderSupplyType) === 2 ? (o(), l(u, { key: 1, name: "甲供", color: "#f7b551" })) : (o(), l(u, { key: 2, name: "自购", color: "#17db9b" })), c("span", null, w(t.containBasicClass), 1)];
    }), _: 1 })) : r("", true), e(n).visible("projects") ? (o(), l(a, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : r("", true), A.value ? (o(), x(U, { key: 3 }, [e(n).visible("amount") ? (o(), l(a, { key: "amount", "show-overflow-tooltip": true, align: "right", label: "本次出库金额", "min-width": "120", prop: "amount" })) : r("", true), e(n).visible("amountExcludingVAT") ? (o(), l(a, { key: "amountExcludingVAT", "show-overflow-tooltip": true, align: "right", label: "本次出库金额(不含税)", "min-width": "130", prop: "amountExcludingVAT" })) : r("", true)], 64)) : r("", true), e(n).visible("areaBatchNameStr") ? (o(), l(a, { key: "areaBatchNameStr", "show-overflow-tooltip": true, align: "center", label: "领用批次", prop: "areaBatchNameStr", width: "90" })) : r("", true), e(n).visible("applicantName") ? (o(), l(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : r("", true), e(n).visible("reviewerName") ? (o(), l(a, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "处理人", "min-width": "100", prop: "reviewerName" })) : r("", true), e(n).visible("outboundTime") ? (o(), l(a, { key: "outboundTime", "show-overflow-tooltip": true, align: "center", label: "出库日期", prop: "outboundTime", width: "200" }, { default: d(({ row: t }) => [c("span", null, w(t.outboundStartTime), 1), i[3] || (i[3] = g("  ~  ")), c("span", null, w(t.outboundEndTime), 1)]), _: 1 })) : r("", true), e(n).visible("createTime") ? (o(), l(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请日期", prop: "createTime", sortable: "custom", width: "160" })) : r("", true), e(n).visible("reviewTime") ? (o(), l(a, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核日期", prop: "reviewTime", width: "140" })) : r("", true), e(n).visible("remark") ? (o(), l(a, { key: "remark", "show-overflow-tooltip": true, align: "center", label: "备注", prop: "remark" })) : r("", true), s(a, { align: "center", fixed: "right", label: "操作", width: "80px" }, { default: d(({ row: t }) => [s(Y, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSelectionChange", "onSortChange"])), [[j, e(p).loading]]), s(e(q)), s(z)]);
  };
} };
export {
  ne as default
};
