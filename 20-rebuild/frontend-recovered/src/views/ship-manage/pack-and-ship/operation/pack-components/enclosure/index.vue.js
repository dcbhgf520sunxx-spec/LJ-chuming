import { inject as C } from "vue";
import { ref as S } from "vue";
import { nextTick as B } from "vue";
import { computed as K } from "vue";
import { watch as L } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as y } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as p } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { vLoading as z } from "element-plus";
import { a as F } from "../../../../../../modules/manual-pack-aab80853.js";
import { _ as G, x as J, bi as W, br as X, c as Y, D as I, bs as Z, G as ee, P as te, ba as ae } from "../../../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
const oe = { class: "app-container" }, re = { class: "head-container" }, ie = ["onClick"], se = { key: 1 }, le = { __name: "index", props: { projectId: { type: [String, Number], default: void 0 }, workshopId: { type: [String, Number], default: void 0 }, areaId: { type: [String, Number], default: void 0 }, maxHeight: { type: [String, Number], default: void 0 }, manufactureType: { type: [String, Number] } }, emits: ["add", "qhseNumbers", "batchAdd"], setup(q, { expose: P, emit: T }) {
  const k = C("permission"), A = { add: false, edit: false, del: false, download: false }, h = S(), { crud: i, columns: s, CRUD: w } = J({ title: "手工打包（围护）", sort: [], permission: { ...k }, optShow: { ...A }, crudApi: { get: F }, invisibleColumns: ["color", "packageQuantity"], queryOnPresenterCreated: false, hasPagination: true }, h), g = W.ENCLOSURE.K, f = T, l = q, v = S();
  B(() => {
    v.value = l.maxHeight;
  });
  const E = C("packData"), x = K(() => Object.keys(E[g]));
  function O(u) {
    return !u || u.id == null ? false : !x.value.includes(String(u.id));
  }
  L(() => [l.projectId, l.workshopId, l.batchId, l.manufactureType], () => {
    setTimeout(() => {
      i.toQuery();
    }, 100);
  }, { immediate: true }), w.HOOK.beforeRefresh = () => {
    i.query.projectId = l.projectId, i.query.workshopId = l.workshopId, i.query.areaId = l.areaId ? l.areaId : void 0, i.query.boolOutsourcing = !!l.manufactureType;
  };
  function D(u) {
    f("add", u, g);
  }
  function R() {
    f("batchAdd", i.selections, g), h.value.clearSelection();
  }
  w.HOOK.handleRefresh = (u, m) => {
    var b;
    m.data.content = (b = m.data.content) == null ? void 0 : b.map((t) => (t.productQuantity = t.unPackageQuantity, t));
  };
  function j(u) {
    return ae(u, { props: ["quantity", "inQuantity", "unPackageQuantity"] });
  }
  return P({ refresh: i.toQuery }), (u, m) => {
    const b = Q("common-button"), t = $, H = Q("common-table"), M = z;
    return n(), _("div", oe, [N("div", re, [d(e(ne)), d(b, { size: "default", type: "primary", onClick: R }, { default: c(() => m[0] || (m[0] = [y(" 批量添加 ")])), _: 1, __: [0] })]), V((n(), o(H, { ref_key: "tableRef", ref: h, data: e(i).data, "empty-text": e(i).emptyText, "max-height": v.value, style: { width: "100%" }, "summary-method": j, "show-summary": "", onSortChange: e(i).handleSortChange, onSelectionChange: e(i).selectionChangeHandler }, { default: c(() => [d(t, { key: "selection", type: "selection", width: "55", align: "center", selectable: O }), d(t, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("name") ? (n(), o(t, { key: "name", "show-overflow-tooltip": true, label: "名称", prop: "name", sortable: "custom", width: "120px" }, { default: c((a) => [a.row.workshop ? (n(), o(X, { key: 0, name: a.row.workshop.name }, null, 8, ["name"])) : r("", true), N("span", null, p(a.row.name), 1)]), _: 1 })) : r("", true), e(s).visible("serialNumber") ? (n(), o(t, { key: 1, align: "center", label: "编号", prop: "serialNumber", sortable: "custom", width: "120px" })) : r("", true), e(s).visible("plate") ? (n(), o(t, { key: "plate", "show-overflow-tooltip": true, align: "center", label: "板型", "min-width": "100px", prop: "plate", sortable: "custom" })) : r("", true), e(s).visible("color") ? (n(), o(t, { key: "color", "show-overflow-tooltip": true, align: "center", label: "颜色", "min-width": "100px", prop: "color", sortable: "custom" })) : r("", true), e(s).visible("weight") ? (n(), o(t, { key: "weight", label: `单重
(kg)`, "show-overflow-tooltip": true, align: "center", "min-width": "85px", prop: "weight", sortable: "custom" }, { default: c((a) => [y(p(a.row.weight), 1)]), _: 1 })) : r("", true), e(s).visible("surfaceArea") ? (n(), o(t, { key: "surfaceArea", label: `单面积
(m²)`, "show-overflow-tooltip": true, align: "center", "min-width": "85px", prop: "surfaceArea", sortable: "custom" }, { default: c((a) => [y(p(e(Y)(a.row.surfaceArea, "mm²", "m²", e(I).COM_AREA__M2)), 1)]), _: 1 })) : r("", true), e(s).visible("length") ? (n(), o(t, { key: "length", "show-overflow-tooltip": true, align: "center", label: "单长（mm）", prop: "length", sortable: "custom" }, { default: c((a) => [y(p(e(Z)(a.row.length, e(I).MES_ENCLOSURE_L__MM)), 1)]), _: 1 })) : r("", true), e(s).visible("quantity") ? (n(), o(t, { key: "quantity", align: "center", label: "清单数（件）", prop: "quantity", sortable: "custom" })) : r("", true), e(s).visible("inQuantity") ? (n(), o(t, { key: "inQuantity", align: "center", label: "入库数（件）", prop: "inQuantity", sortable: "custom" })) : r("", true), e(s).visible("unPackageQuantity") ? (n(), o(t, { key: "unPackageQuantity", align: "center", label: "可打包数（件）", prop: "unPackageQuantity", sortable: "custom" }, { default: c(({ row: a }) => [a.qhseNumbers ? (n(), _("span", { key: 0, style: { color: "red", cursor: "pointer" }, onClick: (U) => f("qhseNumbers", a) }, p(a.unPackageQuantity || "-"), 9, ie)) : (n(), _("span", se, p(a.unPackageQuantity || "-"), 1))]), _: 1 })) : r("", true), e(s).visible("packageQuantity") ? (n(), o(t, { key: "packageQuantity", align: "center", label: "已打包数（件）", prop: "packageQuantity", sortable: "custom" })) : r("", true), e(ee)(e(k).pack) ? (n(), o(t, { key: 11, align: "center", fixed: "right", label: "操作", width: "70" }, { default: c((a) => [d(b, { disabled: x.value.includes(`${a.row.id}`), icon: "el-icon-plus", size: "default", type: "success", onClick: (U) => D(a.row) }, null, 8, ["disabled", "onClick"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange", "onSelectionChange"])), [[M, e(i).loading]]), d(e(te))]);
  };
} }, me = G(le, [["__scopeId", "data-v-31937417"]]);
export {
  me as default
};
