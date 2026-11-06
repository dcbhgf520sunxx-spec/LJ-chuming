import { ref as v } from "vue";
import { nextTick as j } from "vue";
import { inject as A } from "vue";
import { computed as B } from "vue";
import { watch as H } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as n } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as u } from "vue";
import { createTextVNode as y } from "vue";
import { ElTableColumn as K } from "element-plus";
import { vLoading as L } from "element-plus";
import { a as V } from "../../../../../modules/manual-pack-aab80853.js";
import { a as I } from "../../../../../modules/ship-manage-3066b2ed.js";
import { _ as $, x as z, bi as F, br as G, c as J, D as N, bs as W, G as X, P as Y } from "../../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
const ee = { class: "app-container" }, te = { class: "head-container" }, ae = ["onClick"], oe = { key: 1 }, ne = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, areaBatchId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add", "qhseNumbers"], setup(Q, { expose: P, emit: S }) {
  const q = { add: false, edit: false, del: false, download: false }, f = v(), { crud: s, columns: i, CRUD: _ } = z({ title: "手工打包（围护）", sort: [], permission: { ...I }, optShow: { ...q }, crudApi: { get: V }, invisibleColumns: ["color", "packageQuantity"], queryOnPresenterCreated: false, hasPagination: true }, f), g = F.ENCLOSURE.K, k = S, l = Q, w = v();
  j(() => {
    w.value = l.maxHeight;
  });
  const E = A("packData"), T = B(() => Object.keys(E[g]));
  H(() => [l.projectId, l.workshopId, l.batchId], () => {
    setTimeout(() => {
      s.toQuery();
    }, 100);
  }, { immediate: true }), _.HOOK.beforeRefresh = () => {
    s.query.projectId = l.projectId, s.query.workshopId = l.workshopId, s.query.areaId = l.areaId ? l.areaId : void 0, s.query.areaBatchId = l.areaBatchId;
  };
  function D(m) {
    k("add", m, g);
  }
  return _.HOOK.handleRefresh = (m, b) => {
    var o;
    b.data.content = (o = b.data.content) == null ? void 0 : o.map((d) => (d.productQuantity = d.unPackageQuantity, d));
  }, P({ refresh: s.toQuery }), (m, b) => {
    const o = K, d = x("common-button"), O = x("common-table"), R = L;
    return a(), h("div", ee, [C("div", te, [p(e(Z))]), U((a(), n(O, { ref_key: "tableRef", ref: f, data: e(s).data, "empty-text": e(s).emptyText, "max-height": w.value, style: { width: "100%" }, onSortChange: e(s).handleSortChange }, { default: c(() => [p(o, { label: "序号", type: "index", align: "center", width: "60" }), e(i).visible("name") ? (a(), n(o, { key: "name", prop: "name", sortable: "custom", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: c((t) => [t.row.workshop ? (a(), n(G, { key: 0, name: t.row.workshop.name }, null, 8, ["name"])) : r("", true), C("span", null, u(t.row.name), 1)]), _: 1 })) : r("", true), e(i).visible("serialNumber") ? (a(), n(o, { key: 1, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "120px" })) : r("", true), e(i).visible("plate") ? (a(), n(o, { key: "plate", prop: "plate", sortable: "custom", "show-overflow-tooltip": true, label: "板型", align: "center", "min-width": "100px" })) : r("", true), e(i).visible("color") ? (a(), n(o, { key: "color", prop: "color", sortable: "custom", "show-overflow-tooltip": true, label: "颜色", align: "center", "min-width": "100px" })) : r("", true), e(i).visible("weight") ? (a(), n(o, { key: "weight", prop: "weight", sortable: "custom", "show-overflow-tooltip": true, label: `单重
(kg)`, align: "center", "min-width": "85px" }, { default: c((t) => [y(u(t.row.weight), 1)]), _: 1 })) : r("", true), e(i).visible("surfaceArea") ? (a(), n(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", "show-overflow-tooltip": true, label: `单面积
(m²)`, align: "center", "min-width": "85px" }, { default: c((t) => [y(u(e(J)(t.row.surfaceArea, "mm²", "m²", e(N).COM_AREA__M2)), 1)]), _: 1 })) : r("", true), e(i).visible("length") ? (a(), n(o, { key: "length", prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: "单长（mm）", align: "center" }, { default: c((t) => [y(u(e(W)(t.row.length, e(N).MES_ENCLOSURE_L__MM)), 1)]), _: 1 })) : r("", true), e(i).visible("quantity") ? (a(), n(o, { key: "quantity", prop: "quantity", sortable: "custom", label: "清单数（件）", align: "center" })) : r("", true), e(i).visible("inQuantity") ? (a(), n(o, { key: "inQuantity", prop: "inQuantity", sortable: "custom", label: "入库数（件）", align: "center" })) : r("", true), e(i).visible("unPackageQuantity") ? (a(), n(o, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包数（件）", align: "center" }, { default: c(({ row: t }) => [t.qhseNumbers ? (a(), h("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (M) => k("qhseNumbers", t) }, u(t.unPackageQuantity || "-"), 9, ae)) : (a(), h("span", oe, u(t.unPackageQuantity || "-"), 1))]), _: 1 })) : r("", true), e(i).visible("packageQuantity") ? (a(), n(o, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包数（件）", align: "center" })) : r("", true), e(X)(e(I).pack) ? (a(), n(o, { key: 11, label: "操作", width: "70", align: "center", fixed: "right" }, { default: c((t) => [p(d, { type: "success", icon: "el-icon-plus", disabled: T.value.includes(`${t.row.id}`), size: "default", onClick: (M) => D(t.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[R, e(s).loading]]), p(e(Y))]);
  };
} }, ue = $(ne, [["__scopeId", "data-v-9bccbbc1"]]);
export {
  ue as default
};
