import { ref as s } from "vue";
import { watch as L } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { unref as e } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as u } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as g } from "vue";
import { toDisplayString as B } from "vue";
import { createTextVNode as E } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as M, u as Q } from "./module/upload-form.vue.js";
import { _ as F, m as $, x as z, o as G, tP as K, bN as h, p as J, an as W, L as X, P as Y } from "../../../../shared/runtime.js";
import { c as x } from "../../../../modules/project-19a12d6b.js";
import Z from "./module/header.vue.js";
import "./module/upload-btn/index.vue.js";
const ee = { class: "app-container" }, te = { key: 0 }, ae = { class: "head-container" }, oe = { key: 1 }, re = { __name: "index", setup(ne) {
  const { globalProjectId: l, globalProject: m } = $(["globalProjectId", "globalProject"]), w = { add: false, edit: false, del: false, download: false }, y = s(), T = s({}), N = s({}), i = s(false), { crud: a, columns: _, CRUD: j } = z({ title: "施工资料", sort: ["id.desc"], permission: { ...x }, optShow: { ...w }, requiredQuery: ["projectId"], crudApi: { ...M }, hasPagination: true }, y), { maxHeight: I } = G({ wrapperBox: ".construction-data", paginate: true, extraHeight: 40 });
  L(() => l.value, (c) => {
    c && (a.query.projectId = l.value, a.toQuery());
  }, { immediate: true, deep: true });
  const k = s([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["constructionStageType", ["parse-enum", K]]]);
  function P(c) {
    N.value = c;
  }
  function S() {
    T.value = {}, i.value = true;
  }
  j.HOOK.beforeRefresh = () => (a.query.projectId = m.value.businessType === h.INSTALLATION.V ? l.value : void 0, !!a.query.projectId);
  function C() {
    i.value = false, a.toQuery();
  }
  return (c, d) => {
    var b;
    const n = H, V = R("common-table"), A = O, D = U;
    return r(), f("div", ee, [((b = e(m)) == null ? void 0 : b.businessType) === e(h).INSTALLATION.V ? (r(), f("div", te, [v("div", ae, [t(e(Z), { "project-id": e(l), onCurrentChange: P, onHandleUpload: S }, null, 8, ["project-id"])]), q((r(), u(V, { ref_key: "tableRef", ref: y, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(I), "data-format": k.value, style: { width: "100%" } }, { default: p(() => [t(n, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(_).visible("constructionStageType") ? (r(), u(n, { key: "constructionStageType", prop: "constructionStageType", "show-overflow-tooltip": true, label: "阶段", align: "center" })) : g("", true), e(_).visible("fileName") ? (r(), u(n, { key: "fileName", prop: "fileName", "show-overflow-tooltip": true, label: "文件名称", align: "center" })) : g("", true), e(_).visible("userName") ? (r(), u(n, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "上传人", align: "center" })) : g("", true), t(n, { key: "createTime", prop: "createTime", label: "日期", align: "center" }, { default: p((o) => [v("div", null, B(o.row.createTime ? e(J)(o.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), t(n, { label: "操作", width: "150px", align: "center", fixed: "right" }, { default: p((o) => [t(e(W), { data: o.row, permission: e(x), "show-edit": false }, null, 8, ["data", "permission"]), t(X, { params: { id: o.row.attachmentId } }, null, 8, ["params"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[D, e(a).loading]]), t(e(Y))])) : (r(), f("div", oe, [t(A, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: p(() => d[1] || (d[1] = [E(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [1] })])), t(e(Q), { modelValue: i.value, "onUpdate:modelValue": d[0] || (d[0] = (o) => i.value = o), globalProject: e(m), onSuccess: C }, null, 8, ["modelValue", "globalProject"])]);
  };
} }, pe = F(re, [["__scopeId", "data-v-9ec24f9f"]]);
export {
  pe as default
};
