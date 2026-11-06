import { ref as C } from "vue";
import { provide as G } from "vue";
import { resolveComponent as K } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as n } from "vue";
import { unref as o } from "vue";
import { withDirectives as J } from "vue";
import { createBlock as h } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as w } from "vue";
import { toDisplayString as _ } from "vue";
import { normalizeStyle as O } from "vue";
import { createTextVNode as W } from "vue";
import { Fragment as X } from "vue";
import { renderList as Y } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { ElDivider as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElProgress as oe } from "element-plus";
import { vLoading as ae } from "element-plus";
import { c as le, g as se } from "../../../../../modules/process-assistance-e91c5400.js";
import { _ as ne, a3 as q, x as ie, rK as P, o as re, bo as E, P as pe } from "../../../../../shared/runtime.js";
import ue from "./module/header.vue.js";
import ce from "./module/assistance-drawer.vue.js";
import "../../../../../modules/use-scheduling-line-f234c58c.js";
import "../../../../../modules/artifact-f1b0ca44.js";
import "./module/assistance-preview.vue.js";
import "./module/assistance-detail-form.vue.js";
import "./module/next-process-assist-dialog.vue.js";
import "./module/assistance-assemble.vue.js";
const de = { class: "app-container wrap" }, me = { class: "wrap-left" }, ge = { class: "head-container" }, he = { class: "head-container" }, fe = { style: { "margin-left": "8px", "font-size": "14px" } }, _e = { __name: "index", setup(ye) {
  const B = { add: false, edit: false, del: false, download: false }, F = { [q.ARTIFACT.K]: "success", [q.ASSEMBLE.K]: "warning", [q.MACHINE_PART.K]: "" }, z = C([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), L = C(), { crud: y, columns: k, CRUD: H } = ie({ title: "工序协同", sort: [], permission: { ...P }, optShow: { ...B }, crudApi: { ...le } }, L);
  G("permission", P);
  const { maxHeight: R } = re({ paginate: true });
  H.HOOK.handleRefresh = (p, l) => {
    l.data.content = l.data.content.map((t) => {
      var b, m, f, v, x, M;
      return t.completeRatio = ((b = t.totalMete) == null ? void 0 : b.netWeight) && ((m = t.totalCompleteMete) == null ? void 0 : m.netWeight) && (((f = t.totalCompleteMete) == null ? void 0 : f.netWeight) / ((v = t.totalMete) == null ? void 0 : v.netWeight) * 100).toFixed(2) || 0, t.monomerName = (x = t.monomer) == null ? void 0 : x.name, t.areaName = (M = t.area) == null ? void 0 : M.name, t;
    });
  };
  const N = C({}), S = C([]), I = C(false);
  function $(p) {
    N.value = Object.assign({}, p), U(p == null ? void 0 : p.id);
  }
  async function U(p) {
    if (S.value = [], !!p) try {
      I.value = true;
      const { content: l } = await se({ topTaskOrderId: p });
      console.log(l), S.value = l.map((t) => {
        var b;
        return console.log(t.processList), (b = t.processList) == null || b.forEach((m) => {
          var f, v, x, M;
          m.completeRatio = ((f = m.totalTaskMete) == null ? void 0 : f.netWeight) && ((v = m.totalCompleteMete) == null ? void 0 : v.netWeight) && (((x = m.totalCompleteMete) == null ? void 0 : x.netWeight) / ((M = m.totalTaskMete) == null ? void 0 : M.netWeight) * 100).toFixed(2) || 0;
        }), t;
      });
    } catch (l) {
      console.log("获取子工单失败", l);
    } finally {
      I.value = false;
    }
  }
  const V = C(false), j = C({});
  function Q(p, l) {
    var t;
    j.value = Object.assign(p, l, { topTaskOrderId: (t = N.value) == null ? void 0 : t.id }), V.value = true;
  }
  return (p, l) => {
    var D;
    const t = Z, b = K("common-table"), m = ee, f = te, v = oe, x = K("common-button"), M = ae;
    return i(), A("div", de, [g("div", me, [g("div", ge, [n(o(ue))]), J((i(), h(b, { ref_key: "tableRef", ref: L, data: o(y).data, "empty-text": o(y).emptyText, "max-height": o(R), "data-format": z.value, style: { width: "100%" }, "highlight-current-row": "", onCurrentChange: $ }, { default: r(() => [n(t, { label: "序号", type: "index", align: "center", width: "60" }), o(k).visible("orderNumber") ? (i(), h(t, { key: 0, align: "center", prop: "orderNumber", "show-overflow-tooltip": true, label: "排产工单号", "min-width": "130px" })) : w("", true), o(k).visible("project") ? (i(), h(t, { key: 1, prop: "project", "show-overflow-tooltip": true, label: "所属项目", "min-width": "160px" })) : w("", true), o(k).visible("monomerName") ? (i(), h(t, { key: 2, prop: "monomerName", "show-overflow-tooltip": true, label: "单体", "min-width": "100px" })) : w("", true), o(k).visible("areaName") ? (i(), h(t, { key: 3, prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px" })) : w("", true), o(k).visible("askCompleteTime") ? (i(), h(t, { key: 4, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : w("", true), o(k).visible("totalMete.quantity") ? (i(), h(t, { key: 5, align: "center", prop: "totalMete.quantity", "show-overflow-tooltip": true, label: "任务量（件/kg）", width: "135px" }, { default: r(({ row: e }) => {
      var a, s, u, c, d, T;
      return [g("span", null, _(o(y).query.weightStatus === o(E).NET.V ? ((a = e.totalMete) == null ? void 0 : a.quantity) + "/" + ((s = e.totalMete) == null ? void 0 : s.netWeight) : (u = e.totalMete) != null && u.grossWeight ? ((c = e.totalMete) == null ? void 0 : c.quantity) + "/" + ((d = e.totalMete) == null ? void 0 : d.grossWeight) : ((T = e.totalMete) == null ? void 0 : T.quantity) + "/-"), 1)];
    }), _: 1 })) : w("", true), o(k).visible("totalCompleteMete.quantity") ? (i(), h(t, { key: 6, align: "center", prop: "totalCompleteMete.quantity", "show-overflow-tooltip": true, label: "实际完成（件/kg）", width: "135px" }, { default: r(({ row: e }) => {
      var a, s, u, c, d, T;
      return [g("span", null, _(o(y).query.weightStatus === o(E).NET.V ? ((a = e.totalCompleteMete) == null ? void 0 : a.quantity) + "/" + ((s = e.totalCompleteMete) == null ? void 0 : s.netWeight) : (u = e.totalMete) != null && u.grossWeight ? ((c = e.totalCompleteMete) == null ? void 0 : c.quantity) + "/" + ((d = e.totalCompleteMete) == null ? void 0 : d.grossWeight) : ((T = e.totalCompleteMete) == null ? void 0 : T.quantity) + "/-"), 1)];
    }), _: 1 })) : w("", true), o(k).visible("completeRatio") ? (i(), h(t, { key: 7, align: "center", prop: "completeRatio", "show-overflow-tooltip": true, label: "完成率", width: "90px" }, { default: r(({ row: e }) => [g("span", null, _(e.completeRatio) + "%", 1)]), _: 1 })) : w("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[M, o(y).loading]]), n(o(pe))]), n(m, { direction: "vertical", style: O(`height: ${o(R) + 90}px`) }, null, 8, ["style"]), g("div", { class: "wrap-right", style: O(`height: ${o(R) + 90}px;overflow: auto;`) }, [(D = N.value) != null && D.id ? (i(true), A(X, { key: 1 }, Y(S.value, (e) => (i(), A("div", { key: e.id, style: { "margin-bottom": "10px" } }, [g("div", he, [n(f, { effect: "dark", type: F[o(q).VK[e == null ? void 0 : e.taskTypeEnum]] }, { default: r(() => [W(_(o(q).VL[e == null ? void 0 : e.taskTypeEnum]), 1)]), _: 2 }, 1032, ["type"]), n(f, { style: { "margin-left": "8px" }, effect: "plain" }, { default: r(() => {
      var a, s;
      return [W(_((a = e == null ? void 0 : e.workshop) == null ? void 0 : a.name) + ">" + _((s = e == null ? void 0 : e.productionLine) == null ? void 0 : s.name), 1)];
    }), _: 2 }, 1024), g("span", fe, "工单号：" + _(e == null ? void 0 : e.orderNumber), 1)]), n(b, { data: e.processList, "empty-text": "暂无数据", style: { width: "100%", cursor: "pointer" } }, { default: r(() => [n(t, { align: "center", prop: "process.name", "show-overflow-tooltip": true, label: "工序" }), n(t, { align: "center", key: "completeRatio", prop: "completeRatio", "show-overflow-tooltip": true, label: "进度", width: "160px" }, { default: r(({ row: a }) => [n(v, { "text-inside": true, "stroke-linecap": "square", "stroke-width": 22, percentage: Number(a.completeRatio), status: "success" }, null, 8, ["percentage"])]), _: 1 }), n(t, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务（件/kg）", width: "120px" }, { default: r(({ row: a }) => {
      var s, u, c, d;
      return [g("span", null, _(o(y).query.weightStatus === o(E).NET.V ? ((s = a.totalTaskMete) == null ? void 0 : s.quantity) + "/" + ((u = a.totalTaskMete) == null ? void 0 : u.netWeight) : ((c = a.totalTaskMete) == null ? void 0 : c.quantity) + "/" + ((d = a.totalTaskMete) == null ? void 0 : d.grossWeight)), 1)];
    }), _: 1 }), n(t, { align: "center", prop: "totalCompleteMete.quantity", "show-overflow-tooltip": true, label: "完成（件/kg）", width: "120px" }, { default: r(({ row: a }) => {
      var s, u, c, d;
      return [g("span", null, _(o(y).query.weightStatus === o(E).NET.V ? ((s = a.totalCompleteMete) == null ? void 0 : s.quantity) + "/" + ((u = a.totalCompleteMete) == null ? void 0 : u.netWeight) : ((c = a.totalCompleteMete) == null ? void 0 : c.quantity) + "/" + ((d = a.totalCompleteMete) == null ? void 0 : d.grossWeight)), 1)];
    }), _: 1 }), n(t, { label: "操作", width: "120px", align: "center", fixed: "right" }, { default: r(({ row: a }) => [n(x, { size: "default", type: "primary", onClick: (s) => Q(a, e) }, { default: r(() => l[2] || (l[2] = [W("班组协同")])), _: 2, __: [2] }, 1032, ["onClick"])]), _: 2 }, 1024)]), _: 2 }, 1032, ["data"])]))), 128)) : (i(), h(f, { key: 0, type: "info", size: "large" }, { default: r(() => l[1] || (l[1] = [W(" * 请先选择排产工单，进行班组协同 ")])), _: 1, __: [1] }))], 4), n(ce, { visible: V.value, "onUpdate:visible": l[0] || (l[0] = (e) => V.value = e), info: j.value, currentInfo: N.value, onSuccess: o(y).toQuery }, null, 8, ["visible", "info", "currentInfo", "onSuccess"])]);
  };
} }, Se = ne(_e, [["__scopeId", "data-v-fe50679a"]]);
export {
  Se as default
};
