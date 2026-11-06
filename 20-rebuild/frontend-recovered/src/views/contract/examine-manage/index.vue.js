import { ref as c } from "vue";
import { reactive as H } from "vue";
import { provide as N } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as p } from "vue";
import { withDirectives as I } from "vue";
import { unref as e } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as E } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as $ } from "vue";
import { withModifiers as Q } from "vue";
import { mergeProps as q } from "vue";
import { nextTick as z } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElTag as J } from "element-plus";
import { ElButton as K } from "element-plus";
import { vLoading as Y } from "element-plus";
import { _ as W, x as X, iM as Z, o as ee, D as te, iN as _, gD as ae, bV as ne, G as ie, P as oe, iO as le, iP as re, iQ as se } from "../../../shared/runtime.js";
import ue from "./module/header.vue.js";
import { n as A } from "../../../modules/contract-9b18cc88.js";
import "../../../modules/useSelect-654af12a.js";
const pe = { class: "app-container" }, me = { class: "head-container" }, ce = { __name: "index", setup(de, { expose: C }) {
  const w = c(null), P = c({}), g = c(null), j = { add: false, edit: false, del: false, download: false }, y = c(false), { crud: u, columns: r, CRUD: S } = X({ title: "审批管理", invisibleColumns: ["contractNumber", "writtenByName", "voucherNumber", "submitDate"], optShow: { ...j }, permission: A, crudApi: Z }, g), v = c(null), h = H({}), { maxHeight: T } = ee({ paginate: true, extraHeight: 20 }), V = c([["filingDate", ["parse-time", "{y}-{m}-{d}"]], ["submitDate", ["parse-time", "{y}-{m}-{d}"]], ["actuallyPayAmount", ["to-thousand", te.YUAN]]]);
  N("tableItemData", h), S.HOOK.handleRefresh = async (m, { data: o }) => {
    o.content = o.content.map((t) => (t.paymentEnumName = _.VL[t.paymentEnum], t.projectAttributeName = ae.VL[t.projectAttribute], t));
  };
  const R = async (m) => {
    const { paymentEnumName: o, projectAttributeName: t } = m;
    y.value = true, Object.assign(h, m, { approvalFlag: true }), await z(() => {
      t ? v.value.headerTitle = `${o}` : v.value.headerTitle = `${o} `;
    });
  };
  function B(m) {
    u.crudApi.detail = se, u.toDetail(m);
  }
  function L() {
    y.value = false;
  }
  return N("parentData", { headerRef: w, tableRef: g, formData: P }), C({ refresh: u.toQuery }), (m, o) => {
    const t = G, d = J, M = K, O = k("common-button"), U = k("common-table"), F = Y;
    return a(), D("div", pe, [x("div", me, [p(ue, { ref_key: "headerRef", ref: w }, null, 512)]), I((a(), n(U, { ref_key: "tableRef", ref: g, data: e(u).data, "data-format": V.value, "empty-text": e(u).emptyText, "max-height": e(T) }, { default: s(() => [p(t, { align: "center", fixed: "", label: "序号", type: "index", width: "60" }), e(r).visible("paymentEnum") ? (a(), n(t, { key: "paymentEnum", align: "center", fixed: "", label: "付款类型", prop: "paymentEnum", width: "100" }, { default: s(({ row: { paymentEnum: l } }) => {
      var f;
      return [p(d, { type: (f = e(_).V[l]) == null ? void 0 : f.T }, { default: s(() => [b(E(e(_).VL[l]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), e(r).visible("filingDate") ? (a(), n(t, { key: "filingDate", align: "center", label: "申请日期", prop: "filingDate", width: "120" })) : i("", true), e(r).visible("oaNumber") ? (a(), n(t, { key: "oaNumber", align: "center", label: "OA编号", prop: "oaNumber", "show-overflow-tooltip": "", width: "120" })) : i("", true), e(r).visible("initiatorName") ? (a(), n(t, { key: "initiatorName", align: "center", label: "发起人", prop: "initiatorName", width: "120" })) : i("", true), e(r).visible("contractNumber") ? (a(), n(t, { key: "contractNumber", align: "center", label: "采购/分包合同号", prop: "contractNumber", "show-overflow-tooltip": "", width: "300" })) : i("", true), e(r).visible("projectName") ? (a(), n(t, { key: "projectName", align: "center", label: "所属项目", "min-width": "180", prop: "projectName", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("projectManagerName") ? (a(), n(t, { key: "projectManagerName", align: "center", label: "项目经理/销售负责人", "min-width": "140", prop: "projectManagerName" })) : i("", true), e(r).visible("supplierName") ? (a(), n(t, { key: "supplierName", align: "center", label: "供应商", "min-width": "160", prop: "supplierName", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("applyAmount") ? (a(), n(t, { key: "applyAmount", align: "center", label: "申请金额", "min-width": "120", prop: "applyAmount" }, { default: s(({ row: l }) => [x("span", null, E(e(ne)(l.applyAmount)), 1)]), _: 1 })) : i("", true), e(r).visible("actuallyPayAmount") ? (a(), n(t, { key: "actuallyPayAmount", align: "center", label: "实付(开)金额", "min-width": "120", prop: "actuallyPayAmount", "show-overflow-tooltip": "" })) : i("", true), e(r).visible("writtenByName") ? (a(), n(t, { key: "writtenByName", align: "center", label: "审核人", prop: "writtenByName", width: "120" })) : i("", true), e(r).visible("submitDate") ? (a(), n(t, { key: "submitDate", align: "center", label: "审核日期", prop: "submitDate", width: "120" })) : i("", true), e(r).visible("auditStatusEnum") ? (a(), n(t, { key: "auditStatusEnum", align: "center", label: "状态", prop: "auditStatusEnum", width: "90" }, { default: s(({ row: l }) => [l.auditStatusEnum === 1 ? (a(), n(d, { key: 0, type: "warning" }, { default: s(() => o[1] || (o[1] = [b("审核中")])), _: 1, __: [1] })) : i("", true), l.auditStatusEnum === 2 ? (a(), n(d, { key: 1, type: "success" }, { default: s(() => o[2] || (o[2] = [b("审核通过")])), _: 1, __: [2] })) : i("", true), l.auditStatusEnum === 4 ? (a(), n(d, { key: 2, type: "danger" }, { default: s(() => o[3] || (o[3] = [b("驳回")])), _: 1, __: [3] })) : i("", true), l.auditStatusEnum === 8 ? (a(), n(d, { key: 3, type: "danger" }, { default: s(() => o[4] || (o[4] = [b("撤销")])), _: 1, __: [4] })) : i("", true)]), _: 1 })) : i("", true), p(t, { align: "center", fixed: "right", label: "操作", width: "100" }, { default: s(({ row: l }) => [e(ie)(e(A).detail) ? (a(), D($, { key: 0 }, [l.paymentEnum !== e(_).PROJECT_COLLECTION.V ? (a(), n(M, { key: 0, icon: "el-icon-view", type: "info", onClick: (f) => R(l) }, null, 8, ["onClick"])) : (a(), n(O, { key: 1, icon: "el-icon-view", type: "info", size: "default", onClick: Q((f) => B(l), ["stop"]) }, null, 8, ["onClick"]))], 64)) : i("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[F, e(u).loading]]), p(oe), p(le, q({ ref_key: "drawerRef", ref: v, visible: y.value, "onUpdate:visible": o[0] || (o[0] = (l) => y.value = l), "table-item-data": h }, { ApprovalFlag: true }, { onClose: L, onUpdateList: e(u).toQuery }), null, 16, ["visible", "table-item-data", "onUpdateList"]), p(re, { ApprovalFlag: "" })]);
  };
} }, ve = W(ce, [["__scopeId", "data-v-cb60c539"]]);
export {
  ve as default
};
