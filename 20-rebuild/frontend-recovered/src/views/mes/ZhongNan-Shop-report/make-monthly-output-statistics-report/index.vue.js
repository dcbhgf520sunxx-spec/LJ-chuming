import { provide as M } from "vue";
import { ref as T } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as w } from "vue";
import { unref as o } from "vue";
import { withDirectives as E } from "vue";
import { createBlock as d } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as y } from "vue";
import { ElTableColumn as O } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as H, _ as P } from "./module/header.vue.js";
import { n0 as A, x as V, o as I } from "../../../../shared/runtime.js";
import "../../../../modules/project-select-94bb5bbd.js";
const U = { class: "app-container" }, q = { class: "head-container" }, Q = { __name: "index", setup(K) {
  M("permission", A);
  const W = { add: false, edit: false, del: false, download: false }, N = T(), _ = T([]), { crud: g, CRUD: k, columns: f } = V({ title: "制作产量统计月报", permission: { ...A }, optShow: { ...W }, crudApi: { ...H }, dataPath: "", hasPagination: false }, N), { maxHeight: C } = I({ paginate: false });
  k.HOOK.handleRefresh = (c, l) => {
    const a = [];
    _.value = [], l.data = l.data.map((e) => (a.indexOf(e.structureType) < 0 && a.push(e.structureType), e));
    for (let e = 0; e < a.length; e++) {
      const r = l.data.filter((t) => t.structureType === a[e]);
      r[0].structureTypeSpan = r.length, r[0].index = e + 1, _.value.push(...r);
    }
    l.data = _.value;
  };
  function D({ row: c, column: l, rowIndex: a, columnIndex: e }) {
    if (e === 0 || e === 1 || e === 4) return { rowspan: c.structureTypeSpan || 0, colspan: 1 };
  }
  const R = (c) => {
    const { columns: l, data: a } = c, e = [];
    return l.forEach((r, t) => {
      if (t === 1) {
        e[t] = "合计";
        return;
      }
      if (["totalNetWeightAll"].findIndex((n) => Array.isArray(n) ? n[0] === r.property : n === r.property) > -1) {
        const n = [], b = [];
        a.forEach((s) => {
          n.indexOf(s.structureType) < 0 && (n.push(s.structureType), b.push(s));
        });
        const v = b.map((s) => Number(s[r.property]));
        v.every((s) => Number.isNaN(s)) ? e[t] = "" : (e[t] = v.reduce((s, x) => {
          const S = Number(x);
          return Number.isNaN(S) ? s : s + x;
        }, 0), r.property === "totalNetWeightAll" && (e[t] = e[t].toFixed(5)));
      }
    }), e;
  };
  return (c, l) => {
    const a = O, e = j("common-table"), r = F;
    return u(), B("div", U, [p("div", q, [w(o(P), { ref: "headerRef" }, null, 512)]), E((u(), d(e, { ref_key: "tableRef", ref: N, data: o(g).data, "empty-text": o(g).emptyText, "max-height": o(C), "span-method": D, "summary-method": R, "show-summary": "", style: { width: "100%" } }, { default: m(() => [w(a, { label: "序号", prop: "index", align: "center", width: "60" }), o(f).visible("structureType") ? (u(), d(a, { label: "构件类别", prop: "structureType", key: "structureType", align: "center" }, { default: m((t) => [p("div", null, h(t.row.structureType || "-"), 1)]), _: 1 })) : y("", true), o(f).visible("projectName") ? (u(), d(a, { label: "工程项目", prop: "projectName", key: "projectName", align: "center" }, { default: m((t) => [p("div", null, h(t.row.projectName ?? "-"), 1)]), _: 1 })) : y("", true), o(f).visible("totalNetWeight") ? (u(), d(a, { label: "入库产量(吨)", prop: "totalNetWeight", key: "totalNetWeight", align: "center" }, { default: m((t) => {
      var i;
      return [p("div", null, h(((i = t.row.totalNetWeight) == null ? void 0 : i.toFixed(3)) ?? "-"), 1)];
    }), _: 1 })) : y("", true), o(f).visible("totalNetWeightAll") ? (u(), d(a, { label: "小计", prop: "totalNetWeightAll", key: "totalNetWeightAll", align: "center" }, { default: m((t) => {
      var i;
      return [p("div", null, h(((i = t.row.totalNetWeightAll) == null ? void 0 : i.toFixed(3)) ?? "-"), 1)];
    }), _: 1 })) : y("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[r, o(g).loading]])]);
  };
} };
export {
  Q as default
};
