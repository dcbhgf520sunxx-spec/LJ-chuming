import { inject as S } from "vue";
import { ref as T } from "vue";
import { nextTick as E } from "vue";
import { computed as L } from "vue";
import { watch as V } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as f } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as n } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as m } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as z } from "element-plus";
import { b as F } from "../../../../../../modules/manual-pack-aab80853.js";
import { _ as J, x as X, bi as Y, V as Z, br as q, bs as w, D as x, G as ee, P as te, ba as ae } from "../../../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
const ne = { class: "app-container" }, ie = { class: "head-container" }, re = ["onClick"], se = { key: 1 }, le = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 }, manufactureType: { type: [String, Number] }, areaBatchId: { type: [String, Number] } }, emits: ["add", "qhseNumbers", "batchAdd"], setup(v, { expose: P, emit: R }) {
  const C = S("permission"), D = { add: false, edit: false, del: false, download: false }, g = T(), { crud: r, columns: s, CRUD: I } = X({ title: "手工打包（结构）", sort: [], permission: { ...C }, optShow: { ...D }, crudApi: { get: F }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false }, g), y = Y.STRUCTURE.K, _ = R, l = v, O = T();
  E(() => {
    O.value = l.maxHeight;
  });
  const B = S("packData"), N = L(() => Object.keys(B[y]));
  function W(d) {
    return !d || d.id == null ? false : !N.value.includes(String(d.id));
  }
  V(() => [l.projectId, l.workshopId, l.monomerId, l.areaId, l.manufactureType, l.areaBatchId], () => {
    setTimeout(() => {
      r.toQuery();
    }, 100);
  }, { immediate: true, deep: true });
  function j(d) {
    _("add", d, y);
  }
  function A() {
    _("batchAdd", r.selections, y), g.value.clearSelection();
  }
  I.HOOK.beforeRefresh = () => {
    r.query.projectId = l.projectId, r.query.workshopId = l.workshopId, r.query.monomerId = l.monomerId, r.query.areaId = l.areaId, r.query.boolOutsourcing = !!l.manufactureType, r.query.areaBatchId = l.areaBatchId;
  }, I.HOOK.handleRefresh = (d, b) => {
    b.data.content = b.data.content.map((c, o) => (c.rowKey = `${y}_${Math.random()}_${o}`, c.productQuantity = c.unPackageQuantity, c.originNumberList = c.numberList && Z(c.numberList) || [], c));
  };
  function H(d) {
    return ae(d, { props: ["quantity", "inQuantity", "unPackageQuantity"] });
  }
  return P({ refresh: r.toQuery }), (d, b) => {
    const c = Q("common-button"), o = G, K = Q("common-table"), M = z;
    return a(), k("div", ne, [h("div", ie, [p(e(oe)), p(c, { size: "default", type: "primary", onClick: A }, { default: u(() => b[0] || (b[0] = [f(" 批量添加 ")])), _: 1, __: [0] })]), U((a(), n(K, { ref_key: "tableRef", ref: g, data: e(r).data, "empty-text": e(r).emptyText, "max-height": v.maxHeight, style: { width: "100%" }, "summary-method": H, "show-summary": "", onSortChange: e(r).handleSortChange, onSelectionChange: e(r).selectionChangeHandler }, { default: u(() => [p(o, { key: "selection", type: "selection", width: "55", align: "center", selectable: W }), p(o, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("monomer.name") ? (a(), n(o, { key: 0, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" })) : i("", true), e(s).visible("area.name") ? (a(), n(o, { key: 1, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "120px" })) : i("", true), e(s).visible("name") ? (a(), n(o, { key: "name", "show-overflow-tooltip": true, label: "名称", prop: "name", sortable: "custom", width: "120px" }, { default: u(({ row: t }) => [t.workshop ? (a(), n(q, { key: 0, name: t.workshop.name }, null, 8, ["name"])) : i("", true), h("span", null, m(t.name), 1)]), _: 1 })) : i("", true), e(s).visible("serialNumber") ? (a(), n(o, { key: 3, "show-overflow-tooltip": true, align: "center", label: "编号", prop: "serialNumber", sortable: "custom", width: "120px" }, { default: u(({ row: t }) => [t.warehouseType === 1 ? (a(), n(q, { key: 0, offset: 0, color: "#e64242", name: "回厂返修" })) : i("", true), h("span", null, m(t.serialNumber), 1)]), _: 1 })) : i("", true), e(s).visible("specification") ? (a(), n(o, { key: 4, "show-overflow-tooltip": true, label: "规格", "min-width": "140px", prop: "specification", sortable: "custom" }, { default: u(({ row: t }) => [h("span", null, m(t.specification), 1)]), _: 1 })) : i("", true), e(s).visible("length") ? (a(), n(o, { key: 5, label: `长度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "85px", prop: "length", sortable: "custom" }, { default: u(({ row: t }) => [f(m(e(w)(t.length, e(x).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : i("", true), e(s).visible("material") ? (a(), n(o, { key: 6, "show-overflow-tooltip": true, label: "材质", "min-width": "80px", prop: "material", sortable: "custom" }, { default: u(({ row: t }) => [h("span", null, m(t.material), 1)]), _: 1 })) : i("", true), e(s).visible("netWeight") ? (a(), n(o, { key: 7, label: `单净重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "netWeight", sortable: "custom" }, { default: u(({ row: t }) => [f(m(e(w)(t.netWeight, e(x).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(s).visible("grossWeight") ? (a(), n(o, { key: 8, label: `单毛重
(kg)`, "show-overflow-tooltip": true, align: "left", "min-width": "80px", prop: "grossWeight", sortable: "custom" }, { default: u(({ row: t }) => [f(m(e(w)(t.grossWeight, e(x).COM_WT__KG)), 1)]), _: 1 })) : i("", true), e(s).visible("drawingNumber") ? (a(), n(o, { key: 9, "show-overflow-tooltip": true, label: "图号", "min-width": "140px", prop: "drawingNumber", sortable: "custom" })) : i("", true), e(s).visible("quantity") ? (a(), n(o, { key: 10, align: "center", label: "清单数（件）", "min-width": "90px", prop: "quantity", sortable: "custom" })) : i("", true), e(s).visible("inQuantity") ? (a(), n(o, { key: 11, align: "center", label: "入库数（件）", "min-width": "90px", prop: "inQuantity", sortable: "custom" })) : i("", true), e(s).visible("unPackageQuantity") ? (a(), n(o, { key: "unPackageQuantity", align: "center", label: "可打包数（件）", "min-width": "95px", prop: "unPackageQuantity", sortable: "custom" }, { default: u(({ row: t }) => [t.qhseNumbers ? (a(), k("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: ($) => _("qhseNumbers", t) }, m(t.unPackageQuantity || "-"), 9, re)) : (a(), k("span", se, m(t.unPackageQuantity || "-"), 1))]), _: 1 })) : i("", true), e(s).visible("packageQuantity") ? (a(), n(o, { key: "packageQuantity", align: "center", label: "已打包数", "min-width": "80px", prop: "packageQuantity", sortable: "custom" })) : i("", true), e(ee)(e(C).pack) ? (a(), n(o, { key: 14, align: "center", fixed: "right", label: "操作", width: "70" }, { default: u(({ row: { sourceRow: t } }) => [p(c, { disabled: N.value.includes(`${t.id}`), icon: "el-icon-plus", size: "default", type: "success", onClick: ($) => j(t) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[M, e(r).loading]]), p(e(te))]);
  };
} }, pe = J(le, [["__scopeId", "data-v-b9d51617"]]);
export {
  pe as default
};
