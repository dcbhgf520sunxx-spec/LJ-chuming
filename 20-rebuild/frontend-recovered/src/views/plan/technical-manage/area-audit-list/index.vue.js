import { ref as v } from "vue";
import { computed as B } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as D } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as a } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as U } from "vue";
import { toDisplayString as S } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as M } from "../../../../modules/area-audit-list-39a1a7c7.js";
import { _ as O, m as $, x as q, m9 as h, o as z, P as F } from "../../../../shared/runtime.js";
import { v as g } from "../../../../modules/plan-d12d7ccf.js";
import G from "./module/header.vue.js";
import K from "./module/detail.vue.js";
import "../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const Q = { class: "app-container" }, J = { class: "head-container" }, W = { __name: "index", setup(X) {
  const { globalProjectId: y } = $(["globalProject", "globalProjectId"]), x = { add: false, edit: false, del: false, download: false }, f = v(), w = v({}), p = v(false), { crud: m, columns: r, CRUD: R } = q({ title: "构件变更记录", sort: [], permission: { ...g }, optShow: { ...x }, crudApi: { ...M }, invisibleColumns: [""], hasPagination: true }, f), k = B(() => [["projectInfo", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["reviewedTime", ["parse-time", "{y}-{m}-{d}"]], ["inventoryReviewedEnum", ["parse-enum", h]]]), { maxHeight: T } = z({ wrapperBox: ".artifactChangeLog", paginate: true, extraHeight: 40 });
  R.HOOK.handleRefresh = (s, { data: d }) => {
  };
  function j(s) {
    w.value = s == null ? void 0 : s.sourceRow, p.value = true;
  }
  return (s, d) => {
    const t = H, C = A, E = b("common-button"), N = b("common-table"), V = L;
    return o(), D("div", Q, [I("div", J, [n(e(G), { "project-id": e(y) }, null, 8, ["project-id"])]), P((o(), a(N, { ref_key: "tableRef", ref: f, data: e(m).data, "data-format": k.value, "empty-text": e(m).emptyText, "max-height": e(T), style: { width: "100%" } }, { default: c(() => [n(t, { align: "center", label: "序号", prop: "index", type: "index", width: "60" }), e(r).visible("projectInfo") ? (o(), a(t, { key: "projectInfo", "show-overflow-tooltip": true, align: "left", label: "项目", "min-width": "140", prop: "projectInfo" })) : i("", true), e(r).visible("monomer.name") ? (o(), a(t, { key: "monomer.name", "show-overflow-tooltip": true, align: "left", label: "单体", prop: "monomer.name" })) : i("", true), e(r).visible("area.name") ? (o(), a(t, { key: "area.name", "show-overflow-tooltip": true, align: "left", label: "区域", prop: "area.name" })) : i("", true), e(r).visible("areaBatch.name") ? (o(), a(t, { key: "areaBatch.name", "show-overflow-tooltip": true, align: "left", label: "批次号", prop: "areaBatch.name" })) : i("", true), e(r).visible("createUserName") ? (o(), a(t, { key: "createUserName", "show-overflow-tooltip": true, align: "center", label: "创建人", prop: "createUserName" })) : i("", true), e(r).visible("createTime") ? (o(), a(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建日期", prop: "createTime" })) : i("", true), e(r).visible("reviewedName") ? (o(), a(t, { key: "reviewedName", "show-overflow-tooltip": true, align: "center", label: "审核人", prop: "reviewedName" })) : i("", true), e(r).visible("reviewedTime") ? (o(), a(t, { key: "reviewedTime", "show-overflow-tooltip": true, align: "center", label: "审核日期", prop: "reviewedTime" })) : i("", true), e(r).visible("inventoryReviewedEnum") ? (o(), a(t, { key: "inventoryReviewedEnum", "show-overflow-tooltip": true, align: "center", label: "状态", prop: "inventoryReviewedEnum", width: "100" }, { default: c((l) => {
      var u, _;
      return [n(C, { type: (_ = e(h).V[(u = l.row.sourceRow) == null ? void 0 : u.inventoryReviewedEnum]) == null ? void 0 : _.T }, { default: c(() => [U(S(l.row.inventoryReviewedEnum), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), n(t, { align: "center", fixed: "right", label: "操作", width: "120" }, { default: c((l) => [n(E, { icon: "el-icon-view", size: "default", type: "primary", onClick: (u) => j(l.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[V, e(m).loading]]), n(e(F)), n(e(K), { modelValue: p.value, "onUpdate:modelValue": d[0] || (d[0] = (l) => p.value = l), currentRow: w.value, permission: e(g), onSuccess: e(m).toQuery }, null, 8, ["modelValue", "currentRow", "permission", "onSuccess"])]);
  };
} }, ue = O(W, [["__scopeId", "data-v-e54ebc13"]]);
export {
  ue as default
};
