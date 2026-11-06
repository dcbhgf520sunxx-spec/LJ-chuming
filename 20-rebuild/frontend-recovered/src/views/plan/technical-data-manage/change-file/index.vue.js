import { useStore as U } from "vuex";
import { ref as p } from "vue";
import { watch as x } from "vue";
import { onMounted as D } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as c } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as q } from "vue";
import { createCommentVNode as h } from "vue";
import { createTextVNode as B } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as O } from "element-plus";
import { _ as Q, m as $, x as K, s$ as z, o as J, t0 as g, p as W, G as X, P as Y } from "../../../../shared/runtime.js";
import { o as u } from "../../../../modules/plan-d12d7ccf.js";
import Z from "./module/upload-form.vue.js";
import { _ as ee } from "../../../../modules/E.operation-f0120ea4.js";
import te from "./module/header.vue.js";
import "../components/drawing-upload-btn/index.vue.js";
import "../../../../modules/index-ce9deea8.js";
import "../../../supply-chain/components/audit-records.vue.js";
const ae = { class: "app-container" }, oe = { class: "head-container" }, re = { __name: "index", setup(ne) {
  const n = U(), { globalProjectId: _, globalProject: j } = $(["globalProjectId", "globalProject"]), k = { add: false, edit: false, del: true, download: false }, b = p(), f = p({}), v = p({}), d = p(false), { crud: a, columns: w, CRUD: y } = K({ title: "变更文件", sort: ["id.desc"], permission: { ...u }, optShow: { ...k }, requiredQuery: ["dataType"], crudApi: { ...z }, hasPagination: true }, b), { maxHeight: T } = J({ wrapperBox: ".changeFile", paginate: true, extraHeight: 40 });
  x(() => _.value, (o) => {
    o && a.toQuery();
  }, { immediate: true, deep: true });
  function R(o, r, t) {
  }
  function A(o) {
    f.value = o, d.value = true;
  }
  function S(o) {
    v.value = o;
  }
  function V() {
    f.value = {}, d.value = true;
  }
  return y.HOOK.beforeRefresh = () => (a.query.projectId = _.value, a.query.projectId), y.HOOK.handleRefresh = (o, r) => {
    r.data.content = r.data.content.map((t) => (t.edit = false, t.originalRemark = t.remark, t.editLoading = false, t));
  }, x(() => n.state.approval_list.SubChange_Num, () => {
    a.toQuery();
  }), D(async () => {
    await n.dispatch("approval_list/fetchSubNum", g.PLAN_CHANGE_FILE.V), await n.dispatch("approval_list/fetchApprovalNum", g.PLAN_CHANGE_FILE.V), await n.dispatch("approval_list/fetchRejNum", g.PLAN_CHANGE_FILE.V);
  }), (o, r) => {
    const t = G, E = N("common-button"), H = N("common-table"), L = M("permission"), I = O;
    return s(), F("div", ae, [C("div", oe, [i(e(te), { APPtotal: e(n).state.approval_list.APPChange_Num, "project-id": e(_), "rej-total": e(n).state.approval_list.rejChange_Num, subTotal: e(n).state.approval_list.SubChange_Num, onCurrentChange: S, onHandleUpload: V }, null, 8, ["APPtotal", "project-id", "rej-total", "subTotal"])]), P((s(), c(H, { ref_key: "tableRef", ref: b, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(T), showEmptySymbol: false, "return-source-data": "", style: { width: "100%" }, onRowDblclick: R, onSelectionChange: e(a).selectionChangeHandler }, { default: m(() => [i(t, { align: "center", type: "selection", width: "55" }), i(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), i(t, { key: "createTime", align: "center", label: "日期", prop: "createTime" }, { default: m((l) => [C("div", null, q(l.row.createTime ? e(W)(l.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), e(w).visible("createUserName") ? (s(), c(t, { key: "createUserName", "show-overflow-tooltip": true, align: "center", label: "导入人", prop: "createUserName" })) : h("", true), e(w).visible("fileName") ? (s(), c(t, { key: "fileName", "show-overflow-tooltip": true, align: "center", label: "文件", prop: "fileName" })) : h("", true), e(X)([...e(u).edit, ...e(u).download]) ? (s(), c(t, { key: 2, align: "center", fixed: "right", label: "操作", width: "150px" }, { default: m((l) => [P((s(), c(E, { size: "default", type: "primary", onClick: (le) => A(l.row) }, { default: m(() => r[1] || (r[1] = [B(" 替换 ")])), _: 2, __: [1] }, 1032, ["onClick"])), [[L, e(u).edit]]), i(e(ee), { data: l.row, permission: e(u).download }, null, 8, ["data", "permission"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[I, e(a).loading]]), i(e(Y)), i(e(Z), { modelValue: d.value, "onUpdate:modelValue": r[0] || (r[0] = (l) => d.value = l), currentMonomer: v.value, currentRow: f.value, dataType: e(a).query.dataType, globalProject: e(j), onSuccess: e(a).toQuery }, null, 8, ["modelValue", "currentMonomer", "currentRow", "dataType", "globalProject", "onSuccess"])]);
  };
} }, he = Q(re, [["__scopeId", "data-v-b05cc163"]]);
export {
  he as default
};
