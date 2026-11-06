import { ref as b } from "vue";
import { nextTick as I } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as r } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as k } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as x } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as Q } from "element-plus";
import { i as P } from "../../../../../../modules/warehouse-management-aa3a73c1.js";
import { _ as D, Au as K, x as L, Av as O, cP as S, jR as v, cS as R, i as W, k6 as B, P as H } from "../../../../../../shared/runtime.js";
import { u as $ } from "../../../../../../modules/use-index-info-a6458974.js";
import G from "./module/header.vue.js";
import J from "./manufactured-essential-information/index.vue.js";
import "../../../../../../modules/use-header-info-847d35a5.js";
import "./manufactured-essential-information/module/enclosure.vue.js";
import "./manufactured-essential-information/module/structure.vue.js";
const X = { class: "app-container" }, Y = { __name: "index", setup(Z) {
  const E = { add: false, edit: false, del: false, download: false }, w = b(), d = b([]), f = b([]), U = b([["basicClass", ["parse-enum", K, { f: "L" }]]]), { CRUD: y, crud: p, columns: n } = L({ title: "制成品物料仓", sort: ["id.desc"], invisibleColumns: [], requiredQuery: ["projectId"], permission: { ...O }, optShow: { ...E }, crudApi: { get: P } }, w), { headerRef: C, expandRowKeys: F, maxHeight: q, basicClass: A } = $({ CRUD: y, crud: p, defaultBasicClass: S.STRUC_MANUFACTURED.V });
  function j() {
    d.value = [], f.value = [];
  }
  function z() {
    var i;
    (i = w.value) == null || i.clearSelection();
  }
  y.HOOK.beforeToQuery = async (i) => {
    i.query.projectId || (i.query.monomerId = void 0, i.query.areaId = void 0);
  };
  function V() {
    const i = [];
    p.selections.forEach((l) => {
      i.findIndex((o) => o.id === l.id) < 0 && i.push(l);
    }), f.value.forEach((l) => {
      i.findIndex((o) => o.id === l.id) < 0 && i.push(l);
    }), d.value = i;
  }
  return y.HOOK.beforeRefresh = async (i) => {
    const l = [];
    i.selections.forEach((o) => {
      l.findIndex((e) => e.id === o.id) < 0 && l.push(o);
    }), f.value.forEach((o) => {
      l.findIndex((e) => e.id === o.id) < 0 && l.push(o);
    }), d.value = l;
  }, y.HOOK.handleRefresh = async (i, { data: l }) => {
    C.value && C.value.updateListNumber();
    const o = [];
    l.content = await v(l.content, { toSmallest: false, toNum: false }), l.content.forEach(async (e) => {
      e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === R.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete), Array.isArray(e.projectFrozen) && (e.projectFrozenKV = {}, e.projectFrozenForUnitKV = {}, e.projectFrozen = await v(e.projectFrozen, { measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision, toSmallest: false, toNum: true }), o.push(e.projectFrozen), e.projectFrozen.forEach((u) => {
        e.projectFrozenForUnitKV[u.projectId] = e.outboundUnitType === R.MEASURE.V ? u.quantity : u.mete, e.projectFrozenKV[u.projectId] = u;
      }));
    }), await Promise.all(o), await Promise.all(l.content), i.data = l.content, f.value = [], d.value && d.value.length > 0 && d.value.forEach((e) => {
      const u = i.data.find((c) => c.id === e.id);
      W(u) ? I(() => {
        var c;
        (c = w.value) == null || c.toggleRowSelection(u, true);
      }) : f.value.push(e);
    });
  }, (i, l) => {
    const o = M, e = N("common-table"), u = Q;
    return a(), g("div", X, [m(t(G), { ref_key: "headerRef", ref: C, tableSelections: d.value, onClearTableSelection: j, onGetSelections: V, onHandleClearSelection: z }, null, 8, ["tableSelections"]), T((a(), r(e, { key: `material_inventory_${t(p).query.basicClass}`, ref_key: "tableRef", ref: w, data: t(p).data, "data-format": U.value, "default-expand-all": false, "expand-row-keys": t(F), "max-height": t(q), "row-key": "id", onSortChange: t(p).handleSortChange, onSelectionChange: t(p).selectionChangeHandler }, { default: h(() => [m(o, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), t(n).visible("basicClass") ? (a(), r(o, { key: "basicClass", align: "center", label: "物料种类", prop: "basicClass", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("manufacturedName") ? (a(), r(o, { key: "manufacturedName", align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("manufacturedSn") ? (a(), r(o, { key: "manufacturedSn", align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("specification") ? (a(), r(o, { key: "specification", align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" })) : s("", true), m(J, { "basic-class": t(A), columns: t(n) }, null, 8, ["basic-class", "columns"]), t(n).visible("material") ? (a(), r(o, { key: "material", align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" })) : s("", true), t(p).query.basicClass === t(S).ENCL_MANUFACTURED.V ? (a(), g(k, { key: 5 }, [t(n).visible("width") ? (a(), r(o, { key: "width", align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("brand") ? (a(), r(o, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("color") ? (a(), r(o, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("length") ? (a(), r(o, { key: "length", align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("quantity") ? (a(), r(o, { key: "quantity", align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("totalLength") ? (a(), r(o, { key: "totalLength", align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }, { default: h(({ row: { sourceRow: c } }) => [_(x(c.totalLength), 1)]), _: 1 })) : s("", true), t(n).visible("totalArea") ? (a(), r(o, { key: "totalArea", align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" })) : s("", true), t(n).visible("totalWeight") ? (a(), r(o, { key: "totalWeight", align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" })) : s("", true)], 64)) : (a(), g(k, { key: 6 }, [t(n).visible("quantity") ? (a(), r(o, { key: "quantity", align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }, { default: h(({ row: { sourceRow: c } }) => [_(x(c.quantity), 1)]), _: 1 })) : s("", true), t(p).query.basicClass === t(S).STRUC_MANUFACTURED.V ? (a(), g(k, { key: 1 }, [t(n).visible("weight") ? (a(), r(o, { key: "weight", align: "center", label: "单重（kg）", "min-width": "120px", prop: "weight", "show-overflow-tooltip": "" }, { default: h(({ row: { sourceRow: c } }) => [_(x(c.weight), 1)]), _: 1 })) : s("", true), t(n).visible("totalWeight") ? (a(), r(o, { key: "totalWeight", align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: h(({ row: { sourceRow: c } }) => [_(x(c.totalWeight), 1)]), _: 1 })) : s("", true)], 64)) : s("", true), m(B, { columns: t(n), "show-area": false, "show-monomer": false, "show-project": false }, null, 8, ["columns"])], 64))]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[u, t(p).loading]]), m(t(H))]);
  };
} }, ce = D(Y, [["__scopeId", "data-v-f8c11e73"]]);
export {
  ce as default
};
