import { ref as v } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as s } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as T } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as r } from "vue";
import { createTextVNode as C } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElTag as S } from "element-plus";
import { vLoading as D } from "element-plus";
import { c as A, m as H } from "./module/header.vue.js";
import { x as V, q6 as E, o as W, p as c, q7 as B, i as w, bV as m, q8 as h, P as N } from "../../../../shared/runtime.js";
import "../../../../modules/project-select-94bb5bbd.js";
const j = { class: "app-container" }, q = { class: "head-container" }, P = { key: 0 }, L = { key: 1 }, Q = { key: 0 }, M = { key: 1 }, U = { key: 0 }, z = { key: 1 }, $ = { __name: "index", setup(F) {
  const f = { add: false, edit: false, del: false, download: false }, u = v(), { crud: d, columns: G, CRUD: I } = V({ title: "点工记录", optShow: { ...f }, permission: { ...E }, crudApi: { ...A }, sort: [], hasPagination: true }, u), { maxHeight: _ } = W({ paginate: true });
  return (J, K) => {
    const l = R, k = S, y = b("common-table"), g = D;
    return i(), s("div", j, [p("div", q, [o(t(H))]), x((i(), T(y, { ref_key: "tableRef", ref: u, data: t(d).data, "empty-text": t(d).emptyText, "max-height": t(_), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, "row-key": "id" }, { default: a(() => [o(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), o(l, { key: "reportDate", prop: "reportDate", "show-overflow-tooltip": "", label: "上报日期", align: "center", width: "90" }, { default: a((e) => [p("span", null, r(e.row.reportDate ? t(c)(e.row.reportDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), o(l, { key: "reporter", prop: "reporter", "show-overflow-tooltip": "", label: "上报人", align: "center", width: "90" }, { default: a((e) => {
      var n;
      return [p("span", null, r(((n = e.row.reporter) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 }), o(l, { key: "createTime", prop: "createTime", "show-overflow-tooltip": "", label: "创建日期", align: "center", width: "150" }, { default: a((e) => [p("span", null, r(e.row.createTime ? t(c)(e.row.createTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)]), _: 1 }), o(l, { key: "team", prop: "team", "show-overflow-tooltip": "", label: "所属班组", align: "center", width: "90" }, { default: a((e) => {
      var n;
      return [p("span", null, r(((n = e.row.team) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 }), o(l, { key: "tempWorkQuotaConfig", prop: "tempWorkQuotaConfig", "show-overflow-tooltip": "", label: "点工类型", align: "center", width: "90" }, { default: a((e) => {
      var n;
      return [p("span", null, r(((n = e.row.tempWorkQuotaConfig) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 }), o(l, { key: "reason", prop: "reason", "show-overflow-tooltip": "", label: "点工原因", align: "center", width: "90" }, { default: a((e) => [p("span", null, r(t(B).VL[e.row.reason] || "-"), 1)]), _: 1 }), o(l, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "150" }, { default: a((e) => {
      var n;
      return [p("span", null, r(((n = e.row.project) == null ? void 0 : n.shortName) || "-"), 1)];
    }), _: 1 }), o(l, { key: "workHour", prop: "workHour", "show-overflow-tooltip": "", label: "工时(h)", align: "center", width: "90" }, { default: a((e) => [p("span", null, r(e.row.workHour ?? "-"), 1)]), _: 1 }), o(l, { key: "description", prop: "description", "show-overflow-tooltip": "", label: "描述", align: "center", "min-width": "120" }, { default: a((e) => [p("span", null, r(e.row.description || "-"), 1)]), _: 1 }), o(l, { key: "price", prop: "price", "show-overflow-tooltip": "", label: `工时单价
(元/小时)`, align: "center", width: "90" }, { default: a((e) => [t(w)(e.row.price) ? (i(), s("span", P, r(t(m)(e.row.price)), 1)) : (i(), s("span", L, "-"))]), _: 1 }), o(l, { key: "amount", prop: "amount", "show-overflow-tooltip": "", label: "点工金额(元)", align: "center", width: "100" }, { default: a((e) => [t(w)(e.row.amount) ? (i(), s("span", Q, r(t(m)(e.row.amount)), 1)) : (i(), s("span", M, "-"))]), _: 1 }), o(l, { key: "calculateAmount", prop: "calculateAmount", "show-overflow-tooltip": "", label: "核算金额(元)", align: "center", width: "100" }, { default: a((e) => [t(w)(e.row.calculateAmount) ? (i(), s("span", U, r(t(m)(e.row.calculateAmount)), 1)) : (i(), s("span", z, "-"))]), _: 1 }), o(l, { key: "approvalStatus", prop: "approvalStatus", "show-overflow-tooltip": "", label: "审批状态", align: "center", width: "100" }, { default: a((e) => {
      var n;
      return [o(k, { effect: "light", type: (n = t(h).V[e.row.approvalStatus]) == null ? void 0 : n.T }, { default: a(() => [C(r(t(h).VL[e.row.approvalStatus] || "-"), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), o(l, { key: "approvalRemark", prop: "approvalRemark", "show-overflow-tooltip": "", label: "审核备注", align: "center", "min-width": "120" }, { default: a((e) => [p("span", null, r(e.row.approvalRemark || "-"), 1)]), _: 1 }), o(l, { key: "approvalTime", prop: "approvalTime", "show-overflow-tooltip": "", label: "审批通过日期", align: "center", width: "150" }, { default: a((e) => [p("span", null, r(e.row.approvalTime ? t(c)(e.row.approvalTime, "{y}-{m}-{d} {h}:{i}:{s}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[g, t(d).loading]]), o(t(N))]);
  };
} };
export {
  $ as default
};
