import { ref as N } from "vue";
import { nextTick as H } from "vue";
import { inject as K } from "vue";
import { computed as E } from "vue";
import { watch as V } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as n } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { vShow as $ } from "vue";
import { createTextVNode as b } from "vue";
import { ElTableColumn as G } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as L } from "../../../../../modules/manual-pack-aab80853.js";
import { a as S } from "../../../../../modules/ship-manage-3066b2ed.js";
import { _ as U, x as z, bi as J, br as T, bs as y, D as k, G as X, P as Y } from "../../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
const ee = { class: "app-container" }, te = { class: "head-container" }, ae = ["onClick"], oe = { key: 1 }, ne = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, monomerId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, areaBatchId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 } }, emits: ["add", "qhseNumbers"], setup(q, { expose: D, emit: M }) {
  const O = { add: false, edit: false, del: false, download: false }, w = N(), { crud: l, columns: i, CRUD: v } = z({ title: "手工打包（直发件）", sort: [], permission: { ...S }, optShow: { ...O }, crudApi: { get: L }, invisibleColumns: ["drawingNumber", "packageQuantity"], queryOnPresenterCreated: false }, w), x = J.MACHINE_PART.K, I = M, u = q, C = N();
  H(() => {
    C.value = u.maxHeight;
  });
  const R = K("packData"), W = E(() => Object.keys(R[x]));
  V(() => [u.projectId, u.workshopId, u.monomerId, u.areaId], () => {
    setTimeout(() => {
      l.toQuery();
    }, 100);
  }, { immediate: true }), v.HOOK.beforeRefresh = () => {
    l.query.projectId = u.projectId, l.query.workshopId = u.workshopId, l.query.monomerId = u.monomerId, l.query.areaId = u.areaId, l.query.areaBatchId = u.areaBatchId;
  };
  function j(h) {
    I("add", h, x);
  }
  return v.HOOK.handleRefresh = (h, f) => {
    var o;
    f.data.content = (o = f.data.content) == null ? void 0 : o.map((d) => (d.productQuantity = d.unPackageQuantity, d));
  }, D({ refresh: l.toQuery }), (h, f) => {
    const o = G, d = P("common-button"), B = P("common-table"), A = F;
    return a(), _("div", ee, [p("div", te, [m(e(Z))]), Q((a(), n(B, { ref_key: "tableRef", ref: w, data: e(l).data, "empty-text": e(l).emptyText, "max-height": C.value, style: { width: "100%" }, onSortChange: e(l).handleSortChange }, { default: s(() => [m(o, { label: "序号", type: "index", align: "center", width: "60" }, { default: s(({ row: t, $index: g }) => [t.workshop ? (a(), n(T, { key: 0, name: t.workshop.name }, null, 8, ["name"])) : r("", true), p("span", null, c(g + 1), 1)]), _: 1 }), e(i).visible("monomer.name") ? (a(), n(o, { key: 0, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", sortable: "custom", align: "center", width: "100px" }, { default: s(({ row: t }) => [Q(m(T, { name: "檩条直发", color: "#f56c6c" }, null, 512), [[$, t.boolAllPartSendDirectly]]), p("span", null, c(t.monomer.name), 1)]), _: 1 })) : r("", true), e(i).visible("area.name") ? (a(), n(o, { key: 1, "show-overflow-tooltip": true, prop: "area.name", label: "区域", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(i).visible("serialNumber") ? (a(), n(o, { key: 2, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", sortable: "custom", align: "center", width: "100px" })) : r("", true), e(i).visible("specification") ? (a(), n(o, { key: 3, "show-overflow-tooltip": true, prop: "specification", sortable: "custom", label: "规格", "min-width": "140px" }, { default: s(({ row: t }) => [p("span", null, c(t.specification), 1)]), _: 1 })) : r("", true), e(i).visible("length") ? (a(), n(o, { key: 4, prop: "length", sortable: "custom", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: s(({ row: t }) => [b(c(e(y)(t.length, e(k).MES_ARTIFACT_L__MM)), 1)]), _: 1 })) : r("", true), e(i).visible("material") ? (a(), n(o, { key: 5, prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }, { default: s(({ row: t }) => [p("span", null, c(t.material), 1)]), _: 1 })) : r("", true), e(i).visible("netWeight") ? (a(), n(o, { key: 6, prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: s(({ row: t }) => [b(c(e(y)(t.netWeight, e(k).COM_WT__KG)), 1)]), _: 1 })) : r("", true), e(i).visible("grossWeight") ? (a(), n(o, { key: 7, prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: s(({ row: t }) => [b(c(e(y)(t.grossWeight, e(k).COM_WT__KG)), 1)]), _: 1 })) : r("", true), e(i).visible("drawingNumber") ? (a(), n(o, { key: 8, prop: "drawingNumber", sortable: "custom", "show-overflow-tooltip": true, label: "图号", "min-width": "140px" })) : r("", true), e(i).visible("quantity") ? (a(), n(o, { key: 9, prop: "quantity", sortable: "custom", label: "清单数（件）", align: "center", "min-width": "80px" })) : r("", true), e(i).visible("inQuantity") ? (a(), n(o, { key: 10, prop: "inQuantity", sortable: "custom", label: "入库数（件）", align: "center", "min-width": "80px" })) : r("", true), e(i).visible("unPackageQuantity") ? (a(), n(o, { key: "unPackageQuantity", prop: "unPackageQuantity", sortable: "custom", label: "可打包数（件）", align: "center", "min-width": "80px" }, { default: s(({ row: t }) => [t.qhseNumbers ? (a(), _("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (g) => I("qhseNumbers", t) }, c(t.unPackageQuantity || "-"), 9, ae)) : (a(), _("span", oe, c(t.unPackageQuantity || "-"), 1))]), _: 1 })) : r("", true), e(i).visible("packageQuantity") ? (a(), n(o, { key: "packageQuantity", prop: "packageQuantity", sortable: "custom", label: "已打包数（件）", align: "center", "min-width": "80px" })) : r("", true), e(i).visible("remark") ? (a(), n(o, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注", align: "center", "min-width": "100" }, { default: s((t) => [b(c(t.row.remark ? t.row.remark : "-"), 1)]), _: 1 })) : r("", true), e(X)(e(S).pack) ? (a(), n(o, { key: 14, label: "操作", width: "70", align: "center", fixed: "right" }, { default: s((t) => [m(d, { type: "success", icon: "el-icon-plus", disabled: W.value.includes(`${t.row.id}`), size: "default", onClick: (g) => j(t.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[A, e(l).loading]]), m(e(Y))]);
  };
} }, ce = U(ne, [["__scopeId", "data-v-46992b20"]]);
export {
  ce as default
};
