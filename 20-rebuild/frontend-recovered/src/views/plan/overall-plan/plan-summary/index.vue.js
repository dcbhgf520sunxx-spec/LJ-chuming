import { ref as D } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as y } from "vue";
import { withCtx as a } from "vue";
import { toDisplayString as l } from "vue";
import { createCommentVNode as k } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTooltip as M } from "element-plus";
import { vLoading as T } from "element-plus";
import { l as V, _ as q, x as A, o as L, i } from "../../../../shared/runtime.js";
import { i as O } from "../../../../modules/plan-d12d7ccf.js";
import P from "./module/header.vue.js";
function U(w) {
  return V({ module: "plan", url: "planDetail/summary", method: "get", params: w });
}
const I = { get: U };
const K = { class: "app-container" }, Q = { class: "head-container" }, $ = { __name: "index", setup(w) {
  const S = { add: false, edit: false, del: false, download: false }, b = D(), { crud: p, columns: g, CRUD: F } = A({ title: "排产汇总", permission: { ...O.value }, optShow: { ...S }, requiredQuery: ["type", "year"], crudApi: { ...I }, hasPagination: false }, b), { maxHeight: v } = L({ wrapperBox: ".plan-summary", paginate: true, extraHeight: 40 });
  function j(c) {
    const { columns: s, data: t } = c, r = [], _ = ["month1", "month2", "month3", "month4", "month5", "month6", "month7", "month8", "month9", "month10", "month11", "month12", "monthSummary"], f = {};
    return s.forEach((e, h) => {
      if (h === 1) {
        r[h] = "计划完成合计";
        return;
      }
      if (!_.includes(e.property)) return;
      const x = t.map((d) => Number(d[e.property]));
      x.every((d) => isNaN(d)) || (r[h] = x.reduce((d, N) => {
        const C = Number(N);
        return isNaN(C) ? d : d + N;
      }, 0), f[e.property] = r[h]), r[h] = Number(r[h]).toFixed(2);
    }), r;
  }
  return F.HOOK.handleRefresh = (c, s) => {
    s.data.content = s.data.content.map((t) => (t.projectName = t.project && t.project.shortName ? t.project.serialNumber + " " + t.project.shortName : "-", t.monomerName = t.monomer && t.monomer.name ? t.monomer.name : "-", t.details && t.details.length > 0 && (t.monthSummary = 0, t.details.map((r) => {
      t["month" + Number(r.month)] = r.mete ? r.mete : 0, t.monthSummary = r.mete ? t.monthSummary + r.mete : t.monthSummary;
    })), t));
  }, (c, s) => {
    const t = H, r = M, _ = B("common-table"), f = T;
    return u(), E("div", K, [m("div", Q, [n(o(P))]), R((u(), y(_, { ref_key: "tableRef", ref: b, data: o(p).data, "empty-text": o(p).emptyText, "show-summary": "", stripe: false, "summary-method": j, "max-height": o(v), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: a(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }), o(g).visible("projectName") ? (u(), y(t, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目", "min-width": "150" }, { default: a((e) => [n(r, { content: e.row.project.serialNumber + " " + e.row.project.name, disabled: !e.row.project, "show-after": 50, placement: "top" }, { default: a(() => [m("span", null, l(e.row.projectName), 1)]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 })) : k("", true), o(g).visible("monomerName") ? (u(), y(t, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "150" })) : k("", true), n(t, { align: "center", label: "计划交期" }, { default: a(() => [n(t, { key: "month1", prop: "month1", align: "center", label: "1月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month1) ? e.row.month1.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month2", prop: "month2", align: "center", label: "2月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month2) ? e.row.month2.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month3", prop: "month3", align: "center", label: "3月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month3) ? e.row.month3.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month4", prop: "month4", align: "center", label: "4月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month4) ? e.row.month4.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month5", prop: "month5", align: "center", label: "5月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month5) ? e.row.month5.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month6", prop: "month6", align: "center", label: "6月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month6) ? e.row.month6.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month7", prop: "month7", align: "center", label: "7月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month7) ? e.row.month7.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month8", prop: "month8", align: "center", label: "8月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month8) ? e.row.month8.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month9", prop: "month9", align: "center", label: "9月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month9) ? e.row.month9.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month10", prop: "month10", align: "center", label: "10月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month10) ? e.row.month10.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month11", prop: "month11", align: "center", label: "11月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month11) ? e.row.month11.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "month12", prop: "month12", align: "center", label: "12月" }, { default: a((e) => [m("div", null, l(o(i)(e.row.month12) ? e.row.month12.toFixed(2) : "-"), 1)]), _: 1 }), n(t, { key: "monthSummary", prop: "monthSummary", align: "center", label: "合计" }, { default: a((e) => [m("div", null, l(o(i)(e.row.monthSummary) ? e.row.monthSummary.toFixed(2) : "-"), 1)]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[f, o(p).loading]])]);
  };
} }, X = q($, [["__scopeId", "data-v-9048db40"]]);
export {
  X as default
};
