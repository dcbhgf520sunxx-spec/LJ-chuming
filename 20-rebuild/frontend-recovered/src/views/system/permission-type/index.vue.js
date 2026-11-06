import { ref as g } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as s } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as v } from "vue";
import { ElTableColumn as k } from "element-plus";
import { vLoading as C } from "element-plus";
import { x as T, o as B, G as D, an as H, a as N } from "../../../shared/runtime.js";
import { c as S } from "../../../modules/permission-type-323df755.js";
import V from "./module/header.vue.js";
import E from "./module/form.vue.js";
import "../../../modules/index-e65bb365.js";
const R = { class: "app-container" }, A = { class: "head-container" }, z = { __name: "index", setup($) {
  const i = { get: ["permissionType:get"], add: ["permissionType:add"], edit: ["permissionType:edit"], del: ["permissionType:del"] }, m = g(), { crud: r, columns: p } = T({ title: "权限类型", sort: [], permission: { ...i }, crudApi: { ...S } }, m), { maxHeight: d } = B({ wrapperBox: ".permission-type", paginate: true, extraHeight: 157 });
  return (j, q) => {
    const t = k, _ = N, u = f("common-table"), h = C;
    return o(), x("div", R, [y("div", A, [a(e(V), { ref: "header", permission: i }, null, 512)]), w((o(), s(u, { ref_key: "tableRef", ref: m, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(d), style: { width: "100%" }, onSelectionChange: e(r).selectionChangeHandler, "return-source-data": "", showEmptySymbol: false }, { default: c(() => [a(t, { type: "selection", width: "55", align: "center" }), a(t, { type: "index", align: "center", width: "60" }), e(p).visible("name") ? (o(), s(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "类型名称", "min-width": "125px" })) : l("", true), e(p).visible("icon") ? (o(), s(t, { key: "icon", prop: "icon", label: "图标", align: "center", "min-width": "150px" }, { default: c((n) => [a(_, { "icon-class": n.row.icon }, null, 8, ["icon-class"])]), _: 1 })) : l("", true), e(p).visible("sort") ? (o(), s(t, { key: "sort", prop: "sort", label: "排序", align: "center", "min-width": "125px" }, { default: c((n) => [b(v(n.row.sort), 1)]), _: 1 })) : l("", true), e(D)([...i.edit, ...i.del]) ? (o(), s(t, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: c((n) => [a(e(H), { data: n.row, permission: i }, null, 8, ["data"])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[h, e(r).loading]]), a(e(E))]);
  };
} };
export {
  z as default
};
