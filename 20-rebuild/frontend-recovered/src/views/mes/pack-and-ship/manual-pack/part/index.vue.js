import { ref as R } from "vue";
import { inject as W } from "vue";
import { computed as j } from "vue";
import { watch as K } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as g } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as B } from "element-plus";
import { c as V } from "../../../../../modules/manual-pack-695cccc1.js";
import { _ as G, x as $, oc as I, bi as F, br as L, bs as h, D as y, G as U, P as z } from "../../../../../shared/runtime.js";
import J from "./module/header.vue.js";
const X = { class: "app-container" }, Y = { class: "head-container" }, Z = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workShopId: { type: [String, Number], default: void 0 }, category: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add"], setup(_, { expose: N, emit: S }) {
  const P = { add: false, edit: false, del: false, download: false }, w = R(), { crud: l, columns: i, CRUD: k } = $({ title: "手工打包（直发件）", sort: [], permission: { ...I }, optShow: { ...P }, crudApi: { get: V }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false }, w), x = F.MACHINE_PART.K, Q = S, s = _, T = W("packData"), q = j(() => Object.keys(T[x]));
  K(() => [s.projectId, s.workshopId, s.monomerId, s.areaId, s.category], () => {
    l.toQuery();
  }, { immediate: true }), k.HOOK.beforeRefresh = () => {
    l.query.projectId = s.projectId, l.query.workshopId = s.workshopId, l.query.category = s.category, l.query.monomerId = s.monomerId, l.query.areaId = s.areaId;
  };
  function D(b) {
    Q("add", b, x);
  }
  return k.HOOK.handleRefresh = (b, f) => {
    var t;
    f.data.content = (t = f.data.content) == null ? void 0 : t.map((d) => (d.productQuantity = d.unPackageQuantity, d));
  }, N({ refresh: l.toQuery }), (b, f) => {
    const t = H, d = C("common-button"), M = C("common-table"), O = B;
    return a(), A("div", X, [p("div", Y, [m(e(J))]), E((a(), o(M, { ref_key: "tableRef", ref: w, data: e(l).data, "empty-text": e(l).emptyText, "max-height": _.maxHeight, style: { width: "100%" }, onSortChange: e(l).handleSortChange }, { default: u(() => [m(t, { label: "序号", type: "index", align: "center", width: "60" }, { default: u(({ row: n, $index: v }) => [n.workshop ? (a(), o(L, { key: 0, name: n.workshop.name }, null, 8, ["name"])) : r("", true), p("span", null, c(v + 1), 1)]), _: 1 }), e(i).visible("monomer.name") ? (a(), o(t, { key: 0, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(i).visible("area.name") ? (a(), o(t, { key: 1, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(i).visible("serialNumber") ? (a(), o(t, { key: 2, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(i).visible("specification") ? (a(), o(t, { key: 3, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: u(({ row: n }) => [p("span", null, c(n.specification), 1)]), _: 1 })) : r("", true), e(i).visible("length") ? (a(), o(t, { key: 4, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: u(({ row: n }) => [g(c(e(h)(n.length, e(y).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : r("", true), e(i).visible("material") ? (a(), o(t, { key: 5, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: u(({ row: n }) => [p("span", null, c(n.material), 1)]), _: 1 })) : r("", true), e(i).visible("netWeight") ? (a(), o(t, { key: 6, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: u(({ row: n }) => [g(c(e(h)(n.netWeight, e(y).COM_WT__KG)), 1)]), _: 1 })) : r("", true), e(i).visible("grossWeight") ? (a(), o(t, { key: 7, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: u(({ row: n }) => [g(c(e(h)(n.grossWeight, e(y).COM_WT__KG)), 1)]), _: 1 })) : r("", true), e(i).visible("drawingNumber") ? (a(), o(t, { key: 8, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : r("", true), e(i).visible("quantity") ? (a(), o(t, { key: 9, prop: "quantity", sortable: "custom", label: "清单数", align: "center", "min-width": "80px" })) : r("", true), e(i).visible("inQuantity") ? (a(), o(t, { key: 10, prop: "inQuantity", sortable: "custom", label: "入库量", align: "center", "min-width": "80px" })) : r("", true), e(i).visible("unPackageQuantity") ? (a(), o(t, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包量", align: "center", "min-width": "80px" })) : r("", true), e(i).visible("packageQuantity") ? (a(), o(t, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包量", align: "center", "min-width": "80px" })) : r("", true), e(U)(e(I).pack) ? (a(), o(t, { key: 13, label: "操作", width: "70", align: "center", fixed: "right" }, { default: u((n) => [m(d, { type: "success", icon: "el-icon-plus", disabled: q.value.includes(`${n.row.id}`), size: "default", onClick: (v) => D(n.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[O, e(l).loading]]), m(e(z))]);
  };
} }, ne = G(Z, [["__scopeId", "data-v-f1b91559"]]);
export {
  ne as default
};
