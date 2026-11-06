import { ref as h } from "vue";
import { reactive as B } from "vue";
import { provide as N } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as C } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as f } from "vue";
import { withDirectives as R } from "vue";
import { unref as a } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createCommentVNode as c } from "vue";
import { toDisplayString as d } from "vue";
import { Fragment as Y } from "vue";
import { createTextVNode as Q } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElTag as O } from "element-plus";
import { vLoading as F } from "element-plus";
import { l as b, fg as G, x as $, D as _, g7 as H, c3 as x, an as q, P as K, ba as M } from "../../../../shared/runtime.js";
import { g as z, a as J } from "../../../../modules/common-f216149e.js";
import { v as E } from "../../../../modules/contract-9b18cc88.js";
import X from "./module/header.vue.js";
import Z from "./module/form.vue.js";
function ee(u) {
  return b({ module: "contract", url: "contract/wage-fee/page", method: "get", params: u });
}
function ae(u) {
  return b({ module: "contract", url: "contract/wage-fee", method: "post", data: u });
}
function te(u) {
  return b({ module: "contract", url: "contract/wage-fee", method: "put", data: u });
}
function ne(u) {
  return b({ module: "contract", url: `contract/wage-fee/${u}`, method: "delete" });
}
const oe = { get: ee, add: ae, edit: te, del: ne }, re = { class: "app-container" }, le = { class: "head-container" }, de = { __name: "index", setup(u) {
  const { projectTree: D } = G(), L = { add: true, edit: false, del: false, download: false }, k = h(), T = h([]), v = h(), W = B({ info: 0 }), { crud: w, CRUD: A, columns: m } = $({ title: "工资费用", optShow: { ...L }, permission: { ...E }, crudApi: { ...oe }, hasPagination: true }, k);
  P(), N("summaryData", W), N("expenseList", T.value), N("projectList", D);
  const S = h([["fillInDate", ["parse-time", "{y}-{m}-{d}"]], ["totalWage", ["to-thousand", _.YUAN]], ["averageWage", ["to-thousand", _.YUAN]]]);
  function V(r) {
    return M(r, { props: ["employeeQuantity", ["totalWage", _.YUAN], ["averageWage", _.YUAN]], toThousandFields: ["totalWage", "averageWage"] });
  }
  async function P() {
    var r, g, t;
    try {
      const { content: l } = await z({ category: H.WAGE_CATEGORY.V });
      for (let n = 0; n < l.length; n++) T.value.push({ id: (r = l[n]) == null ? void 0 : r.id, name: (g = l[n]) == null ? void 0 : g.name, links: (t = l[n]) == null ? void 0 : t.links });
    } catch (l) {
      console.log("获取费用类别失败", l);
    }
  }
  A.HOOK.handleRefresh = (r, g) => {
    var l;
    const t = [];
    g.data.content = (l = g.data.content) == null ? void 0 : l.map((n) => (t.push(n.reimburseAmount), n)), W.info = t.reduce((n, y) => {
      const e = Number(y);
      return isNaN(e) ? n : n + y;
    }, 0);
  };
  async function U() {
    try {
      const { content: r } = await J();
      v.value = r;
    } catch (r) {
      console.log(r);
    }
  }
  return U(), (r, g) => {
    const t = j, l = O, n = I("common-table"), y = F;
    return o(), C("div", re, [p("div", le, [f(X, { branchList: v.value }, null, 8, ["branchList"])]), R((o(), s(n, { ref_key: "tableRef", ref: k, data: a(w).data, "empty-text": a(w).emptyText, "max-height": r.maxHeight, "data-format": S.value, "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": V }, { default: i(() => [f(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(m).visible("fillInDate") ? (o(), s(t, { align: "center", key: "fillInDate", prop: "fillInDate", "show-overflow-tooltip": true, label: "日期" })) : c("", true), a(m).visible("branchCompanyName") ? (o(), s(t, { key: "branchCompanyName", prop: "branchCompanyName", label: "费用归属", align: "center" }, { default: i(({ row: e }) => [p("span", null, d(e.branchCompanyName || "-"), 1)]), _: 1 })) : c("", true), a(m).visible("expenseTypeName") ? (o(), s(t, { key: "expenseTypeName", prop: "expenseTypeName", label: "费用类型", align: "center" }, { default: i(({ row: e }) => [p("span", null, d(e.expenseTypeName || "-"), 1)]), _: 1 })) : c("", true), a(m).visible("totalWage") ? (o(), s(t, { key: "totalWage", prop: "totalWage", label: "工资总额（元）", align: "center" }, { default: i(({ row: e }) => [p("span", null, d(e.totalWage || "-"), 1)]), _: 1 })) : c("", true), a(m).visible("employeeQuantity") ? (o(), s(t, { key: "employeeQuantity", prop: "employeeQuantity", label: "员工总数", align: "center" }, { default: i(({ row: e }) => [p("span", null, d(e.employeeQuantity || "-"), 1)]), _: 1 })) : c("", true), a(m).visible("averageWage") ? (o(), s(t, { key: "averageWage", prop: "averageWage", label: "平均工资（元）", align: "center" }, { default: i(({ row: e }) => [p("span", null, d(e.averageWage), 1)]), _: 1 })) : c("", true), a(m).visible("founderName") ? (o(), s(t, { align: "center", key: "founderName", prop: "founderName", "show-overflow-tooltip": true, label: "创建人" }, { default: i((e) => [p("span", null, d(e.row.founderName), 1)]), _: 1 })) : c("", true), f(t, { align: "center", label: "操作" }, { default: i((e) => [e.row.auditStatusEnum === a(x).AUDITING.V ? (o(), s(a(q), { key: 0, data: e.row, permission: a(E) }, null, 8, ["data", "permission"])) : (o(), C(Y, { key: 1 }, [e.row.auditStatusEnum ? (o(), s(l, { key: 0, type: a(x).V[e.row.auditStatusEnum].TYPE }, { default: i(() => [Q(d(a(x).VL[e.row.auditStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : c("", true)], 64))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[y, a(w).loading]]), f(a(K)), f(Z, { branchList: v.value }, null, 8, ["branchList"])]);
  };
} };
export {
  de as default
};
