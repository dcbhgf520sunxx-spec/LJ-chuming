import { ref as _ } from "vue";
import { provide as D } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as w } from "vue";
import { Fragment as A } from "vue";
import { withDirectives as R } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as G } from "element-plus";
import { c as K } from "../../../../modules/artifact-da890fbc.js";
import { _ as J, x as X, se as b, o as Y, aU as Z, a3 as O, c as ee, D as te, G as oe, P as ae } from "../../../../shared/runtime.js";
import le from "./module/header.vue.js";
import ne from "./module/detail.vue.js";
import ie from "./module/artifact-project-list.vue.js";
import "../../../../modules/use-default-table-template-4b5e02c6.js";
import "./component/project-to-area-tree.vue.js";
const re = { class: "app-container wrap" }, se = { class: "wrap-left" }, de = { class: "wrap-right" }, pe = { class: "wrap-head" }, ce = { __name: "index", setup(ue) {
  const P = { add: false, edit: false, del: false, download: false }, k = _(), { crud: s, columns: d, CRUD: S } = X({ title: "构件工单", sort: [], permission: { ...b }, optShow: { ...P }, crudApi: { ...K }, requiredQuery: ["projectIds"] }, k), v = _([]), V = _([["scheduleTime", ["parse-time", "{y}-{m}-{d}"]]]);
  D("crud", s), D("permission", b);
  const { maxHeight: x } = Y();
  function B(c) {
    s.query.projectIds = c, s.toQuery();
  }
  function Q(c) {
    v.value = [], c.forEach((n) => {
      v.value.push(n.orderId);
    });
  }
  S.HOOK.handleRefresh = (c, n) => {
    n.data.content = n.data.content.map((u) => (u.boolPrinted = !!u.printQuantity, u.boolIntellect = u.productionLineTypeEnum === Z.INTELLECT.V, u));
  };
  const W = _(), T = _({}), y = _(false);
  function j(c) {
    y.value = true, T.value = c.sourceRow, W.value = Object.assign({}, c);
  }
  return (c, n) => {
    var C, I;
    const u = $, l = z, N = g("table-cell-tag"), q = g("common-button"), H = g("common-table"), U = M("permission"), F = G;
    return o(), L("div", re, [m("div", se, [p(ie, { maxHeight: e(x) - 40, onNestingTaskClick: B }, null, 8, ["maxHeight"])]), m("div", de, [(I = (C = e(s).query) == null ? void 0 : C.projectIds) != null && I.length ? (o(), L(A, { key: 1 }, [m("div", pe, [p(e(le), { orderIds: v.value }, null, 8, ["orderIds"])]), R((o(), a(H, { ref_key: "tableRef", ref: k, data: e(s).data, "empty-text": e(s).emptyText, dataFormat: V.value, "max-height": e(x) - 130, style: { width: "100%" }, onSelectionChange: Q }, { default: i(() => [p(l, { type: "selection", width: "55", align: "center" }), p(l, { label: "序号", type: "index", align: "center", width: "70" }, { default: i(({ row: t, $index: h }) => [p(N, { show: t.boolPrinted, color: "#e64242", name: "已打印", type: "printed" }, null, 8, ["show"]), m("span", null, f(h + 1), 1)]), _: 1 }), e(d).visible("monomer") ? (o(), a(l, { key: 0, "show-overflow-tooltip": true, prop: "monomer", label: "包含单体/区域", width: "150px", align: "center" }, { default: i(({ row: t }) => {
      var h, E;
      return [m("span", null, f(((h = t.monomer) == null ? void 0 : h.name) + "/" + ((E = t.area) == null ? void 0 : E.name)), 1)];
    }), _: 1 })) : r("", true), e(d).visible("scheduleTime") ? (o(), a(l, { key: 1, "show-overflow-tooltip": true, prop: "scheduleTime", label: "排产日期", width: "110px", align: "center" })) : r("", true), e(d).visible("scheduleOrder") ? (o(), a(l, { key: 2, "show-overflow-tooltip": true, prop: "scheduleOrder", label: "任务工单号", "min-width": "110px", align: "center" }, { default: i(({ row: t }) => [p(N, { show: t.boolIntellect, name: "智" }, null, 8, ["show"]), m("span", null, f(t.scheduleOrder), 1)]), _: 1 })) : r("", true), e(d).visible("userName") ? (o(), a(l, { key: 3, "show-overflow-tooltip": true, prop: "userName", label: "排产人", "min-width": "110px", align: "center" })) : r("", true), e(d).visible("productType") ? (o(), a(l, { key: 4, "show-overflow-tooltip": true, prop: "productType", label: "类型", width: "100px", align: "center" }, { default: i(({ row: t }) => [p(u, { type: t.productType & e(O).ASSEMBLE.V ? "" : "success", effect: "plain" }, { default: i(() => [w(f(e(O).VL[t.productType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(d).visible("workshop.name") ? (o(), a(l, { key: 5, "show-overflow-tooltip": true, prop: "workshop.name", label: "车间", "min-width": "100px", align: "center" })) : r("", true), e(d).visible("productionLine.name") ? (o(), a(l, { key: 6, "show-overflow-tooltip": true, prop: "productionLine.name", label: "生产线", "min-width": "100px", align: "center" })) : r("", true), e(d).visible("taskQuantity") ? (o(), a(l, { key: 7, "show-overflow-tooltip": true, prop: "taskQuantity", label: "任务数（件）", "min-width": "80px", align: "center" })) : r("", true), e(d).visible("taskNetWeight") ? (o(), a(l, { key: 8, "show-overflow-tooltip": true, prop: "taskNetWeight", label: "任务量（吨）", align: "center" }, { default: i(({ row: t }) => [m("span", null, f(t.taskNetWeight ? e(ee)(t.taskNetWeight, "kg", "t", e(te).COM_WT__T) : "-"), 1)]), _: 1 })) : r("", true), e(oe)([...e(b).detail]) ? (o(), a(l, { key: 9, label: "操作", width: "85px", align: "center" }, { default: i(({ row: t }) => [R((o(), a(q, { type: "primary", size: "default", onClick: (h) => j(t) }, { default: i(() => n[2] || (n[2] = [w("查看")])), _: 2, __: [2] }, 1032, ["onClick"])), [[U, e(b).detail]])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "dataFormat", "max-height"])), [[F, e(s).loading]]), p(e(ae))], 64)) : (o(), a(u, { key: 0, type: "info", size: "large" }, { default: i(() => n[1] || (n[1] = [w(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [1] })), p(ne, { visible: y.value, "onUpdate:visible": n[0] || (n[0] = (t) => y.value = t), "detail-data": T.value, serialNumber: e(s).query.serialNumber, onRefresh: e(s).toQuery }, null, 8, ["visible", "detail-data", "serialNumber", "onRefresh"])])]);
  };
} }, ke = J(ce, [["__scopeId", "data-v-18e119bf"]]);
export {
  ke as default
};
