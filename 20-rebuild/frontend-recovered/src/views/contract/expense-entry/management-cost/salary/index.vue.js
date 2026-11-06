import { ref as V } from "vue";
import { computed as I } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as d } from "vue";
import { withDirectives as P } from "vue";
import { unref as n } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as f } from "vue";
import { Fragment as T } from "vue";
import { renderList as H } from "vue";
import { ElTableColumn as M } from "element-plus";
import { InfoFilled as O } from "@element-plus/icons-vue";
import { ElIcon as A } from "element-plus";
import { ElTooltip as U } from "element-plus";
import { vLoading as K } from "element-plus";
import { l as N, t as j, x as z, o as G, an as J, iy as X } from "../../../../../shared/runtime.js";
import { s as D } from "../../../../../modules/contract-9b18cc88.js";
import Y from "./module/header.vue.js";
import Z from "./module/form.vue.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
function ee(i) {
  return N({ module: "", url: "/api/contract/wage-summary", method: "get", params: i });
}
function te(i) {
  return N({ module: "", url: "/api/contract/wage-summary", method: "post", data: [i] });
}
function ae(i) {
  return N({ module: "", url: "/api/contract/wage-summary", method: "post", data: [i] });
}
function oe(i) {
  return N({ module: "", url: "/api/contract/wage-summary", method: "delete", data: i });
}
const ne = { get: ee, add: te, edit: ae, del: oe }, le = { class: "app-container" }, re = { class: "head-container" }, se = { style: { display: "inline-block" } }, ie = ["onDblclick"], ye = { __name: "index", setup(i) {
  const { decimalPrecision: Q } = j(), S = V(), b = V(false), W = V(), E = { add: true, edit: false, del: false, download: false }, B = I(() => [["averageValue", ["to-fixed", Q.value.contract]]]), { crud: k, CRUD: R, columns: h } = z({ title: "人员工资", sort: [], optShow: { ...E }, permission: { ...D }, crudApi: { ...ne }, hasPagination: false }, S);
  function $(g) {
    W.value = g.id, b.value = true;
  }
  function q(g) {
    const { columns: r, data: t } = g, a = [];
    return r.forEach((v, u) => {
      if (u === 0) {
        a[u] = "合计";
        return;
      }
      if (u === 3) {
        a[u] = 0;
        const y = t.map((o) => o.employeeQuantity), _ = t.map((o) => o.totalWage), e = y.reduce((o, w) => w ? o + Number(w) : o, 0), c = _.reduce((o, w) => w ? o + Number(w) : o, 0);
        a[u] = (c / e).toFixed(Q.value.contract);
        return;
      }
      if (v.property === "employeeQuantity" || v.property === "totalWage") {
        const y = t.map((e) => Number(e[v.property]));
        let _ = 0;
        y.every((e) => isNaN(e)) || (_ = y.reduce((e, c) => {
          const o = Number(c);
          return isNaN(o) ? e : e + c;
        }, 0)), a[u] = _;
      }
    }), a;
  }
  R.HOOK.handleRefresh = (g, r) => {
    var t;
    r.data.content = (t = r.data.content) == null ? void 0 : t.map((a) => (a.averageValue = a.totalWage / a.employeeQuantity, a));
  };
  const { maxHeight: F } = G({ extraBox: [".head-container"], paginate: true });
  return (g, r) => {
    const t = M, a = O, v = A, u = U, y = L("common-table"), _ = K;
    return l(), C("div", le, [m("div", re, [d(Y)]), P((l(), p(y, { ref_key: "tableRef", ref: S, data: n(k).data, "data-format": B.value, "empty-text": n(k).emptyText, "max-height": n(F), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": q }, { default: s(() => [n(h).visible("month") ? (l(), p(t, { key: 0, prop: "month", label: "月份", align: "center", width: "100" }, { default: s(({ row: e }) => [m("span", null, x(e.month) + "月", 1)]), _: 1 })) : f("", true), n(h).visible("employeeQuantity") ? (l(), p(t, { align: "center", key: "employeeQuantity", prop: "employeeQuantity", "show-overflow-tooltip": true, label: "员工人数" }, { default: s(({ row: e }) => [m("span", null, x(e.employeeQuantity), 1)]), _: 1 })) : f("", true), n(h).visible("totalWage") ? (l(), p(t, { align: "center", key: "totalWage", prop: "totalWage", "show-overflow-tooltip": true, label: "工资总额" }, { default: s(({ row: e }) => [m("span", null, x(e.totalWage), 1)]), _: 1 })) : f("", true), n(h).visible("averageValue") ? (l(), p(t, { align: "center", key: "averageValue", prop: "averageValue", "show-overflow-tooltip": true, label: "平均工资（人/元）" })) : f("", true), n(h).visible("attachments") ? (l(), p(t, { align: "center", key: "attachments", prop: "attachments", "show-overflow-tooltip": true, label: "附件" }, { header: s(() => [d(u, { class: "item", effect: "dark", content: "双击编号可预览文附件", placement: "top" }, { default: s(() => [m("div", se, [r[1] || (r[1] = m("span", null, "附件", -1)), d(v, null, { default: s(() => [d(a)]), _: 1 })])]), _: 1 })]), default: s((e) => [e.row.attachments && e.row.attachments.length > 0 ? (l(true), C(T, { key: 0 }, H(e.row.attachments, (c) => (l(), C("div", { key: c.id }, [m("div", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (o) => $(c) }, x(c.name), 41, ie)]))), 128)) : f("", true)]), _: 1 })) : f("", true), d(t, { align: "center", label: "操作", width: "200px" }, { default: s((e) => [d(n(J), { data: e.row, permission: n(D) }, null, 8, ["data", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[_, n(k).loading]]), d(Z, { query: n(k).query }, null, 8, ["query"]), b.value ? (l(), p(X, { key: 0, isVisible: b.value, showType: "attachment", id: W.value, onClose: r[0] || (r[0] = (e) => b.value = false) }, null, 8, ["isVisible", "id"])) : f("", true)]);
  };
} };
export {
  ye as default
};
