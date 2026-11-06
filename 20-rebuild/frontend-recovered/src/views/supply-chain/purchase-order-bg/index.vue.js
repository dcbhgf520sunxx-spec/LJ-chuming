import { ref as h } from "vue";
import { useStore as Te } from "vuex";
import { computed as se } from "vue";
import { provide as Ae } from "vue";
import { watch as $ } from "vue";
import { onMounted as Ce } from "vue";
import { watchEffect as Ne } from "vue";
import { resolveComponent as le } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as K } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as we } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as j } from "vue";
import { ElMessage as Ve } from "element-plus";
import { ElTableColumn as Pe } from "element-plus";
import { ElTag as Re } from "element-plus";
import { ElTooltip as xe } from "element-plus";
import { InfoFilled as De } from "@element-plus/icons-vue";
import { ElIcon as je } from "element-plus";
import { ElPopover as Ie } from "element-plus";
import { ElSwitch as Le } from "element-plus";
import { ElPopconfirm as Me } from "element-plus";
import { ElButton as Ue } from "element-plus";
import { vLoading as Oe } from "element-plus";
import { _ as Fe, m as Be, da as ze, bD as He, D as I, uP as _, x as $e, vf as f, vB as Ke, vC as Ge, ho as Ye, o as qe, bv as Qe, cP as We, jP as ie, jJ as Je, jZ as Ze, t0 as C, br as oe, iF as k, i as ne, gD as re, G as T, aS as N, jO as Xe, an as et, a as L, P as tt, uK as at, vD as st, vE as lt, vF as it } from "../../../shared/runtime.js";
import ot from "./module/header.vue.js";
import nt from "./module/line/index.vue.js";
import rt from "./module/record/index.vue.js";
import ut from "./module/oa-approval/index.vue.js";
import "./module/components/storage-list.vue.js";
import "../components/audit-records.vue.js";
import "../../../modules/payment-settlement-e8e799d8.js";
import "../../../modules/invoice-entry-97d1bf05.js";
import "../../../modules/index-70e7196a.js";
const pt = { class: "app-container" }, ct = { key: 1 }, mt = { class: "content-container" }, dt = ["onClick"], _t = { class: "content-container" }, ht = ["onClick"], ft = { class: "content-container" }, vt = ["onClick"], yt = { style: { display: "inline-block" } }, bt = { key: 1 }, St = { __name: "index", setup(Et) {
  const { user: G } = Be(["user"]), ue = { add: false, edit: false, del: false, download: false }, Y = h(), pe = h([]), m = Te(), ce = se(() => [...ze, ["invoiceType", ["parse-enum", He]], ["amount", ["to-thousand", I.YUAN]], ["settlementAmount", ["to-thousand", I.YUAN]], ["cumulativePayment", ["to-thousand", I.YUAN]], ["cumulativeInvoice", ["to-thousand", I.YUAN]], ["requisitionsSNStr", "empty-text"], ["remark", "empty-text"], ["auxMaterialNames", "split"], ["otherMaterialNames", "split"], ["dataStatus", ["parse-enum", _, { f: "L" }]]]), { CRUD: P, crud: d, columns: c } = $e({ title: "采购合同", sort: ["id.desc"], invisibleColumns: ["branchCompany.name", "invoiceType", "userUpdateTime"], permission: { ...f }, optShow: { ...ue }, crudApi: { ...Ke, add: Ge }, requiredQuery: [], formStore: true, queryable: false, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER" }, Y), { loaded: q, rawMatClsKV: Q } = Ye(be), { maxHeight: me } = qe({ paginate: true }), M = h(false), R = h();
  Ae("dataId", R), $(() => R == null ? void 0 : R.value, (o) => {
    o && (M.value = true);
  });
  const W = h();
  function de() {
    d.toQuery(), W.value = Math.random();
  }
  const _e = se(() => !q.value || d.loading);
  P.HOOK.handleRefresh = async (o, { data: r }) => {
    r.content = r.content.map((t) => {
      var w, E, g, A, x, D;
      const S = Qe.getBits(We.ENUM, t.basicClass, "L");
      return t.typeText = t.materialType ? t.materialType & ie.MATERIAL.V ? S.join(" | ") : ie.VL[t.materialType] + " - " + S.join(" | ") : Je.VL[t.purchaseType] + " - " + S.join(" | "), t.branchCompanyId = t.branchCompany ? t.branchCompany.id : void 0, t.requisitionsSNStr = t.applyPurchaseSN ? t.applyPurchaseSN.join("　、　") : "", t.projects = (w = t.project) != null && w.id ? [t.project] : t.projects, (E = t.projects) != null && E.length && (t.projectName = (g = t.projects[0]) != null && g.serialNumber ? ((A = t.projects[0]) == null ? void 0 : A.serialNumber) + "-" + ((x = t.projects[0]) == null ? void 0 : x.name) : (D = t.projects[0]) == null ? void 0 : D.name), t.boolPartyA = t.supplyType === Ze.PARTY_A.V, t.supplierId = t.supplier ? t.supplier.id : void 0, t.purchaseStatus === 1 ? t.purchaseStatusFlag = true : t.purchaseStatus === 2 && (t.purchaseStatusFlag = false), t.auxMaterialIds && (t.auxMaterialNames = t.auxMaterialIds.map((V) => {
        const y = Q.value[V];
        return y ? y.name : "-";
      })), t.otherMaterialIds && (t.otherMaterialNames = t.otherMaterialIds.map((V) => {
        const y = Q.value[V];
        return y ? y.name : "-";
      })), t;
    });
  };
  async function he() {
    await m.dispatch("approval_list/fetchApprovalNum", [C.PURCHASE_ORDER_BG.V]);
  }
  async function J() {
    await m.dispatch("approval_list/fetchSubNum", C.PURCHASE_ORDER_BG.V);
  }
  async function fe() {
    await m.dispatch("approval_list/fetchTSNum", C.PURCHASE_ORDER_BG.V);
  }
  async function U() {
    await he(), await J();
  }
  const O = (o) => (o.invoiceSize || o.paymentSize || o.settlementSize) > 0 || (Math.abs(o.settlementAmount) || Math.abs(o.cumulativePayment) || Math.abs(o.cumulativeInvoice)) > 0;
  async function ve(o) {
    await lt({ id: o }).then((t) => {
      t && Ve.success("作废提交成功，已进入作废审批流程");
    }), U(), await m.dispatch("config/fetchSupplyUsedProject"), await m.dispatch("approval_list/fetchApprovalNum"), d.refresh();
  }
  async function ye(o, r) {
    try {
      await it({ id: o.id, purchaseStatus: r ? 1 : 2 }), d.refresh(), d.notify(N.VL[r] + "成功", P.NOTIFICATION_TYPE.SUCCESS);
    } catch {
      o.purchaseStatus = o.purchaseStatus === N.TRUE.V ? N.FALSE.V : N.TRUE.V;
    }
  }
  P.HOOK.afterSubmit = async () => {
    U(), await m.dispatch("approval_list/fetchApprovalNum");
  }, P.HOOK.afterDelete = () => {
  };
  function be() {
    q.value && (d.queryable = true, d.toQuery());
  }
  const F = h(false), Z = h(), X = h(), ee = h();
  function B(o, r, t) {
    Z.value = o, X.value = r, ee.value = t, F.value = true;
  }
  $(() => m.state.approval_list.approvalBg_Num, async (o) => {
    d.refresh(), await m.dispatch("approval_list/fetchApprovalNum");
  }), $(() => m.state.approval_list.approvalNum, async (o) => {
    d.refresh(), await m.dispatch("approval_list/fetchRejNum", C.PURCHASE_ORDER_BG.V), await J(), await m.dispatch("approval_list/fetchApprovalNum", C.PURCHASE_ORDER_BG.V);
  }), Ce(() => {
    fe(), U(), m.dispatch("approval_list/fetchRejNum", C.PURCHASE_ORDER_BG.V);
  });
  const te = h();
  function Se() {
    te.value = Math.random();
  }
  function z(o, r) {
    d.props.recordType = o, d.props.rowDetail = r, d.props.recordVisible = true;
  }
  const H = h();
  function Ee() {
    d.data.filter((r) => !O(r) && (r.dataStatus === _.PASSED.V || r.dataStatus === _.UNDER_APPROVAL.V) && G.value.id === r.applicantId && r.settlementStatus !== k.SETTLED.V).length ? H.value = 320 : H.value = 220;
  }
  return Ne(() => {
    var o;
    (o = d.data) != null && o.length && Ee();
  }), (o, r) => {
    const t = Pe, S = Re, w = xe, E = De, g = je, A = Ie, x = Le, D = le("common-button"), V = Me, y = Ue, ge = le("common-table"), ke = Oe;
    return s(), K("div", pt, [u(e(ot), { APPtotal: e(m).state.approval_list.approvalBg_Num, TStotal: e(m).state.approval_list.TSScm_Num_bg, rejTotal: e(m).state.approval_list.rejScm_Num_bg, subTotal: e(m).state.approval_list.SubScm_Num_bg }, null, 8, ["APPtotal", "TStotal", "rejTotal", "subTotal"]), we((s(), l(ge, { ref_key: "tableRef", ref: Y, data: e(d).data, "data-format": ce.value, "default-expand-all": false, "expand-row-keys": pe.value, "max-height": e(me), "row-key": "serialNumber" }, { default: i(() => [u(t, { align: "center", label: "序号", type: "index", width: "60" }, { default: i(({ row: a, $index: p }) => [u(oe, { show: a.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), v("span", null, b(p + 1), 1)]), _: 1 }), e(c).visible("createTime") ? (s(), l(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建日期", prop: "createTime", width: "130" }, { default: i(({ row: a }) => [a.settlementStatus == e(k).SETTLED.V ? (s(), l(oe, { key: 0, color: e(k).SETTLED.COLOR, name: e(k).SETTLED.L }, null, 8, ["color", "name"])) : n("", true), j(" " + b(a.createTime), 1)]), _: 1 })) : n("", true), e(c).visible("projectAttribute") ? (s(), l(t, { key: "projectAttribute", align: "center", label: "经营方式", "min-width": "90", prop: "projectAttribute", "show-overflow-tooltip": "" }, { default: i(({ row: { sourceRow: a } }) => {
      var p;
      return [e(ne)(a.projectAttribute) ? (s(), l(S, { key: 0, type: (p = e(re).V[a.projectAttribute]) == null ? void 0 : p.T }, { default: i(() => [j(b(e(re).VL[a.projectAttribute]), 1)]), _: 2 }, 1032, ["type"])) : (s(), K("span", ct, "-"))];
    }), _: 1 })) : n("", true), e(c).visible("serialNumber") ? (s(), l(t, { key: "serialNumber", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "160px", prop: "serialNumber" })) : n("", true), e(c).visible("projectManager.name") ? (s(), l(t, { key: "projectManager.name", "show-overflow-tooltip": true, label: "项目经理", "min-width": "130px", prop: "projectManager.name" })) : n("", true), e(c).visible("projectName") ? (s(), l(t, { key: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "200px", prop: "projectName" })) : n("", true), e(c).visible("basicClass") ? (s(), l(t, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", "min-width": "140px", prop: "basicClass" })) : n("", true), e(c).visible("supplier.shortName") ? (s(), l(t, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "130px", prop: "supplier.shortName" }, { default: i(({ row: a }) => {
      var p;
      return [u(w, { content: (p = a.supplier) == null ? void 0 : p.name, class: "item", effect: "dark", placement: "top-start" }, { default: i(() => {
        var ae;
        return [v("span", null, b(((ae = a.supplier) == null ? void 0 : ae.shortName) || "-"), 1)];
      }), _: 2 }, 1032, ["content"])];
    }), _: 1 })) : n("", true), e(c).visible("branchCompany.name") ? (s(), l(t, { key: "branchCompany.name", "show-overflow-tooltip": true, label: "签约主体", "min-width": "200px", prop: "branchCompany.name" })) : n("", true), e(c).visible("amount") ? (s(), l(t, { key: "amount", "show-overflow-tooltip": true, align: "center", label: "合同额（元）", prop: "amount", width: "110" })) : n("", true), e(c).visible("settlementAmount") ? (s(), l(t, { key: "settlementAmount", "show-overflow-tooltip": true, align: "center", label: "结算额（元）", prop: "settlementAmount", width: "110" }, { default: i(({ row: a }) => [v("div", mt, [a.settlementSize ? (s(), l(A, { key: 0, content: "存在未审核结束的单据：" + a.settlementSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: i(() => [u(g, { class: "icon" }, { default: i(() => [u(E)]), _: 1 })]), _: 2 }, 1032, ["content"])) : n("", true), v("span", { class: "tip_text", onClick: (p) => z("settle", a) }, b(a.settlementAmount), 9, dt)])]), _: 1 })) : n("", true), e(c).visible("cumulativePayment") ? (s(), l(t, { key: "cumulativePayment", "show-overflow-tooltip": true, align: "center", label: "累计付款（元）", prop: "cumulativePayment", width: "110" }, { default: i(({ row: a }) => [v("div", _t, [a.paymentSize ? (s(), l(A, { key: 0, content: "存在未审核结束的单据：" + a.paymentSize, teleported: false, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: i(() => [u(g, { class: "icon" }, { default: i(() => [u(E)]), _: 1 })]), _: 2 }, 1032, ["content"])) : n("", true), v("span", { class: "tip_text", onClick: (p) => z("payment", a) }, b(a.cumulativePayment), 9, ht)])]), _: 1 })) : n("", true), e(c).visible("cumulativeInvoice") ? (s(), l(t, { key: "cumulativeInvoice", "show-overflow-tooltip": true, align: "center", label: "累计收票（元）", prop: "cumulativeInvoice", width: "110" }, { default: i(({ row: a }) => [v("div", ft, [a.invoiceSize ? (s(), l(A, { key: 0, content: "存在未审核结束的单据：" + a.invoiceSize, width: 240, placement: "left", "popper-class": "popper-box", trigger: "hover" }, { reference: i(() => [u(g, { class: "icon" }, { default: i(() => [u(E)]), _: 1 })]), _: 2 }, 1032, ["content"])) : n("", true), v("span", { class: "tip_text", onClick: (p) => z("invoice", a) }, b(a.cumulativeInvoice), 9, vt)])]), _: 1 })) : n("", true), e(c).visible("invoiceType") ? (s(), l(t, { key: "invoiceType", "show-overflow-tooltip": true, align: "center", label: "票据类型", "min-width": "130", prop: "invoiceType" })) : n("", true), e(c).visible("applicantName") ? (s(), l(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "创建人", prop: "applicantName", width: "90" })) : n("", true), e(c).visible("purchaseStatus") ? (s(), l(t, { key: "purchaseStatus", align: "center", label: "采购状态", prop: "purchaseStatus", width: "90px" }, { header: i(() => [u(w, { content: `采购执行完毕后，该采购合同不可在入库办理处选择。

            已结算的采购合同不可再打开采购状态。`, class: "item", effect: "light", placement: "top" }, { default: i(() => [v("div", yt, [r[2] || (r[2] = v("span", null, "采购状态", -1)), u(g, null, { default: i(() => [u(E)]), _: 1 })])]), _: 1 })]), default: i(({ row: { sourceRow: a } }) => [e(T)(e(f).editPurchaseStatus) && e(ne)(a.purchaseStatus) ? (s(), l(x, { key: 0, modelValue: a.purchaseStatusFlag, "onUpdate:modelValue": (p) => a.purchaseStatusFlag = p, "active-value": e(N).TRUE.V, disabled: !e(T)(e(f).editStatus) || a.dataStatus === e(_).INVALID.V || a.dataStatus === e(_).VOIDED.V, "inactive-value": e(N).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (p) => ye(a, a.purchaseStatusFlag) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])) : (s(), K("span", bt, b(e(Xe).VL[a.purchaseStatus] || "-"), 1))]), _: 1 })) : n("", true), e(c).visible("dataStatus") ? (s(), l(t, { key: "status", align: "center", label: "订单状态", "min-width": "100px", "show-overflow-tooltip": "" }, { default: i(({ row: { sourceRow: a } }) => {
      var p;
      return [a.dataStatus === 8 ? (s(), l(S, { key: 0, type: "danger" }, { default: i(() => r[3] || (r[3] = [j("撤销")])), _: 1, __: [3] })) : (s(), l(S, { key: 1, type: (p = e(_).V[a.dataStatus]) == null ? void 0 : p.T }, { default: i(() => [j(b(e(_).VL[a.dataStatus]), 1)]), _: 2 }, 1032, ["type"]))];
    }), _: 1 })) : n("", true), e(c).visible("remark") ? (s(), l(t, { key: "remark", "show-overflow-tooltip": true, align: "center", label: "备注", prop: "remark", width: "90" })) : n("", true), e(T)([...e(f).detail, ...e(f).edit, ...e(f).revoke, ...e(f).void]) ? (s(), l(t, { key: 17, "min-width": H.value, align: "left", fixed: "right", label: "操作" }, { default: i(({ row: { sourceRow: a } }) => [u(et, { data: a, showDel: false, showEdit: !O(a) && (a.dataStatus === e(_).PASSED.V || a.dataStatus === e(_).UNDER_APPROVAL.V) && a.settlementStatus !== e(k).SETTLED.V, "show-detail": "" }, null, 8, ["data", "showEdit"]), !O(a) && a.dataStatus === e(_).PASSED.V && e(G).id === a.applicantId && e(T)(e(f).void) && a.settlementStatus !== e(k).SETTLED.V ? (s(), l(V, { key: 0, title: "确认作废", onConfirm: (p) => ve(a.id) }, { reference: i(() => [u(D, { class: "filter-item", size: "default", type: "danger" }, { default: i(() => [u(L, { "icon-class": "wms-void" })]), _: 1 })]), _: 2 }, 1032, ["onConfirm"])) : n("", true), e(T)(e(f).pay_application) ? (s(), l(y, { key: 1, disabled: a.dataStatus !== e(_).PASSED.V, size: "default", type: "success", onClick: (p) => B("payment", a, "付款申请") }, { default: i(() => [u(L, { "icon-class": "mes-purchase-payment" })]), _: 2 }, 1032, ["disabled", "onClick"])) : n("", true), e(T)(e(f).invoice_entry) ? (s(), l(y, { key: 2, disabled: a.dataStatus !== e(_).PASSED.V, size: "default", type: "primary", onClick: (p) => B("invoice", a, "发票入账") }, { default: i(() => [u(L, { "icon-class": "mes-purchase-invoice" })]), _: 2 }, 1032, ["disabled", "onClick"])) : n("", true), e(T)(e(f).pay_application) ? (s(), l(y, { key: 3, disabled: a.dataStatus !== e(_).PASSED.V || a.settlementStatus === e(k).SETTLED.V || a.settlementSize > 0, size: "default", type: "warning", onClick: (p) => B("settle", a, "结算申请") }, { default: i(() => [u(L, { "icon-class": "mes-purchase-settle" })]), _: 2 }, 1032, ["disabled", "onClick"])) : n("", true)]), _: 1 }, 8, ["min-width"])) : n("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[ke, _e.value]]), u(e(tt)), u(at, { "is-passed-edit": "" }), u(st), u(nt, { visible: F.value, "onUpdate:visible": r[0] || (r[0] = (a) => F.value = a), current_key: Z.value, item_data: X.value, title: ee.value }, null, 8, ["visible", "current_key", "item_data", "title"]), (s(), l(rt, { key: te.value, onClosed: Se })), (s(), l(ut, { key: W.value, visible: M.value, "onUpdate:visible": r[1] || (r[1] = (a) => M.value = a), onReset: de }, null, 8, ["visible"]))]);
  };
} }, jt = Fe(St, [["__scopeId", "data-v-c104a466"]]);
export {
  jt as default
};
