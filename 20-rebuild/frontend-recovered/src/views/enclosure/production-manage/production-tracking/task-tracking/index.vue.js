import { ref as g } from "vue";
import { resolveComponent as S } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as _ } from "vue";
import { Fragment as M } from "vue";
import { withDirectives as w } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as m } from "vue";
import { nextTick as O } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElProgress as B } from "element-plus";
import { vLoading as U } from "element-plus";
import { c as V, _ as A } from "./project-list/index.vue.js";
import { f as k } from "../../../../../modules/enclosure-365a2177.js";
import { _ as F, D as x, kA as H, x as I, o as $, bs as G, G as K, an as J, P as W } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "./project-list/module/header.vue.js";
const Z = { class: "wrap" }, ee = { class: "wrap-left" }, te = { class: "wrap-right" }, ae = { class: "app-container" }, oe = { __name: "index", setup(le) {
  const N = { add: false, edit: false, del: false, download: false }, y = g(), f = g({}), L = g([["totalLength", ["to-fixed", x.MES_ENCLOSURE_L__M]], ["completeLength", ["to-fixed", x.MES_ENCLOSURE_L__M]], ["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["category", ["parse-enum", H]]]), { CRUD: C, crud: u, columns: s } = I({ title: "任务跟踪", sort: [], permission: { ...k }, optShow: { ...N }, crudApi: { ...V }, requiredQuery: ["projectId"], invisibleColumns: ["factoryName"], queryOnPresenterCreated: false }, y), { maxHeight: T } = $({ extraBox: ".task-head-container", paginate: true });
  function E(h = {}) {
    f.value = h, O(() => {
      u.query.projectId = h.id, u.toQuery();
    });
  }
  return C.HOOK.handleRefresh = async (h, { data: c }) => {
    c.content.forEach((n) => {
      n.completeRate = Number(G(n.completeLength / n.totalLength * 100, 2)), n.totalLength = (n.totalLength || 0) / 1e3, n.completeLength = (n.completeLength || 0) / 1e3;
    });
  }, (h, c) => {
    const n = Q, l = z, R = B, j = S("common-table"), q = b("empty-text"), D = b("parse-project"), P = U;
    return t(), v("div", Z, [d("div", ee, [p(e(A), { onProjectChange: E })]), d("div", te, [d("div", ae, [f.value.id ? (t(), v(M, { key: 1 }, [p(e(X), { class: "head-container task-head-container" }, { viewLeft: i(() => [p(n, { effect: "plain", size: "large" }, { default: i(() => [w(d("span", null, null, 512), [[q], [D, { project: f.value }]])]), _: 1 })]), _: 1 }), w((t(), a(j, { ref_key: "tableRef", ref: y, data: e(u).data, "data-format": L.value, "empty-text": e(u).emptyText, "max-height": e(T) }, { default: i(() => [p(l, { align: "center", label: "序号", type: "index", width: "55" }), e(s).visible("createTime") ? (t(), a(l, { key: "createTime", align: "center", label: "排产日期", prop: "createTime", "show-overflow-tooltip": "", width: "90" })) : r("", true), e(s).visible("orderNumber") ? (t(), a(l, { key: "orderNumber", align: "center", label: "任务工单", "min-width": "150", prop: "orderNumber", "show-overflow-tooltip": "" })) : r("", true), e(s).visible("userName") ? (t(), a(l, { key: "userName", align: "center", label: "排产人", prop: "userName", "show-overflow-tooltip": "", width: "90" })) : r("", true), e(s).visible("dictionaryName") ? (t(), a(l, { key: "dictionaryName", align: "center", label: "类型", prop: "dictionaryName", "show-overflow-tooltip": "", width: "110" }, { default: i(({ row: o }) => [p(n, { effect: "plain", size: "large" }, { default: i(() => [_(m(o.dictionaryName), 1)]), _: 2 }, 1024)]), _: 1 })) : r("", true), e(s).visible("factoryName") ? (t(), a(l, { key: "factoryName", align: "center", label: "工厂", "min-width": "130", prop: "factoryName", "show-overflow-tooltip": "" })) : r("", true), e(s).visible("workshopName") ? (t(), a(l, { key: "workshopName", align: "center", label: "车间", "min-width": "130", prop: "workshopName", "show-overflow-tooltip": "" })) : r("", true), e(s).visible("productionLineName") ? (t(), a(l, { key: "productionLineName", align: "center", label: "生产线", "min-width": "130", prop: "productionLineName", "show-overflow-tooltip": "" }, { default: i(({ row: o }) => [_(m(o.productionLineName) + " / " + m(o.leaderName), 1)]), _: 1 })) : r("", true), e(s).visible("quantity") ? (t(), a(l, { key: "quantity", align: "center", label: "任务数(件/m)", "min-width": "100", prop: "quantity", "show-overflow-tooltip": "" }, { default: i(({ row: o }) => [d("span", null, m(o.quantity) + " / " + m(o.totalLength), 1)]), _: 1 })) : r("", true), e(s).visible("completeQuantity") ? (t(), a(l, { key: "completeQuantity", align: "center", label: "完成数(件/m)", "min-width": "100", prop: "completeQuantity", "show-overflow-tooltip": "" }, { default: i(({ row: o }) => [d("span", null, m(o.completeQuantity) + " / " + m(o.completeLength), 1)]), _: 1 })) : r("", true), e(s).visible("askCompleteTime") ? (t(), a(l, { key: "askCompleteTime", align: "center", label: "要求完成时间", prop: "askCompleteTime", "show-overflow-tooltip": "", width: "95" })) : r("", true), e(s).visible("booleanlag") ? (t(), a(l, { key: "booleanlag", align: "center", label: "状态", prop: "booleanlag", "show-overflow-tooltip": "", width: "70" }, { default: i(({ row: o }) => [o.booleanlag ? (t(), a(n, { key: 0, effect: "plain", size: "large", type: "success" }, { default: i(() => c[1] || (c[1] = [_("正常")])), _: 1, __: [1] })) : (t(), a(n, { key: 1, effect: "plain", size: "large", type: "danger" }, { default: i(() => c[2] || (c[2] = [_("滞后")])), _: 1, __: [2] }))]), _: 1 })) : r("", true), e(s).visible("completeRate") ? (t(), a(l, { key: "completeRate", align: "center", label: "进度", "min-width": "90", prop: "completeRate", "show-overflow-tooltip": "" }, { default: i(({ row: o }) => [p(R, { percentage: o.completeRate, "stroke-width": 29, "text-inside": true }, null, 8, ["percentage"])]), _: 1 })) : r("", true), e(K)([...e(k).detail]) ? (t(), a(l, { key: 12, align: "center", fixed: "right", label: "操作", width: "70px" }, { default: i(({ row: o }) => [p(e(J), { data: o, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[P, e(u).loading]]), p(e(W)), p(e(Y), { project: f.value }, null, 8, ["project"])], 64)) : (t(), a(n, { key: 0, effect: "plain", size: "large", type: "info" }, { default: i(() => c[0] || (c[0] = [_(" * 请点击左侧项目列表查看详情")])), _: 1, __: [0] }))])])]);
  };
} }, ue = F(oe, [["__scopeId", "data-v-567a632b"]]);
export {
  ue as default
};
