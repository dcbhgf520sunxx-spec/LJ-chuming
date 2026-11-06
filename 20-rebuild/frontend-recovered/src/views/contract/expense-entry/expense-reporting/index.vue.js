import { ref as v } from "vue";
import { reactive as C } from "vue";
import { provide as N } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as b } from "vue";
import { withDirectives as R } from "vue";
import { unref as t } from "vue";
import { createBlock as u } from "vue";
import { withCtx as s } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as f, t as H, x as L, o as O, p as V, z as F, an as M, P as $ } from "../../../../shared/runtime.js";
import { o as k } from "../../../../modules/contract-9b18cc88.js";
import q from "./module/header.vue.js";
import z from "./module/form.vue.js";
import "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
function K(i) {
  return f({ module: "", url: "/api/contract/expense-reimburse", method: "get", params: i });
}
function G(i) {
  return f({ module: "contract", url: "expenseType/all", method: "get", params: i });
}
function I(i) {
  return f({ module: "", url: "/api/contract/expense-reimburse", method: "post", data: [i] });
}
function J(i) {
  return f({ module: "", url: "/api/contract/expense-reimburse", method: "put", data: i });
}
function Q(i) {
  return f({ module: "", url: "/api/contract/expense-reimburse", method: "delete", data: i });
}
const W = { get: K, add: I, edit: J, del: Q }, X = { class: "app-container" }, Y = { class: "head-container" }, se = { __name: "index", setup(i) {
  const { decimalPrecision: D } = H(), T = { add: true, edit: false, del: false, download: false }, x = v(), y = v([]), g = C({ info: 0 }), { crud: _, CRUD: j, columns: p } = L({ title: "费用填报", sort: [], optShow: { ...T }, permission: { ...k }, crudApi: { ...W }, hasPagination: true }, x);
  B(), N("summaryData", g), N("expenseList", y.value);
  async function B() {
    var w, d, a;
    try {
      const { content: o } = await G();
      for (let r = 0; r < o.length; r++) y.value.push({ id: (w = o[r]) == null ? void 0 : w.id, name: (d = o[r]) == null ? void 0 : d.name, links: (a = o[r]) == null ? void 0 : a.links });
    } catch (o) {
      console.log("获取费用类别失败", o);
    }
  }
  const { maxHeight: A } = O({ extraBox: [".head-container"], paginate: true });
  return j.HOOK.handleRefresh = (w, d) => {
    var o;
    const a = [];
    d.data.content = (o = d.data.content) == null ? void 0 : o.map((r) => (a.push(r.reimburseAmount), r)), g.info = a.reduce((r, e) => {
      const h = Number(e);
      return isNaN(h) ? r : r + e;
    }, 0);
  }, (w, d) => {
    const a = U, o = S("common-table"), r = E;
    return n(), P("div", X, [l("div", Y, [b(q)]), R((n(), u(o, { ref_key: "tableRef", ref: x, data: t(_).data, "empty-text": t(_).emptyText, "max-height": t(A), "row-key": "id", style: { width: "100%" } }, { default: s(() => [b(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(p).visible("reimburseDate") ? (n(), u(a, { align: "center", key: "reimburseDate", prop: "reimburseDate", "show-overflow-tooltip": true, label: "日期" }, { default: s((e) => [l("span", null, m(e.row.reimburseDate ? t(V)(e.row.reimburseDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : c("", true), t(p).visible("deptName") ? (n(), u(a, { align: "center", key: "deptName", prop: "deptName", "show-overflow-tooltip": true, label: "部门" }, { default: s((e) => [l("span", null, m(e.row.deptName), 1)]), _: 1 })) : c("", true), t(p).visible("reimburseUserName") ? (n(), u(a, { align: "center", key: "reimburseUserName", prop: "reimburseUserName", "show-overflow-tooltip": true, label: "报销人" }, { default: s((e) => [l("span", null, m(e.row.reimburseUserName), 1)]), _: 1 })) : c("", true), t(p).visible("expenseTypeName") ? (n(), u(a, { align: "center", key: "expenseTypeName", prop: "expenseTypeName", "show-overflow-tooltip": true, label: "费用类别" }, { default: s((e) => [l("span", null, m(e.row.expenseTypeName), 1)]), _: 1 })) : c("", true), t(p).visible("expenseSubjectName") ? (n(), u(a, { align: "center", key: "expenseSubjectName", prop: "expenseSubjectName", "show-overflow-tooltip": true, label: "费用科目" }, { default: s((e) => [l("span", null, m(e.row.expenseSubjectName), 1)]), _: 1 })) : c("", true), t(p).visible("reimburseAmount") ? (n(), u(a, { align: "center", key: "reimburseAmount", prop: "reimburseAmount", "show-overflow-tooltip": true, label: "报销金额（元）" }, { default: s((e) => {
      var h;
      return [l("span", null, m((h = e.row.reimburseAmount) == null ? void 0 : h.toFixed(t(D).contract)), 1)];
    }), _: 1 })) : c("", true), t(p).visible("project") ? (n(), u(a, { align: "center", key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目" }, { default: s((e) => [l("span", null, m(t(F)(e.row.project)), 1)]), _: 1 })) : c("", true), t(p).visible("writtenByName") ? (n(), u(a, { align: "center", key: "writtenByName", prop: "writtenByName", "show-overflow-tooltip": true, label: "填报人" }, { default: s((e) => [l("span", null, m(e.row.writtenByName), 1)]), _: 1 })) : c("", true), t(p).visible("remark") ? (n(), u(a, { align: "center", key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注" }, { default: s((e) => [l("span", null, m(e.row.remark), 1)]), _: 1 })) : c("", true), b(a, { align: "center", label: "操作" }, { default: s((e) => [b(t(M), { data: e.row, permission: t(k) }, null, 8, ["data", "permission"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[r, t(_).loading]]), b(t($)), b(z)]);
  };
} };
export {
  se as default
};
