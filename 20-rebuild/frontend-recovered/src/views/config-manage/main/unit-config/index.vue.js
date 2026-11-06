import { ref as u } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as o } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as h } from "vue";
import { Fragment as V } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElSwitch as U } from "element-plus";
import { vLoading as A } from "element-plus";
import { aA as B, x as N, e$ as d, f0 as L, o as P, f1 as R, cW as $, G as _, aS as F, an as G, P as H } from "../../../../shared/runtime.js";
import { u as I } from "../../../../modules/use-crud-enabled-change-d83074a3.js";
import M from "./module/header.vue.js";
import O from "./module/batch-form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const j = { class: "app-container" }, ee = { __name: "index", setup(q) {
  const g = { batchAdd: true, add: false, edit: false, del: false, download: false }, c = u(), y = u([...B]), { CRUD: w, crud: m, columns: n } = N({ title: "基础单位配置", formStore: true, formStoreKey: "BASE_CONFIG_UNIT", sort: ["id.desc"], permission: { ...d }, optShow: { ...g }, crudApi: { ...L } }, c), { maxHeight: v } = P({ paginate: true }), { handleEnabledChange: k } = I({ CRUD: w, crud: m, editEnabled: R });
  return (K, W) => {
    const l = D, x = U, C = S("common-table"), T = A;
    return a(), b("div", j, [i(e(M), { ref: "header", permission: e(d) }, null, 8, ["permission"]), E((a(), o(C, { ref_key: "tableRef", ref: c, data: e(m).data, "data-format": y.value, "show-empty-symbol": false, "max-height": e(v), style: { width: "100%" } }, { default: r(() => [i(l, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("name") ? (a(), o(l, { key: "name", "show-overflow-tooltip": true, prop: "name", label: "名称", align: "center" })) : s("", true), e(n).visible("symbol") ? (a(), o(l, { key: "symbol", "show-overflow-tooltip": true, prop: "symbol", label: "符号", align: "center" })) : s("", true), e(n).visible("type") ? (a(), o(l, { key: 2, "show-overflow-tooltip": true, prop: "type", label: "类型", align: "center" }, { default: r(({ row: t }) => [f(h(e($).VL[t.type]), 1)]), _: 1 })) : s("", true), e(n).visible("enabled") ? (a(), o(l, { key: 3, "show-overflow-tooltip": true, prop: "enabled", label: "启用状态", align: "center" }, { default: r(({ row: t }) => [e(_)(e(d).edit) ? (a(), o(x, { key: 0, disabled: t.enabledLoading, modelValue: t.enabled, "onUpdate:modelValue": (p) => t.enabled = p, class: "drawer-switch", onChange: (p) => e(k)(t) }, null, 8, ["disabled", "modelValue", "onUpdate:modelValue", "onChange"])) : (a(), b(V, { key: 1 }, [f(h(e(F).VL[t.enabled]), 1)], 64))]), _: 1 })) : s("", true), e(n).visible("updateTime") ? (a(), o(l, { key: "updateTime", prop: "updateTime", label: "编辑日期", width: "140px" })) : s("", true), e(n).visible("createTime") ? (a(), o(l, { key: "createTime", prop: "createTime", label: "创建日期", width: "140px" })) : s("", true), e(_)(e(d).del) ? (a(), o(l, { key: 6, label: "操作", width: "130px", align: "center" }, { default: r(({ row: t }) => [i(e(G), { "show-del": !t.boolSystem, "show-edit": false, data: t }, null, 8, ["show-del", "data"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[T, e(m).loading]]), i(e(H)), i(e(O))]);
  };
} };
export {
  ee as default
};
