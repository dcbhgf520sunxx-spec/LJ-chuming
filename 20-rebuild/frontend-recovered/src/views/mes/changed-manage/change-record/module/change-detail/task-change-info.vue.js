import { ref as z } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as a } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createVNode as o } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as F } from "vue";
import { createElementBlock as i } from "vue";
import { Fragment as w } from "vue";
import { ElTableColumn as J } from "element-plus";
import { ElTag as K } from "element-plus";
import { inject as U } from "vue";
import { computed as X } from "vue";
import { watch as Y } from "vue";
import { nextTick as Z } from "vue";
import { createElementVNode as g } from "vue";
import { renderList as M } from "vue";
import { toDisplayString as R } from "vue";
import { unref as ee } from "vue";
import { mergeProps as te } from "vue";
import { normalizeStyle as oe } from "vue";
import { ElDivider as ae } from "element-plus";
import { ElCard as le } from "element-plus";
import { b as ne } from "../../../../../../modules/common-ac6e385c.js";
import { a as re } from "../../../../../../modules/anchor-nav-b01bf51a.js";
import { _ as se } from "../../../../../../shared/runtime.js";
const ie = { __name: "task-change-table", props: { compareList: { type: Array, default: () => [] }, typeTitle: { type: String, default: "构件" }, showOrderNumber: { type: Boolean, default: false }, showStatus: { type: Boolean, default: false }, unShowNew: { type: Boolean, default: false }, showChange: { type: Boolean, default: false }, showHandleType: { type: Boolean, default: false }, showProductionQty: { type: Boolean, default: false }, showHandleQty: { type: Boolean, default: false }, showShippedQty: { type: Boolean, default: false } }, setup(f) {
  const l = f, t = z([["handleType", ["parse-enum", ne, { bit: true, split: " 、 " }]]]);
  return (b, n) => {
    const e = J, h = K, c = G("common-table");
    return a(), p(c, { "header-cell-style": { background: "#fff", "font-weight": "bold", color: "#333333" }, data: f.compareList, "data-format": t.value, style: { width: "100%" } }, { default: s(() => [o(e, { label: "序号", type: "index", align: "center", width: "60" }), l.showOrderNumber ? (a(), p(e, { key: 0, label: "排产工单", prop: "orderNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" })) : r("", true), o(e, { label: "区域", prop: "area.name", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), o(e, { label: `原${l.typeTitle}信息`, align: "center" }, { default: s(() => [o(e, { label: "编号", prop: "oldSerialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), o(e, { label: "规格", prop: "oldSpecification", "show-overflow-tooltip": "", align: "center", "min-width": "120" }), o(e, { label: "材质", prop: "oldMaterial", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), o(e, { label: "长度(mm)", prop: "oldLength", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l.showStatus ? (a(), p(e, { key: 0, label: "状态", align: "center", width: "80" }, { default: s(() => [o(h, { type: "danger", effect: "plain" }, { default: s(() => n[0] || (n[0] = [F("删除")])), _: 1, __: [0] })]), _: 1 })) : r("", true), o(e, { label: "数量", prop: "oldQuantity", "show-overflow-tooltip": "", align: "center", width: "90" })]), _: 1 }, 8, ["label"]), l.unShowNew ? r("", true) : (a(), p(e, { key: 1, label: `变更${l.typeTitle}信息`, align: "center" }, { default: s(() => [o(e, { label: "编号", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), o(e, { label: "长度(mm)", prop: "length", "show-overflow-tooltip": "", align: "center", "min-width": "100" }), l.showStatus ? (a(), p(e, { key: 0, label: "状态", align: "center", width: "80" }, { default: s(() => [o(h, { type: "success", effect: "plain" }, { default: s(() => n[1] || (n[1] = [F("新增")])), _: 1, __: [1] })]), _: 1 })) : r("", true), o(e, { label: "数量", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "90" })]), _: 1 }, 8, ["label"])), l.showChange ? (a(), i(w, { key: 2 }, [o(e, { label: "部件变更", prop: "a", "show-overflow-tooltip": "", align: "center", width: "90" }), o(e, { label: "零件变更", prop: "p", "show-overflow-tooltip": "", align: "center", width: "90" })], 64)) : r("", true), l.showHandleType ? (a(), p(e, { key: 3, label: "处理方案", prop: "handleType", "show-overflow-tooltip": "", align: "center", "min-width": "100" })) : r("", true), l.showProductionQty ? (a(), i(w, { key: 4 }, [o(e, { label: "未生产", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "90" }), o(e, { label: "生产中", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "90" })], 64)) : r("", true), l.showShippedQty ? (a(), p(e, { key: 5, label: "已发运数量", prop: "cargoListQuantity", "show-overflow-tooltip": "", align: "center", width: "90" })) : r("", true), l.showHandleQty ? (a(), p(e, { key: 6, label: "处理数量", prop: "quantity", "show-overflow-tooltip": "", align: "center", width: "90" })) : r("", true)]), _: 1 }, 8, ["data", "data-format"]);
  };
} };
const pe = { class: "left-con anchor-container" }, he = { key: 0, class: "type-content" }, ce = { class: "title", style: { padding: "5px 50px" } }, ue = { key: 0, class: "box-content" }, de = ["data-anchor-label"], we = { __name: "task-change-info", props: { heightStyle: { type: String } }, setup(f) {
  const l = z(), t = U("taskInfo"), b = X(() => {
    var n, e, h, c, d, m, u, y, _, v, k, L, B, S, T, N, O, A, Q, C, P, x, H, E, I, W, q, D, V, $, j;
    return [{ title: "构件", show: !!((e = (n = t.value) == null ? void 0 : n.artifactList) != null && e.length || (c = (h = t.value) == null ? void 0 : h.taskOrderArtifactList) != null && c.length || (m = (d = t.value) == null ? void 0 : d.taskOrderPointWorkArtifactList) != null && m.length), cons: [{ title: "# 构件排产变更（任务未下发）", anchorLabel: "构件排产变更", show: !!((y = (u = t.value) == null ? void 0 : u.artifactList) != null && y.length), props: { compareList: ((_ = t.value) == null ? void 0 : _.artifactList) || [], typeTitle: "构件", showStatus: true } }, { title: "# 构件任务变更（【传统线】“任务已下发”且“未生产完成”的构件）", anchorLabel: "构件任务变更", show: !!((k = (v = t.value) == null ? void 0 : v.taskOrderArtifactList) != null && k.length), props: { compareList: ((L = t.value) == null ? void 0 : L.taskOrderArtifactList) || [], typeTitle: "构件", showOrderNumber: true, showChange: true, showProductionQty: true, showHandleQty: true } }, { title: "# 构件点工（【智能线】“任务已下发”且“未生产完成”的构件）", anchorLabel: "构件点工(智能线)", props: { compareList: t.value.artifactList, typeTitle: "构件", showOrderNumber: true, showChange: true, showHandleQty: true } }, { title: "# 构件点工（生产完成）", anchorLabel: "构件点工(生产完成)", show: !!((S = (B = t.value) == null ? void 0 : B.taskOrderPointWorkArtifactList) != null && S.length), props: { compareList: ((T = t.value) == null ? void 0 : T.taskOrderPointWorkArtifactList) || [], typeTitle: "构件", showChange: true, showShippedQty: true, showHandleQty: true } }] }, { title: "部件", show: !!((O = (N = t.value) == null ? void 0 : N.assembleList) != null && O.length || (Q = (A = t.value) == null ? void 0 : A.taskOrderAssembleList) != null && Q.length || (P = (C = t.value) == null ? void 0 : C.taskOrderPointWorkAssembleList) != null && P.length), cons: [{ title: "# 部件排产变更（“未套料”且“未下发”的部件）", anchorLabel: "部件排产变更", show: !!((H = (x = t.value) == null ? void 0 : x.assembleList) != null && H.length), props: { compareList: t.value.assembleList, typeTitle: "部件", showStatus: true } }, { title: "# 部件任务变更（“未套料”且“未生产”的部件）", anchorLabel: "部件任务变更", show: !!((I = (E = t.value) == null ? void 0 : E.taskOrderAssembleList) != null && I.length), props: { compareList: t.value.taskOrderAssembleList, typeTitle: "部件", showHandleQty: true } }, { title: "# 部件点工 (“混套”、“生产中”、“生产完成”的部件)", anchorLabel: "部件点工", show: !!((q = (W = t.value) == null ? void 0 : W.taskOrderPointWorkAssembleList) != null && q.length), props: { compareList: t.value.taskOrderPointWorkAssembleList, typeTitle: "部件", showHandleType: true, showHandleQty: true } }] }, { title: "零件", show: !!((V = (D = t.value) == null ? void 0 : D.machinePartList) != null && V.length), cons: [{ title: "# 零件排产变更（“未套料”且 “未下发”的零件）", anchorLabel: "零件排产变更", show: !!((j = ($ = t.value) == null ? void 0 : $.machinePartList) != null && j.length), props: { compareList: t.value.machinePartList, typeTitle: "零件", showStatus: true } }] }];
  });
  return Y(() => b, () => {
    Z(() => {
      var n;
      (n = l.value) == null || n.refreshAnchorList();
    });
  }, { deep: true, immediate: true }), (n, e) => {
    const h = ae, c = le;
    return a(), i("div", { class: "task-content", style: oe(f.heightStyle) }, [g("div", pe, [o(c, null, { default: s(() => [(a(true), i(w, null, M(b.value, (d, m) => (a(), i(w, { key: m }, [d.show ? (a(), i("div", he, [o(h, null, { default: s(() => [g("span", ce, R(d.title), 1)]), _: 2 }, 1024), (a(true), i(w, null, M(d.cons, (u, y) => (a(), i(w, { key: y }, [u.show ? (a(), i("div", ue, [g("div", { class: "task-title anchor-title", "data-anchor-label": u.anchorLabel }, [g("span", null, R(u.title), 1)], 8, de), o(ee(ie), te({ ref_for: true }, u.props), null, 16)])) : r("", true)], 64))), 128))])) : r("", true)], 64))), 128))]), _: 1 })]), o(c, { class: "right-con" }, { default: s(() => [o(re, { ref_key: "anchorNavRef", ref: l }, null, 512)]), _: 1 })], 4);
  };
} }, be = se(we, [["__scopeId", "data-v-d87ffa38"]]);
export {
  be as default
};
