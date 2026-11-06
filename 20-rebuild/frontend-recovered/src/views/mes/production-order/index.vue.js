import { ref as d } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as n } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as l } from "vue";
import { createElementVNode as L } from "vue";
import { toDisplayString as _ } from "vue";
import { createTextVNode as V } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as H } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as B } from "../../../modules/production-order-028b54f6.js";
import { _ as G, x as K, pZ as h, o as F, D as b, p as C, c as z, c2 as v, G as k, P as A } from "../../../shared/runtime.js";
import Z from "./module/detail.vue.js";
import J from "./module/header.vue.js";
import X from "./module/structure-list.vue.js";
import "../../../modules/use-product-lines-79a95221.js";
import "../../../modules/judgeSameValue-9683bdce.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/type-detail.vue.js";
import "./module/components/Panel/index.vue.js";
const Y = { class: "app-container" }, ee = ["onClick"], te = { key: 1 }, oe = { key: 0 }, ae = { key: 1 }, ie = { key: 0 }, ne = { key: 1 }, re = { __name: "index", setup(le) {
  const T = { add: false, edit: false, del: false, download: false }, W = d([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), x = d(), w = d(false), f = d(), p = d(false), S = d(), { crud: g, columns: s, CRUD: N } = K({ title: "生产订单", sort: [], permission: { ...h }, optShow: { ...T }, invisibleColumns: [], crudApi: { ...B }, hasPagination: true }, x), { maxHeight: D } = F({ paginate: true, extraHeight: 40 });
  N.HOOK.handleRefresh = (m, { data: i }) => {
    i.content.forEach((o) => {
      o.netWeight = o.totalNetWeight ? (o.totalNetWeight / 1e3).toFixed(b.COM_WT__KG) : void 0, o.schedulingNetWeight = o.schedulingTotalNetWeight ? (o.schedulingTotalNetWeight / 1e3).toFixed(b.COM_WT__KG) : void 0;
    });
  };
  function $(m) {
    var i;
    k(h.detailList) && (f.value = (i = m.sourceRow) == null ? void 0 : i.project.id, p.value = true);
  }
  function Q(m, i) {
    var o;
    f.value = (o = m.sourceRow) == null ? void 0 : o.project.id, w.value = true;
  }
  return (m, i) => {
    const o = M, R = H, j = y("common-button"), E = y("common-table"), O = y("common-drawer"), P = U;
    return a(), u("div", Y, [c(t(J)), I((a(), n(E, { ref_key: "tableRef", ref: x, data: t(g).data, "data-format": W.value, "empty-text": t(g).emptyText, "max-height": t(D), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: r(() => [c(o, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(s).visible("createTime") ? (a(), n(o, { key: "createTime", prop: "createTime", label: "立项日期", align: "center" })) : l("", true), t(s).visible("project") ? (a(), n(o, { key: "project", prop: "project", label: "所属项目", "min-width": "150", "show-overflow-tooltip": true })) : l("", true), t(s).visible("date") ? (a(), n(o, { key: "date", prop: "date", label: "项目开始~结束日期", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: r((e) => [L("span", null, _(`${t(C)(e.row.startDate, "{y}-{m}-{d}")}~${t(C)(e.row.endDate, "{y}-{m}-{d}")}`), 1)]), _: 1 })) : l("", true), t(s).visible("quantity") ? (a(), n(o, { key: "quantity", prop: "quantity", label: "清单量（件/吨）", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: r((e) => [e.row.quantity && e.row.netWeight ? (a(), u("span", { key: 0, style: { cursor: "pointer", color: "#409eff" }, onClick: (q) => $(e.row) }, _(`${e.row.quantity} | ${e.row.netWeight}`), 9, ee)) : (a(), u("span", te, "-"))]), _: 1 })) : l("", true), t(s).visible("productionSchedulingQuantity") ? (a(), n(o, { key: "productionSchedulingQuantity", prop: "productionSchedulingQuantity", label: "排产量（件/吨）", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: r((e) => [e.row.productionSchedulingQuantity && e.row.productionSchedulingWeight ? (a(), u("span", oe, _(`${e.row.productionSchedulingQuantity} | ${t(z)(e.row.productionSchedulingWeight, "kg", "t", t(b).COM_WT__KG)}`), 1)) : (a(), u("span", ae, "-"))]), _: 1 })) : l("", true), t(s).visible("schedulingQuantity") ? (a(), n(o, { key: "schedulingQuantity", prop: "schedulingQuantity", label: "排期量（件/吨）", align: "center", "show-overflow-tooltip": true, "min-width": "150" }, { default: r((e) => [e.row.schedulingQuantity && e.row.schedulingNetWeight ? (a(), u("span", ie, _(`${e.row.schedulingQuantity} | ${e.row.schedulingNetWeight}`), 1)) : (a(), u("span", ne, "-"))]), _: 1 })) : l("", true), t(s).visible("status") ? (a(), n(o, { key: "status", prop: "status", label: "状态", align: "center" }, { default: r((e) => [e.row.status ? (a(), n(R, { key: 0, type: e.row.status === t(v).NOT.V ? "warning" : e.row.status === t(v).COMPLETED.V ? "success" : "primary" }, { default: r(() => [V(_(t(v).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"])) : l("", true)]), _: 1 })) : l("", true), t(k)([...t(h).detail]) ? (a(), n(o, { key: 7, label: "操作", width: "120px", align: "center" }, { default: r((e) => [t(k)(t(h).detail) ? (a(), n(j, { key: 0, type: "primary", size: "default", onClick: (q) => Q(e.row) }, { default: r(() => i[2] || (i[2] = [V("计划排期")])), _: 2, __: [2] }, 1032, ["onClick"])) : l("", true)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[P, t(g).loading]]), c(t(Z), { modelValue: w.value, "onUpdate:modelValue": i[0] || (i[0] = (e) => w.value = e), currentId: f.value, onSuccess: t(g).refresh, permission: t(h) }, null, 8, ["modelValue", "currentId", "onSuccess", "permission"]), c(O, { "append-to-body": "", ref_key: "drawerRef", ref: S, modelValue: p.value, "onUpdate:modelValue": i[1] || (i[1] = (e) => p.value = e), top: "10vh", "before-close": () => {
      p.value = false;
    }, title: "构零件清单", "wrapper-closable": false, "custom-class": "artifact-tree-drawer", size: "90%" }, { content: r(() => [c(t(X), { drawerVisible: p.value, currentId: f.value }, null, 8, ["drawerVisible", "currentId"])]), _: 1 }, 8, ["modelValue", "before-close"]), c(t(A))]);
  };
} }, be = G(re, [["__scopeId", "data-v-15a95a86"]]);
export {
  be as default
};
