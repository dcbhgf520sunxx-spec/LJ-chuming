import { useStore as G } from "vuex";
import { ref as g } from "vue";
import { computed as I } from "vue";
import { watch as x } from "vue";
import { onMounted as Q } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as $ } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as i } from "vue";
import { withCtx as A } from "vue";
import { createCommentVNode as p } from "vue";
import { createElementVNode as z } from "vue";
import { createTextVNode as H } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as Z, m as J, aa as c, x as K, t7 as W, o as ee, t0 as d, t8 as ae, G as w, L as te, t9 as oe, ta as le, tb as re, P as ie } from "../../../../../shared/runtime.js";
import { q as r } from "../../../../../modules/plan-d12d7ccf.js";
import ne from "./module/header.vue.js";
import V from "../components/drawing-upload-btn.vue.js";
import pe from "../components/common-detail.vue.js";
import "../../../../supply-chain/components/audit-records.vue.js";
import "../../../../../modules/index-ce9deea8.js";
import "../components/match-detail/index.vue.js";
import "../components/match-detail/module/header.vue.js";
const se = { class: "app-container" }, ue = { class: "btn" }, ce = { __name: "index", setup(de) {
  const { globalProjectId: f, globalProject: O, drawingMatchRange: v } = J(["globalProjectId", "globalProject", "drawingMatchRange"]), t = G(), j = { add: false, edit: false, del: false, download: false }, b = g(), M = g({}), h = g(false), m = I(() => a.query.productType === c.ASSEMBLY.V ? ".nc1" : ".dxf"), S = I(() => a.query.productType === c.ASSEMBLY.V ? "NC1" : "DXF"), { crud: a, columns: _ } = K({ title: "数控文件管理", permission: { ...r }, optShow: { ...j }, requiredQuery: ["projectId", "dataType"], crudApi: { ...W }, hasPagination: true }, b), { maxHeight: k } = ee();
  x(() => f.value, (o) => {
    o && (a.query.projectId = f.value, a.toQuery());
  }, { immediate: true, deep: true });
  function E(o) {
    return { projectId: o.projectId, monomerId: o.monomerId, productType: o.productType, dataType: o.dataType, areaId: o.areaId };
  }
  function q(o) {
    h.value = true, M.value = { ...o, steelPlateTypeEnum: a.query.steelPlateTypeEnum };
  }
  function C() {
    t.dispatch("approval_list/fetchApprovalNum"), t.dispatch("approval_list/fetchSubNum", d.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V), t.dispatch("approval_list/fetchApprovalNum", d.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V), t.dispatch("approval_list/fetchRejNum", d.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V), a.toQuery();
  }
  return x(() => t.state.approval_list.SubNumerical_Num, () => {
    a.toQuery();
  }), Q(async () => {
    await t.dispatch("approval_list/fetchSubNum", d.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V), await t.dispatch("approval_list/fetchRejNum", d.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V), await t.dispatch("approval_list/fetchApprovalNum", d.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V);
  }), (o, y) => {
    const s = Y, U = L("common-button"), D = L("common-table"), R = B("permission"), F = X;
    return l(), $("div", se, [u(e(ne), { APPtotal: e(t).state.approval_list.APPNumerical_Num, globalProject: e(O), drawingMatchRange: e(v), "rej-total": e(t).state.approval_list.SubNumerical_Num, subTotal: e(t).state.approval_list.rejNumerical_Num, class: "head-container" }, null, 8, ["APPtotal", "globalProject", "drawingMatchRange", "rej-total", "subTotal"]), T((l(), i(D, { ref_key: "tableRef", ref: b, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(k), style: { width: "100%" } }, { default: A(() => {
      var N, P;
      return [u(s, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(_).visible("monomerName") ? (l(), i(s, { key: "monomerName", align: "center", label: "单体", prop: "monomerName", "show-overflow-tooltip": "" })) : p("", true), e(_).visible("areaName") && e(a).query.productType === e(c).MACHINE_PART.V && e(v) && e(v) === e(ae).AREA.V ? (l(), i(s, { key: "areaName", align: "center", label: "区域", prop: "areaName", "show-overflow-tooltip": "" })) : p("", true), e(_).visible("quantity") ? (l(), i(s, { key: "quantity", label: `${(P = (N = e(c).V) == null ? void 0 : N[e(a).query.productType]) == null ? void 0 : P.L}总数`, align: "center", prop: "quantity", "show-overflow-tooltip": "" }, null, 8, ["label"])) : p("", true), e(_).visible("drawingQuantity") ? (l(), i(s, { key: "drawingQuantity", align: "center", label: "文件匹配总数", prop: "drawingQuantity", "show-overflow-tooltip": "" })) : p("", true), e(w)([...e(r).matchImport, ...e(r).detail, ...e(r).download]) ? (l(), i(s, { key: 4, width: e(a).query.productType === e(c).MACHINE_PART.V ? "350px" : "270px", align: "center", fixed: "right", label: "操作" }, { default: A((n) => [z("div", ue, [e(a).query.productType === e(c).MACHINE_PART.V && e(w)(e(r).download) ? (l(), i(te, { key: 0, fn: e(oe), params: { projectId: e(f), monomerId: n.row.monomerId, areaId: n.row.areaId }, size: "default" }, { default: A(() => y[1] || (y[1] = [H(" 下载 ")])), _: 2, __: [1] }, 1032, ["fn", "params"])) : p("", true), T(u(V, { accept: `.zip,${m.value}`, data: E(n.row), dataType: n.row.dataType, uploadFunFile: e(le), tip: m.value, size: "default", "success-msg": "审批流已生成!请点击审批记录查看", type: "primary", onSuccess: C }, null, 8, ["accept", "data", "dataType", "uploadFunFile", "tip"]), [[R, e(r).import]]), e(w)(e(r).matchImport) ? (l(), i(V, { key: 1, accept: ".zip", data: E(n.row), dataType: n.row.dataType, tip: m.value, uploadFun: e(re), btnName: "匹配导入", btnType: "warning", size: "default", style: { "margin-right": "6px" }, "success-msg": "审批流已生成!请点击审批记录查看", onSuccess: C }, null, 8, ["data", "dataType", "tip", "uploadFun"])) : p("", true), T(u(U, { icon: "el-icon-document", size: "default", type: "primary", onClick: (me) => q(n.row) }, null, 8, ["onClick"]), [[R, e(r).detail]])])]), _: 1 }, 8, ["width"])) : p("", true)];
    }), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[F, e(a).loading]]), u(e(ie)), u(pe, { modelValue: h.value, "onUpdate:modelValue": y[0] || (y[0] = (N) => h.value = N), currentRow: M.value, permission: e(r), tip: `覆盖导入仅支持${S.value}格式`, "upload-type": m.value, onSuccess: e(a).toQuery }, null, 8, ["modelValue", "currentRow", "permission", "tip", "upload-type", "onSuccess"])]);
  };
} }, be = Z(ce, [["__scopeId", "data-v-31a064ed"]]);
export {
  be as default
};
