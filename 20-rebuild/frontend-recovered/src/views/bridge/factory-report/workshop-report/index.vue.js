import { ref as y } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as C } from "element-plus";
import { c as j, _ as q } from "./module/header.vue.js";
import { x as R, z as D, P as S, ba as B } from "../../../../shared/runtime.js";
import { h as P } from "../../../../modules/bridge-86f96a4f.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
import "../../../../modules/production-line-select-307387f7.js";
const F = { class: "app-container" }, V = { class: "head-container" }, K = { __name: "index", setup(A) {
  const h = y(), f = { add: false, edit: false, del: false, download: false }, { crud: c, CRUD: w, columns: i } = R({ title: "车间报表", sort: [], optShow: { ...f }, permission: { ...P }, crudApi: { ...j }, hasPagination: true }, h);
  w.HOOK.handleRefresh = (m, u) => {
    u.data.content = u.data.content.map((a) => a);
  };
  function _(m) {
    return B(m, { props: ["length", "quantity", ["mete", 2]] });
  }
  return (m, u) => {
    const a = N, g = v("common-table"), b = C;
    return o(), k("div", F, [r("div", V, [d(t(q))]), x((o(), l(g, { ref_key: "tableRef", ref: h, data: t(c).data, "empty-text": t(c).emptyText, "max-height": "330px", "show-summary": "", "summary-method": _, "row-key": "projectId", style: { width: "100%" } }, { default: n(() => [d(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(i).visible("project") ? (o(), l(a, { "header-align": "center", key: "project.shortName", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "60" }, { default: n((e) => [r("span", null, s(t(D)(e.row.project)), 1)]), _: 1 })) : p("", true), t(i).visible("name") ? (o(), l(a, { "header-align": "center", key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "名称" }, { default: n((e) => [r("span", null, s(e.row.name), 1)]), _: 1 })) : p("", true), t(i).visible("serialNumber") ? (o(), l(a, { "header-align": "center", key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "分段编号" }, { default: n((e) => [r("span", null, s(e.row.serialNumber), 1)]), _: 1 })) : p("", true), t(i).visible("specification") ? (o(), l(a, { "header-align": "center", key: "specification", prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格" }, { default: n((e) => [r("span", null, s(e.row.specification), 1)]), _: 1 })) : p("", true), t(i).visible("length") ? (o(), l(a, { "header-align": "center", key: "length", prop: "length", align: "center", "show-overflow-tooltip": true, label: "长度（mm）" }, { default: n((e) => [r("span", null, s(e.row.length), 1)]), _: 1 })) : p("", true), t(i).visible("material") ? (o(), l(a, { "header-align": "center", key: "material", prop: "material", align: "center", "show-overflow-tooltip": true, label: "材质" }, { default: n((e) => [r("span", null, s(e.row.material), 1)]), _: 1 })) : p("", true), t(i).visible("quantity") ? (o(), l(a, { "header-align": "center", key: "quantity", prop: "quantity", align: "center", "show-overflow-tooltip": true, label: "生产数" }, { default: n((e) => [r("span", null, s(e.row.quantity), 1)]), _: 1 })) : p("", true), t(i).visible("mete") ? (o(), l(a, { "header-align": "center", key: "mete", prop: "mete", align: "center", "show-overflow-tooltip": true, label: "总重（kg）" }, { default: n((e) => [r("span", null, s(e.row.mete.toFixed(2)), 1)]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text"])), [[b, t(c).loading]]), d(t(S))]);
  };
} };
export {
  K as default
};
