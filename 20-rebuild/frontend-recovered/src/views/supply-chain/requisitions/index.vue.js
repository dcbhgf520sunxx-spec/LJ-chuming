import { ref as y } from "vue";
import { computed as O } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as o } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as n } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as v } from "vue";
import { Fragment as G } from "vue";
import { ElMessageBox as $ } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElSwitch as z } from "element-plus";
import { vLoading as W } from "element-plus";
import { _ as K, w5 as c, j_ as h, x as X, ww as _, wx as Y, o as J, iX as Q, c as A, vd as T, G as E, aS as b, an as Z, P as ee, wy as te } from "../../../shared/runtime.js";
import ae from "./module/header.vue.js";
import ie from "./module/form.vue.js";
import oe from "./module/detail.vue.js";
import le from "./module/track-drawer.vue.js";
import "../../../modules/use-approval-cfg-0a67817c.js";
import "./module/application/steel/index.vue.js";
import "./module/application/components/common-wrapper.vue.js";
import "./module/application/components/common-footer.vue.js";
import "./module/application/components/confirm-dialog.vue.js";
import "./module/application/steel/module/steel-plate-table.vue.js";
import "./module/application/steel/module/section-steel-table.vue.js";
import "./module/application/steel/module/steel-coil-table.vue.js";
import "./module/application/components/inventory-drawer.vue.js";
import "./module/application/auxiliary-material/index.vue.js";
import "../../../modules/aux-material-a427f83d.js";
import "./module/application/auxiliary-material/module/aux-mat-table.vue.js";
import "./module/application/manufactured/index.vue.js";
import "./module/application/manufactured/module/enclosure-table.vue.js";
import "./module/application/manufactured/module/structure-table.vue.js";
import "./module/application/other/index.vue.js";
import "../../../modules/other-e93f8d3e.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
const ne = { class: "app-container" }, re = ["onClick"], se = { key: 1 }, pe = { __name: "index", setup(ce) {
  const I = { add: true, edit: false, del: false, download: false }, V = y(), M = y([["project", ["parse-project", { onlyShortName: true }]], ["reviewStatus", ["parse-enum", c, { f: "L" }]], ["materialTypeTag", ["parse-enum", h, { f: "T" }], { source: "materialType" }], ["materialType", ["parse-enum", h, { f: "L" }]], ["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: C, crud: f, columns: r } = X({ title: "材料申购", permission: { ..._ }, invisibleColumns: [], crudApi: { ...Y }, optShow: { ...I } }, V), { maxHeight: U } = J({ paginate: true }), S = y(false), N = y({}), d = O(() => f.query.boolInitiateApprove);
  async function D(u, m) {
    try {
      await $.confirm('此操作将 "' + b.VL[m] + '" ' + u.serialNumber + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await te({ id: u.id, enabled: m }), f.refresh(), f.notify(b.VL[m] + "成功", C.NOTIFICATION_TYPE.SUCCESS);
    } catch (a) {
      console.log("申购单状态", a), u.enabled = u.enabled === b.TRUE.V ? b.FALSE.V : b.TRUE.V;
    }
  }
  function R(u) {
    N.value = u, S.value = true;
  }
  return C.HOOK.handleRefresh = (u, { data: m }) => {
    m.content.forEach((a) => {
      a.inboundMete = a.inboundMete || 0, a.totalMete = a.totalMete || 0, a.inboundRate = a.inboundMete ? Q(a.inboundMete / a.totalMete * 100, 2) : 0, a.materialType === h.STEEL.V && (a.inboundMete = A(a.inboundMete, "g", "kg"), a.totalMete = A(a.totalMete, "g", "kg"));
    });
  }, (u, m) => {
    const a = q, w = H, L = x("common-button"), P = z, B = x("common-table"), F = W;
    return i(), g("div", ne, [l(e(ae)), j((i(), o(B, { ref_key: "tableRef", ref: V, data: e(f).data, "data-format": M.value, "max-height": e(U), style: { width: "100%" }, onSelectionChange: e(f).selectionChangeHandler }, { default: p(() => [l(a, { align: "center", fixed: "left", type: "selection", width: "55" }), l(a, { align: "center", label: "序号", type: "index", width: "60" }), e(r).visible("createTime") ? (i(), o(a, { key: "createTime", align: "center", label: "申购创建日期", prop: "createTime", width: "150" })) : n("", true), e(r).visible("updateTime") ? (i(), o(a, { key: "updateTime", align: "center", label: "申购修改日期", prop: "updateTime", width: "150" })) : n("", true), e(r).visible("applicantName") ? (i(), o(a, { key: "applicantName", align: "center", label: "申购人", prop: "applicantName", "show-overflow-tooltip": "", width: "120" })) : n("", true), e(r).visible("serialNumber") ? (i(), o(a, { key: "serialNumber", align: "left", label: "申购编号", "min-width": "120", prop: "serialNumber", "show-overflow-tooltip": "" })) : n("", true), e(r).visible("materialType") ? (i(), o(a, { key: "materialType", align: "center", label: "材料分类", prop: "materialType", "show-overflow-tooltip": "", width: "100" }, { default: p(({ row: t }) => [l(w, { type: t.materialTypeTag, effect: "plain", size: "large" }, { default: p(() => [k(v(t.materialType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : n("", true), e(r).visible("project") ? (i(), o(a, { key: "project", label: "所属项目", "min-width": "150", prop: "project", "show-overflow-tooltip": "" })) : n("", true), l(a, { align: "center", label: "采购状态", prop: "purchaseCreationState", width: "90" }, { default: p(({ row: t }) => {
      var s;
      return [t.purchaseCreationState ? (i(), o(w, { key: 0, type: (s = e(T).V[t.purchaseCreationState]) == null ? void 0 : s.T, effect: "plain" }, { default: p(() => [k(v(e(T).VL[t.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])) : n("", true)];
    }), _: 1 }), e(r).visible("mete") ? (i(), o(a, { key: "mete", align: "center", label: "采购进度", prop: "mete", "show-overflow-tooltip": "", width: "90" }, { default: p(({ row: { sourceRow: t } }) => [e(E)(e(_).trackGet) ? (i(), g(G, { key: 0 }, [t.materialType === e(h).STEEL.V ? (i(), g("span", { key: 0, class: "tc-primary", style: { cursor: "pointer" }, onClick: (s) => R(t) }, v(t.inboundRate) + "% ", 9, re)) : (i(), o(L, { key: 1, icon: "el-icon-view", size: "default", type: "success", onClick: (s) => R(t) }, null, 8, ["onClick"]))], 64)) : (i(), g("span", se, v(t.materialType === e(h).STEEL.V ? t.inboundRate + "%" : "-"), 1))]), _: 1 })) : n("", true), e(r).visible("approveInfoName") && d.value ? (i(), o(a, { key: "approveInfoName", align: "center", label: "审批流程", prop: "approveInfoName", "show-overflow-tooltip": "" })) : n("", true), e(r).visible("reviewStatus") && d.value ? (i(), o(a, { key: "reviewStatus", align: "center", label: "审核状态", prop: "reviewStatus", "show-overflow-tooltip": "", width: "100" }, { default: p(({ row: t }) => {
      var s;
      return [l(w, { type: e(c).V[(s = t == null ? void 0 : t.sourceRow) == null ? void 0 : s.reviewStatus].TAG, effect: "plain", size: "large" }, { default: p(() => [k(v(t.reviewStatus), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : n("", true), e(r).visible("enabled") ? (i(), o(a, { key: "enabled", align: "center", label: "状态", prop: "enabled", width: "100" }, { default: p(({ row: { sourceRow: t } }) => [l(P, { modelValue: t.enabled, "onUpdate:modelValue": (s) => t.enabled = s, "active-value": e(b).TRUE.V, disabled: !e(E)(e(_).editStatus) || d.value && t.reviewStatus !== e(c).PASS.V, "inactive-value": e(b).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (s) => D(t, t.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : n("", true), e(E)([...e(_).detail, ...e(_).del]) ? (i(), o(a, { key: 10, align: "center", label: "操作", width: "180" }, { default: p(({ row: { sourceRow: t } }) => [l(Z, { data: { id: t.id }, "del-icon": d.value ? "el-icon-document-delete" : "el-icon-delete", "del-type": d.value ? "warning" : "danger", delPrompt: `确定${d.value ? "撤销" : "删除"}本条数据吗？`, "disabled-del": t.purchaseCreationState !== e(T).NOT_STARTED.V || !!(d.value && t.reviewStatus & (e(c).UNREVIEWED.V | e(c).AUDITING.V | e(c).PASS.V)), "disabled-edit": t.purchaseCreationState !== e(T).NOT_STARTED.V || !!(t.reviewStatus & (e(c).UNREVIEWED.V | e(c).AUDITING.V | e(c).PASS.V) && d.value), permission: e(_), "show-detail": "" }, null, 8, ["data", "del-icon", "del-type", "delPrompt", "disabled-del", "disabled-edit", "permission"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[F, e(f).loading]]), l(e(ee)), l(e(ie)), l(oe), l(e(le), { visible: S.value, "onUpdate:visible": m[0] || (m[0] = (t) => S.value = t), info: N.value }, null, 8, ["visible", "info"])]);
  };
} }, Le = K(pe, [["__scopeId", "data-v-1b3c7111"]]);
export {
  Le as default
};
