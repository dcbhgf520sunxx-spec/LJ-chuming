import { ref as d } from "vue";
import { inject as x } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as w } from "vue";
import { ElTableColumn as v } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as C } from "../../../../modules/process-class-config-a530529c.js";
import { es as I, x as D, nV as r, G as P, an as R, P as B } from "../../../../shared/runtime.js";
import E from "./module/header.vue.js";
import N from "./module/form.vue.js";
import "../../../../modules/use-section-all-504a2069.js";
const V = { class: "app-container" }, H = { class: "head-container" }, F = { __name: "index", setup(O) {
  const c = d(), m = d([["artifactType", ["parse-enum", I.ENUM]]]), { crud: o, CRUD: _ } = D({ title: "构件分类", sort: [], permission: { ...r }, optShow: { add: true }, crudApi: { ...C } }, c), f = x("maxHeight");
  return _.HOOK.handleRefresh = (u, i) => {
    i.data.content = i.data.content.map((e) => (e.nameList = e.nameIndexList.map((t) => t.name), e.typeList = e.typeIndexList.map((t) => t.name), e.nameListIds = e.nameIndexList.map((t) => t.id), e.typeListIds = e.typeIndexList.map((t) => t.id), e));
  }, (u, i) => {
    const e = v, t = g("common-table"), y = T;
    return s(), L("div", V, [b("div", H, [n(a(E))]), k((s(), l(t, { ref_key: "tableRef", ref: c, data: a(o).data, "empty-text": a(o).emptyText, "max-height": a(f), style: { width: "100%" }, "data-format": m.value, "row-key": "id" }, { default: p(() => [n(e, { label: "序号", type: "index", align: "center", width: "60" }), n(e, { key: "classification", prop: "classification", label: "构件分类", align: "center" }), n(e, { key: "artifactType", prop: "artifactType", label: "主次构件类", align: "center" }), n(e, { key: "nameList", prop: "nameList", label: " 清单构件名称索引", align: "center" }), n(e, { key: "typeList", prop: "typeList", label: " 规格索引", align: "center" }), a(P)([...a(r).edit, ...a(r).del]) ? (s(), l(e, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: p((h) => [n(a(R), { data: h.row }, null, 8, ["data"])]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[y, a(o).loading]]), n(a(B)), n(a(N))]);
  };
} };
export {
  F as default
};
