import { ref as M } from "vue";
import { inject as R } from "vue";
import { computed as W } from "vue";
import { watch as j } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as g } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as o } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as n } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as _ } from "vue";
import { ElTableColumn as L } from "element-plus";
import { vLoading as $ } from "element-plus";
import { g as V } from "../../../../../modules/manual-pack-01ad3a57.js";
import { _ as A, x as E, bw as H, V as G, br as F, bs as y, D as w, G as U } from "../../../../../shared/runtime.js";
import { m as C } from "../../../../../modules/bridge-86f96a4f.js";
import z from "./module/header.vue.js";
const X = { class: "app-container" }, J = { class: "head-container" }, Y = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add"], setup(k, { expose: N, emit: Q }) {
  const S = { add: false, edit: false, del: false, download: false }, x = M(), { crud: l, columns: r, CRUD: v } = E({ title: "手工打包（分段）", sort: [], permission: { ...C }, optShow: { ...S }, crudApi: { get: V }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false, hasPagination: false }, x), m = H.BOX.K, T = Q, u = k, P = R("packData"), D = W(() => Object.keys(P[m]));
  j(() => [u.projectId, u.workshopId, u.monomerId, u.areaId], () => {
    l.toQuery();
  }, { immediate: true, deep: true });
  function O(b) {
    T("add", b, m);
  }
  return v.HOOK.beforeRefresh = () => {
    l.query.projectId = u.projectId, l.query.workshopId = u.workshopId, l.query.monomerId = u.monomerId, l.query.areaId = u.areaId;
  }, v.HOOK.handleRefresh = (b, h) => {
    var t;
    h.data.content = (t = h.data.boxList) == null ? void 0 : t.map((s, f) => (s.rowKey = `${m}_${Math.random()}_${f}`, s.productQuantity = s.unPackageQuantity, s.originNumberList = s.numberList && G(s.numberList) || [], s));
  }, N({ refresh: l.toQuery }), (b, h) => {
    const t = L, s = I("common-button"), f = I("common-table"), q = $;
    return a(), K("div", X, [p("div", J, [g(e(z))]), B((a(), o(f, { ref_key: "tableRef", ref: x, data: e(l).data, "empty-text": e(l).emptyText, "max-height": k.maxHeight, style: { width: "100%" }, onSortChange: e(l).handleSortChange }, { default: d(() => [g(t, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("name") ? (a(), o(t, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: d(({ row: i }) => [i.workshopInf ? (a(), o(F, { key: 0, name: i.workshopInf.name }, null, 8, ["name"])) : n("", true), p("span", null, c(i.name), 1)]), _: 1 })) : n("", true), e(r).visible("monomer.name") ? (a(), o(t, { key: 1, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" })) : n("", true), e(r).visible("area.name") ? (a(), o(t, { key: 2, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : n("", true), e(r).visible("serialNumber") ? (a(), o(t, { key: 3, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "100px" })) : n("", true), e(r).visible("specification") ? (a(), o(t, { key: 4, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: d(({ row: i }) => [p("span", null, c(i.specification), 1)]), _: 1 })) : n("", true), e(r).visible("length") ? (a(), o(t, { key: 5, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: d(({ row: i }) => [_(c(e(y)(i.length, e(w).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : n("", true), e(r).visible("material") ? (a(), o(t, { key: 6, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: d(({ row: i }) => [p("span", null, c(i.material), 1)]), _: 1 })) : n("", true), e(r).visible("netWeight") ? (a(), o(t, { key: 7, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: d(({ row: i }) => [_(c(e(y)(i.netWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : n("", true), e(r).visible("grossWeight") ? (a(), o(t, { key: 8, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: d(({ row: i }) => [_(c(e(y)(i.grossWeight, e(w).COM_WT__KG)), 1)]), _: 1 })) : n("", true), e(r).visible("drawingNumber") ? (a(), o(t, { key: 9, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : n("", true), e(r).visible("quantity") ? (a(), o(t, { key: 10, prop: "quantity", sortable: "custom", label: "清单数", align: "center", "min-width": "80px" })) : n("", true), e(r).visible("inQuantity") ? (a(), o(t, { key: 11, prop: "inQuantity", sortable: "custom", label: "入库量", align: "center", "min-width": "80px" })) : n("", true), e(r).visible("unPackageQuantity") ? (a(), o(t, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包量", align: "center", "min-width": "80px" })) : n("", true), e(r).visible("packageQuantity") ? (a(), o(t, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包量", align: "center", "min-width": "80px" })) : n("", true), e(U)(e(C).pack) ? (a(), o(t, { key: 14, label: "操作", width: "70", align: "center", fixed: "right" }, { default: d(({ row: { sourceRow: i } }) => [g(s, { type: "success", icon: "el-icon-plus", disabled: D.value.includes(`${i.id}`), size: "default", onClick: (Z) => O(i) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[q, e(l).loading]])]);
  };
} }, ne = A(Y, [["__scopeId", "data-v-e71244ac"]]);
export {
  ne as default
};
