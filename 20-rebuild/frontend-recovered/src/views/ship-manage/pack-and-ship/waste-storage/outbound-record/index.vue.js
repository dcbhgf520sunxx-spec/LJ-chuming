import { ref as r } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as d } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as f } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as R } from "element-plus";
import { vLoading as q } from "element-plus";
import { c as L, a as B } from "./module/audit.vue.js";
import { _ as j, x as z, o as G, kC as K, kG as $, ur as F, bV as I, kK as _, G as Q, P as J } from "../../../../../shared/runtime.js";
import { v as y } from "../../../../../modules/ship-manage-3066b2ed.js";
import O from "./module/header.vue.js";
const W = { class: "app-container" }, X = { class: "head-container" }, Y = { __name: "index", setup(Z) {
  const N = { add: false, edit: false, del: false, download: false }, h = r(), p = r(false), v = r(), g = r(), { crud: i } = z({ title: "出库记录", optShow: { ...N }, permission: { ...y }, sort: [], invisibleColumns: ["quantity"], crudApi: { ...L }, hasPagination: true }, h), V = r([["createTime", ["parse-time"]], ["auditTime", ["parse-time"]]]), { maxHeight: D } = G({ paginate: false, extraHeight: 50 });
  function b(k, u) {
    p.value = true, v.value = u, g.value = k;
  }
  return (k, u) => {
    const o = M, T = R, x = C("common-button"), P = C("common-table"), E = U("permission"), H = q;
    return s(), A("div", W, [m("div", X, [a(t(O))]), S((s(), d(P, { ref_key: "tableRef", ref: h, data: t(i).data, "data-format": V.value, "empty-text": t(i).emptyText, "max-height": t(D), style: { width: "100%" }, onSelectionChange: t(i).selectionChangeHandler }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "出库单号", align: "center", "min-width": "120" }), a(o, { "show-overflow-tooltip": "", prop: "productType", key: "productType", label: "制成品类型", align: "center" }, { default: l((e) => [e.row.productType ? (s(), d(T, { key: 0, effect: "plain" }, { default: l(() => [w(n(e.row.relationType ? t(K).VL[e.row.relationType] : t($).VL[e.row.productType]), 1)]), _: 2 }, 1024)) : f("", true)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "wasteHandleMethod", key: "wasteHandleMethod", label: "出库方式", align: "center" }, { default: l((e) => [w(n(t(F).VL[e.row.wasteHandleMethod] || "-"), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "useProjectName", key: "useProjectName", label: "二次利用项目", align: "center", "min-width": "140" }), a(o, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "mete", key: "quantity", label: "总量", align: "center" }, { default: l((e) => [m("span", null, n(e.row.mete) + " " + n(e.row.accountingUnit), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "金额（元）", align: "center" }, { default: l((e) => [m("span", null, n(t(I)(e.row.totalAmount, 3) || 0), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "createUserName", key: "createUserName", label: "办理人", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "createTime", key: "createTime", label: "办理日期", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "auditUserName", key: "auditUserName", label: "审核人", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "auditTime", key: "auditTime", label: "审核日期", align: "center" }), a(o, { "show-overflow-tooltip": "", prop: "auditStatus", key: "auditStatus", label: "审核状态", align: "center" }, { default: l((e) => {
      var c;
      return [e.row.auditStatus ? (s(), d(T, { key: 0, type: (c = t(_).V[e.row.auditStatus]) == null ? void 0 : c.T, effect: "plain" }, { default: l(() => [w(n(t(_).VL[e.row.auditStatus] || "-"), 1)]), _: 2 }, 1032, ["type"])) : f("", true)];
    }), _: 1 }), a(o, { "show-overflow-tooltip": "", prop: "name", key: "nmae", label: "操作", align: "center", "min-width": "100px" }, { default: l((e) => [S(a(x, { type: "primary", size: "default", icon: "el-icon-view", onClick: (c) => b(e.row, "view") }, null, 8, ["onClick"]), [[E, t(y).detail]]), e.row.auditStatus === t(_).UNCHECKED.V && t(Q)(t(y).audit) ? (s(), d(x, { key: 0, type: "success", size: "default", icon: "el-icon-stamp", onClick: (c) => b(e.row, "audit") }, null, 8, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[H, t(i).loading]]), a(t(J)), a(t(B), { visible: p.value, "onUpdate:visible": u[0] || (u[0] = (e) => p.value = e), auditType: v.value, rowData: g.value, onSuccess: t(i).toQuery }, null, 8, ["visible", "auditType", "rowData", "onSuccess"])]);
  };
} }, ne = j(Y, [["__scopeId", "data-v-545bf43f"]]);
export {
  ne as default
};
