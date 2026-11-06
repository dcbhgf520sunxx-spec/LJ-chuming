import { ref as b } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as f } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as w } from "vue";
import { toDisplayString as r } from "vue";
import { normalizeStyle as O } from "vue";
import { createTextVNode as M } from "vue";
import { Fragment as H } from "vue";
import { renderList as $ } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElDivider as Q } from "element-plus";
import { ElTag as X } from "element-plus";
import { ElProgress as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as Y, g as Z } from "./module/assistance-preview.vue.js";
import { _ as ee, F as v, x as te, o as oe, P as ae } from "../../../../../shared/runtime.js";
import { F as le } from "../../../../../modules/bridge-86f96a4f.js";
import ne from "./module/header.vue.js";
import se from "./module/assistance-drawer.vue.js";
import "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import "../../../../../modules/box-3fab54f9.js";
const re = { class: "app-container wrap" }, ie = { class: "wrap-left" }, pe = { class: "head-container" }, ce = { class: "head-container" }, ue = { style: { "margin-left": "8px", "font-size": "14px" } }, de = { __name: "index", setup(me) {
  const S = { add: false, edit: false, del: false, download: false }, V = { [v.BOX.K]: "success", [v.CELL.K]: "warning", [v.MACHINE_PART.K]: "" }, F = b([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), T = b(), { crud: x, columns: g, CRUD: I } = te({ title: "工序协同", sort: [], permission: { ...le }, optShow: { ...S }, crudApi: { ...Y } }, T), { maxHeight: R } = oe({ paginate: true });
  I.HOOK.handleRefresh = (c, l) => {
    l.data.content = l.data.content.map((e) => {
      var _, u, m, h, y;
      return e.completeRatio = ((_ = e.totalMete) == null ? void 0 : _.netWeight) && ((u = e.totalCompleteMete) == null ? void 0 : u.netWeight) && (((m = e.totalCompleteMete) == null ? void 0 : m.netWeight) / ((h = e.totalMete) == null ? void 0 : h.netWeight) * 100).toFixed(2) || 0, e.monomerName = (y = e.monomer) == null ? void 0 : y.name, e;
    });
  };
  const N = b({}), W = b([]), q = b(false);
  function P(c) {
    N.value = Object.assign({}, c), B(c == null ? void 0 : c.id);
  }
  async function B(c) {
    if (W.value = [], !!c) try {
      q.value = true;
      const { content: l } = await Z({ topTaskOrderId: c });
      W.value = l.map((e) => {
        var _;
        return (_ = e.processList) == null || _.forEach((u) => {
          var m, h, y, C;
          u.completeRatio = ((m = u.totalTaskMete) == null ? void 0 : m.netWeight) && ((h = u.totalCompleteMete) == null ? void 0 : h.netWeight) && (((y = u.totalCompleteMete) == null ? void 0 : y.netWeight) / ((C = u.totalTaskMete) == null ? void 0 : C.netWeight) * 100).toFixed(2) || 0;
        }), e;
      });
    } catch (l) {
      console.log("获取子工单失败", l);
    } finally {
      q.value = false;
    }
  }
  const E = b(false), j = b({});
  function K(c, l) {
    var e;
    j.value = Object.assign({}, c, l, { topTaskOrderId: (e = N.value) == null ? void 0 : e.id }), E.value = true;
  }
  return (c, l) => {
    var A;
    const e = U, _ = D("common-table"), u = Q, m = X, h = G, y = D("common-button"), C = J;
    return p(), L("div", re, [d("div", ie, [d("div", pe, [n(a(ne))]), z((p(), f(_, { ref_key: "tableRef", ref: T, data: a(x).data, "empty-text": a(x).emptyText, "max-height": a(R), "data-format": F.value, style: { width: "100%" }, "highlight-current-row": "", onCurrentChange: P }, { default: s(() => [n(e, { label: "序号", type: "index", align: "center", width: "60" }), a(g).visible("orderNumber") ? (p(), f(e, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "120px" })) : w("", true), a(g).visible("project") ? (p(), f(e, { key: 1, prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "160px" })) : w("", true), a(g).visible("monomerName") ? (p(), f(e, { key: 2, prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "100px" })) : w("", true), a(g).visible("askCompleteTime") ? (p(), f(e, { key: 3, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : w("", true), a(g).visible("totalMete") ? (p(), f(e, { key: 4, align: "center", prop: "totalMete", "show-overflow-tooltip": true, label: "任务量（件/kg）", width: "135px" }, { default: s(({ row: t }) => {
      var o, i;
      return [d("span", null, r(((o = t.totalMete) == null ? void 0 : o.quantity) || 0) + " / " + r(((i = t.totalMete) == null ? void 0 : i.netWeight) || 0), 1)];
    }), _: 1 })) : w("", true), a(g).visible("totalCompleteMete") ? (p(), f(e, { key: 5, align: "center", prop: "totalCompleteMete", "show-overflow-tooltip": true, label: "实际完成（件/kg）", width: "135px" }, { default: s(({ row: t }) => {
      var o;
      return [d("span", null, r(((o = t.totalCompleteMete) == null ? void 0 : o.quantity) || 0) + " / " + r(t.totalCompleteMete.netWeight || 0), 1)];
    }), _: 1 })) : w("", true), a(g).visible("completeRatio") ? (p(), f(e, { key: 6, align: "center", prop: "completeRatio", "show-overflow-tooltip": true, label: "完成率", width: "90px" }, { default: s(({ row: t }) => [d("span", null, r(t.completeRatio) + "%", 1)]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[C, a(x).loading]]), n(a(ae))]), n(u, { direction: "vertical", style: O(`height: ${a(R) + 90}px`) }, null, 8, ["style"]), d("div", { class: "wrap-right", style: O(`height: ${a(R) + 90}px;overflow: auto;`) }, [(A = N.value) != null && A.id ? (p(true), L(H, { key: 1 }, $(W.value, (t) => (p(), L("div", { key: t.id, style: { "margin-bottom": "10px" } }, [d("div", ce, [n(m, { effect: "dark", type: V[a(v).VK[t == null ? void 0 : t.taskTypeEnum]] }, { default: s(() => [M(r(a(v).VL[t == null ? void 0 : t.taskTypeEnum]), 1)]), _: 2 }, 1032, ["type"]), n(m, { style: { "margin-left": "8px" }, effect: "plain" }, { default: s(() => {
      var o, i;
      return [M(r((o = t == null ? void 0 : t.productionLine) == null ? void 0 : o.name) + ">" + r((i = t == null ? void 0 : t.groups) == null ? void 0 : i.name), 1)];
    }), _: 2 }, 1024), d("span", ue, "工单号：" + r(t == null ? void 0 : t.orderNumber), 1)]), n(_, { ref_for: true, ref_key: "tableRef", ref: T, data: t.processList, "empty-text": "暂无数据", style: { width: "100%", cursor: "pointer" } }, { default: s(() => [n(e, { align: "center", prop: "process.name", "show-overflow-tooltip": true, label: "工序" }), n(e, { align: "center", key: "completeRatio", prop: "completeRatio", "show-overflow-tooltip": true, label: "进度", width: "160px" }, { default: s(({ row: o }) => [n(h, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: Number(o.completeRatio), status: "success" }, null, 8, ["percentage"])]), _: 1 }), n(e, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务（件/kg）" }, { default: s(({ row: o }) => {
      var i, k;
      return [d("span", null, r(((i = o.totalTaskMete) == null ? void 0 : i.quantity) || 0) + "/" + r(((k = o.totalTaskMete) == null ? void 0 : k.netWeight) || 0), 1)];
    }), _: 1 }), n(e, { align: "center", prop: "totalCompleteMete.quantity", "show-overflow-tooltip": true, label: "完成（件/kg）" }, { default: s(({ row: o }) => {
      var i, k;
      return [d("span", null, r(((i = o.totalCompleteMete) == null ? void 0 : i.quantity) || 0) + "/" + r(((k = o.totalCompleteMete) == null ? void 0 : k.netWeight) || 0), 1)];
    }), _: 1 }), n(e, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: s(({ row: o }) => [n(y, { size: "default", type: "primary", onClick: (i) => K(o, t) }, { default: s(() => l[2] || (l[2] = [M("班组协同")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 2 }, 1024)]), _: 2 }, 1032, ["data"])]))), 128)) : (p(), f(m, { key: 0, type: "info", size: "large" }, { default: s(() => l[1] || (l[1] = [M(" * 请先选择排产工单，进行班组协同 ")])), _: 1, __: [1] }))], 4), n(se, { visible: E.value, "onUpdate:visible": l[0] || (l[0] = (t) => E.value = t), info: j.value, onSuccess: a(x).toQuery }, null, 8, ["visible", "info", "onSuccess"])]);
  };
} }, xe = ee(de, [["__scopeId", "data-v-d9452382"]]);
export {
  xe as default
};
