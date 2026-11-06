import { ref as _ } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as o } from "vue";
import { createBlock as l } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as v } from "vue";
import { unref as t } from "vue";
import { withDirectives as B } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as p } from "vue";
import { createElementBlock as C } from "vue";
import { isRef as O } from "vue";
import { ElTableColumn as T } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as I, _ as A } from "./module/header.vue.js";
import { x as E, u as K, p as P } from "../../../../../shared/runtime.js";
const z = { class: "head-container" }, F = { key: 0 }, L = { key: 1 }, M = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible", "detailClose"], setup(g, { emit: D }) {
  const x = _(), f = D, b = g, N = { add: false, edit: false, del: false, download: false }, h = _(), { crud: u, columns: s, CRUD: Q } = E({ title: "抽检统计详情", invisibleColumns: [], optShow: { ...N }, crudApi: { ...I }, hasPagination: true, queryOnPresenterCreated: false }, h), { visible: m, handleClose: R } = K({ emit: f, props: b, field: "visible", showHook: V, closeHook: j });
  Q.HOOK.beforeToQuery = () => {
    var d;
    u.query.projectId = (d = b.detailData) == null ? void 0 : d.projectId;
  };
  function V() {
    u.toQuery();
  }
  function j() {
    f("detailClose");
  }
  return (d, c) => {
    const i = T, q = k("common-table"), S = k("common-drawer"), U = H;
    return o(), l(S, { ref_key: "drawerRef", ref: x, title: "抽检统计详情", modelValue: t(m), "onUpdate:modelValue": c[0] || (c[0] = (e) => O(m) ? m.value = e : null), direction: "rtl", "before-close": t(R), size: "80%" }, { titleRight: a(() => c[1] || (c[1] = [])), content: a(() => [n("div", z, [v(t(A))]), B((o(), l(q, { ref_key: "tableRef", ref: h, data: t(u).data, "empty-text": t(u).emptyText, "data-format": d.dataFormat, "max-height": d.maxHeight, "row-key": "rowKey", "tree-props": { children: "monomerSpotStatisticsCountDTOS" }, "default-expand-all": "", style: { width: "100%" } }, { default: a(() => [v(i, { label: "序号", type: "index", align: "center", width: "55" }), t(s).visible("project") ? (o(), l(i, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "project", label: "项目名称", "min-width": "140" }, { default: a(({ row: e }) => {
      var w, y;
      return [n("span", null, r((w = e.project) == null ? void 0 : w.serialNumber) + " " + r(((y = e.project) == null ? void 0 : y.shortName) || "-"), 1)];
    }), _: 1 })) : p("", true), t(s).visible("monomer") ? (o(), l(i, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "monomer", label: "单体" }, { default: a(({ row: e }) => [n("span", null, r(e.monomer.name || "-"), 1)]), _: 1 })) : p("", true), t(s).visible("serialNumber") ? (o(), l(i, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "serialNumber", label: "构件编号" }, { default: a(({ row: e }) => [n("span", null, r(e.serialNumber || "-"), 1)]), _: 1 })) : p("", true), t(s).visible("name") ? (o(), l(i, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "name", label: "构件名称" }, { default: a(({ row: e }) => [n("span", null, r(e.name || "-"), 1)]), _: 1 })) : p("", true), t(s).visible("specification") ? (o(), l(i, { key: 4, "show-overflow-tooltip": true, align: "center", prop: "specification", label: "构件规格" }, { default: a(({ row: e }) => [n("span", null, r(e.specification || "-"), 1)]), _: 1 })) : p("", true), t(s).visible("qualifiedQuantity") ? (o(), l(i, { key: 5, "show-overflow-tooltip": true, align: "center", prop: "qualifiedQuantity", label: "合格数", width: "100" }, { default: a(({ row: e }) => [n("span", null, r(e.qualifiedQuantity ?? "-"), 1)]), _: 1 })) : p("", true), t(s).visible("unQualifiedQuantity") ? (o(), l(i, { key: 6, "show-overflow-tooltip": true, align: "center", prop: "unQualifiedQuantity", label: "不合格数", width: "100" }, { default: a(({ row: e }) => [n("span", null, r(e.unQualifiedQuantity ?? "-"), 1)]), _: 1 })) : p("", true), t(s).visible("spotCheckRemark") ? (o(), l(i, { key: 7, "show-overflow-tooltip": true, align: "center", prop: "spotCheckRemark", label: "备注" }, { default: a(({ row: e }) => [n("span", null, r(e.spotCheckRemark || "-"), 1)]), _: 1 })) : p("", true), t(s).visible("spotCheckDate") ? (o(), l(i, { key: 8, "show-overflow-tooltip": true, align: "center", prop: "spotCheckDate", label: "抽检日期" }, { default: a(({ row: e }) => [e.spotCheckDate ? (o(), C("span", F, r(t(P)(e.spotCheckDate, "{y}-{m}-{d}")), 1)) : (o(), C("span", L, "-"))]), _: 1 })) : p("", true), t(s).visible("spotCheckUserName") ? (o(), l(i, { key: 9, "show-overflow-tooltip": true, align: "center", prop: "spotCheckUserName", label: "抽检人", width: "100" }, { default: a(({ row: e }) => [n("span", null, r(e.spotCheckUserName || "-"), 1)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[U, t(u).loading]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  M as default
};
