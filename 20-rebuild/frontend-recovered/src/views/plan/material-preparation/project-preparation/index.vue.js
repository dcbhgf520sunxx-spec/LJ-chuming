import { ref as g } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as o } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as u } from "vue";
import { withModifiers as L } from "vue";
import { createTextVNode as f } from "vue";
import { Fragment as j } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTag as E } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as S } from "./module/configure-project-preparation-type/preview.vue.js";
import { m as h } from "../../../../modules/plan-d12d7ccf.js";
import { sC as w, sD as V, x as $, o as F, i as v, G as H, an as I, P as O } from "../../../../shared/runtime.js";
import { _ as z } from "../../../../modules/E.operation-f0120ea4.js";
import K from "./module/header.vue.js";
import q from "./module/form/index.vue.js";
import G from "./module/detail.vue.js";
import { u as J } from "./module/form/list-and-match/tech-add-form.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "./module/configure-project-preparation-type/drawer.vue.js";
import "../../../../modules/use-table-change-32e98420.js";
import "./module/form/list-and-match/index.vue.js";
import "./module/form/list-and-match/tech-list/structure.vue.js";
import "./module/form/list-and-match/tech-list/enclosure.vue.js";
import "./module/form/list-and-match/tech-list/aux-material.vue.js";
import "./module/form/list-and-match/match-table.vue.js";
import "../../../../modules/factory-select-b8d0a4ac.js";
import "./module/form/inventory-table.vue.js";
import "./module/form/purchase-table.vue.js";
import "./module/form/purchase-material-add/dialog.vue.js";
import "./module/form/purchase-material-add/form/steel-plate.vue.js";
import "../../../../modules/use-purchase-material-form-info-d099f05d.js";
import "./module/form/purchase-material-add/form/section-steel.vue.js";
import "./module/form/purchase-material-add/form/aux-material.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const Q = { class: "app-container" }, W = { key: 0 }, X = { key: 1 }, Y = { key: 0 }, Z = { key: 1 }, Pe = { __name: "index", setup(ee) {
  const C = { add: false, edit: false, del: false, download: false }, b = g(), T = g([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["preparationUpdateTime", "parse-time"], ["listUpdateTime", "parse-time"], ["listUploaderNames", "split"], ["materialBasicClass", ["parse-enum", w, { bit: true }]], ["technologyListType", ["parse-enum", V]], ["project", ["parse-project", { onlyShortName: true }]]]), { CRUD: U, crud: d, columns: r } = $({ title: "项目备料", sort: ["id.desc"], invisibleColumns: ["createTime"], permission: { ...h }, optShow: { ...C }, crudApi: { ...S } }, b), { maxHeight: N } = F({ paginate: true }), { loaded: x } = J((c) => {
    d.props.steelClassifyConfICKV = c || {};
  }, true);
  U.HOOK.handleRefresh = (c, { data: m }) => {
  };
  function te() {
  }
  return (c, m) => {
    const a = D, _ = k("common-button"), y = E, M = k("common-table"), B = A;
    return t(), n("div", Q, [s(e(K)), R((t(), o(M, { ref_key: "tableRef", ref: b, data: e(d).data, "data-format": T.value, "max-height": e(N), "row-key": "id" }, { default: p(() => [s(a, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("serialNumber") ? (t(), o(a, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", label: "备料单号", "min-width": "140px" })) : l("", true), e(r).visible("project") ? (t(), o(a, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "项目", "min-width": "150" })) : l("", true), e(r).visible("monomer.name") ? (t(), o(a, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "120" })) : l("", true), e(r).visible("area.name") ? (t(), o(a, { key: "area.name", prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100" })) : l("", true), e(r).visible("technologyListType") ? (t(), o(a, { key: "technologyListType", "show-overflow-tooltip": true, prop: "technologyListType", label: "清单类型", align: "center", width: "70" })) : l("", true), e(r).visible("materialBasicClass") ? (t(), o(a, { key: "materialBasicClass", "show-overflow-tooltip": true, prop: "materialBasicClass", label: "物料种类", align: "center", width: "90" })) : l("", true), e(r).visible("listMete") ? (t(), o(a, { key: "listMete", "show-overflow-tooltip": true, prop: "listMete", label: "清单量", align: "center", width: "110" }, { default: p(({ row: { sourceRow: i } }) => [!(i.materialBasicClass & e(w).MATERIAL.V) && e(v)(i.listMete) ? (t(), n("span", W, u(i.listMete) + "  kg", 1)) : (t(), n("span", X, "-"))]), _: 1 })) : l("", true), e(r).visible("mete") ? (t(), o(a, { key: "mete", "show-overflow-tooltip": true, prop: "mete", label: "备料量", align: "center", width: "110" }, { default: p(({ row: { sourceRow: i } }) => [!(i.materialBasicClass & e(w).MATERIAL.V) && e(v)(i.preparationMete) ? (t(), n("span", Y, u(i.preparationMete) + "  kg", 1)) : (t(), n("span", Z, "-"))]), _: 1 })) : l("", true), e(r).visible("listUploaderNames") ? (t(), o(a, { key: "listUploaderNames", "show-overflow-tooltip": true, prop: "listUploaderNames", label: "清单上传人", align: "center", "min-width": "100" })) : l("", true), e(r).visible("preparationUpdaterName") ? (t(), o(a, { key: "preparationUpdaterName", "show-overflow-tooltip": true, prop: "preparationUpdaterName", label: "备料更新人", align: "center", width: "90" })) : l("", true), e(r).visible("createTime") ? (t(), o(a, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "创建日期", align: "center", width: "100" })) : l("", true), e(r).visible("listUpdateTime") ? (t(), o(a, { key: "listUpdateTime", "show-overflow-tooltip": true, prop: "listUpdateTime", label: "清单更新时间", align: "center", width: "125" })) : l("", true), e(r).visible("preparationUpdateTime") ? (t(), o(a, { key: "preparationUpdateTime", "show-overflow-tooltip": true, prop: "preparationUpdateTime", label: "备料更新时间", align: "center", width: "125" })) : l("", true), s(a, { label: "备料", width: "105", align: "center", fixed: "right" }, { default: p(({ row: { sourceRow: i } }) => [e(H)(e(h).edit) ? (t(), o(_, { key: 0, size: "default", type: i.boolPrepared ? "success" : "warning", plain: "", onClick: L((P) => e(d).toEdit(i), ["stop"]) }, { default: p(() => [f(u(i.boolPrepared ? "再次备料" : "前往备料"), 1)]), _: 2 }, 1032, ["type", "onClick"])) : (t(), n(j, { key: 1 }, [i.boolPrepared ? (t(), o(y, { key: 0, type: "success" }, { default: p(() => m[0] || (m[0] = [f("已备料")])), _: 1, __: [0] })) : (t(), o(y, { key: 1, type: "warning" }, { default: p(() => m[1] || (m[1] = [f("未备料")])), _: 1, __: [1] }))], 64))]), _: 1 }), s(a, { label: "操作", width: "170px", align: "center", fixed: "right" }, { default: p(({ row: i }) => [s(I, { "show-del": false, "show-edit": false, data: i, "detail-icon": "el-icon-tickets", "detail-type": null, "show-detail": "" }, null, 8, ["data"]), s(_, { size: "default", icon: "el-icon-clock", type: "info", onClick: (P) => (c.scope.row, void 0) }, null, 8, ["onClick"]), s(e(z), { data: i.id, permission: e(h).download }, null, 8, ["data", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[B, !e(x) || e(d).loading]]), s(e(O)), s(e(q)), s(e(G))]);
  };
} };
export {
  Pe as default
};
