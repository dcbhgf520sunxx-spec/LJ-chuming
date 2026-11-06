import { ref as y } from "vue";
import { computed as D } from "vue";
import { onUnmounted as E } from "vue";
import { nextTick as I } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as s } from "vue";
import { mergeProps as q } from "vue";
import { unref as u } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as v } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as M } from "element-plus";
import { InfoFilled as V } from "@element-plus/icons-vue";
import { ElIcon as A } from "element-plus";
import { ElTooltip as H } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as U } from "./module/config-preview.vue.js";
import { _ as L, o as j, x as z, hB as G, i as b } from "../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "./module/config.vue.js";
import "../../../../modules/use-table-change-32e98420.js";
const K = { class: "app-container" }, Q = { class: "classifyName" }, W = { class: "classifyName" }, X = { key: 0 }, Y = { style: { margin: "0 10px" } }, Z = { class: "classifyName" }, ee = { key: 0 }, te = { __name: "index", setup(le) {
  const N = { add: false, edit: false, del: false, download: false }, x = y(), h = y(true), k = [["rdRate", ["suffix", " %"]]], { maxHeight: C } = j({ navbar: false, extraHeight: -20 }), { crud: f, columns: g } = z({ title: "高新研发费配置", sort: ["sort.asc", "id.desc"], permission: { ...G }, crudApi: { ...U }, optShow: { ...N }, hasPagination: false }, x), S = D(() => {
    let l = f.data;
    if (f.query && b(f.query.nameOrCode)) {
      const a = f.query.nameOrCode;
      l = l.filter((n) => n.fullName.some((e) => e.indexOf(a) > -1) || n.fullSerialNumber.some((e) => e.indexOf(a) > -1));
    }
    return R(l);
  });
  E(() => {
  });
  function R(l) {
    if (l.length === 0) return l;
    const a = [[], []], n = [-1, -1];
    return l.forEach((e) => {
      for (let t = 0; t < a.length; t++) {
        const c = e.fullId[t], p = n.length > t ? n[t] : void 0;
        c === p && b(p) ? a[t][a[t].length - 1]++ : (a[t].push(1), n[t] = c);
      }
    }), a[0].reduce((e, t) => (l[e].name1_rowSpan = t, e += t, e), 0), a[1].reduce((e, t) => (l[e].name2_rowSpan = t, e += t, e), 0), setTimeout(() => {
      h.value = false, I(() => {
        h.value = true;
      });
    }, 1e3), l;
  }
  const $ = [0, 2, 1];
  function T({ row: l, column: a, rowIndex: n, columnIndex: e }) {
    if (e === 1) return { rowspan: l.name1_rowSpan || 0, colspan: l.fullName.length === 1 ? 3 : 1 };
    if (e === 2) return { rowspan: l.name2_rowSpan || 0, colspan: $[l.fullName.length - 1] };
    if (e === 3) return { rowspan: 1, colspan: l.fullName.length < 3 ? 0 : 1 };
  }
  return (l, a) => {
    const n = M, e = V, t = A, c = H, p = O("common-table"), B = P;
    return d(), w("div", K, [s(u(J), q(l.$attrs, { ref: "header" }), null, 16), h.value ? F((d(), _(p, { key: 0, ref_key: "tableRef", ref: x, border: "", data: S.value, "data-format": k, "empty-text": u(f).emptyText, "max-height": u(C), "span-method": T, "highlight-current-row": false, "row-key": "id" }, { default: o(() => [s(n, { key: "index", type: "index", label: "序号", align: "center", width: "60" }), u(g).visible("level1") ? (d(), _(n, { key: 0, prop: "level1", label: "一级", align: "left", "min-width": "160px" }, { header: o(() => [s(c, { effect: "light", content: "一级科目（名称-编号）", placement: "top" }, { default: o(() => [i("div", null, [a[0] || (a[0] = i("span", null, "一级科目", -1)), s(t, null, { default: o(() => [s(e)]), _: 1 })])]), _: 1 })]), default: o((r) => [i("div", Q, [i("span", null, v(`${r.row.fullName[0]}-${r.row.fullSerialNumber[0]}`), 1)])]), _: 1 })) : m("", true), u(g).visible("level2") ? (d(), _(n, { key: 1, prop: "level2", label: "二级", align: "left", "min-width": "160px" }, { header: o(() => [s(c, { effect: "light", content: "二级科目（名称-编号）", placement: "top" }, { default: o(() => [i("div", null, [a[1] || (a[1] = i("span", null, "二级科目", -1)), s(t, null, { default: o(() => [s(e)]), _: 1 })])]), _: 1 })]), default: o((r) => [i("div", W, [r.row.fullName.length > 1 ? (d(), w("span", X, v(`${r.row.fullName[1]}-${r.row.fullSerialNumber[1]}`), 1)) : m("", true)])]), _: 1 })) : m("", true), u(g).visible("level3") ? (d(), _(n, { key: 2, prop: "level3", label: "三级", align: "left", "min-width": "160px" }, { header: o(() => [s(c, { effect: "light", content: "三级科目（名称-编号）", placement: "top" }, { default: o(() => [i("div", Y, [a[2] || (a[2] = i("span", null, "三级科目", -1)), s(t, null, { default: o(() => [s(e)]), _: 1 })])]), _: 1 })]), default: o((r) => [i("div", Z, [r.row.fullName.length > 2 ? (d(), w("span", ee, v(`${r.row.fullName[2]}-${r.row.fullSerialNumber[2]}`), 1)) : m("", true)])]), _: 1 })) : m("", true), s(n, { key: "rdRate", prop: "rdRate", "show-overflow-tooltip": true, label: "研发费占比", "min-width": "100px", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[B, u(f).loading]]) : m("", true)]);
  };
} }, ue = L(te, [["__scopeId", "data-v-382a8966"]]);
export {
  ue as default
};
