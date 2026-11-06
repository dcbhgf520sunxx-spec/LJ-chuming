import { useStore as B } from "vuex";
import { ref as p } from "vue";
import { watch as N } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as c } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as M } from "vue";
import { createCommentVNode as h } from "vue";
import { createTextVNode as q } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { vLoading as $ } from "element-plus";
import { _ as G, m as K, x as z, s$ as F, o as J, t0 as b, p as W, G as X, P as Y } from "../../../../shared/runtime.js";
import { n as u } from "../../../../modules/plan-d12d7ccf.js";
import Z from "./module/upload-form.vue.js";
import ee from "./module/header.vue.js";
import { _ as te } from "../../../../modules/E.operation-f0120ea4.js";
import "../components/drawing-upload-btn/index.vue.js";
import "../../../../modules/index-ce9deea8.js";
import "../../../supply-chain/components/audit-records.vue.js";
const ae = { class: "app-container" }, oe = { class: "head-container" }, re = { __name: "index", setup(ne) {
  const { globalProjectId: _, globalProject: C } = K(["globalProjectId", "globalProject"]), n = B(), R = { add: false, edit: false, del: true, download: false }, g = p(), f = p({}), v = p({}), d = p(false), { crud: a, columns: w, CRUD: y } = z({ title: "蓝图", sort: ["id.desc"], permission: { ...u }, optShow: { ...R }, requiredQuery: ["dataType"], crudApi: { ...F }, hasPagination: true }, g), { maxHeight: j } = J({ wrapperBox: ".bluePrint", paginate: true, extraHeight: 40 });
  N(() => _.value, (o) => {
    o && a.toQuery();
  }, { immediate: true, deep: true });
  function k(o, r, t) {
  }
  function S(o) {
    f.value = o, d.value = true;
  }
  function U(o) {
    v.value = o;
  }
  function I() {
    f.value = {}, d.value = true;
  }
  return y.HOOK.beforeRefresh = () => (a.query.projectId = _.value, a.query.projectId), y.HOOK.handleRefresh = (o, r) => {
    r.data.content = r.data.content.map((t) => (t.edit = false, t.originalRemark = t.remark, t.editLoading = false, t));
  }, N(() => n.state.approval_list.Subconstruction_Num, () => {
    a.toQuery();
  }), D(async () => {
    await n.dispatch("approval_list/fetchSubNum", b.PLAN_CONSTRUCTION_BLUEPRINT.V), await n.dispatch("approval_list/fetchApprovalNum", b.PLAN_CONSTRUCTION_BLUEPRINT.V), await n.dispatch("approval_list/fetchRejNum", b.PLAN_CONSTRUCTION_BLUEPRINT.V);
  }), (o, r) => {
    const t = Q, V = P("common-button"), O = P("common-table"), A = E("permission"), L = $;
    return s(), H("div", ae, [T("div", oe, [i(e(ee), { APPtotal: e(n).state.approval_list.APPconstruction_Num, "project-id": e(_), "rej-total": e(n).state.approval_list.rejconstruction_Num, subTotal: e(n).state.approval_list.Subconstruction_Num, onCurrentChange: U, onHandleUpload: I }, null, 8, ["APPtotal", "project-id", "rej-total", "subTotal"])]), x((s(), c(O, { ref_key: "tableRef", ref: g, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(j), showEmptySymbol: false, "return-source-data": "", style: { width: "100%" }, onRowDblclick: k, onSelectionChange: e(a).selectionChangeHandler }, { default: m(() => [i(t, { align: "center", type: "selection", width: "55" }), i(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), i(t, { key: "createTime", align: "center", label: "日期", prop: "createTime" }, { default: m((l) => [T("div", null, M(l.row.createTime ? e(W)(l.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), e(w).visible("createUserName") ? (s(), c(t, { key: "createUserName", "show-overflow-tooltip": true, align: "center", label: "导入人", prop: "createUserName" })) : h("", true), e(w).visible("fileName") ? (s(), c(t, { key: "fileName", "show-overflow-tooltip": true, align: "center", label: "文件", prop: "fileName" })) : h("", true), e(X)([...e(u).edit, ...e(u).download]) ? (s(), c(t, { key: 2, align: "center", fixed: "right", label: "操作", width: "150px" }, { default: m((l) => [x((s(), c(V, { size: "default", type: "primary", onClick: (le) => S(l.row) }, { default: m(() => r[1] || (r[1] = [q(" 替换 ")])), _: 2, __: [1] }, 1032, ["onClick"])), [[A, e(u).edit]]), i(e(te), { data: l.row, permission: e(u).download }, null, 8, ["data", "permission"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[L, e(a).loading]]), i(e(Y)), i(e(Z), { modelValue: d.value, "onUpdate:modelValue": r[0] || (r[0] = (l) => d.value = l), currentMonomer: v.value, currentRow: f.value, dataType: e(a).query.dataType, globalProject: e(C), onSuccess: e(a).toQuery }, null, 8, ["modelValue", "currentMonomer", "currentRow", "dataType", "globalProject", "onSuccess"])]);
  };
} }, he = G(re, [["__scopeId", "data-v-26b7d253"]]);
export {
  he as default
};
