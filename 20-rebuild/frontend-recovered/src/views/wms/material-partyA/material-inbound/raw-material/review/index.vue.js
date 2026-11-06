import { ref as N } from "vue";
import { useStore as B } from "vuex";
import { watch as L } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as o } from "vue";
import { Fragment as H } from "vue";
import { renderList as M } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElTag as F } from "element-plus";
import { ElImage as K } from "element-plus";
import { vLoading as W } from "element-plus";
import { _ as $, uv as J, x as Q, yC as X, zG as Y, o as Z, zB as _, aR as ee, j$ as T, k0 as C, w5 as R, an as te, P as ae, zC as ie } from "../../../../../../shared/runtime.js";
import le from "./module/header.vue.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../supply-chain/components/audit-records.vue.js";
const oe = { class: "app-container" }, se = { key: 0 }, re = { key: 2 }, ne = { class: "imgs-box" }, pe = { __name: "index", setup(ue) {
  const U = { add: false, edit: false, del: false, download: false }, k = N(), p = B(), E = N([...J, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { CRUD: P, crud: d, columns: s } = Q({ title: "入库记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "shipmentNumber"], permission: { ...X }, optShow: { ...U }, crudApi: { ...Y } }, k), g = N([]), { maxHeight: V } = Z({ paginate: true });
  P.HOOK.handleRefresh = (x, { data: u }) => {
    u.content.forEach((i) => {
      var h;
      i.imgUrls = ((h = i.attachments) == null ? void 0 : h.map((v) => v.imageUrl)) || [];
    });
  };
  async function I() {
    await p.dispatch("approval_list/fetchApprovalNum", _.INBOUND.V);
  }
  async function q() {
    await p.dispatch("approval_list/fetchSubNum", _.INBOUND.V);
  }
  async function A() {
    await I(), await q(), await p.dispatch("approval_list/fetchRejNum", _.INBOUND.V), await p.dispatch("approval_list/fetchApprovalNum");
  }
  return A(), L(() => p.state.approval_list.approvalNum, async (x) => {
    d.refresh(), await p.dispatch("approval_list/fetchRejNum", _.INBOUND.V), await p.dispatch("approval_list/fetchApprovalNum", _.INBOUND.V);
  }), (x, u) => {
    const i = G, h = S("table-cell-tag"), v = F, D = K, j = S("common-table"), O = W;
    return t(), y("div", oe, [r(e(le), { APPtotal: e(p).state.approval_list.wmsInbound, subTotal: e(p).state.approval_list.SubScm_Num_wms_Inbound, rejTotal: e(p).state.approval_list.rejScm_Num_wms_Inbound }, null, 8, ["APPtotal", "subTotal", "rejTotal"]), z((t(), l(j, { ref_key: "tableRef", ref: k, data: e(d).data, "data-format": E.value, "default-expand-all": false, "expand-row-keys": g.value, "max-height": e(V), "row-key": "id", onSortChange: e(d).handleSortChange, onSelectionChange: e(d).selectionChangeHandler }, { default: n(() => [r(ee, { "expand-row-keys": g.value, "onUpdate:expandRowKeys": u[0] || (u[0] = (a) => g.value = a), data: e(d).data, "row-key": "id" }, { default: n(({ row: a }) => [c("p", null, [u[1] || (u[1] = f(" 关联项目：")), c("span", null, w(a.projectsFullName), 1)]), c("p", null, [u[2] || (u[2] = f(" 审批意见：")), c("span", null, w(a.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), r(i, { align: "center", type: "selection", width: "55" }), r(i, { align: "center", label: "序号", type: "index", width: "60" }, { default: n(({ row: { sourceRow: a }, $index: m }) => {
      var b;
      return [a.inboundWay === e(T).OPENING_RECEIPT.V ? (t(), l(h, { key: 0, name: e(T).VL[a.inboundWay], color: (b = e(T).V[a.inboundWay]) == null ? void 0 : b.COLOR }, null, 8, ["name", "color"])) : o("", true), c("span", null, w(m + 1), 1)];
    }), _: 1 }), e(s).visible("purchaseSN") ? (t(), l(i, { key: "purchaseSN", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseSN" }, { default: n(({ row: { sourceRow: a } }) => [r(h, { offset: 10, show: !!a.boolPartyA && !!a.purchaseSN, name: "甲供", type: "partyA" }, null, 8, ["show"]), a.purchaseSN ? (t(), y("span", se, w(a.purchaseSN), 1)) : o("", true), a.boolPartyA ? (t(), l(v, { key: 1, effect: "dark", size: "default", type: "danger" }, { default: n(() => u[3] || (u[3] = [f("甲供")])), _: 1, __: [3] })) : (t(), y("span", re, "-"))]), _: 1 })) : o("", true), e(s).visible("serialNumber") ? (t(), l(i, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "serialNumber" })) : o("", true), e(s).visible("shipmentNumber") ? (t(), l(i, { key: "shipmentNumber", align: "left", label: "物流单号", "min-width": "150", prop: "shipmentNumber", "show-overflow-tooltip": "" })) : o("", true), e(s).visible("basicClass") ? (t(), l(i, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : o("", true), e(s).visible("projects") ? (t(), l(i, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : o("", true), e(s).visible("supplier.name") ? (t(), l(i, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : o("", true), e(s).visible("licensePlate") ? (t(), l(i, { key: "licensePlate", "show-overflow-tooltip": true, align: "left", label: "车牌/船牌号", prop: "licensePlate", width: "100" })) : o("", true), e(s).visible("attachments") ? (t(), l(i, { key: "attachments", "show-overflow-tooltip": false, align: "left", label: "质检图片", prop: "attachments", width: "150px" }, { default: n(({ row: { sourceRow: a } }) => [c("div", ne, [(t(true), y(H, null, M(a.attachments, (m) => (t(), l(D, { key: m.id, "initial-index": 1, "preview-src-list": a.imgUrls, src: m.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : o("", true), e(s).visible("applicantName") ? (t(), l(i, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : o("", true), e(s).visible("editorName") ? (t(), l(i, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : o("", true), e(s).visible("qualityTestingUserName") ? (t(), l(i, { key: "qualityTestingUserName", "show-overflow-tooltip": true, align: "center", label: "质检人", "min-width": "100", prop: "qualityTestingUserName" })) : o("", true), e(s).visible("reviewerName") ? (t(), l(i, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : o("", true), e(s).visible("createTime") ? (t(), l(i, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : o("", true), e(s).visible("userUpdateTime") ? (t(), l(i, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "140" })) : o("", true), e(s).visible("qualityTestingTime") ? (t(), l(i, { key: "qualityTestingTime", "show-overflow-tooltip": true, align: "center", label: "质检时间", prop: "qualityTestingTime", width: "140" })) : o("", true), e(s).visible("reviewTime") ? (t(), l(i, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : o("", true), e(s).visible("qualityTestingEnum") ? (t(), l(i, { key: "qualityTestingEnum", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "质检状态", prop: "qualityTestingEnum", width: "100" }, { default: n(({ row: a }) => {
      var m;
      return [r(v, { type: (m = e(C).V[a.qualityTestingEnum]) == null ? void 0 : m.TAG }, { default: n(() => {
        var b;
        return [f(w((b = e(C).V[a.qualityTestingEnum]) == null ? void 0 : b.SL), 1)];
      }), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : o("", true), e(s).visible("reviewStatus") ? (t(), l(i, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "审核状态", prop: "reviewStatus", width: "80" }, { default: n(({ row: { sourceRow: a } }) => {
      var m;
      return [r(v, { type: (m = e(R).V[a.reviewStatus]) == null ? void 0 : m.TAG }, { default: n(() => [f(w(e(R).VL[a.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : o("", true), r(i, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: n(({ row: a }) => [r(te, { data: a, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[O, e(d).loading]]), r(e(ae)), r(ie)]);
  };
} }, ve = $(pe, [["__scopeId", "data-v-9ab283bb"]]);
export {
  ve as default
};
