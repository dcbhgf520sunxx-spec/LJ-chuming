import { ref as d } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as i } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as s } from "vue";
import { createElementVNode as H } from "vue";
import { toDisplayString as w } from "vue";
import { createTextVNode as x } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as Q } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as U } from "../../../../modules/production-order-028b54f6.js";
import { _ as F, x as G, pZ as _, o as K, D as V, p as C, c2 as b, G as v, P as z } from "../../../../shared/runtime.js";
import A from "./module/detail.vue.js";
import Z from "./module/header.vue.js";
import J from "./module/structure-list.vue.js";
import "../../../../modules/use-product-lines-79a95221.js";
import "../../../../modules/judgeSameValue-9683bdce.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/type-detail.vue.js";
import "./module/components/Panel/index.vue.js";
const X = { class: "app-container" }, Y = ["onClick"], ee = { key: 1 }, te = { key: 0 }, ae = { key: 1 }, oe = { __name: "index", setup(re) {
  const T = { add: false, edit: false, del: false, download: false }, N = d([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), k = d(), y = d(false), f = d(), c = d(false), W = d(), { crud: h, columns: l, CRUD: D } = G({ title: "生产订单", sort: [], permission: { ..._ }, optShow: { ...T }, invisibleColumns: [], crudApi: { ...U }, hasPagination: true }, k), { maxHeight: R } = K({ paginate: true, extraHeight: 40 });
  D.HOOK.handleRefresh = (m, { data: r }) => {
    r.content.forEach((a) => {
      a.netWeight = a.totalNetWeight ? (a.totalNetWeight / 1e3).toFixed(V.COM_WT__KG) : void 0, a.schedulingNetWeight = a.schedulingTotalNetWeight ? (a.schedulingTotalNetWeight / 1e3).toFixed(V.COM_WT__KG) : void 0;
    });
  };
  function $(m) {
    var r;
    v(_.detailList) && (f.value = (r = m.sourceRow) == null ? void 0 : r.project.id, c.value = true);
  }
  function j(m, r) {
    var a;
    f.value = (a = m.sourceRow) == null ? void 0 : a.project.id, y.value = true;
  }
  return (m, r) => {
    const a = M, E = Q, P = g("common-button"), O = g("common-table"), S = g("common-drawer"), q = B;
    return o(), p("div", X, [u(e(Z)), L((o(), i(O, { ref_key: "tableRef", ref: k, data: e(h).data, "data-format": N.value, "empty-text": e(h).emptyText, "max-height": e(R), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: n(() => [u(a, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), e(l).visible("createTime") ? (o(), i(a, { key: "createTime", prop: "createTime", label: "立项日期", align: "center" })) : s("", true), e(l).visible("project") ? (o(), i(a, { key: "project", prop: "project", label: "所属项目", "min-width": "150", "show-overflow-tooltip": true })) : s("", true), e(l).visible("date") ? (o(), i(a, { key: "date", prop: "date", label: "项目开始~结束日期", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: n((t) => [H("span", null, w(`${e(C)(t.row.startDate, "{y}-{m}-{d}")}~${e(C)(t.row.endDate, "{y}-{m}-{d}")}`), 1)]), _: 1 })) : s("", true), e(l).visible("quantity") ? (o(), i(a, { key: "quantity", prop: "quantity", label: "清单量（件/吨）", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: n((t) => [t.row.quantity && t.row.netWeight ? (o(), p("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (I) => $(t.row) }, w(`${t.row.quantity} | ${t.row.netWeight}`), 9, Y)) : (o(), p("span", ee, "-"))]), _: 1 })) : s("", true), e(l).visible("schedulingQuantity") ? (o(), i(a, { key: "schedulingQuantity", prop: "schedulingQuantity", label: "排期量（件/吨）", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: n((t) => [t.row.schedulingQuantity && t.row.schedulingNetWeight ? (o(), p("span", te, w(`${t.row.schedulingQuantity} | ${t.row.schedulingNetWeight}`), 1)) : (o(), p("span", ae, "-"))]), _: 1 })) : s("", true), e(l).visible("status") ? (o(), i(a, { key: "status", prop: "status", label: "状态", align: "center" }, { default: n((t) => [t.row.status ? (o(), i(E, { key: 0, type: t.row.status === e(b).NOT.V ? "warning" : t.row.status === e(b).COMPLETED.V ? "success" : "primary" }, { default: n(() => [x(w(e(b).VL[t.row.status]), 1)]), _: 2 }, 1032, ["type"])) : s("", true)]), _: 1 })) : s("", true), e(v)([...e(_).detail]) ? (o(), i(a, { key: 6, label: "操作", width: "120px", align: "center" }, { default: n((t) => [e(v)(e(_).detail) ? (o(), i(P, { key: 0, type: "primary", size: "default", onClick: (I) => j(t.row) }, { default: n(() => r[2] || (r[2] = [x("计划排期")])), _: 2, __: [2] }, 1032, ["onClick"])) : s("", true)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[q, e(h).loading]]), u(e(A), { modelValue: y.value, "onUpdate:modelValue": r[0] || (r[0] = (t) => y.value = t), currentId: f.value, onSuccess: e(h).refresh, permission: e(_) }, null, 8, ["modelValue", "currentId", "onSuccess", "permission"]), u(S, { "append-to-body": "", ref_key: "drawerRef", ref: W, modelValue: c.value, "onUpdate:modelValue": r[1] || (r[1] = (t) => c.value = t), top: "10vh", "before-close": () => {
      c.value = false;
    }, title: "构零件清单", "wrapper-closable": false, "custom-class": "artifact-tree-drawer", size: "90%" }, { content: n(() => [u(e(J), { drawerVisible: c.value, currentId: f.value }, null, 8, ["drawerVisible", "currentId"])]), _: 1 }, 8, ["modelValue", "before-close"]), u(e(z))]);
  };
} }, we = F(oe, [["__scopeId", "data-v-f5717d14"]]);
export {
  we as default
};
