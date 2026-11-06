import { ref as A } from "vue";
import { useStore as le } from "vuex";
import { computed as q } from "vue";
import { watch as B } from "vue";
import { resolveComponent as K } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as m } from "vue";
import { unref as a } from "vue";
import { withDirectives as oe } from "vue";
import { createBlock as o } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as d } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as D } from "vue";
import { ElMessage as ie } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElTooltip as ne } from "element-plus";
import { ElSwitch as pe } from "element-plus";
import { ElTag as ue } from "element-plus";
import { ElPopconfirm as me } from "element-plus";
import { vLoading as de } from "element-plus";
import { jY as ce, m as fe, uv as he, bD as ye, D as _e, x as Se, uM as w, uN as be, ho as we, o as ve, jO as g, uO as Ee, bv as Ne, cP as Te, jP as $, jJ as ge, fE as ke, jZ as Ce, t0 as E, aR as Re, i as I, br as Q, iF as k, G as O, uP as N, an as Ve, P as Pe, uJ as xe, uQ as je, v2 as Ae, a as De } from "../../../shared/runtime.js";
import { u as Ie } from "../../../modules/use-crud-enabled-change-d83074a3.js";
import Oe from "./module/header.vue.js";
import "./module/components/storage-list.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../components/audit-records.vue.js";
const Ue = { class: "app-container" }, Me = { key: 0 }, Le = { key: 1 }, Je = { __name: "index", setup(He) {
  ce();
  const Y = { add: false, edit: false, del: false, download: false }, U = A(), P = A([]), r = le(), { user: M } = fe(["user"]), C = A(), G = q(() => [...he, ["invoiceType", ["parse-enum", ye]], ["amount", ["to-thousand", _e.YUAN]], ["requisitionsSNStr", "empty-text"], ["remark", "empty-text"], ["auxMaterialNames", "split"], ["otherMaterialNames", "split"]]), { CRUD: x, crud: f, columns: p } = Se({ title: "采购合同", sort: ["id.desc"], invisibleColumns: ["branchCompany.name", "invoiceType", "userUpdateTime"], permission: { ...w }, optShow: { ...Y }, crudApi: { ...be }, requiredQuery: [], formStore: true, queryable: false, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER" }, U), { loaded: L, rawMatClsKV: H } = we(ae), { maxHeight: J } = ve({ paginate: true }), { handleEnabledChange: z } = Ie({ CRUD: x, crud: f, editEnabled: Ee }, { enabledField: "purchaseStatus", enumObj: g, t: "UNFINISHED", f: "FINISHED" }), W = q(() => !L.value || f.loading);
  x.HOOK.handleRefresh = (h, { data: l }) => {
    l.content = l.content.map((e) => {
      var R, _, V;
      const T = Ne.getBits(Te.ENUM, e.basicClass, "L");
      return e.typeText = e.materialType ? e.materialType & $.MATERIAL.V ? T.join(" | ") : $.VL[e.materialType] + " - " + T.join(" | ") : ge.VL[e.purchaseType] + " - " + T.join(" | "), e.branchCompanyId = e.branchCompany ? e.branchCompany.id : void 0, e.requisitionsSNStr = e.applyPurchaseSN ? e.applyPurchaseSN.join("　、　") : "", e.projects = (R = e.project) != null && R.id ? [e.project] : e.projects, e.projectIds = e.projects ? e.projects.map((S) => S.id) : (_ = e.project) != null && _.id ? [(V = e.project) == null ? void 0 : V.id] : [], e.level === ke.CONSTRUCTION_SITE.V && (e.projectId = e.projectIds[0]), e.boolPartyA = e.supplyType === Ce.PARTY_A.V, e.supplierId = e.supplier ? e.supplier.id : void 0, e.auxMaterialIds && (e.auxMaterialNames = e.auxMaterialIds.map((S) => {
        const b = H.value[S];
        return b ? b.name : "-";
      })), e.otherMaterialIds && (e.otherMaterialNames = e.otherMaterialIds.map((S) => {
        const b = H.value[S];
        return b ? b.name : "-";
      })), e;
    });
  };
  async function Z() {
    await r.dispatch("approval_list/fetchApprovalNum", E.PURCHASE_ORDER_V2.V);
  }
  async function F() {
    await r.dispatch("approval_list/fetchSubNum", E.PURCHASE_ORDER_V2.V);
  }
  async function j() {
    var h;
    await Z(), await F(), await ((h = C.value) == null ? void 0 : h.fetchSummary());
  }
  j();
  async function X(h) {
    await Ae({ id: h }).then((e) => {
      e && ie.success("作废提交成功，已进入作废审批流程");
    }), await j(), await r.dispatch("config/fetchSupplyUsedProject"), await r.dispatch("approval_list/fetchApprovalNum"), f.refresh();
  }
  ee(), r.dispatch("approval_list/fetchRejNum", E.PURCHASE_ORDER_V2.V);
  async function ee() {
    await r.dispatch("approval_list/fetchTSNum", E.PURCHASE_ORDER_V2.V);
  }
  x.HOOK.afterSubmit = async () => {
    j(), await r.dispatch("approval_list/fetchApprovalNum");
  };
  function ae() {
    L.value && (f.queryable = true, f.toQuery());
  }
  return B(() => r.state.approval_list.approvalSelfOrder_Num, async (h) => {
    var l;
    f.refresh(), await r.dispatch("approval_list/fetchApprovalNum"), await ((l = C.value) == null ? void 0 : l.fetchSummary());
  }), B(() => r.state.approval_list.approvalNum, async (h) => {
    var l;
    f.refresh(), await F(), await r.dispatch("approval_list/fetchApprovalNum", E.PURCHASE_ORDER_V2.V), await ((l = C.value) == null ? void 0 : l.fetchSummary()), await r.dispatch("approval_list/fetchRejNum", E.PURCHASE_ORDER_V2.V);
  }), (h, l) => {
    const e = re, T = ne, R = pe, _ = ue, V = De, S = K("common-button"), b = me, te = K("common-table"), se = de;
    return s(), v("div", Ue, [m(a(Oe), { ref_key: "headerRef", ref: C, APPtotal: a(r).state.approval_list.approvalSelfOrder_Num, TStotal: a(r).state.approval_list.TSScm_Num_self, "rej-total": a(r).state.approval_list.rejScm_Num_self, subTotal: a(r).state.approval_list.SubScm_Num_self }, null, 8, ["APPtotal", "TStotal", "rej-total", "subTotal"]), oe((s(), o(te, { ref_key: "tableRef", ref: U, data: a(f).data, "data-format": G.value, "default-expand-all": false, "expand-row-keys": P.value, "max-height": a(J), "row-key": "serialNumber" }, { default: n(() => [m(Re, { "expand-row-keys": P.value, "onUpdate:expandRowKeys": l[0] || (l[0] = (t) => P.value = t), data: a(f).data, "row-key": "serialNumber" }, { default: n(({ row: t }) => [a(I)(t.auxMaterialIds) ? (s(), v("p", Me, [l[1] || (l[1] = d(" 辅材明细：")), u("span", null, c(t.auxMaterialNames), 1)])) : i("", true), a(I)(t.otherMaterialIds) ? (s(), v("p", Le, [l[2] || (l[2] = d(" 其它明细：")), u("span", null, c(t.otherMaterialNames), 1)])) : i("", true), u("p", null, [l[3] || (l[3] = d(" 关联项目：")), u("span", null, c(t.projectsFullName), 1)]), u("p", null, [l[4] || (l[4] = d(" 关联申购单：")), u("span", null, c(t.requisitionsSNStr), 1)]), u("p", null, [l[5] || (l[5] = d(" 备注：")), u("span", null, c(t.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), m(e, { align: "center", label: "序号", type: "index", width: "60" }, { default: n(({ row: t, $index: y }) => [m(Q, { show: t.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), u("span", null, c(y + 1), 1)]), _: 1 }), a(p).visible("branchCompany.name") ? (s(), o(e, { key: "branchCompany.name", "show-overflow-tooltip": true, label: "签订主体", "min-width": "170px", prop: "branchCompany.name" })) : i("", true), a(p).visible("createTime") ? (s(), o(e, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "编制日期", prop: "createTime", width: "130" }, { default: n(({ row: t }) => [t.settlementStatus === a(k).SETTLED.V ? (s(), o(Q, { key: 0, color: a(k).SETTLED.COLOR, name: a(k).SETTLED.L }, null, 8, ["color", "name"])) : i("", true), d(" " + c(t.createTime), 1)]), _: 1 })) : i("", true), a(p).visible("serialNumber") ? (s(), o(e, { key: "serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "160px", prop: "serialNumber" })) : i("", true), a(p).visible("typeText") ? (s(), o(e, { key: "typeText", "show-overflow-tooltip": true, label: "物料种类", "min-width": "170px", prop: "typeText" })) : i("", true), a(p).visible("projects") ? (s(), o(e, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : i("", true), a(p).visible("supplier.name") ? (s(), o(e, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "150", prop: "supplier.name" })) : i("", true), a(p).visible("mete") ? (s(), o(e, { key: "mete", "show-overflow-tooltip": true, align: "center", label: "合同量", prop: "mete", width: "110" }, { default: n(({ row: t }) => [u("span", null, c(t.mete ? `${t.mete || ""} ${t.meteUnit || ""}` : ""), 1)]), _: 1 })) : i("", true), a(p).visible("amount") ? (s(), o(e, { key: "amount", "show-overflow-tooltip": true, align: "center", label: "合同额（元）", prop: "amount", width: "110" })) : i("", true), a(p).visible("invoiceType") ? (s(), o(e, { key: "invoiceType", "show-overflow-tooltip": true, align: "center", label: "票据类型", "min-width": "130", prop: "invoiceType" })) : i("", true), a(p).visible("purchaseStatus") ? (s(), o(e, { key: "purchaseStatus", align: "center", label: "采购状态", prop: "purchaseStatus", width: "90px" }, { header: n(() => [m(T, { content: `采购执行完毕后，该采购合同不可在入库办理处选择。

            已结算的采购合同不可再打开采购状态。`, class: "item", effect: "light", placement: "top" }, { default: n(() => l[6] || (l[6] = [u("div", { style: { display: "inline-block" } }, [u("span", null, "采购状态"), u("i", { class: "el-icon-info" })], -1)])), _: 1, __: [6] })]), default: n(({ row: { sourceRow: t } }) => [a(I)(t.purchaseStatus) ? (s(), v(D, { key: 0 }, [a(O)(a(w).editPurchaseStatus) ? (s(), o(R, { key: 0, modelValue: t.purchaseStatus, "onUpdate:modelValue": (y) => t.purchaseStatus = y, "active-value": a(g).UNFINISHED.V, disabled: t.enabledLoading || t.status === a(k).SETTLED.V && t.purchaseStatus === a(g).FINISHED.V || t.dataStatus !== a(N).PASSED.V, "inactive-value": a(g).FINISHED.V, "active-color": "#13ce66", onChange: (y) => a(z)(t, "serialNumber") }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])) : (s(), o(_, { key: 1, type: t.purchaseStatus }, { default: n(() => [d(c(a(g).VL[t.purchaseStatus]), 1)]), _: 2 }, 1032, ["type"]))], 64)) : (s(), v(D, { key: 1 }, [d("-")], 64))]), _: 1 })) : i("", true), a(p).visible("status") ? (s(), o(e, { key: "status", align: "center", label: "订单状态", "min-width": "100px", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: t } }) => {
      var y;
      return [t.settlementStatus == a(k).SETTLED.V ? (s(), o(_, { key: 0, type: "danger" }, { default: n(() => l[7] || (l[7] = [d("已结算")])), _: 1, __: [7] })) : (s(), v(D, { key: 1 }, [t.boolTemporaryStorage ? (s(), o(_, { key: 0, type: "warning" }, { default: n(() => l[8] || (l[8] = [d("暂存")])), _: 1, __: [8] })) : (s(), o(_, { key: 1, type: (y = a(N).V[t.dataStatus]) == null ? void 0 : y.T }, { default: n(() => [d(c(a(N).VL[t.dataStatus]), 1)]), _: 2 }, 1032, ["type"]))], 64))];
    }), _: 1 })) : i("", true), a(p).visible("applicantName") ? (s(), o(e, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "创建人", prop: "applicantName", width: "90" })) : i("", true), a(p).visible("lastOperatorName") ? (s(), o(e, { key: "lastOperatorName", "show-overflow-tooltip": true, align: "center", label: "最后操作人", prop: "lastOperatorName", width: "90" })) : i("", true), a(p).visible("userUpdateTime") ? (s(), o(e, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "100" })) : i("", true), a(O)([...a(w).detail, ...a(w).edit, ...a(w).revoke, ...a(w).void]) ? (s(), o(e, { key: 14, align: "left", fixed: "right", label: "操作", width: "180px" }, { default: n(({ row: { sourceRow: t } }) => [m(Ve, { data: t, "show-del": false, showEdit: (t.dataStatus === a(N).PASSED.V || t.dataStatus === a(N).UNDER_APPROVAL.V) && a(M).id === t.applicantId, "show-detail": "" }, null, 8, ["data", "showEdit"]), t.dataStatus === a(N).PASSED.V && a(M).id === t.applicantId && a(O)(a(w).void) ? (s(), o(b, { key: 0, title: "确认作废", onConfirm: (y) => X(t.id) }, { reference: n(() => [m(S, { class: "filter-item", size: "default", type: "danger" }, { default: n(() => [m(V, { "icon-class": "wms-void" })]), _: 1 })]), _: 2 }, 1032, ["onConfirm"])) : i("", true)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[se, W.value]]), m(a(Pe)), m(xe, { "is-passed-edit": "" }), m(je)]);
  };
} };
export {
  Je as default
};
