import { ref as _ } from "vue";
import { useStore as I } from "vuex";
import { watch as O } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as m } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as L } from "vue";
import { renderList as M } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElTag as z } from "element-plus";
import { ElImage as F } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as W, m as K, Aa as $, uv as J, x as Q, Ab as X, Ac as Y, o as Z, zB as ee, aR as te, j$ as g, k0 as C, w5 as N, an as ae, P as ie, zC as le, Ad as se } from "../../../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const re = { class: "app-container" }, ne = { key: 0 }, pe = { key: 2 }, ue = { class: "imgs-box" }, me = { __name: "index", setup(de) {
  const R = { add: false, edit: false, del: false, download: false }, y = _([]), k = _(), b = I(), { user: E } = K(["user"]);
  $();
  const U = _([...J, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { crud: h, columns: o, CRUD: q } = Q({ title: "原材料入库记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "licensePlate", "shipmentNumber"], permission: { ...X }, optShow: { ...R }, crudApi: { ...Y } }, k), { maxHeight: A } = Z({ paginate: true });
  return q.HOOK.handleRefresh = async (T, { data: r }) => {
    r.content = r.content.map((u) => {
      var i;
      return u.imgUrls = ((i = u.attachments) == null ? void 0 : i.map((c) => c.imageUrl)) || [], u;
    });
  }, O(() => b.state.approval_list.approvalNum, async (T) => {
    h.refresh(), await b.dispatch("approval_list/fetchApprovalNum", ee.INBOUND.V);
  }), j(async () => {
    await b.dispatch("wms/fetchSteelDensityCfg");
  }), (T, r) => {
    const u = S("table-cell-tag"), i = G, c = z, V = F, P = S("common-table"), D = H;
    return a(), v("div", re, [n(e(oe)), B((a(), l(P, { ref_key: "tableRef", ref: k, data: e(h).data, "data-format": U.value, "default-expand-all": false, "expand-row-keys": y.value, "max-height": e(A), "row-key": "id" }, { default: p(() => [n(te, { "expand-row-keys": y.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (t) => y.value = t), data: e(h).data, "row-key": "id" }, { default: p(({ row: t }) => [m("p", null, [r[1] || (r[1] = w(" 关联项目：")), m("span", null, d(t.projectsFullName), 1)]), m("p", null, [r[2] || (r[2] = w(" 审批意见：")), m("span", null, d(t.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), n(i, { align: "center", label: "序号", type: "index", width: "60" }, { default: p(({ row: { sourceRow: t }, $index: f }) => {
      var x;
      return [t.inboundWay === e(g).OPENING_RECEIPT.V ? (a(), l(u, { key: 0, name: e(g).VL[t.inboundWay], color: (x = e(g).V[t.inboundWay]) == null ? void 0 : x.COLOR }, null, 8, ["name", "color"])) : s("", true), m("span", null, d(f + 1), 1)];
    }), _: 1 }), e(o).visible("purchaseSN") ? (a(), l(i, { key: "purchaseSN", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseSN" }, { default: p(({ row: { sourceRow: t } }) => [n(u, { offset: 10, show: !!t.boolPartyA && !!t.purchaseSN, name: "甲供", type: "partyA" }, null, 8, ["show"]), t.purchaseSN ? (a(), v("span", ne, d(t.purchaseSN), 1)) : s("", true), t.boolPartyA ? (a(), l(c, { key: 1, effect: "dark", size: "default", type: "danger" }, { default: p(() => r[3] || (r[3] = [w("甲供")])), _: 1, __: [3] })) : (a(), v("span", pe, "-"))]), _: 1 })) : s("", true), e(o).visible("serialNumber") ? (a(), l(i, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "serialNumber" })) : s("", true), e(o).visible("licensePlate") ? (a(), l(i, { key: "licensePlate", "show-overflow-tooltip": true, align: "left", label: "车牌/船牌号", prop: "licensePlate", width: "100" })) : s("", true), e(o).visible("shipmentNumber") ? (a(), l(i, { key: "shipmentNumber", align: "left", label: "物流单号", "min-width": "150", prop: "shipmentNumber", "show-overflow-tooltip": "" })) : s("", true), e(o).visible("basicClass") ? (a(), l(i, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : s("", true), e(o).visible("projects") ? (a(), l(i, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : s("", true), e(o).visible("supplier.name") ? (a(), l(i, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : s("", true), e(o).visible("attachments") ? (a(), l(i, { key: "attachments", "show-overflow-tooltip": false, align: "left", label: "质检图片", prop: "attachments", width: "150px" }, { default: p(({ row: { sourceRow: t } }) => [m("div", ue, [(a(true), v(L, null, M(t.attachments, (f) => (a(), l(V, { key: f.id, "initial-index": 1, "preview-src-list": t.imgUrls, src: f.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : s("", true), e(o).visible("applicantName") ? (a(), l(i, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : s("", true), e(o).visible("editorName") ? (a(), l(i, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : s("", true), e(o).visible("qualityTestingUserName") ? (a(), l(i, { key: "qualityTestingUserName", "show-overflow-tooltip": true, align: "center", label: "质检人", "min-width": "100", prop: "qualityTestingUserName" })) : s("", true), e(o).visible("reviewerName") ? (a(), l(i, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : s("", true), e(o).visible("createTime") ? (a(), l(i, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : s("", true), e(o).visible("qualityTestingTime") ? (a(), l(i, { key: "qualityTestingTime", "show-overflow-tooltip": true, align: "center", label: "质检时间", prop: "qualityTestingTime", width: "140" })) : s("", true), e(o).visible("userUpdateTime") ? (a(), l(i, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "140" })) : s("", true), e(o).visible("reviewTime") ? (a(), l(i, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : s("", true), e(o).visible("qualityTestingEnum") ? (a(), l(i, { key: "qualityTestingEnum", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "质检状态", prop: "qualityTestingEnum", width: "105" }, { default: p(({ row: t }) => [n(c, { type: e(C).V[t.qualityTestingEnum].TAG }, { default: p(() => [w(d(e(C).V[t.qualityTestingEnum].SL), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), e(o).visible("reviewStatus") ? (a(), l(i, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "审核状态", prop: "reviewStatus", width: "90" }, { default: p(({ row: t }) => [n(c, { type: e(N).V[t.reviewStatus].TAG }, { default: p(() => [w(d(e(N).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), n(i, { align: "center", fixed: "right", label: "操作", width: "120px" }, { default: p(({ row: { sourceRow: t } }) => [n(ae, { data: t, "show-del": false, "show-edit": t.reviewStatus === e(N).AUDITING.V && e(E).id === t.applicantId, "show-detail": "" }, null, 8, ["data", "show-edit"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[D, e(h).loading]]), n(e(ie)), n(le), n(se)]);
  };
} }, ve = W(me, [["__scopeId", "data-v-708e8279"]]);
export {
  ve as default
};
