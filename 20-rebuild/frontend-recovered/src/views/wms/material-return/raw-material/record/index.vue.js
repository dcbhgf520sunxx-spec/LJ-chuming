import { ref as f } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as o } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as A } from "element-plus";
import { uv as B, x as P, AT as j, AU as M, o as F, aR as G, ux as x, gG as c, xs as y, kD as $, ib as N, an as H, P as K, AV as W, AW as q } from "../../../../../shared/runtime.js";
import I from "./module/header.vue.js";
import "../../../../../modules/warehouse-project-cascader-17e2b952.js";
const z = { class: "app-container" }, te = { __name: "index", setup(J) {
  const T = { add: false, edit: false, del: false, download: false }, b = f([]), h = f(), S = f([...B, ["approvalComments", "empty-text"]]), { crud: v, columns: l } = P({ title: "退库记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...j }, optShow: { ...T }, crudApi: { ...M } }, h), { maxHeight: V } = F({ paginate: true });
  return (Q, n) => {
    const C = k("table-cell-tag"), i = L, _ = O, R = k("common-table"), U = A;
    return a(), D("div", z, [s(e(I)), E((a(), o(R, { ref_key: "tableRef", ref: h, data: e(v).data, "data-format": S.value, "default-expand-all": false, "expand-row-keys": b.value, "max-height": e(V), "row-key": "id" }, { default: p(() => [s(G, { "expand-row-keys": b.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (t) => b.value = t), data: e(v).data, "row-key": "id" }, { default: p(({ row: t }) => [u("p", null, [n[1] || (n[1] = d(" 关联项目：")), u("span", null, m(t.projectsFullName), 1)]), u("p", null, [n[2] || (n[2] = d(" 关联出库单： ")), s(e(x), { receipt: t.outboundList, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), u("p", null, [n[3] || (n[3] = d(" 审批意见：")), u("span", null, m(t.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(i, { align: "center", label: "序号", type: "index", width: "60" }, { default: p(({ row: t, $index: w }) => {
      var g;
      return [s(C, { color: (g = e(c).V[t.outboundTypeSelection]) == null ? void 0 : g.COLOR, name: e(c).VL[t.outboundTypeSelection] }, null, 8, ["color", "name"]), u("span", null, m(w + 1), 1)];
    }), _: 1 }), e(l).visible("serialNumber") ? (a(), o(i, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "退库单号", "min-width": "160", prop: "serialNumber" })) : r("", true), e(l).visible("basicClass") ? (a(), o(i, { key: "basicClass", "show-overflow-tooltip": true, align: "center", label: "物料种类", prop: "basicClass", width: "80" })) : r("", true), e(l).visible("projects") ? (a(), o(i, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : r("", true), e(l).visible("outboundSNList") ? (a(), o(i, { key: "outboundSNList", "show-overflow-tooltip": true, label: "关联出库单", "min-width": "155", prop: "outboundSNList" }, { default: p(({ row: t }) => [s(e(x), { receipt: t.outboundList, "receipt-types": ["OUTBOUND"] }, null, 8, ["receipt"])]), _: 1 })) : r("", true), e(l).visible("applicantName") ? (a(), o(i, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : r("", true), e(l).visible("editorName") ? (a(), o(i, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : r("", true), e(l).visible("reviewerName") ? (a(), o(i, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : r("", true), e(l).visible("createTime") ? (a(), o(i, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建时间", prop: "createTime", width: "140" })) : r("", true), e(l).visible("userUpdateTime") ? (a(), o(i, { key: "userUpdateTime", "show-overflow-tooltip": true, align: "center", label: "编辑时间", prop: "userUpdateTime", width: "140" })) : r("", true), e(l).visible("reviewTime") ? (a(), o(i, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : r("", true), e(l).visible("reviewStatus") ? (a(), o(i, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "状态", prop: "reviewStatus" }, { default: p(({ row: t }) => {
      var w;
      return [t.outboundTypeSelection === e(c).PRODUCE.V ? (a(), o(_, { key: 0, type: (w = e(y).V[t.reviewStatus]) == null ? void 0 : w.TAG }, { default: p(() => [d(m(e(y).VL[t.reviewStatus] || e($).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])) : (a(), o(_, { key: 1, type: e(N).V[t.reviewStatus].TAG }, { default: p(() => [d(m(e(N).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"]))];
    }), _: 1 })) : r("", true), s(i, { align: "left", fixed: "right", label: "操作", width: "120px" }, { default: p(({ row: t }) => [s(H, { data: t, "disabled-del": t.outboundTypeSelection === e(c).PRODUCE.V && t.reviewStatus !== e(y).UNREVIEWED.V, "disabled-edit": !t.editable, "show-del": false, "show-edit": t.outboundTypeSelection === e(c).PRODUCE.V, "show-detail": "" }, null, 8, ["data", "disabled-del", "disabled-edit", "show-edit"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[U, e(v).loading]]), s(e(K)), s(W), s(q)]);
  };
} };
export {
  te as default
};
