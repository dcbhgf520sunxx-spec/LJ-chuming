import { ref as F } from "vue";
import { inject as O } from "vue";
import { computed as X } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as b } from "vue";
import { createBlock as D } from "vue";
import { withCtx as o } from "vue";
import { unref as a } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as N } from "vue";
import { withDirectives as Y } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as i } from "vue";
import { isRef as Z } from "vue";
import { ElTag as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { l as V, u as ae, o as le, p as $, G as re, L as se, a3 as _ } from "../../../../../shared/runtime.js";
function ie(s) {
  return V({ module: "mes", url: "outputReport/teamOutputStatisticsReport", method: "get", params: s });
}
function ne(s) {
  return V({ module: "mes", url: "outputReport/teamOutputStatisticsDetailsReport", method: "get", params: s });
}
function pe(s) {
  return V({ module: "mes", url: "outputReport/teamOutputStatisticsDetailsReportDownload", method: "get", responseType: "blob", params: s });
}
const me = { get: ie }, ue = { __name: "detail", props: { visible: { type: Boolean, default: false }, rowDetail: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(s, { emit: U }) {
  const q = U, l = s, v = F(false), T = F([]), u = O("query"), E = O("permission"), { visible: I, handleClose: M } = ae({ emit: q, props: l, field: "visible", showHook: K }), { maxHeight: P } = le({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }), z = X(() => {
    var y, p, w, t, f, h, g, c;
    return { processId: (y = l.rowDetail) == null ? void 0 : y.processId, workshopId: (p = l.rowDetail) == null ? void 0 : p.workshopId, teamId: (w = l.rowDetail) == null ? void 0 : w.teamId, productionLineId: (t = l.rowDetail) == null ? void 0 : t.productionLineId, processType: (f = l.rowDetail) == null ? void 0 : f.productType, startDate: u.startDate, endDate: u.endDate, processName: (h = l.rowDetail) == null ? void 0 : h.processName, teamName: (g = l.rowDetail) == null ? void 0 : g.teamName, workshopName: (c = l.rowDetail) == null ? void 0 : c.workshopName };
  });
  async function J() {
    var p, w, t, f, h, g, c, k;
    v.value = true;
    let y = [];
    try {
      const d = { processId: (p = l.rowDetail) == null ? void 0 : p.processId, workshopId: (w = l.rowDetail) == null ? void 0 : w.workshopId, teamId: (t = l.rowDetail) == null ? void 0 : t.teamId, productionLineId: (f = l.rowDetail) == null ? void 0 : f.productionLineId, processType: (h = l.rowDetail) == null ? void 0 : h.productType, startDate: u.startDate, endDate: u.endDate, processName: (g = l.rowDetail) == null ? void 0 : g.processName, teamName: (c = l.rowDetail) == null ? void 0 : c.teamName, workshopName: (k = l.rowDetail) == null ? void 0 : k.workshopName };
      y = await ne(d);
    } catch (d) {
      console.log(d);
    } finally {
      T.value = y, v.value = false;
    }
  }
  function K() {
    J();
  }
  return (y, p) => {
    var c, k;
    const w = ee, t = te, f = Q("common-table"), h = Q("common-drawer"), g = oe;
    return b(), D(h, { ref: "drawerRef", title: (c = s.rowDetail) != null && c.processName ? `【${(k = s.rowDetail) == null ? void 0 : k.processName}】工序` : "工序", modelValue: a(I), "onUpdate:modelValue": p[0] || (p[0] = (d) => Z(I) ? I.value = d : null), direction: "rtl", "close-on-click-modal": false, "before-close": a(M), size: "100%" }, { titleAfter: o(() => [a(u).startDate && a(u).endDate ? (b(), D(w, { key: 0, type: "primary" }, { default: o(() => [S(r(a($)(a(u).startDate, "{y}-{m}-{d}")) + " - " + r(a($)(a(u).endDate, "{y}-{m}-{d}")), 1)]), _: 1 })) : N("", true)]), titleRight: o(() => [a(re)(a(E).export) ? (b(), D(a(se), { key: 0, disabled: !T.value.length, fn: a(pe), params: z.value }, { default: o(() => p[1] || (p[1] = [S(" 班组排产详情下载 ")])), _: 1, __: [1] }, 8, ["disabled", "fn", "params"])) : N("", true)]), content: o(() => [Y((b(), D(f, { ref: "tableRef", data: T.value, "show-empty-symbol": false, "max-height": a(P), style: { width: "100%" } }, { default: o(() => {
      var d, x, R, L, C, W, j, G, H, A, B;
      return [n(t, { label: "序号", type: "index", align: "center", width: "60" }), n(t, { label: "上报人", prop: "reportUserName", key: "reportUserName", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.reportUserName || "-"), 1)]), _: 1 }), n(t, { label: "项目名称", prop: "projectName", key: "projectName", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.projectName || "-"), 1)]), _: 1 }), +((d = s.rowDetail) == null ? void 0 : d.productType) === a(_).ARTIFACT.V ? (b(), D(t, { label: "清单号(批次)", prop: "batchName", key: "batchName", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.batchName || "-"), 1)]), _: 1 })) : N("", true), +((x = s.rowDetail) == null ? void 0 : x.productType) === a(_).ARTIFACT.V ? (b(), D(t, { label: `${(C = (L = a(_).V) == null ? void 0 : L[(R = s.rowDetail) == null ? void 0 : R.productType]) == null ? void 0 : C.L}类别`, prop: "structureType", key: "structureType", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.structureType || "-"), 1)]), _: 1 }, 8, ["label"])) : N("", true), n(t, { label: `${(G = (j = a(_).V) == null ? void 0 : j[(W = s.rowDetail) == null ? void 0 : W.productType]) == null ? void 0 : G.L}名称`, prop: "artifactName", key: "artifactName", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.artifactName || "-"), 1)]), _: 1 }, 8, ["label"]), n(t, { label: `${(B = (A = a(_).V) == null ? void 0 : A[(H = s.rowDetail) == null ? void 0 : H.productType]) == null ? void 0 : B.L}编号`, prop: "serialNumber", key: "serialNumber", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.serialNumber || "-"), 1)]), _: 1 }, 8, ["label"]), n(t, { label: "规格", prop: "specification", key: "specification", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.specification || "-"), 1)]), _: 1 }), n(t, { label: "长度", prop: "length", key: "length", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.length ?? "-"), 1)]), _: 1 }), n(t, { label: "单毛重(kg)", prop: "grossWeight", key: "grossWeight", align: "center", "show-overflow-tooltip": true }, { default: o((e) => {
        var m;
        return [i("span", null, r(((m = e.row.grossWeight) == null ? void 0 : m.toFixed(3)) || "-"), 1)];
      }), _: 1 }), n(t, { label: "任务数量", prop: "taskQuantity", key: "taskQuantity", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.taskQuantity ?? "-"), 1)]), _: 1 }), n(t, { label: "任务总毛重(kg)", prop: "totalTaskGrossWeight", key: "totalTaskGrossWeight", align: "center", "show-overflow-tooltip": true }, { default: o((e) => {
        var m;
        return [i("span", null, r(((m = e.row.totalTaskGrossWeight) == null ? void 0 : m.toFixed(3)) || "-"), 1)];
      }), _: 1 }), n(t, { label: "完成数量", prop: "completeQuantity", key: "completeQuantity", align: "center", "show-overflow-tooltip": true }, { default: o((e) => [i("span", null, r(e.row.completeQuantity ?? "-"), 1)]), _: 1 }), n(t, { label: "完成重量(kg)", prop: "totalCompleteGrossWeight", key: "totalCompleteGrossWeight", align: "center", "show-overflow-tooltip": true }, { default: o((e) => {
        var m;
        return [i("span", null, r(((m = e.row.totalCompleteGrossWeight) == null ? void 0 : m.toFixed(3)) || "-"), 1)];
      }), _: 1 })];
    }), _: 1 }, 8, ["data", "max-height"])), [[g, v.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, we = Object.freeze(Object.defineProperty({ __proto__: null, default: ue }, Symbol.toStringTag, { value: "Module" }));
export {
  ue as _,
  me as c,
  we as d
};
