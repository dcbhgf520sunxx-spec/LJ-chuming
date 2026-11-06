import { ref as W } from "vue";
import { useStore as H } from "vuex";
import { resolveComponent as B } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as r } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as n } from "vue";
import { createElementVNode as R } from "vue";
import { toDisplayString as g } from "vue";
import { Fragment as w } from "vue";
import { renderList as U } from "vue";
import { createTextVNode as y } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTag as A } from "element-plus";
import { ElSwitch as K } from "element-plus";
import { vLoading as F } from "element-plus";
import { o as M, x as P, hS as h, hT as $, hU as q, bv as G, am as I, hV as j, G as k, aS as Q, an as z, P as J, aA as X } from "../../../../shared/runtime.js";
import { u as Y } from "../../../../modules/use-crud-enabled-change-d83074a3.js";
import Z from "./module/header.vue.js";
import ee from "./module/form.vue.js";
import ae from "./module/batch-form.vue.js";
import "./module/workshop-list.vue.js";
import "./module/workshop-form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const te = { class: "app-container warehouse-config" }, ue = { __name: "index", setup(oe) {
  const T = { batchAdd: true, add: true, edit: false, del: true, download: false }, b = W(), i = H(), C = [...X], { maxHeight: v } = M({ paginate: true }), { CRUD: d, crud: m, columns: l } = P({ title: "仓库设置", formStore: true, formStoreKey: "CONFIG_WMS_WAREHOUSE", permission: { ...h }, optShow: { ...T }, crudApi: { ...$ }, requiredQuery: ["workshopId"], sort: ["sort.asc"] }, b), { handleEnabledChange: x } = Y({ CRUD: d, crud: m, editEnabled: q });
  return d.HOOK.handleRefresh = (S, { data: { content: _ } }) => {
    _.forEach((t) => {
      const u = t.materialType;
      t.materialTypeName = G.getBits(I.ENUM, u, "L");
    });
  }, d.HOOK.afterSubmit = () => {
    i.dispatch("config/fetchWorkshopName"), i.dispatch("config/fetchWarehouse");
  }, d.HOOK.afterBatchSubmit = () => {
    i.dispatch("config/fetchWorkshopName"), i.dispatch("config/fetchWarehouse");
  }, d.HOOK.afterDelete = () => {
    i.dispatch("config/fetchWorkshopName"), i.dispatch("config/fetchWarehouse");
  }, (S, _) => {
    const t = L, u = A, E = K, O = B("common-table"), N = F;
    return a(), f("div", te, [s(e(Z)), D((a(), r(O, { ref_key: "tableRef", ref: b, data: e(m).data, "data-format": C, "max-height": e(v), onSelectionChange: e(m).selectionChangeHandler, "row-key": "id" }, { default: c(() => [s(t, { type: "selection", width: "55", align: "center" }), s(t, { label: "序号", type: "index", align: "center", width: "60" }), e(l).visible("name") ? (a(), r(t, { key: "name", "show-overflow-tooltip": true, prop: "name", label: "仓库位置", align: "left", "min-width": "150" })) : n("", true), e(l).visible("warehouseType") ? (a(), r(t, { key: "warehouseType", "show-overflow-tooltip": true, prop: "warehouseType", label: "仓库类型", align: "center", width: "100" }, { default: c(({ row: { sourceRow: o } }) => [R("span", null, g(o.warehouseType ? e(j).VL[o.warehouseType] : "-"), 1)]), _: 1 })) : n("", true), e(l).visible("materialType") ? (a(), r(t, { key: "materialType", "show-overflow-tooltip": true, prop: "name", label: "可存储材料类型", align: "left", "min-width": "300" }, { default: c(({ row: o }) => [(a(true), f(w, null, U(o.materialTypeName, (p, V) => (a(), r(u, { key: V, effect: "plain", style: { "margin-right": "5px" } }, { default: c(() => [y(g(p), 1)]), _: 2 }, 1024))), 128))]), _: 1 })) : n("", true), e(l).visible("sort") ? (a(), r(t, { key: "sort", "show-overflow-tooltip": true, prop: "sort", label: "排序", align: "center", width: "100px" })) : n("", true), e(l).visible("enabled") ? (a(), r(t, { key: 4, "show-overflow-tooltip": true, prop: "enabled", label: "启用状态", align: "center", width: "100px" }, { default: c(({ row: o }) => [e(k)(e(h).edit) ? (a(), r(E, { key: 0, disabled: o.enabledLoading, modelValue: o.enabled, "onUpdate:modelValue": (p) => o.enabled = p, class: "drawer-switch", onChange: (p) => e(x)(o) }, null, 8, ["disabled", "modelValue", "onUpdate:modelValue", "onChange"])) : (a(), f(w, { key: 1 }, [y(g(e(Q).VL[o.enabled]), 1)], 64))]), _: 1 })) : n("", true), e(l).visible("createTime") ? (a(), r(t, { key: "createTime", prop: "createTime", label: "创建日期", width: "140px" })) : n("", true), e(k)([...e(h).edit, ...e(h).del]) ? (a(), r(t, { key: 6, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: c(({ row: o }) => [s(e(z), { data: o }, null, 8, ["data"])]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "max-height", "onSelectionChange"])), [[N, e(m).loading]]), s(e(J)), s(e(ee)), s(e(ae))]);
  };
} };
export {
  ue as default
};
