import { ref as v } from "vue";
import { useStore as D } from "vuex";
import { watch as P } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as c } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as s } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElTag as I } from "element-plus";
import { vLoading as j } from "element-plus";
import { _ as E, m as M, uv as O, x as F, A6 as G, A7 as H, o as K, zB as q, aR as z, w5 as b, an as L, P as $, A8 as J, A9 as Q } from "../../../../../../shared/runtime.js";
import W from "./module/header.vue.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
const X = { class: "app-container" }, Y = { key: 0 }, Z = { __name: "index", setup(ee) {
  const x = { add: false, edit: false, del: false, download: false }, h = v([]), _ = v(), y = D(), { user: S } = M(["user"]), T = v([...O, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { crud: u, columns: i, CRUD: C } = F({ title: "制成品入库记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "licensePlate", "shipmentNumber"], permission: { ...G }, optShow: { ...x }, crudApi: { ...H } }, _), { maxHeight: R } = K({ paginate: true });
  return C.HOOK.handleRefresh = async (g, { data: r }) => {
    r.content = r.content.map((t) => {
      var d;
      return t.imgUrls = ((d = t.attachments) == null ? void 0 : d.map((m) => m.imageUrl)) || [], t;
    });
  }, P(() => y.state.approval_list.approvalNum, async (g) => {
    u.refresh(), await y.dispatch("approval_list/fetchApprovalNum", q.INBOUND.V);
  }), (g, r) => {
    const t = B, d = N("table-cell-tag"), m = I, A = N("common-table"), U = j;
    return a(), k("div", X, [n(e(W)), V((a(), l(A, { ref_key: "tableRef", ref: _, data: e(u).data, "data-format": T.value, "max-height": e(R), "default-expand-all": false, "expand-row-keys": h.value, "row-key": "id" }, { default: p(() => [n(z, { data: e(u).data, "expand-row-keys": h.value, "onUpdate:expandRowKeys": r[0] || (r[0] = (o) => h.value = o), "row-key": "id" }, { default: p(({ row: o }) => [c("p", null, [r[1] || (r[1] = w(" 关联项目：")), c("span", null, f(o.projectsFullName), 1)]), c("p", null, [r[2] || (r[2] = w(" 审批意见：")), c("span", null, f(o.approvalComments), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), n(t, { label: "序号", type: "index", align: "center", width: "60" }), e(i).visible("purchaseSN") ? (a(), l(t, { key: "purchaseSN", "show-overflow-tooltip": true, prop: "purchaseSN", label: "采购合同编号", "min-width": "155" }, { default: p(({ row: { sourceRow: o } }) => [n(d, { show: !!o.boolPartyA && !!o.purchaseSN, name: "甲供", type: "partyA", offset: 10 }, null, 8, ["show"]), o.purchaseSN ? (a(), k("span", Y, f(o.purchaseSN), 1)) : (a(), l(m, { key: 1, type: "danger", effect: "dark", size: "default" }, { default: p(() => r[3] || (r[3] = [w("甲供")])), _: 1, __: [3] }))]), _: 1 })) : s("", true), e(i).visible("serialNumber") ? (a(), l(t, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "160", label: "入库单号", align: "left" })) : s("", true), e(i).visible("licensePlate") ? (a(), l(t, { key: "licensePlate", "show-overflow-tooltip": true, prop: "licensePlate", label: "车牌/船牌号", align: "left", width: "100" })) : s("", true), e(i).visible("shipmentNumber") ? (a(), l(t, { key: "shipmentNumber", prop: "shipmentNumber", label: "物流单号", align: "left", "min-width": "150", "show-overflow-tooltip": "" })) : s("", true), e(i).visible("basicClass") ? (a(), l(t, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "120" })) : s("", true), e(i).visible("projects") ? (a(), l(t, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : s("", true), e(i).visible("supplier.name") ? (a(), l(t, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "200" })) : s("", true), e(i).visible("applicantName") ? (a(), l(t, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", "min-width": "100" })) : s("", true), e(i).visible("editorName") ? (a(), l(t, { key: "editorName", "show-overflow-tooltip": true, prop: "editorName", label: "编辑人", align: "center", "min-width": "100" })) : s("", true), e(i).visible("reviewerName") ? (a(), l(t, { key: "reviewerName", "show-overflow-tooltip": true, prop: "reviewerName", label: "审核人", align: "center", "min-width": "100" })) : s("", true), e(i).visible("createTime") ? (a(), l(t, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" })) : s("", true), e(i).visible("userUpdateTime") ? (a(), l(t, { key: "userUpdateTime", "show-overflow-tooltip": true, prop: "userUpdateTime", label: "编辑时间", align: "center", width: "140" })) : s("", true), e(i).visible("reviewTime") ? (a(), l(t, { key: "reviewTime", "show-overflow-tooltip": true, prop: "reviewTime", label: "审核时间", align: "center", width: "140" })) : s("", true), e(i).visible("reviewStatus") ? (a(), l(t, { key: "reviewStatus", "show-overflow-tooltip": true, prop: "reviewStatus", label: "审核状态", align: "center", width: "80", fixed: "right" }, { default: p(({ row: o }) => [n(m, { type: e(b).V[o.reviewStatus].TAG }, { default: p(() => [w(f(e(b).VL[o.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), n(t, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: p(({ row: { sourceRow: o } }) => [n(L, { "show-edit": o.reviewStatus === e(b).AUDITING.V && e(S).id === o.applicantId, "show-del": false, data: o, "show-detail": "" }, null, 8, ["show-edit", "data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[U, e(u).loading]]), n(e($)), n(J), n(Q)]);
  };
} }, ie = E(Z, [["__scopeId", "data-v-e668f1f9"]]);
export {
  ie as default
};
