import { ref as d } from "vue";
import { provide as $ } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { createBlock as f } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as l } from "vue";
import { withModifiers as h } from "vue";
import { createCommentVNode as m } from "vue";
import { withDirectives as A } from "vue";
import { toDisplayString as n } from "vue";
import { ElMessage as I } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as q, b as U } from "../../../../modules/behavior-scoring-beef2568.js";
import { _ as H, o as j, x as F, nZ as _, G as b, p as G, n_ as Z, n$ as J, o0 as C, P as K } from "../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import Q from "./module/violation-record.vue.js";
import W from "./module/scoring-config.vue.js";
import X from "./module/add-score.vue.js";
const Y = { class: "app-container" }, ee = { class: "head-container flex" }, oe = { key: 0 }, te = { style: { color: "red" } }, ae = { __name: "index", setup(re) {
  const k = d(), u = d(), w = d(false), v = d(false), { maxHeight: D } = j({ paginate: true }), { crud: s } = F({ title: "行为记分", permission: { get: _.get }, crudApi: { ...q }, hasPagination: true }, k);
  function B(p) {
    w.value = true, u.value = p;
  }
  function T(p) {
    v.value = true, u.value = p;
  }
  async function V() {
    try {
      await U() || (I.error("请先配置行为总分！"), s.toAdd());
    } catch (p) {
      console.log(p);
    }
  }
  return V(), $("query", s.query), (p, i) => {
    const g = x("common-button"), r = z, P = L, R = x("common-table"), E = M;
    return c(), S("div", Y, [y("div", ee, [o(O, { ref: "header" }, null, 512), a(b)(a(_).config) ? (c(), f(g, { key: 0, size: "default", type: "primary", onClick: h(a(s).toAdd, ["stop"]) }, { default: t(() => i[2] || (i[2] = [l(" 行为记分配置 ")])), _: 1, __: [2] }, 8, ["onClick"])) : m("", true)]), A((c(), f(R, { ref_key: "tableRef", ref: k, data: a(s).data, "empty-text": a(s).emptyText, "max-height": a(D), style: { width: "100%" }, onSortChange: a(s).handleSortChange }, { default: t(() => [o(r, { label: "序号", align: "center", width: "50", type: "index" }), o(r, { key: "entryDate", prop: "entryDate", "show-overflow-tooltip": "", align: "center", label: "入职时间", sortable: "custom" }, { default: t((e) => [e.row.entryDate ? (c(), S("span", oe, n(a(G)(e.row.entryDate, "{y}-{m}-{d}")), 1)) : m("", true)]), _: 1 }), o(r, { key: "number", prop: "number", "show-overflow-tooltip": "", align: "center", label: "编号" }, { default: t((e) => [l(n(e.row.number || "-"), 1)]), _: 1 }), o(r, { key: "name", prop: "name", "show-overflow-tooltip": "", align: "center", label: "姓名" }, { default: t((e) => [l(n(e.row.name || "-"), 1)]), _: 1 }), o(r, { key: "age", prop: "age", "show-overflow-tooltip": "", align: "center", label: "年龄" }, { default: t((e) => [l(n(e.row.age), 1)]), _: 1 }), o(r, { key: "sex", prop: "sex", "show-overflow-tooltip": "", align: "center", label: "性别" }, { default: t((e) => [y("span", null, n(a(Z).VL[e.row.sex] || "-"), 1)]), _: 1 }), o(r, { key: "nation", prop: "nation", "show-overflow-tooltip": "", align: "center", label: "民族" }, { default: t((e) => [l(n(e.row.nation || "-"), 1)]), _: 1 }), o(r, { key: "phone", prop: "phone", "show-overflow-tooltip": "", align: "center", label: "联系方式" }, { default: t((e) => [l(n(e.row.phone || "-"), 1)]), _: 1 }), o(r, { key: "employeeCategory", prop: "employeeCategory", "show-overflow-tooltip": "", align: "center", label: "类别" }, { default: t((e) => [l(n(a(J).VL[e.row.employeeCategory] || "-"), 1)]), _: 1 }), o(r, { key: "behaviorTotalScore", prop: "behaviorTotalScore", "show-overflow-tooltip": "", align: "center", label: "行为总分" }, { default: t((e) => [l(n(e.row.behaviorTotalScore), 1)]), _: 1 }), o(r, { key: "deductedBehaviorScore", prop: "deductedBehaviorScore", "show-overflow-tooltip": "", align: "center", label: "已记分" }, { default: t((e) => [y("span", te, n(e.row.deductedBehaviorScore), 1)]), _: 1 }), o(r, { key: "remainingBehaviorScore", prop: "remainingBehaviorScore", "show-overflow-tooltip": "", align: "center", label: "剩余行为分" }, { default: t((e) => [l(n(e.row.remainingBehaviorScore), 1)]), _: 1 }), o(r, { key: "cumulativePenalty", prop: "cumulativePenalty", "show-overflow-tooltip": "", align: "center", label: "累计处罚（元）", width: "120px" }, { default: t((e) => [l(n(e.row.cumulativePenalty), 1)]), _: 1 }), o(r, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": "", align: "center", label: "所属单位", width: "140px" }, { default: t((e) => [l(n(e.row.supplierName || "-"), 1)]), _: 1 }), o(r, { key: "status", prop: "status", "show-overflow-tooltip": "", align: "center", label: "状态" }, { default: t((e) => [o(P, { size: "large", type: a(C).V[e.row.status].T, style: { "margin-right": "10px" } }, { default: t(() => [l(n(a(C).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), o(r, { "show-overflow-tooltip": "", align: "center", label: "操作", "min-width": "120" }, { default: t((e) => [a(b)(a(_).violationRecordDetail) ? (c(), f(g, { key: 0, size: "default", type: "primary", onClick: h((N) => B(e.row), ["stop"]) }, { default: t(() => i[3] || (i[3] = [l(" 查看 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : m("", true), a(b)(a(_).addScore) && e.row.remainingBehaviorScore <= 0 ? (c(), f(g, { key: 1, size: "default", type: "success", onClick: h((N) => T(e.row), ["stop"]) }, { default: t(() => i[4] || (i[4] = [l(" 加分 ")])), _: 2, __: [4] }, 1032, ["onClick"])) : m("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[E, a(s).loading]]), o(Q, { visible: w.value, "onUpdate:visible": i[0] || (i[0] = (e) => w.value = e), userInfo: u.value }, null, 8, ["visible", "userInfo"]), o(W), o(X, { visible: v.value, "onUpdate:visible": i[1] || (i[1] = (e) => v.value = e), currentRowData: u.value, onSuccess: a(s).refresh }, null, 8, ["visible", "currentRowData", "onSuccess"]), o(a(K))]);
  };
} }, de = H(ae, [["__scopeId", "data-v-b3bfe507"]]);
export {
  de as default
};
