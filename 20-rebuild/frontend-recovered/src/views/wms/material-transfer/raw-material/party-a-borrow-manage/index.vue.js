import { ref as d } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as o } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as m } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as u } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as q, r as D } from "./module/return-material.vue.js";
import { _ as $, jX as F, x as O, B5 as k, o as G, cO as H, jl as I, cS as K, aR as L, k4 as z, ux as w, jG as X, k5 as J, G as W, B6 as h, P as Y } from "../../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
const ee = { class: "app-container" }, te = { class: "returned-number" }, re = { __name: "index", setup(ae) {
  const R = { batchAdd: false, add: false, edit: false, del: false, download: false }, y = d([]), b = d(false), g = d(), T = d(), S = d([...F, ["corReturnedQuantity", ["to-fixed", "outboundUnitPrecision"]], ["corQuantity", ["to-fixed", "outboundUnitPrecision"]], ["remark", "empty-text"], ["project", ["parse-project", { onlyShortName: true }]], ["borrowProject", ["parse-project", { onlyShortName: true }]], ["transferTime", ["parse-time", "{y}-{m}-{d}"]], ["returnTime", ["parse-time", "{y}-{m}-{d}"]]]), { CRUD: N, crud: c, columns: s } = O({ title: "甲供物料借出管理", sort: ["id.desc"], invisibleColumns: ["transferorName", "transferTime", "returnTransferSN", "returnTime"], permission: { ...k }, optShow: { ...R }, crudApi: { ...q } }, T), { maxHeight: v } = G({ paginate: true });
  N.HOOK.handleRefresh = async (_, { data: a }) => {
    await H(a.content), a.content = await I(a.content, { toSmallest: false, toNum: false }), a.content.forEach((e) => {
      e.pendingQuantity = e.quantity - e.returnedQuantity, e.pendingMete = e.mete - e.returnedMete, e.outboundUnitType === K.MEASURE.V ? (e.corQuantity = e.quantity, e.corReturnedQuantity = e.returnedQuantity, e.corPendingQuantity = e.pendingQuantity, e.corUnderReviewQuantity = e.underReviewQuantity) : (e.corQuantity = e.mete, e.corReturnedQuantity = e.returnedMete, e.corPendingQuantity = e.pendingMete, e.corUnderReviewQuantity = e.underReviewMete);
    });
  };
  function C(_) {
    b.value = true, g.value = _;
  }
  return (_, a) => {
    const e = B, Q = x("common-button"), j = A, E = x("common-table"), P = V;
    return n(), U("div", ee, [i(t(Z)), M((n(), o(E, { key: `party_a_borrow_${t(c).query.basicClass}`, ref_key: "tableRef", ref: T, data: t(c).data, "data-format": S.value, "max-height": t(v), "default-expand-all": false, "expand-row-keys": y.value, "row-key": "id", onSortChange: t(c).handleSortChange }, { default: l(() => [i(L, { data: t(c).data, "expand-row-keys": y.value, "onUpdate:expandRowKeys": a[0] || (a[0] = (r) => y.value = r), "row-key": "id", fixed: "left" }, { default: l(({ row: r }) => [i(z, { "basic-class": r.basicClass, row: r, "show-graphics": "" }, { default: l(() => [m("p", null, [a[2] || (a[2] = p(" 借用调拨备注：")), m("span", null, f(r.remark), 1)]), m("p", null, [a[3] || (a[3] = p(" 归还调拨单号： ")), i(t(w), { "receipt-types": ["TRANSFER"], receipt: r.returnTransfers }, null, 8, ["receipt"])])]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["data", "expand-row-keys"]), i(X, { columns: t(s), "basic-class": t(c).query.basicClass, "show-party-a": false, fixed: "left" }, null, 8, ["columns", "basic-class"]), i(J, { columns: t(s) }, null, 8, ["columns"]), t(s).visible("outboundUnit") ? (n(), o(e, { key: 0, prop: "outboundUnit", label: "单位", align: "center", width: "70px" })) : u("", true), t(s).visible("quantity") ? (n(), o(e, { key: 1, prop: "quantity", label: "已还/总数", align: "right", width: "110px" }, { default: l(({ row: r }) => [m("span", te, f(r.corReturnedQuantity), 1), p("  /  " + f(r.corQuantity), 1)]), _: 1 })) : u("", true), t(s).visible("project") ? (n(), o(e, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "原项目", "min-width": "170" })) : u("", true), t(s).visible("borrowProject") ? (n(), o(e, { "show-overflow-tooltip": "", key: "borrowProject", prop: "borrowProject", label: "借用项目", "min-width": "170" })) : u("", true), t(s).visible("borrowTransferSN") ? (n(), o(e, { key: "borrowTransferSN", "show-overflow-tooltip": true, prop: "borrowTransferSN", label: "借用调拨单号", align: "center", "min-width": "120" }, { default: l(({ row: r }) => [i(t(w), { "receipt-types": ["TRANSFER"], receipt: r.borrowTransfer }, null, 8, ["receipt"])]), _: 1 })) : u("", true), t(s).visible("returnTransferSN") ? (n(), o(e, { key: "returnTransferSN", "show-overflow-tooltip": true, prop: "returnTransferSN", label: "归还调拨单号", align: "center", "min-width": "120" }, { default: l(({ row: r }) => [i(t(w), { "receipt-types": ["TRANSFER"], receipt: r.returnTransfers }, null, 8, ["receipt"])]), _: 1 })) : u("", true), t(s).visible("transferorName") ? (n(), o(e, { key: "transferorName", "show-overflow-tooltip": true, prop: "transferorName", label: "借用调拨人", align: "center", width: "90" })) : u("", true), t(s).visible("transferTime") ? (n(), o(e, { key: "transferTime", "show-overflow-tooltip": true, prop: "transferTime", label: "借用日期", align: "center", width: "100", sortable: "custom" })) : u("", true), t(s).visible("returnTime") ? (n(), o(e, { key: "returnTime", "show-overflow-tooltip": true, prop: "returnTime", label: "归还日期", align: "center", width: "100", sortable: "custom" })) : u("", true), i(e, { label: "操作", width: "85px", align: "center", fixed: "right" }, { default: l(({ row: { sourceRow: r } }) => [t(W)(t(k).return) && r.returnStatus === t(h).NOT_RETURNED.V ? (n(), o(Q, { key: 0, type: "primary", size: "default", onClick: (ne) => C(r) }, { default: l(() => a[4] || (a[4] = [p("归还")])), _: 2, __: [4] }, 1032, ["onClick"])) : (n(), o(j, { key: 1, type: t(h).V[r.returnStatus].TAG }, { default: l(() => [p(f(t(h).VL[r.returnStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange"])), [[P, t(c).loading]]), i(t(Y)), i(D, { visible: b.value, "onUpdate:visible": a[1] || (a[1] = (r) => b.value = r), detail: g.value, onSuccess: t(c).toQuery }, null, 8, ["visible", "detail", "onSuccess"])]);
  };
} }, ue = $(re, [["__scopeId", "data-v-92e4357f"]]);
export {
  ue as default
};
