import { ref as x } from "vue";
import { computed as P } from "vue";
import { onUnmounted as U } from "vue";
import { nextTick as V } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { unref as u } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as S } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElTableColumn as F } from "element-plus";
import { InfoFilled as G } from "@element-plus/icons-vue";
import { ElIcon as K } from "element-plus";
import { ElTooltip as L } from "element-plus";
import { vLoading as Q } from "element-plus";
import { l as I, _ as W, o as z, x as X, hC as $, i as k, G as Y, an as Z } from "../../../../shared/runtime.js";
import ee from "./module/header.vue.js";
import le from "./module/form.vue.js";
function te() {
  return I({ module: "config", url: "classification/material/measure/quality-testing", method: "get" });
}
function ae({ ids: b }) {
  return I({ module: "config", url: "classification/material/measure/quality-testing", method: "put", data: b });
}
function ne(b) {
  return I({ module: "config", url: "classification/material/measure/quality-testing", method: "delete", data: b });
}
const ie = { get: te, add: ae, del: ne };
const se = { class: "app-container" }, oe = { class: "head-container" }, re = { class: "classifyName" }, ue = { class: "classifyName" }, de = { key: 0 }, ce = { style: { margin: "0 10px" } }, fe = { class: "classifyName" }, me = { key: 0 }, pe = { __name: "index", setup(b) {
  const R = { add: true, edit: false, del: true, download: false }, O = x(), y = x(true), N = x([]), { maxHeight: T } = z(), { crud: f, columns: w, CRUD: B } = X({ title: "入库质检物料", sort: ["sort.asc", "id.desc"], permission: { ...$ }, crudApi: { ...ie }, optShow: { ...R }, hasPagination: false }, O), M = P(() => {
    var a, t, e;
    const n = f.data || [];
    let l = JSON.parse(JSON.stringify(n));
    if (f.query) {
      const c = (a = f.query) == null ? void 0 : a.name, s = (t = f.query) == null ? void 0 : t.code, p = (e = f.query) == null ? void 0 : e.basicClass;
      l = l.filter((i) => {
        let h = true;
        return c && !i.fullName.some((v) => v.indexOf(c) > -1) && (h = false), s && !i.fullSerialNumber.some((v) => v.indexOf(s) > -1) && (h = false), p && !(i.basicClass & p) && (h = false), h;
      });
    }
    return H(l);
  });
  U(() => {
  }), B.HOOK.handleRefresh = (n, l) => {
    N.value = [], E(l.data.content), l.data.content = q(l.data.content);
  };
  function E(n) {
    n.forEach((l) => {
      k(l.children) ? (l.classifyQuantity === l.children.length && N.value.push(l.id), E(l.children)) : N.value.push(l.id);
    });
  }
  function q(n, l = 1, a = { fullId: [], fullName: [], fullCode: [], fullSerialNumber: [] }) {
    const t = [];
    return n.forEach((e, c) => {
      e.fullId = [...a.fullId, e.id], e.fullName = [...a.fullName, e.name], e.fullCode = [...a.fullCode, e.code], e.fullSerialNumber = [...a.fullSerialNumber, a.fullCode.join("") + e.code];
      const s = {};
      Object.assign(s, JSON.parse(JSON.stringify(a)), e);
      const p = s.children;
      if (k(p)) {
        const i = { fullId: s.fullId, fullName: s.fullName, fullCode: s.fullCode, fullSerialNumber: s.fullSerialNumber, attribute: s.attribute }, h = q(p, l + 1, i);
        t.push.apply(t, h);
      } else t.push(s);
      delete e.children;
    }), t;
  }
  function H(n) {
    if (n.length === 0) return n;
    const l = [[], []], a = [-1, -1];
    return n.forEach((t) => {
      for (let e = 0; e < l.length; e++) {
        const c = t.fullId[e], s = a.length > e ? a[e] : void 0;
        c === s && k(s) ? l[e][l[e].length - 1]++ : (l[e].push(1), a[e] = c);
      }
    }), l[0].reduce((t, e) => (n[t].name1_rowSpan = e, t += e, t), 0), l[1].reduce((t, e) => (n[t].name2_rowSpan = e, t += e, t), 0), setTimeout(() => {
      y.value = false, V(() => {
        y.value = true;
      });
    }, 1e3), n;
  }
  const J = [0, 2, 1];
  function A({ row: n, column: l, rowIndex: a, columnIndex: t }) {
    if (t === 2) return { rowspan: n.name1_rowSpan || 0, colspan: n.fullName.length === 1 ? 3 : 1 };
    if (t === 3) return { rowspan: n.name2_rowSpan || 0, colspan: J[n.fullName.length - 1] };
    if (t === 4) return { rowspan: 1, colspan: n.fullName.length < 3 ? 0 : 1 };
  }
  return (n, l) => {
    const a = F, t = G, e = K, c = L, s = j("common-table"), p = Q;
    return m(), C("div", se, [d("div", oe, [o(u(ee))]), y.value ? D((m(), g(s, { key: 0, ref_key: "tableRef", ref: O, border: "", data: M.value, "empty-text": u(f).emptyText, "max-height": u(T), "span-method": A, "highlight-current-row": false, onSelectionChange: u(f).selectionChangeHandler, "row-key": "id" }, { default: r(() => [o(a, { type: "selection", width: "55", align: "center" }), o(a, { key: "index", type: "index", label: "序号", align: "center", width: "60" }), u(w).visible("level1") ? (m(), g(a, { key: 0, prop: "level1", label: "一级", align: "left", "min-width": "160px" }, { header: r(() => [o(c, { effect: "light", content: "一级科目（名称-编号）", placement: "top" }, { default: r(() => [d("div", null, [l[0] || (l[0] = d("span", null, "一级科目", -1)), o(e, null, { default: r(() => [o(t)]), _: 1 })])]), _: 1 })]), default: r((i) => [d("div", re, [d("span", null, S(`${i.row.fullName[0]}-${i.row.fullSerialNumber[0]}`), 1)])]), _: 1 })) : _("", true), u(w).visible("level2") ? (m(), g(a, { key: 1, prop: "level2", label: "二级", align: "left", "min-width": "160px" }, { header: r(() => [o(c, { effect: "light", content: "二级科目（名称-编号）", placement: "top" }, { default: r(() => [d("div", null, [l[1] || (l[1] = d("span", null, "二级科目", -1)), o(e, null, { default: r(() => [o(t)]), _: 1 })])]), _: 1 })]), default: r((i) => [d("div", ue, [i.row.fullName.length > 1 ? (m(), C("span", de, S(`${i.row.fullName[1]}-${i.row.fullSerialNumber[1]}`), 1)) : _("", true)])]), _: 1 })) : _("", true), u(w).visible("level3") ? (m(), g(a, { key: 2, prop: "level3", label: "三级", align: "left", "min-width": "160px" }, { header: r(() => [o(c, { effect: "light", content: "三级科目（名称-编号）", placement: "top" }, { default: r(() => [d("div", ce, [l[2] || (l[2] = d("span", null, "三级科目", -1)), o(e, null, { default: r(() => [o(t)]), _: 1 })])]), _: 1 })]), default: r((i) => [d("div", fe, [i.row.fullName.length > 2 ? (m(), C("span", me, S(`${i.row.fullName[2]}-${i.row.fullSerialNumber[2]}`), 1)) : _("", true)])]), _: 1 })) : _("", true), u(Y)([...u($).del]) ? (m(), g(a, { key: 3, label: "操作", width: "90px", align: "center", fixed: "right" }, { default: r(({ row: i }) => [o(u(Z), { data: i, showEdit: false }, null, 8, ["data"])]), _: 1 })) : _("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[p, u(f).loading]]) : _("", true), o(u(le), { "disabled-ids": N.value }, null, 8, ["disabled-ids"])]);
  };
} }, Ne = W(pe, [["__scopeId", "data-v-31783b80"]]);
export {
  Ne as default
};
