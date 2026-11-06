import { ref as v } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as S } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as a } from "vue";
import { withCtx as l } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as w } from "vue";
import { nextTick as N } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as V } from "element-plus";
import { x as M, o as O, x7 as R, x8 as T, G as B, an as H, a as L } from "../../../shared/runtime.js";
import { c as P } from "../../../modules/menu-28602dc9.js";
import J from "./module/header.vue.js";
import U from "./module/form.vue.js";
import "../../../modules/permission-type-323df755.js";
import "../../../modules/tree-select-86c0f12c.js";
import "../../../modules/index-e65bb365.js";
const $ = { class: "app-container" }, j = { class: "head-container" }, q = { key: 0 }, z = { key: 1 }, G = { key: 0 }, K = { key: 1 }, F = { key: 0 }, I = { key: 1 }, ie = { __name: "index", setup(Q) {
  const h = { get: ["menu:get"], add: ["menu:add"], edit: ["menu:edit"], del: ["menu:del"] }, _ = v(), { crud: u, columns: r, CRUD: g } = M({ title: "菜单", sort: [], permission: { ...h }, crudApi: { ...P }, hasPagination: false }, _), { maxHeight: x } = O();
  function b(p, d) {
    p.map((e) => {
      e.parentArray = [...d], e.pid && e.parentArray.push(e.pid), e.children && e.children.length > 0 && b(e.children, e.parentArray);
    });
  }
  g.HOOK.handleRefresh = (p, d) => {
    b(d.data.content, []), d.data.content = d.data.content.map((e) => (e.hasChildren = !!e.children, e));
  };
  function k({ row: p, treeNode: d, resolve: e }) {
    const y = p.children.map((s) => (s.hasChildren = !!s.children, s.hasChildren && (s.newChildren = JSON.parse(JSON.stringify(s.children)), delete s.newChildren.children), s));
    e([...y]), N(() => {
      _.value.expandParent(p, true);
    });
  }
  return (p, d) => {
    const e = A, y = L, s = D("common-table"), C = V;
    return n(), c("div", $, [S("div", j, [m(t(J), { ref: "header", permission: h }, null, 512)]), E((n(), a(s, { ref_key: "tableRef", ref: _, data: t(u).data, "empty-text": t(u).emptyText, "max-height": t(x), style: { width: "100%" }, lazy: "", load: k, "tree-props": { children: "newChildren", hasChildren: "hasChildren" }, "row-key": "id", onSelectionChange: t(u).selectionChangeHandler, "return-source-data": "", showEmptySymbol: false }, { default: l(() => [m(e, { type: "selection", width: "55", align: "center" }), t(r).visible("name") ? (n(), a(e, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "菜单名称", "min-width": "280px" })) : i("", true), t(r).visible("type") ? (n(), a(e, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "菜单类型", width: "120px" }, { default: l((o) => [f(w(t(R).VL[o.row.type]), 1)]), _: 1 })) : i("", true), t(r).visible("icon") ? (n(), a(e, { key: "icon", prop: "icon", label: "图标", align: "center", width: "60px" }, { default: l((o) => [m(y, { "icon-class": o.row.icon ? o.row.icon : "" }, null, 8, ["icon-class"])]), _: 1 })) : i("", true), t(r).visible("sort") ? (n(), a(e, { key: "sort", prop: "sort", label: "排序", align: "center" }, { default: l((o) => [f(w(o.row.sort), 1)]), _: 1 })) : i("", true), t(r).visible("path") ? (n(), a(e, { key: "path", prop: "path", "show-overflow-tooltip": true, label: "路由地址" })) : i("", true), t(r).visible("permission") ? (n(), a(e, { key: "permission", prop: "permission", "show-overflow-tooltip": true, label: "权限标识" })) : i("", true), t(r).visible("component") ? (n(), a(e, { key: "component", prop: "component", "show-overflow-tooltip": true, label: "组件路径" })) : i("", true), t(r).visible("iframe") ? (n(), a(e, { key: "iframe", prop: "iframe", label: "外链", align: "center", width: "75px" }, { default: l((o) => [o.row.iframe ? (n(), c("span", q, "是")) : (n(), c("span", z, "否"))]), _: 1 })) : i("", true), t(r).visible("cache") ? (n(), a(e, { key: "cache", prop: "cache", label: "缓存", align: "center", width: "75px" }, { default: l((o) => [o.row.cache ? (n(), c("span", G, "是")) : (n(), c("span", K, "否"))]), _: 1 })) : i("", true), t(r).visible("hidden") ? (n(), a(e, { key: "hidden", prop: "hidden", label: "可见", align: "center", width: "75px" }, { default: l((o) => [o.row.hidden ? (n(), c("span", F, "否")) : (n(), c("span", I, "是"))]), _: 1 })) : i("", true), t(r).visible("category") ? (n(), a(e, { key: "category", prop: "category", label: "类别", align: "center", width: "75px" }, { default: l((o) => [f(w(t(T).VL[o.row.category]), 1)]), _: 1 })) : i("", true), t(B)([...h.edit, ...h.del]) ? (n(), a(e, { key: 11, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: l((o) => [m(t(H), { disabledEdit: o.row.boolMainSystem, disabledDel: o.row.boolMainSystem, data: o.row, permission: h, "del-prompt": "确定删除吗,如果存在下级节点则一并删除，此操作不能撤销！" }, null, 8, ["disabledEdit", "disabledDel", "data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[C, t(u).loading]]), m(t(U))]);
  };
} };
export {
  ie as default
};
