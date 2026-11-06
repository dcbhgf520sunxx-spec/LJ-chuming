import { ref as c } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as D } from "vue";
import { withCtx as r } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElTag as H } from "element-plus";
import { vLoading as M } from "element-plus";
import { p as V } from "../../../../../../modules/project-overview-0b01c4c7.js";
import { d as A } from "../../../../../../modules/enclosure-365a2177.js";
import { mD as h, x as K, o as L } from "../../../../../../shared/runtime.js";
import N from "./module/header.vue.js";
const O = { class: "app-container" }, $ = { __name: "index", emits: ["project-change"], setup(P, { emit: _ }) {
  const f = _, g = { add: false, edit: false, del: false, download: false }, i = c(), l = c({}), x = c([["project", "parse-project"], ["status", ["parse-enum", h]]]), { crud: o, CRUD: j } = K({ title: "项目全貌-项目列表", sort: [], permission: { ...A }, optShow: { ...g }, crudApi: { get: V }, hasPagination: false }, i), { maxHeight: y } = L({ extraBox: ".project-head-container" });
  function b(t) {
    l.value = (t == null ? void 0 : t.project) || {}, f("project-change", l.value);
  }
  return j.HOOK.handleRefresh = async (t, { data: n }) => {
    n.content = n;
  }, (t, n) => {
    const s = S, C = H, v = R("common-table"), k = M;
    return u(), T("div", O, [a(e(N), { class: "head-container project-head-container" }), w((u(), D(v, { ref_key: "tableRef", ref: i, "data-format": x.value, data: e(o).data, "highlight-current-row": "", "empty-text": e(o).emptyText, "max-height": e(y), onCurrentChange: b }, { default: r(() => [a(s, { label: "序号", type: "index", align: "center", width: "55" }), a(s, { key: "project", prop: "project", label: "项目列表", "min-width": "100", align: "center" }), a(s, { key: "status", prop: "status", label: "状态", width: "92", align: "center" }, { default: r(({ row: p }) => {
      var m, d;
      return [a(C, { size: "large", type: (d = (m = e(h).V) == null ? void 0 : m[p.sourceRow.status]) == null ? void 0 : d.TAG }, { default: r(() => [B(E(p.status), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })]), _: 1 }, 8, ["data-format", "data", "empty-text", "max-height"])), [[k, e(o).loading]])]);
  };
} };
export {
  $ as default
};
