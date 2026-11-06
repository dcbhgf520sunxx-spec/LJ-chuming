import { ref as _ } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as f } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as g } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as Q } from "../../../../../modules/nesting-setting-83aca0bd.js";
import { x as R, nr as M, o as P, aU as V } from "../../../../../shared/runtime.js";
import W from "./module/header.vue.js";
import "./module/no-nesting-drawer.vue.js";
import "../../../../../modules/popover-confirm-35927771.js";
import "./module/extrusion-nesting-setting.vue.js";
import "./module/nesting-progress.vue.js";
const B = { class: "app-container" }, I = { class: "head-container" }, U = { key: 0, class: "tc-success" }, j = { key: 1 }, $ = { __name: "index", setup(A) {
  const N = { add: false, edit: false, del: false, download: false }, v = _(), { crud: c, columns: l, CRUD: C } = R({ title: "套料设置", sort: [], permission: { ...M }, optShow: { ...N }, crudApi: { ...Q }, hasPagination: false, queryOnPresenterCreated: false, requiredQuery: ["projectId", "specPrefix"] }, v), { maxHeight: k } = P(), S = _("nesting"), b = _({});
  C.HOOK.handleRefresh = (d, s) => {
    var p, t, m;
    b.value = { totalNetWeight: (p = s.data) == null ? void 0 : p.totalNetWeight, totalQuantity: (t = s.data) == null ? void 0 : t.totalQuantity }, s.data.content = ((m = s.data) == null ? void 0 : m.nestingDTOS.map((r) => {
      var h, o;
      return r.editQuantity = r.quantity, r.artifactStr = (h = r.artifactTypesettingDTO) == null ? void 0 : h.serialNumber, r.classificationName = (o = r.artifactTypesettingDTO) == null ? void 0 : o.classificationName, r;
    })) || [];
  };
  function T({ column: d, prop: s, order: p }) {
    s === "length" ? c.query.boolLength = p === "ascending" : c.query.boolLength = false, c.toQuery();
  }
  function q(d) {
    S.value = d;
  }
  return (d, s) => {
    const p = H, t = L, m = x("table-cell-tag"), r = x("common-table"), h = O;
    return a(), w("div", B, [y("div", I, [f(e(W), { onChangeMode: q }, { viewLeft: u(() => [f(p, { size: "large", type: "warning", effect: "plain", style: { "margin-right": "5px" } }, { default: u(() => [D(" 清单量：" + g(b.value.totalQuantity || 0) + " 件 | " + g(b.value.totalNetWeight || 0) + " t", 1)]), _: 1 })]), _: 1 })]), E((a(), i(r, { ref_key: "tableRef", ref: v, data: e(c).data, "empty-text": "暂无数据", "max-height": e(k), style: { width: "100%" }, onSortChange: T, onSelectionChange: e(c).selectionChangeHandler }, { default: u(() => [f(t, { type: "selection", width: "55", align: "center" }), f(t, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("monomer.name") ? (a(), i(t, { key: 0, prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "120px", align: "center" })) : n("", true), e(l).visible("area.name") ? (a(), i(t, { key: 1, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "120px", align: "center" })) : n("", true), e(l).visible("serialNumber") ? (a(), i(t, { key: 2, prop: "serialNumber", "show-overflow-tooltip": true, label: "部件编号", "min-width": "120px", align: "center" }, { default: u(({ row: o }) => [o.productionLineTypeEnum === e(V).INTELLECT.V ? (a(), i(m, { key: 0, name: o.classificationName, color: o.classificationName === "短梁" || o.classificationName === "长短梁" ? "#40ed8d" : "#fad400", offset: 15 }, null, 8, ["name", "color"])) : n("", true), y("span", null, g(o.serialNumber), 1)]), _: 1 })) : n("", true), e(l).visible("quantity") ? (a(), i(t, { key: 3, prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "120px" }, { default: u(({ row: { sourceRow: o } }) => [y("span", null, g(o.quantity), 1)]), _: 1 })) : n("", true), e(l).visible("artifactStr") ? (a(), i(t, { key: 4, prop: "artifactStr", "show-overflow-tooltip": true, label: "关联构件", "min-width": "120px", align: "center" })) : n("", true), e(l).visible("specification") ? (a(), i(t, { key: 5, prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" })) : n("", true), e(l).visible("length") ? (a(), i(t, { key: 6, prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", sortable: "custom", align: "center", width: "120px" })) : n("", true), e(l).visible("material") ? (a(), i(t, { key: 7, prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center", width: "100px" })) : n("", true), e(l).visible("netWeight") ? (a(), i(t, { key: 8, prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", align: "center", width: "100px" })) : n("", true), e(l).visible("boolHaveNC1") ? (a(), i(t, { key: 9, prop: "boolHaveNC1", "show-overflow-tooltip": true, label: "NC1", width: "80px", align: "center" }, { default: u(({ row: o }) => [o.boolHaveNC1 ? (a(), w("span", U, "√")) : (a(), w("span", j, "-"))]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "max-height", "onSelectionChange"])), [[h, e(c).loading]])]);
  };
} };
export {
  $ as default
};
