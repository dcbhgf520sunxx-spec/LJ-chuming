import { ref as f } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as s } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as T } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElTableColumn as F } from "element-plus";
import { ElTag as K } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as W } from "../../../../modules/common-b3e76e54.js";
import { c as X, p as Y } from "../../../../modules/artifact-aa863eec.js";
import { x as Z, ne as y, o as ee, a3 as x, n9 as u, G as te, nf as _, P as ae, V as le } from "../../../../shared/runtime.js";
import { _ as ie } from "../../../../modules/index-3b2628f3.js";
import oe from "./module/header.vue.js";
import ne from "./module/production-handle-drawer.vue.js";
import se from "./module/schedule-handle-drawer.vue.js";
import re from "./module/schedule-detail-preview-drawer.vue.js";
import ue from "./module/schedule-detail-drawer.vue.js";
import pe from "./module/production-detail-preview-drawer.vue.js";
import de from "./module/production-detail-drawer.vue.js";
import "./components/handle-operation.vue.js";
import "./module/production-preview.vue.js";
import "../../../../modules/index-490fd9d7.js";
import "./components/item-detail-info.vue.js";
import "../../../../modules/mes-ee117a22.js";
import "../../../../modules/index-c83b228b.js";
import "../../../../modules/index-897a9ea4.js";
import "./module/schedule-preview.vue.js";
const me = { class: "app-container" }, ce = { class: "head-container" }, fe = { key: 0 }, be = { key: 1 }, ve = { key: 2 }, Qe = { __name: "index", setup(ye) {
  const L = { add: false, edit: false, del: false, download: false }, M = f([["createTime", "parse-time"]]), H = f(), { crud: b, columns: p, CRUD: Q } = Z({ title: "变更管理", permission: { ...y }, sort: [], invisibleColumns: [], optShow: { ...L }, crudApi: { ...W } }, H), { maxHeight: O } = ee({ paginate: true }), h = f(false), C = f(false), N = f(false), g = f(false), V = f(false), S = f(false), v = f({});
  Q.HOOK.handleRefresh = (o, a) => {
    a.data.content = a.data.content.map((l) => (l.changTypeText = l.changeType, l.handleType = l.type, l));
  };
  function G(o) {
    if (o.status === u.PENDING.V) R.confirm("处理异常前请通知车间将相关构件进行异常上报后再进行异常处理！", "提示", { confirmButtonText: "仍要处理", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        const a = await X(o.id);
        o.handleType = a, o.status = u.PROCESSING.V;
        const l = a & _.SCHEDULE_CHANGE.V ? C : h;
        P(l, o);
      } catch (a) {
        console.log("仍要处理", a);
      }
    });
    else {
      const a = o.handleType & _.SCHEDULE_CHANGE.V ? C : h;
      P(a, o);
    }
  }
  function U(o) {
    R.confirm("是否确认处理", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await Y(o.id), b.refresh();
      } catch (a) {
        console.log("零件处理", a);
      }
    });
  }
  function B(o) {
    const a = o.handleType & _.SCHEDULE_CHANGE.V ? o.status & u.PROCESSING_COMPLETE.V ? N : g : o.status & u.PROCESSING_COMPLETE.V ? V : S;
    P(a, o);
  }
  function P(o, a) {
    v.value = le(a), o.value = true;
  }
  return (o, a) => {
    const l = F, $ = K, k = I("common-button"), q = I("common-table"), D = j("permission"), z = J;
    return i(), E("div", me, [d("div", ce, [m(e(oe))]), w((i(), s(q, { ref_key: "tableRef", ref: H, data: e(b).data, "data-format": M.value, "empty-text": e(b).emptyText, "max-height": e(O), "row-key": "id", style: { width: "100%" } }, { default: n(() => [m(l, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("createTime") ? (i(), s(l, { key: 0, prop: "createTime", "show-overflow-tooltip": true, label: "变更时间", width: "130", align: "center" }, { default: n(({ row: t }) => [d("span", null, c(t.createTime), 1)]), _: 1 })) : r("", true), e(p).visible("userName") ? (i(), s(l, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "变更人" }, { default: n(({ row: t }) => [d("span", null, c(t.userName), 1)]), _: 1 })) : r("", true), e(p).visible("changTypeText") ? (i(), s(l, { key: 2, prop: "changTypeText", "show-overflow-tooltip": true, label: "变更原因", align: "center" }, { default: n(({ row: t }) => [d("span", null, c(t.changTypeText), 1)]), _: 1 })) : r("", true), m(e(ie), { columns: e(p), showProject: "", showMonomer: "", showArea: "" }, null, 8, ["columns"]), e(p).visible("artifactSerialNumber") && e(b).query.productType & (e(x).MACHINE_PART.V | e(x).ASSEMBLE.V) ? (i(), s(l, { key: "artifactSerialNumber", prop: "artifactSerialNumber", "show-overflow-tooltip": true, label: "构件编号", "min-width": "110" }, { default: n(({ row: t }) => [d("span", null, c(t.artifactSerialNumber), 1)]), _: 1 })) : r("", true), e(p).visible("assembleSerialNumber") && e(b).query.productType & e(x).MACHINE_PART.V ? (i(), s(l, { key: "assembleSerialNumber", prop: "assembleSerialNumber", "show-overflow-tooltip": true, label: "部件编号", "min-width": "110" }, { default: n(({ row: t }) => [d("span", null, c(t.assembleSerialNumber), 1)]), _: 1 })) : r("", true), e(p).visible("serialNumber") ? (i(), s(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "110" }, { default: n(({ row: t }) => [d("span", null, c(t.serialNumber), 1)]), _: 1 })) : r("", true), e(p).visible("oldQuantity") ? (i(), s(l, { key: "oldQuantity", prop: "oldQuantity", "show-overflow-tooltip": true, label: "原清单数量", width: "100", align: "center" }, { default: n(({ row: t }) => [d("span", null, c(t.oldQuantity), 1)]), _: 1 })) : r("", true), e(p).visible("newQuantity") ? (i(), s(l, { key: "newQuantity", prop: "newQuantity", "show-overflow-tooltip": true, label: "变更后清单数量", width: "110", align: "center" }, { default: n(({ row: t }) => [d("span", null, c(t.newQuantity), 1)]), _: 1 })) : r("", true), e(p).visible("totalInProductionQuantity") ? (i(), s(l, { key: "totalInProductionQuantity", prop: "totalInProductionQuantity", "show-overflow-tooltip": true, label: "进入生产数量", width: "100", align: "center" }, { default: n(({ row: t }) => [d("span", null, c(t.totalInProductionQuantity), 1)]), _: 1 })) : r("", true), e(p).visible("status") ? (i(), s(l, { key: 9, "show-overflow-tooltip": true, prop: "status", label: "状态", align: "center", width: "90" }, { default: n(({ row: t }) => [m($, { type: e(u).V[t.status].TAG }, { default: n(() => [T(c(e(u).VL[t.status]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(te)([...e(y).save, ...e(y).detail]) ? (i(), s(l, { key: 10, label: "操作", width: "160px", align: "center", fixed: "right" }, { default: n(({ row: t }) => [t.type & e(_).MACHINE_PART.V && !(t.status & (e(u).PROCESSING_COMPLETE.V | e(u).CANCEL.V)) ? (i(), E("span", fe, [w((i(), s(k, { size: "default", type: "primary", onClick: (A) => U(t) }, { default: n(() => a[6] || (a[6] = [T(" 处理 ")])), _: 2, __: [6] }, 1032, ["onClick"])), [[D, [...e(y).save]]])])) : r("", true), t.type & e(_).MACHINE_PART.V && t.status & (e(u).PROCESSING_COMPLETE.V | e(u).CANCEL.V) ? (i(), E("span", be, a[7] || (a[7] = [d("span", null, "-", -1)]))) : r("", true), t.type & e(_).MACHINE_PART.V ? r("", true) : (i(), E("span", ve, [t.status & (e(u).PROCESSING_COMPLETE.V | e(u).CANCEL.V) ? r("", true) : w((i(), s(k, { key: 0, size: "default", type: "primary", onClick: (A) => G(t) }, { default: n(() => a[8] || (a[8] = [T(" 处理 ")])), _: 2, __: [8] }, 1032, ["onClick"])), [[D, [...e(y).save]]]), w((i(), s(k, { size: "default", type: "info", onClick: (A) => B(t) }, { default: n(() => a[9] || (a[9] = [T("查看")])), _: 2, __: [9] }, 1032, ["onClick"])), [[D, [...e(y).detail]]])]))]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[z, e(b).loading]]), m(e(ae)), m(se, { visible: C.value, "onUpdate:visible": a[0] || (a[0] = (t) => C.value = t), info: v.value, onSuccess: e(b).toQuery }, null, 8, ["visible", "info", "onSuccess"]), m(ue, { visible: N.value, "onUpdate:visible": a[1] || (a[1] = (t) => N.value = t), info: v.value }, null, 8, ["visible", "info"]), m(re, { visible: g.value, "onUpdate:visible": a[2] || (a[2] = (t) => g.value = t), info: v.value }, null, 8, ["visible", "info"]), m(ne, { visible: h.value, "onUpdate:visible": a[3] || (a[3] = (t) => h.value = t), info: v.value, onSuccess: e(b).toQuery }, null, 8, ["visible", "info", "onSuccess"]), m(e(de), { visible: V.value, "onUpdate:visible": a[4] || (a[4] = (t) => V.value = t), info: v.value }, null, 8, ["visible", "info"]), m(e(pe), { visible: S.value, "onUpdate:visible": a[5] || (a[5] = (t) => S.value = t), info: v.value }, null, 8, ["visible", "info"])]);
  };
} };
export {
  Qe as default
};
