import { ref as M } from "vue";
import { inject as O } from "vue";
import { computed as W } from "vue";
import { watch as j } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as K } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as c } from "vue";
import { createTextVNode as g } from "vue";
import { ElTableColumn as E } from "element-plus";
import { vLoading as L } from "element-plus";
import { b as V } from "../../../../../modules/manual-pack-695cccc1.js";
import { _ as A, x as B, oc as C, bi as H, V as U, br as G, bs as _, D as y, G as F, P as z } from "../../../../../shared/runtime.js";
import J from "./module/header.vue.js";
const X = { class: "app-container" }, Y = { class: "head-container" }, Z = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add"], setup(w, { expose: I, emit: N }) {
  const T = { add: false, edit: false, del: false, download: false }, k = M(), { crud: l, columns: r, CRUD: x } = B({ title: "手工打包（结构）", sort: [], permission: { ...C }, optShow: { ...T }, crudApi: { get: V }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false }, k), m = H.STRUCTURE.K, Q = N, s = w, S = O("packData"), P = W(() => Object.keys(S[m]));
  j(() => [s.projectId, s.workshopId, s.monomerId, s.areaId], () => {
    l.toQuery();
  }, { immediate: true, deep: true });
  function R(b) {
    Q("add", b, m);
  }
  return x.HOOK.beforeRefresh = () => {
    l.query.projectId = s.projectId, l.query.workshopId = s.workshopId, l.query.monomerId = s.monomerId, l.query.areaId = s.areaId;
  }, x.HOOK.handleRefresh = (b, h) => {
    h.data.content = h.data.content.map((t, f) => (t.rowKey = `${m}_${Math.random()}_${f}`, t.productQuantity = t.unPackageQuantity, t.originNumberList = t.numberList && U(t.numberList) || [], t));
  }, I({ refresh: l.toQuery }), (b, h) => {
    const t = E, f = v("common-button"), D = v("common-table"), q = L;
    return a(), K("div", X, [d("div", Y, [p(e(J))]), $((a(), o(D, { ref_key: "tableRef", ref: k, data: e(l).data, "empty-text": e(l).emptyText, "max-height": w.maxHeight, style: { width: "100%" }, onSortChange: e(l).handleSortChange }, { default: u(() => [p(t, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("name") ? (a(), o(t, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: u(({ row: n }) => [n.workshop ? (a(), o(G, { key: 0, name: n.workshop.name }, null, 8, ["name"])) : i("", true), d("span", null, c(n.name), 1)]), _: 1 })) : i("", true), e(r).visible("monomer.name") ? (a(), o(t, { key: 1, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" })) : i("", true), e(r).visible("area.name") ? (a(), o(t, { key: 2, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : i("", true), e(r).visible("serialNumber") ? (a(), o(t, { key: 3, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "120px" })) : i("", true), e(r).visible("specification") ? (a(), o(t, { key: 4, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: u(({ row: n }) => [d("span", null, c(n.specification), 1)]), _: 1 })) : i("", true), e(r).visible("length") ? (a(), o(t, { key: 5, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: u(({ row: n }) => [g(c(e(_)(n.length, e(y).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : i("", true), e(r).visible("material") ? (a(), o(t, { key: 6, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: u(({ row: n }) => [d("span", null, c(n.material), 1)]), _: 1 })) : i("", true), e(r).visible("netWeight") ? (a(), o(t, { key: 7, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: u(({ row: n }) => [g(c(e(_)(n.netWeight, e(y).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(r).visible("grossWeight") ? (a(), o(t, { key: 8, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: u(({ row: n }) => [g(c(e(_)(n.grossWeight, e(y).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(r).visible("drawingNumber") ? (a(), o(t, { key: 9, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : i("", true), e(r).visible("quantity") ? (a(), o(t, { key: 10, prop: "quantity", sortable: "custom", label: "清单数", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("inQuantity") ? (a(), o(t, { key: 11, prop: "inQuantity", sortable: "custom", label: "入库量", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("unPackageQuantity") ? (a(), o(t, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包量", align: "center", "min-width": "80px" })) : i("", true), e(r).visible("packageQuantity") ? (a(), o(t, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包量", align: "center", "min-width": "80px" })) : i("", true), e(F)(e(C).pack) ? (a(), o(t, { key: 14, label: "操作", width: "70", align: "center", fixed: "right" }, { default: u(({ row: { sourceRow: n } }) => [p(f, { type: "success", icon: "el-icon-plus", disabled: P.value.includes(`${n.id}`), size: "default", onClick: (ee) => R(n) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[q, e(l).loading]]), p(e(z))]);
  };
} }, ie = A(Z, [["__scopeId", "data-v-619bc581"]]);
export {
  ie as default
};
