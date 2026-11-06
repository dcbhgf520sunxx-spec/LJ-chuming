import { useRoute as P } from "vue-router";
import { ref as v } from "vue";
import { computed as M } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as H } from "vue";
import { createVNode as c } from "vue";
import { unref as a } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as f } from "vue";
import { createTextVNode as I } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTooltip as B } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as F } from "element-plus";
import { _ as G, uv as K, zd as $, jZ as q, ze as Z, zf as J, x as Q, zg as X, o as Y, ib as g, G as ee, i as _, z as te, zh as ae, xP as oe, an as re, P as se, zi as ie } from "../../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import "../../../../../modules/workshop-select-210dd661.js";
const le = { class: "app-container" }, ce = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, pe = { __name: "index", setup(de) {
  const b = P(), C = { add: false, edit: false, del: false, download: false }, S = v(), T = v(), E = v([...K, ["approvalComments", "empty-text"], ["transferType", ["parse-enum", $]], ["borrowProject", ["parse-project", { onlyShortName: true }]], ["[source].project", ["parse-project", { onlyShortName: true }]], ["direction.project", ["parse-project", { onlyShortName: true }]], ["reviewEndTime", ["parse-time"]]]), k = M(() => {
    var p;
    return ((p = b == null ? void 0 : b.meta) == null ? void 0 : p.boolPartyA) === q.SELF.V ? Z : J;
  });
  function j(p) {
    var d;
    const h = (d = p.directionWorkshop) == null ? void 0 : d.name, e = p.directionWarehouse ? p.directionWarehouse.name : p.directionWarehouseName;
    return h ? h + "【" + e + "】" : e;
  }
  const { CRUD: W, crud: w, columns: l } = Q({ title: "移库审核", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime"], permission: { ...k.value }, optShow: { ...C }, crudApi: { ...X } }, S), R = v([]), { maxHeight: L } = Y({ paginate: true });
  return W.HOOK.handleRefresh = (p, { data: h }) => {
    h.content.forEach((e) => {
      e.reviewable = e.reviewStatus === g.UNREVIEWED.V && ee(k.value.review);
      const d = [];
      if (_(e.sourceWorkshopList) && (e.sourceWorkshopList.forEach((r) => {
        r.workshopStr = "";
        let u = [];
        _(r.nameInfos) && r.nameInfos.forEach((y) => {
          u.push(y.name);
        }), _(u) && (u = Array.from(new Set(u)), r.workshopStr = r.name + "(" + u.join("、") + ")"), d.push(r.workshopStr);
      }), _(d) && (e.sourceStr = d.join(" / "))), _(e.projectList)) {
        let r = [];
        e.projectList.forEach((u) => {
          r.push(te(u));
        }), r = Array.from(new Set(r)), e.projectListStr = r.join(" / ");
      }
    });
  }, (p, h) => {
    const e = U, d = N("table-cell-tag"), r = B, u = O, y = N("common-table"), D = A("parse-time"), V = F;
    return o(), H("div", le, [c(a(ne), { ref_key: "mHeaderRef", ref: T }, null, 512), x((o(), s(y, { ref_key: "tableRef", ref: S, data: a(w).data, "data-format": E.value, "default-expand-all": false, "expand-row-keys": R.value, "max-height": a(L), "row-key": "id", onSortChange: a(w).handleSortChange, onSelectionChange: a(w).selectionChangeHandler }, { default: n(() => [c(e, { align: "center", fixed: "left", type: "selection", width: "55" }), c(e, { align: "center", label: "序号", type: "index", width: "60" }, { default: n(({ row: t, $index: z }) => [t.transferCreateType === a(ae).OUTBOUND.V ? (o(), s(d, { key: 0, name: "出库", type: "transferOutbound" })) : i("", true), m("span", null, f(z + 1), 1)]), _: 1 }), a(l).visible("serialNumber") ? (o(), s(e, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "移库单号", prop: "serialNumber", width: "160" }, { default: n(({ row: t }) => [t.boolHasUnfreeze ? (o(), s(d, { key: 0, offset: 15, name: "解冻", type: "unfreeze" })) : i("", true), m("span", null, f(t.serialNumber), 1)]), _: 1 })) : i("", true), a(l).visible("basicClass") ? (o(), s(e, { key: "basicClass", "show-overflow-tooltip": true, align: "center", label: "物料种类", prop: "basicClass", width: "100" })) : i("", true), a(l).visible("sourceStr") ? (o(), s(e, { key: "sourceStr", label: "来源", "min-width": "240", prop: "sourceStr", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [m("span", null, f(t.sourceStr || "-"), 1)]), _: 1 })) : i("", true), a(l).visible("directionWarehouse") ? (o(), s(e, { key: "directionWarehouse", label: "目的", "min-width": "150", prop: "directionWarehouse" }, { default: n(({ row: t }) => [m("div", ce, [c(oe, { id: t.directionWorkshop ? t.directionWorkshop.id : t.directionWorkshopId }, null, 8, ["id"]), c(r, { class: "item", effect: "dark", content: j(t), placement: "top-start" }, { default: n(() => [m("span", null, f(t.directionWarehouse ? t.directionWarehouse.name : t.directionWarehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 })) : i("", true), a(l).visible("projectListStr") ? (o(), s(e, { key: "projectListStr", "show-overflow-tooltip": true, align: "center", label: "关联项目", "min-width": "170", prop: "projectListStr" }, { default: n(({ row: t }) => [m("span", null, f(t.projectListStr || "-"), 1)]), _: 1 })) : i("", true), a(l).visible("applicantName") ? (o(), s(e, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", prop: "applicantName", width: "110" })) : i("", true), a(l).visible("reviewerNames") ? (o(), s(e, { key: "reviewerNames", "show-overflow-tooltip": true, align: "center", label: "审核人", prop: "reviewerNames", width: "110" })) : i("", true), a(l).visible("createTime") ? (o(), s(e, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" }, { default: n(({ row: t }) => [x(m("span", null, null, 512), [[D, t.createTime]])]), _: 1 })) : i("", true), a(l).visible("reviewEndTime") ? (o(), s(e, { key: "reviewEndTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewEndTime", width: "140" })) : i("", true), a(l).visible("reviewStatus") ? (o(), s(e, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", label: "状态", prop: "reviewStatus", width: "80" }, { default: n(({ row: t }) => [c(u, { type: a(g).V[t.reviewStatus].TAG }, { default: n(() => [I(f(a(g).VL[t.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), c(e, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: n(({ row: t }) => [c(re, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[V, a(w).loading]]), c(a(se)), c(ie)]);
  };
} }, _e = G(pe, [["__scopeId", "data-v-5083c9db"]]);
export {
  _e as default
};
