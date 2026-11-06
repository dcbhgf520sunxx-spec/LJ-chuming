import { ref as k } from "vue";
import { provide as B } from "vue";
import { watch as R } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as L } from "vue";
import { vShow as C } from "vue";
import { unref as e } from "vue";
import { createElementVNode as V } from "vue";
import { createBlock as w } from "vue";
import { withCtx as x } from "vue";
import { createVNode as s } from "vue";
import { createCommentVNode as T } from "vue";
import { Fragment as A } from "vue";
import { renderList as H } from "vue";
import { toDisplayString as S } from "vue";
import { ElTableColumn as J } from "element-plus";
import { vLoading as I } from "element-plus";
import { x as j, dh as y, di as q, o as M, i as h, dj as d, G as U, an as G } from "../../../../../shared/runtime.js";
import K from "./module/form.vue.js";
import Q from "./module/batch-form.vue.js";
const z = { key: 1 }, $ = { __name: "index", props: { line: { type: Object, default: () => {
} } }, setup(a, { expose: D }) {
  const _ = k(), b = k([]);
  B("firstLevelDeptOptions", b);
  const { crud: n, CRUD: O } = j({ title: "明细配置", sort: [], permission: { ...y }, crudApi: { ...q }, dataPath: "", queryOnPresenterCreated: false, hasPagination: false }, _), { maxHeight: N } = M({ wrapperBox: ".dict-detail-card", paginate: false, extraHeight: 40 }), E = a;
  return R(() => E.line, (v) => {
    h(v) ? n.toQuery() : n.data = [];
  }, { deep: true, immediate: true }), O.HOOK.handleRefresh = (v, l) => {
    var m, p, u;
    const t = h(l == null ? void 0 : l.data) ? JSON.parse(JSON.stringify(l == null ? void 0 : l.data)) : {}, c = t == null ? void 0 : t.find((i) => i.fieldEnumType === E.line.V);
    b.value = ((m = t == null ? void 0 : t.find((i) => i.fieldEnumType === d.FIRST_LEVEL_DEPT.V)) == null ? void 0 : m.list) || [];
    const r = (c == null ? void 0 : c.list) || [];
    (((p = E.line) == null ? void 0 : p.V) === d.FIRST_LEVEL_DEPT.V || ((u = E.line) == null ? void 0 : u.V) === d.SECOND_LEVEL_DEPT.V) && (r == null || r.forEach((i) => {
      i.yearTarget = [];
      for (const f in i.deptJson) i.yearTarget.push({ year: f, weight: i.deptJson[f] });
    })), l.data = r;
  }, D({ permission: y, toAdd: n.toBatchAdd }), (v, l) => {
    const t = J, c = F("common-table"), r = I;
    return o(), g("div", null, [L(V("div", null, l[0] || (l[0] = [V("div", { class: "my-code" }, "点击合同目录表字段列表查看详情", -1)]), 512), [[C, !e(h)(a.line)]]), L(V("div", null, [L((o(), w(c, { ref_key: "tableRef", ref: _, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(N), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: x(() => {
      var m, p, u;
      return [s(t, { label: "序号", type: "index", align: "center", width: "60" }), ((m = a.line) == null ? void 0 : m.V) === e(d).SECOND_LEVEL_DEPT.V ? (o(), w(t, { key: "firstLevelDeptName", prop: "firstLevelDeptName", "show-overflow-tooltip": true, label: "所属一级部门" })) : T("", true), s(t, { key: "fieldValue", prop: "fieldValue", "show-overflow-tooltip": true, label: "名称" }), s(t, { key: "fieldSort", prop: "fieldSort", "show-overflow-tooltip": true, label: "排序" }), ((p = a.line) == null ? void 0 : p.V) === e(d).FIRST_LEVEL_DEPT.V || ((u = a.line) == null ? void 0 : u.V) === e(d).SECOND_LEVEL_DEPT.V ? (o(), w(t, { key: 1, prop: "year", width: "150", "show-overflow-tooltip": true, label: "目标任务（万元）", align: "left" }, { default: x(({ row: i }) => [e(h)(i.yearTarget) ? (o(true), g(A, { key: 0 }, H(i.yearTarget, (f, P) => (o(), g("div", { key: P }, [V("span", null, S(f.year) + "年: " + S(f.weight), 1)]))), 128)) : (o(), g("span", z, "-"))]), _: 1 })) : T("", true), e(U)([...e(y).edit, ...e(y).del]) ? (o(), w(t, { key: 2, label: "操作", width: "130px", align: "center" }, { default: x((i) => [s(e(G), { data: i.row, permission: e(y) }, null, 8, ["data", "permission"])]), _: 1 })) : T("", true)];
    }), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[r, e(n).loading]]), s(e(K), { line: a.line }, null, 8, ["line"]), s(e(Q), { line: a.line }, null, 8, ["line"])], 512), [[C, e(h)(a.line)]])]);
  };
} };
export {
  $ as default
};
