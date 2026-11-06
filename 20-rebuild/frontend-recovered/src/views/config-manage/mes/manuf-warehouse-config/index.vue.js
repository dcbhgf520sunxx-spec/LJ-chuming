import { useStore as C } from "vuex";
import { ref as S } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as O } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as n } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as D } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as M } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElSwitch as N } from "element-plus";
import { vLoading as P } from "element-plus";
import { l as i, x as R, fB as c, o as T, G as w, aS as U, an as W, P as K } from "../../../../shared/runtime.js";
import { u as L } from "../../../../modules/use-crud-enabled-change-d83074a3.js";
import A from "./module/header.vue.js";
import F from "./module/form.vue.js";
import "../../../../modules/index-c07af747.js";
function j(t) {
  return i({ module: "mes", url: "warehouse/list", method: "get", params: t });
}
function q(t) {
  return i({ module: "mes", url: "warehouse/save", method: "post", data: t });
}
function G(t) {
  return i({ module: "mes", url: "warehouse/update", method: "put", data: t });
}
function z(t) {
  return i({ module: "mes", url: "warehouse/remove/batch", method: "delete", data: t });
}
function I({ id: t, boolEnableEnum: h }) {
  return i({ module: "mes", url: `warehouse/update/${t}/${h}`, method: "put" });
}
const J = { get: j, add: q, edit: G, del: z }, Q = { class: "app-container" }, X = { class: "head-container" }, se = { __name: "index", setup(t) {
  const h = { add: true, edit: false, del: false, download: false }, p = C(), b = S(), { crud: d, columns: u, CRUD: m } = R({ title: "制成品库位配置", sort: [], permission: { ...c }, optShow: { ...h }, crudApi: { ...J } }, b), { handleEnabledChange: E } = L({ CRUD: m, crud: d, editEnabled: I }, { enabledField: "boolEnableEnum" }), { maxHeight: v } = T({ paginate: true });
  return m.HOOK.afterSubmit = () => {
    p.dispatch("config/fetchManufWarehouse");
  }, m.HOOK.afterDelete = () => {
    p.dispatch("config/fetchManufWarehouse");
  }, m.HOOK.afterToEdit = () => {
    p.dispatch("config/fetchManufWarehouse");
  }, (Y, Z) => {
    const l = $, x = N, k = V("common-table"), y = P;
    return a(), g("div", Q, [O("div", X, [s(e(A))]), B((a(), n(k, { ref_key: "tableRef", ref: b, data: e(d).data, "empty-text": e(d).emptyText, "max-height": e(v), style: { width: "100%" } }, { default: f(() => [s(l, { label: "序号", type: "index", align: "center", width: "60" }), e(u).visible("workshop.name") ? (a(), n(l, { key: "workshop.name", "show-overflow-tooltip": true, prop: "workshop.name", label: "所属车间", align: "left", "min-width": "150" })) : r("", true), e(u).visible("name") ? (a(), n(l, { key: "name", "show-overflow-tooltip": true, prop: "name", label: "库位名称", align: "left", "min-width": "150" })) : r("", true), e(u).visible("sort") ? (a(), n(l, { key: "sort", "show-overflow-tooltip": true, prop: "sort", label: "排序", align: "center", width: "100px" })) : r("", true), e(u).visible("boolEnableEnum") ? (a(), n(l, { key: 3, "show-overflow-tooltip": true, prop: "boolEnableEnum", label: "启用状态", align: "center", width: "100px" }, { default: f(({ row: o }) => [e(w)(e(c).editStatus) ? (a(), n(x, { key: 0, disabled: o.enabledLoading, modelValue: o.boolEnableEnum, "onUpdate:modelValue": (_) => o.boolEnableEnum = _, class: "drawer-switch", onChange: (_) => e(E)(o) }, null, 8, ["disabled", "modelValue", "onUpdate:modelValue", "onChange"])) : (a(), g(D, { key: 1 }, [H(M(e(U).VL[o.boolEnableEnum]), 1)], 64))]), _: 1 })) : r("", true), e(w)([...e(c).edit, ...e(c).del]) ? (a(), n(l, { key: 4, label: "操作", width: "120px", align: "center", fixed: "right" }, { default: f((o) => [s(e(W), { data: o.row }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, e(d).loading]]), s(e(K)), s(e(F))]);
  };
} };
export {
  se as default
};
