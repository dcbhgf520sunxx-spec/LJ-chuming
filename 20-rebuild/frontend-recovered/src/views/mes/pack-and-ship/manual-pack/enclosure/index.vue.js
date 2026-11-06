import { ref as R } from "vue";
import { inject as D } from "vue";
import { computed as j } from "vue";
import { watch as A } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as w } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as o } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as d } from "vue";
import { createTextVNode as c } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as B } from "element-plus";
import { a as H } from "../../../../../modules/manual-pack-695cccc1.js";
import { _ as V, x as K, oc as x, br as $, bs as m, D as p, G as z } from "../../../../../shared/runtime.js";
import F from "./module/header.vue.js";
const G = { class: "app-container" }, W = { class: "head-container" }, v = 0, J = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workShopId: { type: [String, Number], default: void 0 }, category: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add"], setup(y, { expose: C, emit: N }) {
  const S = { add: false, edit: false, del: false, download: false }, f = R(), { crud: l, columns: n, CRUD: _ } = K({ title: "手工打包（围护）", sort: [], permission: { ...x }, optShow: { ...S }, crudApi: { get: H }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false, hasPagination: false }, f), I = N, s = y, Q = D("packData"), E = j(() => Object.keys(Q[v]));
  A(() => [s.projectId, s.workshopId, s.monomerId, s.areaId, s.category], () => {
    l.toQuery();
  }, { immediate: true }), _.HOOK.beforeRefresh = () => {
    l.query.projectId = s.projectId, l.query.workshopId = s.workshopId, l.query.category = s.category, l.query.monomerId = s.monomerId, l.query.areaId = s.areaId;
  };
  function M(b) {
    I("add", b, v);
  }
  return _.HOOK.handleRefresh = (b, h) => {
    h.data.content = h.data.enclosureList.map((t) => (t.productQuantity = t.unPackageQuantity, t));
  }, C({ refresh: l.toQuery }), (b, h) => {
    const t = U, q = g("common-button"), O = g("common-table"), P = B;
    return a(), T("div", G, [k("div", W, [w(e(F))]), L((a(), o(O, { ref_key: "tableRef", ref: f, data: e(l).data, "empty-text": e(l).emptyText, "max-height": y.maxHeight, style: { width: "100%" }, onSortChange: e(l).handleSortChange }, { default: u(() => [w(t, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("name") ? (a(), o(t, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: u((i) => [i.row.workshop ? (a(), o($, { key: 0, name: i.row.workshop.name }, null, 8, ["name"])) : r("", true), k("span", null, d(i.row.name), 1)]), _: 1 })) : r("", true), e(n).visible("monomer.name") ? (a(), o(t, { key: 1, prop: "monomer.name", label: "单体", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(n).visible("area.name") ? (a(), o(t, { key: 2, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(n).visible("serialNumber") ? (a(), o(t, { key: 3, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "120px" })) : r("", true), e(n).visible("plate") ? (a(), o(t, { key: "plate", prop: "plate", sortable: "custom", "show-overflow-tooltip": true, label: "板型", "min-width": "100px" })) : r("", true), e(n).visible("color") ? (a(), o(t, { key: "color", prop: "color", sortable: "custom", "show-overflow-tooltip": true, label: "颜色", "min-width": "100px" })) : r("", true), e(n).visible("thickness") ? (a(), o(t, { key: "thickness", prop: "thickness", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: u((i) => [c(d(e(m)(i.row.thickness, e(p).MES_ENCLOSURE_T__MM)), 1)]), _: 1 })) : r("", true), e(n).visible("width") ? (a(), o(t, { key: "width", prop: "width", sortable: "custom", "show-overflow-tooltip": true, label: `有效宽度
(mm)`, align: "left", "min-width": "85px" }, { default: u((i) => [c(d(e(m)(i.row.width, e(p).MES_ENCLOSURE_W__MM)), 1)]), _: 1 })) : r("", true), e(n).visible("length") ? (a(), o(t, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: u((i) => [c(d(e(m)(i.row.length, e(p).MES_ENCLOSURE_L__MM)), 1)]), _: 1 })) : r("", true), e(n).visible("totalArea") ? (a(), o(t, { key: "totalArea", prop: "totalArea", sortable: "custom", "show-overflow-tooltip": true, label: `总面积
(㎡)`, align: "left", "min-width": "100px" }, { default: u((i) => [c(d(e(m)(i.row.totalArea, e(p).COM_AREA__M2)), 1)]), _: 1 })) : r("", true), e(n).visible("drawingNumber") ? (a(), o(t, { key: "drawingNumber", prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : r("", true), e(n).visible("quantity") ? (a(), o(t, { key: "quantity", prop: "quantity", sortable: "custom", label: "清单数", align: "center", "min-width": "80px" })) : r("", true), e(n).visible("inQuantity") ? (a(), o(t, { key: "inQuantity", prop: "inQuantity", sortable: "custom", label: "入库量", align: "center", "min-width": "80px" })) : r("", true), e(n).visible("unPackageQuantity") ? (a(), o(t, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包量", align: "center", "min-width": "80px" })) : r("", true), e(n).visible("packageQuantity") ? (a(), o(t, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包量", align: "center", "min-width": "80px" })) : r("", true), e(z)(e(x).pack) ? (a(), o(t, { key: 15, label: "操作", width: "70", align: "center", fixed: "right" }, { default: u((i) => [w(q, { type: "success", icon: "el-icon-plus", disabled: E.value.includes(`${i.row.id}`), size: "default", onClick: (X) => M(i.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[P, e(l).loading]])]);
  };
} }, ae = V(J, [["__scopeId", "data-v-5a1bbd38"]]);
export {
  ae as default
};
