import { ref as d } from "vue";
import { useStore as S } from "vuex";
import { watch as C } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as o } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as B } from "vue";
import { ElTableColumn as V } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as E } from "element-plus";
import { cP as P, x as H, Br as b, Bs as M, o as O, w5 as v, G, an as K, P as U, Bt as q } from "../../../../shared/runtime.js";
import F from "./module/header.vue.js";
const $ = { class: "app-container" }, W = { __name: "index", setup(z) {
  const _ = { batchAdd: false, add: false, edit: false, del: false, download: false }, y = d([]), u = d(), g = d([["project", ["parse-project"]], ["projectList", ["parse-project"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["materialType", ["parse-enum", P]]]), { CRUD: x, crud: s, columns: l } = H({ title: "配套件出库冻结审核列表", sort: ["id.desc"], permission: { ...b }, optShow: { ..._ }, crudApi: { ...M }, invisibleColumns: [] }, u), k = S();
  C(() => k.state.approval_list.approvalNum, async (w) => {
    s.refresh();
  });
  const { maxHeight: N } = O({ paginate: true });
  return x.HOOK.handleRefresh = (w, { data: h }) => {
    h.content.map((t) => {
      var n;
      t.outboundListName = (n = t.outboundList.map((m) => m.serialNumber)) == null ? void 0 : n.join("、");
    });
  }, (w, h) => {
    const t = V, n = A, m = j("common-table"), T = E;
    return a(), R("div", $, [r(e(F)), L((a(), o(m, { ref_key: "tableRef", ref: u, data: e(s).data, "data-format": g.value, "default-expand-all": false, "empty-text": e(s).emptyText, "expand-row-keys": y.value, "max-height": e(N), "row-key": "id", onSortChange: e(s).handleSortChange }, { default: c(() => [r(t, { align: "center", label: "序号", type: "index", width: "60" }), e(l).visible("serialNumber") ? (a(), o(t, { key: "serialNumber", label: "办理单号", "min-width": "120", prop: "serialNumber", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("outboundListName") ? (a(), o(t, { key: "outboundListName", label: "关联出库单", "min-width": "150", prop: "outboundListName", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("materialType") ? (a(), o(t, { key: "materialType", label: "物料类型", "min-width": "120", prop: "materialType", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("project") ? (a(), o(t, { key: "project", label: "领用项目", "min-width": "150", prop: "project", "show-overflow-tooltip": "" })) : i("", true), e(l).visible("applicantName") ? (a(), o(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", prop: "applicantName", width: "100" })) : i("", true), e(l).visible("createTime") ? (a(), o(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "150" })) : i("", true), e(l).visible("applicantName") ? (a(), o(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "审核人", prop: "applicantName", width: "100" })) : i("", true), e(l).visible("createTime") ? (a(), o(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "createTime", width: "150" })) : i("", true), e(l).visible("reviewStatus") ? (a(), o(t, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "审核状态", prop: "reviewStatus", width: "80" }, { default: c(({ row: { sourceRow: p } }) => {
      var f;
      return [r(n, { type: (f = e(v).V[p.reviewStatus]) == null ? void 0 : f.TAG }, { default: c(() => [D(B(e(v).VL[p.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), e(G)(e(b).detail) ? (a(), o(t, { key: 9, align: "left", fixed: "right", label: "操作", width: "120px" }, { default: c(({ row: p }) => [r(K, { data: p, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSortChange"])), [[T, e(s).loading]]), r(e(U)), r(q)]);
  };
} };
export {
  W as default
};
