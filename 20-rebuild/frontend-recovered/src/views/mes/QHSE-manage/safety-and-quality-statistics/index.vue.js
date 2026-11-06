import { ref as y } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as h } from "vue";
import { unref as a } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as o } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as A } from "vue";
import { withModifiers as U } from "vue";
import { ElTableColumn as V } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as B } from "../../../../modules/index-cfd8d896.js";
import { x as E, mZ as k, o as H, A as g, G as M, P as j } from "../../../../shared/runtime.js";
import I from "./module/header.vue.js";
import K from "./module/detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/index-d532b8ca.js";
const z = { class: "app-container" }, F = { class: "head-container" }, ae = { __name: "index", setup(G) {
  const S = { add: false, edit: false, del: false, download: false }, T = y(), b = y(false), v = y(), { crud: _, columns: s, CRUD: D } = E({ title: "安环统计", permission: { ...k }, invisibleColumns: [], optShow: { ...S }, crudApi: { ...B }, hasPagination: true }, T), O = y([["createTime", "parse-time"], ["rectifyTime", "parse-time"], ["forfeit", ["to-fixed-ck", "YUAN"]]]), { maxHeight: x } = H({ paginate: true });
  D.HOOK.handleRefresh = (w, m) => {
    m.data.content = m.data.content.map((e) => {
      var u, p, d, f;
      return e.qualityTypeListStr = e.qualityTypeList && e.qualityTypeList.join("、"), e.imgUrls = e.attachmentDTOS && e.attachmentDTOS.map((t) => t.imageUrl), e.qhseRectifyDTOS && e.qhseRectifyDTOS.length && (e.rectifyName = (u = e.qhseRectifyDTOS[0]) == null ? void 0 : u.name, e.rectifyTime = (p = e.qhseRectifyDTOS[0]) == null ? void 0 : p.createTime, e.rectifyAttachmentDTOS = (d = e.qhseRectifyDTOS[0]) == null ? void 0 : d.attachmentDTOS, e.rectifyImgUrls = e.rectifyAttachmentDTOS && e.rectifyAttachmentDTOS.map((t) => t.imageUrl), e.rectifyRemark = (f = e.qhseRectifyDTOS[0]) == null ? void 0 : f.remark), e;
    });
  };
  function q(w) {
    b.value = true, v.value = w;
  }
  return (w, m) => {
    const e = V, u = L, p = N("common-button"), d = N("common-table"), f = P;
    return l(), R("div", z, [n("div", F, [h(a(I))]), C((l(), o(d, { ref_key: "tableRef", ref: T, data: a(_).data, "empty-text": a(_).emptyText, "data-format": O.value, "max-height": a(x), "row-key": "rowId", style: { width: "100%" } }, { default: i(() => [h(e, { label: "序号", type: "index", align: "center", width: "60" }), a(s).visible("qhseNumber") ? (l(), o(e, { key: 0, "show-overflow-tooltip": true, align: "center", prop: "qhseNumber", label: "质检编号" }, { default: i(({ row: t }) => [n("span", null, c(t.qhseNumber), 1)]), _: 1 })) : r("", true), a(s).visible("userName") ? (l(), o(e, { key: 1, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "检查人" }, { default: i(({ row: t }) => [n("span", null, c(t.userName), 1)]), _: 1 })) : r("", true), a(s).visible("createTime") ? (l(), o(e, { key: 2, "show-overflow-tooltip": true, align: "center", prop: "createTime", label: "检查日期" }, { default: i(({ row: t }) => [n("span", null, c(t.createTime), 1)]), _: 1 })) : r("", true), a(s).visible("dutyName") ? (l(), o(e, { key: 3, "show-overflow-tooltip": true, align: "center", prop: "dutyName", label: "责任人" }, { default: i(({ row: t }) => [n("span", null, c(t.dutyName), 1)]), _: 1 })) : r("", true), a(s).visible("levelOneName") ? (l(), o(e, { key: 4, "show-overflow-tooltip": true, align: "center", prop: "levelOneName", label: "质量分类" }, { default: i(({ row: t }) => [n("span", null, c(t.levelOneName), 1)]), _: 1 })) : r("", true), a(s).visible("levelTwoName") ? (l(), o(e, { key: 5, "show-overflow-tooltip": true, align: "center", prop: "levelTwoName", label: "子类" }, { default: i(({ row: t }) => [n("span", null, c(t.levelTwoName), 1)]), _: 1 })) : r("", true), a(s).visible("behaviorScore") ? (l(), o(e, { key: 6, "show-overflow-tooltip": true, align: "center", prop: "behaviorScore", label: "扣分" }, { default: i(({ row: t }) => [n("span", null, c(t.behaviorScore), 1)]), _: 1 })) : r("", true), a(s).visible("penalty") ? (l(), o(e, { key: 7, "show-overflow-tooltip": true, align: "center", prop: "penalty", label: "处罚" }, { default: i(({ row: t }) => [n("span", null, c(t.penalty), 1)]), _: 1 })) : r("", true), a(s).visible("userName") ? (l(), o(e, { key: 8, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "状态" }, { default: i(({ row: { sourceRow: t } }) => [a(g).VK[t.status] ? (l(), o(u, { key: 0, type: a(g).V[t.status].T }, { default: i(() => [A(c(a(g).VL[t.status]), 1)]), _: 2 }, 1032, ["type"])) : r("", true)]), _: 1 })) : r("", true), a(s).visible("userName") ? (l(), o(e, { key: 9, "show-overflow-tooltip": true, align: "center", prop: "userName", label: "操作" }, { default: i(({ row: t }) => [a(M)(a(k).detail) ? (l(), o(p, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: U((Q) => q(t), ["stop"]) }, null, 8, ["onClick"])) : r("", true)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[f, a(_).loading]]), h(a(j)), h(a(K), { visible: b.value, "onUpdate:visible": m[0] || (m[0] = (t) => b.value = t), "detail-data": v.value }, null, 8, ["visible", "detail-data"])]);
  };
} };
export {
  ae as default
};
