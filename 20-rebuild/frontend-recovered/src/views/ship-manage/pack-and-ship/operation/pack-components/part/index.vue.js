import { inject as Q } from "vue";
import { ref as P } from "vue";
import { nextTick as G } from "vue";
import { computed as z } from "vue";
import { watch as F } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as y } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as n } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { vShow as L } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as X } from "../../../../../../modules/manual-pack-aab80853.js";
import { _ as Y, x as Z, bi as ee, br as A, bs as v, D as x, G as te, P as ae, ba as oe } from "../../../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
const re = { class: "app-container" }, ie = { class: "head-container" }, le = ["onClick"], se = { key: 1 }, ue = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 }, areaBatchId: { type: [String, Number] }, manufactureType: { type: [String, Number] } }, emits: ["add", "qhseNumbers"], setup(O, { expose: B, emit: R }) {
  const C = Q("permission"), W = { add: false, edit: false, del: false, download: false }, g = P(), { crud: i, columns: l, CRUD: I } = Z({ title: "手工打包（直发件）", sort: [], permission: { ...C }, optShow: { ...W }, crudApi: { get: X }, invisibleColumns: ["drawingNumber", "packageQuantity", "batchAdd"], queryOnPresenterCreated: false }, g), _ = ee.MACHINE_PART.K, k = R, s = O, S = P();
  G(() => {
    S.value = s.maxHeight;
  });
  const j = Q("packData"), N = z(() => Object.keys(j[_]));
  function H(d) {
    return !d || d.id == null ? false : !N.value.includes(String(d.id));
  }
  F(() => [s.projectId, s.workshopId, s.monomerId, s.areaId, s.areaBatchId, s.manufactureType], () => {
    setTimeout(() => {
      i.toQuery();
    }, 100);
  }, { immediate: true }), I.HOOK.beforeRefresh = () => {
    i.query.projectId = s.projectId, i.query.workshopId = s.workshopId, i.query.monomerId = s.monomerId, i.query.areaId = s.areaId, i.query.areaBatchId = s.areaBatchId, i.query.boolOutsourcing = !!s.manufactureType;
  };
  function M(d) {
    k("add", d, _);
  }
  function K() {
    k("batchAdd", i.selections, _), g.value.clearSelection();
  }
  I.HOOK.handleRefresh = (d, b) => {
    var h;
    b.data.content = (h = b.data.content) == null ? void 0 : h.map((a) => (a.productQuantity = a.unPackageQuantity, a));
  };
  function E(d) {
    return oe(d, { props: ["quantity", "inQuantity", "unPackageQuantity"] });
  }
  return B({ refresh: i.toQuery }), (d, b) => {
    const h = q("common-button"), a = U, V = q("common-table"), $ = J;
    return o(), w("div", re, [f("div", ie, [m(e(ne)), m(h, { size: "default", type: "primary", onClick: K }, { default: u(() => b[0] || (b[0] = [y(" 批量添加 ")])), _: 1, __: [0] })]), D((o(), n(V, { ref_key: "tableRef", ref: g, data: e(i).data, "empty-text": e(i).emptyText, "max-height": S.value, style: { width: "100%" }, "summary-method": E, "show-summary": "", onSortChange: e(i).handleSortChange, onSelectionChange: e(i).selectionChangeHandler }, { default: u(() => [m(a, { key: "selection", type: "selection", width: "55", align: "center", selectable: H }), m(a, { label: "序号", type: "index", align: "center", width: "60" }, { default: u(({ row: t, $index: p }) => {
      var T;
      return [t.workshop ? (o(), n(A, { key: 0, name: (T = t.workshop) == null ? void 0 : T.name }, null, 8, ["name"])) : r("", true), f("span", null, c(p + 1), 1)];
    }), _: 1 }), e(l).visible("monomer.name") ? (o(), n(a, { key: 0, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" }, { default: u(({ row: t }) => {
      var p;
      return [D(m(A, { name: "檩条直发", color: "#f56c6c" }, null, 512), [[L, t.boolAllPartSendDirectly]]), f("span", null, c((p = t.monomer) == null ? void 0 : p.name), 1)];
    }), _: 1 })) : r("", true), e(l).visible("area.name") ? (o(), n(a, { key: 1, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(l).visible("serialNumber") ? (o(), n(a, { key: 2, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(l).visible("specification") ? (o(), n(a, { key: 3, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: u(({ row: t }) => [f("span", null, c(t.specification), 1)]), _: 1 })) : r("", true), e(l).visible("length") ? (o(), n(a, { key: 4, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: u(({ row: t }) => [y(c(e(v)(t.length, e(x).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : r("", true), e(l).visible("material") ? (o(), n(a, { key: 5, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: u(({ row: t }) => [f("span", null, c(t.material), 1)]), _: 1 })) : r("", true), e(l).visible("netWeight") ? (o(), n(a, { key: 6, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: u(({ row: t }) => [y(c(e(v)(t.netWeight, e(x).COM_WT__KG)), 1)]), _: 1 })) : r("", true), e(l).visible("grossWeight") ? (o(), n(a, { key: 7, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: u(({ row: t }) => [y(c(e(v)(t.grossWeight, e(x).COM_WT__KG)), 1)]), _: 1 })) : r("", true), e(l).visible("drawingNumber") ? (o(), n(a, { key: 8, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : r("", true), e(l).visible("quantity") ? (o(), n(a, { key: 9, prop: "quantity", sortable: "custom", label: "清单数（件）", align: "center", "min-width": "90px" })) : r("", true), e(l).visible("inQuantity") ? (o(), n(a, { key: 10, prop: "inQuantity", sortable: "custom", label: "入库数（件）", align: "center", "min-width": "90px" })) : r("", true), e(l).visible("unPackageQuantity") ? (o(), n(a, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包数（件）", align: "center", "min-width": "95px" }, { default: u(({ row: t }) => [t.qhseNumbers ? (o(), w("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (p) => k("qhseNumbers", t) }, c(t.unPackageQuantity || "-"), 9, le)) : (o(), w("span", se, c(t.unPackageQuantity || "-"), 1))]), _: 1 })) : r("", true), e(l).visible("packageQuantity") ? (o(), n(a, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包数（件）", align: "center", "min-width": "80px" })) : r("", true), e(l).visible("remark") ? (o(), n(a, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: u((t) => [y(c(t.row.remark ? t.row.remark : "-"), 1)]), _: 1 })) : r("", true), e(te)(e(C).pack) ? (o(), n(a, { key: 14, label: "操作", width: "70", align: "center", fixed: "right" }, { default: u((t) => [m(h, { type: "success", icon: "el-icon-plus", disabled: N.value.includes(`${t.row.id}`), size: "default", onClick: (p) => M(t.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[$, e(i).loading]]), m(e(ae))]);
  };
} }, be = Y(ue, [["__scopeId", "data-v-1459c7f5"]]);
export {
  be as default
};
