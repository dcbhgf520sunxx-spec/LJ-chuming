import { ref as q } from "vue";
import { inject as H } from "vue";
import { computed as P } from "vue";
import { watch as R } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as A } from "vue";
import { withDirectives as u } from "vue";
import { vShow as y } from "vue";
import { createElementVNode as m } from "vue";
import { createBlock as p } from "vue";
import { withCtx as g } from "vue";
import { createVNode as c } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as b } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as K } from "../../../../../modules/production-line-group-45284ce2.js";
import { x as N, aO as i, G as V, an as j, P as E } from "../../../../../shared/runtime.js";
import G from "./module/form.vue.js";
const $ = { __name: "index", props: { line: { type: Object, default: () => {
} } }, emits: ["click-group"], setup(f, { expose: v, emit: x }) {
  const w = x, h = q(), { crud: e, columns: _, CRUD: d } = N({ title: "生产组", sort: [], permission: { ...i }, crudApi: { ...K }, queryOnPresenterCreated: false }, h), k = H("maxHeight"), l = f, o = P(() => l.line && l.line.id);
  R(() => o, (n) => {
    n.value && e.toQuery();
  }, { deep: true, immediate: true });
  function C(n) {
    n && w("click-group", n);
  }
  return d.HOOK.beforeRefresh = () => (e.query.productionLineId = o.value, !!e.query.productionLineId), d.HOOK.beforeToQuery = () => (e.query.productionLineId = o.value, !!e.query.productionLineId), d.HOOK.handleRefresh = (n, r) => {
    r.data.content = r.data.content.map((a) => a);
  }, d.HOOK.beforeSubmit = () => {
    e.form.productionLineId = o.value, e.form.factoryId = l.line.factoryId, e.form.workshopId = l.line.workshopId;
  }, v({ permission: i, toAdd: e.toAdd }), (n, r) => {
    const a = B, O = T("common-table"), I = D;
    return s(), A("div", null, [u(m("div", null, r[0] || (r[0] = [m("div", { class: "my-code" }, "点击生产线查看详情", -1)]), 512), [[y, !o.value]]), u(m("div", null, [u((s(), p(O, { ref_key: "tableRef", ref: h, data: t(e).data, "highlight-current-row": "", "empty-text": t(e).emptyText, "max-height": t(k) + 42, style: { width: "100%" }, "row-key": "id", onCurrentChange: C }, { default: g(() => [c(a, { label: "序号", type: "index", align: "center", width: "60" }), t(_).visible("name") ? (s(), p(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "生产组名称", align: "center", "min-width": "140px" })) : b("", true), t(V)([...t(i).edit, ...t(i).del]) ? (s(), p(a, { key: 1, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: g((L) => [c(t(j), { data: L.row, permission: t(i) }, null, 8, ["data", "permission"])]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[I, t(e).loading]]), c(t(E)), c(t(G), { productType: f.line.productType }, null, 8, ["productType"])], 512), [[y, o.value]])]);
  };
} };
export {
  $ as default
};
