import { ref as s } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as c } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as H } from "vue";
import { toDisplayString as R } from "vue";
import { Fragment as $ } from "vue";
import { renderList as q } from "vue";
import { createTextVNode as L } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as A } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as z } from "./module/issue-record-form.vue.js";
import { _ as F, m as G, x as Q, tU as g, o as K, i as Y, p as J, aN as W, bv as X, bi as y, G as u, P as Z } from "../../../../shared/runtime.js";
import { E as i } from "../../../../modules/project-19a12d6b.js";
import ee from "./module/header.vue.js";
import te from "./module/delivery-detail.vue.js";
import "../../../../modules/PicUpload-8580ccfc.js";
const oe = { class: "app-container" }, ae = { style: { "margin-left": "14px" } }, le = { __name: "index", setup(re) {
  const { globalProjectId: b, globalProject: N } = G(["globalProjectId", "globalProject"]), V = { add: false, edit: false, del: false, download: false }, h = s(), m = s(false), v = s({}), k = s(""), { crud: n, CRUD: C } = Q({ title: "自制收货", sort: ["id.desc"], permission: { ...i }, optShow: { ...V }, requiredQuery: ["projectId"], crudApi: { ...z }, hasPagination: true }, h);
  C.HOOK.beforeRefresh = () => (n.query.projectId = b.value || void 0, !!n.query.projectId);
  const I = s([["status", ["parse-enum", g]], ["auditReceiptTime", "parse-time"]]), { maxHeight: j } = K({ paginate: true, extraHeight: 40 });
  function f(x, p) {
    u(i.detail) && (k.value = p, m.value = true, v.value = x.sourceRow);
  }
  return (x, p) => {
    const a = M, E = w("table-cell-tag"), S = A, T = w("common-button"), D = w("common-table"), B = O;
    return r(), P("div", oe, [o(e(ee), { projectId: e(b) }, null, 8, ["projectId"]), U((r(), c(D, { ref_key: "tableRef", ref: h, data: e(n).data, "data-format": I.value, "empty-text": e(n).emptyText, "max-height": e(j), stripe: false, "row-key": "id", style: { width: "100%" } }, { default: d(() => [o(a, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), o(a, { key: "auditTime", prop: "auditTime", label: "发运日期", align: "center", width: "160", "show-overflow-tooltip": true }, { default: d((t) => {
      var l;
      return [o(E, { show: e(Y)(t.row.boolProblemReceiving) && ((l = t.row.sourceRow) == null ? void 0 : l.status) === e(g).DELIVERY.V, name: t.row.boolProblemReceiving ? "问题收货" : "正常收货", color: t.row.boolProblemReceiving ? "#f56c6c" : "#67c23a", onClick: (ie) => f(t.row, "detail") }, null, 8, ["show", "name", "color", "onClick"]), H("span", ae, R(t.row.auditTime ? e(J)(t.row.auditTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)];
    }), _: 1 }), o(a, { key: "licensePlate", prop: "licensePlate", label: "车牌/船牌号", align: "center", "show-overflow-tooltip": true }), o(a, { key: "serialNumber", prop: "serialNumber", label: "车次/船次", align: "center", "show-overflow-tooltip": true }), o(a, { key: "driverName", prop: "driverName", label: "司机姓名", align: "center", "show-overflow-tooltip": true }), o(a, { key: "driverPhone", prop: "driverPhone", label: "司机电话", align: "center", "show-overflow-tooltip": true }), o(a, { key: "auditUserName", prop: "auditUserName", label: "办理人", align: "center", "show-overflow-tooltip": true }), o(a, { key: "productType", prop: "productType", label: "装载物品", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: d((t) => [(r(true), P($, null, q(e(W)(e(X).getBits(e(y), t.row.productType, "V")), (l) => (r(), c(S, { style: { "margin-right": "5px" }, key: l, type: e(y).V[l].T, effect: "light", "disable-transitions": "" }, { default: d(() => [L(R(e(y).VL[l]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), o(a, { key: "status", prop: "status", label: "状态", align: "center", "show-overflow-tooltip": true }), o(a, { key: "auditReceiptName", prop: "auditReceiptName", label: "收货人", align: "center", "show-overflow-tooltip": true }), o(a, { key: "auditReceiptTime", prop: "auditReceiptTime", label: "收货日期", align: "center", "min-width": "120", "show-overflow-tooltip": true }), e(u)([...e(i).detail, ...e(i).audit]) ? (r(), c(a, { key: 0, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: d((t) => [e(u)(e(i).detail) ? (r(), c(T, { key: 0, size: "default", icon: "el-icon-view", type: "primary", onClick: (l) => f(t.row, "detail") }, null, 8, ["onClick"])) : _("", true), e(u)(e(i).audit) && t.row.sourceRow.status === e(g).SHIPMENT.V ? (r(), c(T, { key: 1, size: "default", icon: "el-icon-stamp", type: "warning", onClick: (l) => f(t.row, "edit") }, null, 8, ["onClick"])) : _("", true)]), _: 1 })) : _("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[B, e(n).loading]]), o(e(Z)), o(e(te), { modelValue: m.value, "onUpdate:modelValue": p[0] || (p[0] = (t) => m.value = t), detailInfo: v.value, showType: k.value, onSuccess: e(n).toQuery, permission: e(i), globalProject: e(N) }, null, 8, ["modelValue", "detailInfo", "showType", "onSuccess", "permission", "globalProject"])]);
  };
} }, fe = F(le, [["__scopeId", "data-v-7c381b71"]]);
export {
  fe as default
};
