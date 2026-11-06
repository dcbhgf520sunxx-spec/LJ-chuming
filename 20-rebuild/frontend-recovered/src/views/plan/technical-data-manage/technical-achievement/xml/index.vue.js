import { useStore as k } from "vuex";
import { ref as d } from "vue";
import { watch as M } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as m } from "vue";
import { createBlock as c } from "vue";
import { withCtx as x } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as Q } from "vue";
import { ElNotification as R } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { vLoading as U } from "element-plus";
import { _ as q, m as O, x as z, t7 as B, o as $, t0 as r, G as F, tb as H, P as J } from "../../../../../shared/runtime.js";
import { x as s } from "../../../../../modules/plan-d12d7ccf.js";
import K from "./module/header.vue.js";
import T from "../components/drawing-upload-btn.vue.js";
import W from "../components/common-detail.vue.js";
import "../../../../supply-chain/components/audit-records.vue.js";
import "../../../../../modules/index-ce9deea8.js";
import "../components/match-detail/index.vue.js";
import "../components/match-detail/module/header.vue.js";
const Y = { class: "app-container" }, Z = { class: "btn" }, ee = { __name: "index", setup(te) {
  const t = k(), { globalProjectId: h } = O(["globalProjectId"]), P = { add: false, edit: false, del: false, download: false }, N = d(), b = d({}), u = d(".xml"), y = d(false), { crud: a, columns: f } = z({ title: "数控文件管理", permission: { ...s }, optShow: { ...P }, requiredQuery: ["projectId", "dataType"], crudApi: { ...B }, hasPagination: true }, N), { maxHeight: L } = $();
  M(() => h.value, (o) => {
    o && (a.query.projectId = h.value, a.toQuery());
  }, { immediate: true, deep: true });
  function g(o) {
    return { projectId: o.projectId, monomerId: o.monomerId, productType: o.productType, dataType: o.dataType };
  }
  function E(o) {
    y.value = true, b.value = o;
  }
  function C() {
    R({ title: "上传成功", type: "success", message: "审批流已生成!请点击审批记录查看", duration: 2500 }), t.dispatch("approval_list/fetchApprovalNum"), t.dispatch("approval_list/fetchSubNum", r.PLAN_XML_DOCUMENT_MANAGE.V), t.dispatch("approval_list/fetchApprovalNum", r.PLAN_XML_DOCUMENT_MANAGE.V), t.dispatch("approval_list/fetchRejNum", r.PLAN_XML_DOCUMENT_MANAGE.V), a.toQuery();
  }
  return M(() => t.state.approval_list.Sub_XML_Num, () => {
    a.toQuery();
  }), D(async () => {
    await t.dispatch("approval_list/fetchSubNum", r.PLAN_XML_DOCUMENT_MANAGE.V), await t.dispatch("approval_list/fetchApprovalNum", r.PLAN_XML_DOCUMENT_MANAGE.V), await t.dispatch("approval_list/fetchRejNum", r.PLAN_XML_DOCUMENT_MANAGE.V);
  }), (o, w) => {
    const p = G, S = A("common-button"), V = A("common-table"), v = X("permission"), j = U;
    return n(), I("div", Y, [l(e(K), { APPtotal: e(t).state.approval_list.APP_XML_Num, "rej-total": e(t).state.approval_list.rej_XML_Num, subTotal: e(t).state.approval_list.Sub_XML_Num, class: "head-container" }, null, 8, ["APPtotal", "rej-total", "subTotal"]), m((n(), c(V, { ref_key: "tableRef", ref: N, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(L), style: { width: "100%" } }, { default: x(() => [l(p, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(f).visible("monomerName") ? (n(), c(p, { key: "monomerName", align: "center", label: "单体", prop: "monomerName", "show-overflow-tooltip": "" })) : _("", true), e(f).visible("quantity") ? (n(), c(p, { key: "quantity", align: "center", label: "构件总数", prop: "quantity", "show-overflow-tooltip": "" })) : _("", true), e(f).visible("drawingQuantity") ? (n(), c(p, { key: "drawingQuantity", align: "center", label: "文件匹配总数", prop: "drawingQuantity", "show-overflow-tooltip": "" })) : _("", true), e(F)([...e(s).import, ...e(s).detail]) ? (n(), c(p, { key: 3, align: "center", fixed: "right", label: "操作", width: "260px" }, { default: x((i) => [Q("div", Z, [m(l(T, { accept: `.zip,${u.value}`, data: g(i.row), dataType: i.row.dataType, tip: u.value, size: "default", type: "primary", onSuccess: e(a).toQuery }, null, 8, ["accept", "data", "dataType", "tip", "onSuccess"]), [[v, e(s).import]]), m(l(T, { accept: ".zip", data: g(i.row), dataType: i.row.dataType, tip: u.value, uploadFun: e(H), btnName: "匹配导入", btnType: "warning", size: "default", style: { "margin-right": "6px" }, onSuccess: C }, null, 8, ["data", "dataType", "tip", "uploadFun"]), [[v, e(s).matchImport]]), m(l(S, { icon: "el-icon-document", size: "default", type: "primary", onClick: (ae) => E(i.row) }, null, 8, ["onClick"]), [[v, e(s).detail]])])]), _: 1 })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[j, e(a).loading]]), l(e(J)), l(W, { modelValue: y.value, "onUpdate:modelValue": w[0] || (w[0] = (i) => y.value = i), currentRow: b.value, permission: e(s), "upload-type": u.value, tip: "覆盖导入仅支持XML格式", onSuccess: e(a).toQuery }, null, 8, ["modelValue", "currentRow", "permission", "upload-type", "onSuccess"])]);
  };
} }, me = q(ee, [["__scopeId", "data-v-2f5a994d"]]);
export {
  me as default
};
