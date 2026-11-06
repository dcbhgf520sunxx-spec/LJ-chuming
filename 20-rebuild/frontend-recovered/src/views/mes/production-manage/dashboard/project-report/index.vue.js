import { ref as A } from "vue";
import { computed as c } from "vue";
import { provide as M } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as $ } from "vue";
import { createElementVNode as q } from "vue";
import { createVNode as m } from "vue";
import { unref as a } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as l } from "vue";
import { withCtx as b } from "vue";
import { resolveDynamicComponent as D } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as O } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as I } from "element-plus";
import { l as v, x as N, pT as P, o as B, bu as d, a3 as f, pr as F, ps as h, P as H } from "../../../../../shared/runtime.js";
import U from "./artifact/index.vue.js";
import W from "./enclosure/index.vue.js";
import K from "./module/header.vue.js";
import "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
import "../../../../../modules/index-b238c21c.js";
function _(i) {
  return v({ module: "mes", url: "kanban/form/artifact/page", method: "get", params: i });
}
function L(i) {
  return v({ module: "mes", url: "kanban/form/enclosure/page", method: "get", params: i });
}
const z = { class: "app-container" }, G = { class: "head-container" }, ne = { __name: "index", setup(i) {
  const w = { add: false, edit: false, del: false, download: false }, g = A(), { crud: n, columns: r, CRUD: y } = N({ title: "项目报表", permission: { ...P }, optShow: { ...w }, requiredQuery: ["monomerId"], crudApi: { get: _ } }, g), { maxHeight: x } = B({ paginate: true }), T = c(() => n.query.category === d.ARTIFACT.V ? U : W), s = c(() => n.query.category === d.ARTIFACT.V ? f.ARTIFACT.V : f.ENCLOSURE.V);
  y.HOOK.beforeRefresh = () => {
    if (n.query.category) n.crudApi.get = n.query.category === d.ARTIFACT.V ? _ : L;
    else return false;
  };
  const t = c(() => F({ productType: s.value, w_unit: "kg", isSingle: true }));
  return M("unitObj", t), y.HOOK.handleRefresh = (C, p) => {
    p.data.content = p.data.content.map((e) => (e.mete = h({ productType: s.value, length: { num: e.length, to: t.value.unit, dp: t.value.dp }, weight: { num: e.netWeight, to: t.value.unit, dp: t.value.dp } }), e.completeMete = h({ productType: s.value, length: { num: e.length * e.completeQuantity, to: t.value.unit, dp: t.value.dp }, weight: { num: e.netWeight * e.completeQuantity, to: t.value.unit, dp: t.value.dp } }), e.shipMete = h({ productType: s.value, length: { num: e.length * e.sendQuantity, to: t.value.unit, dp: t.value.dp }, weight: { num: e.netWeight * e.sendQuantity, to: t.value.unit, dp: t.value.dp } }), e.sendQuantity = e.sendQuantity || 0, e));
  }, (C, p) => {
    const e = j, k = V("common-table"), R = I;
    return o(), $("div", z, [q("div", G, [m(a(K))]), S((o(), l(k, { ref_key: "tableRef", ref: g, data: a(n).data, "empty-text": a(n).emptyText, "max-height": a(x), style: { width: "100%" }, onSortChange: a(n).handleSortChange }, { default: b(() => [m(e, { label: "序号", type: "index", align: "center", width: "60" }), (o(), l(D(T.value), { columns: a(r) }, null, 8, ["columns"])), a(r).visible("quantity") ? (o(), l(e, { key: "quantity", prop: "quantity", sortable: "custom", label: `数量(${t.value.measure})`, align: "center", "min-width": "70px" }, null, 8, ["label"])) : u("", true), a(r).visible("mete") ? (o(), l(e, { key: 1, prop: "mete", "show-overflow-tooltip": true, label: `${t.value.label}(${t.value.unit})`, align: "center", "min-width": "80px" }, { default: b((Q) => [O(E(Q.row.mete), 1)]), _: 1 }, 8, ["label"])) : u("", true), a(r).visible("completeQuantity") ? (o(), l(e, { key: 2, prop: "completeQuantity", sortable: "custom", label: `已生产数(${t.value.measure})`, align: "center", "min-width": "70px" }, null, 8, ["label"])) : u("", true), a(r).visible("completeMete") ? (o(), l(e, { key: 3, prop: "completeMete", sortable: "custom", label: `已生产量(${t.value.unit})`, align: "center", "min-width": "70px" }, null, 8, ["label"])) : u("", true), a(r).visible("sendQuantity") ? (o(), l(e, { key: 4, prop: "sendQuantity", sortable: "custom", label: `已发运数(${t.value.measure})`, align: "center", "min-width": "70px" }, null, 8, ["label"])) : u("", true), a(r).visible("shipMete") ? (o(), l(e, { key: 5, prop: "shipMete", sortable: "custom", label: `已发运量(${t.value.unit})`, align: "center", "min-width": "70px" }, null, 8, ["label"])) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[R, a(n).loading]]), m(a(H))]);
  };
} };
export {
  ne as default
};
