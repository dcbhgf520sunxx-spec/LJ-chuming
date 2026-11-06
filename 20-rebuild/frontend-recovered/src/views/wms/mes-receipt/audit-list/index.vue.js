import { ref as u } from "vue";
import { useStore as S } from "vuex";
import { watch as C } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as i } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as B } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as V } from "element-plus";
import { vLoading as W } from "element-plus";
import { x as E, Bn as _, Bo as P, o as H, w5 as g, G as M, an as O, P as G, Bp as K } from "../../../../shared/runtime.js";
import U from "./module/header.vue.js";
const q = { class: "app-container" }, J = { __name: "index", setup(F) {
  const k = { batchAdd: false, add: false, edit: false, del: false, download: false }, v = u([]), h = u(), N = u([["projectList", ["parse-project"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]]]), { CRUD: y, crud: n, columns: r } = E({ title: "排产出库审核列表", sort: ["id.desc"], permission: { ..._ }, optShow: { ...k }, crudApi: { ...P } }, h), x = S();
  C(() => x.state.approval_list.approvalNum, async (w) => {
    n.refresh();
  });
  const { maxHeight: L } = H({ paginate: true });
  return y.HOOK.handleRefresh = (w, { data: f }) => {
    f.content.map((t) => {
      var p, m, c;
      t.mesWorkshopListName = (p = t.mesWorkshopList.map((o) => o.name)) == null ? void 0 : p.join("、"), t.outboundListName = (m = t.outboundList.map((o) => o.serialNumber)) == null ? void 0 : m.join("、"), t.pickingListName = (c = t.pickingList.map((o) => o.serialNumber)) == null ? void 0 : c.join("、");
    });
  }, (w, f) => {
    const t = A, p = V, m = j("common-table"), c = W;
    return a(), R("div", q, [l(e(U)), T((a(), i(m, { ref_key: "tableRef", ref: h, data: e(n).data, "data-format": N.value, "default-expand-all": false, "empty-text": e(n).emptyText, "expand-row-keys": v.value, "max-height": e(L), "row-key": "id", onSortChange: e(n).handleSortChange }, { default: d(() => [l(t, { align: "center", label: "序号", type: "index", width: "60" }), e(r).visible("serialNumber") ? (a(), i(t, { key: "serialNumber", label: "办理单号", "min-width": "120", prop: "serialNumber", "show-overflow-tooltip": "" })) : s("", true), e(r).visible("mesWorkshopListName") ? (a(), i(t, { key: "mesWorkshopListName", label: "关联车间", "min-width": "120", prop: "mesWorkshopListName", "show-overflow-tooltip": "" })) : s("", true), e(r).visible("projectList") ? (a(), i(t, { key: "projectList", label: "关联项目", "min-width": "170", prop: "projectList", "show-overflow-tooltip": "" })) : s("", true), e(r).visible("outboundListName") ? (a(), i(t, { key: "outboundListName", label: "关联出库单", "min-width": "150", prop: "outboundListName", "show-overflow-tooltip": "" })) : s("", true), e(r).visible("pickingListName") ? (a(), i(t, { key: "pickingListName", label: "关联领料单工单号", "min-width": "150", prop: "pickingListName", "show-overflow-tooltip": "" })) : s("", true), e(r).visible("createTime") ? (a(), i(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建时间", prop: "createTime", width: "160" })) : s("", true), e(r).visible("applicantName") ? (a(), i(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", prop: "applicantName", width: "160" })) : s("", true), e(r).visible("reviewStatus") ? (a(), i(t, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "审核状态", prop: "reviewStatus", width: "80" }, { default: d(({ row: { sourceRow: o } }) => {
      var b;
      return [l(p, { type: (b = e(g).V[o.reviewStatus]) == null ? void 0 : b.TAG }, { default: d(() => [D(B(e(g).VL[o.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : s("", true), e(M)(e(_).detail) ? (a(), i(t, { key: 8, align: "left", fixed: "right", label: "操作", width: "120px" }, { default: d(({ row: o }) => [l(O, { data: o, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height", "onSortChange"])), [[c, e(n).loading]]), l(e(G)), l(K)]);
  };
} };
export {
  J as default
};
