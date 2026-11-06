import { ref as _ } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as s } from "vue";
import { unref as a } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as u } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElTooltip as A } from "element-plus";
import { ElTag as H } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as M, uv as P, zd as K, x as $, zj as F, zg as q, o as G, i as v, z as J, aR as Q, zh as X, xP as Y, ib as C, an as Z, P as ee, zk as te } from "../../../../../shared/runtime.js";
import ae from "./module/header.vue.js";
import oe from "./module/review.vue.js";
import "../../../../../modules/workshop-select-210dd661.js";
import "../../../../../modules/review-convenient-operate-8438d44b.js";
import "../../../../../modules/review-confirm-button-aa3600ad.js";
const re = { class: "app-container" }, ie = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, se = { __name: "index", setup(ne) {
  const T = { add: false, edit: false, del: false, download: false }, g = _(), j = _([...P, ["approvalComments", "empty-text"], ["transferType", ["parse-enum", K]], ["borrowProject", ["parse-project", { onlyShortName: true }]], ["[source].project", ["parse-project", { onlyShortName: true }]], ["direction.project", ["parse-project", { onlyShortName: true }]], ["reviewEndTime", ["parse-time"]]]), { CRUD: E, crud: h, columns: d } = $({ title: "移库审核", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...F }, optShow: { ...T }, crudApi: { ...q } }, g), R = _({}), k = _(false), b = _([]), { maxHeight: W } = G({ paginate: true });
  function L(w) {
    var m;
    const p = (m = w.directionWorkshop) == null ? void 0 : m.name, t = w.directionWarehouse ? w.directionWarehouse.name : w.directionWarehouseName;
    return p ? p + "【" + t + "】" : t;
  }
  return E.HOOK.handleRefresh = (w, { data: p }) => {
    p.content.forEach((t) => {
      const m = [];
      if (v(t.sourceWorkshopList) && (t.sourceWorkshopList.forEach((r) => {
        r.workshopStr = "";
        let c = [];
        v(r.nameInfos) && r.nameInfos.forEach((y) => {
          c.push(y.name);
        }), v(c) && (c = Array.from(new Set(c)), r.workshopStr = r.name + "(" + c.join("、") + ")"), m.push(r.workshopStr);
      }), t.sourceStr = m.join(" / ")), v(t.projectList)) {
        let r = [];
        t.projectList.forEach((c) => {
          r.push(J(c));
        }), r = Array.from(new Set(r)), t.projectListStr = r.join(" / ");
      }
    });
  }, (w, p) => {
    const t = O, m = S("table-cell-tag"), r = A, c = H, y = S("common-table"), D = U("parse-time"), V = I;
    return o(), B("div", re, [s(a(ae)), x((o(), i(y, { ref_key: "tableRef", ref: g, data: a(h).data, "data-format": j.value, "default-expand-all": false, "expand-row-keys": b.value, "max-height": a(W), "row-key": "id", onSortChange: a(h).handleSortChange, onSelectionChange: a(h).selectionChangeHandler }, { default: n(() => [s(Q, { "expand-row-keys": b.value, "onUpdate:expandRowKeys": p[0] || (p[0] = (e) => b.value = e), data: a(h).data, "row-key": "id" }, { default: n(({ row: e }) => [u("p", null, [p[2] || (p[2] = N(" 审批意见：")), u("span", null, f(e.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(t, { align: "center", type: "selection", width: "55" }), s(t, { align: "center", label: "序号", type: "index", width: "60" }, { default: n(({ row: e, $index: z }) => [e.transferCreateType === a(X).OUTBOUND.V ? (o(), i(m, { key: 0, name: "出库", type: "transferOutbound" })) : l("", true), u("span", null, f(z + 1), 1)]), _: 1 }), a(d).visible("serialNumber") ? (o(), i(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "移库单号", prop: "serialNumber", width: "160" }, { default: n(({ row: e }) => [e.boolHasUnfreeze ? (o(), i(m, { key: 0, offset: 15, name: "解冻", type: "unfreeze" })) : l("", true), u("span", null, f(e.serialNumber), 1)]), _: 1 })) : l("", true), a(d).visible("basicClass") ? (o(), i(t, { key: "basicClass", "show-overflow-tooltip": true, align: "center", label: "物料种类", prop: "basicClass", width: "100" })) : l("", true), a(d).visible("sourceStr") ? (o(), i(t, { key: "sourceStr", label: "来源", "min-width": "240", prop: "sourceStr", "show-overflow-tooltip": "" }, { default: n(({ row: e }) => [u("span", null, f(e.sourceStr || "-"), 1)]), _: 1 })) : l("", true), a(d).visible("directionWarehouse") ? (o(), i(t, { key: "directionWarehouse", label: "目的", "min-width": "150", prop: "directionWarehouse" }, { default: n(({ row: e }) => [u("div", ie, [s(Y, { id: e.directionWorkshop ? e.directionWorkshop.id : e.directionWorkshopId }, null, 8, ["id"]), s(r, { content: L(e), class: "item", effect: "dark", placement: "top-start" }, { default: n(() => [u("span", null, f(e.directionWarehouse ? e.directionWarehouse.name : e.directionWarehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 })) : l("", true), a(d).visible("projectListStr") ? (o(), i(t, { key: "projectListStr", "show-overflow-tooltip": true, align: "center", label: "关联项目", "min-width": "170", prop: "projectListStr" }, { default: n(({ row: e }) => [u("span", null, f(e.projectListStr || "-"), 1)]), _: 1 })) : l("", true), a(d).visible("applicantName") ? (o(), i(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", prop: "applicantName", width: "110" })) : l("", true), a(d).visible("reviewerNames") ? (o(), i(t, { key: "reviewerNames", "show-overflow-tooltip": true, align: "center", label: "审核人", prop: "reviewerNames", width: "110" })) : l("", true), a(d).visible("createTime") ? (o(), i(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" }, { default: n(({ row: e }) => [x(u("span", null, null, 512), [[D, e.createTime]])]), _: 1 })) : l("", true), a(d).visible("reviewEndTime") ? (o(), i(t, { key: "reviewEndTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewEndTime", width: "140" })) : l("", true), a(d).visible("reviewStatus") ? (o(), i(t, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "状态", prop: "reviewStatus", width: "80" }, { default: n(({ row: e }) => [s(c, { type: a(C).V[e.reviewStatus].TAG }, { default: n(() => [N(f(a(C).VL[e.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : l("", true), s(t, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: n(({ row: e }) => [s(Z, { data: e, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[V, a(h).loading]]), s(a(ee)), s(te), s(oe, { visible: k.value, "onUpdate:visible": p[1] || (p[1] = (e) => k.value = e), data: R.value, onRefresh: a(h).refresh }, null, 8, ["visible", "data", "onRefresh"])]);
  };
} }, he = M(se, [["__scopeId", "data-v-ad65de8b"]]);
export {
  he as default
};
