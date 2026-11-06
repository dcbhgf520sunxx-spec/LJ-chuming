import { ref as b } from "vue";
import { provide as P } from "vue";
import { computed as V } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as y } from "vue";
import { unref as a } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as m } from "vue";
import { toDisplayString as i } from "vue";
import { createTextVNode as S } from "vue";
import { ElTableColumn as B } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as H, _ as O } from "./module/detail.vue.js";
import { x as F, pq as v, o as I, a3 as _, pr as $, ps as T, G as j } from "../../../../../shared/runtime.js";
import W from "./module/header.vue.js";
import "../../../../../modules/index-3b2628f3.js";
import "../../../../../modules/index-490fd9d7.js";
const z = { class: "app-container" }, G = { class: "head-container" }, ie = { __name: "index", setup(K) {
  const C = { add: false, edit: false, del: false, download: false }, k = b(), { crud: c, columns: d, CRUD: M } = F({ title: "迟滞报表", sort: [], permission: { ...v }, optShow: { ...C }, crudApi: { ...H }, dataPath: "", hasPagination: false }, k), { maxHeight: Q } = I({ paginate: false });
  P("query", c.query);
  const h = b(false), g = b({});
  function R(f) {
    g.value = f, h.value = true;
  }
  const N = { [_.MACHINE_PART.V]: "artifactAssembleList", [_.ARTIFACT.V]: "artifactAssembleList", [_.ASSEMBLE.V]: "artifactAssembleList", [_.ENCLOSURE.V]: "enclosureList" }, n = V(() => $({ productType: c.query.productType, w_unit: "kg" }));
  return M.HOOK.handleRefresh = (f, u) => {
    const o = f.query.productType;
    u.data = u.data[N[f.query.productType]].map((e) => (e.taskMete = T({ productType: o, weight: { num: e.taskNetWeight }, length: { num: e.taskLength, to: n.value.unit, dp: n.value.dp } }), e.completeMete = T({ productType: o, weight: { num: e.completeNetWeight }, length: { num: e.completeLength, to: n.value.unit, dp: n.value.dp } }), e.diffQuantity = e.taskQuantity - e.completeQuantity || 0, e.diffMete = (e.taskMete - e.completeMete).toFixed(n.value.DP), e.completeRate = Number(e.taskMete) ? (Number(e.completeMete) / Number(e.taskMete) * 100).toFixed(2) + "%" : "0%", e));
  }, (f, u) => {
    const o = B, e = w("common-button"), A = w("common-table"), D = E("parse-time"), L = U;
    return l(), q("div", z, [p("div", G, [y(a(W))]), x((l(), r(A, { ref_key: "tableRef", ref: k, data: a(c).data, "empty-text": a(c).emptyText, "max-height": a(Q), style: { width: "100%" } }, { default: s(() => [y(o, { label: "序号", type: "index", align: "center", width: "60" }), a(d).visible("askCompleteTime") ? (l(), r(o, { key: "askCompleteTime", prop: "askCompleteTime", label: "完成节点", align: "center", "min-width": "70px" }, { default: s((t) => [x(p("span", null, null, 512), [[D, { val: t.row.askCompleteTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : m("", true), a(d).visible("taskQuantity") ? (l(), r(o, { key: "taskQuantity", prop: "taskQuantity", label: "计划量", align: "center", "min-width": "100px" }, { default: s((t) => [p("span", null, i(t.row.taskQuantity) + " " + i(n.value.measure) + " | " + i(t.row.taskMete) + " " + i(n.value.unit), 1)]), _: 1 })) : m("", true), a(d).visible("completeQuantity") ? (l(), r(o, { key: "completeQuantity", prop: "completeQuantity", label: "完成量", align: "center", "min-width": "100px" }, { default: s((t) => [p("span", null, i(t.row.completeQuantity) + " " + i(n.value.measure) + " | " + i(t.row.completeMete) + " " + i(n.value.unit), 1)]), _: 1 })) : m("", true), a(d).visible("diffQuantity") ? (l(), r(o, { key: "diffQuantity", prop: "diffQuantity", label: "差异", align: "center", "min-width": "100px" }, { default: s((t) => [p("span", null, i(t.row.diffQuantity) + " " + i(n.value.measure) + " | " + i(t.row.diffMete) + " " + i(n.value.unit), 1)]), _: 1 })) : m("", true), a(d).visible("completeRate") ? (l(), r(o, { key: "completeRate", prop: "completeRate", label: "完成率", align: "center", "min-width": "70px" }, { default: s((t) => [p("span", null, i(t.row.completeRate), 1)]), _: 1 })) : m("", true), a(j)(a(v).detail) ? (l(), r(o, { key: 5, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: s((t) => [y(e, { size: "default", type: "info", onClick: (J) => R(t.row) }, { default: s(() => u[1] || (u[1] = [S("查看")])), _: 2, __: [1] }, 1032, ["onClick"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[L, a(c).loading]]), y(a(O), { visible: h.value, "onUpdate:visible": u[0] || (u[0] = (t) => h.value = t), info: g.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  ie as default
};
