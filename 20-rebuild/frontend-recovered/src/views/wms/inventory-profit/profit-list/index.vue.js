import { useStore as R } from "vuex";
import { ref as g } from "vue";
import { computed as P } from "vue";
import { watch as j } from "vue";
import { onMounted as H } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as M } from "vue";
import { unref as e } from "vue";
import { createBlock as i } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTag as B } from "element-plus";
import { vLoading as L } from "element-plus";
import { hg as O, tX as _, x as F, xI as d, xJ as I, o as $, bv as q, cP as G, G as K, an as Y, P as z, xK as J, ba as Q, D as T } from "../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import W from "./module/form.vue.js";
import "../../../supply-chain/components/audit-records.vue.js";
import "./module/components/inventory-surplus-list/index.vue.js";
import "./module/components/inventory-surplus-list/module/list.vue.js";
import "./module/components/application/steel/index.vue.js";
import "./module/components/application/steel/module/steel-plate-table.vue.js";
import "./module/components/application/price-set-columns.vue.js";
import "../../../../modules/supplier-select-0ce6adf5.js";
import "./module/components/application/steel/module/section-steel-table.vue.js";
import "./module/components/application/steel/module/steel-coil-table.vue.js";
import "./module/components/application/other/module/other-steel-material-table.vue.js";
import "./module/components/application/other/index.vue.js";
import "./module/components/application/other/module/other-table.vue.js";
import "./module/components/application/other/module/auxiliary-material-table.vue.js";
import "./module/components/application/other/module/gas-table.vue.js";
import "./module/components/submit-preview.vue.js";
const Z = { class: "app-container" }, _e = { __name: "index", setup(ee) {
  const f = R(), x = { add: true, edit: false, del: false, download: false }, w = g(), h = g(), S = P(() => [["projects", ["parse-project"]], ["deficitType", ["parse-enum", O]], ["createTime", ["parse-time"]], ["reviewTime", ["parse-time"]], ["reviewStatusTag", ["parse-enum", _, { f: "TAG" }], { source: "reviewStatus" }], ["reviewStatus", ["parse-enum", _]]]), { CRUD: k, crud: p, columns: l } = F({ title: "盘盈", sort: ["id.desc"], invisibleColumns: [], permission: { ...d }, optShow: { ...x }, crudApi: I }, w), { maxHeight: C } = $({ paginate: true });
  function N(n) {
    return Q(n, { props: ["quantity", "mete", ["amount", T.YUAN], ["amountExcludingVAT", T.YUAN]], toThousandFields: ["amount", "amountExcludingVAT"] });
  }
  return k.HOOK.handleRefresh = async (n, { data: u }) => {
    u.content.map((t) => {
      const c = q.getBits(G.ENUM, t.basicClass, "L");
      t.typeText = c.join(" | ");
    });
  }, j(() => f.state.approval_list.isRefresh, (n) => {
    n && p.toQuery();
  }, { deep: true }), H(async () => {
    await f.dispatch("wms/fetchSteelDensityCfg");
  }), (n, u) => {
    const t = U, c = v("table-cell-tag"), E = B, A = v("common-table"), D = L;
    return a(), V("div", Z, [o(X, { ref_key: "mHeaderRef", ref: h }, null, 512), M((a(), i(A, { ref_key: "tableRef", ref: w, data: e(p).data, "data-format": S.value, "max-height": e(C), "summary-method": N, "highlight-current-row": "", "row-key": "id", "show-summary": "", onSelectionChange: e(p).selectionChangeHandler }, { default: m(() => [o(t, { align: "center", fixed: "left", type: "selection", width: "55" }), o(t, { align: "center", label: "序号", type: "index", width: "60" }), e(l).visible("serialNumber") ? (a(), i(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "盘盈单号", "min-width": "100", prop: "serialNumber" }, { default: m(({ row: r }) => [o(c, { show: !!r.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), b(" " + y(r.serialNumber), 1)]), _: 1 })) : s("", true), e(l).visible("typeText") ? (a(), i(t, { key: "typeText", "show-overflow-tooltip": true, align: "left", label: "物料种类", "min-width": "100", prop: "typeText" })) : s("", true), e(l).visible("projects") ? (a(), i(t, { key: "projects", "show-overflow-tooltip": true, align: "left", label: "关联项目", "min-width": "100", prop: "projects" })) : s("", true), e(l).visible("createTime") ? (a(), i(t, { key: "createTime", "show-overflow-tooltip": true, align: "left", label: "申请时间", prop: "createTime", width: "150" })) : s("", true), e(l).visible("applicantName") ? (a(), i(t, { key: "applicantName", "show-overflow-tooltip": true, align: "left", label: "申请人", "min-width": "100", prop: "applicantName" })) : s("", true), e(l).visible("reviewStatus") ? (a(), i(t, { key: "reviewStatus", align: "center", label: "审批状态", "show-overflow-tooltip": "", width: "90" }, { default: m(({ row: r }) => [o(E, { type: r.reviewStatusTag, effect: "plain", size: "default" }, { default: m(() => [b(y(r.reviewStatus), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), e(l).visible("reviewTime") ? (a(), i(t, { key: "reviewTime", "show-overflow-tooltip": true, align: "left", label: "审核通过时间", prop: "reviewTime", width: "150" })) : s("", true), e(K)([...e(d).detail]) ? (a(), i(t, { key: 7, align: "center", fixed: "right", label: "操作", width: "70" }, { default: m(({ row: { sourceRow: r } }) => [o(Y, { data: { id: r.id }, permission: e(d), "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data", "permission"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "max-height", "onSelectionChange"])), [[D, e(p).loading]]), o(e(z)), o(W, { onHandleSuccess: u[0] || (u[0] = (r) => h.value.handleInventorySurplusList()) }), o(J)]);
  };
} };
export {
  _e as default
};
