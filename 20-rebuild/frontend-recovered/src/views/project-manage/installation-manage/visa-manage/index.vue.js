import { useStore as T } from "vuex";
import { ref as u } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as l } from "vue";
import { withCtx as d } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as r } from "vue";
import { withDirectives as I } from "vue";
import { toDisplayString as A } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElTag as B } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as L, m as M, x as q, u0 as F, u1 as G, o as O, G as w, u2 as f, an as Q, P as U, u3 as $ } from "../../../../shared/runtime.js";
import { w as i } from "../../../../modules/project-19a12d6b.js";
import z from "./module/header.vue.js";
import J from "./module/create-visa-form.vue.js";
import "../../../../modules/visa-manage-fd5a2300.js";
import "../../../../modules/PicUpload-8580ccfc.js";
import "../../../../modules/project-visa-select-e1b3658e.js";
import "../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const K = { class: "app-container" }, W = { __name: "index", setup(X) {
  const y = T(), { globalProjectId: h, globalProject: Y } = M(["globalProjectId", "globalProject"]), x = { add: false, edit: false, del: false, download: false }, _ = u(), k = u(), c = u(false), { crud: m, columns: n } = q({ title: "签证管理", sort: ["id.desc"], permission: { ...i }, optShow: { ...x }, requiredQuery: [], crudApi: { ...F }, hasPagination: true }, _), V = u([["mode", ["parse-enum", G]]]), { maxHeight: N } = O({ paginate: true, extraHeight: 40 });
  async function P() {
    m.toQuery(), await y.dispatch("approval_list/fetchApprovalNum");
  }
  return (Z, p) => {
    const D = g("common-button"), o = S, j = B, C = g("common-table"), R = H;
    return t(), E("div", K, [l(e(z), { projectId: e(h) }, { createBtn: d(() => [e(w)(e(i).add) ? (t(), a(D, { key: 0, size: "default", icon: "el-icon-plus", type: "primary", class: "filter-item", onClick: p[0] || (p[0] = (s) => c.value = true) }, { default: d(() => p[2] || (p[2] = [v(" 创建签证 ")])), _: 1, __: [2] })) : r("", true)]), _: 1 }, 8, ["projectId"]), I((t(), a(C, { ref_key: "tableRef", ref: _, data: e(m).data, "data-format": V.value, "empty-text": e(m).emptyText, "max-height": e(N), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: d(() => [l(o, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(n).visible("mode") ? (t(), a(o, { key: "mode", prop: "mode", label: "类别", align: "center", "show-overflow-tooltip": true })) : r("", true), e(n).visible("serialNumber") ? (t(), a(o, { key: "serialNumber", prop: "serialNumber", label: "签证编号", align: "center", "show-overflow-tooltip": true })) : r("", true), e(n).visible("recipients") ? (t(), a(o, { key: "recipients", prop: "recipients", label: "单位", align: "center", "show-overflow-tooltip": true })) : r("", true), e(n).visible("reasonName") ? (t(), a(o, { key: "reasonName", prop: "reasonName", label: "事由", align: "center", "show-overflow-tooltip": true })) : r("", true), e(n).visible("amount") ? (t(), a(o, { key: "amount", prop: "amount", label: "费用（元）", align: "center", "show-overflow-tooltip": true })) : r("", true), e(n).visible("status") ? (t(), a(o, { key: "status", prop: "status", label: "审批状态", align: "center", "show-overflow-tooltip": true }, { default: d((s) => {
      var b;
      return [l(j, { type: (b = e(f).V[s.row.status]) == null ? void 0 : b.T, effect: "light" }, { default: d(() => [v(A(e(f).VL[s.row.status]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : r("", true), e(w)([...e(i).detail, ...e(i).del]) ? (t(), a(o, { key: 6, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: d((s) => [l(Q, { data: { id: s.row.id }, permission: e(i), showDel: true, showEdit: false, disabledDel: s.row.status === e(f).IN_APPROVAL.V, "show-detail": "" }, null, 8, ["data", "permission", "disabledDel"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[R, e(m).loading]]), l(e(U)), l(J, { modelValue: c.value, "onUpdate:modelValue": p[1] || (p[1] = (s) => c.value = s), permission: e(i), onSuccess: P }, null, 8, ["modelValue", "permission"]), l($, { ref_key: "detailRef", ref: k, permission: e(i) }, null, 8, ["permission"])]);
  };
} }, pe = L(W, [["__scopeId", "data-v-317636e6"]]);
export {
  pe as default
};
