import { ref as E } from "vue";
import { nextTick as R } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as x } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as m } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTag as V } from "element-plus";
import { ElDescriptionsItem as B } from "element-plus";
import { ElDescriptions as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as I } from "../../../modules/dept-task-1cfc3d1d.js";
import { _ as z, x as F, o as U, i as C, p as S, P as q, gD as K, iG as Q, bN as G, aI as k } from "../../../shared/runtime.js";
import { p as $ } from "../../../modules/plan-d12d7ccf.js";
import J from "./module/header.vue.js";
import W from "./module/dept-plan.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./module/user-dialog.vue.js";
import "../../../modules/index-9d220fe1.js";
import "../../../modules/use-users-4d979987.js";
const X = { class: "app-container" }, Y = { class: "head-container" }, Z = { style: { display: "flex" } }, ee = { style: { width: "450px", "margin-right": "20px" } }, te = { style: { flex: "1", overflow: "hidden" } }, ae = { __name: "index", setup(ne) {
  const L = { add: false, edit: false, del: false, download: false }, h = E(), { crud: _, CRUD: v } = F({ title: "我的任务", hasPagination: true, sort: [], permission: { get: $.get }, optShow: { ...L }, crudApi: { ...I } }, h), { maxHeight: b } = U({ paginate: true }), i = E(null);
  function N(d) {
    var a;
    d && ((a = d.monomerList) == null || a.forEach((e, p) => {
      var g, c;
      e.idx = p + 1, e.uid = k(), e.isMonomer = true, e.areaList = e.areaDTOList, e.deepenNames = ((c = (g = e.deepenIdsAndName) == null ? void 0 : g.map((n) => n.deepenedPersonName)) == null ? void 0 : c.join("、")) || "", e.areaList.forEach((n, y) => {
        n.idx = e.idx + "." + (y + 1), n.uid = k(), n.isMonomer = false, n.completeRate = n.actualCompletion ? (n.actualCompletion / n.mete * 100).toFixed(2) : 0, e.deepenStartDate = e.deepenStartDate ? Math.min(e.deepenStartDate, n.deepenStartDate) : n.deepenStartDate, e.deepenEndDate = e.deepenEndDate ? Math.max(e.deepenEndDate, n.deepenEndDate) : n.deepenEndDate;
      });
    }), i.value = d);
  }
  function T() {
    _.toQuery(), _.data.forEach((d) => {
      d.id === i.value.id && console.log(d, "12333");
    });
  }
  return v.HOOK.afterToQuery = () => {
    console.log(_.data);
  }, v.HOOK.afterRefresh = (d) => {
    const a = d.data.find((e) => {
      var p;
      return (e == null ? void 0 : e.id) === ((p = i.value) == null ? void 0 : p.id);
    });
    i.value = void 0, C(a) && (R(() => {
      h.value.setCurrentRow(a);
    }), console.log(a, i.value, "111"));
  }, (d, a) => {
    var D;
    const e = M, p = V, g = j("common-table"), c = B, n = O, y = P;
    return f(), w("div", X, [r("div", Y, [s(o(J))]), r("div", Z, [r("div", ee, [A((f(), x(g, { ref_key: "tableRef", ref: h, data: o(_).data, "empty-text": o(_).emptyText, "max-height": o(b), style: { width: "100%", cursor: "pointer" }, "highlight-current-row": "", onCurrentChange: N }, { default: l(() => [s(e, { label: "序号", type: "index", align: "center", width: "55" }), s(e, { prop: "isCreateDeepArchivist", label: "状态", align: "center", width: "80" }, { default: l(({ row: t }) => [t.isCreateDeepArchivist ? (f(), x(p, { key: 1, type: "success", effect: "plain" }, { default: l(() => a[1] || (a[1] = [u("已创建")])), _: 1, __: [1] })) : (f(), x(p, { key: 0, type: "danger", effect: "plain" }, { default: l(() => a[0] || (a[0] = [u(" 未创建 ")])), _: 1, __: [0] }))]), _: 1 }), s(e, { label: "计划编排日期", align: "center", width: "95" }, { default: l(({ row: t }) => [r("span", null, m(o(S)(t.planCreateDate, "{y}-{m}-{d}")), 1)]), _: 1 }), s(e, { prop: "shortName", label: "项目简称", align: "center", "show-overflow-tooltip": true, "min-width": "100" }, { default: l(({ row: t }) => [r("span", null, m(t.serialNumber + "  " + t.shortName), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, o(_).loading]]), s(o(q))]), r("div", te, [o(C)(i.value) ? (f(), w(H, { key: 0 }, [a[2] || (a[2] = r("div", { class: "dialog-title" }, [r("span", { class: "title", style: { "font-size": "16px" } }, "项目信息")], -1)), s(n, { column: 5, size: "small", border: "", data: i.value, style: { "margin-top": "10px", "margin-bottom": "20px" } }, { default: l(() => [s(c, { label: "立项日期", align: "center" }, { default: l(() => {
      var t;
      return [u(m(o(S)((t = i.value) == null ? void 0 : t.signingDate, "{y}-{m}-{d}")), 1)];
    }), _: 1 }), s(c, { label: "经营方式", align: "center" }, { default: l(() => {
      var t;
      return [u(m(o(K).VL[(t = i.value) == null ? void 0 : t.projectAttribute]), 1)];
    }), _: 1 }), s(c, { label: "订单类型", align: "center" }, { default: l(() => {
      var t;
      return [u(m(o(Q).VL[(t = i.value) == null ? void 0 : t.businessType]), 1)];
    }), _: 1 }), s(c, { label: "结构类型", align: "center" }, { default: l(() => {
      var t;
      return [u(m(o(G).VL[(t = i.value) == null ? void 0 : t.structureStatus]), 1)];
    }), _: 1 }), s(c, { label: "项目经理", align: "center" }, { default: l(() => {
      var t;
      return [u(m((t = i.value) == null ? void 0 : t.projectManagerName), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data"]), a[3] || (a[3] = r("div", { class: "dialog-title", style: { "margin-bottom": "10px" } }, [r("span", { class: "title", style: { "font-size": "16px" } }, "部门计划")], -1)), s(W, { maxHeight: o(b) - 200, projectDetail: i.value, infoList: ((D = i.value) == null ? void 0 : D.monomerList) || [], onSuccess: T }, null, 8, ["maxHeight", "projectDetail", "infoList"])], 64)) : (f(), x(p, { key: 1, type: "warning" }, { default: l(() => a[4] || (a[4] = [u(" * 请点击左侧项目列表查看详情 ")])), _: 1, __: [4] }))])])]);
  };
} }, ge = z(ae, [["__scopeId", "data-v-098ba8f1"]]);
export {
  ge as default
};
